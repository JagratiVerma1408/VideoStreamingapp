package com.example.netflix.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflix.Mainscreens.Mainscreen;
import com.example.netflix.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PaymentOverdue extends AppCompatActivity {

    TextView Signin;
    Button paybutton;
    RadioButton radiobasic,radiostandard,radiopremium;
    String planname, plancost,planformatofcost,Intfirstname,Intlastname,IntUid,Intemail,Intcontact;
    Date today,validate;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String TAG="payment error";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_overdue);
        getSupportActionBar().hide();
        Intent i=getIntent();
        Intfirstname=i.getStringExtra("firstname");
        Intlastname=i.getStringExtra("lastname");
        IntUid=i.getStringExtra("Uid");
        Intemail=i.getStringExtra("email");
        Intcontact=i.getStringExtra("contact");
        Signin=findViewById(R.id.signinstepone);
        paybutton=findViewById(R.id.continuebuttonchooseplan);
        radiobasic=findViewById(R.id.radiobuttonforbasic);
        radiostandard=findViewById(R.id.radiobuttonforstandard);
        radiopremium=findViewById(R.id.radiobuttonforpremium);
        radiobasic.setOnCheckedChangeListener(new PaymentOverdue.Radio_check());
        radiostandard.setOnCheckedChangeListener(new PaymentOverdue.Radio_check());
        radiopremium.setOnCheckedChangeListener(new PaymentOverdue.Radio_check());
        radiopremium.setChecked(true);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        Calendar c=Calendar.getInstance();
        today=c.getTime();
        c.add(Calendar.MONTH,1);
        validate=c.getTime();
        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PaymentOverdue.this, SigninActivity.class);
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
    public void startPayment(){
        progressDialog=new ProgressDialog(PaymentOverdue.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);
        Checkout checkout=new Checkout();
        final Activity activity=this;
        String name=Intfirstname+Intlastname;
        try{
            JSONObject options=new JSONObject();
            options.put("name",name);
            options.put("description","APP PAYMENT");
            options.put("currency","INR");
            String payment=plancost;
            double total=Double.parseDouble(payment);
            total=total*100;
            options.put("amount",total);
            options.put("prefill.email",Intemail);
            options.put("prefill.contact",Intcontact);
            checkout.open(activity,options);

        }catch(Exception e){
            Log.e(TAG,"error occures",e);
        }
    }

    public void onPaymentSuccess(String s) {

                    DocumentReference documentReference=firebaseFirestore.collection("Users").document(IntUid);
                    Map<String,Object> user= new HashMap<>();
                    user.put("Email",Intemail);
                    user.put("First_Name",Intfirstname);
                    user.put("Last_name",Intlastname);
                    user.put("Plan_cost",plancost);
                    user.put("Contact_number",Intcontact);
                    user.put("Valid_date",validate);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Intent i = new Intent(PaymentOverdue.this, Mainscreen.class);
                            startActivity(i);
                            progressDialog.cancel();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if(e instanceof FirebaseNetworkException)
                            {Toast.makeText(getApplicationContext(),"No internet connection",Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();}
                            Toast.makeText(getApplicationContext(),"Values not stored",Toast.LENGTH_SHORT).show();
                            progressDialog.cancel();

                        }
                    });


    }

    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "payment unsucessfull", Toast.LENGTH_SHORT).show();
        progressDialog.cancel();
    }
}