package com.example.app_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView text = findViewById(R.id.delete_name);
        Button fab = findViewById(R.id.delete_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhelper helper = new DBhelper(DeleteActivity3.this);
                helper.delete(text.getText().toString());
                Toast.makeText(DeleteActivity3.this, "Deleted !", Toast.LENGTH_LONG).show();
                startActivity(new Intent(DeleteActivity3.this, Second.class));
            }
        });
    }
}