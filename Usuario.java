package com.example.root.encuentrame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {

    TextView tv_no , tv_cl ;
    TextView tv_idusuariologin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_usuario );

        tv_no = findViewById( R.id.tv_no );
        tv_cl = findViewById( R.id.tv_cl );

        Intent intent = getIntent();
        String usuario = intent.getStringExtra( "usuario" );
        String clave = intent.getStringExtra( "clave" );



        tv_no.setText( usuario );
        tv_cl.setText( clave );

    }
}

