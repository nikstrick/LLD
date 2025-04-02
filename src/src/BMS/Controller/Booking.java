package BMS.Controller;

import BMS.Entities.Payment;

public class Booking {
    private int id;
    private Payment payment;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
