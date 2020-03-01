package com.example.inertia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {


      /* Button drk=findViewById(R.id.buttonDrinks);
        drk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Adapter.class);
                startActivity(intent);
            }
        });
*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void sendMessage(View view){

        EditText message = (EditText)findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.sohom, menu);

        Button Lbutton=(Button)findViewById(R.id.toNamesList);
        Lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TheList.class);
                startActivity(intent);
            }
        });
        return true;

    }

    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Servicez:
                startActivity(new Intent(this, ServiceMe.class));
                return true;
            case R.id.Loc:
                startActivity(new Intent(this, SohoLoc.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
