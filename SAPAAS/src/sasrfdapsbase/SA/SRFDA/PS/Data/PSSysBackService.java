/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBackService
extends BaseDataEntity {
    public static final String STARTMODE_AUTO = "AUTO";
    public static final String STARTMODE_MANUAL = "MANUAL";
    public static final String SERVICECONTAINER_SC01 = "SC01";
    public static final String SERVICECONTAINER_SC02 = "SC02";
    public static final String SERVICECONTAINER_SC03 = "SC03";
    public static final String SERVICECONTAINER_SC04 = "SC04";
    public static final String TASKTYPE_PREDEFINED = "PREDEFINED";
    public static final String TASKTYPE_DEACTION = "DEACTION";
    public static final String TASKTYPE_USER = "USER";
    public static final String PREDEFINEDTYPE_DENOTIFY = "DENOTIFY";
    public static final String PREDEFINEDTYPE_SYSDATASYNCAGENT = "SYSDATASYNCAGENT";
    public static final String PREDEFINEDTYPE_WFCALLBACK = "WFCALLBACK";
    public static final String PREDEFINEDTYPE_SYSADMIN = "SYSADMIN";
    public static final String PREDEFINEDTYPE_SYSDTSQUEUE = "SYSDTSQUEUE";
    public static final String PREDEFINEDTYPE_USER = "USER";
    public static final String TAG_PSSYSBACKSERVICEID = "PSSYSBACKSERVICEID";
    public static final String TAG_PSSYSBACKSERVICENAME = "PSSYSBACKSERVICENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSBACKSERVICEID = "PSBACKSERVICEID";
    public static final String TAG_PSBACKSERVICENAME = "PSBACKSERVICENAME";
    public static final String TAG_SERVICEOBJ = "SERVICEOBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RUNORDER = "RUNORDER";
    public static final String TAG_STARTMODE = "STARTMODE";
    public static final String TAG_SERVICECONTAINER = "SERVICECONTAINER";
    public static final String TAG_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_CONTAINERTAG = "CONTAINERTAG";
    public static final String TAG_SERVICEPOLICY = "SERVICEPOLICY";
    public static final String TAG_SERVICEPOLICY2 = "SERVICEPOLICY2";
    public static final String TAG_SERVICETAG = "SERVICETAG";
    public static final String TAG_SERVICETAG2 = "SERVICETAG2";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_TIMERMODE = "TIMERMODE";
    public static final String TAG_TIMERPOLICY = "TIMERPOLICY";
    public static final String TAG_TASKTYPE = "TASKTYPE";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";

    public final boolean isPSSYSBACKSERVICEIDNull() {
        return this.IsParamNull(TAG_PSSYSBACKSERVICEID);
    }

    public final String getPSSYSBACKSERVICEID() {
        return this.GetParamStringValue(TAG_PSSYSBACKSERVICEID, "");
    }

    public final void setPSSYSBACKSERVICEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBACKSERVICEID, strValue);
    }

    public final boolean isPSSYSBACKSERVICENAMENull() {
        return this.IsParamNull(TAG_PSSYSBACKSERVICENAME);
    }

    public final String getPSSYSBACKSERVICENAME() {
        return this.GetParamStringValue(TAG_PSSYSBACKSERVICENAME, "");
    }

    public final void setPSSYSBACKSERVICENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBACKSERVICENAME, strValue);
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

    public final boolean isPSBACKSERVICEIDNull() {
        return this.IsParamNull(TAG_PSBACKSERVICEID);
    }

    public final String getPSBACKSERVICEID() {
        return this.GetParamStringValue(TAG_PSBACKSERVICEID, "");
    }

    public final void setPSBACKSERVICEID(String strValue) {
        this.SetParamValue(TAG_PSBACKSERVICEID, strValue);
    }

    public final boolean isPSBACKSERVICENAMENull() {
        return this.IsParamNull(TAG_PSBACKSERVICENAME);
    }

    public final String getPSBACKSERVICENAME() {
        return this.GetParamStringValue(TAG_PSBACKSERVICENAME, "");
    }

    public final void setPSBACKSERVICENAME(String strValue) {
        this.SetParamValue(TAG_PSBACKSERVICENAME, strValue);
    }

    public final boolean isSERVICEOBJNull() {
        return this.IsParamNull(TAG_SERVICEOBJ);
    }

    public final String getSERVICEOBJ() {
        return this.GetParamStringValue(TAG_SERVICEOBJ, "");
    }

    public final void setSERVICEOBJ(String strValue) {
        this.SetParamValue(TAG_SERVICEOBJ, strValue);
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

    public final boolean isRUNORDERNull() {
        return this.IsParamNull(TAG_RUNORDER);
    }

    public final int getRUNORDER() {
        return this.GetParamIntValue(TAG_RUNORDER, 0);
    }

    public final void setRUNORDER(int nValue) {
        this.SetParamValue(TAG_RUNORDER, nValue);
    }

    public final boolean isSTARTMODENull() {
        return this.IsParamNull(TAG_STARTMODE);
    }

    public final String getSTARTMODE() {
        return this.GetParamStringValue(TAG_STARTMODE, "");
    }

    public final void setSTARTMODE(String strValue) {
        this.SetParamValue(TAG_STARTMODE, strValue);
    }

    public final boolean isSERVICECONTAINERNull() {
        return this.IsParamNull(TAG_SERVICECONTAINER);
    }

    public final String getSERVICECONTAINER() {
        return this.GetParamStringValue(TAG_SERVICECONTAINER, "");
    }

    public final void setSERVICECONTAINER(String strValue) {
        this.SetParamValue(TAG_SERVICECONTAINER, strValue);
    }

    public final boolean isSERVICEPARAMSNull() {
        return this.IsParamNull(TAG_SERVICEPARAMS);
    }

    public final String getSERVICEPARAMS() {
        return this.GetParamStringValue(TAG_SERVICEPARAMS, "");
    }

    public final void setSERVICEPARAMS(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAMS, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isCONTAINERTAGNull() {
        return this.IsParamNull(TAG_CONTAINERTAG);
    }

    public final String getCONTAINERTAG() {
        return this.GetParamStringValue(TAG_CONTAINERTAG, "");
    }

    public final void setCONTAINERTAG(String strValue) {
        this.SetParamValue(TAG_CONTAINERTAG, strValue);
    }

    public final boolean isSERVICEPOLICYNull() {
        return this.IsParamNull(TAG_SERVICEPOLICY);
    }

    public final String getSERVICEPOLICY() {
        return this.GetParamStringValue(TAG_SERVICEPOLICY, "");
    }

    public final void setSERVICEPOLICY(String strValue) {
        this.SetParamValue(TAG_SERVICEPOLICY, strValue);
    }

    public final boolean isSERVICEPOLICY2Null() {
        return this.IsParamNull(TAG_SERVICEPOLICY2);
    }

    public final String getSERVICEPOLICY2() {
        return this.GetParamStringValue(TAG_SERVICEPOLICY2, "");
    }

    public final void setSERVICEPOLICY2(String strValue) {
        this.SetParamValue(TAG_SERVICEPOLICY2, strValue);
    }

    public final boolean isSERVICETAGNull() {
        return this.IsParamNull(TAG_SERVICETAG);
    }

    public final String getSERVICETAG() {
        return this.GetParamStringValue(TAG_SERVICETAG, "");
    }

    public final void setSERVICETAG(String strValue) {
        this.SetParamValue(TAG_SERVICETAG, strValue);
    }

    public final boolean isSERVICETAG2Null() {
        return this.IsParamNull(TAG_SERVICETAG2);
    }

    public final String getSERVICETAG2() {
        return this.GetParamStringValue(TAG_SERVICETAG2, "");
    }

    public final void setSERVICETAG2(String strValue) {
        this.SetParamValue(TAG_SERVICETAG2, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
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

    public final boolean isTIMERMODENull() {
        return this.IsParamNull(TAG_TIMERMODE);
    }

    public final int getTIMERMODE() {
        return this.GetParamIntValue(TAG_TIMERMODE, 0);
    }

    public final void setTIMERMODE(int bValue) {
        this.SetParamValue(TAG_TIMERMODE, bValue);
    }

    public final boolean isTIMERPOLICYNull() {
        return this.IsParamNull(TAG_TIMERPOLICY);
    }

    public final String getTIMERPOLICY() {
        return this.GetParamStringValue(TAG_TIMERPOLICY, "");
    }

    public final void setTIMERPOLICY(String strValue) {
        this.SetParamValue(TAG_TIMERPOLICY, strValue);
    }

    public final boolean isTASKTYPENull() {
        return this.IsParamNull(TAG_TASKTYPE);
    }

    public final String getTASKTYPE() {
        return this.GetParamStringValue(TAG_TASKTYPE, "");
    }

    public final void setTASKTYPE(String strValue) {
        this.SetParamValue(TAG_TASKTYPE, strValue);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }
}

