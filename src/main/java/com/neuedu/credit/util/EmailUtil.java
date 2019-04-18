package com.neuedu.credit.util;

import javafx.util.Pair;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Created by elvin on 2018/9/26 10:14.
 * @Describe:
 */
public interface EmailUtil {
        /**
         * 发送简单邮件
         * @param sendTo 收件人地址
         * @param titel  邮件标题
         * @param content 邮件内容
         */
        void sendSimpleMail(String sendTo, String titel, String content);

        /**
         * 发送简单邮件
         * @param sendTo 收件人地址
         * @param title  邮件标题
         * @param content 邮件内容
         * @param attachments<文件名，附件> 附件列表
         */
        void sendAttachmentsMail(String sendTo, String title, String content, List<Pair<String, File>> attachments);

}
