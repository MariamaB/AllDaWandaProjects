package com.lischke.miriam.databaseapp.model;

/**
 * Created by Miriam on 27.05.2016.
 */
public class Price {

    private String currency;
    private int cents;
    private String symbol;



    public void Price(int pCents, String pCurrency, String psymbol){

        cents = pCents;
        currency = pCurrency;
        symbol = psymbol;
    }

    public String getCurrency(){
        return currency;
    }


    public String getPrice(){
        return ""+cents+" "+symbol;
    }
}
