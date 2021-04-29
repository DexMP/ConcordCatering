package com.example.concordcatering_v2.ui.calc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.concordcatering_v2.R;
import com.example.concordcatering_v2.ui.contacts.ContactsViewModel;

public class CalcFragment extends Fragment {

    private CalcViewModel calcViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calcViewModel =
                new ViewModelProvider(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calc, container, false);
        final TextView textView = root.findViewById(R.id.text_calc);
        calcViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}