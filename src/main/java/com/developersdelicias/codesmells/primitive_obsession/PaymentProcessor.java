package com.developersdelicias.codesmells.primitive_obsession;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

class PaymentProcessor {

	void process(List<Payment> payments, Double totalAmount) throws PaymentException {

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

			process(payment, amount.compareTo(amountToProcess) > 0 ? amountToProcess : amount);

			amountToProcess = amountToProcess.subtract(amount);

			if (amountToProcess.compareTo(zeroAmount) <= 0) {
				break;
			}
		}

		if (amountToProcess.compareTo(zeroAmount) > 0) {
			throw new PaymentException(String.format("There is a remaining of $%s to be covered",
					new DecimalFormat("0.00").format(amountToProcess.doubleValue())
			));
		}
	}

	void process(Payment payment, BigDecimal amount) {
		// Simulate individual payment is processed
	}
}
