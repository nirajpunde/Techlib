package com.niraj.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
    }


    public void toc(View v)
    {
        Intent intent = new Intent(getApplicationContext(),SubjectList.class);
        intent.putExtra("subject","toc");
        startActivity(intent);
    }
    public void dbms(View v)
    {
        Intent intent = new Intent(getApplicationContext(),SubjectList.class);
        intent.putExtra("subject","dbms");
        startActivity(intent);
    }
    public void isee(View v)
    {
        Intent intent = new Intent(getApplicationContext(),SubjectList.class);
        intent.putExtra("subject","isee");
        startActivity(intent);
    }
    public void softengg(View v)
    {
        Intent intent = new Intent(getApplicationContext(),SubjectList.class);
        intent.putExtra("subject","softengg");
        startActivity(intent);
    }
    public void networks(View v)
    {
        Intent intent = new Intent(getApplicationContext(),SubjectList.class);
        intent.putExtra("subject","networks");
        startActivity(intent);
    }
}
