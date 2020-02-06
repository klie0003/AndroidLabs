package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Context;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    SharedPreferences saveEmail;
    EditText emailIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        emailIn = (EditText) findViewById(R.id.input_address);

        saveEmail = getSharedPreferences("input_address", Context.MODE_PRIVATE);
        if (saveEmail.contains(null)) {
            emailIn.setText(saveEmail.getString("input_address", ""));
        }

        Button lBtn = (Button)findViewById(R.id.loginButton);
        lBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View bV){
                Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
                goToProfile.putExtra("EMAIL", "@string/input_email");
            }
        });

        Intent fromMain = getIntent();
        fromMain.getStringExtra("EMAIL");
        emailIn.setText(Intent.EXTRA_TEXT);

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View bV){
                bV.getResources().getString(R.string.toast_message);
            }
        });

        Switch swh = (Switch)findViewById(R.id.switch1);
        swh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(final CompoundButton cb, final boolean b) {
                if (b) {
                    Snackbar.make(cb, getResources().getString(R.string.snackbar_on), Snackbar.LENGTH_SHORT)
                            .setAction(R.string.undo_message, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cb.setChecked(!b);
                                }
                            });
                } else {
                    Snackbar.make(cb, getResources().getString(R.string.snackbar_off), Snackbar.LENGTH_SHORT)
                            .setAction(R.string.undo_message, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cb.setChecked(!b);
                                }
                            });
                }
            }
        });
    }

    protected void onPause(){
        super.onPause();
        String em = emailIn.getText().toString();
        SharedPreferences.Editor editor = saveEmail.edit();
        editor.putString("input_address", em);
        editor.commit();
    }
}