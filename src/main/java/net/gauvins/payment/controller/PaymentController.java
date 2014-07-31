package net.gauvins.payment.controller;

import java.util.ArrayList;
import java.util.List;

import net.gauvins.controller.NonceHandler;
import net.gauvins.payment.model.Payment;
import net.gauvins.payment.service.PaymentService;

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

  private final NonceHandler nonceHandler;
  private final PaymentService paymentService;

  @Autowired
  public PaymentController(final PaymentService paymentService, final NonceHandler nonceHandler) {
    this.paymentService = paymentService;
    this.nonceHandler = nonceHandler;
  }

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

  @RequestMapping(method = RequestMethod.GET, value = "/payment")
  public String get() {
    return ".payment";
  }

  @RequestMapping(method = RequestMethod.POST, value = "/payment")
  public String post(final Payment payment) {
    paymentService.processPayment(payment);
    return ".paymentsuccess";
  }

}
