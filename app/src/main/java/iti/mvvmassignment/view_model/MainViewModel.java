package iti.mvvmassignment.view_model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import iti.mvvmassignment.model.CounterModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<CounterModel> counterModelMutableLiveData;

    CounterModel counterModel = new CounterModel();
    public MutableLiveData<CounterModel> getCounterValue() {

        if (counterModelMutableLiveData == null) {
            counterModelMutableLiveData = new MutableLiveData<>();
        }
        return counterModelMutableLiveData;

    }

    public void onClick(View view) {
        counterModel.incrementCount();
        counterModelMutableLiveData.setValue(counterModel);

    }

}
