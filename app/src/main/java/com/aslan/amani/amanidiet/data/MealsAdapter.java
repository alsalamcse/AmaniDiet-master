package com.aslan.amani.amanidiet.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aslan.amani.amanidiet.R;

/**
 * Created by aodai on 11/06/2018.
 */

public class MealsAdapter extends ArrayAdapter<Meals> {

    public MealsAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_meals, parent, false);
        TextView tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        TextView tvTime = (TextView) view.findViewById(R.id.tvTime);


        final Meals h = getItem(position);

        tvDescription.setText(h.getTime() + "");
        tvTime.setText(h.getDescription() + "");

        return view;
    }
}
