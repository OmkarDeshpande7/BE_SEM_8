package com.example.app_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Third extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBhelper helper = new DBhelper(this);
        Button loginButton = findViewById(R.id.button);
        EditText username = findViewById(R.id.editText);
        EditText password = findViewById(R.id.editText2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long res = helper.insertData("one","one");
                if(res >= 0){
                    String toastMessage = "User successfully added !";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Third.this, MainActivity.class));

                }
                else{
                    String toastMessage = "User already exists !";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
