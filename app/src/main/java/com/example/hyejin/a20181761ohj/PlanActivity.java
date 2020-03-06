package com.example.hyejin.a20181761ohj;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class PlanActivity extends AppCompatActivity {


    ArrayList<String> recorddata = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayList<Rest> recordlist = new ArrayList<Rest>();
    ListView listView;
    final int REST_INFO = 21;
    final int NEW_REST = 22;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        tv = (TextView) findViewById(R.id.tv);
        setTitle("나의 기록");
        setListView();
    }


    public void onClick(View v) {
        Intent intent = new Intent(PlanActivity.this, WriteActivity.class);
        intent.putExtra("recordlist", recorddata);
        startActivityForResult(intent, NEW_REST);
    }

    public void setListView() {
        listView = (ListView) findViewById(R.id.listview);


        //어댑터 만듬
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recorddata);
        listView.setAdapter(adapter);

        //꾹 눌렀을때 삭제
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {

                //정보를 삭제하는지 묻는 대화상자 나타남
                AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
                dlg.setTitle("삭제")
                        .setMessage("정말 삭제하시겠습니까?")
                        .setNegativeButton("취소", null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //삭제 클릭시 아래꺼
                                recorddata.remove(position);
                                recordlist.remove(position);
                                adapter.notifyDataSetChanged();
                                tv.setText("나의 기록");
                                Snackbar.make(view, "삭제되었습니다.", 2000).show();
                            }
                        })
                        .show();
                return true;
            }
        });

        //클릭시 상세정보가 나타남
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlanActivity.this, PlanVActivity.class);
                Rest res = recordlist.get(position);
                intent.putExtra("restinfo", res);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_REST) {
            if (resultCode == RESULT_OK) {
                Rest res = data.getParcelableExtra("newrest"); //새 레스토랑 받아옴
                recorddata.add(res.getName());
                recordlist.add(res);
                adapter.notifyDataSetChanged();
                tv.setText("나의 기록");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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

