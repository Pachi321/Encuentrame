package com.example.root.encuentrame;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tv_registrar;
    TextView tv_idusuariologin;
    TextView tv_usuario;
    TextView tv_pass;
    Button   bt_entrar;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_registrar    =   findViewById(R.id.tv_registrar);
        tv_idusuariologin    =   findViewById(R.id.tv_idusuariologin);
        tv_usuario  =   findViewById( R.id.tv_usuario );
        tv_pass     =   findViewById( R.id.tv_pass );
        bt_entrar   =   findViewById( R.id.bt_entrar );


        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {

                Intent intentReg = new Intent(MainActivity.this, Registro.class );
                MainActivity.this.startActivity(intentReg);

            }
        });

        bt_entrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String usuario    = tv_usuario.getText().toString();
                final String clave      = tv_pass.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject( response );
                            boolean success = jsonResponse.getBoolean( "success" );

                            if(success){

                                String usuario = jsonResponse.getString( "usuario" );
                                String clave = jsonResponse.getString( "clave" );
                                String idusuariologin = jsonResponse.getString( "idusuariologin" );

                                Intent intent = new Intent( MainActivity.this, Registros.class );
                                intent.putExtra( "usuario",usuario );
                                intent.putExtra( "clave",clave );
                                intent.putExtra( "idusuariologin",idusuariologin );

                                MainActivity.this.startActivity( intent );


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this );
                                builder.setMessage( "Error al entrar" )
                                        .setNegativeButton( "Reintentar",null )
                                        .create().show();

                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                LoginRequest loginRequest = new LoginRequest( usuario,clave, responseListener );
                RequestQueue queue = Volley.newRequestQueue( MainActivity.this );
                queue.add( loginRequest );

            }
        } );


    }
}

