/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSCounter
extends BaseDataEntity {
    public static final String TAG_PSCOUNTERID = "PSCOUNTERID";
    public static final String TAG_PSCOUNTERNAME = "PSCOUNTERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_COUNTERTYPE = "COUNTERTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";

    public final boolean isPSCOUNTERIDNull() {
        return this.isParamNull(TAG_PSCOUNTERID);
    }

    public final String getPSCOUNTERID() {
        return this.getParamStringValue(TAG_PSCOUNTERID, "");
    }

    public final void setPSCOUNTERID(String strValue) {
        this.setParamValue(TAG_PSCOUNTERID, strValue);
    }

    public final boolean isPSCOUNTERNAMENull() {
        return this.isParamNull(TAG_PSCOUNTERNAME);
    }

    public final String getPSCOUNTERNAME() {
        return this.getParamStringValue(TAG_PSCOUNTERNAME, "");
    }

    public final void setPSCOUNTERNAME(String strValue) {
        this.setParamValue(TAG_PSCOUNTERNAME, strValue);
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

    public final boolean isCOUNTERTYPENull() {
        return this.isParamNull(TAG_COUNTERTYPE);
    }

    public final String getCOUNTERTYPE() {
        return this.getParamStringValue(TAG_COUNTERTYPE, "");
    }

    public final void setCOUNTERTYPE(String strValue) {
        this.setParamValue(TAG_COUNTERTYPE, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
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

