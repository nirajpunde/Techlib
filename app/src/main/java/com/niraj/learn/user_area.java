package com.niraj.learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class user_area extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        ListView mainListView = (ListView) findViewById( R.id.menulist );
        final Intent intent = getIntent();
        String fname=intent.getStringExtra("fname");
        String lname=intent.getStringExtra("lname");
        final String username = intent.getStringExtra("username");

        Toast.makeText(getApplicationContext(),"welcome"+fname+lname+"",Toast.LENGTH_LONG).show();

        String[] menu={"Contribute","My Contribution","View by subject","View all"};
        ArrayList<String> menulist= new ArrayList<String>();
        menulist.addAll(Arrays.asList(menu));
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menulist);
        mainListView.setAdapter(arrayAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0)
                {
                    Intent intent1 = new Intent(user_area.this,Contrib.class);
                    intent1.putExtra("username",username);
                    startActivity(intent1);
                }
                if(i==1)
                {

                    //Toast.makeText(getApplicationContext(),"my contribution is under progress",Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(getApplicationContext(),user_contri.class);
                    intent4.putExtra("username",username);
                    startActivity(intent4);

                }

                if(i==2)
                {
                    //Toast.makeText(getApplicationContext(),"view by subject is under progress",Toast.LENGTH_SHORT).show();
                    Intent intent6 =new Intent(getApplicationContext(),list_of_sub.class);
                    intent6.putExtra("username",username);
                    startActivity(intent6);
                }
                if(i==3)
                {
//                    Toast.makeText(getApplicationContext(),"my contribution is under progress",Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(user_area.this,View_all.class);
                    startActivity(intent3);
                }
            }
        });
    }

}
