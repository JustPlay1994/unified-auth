package com.justplay1994.github.unifiedauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @Package: com.justplay1994.github.unifiedauth
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/1 9:43
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/1 9:43
 * @Update_Description: huangzezhou 补充
 **/


/**
 * MD5 默认的结果长度是16字节
 * 基本思路，将密码进行md5加密后，得到字节数组，需要对字节数组进行处理，
 * 因为传输过程是utf-8字符串，需要保证后台收到后解码能和前端加密的一样。
 * byte直接toString不行！注意在使用byte[].toString和String.getBytes时，需要加上编码，不然很容易换操作系统后出问题。
 *
 * 已验证1：
 * 字节数组base64编码，再base64解码，结果与原串不变。已验证。
 *
 * 错误情况1:每个过程都加上UTF-8
 * 将密码进行md5加密->base64编码->转字符串(打印)->base64解码->转字符串(打印)
 * 错误情况2：
 * 将一个字节数组按UTF-8转换为String，再将String转换为byte数组时，不一致。也就是说，该过程不可逆！
 * 需要采取高位补零的方式来解决。
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UnifiedAuthApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MD5LengthTest {

    /**
     * 最终解决方案：
     * 明文密码进行md5加密->将加密字节数组转换为16进制字符串（每4个bit位转换为一个字符）->前端传输给后台->
     * 后台将16进制字符串还原为字节数组->得到md5加密后的密码。
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void transportFinalTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(System.getProperty("file.encoding"));
        /*加密*/
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = new String("中文").getBytes("UTF-8");
        System.out.println(new String(b,"UTF-8"));
        System.out.println("b:\n" + Arrays.toString(b));
        md.update(b);
        byte b_md5[] = md.digest();
        System.out.println("b_md5:\n" + Arrays.toString(b_md5) + "+" + b_md5.length);

        System.out.println("b_md5_base64Encode:\n" + Arrays.toString(Base64.getEncoder().encode(b_md5)));
        System.out.println("b_md5_base64Encode_base64Decode:\n" + Arrays.toString(Base64.getDecoder().decode(Base64.getEncoder().encode(b_md5))));


        String transport = new String(Base64.getEncoder().encode(b_md5), "UTF-8");
        System.out.println("b_md5_base64Encode_Str:\n" + transport);
        System.out.println("b_md5_base64Encode_Str_bytes:\n" + Arrays.toString(transport.getBytes("UTF-8")));
        System.out.println("b_md5_base64Encode_Str_base64Decode:\n" + Arrays.toString(Base64.getDecoder().decode(transport)));
        System.out.println("b_md5_base64Encode_Str_base64Decode_Str:\n" +new String(Base64.getDecoder().decode(transport.getBytes("UTF-8")), "UTF-8"));
    }

    /**
     * 16进制字符串，转为二进制串。
     * 说明：1.有定长的概念，4个bit位，转换为一个字符(占8位，一个字节）
     *
     * 现在还需要确定一个事情，就是base64编码转string和string转64编码的标准是什么，不然前端还得自己写，最好是引入框架搞定。
     * @throws UnsupportedEncodingException
     */
    @Test
    public void str2hex() throws Exception {
        String str = "01020304";
//        byte[] answer = {49, 50, 51, 52};
        if (str!=null && str.length()>0 && str.length()%2!=0) throw new Exception("这不是16进制字符串，因为其长度不是偶数！");
        byte[] answer = new byte[str.length()/2];
        for (int i = 0; i < str.length(); i+=2){
            byte high = (byte) str.charAt(i);
            byte low = (byte) str.charAt(i+1);
            answer[i/2]= (byte) ((byte) (high << 4) | low);
        }
        System.out.println(Arrays.toString(answer));
    }

    /**
     * 16进制转字符串
     * 将一个二进制的bin串，转换为16进制的字符串。每个字节的二进制，转换为两个字符（由于是16进制，所以字符的范围0-15）。也就是每四个二进制位，转换为一个16进制的字符.
     * 字符串的长度，是字节数组的两倍，也就是说，字符串的长度一定是偶数。
     *
     */
    @Test
    public void hex2str() throws UnsupportedEncodingException {
//        String str = "1234";
//        byte[] bytes = str.getBytes("UTF-8");
        String answer = "";
        byte[] bytes = {49, 50, 51, 52};
        System.out.println("bytes:"+Arrays.toString(bytes));
        for (int i = 0 ; i < bytes.length; ++i){
            int low = bytes[i] & 0x0F;        //由于范围是0-15只需要4个bit，所以char的高位都是0
            int high = bytes[i]<<4 & 0x0F;    //由于范围是0-15只需要4个bit，所以char的高位都是0
            answer += high;       //字符串由一个字节的高位(高4位转16进制对应的字符)和低位(低4位转16进制对应的字符)组成。
            answer += low;
        }
        System.out.println("hex_Str:"+answer);
    }

    @Test
    public void md5LengthTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(System.getProperty("file.encoding"));
        /*加密*/
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = "123456789".getBytes("UTF-8");
        System.out.println("b:\n" + Arrays.toString(b));
        md.update(b);
        byte b_md5[] = md.digest();
        System.out.println("b_md5:\n" + Arrays.toString(b_md5) + "+" + b_md5.length);

        //验证base64编解码是否可逆，在byte[]类型的情况下
        System.out.println("b_md5_base64Encode:\n" + Arrays.toString(Base64.getEncoder().encode(b_md5)));
        System.out.println("b_md5_base64Encode_base64Decode:\n" + Arrays.toString(Base64.getDecoder().decode(Base64.getEncoder().encode(b_md5))));

        String transport = new String(Base64.getEncoder().encode(b_md5), "UTF-8");
        System.out.println("b_md5_base64Encode_Str:\n" + transport);
        Base64.getDecoder().decode(transport);
        System.out.println("b_md5_base64Encode_Str_base64Encode_Str:\n" +new String(Base64.getDecoder().decode(transport.getBytes("UTF-8")), "UTF-8"));
    }

    /**
     * 错误情况2：
     * 将一个字节数组按UTF-8转换为String，再将String转换为byte数组时，不一致。也就是说，该过程不可逆！
     * 需要采取高位补零的方式来解决。
     *
     * 往上普遍采用的方式是，将字节数组转换为16进制字符串，也就是说每4位（bit）转换为一个字符（char）
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    @Test
    public void transportTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        System.out.println(System.getProperty("file.encoding"));
        /*加密*/
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = new String("中文").getBytes("UTF-8");
        System.out.println(new String(b,"UTF-8"));
        System.out.println("b:\n" + Arrays.toString(b));
        md.update(b);
        byte b_md5[] = md.digest();
        System.out.println("b_md5:\n" + Arrays.toString(b_md5) + "+" + b_md5.length);

        System.out.println("b_md5_base64Encode:\n" + Arrays.toString(Base64.getEncoder().encode(b_md5)));
        System.out.println("b_md5_base64Encode_base64Decode:\n" + Arrays.toString(Base64.getDecoder().decode(Base64.getEncoder().encode(b_md5))));


        String transport = new String(Base64.getEncoder().encode(b_md5), "UTF-8");
        System.out.println("b_md5_base64Encode_Str:\n" + transport);
        System.out.println("b_md5_base64Encode_Str_bytes:\n" + Arrays.toString(transport.getBytes("UTF-8")));
        System.out.println("b_md5_base64Encode_Str_base64Decode:\n" + Arrays.toString(Base64.getDecoder().decode(transport)));
        System.out.println("b_md5_base64Encode_Str_base64Decode_Str:\n" +new String(Base64.getDecoder().decode(transport.getBytes("UTF-8")), "UTF-8"));
    }

    /**
     * java里面的String，用的unicode(UTF-8),是变长编码方案，每个字节牺牲了高位来存信息，帮助解码。
     *
     * @throws UnsupportedEncodingException
     */
    @Test
    public void byteAndStr() throws UnsupportedEncodingException {
        String a = "123abc";
        int num = a.getBytes("utf-8").length;
        System.out.println(num);
        a = "中文";
        num = a.getBytes("utf-8").length;
        System.out.println(num);
    }
}
