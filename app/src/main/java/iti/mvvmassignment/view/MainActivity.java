package iti.mvvmassignment.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import iti.mvvmassignment.R;
import iti.mvvmassignment.databinding.ActivityMainBinding;
import iti.mvvmassignment.model.CounterModel;
import iti.mvvmassignment.view_model.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setMainViewModel(mainViewModel);
        mainViewModel.getCounterValue().observe(this, new Observer<CounterModel>() {
            @Override
            public void onChanged(@Nullable CounterModel counterModel) {
                String countString=""+counterModel.getCount();
                binding.counterTextView.setText(countString);
            }
        });
    }
}
