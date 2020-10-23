package com.example.practical8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_clickHere;
    TextView txt_messageOutput;
    EditText txt_messageInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_clickHere = findViewById(R.id.btn_clickHere);
        txt_messageInput = findViewById(R.id.txt_messageInput);
        txt_messageOutput = findViewById(R.id.txt_messageOutput);


        btn_clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hello, "+(txt_messageInput.getText());
                txt_messageOutput.setText(message);
                Toast toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}