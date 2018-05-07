package gece.com.groupchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import gece.com.groupchat.R;
import gece.com.groupchat.adapters.SlidingTabAdapter;
import gece.com.groupchat.util.SessionManager;

/**
 * Created by fizhu on 15/02/18.
 */

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SlidingTabAdapter slidingTabAdapter;
    private CharSequence titles[] = {"Profile","Obrolan", "Pengaturan"};

    //for the tab's items
    private TabLayout.Tab profile;
    private TabLayout.Tab chats;
    private TabLayout.Tab setting;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static MainActivity ma;
    SessionManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ma=this;
        sm = new SessionManager(MainActivity.this);
        sm.checkLogin();

        // to hide the devider between action bar and tabLayout
        getSupportActionBar().setElevation(0);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        //initialize the adapter
        slidingTabAdapter = new SlidingTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(slidingTabAdapter);


        //set your tab's item
        profile = tabLayout.newTab();
        chats = tabLayout.newTab();
        setting = tabLayout.newTab();


        //labeling the tab's items
        profile.setIcon(R.drawable.ic_action_person);
        chats.setIcon(R.drawable.ic_action_chat);
        setting.setIcon(R.drawable.ic_action_settings);


        //set the index of the tab's items
        tabLayout.addTab(profile, 0);
        tabLayout.addTab(chats,1);
        tabLayout.addTab(setting,2);

        //set tab selector color
        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));

        //set the indicator
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.BawahanTab));
        tabLayout.setSelectedTabIndicatorHeight(10);

        // switch the fragment when the current fragment was slided.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // switch the fragment when the tab item was clicked
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                setTitle(titles[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override

            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(1,true);

        //get current tab
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String position = sharedPreferences.getString("tab_opened", null);
        if(position==null){
            viewPager.setCurrentItem(1,true);
        }else if(position=="0"){
            viewPager.setCurrentItem(0,true);
        }else if(position=="1"){
            viewPager.setCurrentItem(1,true);
        }else{
            viewPager.setCurrentItem(2,true);
        }

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            moveTaskToBack(true);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan Sekali Lagi Untuk Keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

//    public void sbView(){
//        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        Snackbar snackbar = Snackbar
//                .make(findViewById(R.id.activity_main), "Gagal Terhubung, Periksa Kembali Koneksi Anda !", Snackbar.LENGTH_SHORT)
//                .setAction("Refresh", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        editor.putString("tab_opened", "2");
//                        editor.apply();
//                        ThirdFragment.tf.refreshItems();
//                    }
//                });
//
//        View sbView = snackbar.getView();
//        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
//        textView.setTextColor(Color.WHITE);
//        snackbar.show();
//    }
//
}
