package com.example.practical9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> countries=new ArrayList<String>();
    AutoCompleteTextView mcountry;
    Spinner mstates;
    EditText musername;
    EditText mpassword;
    EditText memail;
    EditText mphoneNumber;
    Spinner mgender;
    Button mbirthDate;
    Button mbirthTime;
    EditText minterests;
    Button msubmit;
    String []states = {"New Delhi","Andaman/Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra/Nagar Haveli","Daman/Diu","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu/Kashmir","Jharkhand","Karnataka","Kerala","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Pondicherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttaranchal","Uttar Pradesh","West Bengal"};
    ArrayList<String> allStates=new ArrayList<String>();
    ArrayList<String> genderList=new ArrayList<String>();
    private int mYear, mMonth, mDay, mHour, mMinute;
    String username;
    String password;
    String email;
    String phoneNumber;
    String country;
    String state;
    String gender;
    String interests;
    String bdate;
    String btime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musername=(EditText)findViewById(R.id.et_username);
        mcountry=(AutoCompleteTextView)findViewById(R.id.actv_country);
        mstates=(Spinner)findViewById(R.id.sp_states);
        musername=(EditText)findViewById(R.id.et_username);
        mpassword=(EditText)findViewById(R.id.et_password);
        memail=(EditText)findViewById(R.id.et_email);
        mphoneNumber=(EditText)findViewById(R.id.et_phone_number);
        mgender=(Spinner)findViewById(R.id.sp_gender);
        mbirthDate=(Button)findViewById(R.id.bt_birth_date);
        mbirthTime=(Button)findViewById(R.id.bt_birth_time);
        minterests=(EditText)findViewById(R.id.et_interests);
        msubmit=(Button)findViewById(R.id.bt_submit);

        mbirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new
                        DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth)
                            {
                                mbirthDate.setText(dayOfMonth + "-" + (monthOfYear
                                        + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        mbirthTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);
                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new
                        TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                mbirthTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFilled())
                {
                    username=musername.getText().toString();
                    password=mpassword.getText().toString();
                    email=memail.getText().toString();
                    phoneNumber=mphoneNumber.getText().toString();
                    country=mcountry.getText().toString();
                    state=mstates.getSelectedItem().toString();
                    gender=mgender.getSelectedItem().toString();
                    interests=minterests.getText().toString();
                    bdate=mbirthDate.getText().toString();
                    btime=mbirthTime.getText().toString();
                    Intent intent=new
                            Intent(MainActivity.this,ViewDataActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("password",password);
                    intent.putExtra("email",email);
                    intent.putExtra("phone",phoneNumber);
                    intent.putExtra("country",country);
                    intent.putExtra("state",state);
                    intent.putExtra("gender",gender);
                    intent.putExtra("interests",interests);
                    intent.putExtra("bdate",bdate);
                    intent.putExtra("btime",btime);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Please fill all the fileds!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //setting gender spinner
        genderList.add("Male");
        genderList.add("Female");
        ArrayAdapter<String> genderAdapter=new
        ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,genderList);
        mgender.setAdapter(genderAdapter);
        //setting country autocompletetextview
        mcountry.setThreshold(1);
        allStates.add("Select a country first");
        ArrayAdapter<String> adapter=new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,allStates);
        mstates.setAdapter(adapter);
        getCountries();
        ArrayAdapter<String> adapter2=new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
        mcountry.setAdapter(adapter2);
        mcountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i,
                                    long l) {

//Toast.makeText(MainActivity.this,"Selected",Toast.LENGTH_SHORT).show();
                hideKeyboard(MainActivity.this);
                String selectedItem=(String)adapterView.getItemAtPosition(i);
                if(selectedItem.equalsIgnoreCase("India"))
                {
                    getStates();
                    ArrayAdapter<String> adapter=new
                            ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,allStates);
                    mstates.setAdapter(adapter);
                }
            }
        });
    }
    private void getCountries()
    {
        Locale []locale= Locale.getAvailableLocales();
        String country;
        for(Locale loc:locale)
        {
            country=loc.getDisplayCountry();
            if(country.length()>0 && !countries.contains(country))
            {
                countries.add(country);
            }
        }
        Collections.sort(countries,String.CASE_INSENSITIVE_ORDER);
    }
    private void getStates()
    {
        allStates.remove(0);
        for(int i=0;i<states.length;i++)
        {
            allStates.add(states[i]);
        }
        Collections.sort(allStates);
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager)
                activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    private boolean isFilled()
    {
        if(!musername.getText().toString().equals("") &&
                !mpassword.getText().toString().equals("") &&
                !memail.getText().toString().equals("") &&
                !mphoneNumber.getText().toString().equals("") &&
                !mcountry.getText().toString().equals("") &&
                !mstates.getSelectedItem().toString().equals("") &&
                !mgender.getSelectedItem().toString().equals("") &&
                !minterests.getText().toString().equals("") &&
                !mbirthDate.getText().toString().equalsIgnoreCase("SELECT DATE") &&
                !mbirthTime.getText().toString().equalsIgnoreCase("SELECT TIME"))
        {
            return true;
        }
        else
        {

            return false;
        }
    }
}
