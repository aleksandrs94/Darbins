package com.example.kriss.galadarbs;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }
    Context context;

    static class LayoutHandler
    {
        TextView NOSAUKUMS;
        //TextView DATUMS,CENA,INFO;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NOSAUKUMS = (TextView)row.findViewById(R.id.text_nosaukums);
            //layoutHandler.DATUMS = (TextView)row.findViewById(R.id.text_datums);
            //layoutHandler.CENA = (TextView)row.findViewById(R.id.text_cena);
            //layoutHandler.INFO = (TextView)row.findViewById(R.id.text_info);
            row.setTag(layoutHandler);
        }
        else
        {

        layoutHandler =(LayoutHandler)row.getTag();


        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.NOSAUKUMS.setText(dataProvider.getNosaukums());
        //layoutHandler.DATUMS.setText(dataProvider.getDatums());
        //layoutHandler.CENA.setText(dataProvider.getCena());
        //layoutHandler.INFO.setText(dataProvider.getInfo());

        return row;

    }

}
