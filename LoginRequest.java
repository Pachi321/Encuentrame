package com.example.root.encuentrame;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL="http://encuentrame.solucionesjkj.cl/login.php";
    private Map<String,String> params;


    LoginRequest(String usuario, String clave, Response.Listener<String> listener){
        super (Method.POST,LOGIN_REQUEST_URL,listener,null);


        params=new HashMap<>(  );
        params.put( "usuario",usuario );
        params.put( "clave",clave );

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

