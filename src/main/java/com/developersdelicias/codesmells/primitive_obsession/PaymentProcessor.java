package com.developersdelicias.codesmells.primitive_obsession;

import java.math.BigDecimal;
import java.util.List;

public class PaymentProcessor {

	public void process(List<Payment> payments, Double totalAmount) throws PaymentException {

		BigDecimal amountToProcess = PaymentUtil.getSafeAmount(totalAmount);
		BigDecimal zeroAmount = new BigDecimal("0");

		if (amountToProcess.compareTo(zeroAmount) <= 0) {
			throw new PaymentException("Amount is zero or negative. Nothing to process.");
		}

		if (payments.isEmpty()) {
			throw new PaymentException("Payment list is empty. Nothing to process.");
		}

		for (Payment payment: payments) {
			BigDecimal amount = PaymentUtil.getSafeAmount(payment.amount());
			process(payment, amount);

			amountToProcess = amountToProcess.subtract(amount);

			if (amountToProcess.compareTo(zeroAmount) <= 0) {
				break;
			}
		}
	}

	void process(Payment payment, BigDecimal amount) {
		// Simulate individual payment is processed
	}
}
