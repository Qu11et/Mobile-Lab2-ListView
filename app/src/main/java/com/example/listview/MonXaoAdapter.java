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

public class MonXaoAdapter extends ArrayAdapter<MonXaoData> {
    public MonXaoAdapter(@NonNull Context context, ArrayList<MonXaoData> dataArrayList) {
        super(context, R.layout.list_detailed_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view2, @NonNull ViewGroup parent) {
        MonXaoData monXaoData = getItem(position);

        if(view2 == null){
            view2 = LayoutInflater.from(getContext()).inflate(R.layout.list_detailed_item, parent, false);
        }

        ImageView listImage = view2.findViewById(R.id.listImage2);
        TextView listName = view2.findViewById(R.id.listSubName);
        TextView listDish = view2.findViewById(R.id.listPrice);
        TextView listSale2 = view2.findViewById(R.id.listSale2);

        assert monXaoData != null;
        listImage.setImageResource(monXaoData.image2);
        listName.setText(monXaoData.subName);
        listDish.setText(monXaoData.price);
        listSale2.setText(monXaoData.sale2);

        return view2;
    }
}
