package com.example.root.encuentrame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText tv_no, tv_ru, tv_cl;
    Button bt_re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registro );

        tv_no= findViewById(R.id.tv_no);
        tv_ru= findViewById(R.id.tv_ru);
        tv_cl= findViewById(R.id.tv_cl);

        bt_re= findViewById(R.id.bt_re);

        bt_re.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        final String nombre=tv_no.getText().toString();
        final String rut=tv_ru.getText().toString();
        final String clave=tv_cl.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRespose = new JSONObject( response );
                    boolean success= jsonRespose.getBoolean( "success" );


                    if(success){
                        Intent intent = new Intent( Registro.this,MainActivity.class );
                        Registro.this.startActivity( intent );
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this );
                        builder.setMessage( "Error al registrar" )
                                .setNegativeButton( "Retry",null )
                                .create().show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterRequest registerRequest= new RegisterRequest( nombre, rut, clave, respoListener);
        RequestQueue queue = Volley.newRequestQueue( Registro.this );
        queue.add( registerRequest );

    }


}

