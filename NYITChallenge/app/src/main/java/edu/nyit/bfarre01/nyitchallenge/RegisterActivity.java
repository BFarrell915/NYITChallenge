package edu.nyit.bfarre01.nyitchallenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class RegisterActivity extends Activity {
    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Parse.initialize(this, "APPLICATION ID", "CLIENT KEY");

        //initialize
        mUsername = (EditText) findViewById(R.id.usernameRegisterEditText);
        mUserEmail = (EditText) findViewById(R.id.emailRegisterEditText);
        mUserPassword = (EditText) findViewById(R.id.passwordRegisterEditText);
        mRegisterButton = (Button) findViewById(R.id.registerButton);

        //listen to register button click
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            //Covert user to string
            String username = mUsername.getText().toString().trim();
            String email = mUserEmail.getText().toString().trim();
            String password = mUserPassword.getText().toString().trim();

            //Store users in parse
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                            //user signed up successfully
                            Toast.makeText(RegisterActivity.this, "Success! Welcome", Toast.LENGTH_LONG).show();
                            //take user to Login Page
                        } else {
                            //There was an error signing up
                        }
                    }
                });
            }
        });
    }


        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.menu_register, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
            //Handle action bar item clicks here. The action bar will
            //automatically handle clicks on the Home/Up button, so long
            //as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

        public void startLogin(View view) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
