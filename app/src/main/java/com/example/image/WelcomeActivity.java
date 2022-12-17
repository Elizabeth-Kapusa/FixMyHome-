package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button = (Button) findViewById(R.id.escom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openEscom();
            }
        });

        button = (Button) findViewById(R.id.dstv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDstv();
            }
        });

        button = (Button) findViewById(R.id.mwb);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMwb();
            }
        });

        button = (Button) findViewById(R.id.mhc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMhc();
            }
        });
    }
     public void openEscom(){
        Intent intent = new Intent(this, EscomActivity.class);
        startActivity(intent);
    }

    public void openDstv(){
        Intent intent = new Intent(this, DstvActivity.class);
        startActivity(intent);
    }

    public void openMwb(){
        Intent intent = new Intent(this, MwbActivity.class);
        startActivity(intent);
    }

    public void openMhc(){
        Intent intent = new Intent(this, MhcActivity.class);
        startActivity(intent);
    }
}