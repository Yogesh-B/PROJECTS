package com.example.practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isOpPressed = false;
    private double firstNumber=0;
    private int secondNumberIndex = 0;
    private char currentOp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylayout);

        final TextView calculatorScreen = findViewById(R.id.calculatorScreen);
        final Button btn_0 = findViewById(R.id.btn_0);
        final Button btn_1 = findViewById(R.id.btn_1);
        final Button btn_2 = findViewById(R.id.btn_2);
        final Button btn_3 = findViewById(R.id.btn_3);
        final Button btn_4 = findViewById(R.id.btn_4);
        final Button btn_5 = findViewById(R.id.btn_5);
        final Button btn_6 = findViewById(R.id.btn_6);
        final Button btn_7 = findViewById(R.id.btn_7);
        final Button btn_8 = findViewById(R.id.btn_8);
        final Button btn_9 = findViewById(R.id.btn_9);
        final Button btn_add = findViewById(R.id.btn_add);
        final Button btn_sub = findViewById(R.id.btn_sub);
        final Button btn_mul = findViewById(R.id.btn_mul);
        final Button btn_div = findViewById(R.id.btn_div);
        final Button btn_dot = findViewById(R.id.btn_dot);
        final Button btn_eql = findViewById(R.id.btn_eql);



        final View.OnClickListener calculatorListener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id =  v.getId();
                switch(id){
                    case R.id.btn_0:
                        calculatorScreen.append("0");
                        break;
                    case R.id.btn_1:
                        calculatorScreen.append("1");
                        break;
                    case R.id.btn_2:
                        calculatorScreen.append("2");
                        break;
                    case R.id.btn_3:
                        calculatorScreen.append("3");
                        break;
                    case R.id.btn_4:
                        calculatorScreen.append("4");
                        break;
                    case R.id.btn_5:
                        calculatorScreen.append("5");
                        break;
                    case R.id.btn_6:
                        calculatorScreen.append("6");
                        break;
                    case R.id.btn_7:
                        calculatorScreen.append("7");
                        break;
                    case R.id.btn_8:
                        calculatorScreen.append("8");
                        break;
                    case R.id.btn_9:
                        calculatorScreen.append("9");
                        break;
                    case R.id.btn_add:
                        String screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Double.parseDouble(screenContent);
                        calculatorScreen.append("+");
                        isOpPressed=true;
                        currentOp='+';
                        break;
                    case R.id.btn_sub:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Double.parseDouble(screenContent);
                        calculatorScreen.append("-");
                        isOpPressed=true;
                        currentOp='-';
                        break;
                    case R.id.btn_mul:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Double.parseDouble(screenContent);
                        calculatorScreen.append("*");
                        isOpPressed=true;
                        currentOp='*';
                        break;
                    case R.id.btn_div:
                        screenContent = calculatorScreen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Double.parseDouble(screenContent);
                        calculatorScreen.append("/");
                        isOpPressed=true;
                        currentOp='/';
                        break;
                    case R.id.btn_dot:
                        calculatorScreen.append(".");
                        break;
                    case R.id.btn_eql:
                        if(isOpPressed){
                            switch (currentOp){
                                case '+':
                                    String content = calculatorScreen.getText().toString();
                                    double secondNumber = Double.parseDouble(content.substring(secondNumberIndex, content.length()));
                                    secondNumber=secondNumber + firstNumber;
                                    calculatorScreen.setText(Double.toString(secondNumber));
                                    break;
                                case '-':
                                    content = calculatorScreen.getText().toString();
                                    secondNumber = Double.parseDouble(content.substring(secondNumberIndex, content.length()));
                                    secondNumber=firstNumber-secondNumber;
                                    calculatorScreen.setText(Double.toString(secondNumber));
                                    break;
                                case '*':
                                    content = calculatorScreen.getText().toString();
                                    secondNumber = Double.parseDouble(content.substring(secondNumberIndex, content.length()));
                                    secondNumber=firstNumber*secondNumber;
                                    calculatorScreen.setText(Double.toString(secondNumber));
                                    break;
                                case '/':
                                    content = calculatorScreen.getText().toString();
                                    secondNumber = Double.parseDouble(content.substring(secondNumberIndex, content.length()));
                                    secondNumber=firstNumber/secondNumber;
                                    calculatorScreen.setText(Double.toString(secondNumber));
                                    break;
                                default:
                                    Toast.makeText(MainActivity.this,"Default executed in = button...",Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(MainActivity.this,"= button could not find isOpPressed...",Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        Toast.makeText(MainActivity. this,"Button case default executed...",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        btn_0.setOnClickListener(calculatorListener);
        btn_1.setOnClickListener(calculatorListener);
        btn_2.setOnClickListener(calculatorListener);
        btn_3.setOnClickListener(calculatorListener);
        btn_4.setOnClickListener(calculatorListener);
        btn_5.setOnClickListener(calculatorListener);
        btn_6.setOnClickListener(calculatorListener);
        btn_7.setOnClickListener(calculatorListener);
        btn_8.setOnClickListener(calculatorListener);
        btn_9.setOnClickListener(calculatorListener);
        btn_add.setOnClickListener(calculatorListener);
        btn_sub.setOnClickListener(calculatorListener);
        btn_mul.setOnClickListener(calculatorListener);
        btn_div.setOnClickListener(calculatorListener);
        btn_dot.setOnClickListener(calculatorListener);
        btn_eql.setOnClickListener(calculatorListener);

        //delete button code below
        final Button btn_del = findViewById(R.id.btn_del);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentElements = calculatorScreen.getText().toString();
                int length = currentElements.length();
                if(length>0){
                    currentElements = currentElements.substring(0,length-1);
                    calculatorScreen.setText(currentElements);
                }
            }
        });

        //Clear button code
        final Button btn_ce = findViewById(R.id.btn_ce);
        btn_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorScreen.setText("");
            }
        });

    }
}