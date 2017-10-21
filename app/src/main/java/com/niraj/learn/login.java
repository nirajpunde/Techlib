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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v)
    {
        final EditText etUsername = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);


        final String username = etUsername.getText().toString();
        final String password = etPassword.getText().toString();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                    JSONArray jsonResponse = new JSONArray(response);
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                    int success = jsonResponse.getJSONObject(0).getInt("uid");
                    Toast.makeText(getApplicationContext(),success+" ",Toast.LENGTH_LONG).show();
                    if (success!=0) {
                        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                        String fname = jsonResponse.getJSONObject(0).getString("fname");
                        String lname = jsonResponse.getJSONObject(0).getString("lname");


                        Intent intent = new Intent(login.this,user_area.class);
                        intent.putExtra("fname",fname);
                        intent.putExtra("lname",lname);
                        intent.putExtra("username",username);
                        login.this.startActivity(intent);
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                        builder.setMessage("login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        LoginRequest loginRequest = new LoginRequest(username, password,responseListener);
        RequestQueue queue = Volley.newRequestQueue(login.this);
        queue.add(loginRequest);

    }


}
