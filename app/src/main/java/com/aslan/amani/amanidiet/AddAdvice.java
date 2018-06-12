package com.aslan.amani.amanidiet;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aslan.amani.amanidiet.data.Advice;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAdvice extends AppCompatActivity {

    private EditText etType;
    private EditText weight;
    private Button btnSave;
    private Button graph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_advice);

        etType=(EditText)findViewById(R.id.etType);
        weight=(EditText)findViewById(R.id.weight);
        graph=(Button)findViewById(R.id.Progress);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }


    public void dataHandler(){
        String stAdvice=weight.getText().toString();
        String stType=etType.getText().toString();


        Advice a= new Advice();
        a.setAdvice(stAdvice);
        a.setType(stType);

        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        a.setEmail(email);
        String key=reference.child("mylist").push().getKey();
        a.setKeyId(key);
        reference.child("mylist").child(key).setValue(a).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddAdvice.this, "Add Advice Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddAdvice.this, "Add Advice Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



