/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class POWorkflow
extends BaseDataEntity {
    public static final String TAG_POWORKFLOWID = "POWORKFLOWID";
    public static final String TAG_POWORKFLOWNAME = "POWORKFLOWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PROCESSTIME = "PROCESSTIME";
    public static final String TAG_WFACTION = "WFACTION";
    public static final String TAG_WFACTIONDETAIL = "WFACTIONDETAIL";
    public static final String TAG_PROCESSDATE = "PROCESSDATE";
    public static final String TAG_WFID = "WFID";
    public static final String TAG_WFNAME = "WFNAME";

    public String getPOWORKFLOWID() {
        return this.GetParamStringValue(TAG_POWORKFLOWID, "");
    }

    public void setPOWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_POWORKFLOWID, strValue);
    }

    public String getPOWORKFLOWNAME() {
        return this.GetParamStringValue(TAG_POWORKFLOWNAME, "");
    }

    public void setPOWORKFLOWNAME(String strValue) {
        this.SetParamValue(TAG_POWORKFLOWNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public int getPROCESSTIME() {
        return this.GetParamIntValue(TAG_PROCESSTIME, 0);
    }

    public void setPROCESSTIME(int strValue) {
        this.SetParamValue(TAG_PROCESSTIME, strValue);
    }

    public String getWFACTION() {
        return this.GetParamStringValue(TAG_WFACTION, "");
    }

    public void setWFACTION(String strValue) {
        this.SetParamValue(TAG_WFACTION, strValue);
    }

    public String getWFACTIONDETAIL() {
        return this.GetParamStringValue(TAG_WFACTIONDETAIL, "");
    }

    public void setWFACTIONDETAIL(String strValue) {
        this.SetParamValue(TAG_WFACTIONDETAIL, strValue);
    }

    public Date getPROCESSDATE() {
        return this.GetParamDateValue(TAG_PROCESSDATE, null);
    }

    public void setPROCESSDATE(Date strValue) {
        this.SetParamValue(TAG_PROCESSDATE, strValue);
    }

    public String getWFID() {
        return this.GetParamStringValue(TAG_WFID, "");
    }

    public void setWFID(String strValue) {
        this.SetParamValue(TAG_WFID, strValue);
    }

    public String getWFNAME() {
        return this.GetParamStringValue(TAG_WFNAME, "");
    }

    public void setWFNAME(String strValue) {
        this.SetParamValue(TAG_WFNAME, strValue);
    }
}

