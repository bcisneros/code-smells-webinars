package com.developersdelicias.codesmells.primitive_obsession;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class PaymentProcessorTest {

	private static final List<Payment> UNUSED_PAYMENT_LIST = null;
	private static final double ZERO_TOTAL_AMOUNT = 0.0d;
	private static final double NEGATIVE_TOTAL_AMOUNT = -1.0d;
	private static final Double NULL_TOTAL_AMOUNT = null;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private PaymentProcessor processor = Mockito.spy(new PaymentProcessor());

	@Test
	@Parameters(method = "invalidTotalAmounts")
	public void throws_payment_exception_when_payment_is_zero(Double invalidAmount) throws PaymentException {
		expectPaymentExceptionWithMessage("Amount is zero or negative. Nothing to process.");

		processor.process(UNUSED_PAYMENT_LIST, invalidAmount);
	}

	@Test
	public void throws_paymentException_when_payment_list_is_empty() throws PaymentException {
		expectPaymentExceptionWithMessage("Payment list is empty. Nothing to process.");

		processor.process(Collections.<Payment>emptyList(), 120.05d);
	}

	@Test
	public void can_process_all_payments_correctly() throws PaymentException {
		Payment creditCardPayment = Payment.of(150.0d, "Credit Card");
		Payment couponPayment = Payment.of(75.0d, "Coupon");
		Payment cashPayment = Payment.of(25.0d, "Cash");

		List<Payment> payments = asList(
				creditCardPayment,
				couponPayment,
				cashPayment
		);

		processor.process(payments, 250.0d);

		Mockito.verify(processor).process(creditCardPayment, BigDecimal.valueOf(150.0d));
		Mockito.verify(processor).process(couponPayment, BigDecimal.valueOf(75.0d));
		Mockito.verify(processor).process(cashPayment, BigDecimal.valueOf(25.0d));
	}

	@SuppressWarnings("unused")
	private Collection<Double> invalidTotalAmounts() {
		return asList(ZERO_TOTAL_AMOUNT, NEGATIVE_TOTAL_AMOUNT, NULL_TOTAL_AMOUNT);
	}

	private void expectPaymentExceptionWithMessage(String message) {
		thrown.expect(PaymentException.class);
		thrown.expectMessage(is(message));
	}
}