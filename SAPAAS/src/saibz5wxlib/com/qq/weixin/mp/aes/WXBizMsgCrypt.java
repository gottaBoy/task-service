/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.codec.binary.Base64
 */
package com.qq.weixin.mp.aes;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.ByteGroup;
import com.qq.weixin.mp.aes.PKCS7Encoder;
import com.qq.weixin.mp.aes.SHA1;
import com.qq.weixin.mp.aes.XMLParse;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class WXBizMsgCrypt {
    static Charset CHARSET = Charset.forName("utf-8");
    Base64 base64 = new Base64();
    byte[] aesKey;
    String token;
    String corpId;

    public WXBizMsgCrypt(String token, String encodingAesKey, String corpId) throws AesException {
        if (encodingAesKey.length() != 43) {
            throw new AesException(-40004);
        }
        this.token = token;
        this.corpId = corpId;
        this.aesKey = Base64.decodeBase64((String)(String.valueOf(encodingAesKey) + "="));
    }

    byte[] getNetworkBytesOrder(int sourceNumber) {
        byte[] orderBytes = new byte[4];
        orderBytes[3] = (byte)(sourceNumber & 0xFF);
        orderBytes[2] = (byte)(sourceNumber >> 8 & 0xFF);
        orderBytes[1] = (byte)(sourceNumber >> 16 & 0xFF);
        orderBytes[0] = (byte)(sourceNumber >> 24 & 0xFF);
        return orderBytes;
    }

    int recoverNetworkBytesOrder(byte[] orderBytes) {
        int sourceNumber = 0;
        int i = 0;
        while (i < 4) {
            sourceNumber <<= 8;
            sourceNumber |= orderBytes[i] & 0xFF;
            ++i;
        }
        return sourceNumber;
    }

    String getRandomStr() {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < 16) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
            ++i;
        }
        return sb.toString();
    }

    String encrypt(String randomStr, String text) throws AesException {
        ByteGroup byteCollector = new ByteGroup();
        byte[] randomStrBytes = randomStr.getBytes(CHARSET);
        byte[] textBytes = text.getBytes(CHARSET);
        byte[] networkBytesOrder = this.getNetworkBytesOrder(textBytes.length);
        byte[] corpidBytes = this.corpId.getBytes(CHARSET);
        byteCollector.addBytes(randomStrBytes);
        byteCollector.addBytes(networkBytesOrder);
        byteCollector.addBytes(textBytes);
        byteCollector.addBytes(corpidBytes);
        byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
        byteCollector.addBytes(padBytes);
        byte[] unencrypted = byteCollector.toBytes();
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(this.aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(this.aesKey, 0, 16);
            cipher.init(1, (Key)keySpec, iv);
            byte[] encrypted = cipher.doFinal(unencrypted);
            String base64Encrypted = this.base64.encodeToString(encrypted);
            return base64Encrypted;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new AesException(-40006);
        }
    }

    String decrypt(String text) throws AesException {
        String from_corpid;
        String xmlContent;
        byte[] original;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec key_spec = new SecretKeySpec(this.aesKey, "AES");
            IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(this.aesKey, 0, 16));
            cipher.init(2, (Key)key_spec, iv);
            byte[] encrypted = Base64.decodeBase64((String)text);
            original = cipher.doFinal(encrypted);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new AesException(-40007);
        }
        try {
            byte[] bytes = PKCS7Encoder.decode(original);
            byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
            int xmlLength = this.recoverNetworkBytesOrder(networkOrder);
            xmlContent = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
            from_corpid = new String(Arrays.copyOfRange(bytes, 20 + xmlLength, bytes.length), CHARSET);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new AesException(-40008);
        }
        if (!from_corpid.equals(this.corpId)) {
            throw new AesException(-40005);
        }
        return xmlContent;
    }

    public String EncryptMsg(String replyMsg, String timeStamp, String nonce) throws AesException {
        String encrypt = this.encrypt(this.getRandomStr(), replyMsg);
        if (timeStamp == "") {
            timeStamp = Long.toString(System.currentTimeMillis());
        }
        String signature = SHA1.getSHA1(this.token, timeStamp, nonce, encrypt);
        String result = XMLParse.generate(encrypt, signature, timeStamp, nonce);
        return result;
    }

    public String DecryptMsg(String msgSignature, String timeStamp, String nonce, String postData) throws AesException {
        Object[] encrypt = XMLParse.extract(postData);
        String signature = SHA1.getSHA1(this.token, timeStamp, nonce, encrypt[1].toString());
        if (!signature.equals(msgSignature)) {
            throw new AesException(-40001);
        }
        String result = this.decrypt(encrypt[1].toString());
        return result;
    }

    public String VerifyURL(String msgSignature, String timeStamp, String nonce, String echoStr) throws AesException {
        String signature = SHA1.getSHA1(this.token, timeStamp, nonce, echoStr);
        if (!signature.equals(msgSignature)) {
            throw new AesException(-40001);
        }
        String result = this.decrypt(echoStr);
        return result;
    }
}

