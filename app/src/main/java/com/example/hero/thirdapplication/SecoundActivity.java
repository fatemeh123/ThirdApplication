package com.example.hero.thirdapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        TextView txtName=findViewById(R.id.txtName);
        TextView txtAge=findViewById(R.id.txtAge);
        TextView txtsite=findViewById(R.id.txtSite);
        Button btnYes=findViewById(R.id.btnYes);
        Button btnNo=findViewById(R.id.btnNo);

        final Intent intent=getIntent();

        String name=intent.getStringExtra("name");
        txtName.setText(name);
        String age=intent.getStringExtra("age");

        String site=intent.getStringExtra("site");
        txtsite.setText(site);

        PreferenceManager.getDefaultSharedPreferences(SecoundActivity.this).edit().putString("name",name).apply();
        PreferenceManager.getDefaultSharedPreferences(SecoundActivity.this).edit().putString("age",age).apply();
        PreferenceManager.getDefaultSharedPreferences(SecoundActivity.this).edit().putString("site",site).apply();
        Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse(site));


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent();
                intent1.putExtra("successful","seccessful resault");
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent.putExtra("canceled","the resault is not successful");
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });



    }



}
