package paltrytrack.maker.paltrytrack;

import android.app.Activity;
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

public class CustomListView4 extends ArrayAdapter<String> {

    private String[] name;
    private String[] price;
    private String[] image_path;
    String[] unit;
    String[] quantity;
    private String[] id;
    String ids;
    private Activity context;
    Bitmap bitmap;
    BufferedInputStream is;
    String line=null;
    String result=null;
    String urladdress1="http://192.168.43.199/myorders1.php";

    public CustomListView4(Activity context, String[] name, String[] price, String[] image_path, String[] unit, String[] id, String[] quantity) {
        super(context, R.layout.layout4,name);
        this.context=context;
        this.name=name;
        this.price=price;
        this.image_path=image_path;
        this.id=id;
        this.unit=unit;
        this.quantity=quantity;

    }

    @NonNull
    @Override

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        CustomListView4.ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout4,null,true);
            viewHolder=new CustomListView4.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(CustomListView4.ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(name[position]);
        viewHolder.tvw2.setText("₹ "+price[position]);
        viewHolder.unit.setText(unit[position]);
        viewHolder.quantity.setText(quantity[position]);

        viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ids=id[position];
                collectData1();
                Log.i("aaab","aaab");
                notifyDataSetChanged();
            }
        });

        new CustomListView4.GetImageFromURL(viewHolder.ivw).execute(image_path[position]);

        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView unit;
        TextView quantity;
        ImageView ivw;
        ImageButton fav;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvprofilename);
            tvw2=(TextView)v.findViewById(R.id.tvemail);
            quantity=(TextView)v.findViewById(R.id.quantity);
            ivw=(ImageView)v.findViewById(R.id.imageView);
            unit=(TextView)v.findViewById(R.id.unit);
            fav=(ImageButton)v.findViewById(R.id.fav);
            fav.setFocusable(false);
        }

    }

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
                    .appendQueryParameter("dh", ids);
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
