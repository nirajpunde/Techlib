package com.niraj.learn;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class book_manage extends AppCompatActivity {

    TextView tvbookname;
    TextView tvsubject ;
    TextView tvpublisher;
    TextView tvedition;
    TextView tvauthor ;
    TextView tvcontributer;
    BookModel book;
    Integer id;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_manage);

        TextView tvbookname = (TextView)findViewById(R.id.bookname);
        TextView tvsubject = (TextView)findViewById(R.id.subject);
        TextView tvpublisher = (TextView)findViewById(R.id.publisher);
        TextView tvedition = (TextView)findViewById(R.id.edition);
        TextView tvauthor = (TextView)findViewById(R.id.author);
        TextView tvcontributer = (TextView)findViewById(R.id.contributer);


        book = (BookModel) getIntent().getSerializableExtra("obj");
        username=getIntent().getStringExtra("username");

        tvbookname.setText(book.getBookname());
        tvsubject.setText(book.getSubject());
        tvauthor.setText(book.getAuthor());
        tvedition.setText(book.getEdition());
        tvpublisher.setText(book.getPublisher());
        tvcontributer.setText(book.getContributer());

        id=book.getId();


    }


    public void delete_book(View v)
    {
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                    JSONObject jsonResponse = new JSONObject(response);
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                    boolean success = jsonResponse.getBoolean("success");
                    Toast.makeText(getApplicationContext(),success+" ",Toast.LENGTH_LONG).show();
                    if (success) {
                        Toast.makeText(getApplicationContext(),"book deleted sucessfully",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),user_area.class);
                        i.putExtra("username",username);
                        startActivity(i);

                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage("Delete Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        DeleteRequest deleteRequest = new DeleteRequest(id,responseListener);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(deleteRequest);




    }
}
