package com.example.netflix.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.netflix.R;

public class StepThree extends AppCompatActivity {
    String PlanName,PlanCost,PlanCostFormat,UserEmailId,UserPassword;
    TextView Signout,textView;
    LinearLayout paymentlinearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_step_three);
        Intent i= getIntent();
        PlanName=i.getStringExtra("PlanName");
        PlanCost=i.getStringExtra("PlanCost");
        PlanCostFormat=i.getStringExtra("PlanCostFormat");
        UserEmailId=i.getStringExtra("EmailId");
        UserPassword=i.getStringExtra("Password");
        paymentlinearlayout=findViewById(R.id.paymentlinearlayout);
        textView=findViewById(R.id.stepthree);
      Signout=findViewById(R.id.signoutstepthree);
        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StepThree.this, SigninActivity.class);
                startActivity(i);
            }
        });
        SpannableString st=new SpannableString("STEP 3 OF 3");
        StyleSpan boldspan=new StyleSpan(Typeface.BOLD);
        StyleSpan boldspan1=new StyleSpan(Typeface.BOLD);
        st.setSpan(boldspan,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        st.setSpan(boldspan1,10,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(st);
       paymentlinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StepThree.this, PaymentGateway.class);
                i.putExtra("PlanName",PlanName);
                i.putExtra("PlanCost",PlanCost);
                i.putExtra("PlanCostFormat",PlanCostFormat);
                i.putExtra("EmailId",UserEmailId);
                i.putExtra("Password",UserPassword);
                startActivity(i);
            }
        });

    }
}