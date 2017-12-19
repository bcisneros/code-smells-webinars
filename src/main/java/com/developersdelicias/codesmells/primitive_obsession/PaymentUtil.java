package com.developersdelicias.codesmells.primitive_obsession;

import java.math.BigDecimal;

public class PaymentUtil {

	public static BigDecimal getSafeAmount(Double amount) {
		return amount == null ? BigDecimal.ZERO : new BigDecimal(amount.toString());
	}
}
