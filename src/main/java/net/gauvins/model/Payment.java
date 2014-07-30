package net.gauvins.model;

import java.math.BigDecimal;

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
