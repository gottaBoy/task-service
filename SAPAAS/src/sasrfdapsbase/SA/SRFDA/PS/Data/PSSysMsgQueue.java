/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysMsgQueue
extends BaseDataEntity {
    public static final String MSGQUEUETYPE_RUNTIME = "RUNTIME";
    public static final String MSGQUEUETYPE_DE = "DE";
    public static final String MSGQUEUETYPE_USER = "USER";
    public static final String MSGQUEUETYPE_USER2 = "USER2";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSMSGQUEUEID = "PSSYSMSGQUEUEID";
    public static final String TAG_PSSYSMSGQUEUENAME = "PSSYSMSGQUEUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MSGQUEUETAG = "MSGQUEUETAG";
    public static final String TAG_MSGQUEUETAG2 = "MSGQUEUETAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_MSGQUEUETYPE = "MSGQUEUETYPE";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_TAGPSDEFID = "TAGPSDEFID";
    public static final String TAG_TAGPSDEFNAME = "TAGPSDEFNAME";
    public static final String TAG_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String TAG_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String TAG_MSGTYPEPSDEFID = "MSGTYPEPSDEFID";
    public static final String TAG_MSGTYPEPSDEFNAME = "MSGTYPEPSDEFNAME";
    public static final String TAG_TITLEPSDEFID = "TITLEPSDEFID";
    public static final String TAG_TITLEPSDEFNAME = "TITLEPSDEFNAME";
    public static final String TAG_TARGETPSDEFID = "TARGETPSDEFID";
    public static final String TAG_TARGETPSDEFNAME = "TARGETPSDEFNAME";
    public static final String TAG_TARGETTYPEPSDEFID = "TARGETTYPEPSDEFID";
    public static final String TAG_TARGETTYPEPSDEFNAME = "TARGETTYPEPSDEFNAME";
    public static final String TAG_SENDTIMEPSDEFID = "SENDTIMEPSDEFID";
    public static final String TAG_SENDTIMEPSDEFNAME = "SENDTIMEPSDEFNAME";
    public static final String TAG_STATEPSDEFID = "STATEPSDEFID";
    public static final String TAG_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String TAG_TAG2PSDEFID = "TAG2PSDEFID";
    public static final String TAG_TAG2PSDEFNAME = "TAG2PSDEFNAME";
    public static final String TAG_SMSCONTENTPSDEFID = "SMSCONTENTPSDEFID";
    public static final String TAG_SMSCONTENTPSDEFNAME = "SMSCONTENTPSDEFNAME";
    public static final String TAG_IMCONTENTPSDEFID = "IMCONTENTPSDEFID";
    public static final String TAG_IMCONTENTPSDEFNAME = "IMCONTENTPSDEFNAME";
    public static final String TAG_WXCONTENTPSDEFID = "WXCONTENTPSDEFID";
    public static final String TAG_WXCONTENTPSDEFNAME = "WXCONTENTPSDEFNAME";
    public static final String TAG_DDCONTENTPSDEFID = "DDCONTENTPSDEFID";
    public static final String TAG_DDCONTENTPSDEFNAME = "DDCONTENTPSDEFNAME";
    public static final String TAG_TASKURLPSDEFID = "TASKURLPSDEFID";
    public static final String TAG_TASKURLPSDEFNAME = "TASKURLPSDEFNAME";
    public static final String TAG_MOBTASKURLPSDEFID = "MOBTASKURLPSDEFID";
    public static final String TAG_MOBTASKURLPSDEFNAME = "MOBTASKURLPSDEFNAME";
    public static final String TAG_QUEUEPARAMS = "QUEUEPARAMS";
    public static final String TAG_FILEPSDEFID = "FILEPSDEFID";
    public static final String TAG_FILEPSDEFNAME = "FILEPSDEFNAME";
    public static final String TAG_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String TAG_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String TAG_USERPSDEFID = "USERPSDEFID";
    public static final String TAG_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String TAG_USER2PSDEFID = "USER2PSDEFID";
    public static final String TAG_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_MSGQUEUEPARAMS = "MSGQUEUEPARAMS";

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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
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

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
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

    public final boolean isMSGQUEUETAGNull() {
        return this.IsParamNull(TAG_MSGQUEUETAG);
    }

    public final String getMSGQUEUETAG() {
        return this.GetParamStringValue(TAG_MSGQUEUETAG, "");
    }

    public final void setMSGQUEUETAG(String strValue) {
        this.SetParamValue(TAG_MSGQUEUETAG, strValue);
    }

    public final boolean isMSGQUEUETAG2Null() {
        return this.IsParamNull(TAG_MSGQUEUETAG2);
    }

    public final String getMSGQUEUETAG2() {
        return this.GetParamStringValue(TAG_MSGQUEUETAG2, "");
    }

    public final void setMSGQUEUETAG2(String strValue) {
        this.SetParamValue(TAG_MSGQUEUETAG2, strValue);
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

    public final boolean isMSGQUEUETYPENull() {
        return this.IsParamNull(TAG_MSGQUEUETYPE);
    }

    public final String getMSGQUEUETYPE() {
        return this.GetParamStringValue(TAG_MSGQUEUETYPE, "");
    }

    public final void setMSGQUEUETYPE(String strValue) {
        this.SetParamValue(TAG_MSGQUEUETYPE, strValue);
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

    public final boolean isTAGPSDEFIDNull() {
        return this.IsParamNull(TAG_TAGPSDEFID);
    }

    public final String getTAGPSDEFID() {
        return this.GetParamStringValue(TAG_TAGPSDEFID, "");
    }

    public final void setTAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_TAGPSDEFID, strValue);
    }

    public final boolean isTAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_TAGPSDEFNAME);
    }

    public final String getTAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_TAGPSDEFNAME, "");
    }

    public final void setTAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TAGPSDEFNAME, strValue);
    }

    public final boolean isCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_CONTENTPSDEFID);
    }

    public final String getCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFID, "");
    }

    public final void setCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFID, strValue);
    }

    public final boolean isCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSDEFNAME);
    }

    public final String getCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSDEFNAME, "");
    }

    public final void setCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSDEFNAME, strValue);
    }

    public final boolean isMSGTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_MSGTYPEPSDEFID);
    }

    public final String getMSGTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_MSGTYPEPSDEFID, "");
    }

    public final void setMSGTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_MSGTYPEPSDEFID, strValue);
    }

    public final boolean isMSGTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_MSGTYPEPSDEFNAME);
    }

    public final String getMSGTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_MSGTYPEPSDEFNAME, "");
    }

    public final void setMSGTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MSGTYPEPSDEFNAME, strValue);
    }

    public final boolean isTITLEPSDEFIDNull() {
        return this.IsParamNull(TAG_TITLEPSDEFID);
    }

    public final String getTITLEPSDEFID() {
        return this.GetParamStringValue(TAG_TITLEPSDEFID, "");
    }

    public final void setTITLEPSDEFID(String strValue) {
        this.SetParamValue(TAG_TITLEPSDEFID, strValue);
    }

    public final boolean isTITLEPSDEFNAMENull() {
        return this.IsParamNull(TAG_TITLEPSDEFNAME);
    }

    public final String getTITLEPSDEFNAME() {
        return this.GetParamStringValue(TAG_TITLEPSDEFNAME, "");
    }

    public final void setTITLEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSDEFNAME, strValue);
    }

    public final boolean isTARGETPSDEFIDNull() {
        return this.IsParamNull(TAG_TARGETPSDEFID);
    }

    public final String getTARGETPSDEFID() {
        return this.GetParamStringValue(TAG_TARGETPSDEFID, "");
    }

    public final void setTARGETPSDEFID(String strValue) {
        this.SetParamValue(TAG_TARGETPSDEFID, strValue);
    }

    public final boolean isTARGETPSDEFNAMENull() {
        return this.IsParamNull(TAG_TARGETPSDEFNAME);
    }

    public final String getTARGETPSDEFNAME() {
        return this.GetParamStringValue(TAG_TARGETPSDEFNAME, "");
    }

    public final void setTARGETPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TARGETPSDEFNAME, strValue);
    }

    public final boolean isTARGETTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_TARGETTYPEPSDEFID);
    }

    public final String getTARGETTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_TARGETTYPEPSDEFID, "");
    }

    public final void setTARGETTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_TARGETTYPEPSDEFID, strValue);
    }

    public final boolean isTARGETTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_TARGETTYPEPSDEFNAME);
    }

    public final String getTARGETTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_TARGETTYPEPSDEFNAME, "");
    }

    public final void setTARGETTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TARGETTYPEPSDEFNAME, strValue);
    }

    public final boolean isSENDTIMEPSDEFIDNull() {
        return this.IsParamNull(TAG_SENDTIMEPSDEFID);
    }

    public final String getSENDTIMEPSDEFID() {
        return this.GetParamStringValue(TAG_SENDTIMEPSDEFID, "");
    }

    public final void setSENDTIMEPSDEFID(String strValue) {
        this.SetParamValue(TAG_SENDTIMEPSDEFID, strValue);
    }

    public final boolean isSENDTIMEPSDEFNAMENull() {
        return this.IsParamNull(TAG_SENDTIMEPSDEFNAME);
    }

    public final String getSENDTIMEPSDEFNAME() {
        return this.GetParamStringValue(TAG_SENDTIMEPSDEFNAME, "");
    }

    public final void setSENDTIMEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SENDTIMEPSDEFNAME, strValue);
    }

    public final boolean isSTATEPSDEFIDNull() {
        return this.IsParamNull(TAG_STATEPSDEFID);
    }

    public final String getSTATEPSDEFID() {
        return this.GetParamStringValue(TAG_STATEPSDEFID, "");
    }

    public final void setSTATEPSDEFID(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFID, strValue);
    }

    public final boolean isSTATEPSDEFNAMENull() {
        return this.IsParamNull(TAG_STATEPSDEFNAME);
    }

    public final String getSTATEPSDEFNAME() {
        return this.GetParamStringValue(TAG_STATEPSDEFNAME, "");
    }

    public final void setSTATEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFNAME, strValue);
    }

    public final boolean isTAG2PSDEFIDNull() {
        return this.IsParamNull(TAG_TAG2PSDEFID);
    }

    public final String getTAG2PSDEFID() {
        return this.GetParamStringValue(TAG_TAG2PSDEFID, "");
    }

    public final void setTAG2PSDEFID(String strValue) {
        this.SetParamValue(TAG_TAG2PSDEFID, strValue);
    }

    public final boolean isTAG2PSDEFNAMENull() {
        return this.IsParamNull(TAG_TAG2PSDEFNAME);
    }

    public final String getTAG2PSDEFNAME() {
        return this.GetParamStringValue(TAG_TAG2PSDEFNAME, "");
    }

    public final void setTAG2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TAG2PSDEFNAME, strValue);
    }

    public final boolean isSMSCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_SMSCONTENTPSDEFID);
    }

    public final String getSMSCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_SMSCONTENTPSDEFID, "");
    }

    public final void setSMSCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_SMSCONTENTPSDEFID, strValue);
    }

    public final boolean isSMSCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_SMSCONTENTPSDEFNAME);
    }

    public final String getSMSCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_SMSCONTENTPSDEFNAME, "");
    }

    public final void setSMSCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_SMSCONTENTPSDEFNAME, strValue);
    }

    public final boolean isIMCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_IMCONTENTPSDEFID);
    }

    public final String getIMCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_IMCONTENTPSDEFID, "");
    }

    public final void setIMCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_IMCONTENTPSDEFID, strValue);
    }

    public final boolean isIMCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_IMCONTENTPSDEFNAME);
    }

    public final String getIMCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_IMCONTENTPSDEFNAME, "");
    }

    public final void setIMCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_IMCONTENTPSDEFNAME, strValue);
    }

    public final boolean isWXCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_WXCONTENTPSDEFID);
    }

    public final String getWXCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_WXCONTENTPSDEFID, "");
    }

    public final void setWXCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_WXCONTENTPSDEFID, strValue);
    }

    public final boolean isWXCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_WXCONTENTPSDEFNAME);
    }

    public final String getWXCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_WXCONTENTPSDEFNAME, "");
    }

    public final void setWXCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_WXCONTENTPSDEFNAME, strValue);
    }

    public final boolean isDDCONTENTPSDEFIDNull() {
        return this.IsParamNull(TAG_DDCONTENTPSDEFID);
    }

    public final String getDDCONTENTPSDEFID() {
        return this.GetParamStringValue(TAG_DDCONTENTPSDEFID, "");
    }

    public final void setDDCONTENTPSDEFID(String strValue) {
        this.SetParamValue(TAG_DDCONTENTPSDEFID, strValue);
    }

    public final boolean isDDCONTENTPSDEFNAMENull() {
        return this.IsParamNull(TAG_DDCONTENTPSDEFNAME);
    }

    public final String getDDCONTENTPSDEFNAME() {
        return this.GetParamStringValue(TAG_DDCONTENTPSDEFNAME, "");
    }

    public final void setDDCONTENTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_DDCONTENTPSDEFNAME, strValue);
    }

    public final boolean isTASKURLPSDEFIDNull() {
        return this.IsParamNull(TAG_TASKURLPSDEFID);
    }

    public final String getTASKURLPSDEFID() {
        return this.GetParamStringValue(TAG_TASKURLPSDEFID, "");
    }

    public final void setTASKURLPSDEFID(String strValue) {
        this.SetParamValue(TAG_TASKURLPSDEFID, strValue);
    }

    public final boolean isTASKURLPSDEFNAMENull() {
        return this.IsParamNull(TAG_TASKURLPSDEFNAME);
    }

    public final String getTASKURLPSDEFNAME() {
        return this.GetParamStringValue(TAG_TASKURLPSDEFNAME, "");
    }

    public final void setTASKURLPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TASKURLPSDEFNAME, strValue);
    }

    public final boolean isMOBTASKURLPSDEFIDNull() {
        return this.IsParamNull(TAG_MOBTASKURLPSDEFID);
    }

    public final String getMOBTASKURLPSDEFID() {
        return this.GetParamStringValue(TAG_MOBTASKURLPSDEFID, "");
    }

    public final void setMOBTASKURLPSDEFID(String strValue) {
        this.SetParamValue(TAG_MOBTASKURLPSDEFID, strValue);
    }

    public final boolean isMOBTASKURLPSDEFNAMENull() {
        return this.IsParamNull(TAG_MOBTASKURLPSDEFNAME);
    }

    public final String getMOBTASKURLPSDEFNAME() {
        return this.GetParamStringValue(TAG_MOBTASKURLPSDEFNAME, "");
    }

    public final void setMOBTASKURLPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MOBTASKURLPSDEFNAME, strValue);
    }

    public final boolean isQUEUEPARAMSNull() {
        return this.IsParamNull(TAG_QUEUEPARAMS);
    }

    public final String getQUEUEPARAMS() {
        return this.GetParamStringValue(TAG_QUEUEPARAMS, "");
    }

    public final void setQUEUEPARAMS(String strValue) {
        this.SetParamValue(TAG_QUEUEPARAMS, strValue);
    }

    public final boolean isFILEPSDEFIDNull() {
        return this.IsParamNull(TAG_FILEPSDEFID);
    }

    public final String getFILEPSDEFID() {
        return this.GetParamStringValue(TAG_FILEPSDEFID, "");
    }

    public final void setFILEPSDEFID(String strValue) {
        this.SetParamValue(TAG_FILEPSDEFID, strValue);
    }

    public final boolean isFILEPSDEFNAMENull() {
        return this.IsParamNull(TAG_FILEPSDEFNAME);
    }

    public final String getFILEPSDEFNAME() {
        return this.GetParamStringValue(TAG_FILEPSDEFNAME, "");
    }

    public final void setFILEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_FILEPSDEFNAME, strValue);
    }

    public final boolean isPSSYSUTILDEIDNull() {
        return this.IsParamNull(TAG_PSSYSUTILDEID);
    }

    public final String getPSSYSUTILDEID() {
        return this.GetParamStringValue(TAG_PSSYSUTILDEID, "");
    }

    public final void setPSSYSUTILDEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUTILDEID, strValue);
    }

    public final boolean isPSSYSUTILDENAMENull() {
        return this.IsParamNull(TAG_PSSYSUTILDENAME);
    }

    public final String getPSSYSUTILDENAME() {
        return this.GetParamStringValue(TAG_PSSYSUTILDENAME, "");
    }

    public final void setPSSYSUTILDENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUTILDENAME, strValue);
    }

    public final boolean isUSERPSDEFIDNull() {
        return this.IsParamNull(TAG_USERPSDEFID);
    }

    public final String getUSERPSDEFID() {
        return this.GetParamStringValue(TAG_USERPSDEFID, "");
    }

    public final void setUSERPSDEFID(String strValue) {
        this.SetParamValue(TAG_USERPSDEFID, strValue);
    }

    public final boolean isUSERPSDEFNAMENull() {
        return this.IsParamNull(TAG_USERPSDEFNAME);
    }

    public final String getUSERPSDEFNAME() {
        return this.GetParamStringValue(TAG_USERPSDEFNAME, "");
    }

    public final void setUSERPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_USERPSDEFNAME, strValue);
    }

    public final boolean isUSER2PSDEFIDNull() {
        return this.IsParamNull(TAG_USER2PSDEFID);
    }

    public final String getUSER2PSDEFID() {
        return this.GetParamStringValue(TAG_USER2PSDEFID, "");
    }

    public final void setUSER2PSDEFID(String strValue) {
        this.SetParamValue(TAG_USER2PSDEFID, strValue);
    }

    public final boolean isUSER2PSDEFNAMENull() {
        return this.IsParamNull(TAG_USER2PSDEFNAME);
    }

    public final String getUSER2PSDEFNAME() {
        return this.GetParamStringValue(TAG_USER2PSDEFNAME, "");
    }

    public final void setUSER2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_USER2PSDEFNAME, strValue);
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

    public final boolean isCUSTOMMODENull() {
        return this.IsParamNull(TAG_CUSTOMMODE);
    }

    public final boolean getCUSTOMMODE() {
        return this.GetParamIntValue(TAG_CUSTOMMODE, 0) == 1;
    }

    public final void setCUSTOMMODE(boolean bValue) {
        this.SetParamValue(TAG_CUSTOMMODE, bValue ? 1 : 0);
    }

    public final boolean isMSGQUEUEPARAMSNull() {
        return this.IsParamNull(TAG_MSGQUEUEPARAMS);
    }

    public final String getMSGQUEUEPARAMS() {
        return this.GetParamStringValue(TAG_MSGQUEUEPARAMS, "");
    }

    public final void setMSGQUEUEPARAMS(String strValue) {
        this.SetParamValue(TAG_MSGQUEUEPARAMS, strValue);
    }
}

