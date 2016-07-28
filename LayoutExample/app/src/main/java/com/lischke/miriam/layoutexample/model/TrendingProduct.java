package com.lischke.miriam.layoutexample.model;

/**
 * Created by Miriam on 27.05.2016.
 */
public final class TrendingProduct {

    private int id;
    private String slug;
    private String title;

    private Price price;
    private Images default_image;

    public void trendingProduct(int pId, String pSlug, String pTitle, Price pPrice, Images pImages){

        id = pId;
        slug = pSlug;
        title = pTitle;
        price = pPrice;
        default_image = pImages;

    }

    public int getId(){
        return id;
    }

    public String getSlug(){
        return slug;
    }

    public String getTitle(){
        return title;
    }

    public Price getPrice(){
        return price;
    }

    public Images getDefault_image(){
        return default_image;
    }

    public String toStringId(){
        return "ProductId: "+id;
    }

public String toString(){
    return "TrendingProduct contains id: " + id + ", slug: " + slug + " , title: " + title+", price: "+price+", default_image: "+default_image;
}

}
