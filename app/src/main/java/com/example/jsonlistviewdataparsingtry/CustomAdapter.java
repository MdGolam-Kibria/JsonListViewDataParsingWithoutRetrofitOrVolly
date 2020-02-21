package com.example.jsonlistviewdataparsingtry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class CustomAdapter extends BaseAdapter {
    Context applicationContext;
    int simple;
    List<DemoStudent> s;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context applicationContext, int simple, List<DemoStudent> s) {
        this.applicationContext = applicationContext;
        this.simple = simple;
        this.s = s;
    }

    @Override
    public int getCount() {
        return s.size();
    }

    @Override
    public Object getItem(int i) {
        return s.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            layoutInflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.simple, viewGroup, false);
        }
        TextView name, dept, year, university;
        name = view.findViewById(R.id.name);
        dept = view.findViewById(R.id.dept);
        year = view.findViewById(R.id.year);
        university = view.findViewById(R.id.university);
        name.setText(s.get(i).getName());
        dept.setText(s.get(i).getDept());
        year.setText(s.get(i).getYear());
        university.setText(s.get(i).getUniversity());
        return view;
    }
}
