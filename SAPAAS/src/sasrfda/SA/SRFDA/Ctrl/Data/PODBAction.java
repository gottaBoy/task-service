/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PODBAction
extends BaseDataEntity {
    public static final String TAG_PODBACTIONID = "PODBACTIONID";
    public static final String TAG_PODBACTIONNAME = "PODBACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBACTION = "DBACTION";
    public static final String TAG_PROCESSTIME = "PROCESSTIME";
    public static final String TAG_ISTRAN = "ISTRAN";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_PROCNAME = "PROCNAME";
    public static final String TAG_TRANSACTIONID = "TRANSACTIONID";

    public String getPODBACTIONID() {
        return this.GetParamStringValue(TAG_PODBACTIONID, "");
    }

    public void setPODBACTIONID(String strValue) {
        this.SetParamValue(TAG_PODBACTIONID, strValue);
    }

    public String getPODBACTIONNAME() {
        return this.GetParamStringValue(TAG_PODBACTIONNAME, "");
    }

    public void setPODBACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PODBACTIONNAME, strValue);
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

    public String getDBACTION() {
        return this.GetParamStringValue(TAG_DBACTION, "");
    }

    public void setDBACTION(String strValue) {
        this.SetParamValue(TAG_DBACTION, strValue);
    }

    public int getPROCESSTIME() {
        return this.GetParamIntValue(TAG_PROCESSTIME, 0);
    }

    public void setPROCESSTIME(int strValue) {
        this.SetParamValue(TAG_PROCESSTIME, strValue);
    }

    public boolean getISTRAN() {
        return this.GetParamIntValue(TAG_ISTRAN, 0) == 1;
    }

    public void setISTRAN(boolean bValue) {
        this.SetParamValue(TAG_ISTRAN, bValue ? 1 : 0);
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

    public String getPROCNAME() {
        return this.GetParamStringValue(TAG_PROCNAME, "");
    }

    public void setPROCNAME(String strValue) {
        this.SetParamValue(TAG_PROCNAME, strValue);
    }

    public String getTRANSACTIONID() {
        return this.GetParamStringValue(TAG_TRANSACTIONID, "");
    }

    public void setTRANSACTIONID(String strValue) {
        this.SetParamValue(TAG_TRANSACTIONID, strValue);
    }
}

