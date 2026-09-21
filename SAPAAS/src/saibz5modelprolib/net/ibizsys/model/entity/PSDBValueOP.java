/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDBValueOP
extends BaseDataEntity {
    public static final String TAG_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String TAG_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_SIMPLENAME = "SIMPLENAME";

    public final boolean isPSDBVALUEOPIDNull() {
        return this.isParamNull(TAG_PSDBVALUEOPID);
    }

    public final String getPSDBVALUEOPID() {
        return this.getParamStringValue(TAG_PSDBVALUEOPID, "");
    }

    public final void setPSDBVALUEOPID(String strValue) {
        this.setParamValue(TAG_PSDBVALUEOPID, strValue);
    }

    public final boolean isPSDBVALUEOPNAMENull() {
        return this.isParamNull(TAG_PSDBVALUEOPNAME);
    }

    public final String getPSDBVALUEOPNAME() {
        return this.getParamStringValue(TAG_PSDBVALUEOPNAME, "");
    }

    public final void setPSDBVALUEOPNAME(String strValue) {
        this.setParamValue(TAG_PSDBVALUEOPNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isSIMPLENAMENull() {
        return this.isParamNull(TAG_SIMPLENAME);
    }

    public final String getSIMPLENAME() {
        return this.getParamStringValue(TAG_SIMPLENAME, "");
    }

    public final void setSIMPLENAME(String strValue) {
        this.setParamValue(TAG_SIMPLENAME, strValue);
    }
}

