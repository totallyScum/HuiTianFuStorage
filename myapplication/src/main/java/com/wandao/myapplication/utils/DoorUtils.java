package com.wandao.myapplication.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.serialportlibrary.service.impl.SerialPortBuilder;
import com.serialportlibrary.service.impl.SerialPortService;
import com.serialportlibrary.util.ByteStringUtil;

import java.util.ArrayList;

public class DoorUtils {
    private volatile static DoorUtils singleton;
    private static SerialPortService serialPortService;
    private static BroadcastReceiver mReceiver;
    private static int status=0;
    private DoorUtils (){
//         serialPortService = new SerialPortBuilder()
//                .setTimeOut(100L)
//                .setBaudrate(57600)
//                .setDevicePath("/dev/ttyACM2")
//                .createService();
//        serialPortService.isOutputLog(true);
    }
    public static DoorUtils getSingleton() {
        if (singleton == null) {
            synchronized (DoorUtils.class) {
                if (singleton == null) {
                    singleton = new DoorUtils();
                }
            }
        }
        return singleton;
    }
    public void openDoor(int doorNumber, Context context)
    {
        //发送开门指令
        //        byte[] b=new byte{0x5C,0xC5,0x05,0x01,0x02,0x00,0x00,0xD7}
//        byte[] b=new byte[9];
//        b[0]=(byte)0x5C;
//        b[1]=(byte)0xC5;
//        b[2]=(byte)0x05;


//
//        b[3]=(byte)0x01;//锁控版地址
//        b[3]=(byte)Long.parseLong((doorNumber/10)+1+"",16);//锁控版地址
//
//        b[4]=(byte)0xD1;
//   //     b[4]=(byte)0xD2;
//        b[5]=(byte)Long.parseLong(doorNumber%10+"",16);                //锁地址
//   //     b[5]=(byte)0x02;                //锁地址
//        b[6]=(byte)0x00;
//        b[7]=(byte)0x00;
//
//        byte b1 = 0;
//        for (int i = 2; i < b.length; i++)
//        {
//            b1 ^= b[i];
//        }
//        b[8]=(byte)b1;
//        //      byte[] receiveData = serialPortService.sendData("5CC50501D1020000D7");
//        byte[] receiveData = serialPortService.sendData(b);
//        if (receiveData!=null)
//            Log.e("MainActivity：", ByteStringUtil.byteArrayToHexStr(receiveData));

//        Intent localIntent=new Intent("com.hzjubu.action.REQ_OPEN_DOOR");
//        localIntent.putExtra("iBoardId",0);
//        localIntent.putExtra("iLockId",0);
//        sendBroadcast(localIntent);
        Intent localIntent=new Intent("com.hzjubu.action.REQ_OPEN_DOOR");
        localIntent.putExtra("iBoardId",0);
        localIntent.putExtra("iLockId",doorNumber-1);
        context.sendBroadcast(localIntent);








Toast.makeText(context,"233333",Toast.LENGTH_LONG).show();
    }

    public void   checkDoorStatus(Context context)
    {
        Intent localIntent=new Intent("com.hzjubu.action.REQ_DOORS_STATUS");
        localIntent.putExtra("iBoardId",0);
        localIntent.putExtra("iBoxesCounts",60);
        context.sendBroadcast(localIntent);


    }
}
