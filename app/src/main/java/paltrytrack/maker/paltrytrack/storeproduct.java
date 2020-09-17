package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class storeproduct extends AppCompatActivity {

    SharedPreferences pref;

    String urladdress = "http://192.168.43.199/ditemss.php";
    String[] name;
    String[] email;
    String[] imagepath;
    String[] id,unita,dis;
    BufferedInputStream is;
    String line = null;
    String result = null;
    String dh , co, n;
    String username,name1;
    ListView listView;
    SearchView searchView;
    CustomListView3 customListView;
    int con;
    String[] name2={"Dhaval"};
    String[] email1={"Dhaval"};
    String[] imagepath1={"Dhaval"};
    String[] id1={"Dhaval"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeproduct);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView=(ListView)findViewById(R.id.lview);

        name1=getIntent().getStringExtra("id");
        username=getIntent().getStringExtra("contact");
        dh=name1;

        collectData();
        customListView=new CustomListView3(this,name,email,imagepath,unita,dis);
        listView.setAdapter(customListView);




        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username=pref.getString("user", "");


        listView . setOnItemClickListener ( new AdapterView. OnItemClickListener () {
            @Override
            public void onItemClick (AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(storeproduct.this,placeorder1.class);
                i1.putExtra("id",id[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
            }
        });





    }

    public void dhaval(){
        customListView=new CustomListView3(this,name2,email1,imagepath1,unita,dis);
        listView.setAdapter(customListView);

        listView . setOnItemClickListener ( new AdapterView . OnItemClickListener () {
            @Override
            public void onItemClick ( AdapterView <?> adapterView , View view , int i , long l ) {
                Intent i1=new Intent(storeproduct.this,placeorder1.class);
                i1.putExtra("id",id1[i]);
                i1.putExtra("contact",co);
                startActivity(i1);
            }
        });

    }

    public void dhaval1(){
        customListView=new CustomListView3(this,name,email,imagepath,unita,dis);
        listView.setAdapter(customListView);

        listView . setOnItemClickListener ( new AdapterView . OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(storeproduct.this, placeorder1.class);
                i1.putExtra("id", id[i]);
                i1.putExtra("contact", co);
                startActivity(i1);
            }
        });

    }


    private void collectData() {
//Connection
        try{

            URL url=new URL(urladdress);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("storec", name1);


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
            unita=new String[ja.length()];
            dis=new String[ja.length()];
            con=ja.length();

            for(int i=0;i<=ja.length();i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("item_title");
                email[i]=jo.getString("item_price");
                imagepath[i]=jo.getString("small_pic");
                unita[i]=jo.getString("unit");
                int p1=Integer.parseInt(jo.getString("was_price"));
                int p2=Integer.parseInt(jo.getString("item_price"));
                dis[i]=(String.valueOf((p1-p2)*100/p1)+"% OFF");
                id[i]=jo.getString("id");
            }
        }
        catch (Exception ex)
        {

            ex.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);

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
                    if(name[i].contains(newText)){
                        dr++;
                    }
                }
                name2=new String[dr];
                email1=new String[dr];
                imagepath1=new String[dr];
                id1=new String[dr];

                for(int i=0;i<con;i++){
                    if(name[i].contains(newText)){
                        name2[ad]=name[i];
                        email1[ad]=email[i];
                        imagepath1[ad]=imagepath[i];
                        id1[ad]=id[i];

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
        int id3 = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id3 == R.id.cart) {
            Intent inte=new Intent(storeproduct.this,cart.class);
            startActivity(inte);
            return true;
        }
        else if (id3 == android.R.id.home) {
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
