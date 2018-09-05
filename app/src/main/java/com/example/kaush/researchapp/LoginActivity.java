package com.example.kaush.researchapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private static boolean LOGIN_CODE_SET = false;

    private FirebaseAuth mAuth;
    private FirebaseUser mFirebaseUser;
    String[] permissions = new String[]{
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.RECEIVE_BOOT_COMPLETED,
            android.Manifest.permission.READ_CONTACTS,
            android.Manifest.permission.READ_CALL_LOG,
            android.Manifest.permission.WRITE_CALL_LOG,
    };
    int permissionCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mAuth.getCurrentUser();

        if (mFirebaseUser == null) {
            startActivity(new Intent(LoginActivity.this, PhoneActivity.class));
            finish();
        }

        requestPermission(permissions[permissionCount], permissionCount++);

        if (!LOGIN_CODE_SET) {
            Toast.makeText(this, "Please Set your Login Code.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    private void requestPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    permission)) {
            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{permission},
                        requestCode);
            }
        } else {
            if(permissionCount<permissions.length)
                requestPermission(permissions[permissionCount], permissionCount++);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(permissionCount<permissions.length)
            requestPermission(permissions[permissionCount], permissionCount++);
    }
}
