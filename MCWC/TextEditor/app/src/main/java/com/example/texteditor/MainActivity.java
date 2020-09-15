package com.example.texteditor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText main_editor;
    private static final int STORAGE_PERMISSION_CODE = 101;


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
                return true;
            case R.id.close_file:
                Toast.makeText(this,"Close Button Clicked!!!",Toast.LENGTH_SHORT).show();

//                AlertDialog.Builder alert_close = new AlertDialog.Builder(this);
//                alert_close.setTitle("TextEditor:");
//                alert_close.setMessage("Unsaved work will be lost. Are you sure to exit? ");
//                alert_close.setNegativeButton(android.R.string.no,null);
//                alert_close.setPositiveButton(android.R.string.yes,DialogInterface.OnClickListener(){
//
//                });
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);

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


}