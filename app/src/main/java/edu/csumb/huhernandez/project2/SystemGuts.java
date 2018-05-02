package edu.csumb.huhernandez.project2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SystemGuts extends AppCompatActivity {
    public TextView logsnStuff;
    public Button okbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_guts);

        logsnStuff = findViewById(R.id.sysLogStuff);
        okbutton = findViewById(R.id.okayButton);

        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(SystemGuts.this);
                builder.setMessage("Would you like to add a book?")
                        .setTitle("Add Book?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(SystemGuts.this, AddBookActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                Intent intent = new Intent(SystemGuts.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();



//                AlertDialog alertDialog = new AlertDialog.Builder(SystemGuts.this).create();
//                alertDialog.setTitle("Add Book");
//                alertDialog.setMessage("Would you like to add a book?");
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "YES", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent(SystemGuts.this, AddBookActivity.class);
//                        startActivity(intent);
//                    }
//
//                });
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "NO", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        dialog.dismiss();
//                        finish();
//                    }
//                });
//                alertDialog.show();


            }
        });
    }
}