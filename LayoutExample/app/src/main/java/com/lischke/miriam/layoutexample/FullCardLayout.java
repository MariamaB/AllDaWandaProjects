package com.lischke.miriam.layoutexample;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.lischke.miriam.layoutexample.model.TrendingProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class FullCardLayout extends AppCompatActivity {


    List<TrendingProduct> responseBody;
    RecyclerView rv;
    boolean portrait;
    Button b1;
    boolean clicked;


    public interface DawandaService {

        @GET("/core/mobile/trending_products")
        Call<List<TrendingProduct>> getDummieContent();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_card_layout);
        rv = (RecyclerView)findViewById(R.id.rvF);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(llm);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://de.dawanda.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DawandaService service = retrofit.create(DawandaService.class);
        Call<List<TrendingProduct>> aufruf = service.getDummieContent();


        aufruf.enqueue(new retrofit2.Callback<List<TrendingProduct>>() {

            @Override
            public void onResponse(Call<List<TrendingProduct>> call, Response<List<TrendingProduct>> response) {

                buildAdapter(response);
            }
            @Override
            public void onFailure(Call<List<TrendingProduct>> call, Throwable t) {
                System.out.println("Failurrrrree!!!: "+t);
            }


        });


    }




    private void buildAdapter(Response<List<TrendingProduct>> response) {
        responseBody = response.body();
        System.out.println("Titel: "+responseBody.get(1).getTitle());
        onConfigurationChanged(getResources().getConfiguration());
        RVAdapter adapter = new RVAdapter(responseBody,this, portrait);
        rv.setAdapter(adapter);
    }




    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("Landscape!!!!!!!!!");
            portrait = true;
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            System.out.println("Portrait!!!!!!!!!");
            portrait = false;
        }

    }
}
