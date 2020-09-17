package com.example.texteditor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText main_editor;
    private static final int STORAGE_PERMISSION_CODE = 101;
//    public static final String ACTION_OPEN_DOCUMENT = "open_file"
    private static Uri file_path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //check permissions
        checkPermissionStatus(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE});
        //get ids
        main_editor = findViewById(R.id.editText1);



        //method call for Option Set
        //onCreateOptionsMenu();


    }

    private void checkPermissionStatus(String[] permission) {

        if (ContextCompat.checkSelfPermission(MainActivity.this, permission[1] )
                == PackageManager.PERMISSION_DENIED){
            Toast.makeText(MainActivity.this, "Without Storage Permission you won't be able to SAVE files!!!", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(MainActivity.this,permission,STORAGE_PERMISSION_CODE);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.open_file:
                //newGame();
                Toast.makeText(this,"Open Button Clicked!!!",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save_file:
                //showHelp();
                Toast.makeText(this,"Save Button Clicked!!!",Toast.LENGTH_SHORT).show();
                saveFile();
                return true;
            case R.id.close_file:
                AlertDialog.Builder alert_close = new AlertDialog.Builder(MainActivity.this);
                alert_close.setTitle("TextEditor:");
                alert_close.setMessage("Unsaved work will be lost. Are you sure to exit?");
                alert_close.setNegativeButton("No",null);
                alert_close.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface diag1,int id){
                        finish();
                    }
                });
                alert_close.setNeutralButton("Save File",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface diag1,int id){
                        Toast.makeText( MainActivity.this,"Saving file before exit!!!",Toast.LENGTH_SHORT).show();
                        saveFile();
                    }
                });
                alert_close.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    protected void setActionBarText(String str){

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,@NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,"Storage Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this,"Storage Permission Denied",Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void saveFile(){
        final TextView messageSaveFile = (TextView)findViewById(R.id.textView_save);
        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
        final EditText txt_inputText = (EditText) mView.findViewById(R.id.editText_save);
        Button btn_cancel = (Button)mView.findViewById(R.id.btnCancel_save);
        Button btn_okay = (Button)mView.findViewById(R.id.btnSave_save);
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        btn_okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(this,"Just worked!!",Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }


}