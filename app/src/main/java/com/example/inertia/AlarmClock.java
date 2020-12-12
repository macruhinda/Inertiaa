package com.example.inertia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmClock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock);

    }

    public void alarmsetting(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.VIBRATE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.VIBRATE}, 5000);
        }

        EditText editText = findViewById(R.id.alarmtext);
        int z =Integer.parseInt(editText.getText().toString());

        Intent intent= new Intent(getApplicationContext(),MyBroad.class);

        PendingIntent pendingIntent;
        pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);

        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (z* 1000),pendingIntent);

        Toast.makeText(this," Your Alarm is set in"+  z +"seconds",Toast.LENGTH_LONG).show();

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1000:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Storage access Granted", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this,"Storage access Denied", Toast.LENGTH_SHORT).show();
                finish();



        }
    }

}
