package com.moringaschool.one_clickpick.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.moringaschool.one_clickpick.R;
import com.moringaschool.one_clickpick.adapters.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.orderNowButton) Button mOrderNowButton;
    @BindView(R.id.mainPageTabLayout) TabLayout tabLayout;
    @BindView(R.id.viewPagerMainPage) ViewPager viewPager;
    @BindView(R.id.searchIcon) ImageView mSearchIcon;
    @BindView(R.id.enterSearch) EditText mEnterSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mOrderNowButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

//        mSearchIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String beerName = mEnterSearch.getText().toString();
//                Intent intent = new Intent(MainActivity.this, SearchedItemActivity.class);
//                intent.putExtra("beerName", beerName);
//                startActivity(intent);
//            }
//        });


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentPopular(), "Popular");
        adapter.addFragment(new FragmentLatest(), "Latest");
        adapter.addFragment(new FragmentCategories(), "Wish list");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
