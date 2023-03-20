package com.example.system_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity implements View.OnClickListener {

    EditText etName,etEmail,etPassword;
    Button btnSignUp;

    AccountDatabaseHelper accountDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_u);

        accountDatabaseHelper = new AccountDatabaseHelper(this);


        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignup:
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(accountDatabaseHelper.signUp(name,email,password) == true){
                    Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(sign_up.this,log_in.class);
                    startActivity(i);
                }else{
                    Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }
}