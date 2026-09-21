/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BITD_Hour
extends BaseDataEntity {
    public static final String TAG_BITD_HOURID = "BITD_HOURID";
    public static final String TAG_BITD_HOURNAME = "BITD_HOURNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_YEARVALUE = "YEARVALUE";
    public static final String TAG_MONTHVALUE = "MONTHVALUE";
    public static final String TAG_DAYVALUE = "DAYVALUE";
    public static final String TAG_HOURVALUE = "HOURVALUE";
    public static final String TAG_DAYTEXT = "DAYTEXT";
    public static final String TAG_MONTHTEXT = "MONTHTEXT";
    public static final String TAG_YEARTEXT = "YEARTEXT";
    public static final String TAG_HOURTEXT = "HOURTEXT";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";

    public String getBITD_HOURID() {
        return this.GetParamStringValue(TAG_BITD_HOURID, "");
    }

    public void setBITD_HOURID(String strValue) {
        this.SetParamValue(TAG_BITD_HOURID, strValue);
    }

    public String getBITD_HOURNAME() {
        return this.GetParamStringValue(TAG_BITD_HOURNAME, "");
    }

    public void setBITD_HOURNAME(String strValue) {
        this.SetParamValue(TAG_BITD_HOURNAME, strValue);
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

    public int getYEARVALUE() {
        return this.GetParamIntValue(TAG_YEARVALUE, 0);
    }

    public void setYEARVALUE(int strValue) {
        this.SetParamValue(TAG_YEARVALUE, strValue);
    }

    public int getMONTHVALUE() {
        return this.GetParamIntValue(TAG_MONTHVALUE, 0);
    }

    public void setMONTHVALUE(int strValue) {
        this.SetParamValue(TAG_MONTHVALUE, strValue);
    }

    public int getDAYVALUE() {
        return this.GetParamIntValue(TAG_DAYVALUE, 0);
    }

    public void setDAYVALUE(int strValue) {
        this.SetParamValue(TAG_DAYVALUE, strValue);
    }

    public int getHOURVALUE() {
        return this.GetParamIntValue(TAG_HOURVALUE, 0);
    }

    public void setHOURVALUE(int strValue) {
        this.SetParamValue(TAG_HOURVALUE, strValue);
    }

    public String getDAYTEXT() {
        return this.GetParamStringValue(TAG_DAYTEXT, "");
    }

    public void setDAYTEXT(String strValue) {
        this.SetParamValue(TAG_DAYTEXT, strValue);
    }

    public String getMONTHTEXT() {
        return this.GetParamStringValue(TAG_MONTHTEXT, "");
    }

    public void setMONTHTEXT(String strValue) {
        this.SetParamValue(TAG_MONTHTEXT, strValue);
    }

    public String getYEARTEXT() {
        return this.GetParamStringValue(TAG_YEARTEXT, "");
    }

    public void setYEARTEXT(String strValue) {
        this.SetParamValue(TAG_YEARTEXT, strValue);
    }

    public String getHOURTEXT() {
        return this.GetParamStringValue(TAG_HOURTEXT, "");
    }

    public void setHOURTEXT(String strValue) {
        this.SetParamValue(TAG_HOURTEXT, strValue);
    }

    public Date getSTARTTIME() {
        return this.GetParamDateValue(TAG_STARTTIME, null);
    }

    public void setSTARTTIME(Date strValue) {
        this.SetParamValue(TAG_STARTTIME, strValue);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }
}

