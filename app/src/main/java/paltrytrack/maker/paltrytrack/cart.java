package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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


public class cart extends AppCompatActivity {

    SharedPreferences pref;

    String urladdress="http://192.168.43.199/myorders.php";
    String[] name;
    String[] email;
    String[] imagepath;
    String[] unit;
    String[] quantity1;
    String[] id;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;
    String dh="gy",co,n;
    Button bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        co=pref.getString("user", "");

        Log.i("aaaa",co);
        listView=(ListView)findViewById(R.id.lview);

        bill=(Button)findViewById(R.id.bill);

        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(cart.this,billg.class);
                intent.putExtra("contact",co);
                startActivity(intent);
            }
        });

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        CustomListView4 customListView=new CustomListView4(this,name,email,imagepath,unit,id,quantity1);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(cart.this, name[position], Toast.LENGTH_SHORT).show();
            }
        });

        listView . setOnItemClickListener ( new AdapterView . OnItemClickListener () {
            @Override
            public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(cart.this,placeorder3.class);
                i1.putExtra("id",id[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
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
            email=new String[ja.length()];
            unit=new String[ja.length()];
            quantity1=new String[ja.length()];
            imagepath=new String[ja.length()];
            id=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("item_title");
                email[i]=jo.getString("price");
                imagepath[i]=jo.getString("small_pic");
                unit[i]=jo.getString("unit");
                quantity1[i]=jo.getString("quantity");
                Log.i("asd",quantity1[i]);
                Log.i("asd",unit[i]);
                id[i]=jo.getString("id");
            }
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