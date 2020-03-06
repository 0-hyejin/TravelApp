package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanVActivity extends AppCompatActivity {


    TextView name, menu1,menu2,menu3,tvtel,tvaddress,tvdate;
    ImageView imageView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_v);



        setTitle("나의 기록");
        name = (TextView)findViewById(R.id.txtname);
        menu1 = (TextView)findViewById(R.id.etplace1);
        menu2 = (TextView)findViewById(R.id.etplace2);
        menu3 = (TextView)findViewById(R.id.etplace3);
        tvtel = (TextView)findViewById(R.id.tvTel);
        tvaddress = (TextView)findViewById(R.id.tvURL);
        tvdate = (TextView)findViewById(R.id.tvRegdate);
        back = (Button)findViewById(R.id.btnback) ;
        imageView = (ImageView)findViewById(R.id.imgno);
        Intent intent = getIntent();
        Rest res = intent.getParcelableExtra("restinfo");

        name.setText(res.getName());
        menu1.setText(res.getmenu1());
        menu2.setText(res.getmenu2());
        menu3.setText(res.getmenu3());
        tvtel.setText(res.getTel());
        tvdate.setText(res.getDate());
        tvaddress.setText(res.getHomepage());

        if(res.getCategorynum() == 1)
        {
            imageView.setImageResource(R.drawable.car);
        }
        else if (res.getCategorynum() == 2)
        {
            imageView.setImageResource(R.drawable.train);
        }
        else if (res.getCategorynum() == 3)
        {
            imageView.setImageResource(R.drawable.bus);
        }
        else
        {
            imageView.setImageResource(R.drawable.taix);
        }

    }

    public void onClick(View v)
    {
        Intent intent = getIntent();
        Rest res = intent.getParcelableExtra("restinfo");
        switch (v.getId())
        {
            case R.id.btnback:
                finish();
                break;

            case R.id.imageView3:
                Intent intent3 = new Intent(Intent.ACTION_VIEW,Uri.parse(res.getHomepage()));
                startActivity(intent3);
                break;
        }
    }
}
