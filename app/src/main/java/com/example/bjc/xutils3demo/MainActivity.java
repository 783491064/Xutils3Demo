package com.example.bjc.xutils3demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;
@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        x.view().inject(this);
    }
    @Event(value={R.id.bt_zj,R.id.bt_zj_lw,R.id.bt_dt,R.id.bt_lt})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_zj:
                break;
            case R.id.bt_zj_lw:
                Intent intent=new Intent(this,NetActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_dt:
                break;
            case R.id.bt_lt:
                break;
        }


    }
}
