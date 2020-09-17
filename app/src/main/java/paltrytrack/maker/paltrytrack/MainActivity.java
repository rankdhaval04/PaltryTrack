package paltrytrack.maker.paltrytrack;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;

    String urladdress = "http://192.168.43.9/pdata.php";
    String[] name;
    String[] email;
    String[] imagepath;
    String[] id, unita, dis;
    BufferedInputStream is;
    String line = null;
    String result = null;
    String dh, co, n;
    String username, name1;
    ListView listView;
    SearchView searchView;
    CustomListView3 customListView;
    int con;
    String[] name2 = {"Dhaval"};
    String[] email1 = {"Dhaval"};
    String[] imagepath1 = {"Dhaval"};
    String[] id1 = {"Dhaval"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.lview);

        name1 = "7069936106";

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        collectData();
        customListView = new CustomListView3(this, name, email, imagepath, unita, dis);
        listView.setAdapter(customListView);



       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(storeproduct.this, placeorder1.class);
                i1.putExtra("id", id[i]);
                i1.putExtra("idd", dh);
                i1.putExtra("contact", co);
                startActivity(i1);
            }
        }); */

    }




    private void collectData() {
//Connection
        try {

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("name", name1);


            String query = builder.build().getEncodedQuery();

            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            con.connect();

            is = new BufferedInputStream(con.getInputStream());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //content
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();

        } catch (Exception ex) {
            ex.printStackTrace();

        }

//JSON
        try {
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;
            name = new String[ja.length()];
            email = new String[ja.length()];
            imagepath = new String[ja.length()];
            id = new String[ja.length()];
            unita = new String[ja.length()];
            dis = new String[ja.length()];
            con = ja.length();

            for (int i = 0; i <= ja.length(); i++) {
                jo = ja.getJSONObject(i);
                name[i] = jo.getString("name");
                email[i] = jo.getString("price");
                imagepath[i] = jo.getString("small_pic");
                unita[i] = jo.getString("quantity") + " item";
                dis[i] = jo.getString("off");
                id[i] = jo.getString("id");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }


    }
}