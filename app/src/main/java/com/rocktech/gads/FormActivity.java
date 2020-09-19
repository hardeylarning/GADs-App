package com.rocktech.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormActivity extends AppCompatActivity {
   // private ImageView backImage;
    private EditText first,last,email,project;
    private Button submitBtn;
    private FormInterface formInterface;
    private static final String TAG = "FormActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        initValue();
        formInterface = ApiPost.postForm().create(FormInterface.class);
//        backImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FormActivity.this, LeaderBoardActivity.class);
//                startActivity(intent);
//            }
//        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                builder.setCancelable(false);
//                builder.setTitle(" ");
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(FormActivity.this);
                builder.setIcon(R.drawable.ic_cancel_black_24dp);
                builder.setMessage("Are you Sure ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        submitForm();
                        //dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
    }

    private void initValue(){
       // backImage = findViewById(R.id.back);
        first = findViewById(R.id.first);
        last = findViewById(R.id.last);
        email = findViewById(R.id.email);
        project = findViewById(R.id.project);
        submitBtn = findViewById(R.id.submitBtn);

    }
    //

    private  void submitForm(){
        Call<Form> call = formInterface.submitForm(email.getText().toString(),first.getText().toString(),last.getText().toString(),project.getText().toString());
        call.enqueue(new Callback<Form>() {
            @Override
            public void onResponse(Call<Form> call, Response<Form> response) {
                if (response.isSuccessful()){
                   // MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(FormActivity.this);
                   // builder = new MaterialAlertDialogBuilder(FormActivity.this);
                    Log.d(TAG, "onResponse: successful"+response.code());
                    Log.d(TAG, "onResponse: checkout"+response.body());
                    Toast.makeText(FormActivity.this, "Successfully sent", Toast.LENGTH_LONG).show();
//                    builder.setView(R.layout.image_view);
//                    builder.show();
                }
            }

            @Override
            public void onFailure(Call<Form> call, Throwable t) {
              //  MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(FormActivity.this);
               // builder = new MaterialAlertDialogBuilder(FormActivity.this);
                Log.d(TAG, "onFailure: failed"+t.getMessage());
                Toast.makeText(FormActivity.this, "Failed: "+t.getMessage(), Toast.LENGTH_LONG).show();
//                builder.setView(R.layout.failed_view);
//                builder.show();
            }
        });
    }


}
