package com.example.netflix.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netflix.R;

public class ChooseYourPlan extends AppCompatActivity {
    TextView Signin;
    Button  continuebutton;
    RadioButton radiobasic,radiostandard,radiopremium;
    String planname, plancost,planformatofcost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_plan);
        getSupportActionBar().hide();
        Signin=findViewById(R.id.signinstepone);
        continuebutton=findViewById(R.id.continuebuttonchooseplan);
        radiobasic=findViewById(R.id.radiobuttonforbasic);
        radiostandard=findViewById(R.id.radiobuttonforstandard);
        radiopremium=findViewById(R.id.radiobuttonforpremium);
        radiobasic.setOnCheckedChangeListener(new Radio_check());
        radiostandard.setOnCheckedChangeListener(new Radio_check());
        radiopremium.setOnCheckedChangeListener(new Radio_check());
        radiopremium.setChecked(true);
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChooseYourPlan.this,FinishUpAccount.class);
                i.putExtra("PlanName",planname);
                i.putExtra("PlanCost",plancost);
                i.putExtra("PlanCostFormat",planformatofcost);
                startActivity(i);
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChooseYourPlan.this, SigninActivity.class);
                startActivity(i);
            }
        });
    }
    class Radio_check implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked){
                if(compoundButton.getId()== R.id.radiobuttonforbasic){
                    planname="Basic";
                    plancost="349";
                    planformatofcost="₹ 349/month";
                    radiostandard.setChecked(false);
                    radiopremium.setChecked(false);
                }
                if(compoundButton.getId()== R.id.radiobuttonforstandard){
                    planname="Standard";
                    plancost="649";
                    planformatofcost="₹ 649/month";
                    radiobasic.setChecked(false);
                    radiopremium.setChecked(false);
                }
                if(compoundButton.getId()== R.id.radiobuttonforpremium){
                    planname="Premium";
                    plancost="799";
                    planformatofcost="₹ 799/month";
                    radiostandard.setChecked(false);
                    radiobasic.setChecked(false);
                }

            }
        }
    }
}