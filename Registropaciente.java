package com.example.root.encuentrame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registropaciente extends AppCompatActivity implements View.OnClickListener {
    EditText et_al ;
    RadioButton rb_chek ;
    Button bt_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registropaciente );


        et_al= findViewById(R.id.et_al);
        rb_chek= findViewById(R.id.rb_chek);

        bt_reg= findViewById(R.id.bt_reg);

        bt_reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

     String sxo = "";

        if (rb_chek.isChecked())
        {
            sxo = "F";
        }
        else
        {
            sxo = "M";
        }


        final String aliasp=et_al.getText().toString();
        final String sexo=sxo.toString();


        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRespose = new JSONObject( response );
                    boolean success= jsonRespose.getBoolean( "success" );


                    if(success){
                        Intent intent = new Intent( Registropaciente.this,MainActivity.class );
                        Registropaciente.this.startActivity( intent );
                    }else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registropaciente.this );
                        builder.setMessage( "Error al registrar" )
                                .setNegativeButton( "Retry",null )
                                .create().show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterRequest2 registerRequest2= new RegisterRequest2( aliasp, sexo, respoListener);
        RequestQueue queue = Volley.newRequestQueue( Registropaciente.this );
        queue.add( registerRequest2 );

    }


}


