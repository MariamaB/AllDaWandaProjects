package com.lischke.miriam.databaseapp.model;

/**
 * Created by Miriam on 27.05.2016.
 */
public final class TrendingProduct {

    private String id;
    private String category_id;
    private String slug;
    private String milli_units_per_item;
    private String unit;
    private String title;
    private Price price;
    private Price undiscounted_price;
    private Price base_price;
    private String badge;
    private String sale_percentage;
    private String discounted;
    private String sold_in_unit;
    private Seller seller;
    private Shop shop;
    private Images default_image;
    private String pinned;
    private String customizable;
    private String campaigned;

    public void trendingProduct(String pId, String pCategory_id, String pSlug, String pMilli_units_per_item, String pUnit, String pTitle, Price pPrice, Price pUndiscounted_price, Price pBase_price, String pBadge, String pSale_percentage, String pDiscounted,
                                String pSold_in_unit, Seller pSeller, Shop pShop, Images pImages, String pPinned, String pCustomizable, String pCampaigned){

        id = pId;
        category_id = pCategory_id;
        slug = pSlug;
        milli_units_per_item = pMilli_units_per_item;
        unit = pUnit;
        title = pTitle;
        price = pPrice;
        undiscounted_price = pUndiscounted_price;
        base_price = pBase_price;
        badge = pBadge;
        sale_percentage = pSale_percentage;
        discounted = pDiscounted;
        sold_in_unit = pSold_in_unit;
        seller = pSeller;
        shop = pShop;
        default_image = pImages;
        pinned = pPinned;
        customizable = pCustomizable;
        campaigned = pCampaigned;

    }

    public String getId(){
        return id;
    }

    public String getCategory_id() {
        return category_id;
    }
    public String getSlug(){
        return slug;
    }

    public String getMilli_units_per_item() {
        return milli_units_per_item;
    }

    public String getUnit() {
        return unit;
    }

    public String getTitle(){
        return title;
    }

    public Price getPrice(){
        return price;
    }

    public Price getUndiscounted_price() {
        return undiscounted_price;
    }

    public Price getBase_price() {
        return base_price;
    }

    public String getBadge() {
        return badge;
    }

    public String getSale_percentage() {
        return sale_percentage;
    }

    public String getDiscounted() {
        return discounted;
    }

    public String getSold_in_unit() {
        return sold_in_unit;
    }

    public Seller getSeller() {
        return seller;
    }


    public Shop getShop() {
        return shop;
    }

    public Images getDefault_image(){
        return default_image;
    }

    public String getPinned() {
        return pinned;
    }

    public String getCustomizable() {
        return customizable;
    }

    public String getCampaigned() {
        return campaigned;
    }


    //    public String toStringId(){
//        return ""+id;
//    }

//public String toString(){
//    return "TrendingProduct contains id: " + id + ", slug: " + slug + " , title: " + title+", price: "+price+", default_image: "+default_image;
//}

}
