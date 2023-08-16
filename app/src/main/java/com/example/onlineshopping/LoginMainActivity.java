package com.example.onlineshopping;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.onlineshopping.databinding.LoginMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMainActivity extends AppCompatActivity {

  EditText email,password;
  Button login;
  TextView newUser;
  DBHelper DB;

    private static final String EMAIL_PATTERN =
            "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        email = findViewById(R.id.textEditTextEmail);
        password = findViewById(R.id.textEditTextPass);
        login = findViewById(R.id.logInButton);

        newUser = findViewById(R.id.textView3);

        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
                String Password = password.getText().toString();

                if(email.equals("")||password.equals("")){

                    if (isValidEmail(Email)) {
                        // Email is valid, proceed with registration
                    } else {
                        // Invalid email, show an error message
                        Toast.makeText(LoginMainActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(LoginMainActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();


                }
                else{
                    Boolean checkEmailPass = DB.checkEmailPassword(Email,Password);

                    if(checkEmailPass==true){



                        Toast.makeText(LoginMainActivity.this, "SignIn successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),home.class);
                        startActivity(intent);

                    }else{

                        Toast.makeText(LoginMainActivity.this, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newUserIntent =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(newUserIntent);

            }
        });


    }
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}