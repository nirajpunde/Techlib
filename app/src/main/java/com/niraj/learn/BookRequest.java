package com.niraj.learn;

/**
 * Created by niraj on 8/10/17.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BookRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://niraj123.000webhostapp.com/contrib.php";
    private Map<String,String> params;

    public BookRequest(String subject, String bookname, String author, String publisher, String edition,String link,String contributer,Response.Listener<String> listener){

        super(Method.POST , REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("subject",subject);
        params.put("bookname",bookname);
        params.put("author",author);
        params.put("publisher",publisher);
        params.put("edition",edition);
        params.put("link",link);
        params.put("contributer",contributer);
        //Incase of an integer(say age) use : params.put("age",age+"");
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
