package com.example.navigationview.ui.gallery;

import com.example.navigationview.R;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerModel {
    public List<Integer> getData() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.v1);
        list.add(R.drawable.v2);
        list.add(R.drawable.v3);
        return list;
    }
}
