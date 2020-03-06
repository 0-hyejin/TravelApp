package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editID;
    EditText editPWD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);



        editID = findViewById(R.id.editID);
        editPWD = findViewById(R.id.editPWD);

        Button btnLOGIN = findViewById(R.id.buttonLOGIN);
        btnLOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sID = editID.getText().toString().trim();
                String sPWD = editPWD.getText().toString();
                sPWD = sPWD.trim();

                if(sID.isEmpty() || sPWD.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "ID와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent it2 = new Intent(getApplicationContext(), HomeActivity.class);
                it2.putExtra("id", sID);
                startActivity(it2);
            }
        });

        Button btnJOIN = findViewById(R.id.buttonJOIN);
        btnJOIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it2 = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(it2);
            }
        });



        Button btnPWD = findViewById(R.id.buttonFIND);
        btnPWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sID = editID.getText().toString().trim();

                if(sID.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent it3 = new Intent(getApplicationContext(), FindActivity.class);
                it3.putExtra("id", sID);
                startActivity(it3);
            }
        });
    }

}

