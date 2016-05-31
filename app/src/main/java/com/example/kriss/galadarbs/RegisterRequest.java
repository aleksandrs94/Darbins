package com.example.kriss.galadarbs;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;
import java.net.URL;

/**
 * Created by LIZDA on 28-May-16.
 */
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://galadarbs.netau.net/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String surname, String email, String password, int phone, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("surname", surname);
        params.put("email", email);
        params.put("password", password);
        params.put("phone", phone + "");

    }



    @Override
    public  Map<String, String> getParams(){
        return params;
    }
}
