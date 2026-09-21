/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBIScheme
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
    public static final String BIENGINETYPE_KYLIN = "KYLIN";
    public static final String BIENGINETYPE_USER = "USER";
    public static final String BIENGINETYPE_USER2 = "USER2";
    public static final String TAG_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String TAG_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_BIENGINETYPE = "BIENGINETYPE";
    public static final String TAG_BISCHEMETAG = "BISCHEMETAG";
    public static final String TAG_BISCHEMETAG2 = "BISCHEMETAG2";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_ENABLESERVICEAPI = "ENABLESERVICEAPI";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_SUBSYSSERVICECODENAME = "SUBSYSSERVICECODENAME";
    public static final String TAG_ENABLESUBSYSSERVICEAPI = "ENABLESUBSYSSERVICEAPI";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_SCHEMEPARAMS = "SCHEMEPARAMS";
    public static final String TAG_SERVICEPATH = "SERVICEPATH";
    public static final String TAG_SERVICEPARAM = "SERVICEPARAM";
    public static final String TAG_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String TAG_AUTHPARAM2 = "AUTHPARAM2";
    public static final String TAG_AUTHPARAM = "AUTHPARAM";
    public static final String TAG_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String TAG_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String TAG_AUTHMODE = "AUTHMODE";
    public static final String TAG_OBJNAMECASE = "OBJNAMECASE";
    public static final String TAG_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String TAG_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSSYSBISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMEID);
    }

    public final String getPSSYSBISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMEID, "");
    }

    public final void setPSSYSBISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMEID, strValue);
    }

    public final boolean isPSSYSBISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSBISCHEMENAME);
    }

    public final String getPSSYSBISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSBISCHEMENAME, "");
    }

    public final void setPSSYSBISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBISCHEMENAME, strValue);
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

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isBIENGINETYPENull() {
        return this.IsParamNull(TAG_BIENGINETYPE);
    }

    public final String getBIENGINETYPE() {
        return this.GetParamStringValue(TAG_BIENGINETYPE, "");
    }

    public final void setBIENGINETYPE(String strValue) {
        this.SetParamValue(TAG_BIENGINETYPE, strValue);
    }

    public final boolean isBISCHEMETAGNull() {
        return this.IsParamNull(TAG_BISCHEMETAG);
    }

    public final String getBISCHEMETAG() {
        return this.GetParamStringValue(TAG_BISCHEMETAG, "");
    }

    public final void setBISCHEMETAG(String strValue) {
        this.SetParamValue(TAG_BISCHEMETAG, strValue);
    }

    public final boolean isBISCHEMETAG2Null() {
        return this.IsParamNull(TAG_BISCHEMETAG2);
    }

    public final String getBISCHEMETAG2() {
        return this.GetParamStringValue(TAG_BISCHEMETAG2, "");
    }

    public final void setBISCHEMETAG2(String strValue) {
        this.SetParamValue(TAG_BISCHEMETAG2, strValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPINAME);
    }

    public final String getPSSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPINAME, "");
    }

    public final void setPSSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPINAME, strValue);
    }

    public final boolean isENABLESERVICEAPINull() {
        return this.IsParamNull(TAG_ENABLESERVICEAPI);
    }

    public final boolean getENABLESERVICEAPI() {
        return this.GetParamIntValue(TAG_ENABLESERVICEAPI, 0) == 1;
    }

    public final void setENABLESERVICEAPI(boolean bValue) {
        this.SetParamValue(TAG_ENABLESERVICEAPI, bValue ? 1 : 0);
    }

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPIID);
    }

    public final String getPSSUBSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPIID, "");
    }

    public final void setPSSUBSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSUBSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSSERVICEAPINAME);
    }

    public final String getPSSUBSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSSERVICEAPINAME, "");
    }

    public final void setPSSUBSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSSERVICEAPINAME, strValue);
    }

    public final boolean isSUBSYSSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SUBSYSSERVICECODENAME);
    }

    public final String getSUBSYSSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SUBSYSSERVICECODENAME, "");
    }

    public final void setSUBSYSSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SUBSYSSERVICECODENAME, strValue);
    }

    public final boolean isENABLESUBSYSSERVICEAPINull() {
        return this.IsParamNull(TAG_ENABLESUBSYSSERVICEAPI);
    }

    public final boolean getENABLESUBSYSSERVICEAPI() {
        return this.GetParamIntValue(TAG_ENABLESUBSYSSERVICEAPI, 0) == 1;
    }

    public final void setENABLESUBSYSSERVICEAPI(boolean bValue) {
        this.SetParamValue(TAG_ENABLESUBSYSSERVICEAPI, bValue ? 1 : 0);
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

    public final boolean isSCHEMEPARAMSNull() {
        return this.IsParamNull(TAG_SCHEMEPARAMS);
    }

    public final String getSCHEMEPARAMS() {
        return this.GetParamStringValue(TAG_SCHEMEPARAMS, "");
    }

    public final void setSCHEMEPARAMS(String strValue) {
        this.SetParamValue(TAG_SCHEMEPARAMS, strValue);
    }

    public final boolean isSERVICEPATHNull() {
        return this.IsParamNull(TAG_SERVICEPATH);
    }

    public final String getSERVICEPATH() {
        return this.GetParamStringValue(TAG_SERVICEPATH, "");
    }

    public final void setSERVICEPATH(String strValue) {
        this.SetParamValue(TAG_SERVICEPATH, strValue);
    }

    public final boolean isSERVICEPARAMNull() {
        return this.IsParamNull(TAG_SERVICEPARAM);
    }

    public final String getSERVICEPARAM() {
        return this.GetParamStringValue(TAG_SERVICEPARAM, "");
    }

    public final void setSERVICEPARAM(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM, strValue);
    }

    public final boolean isSERVICEPARAM2Null() {
        return this.IsParamNull(TAG_SERVICEPARAM2);
    }

    public final String getSERVICEPARAM2() {
        return this.GetParamStringValue(TAG_SERVICEPARAM2, "");
    }

    public final void setSERVICEPARAM2(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM2, strValue);
    }

    public final boolean isAUTHPARAM2Null() {
        return this.IsParamNull(TAG_AUTHPARAM2);
    }

    public final String getAUTHPARAM2() {
        return this.GetParamStringValue(TAG_AUTHPARAM2, "");
    }

    public final void setAUTHPARAM2(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM2, strValue);
    }

    public final boolean isAUTHPARAMNull() {
        return this.IsParamNull(TAG_AUTHPARAM);
    }

    public final String getAUTHPARAM() {
        return this.GetParamStringValue(TAG_AUTHPARAM, "");
    }

    public final void setAUTHPARAM(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM, strValue);
    }

    public final boolean isAUTHCLIENTSECRETNull() {
        return this.IsParamNull(TAG_AUTHCLIENTSECRET);
    }

    public final String getAUTHCLIENTSECRET() {
        return this.GetParamStringValue(TAG_AUTHCLIENTSECRET, "");
    }

    public final void setAUTHCLIENTSECRET(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTSECRET, strValue);
    }

    public final boolean isAUTHCLIENTIDNull() {
        return this.IsParamNull(TAG_AUTHCLIENTID);
    }

    public final String getAUTHCLIENTID() {
        return this.GetParamStringValue(TAG_AUTHCLIENTID, "");
    }

    public final void setAUTHCLIENTID(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTID, strValue);
    }

    public final boolean isAUTHMODENull() {
        return this.IsParamNull(TAG_AUTHMODE);
    }

    public final String getAUTHMODE() {
        return this.GetParamStringValue(TAG_AUTHMODE, "");
    }

    public final void setAUTHMODE(String strValue) {
        this.SetParamValue(TAG_AUTHMODE, strValue);
    }

    public final boolean isOBJNAMECASENull() {
        return this.IsParamNull(TAG_OBJNAMECASE);
    }

    public final String getOBJNAMECASE() {
        return this.GetParamStringValue(TAG_OBJNAMECASE, "");
    }

    public final void setOBJNAMECASE(String strValue) {
        this.SetParamValue(TAG_OBJNAMECASE, strValue);
    }

    public final boolean isPSSYSMODELGROUPIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELGROUPID);
    }

    public final String getPSSYSMODELGROUPID() {
        return this.GetParamStringValue(TAG_PSSYSMODELGROUPID, "");
    }

    public final void setPSSYSMODELGROUPID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELGROUPID, strValue);
    }

    public final boolean isPSSYSMODELGROUPNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELGROUPNAME);
    }

    public final String getPSSYSMODELGROUPNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELGROUPNAME, "");
    }

    public final void setPSSYSMODELGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELGROUPNAME, strValue);
    }

    public final boolean isENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZED);
    }

    public final boolean getENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZED, 0) == 1;
    }

    public final void setENABLECUSTOMIZED(boolean bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZED, bValue ? 1 : 0);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }
}

