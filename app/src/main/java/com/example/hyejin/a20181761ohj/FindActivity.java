package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);


        TextView inf = findViewById(R.id.inf);


        Intent intent = getIntent();
        String sID = intent.getStringExtra("id");
        inf.setText(sID + inf.getText().toString());


        Button btnTooLogin = findViewById(R.id.toLogin);
        btnTooLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
