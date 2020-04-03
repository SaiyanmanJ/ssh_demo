package config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    /*本想用ip替换notify_url和return_url中的localhost:8080部分,经实验用不到，请无视*/
    public static String ip;

    static {
        try {
            ip = new GetIpAddress().getIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号，此处填入你的信息!!!
	public static String app_id = "2016092400587371";
	
	// 商户私钥，您的PKCS8格式RSA2私钥，此处填入你的信息!!!
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCXNyCY36phaqSZnuTvKRuREutu1wmdEjA+5O5xF9fGr9pMJGhJ9Fn04TpdKDb0aRb2Vfha16R+1N7yl4PztGZAxzXISve6G7BjnMhcxFe+YbRlEmDlaUqkSeYpvwcfUDOYDH3/yqhzEWpViSl1+wvXQ1xMfmNhqfhqX+HklkCUYwXvpwnYxzBZs5NHWsoWps7FtUi7C7aDbAhBC0vKFPyPzgljUIwgeuIQe/2gbScGSn6IUKnnJmv9PyNBnDNaNjr4HOj7k1+HHKud9q1WHAxoeo/l2Qj4gyGvxPKQbbAlqAjtPkddFY0iZgYfc7yE5lzx+U6936zjzE7TdAFfQKwTAgMBAAECggEAHrjZi5WtpRsok/l/Y8PDUQc6BAv2bQ4b9TtH4nxIn5pszJl9AsF9YU49MF4SRDfxrVysF7DGP+p53WnBKktVlwWiPK5WhF5JyQM6hfZyKUDqiLpiK1noC1bkR0kDZm5B/TtUghqnfLFmHDjAzrKRpkuOPhBTmq0QxnPyjiGkv0DK/mNDYApPmEogK2YZ0IzP4hhbSEC4ECOhqirWofWmQGWM3DhyNLUy47iYTuBel0ebfxJXNHKHEJU5qwrqS6NbC0fF0cMOx7ec2CuHVdvpfi5CDgIkoju4VeifobL8owr7v7ta1ABEIbWJluDUbPu2mIOutReDIYEzXhpQdi5d8QKBgQDSDXSAfcmI4X3i+CqEgeGIrnviP209a9lOAPzICVrOSuDzZ7BsXG/429jBn+DA0TroDlGy0w4C3catXW2wu8cTWsa/Fo0xylA6wD//63rOmUiBt8DcX6f5JY0oB2uGwG0ce5tw4Qh/1xxlnvFHIbfX6yMTGUx0nmwDRmMQPZl5+wKBgQC4SuZO66MpkDWuDLye5QdnhvueV9ubZQ/CxXp+ggZBdNKu21G14gJETVCoAdfCBS7pdsnMeg7sEnLcXPNwq4PPX0vgJqV1kmCljPl/sEhP+f+U2yrA+sATnAW7/mmTAXPHuhRNLoc20twMvSRIF/ItCsrJ+wNOPxoaE1mHtBDSyQKBgCkVPJ4M/CfrgoWr6BT2mjfzeINtyF3lBCF/i/FL8xi6CHlS5GytP7E6vpBQRtMvmQfeFRiWsvzYh41M4rFYaL1eWdTyAjekzEBRbbMOSXyy+j10xSHVC7NtJsiXeu5mIHEbs/FF8jWeyw0NIz+4Vo7CjJ+lqRB+E74oPCPnCGeVAoGAJ93D/nSI4jfY9OK6duDyfhm8Gp/E2NO+2hJgEjfMZKKB5ON6xI60kNPsy7tCUi1O3aAdvUb2LWk8QaE15DymEdj6j+2sQ0e78nQRkOawbeSVvjy+/eoAXP2WW/mIGw3oXt9I/v0+sMRiZ7sOuy267LV18sWDDI0n91YSOwHf1ckCgYEAm3IlqhKGmQsAANRNg1CfvHUboOQ41BlRdepIjOIST7mTFyoV/+Qh5xFzRM/7v9uawvT16Ojka3FtCxjiNMx+iazkp7HSKhrvdDVveyg9cMcDxnesOLFE8XIiEeo6AixzA6Lo+LXvVA1NsEawhSAou2f6u6KlcdFvwYpVmiSymIc=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。此处填入你的信息!!!
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwRmPChKxz+xFAYpgzYaS9x4Mfv8EpivfAwaNsW8IMIZ25Xy/7f4etzrbAdiyi3oJL80h++ksR739uytY0wzl+ee8rIojetMimX2dJT7yd/lx81fuBY0FkvWl8Bf7GFuwjuPfxyQo2bb6oi5eyPi6fxQVY3ITOw1OCtTUW/UKEjATq6zLp3B6bbnK0uPAdrRPrlicpgrmUmAdsu71Lj0PrykejzA0xUJadqbjFJE2ukYpKftvzWq4kx0X2k8pX8VyFOYrwqR6wI/4HihCWcAn5fBDQjTh8u2qNys5ZqLTyb8sTzwH43qYIo1CzmGfXuKEQElyyFPq8/NhWbTBRq9RrQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/ssh_demo/payedOrder";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/ssh_demo/payedOrder";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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

