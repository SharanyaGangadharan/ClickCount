package com.example.shara.clickcount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView btnCount,bdCount, btnText, bgdText;
    int count = 0;
    static int bgcount =0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCount = (TextView) this.findViewById(R.id.textView1);
        bdCount = (TextView) this.findViewById(R.id.textView2);
        bgdText = (TextView) this.findViewById(R.id.textView3);
        btnText = (TextView) this.findViewById(R.id.textView4);
        btnCount.setText(String.valueOf(count));
        bdCount.setText(String.valueOf(bgcount));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("Button Count");
        btnCount.setText(String.valueOf(count));
    }

    protected void onResume(){
        bdCount.setText(String.valueOf(bgcount));
        super.onResume();
    }

    protected void onStop(){
        if(!isChangingConfigurations())
            bgcount++;
        bdCount.setText(String.valueOf(bgcount));
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("Button Count", count);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void increase(View button) {
        Log.i("rew","increase");
        count++;
        btnCount.setText(String.valueOf(count));
    }

    @Override
    protected void onDestroy(){
        if(isFinishing())
            bgcount=0;
        super.onDestroy();
    }
}
