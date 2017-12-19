package com.developersdelicias.codesmells.primitive_obsession;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PaymentUtilTest {

	@Test
	public void getSafeAmount_nullAmount_returnsZero() {
		assertThat(
				PaymentUtil.getSafeAmount(null),
				is(BigDecimal.ZERO)
		);
	}

	@Test
	@Parameters(method = "validAmounts")
	public void getSafeAmount_notNullAmount_returnsAnAmountWithPassedValue(Double amount, String amountString) {
		assertThat(
				PaymentUtil.getSafeAmount(amount),
				is(new BigDecimal(amountString))
		);
	}

	@SuppressWarnings("unused")
	private Object[] validAmounts() {
		return new Object[]{
				new Object[]{145.03d, "145.03"},
				new Object[]{1.0002d, "1.0002"},
				new Object[]{new Double("156.36"), "156.36"},
				new Object[]{0d, "0.0"},
				new Object[]{1d, "1.0"},
				new Object[]{.05d, "0.05"},
		};
	}
}