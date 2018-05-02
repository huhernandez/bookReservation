package edu.csumb.huhernandez.project2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {
    public EditText titleInput;
    public EditText authorInput;
    public EditText isbnInput;
    public EditText feeInput;
    public Button   okayButton;
    private LibraryDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        titleInput= findViewById(R.id.titleIn);
        authorInput=findViewById(R.id.authorIn);
        isbnInput=findViewById(R.id.isbnIn);
        feeInput=  findViewById(R.id.rateIn);
        okayButton= findViewById(R.id.okydokie);


        db = LibraryDB.getInstance(this);
        db.populateInitialData();



        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String ti = titleInput.getText().toString();
                final String ai = authorInput.getText().toString();
                final String ii = isbnInput.getText().toString();
                final String fi = feeInput.getText().toString();

                final double rate= Double.parseDouble(fi);

                AlertDialog.Builder builder = new AlertDialog.Builder(AddBookActivity.this);
                builder.setMessage("Title: "+ti+"\n Author: "+ ai +"\n ISBN: "+ ii +"\n Fee: "+ fi)
                        .setTitle("Is This Information Correct?")
                        .setCancelable(false)
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(AddBookActivity.this, AddBookActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                db.bookDao().addBook(new Book(ti, ai, ii,rate,"y" ));
                                dialog.dismiss();
                                Intent intent = new Intent(AddBookActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}
