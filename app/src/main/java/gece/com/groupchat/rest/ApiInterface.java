package gece.com.groupchat.rest;


import gece.com.groupchat.model.GetLogin;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;


/**
 * Created by fizhu on 28/02/18.
 */


public interface ApiInterface {

    @FormUrlEncoded
    @POST("Login")
    Call<GetLogin> postLogin(@Field("email") String email,
                             @Field("password") String password);
}
