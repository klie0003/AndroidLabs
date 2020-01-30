package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Switch;
import com.google.android.material.snackbar.Snackbar;


public class activity_main_grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);

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
}