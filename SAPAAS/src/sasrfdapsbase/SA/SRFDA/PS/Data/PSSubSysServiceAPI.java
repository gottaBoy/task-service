/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubSysServiceAPI
extends BaseDataEntity {
    public static final String APITYPE_RESTFUL = "RESTFUL";
    public static final String APITYPE_JAXRS = "JAXRS";
    public static final String APITYPE_WEBSERVICE = "WEBSERVICE";
    public static final String APISOURCE_SYSAPI = "SYSAPI";
    public static final String APISOURCE_DEVSYSAPI = "DEVSYSAPI";
    public static final String APISOURCE_PREDEFINED = "PREDEFINED";
    public static final String SERVICETYPE_DEFAULT = "DEFAULT";
    public static final String SERVICETYPE_MIDDLEPLATFORM = "MIDDLEPLATFORM";
    public static final String SERVICETYPE_MASA = "MASA";
    public static final String SERVICETYPE_USER = "USER";
    public static final String SERVICETYPE_USER2 = "USER2";
    public static final String TAG_PSSUBSYSSERVICEAPIID = "PSSUBSYSSERVICEAPIID";
    public static final String TAG_PSSUBSYSSERVICEAPINAME = "PSSUBSYSSERVICEAPINAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_APITYPE = "APITYPE";
    public static final String TAG_VER = "VER";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_SERVICEPATH = "SERVICEPATH";
    public static final String TAG_SERVICEPARAM = "SERVICEPARAM";
    public static final String TAG_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_AUTHMODE = "AUTHMODE";
    public static final String TAG_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String TAG_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String TAG_AUTHACCESSTOKENURI = "AUTHACCESSTOKENURI";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_ADDDEMODE = "ADDDEMODE";
    public static final String TAG_ADDDEPARAMS = "ADDDEPARAMS";
    public static final String TAG_ADDDEPREFIX = "ADDDEPREFIX";
    public static final String TAG_CFGTAG = "CFGTAG";
    public static final String TAG_CFGPSMODELSTORAGEID = "CFGPSMODELSTORAGEID";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PSSYSSAHANDLERID = "PSSYSSAHANDLERID";
    public static final String TAG_PSSYSSAHANDLERNAME = "PSSYSSAHANDLERNAME";
    public static final String TAG_APISOURCE = "APISOURCE";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_SERVICEPARAM3 = "SERVICEPARAM3";
    public static final String TAG_SERVICEPARAM4 = "SERVICEPARAM4";
    public static final String TAG_AUTHPARAM4 = "AUTHPARAM4";
    public static final String TAG_AUTHPARAM3 = "AUTHPARAM3";
    public static final String TAG_AUTHPARAM2 = "AUTHPARAM2";
    public static final String TAG_AUTHPARAM = "AUTHPARAM";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_DEFDEACTIONREQMETHOD = "DEFDEACTIONREQMETHOD";
    public static final String TAG_DEFDEDATASETREQMETHOD = "DEFDEDATASETREQMETHOD";
    public static final String TAG_DEFSELECTREQMETHOD = "DEFSELECTREQMETHOD";
    public static final String TAG_APITAG = "APITAG";
    public static final String TAG_APITAG2 = "APITAG2";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_DEPSSYSSFPLUGINID = "DEPSSYSSFPLUGINID";
    public static final String TAG_DEPSSYSSFPLUGINNAME = "DEPSSYSSFPLUGINNAME";
    public static final String TAG_SERVICETYPE = "SERVICETYPE";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_SERVICEDTOFLAG = "SERVICEDTOFLAG";
    public static final String TAG_FROMDEMODELFLAG = "FROMDEMODELFLAG";
    public static final String TAG_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String TAG_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String TAG_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String TAG_AUTHTIMEOUT = "AUTHTIMEOUT";
    public static final String TAG_AUTHCODE = "AUTHCODE";
    public static final String TAG_HEADERPARAMS = "HEADERPARAMS";
    public static final String TAG_METHODCODE = "METHODCODE";
    public static final String TAG_DEFCREATEREQMETHOD = "DEFCREATEREQMETHOD";
    public static final String TAG_DEFUPDATEREQMETHOD = "DEFUPDATEREQMETHOD";
    public static final String TAG_DEFGETREQMETHOD = "DEFGETREQMETHOD";
    public static final String TAG_DEFDELETEREQMETHOD = "DEFDELETEREQMETHOD";
    public static final String TAG_DEFNEEDRESOURCEKEY = "DEFNEEDRESOURCEKEY";
    public static final String TAG_RESETDEFACTIONCODENAME = "RESETDEFACTIONCODENAME";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_SCRIPTENGINE = "SCRIPTENGINE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_DEFGETDRAFTREQMETHOD = "DEFGETDRAFTREQMETHOD";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_ENABLEAPIMODELEX = "ENABLEAPIMODELEX";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isAPITYPENull() {
        return this.IsParamNull(TAG_APITYPE);
    }

    public final String getAPITYPE() {
        return this.GetParamStringValue(TAG_APITYPE, "");
    }

    public final void setAPITYPE(String strValue) {
        this.SetParamValue(TAG_APITYPE, strValue);
    }

    public final boolean isVERNull() {
        return this.IsParamNull(TAG_VER);
    }

    public final int getVER() {
        return this.GetParamIntValue(TAG_VER, 0);
    }

    public final void setVER(int nValue) {
        this.SetParamValue(TAG_VER, nValue);
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

    public final boolean isSERVICECODENAMENull() {
        return this.IsParamNull(TAG_SERVICECODENAME);
    }

    public final String getSERVICECODENAME() {
        return this.GetParamStringValue(TAG_SERVICECODENAME, "");
    }

    public final void setSERVICECODENAME(String strValue) {
        this.SetParamValue(TAG_SERVICECODENAME, strValue);
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

    public final boolean isAUTHCLIENTIDNull() {
        return this.IsParamNull(TAG_AUTHCLIENTID);
    }

    public final String getAUTHCLIENTID() {
        return this.GetParamStringValue(TAG_AUTHCLIENTID, "");
    }

    public final void setAUTHCLIENTID(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTID, strValue);
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

    public final boolean isAUTHACCESSTOKENURINull() {
        return this.IsParamNull(TAG_AUTHACCESSTOKENURI);
    }

    public final String getAUTHACCESSTOKENURI() {
        return this.GetParamStringValue(TAG_AUTHACCESSTOKENURI, "");
    }

    public final void setAUTHACCESSTOKENURI(String strValue) {
        this.SetParamValue(TAG_AUTHACCESSTOKENURI, strValue);
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

    public final boolean isADDDEMODENull() {
        return this.IsParamNull(TAG_ADDDEMODE);
    }

    public final int getADDDEMODE() {
        return this.GetParamIntValue(TAG_ADDDEMODE, 0);
    }

    public final void setADDDEMODE(int nValue) {
        this.SetParamValue(TAG_ADDDEMODE, nValue);
    }

    public final boolean isADDDEPARAMSNull() {
        return this.IsParamNull(TAG_ADDDEPARAMS);
    }

    public final String getADDDEPARAMS() {
        return this.GetParamStringValue(TAG_ADDDEPARAMS, "");
    }

    public final void setADDDEPARAMS(String strValue) {
        this.SetParamValue(TAG_ADDDEPARAMS, strValue);
    }

    public final boolean isADDDEPREFIXNull() {
        return this.IsParamNull(TAG_ADDDEPREFIX);
    }

    public final String getADDDEPREFIX() {
        return this.GetParamStringValue(TAG_ADDDEPREFIX, "");
    }

    public final void setADDDEPREFIX(String strValue) {
        this.SetParamValue(TAG_ADDDEPREFIX, strValue);
    }

    public final boolean isCFGTAGNull() {
        return this.IsParamNull(TAG_CFGTAG);
    }

    public final String getCFGTAG() {
        return this.GetParamStringValue(TAG_CFGTAG, "");
    }

    public final void setCFGTAG(String strValue) {
        this.SetParamValue(TAG_CFGTAG, strValue);
    }

    public final boolean isCFGPSMODELSTORAGEIDNull() {
        return this.IsParamNull(TAG_CFGPSMODELSTORAGEID);
    }

    public final String getCFGPSMODELSTORAGEID() {
        return this.GetParamStringValue(TAG_CFGPSMODELSTORAGEID, "");
    }

    public final void setCFGPSMODELSTORAGEID(String strValue) {
        this.SetParamValue(TAG_CFGPSMODELSTORAGEID, strValue);
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

    public final boolean isPSSYSSAHANDLERIDNull() {
        return this.IsParamNull(TAG_PSSYSSAHANDLERID);
    }

    public final String getPSSYSSAHANDLERID() {
        return this.GetParamStringValue(TAG_PSSYSSAHANDLERID, "");
    }

    public final void setPSSYSSAHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSSYSSAHANDLERID, strValue);
    }

    public final boolean isPSSYSSAHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSSYSSAHANDLERNAME);
    }

    public final String getPSSYSSAHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSSYSSAHANDLERNAME, "");
    }

    public final void setPSSYSSAHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSAHANDLERNAME, strValue);
    }

    public final boolean isAPISOURCENull() {
        return this.IsParamNull(TAG_APISOURCE);
    }

    public final String getAPISOURCE() {
        return this.GetParamStringValue(TAG_APISOURCE, "");
    }

    public final void setAPISOURCE(String strValue) {
        this.SetParamValue(TAG_APISOURCE, strValue);
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

    public final boolean isSERVICEPARAM3Null() {
        return this.IsParamNull(TAG_SERVICEPARAM3);
    }

    public final String getSERVICEPARAM3() {
        return this.GetParamStringValue(TAG_SERVICEPARAM3, "");
    }

    public final void setSERVICEPARAM3(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM3, strValue);
    }

    public final boolean isSERVICEPARAM4Null() {
        return this.IsParamNull(TAG_SERVICEPARAM4);
    }

    public final String getSERVICEPARAM4() {
        return this.GetParamStringValue(TAG_SERVICEPARAM4, "");
    }

    public final void setSERVICEPARAM4(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM4, strValue);
    }

    public final boolean isAUTHPARAM4Null() {
        return this.IsParamNull(TAG_AUTHPARAM4);
    }

    public final String getAUTHPARAM4() {
        return this.GetParamStringValue(TAG_AUTHPARAM4, "");
    }

    public final void setAUTHPARAM4(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM4, strValue);
    }

    public final boolean isAUTHPARAM3Null() {
        return this.IsParamNull(TAG_AUTHPARAM3);
    }

    public final String getAUTHPARAM3() {
        return this.GetParamStringValue(TAG_AUTHPARAM3, "");
    }

    public final void setAUTHPARAM3(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM3, strValue);
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

    public final boolean isDEFDEACTIONREQMETHODNull() {
        return this.IsParamNull(TAG_DEFDEACTIONREQMETHOD);
    }

    public final String getDEFDEACTIONREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFDEACTIONREQMETHOD, "");
    }

    public final void setDEFDEACTIONREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFDEACTIONREQMETHOD, strValue);
    }

    public final boolean isDEFDEDATASETREQMETHODNull() {
        return this.IsParamNull(TAG_DEFDEDATASETREQMETHOD);
    }

    public final String getDEFDEDATASETREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFDEDATASETREQMETHOD, "");
    }

    public final void setDEFDEDATASETREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFDEDATASETREQMETHOD, strValue);
    }

    public final boolean isDEFSELECTREQMETHODNull() {
        return this.IsParamNull(TAG_DEFSELECTREQMETHOD);
    }

    public final String getDEFSELECTREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFSELECTREQMETHOD, "");
    }

    public final void setDEFSELECTREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFSELECTREQMETHOD, strValue);
    }

    public final boolean isAPITAGNull() {
        return this.IsParamNull(TAG_APITAG);
    }

    public final String getAPITAG() {
        return this.GetParamStringValue(TAG_APITAG, "");
    }

    public final void setAPITAG(String strValue) {
        this.SetParamValue(TAG_APITAG, strValue);
    }

    public final boolean isAPITAG2Null() {
        return this.IsParamNull(TAG_APITAG2);
    }

    public final String getAPITAG2() {
        return this.GetParamStringValue(TAG_APITAG2, "");
    }

    public final void setAPITAG2(String strValue) {
        this.SetParamValue(TAG_APITAG2, strValue);
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

    public final boolean isDEPSSYSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_DEPSSYSSFPLUGINID);
    }

    public final String getDEPSSYSSFPLUGINID() {
        return this.GetParamStringValue(TAG_DEPSSYSSFPLUGINID, "");
    }

    public final void setDEPSSYSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_DEPSSYSSFPLUGINID, strValue);
    }

    public final boolean isDEPSSYSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_DEPSSYSSFPLUGINNAME);
    }

    public final String getDEPSSYSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_DEPSSYSSFPLUGINNAME, "");
    }

    public final void setDEPSSYSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_DEPSSYSSFPLUGINNAME, strValue);
    }

    public final boolean isSERVICETYPENull() {
        return this.IsParamNull(TAG_SERVICETYPE);
    }

    public final String getSERVICETYPE() {
        return this.GetParamStringValue(TAG_SERVICETYPE, "");
    }

    public final void setSERVICETYPE(String strValue) {
        this.SetParamValue(TAG_SERVICETYPE, strValue);
    }

    public final boolean isSERVICEDTOFLAGNull() {
        return this.IsParamNull(TAG_SERVICEDTOFLAG);
    }

    public final boolean getSERVICEDTOFLAG() {
        return this.GetParamIntValue(TAG_SERVICEDTOFLAG, 0) == 1;
    }

    public final void setSERVICEDTOFLAG(boolean bValue) {
        this.SetParamValue(TAG_SERVICEDTOFLAG, bValue ? 1 : 0);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.IsParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.GetParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.SetParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isFROMDEMODELFLAGNull() {
        return this.IsParamNull(TAG_FROMDEMODELFLAG);
    }

    public final boolean getFROMDEMODELFLAG() {
        return this.GetParamIntValue(TAG_FROMDEMODELFLAG, 0) == 1;
    }

    public final void setFROMDEMODELFLAG(boolean bValue) {
        this.SetParamValue(TAG_FROMDEMODELFLAG, bValue ? 1 : 0);
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

    public final boolean isPSSYSEAISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMEID);
    }

    public final String getPSSYSEAISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMEID, "");
    }

    public final void setPSSYSEAISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMEID, strValue);
    }

    public final boolean isPSSYSEAISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMENAME);
    }

    public final String getPSSYSEAISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMENAME, "");
    }

    public final void setPSSYSEAISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMENAME, strValue);
    }

    public final boolean isAUTHTIMEOUTNull() {
        return this.IsParamNull(TAG_AUTHTIMEOUT);
    }

    public final int getAUTHTIMEOUT() {
        return this.GetParamIntValue(TAG_AUTHTIMEOUT, 0);
    }

    public final void setAUTHTIMEOUT(int nValue) {
        this.SetParamValue(TAG_AUTHTIMEOUT, nValue);
    }

    public final boolean isAUTHCODENull() {
        return this.IsParamNull(TAG_AUTHCODE);
    }

    public final String getAUTHCODE() {
        return this.GetParamStringValue(TAG_AUTHCODE, "");
    }

    public final void setAUTHCODE(String strValue) {
        this.SetParamValue(TAG_AUTHCODE, strValue);
    }

    public final boolean isHEADERPARAMSNull() {
        return this.IsParamNull(TAG_HEADERPARAMS);
    }

    public final String getHEADERPARAMS() {
        return this.GetParamStringValue(TAG_HEADERPARAMS, "");
    }

    public final void setHEADERPARAMS(String strValue) {
        this.SetParamValue(TAG_HEADERPARAMS, strValue);
    }

    public final boolean isMETHODCODENull() {
        return this.IsParamNull(TAG_METHODCODE);
    }

    public final String getMETHODCODE() {
        return this.GetParamStringValue(TAG_METHODCODE, "");
    }

    public final void setMETHODCODE(String strValue) {
        this.SetParamValue(TAG_METHODCODE, strValue);
    }

    public final boolean isDEFCREATEREQMETHODNull() {
        return this.IsParamNull(TAG_DEFCREATEREQMETHOD);
    }

    public final String getDEFCREATEREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFCREATEREQMETHOD, "");
    }

    public final void setDEFCREATEREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFCREATEREQMETHOD, strValue);
    }

    public final boolean isDEFUPDATEREQMETHODNull() {
        return this.IsParamNull(TAG_DEFUPDATEREQMETHOD);
    }

    public final String getDEFUPDATEREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFUPDATEREQMETHOD, "");
    }

    public final void setDEFUPDATEREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFUPDATEREQMETHOD, strValue);
    }

    public final boolean isDEFGETREQMETHODNull() {
        return this.IsParamNull(TAG_DEFGETREQMETHOD);
    }

    public final String getDEFGETREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFGETREQMETHOD, "");
    }

    public final void setDEFGETREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFGETREQMETHOD, strValue);
    }

    public final boolean isDEFDELETEREQMETHODNull() {
        return this.IsParamNull(TAG_DEFDELETEREQMETHOD);
    }

    public final String getDEFDELETEREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFDELETEREQMETHOD, "");
    }

    public final void setDEFDELETEREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFDELETEREQMETHOD, strValue);
    }

    public final boolean isDEFNEEDRESOURCEKEYNull() {
        return this.IsParamNull(TAG_DEFNEEDRESOURCEKEY);
    }

    public final boolean getDEFNEEDRESOURCEKEY() {
        return this.GetParamIntValue(TAG_DEFNEEDRESOURCEKEY, 0) == 1;
    }

    public final void setDEFNEEDRESOURCEKEY(boolean bValue) {
        this.SetParamValue(TAG_DEFNEEDRESOURCEKEY, bValue ? 1 : 0);
    }

    public final boolean isRESETDEFACTIONCODENAMENull() {
        return this.IsParamNull(TAG_RESETDEFACTIONCODENAME);
    }

    public final boolean getRESETDEFACTIONCODENAME() {
        return this.GetParamIntValue(TAG_RESETDEFACTIONCODENAME, 0) == 1;
    }

    public final void setRESETDEFACTIONCODENAME(boolean bValue) {
        this.SetParamValue(TAG_RESETDEFACTIONCODENAME, bValue ? 1 : 0);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isSCRIPTENGINENull() {
        return this.IsParamNull(TAG_SCRIPTENGINE);
    }

    public final String getSCRIPTENGINE() {
        return this.GetParamStringValue(TAG_SCRIPTENGINE, "");
    }

    public final void setSCRIPTENGINE(String strValue) {
        this.SetParamValue(TAG_SCRIPTENGINE, strValue);
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

    public final boolean isDEFGETDRAFTREQMETHODNull() {
        return this.IsParamNull(TAG_DEFGETDRAFTREQMETHOD);
    }

    public final String getDEFGETDRAFTREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFGETDRAFTREQMETHOD, "");
    }

    public final void setDEFGETDRAFTREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFGETDRAFTREQMETHOD, strValue);
    }

    public final boolean isCODENAMEMODENull() {
        return this.IsParamNull(TAG_CODENAMEMODE);
    }

    public final String getCODENAMEMODE() {
        return this.GetParamStringValue(TAG_CODENAMEMODE, "");
    }

    public final void setCODENAMEMODE(String strValue) {
        this.SetParamValue(TAG_CODENAMEMODE, strValue);
    }

    public final boolean isENABLEAPIMODELEXNull() {
        return this.IsParamNull(TAG_ENABLEAPIMODELEX);
    }

    public final boolean getENABLEAPIMODELEX() {
        return this.GetParamIntValue(TAG_ENABLEAPIMODELEX, 0) == 1;
    }

    public final void setENABLEAPIMODELEX(boolean bValue) {
        this.SetParamValue(TAG_ENABLEAPIMODELEX, bValue ? 1 : 0);
    }

    public final boolean isPSSYSRESOURCEIDNull() {
        return this.IsParamNull(TAG_PSSYSRESOURCEID);
    }

    public final String getPSSYSRESOURCEID() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCEID, "");
    }

    public final void setPSSYSRESOURCEID(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCEID, strValue);
    }

    public final boolean isPSSYSRESOURCENAMENull() {
        return this.IsParamNull(TAG_PSSYSRESOURCENAME);
    }

    public final String getPSSYSRESOURCENAME() {
        return this.GetParamStringValue(TAG_PSSYSRESOURCENAME, "");
    }

    public final void setPSSYSRESOURCENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRESOURCENAME, strValue);
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

