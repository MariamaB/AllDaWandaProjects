package com.lischke.miriam.databaseapp.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Miriam on 27.05.2016.
 */
@DatabaseTable(tableName = Images.table_name_default_images, daoClass = BaseDaoImpl.class)

public class Images {

    public static final String table_name_default_images = "default_images";
    public static final String img_id = "img_id";
    public static final String image_product_id = "product_id";
    public static final String image_big = "image_big";
    public static final String image_thumb = "image_thumb";
    //      public static final String image_long = "image_long";
    public static final String image_product_l = "image_product_l";
    public static final String image_full = "image_full";
    public static final String image_listview  = "image_listview";
    public static final String image_listview_xs = "image_listview_xs";
    public static final String image_listview_s = "image_listview_s";
    public static final String image_listview_m = "image_listview_m";
    public static final String image_listview_l = "image_listview_l";
    public static final String image_pin = "image_pin";

    @DatabaseField(columnName = img_id, generatedId = true)
    private int id;

    @DatabaseField(columnName = image_product_id)
    private String productId;

    @DatabaseField(columnName = image_big)
    private String big;

    @DatabaseField(columnName = image_thumb)
    private String thumb;

    @DatabaseField(columnName = image_product_l)
    private String productL;

    @DatabaseField(columnName = image_full)
    private String full;

    @DatabaseField(columnName = image_listview)
    private String listview;

    @DatabaseField(columnName = image_listview_xs)
    private String listviewXs;

    @DatabaseField(columnName = image_listview_s)
    private String listviewS;

    @DatabaseField(columnName = image_listview_m)
    private String listviewM;

    @DatabaseField(columnName = image_listview_l)
    private String listviewL;

    @DatabaseField(columnName = image_pin)
    private String pin;


    //COSTRUCTOR
    public Images() {
    }



    //GETTER


    public int getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getBig() {
        return big;
    }

    public String getThumb() {
        return thumb;
    }

    public static String getImage_product_l() {
        return image_product_l;
    }

    public String getFull() {
        return full;
    }

    public String getListview() {
        return listview;
    }

    public static String getImage_listview_xs() {
        return image_listview_xs;
    }

    public String getListviewS() {
        return listviewS;
    }

    public String getListviewM() {
        return listviewM;
    }

    public String getListviewL() {
        return listviewL;
    }

    public String getPin() {
        return pin;
    }




    //SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setProductL(String productL) {
        this.productL = productL;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public void setListview(String listview) {
        this.listview = listview;
    }

    public void setListviewXs(String listviewXs) {
        this.listviewXs = listviewXs;
    }

    public void setListviewS(String listviewS) {
        this.listviewS = listviewS;
    }

    public void setListviewM(String listviewM) {
        this.listviewM = listviewM;
    }

    public void setListviewL(String listviewL) {
        this.listviewL = listviewL;
    }
}
