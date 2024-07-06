import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class TestClass {

    interface VelocityProvider {

        /**
         * This method is called during the payment risk assessment.
         * <p>
         * It returns how many times the card in the Payment has been seen in the last minutes/seconds/hours as
         * defined in the {@code duration} parameter at the time the payment is being processed.
         *
         * @param payment  The payment being processed
         * @param duration The interval to count
         * @return The number of times the card was used in the interval defined in duration.
         */
        int getCardUsageCount(Payment payment, Duration duration);


        /**
         * After the payment is processed this method is called.
         *
         * @param payment The payment that has been processed.
         */
        void registerPayment(Payment payment);

        /**
         * @return Instance of a Velocity provider
         */
        static VelocityProvider getProvider() {
            return new VelocityProviderImpl();
        }
    }

    static class Payment {
        private final String paymentId;
        private final Instant timestamp;
        private final String hashedCardNumber;

        public Payment(String paymentId, Instant timestamp, String hashedCardNumber) {
            this.paymentId = paymentId;
            this.timestamp = timestamp;
            this.hashedCardNumber = hashedCardNumber;
        }

        public String getPaymentId() {
            return paymentId;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public String getHashedCardNumber() {
            return hashedCardNumber;
        }
    }


    public static class VelocityProviderImpl implements VelocityProvider {

        Map<String, List<Payment>> paymentsPerCardMap = new HashMap();

        @Override
        public int getCardUsageCount(Payment payment, Duration duration) {
            List<Payment> payments = getPaymentListPerCard(payment.getHashedCardNumber());
            Instant latestInstant = payment.getTimestamp();
            java.util.concurrent.atomic.AtomicInteger counter = new java.util.concurrent.atomic.AtomicInteger(0);
            Instant timeLimit = latestInstant.minus(duration);
            payments
                    .parallelStream()
                    .filter(oldPayment -> !oldPayment.getTimestamp().isBefore(timeLimit))
                    .forEach(v -> counter.incrementAndGet());
            return counter.get();
        }

        private List<Payment> getPaymentListPerCard(String hashedCardNumber) {
            List<Payment> payments = paymentsPerCardMap.get(hashedCardNumber);
            if (payments == null) {
                payments = new ArrayList<>();
                paymentsPerCardMap.put(hashedCardNumber, payments);
            }
            return payments;
        }

        //it should implement registerPayment
        @Override
        public void registerPayment(Payment payment) {
            List<Payment> payments = getPaymentListPerCard(payment.getHashedCardNumber());
            payments.add(payment);
        }
    }

    public long getMiliFromString(String datetime) {
        return LocalDateTime
                .parse(datetime, java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }

    @Test
    public void paymentVelocity() {

        VelocityProvider velocityProvider = VelocityProvider.getProvider();

        velocityProvider.registerPayment(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123600000")), "c1"));
        velocityProvider.registerPayment(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123620000")), "c1"));
        velocityProvider.registerPayment(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123621000")), "c2"));
        velocityProvider.registerPayment(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123630000")), "c1"));
        velocityProvider.registerPayment(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123645000")), "c2"));


        int counter1 = velocityProvider.getCardUsageCount(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123660000")), "c1"), Duration.ofSeconds(60));
        int counter2 = velocityProvider.getCardUsageCount(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123660000")), "c1"), Duration.ofSeconds(35));
        int counter3 = velocityProvider.getCardUsageCount(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123660000")), "c1"), Duration.ofSeconds(15));
        int counter4 = velocityProvider.getCardUsageCount(new Payment(UUID.randomUUID().toString(), Instant.ofEpochMilli(Long.parseLong("1662123660000")), "c3"), Duration.ofSeconds(75));

        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println(counter3);
        System.out.println(counter4);

    }
}
