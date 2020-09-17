package paltrytrack.maker.paltrytrack;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class address extends AppCompatActivity {
    EditText name1,street1,city1,area1;
    Button add1;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        name1=(EditText)findViewById(R.id.name);
        street1=(EditText)findViewById(R.id.street);
        city1=(EditText)findViewById(R.id.city);
        area1=(EditText)findViewById(R.id.area);
        add1=(Button)findViewById(R.id.add);

        pref= getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);//getting a shared preference
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String faddress=name1.getText().toString()+", "+street1.getText().toString()+", "+area1.getText().toString()+", "+city1.getText().toString();

                SharedPreferences.Editor editor = pref.edit();//to edit or add
                editor.putString("address", faddress);
                editor.commit();
                Intent i=new Intent(address.this,billg.class);
                startActivity(i);
            }
        });
    }
}
