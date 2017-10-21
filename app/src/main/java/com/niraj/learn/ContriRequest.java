package com.niraj.learn;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraj on 12/10/17.
 */

public class ContriRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "https://niraj123.000webhostapp.com/mycontri.php";
    private Map<String, String> params;

    public ContriRequest(String username,Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username",username);

    };

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
