/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFTS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TSSchedule
extends BaseDataEntity {
    public static final int SCHEDULETYPE_RUNONCE = 1;
    public static final int SCHEDULETYPE_RUNMONTH = 3;
    public static final int SCHEDULETYPE_RUNWEEK = 4;
    public static final int SCHEDULETYPE_RUNDAY = 5;
    public static final String TAG_TSSCHEDULEID = "TSSCHEDULEID";
    public static final String TAG_SCHEDULEINFO = "SCHEDULEINFO";
    public static final String TAG_SCHEDULESTATE = "SCHEDULESTATE";
    public static final String TAG_TSTASKID = "TSTASKID";
    public static final String TAG_SCHEDULETYPE = "SCHEDULETYPE";
    public static final String TAG_CYCLESTARTTIME = "CYCLESTARTTIME";
    public static final String TAG_CYCLEENDTIME = "CYCLEENDTIME";
    public static final String TAG_RUNDATE = "RUNDATE";
    public static final String TAG_RUNTIME = "RUNTIME";
    public static final String TAG_LASTMINUTE = "LASTMINUTE";
    public static final String TAG_INTERVALMINUTE = "INTERVALMINUTE";
    public static final String TAG_SCHEDULEPARAM = "SCHEDULEPARAM";
    public static final String TAG_SCHEDULEPARAM2 = "SCHEDULEPARAM2";
    public static final String TAG_SCHEDULEPARAM3 = "SCHEDULEPARAM3";
    public static final String TAG_SCHEDULEPARAM4 = "SCHEDULEPARAM4";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_TASKOBJECT = "TASKOBJECT";
    public static final String TAG_TASKNAME = "TASKNAME";

    public String getTASKOBJECT() {
        return this.GetParamStringValue(TAG_TASKOBJECT, "");
    }

    public String getTASKNAME() {
        return this.GetParamStringValue(TAG_TASKNAME, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getSCHEDULEPARAM4() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM4, "");
    }

    public String getSCHEDULEPARAM3() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM3, "");
    }

    public String getSCHEDULEPARAM2() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM2, "");
    }

    public String getSCHEDULEPARAM() {
        return this.GetParamStringValue(TAG_SCHEDULEPARAM, "");
    }

    public String getTSTASKID() {
        return this.GetParamStringValue(TAG_TSTASKID, "");
    }

    public String getSCHEDULEINFO() {
        return this.GetParamStringValue(TAG_SCHEDULEINFO, "");
    }

    public String getTSSCHEDULEID() {
        return this.GetParamStringValue(TAG_TSSCHEDULEID, "");
    }

    public void setTASKOBJECT(String strValue) {
        this.SetParamValue(TAG_TASKOBJECT, strValue);
    }

    public void setTASKNAME(String strValue) {
        this.SetParamValue(TAG_TASKNAME, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setSCHEDULEPARAM4(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM4, strValue);
    }

    public void setSCHEDULEPARAM3(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM3, strValue);
    }

    public void setSCHEDULEPARAM2(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM2, strValue);
    }

    public void setSCHEDULEPARAM(String strValue) {
        this.SetParamValue(TAG_SCHEDULEPARAM, strValue);
    }

    public void setTSTASKID(String strValue) {
        this.SetParamValue(TAG_TSTASKID, strValue);
    }

    public void setSCHEDULEINFO(String strValue) {
        this.SetParamValue(TAG_SCHEDULEINFO, strValue);
    }

    public void setTSSCHEDULEID(String strValue) {
        this.SetParamValue(TAG_TSSCHEDULEID, strValue);
    }

    public int getSCHEDULESTATE() {
        return this.GetParamIntValue(TAG_SCHEDULESTATE, 0);
    }

    public int getSCHEDULETYPE() {
        return this.GetParamIntValue(TAG_SCHEDULETYPE, 0);
    }

    public int getLASTMINUTE() {
        return this.GetParamIntValue(TAG_LASTMINUTE, 0);
    }

    public int getINTERVALMINUTE() {
        return this.GetParamIntValue(TAG_INTERVALMINUTE, 0);
    }

    public void setSCHEDULESTATE(int nValue) {
        this.SetParamValue(TAG_SCHEDULESTATE, nValue);
    }

    public void setSCHEDULETYPE(int nValue) {
        this.SetParamValue(TAG_SCHEDULETYPE, nValue);
    }

    public void setLASTMINUTE(int nValue) {
        this.SetParamValue(TAG_LASTMINUTE, nValue);
    }

    public void setINTERVALMINUTE(int nValue) {
        this.SetParamValue(TAG_INTERVALMINUTE, nValue);
    }

    public Date getRUNDATE() {
        return this.GetDate(this.GetParamDateValue(TAG_RUNDATE, null));
    }

    public Date getRUNTIME() {
        return this.GetDate(this.GetParamDateValue(TAG_RUNTIME, null));
    }

    public Date getCYCLESTARTTIME() {
        return this.GetDate(this.GetParamDateValue(TAG_CYCLESTARTTIME, null));
    }

    public Date getCYCLEENDTIME() {
        return this.GetDate(this.GetParamDateValue(TAG_CYCLEENDTIME, null));
    }

    protected Date GetDate(java.sql.Date sqlDate) {
        if (sqlDate == null) {
            return null;
        }
        return new Date(sqlDate.getTime());
    }
}

