package com.niraj.learn;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraj on 12/10/17.
 */

public class DeleteRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "https://niraj123.000webhostapp.com/delete.php";
    private Map<String, String> params;

    public DeleteRequest(Integer id,Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("book_id",id+"");

    };

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
