package org.example.payment;

public class WalletPayment implements PaymentStrategy {
    private String walletId;

    public WalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void pay(double amount) {
        // TODO: Implement payment logic
    }
}
