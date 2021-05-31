package com.example.netflix.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netflix.R;

public class FinishUpAccount extends AppCompatActivity {
   String PlanName,PlanCost,PlanCostFormat;
   TextView textView,Signin;
   Button continuebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_up_account);
        getSupportActionBar().hide();
        Intent i= getIntent();
        PlanName=i.getStringExtra("PlanName");
        PlanCost=i.getStringExtra("PlanCost");
        PlanCostFormat=i.getStringExtra("PlanCostFormat");
        textView=findViewById(R.id.step1of3finish);
        continuebutton=findViewById(R.id.continuefinish);
        Signin=findViewById(R.id.signinstepone);
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FinishUpAccount.this, SigninActivity.class);
                startActivity(i);
            }
        });
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FinishUpAccount.this, StepTwo.class);
                i.putExtra("PlanName",PlanName);
                i.putExtra("PlanCost",PlanCost);
                i.putExtra("PlanCostFormat",PlanCostFormat);
                startActivity(i);
            }
        });
        SpannableString st=new SpannableString("STEP 2 OF 3");
        StyleSpan boldspan=new StyleSpan(Typeface.BOLD);
        StyleSpan boldspan1=new StyleSpan(Typeface.BOLD);
        st.setSpan(boldspan,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        st.setSpan(boldspan1,10,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(st);



    }
}