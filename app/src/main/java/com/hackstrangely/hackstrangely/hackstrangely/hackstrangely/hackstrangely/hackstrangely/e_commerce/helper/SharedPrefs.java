package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.e_commerce.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Meghal on 6/9/2016.
 */
public class SharedPrefs {

    // Shared preferences file name
    private static final String PREF_NAME = "AndroidHiveLogin";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_IS_REGISTERED = "isRegistered";
    private static final String KEY_IS_OTPLOGGEDIN = "isOtpLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHOTO_URL = "photoUrl";
    private static final String KEY_USER_ID = "userId";
    private static final String FIRSTBLOG="isFirstBlog";
    private static final String KEY_LOGIN_TYPE = "loginType";
    private static final String KEY_FCM = "fcm";
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_PRODUCT_TYPE = "product_type";
    private static final String KEY_PRODUCT_ID = "product_id";
    private static final String KEY_CROP = "crop";
    private static final String KEY_SPACE = "space";
    private static final String KEY_SEED = "seed";
    private static final int KEY_VERSION=1;
    private static final String KEY_LANGUAGE = "lang";
    // LogCat tag
    private static String TAG = "Shared Preference";
    // Shared Preferences
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    public static int getKeyVersion() {
        return KEY_VERSION;
    }

    public SharedPrefs(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn) {

        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }
    public void setRegister(boolean isRegistered) {

        editor.putBoolean(KEY_IS_REGISTERED, isRegistered);
        // commit changes
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }
    public void setOtpLogin(boolean isOtpLoggedIn){
        editor.putBoolean(KEY_IS_OTPLOGGEDIN, isOtpLoggedIn);
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public void setKeyLanguage(String language){
        editor.putString(KEY_LANGUAGE,language);
        editor.commit();
    }
    public String getKeyLanguage(){
        return pref.getString(KEY_LANGUAGE,"1");
    }
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }
    public boolean isRegistered(){
        return pref.getBoolean(KEY_IS_REGISTERED,false);
    }

    public String getUsername() {

        return pref.getString(KEY_USERNAME, "USER NAME");
    }


    public void setFCM(String fcm) {
        editor.putString(KEY_FCM, fcm);
        editor.commit();
    }

    public String getFcm() {
        return pref.getString(KEY_FCM, null);
    }

    public void setUsername(String username) {

        editor.putString(KEY_USERNAME, username);
        editor.commit();


    }

    public void setEmailId(String emailId) {

        editor.putString(KEY_EMAIL, emailId);
        editor.commit();

    }

    public String getUserId() {

        return pref.getString(KEY_USER_ID, "Not Available");

    }

    public void setUserId(String userId) {

        editor.putString(KEY_USER_ID, userId);
        editor.commit();

    }

    public String getPhotoUrl() {

        return pref.getString(KEY_PHOTO_URL, "User name not available");
    }

    public void setPhotoUrl(String photoUrl) {

        editor.putString(KEY_PHOTO_URL, photoUrl);
        editor.commit();

    }

    public void setAccessToken(String accessToken) {
        editor.putString(KEY_ACCESS_TOKEN, accessToken);
        editor.commit();
    }

    public String getAccessToken() {

        return pref.getString(KEY_ACCESS_TOKEN, null);
    }

    public String getEmail() {

        return pref.getString(KEY_EMAIL, "Your Email Address");
    }


    public String getMobile() {

        return pref.getString(KEY_MOBILE, "Your Phone Number");

    }

    public void setMobile(String userName) {

        editor.putString(KEY_MOBILE, userName);
        editor.commit();

    }

    public void setProduct(String productType) {
        editor.putString(KEY_PRODUCT_TYPE, productType);
        editor.commit();
    }

    public String getProduct() {

        return pref.getString(KEY_PRODUCT_TYPE, "Your Product Type");

    }

    public void setProductId(String productId)
    {
        editor.putString(KEY_PRODUCT_ID, productId);
        editor.commit();
    }
    public String getProductId()
    {
        return pref.getString(KEY_PRODUCT_ID,"Your Product ID");
    }

    public void setCrop(String crop)
    {
        editor.putString(KEY_CROP,crop);
        editor.commit();
    }

    public String getCrop()
    {
        return pref.getString(KEY_CROP,"Crop Name");
    }

    public  void setSpacing(String space){
        editor.putString(KEY_SPACE,space);
        editor.commit();
    }
    public  void setSeed(String seed){
        editor.putString(KEY_SEED,seed);
        editor.commit();
    }

    public String getSpacing()
    {
        return pref.getString(KEY_SPACE,"space");
    }
    public String getSeed()
    {
        return pref.getString(KEY_SEED,"Seed value");
    }
}
