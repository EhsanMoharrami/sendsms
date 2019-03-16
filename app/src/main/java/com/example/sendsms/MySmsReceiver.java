package com.example.sendsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.security.KeyStore;

public class MySmsReceiver extends BroadcastReceiver {

    private static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "sms received");


        Bundle bundle = intent.getExtras();
        if (bundle == null)
            return;
        Object[] pdus = (Object[]) bundle.get("pdus");
        if (pdus == null) return;

        SmsMessage[] messages = new SmsMessage[pdus.length];
        for (int i = 0; i < pdus.length; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                String format = bundle.getString("format");

                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
            } else {

                SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            String text = "sms from : " + messages[i].getDisplayOriginatingAddress() +  "  : " + messages[i].getDisplayMessageBody() + "\n" ;

            Log.i(TAG, text);


        }

    }

}