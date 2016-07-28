package com.lischke.miriam.layoutexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lischke.miriam.layoutexample.model.TrendingProduct;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ListCardLayout extends AppCompatActivity {


    List<TrendingProduct> responseBody;
    RecyclerView rv;



    public interface DawandaService {

        @GET("/core/mobile/trending_products")
        Call<List<TrendingProduct>> getDummieContent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card_layout);
        rv = (RecyclerView)findViewById(R.id.rvL);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
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

        RVAdapter adapter = new RVAdapter(responseBody, this, true);
        rv.setAdapter(adapter);
    }

}
