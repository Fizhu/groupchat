package gece.com.groupchat.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import gece.com.groupchat.R;
import gece.com.groupchat.util.SessionManager;

/**
 * Created by fizhu on 15/02/18.
 */

public class SettingFragment extends Fragment implements View.OnClickListener{

    private Button btLOGOUT;
    SessionManager sm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        btLOGOUT = (Button) v.findViewById(R.id.btKELUAR);

        btLOGOUT.setOnClickListener(this);

        sm = new SessionManager(getContext());
        sm.checkLogin();

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == btLOGOUT) {
            sm.logout();
            sm.checkLogin();
            Toast.makeText(getContext(),"Anda Berhasil Logout",Toast.LENGTH_SHORT).show();
        }
    }
}
