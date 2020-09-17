package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
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

public class profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences pref;

    String urladdress="http://192.168.43.199/displayprofilec.php";
    String urladdress1="http://192.168.43.199/updateprofilec.php";
    BufferedInputStream is;
    String line=null;
    String result=null;
    String co;
    int id;
    TextView etName2,etPassword2,etArea2,etaddress2,etphone2,etcity2,etpincode2;
    ImageButton button;
    String name1,password1,area1,address1,phone1,city1,pincode1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        co=pref.getString("user", "");
                //getIntent().getStringExtra("contact");

        etName2 = (TextView) findViewById(R.id.etName3);
        etArea2 = (TextView) findViewById(R.id.etArea3);
        etphone2 = (TextView) findViewById(R.id.phone3);
        etcity2 = (TextView) findViewById(R.id.etcity3);
        etpincode2 = (TextView) findViewById(R.id.pincode3);
        button=(ImageButton)findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(profile.this,editprofile.class);
                i2.putExtra("contact",co);
                startActivity(i2);
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
                etName2.setText(jo.getString("name"));
                etArea2.setText(jo.getString("area"));
               // etPassword2.setText(jo.getString("password"));
               // etaddress2.setText(jo.getString("address"));
                etphone2.setText(jo.getString("contect"));
                etcity2.setText(jo.getString("city"));
                etpincode2.setText(jo.getString("pincode"));
                id=Integer.parseInt(jo.getString("id"));
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cart) {
            Intent inte=new Intent(profile.this,cart.class);
            inte.putExtra("contact",co);
            startActivity(inte);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_cart) {

            Intent inte=new Intent(profile.this,cart.class);
            inte.putExtra("contact",co);
            startActivity(inte);

        } else if (id == R.id.offer) {

            Intent i=new Intent(profile.this,dashboard.class);
            startActivity(i);

        } else if (id == R.id.stores) {

            Intent in=new Intent(profile.this,search.class);
            in.putExtra("contact",co);
            in.putExtra("contact",co);
            startActivity(in);

        } else if (id == R.id.profile) {
            Intent inten=new Intent(profile.this,profile.class);
            inten.putExtra("contact",co);
            startActivity(inten);
        } else if (id == R.id.logout) {
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.commit();
            Intent inte =new Intent(profile.this,login.class);
            startActivity(inte);

        }else if (id == R.id.fav_store) {
            Intent inten=new Intent(profile.this,fav_stores.class);
            inten.putExtra("contact",co);
            startActivity(inten);
        } else if (id == R.id.fav_product) {
            Intent i2=new Intent(profile.this,login.class);
            i2.putExtra("contact",co);
            startActivity(i2);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
