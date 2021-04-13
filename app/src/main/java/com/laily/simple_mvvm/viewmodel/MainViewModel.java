package com.laily.simple_mvvm.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laily.simple_mvvm.model.Segitiga;
import com.laily.simple_mvvm.utils.View;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> etAlas = new MutableLiveData<>();
    public MutableLiveData<String> etTinggi = new MutableLiveData<>();
    public MutableLiveData<String> etSisiA = new MutableLiveData<>();
    public MutableLiveData<String> etSisiB = new MutableLiveData<>();
    public MutableLiveData<String> etSisiC = new MutableLiveData<>();
    private MutableLiveData<Segitiga> segitigaMutableLiveData;

    public void btnLSegitiga(Context context) {

        if (etAlas.getValue() == null || etAlas.getValue().length() == 0 || etTinggi.getValue() == null ||
                etTinggi.getValue().length() == 0) {


            View.toast(context, "Harus Terisi Semua");
            return;

        }

        Double alas = Double.parseDouble(etAlas.getValue());
        Double tinggi = Double.parseDouble(etTinggi.getValue());
        Double hasilLuas = (alas * tinggi) / 2;

        Segitiga segitiga = new Segitiga (alas,tinggi,0.0,0.0,0.0,hasilLuas);
        segitigaMutableLiveData.setValue(segitiga);
    }
    public void btnKSegitiga(Context context) {

        if (etSisiA.getValue() == null || etSisiA.getValue().length() == 0 || etSisiB.getValue() == null ||
                etSisiB.getValue().length() == 0 || etSisiC.getValue()==null||etSisiC.getValue().length()==0) {


            View.toast(context, "Harus Terisi Semua");
            return;

        }

        Double sisiA = Double.parseDouble(etSisiA.getValue());
        Double sisiB = Double.parseDouble(etSisiB.getValue());
        Double sisiC = Double.parseDouble(etSisiC.getValue());

        Double hasilKeliling= sisiA +sisiB+sisiC;

        Segitiga segitiga = new Segitiga(0.0,0.0,sisiA,sisiB,sisiC,hasilKeliling);
        segitigaMutableLiveData.setValue(segitiga);
    }
    public LiveData <Segitiga> getSegitiga(){
        if (segitigaMutableLiveData==null){
            segitigaMutableLiveData= new MutableLiveData<>();
        }
        return  segitigaMutableLiveData;
    }
}

