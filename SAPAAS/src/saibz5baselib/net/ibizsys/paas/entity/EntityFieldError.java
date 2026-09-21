/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.entity;

import net.ibizsys.paas.util.StringHelper;

public class EntityFieldError {
    public static final int ERROR_OK = 0;
    public static final int ERROR_EMPTY = 1;
    public static final int ERROR_DATATYPE = 2;
    public static final int ERROR_VALUERULE = 3;
    private String strFieldLogicName = "";
    private String strFieldName = "";
    private String strFieldErrorId = "";
    private int nErrorType = 0;
    private String strErrorInfo = "";
    private Object objFieldValue = null;

    public String getFieldName() {
        return this.strFieldName;
    }

    public void setFieldName(String strFieldName) {
        this.strFieldName = strFieldName;
    }

    public Object getFieldValue() {
        return this.objFieldValue;
    }

    public void setFieldValue(Object objFieldValue) {
        this.objFieldValue = objFieldValue;
    }

    public String getFieldLogicName() {
        return this.strFieldLogicName;
    }

    public void setFieldLogicName(String strFieldLogicName) {
        this.strFieldLogicName = strFieldLogicName;
    }

    public String getFieldErrorId() {
        return this.strFieldErrorId;
    }

    public void setFieldErrorId(String strFieldErrorId) {
        this.strFieldErrorId = strFieldErrorId;
    }

    public String getErrorInfo() {
        return this.strErrorInfo;
    }

    public void setErrorInfo(String strErrorInfo) {
        this.strErrorInfo = strErrorInfo;
    }

    public int getErrorType() {
        return this.nErrorType;
    }

    public void setErrorType(int nErrorType) {
        this.nErrorType = nErrorType;
    }

    public String toString() {
        if (StringHelper.isNullOrEmpty(this.getFieldLogicName())) {
            return StringHelper.format("%1$s[%2$s], %3$s", this.getFieldName(), EntityFieldError.getErrorTypeString(this.getErrorType()), this.getErrorInfo());
        }
        return StringHelper.format("%1$s[%2$s], %3$s", this.getFieldLogicName(), EntityFieldError.getErrorTypeString(this.getErrorType()), this.getErrorInfo());
    }

    public static String getErrorTypeString(int nErrorType) {
        switch (nErrorType) {
            case 1: {
                return "\u6570\u636e\u8f93\u5165\u4e3a\u7a7a\u9519\u8bef";
            }
            case 2: {
                return "\u6570\u636e\u7c7b\u578b\u4e0d\u6b63\u786e\u9519\u8bef";
            }
            case 3: {
                return "\u503c\u89c4\u5219\u9519\u8bef";
            }
        }
        return "\u672a\u77e5\u9519\u8bef";
    }
}

