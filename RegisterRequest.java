package com.example.root.encuentrame;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://encuentrame.solucionesjkj.cl/guardapp.php";
    private Map<String,String> params;
    RegisterRequest(String usuario, String rut, String clave, Response.Listener<String> listener){
        super (Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>(  );

        params.put( "usuario",usuario );
        params.put( "rut",rut );
        params.put( "clave",clave );
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

