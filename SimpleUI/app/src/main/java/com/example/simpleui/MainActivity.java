package com.example.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputText1;
    private EditText inputText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText1 = (EditText)findViewById(R.id.inputText);
        inputText1.setText("12345");
        inputText2 = (EditText)findViewById(R.id.editText);
        inputText2.setText("54321");
    }

    public void submit(View view){
        String text = inputText1.getText().toString();
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}
