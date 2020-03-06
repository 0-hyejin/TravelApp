package com.example.hyejin.a20181761ohj;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceActivity extends AppCompatActivity {

    int imgNum = 1; // 보여줄 이미지 번호
    ImageView img; // 맛집 이미지 보여주는 위젯
    Button btn; // 맛집 이름 보여주는 위젯
    Resources res; // 리소스 관리 객체

    private void changeImg() { // 현재 imgNum에 해당하는 이미지를 가져와서 보여줌
        int id = res.getIdentifier("place" + imgNum, "drawable", getPackageName());
        img.setImageResource(id);
    }

    private void changePlace() { // 현재 imgNum에 해당하는 식당이름을 가져와서 보여줌
        int id = res.getIdentifier("place" + imgNum, "string", getPackageName());
        String place = res.getString(id);
        btn.setText(place);
    }

    public void changeImgLeft(View v) { //왼쪽 화살표를 클릭하면 실행
        if(imgNum > 1) {
            imgNum--;
            changeImg();
            changePlace();
        }
    }

    public void changeImgRight(View v) { // 오른쪽 화살표를 클릭하면 실행
        if(imgNum < 6) {
            imgNum++;
            changeImg();
            changePlace();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);


        img = (ImageView)findViewById(R.id.imageView); // 맛집 이미지를 보여주는 위젯
        btn = (Button)findViewById(R.id.button); // 맛집 이름을 보여주는 위젯
        res = getResources(); // 리소스 관리 객체

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int id = res.getIdentifier("info" + imgNum, "string", getPackageName());
                String str = res.getString(id);
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PRActivity.class);
                intent.putExtra("imgNo", imgNum);
                startActivity(intent);

            }
        });

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
                Intent it2 = new Intent(getApplicationContext(), WriteActivity.class);
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
