package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MwbActivity extends AppCompatActivity {
    private EditText fullName, region, city, physicalAddress, contactNumber,complaint_info;
    private Button submitBtn;

    private DatabaseReference db;
// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mwb);
        db = FirebaseDatabase.getInstance().getReference();

        fullName = findViewById(R.id.fullname);
        region = findViewById(R.id.region);
        city = findViewById(R.id.city);
        physicalAddress = findViewById(R.id.physicalAddress);
        contactNumber = findViewById(R.id.contactNumber);
        complaint_info = findViewById(R.id.complaint_info);
        submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(view ->  saveUserDetails());
    }

    private void saveUserDetails() {
        String fullname = fullName.getText().toString();
        String regionn = region.getText().toString();
        String cityy = city.getText().toString();
        String physicalAddresss = physicalAddress.getText().toString();
        String contactNo = contactNumber.getText().toString();
        String complaintInformation = complaint_info.getText().toString();

        HashMap<String , String> userMap = new HashMap<>();

        userMap.put("fullname" , fullname);
        userMap.put("region" , regionn);
        userMap.put("city" , cityy);
        userMap.put("physicalAddress" , physicalAddresss);
        userMap.put("contactNumber" , contactNo);
        userMap.put("complaint_info" , complaintInformation);

        db.setValue(userMap);

        if(db.setValue(userMap).isSuccessful())
        {
            System.out.println("success");
            Toast.makeText(this,"Details submitted successfully",Toast.LENGTH_SHORT);
        }
        else
        {
            System.out.println("failed");
            Toast.makeText(this,"Failed to submmit details",Toast.LENGTH_SHORT);
        }

    }
}