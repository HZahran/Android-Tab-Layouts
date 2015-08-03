package com.hishamzahran.tabs2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {

    ArrayList<String> contacts;
    Context cntxt;

    public CustomAdapter(Context context, ArrayList<String> contacts) {
        super(context, R.layout.custom_row, contacts);
        cntxt = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView;

        if(convertView == null){
            LayoutInflater li = LayoutInflater.from(cntxt);
            customView = li.inflate(R.layout.custom_row, parent, false);
        } else {
            customView = convertView;
        }

        String contact[] = getItem(position).split("-");
        TextView name = (TextView) customView.findViewById(R.id.txt);
        TextView number = (TextView) customView.findViewById(R.id.number);
        ImageView img = (ImageView) customView.findViewById(R.id.img);


        name.setText(contact[0]);
        number.setText(contact[1]);
        int resourceId = cntxt.getResources().getIdentifier("contact", "drawable",
                cntxt.getPackageName());

        img.setImageResource(resourceId);

        return customView;
    }

    public void setContacts(ArrayList<String> contacts){
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public String getItem(int position){
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
