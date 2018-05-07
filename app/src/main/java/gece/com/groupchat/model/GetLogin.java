package gece.com.groupchat.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fizhu on 28/02/18.
 */

public class GetLogin {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("result")
    List<Login> listDataLogin;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Login> getListDataLogin() {
        return listDataLogin;
    }

    public void setListDataLogin(List<Login> listDataLogin) {
        this.listDataLogin = listDataLogin;
    }
}
