/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFDEActionProcessParamModel;

public class WFDEActionProcessParamModel
implements IWFDEActionProcessParamModel {
    private String strDstField = "";
    private String strSrcValue = "";
    private String strSrcValueType = "";

    @Override
    public String getDstField() throws Exception {
        return this.strDstField;
    }

    @Override
    public String getSrcValue() {
        return this.strSrcValue;
    }

    @Override
    public String getDirectCode() {
        return null;
    }

    @Override
    public String getSrcValueType() {
        return this.strSrcValueType;
    }

    public void setDstField(String strDstField) {
        this.strDstField = strDstField;
    }

    public void setSrcValue(String strSrcValue) {
        this.strSrcValue = strSrcValue;
    }

    public void setSrcValueType(String strSrcValueType) {
        this.strSrcValueType = strSrcValueType;
    }
}

