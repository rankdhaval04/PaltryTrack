package paltrytrack.maker.paltrytrack;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        final EditText contect = (EditText) findViewById(R.id.contect);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);
        pref= getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);
        if (pref.contains("user") && pref.contains("pass")) {
            Intent intent = new Intent(login.this, dashboard.class);

            intent.putExtra("contact",pref.getString("user","000000") );
            Log.i("asas",pref.getString("user","000000"));
            login.this.startActivity(intent);
        }

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(login.this, Register.class);
                login.this.startActivity(registerIntent);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String contect1 = contect.getText().toString();
                final String password = etPassword.getText().toString();
                Log.i("name", password);

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("name1", password);
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("user", contect1);
                                editor.putString("pass", password);
                                editor.commit();
                                Intent intent = new Intent(login.this, dashboard.class);
                                intent.putExtra("contact", contect1);
                                login.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(contect1, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(login.this);
                Log.i("namesend", password);
                queue.add(loginRequest);
            }
        });
    }
}



//for LOGOUT BUTTON
//SharedPreferences.Editor editor = prf.edit();
//                editor.clear();
//                editor.commit();