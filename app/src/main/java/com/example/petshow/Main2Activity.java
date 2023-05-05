package com.example.petshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.petshow.DailyFragment.DailyFragment;
import com.example.petshow.HomeFragment.HomeFragment;
import com.example.petshow.MemberFragment.MemberFragment;
import com.example.petshow.RequestFragment.RequestFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        switchFragment(new HomeFragment());
                        break;
                    case R.id.navigation_dashboard:
                        switchFragment(new RequestFragment());
                        break;
                    case R.id.navigation_notifications:
                        switchFragment(new MemberFragment());
                        break;
                    case R.id.camp_daily:
                        switchFragment(new DailyFragment());
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
                return true;
            }
        });
        //如果没有传回fragment参数，就默认显示HomeFragment
        //如果传回了fragment参数，就显示对应的fragment
        String fragment = getIntent().getStringExtra("fragment");
        if(fragment == null){
            switchFragment(new HomeFragment());
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        } else {
            switch (fragment) {
                case "home":
                    switchFragment(new HomeFragment());
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                    break;
                case "request":
                    switchFragment(new RequestFragment());
                    bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);
                    break;
                case "member":
                    switchFragment(new MemberFragment());
                    bottomNavigationView.setSelectedItemId(R.id.navigation_notifications);
                    break;
                case "daily":
                    switchFragment(new DailyFragment());
                    bottomNavigationView.setSelectedItemId(R.id.camp_daily);
                    break;
            }
        }

    }



    private void switchFragment(Fragment fragment) {
        if(currentFragment == fragment){
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(currentFragment != null){
            transaction.hide(currentFragment);
        }
        if(fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment);
        } else {
            transaction.show(fragment);
        }
        transaction.commit();
        currentFragment = fragment;
    }

}