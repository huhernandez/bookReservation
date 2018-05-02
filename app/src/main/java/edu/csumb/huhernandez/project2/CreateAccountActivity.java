package edu.csumb.huhernandez.project2;

import android.arch.persistence.room.util.StringUtil;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Hugo on 12/8/17.
 */

public class CreateAccountActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText pwdInput;
    private Button mSubmitButton;
    private LibraryDB db;
    public int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        mSubmitButton = findViewById(R.id.mSubmitButton);   //mapped button & inputs to layout
        usernameInput = findViewById(R.id.usernameInput);
        pwdInput = findViewById(R.id.pwdInput);

        db = LibraryDB.getInstance(this);
        db.populateInitialData();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkFields()!=true){
                    counter++;
                }

                if (checkFields() == true) {
                    counter=0;
                    String un = usernameInput.getText().toString();
                    String pw= pwdInput.getText().toString();


                    Toast.makeText(CreateAccountActivity.this, "Account created successfuly.", Toast.LENGTH_SHORT).show();  //we good
                    db.userDao().addUser(new User(un,pw));
                    //long blah = db.entertainerDao().addEntertainer(new Entertainer("The Hernandez Boys", pundt.getId()));
                    AlertDialog alertDialog = new AlertDialog.Builder(CreateAccountActivity.this).create();
                    alertDialog.setTitle("Success");
                    alertDialog.setMessage("Account has been created");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    finish();
                                }
                            });
                    alertDialog.show();

                }
                if(counter>1){
                    counter=0;
                    finish();
                }

                System.out.println("WHATUP GGGGGGG");  //testing purposes
            }
        });
    }


    public boolean checkAlpha(String x) {
        boolean isAlpha =false;
        int counter =0;
        for (int i = 0; i < x.length(); i++) {
            char charAt2 = x.charAt(i);
            if (Character.isLetter(charAt2)) {
                counter++;
            }
        }
        if (counter>=3) {
            isAlpha = true;
        }
        return isAlpha;
    }

    public boolean hasNumber(String z){

        for (int i = 0; i < z.length(); i++) {
            if (!Character.isDigit(z.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFields() {          // try-catch for bad inputs
        Boolean flag = false;
        String tempUserNameIn = usernameInput.getText().toString();
        String tempPasswordIn = pwdInput.getText().toString();


        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher u = p.matcher(tempUserNameIn);
        Matcher pw = p.matcher (tempPasswordIn);
        boolean x = u.find();
        boolean y = pw.find();
        List<String> allUsers = db.userDao().getAllUsernames();

        for (int i = 0; i < allUsers.size(); i++) {
            if (tempUserNameIn.equals(allUsers.get(i))==true){
                flag=false;
            }
        }



        try{
            //Integer cypherBy = Integer.parseInt(shiftValue.getText().toString());

            if(!pwdInput.getText().toString().isEmpty() || !usernameInput.getText().toString().isEmpty()){  //checks for empty string
                flag= true;
            }
            else{
                Toast.makeText(this, R.string.emptyString, Toast.LENGTH_SHORT).show();
                return false;
            }

            if( x == true && y == true){  //checks for special characters.
                flag = true;
            }
            else{
                Toast.makeText(this, R.string.noSpecial, Toast.LENGTH_SHORT).show();
                return false;
            }

            if( checkAlpha(tempUserNameIn)==true && checkAlpha(tempPasswordIn) == true){  //checks for >=3 alpha chars.
                flag = true;
            }
            else{
                Toast.makeText(this, R.string.moarAlpha, Toast.LENGTH_SHORT).show();
                return false;
            }

            if( hasNumber(tempPasswordIn)==true && hasNumber(tempUserNameIn) == true){  //checks for >=3 alpha chars.
                flag = true;
            }
            else{
                Toast.makeText(this, R.string.nonum, Toast.LENGTH_SHORT).show();
                return false;
            }
            if(flag == false){
                return false;
            }

        }
        catch(Exception e){
            Toast.makeText(this, R.string.wrongInput, Toast.LENGTH_SHORT).show();
            return false;
        }
        return flag;

    }


}
