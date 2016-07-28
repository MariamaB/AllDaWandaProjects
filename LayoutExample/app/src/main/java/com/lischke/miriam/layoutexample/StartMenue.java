package com.lischke.miriam.layoutexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartMenue extends AppCompatActivity {

    Button b1,b2,b3,b4;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menue);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        t1 = (TextView) findViewById(R.id.openingText);
    }


    public void onClick(View v){
        if (v.equals(b1)){
            startActivity(new Intent(getApplicationContext(),FullCardLayout.class));
        }else if(v.equals(b2)){
            startActivity(new Intent(getApplicationContext(),ListCardLayout.class));
        }else if (v.equals(b3)){
            startActivity(new Intent(getApplicationContext(),Gridlayout.class));
        }else if (v.equals(b4)){
            startActivity(new Intent(getApplicationContext(),StaggerdGridLayout.class));
        }

    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("Landscape!!!!!!!!!");


        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            System.out.println("Portrait!!!!!!!!!");


        }

    }
}
