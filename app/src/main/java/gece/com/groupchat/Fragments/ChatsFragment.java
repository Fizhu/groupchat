package gece.com.groupchat.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gece.com.groupchat.R;

/**
 * Created by fizhu on 15/02/18.
 */

public class ChatsFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chats, container, false);

        return v;
    }

}
