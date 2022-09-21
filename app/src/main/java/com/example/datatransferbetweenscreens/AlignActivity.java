package com.example.datatransferbetweenscreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener{

    final int REQUEST_CODE_ALIGN = 2;
    Button btnLeft, btnCenter, btnRight;
    TextView tvAlignText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);
        tvAlignText = (TextView)findViewById(R.id.tvAlignText);
        Intent intent = getIntent();
        String name = intent.getStringExtra("text");
        tvAlignText.setText(name);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnCenter = (Button)findViewById(R.id.btnCenter);
        btnRight = (Button)findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("requestCode", REQUEST_CODE_ALIGN);
        switch (v.getId()){
            case R.id.btnLeft:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();

    }
}