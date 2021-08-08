package com.example.newandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MyActivity extends AppCompatActivity {
    Button btnLogin;
    TextInputLayout inputTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

        System.out.println(data);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        btnLogin = findViewById(R.id.button);
        inputTextEmail = findViewById(R.id.filledTextFieldEmail);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                printText(inputTextEmail.getEditText().getText().toString());
                System.out.println("vonclick view" );
                Intent intent = new Intent();
                intent.putExtra("LatLng", "vantu");
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    private void printText(String text){
        new progressdata().execute(10);
    }
    private class progressdata extends AsyncTask<Integer, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("start\n");
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for(int i = 0; i < integers[0]; i++){
                this.publishProgress("task "+ i+"\n");
            }
            return "xong\n";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            System.out.println(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println(s);
        }
    }
}