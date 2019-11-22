package com.wandao.myapplication.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.wandao.myapplication.utils.DoorUtils;

import java.util.ArrayList;

public class DoorReceiver extends BroadcastReceiver {
    static int status=0;
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equalsIgnoreCase("com.hzjubu.action.ACK_DOORS_STATUS")){ //获取应答箱格所在的副机地址
            int iBoardId = intent. getIntExtra("iBoardId",-1);
            int iErrorCode = intent. getIntExtra("iErrorCode",-1);
            if(iErrorCode<0){//命令执行失败，提示失败原因：线路连接、硬件故障等
                String sErrordesc = intent. getStringExtra("sErrordesc");
                Intent myIntent = new Intent("android.intent.action.MAIN");
                myIntent.putExtra("data",sErrordesc);
                context.sendBroadcast(myIntent);
            }else{//命令执行成功，获取箱门当前状态
                Bundle b= intent.getExtras();
                ArrayList<Integer> iOpendArray = b.getIntegerArrayList("iOpendArray");
                Log.d("2333344we","成功");
                //       String str = String.join(",",  iOpendArray.toArray(new String[iOpendArray.size()+1]));
                status=0;
                for (int i=1;i<=iOpendArray.size();i++)
                {
                    if(iOpendArray.get(i-1)!=0)
                    {
                        status=1;
                        Intent myIntent = new Intent();
                        myIntent.putExtra("count", i);
                        myIntent.setAction("com.wandao.myapplication");
                        context.sendBroadcast(myIntent);
                    }


                }

                if(status==0){
                    Intent myIntent = new Intent();
                    myIntent.putExtra("count", 0);
                    myIntent.setAction("com.wandao.myapplication");
                    context.sendBroadcast(myIntent);
                }

            }}
        if(intent.getAction().equalsIgnoreCase("com.hzjubu.action.ACK_OPEN_DOOR ")){
//获取应答箱格所在的副机地址
 int iBoardId = intent. getIntExtra("iBoardId",-1);
//获取应答箱格的格口ID
 int iLockId  = intent. getIntExtra("iLockId",-1); int iErrorCode = intent. getIntExtra("iErrorCode",-1);
            if(iErrorCode<0){//命令执行失败，提示失败原因：线路连接、硬件故障等
                 String sErrordesc = intent. getStringExtra("sErrordesc");
                Toast.makeText(context,sErrordesc,Toast.LENGTH_LONG).show();

//                Intent localIntent=new Intent("com.hzjubu.action.REQ_OPEN_DOOR");
//                localIntent.putExtra("iBoardId",iBoardId);
//                localIntent.putExtra("iLockId",iLockId);
//                context.sendBroadcast(localIntent);

            }else{
                //命令执行成功，根据业务逻辑可进一步判断箱门是否被打开
                 boolean  bOpend  = intent. getBooleanExtra("bOpend",false);
                if(bOpend==false){
                    Intent localIntent=new Intent("com.hzjubu.action.REQ_OPEN_DOOR");
                    localIntent.putExtra("iBoardId",iBoardId);
                    localIntent.putExtra("iLockId",iLockId);
                    context.sendBroadcast(localIntent);
//                    //箱门被卡住，提示用户开箱重试
//                    Intent localIntent=new Intent("com.chen.bOpen");
//                    localIntent.putExtra("bOpend",false);
//         //           localIntent.putExtra("iLockId",doorNumber-1);
//                    context.sendBroadcast(localIntent);
                    } }
                }

    }
}
