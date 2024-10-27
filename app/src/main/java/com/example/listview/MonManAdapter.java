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

public class MonManAdapter extends ArrayAdapter<MonManData> {
    public MonManAdapter(@NonNull Context context, ArrayList<MonManData> dataArrayList) {
        super(context, R.layout.list_detailed_item, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view0, @NonNull ViewGroup parent) {
        MonManData monManData = getItem(position);

        if(view0 == null){
            view0 = LayoutInflater.from(getContext()).inflate(R.layout.list_detailed_item, parent, false);
        }

        ImageView listImage = view0.findViewById(R.id.listImage2);
        TextView listName = view0.findViewById(R.id.listSubName);
        TextView listDish = view0.findViewById(R.id.listPrice);
        TextView listSale2 = view0.findViewById(R.id.listSale2);

        assert monManData != null;
        listImage.setImageResource(monManData.image2);
        listName.setText(monManData.subName);
        listDish.setText(monManData.price);
        listSale2.setText(monManData.sale2);

        return view0;
    }
}
