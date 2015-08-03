package com.hishamzahran.tabs2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 8/2/2015.
 */
public class MyFragment extends Fragment {

    private ListView listView;
    private CustomAdapter la;
    private ArrayList<String> contacts;

    public static MyFragment getInstance(ArrayList<String> contacts) {
        MyFragment mf = new MyFragment();
        mf.contacts = contacts;
        return mf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment, container, false);

        //ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sites);
        la = new CustomAdapter(v.getContext(), contacts);
        listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(la);

        return v;
    }

    public ListView getListView() {
        return listView;
    }

    public void updateList(){
        la.notifyDataSetChanged();
    }
}