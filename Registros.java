package com.example.root.encuentrame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registros extends AppCompatActivity {
    Button btn_regpa;
    TextView tv_no;
    TextView tv_idusuariologin;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registros );

        btn_regpa =findViewById( R.id.btn_regpa );
        tv_idusuariologin = findViewById( R.id.tv_idusuariologin );
        tv_no = findViewById( R.id.tv_no );

        
        Intent intent = getIntent();

        String idusuariologin = intent.getStringExtra( "idusuariologin" );

        tv_idusuariologin.setText( idusuariologin );

        


        btn_regpa.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentReg = new Intent( Registros.this, Registropaciente.class );
                Registros.this.startActivity( intentReg );

            }
        } );


    }


}

