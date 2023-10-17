package com.example.alexisindickweighttrackingapp;



import android.telephony.SmsManager;



import java.util.ArrayList;

public class SMSNotify  {
    public static void sendLongSMS(String phoneNumber) {
        String message = "Congrats! Goal weight reached!";
        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(message);
        smsManager.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
    }
}
