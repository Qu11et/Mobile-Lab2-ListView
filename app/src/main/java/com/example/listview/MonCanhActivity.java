package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MonCanhActivity extends AppCompatActivity {


    MonCanhAdapter monCanhAdapter;
    ArrayList<MonCanhData> canhArrayList = new ArrayList<>();
    MonCanhData monCanhData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        EdgeToEdge.enable(this);

        // Set up the toolbar back button
        ImageView backButton = findViewById(R.id.left_icon);
        backButton.setOnClickListener(v -> {
            // Navigate back to MainActivity
            Intent intent = new Intent(MonCanhActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });

        int[] image2List = {R.drawable.canhchua, R.drawable.canhcachuatrung, R.drawable.canhbido, R.drawable.canhcaixanh};
        String[] subNameList = {"Canh chua", "Canh cà chua trứng", "Canh bí đỏ", "Canh cải xanh"};
        String[] priceList = {"12000đ", "12000đ", "12000đ", "12000đ"};
        String[] sale2List = {"20000 đ", "20000 đ", "20000 đ", "20000 đ"};

        for (int i = 0; i < image2List.length; i++) {
            monCanhData = new MonCanhData(image2List[i], priceList[i], subNameList[i], sale2List[i]);
            canhArrayList.add(monCanhData);
        }
        monCanhAdapter = new MonCanhAdapter(MonCanhActivity.this, canhArrayList);
        ListView listView = findViewById(R.id.listView2);
        listView.setAdapter(monCanhAdapter);
    }
}
