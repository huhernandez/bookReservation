package edu.csumb.huhernandez.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;


public class PlaceHoldActivity extends AppCompatActivity {

    private EditText pickupdateinput;
    private EditText pickuptimeinput;
    private EditText returndateinput;
    private EditText returntimeinput;
    private Spinner  bookSpinner;
    private EditText usernamePH;
    private EditText pwdPH;


    private LibraryDB db;

    private Button mPlaceHoldButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placehold);

        mPlaceHoldButton = findViewById(R.id.mPlaceHoldButton);   //mapped button & inputs to layout
        bookSpinner=findViewById(R.id.bookspinner);

        db = LibraryDB.getInstance(this);
        db.populateInitialData();

        pickupdateinput= findViewById(R.id.pickupdateinput);
        pickuptimeinput= findViewById(R.id.pickuptimeinput);
        returntimeinput=findViewById(R.id.returntimeinput);
        returndateinput=findViewById(R.id.returndateinput);
        usernamePH=findViewById(R.id.usernameInput);
        pwdPH=findViewById(R.id.pwdInput);

        final String pickupdate= pickupdateinput.getText().toString();
        final String returndate= returndateinput.getText().toString();
        final String pickuptime= pickuptimeinput.getText().toString();
        final String returntime= returntimeinput.getText().toString();
        final String un = usernamePH.getText().toString();
        final String pw = pwdPH.getText().toString();


        List<String> allBooks = db.bookDao().getAllBookTitles();

        //allBooks.add(0, new Book("Please select a book ","","",0,""));

        final ArrayAdapter<String> bookAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, allBooks);

        bookAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bookSpinner.setAdapter(bookAdapter);




        bookSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // ignore first item of spinner
                if (i != 0) {
                    String thatbook = bookSpinner.getSelectedItem().toString();



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mPlaceHoldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thatbook = bookSpinner.getSelectedItem().toString();

                db.reservationDao().addReservation(new Reservation(1, thatbook ,pickupdate,returndate,2.4,"N") );

            }
        });

    }


    }



