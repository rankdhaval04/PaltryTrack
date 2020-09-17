package paltrytrack.maker.paltrytrack;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    int d=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final EditText etaddress = (EditText) findViewById(R.id.etaddress);
        final EditText etphone = (EditText) findViewById(R.id.phone3);
        final EditText area=(EditText)findViewById(R.id.area);
        final EditText city=(EditText)findViewById(R.id.city);
        final EditText pincode=(EditText)findViewById(R.id.pincode);
        final Button bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());
                final String password = etPassword.getText().toString();
                final String address = etaddress.getText().toString();
                final String phone = etphone.getText().toString();
                final String area1 = area.getText().toString();
                final String city1 = city.getText().toString();
                final String pincode1 = pincode.getText().toString();

                if(name.length()==0)
                {
                    etName.requestFocus();
                    etName.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }

                if(area.length()==0)
                {
                    area.requestFocus();
                    area.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }

                if(password.length()==0||password.length()<6)
                {
                    etPassword.requestFocus();
                    etPassword.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }

                if(address.length()==0)
                {
                    etaddress.requestFocus();
                    etaddress.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }

                if(phone.length()==0||phone.length()!=10)
                {
                    etphone.requestFocus();
                    etphone.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }
                if(city.length()==0)
                {
                    city.requestFocus();
                    city.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }
                if(pincode.length()==0||pincode.length()!=6)
                {
                    pincode.requestFocus();
                    pincode.setError("FIELD CANNOT BE EMPTY");
                    d++;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(Register.this, login.class);
                                Register.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                if(d==0) {
                    RegisterRequest registerRequest = new RegisterRequest(name, password, age, address, phone, area1, city1, pincode1, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Register.this);
                    queue.add(registerRequest);
                }
            }
        });
    }
}

