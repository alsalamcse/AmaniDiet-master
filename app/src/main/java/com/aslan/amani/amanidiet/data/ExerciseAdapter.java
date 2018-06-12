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

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    public ExerciseAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_exercise, parent, false);
        TextView tvPullUp = (TextView) view.findViewById(R.id.tvPullUp);
        TextView tvPushUps = (TextView) view.findViewById(R.id.tvPushUp);
        TextView tvSquats = (TextView) view.findViewById(R.id.tvSquats);


        final Exercise h = getItem(position);

        tvPullUp.setText(h.getPullups() + "");
        tvPushUps.setText(h.getPushups() + "");
        tvSquats.setText(h.getSquats()+ "");

        return view;
    }
}
