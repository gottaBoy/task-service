/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Threshold
extends BaseDataEntity {
    public static final String TAG_THRESHOLDID = "THRESHOLDID";
    public static final String TAG_THRESHOLDNAME = "THRESHOLDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_THGROUPID = "THGROUPID";
    public static final String TAG_THGROUPNAME = "THGROUPNAME";
    public static final String TAG_COLOR = "COLOR";
    public static final String TAG_ENDVALUE = "ENDVALUE";
    public static final String TAG_STARTVALUE = "STARTVALUE";
    public static final String TAG_THRESHOLDCODE = "THRESHOLDCODE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_SLSTYLE = "SLSTYLE";

    public String getTHRESHOLDID() {
        return this.GetParamStringValue(TAG_THRESHOLDID, "");
    }

    public void setTHRESHOLDID(String strValue) {
        this.SetParamValue(TAG_THRESHOLDID, strValue);
    }

    public String getTHRESHOLDNAME() {
        return this.GetParamStringValue(TAG_THRESHOLDNAME, "");
    }

    public void setTHRESHOLDNAME(String strValue) {
        this.SetParamValue(TAG_THRESHOLDNAME, strValue);
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

    public String getTHGROUPID() {
        return this.GetParamStringValue(TAG_THGROUPID, "");
    }

    public void setTHGROUPID(String strValue) {
        this.SetParamValue(TAG_THGROUPID, strValue);
    }

    public String getTHGROUPNAME() {
        return this.GetParamStringValue(TAG_THGROUPNAME, "");
    }

    public void setTHGROUPNAME(String strValue) {
        this.SetParamValue(TAG_THGROUPNAME, strValue);
    }

    public String getCOLOR() {
        return this.GetParamStringValue(TAG_COLOR, "");
    }

    public void setCOLOR(String strValue) {
        this.SetParamValue(TAG_COLOR, strValue);
    }

    public float getENDVALUE() {
        return this.GetParamFloatValue(TAG_ENDVALUE, 0.0f);
    }

    public void setENDVALUE(float strValue) {
        this.SetParamValue(TAG_ENDVALUE, Float.valueOf(strValue));
    }

    public float getSTARTVALUE() {
        return this.GetParamFloatValue(TAG_STARTVALUE, 0.0f);
    }

    public void setSTARTVALUE(float strValue) {
        this.SetParamValue(TAG_STARTVALUE, Float.valueOf(strValue));
    }

    public String getTHRESHOLDCODE() {
        return this.GetParamStringValue(TAG_THRESHOLDCODE, "");
    }

    public void setTHRESHOLDCODE(String strValue) {
        this.SetParamValue(TAG_THRESHOLDCODE, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getSLSTYLE() {
        return this.GetParamStringValue(TAG_SLSTYLE, "");
    }

    public void setSLSTYLE(String strValue) {
        this.SetParamValue(TAG_SLSTYLE, strValue);
    }
}

