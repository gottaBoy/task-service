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

public class TMTaskBase
extends BaseDataEntity {
    public static final String TASKRESSTATE_OK = "OK";
    public static final String TASKRESSTATE_NECESSARYOK = "NECESSARYOK";
    public static final String TASKRESSTATE_NOTOK = "NOTOK";
    public static final String TAG_TASKRESSTATE = "TASKRESSTATE";
    public static final String TAG_TASKSN = "TASKSN";
    public static final String TAG_TMTASKBASEID = "TMTASKBASEID";
    public static final String TAG_TMTASKBASENAME = "TMTASKBASENAME";
    public static final String TAG_TMTASKBASETYPE = "TMTASKBASETYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMTASKCENTERID = "TMTASKCENTERID";
    public static final String TAG_TMTASKCENTERNAME = "TMTASKCENTERNAME";
    public static final String TAG_ROOTTMTASKBASEID = "ROOTTMTASKBASEID";
    public static final String TAG_ROOTTMTASKBASENAME = "ROOTTMTASKBASENAME";
    public static final String TAG_PTMTASKBASEID = "PTMTASKBASEID";
    public static final String TAG_PTMTASKBASENAME = "PTMTASKBASENAME";
    public static final String TAG_FRONTTASKSN = "FRONTTASKSN";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_DURATION = "DURATION";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_NRCNT = "NRCNT";
    public static final String TAG_NRCNT2 = "NRCNT2";
    public static final String TAG_ORCNT2 = "ORCNT2";
    public static final String TAG_ORCNT = "ORCNT";
    public static final String TAG_TASKRESSTATEINFO = "TASKRESSTATEINFO";

    public boolean isTASKRESSTATENull() {
        return this.IsParamNull(TAG_TASKRESSTATE);
    }

    public String getTASKRESSTATE() {
        return this.GetParamStringValue(TAG_TASKRESSTATE, "");
    }

    public void setTASKRESSTATE(String strValue) {
        this.SetParamValue(TAG_TASKRESSTATE, strValue);
    }

    public boolean isTASKSNNull() {
        return this.IsParamNull(TAG_TASKSN);
    }

    public String getTASKSN() {
        return this.GetParamStringValue(TAG_TASKSN, "");
    }

    public void setTASKSN(String strValue) {
        this.SetParamValue(TAG_TASKSN, strValue);
    }

    public boolean isTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_TMTASKBASEID);
    }

    public String getTMTASKBASEID() {
        return this.GetParamStringValue(TAG_TMTASKBASEID, "");
    }

    public void setTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_TMTASKBASEID, strValue);
    }

    public boolean isTMTASKBASENAMENull() {
        return this.IsParamNull(TAG_TMTASKBASENAME);
    }

    public String getTMTASKBASENAME() {
        return this.GetParamStringValue(TAG_TMTASKBASENAME, "");
    }

    public void setTMTASKBASENAME(String strValue) {
        this.SetParamValue(TAG_TMTASKBASENAME, strValue);
    }

    public boolean isTMTASKBASETYPENull() {
        return this.IsParamNull(TAG_TMTASKBASETYPE);
    }

    public String getTMTASKBASETYPE() {
        return this.GetParamStringValue(TAG_TMTASKBASETYPE, "");
    }

    public void setTMTASKBASETYPE(String strValue) {
        this.SetParamValue(TAG_TMTASKBASETYPE, strValue);
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

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
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

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isTMTASKCENTERIDNull() {
        return this.IsParamNull(TAG_TMTASKCENTERID);
    }

    public String getTMTASKCENTERID() {
        return this.GetParamStringValue(TAG_TMTASKCENTERID, "");
    }

    public void setTMTASKCENTERID(String strValue) {
        this.SetParamValue(TAG_TMTASKCENTERID, strValue);
    }

    public boolean isTMTASKCENTERNAMENull() {
        return this.IsParamNull(TAG_TMTASKCENTERNAME);
    }

    public String getTMTASKCENTERNAME() {
        return this.GetParamStringValue(TAG_TMTASKCENTERNAME, "");
    }

    public void setTMTASKCENTERNAME(String strValue) {
        this.SetParamValue(TAG_TMTASKCENTERNAME, strValue);
    }

    public boolean isROOTTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_ROOTTMTASKBASEID);
    }

    public String getROOTTMTASKBASEID() {
        return this.GetParamStringValue(TAG_ROOTTMTASKBASEID, "");
    }

    public void setROOTTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_ROOTTMTASKBASEID, strValue);
    }

    public boolean isROOTTMTASKBASENAMENull() {
        return this.IsParamNull(TAG_ROOTTMTASKBASENAME);
    }

    public String getROOTTMTASKBASENAME() {
        return this.GetParamStringValue(TAG_ROOTTMTASKBASENAME, "");
    }

    public void setROOTTMTASKBASENAME(String strValue) {
        this.SetParamValue(TAG_ROOTTMTASKBASENAME, strValue);
    }

    public boolean isPTMTASKBASEIDNull() {
        return this.IsParamNull(TAG_PTMTASKBASEID);
    }

    public String getPTMTASKBASEID() {
        return this.GetParamStringValue(TAG_PTMTASKBASEID, "");
    }

    public void setPTMTASKBASEID(String strValue) {
        this.SetParamValue(TAG_PTMTASKBASEID, strValue);
    }

    public boolean isPTMTASKBASENAMENull() {
        return this.IsParamNull(TAG_PTMTASKBASENAME);
    }

    public String getPTMTASKBASENAME() {
        return this.GetParamStringValue(TAG_PTMTASKBASENAME, "");
    }

    public void setPTMTASKBASENAME(String strValue) {
        this.SetParamValue(TAG_PTMTASKBASENAME, strValue);
    }

    public boolean isFRONTTASKSNNull() {
        return this.IsParamNull(TAG_FRONTTASKSN);
    }

    public String getFRONTTASKSN() {
        return this.GetParamStringValue(TAG_FRONTTASKSN, "");
    }

    public void setFRONTTASKSN(String strValue) {
        this.SetParamValue(TAG_FRONTTASKSN, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public Timestamp getBEGINTIME() {
        return this.GetParamTimestampValue(TAG_BEGINTIME, null);
    }

    public void setBEGINTIME(Timestamp strValue) {
        this.SetParamValue(TAG_BEGINTIME, strValue);
    }

    public boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public Timestamp getENDTIME() {
        return this.GetParamTimestampValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Timestamp strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }

    public boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public int getUSERTAG() {
        return this.GetParamIntValue(TAG_USERTAG, 0);
    }

    public void setUSERTAG(int strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public int getUSERTAG2() {
        return this.GetParamIntValue(TAG_USERTAG2, 0);
    }

    public void setUSERTAG2(int strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public boolean isDURATIONNull() {
        return this.IsParamNull(TAG_DURATION);
    }

    public int getDURATION() {
        return this.GetParamIntValue(TAG_DURATION, 0);
    }

    public void setDURATION(int strValue) {
        this.SetParamValue(TAG_DURATION, strValue);
    }

    public boolean isIMPORTANCEFLAGNull() {
        return this.IsParamNull(TAG_IMPORTANCEFLAG);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setIMPORTANCEFLAG(int strValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, strValue);
    }

    public boolean isNRCNTNull() {
        return this.IsParamNull(TAG_NRCNT);
    }

    public int getNRCNT() {
        return this.GetParamIntValue(TAG_NRCNT, 0);
    }

    public void setNRCNT(int strValue) {
        this.SetParamValue(TAG_NRCNT, strValue);
    }

    public boolean isNRCNT2Null() {
        return this.IsParamNull(TAG_NRCNT2);
    }

    public int getNRCNT2() {
        return this.GetParamIntValue(TAG_NRCNT2, 0);
    }

    public void setNRCNT2(int strValue) {
        this.SetParamValue(TAG_NRCNT2, strValue);
    }

    public boolean isORCNT2Null() {
        return this.IsParamNull(TAG_ORCNT2);
    }

    public int getORCNT2() {
        return this.GetParamIntValue(TAG_ORCNT2, 0);
    }

    public void setORCNT2(int strValue) {
        this.SetParamValue(TAG_ORCNT2, strValue);
    }

    public boolean isORCNTNull() {
        return this.IsParamNull(TAG_ORCNT);
    }

    public int getORCNT() {
        return this.GetParamIntValue(TAG_ORCNT, 0);
    }

    public void setORCNT(int strValue) {
        this.SetParamValue(TAG_ORCNT, strValue);
    }

    public boolean isTASKRESSTATEINFONull() {
        return this.IsParamNull(TAG_TASKRESSTATEINFO);
    }

    public String getTASKRESSTATEINFO() {
        return this.GetParamStringValue(TAG_TASKRESSTATEINFO, "");
    }

    public void setTASKRESSTATEINFO(String strValue) {
        this.SetParamValue(TAG_TASKRESSTATEINFO, strValue);
    }
}

