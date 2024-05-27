package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    TextView txtInfo;
    EditText edtResult;
    Button btnBack;
    String name;
    int roll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        extractInput();
        initListners();

    }
    private void initViews(){
        txtInfo = findViewById(R.id.txtInfo);
        edtResult = findViewById(R.id.edtResult);
        btnBack = findViewById(R.id.btnBack);
    }
    private void extractInput(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        roll = bundle.getInt("rollno");
        name = bundle.getString("name");
        txtInfo.setText(name+" "+roll);

    }
    private void initListners(){
        btnBack.setOnClickListener(new btnBackClickListner());
    }
    class btnBackClickListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("result",edtResult.getText().toString());
            setResult(1,intent);
            finish();
        }
    }
}
