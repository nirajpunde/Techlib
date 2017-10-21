package com.niraj.learn.dummy;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraj on 13/10/17.
 */

public class SubjectRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "https://niraj123.000webhostapp.com/sublistbook.php";
    private Map<String, String> params;

    public SubjectRequest(String subject,Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("subject",subject);

    };

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
