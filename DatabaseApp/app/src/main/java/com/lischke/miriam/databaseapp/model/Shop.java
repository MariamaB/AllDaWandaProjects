package com.lischke.miriam.databaseapp.model;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by Miriam on 27.06.2016.
 */
@DatabaseTable(tableName = Shop.table_name_shops, daoClass = BaseDaoImpl.class)
public class Shop {

    public static final String table_name_shops = "shops";
    public static final String sh_id = "sh_id";
    public static final String shop_id = "shop_id";
    public static final String shop_subdomain = "shop_subdomain";
    public static final String shop_holiday_from = "shop_holiday_from";
    public static final String shop_holiday_to = "shop_holiday_to";
    public static final String shop_title = "shop_title";
    public static final String shop_auto_confirm = "shop_auto_confirm";

    @DatabaseField(columnName = sh_id, generatedId = true)
    private int id;

    @DatabaseField(columnName = shop_id)
    private String shopId;

    @DatabaseField(columnName = shop_subdomain)
    private String subdomain;

    @DatabaseField(columnName = shop_holiday_from)
    private String holidayFrom;

    @DatabaseField(columnName = shop_holiday_to)
    private String holidayTo;

    @DatabaseField(columnName = shop_title)
    private String title;

    @DatabaseField(columnName = shop_auto_confirm)
    private String autoConfirm;

    //CONSTRUCTOR
    public Shop() {
    }

    // GETTER
    public int getId() {
        return id;
    }

    public String getShopId() {
        return shopId;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public String getHolidayFrom() {
        return holidayFrom;
    }

    public static String getShop_holiday_to() {
        return shop_holiday_to;
    }

    public String getTitle() {
        return title;
    }

    public String getAutoConfirm() {
        return autoConfirm;
    }

    //SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public void setHolidayFrom(String holidayFrom) {
        this.holidayFrom = holidayFrom;
    }

    public void setHolidayTo(String holidayTo) {
        this.holidayTo = holidayTo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAutoConfirm(String autoConfirm) {
        this.autoConfirm = autoConfirm;
    }
}
