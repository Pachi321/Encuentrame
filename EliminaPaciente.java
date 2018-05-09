package com.example.root.encuentrame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class EliminaPaciente extends AppCompatActivity {
    public static final String EmployeeNamearray = "aliasp";
    public static final String JSON_ARRAY = "result";
    private JSONArray result;
    Spinner spinner;
    String  aliasp;
    Button btn_eliminapaciente, btn_volver;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina_paciente);
        spinner= (Spinner) findViewById(R.id.sp_alias);
        btn_eliminapaciente = findViewById( R.id.btn_eliminapaciente );
        btn_volver = findViewById( R.id.btn_volver );
        arrayList = new ArrayList<String>();
        getdata();

        btn_volver.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentReg = new Intent( EliminaPaciente.this, Registros.class );
                EliminaPaciente.this.startActivity( intentReg );

            }
        } );

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void getdata() {
        StringRequest stringRequest = new StringRequest("http://encuentrame.solucionesjkj.cl/consulta_alias.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray(JSON_ARRAY);
                            empdetails(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void empdetails(JSONArray j) {
        for (int i = 0; i < j.length(); i++) {
            try {
                JSONObject json = j.getJSONObject(i);
                arrayList.add(json.getString(EmployeeNamearray));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        spinner.setAdapter(new ArrayAdapter<String>(EliminaPaciente.this, android.R.layout.simple_spinner_dropdown_item, arrayList));
    }

    private String getemployeeName(int position){
        String name="";
        try {

            JSONObject json = result.getJSONObject(position);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return name;
    }

    private String getmailid(int position){
        String mailid="";
        try {
            JSONObject json = result.getJSONObject(position);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mailid;
    }
}

