/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEFValueRuleTypeDetail
extends BaseDataEntity {
    public static final String TAG_PSDEFVRTYPEDETAILID = "PSDEFVRTYPEDETAILID";
    public static final String TAG_PSDEFVRTYPEDETAILNAME = "PSDEFVRTYPEDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEFVRTYPEID = "PSDEFVRTYPEID";
    public static final String TAG_PSDEFVRTYPENAME = "PSDEFVRTYPENAME";
    public static final String TAG_PROCESSOBJ = "PROCESSOBJ";

    public final boolean isPSDEFVRTYPEDETAILIDNull() {
        return this.isParamNull(TAG_PSDEFVRTYPEDETAILID);
    }

    public final String getPSDEFVRTYPEDETAILID() {
        return this.getParamStringValue(TAG_PSDEFVRTYPEDETAILID, "");
    }

    public final void setPSDEFVRTYPEDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEFVRTYPEDETAILID, strValue);
    }

    public final boolean isPSDEFVRTYPEDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEFVRTYPEDETAILNAME);
    }

    public final String getPSDEFVRTYPEDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEFVRTYPEDETAILNAME, "");
    }

    public final void setPSDEFVRTYPEDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEFVRTYPEDETAILNAME, strValue);
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

    public final boolean isPSDEFVRTYPEIDNull() {
        return this.isParamNull(TAG_PSDEFVRTYPEID);
    }

    public final String getPSDEFVRTYPEID() {
        return this.getParamStringValue(TAG_PSDEFVRTYPEID, "");
    }

    public final void setPSDEFVRTYPEID(String strValue) {
        this.setParamValue(TAG_PSDEFVRTYPEID, strValue);
    }

    public final boolean isPSDEFVRTYPENAMENull() {
        return this.isParamNull(TAG_PSDEFVRTYPENAME);
    }

    public final String getPSDEFVRTYPENAME() {
        return this.getParamStringValue(TAG_PSDEFVRTYPENAME, "");
    }

    public final void setPSDEFVRTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDEFVRTYPENAME, strValue);
    }

    public final boolean isPROCESSOBJNull() {
        return this.isParamNull(TAG_PROCESSOBJ);
    }

    public final String getPROCESSOBJ() {
        return this.getParamStringValue(TAG_PROCESSOBJ, "");
    }

    public final void setPROCESSOBJ(String strValue) {
        this.setParamValue(TAG_PROCESSOBJ, strValue);
    }
}

