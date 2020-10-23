package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private IntentFilter mActionFoundFilter, mActionDiscoveryFinishedFilter;
    private BluetoothAdapter mBluetoothAdapter;
    private ArrayAdapter<String> mPairedDeviceAdapter, mNewDevicesArrayAdapter;
    int REQUEST_CODE = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //search button code
        Button scanDevicesButton = findViewById(R.id.btn_search);
        scanDevicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDiscovery();
            }
        });

        mPairedDeviceAdapter = new ArrayAdapter<>(this, R.layout.device_name, R.id.tv);
        mNewDevicesArrayAdapter = new ArrayAdapter<>(this, R.layout.device_name, R.id.tv);


        ListView pairedListView = findViewById(R.id.device_list_listView);
        pairedListView.setAdapter(mPairedDeviceAdapter);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth devices not found...!!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //initializing filters and registering call for broadcast receiver
        mActionFoundFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReceiver, mActionFoundFilter);

        mActionDiscoveryFinishedFilter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, mActionDiscoveryFinishedFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(mReceiver);
    }

    public void startDiscovery() {
        if (!mBluetoothAdapter.isEnabled()) {
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i, REQUEST_CODE);
        } else {
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(i, REQUEST_CODE);

        }
        //start discovery
        mBluetoothAdapter.startDiscovery();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (requestCode == RESULT_OK) {
                Toast.makeText(this, "Bluetooth turned on!", Toast.LENGTH_LONG).show();
            }
        }
        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Bluetooth is already on!", Toast.LENGTH_LONG).show();
        }

        Set<BluetoothDevice> paireDevices = mBluetoothAdapter.getBondedDevices();
        if (paireDevices.size() > 0) {

            if (mPairedDeviceAdapter != null && !mPairedDeviceAdapter.isEmpty())
                mPairedDeviceAdapter.clear();

            for (BluetoothDevice bDevice : paireDevices) {
                mPairedDeviceAdapter.add(bDevice.getName() + " \n" + bDevice.getAddress());
            }

        } else {
            String noDevice = getString(R.string.no_devices_connected);
            mPairedDeviceAdapter.add(noDevice);

        }
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // If it's already paired, skip it, because it's been listed already
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    mNewDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                }
                // When discovery is finished, change the Activity title
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                setProgressBarIndeterminateVisibility(false);

                if (mNewDevicesArrayAdapter.getCount() == 0) {
                    String noDevices = "NO DEVICE FOUND";
                    mNewDevicesArrayAdapter.add(noDevices);
                }
            }
        }
    };
}