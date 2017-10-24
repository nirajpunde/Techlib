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
import com.niraj.learn.dummy.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import static com.niraj.learn.R.id.author;
import static com.niraj.learn.R.id.bookname;
import static com.niraj.learn.R.id.subject;
import static com.niraj.learn.R.id.username;

public class Contrib extends AppCompatActivity {
     EditText etsubject;
     EditText etbookname;
     EditText etauthor;
     EditText etpublisher;
     EditText etedition;
     EditText etlink;

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrib);


        user=getIntent().getStringExtra("username");

        etsubject = (EditText)findViewById(R.id.subject);
        etbookname = (EditText)findViewById(R.id.bookname);
        etauthor = (EditText)findViewById(R.id.author);
        etpublisher = (EditText)findViewById(R.id.publisher);
        etedition = (EditText)findViewById(R.id.edition);
        etlink = (EditText)findViewById(R.id.link);

    }

    public void add_book(View v)
    {


        final String subject_str =  etsubject.getText().toString();
        final String bookname_str =  etbookname.getText().toString();
        final String author_str =  etauthor.getText().toString();
        final String publisher_str =  etpublisher.getText().toString();
        final String edition_str =  etedition.getText().toString();
        final String link_str =  etlink.getText().toString();

        Validator val=new Validator(bookname_str,subject_str,author_str,edition_str,publisher_str,link_str,user);

        Response.Listener<String> responseListener = new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(Contrib.this, response, Toast.LENGTH_LONG).show();
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        Intent index = new Intent(Contrib.this , user_area.class);
                        index.putExtra("username",user);
                        Contrib.this.startActivity(index);
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Contrib.this);
                        builder.setMessage("Registration Failed")
                                .setNegativeButton("Retry",null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        if(val.isvalid())
        {
            BookRequest bookRequest = new BookRequest(subject_str,bookname_str,author_str,publisher_str,edition_str,link_str,user,responseListener);
            RequestQueue queue = Volley.newRequestQueue(Contrib.this);
            queue.add(bookRequest);
            Toast.makeText(getApplicationContext(),"Book Added Succesfully",Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid data entered",Toast.LENGTH_SHORT).show();
        }


    }





}
