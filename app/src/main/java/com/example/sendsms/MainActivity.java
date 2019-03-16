package com.example.sendsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static final int PERM_REQ_CODE = 1442;



    private EditText txtMobile;
    private EditText txtMessage;
    private Button btnSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    txtMobile = (EditText)findViewById(R.id.input_number);
    txtMessage = (EditText)findViewById(R.id.input_text);
    btnSms = (Button)findViewById(R.id.btn_submit);
        //checkPerms();
        btnSms.setOnClickListener(new View.OnClickListener() {

      @Override
        public void onClick(View v) {
            try{
                SmsManager smgr = SmsManager.getDefault();
                smgr.sendTextMessage(txtMobile.getText().toString(),null,txtMessage.getText().toString(),null,null);
                Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
            }
        }
        });
    }
}

    //private void checkPerms(){
        //if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            //if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
              //  !=PackageManager.PERMISSION_GRANTED){
               // ActivityCompat.requestPermissions(this,
                       // new String[]{
                               //Manifest.permission.READ_SMS,
                               // Manifest.permission.SEND_SMS,
                               // Manifest.permission.RECEIVE_SMS,

              //  },
                       // PERM_REQ_CODE);
        //    }
      //  }
   // }

   // @Override
   // public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      //if(requestCode == PERM_REQ_CODE){
         // if(grantResults[0] != PackageManager.PERMISSION_GRANTED &&
                  //grantResults[1] != PackageManager.PERMISSION_GRANTED &&
                //  grantResults[2] != PackageManager.PERMISSION_GRANTED){
            //  Toast.makeText(this, "permissions denied. closing application", Toast.LENGTH_SHORT).show();
             // finish();

        //  }
     // }
   // }

//}
