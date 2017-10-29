package com.developersdelicias.codesmells.comments.bad;

import com.developersdelicias.codesmells.comments.CreditCard;
import com.developersdelicias.codesmells.comments.ExpiredCardException;

public class RedundantComment {


    // Validate that a credit card is not expired, if is expired throws an ExpiredCardException
    public void validate(CreditCard creditCard) {
        if (creditCard.isExpired()) {
            throw new ExpiredCardException();
        }
    }

    /**
     * The name of the process
     */
    private String processName;
}
