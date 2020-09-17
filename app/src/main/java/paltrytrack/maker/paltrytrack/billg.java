package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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
import java.util.ArrayList;
import java.util.List;

public class billg extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SharedPreferences pref;

    String urladdress="http://192.168.43.199/myorders.php";
    String urladdress1="http://192.168.43.199/myorders3.php";
    String[] name;
    String[] price;
    String[] quantity;
    String[] id;
    int[] pric;
    int[] quantit;
    int[] tota;
    int finalprice,gst;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;
    String dh="gy",co,n;
    Button bill;
    TextView t6,gst1,change1,addresst1;
    Button Placeorder;
    String abs="Enter Address";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //co=getIntent().getStringExtra("contact");
        t6=(TextView)findViewById(R.id.t6);
        gst1=(TextView)findViewById(R.id.gst);
        change1=(TextView)findViewById(R.id.change);
        addresst1=(TextView)findViewById(R.id.addresst);
        Placeorder=(Button)findViewById(R.id.placeorder);

        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        co=pref.getString("user", "");

        abs = pref.getString("address", "" );
        if (pref.contains("address")) {
            addresst1.setText(abs);
        }


        listView=(ListView)findViewById(R.id.lview);

        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView1 customListView=new CustomListView1(this,name,pric,quantit,tota);
        listView.setAdapter(customListView);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collectData1();
                Intent in=new Intent(billg.this,dashboard.class);
                startActivity(in);

            }
        });
        // Spinner click listener


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Pick Up From Store");
        categories.add("Deliver To My Home");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(this);
        gst=(finalprice*18)/100;
        finalprice=finalprice+gst;
        t6.setText(String.valueOf(finalprice));
        gst1.setText(String.valueOf(gst));

        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(billg.this,address.class);
                startActivity(in);
            }
        });
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
            name=new String[ja.length()];
            price=new String[ja.length()];
            quantity=new String[ja.length()];
            id=new String[ja.length()];
            pric=new int[ja.length()];
            quantit=new int[ja.length()];
            tota=new int[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("item_title");
                price[i]=jo.getString("price");
                quantity[i]=jo.getString("quantity");
                id[i]=jo.getString("id");
                String parts[] = price[i].split("/");

                pric[i] = Integer.parseInt(price[i]);
                quantit[i]=Integer.parseInt(quantity[i]);
                tota[i]=pric[i]*quantit[i];

                finalprice+=tota[i];
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }
    }


    private void collectData1()
    {
//Connection http with php file
        try{

            URL url=new URL(urladdress1);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("dh", co)
                    .appendQueryParameter("address", addresst1.getText().toString());
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        if(item.equals("Pick Up From Store")){

            t6.setText(String.valueOf(finalprice));
        }
        else{

            if(finalprice>499){
                t6.setText(String.valueOf(finalprice));
            }

            else {

                t6.setText(String.valueOf((finalprice+30)));
            }

        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id3 = item.getItemId();//item id retrival


        //noinspection SimplifiableIfStatement
        //redirect to home
        if (id3 == android.R.id.home) {
            finish();
            return true;
        }

        //return item
        return super.onOptionsItemSelected(item);
    }
}

