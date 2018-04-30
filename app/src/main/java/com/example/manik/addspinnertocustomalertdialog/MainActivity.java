package com.example.manik.addspinnertocustomalertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.but);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this,R.style.AppTheme);

                View v=getLayoutInflater().inflate(R.layout.spinner,null);
                adb.setTitle("Spinner in custom dialog");
                final Spinner mspin=(Spinner)v.findViewById(R.id.spin);
                ArrayAdapter<String> adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.laguages));
                //adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspin.setAdapter(adap);


                adb.setPositiveButton("yes",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if(!mspin.getSelectedItem().toString().equalsIgnoreCase("C"))
                            Toast.makeText(getApplicationContext(),mspin.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                    }});

                adb.setNegativeButton("No",new DialogInterface.OnClickListener()
                {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                adb.setView(v);
                //getWindow().setBackgroundDrawableResource(android.R.color.holo_green_dark);
                //After Creating and setting the Dialog Builder,now create an alert dialog by calling the create() method of the builder class
                AlertDialog alertDialog = adb.create();

                alertDialog.show();
            }
        });
    }}
