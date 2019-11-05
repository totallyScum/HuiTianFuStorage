package com.wandao.myapplication.utils;

import android.util.Log;

import com.wandao.myapplication.bean.MailSenderInfo;

public class EmailUtil {
    private static final String TAG = "EmailUtil";

    /**
     * @param title  邮件的标题
     * @param msuggestions 邮件的文本内容
     * @param toAddress  收件人的地址  如：xxx@qq.com
     */
    public static void autoSendMail(String title,String msuggestions,String toAddress) {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");//smtp地址
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("c13238101563@163.com");// 发送方邮件地址
        mailInfo.setPassword("wandao123");// 邮箱POP3/SMTP服务授权码
        mailInfo.setFromAddress("c13238101563@163.com");// 发送方邮件地址
        mailInfo.setToAddress(toAddress);//接受方邮件地址
        mailInfo.setSubject(title);//设置邮箱标题
        mailInfo.setContent(msuggestions);
        // 这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextMail(mailInfo);// 发送文体格式
        Log.d(TAG, "autoSendMail: msuggestions: "+msuggestions);
    }

    /**
     * @param title  邮件的标题
     * @param msuggestions 邮件的文本内容
     * @param toAddress  收件人的地址  如：xxx@qq.com
     * @param filePath  附件的路径
     */
    public static void autoSendFileMail(String title,String msuggestions,String toAddress,String[] filePath) {
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");//smtp地址
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("c13238101563@163.com");// 发送方邮件地址
        mailInfo.setPassword("wandao123");// 邮箱POP3/SMTP服务授权码
        mailInfo.setFromAddress("c13238101563@163.com");// 发送方邮件地址
        mailInfo.setToAddress(toAddress);//接受方邮件地址
        mailInfo.setSubject(title);//设置邮箱标题
        mailInfo.setContent(msuggestions);
        // 这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        sms.sendTextAndFileMail(mailInfo,filePath);// 发送文体格式
        Log.d(TAG, "autoSendMail: msuggestions: "+msuggestions);
    }
}