package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        TextView info = findViewById(R.id.info);
        Intent intent = getIntent();
        String sID = intent.getStringExtra("id");
        info.setText(sID + info.getText().toString());

        TextView marque = (TextView) this.findViewById(R.id.info);
        marque.setSelected(true);



        ImageButton imgbtnWrite = findViewById(R.id.ImgBtnWrite);
        imgbtnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(w);
            }
        });



        ImageButton imgbtnList = findViewById(R.id.ImgBtnList);
        imgbtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(getApplicationContext(), PlanActivity.class);
                startActivity(l);
            }
        });



        ImageButton imgbtnPlace = findViewById(R.id.ImgBtnPlace);
        imgbtnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(getApplicationContext(), PlaceActivity.class);
                startActivity(p);
            }
        });



        ImageButton imgbtnFood = findViewById(R.id.ImgBtnFood);
        imgbtnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent f = new Intent(getApplicationContext(), FRActivity.class);
                startActivity(f);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.manbogi:
                Intent it4 = new Intent(getApplicationContext(), ManbogiActivity.class);
                startActivity(it4);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
