package com.example.simpleui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputText1;
    private EditText inputText2;
    private CheckBox hideCheckBox;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("setting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        inputText1 = (EditText)findViewById(R.id.inputText);
        inputText1.setText("12345");
        inputText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    if(keyCode == KeyEvent.KEYCODE_ENTER){
                        submit(v);
                        return true;
                    }
                }
                return false;
            }
        });
        inputText2 = (EditText)findViewById(R.id.editText);
        //inputText2.setText("54321");
        inputText2.setText(sharedPreferences.getString("inputText","??"));

        hideCheckBox = (CheckBox)findViewById(R.id.hideCheckBox);
        hideCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("hideCheckBox",isChecked);
                editor.commit();
            }
        });
        hideCheckBox.setChecked(sharedPreferences.getBoolean("hideCheckBox",false));
        //hideCheckBox.setChecked(true);

    }

    public void submit(View view){
        String text = inputText1.getText().toString();
        editor.putString("inputText",text);
        editor.commit(); //要加上commit才能寫入

        Utils.writeFile(this, "history.txt", text + "\n");

        //檢查hide有沒勾
        if(hideCheckBox.isChecked()){
            text = "*********";
            inputText1.setText("*********");
        }

        //顯示text資料
        //Toast.makeText(this,text,Toast.LENGTH_LONG).show();

        // 從history.txt 取出submit內容
        String fileContent = Utils.readFile(this,"history.txt");
        Toast.makeText(this,fileContent,Toast.LENGTH_LONG).show();
        //inputText1.setText("");
    }
}
