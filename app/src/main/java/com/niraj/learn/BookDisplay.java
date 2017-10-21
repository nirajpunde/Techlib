package com.niraj.learn;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BookDisplay extends AppCompatActivity {

    TextView tvbookname;
    TextView tvsubject ;
    TextView tvpublisher;
    TextView tvedition;
    TextView tvauthor ;
    TextView tvcontributer;
    BookModel book;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_display);


        TextView tvbookname = (TextView)findViewById(R.id.bookname);
        TextView tvsubject = (TextView)findViewById(R.id.subject);
        TextView tvpublisher = (TextView)findViewById(R.id.publisher);
        TextView tvedition = (TextView)findViewById(R.id.edition);
        TextView tvauthor = (TextView)findViewById(R.id.author);
        TextView tvcontributer = (TextView)findViewById(R.id.contributer);


        book = (BookModel) getIntent().getSerializableExtra("obj");

        tvbookname.setText(book.getBookname());
        tvsubject.setText(book.getSubject());
        tvauthor.setText(book.getAuthor());
        tvedition.setText(book.getEdition());
        tvpublisher.setText(book.getPublisher());
        tvcontributer.setText(book.getContributer());

        link=book.getLink();


    }

    public void download_book(View v)
    {
        try{
            Intent i = new Intent(Intent.ACTION_VIEW , Uri.parse(link));
            startActivity(i);
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Invalid Link",Toast.LENGTH_SHORT).show();
        }

    }
}
