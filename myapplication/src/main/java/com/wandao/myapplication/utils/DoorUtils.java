package com.wandao.myapplication.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
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
    //    toastTest();
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
    public boolean openDoor(int doorNumber, Context context)
    {



        status=1;
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




//        if(localIntent.getAction().equalsIgnoreCase("com.hzjubu.action.ACK_OPEN_DOOR ")) {
////获取应答箱格所在的副机地址
//            int iBoardId = localIntent.getIntExtra("iBoardId", -1);
////获取应答箱格的格口ID
//            int iLockId = localIntent.getIntExtra("iLockId", -1);
//            int iErrorCode = localIntent.getIntExtra("iErrorCode", -1);
//            if (iErrorCode < 0) {//命令执行失败，提示失败原因：线路连接、硬件故障等
//
//                  String sErrordesc = localIntent. getStringExtra("sErrordesc");
//            } else {//命令执行成功，根据业务逻辑可进一步判断箱门是否被打开
//                 boolean  bOpend  = localIntent. getBooleanExtra("bOpend",false);
//                if (bOpend == false) {//箱门被卡住，提示用户开箱重试
//
//                }
//            }
//        }
//        Looper.prepare();
//        if (countDownTimer!=null)
//        countDownTimer.cancel();
//        countDownTimer.start();
//        Looper.loop();
  //     status=0;

        if(countDownTimer==null)
        {
            initCountDown();
            if (countDownTimer!=null)
            countDownTimer.start();

        }


        if (countDownTimer!=null)
        {
            countDownTimer.cancel();
            countDownTimer=null;
            initCountDown();
            if (countDownTimer!=null)
            countDownTimer.start();
        }
//            countDownTimer.cancel();
//        countDownTimer.start();



return true;
    }

//
   static CountDownTimer countDownTimer ;


   static private void initCountDown() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        Log.d("initCountDown","66666666666");

                       countDownTimer= new CountDownTimer(30000, 1000) {//第一个参数表示总时间，第二个参数表示间隔时间。

                            @Override
                            public void onTick(long millisUntilFinished) {
                            }

                            @Override
                            public void onFinish() {
                                status=0;
                            }
                        };

                    }
                });
            }
        }).start();
    }








    public void   checkDoorStatus(Context context)
    {
        if (status==0)
        {
            Intent localIntent=new Intent("com.hzjubu.action.REQ_DOORS_STATUS");
            localIntent.putExtra("iBoardId",0);
            localIntent.putExtra("iBoxesCounts",60);
            context.sendBroadcast(localIntent);
        }
    }



    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }


}
