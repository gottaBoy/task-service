/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSCounterType
extends BaseDataEntity {
    public static final String TAG_PSCOUNTERTYPEID = "PSCOUNTERTYPEID";
    public static final String TAG_PSCOUNTERTYPENAME = "PSCOUNTERTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_COUNTEROBJ = "COUNTEROBJ";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_TYPEPARAMS = "TYPEPARAMS";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";

    public final boolean isPSCOUNTERTYPEIDNull() {
        return this.isParamNull(TAG_PSCOUNTERTYPEID);
    }

    public final String getPSCOUNTERTYPEID() {
        return this.getParamStringValue(TAG_PSCOUNTERTYPEID, "");
    }

    public final void setPSCOUNTERTYPEID(String strValue) {
        this.setParamValue(TAG_PSCOUNTERTYPEID, strValue);
    }

    public final boolean isPSCOUNTERTYPENAMENull() {
        return this.isParamNull(TAG_PSCOUNTERTYPENAME);
    }

    public final String getPSCOUNTERTYPENAME() {
        return this.getParamStringValue(TAG_PSCOUNTERTYPENAME, "");
    }

    public final void setPSCOUNTERTYPENAME(String strValue) {
        this.setParamValue(TAG_PSCOUNTERTYPENAME, strValue);
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

    public final boolean isCOUNTEROBJNull() {
        return this.isParamNull(TAG_COUNTEROBJ);
    }

    public final String getCOUNTEROBJ() {
        return this.getParamStringValue(TAG_COUNTEROBJ, "");
    }

    public final void setCOUNTEROBJ(String strValue) {
        this.setParamValue(TAG_COUNTEROBJ, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.isParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.getParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.setParamValue(TAG_TYPEOBJ, strValue);
    }

    public final boolean isTYPEPARAMSNull() {
        return this.isParamNull(TAG_TYPEPARAMS);
    }

    public final String getTYPEPARAMS() {
        return this.getParamStringValue(TAG_TYPEPARAMS, "");
    }

    public final void setTYPEPARAMS(String strValue) {
        this.setParamValue(TAG_TYPEPARAMS, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.isParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.getParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.setParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isJITCTRLOBJNull() {
        return this.isParamNull(TAG_JITCTRLOBJ);
    }

    public final String getJITCTRLOBJ() {
        return this.getParamStringValue(TAG_JITCTRLOBJ, "");
    }

    public final void setJITCTRLOBJ(String strValue) {
        this.setParamValue(TAG_JITCTRLOBJ, strValue);
    }
}

