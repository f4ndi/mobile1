package com.antum.tugas1;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

    }

    public void openMap(View v) {
        Uri uri = Uri.parse("geo:-7.002693, 110.437307?q=" + Uri.encode("Rambutan 1"));
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        it.setPackage("com.google.android.apps.maps");
        startActivity(it);
    }

    public void callphone(View v) {
        TextView edtphone = (TextView) findViewById(R.id.edtphone);
        String phone = edtphone.getText().toString();

        Uri uri = Uri.parse("tel:" + phone);
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }

    public void openEmail(View v) {
        TextView email =(TextView) findViewById(R.id.email);
        String Email = email.getText().toString();

        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,Email);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an App"));
    }
}

