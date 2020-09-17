package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

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

public class search extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences pref;

    String urladdress="http://192.168.43.199/ditems.php";
    String urladdress1="http://192.168.43.199/dstores.php";
    String[] name;
    String[] email;
    String[] imagepath;
    String[] id;
    String[] name1;
    String[] email1;
    String[] imagepath1;
    String[] id1;
    String[] id2={"Dhaval"};
    ListView listView,listView1;
    BufferedInputStream is;
    String line=null;
    String result=null;
    String dh="gy",co,n;
    SearchView searchView;
    CustomListView customListView1;
    int con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
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

        // listView=(ListView)findViewById(R.id.lview);

        listView1=(ListView)findViewById(R.id.lview1);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
       /* collectData();
        CustomListView customListView=new CustomListView(this,name,email,imagepath);
        listView.setAdapter(customListView);
        */

        collectData1();

        customListView1=new CustomListView(this,name1,email1,imagepath1,id1,co);
        listView1.setAdapter(customListView1);

   /*     listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(search.this, name[position], Toast.LENGTH_SHORT).show();
            }
        });*/

     /*   listView . setOnItemClickListener ( new AdapterView . OnItemClickListener () {
            @Override
            public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(search.this,placeorder1.class);
                i1.putExtra("id",id[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
            }
        });*/

        listView1.setOnItemClickListener ( new AdapterView. OnItemClickListener () {
            @Override
            public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(search.this,storeproduct.class);
                i1.putExtra("id",id1[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
            }
        });


    }

    public void dhaval(){

        customListView1=new CustomListView(this,name,email,imagepath,id1,co);
        listView1.setAdapter(customListView1);
        listView1.setOnItemClickListener ( new AdapterView . OnItemClickListener () {
            @Override
            public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(search.this,storeproduct.class);
                i1.putExtra("id",id[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
            }
        });

    }

    public void dhaval1(){
        customListView1=new CustomListView(this,name1,email1,imagepath1,id1,co);
        listView1.setAdapter(customListView1);

        listView1.setOnItemClickListener ( new AdapterView . OnItemClickListener () {
            @Override
            public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(search.this,storeproduct.class);
                i1.putExtra("id",id1[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
            }
        });

    }
    /*private void collectData()
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
            imagepath=new String[ja.length()];
            id=new String[ja.length()];

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("name");
                email[i]=jo.getString("price");
                imagepath[i]=jo.getString("image_path");
                id[i]=jo.getString("id");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    } */

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
            name1=new String[ja.length()];
            email1=new String[ja.length()];
            imagepath1=new String[ja.length()];
            id1=new String[ja.length()];
            con=ja.length();

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name1[i]=jo.getString("storename");
                email1[i]=jo.getString("area");
                imagepath1[i]=jo.getString("city");
                id1[i]=jo.getString("id");
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
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem searchViewItem = menu.findItem(R.id.action_search);
        final SearchView searchViewAndroidActionBar = (SearchView) MenuItemCompat.getActionView(searchViewItem);

        searchViewAndroidActionBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                int dr=0;
                int ad=0;
                int changer=0;
                if(newText.length() == 0){
                    dhaval1();
                    changer=1;
                }
                for(int i=0;i<con;i++){
                    if(name1[i].contains(newText)){
                        dr++;
                    }
                }
                name=new String[dr];
                email=new String[dr];
                imagepath=new String[dr];
                id=new String[dr];

                for(int i=0;i<con;i++){
                    if(name1[i].contains(newText)){
                        name[ad]=name1[i];
                        email[ad]=email1[i];
                        imagepath[ad]=imagepath1[i];
                        id[ad]=id1[i];

                    }
                }
                if(changer==0) {
                    dhaval();
                }
                return false;
            }
        });

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
            Intent inte=new Intent(search.this,cart.class);
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

            Intent inte=new Intent(search.this,cart.class);
            inte.putExtra("contact",co);
            startActivity(inte);

        } else if (id == R.id.offer) {

            Intent i=new Intent(search.this,dashboard.class);
            i.putExtra("contact",co);
            startActivity(i);

        } else if (id == R.id.stores) {

            Intent in=new Intent(search.this,search.class);
            in.putExtra("contact",co);
            in.putExtra("contact",co);
            startActivity(in);

        } else if (id == R.id.profile) {
            Intent inten=new Intent(search.this,profile.class);
            inten.putExtra("contact",co);
            startActivity(inten);
        } else if (id == R.id.logout) {
            SharedPreferences.Editor editor = pref.edit();
            editor.clear();
            editor.commit();
            Intent i2=new Intent(search.this,login.class);
            startActivity(i2);

        }else if (id == R.id.fav_store) {
            Intent inten=new Intent(search.this,fav_stores.class);
            inten.putExtra("contact",co);
            startActivity(inten);
        } else if (id == R.id.fav_product) {
            Intent i2=new Intent(search.this,login.class);
            i2.putExtra("contact",co);
            startActivity(i2);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}