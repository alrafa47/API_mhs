package com.alrafa47.api_datamhs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RequestQueue Requestqueue;
    private String TEMP_URL = "http://192.168.43.196/mobile_api/list_json_mhs.php";
    private TextView txtnpm, txtnama;
    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnpm = findViewById(R.id.tv_npm);
        txtnama = findViewById(R.id.tv_nama);

getData();
    }
    public void getData(){
        list_data = new ArrayList<HashMap<String, String>>();
        Requestqueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, TEMP_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("iki respone"+response);
                try {
                    JSONObject jsonPost = new JSONObject(response);
                    JSONArray jsonArray = jsonPost.getJSONArray("list_info");

                    for (int a = 0; a < jsonArray.length(); a ++){
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map  = new HashMap<String, String>();
                        map.put("npm", json.getString("npm"));
                        map.put("nama", json.getString("nama"));
                        list_data.add(map);
                    }
                    txtnpm.setText(list_data.get(0).get("npm"));
                    txtnama.setText(list_data.get(0).get("nama"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Iki eror e : "+error);
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}





