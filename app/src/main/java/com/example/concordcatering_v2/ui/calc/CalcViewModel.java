package com.example.concordcatering_v2.ui.calc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalcViewModel extends ViewModel{
    private MutableLiveData<String> mText;

    public CalcViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Calc fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
