/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewMsg
extends BaseDataEntity {
    public static final String MSGPOS_TOP = "TOP";
    public static final String MSGPOS_BOTTOM = "BOTTOM";
    public static final String MSGPOS_POPUP = "POPUP";
    public static final String MSGTYPE_INFO = "INFO";
    public static final String MSGTYPE_WARN = "WARN";
    public static final String MSGTYPE_ERROR = "ERROR";
    public static final String TAG_PSVIEWMSGID = "PSVIEWMSGID";
    public static final String TAG_PSVIEWMSGNAME = "PSVIEWMSGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MSGPOS = "MSGPOS";
    public static final String TAG_MSGTYPE = "MSGTYPE";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_DYNAMICMODE = "DYNAMICMODE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_MSGPOSPSDEFID = "MSGPOSPSDEFID";
    public static final String TAG_MSGPOSPSDEFNAME = "MSGPOSPSDEFNAME";
    public static final String TAG_MSGTYPEPSDEFID = "MSGTYPEPSDEFID";
    public static final String TAG_MSGTYPEPSDEFNAME = "MSGTYPEPSDEFNAME";
    public static final String TAG_TITLEPSDEFID = "TITLEPSDEFID";
    public static final String TAG_TITLEPSDEFNAME = "TITLEPSDEFNAME";
    public static final String TAG_REMOVEPSDEFID = "REMOVEPSDEFID";
    public static final String TAG_REMOVEPSDEFNAME = "REMOVEPSDEFNAME";
    public static final String TAG_ENABLEREMOVE = "ENABLEREMOVE";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_TITLELANRESTAGPSDEFID = "TITLELANRESTAGPSDEFID";
    public static final String TAG_TITLELANRESTAGPSDEFNAME = "TITLELANRESTAGPSDEFNAME";
    public static final String TAG_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String TAG_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_ENABLECACHE = "ENABLECACHE";
    public static final String TAG_CACHESCOPE = "CACHESCOPE";
    public static final String TAG_CACHETIMEOUT = "CACHETIMEOUT";
    public static final String TAG_DSLINK = "DSLINK";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_CACHETAGPSDEFID = "CACHETAGPSDEFID";
    public static final String TAG_CACHETAGPSDEFNAME = "CACHETAGPSDEFNAME";
    public static final String TAG_CACHETAG2PSDEFID = "CACHETAG2PSDEFID";
    public static final String TAG_CACHETAG2PSDEFNAME = "CACHETAG2PSDEFNAME";
    public static final String TAG_ORDERVALUEPSDEFID = "ORDERVALUEPSDEFID";
    public static final String TAG_ORDERVALUEPSDEFNAME = "ORDERVALUEPSDEFNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String TAG_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_ICONPSDEFID = "ICONPSDEFID";
    public static final String TAG_ICONPSDEFNAME = "ICONPSDEFNAME";
    public static final String TAG_CLSPSDEFID = "CLSPSDEFID";
    public static final String TAG_CLSPSDEFNAME = "CLSPSDEFNAME";
    public static final String TAG_VIEWMSGPARAMS = "VIEWMSGPARAMS";
    public static final String TAG_VIEWMSGTAG2 = "VIEWMSGTAG2";
    public static final String TAG_VIEWMSGTAG = "VIEWMSGTAG";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_ENABLEMODE = "ENABLEMODE";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_TESTCUSTOMCODE = "TESTCUSTOMCODE";
    public static final String TAG_TESTPSDELOGICID = "TESTPSDELOGICID";
    public static final String TAG_TESTPSDELOGICNAME = "TESTPSDELOGICNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_CONTENTTYPEPSDEFID = "CONTENTTYPEPSDEFID";
    public static final String TAG_CONTENTTYPEPSDEFNAME = "CONTENTTYPEPSDEFNAME";

    public final boolean isPSVIEWMSGIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGID);
    }

    public final String getPSVIEWMSGID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGID, "");
    }

    public final void setPSVIEWMSGID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGID, strValue);
    }

    public final boolean isPSVIEWMSGNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGNAME);
    }

    public final String getPSVIEWMSGNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGNAME, "");
    }

    public final void setPSVIEWMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isMSGPOSNull() {
        return this.IsParamNull(TAG_MSGPOS);
    }

    public final String getMSGPOS() {
        return this.GetParamStringValue(TAG_MSGPOS, "");
    }

    public final void setMSGPOS(String strValue) {
        this.SetParamValue(TAG_MSGPOS, strValue);
    }

    public final boolean isMSGTYPENull() {
        return this.IsParamNull(TAG_MSGTYPE);
    }

    public final String getMSGTYPE() {
        return this.GetParamStringValue(TAG_MSGTYPE, "");
    }

    public final void setMSGTYPE(String strValue) {
        this.SetParamValue(TAG_MSGTYPE, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
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

    public final boolean isDYNAMICMODENull() {
        return this.IsParamNull(TAG_DYNAMICMODE);
    }

    public final boolean getDYNAMICMODE() {
        return this.GetParamIntValue(TAG_DYNAMICMODE, 0) == 1;
    }

    public final void setDYNAMICMODE(boolean bValue) {
        this.SetParamValue(TAG_DYNAMICMODE, bValue ? 1 : 0);
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

    public final boolean isMSGPOSPSDEFIDNull() {
        return this.IsParamNull(TAG_MSGPOSPSDEFID);
    }

    public final String getMSGPOSPSDEFID() {
        return this.GetParamStringValue(TAG_MSGPOSPSDEFID, "");
    }

    public final void setMSGPOSPSDEFID(String strValue) {
        this.SetParamValue(TAG_MSGPOSPSDEFID, strValue);
    }

    public final boolean isMSGPOSPSDEFNAMENull() {
        return this.IsParamNull(TAG_MSGPOSPSDEFNAME);
    }

    public final String getMSGPOSPSDEFNAME() {
        return this.GetParamStringValue(TAG_MSGPOSPSDEFNAME, "");
    }

    public final void setMSGPOSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_MSGPOSPSDEFNAME, strValue);
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

    public final boolean isREMOVEPSDEFIDNull() {
        return this.IsParamNull(TAG_REMOVEPSDEFID);
    }

    public final String getREMOVEPSDEFID() {
        return this.GetParamStringValue(TAG_REMOVEPSDEFID, "");
    }

    public final void setREMOVEPSDEFID(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEFID, strValue);
    }

    public final boolean isREMOVEPSDEFNAMENull() {
        return this.IsParamNull(TAG_REMOVEPSDEFNAME);
    }

    public final String getREMOVEPSDEFNAME() {
        return this.GetParamStringValue(TAG_REMOVEPSDEFNAME, "");
    }

    public final void setREMOVEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_REMOVEPSDEFNAME, strValue);
    }

    public final boolean isENABLEREMOVENull() {
        return this.IsParamNull(TAG_ENABLEREMOVE);
    }

    public final boolean getENABLEREMOVE() {
        return this.GetParamIntValue(TAG_ENABLEREMOVE, 0) == 1;
    }

    public final void setENABLEREMOVE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEREMOVE, bValue ? 1 : 0);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.IsParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESNAME, strValue);
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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isTITLELANRESTAGPSDEFIDNull() {
        return this.IsParamNull(TAG_TITLELANRESTAGPSDEFID);
    }

    public final String getTITLELANRESTAGPSDEFID() {
        return this.GetParamStringValue(TAG_TITLELANRESTAGPSDEFID, "");
    }

    public final void setTITLELANRESTAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_TITLELANRESTAGPSDEFID, strValue);
    }

    public final boolean isTITLELANRESTAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_TITLELANRESTAGPSDEFNAME);
    }

    public final String getTITLELANRESTAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_TITLELANRESTAGPSDEFNAME, "");
    }

    public final void setTITLELANRESTAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TITLELANRESTAGPSDEFNAME, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isENABLECACHENull() {
        return this.IsParamNull(TAG_ENABLECACHE);
    }

    public final boolean getENABLECACHE() {
        return this.GetParamIntValue(TAG_ENABLECACHE, 0) == 1;
    }

    public final void setENABLECACHE(boolean bValue) {
        this.SetParamValue(TAG_ENABLECACHE, bValue ? 1 : 0);
    }

    public final boolean isCACHESCOPENull() {
        return this.IsParamNull(TAG_CACHESCOPE);
    }

    public final String getCACHESCOPE() {
        return this.GetParamStringValue(TAG_CACHESCOPE, "");
    }

    public final void setCACHESCOPE(String strValue) {
        this.SetParamValue(TAG_CACHESCOPE, strValue);
    }

    public final boolean isCACHETIMEOUTNull() {
        return this.IsParamNull(TAG_CACHETIMEOUT);
    }

    public final int getCACHETIMEOUT() {
        return this.GetParamIntValue(TAG_CACHETIMEOUT, 0);
    }

    public final void setCACHETIMEOUT(int nValue) {
        this.SetParamValue(TAG_CACHETIMEOUT, nValue);
    }

    public final boolean isDSLINKNull() {
        return this.IsParamNull(TAG_DSLINK);
    }

    public final String getDSLINK() {
        return this.GetParamStringValue(TAG_DSLINK, "");
    }

    public final void setDSLINK(String strValue) {
        this.SetParamValue(TAG_DSLINK, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }

    public final boolean isCACHETAGPSDEFIDNull() {
        return this.IsParamNull(TAG_CACHETAGPSDEFID);
    }

    public final String getCACHETAGPSDEFID() {
        return this.GetParamStringValue(TAG_CACHETAGPSDEFID, "");
    }

    public final void setCACHETAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_CACHETAGPSDEFID, strValue);
    }

    public final boolean isCACHETAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_CACHETAGPSDEFNAME);
    }

    public final String getCACHETAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_CACHETAGPSDEFNAME, "");
    }

    public final void setCACHETAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CACHETAGPSDEFNAME, strValue);
    }

    public final boolean isCACHETAG2PSDEFIDNull() {
        return this.IsParamNull(TAG_CACHETAG2PSDEFID);
    }

    public final String getCACHETAG2PSDEFID() {
        return this.GetParamStringValue(TAG_CACHETAG2PSDEFID, "");
    }

    public final void setCACHETAG2PSDEFID(String strValue) {
        this.SetParamValue(TAG_CACHETAG2PSDEFID, strValue);
    }

    public final boolean isCACHETAG2PSDEFNAMENull() {
        return this.IsParamNull(TAG_CACHETAG2PSDEFNAME);
    }

    public final String getCACHETAG2PSDEFNAME() {
        return this.GetParamStringValue(TAG_CACHETAG2PSDEFNAME, "");
    }

    public final void setCACHETAG2PSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CACHETAG2PSDEFNAME, strValue);
    }

    public final boolean isORDERVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_ORDERVALUEPSDEFID);
    }

    public final String getORDERVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_ORDERVALUEPSDEFID, "");
    }

    public final void setORDERVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_ORDERVALUEPSDEFID, strValue);
    }

    public final boolean isORDERVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_ORDERVALUEPSDEFNAME);
    }

    public final String getORDERVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_ORDERVALUEPSDEFNAME, "");
    }

    public final void setORDERVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ORDERVALUEPSDEFNAME, strValue);
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

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isTIMEOUTNull() {
        return this.IsParamNull(TAG_TIMEOUT);
    }

    public final int getTIMEOUT() {
        return this.GetParamIntValue(TAG_TIMEOUT, 0);
    }

    public final void setTIMEOUT(int nValue) {
        this.SetParamValue(TAG_TIMEOUT, nValue);
    }

    public final boolean isCONTENTPSLANRESIDNull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESID);
    }

    public final String getCONTENTPSLANRESID() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESID, "");
    }

    public final void setCONTENTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESID, strValue);
    }

    public final boolean isCONTENTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CONTENTPSLANRESNAME);
    }

    public final String getCONTENTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CONTENTPSLANRESNAME, "");
    }

    public final void setCONTENTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTPSLANRESNAME, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isICONPSDEFIDNull() {
        return this.IsParamNull(TAG_ICONPSDEFID);
    }

    public final String getICONPSDEFID() {
        return this.GetParamStringValue(TAG_ICONPSDEFID, "");
    }

    public final void setICONPSDEFID(String strValue) {
        this.SetParamValue(TAG_ICONPSDEFID, strValue);
    }

    public final boolean isICONPSDEFNAMENull() {
        return this.IsParamNull(TAG_ICONPSDEFNAME);
    }

    public final String getICONPSDEFNAME() {
        return this.GetParamStringValue(TAG_ICONPSDEFNAME, "");
    }

    public final void setICONPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ICONPSDEFNAME, strValue);
    }

    public final boolean isCLSPSDEFIDNull() {
        return this.IsParamNull(TAG_CLSPSDEFID);
    }

    public final String getCLSPSDEFID() {
        return this.GetParamStringValue(TAG_CLSPSDEFID, "");
    }

    public final void setCLSPSDEFID(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFID, strValue);
    }

    public final boolean isCLSPSDEFNAMENull() {
        return this.IsParamNull(TAG_CLSPSDEFNAME);
    }

    public final String getCLSPSDEFNAME() {
        return this.GetParamStringValue(TAG_CLSPSDEFNAME, "");
    }

    public final void setCLSPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CLSPSDEFNAME, strValue);
    }

    public final boolean isVIEWMSGPARAMSNull() {
        return this.IsParamNull(TAG_VIEWMSGPARAMS);
    }

    public final String getVIEWMSGPARAMS() {
        return this.GetParamStringValue(TAG_VIEWMSGPARAMS, "");
    }

    public final void setVIEWMSGPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWMSGPARAMS, strValue);
    }

    public final boolean isVIEWMSGTAG2Null() {
        return this.IsParamNull(TAG_VIEWMSGTAG2);
    }

    public final String getVIEWMSGTAG2() {
        return this.GetParamStringValue(TAG_VIEWMSGTAG2, "");
    }

    public final void setVIEWMSGTAG2(String strValue) {
        this.SetParamValue(TAG_VIEWMSGTAG2, strValue);
    }

    public final boolean isVIEWMSGTAGNull() {
        return this.IsParamNull(TAG_VIEWMSGTAG);
    }

    public final String getVIEWMSGTAG() {
        return this.GetParamStringValue(TAG_VIEWMSGTAG, "");
    }

    public final void setVIEWMSGTAG(String strValue) {
        this.SetParamValue(TAG_VIEWMSGTAG, strValue);
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

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isENABLEMODENull() {
        return this.IsParamNull(TAG_ENABLEMODE);
    }

    public final String getENABLEMODE() {
        return this.GetParamStringValue(TAG_ENABLEMODE, "");
    }

    public final void setENABLEMODE(String strValue) {
        this.SetParamValue(TAG_ENABLEMODE, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isTESTCUSTOMCODENull() {
        return this.IsParamNull(TAG_TESTCUSTOMCODE);
    }

    public final String getTESTCUSTOMCODE() {
        return this.GetParamStringValue(TAG_TESTCUSTOMCODE, "");
    }

    public final void setTESTCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_TESTCUSTOMCODE, strValue);
    }

    public final boolean isTESTPSDELOGICIDNull() {
        return this.IsParamNull(TAG_TESTPSDELOGICID);
    }

    public final String getTESTPSDELOGICID() {
        return this.GetParamStringValue(TAG_TESTPSDELOGICID, "");
    }

    public final void setTESTPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_TESTPSDELOGICID, strValue);
    }

    public final boolean isTESTPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_TESTPSDELOGICNAME);
    }

    public final String getTESTPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_TESTPSDELOGICNAME, "");
    }

    public final void setTESTPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_TESTPSDELOGICNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public final boolean isCONTENTTYPEPSDEFIDNull() {
        return this.IsParamNull(TAG_CONTENTTYPEPSDEFID);
    }

    public final String getCONTENTTYPEPSDEFID() {
        return this.GetParamStringValue(TAG_CONTENTTYPEPSDEFID, "");
    }

    public final void setCONTENTTYPEPSDEFID(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPEPSDEFID, strValue);
    }

    public final boolean isCONTENTTYPEPSDEFNAMENull() {
        return this.IsParamNull(TAG_CONTENTTYPEPSDEFNAME);
    }

    public final String getCONTENTTYPEPSDEFNAME() {
        return this.GetParamStringValue(TAG_CONTENTTYPEPSDEFNAME, "");
    }

    public final void setCONTENTTYPEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPEPSDEFNAME, strValue);
    }
}

