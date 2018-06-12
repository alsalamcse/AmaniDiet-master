package com.aslan.amani.amanidiet.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.aslan.amani.amanidiet.R;

/**
 * Created by aodai on 11/06/2018.
 */

public class AdviceAdapter extends ArrayAdapter<Advice> {

    public AdviceAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_advice, parent, false);
        TextView tvAdvice = (TextView) view.findViewById(R.id.tvAdvice);
        TextView tvType = (TextView) view.findViewById(R.id.tvType);

        final Advice h = getItem(position);

        tvAdvice.setText(h.getAdvice() + "");
        tvType.setText(h.getType() + "");

        return view;
    }


}
