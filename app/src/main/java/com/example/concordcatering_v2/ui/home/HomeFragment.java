package com.example.concordcatering_v2.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.concordcatering_v2.R;
import com.example.concordcatering_v2.ui.home.pager.ViewPagerFragment;

import static com.example.concordcatering_v2.data.Consts.ARGUMENT_PAGE_NUMBER;
import static com.example.concordcatering_v2.data.Consts.PAGE_COUNT;
import static com.example.concordcatering_v2.data.Consts.TAG;

public class HomeFragment extends Fragment {

    // UI
    ViewPager pager;
    PagerAdapter pagerAdapter;

    // Var

    // ViewModel
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        pager = (ViewPager) root.findViewById(R.id.view_pager);
        updatePager();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        updatePager();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        pager.setCurrentItem(0);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pager.setCurrentItem(0);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ViewPagerFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }

    private void updatePager() {
        pagerAdapter = new MyFragmentPagerAdapter(getFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(0);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

}