/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFProcParam
extends BaseDataEntity {
    public static final String SRCVALUETYPE_SESSION = "SESSION";
    public static final String SRCVALUETYPE_APPLICATION = "APPLICATION";
    public static final String SRCVALUETYPE_UNIQUEID = "UNIQUEID";
    public static final String SRCVALUETYPE_CONTEXT = "CONTEXT";
    public static final String SRCVALUETYPE_OPERATOR = "OPERATOR";
    public static final String SRCVALUETYPE_OPERATORNAME = "OPERATORNAME";
    public static final String SRCVALUETYPE_CURTIME = "CURTIME";
    public static final String TAG_PSWFPROCPARAMID = "PSWFPROCPARAMID";
    public static final String TAG_PSWFPROCPARAMNAME = "PSWFPROCPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String TAG_SRCVALUE = "SRCVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CUSTOMDSTDEFNAME = "CUSTOMDSTDEFNAME";

    public final boolean isPSWFPROCPARAMIDNull() {
        return this.isParamNull(TAG_PSWFPROCPARAMID);
    }

    public final String getPSWFPROCPARAMID() {
        return this.getParamStringValue(TAG_PSWFPROCPARAMID, "");
    }

    public final void setPSWFPROCPARAMID(String strValue) {
        this.setParamValue(TAG_PSWFPROCPARAMID, strValue);
    }

    public final boolean isPSWFPROCPARAMNAMENull() {
        return this.isParamNull(TAG_PSWFPROCPARAMNAME);
    }

    public final String getPSWFPROCPARAMNAME() {
        return this.getParamStringValue(TAG_PSWFPROCPARAMNAME, "");
    }

    public final void setPSWFPROCPARAMNAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCPARAMNAME, strValue);
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

    public final boolean isPSWFPROCESSIDNull() {
        return this.isParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.getParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSID, strValue);
    }

    public final boolean isPSWFPROCESSNAMENull() {
        return this.isParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.getParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSNAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isSRCVALUETYPENull() {
        return this.isParamNull(TAG_SRCVALUETYPE);
    }

    public final String getSRCVALUETYPE() {
        return this.getParamStringValue(TAG_SRCVALUETYPE, "");
    }

    public final void setSRCVALUETYPE(String strValue) {
        this.setParamValue(TAG_SRCVALUETYPE, strValue);
    }

    public final boolean isSRCVALUENull() {
        return this.isParamNull(TAG_SRCVALUE);
    }

    public final String getSRCVALUE() {
        return this.getParamStringValue(TAG_SRCVALUE, "");
    }

    public final void setSRCVALUE(String strValue) {
        this.setParamValue(TAG_SRCVALUE, strValue);
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

    public final boolean isCUSTOMDSTDEFNAMENull() {
        return this.isParamNull(TAG_CUSTOMDSTDEFNAME);
    }

    public final String getCUSTOMDSTDEFNAME() {
        return this.getParamStringValue(TAG_CUSTOMDSTDEFNAME, "");
    }

    public final void setCUSTOMDSTDEFNAME(String strValue) {
        this.setParamValue(TAG_CUSTOMDSTDEFNAME, strValue);
    }
}

