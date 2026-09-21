/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;
import java.util.Date;

public class TMBTPRJInst
extends BaseDataEntity {
    public static final String BTSTATE_UNTEST = "UNTEST";
    public static final String BTSTATE_TESTING = "TESTING";
    public static final String BTSTATE_TESTCANCEL = "TESTCANCEL";
    public static final String BTSTATE_TESTFINISH = "TESTFINISH";
    public static final String TAG_TMBTPRJINSTID = "TMBTPRJINSTID";
    public static final String TAG_TMBTPRJINSTNAME = "TMBTPRJINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMBTPRJID = "TMBTPRJID";
    public static final String TAG_TMBTPRJNAME = "TMBTPRJNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_BTSTATE = "BTSTATE";
    public static final String TAG_TESTBEGINTIME = "TESTBEGINTIME";
    public static final String TAG_TESTENDTIME = "TESTENDTIME";
    public static final String TAG_MAINTASKSUCCESSLOOPCNT = "MAINTASKSUCCESSLOOPCNT";
    public static final String TAG_TASKSUCCESSLOOPCNT = "TASKSUCCESSLOOPCNT";
    public static final String TAG_MAINTASKFAILEDLOOPCNT = "MAINTASKFAILEDLOOPCNT";
    public static final String TAG_TASKFAILEDLOOPCNT = "TASKFAILEDLOOPCNT";

    public boolean isTMBTPRJINSTIDNull() {
        return this.IsParamNull(TAG_TMBTPRJINSTID);
    }

    public String getTMBTPRJINSTID() {
        return this.GetParamStringValue(TAG_TMBTPRJINSTID, "");
    }

    public void setTMBTPRJINSTID(String strValue) {
        this.SetParamValue(TAG_TMBTPRJINSTID, strValue);
    }

    public boolean isTMBTPRJINSTNAMENull() {
        return this.IsParamNull(TAG_TMBTPRJINSTNAME);
    }

    public String getTMBTPRJINSTNAME() {
        return this.GetParamStringValue(TAG_TMBTPRJINSTNAME, "");
    }

    public void setTMBTPRJINSTNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPRJINSTNAME, strValue);
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

    public void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
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

    public void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public boolean isTMBTPRJIDNull() {
        return this.IsParamNull(TAG_TMBTPRJID);
    }

    public String getTMBTPRJID() {
        return this.GetParamStringValue(TAG_TMBTPRJID, "");
    }

    public void setTMBTPRJID(String strValue) {
        this.SetParamValue(TAG_TMBTPRJID, strValue);
    }

    public boolean isTMBTPRJNAMENull() {
        return this.IsParamNull(TAG_TMBTPRJNAME);
    }

    public String getTMBTPRJNAME() {
        return this.GetParamStringValue(TAG_TMBTPRJNAME, "");
    }

    public void setTMBTPRJNAME(String strValue) {
        this.SetParamValue(TAG_TMBTPRJNAME, strValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Timestamp getBEGINTIME() {
        return this.GetParamTimestampValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Timestamp getENDTIME() {
        return this.GetParamTimestampValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Timestamp dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public boolean isBTSTATENull() {
        return this.IsParamNull(TAG_BTSTATE);
    }

    public String getBTSTATE() {
        return this.GetParamStringValue(TAG_BTSTATE, "");
    }

    public void setBTSTATE(String strValue) {
        this.SetParamValue(TAG_BTSTATE, strValue);
    }

    public boolean isTESTBEGINTIMENull() {
        return this.IsParamNull(TAG_TESTBEGINTIME);
    }

    public Date getTESTBEGINTIME() {
        return this.GetParamDateValue(TAG_TESTBEGINTIME, null);
    }

    public void setTESTBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_TESTBEGINTIME, dtValue);
    }

    public boolean isTESTENDTIMENull() {
        return this.IsParamNull(TAG_TESTENDTIME);
    }

    public Date getTESTENDTIME() {
        return this.GetParamDateValue(TAG_TESTENDTIME, null);
    }

    public void setTESTENDTIME(Date dtValue) {
        this.SetParamValue(TAG_TESTENDTIME, dtValue);
    }

    public boolean isMAINTASKSUCCESSLOOPCNTNull() {
        return this.IsParamNull(TAG_MAINTASKSUCCESSLOOPCNT);
    }

    public int getMAINTASKSUCCESSLOOPCNT() {
        return this.GetParamIntValue(TAG_MAINTASKSUCCESSLOOPCNT, 0);
    }

    public void setMAINTASKSUCCESSLOOPCNT(int nValue) {
        this.SetParamValue(TAG_MAINTASKSUCCESSLOOPCNT, nValue);
    }

    public boolean isTASKSUCCESSLOOPCNTNull() {
        return this.IsParamNull(TAG_TASKSUCCESSLOOPCNT);
    }

    public int getTASKSUCCESSLOOPCNT() {
        return this.GetParamIntValue(TAG_TASKSUCCESSLOOPCNT, 0);
    }

    public void setTASKSUCCESSLOOPCNT(int nValue) {
        this.SetParamValue(TAG_TASKSUCCESSLOOPCNT, nValue);
    }

    public boolean isMAINTASKFAILEDLOOPCNTNull() {
        return this.IsParamNull(TAG_MAINTASKFAILEDLOOPCNT);
    }

    public int getMAINTASKFAILEDLOOPCNT() {
        return this.GetParamIntValue(TAG_MAINTASKFAILEDLOOPCNT, 0);
    }

    public void setMAINTASKFAILEDLOOPCNT(int nValue) {
        this.SetParamValue(TAG_MAINTASKFAILEDLOOPCNT, nValue);
    }

    public boolean isTASKFAILEDLOOPCNTNull() {
        return this.IsParamNull(TAG_TASKFAILEDLOOPCNT);
    }

    public int getTASKFAILEDLOOPCNT() {
        return this.GetParamIntValue(TAG_TASKFAILEDLOOPCNT, 0);
    }

    public void setTASKFAILEDLOOPCNT(int nValue) {
        this.SetParamValue(TAG_TASKFAILEDLOOPCNT, nValue);
    }
}

