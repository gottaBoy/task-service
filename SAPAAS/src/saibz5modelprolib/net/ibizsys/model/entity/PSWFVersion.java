/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFVersion
extends BaseDataEntity {
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_WFMODEL = "WFMODEL";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_WFMODE = "WFMODE";
    public static final String TAG_ACTIVITIMODEL = "ACTIVITIMODEL";
    public static final String TAG_WFENGINETYPE = "WFENGINETYPE";
    public static final String TAG_BPMNMODEL = "BPMNMODEL";

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.isParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.getParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.setParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.isParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.getParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFNAME, strValue);
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

    public final boolean isWFMODELNull() {
        return this.isParamNull(TAG_WFMODEL);
    }

    public final String getWFMODEL() {
        return this.getParamStringValue(TAG_WFMODEL, "");
    }

    public final void setWFMODEL(String strValue) {
        this.setParamValue(TAG_WFMODEL, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isWFVERSIONNull() {
        return this.isParamNull(TAG_WFVERSION);
    }

    public final int getWFVERSION() {
        return this.getParamIntValue(TAG_WFVERSION, 0);
    }

    public final void setWFVERSION(int nValue) {
        this.setParamValue(TAG_WFVERSION, nValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isWFMODENull() {
        return this.isParamNull(TAG_WFMODE);
    }

    public final String getWFMODE() {
        return this.getParamStringValue(TAG_WFMODE, "");
    }

    public final void setWFMODE(String strValue) {
        this.setParamValue(TAG_WFMODE, strValue);
    }

    public final boolean isACTIVITIMODELNull() {
        return this.isParamNull(TAG_ACTIVITIMODEL);
    }

    public final String getACTIVITIMODEL() {
        return this.getParamStringValue(TAG_ACTIVITIMODEL, "");
    }

    public final void setACTIVITIMODEL(String strValue) {
        this.setParamValue(TAG_ACTIVITIMODEL, strValue);
    }

    public final boolean isWFENGINETYPENull() {
        return this.isParamNull(TAG_WFENGINETYPE);
    }

    public final String getWFENGINETYPE() {
        return this.getParamStringValue(TAG_WFENGINETYPE, "");
    }

    public final void setWFENGINETYPE(String strValue) {
        this.setParamValue(TAG_WFENGINETYPE, strValue);
    }

    public final boolean isBPMNMODELNull() {
        return this.isParamNull(TAG_BPMNMODEL);
    }

    public final String getBPMNMODEL() {
        return this.getParamStringValue(TAG_BPMNMODEL, "");
    }

    public final void setBPMNMODEL(String strValue) {
        this.setParamValue(TAG_BPMNMODEL, strValue);
    }
}

