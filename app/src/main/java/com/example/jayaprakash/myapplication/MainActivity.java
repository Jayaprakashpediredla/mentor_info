package com.example.jayaprakash.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

//import com.theartofdev.edmodo.cropper.CropImage;
// com.theartofdev.edmodo.cropper.CropImageView;

public class MainActivity extends AppCompatActivity {


    EditText mEdtName,mEdtRoll,mEdtPhn,mEdtCgpa,mEdtAttend,mEdtS1,mEdtS2,mEdtS3,mEdtS4,mEdtS5,mEdtS6,mEdtS7,mEdtS8;
    Button mBtnAdd,mBtnList;
    ImageView mImageView;

    final int REQUEST_CODE_GALLERY = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtName = findViewById(R.id.edtName);
        mEdtRoll = findViewById(R.id.edtRollno);
        mEdtPhn = findViewById(R.id.edtPhn);
        mEdtCgpa = findViewById(R.id.edtCgpa);
        mEdtAttend =findViewById(R.id.edtAttend);
        mEdtS1=findViewById(R.id.edtS1);
        mEdtS2=findViewById(R.id.edtS2);
        mEdtS3=findViewById(R.id.edtS3);
        mEdtS4=findViewById(R.id.edtS4);
        mEdtS5=findViewById(R.id.edtS5);
        mEdtS6=findViewById(R.id.edtS6);
        mEdtS7=findViewById(R.id.edtS7);
        mEdtS8=findViewById(R.id.edtS8);

        mBtnAdd=findViewById(R.id.btnAdd);
        mBtnList=findViewById(R.id.btnList);
        mImageView=findViewById(R.id.imageView);

        // Select image by clicking on image view
     mImageView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             //read external storage permission to select image from gallery
             //runtime permission for android 6.0 and later
             ActivityCompat.requestPermissions(
                     MainActivity.this,
                     new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                     REQUEST_CODE_GALLERY
             );

         }
     });
     mBtnAdd.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });

     mBtnList.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // gallery intent

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,REQUEST_CODE_GALLERY);
            }
            else
            {
                Toast.makeText(this, "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON) //enable image guidelines
            .setAspectRatio(1,1)//image will be square

            .start(this);

            if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){

                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if(resultCode == RESULT_OK){
                    Uri resultUri = result.getUri();
                    //set image choosed from gallery to image view
                    mImageView.setImageURI(resultUri);
                }
                else if(resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                    Exception error = result.getError();
                }
            }
        }
        
        super.onActivityResult(requestCode, resultCode, data);
    }*/
}
