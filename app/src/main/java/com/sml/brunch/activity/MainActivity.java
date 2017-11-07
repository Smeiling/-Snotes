package com.sml.brunch.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sml.brunch.R;
import com.sml.brunch.adapter.BrunchViewPagerAdapter;
import com.sml.brunch.adapter.FragmentAdapter;
import com.sml.brunch.fragment.BrunchSplitFragment;
import com.sml.brunch.fragment.FullBackgroundFragment;
import com.sml.brunch.fragment.HalfBackgroundFragment;
import com.sml.brunch.fragment.RankListFragment;
import com.sml.brunch.widget.HorizontalViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout = null;
    private ImageView ivMenu;
    private HorizontalViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_view_pager);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        ivMenu = findViewById(R.id.iv_menu);
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            /**
             * 当抽屉滑动状态改变的时候被调用
             * 状态值是STATE_IDLE（闲置--0）, STATE_DRAGGING（拖拽的--1）, STATE_SETTLING（固定--2）中之一。
             * 抽屉打开的时候，点击抽屉，drawer的状态就会变成STATE_DRAGGING，然后变成STATE_IDLE
             */
            @Override
            public void onDrawerStateChanged(int arg0) {
                Log.i("drawer", "drawer的状态：" + arg0);
            }

            /**
             * 当抽屉被滑动的时候调用此方法
             * arg1 表示 滑动的幅度（0-1）
             */
            @Override
            public void onDrawerSlide(View arg0, float arg1) {
                Log.i("drawer", arg1 + "");
            }

            /**
             * 当一个抽屉被完全打开的时候被调用
             */
            @Override
            public void onDrawerOpened(View arg0) {
                Log.i("drawer", "抽屉被完全打开了！");
            }

            /**
             * 当一个抽屉完全关闭的时候调用此方法
             */
            @Override
            public void onDrawerClosed(View arg0) {
                Log.i("drawer", "抽屉被完全关闭了！");
            }
        });


        Button button = (Button) findViewById(R.id.buttonPanel);
        viewPager = (HorizontalViewPager) findViewById(R.id.viewpager);
        assert viewPager != null;
        viewPager.setPageMargin(80);
        viewPager.setOffscreenPageLimit(3);
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.a);
        list.add(R.mipmap.b);
        list.add(R.mipmap.c);
        list.add(R.mipmap.d);
        list.add(R.mipmap.e);
        list.add(R.mipmap.f);

        final BrunchViewPagerAdapter adapter = new BrunchViewPagerAdapter(this, list);

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new HalfBackgroundFragment());
        fragments.add(new FullBackgroundFragment());
        fragments.add(new BrunchSplitFragment());
        fragments.add(new RankListFragment());
        FragmentAdapter adapter1 = new FragmentAdapter(getSupportFragmentManager(), fragments);

        viewPager.setAdapter(adapter1);
        viewPager.addOnPageChangeListener(adapter);

        adapter.setOnTouchListener(new BrunchViewPagerAdapter.OnTouchListener() {
            @Override
            public void onVerticalFling(int offsetPosition) {
                viewPager.setVertical(true);
                viewPager.setCurrentItem(adapter.getPosition() + offsetPosition);
                Log.d("sml", "onVerticalFling position = " + offsetPosition);
            }

            @Override
            public void onHorizontalFling(int offsetPosition) {
                viewPager.setVertical(false);
                viewPager.setCurrentItem(adapter.getPosition() + offsetPosition);
                Log.d("sml", "onHorizontalFling position = " + offsetPosition);
            }
        });

        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setVertical(!viewPager.isVertical());
                adapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mDrawerLayout != null) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawers();
            } else super.onBackPressed();
        }
    }
}
