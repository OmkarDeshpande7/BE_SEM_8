package com.example.app_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    private Button loginButton;

    private int loginAttempts = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginAttempts == 0) {
                    return;
                }



                if (username.getText().toString().equals("scarecrow") && password.getText().toString().equals("scarecrow")) {
                    loginAttempts = 3;
                    String toastMessage = "Login successful !";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Second.class));
                } else {
                    loginAttempts--;
                    if(loginAttempts == 0) {
                        loginButton.setEnabled(false);
                        loginButton.setBackgroundColor(Color.WHITE);
                        Toast.makeText(MainActivity.this, "Your attempt reach 0, please try restarting the app.", Toast.LENGTH_SHORT).show();

                    }
                    String toastMessage = "Please try again ! Attempts remaining : "+ loginAttempts;
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}
