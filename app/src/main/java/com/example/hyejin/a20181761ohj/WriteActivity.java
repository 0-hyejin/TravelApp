package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class WriteActivity extends AppCompatActivity {

    EditText etname,ettel,etplace1,etplace2,etplace3,etaddr;
    RadioButton rb1,rb2,rb3;
    Rest res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);


        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etplace1 = (EditText)findViewById(R.id.etplace1);
        etplace2 = (EditText)findViewById(R.id.etplace2);
        etplace3 = (EditText)findViewById(R.id.etplace3);
        etaddr = (EditText)findViewById(R.id.etaddr);
        rb1 = (RadioButton)findViewById(R.id.radio1);
        rb2 = (RadioButton)findViewById(R.id.radio2);
        rb3 = (RadioButton)findViewById(R.id.radio3);
        setTitle("기록 남기기");



    }



    public void onClick(View v)
    {
        if (v.getId() == R.id.btnCancel)
        {
            finish();
        }
        else
        {
            if(rb1.isChecked())
            {
                setcategorynum(1);
            }
            else if (rb2.isChecked())
            {
                setcategorynum(2);
            }
            else if (rb3.isChecked())
            {
                setcategorynum(3);
            }
            res.setMenu(etplace1.getText().toString());
            res.setMenu(etplace2.getText().toString());
            res.setMenu(etplace3.getText().toString());
            res.setDate(finddate());
            Intent intent = new Intent(getApplicationContext(), PlanActivity.class);
            intent.putExtra("newrest",res);
            setResult(RESULT_OK,intent);
            finish();
        }
    }



    public void setcategorynum(int n)
    {
        res = new Rest(etname.getText().toString(),
                ettel.getText().toString(),
                etaddr.getText().toString(),
                n);
    }

    public String finddate()
    {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String fmdate = sdf.format(date);
        return fmdate;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Intent it = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(it);
                return true;
            case R.id.write:
                Intent it2 = new Intent(getApplicationContext(), PlanActivity.class);
                startActivity(it2);
                return true;
            case R.id.place:
                Intent it3 = new Intent(getApplicationContext(), PlaceActivity.class);
                startActivity(it3);
                return true;
            case R.id.food:
                Intent it4 = new Intent(getApplicationContext(), FRActivity.class);
                startActivity(it4);
                return true;
            case R.id.manbogi:
                Intent it5 = new Intent(getApplicationContext(), ManbogiActivity.class);
                startActivity(it5);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
