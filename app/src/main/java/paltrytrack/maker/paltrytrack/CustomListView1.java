package paltrytrack.maker.paltrytrack;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class CustomListView1 extends ArrayAdapter<String> {

    private String[] name;
    private int[] price;
    private int[] quantity;
    private int[] total;
    private Activity context;


    public CustomListView1(Activity context, String[] name, int[] pric, int[] quantit,int[] tota) {
        super(context, R.layout.layout1,name);
        this.context=context;
        this.name=name;
        this.price=pric;
        this.quantity=quantit;
        this.total=tota;
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.layout1,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder=(ViewHolder)r.getTag();

        }

        viewHolder.tvw1.setText(name[position]);
        viewHolder.tvw2.setText(String.valueOf(price[position]));
        viewHolder.tvw3.setText(String.valueOf(quantity[position]));
        viewHolder.tvw4.setText(String.valueOf(total[position]));

        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        TextView tvw4;

        ViewHolder(View v){
            tvw1=(TextView)v.findViewById(R.id.t1);
            tvw2=(TextView)v.findViewById(R.id.t2);
            tvw3=(TextView)v.findViewById(R.id.t3);
            tvw4=(TextView)v.findViewById(R.id.t4);
        }

    }

}
