package com.techblogon.loginexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homescreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);


        Button S = (Button) findViewById(R.id.S);

        S.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, Science.class));

            }

        });


        Button T = (Button) findViewById(R.id.T);

        T.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this, Technology.class));
            }
        });
    }}