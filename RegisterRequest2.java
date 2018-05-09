package com.example.root.encuentrame;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest2 extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://encuentrame.solucionesjkj.cl/paciente.php";
    private Map<String,String> params;
    RegisterRequest2(String aliasp, String sexo, String imei, String idusuariologin, Response.Listener<String> listener){
        super (Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>(  );

        params.put( "aliasp",aliasp );
        params.put( "sexo",sexo );
        params.put( "imei",imei );
        params.put( "idusuariologin",idusuariologin );
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

