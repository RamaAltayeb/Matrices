package com.example.cec.matrixes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import matrix.matrix;


public class MatrixMainActivity extends AppCompatActivity {

    private Button lamdaBtn;
    private Button matrixABtn;
    private Button matrixBBtn;
    private Button swipBtn;
    private Button sumLamdaABtn;
    private Button subLamdaABtn;
    private Button subALamdaBtn;
    private Button multLamdaABtn;
    private Button divLamdaABtn;
    private Button divALamdaBtn;
    private Button sumABBtn;
    private Button subABBtn;
    private Button multABBtn;
    private Button divABBtn;
    private Button TABtn;
    private Button TBBtn;
    private Button detABtn;
    private Button detBBtn;
    private Button invertABtn;
    private Button invertBBtn;

    protected static float lamda = 0;
    protected static int rowA = 2;
    protected static int colA = 2;
    protected static int rowB = 2;
    protected static int colB = 2;
    protected static float[][] A = {{0, 0}, {0, 0}};
    protected static float[][] B = {{0, 0}, {0, 0}};
    protected static float[][] sol;
    protected static float det = 0;
    protected static boolean IsA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_main);

        lamdaBtn = (Button) findViewById(R.id.lamda);
        lamdaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MatrixMainActivity.this, LamdaActivity.class);
                startActivity(in);
            }

        });

        matrixABtn = (Button) findViewById(R.id.Amatrix);
        matrixABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsA = true;
                Intent in = new Intent(MatrixMainActivity.this, MatrixActivity.class);
                startActivity(in);
            }

        });

        matrixBBtn = (Button) findViewById(R.id.Bmatrix);
        matrixBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsA = false;
                Intent in = new Intent(MatrixMainActivity.this, MatrixActivity.class);
                startActivity(in);
            }

        });

        swipBtn = (Button) findViewById(R.id.swip);
        swipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t = rowA;
                rowA = rowB;
                rowB = t;
                t = colA;
                colA = colB;
                colB = t;
                float[][] temp = new float[A.length][A[0].length];
                for (int i = 0; i < A.length; i++) {
                    for (int j = 0; j < A[0].length; j++) {
                        temp[i][j] = A[i][j];
                    }
                }
                A = new float[B.length][B[0].length];
                for (int i = 0; i < B.length; i++) {
                    for (int j = 0; j < B[0].length; j++) {
                        A[i][j] = B[i][j];
                    }
                }
                B = new float[temp.length][temp[0].length];
                for (int i = 0; i < temp.length; i++) {
                    for (int j = 0; j < temp[0].length; j++) {
                        B[i][j] = temp[i][j];
                    }
                }
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Done", duration);
                toast.show();
            }

        });

        sumLamdaABtn = (Button) findViewById(R.id.sumLamdaA);
        sumLamdaABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.sum(A, lamda);
                Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                startActivity(in);
            }

        });

        subLamdaABtn = (Button) findViewById(R.id.subLamdaA);
        subLamdaABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.sub(lamda, A);
                Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                startActivity(in);
            }

        });

        subALamdaBtn = (Button) findViewById(R.id.subALamda);
        subALamdaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.sub(A, lamda);
                Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                startActivity(in);
            }

        });

        multLamdaABtn = (Button) findViewById(R.id.multLamdaA);
        multLamdaABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.mult(A, lamda);
                Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                startActivity(in);
            }

        });

        divLamdaABtn = (Button) findViewById(R.id.divLamdaA);
        divLamdaABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.div(lamda, A);
                if (sol != null) {
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: A has a zero field value", duration);
                    toast.show();
                }
            }

        });

        divALamdaBtn = (Button) findViewById(R.id.divALamda);
        divALamdaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lamda != 0) {
                    sol = matrix.div(A, lamda);
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: λ = 0", duration);
                    toast.show();
                }
            }

        });

        sumABBtn = (Button) findViewById(R.id.sumAB);
        sumABBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.sum(A, B);
                if (sol != null) {
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: Rows A ≠ Rows B \n Columns A ≠ Columns B", duration);
                    toast.show();
                }
            }

        });

        subABBtn = (Button) findViewById(R.id.subAB);
        subABBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.sub(A, B);
                if (sol != null) {
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: Rows A ≠ Rows B \n Columns A ≠ Columns B", duration);
                    toast.show();
                }
            }

        });

        multABBtn = (Button) findViewById(R.id.multAB);
        multABBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.mult(A, B);
                if (sol != null) {
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: Columns A ≠ Rows B", duration);
                    toast.show();
                }
            }

        });

        divABBtn = (Button) findViewById(R.id.divAB);
        divABBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.div(A, B);
                if (sol != null) {
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: Rows A ≠ Rows B \n Columns A ≠ Columns B", duration);
                    toast.show();
                }
            }

        });

        TABtn = (Button) findViewById(R.id.transportA);
        TABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.transport(A);
                Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                startActivity(in);
            }

        });

        TBBtn = (Button) findViewById(R.id.transportB);
        TBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sol = matrix.transport(B);
                Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                startActivity(in);
            }

        });

        detABtn = (Button) findViewById(R.id.detA);
        detABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (matrix.isSquare(A)) {
                    det = matrix.determinant(A);
                    Intent in = new Intent(MatrixMainActivity.this, DetActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: A is not a square matrix", duration);
                    toast.show();
                }

            }

        });

        detBBtn = (Button) findViewById(R.id.detB);
        detBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (matrix.isSquare(B)) {
                    det = matrix.determinant(B);
                    Intent in = new Intent(MatrixMainActivity.this, DetActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: B is not a square matrix", duration);
                    toast.show();
                }

            }

        });

        invertABtn = (Button) findViewById(R.id.invertA);
        invertABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float[][] temp=new float[A.length][A[0].length];
                for(int i=0;i<A.length;i++)
                    for(int j=0;j<A[0].length;j++)
                        temp[i][j]=A[i][j];
                if (matrix.isSquare(temp)) {
                    sol = matrix.invert(temp);
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: A is not a square matrix", duration);
                    toast.show();
                }

            }

        });

        invertBBtn = (Button) findViewById(R.id.invertB);
        invertBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float[][] temp=new float[B.length][B[0].length];
                for(int i=0;i<B.length;i++)
                    for(int j=0;j<B[0].length;j++)
                        temp[i][j]=B[i][j];
                if (matrix.isSquare(temp)) {
                    sol = matrix.invert(temp);
                    Intent in = new Intent(MatrixMainActivity.this, SolMatrixActivity.class);
                    startActivity(in);
                } else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, "Error: B is not a square matrix", duration);
                    toast.show();
                }
            }
        });
    }

}
