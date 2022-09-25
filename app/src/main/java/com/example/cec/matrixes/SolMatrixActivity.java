package com.example.cec.matrixes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import matrix.cell;

public class SolMatrixActivity extends MatrixMainActivity {

    Button oksol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sol_matrix);

        setGrid();

        oksol=(Button)findViewById(R.id.oksol);
        oksol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }

        });
    }

    public void setGrid() {
            // INITIALISE YOUR GRID
            GridView grid = (GridView) findViewById(R.id.solgrid);
            grid.setNumColumns(sol[0].length);

            ArrayList<cell> matrixList = new ArrayList<>();


            // ADD SOME CONTENTS TO EACH ITEM
            for (int i = 0; i < sol.length;i++) {
                for (int j = 0; j < sol[0].length; j++) {
                    matrixList.add(new cell(i, j, sol[i][j]));
                }
            }

            // CREATE AN ADAPTER  (MATRIX ADAPTER)
            SolMatrixAdapter adapter = new SolMatrixAdapter(getApplicationContext(), matrixList);

            // ATTACH THE ADAPTER TO GRID
            grid.setAdapter(adapter);
    }

}
