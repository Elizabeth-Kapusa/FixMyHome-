package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class EscomActivity extends AppCompatActivity {
    private EditText fullName, region, city, physicalAddress, contactNumber,complaint_info;
    private Button submitBtn;

    private DatabaseReference db;
// ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escom);

        db = FirebaseDatabase.getInstance().getReference();

        fullName = findViewById(R.id.fullname);
        region = findViewById(R.id.region);
        city = findViewById(R.id.city);
        physicalAddress = findViewById(R.id.physicalAddress);
        contactNumber = findViewById(R.id.contactNumber);
        complaint_info = findViewById(R.id.complaint_info);
        submitBtn = findViewById(R.id.submit);
        submitBtn.setOnClickListener(view ->  saveUserDetails());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                sendSMS();
            }
            else{
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 1);
            }
        }
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

//        if(db.setValue(userMap).isSuccessful())
//        {
//            System.out.println("success");
//            Toast.makeText(this,"Details submitted successfully",Toast.LENGTH_SHORT);
//        }
//        else
//        {
//            System.out.println("failed");
//            Toast.makeText(this,"Failed to submmit details",Toast.LENGTH_SHORT);
//        }

    }
    private void sendSMS(){
        String contactNo = contactNumber.getText().toString().trim();
        String complaintInformation = complaint_info.getText().toString().trim();
        String physicalAddresss = physicalAddress.getText().toString().trim();
        String cityyy = city.getText().toString().trim();
        String regionn = region.getText().toString().trim();
        String fullname = fullName.getText().toString().trim();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(contactNo,null,complaintInformation,null, null);
            Toast.makeText(this, "Complaint sent Successfully", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to send Complaint", Toast.LENGTH_SHORT).show();
        }

    }
}
