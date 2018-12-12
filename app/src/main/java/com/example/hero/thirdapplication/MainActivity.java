package com.example.hero.thirdapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        EditText edtName=findViewById(R.id.edtNeme);
        EditText edtAge=findViewById(R.id.edtAge);
        EditText edtSite=findViewById(R.id.edtSite);
        Button button=findViewById(R.id.btn);

        final String name =edtAge.getText().toString();
        final String age = edtName.getText().toString();
        final String site =edtSite.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecoundActivity.class);
                startActivityForResult(intent,150);

                intent.putExtra("name",name);
                intent.putExtra("age",age);
                intent.putExtra("site",site);
            }
        });

        Button btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Dialog   are u sure u wanna leave the application?

                AlertDialog dialog=new AlertDialog.Builder(MainActivity.this).create();
                dialog.setTitle("Exit!");
                dialog.setMessage("Are you sure to exit the application?");
                dialog.setButton(AlertDialog.BUTTON_POSITIVE, "yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         //khrooj az application
                    }
                });
                dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
            }
        });




    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==150){
            if (resultCode==Activity.RESULT_OK){
                String resault=data.getStringExtra("successful");
                Toast.makeText(MainActivity.this, resault,Toast.LENGTH_LONG).show();

            }
            if (requestCode==Activity.RESULT_CANCELED){
                String resault=data.getStringExtra("canceled") ;
                Toast.makeText(MainActivity.this,resault,Toast.LENGTH_LONG).show();
            }
        }
    }
}
