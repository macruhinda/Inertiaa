package com.example.inertia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class SohoLoc extends AppCompatActivity {
    InputStream files;
    TextView textView;
    Button codeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soho_loc);

        textView=findViewById(R.id.theC);
        codeBtn=findViewById(R.id.CodV);


        //AssetManager assetManager=getAssets();

        codeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Cods="";

                    try{
                        // files=assetManager.open("addanumber.c");
                        files=getAssets().open("addanumber.c");
                        int chrz=files.available();
                        byte[] macstore=new byte[chrz];
                        files.read(macstore);
                        files.close();
                        Cods=new String(macstore);

                    }catch (IOException mac){
                        mac.printStackTrace();
                    }
                    textView.setText((CharSequence) Cods);


            }
        });



    }

}
