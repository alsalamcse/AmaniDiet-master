package com.aslan.amani.amanidiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aslan.amani.amanidiet.data.ExerciseAdapter;
import com.aslan.amani.amanidiet.data.Meals;
import com.aslan.amani.amanidiet.data.MealsAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListofMeals extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private ListView listView;
    private MealsAdapter mealsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_meals);

        listView = (ListView) findViewById(R.id.listview);
        mealsAdapter= new MealsAdapter(this, R.layout.item_meals);
        mAuth= FirebaseAuth.getInstance();
        listView.setAdapter(mealsAdapter);
        readAndListen();
        listView.setOnItemClickListener(this);
    }

    private void readAndListen() {

        FirebaseUser user = mAuth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("mylist").orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mealsAdapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Meals m = ds.getValue(Meals.class);
                    Log.d("SL", m.toString());
                    mealsAdapter.add(m);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
