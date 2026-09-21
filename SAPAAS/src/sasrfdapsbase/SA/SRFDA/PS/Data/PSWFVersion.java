/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isWFMODELNull() {
        return this.IsParamNull(TAG_WFMODEL);
    }

    public final String getWFMODEL() {
        return this.GetParamStringValue(TAG_WFMODEL, "");
    }

    public final void setWFMODEL(String strValue) {
        this.SetParamValue(TAG_WFMODEL, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isWFVERSIONNull() {
        return this.IsParamNull(TAG_WFVERSION);
    }

    public final int getWFVERSION() {
        return this.GetParamIntValue(TAG_WFVERSION, 0);
    }

    public final void setWFVERSION(int nValue) {
        this.SetParamValue(TAG_WFVERSION, nValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isWFMODENull() {
        return this.IsParamNull(TAG_WFMODE);
    }

    public final String getWFMODE() {
        return this.GetParamStringValue(TAG_WFMODE, "");
    }

    public final void setWFMODE(String strValue) {
        this.SetParamValue(TAG_WFMODE, strValue);
    }

    public final boolean isACTIVITIMODELNull() {
        return this.IsParamNull(TAG_ACTIVITIMODEL);
    }

    public final String getACTIVITIMODEL() {
        return this.GetParamStringValue(TAG_ACTIVITIMODEL, "");
    }

    public final void setACTIVITIMODEL(String strValue) {
        this.SetParamValue(TAG_ACTIVITIMODEL, strValue);
    }

    public final boolean isWFENGINETYPENull() {
        return this.IsParamNull(TAG_WFENGINETYPE);
    }

    public final String getWFENGINETYPE() {
        return this.GetParamStringValue(TAG_WFENGINETYPE, "");
    }

    public final void setWFENGINETYPE(String strValue) {
        this.SetParamValue(TAG_WFENGINETYPE, strValue);
    }

    public final boolean isBPMNMODELNull() {
        return this.IsParamNull(TAG_BPMNMODEL);
    }

    public final String getBPMNMODEL() {
        return this.GetParamStringValue(TAG_BPMNMODEL, "");
    }

    public final void setBPMNMODEL(String strValue) {
        this.SetParamValue(TAG_BPMNMODEL, strValue);
    }
}

