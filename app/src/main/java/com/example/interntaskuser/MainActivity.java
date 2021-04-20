package com.example.interntaskuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    TextView login;
    EditText name, number, mail, passwordm, confirm;
    String _name,_number,_mail,_password,_confirm;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        name = findViewById(R.id.edttxt_name);
        number=findViewById(R.id.edttxt_number);
        mail=findViewById(R.id.edttxt_email);
        passwordm=findViewById(R.id.edttxt_password);
        confirm=findViewById(R.id.edttxt_confirm_password);
        register= findViewById(R.id.regbutton);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatedata();
                Intent i =  new Intent(MainActivity.this,Login.class);
                startActivity(i);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
    }

    private void validatedata() {
        _name=name.getText().toString();
        _number=number.getText().toString();
        _mail = mail.getText().toString();
        _password = passwordm.getText().toString();
        _confirm=confirm.getText().toString();
        if (TextUtils.isEmpty(_name))
        {
            Toast.makeText(this, "Name is Required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(_number))
        {
            Toast.makeText(this, "Number is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(_mail))
        {
            Toast.makeText(this, "Mail is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(_password))
        {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(_confirm))
        {
            Toast.makeText(this, "Category is required", Toast.LENGTH_SHORT).show();
        }
        else if (!_confirm.equals(_password))
        {
            Toast.makeText(this, "Confirm Password is not matched", Toast.LENGTH_SHORT).show();
        }
        else{

            storeNewUserData();
        }

    }

    private void storeNewUserData() {

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");


        User addnewUser = new User(_name,_mail,_password);
        reference.child(_number).setValue(addnewUser);
        Toast.makeText(MainActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
    }
}