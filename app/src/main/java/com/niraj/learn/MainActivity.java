package com.niraj.learn;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.niraj.learn.dummy.UserModel;

import org.json.JSONException;
import org.json.JSONObject;


import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etfname = (EditText) findViewById(R.id.fname);
        final EditText etlname = (EditText) findViewById(R.id.lname);
        final EditText etUsername = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);

    }
    public void jump_login(View v)
    {
        Intent intent= new Intent(MainActivity.this,login.class);
        startActivity(intent);
    }

    public void sign_up(View v)
    {
        final EditText etfname = (EditText) findViewById(R.id.fname);
        final EditText etlname = (EditText) findViewById(R.id.lname);
        final EditText etUsername = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);

        final String fname = etfname.getText().toString();
        final String lname = etlname.getText().toString();
        final String username = etUsername.getText().toString();
        final String password = etPassword.getText().toString();

        UserModel userModel=new UserModel(fname,lname,username,password);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        Intent intent = new Intent(MainActivity.this, login.class);
                        MainActivity.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Register Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        if (userModel.isValid()==5) {
            RegisterRequest registerRequest = new RegisterRequest(fname, lname, username, password, responseListener);
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            queue.add(registerRequest);

        }
        else if (userModel.isValid()==1)
        {
            Toast.makeText(getApplicationContext(),"Please Enter First name",Toast.LENGTH_SHORT).show();
        }
        else if (userModel.isValid()==2)
        {
            Toast.makeText(getApplicationContext(),"Please Enter Last name",Toast.LENGTH_SHORT).show();
        }

        else if (userModel.isValid()==3)
        {
            Toast.makeText(getApplicationContext(),"Username should be 5 character long",Toast.LENGTH_SHORT).show();
        }
        else if (userModel.isValid()==4)
        {
            Toast.makeText(getApplicationContext(),"Password should be 5 character long",Toast.LENGTH_SHORT).show();
        }

    }
    public void skip(View v)
    {
        Intent intent = new Intent(this,View_all.class);
        startActivity(intent);
    }

}
