package com.example.spc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.TestAnno;

@TestAnno
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectActivity.inject(this);//调用build生成的类
    }
}
