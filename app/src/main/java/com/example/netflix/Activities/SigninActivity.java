package com.example.netflix.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.netflix.Mainscreens.Mainscreen;
import com.example.netflix.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class SigninActivity extends AppCompatActivity {
ProgressBar progressBar;
TextView  Sinuptextview,forgotpasswordtextview;
Button    signinbutton;
EditText email,password;
String resetemail,authemail,authpassword,UserID,FireContact,Firefirstname,Firelastname;
FirebaseAuth firebaseAuth;
FirebaseFirestore firebaseFirestore;
Date validate,today;
DocumentReference userRef;
    static int counter=0;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);
        progressBar=findViewById(R.id.signinprogressbar);
        progressBar.setVisibility(View.GONE);
       Sinuptextview=findViewById(R.id.singuptextview);
        forgotpasswordtextview=findViewById(R.id.forgotpasswordtextview);
        signinbutton=findViewById(R.id.signinbutton);
        email=findViewById(R.id.emailedittext);
        password=findViewById(R.id.passwordedittext);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        Calendar c=Calendar.getInstance();
        today=c.getTime();
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                authemail=email.getText().toString();
                authpassword=password.getText().toString();
                progressBar.setVisibility(View.VISIBLE);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                if(email.getText().toString().length()>8 && email.getText().toString().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") && password.getText().toString().length()>7)
                {

                    firebaseAuth.signInWithEmailAndPassword(authemail, authpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                UserID=firebaseAuth.getCurrentUser().getUid();
                                userRef=firebaseFirestore.collection("Users").document(UserID);
                                userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        validate=documentSnapshot.getDate("Valid_date");
                                        Firefirstname=documentSnapshot.getString("First_Name");
                                        Firelastname=documentSnapshot.getString("Last_name");
                                        FireContact=documentSnapshot.getString("Contact_number");
                                        if(validate.compareTo(today)>=0)
                                        {
                                            Intent i = new Intent(SigninActivity.this, Mainscreen.class);
                                            startActivity(i);
                                            progressBar.setVisibility(view.GONE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                        }
                                        else
                                        {
                                            Intent i= new Intent(SigninActivity.this,PaymentOverdue.class);
                                            i.putExtra("firstname",Firefirstname);
                                            i.putExtra("lastname",Firelastname);
                                            i.putExtra("contact",FireContact);
                                            i.putExtra("email",authemail);
                                            i.putExtra("Uid",UserID);
                                            startActivity(i);
                                            progressBar.setVisibility(view.GONE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                        }

                                    }
                                });

                            } else { if(task.getException() instanceof FirebaseNetworkException)
                                Toast.makeText(getApplicationContext(),"No internet connection",Toast.LENGTH_SHORT).show();
                            if(task.getException() instanceof FirebaseAuthInvalidUserException)
                            { email.setError("User does not exist");}
                                if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                              password.setError("Invalid Password");
                                progressBar.setVisibility(View.GONE);
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            }
                        }
                    });
                }
                else
                    {
                        if(email.getText().toString().length()<=7 ||!email.getText().toString().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") )
                        {email.setError("Enter a valid email id");
                            progressBar.setVisibility(View.GONE);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            }
                        if(password.getText().toString().length()<=7)
                        {password.setError("Wrong password");
                            progressBar.setVisibility(View.GONE);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                          }
                        if(email.getText().toString().length()==0)
                        {email.setError("Field cannot be empty");
                            progressBar.setVisibility(View.GONE);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                           }
                        if(password.getText().toString().length()==0)
                        {password.setError("Field cannot be empty");
                            progressBar.setVisibility(View.GONE);
                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            }
                        else
                        {
                            password.setError("Wrong password");
                        }
                        progressBar.setVisibility(View.GONE);
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);}
            }
        });
        Sinuptextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SigninActivity.this, SwipeScreen.class);
                startActivity(i);
            }
        });
        forgotpasswordtextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().length()>8 && email.getText().toString().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
                {
                    AlertDialog.Builder passwordreset= new AlertDialog.Builder(view.getContext());
                    passwordreset.setTitle("Reset Password?");
                    passwordreset.setMessage("Press YES to receive the reset link");
                    passwordreset.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetemail=email.getText().toString();
                            firebaseAuth.sendPasswordResetEmail(resetemail).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getApplicationContext(),"Email reset link sent",Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    if(e instanceof FirebaseNetworkException)
                                    { Toast.makeText(getApplicationContext(),"No internet connection",Toast.LENGTH_SHORT).show();}
                                    Toast.makeText(getApplicationContext(),"Email reset link not sent as no user exist by this email",Toast.LENGTH_SHORT).show();
                                }
                            });


                        }
                    });
                    passwordreset.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    passwordreset.create().show();

                }
                else
                {email.setError("Enter a valid email");}
            }
        });

    }
    public void progress(){
        final Timer timer =new Timer();
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if(counter==500){
                    timer.cancel();
                }

            }
        };
        timer.schedule(timerTask,0,100);
    }
}