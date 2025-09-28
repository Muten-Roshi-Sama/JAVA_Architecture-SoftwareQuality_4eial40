// Account.java

package be.ecam.basics.exercises;

import java.util.Objects;
import java.math.BigDecimal;

//--------BigDecimal-----

//   .ZERO             :  The value 0, with a scale of 0.
//  .valueOf(long val) : Translates a long value into a BigDecimal with a scale of zero.
//  .valueOf(long unscaledVal, int scale): Translates a long unscaled value and an int scale into a BigDecimal.
//
//  .add()
//  .subtract()
//  .compareTo()

public class Account {
    private BigDecimal balance;

    public Account() {
        this(BigDecimal.ZERO);
    }

    public Account(double initial) {
        this(BigDecimal.valueOf(initial));
    }

    private Account(BigDecimal initial) {
        this.balance = initial.setScale(2, BigDecimal.ROUND_UNNECESSARY);
    }

    public double getBalance() {
        return balance.doubleValue();
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount");
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount");
        BigDecimal amt = BigDecimal.valueOf(amount);
        if (amt.compareTo(balance) > 0) throw new IllegalStateException("insufficient");
        balance = balance.subtract(amt);
    }

    public void transferTo(Account other, double amount) {
        Objects.requireNonNull(other, "other");
        withdraw(amount);
        other.deposit(amount);
    }
}