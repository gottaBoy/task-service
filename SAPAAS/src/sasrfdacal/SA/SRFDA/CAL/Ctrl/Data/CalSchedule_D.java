/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.CAL.Ctrl.Data;

import SA.SRFDA.CAL.Ctrl.Data.CalSchedule;
import java.util.Date;

public class CalSchedule_D
extends CalSchedule {
    public static final String TAG_CALSCHEDULE_DID = "CALSCHEDULE_DID";
    public static final String TAG_CALSCHEDULE_DNAME = "CALSCHEDULE_DNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SCHEDULESTATE = "SCHEDULESTATE";
    public static final String TAG_CYCLESTARTTIME = "CYCLESTARTTIME";
    public static final String TAG_CYCLEENDTIME = "CYCLEENDTIME";
    public static final String TAG_RUNTIME = "RUNTIME";
    public static final String TAG_RUNDATE = "RUNDATE";
    public static final String TAG_LASTMINUTE = "LASTMINUTE";
    public static final String TAG_INTERVALMINUTE = "INTERVALMINUTE";
    public static final String TAG_SCHEDULEPARAM3 = "SCHEDULEPARAM3";
    public static final String TAG_SCHEDULEPARAM = "SCHEDULEPARAM";
    public static final String TAG_SCHEDULEPARAM2 = "SCHEDULEPARAM2";
    public static final String TAG_SCHEDULEPARAM4 = "SCHEDULEPARAM4";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_CALENDARNAME = "CALENDARNAME";
    public static final String TAG_CALENDARID = "CALENDARID";

    public String getCALSCHEDULE_DID() {
        return this.GetParamStringValue(TAG_CALSCHEDULE_DID, "");
    }

    public void setCALSCHEDULE_DID(String strValue) {
        this.SetParamValue(TAG_CALSCHEDULE_DID, strValue);
    }

    public String getCALSCHEDULE_DNAME() {
        return this.GetParamStringValue(TAG_CALSCHEDULE_DNAME, "");
    }

    public void setCALSCHEDULE_DNAME(String strValue) {
        this.SetParamValue(TAG_CALSCHEDULE_DNAME, strValue);
    }

    @Override
    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    @Override
    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    @Override
    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    @Override
    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    @Override
    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    @Override
    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    @Override
    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    @Override
    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    @Override
    public String getSCHEDULESTATE() {
        return this.GetParamStringValue(TAG_SCHEDULESTATE, "");
    }

    @Override
    public void setSCHEDULESTATE(String strValue) {
        this.SetParamValue(TAG_SCHEDULESTATE, strValue);
    }

    @Override
    public Date getCYCLESTARTTIME() {
        return this.GetParamDateValue(TAG_CYCLESTARTTIME, null);
    }

    @Override
    public void setCYCLESTARTTIME(Date strValue) {
        this.SetParamValue(TAG_CYCLESTARTTIME, strValue);
    }

    @Override
    public Date getCYCLEENDTIME() {
        return this.GetParamDateValue(TAG_CYCLEENDTIME, null);
    }

    @Override
    public void setCYCLEENDTIME(Date strValue) {
        this.SetParamValue(TAG_CYCLEENDTIME, strValue);
    }

    @Override
    public Date getRUNTIME() {
        return this.GetParamDateValue(TAG_RUNTIME, null);
    }

    @Override
    public void setRUNTIME(Date strValue) {
        this.SetParamValue(TAG_RUNTIME, strValue);
    }

    @Override
    public Date getRUNDATE() {
        return this.GetParamDateValue(TAG_RUNDATE, null);
    }

    @Override
    public void setRUNDATE(Date strValue) {
        this.SetParamValue(TAG_RUNDATE, strValue);
    }

    @Override
    public String getLASTMINUTE() {
        return this.GetParamStringValue(TAG_LASTMINUTE, "");
    }

    @Override
    public void setLASTMINUTE(String strValue) {
        this.SetParamValue(TAG_LASTMINUTE, strValue);
    }

    @Override
    public String getINTERVALMINUTE() {
        return this.GetParamStringValue(TAG_INTERVALMINUTE, "");
    }

    @Override
    public void setINTERVALMINUTE(String strValue) {
        this.SetParamValue(TAG_INTERVALMINUTE, strValue);
    }

    @Override
    public String getSCHEDULEPARAM3() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM3, "");
    }

    @Override
    public void setSCHEDULEPARAM3(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM3, strValue);
    }

    @Override
    public String getSCHEDULEPARAM() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM, "");
    }

    @Override
    public void setSCHEDULEPARAM(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM, strValue);
    }

    @Override
    public String getSCHEDULEPARAM2() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM2, "");
    }

    @Override
    public void setSCHEDULEPARAM2(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM2, strValue);
    }

    @Override
    public String getSCHEDULEPARAM4() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM4, "");
    }

    @Override
    public void setSCHEDULEPARAM4(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM4, strValue);
    }

    @Override
    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    @Override
    public void setENDTIME(Date strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    @Override
    public Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    @Override
    public void setBEGINTIME(Date strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    @Override
    public String getCALENDARNAME() {
        return this.GetParamStringValue(TAG_CALENDARNAME, "");
    }

    @Override
    public void setCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_CALENDARNAME, strValue);
    }

    @Override
    public String getCALENDARID() {
        return this.GetParamStringValue(TAG_CALENDARID, "");
    }

    @Override
    public void setCALENDARID(String strValue) {
        this.SetParamValue(TAG_CALENDARID, strValue);
    }
}

