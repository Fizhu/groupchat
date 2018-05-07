package gece.com.groupchat.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;
import gece.com.groupchat.LoginActivity;
import gece.com.groupchat.model.Login;

import java.util.HashMap;

/**
 * Created by fizhu on 12/03/18.
 */

public class SessionManager {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_ID = "user_id";
    public static final String KEY_PROFILE_USER = "user_profile";
    private static final String is_login = "loginstatus";
    private final String SHARE_NAME = "loginsession";
    private final int MODE_PRIVATE = 0;
    private Context _context;

    public SessionManager(Context context){
        this._context = context;
        sp = _context.getSharedPreferences(SHARE_NAME,Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    private static SharedPreferences getSharedPreferences(Context _context){
        return PreferenceManager.getDefaultSharedPreferences(_context);
    }

    public static String getKeyId(Context _context){
        return getSharedPreferences(_context).getString(KEY_ID,null);
    }
    public static void setKeyId(Context _context, String user_id){
        getSharedPreferences(_context).edit().putString(KEY_ID, user_id).apply();
    }

    public static Login getUser(Context _context){
        String json = getSharedPreferences(_context).getString(KEY_PROFILE_USER,null);
        if(TextUtils.isEmpty(json)) return null;
        return new Gson().fromJson(json,Login.class);
    }

    public static void saveUser(Context _context, Login user){
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        getSharedPreferences(_context).edit().putString(KEY_PROFILE_USER,userJson).apply();
    }

    public void storeLogin(String email, String password, String user_id){
        editor.putBoolean(is_login,true);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASSWORD,password);
        editor.putString(KEY_ID,user_id);
        editor.commit();
    }
     public HashMap getDetailLogin(){
        HashMap<String,String> map = new HashMap<>();
        map.put(KEY_EMAIL, sp.getString(KEY_EMAIL,null));
        map.put(KEY_PASSWORD, sp.getString(KEY_PASSWORD,null));
        map.put(KEY_ID, sp.getString(KEY_ID,null));
        return map;
     }

     public void checkLogin(){
        if(!this.Login()){
            Intent login = new Intent(_context, LoginActivity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(login);
        }
     }

     public Boolean Login(){
         return sp.getBoolean(is_login,false);
     }

     public void logout(){
         editor.clear();
         editor.commit();
     }
}

