package com.example.datatransferbetweenscreens;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRed, btnGreen, btnBlue;
    TextView tvColorText;
    final int REQUEST_CODE_COLOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        tvColorText = (TextView)findViewById(R.id.tvColorText);
        Intent intent = getIntent();
        String name = intent.getStringExtra("text");
        tvColorText.setText(name);

        btnRed = (Button)findViewById(R.id.btnRed);
        btnGreen = (Button)findViewById(R.id.btnGreen);
        btnBlue = (Button)findViewById(R.id.btnBlue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("requestCode", REQUEST_CODE_COLOR);
        switch (v.getId()){
            case R.id.btnRed:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btnGreen:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}