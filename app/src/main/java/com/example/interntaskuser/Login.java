package com.example.interntaskuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button login;
    EditText number,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.loginbutton);
        number = findViewById(R.id.edttxt_email1);
        password = findViewById(R.id.edttxt_password1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logintouser();

            }
        });
    }
    private void Logintouser()
    {
        String _password=password.getText().toString();
        String _number = number.getText().toString();


        if(number.getText().toString().contentEquals(""))
        {
            Toast.makeText(Login.this, "Please type your Number", Toast.LENGTH_SHORT).show();
        }
        else if (password.getText().toString().contentEquals(""))
        {
            Toast.makeText(Login.this, "Please type your Password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            /*loadingbar.setMessage("Please Wait..");
            loadingbar.setTitle("Login Account");
            loadingbar.setCancelable(false);
            loadingbar.show();*/


            Query checkuser = FirebaseDatabase.getInstance().getReference("Users").child(_number);
            checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot.exists()){


                        String systempassword = snapshot.child("password").getValue(String.class);


                        if (systempassword.equals(_password)){

                            Intent intent = new Intent(Login.this,Home.class);



                            startActivity(intent);
                            finish();
                        }
                        else{

                            Toast.makeText(Login.this,"wrong password and mail",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {


                }
            });
        }
    }
}