package com.laily.simple_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.laily.simple_mvvm.R;
import com.laily.simple_mvvm.databinding.ActivityMainBinding;
import com.laily.simple_mvvm.utils.View;
import com.laily.simple_mvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewmodel(mainViewModel);
        binding.setLifecycleOwner(this);

        mainViewModel.getSegitiga().observe(this, segitiga->{
            if (segitiga.getHasil() != null) {
                View.toast(this, segitiga.getHasil().toString());
            }
        });
    }
}