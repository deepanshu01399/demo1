package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    Button button,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("deep","on create was called");
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);


        button.setOnClickListener(this);
        button2.setOnClickListener(new clickclass());
        button3.setOnClickListener(new OnClickListener() {//unanymus class
            @Override
            public void onClick(View v) {
                Log.d("deep","3rd button click by object ");//method
            }
        });
        button4.setOnClickListener(this);


    }
    /*class clickclass1 implements OnClickListener{
        public void onClick(View v){
            v.getId();
            Intent intent = new Intent(MainActivity.class,activitymain.class);
        }

    }*/
    public void doSomething1(View view) {
        Intent i=new Intent(this, activitymain.class);
        startActivity(i);
    }


    class clickclass implements OnClickListener{
        public void onClick(View v){
            v.getId();

        }

    }

    int count=0;
    protected void onResume(){
        super.onResume();
        count++;
        Log.d("deep","on resume was called");

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",count);
        Log.d("deep",count+"was saved");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count=savedInstanceState.getInt("count");
        Log.d("deep",count+"was restore");
    }

    protected void onStart(){
        super.onStart();
        Log.d("deep","on start was called");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("deep","on pause was called");


    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("deep","on destroy was called");


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("deep"," orientationn  was changed");
        Log.d("deep",""+newConfig.orientation);
        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            Log.d("deep","u are at landscape");
        }
        else
            Log.d("deep","u are portarate mode");

    }
    public void doSomething(View v){

        Log.d("deep","button click");
        v.getId();
        Log.d("deep",v.getId()+ "is cliked");

        if(v.getId()==R.id.button1){
            Log.d("deep","first button clicked");
        }
        else
            Log.d("deep","second button clicked");


    }




    @Override
    public void onClick(View v) {
      //  Toast.makeText(this,"button by method call",Toast.LENGTH_LONG).show();
        switch (v.getId()){
            case R.id.button1:
                Log.d("deep","button by method call by button 1");
                Intent intent = new Intent(this,activitymain.class);
                startActivity(intent);

                break;
            case R.id.button4:
                Log.d("deep","button by method call by button 4");
                Intent intent1 = new Intent(this,activitymain.class);
                startActivity(intent1);

                break;
        }


    }



}
