package paltrytrack.maker.paltrytrack;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.InputStream;

public class CustomListView3  extends ArrayAdapter<String> {

    private String[] name;
    private String[] price;
    private String[] image_path,unita,dis;
    private Activity context;
    Bitmap bitmap;

    public CustomListView3(Activity context, String[] name, String[] price, String[] image_path, String[] unita, String[] dis) {
        super(context, R.layout.layout3,name);
        this.context=context;
        this.name=name;
        this.price=price;
        this.unita=unita;
        this.dis=dis;
        this.image_path=image_path;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        CustomListView3.ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout3,null,true);
            viewHolder=new CustomListView3.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(CustomListView3.ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(name[position]);
        viewHolder.tvw2.setText(price[position]);
        viewHolder.off.setText(dis[position]);
        viewHolder.unit.setText(unita[position]);

        viewHolder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                //
                //

                Log.i("aaa","aaa");

            }
        });

        new CustomListView3.GetImageFromURL(viewHolder.ivw).execute(image_path[position]);

        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView off;
        TextView unit;
        ImageView ivw;
        ImageButton fav;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.tvprofilename);
            tvw2=(TextView)v.findViewById(R.id.tvemail);
            off=(TextView)v.findViewById(R.id.off);
            unit=(TextView)v.findViewById(R.id.unit);
            ivw=(ImageView)v.findViewById(R.id.imageView);
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




}
