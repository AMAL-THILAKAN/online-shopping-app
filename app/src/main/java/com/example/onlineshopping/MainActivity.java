package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText username,password,email,confPassword;
    Button registerBtn;
    TextView alreadyBtn;
     DBHelper DB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.textEditTextName);
        email = findViewById(R.id.textEditTextEmail);
        password = findViewById(R.id.textEditTextPass);
        confPassword = findViewById(R.id.textEditTextConfirmPass);
        registerBtn = findViewById(R.id.registerButton);
        alreadyBtn = findViewById(R.id.haveAnAcc);

        DB = new DBHelper (this);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String user = username.getText().toString();
            String Email = email.getText().toString();
            String pass = password.getText().toString();
            String conPass = confPassword.getText().toString();

            if(user.equals("")||Email.equals("")||pass.equals("")||conPass.equals("")){
                Toast.makeText(MainActivity.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
            }else{
                if(pass.equals(conPass)){
                    Boolean checkUser = DB.checkUsername(user);
                    if(checkUser == false){
                        Boolean insert = DB.insertData(user,Email,pass);
                        if(insert == true){
                            Toast.makeText(MainActivity.this,"Registered successfully ",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginMainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "user already exists", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "password ar not same", Toast.LENGTH_SHORT).show();
                }
            }


            }
        });

        alreadyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent alreadyIntent = new Intent(getApplicationContext(),LoginMainActivity.class);
                startActivity(alreadyIntent);

            }
        });



    }

}