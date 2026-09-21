/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.CAL.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class CalSchedule
extends BaseDataEntity {
    public static final String CALSCHEDULETYPE_RUNONCE = "1";
    public static final String CALSCHEDULETYPE_RUNMONTH = "3";
    public static final String CALSCHEDULETYPE_RUNWEEK = "4";
    public static final String CALSCHEDULETYPE_RUNDAY = "5";
    public static final String TAG_CALSCHEDULEID = "CALSCHEDULEID";
    public static final String TAG_CALSCHEDULENAME = "CALSCHEDULENAME";
    public static final String TAG_CALSCHEDULETYPE = "CALSCHEDULETYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SCHEDULESTATE = "SCHEDULESTATE";
    public static final String TAG_SCHEDULETYPE = "SCHEDULETYPE";
    public static final String TAG_CYCLEENDTIME = "CYCLEENDTIME";
    public static final String TAG_CYCLESTARTTIME = "CYCLESTARTTIME";
    public static final String TAG_RUNTIME = "RUNTIME";
    public static final String TAG_RUNDATE = "RUNDATE";
    public static final String TAG_LASTMINUTE = "LASTMINUTE";
    public static final String TAG_INTERVALMINUTE = "INTERVALMINUTE";
    public static final String TAG_SCHEDULEPARAM2 = "SCHEDULEPARAM2";
    public static final String TAG_SCHEDULEPARAM = "SCHEDULEPARAM";
    public static final String TAG_SCHEDULEPARAM3 = "SCHEDULEPARAM3";
    public static final String TAG_SCHEDULEPARAM4 = "SCHEDULEPARAM4";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CALENDARNAME = "CALENDARNAME";
    public static final String TAG_CALENDARID = "CALENDARID";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";

    public String getCALSCHEDULEID() {
        return this.GetParamStringValue(TAG_CALSCHEDULEID, "");
    }

    public void setCALSCHEDULEID(String strValue) {
        this.SetParamValue(TAG_CALSCHEDULEID, strValue);
    }

    public String getCALSCHEDULENAME() {
        return this.GetParamStringValue(TAG_CALSCHEDULENAME, "");
    }

    public void setCALSCHEDULENAME(String strValue) {
        this.SetParamValue(TAG_CALSCHEDULENAME, strValue);
    }

    public String getCALSCHEDULETYPE() {
        return this.GetParamStringValue(TAG_CALSCHEDULETYPE, "");
    }

    public void setCALSCHEDULETYPE(String strValue) {
        this.SetParamValue(TAG_CALSCHEDULETYPE, strValue);
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

    public String getSCHEDULESTATE() {
        return this.GetParamStringValue(TAG_SCHEDULESTATE, "");
    }

    public void setSCHEDULESTATE(String strValue) {
        this.SetParamValue(TAG_SCHEDULESTATE, strValue);
    }

    public String getSCHEDULETYPE() {
        return this.GetParamStringValue(TAG_SCHEDULETYPE, "");
    }

    public void setSCHEDULETYPE(String strValue) {
        this.SetParamValue(TAG_SCHEDULETYPE, strValue);
    }

    public Date getCYCLEENDTIME() {
        return this.GetParamDateValue(TAG_CYCLEENDTIME, null);
    }

    public void setCYCLEENDTIME(Date strValue) {
        this.SetParamValue(TAG_CYCLEENDTIME, strValue);
    }

    public Date getCYCLESTARTTIME() {
        return this.GetParamDateValue(TAG_CYCLESTARTTIME, null);
    }

    public void setCYCLESTARTTIME(Date strValue) {
        this.SetParamValue(TAG_CYCLESTARTTIME, strValue);
    }

    public Date getRUNTIME() {
        return this.GetParamDateValue(TAG_RUNTIME, null);
    }

    public void setRUNTIME(Date strValue) {
        this.SetParamValue(TAG_RUNTIME, strValue);
    }

    public Date getRUNDATE() {
        return this.GetParamDateValue(TAG_RUNDATE, null);
    }

    public void setRUNDATE(Date strValue) {
        this.SetParamValue(TAG_RUNDATE, strValue);
    }

    public String getLASTMINUTE() {
        return this.GetParamStringValue(TAG_LASTMINUTE, "");
    }

    public void setLASTMINUTE(String strValue) {
        this.SetParamValue(TAG_LASTMINUTE, strValue);
    }

    public String getINTERVALMINUTE() {
        return this.GetParamStringValue(TAG_INTERVALMINUTE, "");
    }

    public void setINTERVALMINUTE(String strValue) {
        this.SetParamValue(TAG_INTERVALMINUTE, strValue);
    }

    public String getSCHEDULEPARAM2() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM2, "");
    }

    public void setSCHEDULEPARAM2(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM2, strValue);
    }

    public String getSCHEDULEPARAM() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM, "");
    }

    public void setSCHEDULEPARAM(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM, strValue);
    }

    public String getSCHEDULEPARAM3() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM3, "");
    }

    public void setSCHEDULEPARAM3(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM3, strValue);
    }

    public String getSCHEDULEPARAM4() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM4, "");
    }

    public void setSCHEDULEPARAM4(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM4, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getCALENDARNAME() {
        return this.GetParamStringValue(TAG_CALENDARNAME, "");
    }

    public void setCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_CALENDARNAME, strValue);
    }

    public String getCALENDARID() {
        return this.GetParamStringValue(TAG_CALENDARID, "");
    }

    public void setCALENDARID(String strValue) {
        this.SetParamValue(TAG_CALENDARID, strValue);
    }

    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }
}

