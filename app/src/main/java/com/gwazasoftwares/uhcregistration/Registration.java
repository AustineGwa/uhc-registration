package com.gwazasoftwares.uhcregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gwazasoftwares.uhcregistration.models.RegData;

public class Registration extends AppCompatActivity {

    private TextView name,dob, id, county, employer;
    private Spinner gender;
    Button register;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.nametxt);
        dob = findViewById(R.id.dobtxt);
        id  = findViewById(R.id.idno);
        gender = findViewById(R.id.gender);
        county = findViewById(R.id.countytxt);
        employer = findViewById(R.id.employertxt);
        register = findViewById(R.id.submit);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Sending data to Server...");

    }

    @Override
    protected void onStart() {
        super.onStart();

        register.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitDetails();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.adm){
            startActivity(new Intent(getApplicationContext(), Admin.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void submitDetails(){
        progressDialog.show();
        RegData regData = new RegData(
                name.getText().toString(),
                dob.getText().toString(),
                id.getText().toString(),
                gender.getSelectedItem().toString(),
                county.getText().toString(),
                employer.getText().toString());

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("kioko").child("uhc-registration");

        myRef.push().setValue(regData).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Data saved Successfully", Toast.LENGTH_LONG).show();
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
