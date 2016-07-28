package com.lischke.miriam.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    private boolean gameReady = false;
    private boolean isBlack, isRed;
    private RadioButton black;
    private RadioButton red;
    private RadioButton human;
    private RadioButton computer;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private TextView anzeige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        black = (RadioButton) findViewById(R.id.black);
        red = (RadioButton) findViewById(R.id.red);
        human = (RadioButton) findViewById(R.id.human);
        computer = (RadioButton) findViewById(R.id.computer);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        anzeige = (TextView)findViewById(R.id.textView);
        stop(anzeige);

    }

    public void start(View v){

        if(gameReady == false){
            System.out.println("gameReady = false ");

            black.setEnabled(true);
            red.setEnabled(true);
            human.setEnabled(true);
            human.setChecked(true);
            //computer.setEnabled(true);
            anzeige.setText(R.string.anzeigeFarbe);


        }else if (gameReady == true){

            button1.setEnabled(true); button2.setEnabled(true); button3.setEnabled(true);
            button4.setEnabled(true); button5.setEnabled(true); button6.setEnabled(true);
            button7.setEnabled(true); button8.setEnabled(true); button9.setEnabled(true);

            button1.setClickable(true); button2.setClickable(true); button3.setClickable(true);
            button4.setClickable(true); button5.setClickable(true); button6.setClickable(true);
            button7.setClickable(true); button8.setClickable(true); button9.setClickable(true);

            if(black.isChecked()){
                anzeige.setText(R.string.anzeigeSchwarz);
                isBlack = true;
                red.setEnabled(false);
                black.setEnabled(false);
            }else if(red.isChecked()){
                anzeige.setText(R.string.anzeigeRot);
                isRed = true;
                red.setEnabled(false);
                black.setEnabled(false);
            }

        }
    }


    public void selectAndEnable(View v){

        gameReady = true;
        anzeige.setText(R.string.anzeigeReady);
    }


    public void duringGame(View v){

        Button button = (Button) v;

        if (isBlack){
            anzeige.setText("Rot ist dran");
            button.setText(R.string.O);
            button.setTextColor(getResources().getColor(R.color.textColor));
            isBlack = false;
            isRed = true;
            Log.d("duringGame","Black war dran");

           if(spielGewonnen()){
               Log.d("duringGame","Black spielGewonnen = true");
               anzeige.setText("Schwarz hat gewonnen");
           }else{
               Log.d("duringGame","spielGewonnen = "+spielGewonnen());
           }

        }else if (isRed){
            anzeige.setText("Schwarz ist dran");
            button.setText(R.string.X);
            button.setTextColor(getResources().getColor(R.color.redC));
            isRed = false;
            isBlack = true;
            Log.d("duringGame","Rot war dran");

            if(spielGewonnen()){
                Log.d("duringGame","Rot spielGewonnen = true");
                anzeige.setText("Rot hat gewonnen");
            }else{
                Log.d("duringGame","spielGewonnen = "+spielGewonnen());
            }
        }
    }


    public boolean spielGewonnen(){


        if(button1.getText().toString() == "X"&&
                button2.getText().toString() == "X"&&
               button3.getText().toString() == "X"
                ||
                button1.getText().toString() == "O"&&
                        button2.getText().toString() == "O"&&
                        button3.getText().toString() == "O")
        {
            return true;
        }
        else if(button1.getText().toString() == "X"&&
                button4.getText().toString() == "X"&&
                button7.getText().toString() == "X"
                ||
                button1.getText().toString() == "O"&&
                        button4.getText().toString() == "O"&&
                        button7.getText().toString() == "O")
        {
            return true;
        }
        else if(button1.getText().toString() == "X"&&
                button5.getText().toString() == "X"&&
                button9.getText().toString() == "X"
                ||
                button1.getText().toString() == "O"&&
                        button5.getText().toString() == "O"&&
                        button9.getText().toString() == "O")
        {
            return true;
        }
        else if(button2.getText().toString() == "X"&&
                button5.getText().toString() == "X"&&
                button8.getText().toString() == "X"
                ||
                button2.getText().toString() == "O"&&
                        button5.getText().toString() == "O"&&
                        button8.getText().toString() == "O")
        {
            return true;
        }
        else if(button3.getText().toString() == "X"&&
                button6.getText().toString() == "X"&&
                button9.getText().toString() == "X"
                ||
                button3.getText().toString() == "O"&&
                        button6.getText().toString() == "O"&&
                        button9.getText().toString() == "O")
        {
            return true;
        }
        else if(button4.getText().toString() == "X"&&
                button5.getText().toString() == "X"&&
                button6.getText().toString() == "X"
                ||
                button4.getText().toString() == "O"&&
                        button5.getText().toString() == "O"&&
                        button6.getText().toString() == "O")
        {
            return true;
        }
        else if(button7.getText().toString() == "X".toString()&&
                button8.getText().toString() == "X".toString()&&
                button9.getText().toString() == "X".toString()
                ||
                button7.getText().toString() == "O".toString()&&
                        button8.getText().toString() == "O".toString() &&
                        button9.getText().toString() == "O".toString())
        {
            return true;
        }
        else if(button7.getText().toString() == "X"&&
                button5.getText().toString() == "X"&&
                button2.getText().toString() == "X"
                ||
                button7.getText().toString() == "O"&&
                        button5.getText().toString() == "O"&&
                        button3.getText().toString() == "O")
        {

            return true;
        }

        return false;
    }


    public void stop(View v){

        gameReady = false;

        black.setChecked(false);
        red.setChecked(false);
        human.setChecked(false);
        computer.setChecked(false);

        black.setEnabled(false);
        red.setEnabled(false);
        human.setEnabled(false);
        computer.setEnabled(false);

        button1.setClickable(false); button1.setEnabled(false);  button2.setClickable(false); button2.setEnabled(false);  button3.setClickable(false); button3.setEnabled(false);

        button4.setClickable(false); button4.setEnabled(false);  button5.setClickable(false); button5.setEnabled(false);  button6.setClickable(false); button6.setEnabled(false);

        button7.setClickable(false); button7.setEnabled(false);  button8.setClickable(false); button8.setEnabled(false);  button9.setClickable(false); button9.setEnabled(false);

        button1.setText(" "); button2.setText(" "); button3.setText(" ");
        button4.setText(" "); button5.setText(" "); button6.setText(" ");
        button7.setText(" "); button8.setText(" "); button9.setText(" ");

        anzeige.setText(R.string.anzeigeDefault);

        System.out.println("Game STOP!!! ");


    }



}
