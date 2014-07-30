package net.gauvins.model;

public class CreditCard {

  private String cardHolder;
  private String cardNumber;
  private String expiryMonth;
  private String expiryYear;
  private String securityCode;

  public String getCardHolder() {
    return cardHolder;
  }

  public void setCardHolder(final String cardHolder) {
    this.cardHolder = cardHolder;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(final String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getExpiryMonth() {
    return expiryMonth;
  }

  public void setExpiryMonth(final String expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  public String getExpiryYear() {
    return expiryYear;
  }

  public void setExpiryYear(final String expiryYear) {
    this.expiryYear = expiryYear;
  }

  public String getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(final String securityCode) {
    this.securityCode = securityCode;
  }

}
