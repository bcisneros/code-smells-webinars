package com.developersdelicias.codesmells.comments.bad;

import com.developersdelicias.codesmells.comments.CreditCard;

import java.util.List;

public class ClosingBraceComments {


    public void action(List<CreditCard> creditCardList) {
        for (CreditCard c: creditCardList) {

            while(true) {

                if (c.isExpired()) {

                } // end if is expired


            } // end while

        }// end for
    } // end action
}
