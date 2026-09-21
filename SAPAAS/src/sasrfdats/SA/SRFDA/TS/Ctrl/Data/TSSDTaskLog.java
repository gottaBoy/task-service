/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.TS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TSSDTaskLog
extends BaseDataEntity {
    public static final String TAG_TSSDTASKLOGID = "TSSDTASKLOGID";
    public static final String TAG_TSSDTASKLOGNAME = "TSSDTASKLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TSSDTASKID = "TSSDTASKID";
    public static final String TAG_TSSDTASKNAME = "TSSDTASKNAME";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_RETCODE = "RETCODE";
    public static final String TAG_RETINFO = "RETINFO";
    public static final String TAG_DURATION = "DURATION";

    public String getTSSDTASKLOGID() {
        return this.GetParamStringValue(TAG_TSSDTASKLOGID, "");
    }

    public void setTSSDTASKLOGID(String strValue) {
        this.SetParamValue(TAG_TSSDTASKLOGID, strValue);
    }

    public String getTSSDTASKLOGNAME() {
        return this.GetParamStringValue(TAG_TSSDTASKLOGNAME, "");
    }

    public void setTSSDTASKLOGNAME(String strValue) {
        this.SetParamValue(TAG_TSSDTASKLOGNAME, strValue);
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

    public String getTSSDTASKID() {
        return this.GetParamStringValue(TAG_TSSDTASKID, "");
    }

    public void setTSSDTASKID(String strValue) {
        this.SetParamValue(TAG_TSSDTASKID, strValue);
    }

    public String getTSSDTASKNAME() {
        return this.GetParamStringValue(TAG_TSSDTASKNAME, "");
    }

    public void setTSSDTASKNAME(String strValue) {
        this.SetParamValue(TAG_TSSDTASKNAME, strValue);
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

    public int getRETCODE() {
        return this.GetParamIntValue(TAG_RETCODE, 0);
    }

    public void setRETCODE(int strValue) {
        this.SetParamValue(TAG_RETCODE, strValue);
    }

    public String getRETINFO() {
        return this.GetParamStringValue(TAG_RETINFO, "");
    }

    public void setRETINFO(String strValue) {
        this.SetParamValue(TAG_RETINFO, strValue);
    }

    public int getDURATION() {
        return this.GetParamIntValue(TAG_DURATION, 0);
    }

    public void setDURATION(int strValue) {
        this.SetParamValue(TAG_DURATION, strValue);
    }
}

