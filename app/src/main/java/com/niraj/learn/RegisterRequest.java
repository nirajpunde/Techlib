package com.niraj.learn;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by niraj on 25/9/17.
 */

public class RegisterRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "https://niraj123.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String fname, String lname, String username, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("fname", fname);
        params.put("lname", lname);
        params.put("username", username);
        params.put("password", password);
    };

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
