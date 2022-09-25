package com.example.cec.matrixes;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import matrix.cell;

public class SolMatrixAdapter extends BaseAdapter {
    Context context;
    List<cell> matrixList;

    public SolMatrixAdapter(Context context, List<cell> matrixList) {
        this.context = context;
        this.matrixList = matrixList;
    }

    @Override
    public int getCount() {
        return matrixList.size();
    }

    @Override
    public Object getItem(int i) {
        return matrixList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView v =new TextView(context);
        v.setText(""+matrixList.get(i).getVal());
        return v;
    }

}
