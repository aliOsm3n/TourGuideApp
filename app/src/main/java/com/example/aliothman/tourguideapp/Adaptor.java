package com.example.aliothman.tourguideapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptor extends ArrayAdapter {

    public Adaptor(Context context, ArrayList<Modelitems> data) {
        super(context, 0, data);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview = convertView;
        if (itemview == null) {
            itemview = LayoutInflater.from(getContext()).inflate(
                    R.layout.item, parent, false);
        }
        Modelitems current = (Modelitems) getItem(position);

        TextView tvn = (TextView) itemview.findViewById(R.id.namebar);
        tvn.setText(current.get_name());
        TextView tva = (TextView) itemview.findViewById(R.id.addbar);
        tva.setText(current.get_address());

        ImageView ivi = (ImageView) itemview.findViewById(R.id.ipicture);
        if (current.image_available()) {
            ivi.setImageResource(current.get_imgid());
            ivi.setVisibility(View.VISIBLE);
        } else {
            ivi.setVisibility(View.GONE);
        }
        return itemview;
    }
}
