package cs371.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    private ToggleButton power;
    private ToggleButton radio;
    private Button preset1;
    private Button preset2;
    private Button preset3;
    private Button preset4;
    private Button preset5;
    private Button preset6;

    private Button play;
    private TextView station;
    private SeekBar tuner;
    public boolean radioSet = true;
    public boolean power2;
    private double[] Fmpresets;
    private int[] Ampresets;

    //protected void onCreate(Bundle savedInstanceState){

    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        power = (ToggleButton) findViewById(R.id.powerButton);

        radio = (ToggleButton) findViewById(R.id.radio);

        preset1 = (Button) findViewById(R.id.preset1);

        preset2 = (Button) findViewById(R.id.preset2);

        preset3 = (Button) findViewById(R.id.preset3);

        preset4 = (Button) findViewById(R.id.preset4);

        preset5 = (Button) findViewById(R.id.preset5);

        preset6 = (Button) findViewById(R.id.preset6);

        play = (Button) findViewById(R.id.Play);

        station = (TextView) findViewById(R.id.textView2);

        tuner = (SeekBar) findViewById(R.id.Volume);

        tuner.setOnSeekBarChangeListener(this);

        Fmpresets = new double[6];
        Fmpresets[0] = 90.9;
        Fmpresets[1] = 92.9;
        Fmpresets[2] = 94.9;
        Fmpresets[3] = 96.9;
        Fmpresets[4] = 98.9;
        Fmpresets[5] = 100.9;

        Ampresets = new int[6];
        Ampresets[0] = 550;
        Ampresets[1] = 600;
        Ampresets[2] = 650;
        Ampresets[3] = 700;
        Ampresets[4] = 750;
        Ampresets[5] = 800;





        Log.i("create","");

    }
    public void onClick(View v){
        Log.i("on click","");
    }
    public boolean Power(View v) {
        if (power.isChecked()) {
            Log.i("power button", "hihi");
            power.setBackgroundColor(Color.GREEN);
            radio.setBackgroundColor(Color.LTGRAY);
            preset1.setBackgroundColor(Color.LTGRAY);
            play.setBackgroundColor(Color.LTGRAY);
        } else {
            power2 = false;
            power.setBackgroundColor(Color.GRAY);
            radio.setBackgroundColor(Color.BLACK);
            preset1.setBackgroundColor(Color.BLACK);
            play.setBackgroundColor(Color.BLACK);

        }
        return true;
    }
    public void preset(View v)
    {   if(radioSet == false)
    {
        if(v.equals(preset1)) {
            tuner.setProgress((Integer.parseInt(preset1.getText().toString()) - 530) / 10);
        }
        else if(v.equals(preset2))
    }}

    public boolean Radio(View v){

        if (radio.isChecked()){

            preset1.setText("" + Fmpresets[0]);
            preset2.setText("" + Fmpresets[1]);
            preset3.setText("" + Fmpresets[2]);
            preset4.setText("" + Fmpresets[3]);
            preset5.setText("" + Fmpresets[4]);
            preset6.setText("" + Fmpresets[5]);
            tuner.setMax(99);
            radioSet = true;

        }
        else{

            preset1.setText("" + Ampresets[0]);
            preset2.setText("" + Ampresets[1]);
            preset3.setText("" + Ampresets[2]);
            preset4.setText("" + Ampresets[3]);
            preset5.setText("" + Ampresets[4]);
            preset6.setText("" + Ampresets[5]);

            tuner.setMax(117);
            radioSet = false;

        }
        return true;
    }

    public boolean barmove (View v){
        Log.i("barmove","");

        return true;
    }

    public void onProgressChanged(SeekBar tuner,int progress, boolean user) {
        if(radioSet == true)
        {
            double fmStation;

            fmStation = (progress* (.2)) + 88.1 ;
            station.setText("" + fmStation);
        }
        else if(radioSet == false)
        {
            double amStation;
            amStation = (progress * (10)) + 530;
            station.setText(""+amStation);

        }

    }

    public void onStartTrackingTouch(SeekBar tuner){

    }
    public void onStopTrackingTouch(SeekBar tuner){

    }


}
