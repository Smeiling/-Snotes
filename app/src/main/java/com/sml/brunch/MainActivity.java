package com.sml.brunch;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sml.brunch.adapter.BrunchViewPagerAdapter;
import com.sml.brunch.adapter.FragmentAdapter;
import com.sml.brunch.fragment.BrunchPickedFragment;
import com.sml.brunch.fragment.BrunchRecommendFragment;
import com.sml.brunch.fragment.BrunchSplitFragment;
import com.sml.brunch.fragment.RankListFragment;
import com.sml.brunch.widget.BrunchViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_view_pager);

        Button button = (Button) findViewById(R.id.buttonPanel);
        final BrunchViewPager viewPager = (BrunchViewPager) findViewById(R.id.viewpager);
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

        fragments.add(new BrunchPickedFragment());
        fragments.add(new BrunchRecommendFragment());
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
}
