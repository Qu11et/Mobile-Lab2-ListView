package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MonCanhAdapter extends ArrayAdapter<MonCanhData> {
    public MonCanhAdapter(@NonNull Context context, ArrayList<MonCanhData> dataArrayList) {
        super(context, R.layout.list_detailed_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view1, @NonNull ViewGroup parent) {
        MonCanhData monCanhData = getItem(position);

        if(view1 == null){
            view1 = LayoutInflater.from(getContext()).inflate(R.layout.list_detailed_item, parent, false);
        }

        ImageView listImage = view1.findViewById(R.id.listImage2);
        TextView listName = view1.findViewById(R.id.listSubName);
        TextView listDish = view1.findViewById(R.id.listPrice);
        TextView listSale2 = view1.findViewById(R.id.listSale2);

        assert monCanhData != null;
        listImage.setImageResource(monCanhData.image2);
        listName.setText(monCanhData.subName);
        listDish.setText(monCanhData.price);
        listSale2.setText(monCanhData.sale2);

        return view1;
    }
}
