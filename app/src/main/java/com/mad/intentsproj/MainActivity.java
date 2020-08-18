package com.mad.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText no1;
    EditText no2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonnext);
        no1 = (EditText)findViewById(R.id.inputno1);
        no2 = (EditText)findViewById(R.id.inputno2);

        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.customtoast, (ViewGroup)
                findViewById(R.id.custom_toast_layout));
        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Context context = getApplicationContext();

                CharSequence message = "You just clicked the OK button";

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);

                String text1 = no1.getText().toString();
                String text2 = no2.getText().toString();

                intent.putExtra("NUMBER1", text1);
                intent.putExtra("NUMBER2", text2);
                startActivity(intent);
            }
        });

    }
}