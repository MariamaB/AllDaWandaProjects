package com.lischke.miriam.giftfinder.model;

/**
 * Created by Miriam on 27.05.2016.
 */
public class Images {

    private  String big;
    private  String thumb;
    private  String full;


    public void Images(String big, String pThumb, String pfull){

        this.big = big;
        thumb = pThumb;
        full = pfull;
    }

    public String getBig(){
        return big;
    }

    public String getThumb(){
        return thumb;
    }

    public String getFull(){
        return full;
    }

    public String toString(){
        return "big: "+big+", thumb: "+thumb+", full: "+full;
    }


}
