/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSR2SumTable
extends BaseDataEntity {
    public static final String TAG_GSR2SUMTABLEID = "GSR2SUMTABLEID";
    public static final String TAG_GSR2SUMTABLENAME = "GSR2SUMTABLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GSR2ID = "GSR2ID";
    public static final String TAG_GSR2NAME = "GSR2NAME";
    public static final String TAG_TD = "TD";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_EXCOND = "EXCOND";
    public static final String TAG_FACTDEID = "FACTDEID";
    public static final String TAG_FACTDENAME = "FACTDENAME";

    public String getGSR2SUMTABLEID() {
        return this.GetParamStringValue(TAG_GSR2SUMTABLEID, "");
    }

    public void setGSR2SUMTABLEID(String strValue) {
        this.SetParamValue(TAG_GSR2SUMTABLEID, strValue);
    }

    public String getGSR2SUMTABLENAME() {
        return this.GetParamStringValue(TAG_GSR2SUMTABLENAME, "");
    }

    public void setGSR2SUMTABLENAME(String strValue) {
        this.SetParamValue(TAG_GSR2SUMTABLENAME, strValue);
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

    public String getGSR2ID() {
        return this.GetParamStringValue(TAG_GSR2ID, "");
    }

    public void setGSR2ID(String strValue) {
        this.SetParamValue(TAG_GSR2ID, strValue);
    }

    public String getGSR2NAME() {
        return this.GetParamStringValue(TAG_GSR2NAME, "");
    }

    public void setGSR2NAME(String strValue) {
        this.SetParamValue(TAG_GSR2NAME, strValue);
    }

    public String getTD() {
        return this.GetParamStringValue(TAG_TD, "");
    }

    public void setTD(String strValue) {
        this.SetParamValue(TAG_TD, strValue);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setORDERFLAG(int strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }

    public boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public String getEXCOND() {
        return this.GetParamStringValue(TAG_EXCOND, "");
    }

    public void setEXCOND(String strValue) {
        this.SetParamValue(TAG_EXCOND, strValue);
    }

    public String getFACTDEID() {
        return this.GetParamStringValue(TAG_FACTDEID, "");
    }

    public void setFACTDEID(String strValue) {
        this.SetParamValue(TAG_FACTDEID, strValue);
    }

    public String getFACTDENAME() {
        return this.GetParamStringValue(TAG_FACTDENAME, "");
    }

    public void setFACTDENAME(String strValue) {
        this.SetParamValue(TAG_FACTDENAME, strValue);
    }
}

