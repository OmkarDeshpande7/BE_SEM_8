    package com.example.app_1;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.Bundle;
    import android.support.design.widget.FloatingActionButton;
    import android.support.design.widget.Snackbar;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Toast;

    public class Second extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


        }
        @SuppressLint("ResourceType")
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            //getMenuInflater().inflate(R.menu.main, menu);
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.layout.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.view:
                    startActivity(new Intent(Second.this, ViewActivity.class));
                    return true;
                case R.id.delete:
                    startActivity(new Intent(Second.this, DeleteActivity3.class));
                    return true;
                case R.id.logout:
                    Toast.makeText(Second.this, "Good Bye !", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Second.this, MainActivity.class));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

    }
