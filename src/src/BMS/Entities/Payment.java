package BMS.Entities;

public class Payment {
    int paymentId;
//    int customerId;
    int cost;
    public Payment(int paymentId, int cost) {
        this.paymentId = paymentId;
//        this.customerId = customerId;
        this.cost = cost;
    }

    public int getPaymentId() {
        return paymentId;
    }
    public int getCost() {
        return cost;
    }
}
