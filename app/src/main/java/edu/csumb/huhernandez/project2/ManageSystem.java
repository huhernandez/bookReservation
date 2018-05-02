package edu.csumb.huhernandez.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class ManageSystem extends AppCompatActivity {
    public Button mLoginButton;
    public EditText mAdminUn;
    public EditText mAdminPw;
    public int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_system);

        mAdminUn = findViewById(R.id.adIdInput);
        mAdminPw= findViewById(R.id.adPwInput);
        mLoginButton= findViewById(R.id.mAdminLogin);



        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLogin()==true){
                    counter=0;
                    Intent intent = new Intent(ManageSystem.this,SystemGuts.class );
                    startActivity(intent);
                }
                if(counter > 0){
                    //end activity
                    counter=0;
                    finish();
                }
                else{

                    counter++;
                }
            }
        });

    }

    public boolean checkLogin(){
        Boolean flag = false;
        String tempAdId = mAdminUn.getText().toString();
        String tempAdPw = mAdminPw.getText().toString();
        String admincred="!admin2";

        try{
            if(Objects.equals(tempAdId, admincred) && Objects.equals(tempAdPw, admincred)) {
                return true;
            }
            else{
                Toast. makeText(this,R.string.notRight,Toast.LENGTH_SHORT).show();

            }
        }
        catch(Exception e){
            Toast.makeText(this, R.string.notRight, Toast.LENGTH_SHORT).show();
            flag = false;
        }
        return flag;
    }
}
