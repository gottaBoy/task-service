/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICalculatedMeasure
extends BaseDataEntity {
    public static final String TAG_BICALCULATEDMEASUREID = "BICALCULATEDMEASUREID";
    public static final String TAG_BICALCULATEDMEASURENAME = "BICALCULATEDMEASURENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEMEASURETYPE = "BICUBEMEASURETYPE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_MEASUREFORMULA = "MEASUREFORMULA";
    public static final String TAG_FMTTYPE = "FMTTYPE";
    public static final String TAG_CUSTOMFMT = "CUSTOMFMT";
    public static final String TAG_HIDDENFLAG = "HIDDENFLAG";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";

    public String getBICALCULATEDMEASUREID() {
        return this.GetParamStringValue(TAG_BICALCULATEDMEASUREID, "");
    }

    public void setBICALCULATEDMEASUREID(String strValue) {
        this.SetParamValue(TAG_BICALCULATEDMEASUREID, strValue);
    }

    public String getBICALCULATEDMEASURENAME() {
        return this.GetParamStringValue(TAG_BICALCULATEDMEASURENAME, "");
    }

    public void setBICALCULATEDMEASURENAME(String strValue) {
        this.SetParamValue(TAG_BICALCULATEDMEASURENAME, strValue);
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

    public String getBICUBEMEASURETYPE() {
        return this.GetParamStringValue(TAG_BICUBEMEASURETYPE, "");
    }

    public void setBICUBEMEASURETYPE(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURETYPE, strValue);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public String getMEASUREFORMULA() {
        return this.GetParamStringValue(TAG_MEASUREFORMULA, "");
    }

    public void setMEASUREFORMULA(String strValue) {
        this.SetParamValue(TAG_MEASUREFORMULA, strValue);
    }

    public String getFMTTYPE() {
        return this.GetParamStringValue(TAG_FMTTYPE, "");
    }

    public void setFMTTYPE(String strValue) {
        this.SetParamValue(TAG_FMTTYPE, strValue);
    }

    public String getCUSTOMFMT() {
        return this.GetParamStringValue(TAG_CUSTOMFMT, "");
    }

    public void setCUSTOMFMT(String strValue) {
        this.SetParamValue(TAG_CUSTOMFMT, strValue);
    }

    public boolean getHIDDENFLAG() {
        return this.GetParamIntValue(TAG_HIDDENFLAG, 0) == 1;
    }

    public void setHIDDENFLAG(boolean bValue) {
        this.SetParamValue(TAG_HIDDENFLAG, bValue ? 1 : 0);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }
}

