package com.mad.intentsproj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

    EditText no1;
    EditText no2;
    //String takeExtra;
    Button plusBtn, minusBtn, multiplyBtn, divideBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        Intent intent = getIntent();
        no1 = (EditText) findViewById(R.id.inputno1);
        no2 = (EditText) findViewById(R.id.inputno2);
        plusBtn = findViewById(R.id.buttonplus);
        minusBtn = findViewById(R.id.buttonminus);
        multiplyBtn = findViewById(R.id.buttonmultiply);
        divideBtn = findViewById(R.id.buttondivide);

        //takeExtra = intent.getStringExtra("NAME1");



    }
    @Override
    protected void onResume() {

        super.onResume();
        no1.setText(getIntent().getStringExtra("NUMBER1"));
        no2.setText(getIntent().getStringExtra("NUMBER2"));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String addString1 = no1.getText().toString();
                String addString2 = no2.getText().toString();

                TextView addAnswer = (TextView)findViewById(R.id.calculation);

                Integer addAns = addCalculation(addString1,addString2);

                String addCalulation = String.valueOf(addAns);

                addAnswer.setText(addString1 + " + " + addString2 + " = " +addCalulation);

            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subString1 = no1.getText().toString();
                String subString2 = no2.getText().toString();

                TextView subAnswer = (TextView)findViewById(R.id.calculation);

                Integer subAns = subCalculation(subString1,subString2);

                String subCalulation= String.valueOf(subAns);

                subAnswer.setText(subString1 + " - " + subString2 + " = " +subCalulation);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String multiString1 = no1.getText().toString();
                String multiString2 = no2.getText().toString();

                TextView multiAnswer = (TextView)findViewById(R.id.calculation);

                Integer multiAns = multiCalculation(multiString1,multiString2);

                String multiCalulation = String.valueOf(multiAns);

                multiAnswer.setText(multiString1 + " * " + multiString2 + " = " +multiCalulation);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String divString1 = no1.getText().toString();
                String divString2 = no2.getText().toString();

                TextView divAnswer = (TextView)findViewById(R.id.calculation);

                Integer divAns = divCalculation(divString1,divString2);

                String divCalulation = String.valueOf(divAns);

                divAnswer.setText(divString1 + " / " + divString2 + " = " +divCalulation);
            }
        });
    }

    private Integer addCalculation(String addStr1, String addStr2) {
        Integer addition1 = Integer.parseInt(addStr1);
        Integer addition2 = Integer.parseInt(addStr2);

        return  addition1 + addition2;
    }
    private Integer subCalculation(String subStr1, String subStr2){
        Integer subtract1 = Integer.parseInt(subStr1);
        Integer subtract2 = Integer.parseInt(subStr2);

        return subtract1 - subtract2;
    }
    private Integer multiCalculation(String multiStr1, String multiStr2){
        Integer multi1ply1 = Integer.parseInt(multiStr1);
        Integer multiply2 = Integer.parseInt(multiStr2);

        return multi1ply1 * multiply2;
    }
    private Integer divCalculation(String divSta1, String divSta2){
        Integer divide1 = Integer.parseInt(divSta1);
        Integer divide2 = Integer.parseInt(divSta2);

        return divide1 / divide2;
    }
}
