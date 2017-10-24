package com.niraj.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.niraj.learn.dummy.SubjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SubjectList extends AppCompatActivity {

    ListView sublist;
    MyAdapter adapter;
    ArrayList<BookModel> list;
    String subject;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_list);

        
        sublist=(ListView)findViewById(R.id.sublist);

        subject=getIntent().getStringExtra("subject");
        username=getIntent().getStringExtra("username");

        //Toast.makeText(getApplicationContext(),subject,Toast.LENGTH_SHORT).show();

        list =generateData();
        // 1. pass context and data to the custom adapter
        adapter = new MyAdapter(this, list);

        sublist = (ListView) findViewById(R.id.sublist);
        //2. setListAdapter

        TextView empty = (TextView)findViewById(android.R.id.empty);

        sublist.setEmptyView(empty);
        sublist.setAdapter(adapter);




//        setListAdapter(adapter);

        sublist.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                        BookModel clickedobj = adapter.getItem(i);
                        //Toast.makeText(getApplicationContext(),"you have clicked"+clickedobj.getId()+"", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),BookDisplay.class);
                        intent.putExtra("obj",clickedobj);
                        intent.putExtra("username",username);
                        startActivity(intent);

                    }
                }
        );

    }

    private ArrayList<BookModel> generateData() {
        final ArrayList<BookModel> BookModelslist = new ArrayList<BookModel>();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
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
                            Integer id = temp.getInt("book_id");
                            //Toast.makeText(getApplicationContext(), bname, Toast.LENGTH_LONG).show();
                            BookModel buf = new BookModel(bname, sub,author,edition,publisher,link,contributer,id);
                            BookModelslist.add(buf);

                        }
                        adapter.notifyDataSetChanged();

                    } else {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//                        builder.setMessage("fetching activity failed")
//                                .setNegativeButton("Retry", null)
//                                .create()
//                                .show();
                        Toast.makeText(getApplicationContext(),"Error Occured",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        };

        SubjectRequest subjectRequest = new SubjectRequest(subject,responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(subjectRequest);


        return BookModelslist;
    }
    
    
}
