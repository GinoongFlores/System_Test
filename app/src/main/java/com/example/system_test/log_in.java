package com.example.system_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class log_in extends AppCompatActivity implements View.OnClickListener {

    TextView tvSignUp;
    EditText etEmail,etPassword;
    Button btnLogIn;


    AccountDatabaseHelper accountDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

    accountDatabaseHelper = new AccountDatabaseHelper(this);


    etEmail = findViewById(R.id.etEmail);
    etPassword = findViewById(R.id.etPassword);



    btnLogIn = findViewById(R.id.btnLogin);
    btnLogIn.setOnClickListener(this);

    tvSignUp = findViewById(R.id.tvSignUp);
    tvSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                if(accountDatabaseHelper.checkUser(email,password) == true){
                    Intent i = new Intent(log_in.this,home.class);
                    startActivity(i);
                }else{
                    Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tvSignUp:
                Intent ii = new Intent(log_in.this,sign_up.class);
                startActivity(ii);
                break;
        }
    }
}