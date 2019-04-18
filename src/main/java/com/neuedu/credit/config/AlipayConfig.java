package com.neuedu.credit.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Created by elvin on 2018/10/10 8:29.
 * @Describe:
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092100559791";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDR+CmaCP2IjzTKIoGaI6BRpewjLT/yV8SLconQn/STnQ3sPIwp8KXUkclKkBfSbqQi5lJYlRRKUMd0Y28CuT7Qid2XYhf6aYVM6mtBpQK34KlHNqh3S7Zk64icNnrhdKo1FeVvpJRtkTs8XJKGvwFzMNSKpwr6y0HiWvq39mYo3C3LAhn/8uliLZIkliVXha/9T/kqD2ebWWKlUmN6eF+718pfi3b1i7FyKMGemJp7SZ+33optZ9YfQJrDjCcGmJMJnXBykYWZ5fA6wVqOGrW2ArbCvGZmF/6GCaKJ33tbA2VQ59CJWegdBuW4iR8PBOOHv8cq2xeXMTa1rXDbTICTAgMBAAECggEBAMf+HuoH/C2Rcc/CtD10B6UdbGFJHWqgbKYCMACWCuh7JKLKPRtJizqArgEmZHpcRlyzkuWrAcuTS5exijBG7+zEFFu35GzxCzXq5sR8/qzUAYjCKA6RACb6LYHVZo/OhrzPoV0InxQJzCk/Z5WO4zur3BZA63VcGuIWlE6bFE1/R2yNSWWypmGaGudmbhIc1EKZDPo0H/ktON6GlNcFA0om7cK4MMxzoAlt259dYPx1mUTB5s48sgqYBxks0dvV29ZNLcN0BqmYtyWRHK5FCCC2IUpy8bssr1ZDOFvyzOeDfALjZHg2+LeyWF6xRNwQO/tKhMjzlaItSCaVrKqi6XECgYEA/bot5CU3gHvCeooQ13lpC13NHNfoC0bixSiP+1qNMTIsFZfQoS3megnPP85hgvnIcvjjnVOIBncDkDOPM1NenwNHpfCieMIfplJcEA///eB5VKZFPoKwzsBONs05F8XgxGeLwy2NehfucIlA0Rcf0nXM4NMmeZnDpq/5xT9BsVsCgYEA09mka8d7Reiq9b035iMxzIIX0h/pTYURdmjRd+lI+cbtYG5ibkARI0JIur5E3JlZjTFvjb823wsLeR0bC5tHAycioVFudx1wBix0pwsoOryWwbupym/nRtuAl8HFgiV7hmFc6GfWYh/FyuWDodmTSIbIGuAKFsEvEcSPuko/mykCgYEAse9HD6Ap9CjWkikQ9otmZ1o45elkCcSEc8+maZdvPPj6gYod/Wq7HwqSFSUerUOOl1KEDWjvE9mS3iXKXywwR0N9k5nV1uoMWA+aEImn9NrfO8X++X+djuC9+SCi0VEr95DGKvJfLShrRvB6TCfzYRzLuT9a1BxJYTQ37WQXJdECgYEAmQZN8RhfoAjHbMgoF5F2iD20TTCFylwDWB+wpsgY0WtyzcQOT4rxliFr/ZAwl5Qhjo6WALKNRSFqQSrX/VNFQS7Eoff7LglSgPMdtAeoIH1W/Eu9AqBAU/t78KKkMzU1+8RaYvmWbrx6l+ufYIqUC8BnzJnmT7dtc40jMLIvLbkCgYEAt/Supo8xrrkgnAplJq2lf1o8XRvdUDCbTkt+ZGnFsO3JmW3tw/2S7xo664Ma49wBu1r8YJBCLAtcxc3ABWjJxcaWXCc25+a/HsCtGC1ZO6FM7BmidW3eMMbzB1aLkp7m8SCGFZuqKQ2NggJ3Uyjv242GGMxV6Rou5L/AIh2H0KY=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4htEIJPJbF1CTCdBHeQKUdRSDdSSruVPEHQfl6O4sWtQQ0dred7d4GYACpQlnQkPktHzNZnu8HaP4XtZKBxUuYDQ9j1EvMWY10Ps80sg5FaCwp4Ujo8fBAdptp5TwgjwGG/kRDXYeqnE6bs8I4tBV3N9TarFJOxc/Y1J/gv41uDOLocGl1UIyxRpW8i8a81QMFwqB9AU41Xnl5QcR/a5Zlb4LGhXQggSbeZwWGvZcnfUMDwQU0Lmzdhos4NWDe/mtCRxfUdomXpop+VPIJ8CgY4SZ06yDxuNh9e25uH4IKJOoIis9HSN0MJ5len0hCfczU+SaX+XfYKCYkciEY5nDwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://127.0.0.1:8080/returnPay/aliReturnPay";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8080/order/get";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
            //"https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
