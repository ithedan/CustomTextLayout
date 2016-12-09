package com.dengxiao.customtextlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomTextView customTextView1 = (CustomTextView) findViewById(R.id.coustomTextView);

    /*    customTextView1.setLeftImg(getResources().getDrawable(R.drawable.ic_search))
                .setRightImg(getResources().getDrawable(R.drawable.icon_portrait))
                .setLeftTv("代码添加","#c95fdc")
                .setRightTv("代码添加","#4be1c3")
                .setCenterTv("代码",null)
                .setLeftTopTv("上",null)
                .setLeftBottomTv("下",null)
                .setBottomLine("#1587e7")
                .setCustomTvBackground("#4dacff");

        customTextView1.setOnTextViewClickListener(new CustomTextView.OnTextViewClickListener(){
            @Override
            public void OnLeftImgClick() {
                Toast.makeText(MainActivity.this,"左边图片",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void OnRightImgClick() {
                Toast.makeText(MainActivity.this,"右边图片",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void OnTextViewClick() {
                Toast.makeText(MainActivity.this,"布局",Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
