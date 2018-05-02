package edu.csumb.huhernandez.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mCreateButton;
    private Button mPlaceButton;
    private Button mCancelButton;
    private Button mManageButton;
    private LibraryDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = LibraryDB.getInstance(this);
        db.populateInitialData();



        mCreateButton = findViewById(R.id.mCreateButton);

        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                    startActivity(intent);


            }
        });

        mPlaceButton= findViewById(R.id.mPlaceButton);
        mPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlaceHoldActivity.class);
                startActivity(intent);


            }
        });

        mCancelButton= findViewById(R.id.mCancelButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CancelHoldActivity.class);
                startActivity(intent);


            }
        });

        mManageButton= findViewById(R.id.mManageButton);

        mManageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ManageSystem.class);
                startActivity(intent);


            }
        });
    }
}
