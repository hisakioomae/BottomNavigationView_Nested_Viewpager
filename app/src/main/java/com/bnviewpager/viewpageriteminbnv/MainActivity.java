package com.bnviewpager.viewpageriteminbnv;

import android.os.Bundle;
import android.support.annotation.IdRes;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String FRAGMENT_VIEWPAGER = "FRAGMENT_VIEWPAGER";
    public static final String FRAGMENT_FIRST = "FRAGMENT_FIRST";
    public static final String FRAGMENT_SECOND = "FRAGMENT_SECOND";

    private BottomNavigation BottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView = (BottomNavigation) findViewById(R.id.navigation);
        BottomNavigationView.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(@IdRes int i, int i1, boolean b) {
                switch (i1) {
                    case 0:
                        replaceFragment(FirstFragment.newInstance(),FRAGMENT_FIRST);
                        break;
                    case 1:
                        replaceFragment(SecondFragment.newInstance(),FRAGMENT_SECOND);
                        break;
                    case 2:
                        replaceFragment(ViewPagerFragment.newInstance(),FRAGMENT_VIEWPAGER);
                        break;
                    case 3:
                        replaceFragment(ViewPagerFragment.newInstance(),FRAGMENT_VIEWPAGER);
                        break;
                }
            }

            @Override
            public void onMenuItemReselect(@IdRes int i, int i1, boolean b) {

            }
        });

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, FirstFragment.newInstance(), FRAGMENT_FIRST).commit();//最初はadd
    }

    private void replaceFragment(Fragment newFragment, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, newFragment, tag).commit();
    }
}
