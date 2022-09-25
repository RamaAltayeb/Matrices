package com.example.cec.matrixes;

import android.content.Context;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;


import java.util.List;

import matrix.cell;

public class MatrixAdapter extends BaseAdapter {
    Context context;
    List<cell> matrixList;

    public MatrixAdapter(Context context, List<cell> matrixList) {
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
        EditText v =new EditText(context);
        v.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        v.setText(""+matrixList.get(i).getVal());
        return v;
    }

}
