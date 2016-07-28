package com.lischke.miriam.databaseapp.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.lischke.miriam.databaseapp.R;
import com.lischke.miriam.databaseapp.database.DatabaseOperations;
import com.lischke.miriam.databaseapp.database.Product;
import com.lischke.miriam.databaseapp.model.Images;
import com.lischke.miriam.databaseapp.model.Seller;
import com.lischke.miriam.databaseapp.model.Shop;
import com.lischke.miriam.databaseapp.model.TrendingProduct;

import java.sql.SQLException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class DatabaseActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {


    List<TrendingProduct> responsebody;
    private Toolbar myToolbar;
    private FragmentDrawer drawerFragment;

    public interface DawandaService {

        @GET("/core/mobile/trending_products")
        Call<List<TrendingProduct>> getDummieContent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), myToolbar);
        drawerFragment.setDrawerListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://de.dawanda.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DawandaService service = retrofit.create(DawandaService.class);
        Call<List<TrendingProduct>> aufruf = service.getDummieContent();


        aufruf.enqueue(new retrofit2.Callback<List<TrendingProduct>>() {

            @Override
            public void onResponse(Call<List<TrendingProduct>> call, Response<List<TrendingProduct>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    insertData(response);

                }else{
                    Toast.makeText(DatabaseActivity.this,"Fehler!!",Toast.LENGTH_LONG).show();
                    Log.d("Request: ", "Fehler!!!");
                }
            }

            @Override
            public void onFailure(Call<List<TrendingProduct>> call, Throwable t) {
               Log.d("Request: ","Failurrrrree!!!: " + t);
            }


        });

//        finish(); STOPS THE ACTIVITY!!!
    }

    private void insertData(Response<List<TrendingProduct>> response) {

        responsebody = response.body();
        TrendingProduct p;
        Seller seller;
        Images img;
        Shop shop;
        Product product;
//        context.deleteDatabase("Trending Products");


        DatabaseOperations db = new DatabaseOperations(this);
        Dao<Product, Integer> productDao = null;
        Dao<Seller, Integer> sellerDao = null;
        Dao<Shop, Integer> shopDao = null;
        Dao<Images, Integer> imagesDao = null;

        try {
            productDao = db.getProductDao();
            sellerDao = db.getSellerDao();
            shopDao = db.getShopDao();
            imagesDao = db.getImagesDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < responsebody.size(); i++) {
            p = responsebody.get(i);
            seller = p.getSeller();
            shop = p.getShop();
            img = p.getDefault_image();


            product = new Product(p);

            try {
                productDao.create(product);
                sellerDao.create(seller);
                shopDao.create(shop);
                imagesDao.create(img);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        Toast.makeText(getBaseContext(), "Data was inserted", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }
}
