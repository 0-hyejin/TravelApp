package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {
    EditText editJID;
    EditText editJPWD;
    EditText editJNAME;
    EditText editJCALL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        editJID = findViewById(R.id.editJID);
        editJPWD = findViewById(R.id.editJPWD);
        editJNAME = findViewById(R.id.editJNAME);
        editJCALL = findViewById(R.id.editJCALL);


        Intent intent = getIntent();
        String sID = intent.getStringExtra("id");


        Button btnTooLogin = findViewById(R.id.toLogin);
        btnTooLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sID = editJID.getText().toString().trim();
                String sPWD = editJPWD.getText().toString();
                String sNAME = editJNAME.getText().toString().trim();
                String sCALL = editJCALL.getText().toString().trim();
                sPWD = sPWD.trim();

                if(sID.isEmpty() || sPWD.isEmpty() || sNAME.isEmpty() || sCALL.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "정보를 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();


                Intent it = new Intent();
                it.putExtra("id", sID);
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}
