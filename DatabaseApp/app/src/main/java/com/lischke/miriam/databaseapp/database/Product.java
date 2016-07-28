package com.lischke.miriam.databaseapp.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lischke.miriam.databaseapp.model.TrendingProduct;

/**
 * Created by Miriam on 04.07.2016.
 */
@DatabaseTable(tableName = Product.table_name_products, daoClass = BaseDaoImpl.class)
public class Product {

    public static final String table_name_products = "products";

    public static final String p_id = "p_id";
    public static final String product_id = "product_id";
    public static final String product_catagory_id = "product_catagory_id";
    public static final String product_slug= "product_slug";
    public static final String product_milli_units_per_item = "product_milli_units_per_item";
    public static final String product_unit = "product_unit";
    public static final String product_title = "product_title";
    public static final String product_price = "product_price";
    public static final String product_undiscounted_price = "product_undiscounted_price";
    public static final String product_base_price = "product_base_price";
    public static final String product_currency = "product_currency";
    public static final String product_badge = "product_badge";
    public static final String product_sale_percentage = "product_sale_percentage";
    public static final String product_discounted = "product_discounted";
    public static final String product_sold_in_unit = "product_sold_in_unit";
    public static final String product_seller = "product_seller";
    public static final String product_shop = "product_shop";
//    public static final String product_default_image = "product_default_image";
    public static final String product_pinned = "product_pinned";
    public static final String product_customizable = "product_customizable";
    public static final String product_campaigned = "product_campaigned";



    @DatabaseField(columnName = p_id, generatedId = true)
    private int id;

    @DatabaseField(columnName = product_id)
    private String productId;

    @DatabaseField(columnName = product_catagory_id)
    private String catagoryId;

    @DatabaseField(columnName = product_slug)
    private String slug;

    @DatabaseField(columnName = product_milli_units_per_item)
    private String MilliUnitsPerItem;

    @DatabaseField(columnName = product_unit)
    private String unit;

    @DatabaseField(columnName = product_title)
    private String title;

    @DatabaseField(columnName = product_price)
    private String price;

    @DatabaseField(columnName = product_undiscounted_price)
    private String undiscountedPrice;

    @DatabaseField(columnName = product_base_price)
    private String basePrice;

    @DatabaseField(columnName = product_currency)
    private String currency;

    @DatabaseField(columnName = product_badge)
    private String badge;

    @DatabaseField(columnName = product_sale_percentage)
    private String salePercentage;

    @DatabaseField(columnName = product_discounted)
    private String discounted;

    @DatabaseField(columnName = product_sold_in_unit)
    private String soldInUnit;

    @DatabaseField(columnName = product_seller)
    private String seller;

    @DatabaseField(columnName = product_shop)
    private String shop;

//    @DatabaseField(columnName = product_default_image)
//    private String defaultImage;

    @DatabaseField(columnName = product_pinned)
    private String pinned;

    @DatabaseField(columnName = product_customizable)
    private String customizable;

    @DatabaseField(columnName = product_campaigned)
    private String campaigned;


    public Product(){

    }


    public Product(TrendingProduct p){
        this.productId = p.getId();
        this.catagoryId = p.getCategory_id();
        this.slug = p.getSlug();
        this.MilliUnitsPerItem = p.getMilli_units_per_item();
        this.unit = p.getUnit();
        this.title = p.getTitle();
        this.price = p.getPrice().getPrice();
        this.undiscountedPrice = p.getUndiscounted_price().getPrice();
        this.basePrice = p.getBase_price().getPrice();
        this.currency = p.getPrice().getCurrency();
        this.badge = p.getBadge();
        this.salePercentage = p.getSale_percentage();
        this.discounted = p.getDiscounted();
        this.soldInUnit = p.getSold_in_unit();
        this.seller = p.getSeller().getSeller_id();
        this.shop = p.getShop().getShopId();
        this.pinned = p.getPinned();
        this.customizable = p.getCustomizable();
        this.campaigned = p.getCampaigned();

    }

    //GETTER
    public int getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getCatagoryId() {
        return catagoryId;
    }

    public String getSlug() {
        return slug;
    }

    public String getMilliUnitsPerItem() {
        return MilliUnitsPerItem;
    }

    public String getUnit() {
        return unit;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getUndiscountedPrice() {
        return undiscountedPrice;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public String getCurrency() {
        return currency;
    }

    public static String getProduct_badge() {
        return product_badge;
    }

    public String getSalePercentage() {
        return salePercentage;
    }

    public String getDiscounted() {
        return discounted;
    }

    public String getSoldInUnit() {
        return soldInUnit;
    }

    public String getSeller() {
        return seller;
    }

    public String getShop() {
        return shop;
    }

//    public String getDefaultImage() {
//        return defaultImage;
//    }

    public String getPinned() {
        return pinned;
    }

    public String getCustomizable() {
        return customizable;
    }

    public String getCampaigned() {
        return campaigned;
    }


        //SETTER
    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setMilliUnitsPerItem(String milliUnitsPerItem) {
        MilliUnitsPerItem = milliUnitsPerItem;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUndiscountedPrice(String undiscountedPrice) {
        this.undiscountedPrice = undiscountedPrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public void setSalePercentage(String salePercentage) {
        this.salePercentage = salePercentage;
    }

    public void setDiscounted(String discounted) {
        this.discounted = discounted;
    }

    public void setSoldInUnit(String soldInUnit) {
        soldInUnit = soldInUnit;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

//    public void setDefaultImage(String defaultImage) {
//        this.defaultImage = defaultImage;
//    }

    public void setPinned(String pinned) {
        this.pinned = pinned;
    }

    public void setCustomizable(String customizable) {
        this.customizable = customizable;
    }

    public void setCampaigned(String campaigned) {
        this.campaigned = campaigned;
    }
}
