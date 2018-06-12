package com.aslan.amani.amanidiet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btnEx,btnMeal,btnAdvice,Progress;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnMeal = (Button) findViewById(R.id.btnMeals);
        btnEx = (Button) findViewById(R.id.btnEx);
        btnAdvice = (Button) findViewById(R.id.btnAdvice);
        Progress=(Button)findViewById(R.id.Progress);
        Progress.setOnClickListener(this);
        btnMeal.setOnClickListener(this);
        btnEx.setOnClickListener(this);
        btnAdvice.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnItmAddAdvice:
                Intent i = new Intent(this, AddAdvice.class);
                startActivity(i);
                break;
            case R.id.mnItmAddExercise:
                Intent i1 = new Intent(this, AddExercise.class);
                startActivity(i1);
                break;
            case R.id.mnItmAddMeal:
                Intent i2 = new Intent(this, AddMeal.class);
                startActivity(i2);
                break;
            case R.id.mnSignOut:
                mAuth.signOut();
                Intent s = new Intent(this, MainActivity.class);
                startActivity(s);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {

        if (v==btnEx) {
            Intent i = new Intent(this, ListofExercise.class);
            startActivity(i);
        }

        if (v==btnAdvice) {
            Intent i2 = new Intent(this, ListofAdvice.class);
            startActivity(i2);
        }

        if (v==btnMeal) {
            Intent i3 = new Intent(this, ListofMeals.class);
            startActivity(i3);
        }
        if (v==Progress){
            Intent i4= new Intent(this, progress.class);
            startActivity(i4);

        }


    }
}
