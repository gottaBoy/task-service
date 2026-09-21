/*
 * Decompiled with CFR 0.152.
 */
package com.qq.weixin.mp.aes;

public class AesException
extends Exception {
    public static final int OK = 0;
    public static final int ValidateSignatureError = -40001;
    public static final int ParseXmlError = -40002;
    public static final int ComputeSignatureError = -40003;
    public static final int IllegalAesKey = -40004;
    public static final int ValidateCorpidError = -40005;
    public static final int EncryptAESError = -40006;
    public static final int DecryptAESError = -40007;
    public static final int IllegalBuffer = -40008;
    private int code;

    private static String getMessage(int code) {
        switch (code) {
            case -40001: {
                return "\u7b7e\u540d\u9a8c\u8bc1\u9519\u8bef";
            }
            case -40002: {
                return "xml\u89e3\u6790\u5931\u8d25";
            }
            case -40003: {
                return "sha\u52a0\u5bc6\u751f\u6210\u7b7e\u540d\u5931\u8d25";
            }
            case -40004: {
                return "SymmetricKey\u975e\u6cd5";
            }
            case -40005: {
                return "corpid\u6821\u9a8c\u5931\u8d25";
            }
            case -40006: {
                return "aes\u52a0\u5bc6\u5931\u8d25";
            }
            case -40007: {
                return "aes\u89e3\u5bc6\u5931\u8d25";
            }
            case -40008: {
                return "\u89e3\u5bc6\u540e\u5f97\u5230\u7684buffer\u975e\u6cd5";
            }
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    AesException(int code) {
        super(AesException.getMessage(code));
        this.code = code;
    }
}

