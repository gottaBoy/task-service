/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysServiceAPI
extends BaseDataEntity {
    public static final String AUTHMODE_NONE = "NONE";
    public static final String AUTHMODE_AUTHORIZATION_CODE = "AUTHORIZATION_CODE";
    public static final String AUTHMODE_PASSWORD = "PASSWORD";
    public static final String AUTHMODE_CLIENT_CREDENTIALS = "CLIENT_CREDENTIALS";
    public static final String AUTHMODE_IMPLICIT = "IMPLICIT";
    public static final String APITYPE_RESTFUL = "RESTFUL";
    public static final String APITYPE_JAXRS = "JAXRS";
    public static final String APITYPE_WEBSERVICE = "WEBSERVICE";
    public static final int APIMODE_ALLDE = 1;
    public static final String SERVICETYPE_DEFAULT = "DEFAULT";
    public static final String SERVICETYPE_MIDDLEPLATFORM = "MIDDLEPLATFORM";
    public static final String SERVICETYPE_MASA = "MASA";
    public static final String SERVICETYPE_USER = "USER";
    public static final String SERVICETYPE_USER2 = "USER2";
    public static final int APILEVEL_CORE = 0;
    public static final int APILEVEL_USER = 3;
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_APITYPE = "APITYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_UNIQUETAG = "UNIQUETAG";
    public static final String TAG_VER = "VER";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_APIMODE = "APIMODE";
    public static final String TAG_SERVICECODENAME = "SERVICECODENAME";
    public static final String TAG_AUTHMODE = "AUTHMODE";
    public static final String TAG_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String TAG_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String TAG_AUTHCHECKTOKENURI = "AUTHCHECKTOKENURI";
    public static final String TAG_CFGTAG = "CFGTAG";
    public static final String TAG_CFGPSMODELSTORAGEID = "CFGPSMODELSTORAGEID";
    public static final String TAG_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PSSYSSAHANDLERID = "PSSYSSAHANDLERID";
    public static final String TAG_PSSYSSAHANDLERNAME = "PSSYSSAHANDLERNAME";
    public static final String TAG_AUTHPARAM2 = "AUTHPARAM2";
    public static final String TAG_AUTHPARAM = "AUTHPARAM";
    public static final String TAG_AUTHPARAM3 = "AUTHPARAM3";
    public static final String TAG_AUTHPARAM4 = "AUTHPARAM4";
    public static final String TAG_SERVICEPARAM = "SERVICEPARAM";
    public static final String TAG_SERVICEPARAM2 = "SERVICEPARAM2";
    public static final String TAG_SERVICEPARAM3 = "SERVICEPARAM3";
    public static final String TAG_SERVICEPARAM4 = "SERVICEPARAM4";
    public static final String TAG_DEFSELECTREQMETHOD = "DEFSELECTREQMETHOD";
    public static final String TAG_DEFDEDATASETREQMETHOD = "DEFDEDATASETREQMETHOD";
    public static final String TAG_DEFDEACTIONREQMETHOD = "DEFDEACTIONREQMETHOD";
    public static final String TAG_DEPSSYSSFPLUGINID = "DEPSSYSSFPLUGINID";
    public static final String TAG_DEPSSYSSFPLUGINNAME = "DEPSSYSSFPLUGINNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_APITAG = "APITAG";
    public static final String TAG_APITAG2 = "APITAG2";
    public static final String TAG_SERVICETYPE = "SERVICETYPE";
    public static final String TAG_DEFAULTPORT = "DEFAULTPORT";
    public static final String TAG_APILEVEL = "APILEVEL";
    public static final String TAG_RESETDEFACTIONCODENAME = "RESETDEFACTIONCODENAME";
    public static final String TAG_DEFAULTPSDEOPPRIVID = "DEFAULTPSDEOPPRIVID";
    public static final String TAG_DEFAULTPSDEOPPRIVNAME = "DEFAULTPSDEOPPRIVNAME";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_SERVICEDTOFLAG = "SERVICEDTOFLAG";
    public static final String TAG_SERVICEPARAMS = "SERVICEPARAMS";
    public static final String TAG_DEFCREATEREQMETHOD = "DEFCREATEREQMETHOD";
    public static final String TAG_DEFUPDATEREQMETHOD = "DEFUPDATEREQMETHOD";
    public static final String TAG_DEFGETREQMETHOD = "DEFGETREQMETHOD";
    public static final String TAG_DEFDELETEREQMETHOD = "DEFDELETEREQMETHOD";
    public static final String TAG_DEFNEEDRESOURCEKEY = "DEFNEEDRESOURCEKEY";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_DEFGETDRAFTREQMETHOD = "DEFGETDRAFTREQMETHOD";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_NAMINGSERVICE = "NAMINGSERVICE";
    public static final String TAG_ENABLEAPIMODELEX = "ENABLEAPIMODELEX";
    public static final String TAG_ENABLEGATEWAY = "ENABLEGATEWAY";
    public static final String TAG_IGNOREAUTHPATTERNS = "IGNOREAUTHPATTERNS";
    public static final String TAG_OUTPSSYSTRANSLATORID = "OUTPSSYSTRANSLATORID";
    public static final String TAG_OUTPSSYSTRANSLATORNAME = "OUTPSSYSTRANSLATORNAME";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

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

    public final boolean isAPITYPENull() {
        return this.IsParamNull(TAG_APITYPE);
    }

    public final String getAPITYPE() {
        return this.GetParamStringValue(TAG_APITYPE, "");
    }

    public final void setAPITYPE(String strValue) {
        this.SetParamValue(TAG_APITYPE, strValue);
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

    public final boolean isUNIQUETAGNull() {
        return this.IsParamNull(TAG_UNIQUETAG);
    }

    public final String getUNIQUETAG() {
        return this.GetParamStringValue(TAG_UNIQUETAG, "");
    }

    public final void setUNIQUETAG(String strValue) {
        this.SetParamValue(TAG_UNIQUETAG, strValue);
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

    public final boolean isAPIMODENull() {
        return this.IsParamNull(TAG_APIMODE);
    }

    public final int getAPIMODE() {
        return this.GetParamIntValue(TAG_APIMODE, 0);
    }

    public final void setAPIMODE(int nValue) {
        this.SetParamValue(TAG_APIMODE, nValue);
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

    public final boolean isAUTHCHECKTOKENURINull() {
        return this.IsParamNull(TAG_AUTHCHECKTOKENURI);
    }

    public final String getAUTHCHECKTOKENURI() {
        return this.GetParamStringValue(TAG_AUTHCHECKTOKENURI, "");
    }

    public final void setAUTHCHECKTOKENURI(String strValue) {
        this.SetParamValue(TAG_AUTHCHECKTOKENURI, strValue);
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

    public final boolean isPSDEVSLNSYSAPIIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPIID);
    }

    public final String getPSDEVSLNSYSAPIID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPIID, "");
    }

    public final void setPSDEVSLNSYSAPIID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPIID, strValue);
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

    public final boolean isAUTHPARAM3Null() {
        return this.IsParamNull(TAG_AUTHPARAM3);
    }

    public final String getAUTHPARAM3() {
        return this.GetParamStringValue(TAG_AUTHPARAM3, "");
    }

    public final void setAUTHPARAM3(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM3, strValue);
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

    public final boolean isDEFSELECTREQMETHODNull() {
        return this.IsParamNull(TAG_DEFSELECTREQMETHOD);
    }

    public final String getDEFSELECTREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFSELECTREQMETHOD, "");
    }

    public final void setDEFSELECTREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFSELECTREQMETHOD, strValue);
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

    public final boolean isDEFDEACTIONREQMETHODNull() {
        return this.IsParamNull(TAG_DEFDEACTIONREQMETHOD);
    }

    public final String getDEFDEACTIONREQMETHOD() {
        return this.GetParamStringValue(TAG_DEFDEACTIONREQMETHOD, "");
    }

    public final void setDEFDEACTIONREQMETHOD(String strValue) {
        this.SetParamValue(TAG_DEFDEACTIONREQMETHOD, strValue);
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

    public final boolean isSERVICETYPENull() {
        return this.IsParamNull(TAG_SERVICETYPE);
    }

    public final String getSERVICETYPE() {
        return this.GetParamStringValue(TAG_SERVICETYPE, "");
    }

    public final void setSERVICETYPE(String strValue) {
        this.SetParamValue(TAG_SERVICETYPE, strValue);
    }

    public final boolean isDEFAULTPORTNull() {
        return this.IsParamNull(TAG_DEFAULTPORT);
    }

    public final int getDEFAULTPORT() {
        return this.GetParamIntValue(TAG_DEFAULTPORT, 0);
    }

    public final void setDEFAULTPORT(int nValue) {
        this.SetParamValue(TAG_DEFAULTPORT, nValue);
    }

    public final boolean isAPILEVELNull() {
        return this.IsParamNull(TAG_APILEVEL);
    }

    public final int getAPILEVEL() {
        return this.GetParamIntValue(TAG_APILEVEL, 0);
    }

    public final void setAPILEVEL(int nValue) {
        this.SetParamValue(TAG_APILEVEL, nValue);
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

    public final boolean isDEFAULTPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_DEFAULTPSDEOPPRIVID);
    }

    public final String getDEFAULTPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_DEFAULTPSDEOPPRIVID, "");
    }

    public final void setDEFAULTPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_DEFAULTPSDEOPPRIVID, strValue);
    }

    public final boolean isDEFAULTPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_DEFAULTPSDEOPPRIVNAME);
    }

    public final String getDEFAULTPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_DEFAULTPSDEOPPRIVNAME, "");
    }

    public final void setDEFAULTPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_DEFAULTPSDEOPPRIVNAME, strValue);
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

    public final boolean isSERVICEDTOFLAGNull() {
        return this.IsParamNull(TAG_SERVICEDTOFLAG);
    }

    public final boolean getSERVICEDTOFLAG() {
        return this.GetParamIntValue(TAG_SERVICEDTOFLAG, 0) == 1;
    }

    public final void setSERVICEDTOFLAG(boolean bValue) {
        this.SetParamValue(TAG_SERVICEDTOFLAG, bValue ? 1 : 0);
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

    public final boolean isNAMINGSERVICENull() {
        return this.IsParamNull(TAG_NAMINGSERVICE);
    }

    public final String getNAMINGSERVICE() {
        return this.GetParamStringValue(TAG_NAMINGSERVICE, "");
    }

    public final void setNAMINGSERVICE(String strValue) {
        this.SetParamValue(TAG_NAMINGSERVICE, strValue);
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

    public final boolean isENABLEGATEWAYNull() {
        return this.IsParamNull(TAG_ENABLEGATEWAY);
    }

    public final boolean getENABLEGATEWAY() {
        return this.GetParamIntValue(TAG_ENABLEGATEWAY, 0) == 1;
    }

    public final void setENABLEGATEWAY(boolean bValue) {
        this.SetParamValue(TAG_ENABLEGATEWAY, bValue ? 1 : 0);
    }

    public final boolean isIGNOREAUTHPATTERNSNull() {
        return this.IsParamNull(TAG_IGNOREAUTHPATTERNS);
    }

    public final String getIGNOREAUTHPATTERNS() {
        return this.GetParamStringValue(TAG_IGNOREAUTHPATTERNS, "");
    }

    public final void setIGNOREAUTHPATTERNS(String strValue) {
        this.SetParamValue(TAG_IGNOREAUTHPATTERNS, strValue);
    }

    public final boolean isOUTPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_OUTPSSYSTRANSLATORID);
    }

    public final String getOUTPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_OUTPSSYSTRANSLATORID, "");
    }

    public final void setOUTPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSTRANSLATORID, strValue);
    }

    public final boolean isOUTPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_OUTPSSYSTRANSLATORNAME);
    }

    public final String getOUTPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_OUTPSSYSTRANSLATORNAME, "");
    }

    public final void setOUTPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_OUTPSSYSTRANSLATORNAME, strValue);
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

