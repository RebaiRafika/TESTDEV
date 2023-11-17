package com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.Controller;

import android.widget.RadioButton;
import android.widget.SeekBar;

import com.example.rafika_rebai_lsi3_devmobil_mesure_glycemie.model.Patient;
public class Controller {
    private static Patient patient;
    public Controller()
    {
        super();
    }
    public void create_patient(int age ,float valeur , boolean isFasting){
        patient=new Patient(age,valeur,isFasting) ;
    }
    //update entre le controller vers la view
    public String getResult(){

        return patient.getResult();//update patient to controller
    }

}