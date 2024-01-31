package com.example.healthcare24_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edusername,edemail,edpassword,edpasswordConfirm;
    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edusername = findViewById(R.id.editTextAppFulName);
        edpassword = findViewById(R.id.editTextAppContactNumber);
        edpasswordConfirm = findViewById(R.id.editTextAppFees);
        edemail = findViewById(R.id.editTextAppAddress);
        button = findViewById(R.id.buttonBookAppointment);
        tv = findViewById(R.id.textView3);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = edusername.getText().toString();
                String password  = edpassword.getText().toString();
                String email  = edemail.getText().toString();
                String passwordConfirm  = edpasswordConfirm.getText().toString();

                Database db = new Database(getApplicationContext(),"healthcare",null,1);

                if(username.length()==0 || password.length()==0 || email.length()==0 || passwordConfirm.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All Details",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(passwordConfirm)==0){
                        if(isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(),"Password must have atleast 8 characters having letters, digits and special characters",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"Passwords Did Not Match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static Boolean isValid(String passwordhere){
        int f1=0 ,f2=0, f3=0;
        if(passwordhere.length() < 8){
            return false;
        }else{
            for(int p=0; p<passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0; r<passwordhere.length(); r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0; s<passwordhere.length(); s++){
                char c = passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}