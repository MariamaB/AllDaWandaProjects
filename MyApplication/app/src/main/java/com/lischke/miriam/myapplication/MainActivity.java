package com.lischke.miriam.myapplication;

	import android.app.ActionBar;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.annotation.NonNull;
    import android.support.annotation.Nullable;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.RelativeLayout;

    import com.google.android.gms.appindexing.Action;
    import com.google.android.gms.appindexing.AppIndex;
    import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {

    private static int [] colors = {R.color.c1,R.color.c2,R.color.c3};
    private static int [] imgCenter = {R.drawable.ic_launcher_web, R.color.c1,R.drawable.miriam_web};
    private static Button buttonC;
    private static ImageView colorField;
    private static int index;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.lischke.miriam.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
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
                Uri.parse("android-app://com.lischke.miriam.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

 /* public void buttonClick(View v){
        buttonC = (Button)findViewById(R.id.buttonMain);
        colorField = (ImageView)findViewById(R.id.colorField);
        buttonC.setOnClickListener(
                new View.OnClickListener(){
                    public void  onClick(View v){
                        index ++;
                       colorField.setImageResource(colors[index]);

                        ImageView img = (ImageView) v;

                        img.setImageResource(colors[index]);


                    }
                }
        );

    }*/

    public void onClick(View v){


        ImageView img = (ImageView) v;
         img.setImageResource(colors[index]);


    }

    public void buttonClick(View v){

        Button buttonc = (Button) v;
        ((Button) v).setText("geschafft!!!");

    }

    public void clickMainCenter(View v){
        ImageView center = (ImageView) v;

        center.setImageResource(imgCenter[index]);
        if(index <= 1) {
            index++;
        }else
        {
            index = 0;
        }


    }

}


