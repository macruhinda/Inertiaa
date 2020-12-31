package com.example.inertia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {
    ListView saved_messag;
    EditText textV;
    Button sendBut;


    Subaru subaru;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        saved_messag = findViewById(R.id.saved_message);

        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
       // TextView messageView =(TextView)findViewById(R.id.messageTextView);
       // messageView.setText(message);



        textV = findViewById(R.id.editText);
        sendBut =  findViewById(R.id.saving);
        final Subaru subaru = new Subaru(DisplayMessageActivity.this);
        arrayList = subaru.allcomment();
        arrayAdapter = new ArrayAdapter(DisplayMessageActivity.this,android.R.layout.activity_list_item,arrayList);
        saved_messag.setAdapter(arrayAdapter);

        sendBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt2 = textV.getText().toString();
                if (!txt2.isEmpty()){
                    if(subaru.addcomment(txt2)){
                        textV.setText("");
                        Toast.makeText(getApplicationContext(),"saved....",Toast.LENGTH_SHORT).show();
                        arrayList.clear();
                        arrayList.addAll(subaru.allcomment());

                        arrayAdapter.notifyDataSetChanged();
                        saved_messag.invalidateViews();
                        saved_messag.refreshDrawableState();

                    }

                }
            }
        });
    }
    public void onClose(View view) {
        super.finish();

    }
}
