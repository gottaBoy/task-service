/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

public interface IWFDEActionProcessParamModel {
    public static final String SRCVALUETYPE_SESSION = "SESSION";
    public static final String SRCVALUETYPE_APPLICATION = "APPLICATION";
    public static final String SRCVALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String SRCVALUETYPE_CONTEXT = "CONTEXT";
    public static final String SRCVALUETYPE_OPERATOR = "OPERATOR";
    public static final String SRCVALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String SRCVALUETYPE_CURTIME = "CURTIME";

    public String getDstField() throws Exception;

    public String getSrcValue();

    public String getDirectCode();

    public String getSrcValueType();
}

