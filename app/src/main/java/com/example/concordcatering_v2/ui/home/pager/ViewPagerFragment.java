package com.example.concordcatering_v2.ui.home.pager;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.concordcatering_v2.R;

import java.io.PrintWriter;

import static com.example.concordcatering_v2.data.Consts.ARGUMENT_PAGE_NUMBER;

public class ViewPagerFragment extends Fragment {

    // UI
    View view;
    ImageView background;
    ImageView logo;
    TextView tvPage;

    // Var
    int pageNumber;

    public static ViewPagerFragment newInstance(int page) {
        ViewPagerFragment pageFragment = new ViewPagerFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);

        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_pager, null);
        initData();
        updateView();
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateView();
    }

    protected void updateView() {
        tvPage.setText("Page " + pageNumber);

        if (pageNumber == 0) {
            background.setImageResource(R.drawable.slide_1);
            logo.setVisibility(View.VISIBLE);
        } else if (pageNumber == 1) {
            background.setImageResource(R.drawable.slide_2);
            logo.setVisibility(View.GONE);
        } else if (pageNumber == 2) {
            background.setImageResource(R.drawable.slide_3);
            logo.setVisibility(View.GONE);
        }
    }

    protected void initData() {
        background = (ImageView) view.findViewById(R.id.ViewPager_background);
        logo = (ImageView) view.findViewById(R.id.ViewPager_logo);
        tvPage = (TextView) view.findViewById(R.id.ViewPager_text);
    }
}