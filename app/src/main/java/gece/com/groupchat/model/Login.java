package gece.com.groupchat.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fizhu on 28/02/18.
 */

public class Login {
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("nama")
    private String nama;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("telepon")
    private String telepon;

    public Login(String id_user, String nama, String email, String password, String telepon) {
        this.id_user = id_user;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.telepon = telepon;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}

