package com.example.cec.matrixes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetActivity extends MatrixMainActivity {

    TextView tv;
    Button okdet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_det);

        tv = (TextView) findViewById(R.id.detval);
        tv.setText(""+det);


        okdet=(Button)findViewById(R.id.okdet);
        okdet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }

        });
    }
}
