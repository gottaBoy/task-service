/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFSubWF
extends BaseDataEntity {
    public static final String TAG_DESUBWFID = "DESUBWFID";
    public static final String TAG_DESUBWFNAME = "DESUBWFNAME";
    public static final String TAG_DESUBWFVR = "DESUBWFVR";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WFID = "WFID";
    public static final String TAG_WFNAME = "WFNAME";

    public String getDESUBWFID() {
        return this.GetParamStringValue(TAG_DESUBWFID, "");
    }

    public void setDESUBWFID(String strValue) {
        this.SetParamValue(TAG_DESUBWFID, strValue);
    }

    public String getDESUBWFNAME() {
        return this.GetParamStringValue(TAG_DESUBWFNAME, "");
    }

    public void setDESUBWFNAME(String strValue) {
        this.SetParamValue(TAG_DESUBWFNAME, strValue);
    }

    public String getDESUBWFVR() {
        return this.GetParamStringValue(TAG_DESUBWFVR, "");
    }

    public void setDESUBWFVR(String strValue) {
        this.SetParamValue(TAG_DESUBWFVR, strValue);
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

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
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

