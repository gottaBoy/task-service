/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDENotify
extends BaseDataEntity {
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSDENOTIFYID = "PSDENOTIFYID";
    public static final String TAG_PSDENOTIFYNAME = "PSDENOTIFYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_BEGINPSDEFID = "BEGINPSDEFID";
    public static final String TAG_BEGINPSDEFNAME = "BEGINPSDEFNAME";
    public static final String TAG_ENDPSDEFID = "ENDPSDEFID";
    public static final String TAG_ENDPSDEFNAME = "ENDPSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_NOTIFYTAG = "NOTIFYTAG";
    public static final String TAG_NOTIFYTAG2 = "NOTIFYTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_NOTIFYSTART = "NOTIFYSTART";
    public static final String TAG_NOTIFYEND = "NOTIFYEND";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_CHECKTIMER = "CHECKTIMER";
    public static final String TAG_PSSYSMSGQUEUEID = "PSSYSMSGQUEUEID";
    public static final String TAG_PSSYSMSGQUEUENAME = "PSSYSMSGQUEUENAME";
    public static final String TAG_TIMERMODE = "TIMERMODE";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_MSGTYPE = "MSGTYPE";
    public static final String TAG_TASKMODE = "TASKMODE";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_ATTACHMENTTYPE = "ATTACHMENTTYPE";
    public static final String TAG_PSDEPRINTID = "PSDEPRINTID";
    public static final String TAG_PSDEPRINTNAME = "PSDEPRINTNAME";
    public static final String TAG_PSDEREPORTID = "PSDEREPORTID";
    public static final String TAG_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String TAG_PROPERTYMAP = "PROPERTYMAP";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_FILTERMODEL = "FILTERMODEL";
    public static final String TAG_EVENTMODEL = "EVENTMODEL";
    public static final String TAG_IGNOREEXCEPTION = "IGNOREEXCEPTION";
    public static final String TAG_NOTIFYSUBTYPE = "NOTIFYSUBTYPE";
    public static final String TAG_THREADRUNMODE = "THREADRUNMODE";
    public static final String TAG_TEMPLFLAG = "TEMPLFLAG";
    public static final String TAG_EVENTS = "EVENTS";

    public final boolean isPSDENOTIFYIDNull() {
        return this.IsParamNull(TAG_PSDENOTIFYID);
    }

    public final String getPSDENOTIFYID() {
        return this.GetParamStringValue(TAG_PSDENOTIFYID, "");
    }

    public final void setPSDENOTIFYID(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYID, strValue);
    }

    public final boolean isPSDENOTIFYNAMENull() {
        return this.IsParamNull(TAG_PSDENOTIFYNAME);
    }

    public final String getPSDENOTIFYNAME() {
        return this.GetParamStringValue(TAG_PSDENOTIFYNAME, "");
    }

    public final void setPSDENOTIFYNAME(String strValue) {
        this.SetParamValue(TAG_PSDENOTIFYNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSDEDSIDNull() {
        return this.IsParamNull(TAG_PSDEDSID);
    }

    public final String getPSDEDSID() {
        return this.GetParamStringValue(TAG_PSDEDSID, "");
    }

    public final void setPSDEDSID(String strValue) {
        this.SetParamValue(TAG_PSDEDSID, strValue);
    }

    public final boolean isPSDEDSNAMENull() {
        return this.IsParamNull(TAG_PSDEDSNAME);
    }

    public final String getPSDEDSNAME() {
        return this.GetParamStringValue(TAG_PSDEDSNAME, "");
    }

    public final void setPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDSNAME, strValue);
    }

    public final boolean isBEGINPSDEFIDNull() {
        return this.IsParamNull(TAG_BEGINPSDEFID);
    }

    public final String getBEGINPSDEFID() {
        return this.GetParamStringValue(TAG_BEGINPSDEFID, "");
    }

    public final void setBEGINPSDEFID(String strValue) {
        this.SetParamValue(TAG_BEGINPSDEFID, strValue);
    }

    public final boolean isBEGINPSDEFNAMENull() {
        return this.IsParamNull(TAG_BEGINPSDEFNAME);
    }

    public final String getBEGINPSDEFNAME() {
        return this.GetParamStringValue(TAG_BEGINPSDEFNAME, "");
    }

    public final void setBEGINPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_BEGINPSDEFNAME, strValue);
    }

    public final boolean isENDPSDEFIDNull() {
        return this.IsParamNull(TAG_ENDPSDEFID);
    }

    public final String getENDPSDEFID() {
        return this.GetParamStringValue(TAG_ENDPSDEFID, "");
    }

    public final void setENDPSDEFID(String strValue) {
        this.SetParamValue(TAG_ENDPSDEFID, strValue);
    }

    public final boolean isENDPSDEFNAMENull() {
        return this.IsParamNull(TAG_ENDPSDEFNAME);
    }

    public final String getENDPSDEFNAME() {
        return this.GetParamStringValue(TAG_ENDPSDEFNAME, "");
    }

    public final void setENDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ENDPSDEFNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isNOTIFYTAGNull() {
        return this.IsParamNull(TAG_NOTIFYTAG);
    }

    public final String getNOTIFYTAG() {
        return this.GetParamStringValue(TAG_NOTIFYTAG, "");
    }

    public final void setNOTIFYTAG(String strValue) {
        this.SetParamValue(TAG_NOTIFYTAG, strValue);
    }

    public final boolean isNOTIFYTAG2Null() {
        return this.IsParamNull(TAG_NOTIFYTAG2);
    }

    public final String getNOTIFYTAG2() {
        return this.GetParamStringValue(TAG_NOTIFYTAG2, "");
    }

    public final void setNOTIFYTAG2(String strValue) {
        this.SetParamValue(TAG_NOTIFYTAG2, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isNOTIFYSTARTNull() {
        return this.IsParamNull(TAG_NOTIFYSTART);
    }

    public final int getNOTIFYSTART() {
        return this.GetParamIntValue(TAG_NOTIFYSTART, 0);
    }

    public final void setNOTIFYSTART(int nValue) {
        this.SetParamValue(TAG_NOTIFYSTART, nValue);
    }

    public final boolean isNOTIFYENDNull() {
        return this.IsParamNull(TAG_NOTIFYEND);
    }

    public final int getNOTIFYEND() {
        return this.GetParamIntValue(TAG_NOTIFYEND, 0);
    }

    public final void setNOTIFYEND(int nValue) {
        this.SetParamValue(TAG_NOTIFYEND, nValue);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isCHECKTIMERNull() {
        return this.IsParamNull(TAG_CHECKTIMER);
    }

    public final int getCHECKTIMER() {
        return this.GetParamIntValue(TAG_CHECKTIMER, 0);
    }

    public final void setCHECKTIMER(int nValue) {
        this.SetParamValue(TAG_CHECKTIMER, nValue);
    }

    public final boolean isPSSYSMSGQUEUEIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGQUEUEID);
    }

    public final String getPSSYSMSGQUEUEID() {
        return this.GetParamStringValue(TAG_PSSYSMSGQUEUEID, "");
    }

    public final void setPSSYSMSGQUEUEID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGQUEUEID, strValue);
    }

    public final boolean isPSSYSMSGQUEUENAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGQUEUENAME);
    }

    public final String getPSSYSMSGQUEUENAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGQUEUENAME, "");
    }

    public final void setPSSYSMSGQUEUENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGQUEUENAME, strValue);
    }

    public final boolean isTIMERMODENull() {
        return this.IsParamNull(TAG_TIMERMODE);
    }

    public final boolean getTIMERMODE() {
        return this.GetParamIntValue(TAG_TIMERMODE, 0) == 1;
    }

    public final void setTIMERMODE(boolean bValue) {
        this.SetParamValue(TAG_TIMERMODE, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }

    public final boolean isMSGTYPENull() {
        return this.IsParamNull(TAG_MSGTYPE);
    }

    public final int getMSGTYPE() {
        return this.GetParamIntValue(TAG_MSGTYPE, 0);
    }

    public final void setMSGTYPE(int nValue) {
        this.SetParamValue(TAG_MSGTYPE, nValue);
    }

    public final boolean isTASKMODENull() {
        return this.IsParamNull(TAG_TASKMODE);
    }

    public final int getTASKMODE() {
        return this.GetParamIntValue(TAG_TASKMODE, 0);
    }

    public final void setTASKMODE(int nValue) {
        this.SetParamValue(TAG_TASKMODE, nValue);
    }

    public final boolean isPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINID);
    }

    public final String getPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINID, "");
    }

    public final void setPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINID, strValue);
    }

    public final boolean isPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPLUGINNAME);
    }

    public final String getPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPLUGINNAME, "");
    }

    public final void setPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPLUGINNAME, strValue);
    }

    public final String getATTACHMENTTYPE() {
        return this.GetParamStringValue(TAG_ATTACHMENTTYPE, "");
    }

    public final void setATTACHMENTTYPE(String strValue) {
        this.SetParamValue(TAG_ATTACHMENTTYPE, strValue);
    }

    public final boolean isPSDEPRINTIDNull() {
        return this.IsParamNull(TAG_PSDEPRINTID);
    }

    public final String getPSDEPRINTID() {
        return this.GetParamStringValue(TAG_PSDEPRINTID, "");
    }

    public final void setPSDEPRINTID(String strValue) {
        this.SetParamValue(TAG_PSDEPRINTID, strValue);
    }

    public final boolean isPSDEPRINTNAMENull() {
        return this.IsParamNull(TAG_PSDEPRINTNAME);
    }

    public final String getPSDEPRINTNAME() {
        return this.GetParamStringValue(TAG_PSDEPRINTNAME, "");
    }

    public final void setPSDEPRINTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPRINTNAME, strValue);
    }

    public final boolean isPSDEREPORTIDNull() {
        return this.IsParamNull(TAG_PSDEREPORTID);
    }

    public final String getPSDEREPORTID() {
        return this.GetParamStringValue(TAG_PSDEREPORTID, "");
    }

    public final void setPSDEREPORTID(String strValue) {
        this.SetParamValue(TAG_PSDEREPORTID, strValue);
    }

    public final boolean isPSDEREPORTNAMENull() {
        return this.IsParamNull(TAG_PSDEREPORTNAME);
    }

    public final String getPSDEREPORTNAME() {
        return this.GetParamStringValue(TAG_PSDEREPORTNAME, "");
    }

    public final void setPSDEREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEREPORTNAME, strValue);
    }

    public final boolean isPROPERTYMAPNull() {
        return this.IsParamNull(TAG_PROPERTYMAP);
    }

    public final String getPROPERTYMAP() {
        return this.GetParamStringValue(TAG_PROPERTYMAP, "");
    }

    public final void setPROPERTYMAP(String strValue) {
        this.SetParamValue(TAG_PROPERTYMAP, strValue);
    }

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }

    public final boolean isFILTERMODELNull() {
        return this.IsParamNull(TAG_FILTERMODEL);
    }

    public final String getFILTERMODEL() {
        return this.GetParamStringValue(TAG_FILTERMODEL, "");
    }

    public final void setFILTERMODEL(String strValue) {
        this.SetParamValue(TAG_FILTERMODEL, strValue);
    }

    public final boolean isEVENTMODELNull() {
        return this.IsParamNull(TAG_EVENTMODEL);
    }

    public final String getEVENTMODEL() {
        return this.GetParamStringValue(TAG_EVENTMODEL, "");
    }

    public final void setEVENTMODEL(String strValue) {
        this.SetParamValue(TAG_EVENTMODEL, strValue);
    }

    public final boolean isIGNOREEXCEPTIONNull() {
        return this.IsParamNull(TAG_IGNOREEXCEPTION);
    }

    public final boolean getIGNOREEXCEPTION() {
        return this.GetParamIntValue(TAG_IGNOREEXCEPTION, 0) == 1;
    }

    public final void setIGNOREEXCEPTION(boolean bValue) {
        this.SetParamValue(TAG_IGNOREEXCEPTION, bValue ? 1 : 0);
    }

    public final boolean isNOTIFYSUBTYPENull() {
        return this.IsParamNull(TAG_NOTIFYSUBTYPE);
    }

    public final String getNOTIFYSUBTYPE() {
        return this.GetParamStringValue(TAG_NOTIFYSUBTYPE, "");
    }

    public final void setNOTIFYSUBTYPE(String strValue) {
        this.SetParamValue(TAG_NOTIFYSUBTYPE, strValue);
    }

    public final boolean isTHREADRUNMODENull() {
        return this.IsParamNull(TAG_THREADRUNMODE);
    }

    public final int getTHREADRUNMODE() {
        return this.GetParamIntValue(TAG_THREADRUNMODE, 0);
    }

    public final void setTHREADRUNMODE(int nValue) {
        this.SetParamValue(TAG_THREADRUNMODE, nValue);
    }

    public final boolean isTEMPLFLAGNull() {
        return this.IsParamNull(TAG_TEMPLFLAG);
    }

    public final boolean getTEMPLFLAG() {
        return this.GetParamIntValue(TAG_TEMPLFLAG, 0) == 1;
    }

    public final void setTEMPLFLAG(boolean bValue) {
        this.SetParamValue(TAG_TEMPLFLAG, bValue ? 1 : 0);
    }

    public final boolean isEVENTSNull() {
        return this.IsParamNull(TAG_EVENTS);
    }

    public final String getEVENTS() {
        return this.GetParamStringValue(TAG_EVENTS, "");
    }

    public final void setEVENTS(String strValue) {
        this.SetParamValue(TAG_EVENTS, strValue);
    }
}

