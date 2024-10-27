package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MonXaoActivity extends AppCompatActivity {

    MonXaoAdapter monXaoAdapter;
    ArrayList<MonXaoData> xaoArrayList = new ArrayList<>();
    MonXaoData monXaoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        EdgeToEdge.enable(this);

        // Set up the toolbar back button
        ImageView backButton = findViewById(R.id.left_icon);
        backButton.setOnClickListener(v -> {
            // Navigate back to MainActivity
            Intent intent = new Intent(MonXaoActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        int[] image2List = {R.drawable.giahexaodauhu, R.drawable.vitxaosaot, R.drawable.mucxaodualeo, R.drawable.thitboxaodaurong};
        String[] subNameList = {"Giá hẹ xào đậu hủ", "Vịt xào sả ớt", "Mực xào dưa leo", "Thịt bò xào đậu rồng"};
        String[] priceList = {"18000 đ", "18000 đ", "18000 đ", "18000 đ"};
        String[] listSale2 = {"30000 đ", "30000 đ", "30000 đ", "30000 đ"};

        for (int i = 0; i < image2List.length; i++) {
            monXaoData = new MonXaoData(image2List[i], priceList[i], subNameList[i], listSale2[i]);
            xaoArrayList.add(monXaoData);
        }
        monXaoAdapter = new MonXaoAdapter(MonXaoActivity.this, xaoArrayList);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(monXaoAdapter);
    }
}