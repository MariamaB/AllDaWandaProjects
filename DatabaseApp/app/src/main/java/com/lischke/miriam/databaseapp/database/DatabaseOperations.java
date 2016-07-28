package com.lischke.miriam.databaseapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.lischke.miriam.databaseapp.model.Images;
import com.lischke.miriam.databaseapp.model.Seller;
import com.lischke.miriam.databaseapp.model.Shop;

import java.sql.SQLException;

/**
 * Created by Miriam on 22.06.2016.
 */
public class DatabaseOperations extends OrmLiteSqliteOpenHelper{

    public static final String database_name = "trending_products.db";
    public static final int database_version = 2;

    private Dao<Product, Integer> productDao = null;
    private Dao<Seller, Integer> sellerDao = null;
    private Dao<Shop, Integer> shopDao = null;
    private Dao<Images, Integer> imgDao = null;

    public DatabaseOperations(Context context) {
        super(context, database_name, null, database_version);
        Log.d("Database Operations","Created Database");
    }


    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Product.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Seller.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Shop.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            TableUtils.createTable(connectionSource, Images.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Log.d("Database Operations","Created Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.d("Database Operations","Update Table");

            try {
                TableUtils.dropTable(connectionSource, Product.class, true);
                TableUtils.dropTable(connectionSource, Seller.class, true);
                TableUtils.dropTable(connectionSource, Shop.class, true);
                TableUtils.dropTable(connectionSource, Images.class, true);
                onCreate(db, connectionSource);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }




    public Dao<Product, Integer> getProductDao() throws SQLException {
        if (productDao == null) {
            productDao = getDao(Product.class);
        }

        return productDao;
    }

    public void productClose() {
        productDao = null;

        super.close();
    }




    public Dao<Seller, Integer> getSellerDao() throws SQLException {
        if (sellerDao == null) {
            sellerDao = getDao(Seller.class);
        }

        return sellerDao;
    }


    public void sellerClose() {
        sellerDao = null;

        super.close();
    }




    public Dao<Shop, Integer> getShopDao() throws SQLException {
        if (shopDao == null) {
            shopDao = getDao(Shop.class);
        }

        return shopDao;
    }


    public void shopClose() {
        shopDao = null;

        super.close();
    }





    public Dao<Images, Integer> getImagesDao() throws SQLException {
        if (imgDao == null) {
            imgDao = getDao(Images.class);
        }

        return imgDao;
    }


    public void imagesClose() {
        imgDao = null;

        super.close();
    }

}



