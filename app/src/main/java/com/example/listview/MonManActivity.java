package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MonManActivity extends AppCompatActivity {


    MonManAdapter monManAdapter;
    ArrayList<MonManData> manArrayList = new ArrayList<>();
    MonManData monManData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        EdgeToEdge.enable(this);

        // Set up the toolbar back button
        ImageView backButton = findViewById(R.id.left_icon);
        backButton.setOnClickListener(v -> {
            // Navigate back to MainActivity
            Intent intent = new Intent(MonManActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        int[] image2List = {R.drawable.suonnuong, R.drawable.thitkhotrung, R.drawable.nemnuong, R.drawable.gakho};
        String[] subNameList = {"Sườn nướng", "Thịt kho trứng", "Nem nướng", "Gà kho"};
        String[] priceList = {"15000đ", "15000đ", "15000đ", "15000đ"};
        String[] sale2List = {"25000 đ", "25000 đ", "25000 đ", "25000 đ"};

        for (int i = 0; i < image2List.length; i++) {
            monManData = new MonManData(image2List[i], priceList[i], subNameList[i], sale2List[i]);
            manArrayList.add(monManData);
        }
        monManAdapter = new MonManAdapter(MonManActivity.this, manArrayList);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(monManAdapter);
    }

}