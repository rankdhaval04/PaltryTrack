package paltrytrack.maker.paltrytrack;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class editprofile extends AppCompatActivity {

    String urladdress="http://192.168.43.199/displayprofilec.php";
    String urladdress1="http://192.168.43.199/updateprofilec.php";
    BufferedInputStream is;
    String line=null;
    String result=null;
    String co;
    int id;
    EditText etName,etPassword,etArea,etaddress,etphone,etcity,etpincode;
    Button b;
    String name1,password1,area1,address1,phone1,city1,pincode1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        co=getIntent().getStringExtra("contact");

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etArea= (EditText) findViewById(R.id.etArea);
        etaddress = (EditText) findViewById(R.id.etaddress);
        etphone = (EditText) findViewById(R.id.phone3);
        etcity = (EditText) findViewById(R.id.etcity);
        etpincode = (EditText) findViewById(R.id.pincode);
        b=(Button)findViewById(R.id.b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1=etName.getText().toString();
                password1=etPassword.getText().toString();
                area1=etArea.getText().toString();
                address1=etaddress.getText().toString();
                phone1=etphone.getText().toString();
                city1=etcity.getText().toString();
                pincode1=etpincode.getText().toString();

                collectData1();
            }
        });

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
    }
    private void collectData()
    {
//Connection
        try{

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("dh", co);
            String query = builder.build().getEncodedQuery();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            con.connect();

            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }

//JSON
        try{
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                etName.setText(jo.getString("name"));
                etArea.setText(jo.getString("area"));
                etPassword.setText(jo.getString("password"));
                etaddress.setText(jo.getString("address"));
                etphone.setText(jo.getString("contect"));
                etcity.setText(jo.getString("city"));
                etpincode.setText(jo.getString("pincode"));
                id=Integer.parseInt(jo.getString("id"));
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }

    private void collectData1()
    {
//Connection
        try{

            URL url=new URL(urladdress1);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("name", name1)
                    .appendQueryParameter("area", area1)
                    .appendQueryParameter("password", password1)
                    .appendQueryParameter("address", address1)
                    .appendQueryParameter("contect", phone1)
                    .appendQueryParameter("city", city1)
                    .appendQueryParameter("pincode", pincode1)
                    .appendQueryParameter("dh", id+"");
            String query = builder.build().getEncodedQuery();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            con.connect();

            is=new BufferedInputStream(con.getInputStream());

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        //content
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception ex)
        {
            ex.printStackTrace();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id3 = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id3 == android.R.id.home) {
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
