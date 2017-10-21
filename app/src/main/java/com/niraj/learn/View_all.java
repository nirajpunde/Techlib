package com.niraj.learn;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.niraj.learn.R.id.parent;
import static com.niraj.learn.R.styleable.View;

public class View_all extends AppCompatActivity {

    MyAdapter adapter;
    ListView listView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_all);

        // 1. pass context and data to the custom adapter
        adapter = new MyAdapter(this, generateData());

        listView = (ListView) findViewById(R.id.listview);
        //2. setListAdapter
        listView.setAdapter(adapter);
//        setListAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                        BookModel clickedobj = adapter.getItem(i);
                        Toast.makeText(View_all.this,"you have clicked"+clickedobj.getBookname(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(View_all.this,BookDisplay.class);
                        intent.putExtra("obj",clickedobj);
                        startActivity(intent);

                    }
                }
        );


    }


    private ArrayList<BookModel> generateData() {
        final ArrayList<BookModel> BookModelslist = new ArrayList<BookModel>();
//        BookModels.add(new BookModel("python 1","pyhton"));
//        BookModels.add(new BookModel("django 2","webdev"));
//        BookModels.add(new BookModel("php 3","webdev"));
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    JSONArray jsonResponse = new JSONArray(response);
                    int lenght = jsonResponse.length();
                    Toast.makeText(getApplicationContext(), "" + lenght, Toast.LENGTH_LONG).show();

                    if (jsonResponse.length() > 0) {
                        for (int i = 0; i < jsonResponse.length(); i++) {
                            JSONObject temp = jsonResponse.getJSONObject(i);
                            //Toast.makeText(getApplicationContext(),temp.toString(),Toast.LENGTH_LONG).show();
                            String bname = temp.getString("book_name");
                            String sub = temp.getString("subject");
                            String author = temp.getString("author");
                            String publisher = temp.getString("publisher");
                            String edition = temp.getString("edition");
                            String link = temp.getString("link");
                            String contributer = temp.getString("contributer");
                            //Toast.makeText(getApplicationContext(), bname, Toast.LENGTH_LONG).show();
                            BookModel buf = new BookModel(bname, sub,author,edition,publisher,link,contributer);
                            BookModelslist.add(buf);

                        }
                        adapter.notifyDataSetChanged();

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(View_all.this);
                        builder.setMessage("fetching activity failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        };

        ListRequest listRequest = new ListRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(listRequest);


        return BookModelslist;
    }
}
