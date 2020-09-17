package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class placeorder1 extends AppCompatActivity {

    SharedPreferences pref;

    String urladdress="http://192.168.43.199/orderads1.php";
    String urladdress1="http://192.168.43.199/placeorder1.php";
    TextView name,price,pincode,description,contact,quantity,unit;
    Button buy,minus,plus,off;
    ListView listView;
    BufferedInputStream is;
    String line=null;
    String result=null;
    String dh;
    int ab;
    String name1,username;
    String name2,price2,s1,vc,td,storeid,db;
    ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeorder1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name1=getIntent().getStringExtra("id");
        username=getIntent().getStringExtra("contact");
        dh=name1;

        pref=getApplication().getSharedPreferences("Options", MODE_PRIVATE);
        username=pref.getString("user", "");

        name=(TextView)findViewById(R.id.fghjk);
        price=(TextView)findViewById(R.id.price);
       // pincode=(TextView)findViewById(R.id.pincode);
        description=(TextView)findViewById(R.id.description);
        //contact=(TextView)findViewById(R.id.contact);
        buy=(Button)findViewById(R.id.buy);
        quantity=(TextView)findViewById(R.id.quantity);
        iv2=(ImageView) findViewById(R.id.iv2);
        minus=(Button)findViewById(R.id.minus);
        plus=(Button)findViewById(R.id.plus);

        off=(Button)findViewById(R.id.off);
        unit=(TextView)findViewById(R.id.unit);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ab=Integer.parseInt(quantity.getText().toString());
                    name2 = name.getText().toString();
                    price2 = price.getText().toString();
                    collectData1();
                    Toast.makeText(placeorder1.this, "Item is Added in your cart", Toast.LENGTH_LONG).show();
                    Intent i12 = new Intent(placeorder1.this, storeproduct.class);
                    startActivity(i12);

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(quantity.getText().toString()) != 1) {
                    int d = Integer.parseInt(quantity.getText().toString());
                    d=d-1;
                    String s5 = String.valueOf(d);
                    quantity.setText(s5);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int d=Integer.parseInt(quantity.getText().toString());
                d++;
                String s5=String.valueOf(d);
                quantity.setText(s5);
            }
        });

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
    }

    private boolean hasContent(EditText et) {
        // Always assume false until proven otherwise
        boolean bHasContent = false;

        if (et.getText().toString().trim().length() > 0) {
            // Got content
            bHasContent = true;
        }
        return bHasContent;
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
                    .appendQueryParameter("dh", dh);
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
                name.setText(jo.getString("item_title"));
                price.setText("₹ " +jo.getString("item_price"));
                td=jo.getString("item_price");
                description.setText(jo.getString("item_description"));
                unit.setText(jo.getString("unit"));
                int p1=Integer.parseInt(jo.getString("was_price"));
                int p2=Integer.parseInt(jo.getString("item_price"));
                off.setText(String.valueOf((p1-p2)*100/p1)+"% OFF");
                storeid=jo.getString("store_id");
                db=jo.getString("small_pic");
            //    pincode.setText(jo.getString("pincode"));
                vc=jo.getString("store_id");
                new DownLoadImageTask(iv2).execute(jo.getString("small_pic"));
                s1=vc;
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
                    .appendQueryParameter("item_title", name.getText().toString())
                    .appendQueryParameter("quantity", quantity.getText().toString())
                    .appendQueryParameter("price", td)
                    .appendQueryParameter("small_pic", db)
                    .appendQueryParameter("unit", unit.getText().toString())
                    .appendQueryParameter("contact", username)
                    .appendQueryParameter("vendor_contact", name1);

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
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
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
        int id3 = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id3 == R.id.cart) {
            Intent inte=new Intent(placeorder1.this,cart.class);
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
