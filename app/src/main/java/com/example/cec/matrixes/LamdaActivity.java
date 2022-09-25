package com.example.cec.matrixes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LamdaActivity extends MatrixMainActivity {

    private EditText edittext;
    private Button oklamdaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamda);

        settext();

        oklamdaBtn=(Button)findViewById(R.id.oklamda);
        oklamdaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                float temp=lamda;
                try{
                     edittext=(EditText) findViewById(R.id.editlamda);
                     String text=edittext.getText().toString();
                     lamda=Float.parseFloat(text);
                }
                catch(Exception ex){
                    lamda=temp;
                }
                finally{
                        finish();
                }
            }

        });
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    private void settext(){
        edittext = (EditText) findViewById(R.id.editlamda);
        edittext.setText("" +lamda);
    }
}
