package com.wandao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MarqueeActivity extends AppCompatActivity {
private List<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);

//        MarqueeView marqueeView = (MarqueeView) findViewById(R.id.marqueeView);
//
//        List<String> messages = new ArrayList<>();
//        messages.add("1. 大家好，我是孙福生。");
//        messages.add("2. 欢迎大家关注我哦！");
//        messages.add("3. GitHub帐号：sunfusheng");
//        messages.add("4. 新浪微博：孙福生微博");
//        messages.add("5. 个人博客：sunfusheng.com");
//        messages.add("6. 微信公众号：孙福生");
//        marqueeView.(messages, R.anim.anim_bottom_in, R.anim.anim_top_out);
//
//        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
//            @Override
//            public void onItemClick(int i, View view) {
//                Toast.makeText(getApplicationContext(), String.valueOf(marqueeView1.getPosition()) + ". " + textView.getText(), Toast.LENGTH_SHORT).show();
//
//            }
//
//    });
//// 或者设置自定义的Model数据类型
//        public class CustomModel implements IMarqueeItem {
//            @Override
//            public CharSequence marqueeMessage() {
//                return "...";
//            }
//        }


    }


//    @Override
//    public void onResume() {
//        super.onResume();
//        marqueeView.startFlipping();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        marqueeView.stopFlipping();
//    }
}
