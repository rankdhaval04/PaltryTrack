package paltrytrack.maker.paltrytrack;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://192.168.43.199/loginl.php";
    private Map<String, String> params;

    public LoginRequest(String contect, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("contect", contect);
        params.put("password", password);
        Log.i("namerecive",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
