package com.example.datatransferbetweenscreens;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;
    final int REQUEST_CODE_DEFAULT = 0;

    TextView tvText;
    Button btnColor;
    Button btnAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = (TextView)findViewById(R.id.tvText);

        btnColor = (Button)findViewById(R.id.btnColor);
        btnAlign = (Button)findViewById(R.id.btnAlign);

        btnAlign.setOnClickListener(this);
        btnColor.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                intent.putExtra("text", "Change color");
                someActivityResultLauncher.launch(intent);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, AlignActivity.class);
                intent.putExtra("text", "Change align");
                someActivityResultLauncher.launch(intent);
                break;
        }

    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        int requestCode = data.getIntExtra("requestCode", REQUEST_CODE_DEFAULT);
                        switch (requestCode){
                            case REQUEST_CODE_COLOR:
                                int color = data.getIntExtra("color", Color.WHITE);
                                tvText.setTextColor(color);
                                break;
                            case REQUEST_CODE_ALIGN:
                                int align = data.getIntExtra("alignment", Gravity.LEFT);
                                tvText.setGravity(align);
                                break;
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong result", Toast.LENGTH_SHORT).show();
                    }

                }
            });
}