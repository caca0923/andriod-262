package com.example.simpleui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DrinkMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

    }

    public void add(View view){
        Button button = (Button)view;
        int number = Integer.parseInt(button.getText().toString());
        number++;
        button.setText(String.valueOf(number));

    }

    public void getData(){
        LinearLayout rootLinearLayout =
                (LinearLayout) findViewById(R.id.root);
        int ccount = = rootLinearLayout.getChildCount();

        JSONArray array = new JSONArray();

        for (int i = 0 ; i < count - 1 ; i++) {
            LinearLayout ll = (LinearLayout)
                    rootLinearLayout.getChildAt(i);

            TextView drinkNameTextView = (TextView) ll.getChildAt(0);
            Button lButton = (Button) ll.getChildAt(1);
            Button mButton = (Button) ll.getChildAt(2);


            String drinkName = drinkNameTextView.getText().toString();
            int lNomber = Integer.parseInt((lButton.getText().toString()));
            int mNomber = Integer.parseInt((mButton.getText().toString()));

            JSONObject object = new JSONObject();
            try {
                object.put("name",drinkName);
                object.put("l",lNomber);
                object.put("m",mNomber);
                array.put(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return array;

    }

}
