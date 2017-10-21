package com.niraj.learn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraj on 26/9/17.
 */

public class ListRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://niraj123.000webhostapp.com/View_all.php";
    private Map<String, String> params;

    public ListRequest(Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();

    };

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
