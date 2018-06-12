package com.aslan.amani.amanidiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aslan.amani.amanidiet.data.Advice;
import com.aslan.amani.amanidiet.data.AdviceAdapter;
import com.aslan.amani.amanidiet.data.ExerciseAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListofAdvice extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private ListView listView;
    private AdviceAdapter adviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_advice);

        listView = (ListView) findViewById(R.id.listview);
        adviceAdapter= new AdviceAdapter(this, R.layout.item_advice);
        mAuth= FirebaseAuth.getInstance();
        listView.setAdapter(adviceAdapter);
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
                adviceAdapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Advice a = ds.getValue(Advice.class);
                    Log.d("SL", a.toString());
                    adviceAdapter.add(a);
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
