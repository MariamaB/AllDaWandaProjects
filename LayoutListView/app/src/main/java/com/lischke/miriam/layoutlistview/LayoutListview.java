package com.lischke.miriam.layoutlistview;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.lischke.miriam.layoutlistview.model.Images;
import com.lischke.miriam.layoutlistview.model.Price;
import com.lischke.miriam.layoutlistview.model.TrendingProduct;

import java.net.URL;
import java.util.List;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    TrendingProduct product;
    List<TrendingProduct> responseBody;
    Price p;
    Images images;
    String img;
    ImageView imageView;
    URL url;
    Bitmap bmp;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    public interface DawandaService {

        @GET("/core/mobile/trending_products")
        Call<List<TrendingProduct>> getDummieContent();

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(llm);


        OkHttpClient client = new OkHttpClient();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://de.dawanda.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DawandaService service = retrofit.create(DawandaService.class);

        Call<List<TrendingProduct>> aufruf = service.getDummieContent();
        aufruf.enqueue(new retrofit2.Callback<List<TrendingProduct>>() {
            @Override
            public void onResponse(Call<List<TrendingProduct>> call, Response<List<TrendingProduct>> response) {

                responseBody = response.body();
                System.out.println(responseBody.get(1).getTitle());
                RVAdapter adapter = new RVAdapter(responseBody);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<TrendingProduct>> call, Throwable t) {
                System.out.println("Failurrrrree!!!: "+t);
            }


        });



        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lischke.miriam.giftfinder/http/host/path")
        );
        AppIndex.AppIndexApi.start(client2, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lischke.miriam.giftfinder/http/host/path")
        );
        AppIndex.AppIndexApi.end(client2, viewAction);
        client2.disconnect();
    }
}
