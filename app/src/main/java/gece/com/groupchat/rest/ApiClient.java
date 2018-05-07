package gece.com.groupchat.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fizhu on 28/02/18.
 */

public class ApiClient {

    //IP adress ketika terhubung dengan Rumah Sipong
//    public static final String BASE_URL = "http://192.168.100.12/rest_ci_gc/";

    //IP adress ketika terhubung dengan WiFi Rumah
//    public static final String BASE_URL = "http://192.168.1.40/rest_ci_gc/";

    //IP adress ketika terhubung dengan WiFi Rumah
    public static final String BASE_URL = "http://192.168.43.197/rest_ci_gc/";

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
