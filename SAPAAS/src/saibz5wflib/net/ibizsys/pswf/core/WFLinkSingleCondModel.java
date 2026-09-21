/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswf.core;

import net.ibizsys.pswf.core.IWFLinkSingleCondModel;
import net.ibizsys.pswf.core.WFLinkCondModelBase;

public class WFLinkSingleCondModel
extends WFLinkCondModelBase
implements IWFLinkSingleCondModel {
    private String strFieldName = "";
    private String strCondOP = "";
    private String strParamType = null;
    private String strParamValue = null;

    @Override
    public String getCondType() {
        return "SINGLE";
    }

    @Override
    public String getFieldName() throws Exception {
        return this.strFieldName;
    }

    @Override
    public String getCondOP() {
        return this.strCondOP;
    }

    @Override
    public String getParamType() {
        return this.strParamType;
    }

    @Override
    public String getParamValue() {
        return this.strParamValue;
    }

    public void setFieldName(String strFieldName) {
        this.strFieldName = strFieldName;
    }

    public void setCondOP(String strCondOP) {
        this.strCondOP = strCondOP;
    }

    public void setParamType(String strParamType) {
        this.strParamType = strParamType;
    }

    public void setParamValue(String strParamValue) {
        this.strParamValue = strParamValue;
    }
}

