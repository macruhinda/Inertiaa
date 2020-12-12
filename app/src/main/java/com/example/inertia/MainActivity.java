package com.example.inertia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final boolean TODO = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Cconsepts = (Button) findViewById(R.id.butnDrk);
        Cconsepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TheRecyc.class);
                startActivity(intent);
            }
        });


    }

    public void sendMessage(View view) {

        EditText message = (EditText) findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sohom, menu);

        Button Lbutton = (Button) findViewById(R.id.toNamesList);
        Lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TheList.class);
                startActivity(intent);
            }
        });
        return true;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.alm:
                startActivity(new Intent(this, AlarmClock.class));
                return true;
            case R.id.track:
                startActivity(new Intent(this, ServiceMe.class));
                return true;
            case R.id.Loc:
                startActivity(new Intent(this, SohoLoc.class));
                return true;
            case R.id.mail:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String towho[] = {"bvicxbax@gmail.com, markruhinda47@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, towho);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Kiki nawe");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello this is a stupid Guy");
                intent.setType("message/rfc822");
                startActivity(intent);
                return true;

            case R.id.call:
                Intent man = new Intent(Intent.ACTION_DIAL);
                man.setData(Uri.parse("tel:0706944635"));
             /*   if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    Activity#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for Activity#requestPermissions for more details.
                    return TODO;
                }*/
                startActivity(man);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
