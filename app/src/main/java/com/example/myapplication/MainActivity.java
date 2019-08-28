package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private Event eventgetRequest() {
        final Event event= new Event();
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            String URL = "http://localhost:8090/events";
            JSONObject jsonBody = new JSONObject();

            jsonBody.put("email", "abc@abc.com");
            jsonBody.put("password", "");
            jsonBody.put("user_type", "");
            jsonBody.put("company_id", "");
            jsonBody.put("status", "");

            JsonArrayRequest jsonOblect = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                    for(int i=0;i<response.length();i++)
                    {


                        // Get current json object

                            JSONObject resp = response.getJSONObject(i);

                        event.setUsername(resp.getString("Username"));
                        event.setEvent_date(formatter.parse(resp.getString("Event_date")));
                        event.setDeadline_to_applay(formatter.parse(resp.getString("Deadline_to_applay")));
                        event.setPrice(Integer.parseInt((resp.getString("Price"))));
                        event.setFormateur_linkedin_url(resp.getString("Formateur_linkedin_url"));
                    }
                    // Toast.makeText(getApplicationContext(), "Response:  " + response.toString(), Toast.LENGTH_SHORT).show();
                }catch(JSONException e){e.printStackTrace();} catch (ParseException e) {
                        e.printStackTrace();
                    }
            }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        Snackbar.make(
                                mCLayout,
                                "Error...",
                                Snackbar.LENGTH_LONG
                        ).show();
                    }
                }
                );
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    final Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + "c2FnYXJAa2FydHBheS5jb206cnMwM2UxQUp5RnQzNkQ5NDBxbjNmUDgzNVE3STAyNzI=");//put your token here
                    return headers;
                }
            };
           // VolleyApplication.getInstance().addToRequestQueue(jsonOblect);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();
        return  event ;
    }






















    private equipment equipmentgetRequest() {
        final equipment equipment= new equipment();
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        try {
            String URL = "http://localhost:8090/events";
            JSONObject jsonBody = new JSONObject();

            jsonBody.put("email", "abc@abc.com");
            jsonBody.put("password", "");
            jsonBody.put("user_type", "");
            jsonBody.put("company_id", "");
            jsonBody.put("status", "");

            JsonObjectRequest jsonOblect = new JsonObjectRequest(Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        equipment.setUsername(response.getString("Username"));
                        event.setEvent_date(formatter.parse(response.getString("Event_date")));
                        event.setDeadline_to_applay(formatter.parse(response.getString("Deadline_to_applay")));
                        event.setPrice(Integer.parseInt((response.getString("Price"))));
                        event.setFormateur_linkedin_url(response.getString("Formateur_linkedin_url"));
                    } catch(JSONException e){e.printStackTrace();} catch (ParseException e) {
                        e.printStackTrace();
                    }
                    // Toast.makeText(getApplicationContext(), "Response:  " + response.toString(), Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    onBackPressed();

                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    final Map<String, String> headers = new HashMap<>();
                    headers.put("Authorization", "Basic " + "c2FnYXJAa2FydHBheS5jb206cnMwM2UxQUp5RnQzNkQ5NDBxbjNmUDgzNVE3STAyNzI=");//put your token here
                    return headers;
                }
            };
            // VolleyApplication.getInstance().addToRequestQueue(jsonOblect);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();
        return  event ;
    }


















}

