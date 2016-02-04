package com.wirasetiawan.dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wira on 2/3/16.
 */
public class MyDialogFragment extends DialogFragment {
    private ViewPager viewPager;
    private ViewPagerArrowIndicator viewPagerArrowIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        getDialog().setTitle("Simple Dialog");
        return rootView;

        viewPager = (ViewPager) getActivity().findViewById(R.id.viewPager);
        viewPagerArrowIndicator = (ViewPagerArrowIndicator) getActivity().findViewById(R.id.viewPagerArrowIndicator);
        viewPager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));

        viewPagerArrowIndicator.bind(viewPager);

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int pos) {
            switch(pos) {
                case 0:
                    return Fragment.newInstance("Halaman 1");
                case 1:
                    return Fragment.newInstance("Halaman 2");
                case 2:
                    return Fragment.newInstance("Halaman 3");
                case 3:
                    return Fragment.newInstance("Halaman 4");
                default:
                    return Fragment.newInstance("Halaman 5");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}