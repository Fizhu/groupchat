package gece.com.groupchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import gece.com.groupchat.model.GetLogin;
import gece.com.groupchat.model.Login;
import gece.com.groupchat.rest.ApiClient;
import gece.com.groupchat.rest.ApiInterface;
import gece.com.groupchat.util.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private SessionManager sm;
    ApiInterface mApiInterface;

    private Button btnMasuk, btnDaftar;
    private EditText etEmail,etPw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sm = new SessionManager(LoginActivity.this);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnMasuk = (Button) findViewById(R.id.tbMasuk);
        btnDaftar = (Button) findViewById(R.id.tbDaftar);
        etEmail = (EditText) findViewById(R.id.email);
        etPw = (EditText) findViewById(R.id.password);

        btnMasuk.setOnClickListener(this);
        btnDaftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnMasuk){
//            startActivity(new Intent(this,MainActivity.class));
            if(etEmail.getText().length()<1) {
                etEmail.setError("Email Harus Diisi !!!");
            }else if(etPw.getText().length()<1){
                etPw.setError("Password Harus Diisi !!!");
            }else {
                Call<GetLogin> postLoginCall = mApiInterface.postLogin(etEmail.getText().toString(), etPw.getText().toString());
                postLoginCall.enqueue(new Callback<GetLogin>() {
                    @Override
                    public void onResponse(Call<GetLogin> call, Response<GetLogin> response) {
                        GetLogin res = response.body();
                        List<Login> user = res.getListDataLogin();
                        if (res.getStatus().equals("1")) {
                            sm.storeLogin(user.get(0).getEmail(), user.get(0).getPassword(), user.get(0).getId_user());
                            SessionManager.setKeyId(LoginActivity.this, user.get(0).getId_user());
                            SessionManager.saveUser(LoginActivity.this, user.get(0));
                            Toast.makeText(LoginActivity.this, "Login Berhasil !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else if (res.getStatus().equals("2")) {
                            Toast.makeText(LoginActivity.this, "Email Anda Tidak Terdaftar !", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Password Anda Salah !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetLogin> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Gagal Terhubung, Periksa Kembali Koneksi anda !", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
        if (v == btnDaftar){
            Intent j = new Intent(this, RegisterActivity.class);
            startActivity(j);
        }

    }


}
