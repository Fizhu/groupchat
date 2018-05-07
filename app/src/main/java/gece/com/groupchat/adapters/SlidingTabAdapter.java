package gece.com.groupchat.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import gece.com.groupchat.Fragments.ChatsFragment;
import gece.com.groupchat.Fragments.ProfileFragment;
import gece.com.groupchat.Fragments.SettingFragment;


/**
 * Created by putuguna on 13/01/17.
 */

public class SlidingTabAdapter extends FragmentStatePagerAdapter {


    public SlidingTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ProfileFragment();
        }else if(position==1){
            return new ChatsFragment();
        }else{
            return new SettingFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
