package com.example.cec.matrixes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import matrix.cell;

public class MatrixActivity extends MatrixMainActivity {

    private Button inRBtn;
    private Button deRBtn;
    private Button inCBtn;
    private Button deCBtn;
    private Button subBtn;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        if (IsA) {
            setTextRow();
            setTextCol();
            setGrid();

            inRBtn = (Button) findViewById(R.id.increaserows);
            inRBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rowA < 20) {
                        rowA++;
                        setTextRow();
                        A = new float[rowA][colA];
                        setGrid();
                    }
                }

            });

            deRBtn = (Button) findViewById(R.id.decreaserows);
            deRBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rowA > 1) {
                        rowA--;
                        setTextRow();
                        A = new float[rowA][colA];
                        setGrid();
                    }

                }

            });

            inCBtn = (Button) findViewById(R.id.increasecols);
            inCBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (colA < 20) {
                        colA++;
                        setTextCol();
                        A = new float[rowA][colA];
                        setGrid();
                    }
                }

            });

            deCBtn = (Button) findViewById(R.id.decreasecols);
            deCBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (colA > 1) {
                        colA--;
                        setTextCol();
                        A = new float[rowA][colA];
                        setGrid();
                    }
                }

            });

            subBtn = (Button) findViewById(R.id.submitmatrix);
            subBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        // SETUP GRIDVIEW
                        GridView mGridView = (GridView) findViewById(R.id.matrixgrid);
                        float[] temporary = new float[mGridView.getChildCount()];
                        // ITERATE THROUGH EACH CHILDS
                        for (int i = 0; i < mGridView.getChildCount(); i++) {
                            EditText element = (EditText) mGridView.getChildAt(i);
                            String matrix_value = element.getText().toString();
                            temporary[i] = Float.parseFloat(matrix_value);

                        }
                        int k = 0;
                        for (int i = 0; i < rowA; i++) {
                            for (int j = 0; j < colA; j++) {
                                A[i][j] = temporary[k];
                                k++;
                            }
                        }
                    } catch (Exception ex) {
                    } finally {
                        finish();
                    }
                }

            });

        } else {
            setTextRow();
            setTextCol();
            setGrid();

            inRBtn = (Button) findViewById(R.id.increaserows);
            inRBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rowB < 20) {
                        rowB++;
                        setTextRow();
                        B = new float[rowB][colB];
                        setGrid();
                    }
                }

            });

            deRBtn = (Button) findViewById(R.id.decreaserows);
            deRBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (rowB > 1) {
                        rowB--;
                        setTextRow();
                        B = new float[rowB][colB];
                        setGrid();
                    }

                }

            });

            inCBtn = (Button) findViewById(R.id.increasecols);
            inCBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (colB < 20) {
                        colB++;
                        setTextCol();
                        B = new float[rowB][colB];
                        setGrid();
                    }
                }

            });

            deCBtn = (Button) findViewById(R.id.decreasecols);
            deCBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (colB > 1) {
                        colB--;
                        setTextCol();
                        B = new float[rowB][colB];
                        setGrid();
                    }
                }

            });

            subBtn = (Button) findViewById(R.id.submitmatrix);
            subBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        // SETUP GRIDVIEW
                        GridView mGridView = (GridView) findViewById(R.id.matrixgrid);
                        float[] temporary = new float[mGridView.getChildCount()];
                        // ITERATE THROUGH EACH CHILDS
                        for (int i = 0; i < mGridView.getChildCount(); i++) {
                            EditText element = (EditText) mGridView.getChildAt(i);
                            String matrix_value = element.getText().toString();
                            temporary[i] = Float.parseFloat(matrix_value);

                        }
                        int k = 0;
                        for (int i = 0; i < rowB; i++) {
                            for (int j = 0; j < colB; j++) {
                                B[i][j] = temporary[k];
                                k++;
                            }
                        }
                    } catch (Exception ex) {
                    } finally {
                        finish();
                    }
                }

            });
        }

    }


    public void setTextRow() {
        if (IsA) {
            textview = (TextView) findViewById(R.id.rowsnumber);
            textview.setText("" + rowA);
        } else {
            textview = (TextView) findViewById(R.id.rowsnumber);
            textview.setText("" + rowB);
        }
    }

    public void setTextCol() {
        if (IsA) {
            textview = (TextView) findViewById(R.id.colsnumber);
            textview.setText("" + colA);
        } else {
            textview = (TextView) findViewById(R.id.colsnumber);
            textview.setText("" + colB);
        }
    }

    public void setGrid() {
        if (IsA) {
            // INITIALISE YOUR GRID
            GridView grid = (GridView) findViewById(R.id.matrixgrid);
            grid.setNumColumns(colA);

            ArrayList<cell> matrixList = new ArrayList<>();


            // ADD SOME CONTENTS TO EACH ITEM
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colA; j++) {
                    matrixList.add(new cell(i, j, A[i][j]));
                }
            }

            // CREATE AN ADAPTER  (MATRIX ADAPTER)
            MatrixAdapter adapter = new MatrixAdapter(getApplicationContext(), matrixList);

            // ATTACH THE ADAPTER TO GRID
            grid.setAdapter(adapter);
        } else {
            // INITIALISE YOUR GRID
            GridView grid = (GridView) findViewById(R.id.matrixgrid);
            grid.setNumColumns(colB);

            ArrayList<cell> matrixList = new ArrayList<>();


            // ADD SOME CONTENTS TO EACH ITEM
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < colB; j++) {
                    matrixList.add(new cell(i, j, B[i][j]));
                }
            }

            // CREATE AN ADAPTER  (MATRIX ADAPTER)
            MatrixAdapter adapter = new MatrixAdapter(getApplicationContext(), matrixList);

            // ATTACH THE ADAPTER TO GRID
            grid.setAdapter(adapter);
        }

    }


}