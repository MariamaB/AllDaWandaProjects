package com.lischke.miriam.giftfinder.model;

/**
 * Created by Miriam on 27.05.2016.
 */
public class Price {

    private String currency;
    private int cents;


    public void Price(int pCents, String pCurrency){

        cents = pCents;
        currency = pCurrency;
    }


    public String toString(){
        return currency+" "+cents;
    }
}
