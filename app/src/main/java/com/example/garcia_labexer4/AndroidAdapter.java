package com.example.garcia_labexer4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AndroidAdapter extends ArrayAdapter<AndroidVersions> {
    private Context context;
    private int resource;

    public AndroidAdapter(@NonNull Context context, int resource, @NonNull List<AndroidVersions> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
        // return super.getView(position, convertView, parent);
        int logo = getItem(i).getLogo();
        String name = getItem(i).getoName();
        String country = getItem(i).getoCountry();
        String industry = getItem(i).getoIndustry();
        String ceo = getItem(i).getoCeo();


        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.imageView);
        TextView nname = convertView.findViewById(R.id.tname);
        TextView ncountry = convertView.findViewById(R.id.tcountry);
        TextView nindustry = convertView.findViewById(R.id.tindustry);
        TextView nceo = convertView.findViewById(R.id.tceo);

        img.setImageResource(logo);
        nname.setText(name);
        ncountry.setText(country);
        nindustry.setText(industry);
        nceo.setText(ceo);
        return convertView;

    }
}
