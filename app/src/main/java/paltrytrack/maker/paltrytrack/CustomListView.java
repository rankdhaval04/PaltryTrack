package paltrytrack.maker.paltrytrack;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jaiso on 13-02-2018.
 */

public class CustomListView extends ArrayAdapter<String> {

    SharedPreferences pref;

    private String[] name;
    private String[] price;
    private String[] image_path;
    private String[] id;
    private Activity context;
    Bitmap bitmap;
    BufferedInputStream is;
    String ids,co,ns,areas;
    String line=null;
    String result=null;
    String urladdress1="http://192.168.43.199/favstores.php";

    public CustomListView(Activity context, String[] name, String[] price, String[] image_path, String[] id,String co) {//data collection for passing in customlistview
        super(context, R.layout.layout,name);//layout specification
        this.context=context;
        //assignment or data transfer args to global array
        this.name=name;
        this.price=price;
        this.id=id;
        this.co=co;
        this.image_path=image_path;
    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        //viewholder declaration
        ViewHolder viewHolder=null;
        if(r==null){
            //setting layout using view holder
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();

        }

        //we can access views using viewholder class
        viewHolder.tvw1.setText(name[position]);
        viewHolder.tvw2.setText(price[position]);
        ns=name[position];
        areas=price[position];

        //accessing button using viewholder
        viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ids=id[position];
                collectData1();
                Log.i("aaab","aaab");
                notifyDataSetChanged();

            }
        });

        //setting image in imageview using viewholder class view
        new GetImageFromURL(viewHolder.ivw).execute(image_path[position]);

        return r;
    }

    class ViewHolder{

        //defining views in viewholder class
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ImageButton fav;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvprofilename);
            tvw2=(TextView)v.findViewById(R.id.tvemail);
            ivw=(ImageView)v.findViewById(R.id.imageView);
            fav=(ImageButton)v.findViewById(R.id.fav);
            fav.setFocusable(false);
        }

    }

    //set image in image
    public class GetImageFromURL extends AsyncTask<String,Void,Bitmap>
    {

        ImageView imgView;
        public GetImageFromURL(ImageView imgv)
        {
            this.imgView=imgv;
        }
        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay=url[0];
            bitmap=null;

            try{

                InputStream ist=new java.net.URL(urldisplay).openStream();
                bitmap= BitmapFactory.decodeStream(ist);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap){

            super.onPostExecute(bitmap);
            imgView.setImageBitmap(bitmap);
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
                    .appendQueryParameter("contact_cust", co)
                    .appendQueryParameter("store_name",ns )
                    .appendQueryParameter("store_area", areas)
                    .appendQueryParameter("store_id", ids);
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

}
