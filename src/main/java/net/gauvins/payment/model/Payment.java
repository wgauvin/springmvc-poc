package net.gauvins.payment.model;

import java.math.BigDecimal;

import net.gauvins.model.CreditCard;

public class Payment {

  private BigDecimal amount;
  private CreditCard creditCard;

  public CreditCard getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(final CreditCard creditCard) {
    this.creditCard = creditCard;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(final BigDecimal amount) {
    this.amount = amount;
  }

}
