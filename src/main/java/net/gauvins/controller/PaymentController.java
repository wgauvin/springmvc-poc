package net.gauvins.controller;

import java.util.ArrayList;
import java.util.List;

import net.gauvins.model.Payment;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controls payments
 * @author will
 *
 */
@Controller
public class PaymentController {

  @Autowired
  private NonceHandler nonceHandler;

  @ModelAttribute("payment")
  public Payment getPayment() {
    return new Payment();
  }

  @ModelAttribute("validExpiryMonths")
  public List<String> getValidExpiryMonths() {
    final List<String> values = new ArrayList<>();
    for (int i = 1; i <= 12; i++) {
      values.add(String.format("%02d", i));
    }
    return values;
  }

  @ModelAttribute("validExpiryYears")
  public List<String> getValidExpiryYears() {
    final List<String> values = new ArrayList<>();
    final int currYear = new LocalDate().getYear();
    for (int i = currYear; i <= currYear + 5; i++) {
      values.add(String.format("%04d", i));
    }
    return values;
  }

  @ModelAttribute("nonce")
  public String getNonce() {
    return nonceHandler.getNonce();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/payment.do")
  public String get() {
    return ".payment";
  }

}
