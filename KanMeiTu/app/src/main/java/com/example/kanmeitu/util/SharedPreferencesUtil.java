package com.example.kanmeitu.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    private final static String TAG = "TAG";
    private final static String KEY_LOGIN = "KEY_LOGIN";

    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static SharedPreferencesUtil mSharedPreferencesUtil;
    private final Context context;

    public SharedPreferencesUtil(Context context){
        this.context = context.getApplicationContext();
        mPreferences = this.context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    /**
     * 单例简单实现（Android没有java Wed那样的高并发量， 所以单例可以这样简单实现）
     * @param context
     * @return
     */
    public static SharedPreferencesUtil getInstance(Context context){
        if(mPreferences == null){
            mSharedPreferencesUtil = new SharedPreferencesUtil(context);
        }
        return mSharedPreferencesUtil;
    }

    /**
     * 判断是否登入
     * @retrun
     */
    public boolean isLogin(){
        return getBoolean(KEY_LOGIN, false);
    }

    /**
     * 更改登入状态
     * @param value
     */
    public void setLogin(boolean value){
        putBoolean(KEY_LOGIN, value);
    }

//    --私有方法
    private void put(String key,String value){
        mEditor.putString(key, value);
        mEditor.commit();
    }


    private void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    private String get(String key){
        return mPreferences.getString(key,"");
    }

    private boolean getBoolean(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    private void putInt(String key, int value){
        mEditor.putInt(key, value);
        mEditor.commit();
    }
    private int getInt(String key, int defaultValue){
        return mPreferences.getInt(key, defaultValue);
    }
//    ---end 私有方法
}
