package com.lischke.miriam.databaseapp.database;

import android.provider.BaseColumns;

/**
 * Created by Miriam on 22.06.2016.
 */
public class TableData {

   public TableData(){

    }


    public static abstract class TableInfo implements BaseColumns{



        public static final String table_products = "products";
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
        public static final String product_default_image = "product_default_image";
        public static final String product_pinned = "product_pinned";
        public static final String product_customizable = "product_customizable";
        public static final String product_campaigned = "product_campaigned";


        public static final String table_seller = "sellers";
        public static final String s_id = "s_id";
        public static final String seller_id = "seller_id";
        public static final String seller_username = "seller_username";
        public static final String seller_country = "seller_country";
        public static final String seller_platform = "seller_platform";
        public static final String seller_rating = "seller_rating";
        public static final String seller_image_base_url = "seller_image_base_url";


        public static final String table_shop = "table_shop";
        public static final String sh_id = "sh_id";
        public static final String shop_id = "shop_id";
        public static final String shop_subdomain = "shop_subdomain";
        public static final String shop_holiday_from = "shop_holiday_from";
        public static final String shop_holiday_to = "shop_holiday_to";
        public static final String shop_title = "shop_title";
        public static final String shop_auto_confirm = "shop_auto_confirm";


        public static final String table_default_image = "table_default_image";
        public static final String img_id = "img_id";
        public static final String image_product_id = "product_id";
        public static final String image_big = "image_big";
        public static final String image_thumb = "image_thumb";
//      public static final String image_long = "image_long";
        public static final String image_product_l = "image_product_l";
        public static final String image_full = "image_full";
        public static final String image_listview  = "image_listview";
        public static final String image_listview_xs = "image_listview_xs";
        public static final String image_listview_s = "image_listview_a";
        public static final String image_listview_m = "image_listview_m";
        public static final String image_listview_l = "image_listview_l";
        public static final String image_pin = "image_pin";


    }




}
