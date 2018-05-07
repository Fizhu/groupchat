package gece.com.groupchat.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gece.com.groupchat.R;
import gece.com.groupchat.model.Login;
import gece.com.groupchat.util.SessionManager;


/**
 * Created by fizhu on 15/02/18.
 */

public class ProfileFragment extends Fragment{
    SessionManager sm;

    private TextView txtNAMA,txtEMAIL,txtTELEPON;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        sm = new SessionManager(getContext());
        sm.checkLogin();

        Login login = SessionManager.getUser(getContext());

        txtNAMA = (TextView) v.findViewById(R.id.tvNAMA);
        txtEMAIL = (TextView) v.findViewById(R.id.tvEMAIL);
        txtTELEPON = (TextView) v.findViewById(R.id.tvTELEPON);

        if (login != null) {
            txtNAMA.setText(login.getNama());
            txtEMAIL.setText(login.getEmail());
            txtTELEPON.setText("0"+login.getTelepon());
        }

        return v;

    }



}
