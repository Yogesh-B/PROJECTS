package com.example.practical9;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewDataActivity extends AppCompatActivity {
    TextView musername;
    TextView mpassword;
    TextView memail;
    TextView mphoneNumber;
    TextView mcountry;
    TextView mstate;
    TextView mgender;
    TextView minterests;
    TextView mbirthDate;
    TextView mbirthTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        musername=(TextView)findViewById(R.id.tv_username);
        mpassword=(TextView)findViewById(R.id.tv_password);
        memail=(TextView)findViewById(R.id.tv_email);
        mphoneNumber=(TextView)findViewById(R.id.tv_phone_number);
        mcountry=(TextView)findViewById(R.id.tv_country);
        mstate=(TextView)findViewById(R.id.tv_state);
        mgender=(TextView)findViewById(R.id.tv_gender);
        minterests=(TextView)findViewById(R.id.tv_interests);
        mbirthDate=(TextView)findViewById(R.id.tv_birth_date);
        mbirthTime=(TextView)findViewById(R.id.tv_birth_time);
        Intent intent=getIntent();
        Bundle data=intent.getExtras();
        musername.setText(data.getString("username").toString());
        mpassword.setText(data.getString("password").toString());
        memail.setText(data.getString("email").toString());
        mphoneNumber.setText(data.getString("phone").toString());
        mcountry.setText(data.getString("country").toString());
        mstate.setText(data.getString("state").toString());
        mgender.setText(data.getString("gender").toString());
        minterests.setText(data.getString("interests").toString());
        mbirthDate.setText(data.getString("bdate").toString());
        mbirthTime.setText(data.getString("btime").toString());
    }
}