package net.gauvins.payment.service;

import net.gauvins.payment.model.Payment;

public interface PaymentService {

  void processPayment(Payment payment);

}
