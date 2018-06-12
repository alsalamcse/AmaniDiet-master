package com.aslan.amani.amanidiet;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aslan.amani.amanidiet.data.Advice;
import com.aslan.amani.amanidiet.data.Meals;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMeal extends AppCompatActivity {

    private EditText etDescripe,etTime;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        etDescripe = (EditText)findViewById(R.id.etDescripe);
        etTime = (EditText)findViewById(R.id.etTime);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

    public void dataHandler(){
        String stAdvice=etDescripe.getText().toString();
        String stType=etTime.getText().toString();


        Meals m= new Meals();
        m.setDescription(stAdvice);
        m.setTime(stType);

        FirebaseAuth auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        m.setEmail(email);
        String key=reference.child("mylist").push().getKey();
        m.setKeyId(key);
        reference.child("mylist").child(key).setValue(m).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddMeal.this, "Add Meal Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddMeal.this, "Add Meal Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
