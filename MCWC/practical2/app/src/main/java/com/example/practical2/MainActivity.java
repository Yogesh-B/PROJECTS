package com.example.practical2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Set;



public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_ACCESS_COARSE_LOCATION=1;
    public static final int REQUEST_ENABLE_BLUETOOTH=11;
    private ListView LV_devices;
    private Button btn;
    private BluetoothAdapter btAdapter;
    private ArrayAdapter<String>  listAdapter;
    public static int REQUEST_BLUETOOTH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_scan);
        btAdapter = BluetoothAdapter.getDefaultAdapter();//get BT adapter
        LV_devices = findViewById(R.id.LV_devices);

        //get device list
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        LV_devices.setAdapter(listAdapter);

        checkBluetoothState();

        registerReceiver(deviceFoundReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
        registerReceiver(deviceFoundReceiver, new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED));
        registerReceiver(deviceFoundReceiver, new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btAdapter != null && btAdapter.isEnabled()) {
                    if (checkCoarseLocationPermission()) {
                        listAdapter.clear();
                        btAdapter.startDiscovery();
                    }
                } else {
                    checkBluetoothState();
                }
            }
        });

        checkCoarseLocationPermission();
    }

    @Override
    protected void onPause(){
        super.onPause();
        unregisterReceiver(deviceFoundReceiver);
    }

    private boolean checkCoarseLocationPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_ACCESS_COARSE_LOCATION);
            return false;
        }
        else
            return true;
    }


    private void checkBluetoothState(){
        if(btAdapter == null){
            Toast.makeText(this,"Bluetooth Not Supported in This device.!",Toast.LENGTH_SHORT).show();
        }
        else{
            if(btAdapter.isEnabled()){
                if(btAdapter.isDiscovering()){
                    Toast.makeText(this,"Device Discovering Progress...",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Bluetooth is Enabled!",Toast.LENGTH_SHORT).show();
                    btn.setEnabled(true);
                }
            }
            else{
                Toast.makeText(this,"You need to enable Bluetooth!",Toast.LENGTH_SHORT).show();
                Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableIntent,REQUEST_ENABLE_BLUETOOTH);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode==REQUEST_ENABLE_BLUETOOTH){
            checkBluetoothState();
        }
    }

    //@Override
    public void onRequestPermissionResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults ){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        switch(requestCode){
            case REQUEST_ACCESS_COARSE_LOCATION:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Coarse Location Permission granted, now you can scan devices!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Coarse Location Permission denied, now you can't scan devices!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private final BroadcastReceiver deviceFoundReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                listAdapter.add(device.getName()+"\n"+device.getAddress());
                listAdapter.notifyDataSetChanged();
            }
            else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                btn.setText("Start Scan123");
            }
            else if(BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)){
                btn.setText("Scanning in Progress...");
            }
        }
    };


}