/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFWFVersion
extends BaseDataEntity {
    public static final String TAG_WFWFVERSIONID = "WFWFVERSIONID";
    public static final String TAG_WFWFVERSIONNAME = "WFWFVERSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WFWFID = "WFWFID";
    public static final String TAG_WFWFNAME = "WFWFNAME";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_WFMODEL = "WFMODEL";

    public boolean isWFWFVERSIONIDNull() {
        return this.IsParamNull(TAG_WFWFVERSIONID);
    }

    public String getWFWFVERSIONID() {
        return this.GetParamStringValue(TAG_WFWFVERSIONID, "");
    }

    public void setWFWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_WFWFVERSIONID, strValue);
    }

    public boolean isWFWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_WFWFVERSIONNAME);
    }

    public String getWFWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_WFWFVERSIONNAME, "");
    }

    public void setWFWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_WFWFVERSIONNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isWFWFIDNull() {
        return this.IsParamNull(TAG_WFWFID);
    }

    public String getWFWFID() {
        return this.GetParamStringValue(TAG_WFWFID, "");
    }

    public void setWFWFID(String strValue) {
        this.SetParamValue(TAG_WFWFID, strValue);
    }

    public boolean isWFWFNAMENull() {
        return this.IsParamNull(TAG_WFWFNAME);
    }

    public String getWFWFNAME() {
        return this.GetParamStringValue(TAG_WFWFNAME, "");
    }

    public void setWFWFNAME(String strValue) {
        this.SetParamValue(TAG_WFWFNAME, strValue);
    }

    public boolean isWFVERSIONNull() {
        return this.IsParamNull(TAG_WFVERSION);
    }

    public int getWFVERSION() {
        return this.GetParamIntValue(TAG_WFVERSION, 0);
    }

    public void setWFVERSION(int strValue) {
        this.SetParamValue(TAG_WFVERSION, strValue);
    }

    public boolean isWFMODELNull() {
        return this.IsParamNull(TAG_WFMODEL);
    }

    public String getWFMODEL() {
        return this.GetParamStringValue(TAG_WFMODEL, "");
    }

    public void setWFMODEL(String strValue) {
        this.SetParamValue(TAG_WFMODEL, strValue);
    }
}

