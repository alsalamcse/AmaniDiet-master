package com.aslan.amani.amanidiet;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aslan.amani.amanidiet.data.Advice;
import com.aslan.amani.amanidiet.data.Exercise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddExercise extends AppCompatActivity {

    private EditText etPushUps;
    private EditText etPullups;
    private EditText etSquats;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        etPullups=(EditText)findViewById(R.id.etPullups);
        etPushUps=(EditText)findViewById(R.id.etPushUps);
        etSquats=(EditText)findViewById(R.id.etSquats);

        btnSave= (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });


    }

    public void dataHandler(){
        String stPullups=etPullups.getText().toString();
        String stPushups=etPushUps.getText().toString();
        String stSquats =etSquats.getText().toString();

        double pullups=Double.parseDouble(stPullups);
        double pushups=Double.parseDouble(stPushups);
        double squats=Double.parseDouble(stSquats);


        Exercise e= new Exercise();
        e.setPullups(Double.parseDouble(stPullups));
        e.setPushups(Double.parseDouble(stPushups));
        e.setSquats(Double.parseDouble(stSquats));

        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        e.setEmail(email);
        String key=reference.child("mylist").push().getKey();
        e.setKeyId(key);
        reference.child("mylist").child(key).setValue(e).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddExercise.this, "Add Exercise Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddExercise.this, "Add Exercise Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
