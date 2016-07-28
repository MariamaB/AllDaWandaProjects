package com.lischke.miriam.databaseapp.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by Miriam on 27.06.2016.
 */
@DatabaseTable(tableName = Seller.table_name_Sellers,daoClass = BaseDaoImpl.class)
public class Seller {


    public static final String table_name_Sellers = "sellers";
    public static final String s_id = "s_id";
    public static final String seller_id = "seller_id";
    public static final String seller_username = "seller_username";
    public static final String seller_country = "seller_country";
    public static final String seller_platform = "seller_platform";
    public static final String seller_rating = "seller_rating";
    public static final String seller_image_base_url = "seller_image_base_url";

    @DatabaseField(columnName = s_id, generatedId = true)
    private int id;

    @DatabaseField(columnName = seller_id)
    @SerializedName("id")
    private String sellerId;

    @DatabaseField(columnName = seller_username)
    private String username;

    @DatabaseField(columnName = seller_country)
    private String country;

    @DatabaseField(columnName = seller_platform)
    private String platform;

    @DatabaseField(columnName = seller_rating)
    private String rating;

    @DatabaseField(columnName = seller_image_base_url)
    private String imageBaseUrl;

    public Seller() {
    }


//    public Seller( Seller s) {
//
//        this.sellerId = s.getSeller_id();
//        this.username =s.getUsername();
//        this.country = s.getCountry();
//
//    }

    public int getId() {
        return id;
    }

    public String getSeller_id() {
        return sellerId;
    }

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public String getPlatform() {
        return platform;
    }

    public String getRating() {
        return rating;
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }




    public void setId(int id) {
        this.id = id;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setImageBaseUrl(String imageBaseUrl) {
        this.imageBaseUrl = imageBaseUrl;
    }
}
