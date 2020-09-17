package paltrytrack.maker.paltrytrack;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.43.199/registerl.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String password, int age, String address, String phone,String area,String city,String pincode, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("password", password);
        params.put("age", age + "");
        params.put("phone", phone);
        params.put("address", address);
        params.put("area", area);
        params.put("city", city);
        params.put("pincode", pincode);
        Log.i("name",name+password+age+address+phone);
    }

    @Override
    public Map<String, String> getParams() {
        Log.i("name","fdsuig");
        return params;
    }
}
