package com.example.thanhnguyen.simpleemail.Helpers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by thanhnguyen on 3/5/17.
 */
public class Utilities {

    public static boolean isNotEmpty(EditText editText) {
        return editText.getText().toString().trim().length() > 0;
    }

    @NonNull
    public static String getString(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static boolean checkPermission(Context context, String permission) {
        if (isMarshmallow()) {
            int result = ContextCompat.checkSelfPermission(context, permission);
            return result == PackageManager.PERMISSION_GRANTED;
        } else {
            return true;
        }
    }

    public static boolean isMarshmallow() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    public static void showMessage(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static Map<String,String> parse(JSONObject json , Map<String,String> out) throws JSONException {
        Iterator<String> keys = json.keys();
        while(keys.hasNext()){
            String key = keys.next();
            String val = null;
            if ( json.getJSONObject(key) instanceof JSONObject) {
                JSONObject value = json.getJSONObject(key);
                parse(value,out);
            }

            else {
                val = json.getString(key);
            }


            if(val != null){
                out.put(key,val);
            }
        }
        return out;
    }
}
