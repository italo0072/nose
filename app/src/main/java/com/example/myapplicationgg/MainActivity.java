package com.example.myapplicationgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

private  static  final  long start_time_in_millis = 600000;

private  TextView time2;
private Button mb1,mb2;

private CountDownTimer l2;
private  boolean l3;
private  long l4 = start_time_in_millis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time2 = findViewById(R.id.a1);
        mb1= findViewById(R.id.b1);
        mb2= findViewById(R.id.b2);

mb1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(l3){
            pausarreloj();

        }else {
            despausar();
        }

    }
});

mb2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        resetearreloj();

    }
});
kd();

    }

    private  void  despausar(){
    l2 = new CountDownTimer(l4,1000) {
        @Override
        public void onTick(long l) {
l4= l;
kd();
        }

        @Override
        public void onFinish() {
            l3= false;
            mb1.setText("start");
            mb1.setVisibility(View.INVISIBLE);
            mb2.setVisibility(View.VISIBLE);

        }
    }.start();
    l3 = true;
    mb1.setText("pause");
    mb2.setVisibility(View.INVISIBLE);
    }

    private  void pausarreloj () {
        l2.cancel();
        l3 = false;
        mb1.setText("start");
        mb2.setVisibility(View.VISIBLE);
    }
    private void  resetearreloj(){
l4  = start_time_in_millis;
kd();
mb2.setVisibility(View.INVISIBLE);
mb1.setVisibility(View.VISIBLE);
    }

    private  void kd(){

    int minutes = (int) (l4 / 1000) /60;
        int seconds = (int) (l4 / 1000) %60;
        String c1 = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
    time2.setText(c1);
    }


}