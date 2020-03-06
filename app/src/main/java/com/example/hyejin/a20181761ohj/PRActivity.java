package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PRActivity extends AppCompatActivity {

    int imgNum = 1; // 보여줄 이미지 번호
    TextView tv1;
    TextView tv2;
    ImageView img; // 맛집 이미지 보여주는 위젯
    Resources res; // 리소스 관리 객체


    public void back(View v) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pr);


        Intent intent= getIntent();

        imgNum = intent.getIntExtra("imgNo",1);

        tv1 = (TextView)findViewById(R.id.pp);
        img = (ImageView)findViewById(R.id.ii);
        tv2 = (TextView)findViewById(R.id.ifif);
        res = getResources();

        int id =  res.getIdentifier("place" + imgNum, "string", getPackageName());
        String str = res.getString(id);

        tv1.setText(str);
        id = res.getIdentifier("place" + imgNum, "drawable", getPackageName());
        img.setImageResource(id);

        id=res.getIdentifier("info" + imgNum, "string", getPackageName());
        str=res.getString(id);
        tv2.setText(str);

    }
}
