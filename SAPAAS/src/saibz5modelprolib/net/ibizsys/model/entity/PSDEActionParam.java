/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEActionParam
extends BaseDataEntity {
    public static final String VALUETYPE_VALUE = "VALUE";
    public static final String VALUETYPE_NULLVALUE = "NULLVALUE";
    public static final String VALUETYPE_SESSION = "SESSION";
    public static final String VALUETYPE_APPLICATION = "APPLICATION";
    public static final String VALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String VALUETYPE_CONTEXT = "CONTEXT";
    public static final String VALUETYPE_PARAM = "PARAM";
    public static final String VALUETYPE_OPERATOR = "OPERATOR";
    public static final String VALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String VALUETYPE_CURTIME = "CURTIME";
    public static final String VALUETYPE_APPDATA = "APPDATA";
    public static final String VALUETYPE_NONEVALUE = "NONEVALUE";
    public static final String TAG_PSDEACTIONPARAMID = "PSDEACTIONPARAMID";
    public static final String TAG_PSDEACTIONPARAMNAME = "PSDEACTIONPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_VALUETYPE = "VALUETYPE";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMDESC = "PARAMDESC";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSDEACTIONPARAMIDNull() {
        return this.isParamNull(TAG_PSDEACTIONPARAMID);
    }

    public final String getPSDEACTIONPARAMID() {
        return this.getParamStringValue(TAG_PSDEACTIONPARAMID, "");
    }

    public final void setPSDEACTIONPARAMID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONPARAMID, strValue);
    }

    public final boolean isPSDEACTIONPARAMNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONPARAMNAME);
    }

    public final String getPSDEACTIONPARAMNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONPARAMNAME, "");
    }

    public final void setPSDEACTIONPARAMNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONPARAMNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isVALUETYPENull() {
        return this.isParamNull(TAG_VALUETYPE);
    }

    public final String getVALUETYPE() {
        return this.getParamStringValue(TAG_VALUETYPE, "");
    }

    public final void setVALUETYPE(String strValue) {
        this.setParamValue(TAG_VALUETYPE, strValue);
    }

    public final boolean isVALUENull() {
        return this.isParamNull("VALUE");
    }

    public final String getVALUE() {
        return this.getParamStringValue("VALUE", "");
    }

    public final void setVALUE(String strValue) {
        this.setParamValue("VALUE", strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPARAMDESCNull() {
        return this.isParamNull(TAG_PARAMDESC);
    }

    public final String getPARAMDESC() {
        return this.getParamStringValue(TAG_PARAMDESC, "");
    }

    public final void setPARAMDESC(String strValue) {
        this.setParamValue(TAG_PARAMDESC, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }
}

