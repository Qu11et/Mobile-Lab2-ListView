package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());



        int[] imageList = {R.drawable.suonnuong, R.drawable.canhchua, R.drawable.giahexaodauhu};
        String[] nameList = {"Món mặn", "Món canh", "Món xào"};
        String[] dishList = {"4 sản phẩm", "4 sản phẩm", "4 sản phẩm"};
        String[] saleList = {"4 đang giảm giá", "4 đang giảm giá", "4 đang giảm giá"};

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(imageList[i], dishList[i], nameList[i], saleList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(MainActivity.this, MonManActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, MonCanhActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, MonXaoActivity.class);
                        break;
                    default:
                        return;
                }
                intent.putExtra("sale", saleList[i]);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("dish", dishList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}