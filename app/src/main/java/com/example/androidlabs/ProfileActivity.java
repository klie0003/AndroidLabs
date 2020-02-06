package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE=1;
    ImageButton mImageButton;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton btn = (ImageButton)findViewById(R.id.pictureButton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View bV){
                dispatchTakePictureIntent();
            }
        });

        mImageButton = (ImageButton)findViewById(R.id.pictureButton);

        Log.e(ACTIVITY_NAME, "In function: onCreate");
    }

    public void onStart(){
        super.onStart();
        Log.e(ACTIVITY_NAME, "In function: onStart");
    }

    public void onPause(){
        super.onPause();
        Log.e(ACTIVITY_NAME, "In function: onPause");
    }

    public void onStop(){
        super.onStop();
        Log.e(ACTIVITY_NAME, "In function: onStop");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "In function: onDestroy");
    }

    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
        }
        Log.e(ACTIVITY_NAME, "In function: onActivityResult");
    }

}
