/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysResource
extends BaseDataEntity {
    public static final String RESOURCETYPE_IMAGE = "IMAGE";
    public static final String RESOURCETYPE_STRING = "STRING";
    public static final String RESOURCETYPE_USER = "USER";
    public static final String RESOURCETYPE_USER2 = "USER2";
    public static final String RESOURCETYPE_USER3 = "USER3";
    public static final String RESOURCETYPE_USER4 = "USER4";
    public static final String RESOURCETYPE_USER5 = "USER5";
    public static final String RESOURCETYPE_USER6 = "USER6";
    public static final String RESOURCETYPE_USER7 = "USER7";
    public static final String RESOURCETYPE_USER8 = "USER8";
    public static final String RESOURCETYPE_USER9 = "USER9";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String TAG_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_RESTAG = "RESTAG";
    public static final String TAG_RESOURCETYPE = "RESOURCETYPE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CONTENTPSLANRESID = "CONTENTPSLANRESID";
    public static final String TAG_CONTENTPSLANRESNAME = "CONTENTPSLANRESNAME";
    public static final String TAG_RESOURCEURI = "RESOURCEURI";
    public static final String TAG_AUTHACCESSTOKENURI = "AUTHACCESSTOKENURI";
    public static final String TAG_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String TAG_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String TAG_AUTHMODE = "AUTHMODE";
    public static final String TAG_AUTHPARAM = "AUTHPARAM";
    public static final String TAG_AUTHPARAM2 = "AUTHPARAM2";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_RESOURCEPARAMS = "RESOURCEPARAMS";
    public static final String TAG_PSSYSCONTENTCATID = "PSSYSCONTENTCATID";
    public static final String TAG_PSSYSCONTENTCATNAME = "PSSYSCONTENTCATNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_CONTENTPSDEFID = "CONTENTPSDEFID";
    public static final String TAG_CONTENTPSDEFNAME = "CONTENTPSDEFNAME";
    public static final String TAG_NAMEPSDEFID = "NAMEPSDEFID";
    public static final String TAG_NAMEPSDEFNAME = "NAMEPSDEFNAME";
    public static final String TAG_PATHPSDEFID = "PATHPSDEFID";
    public static final String TAG_PATHPSDEFNAME = "PATHPSDEFNAME";
    public static final String TAG_USER2PSDEFID = "USER2PSDEFID";
    public static final String TAG_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String TAG_USERPSDEFID = "USERPSDEFID";
    public static final String TAG_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String TAG_TAGPSDEFID = "TAGPSDEFID";
    public static final String TAG_TAGPSDEFNAME = "TAGPSDEFNAME";

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

    public final boolean isCONTENTNull() {
        return this.IsParamNull(TAG_CONTENT);
    }

    public final String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public final void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public final boolean isRESTAGNull() {
        return this.IsParamNull(TAG_RESTAG);
    }

    public final String getRESTAG() {
        return this.GetParamStringValue(TAG_RESTAG, "");
    }

    public final void setRESTAG(String strValue) {
        this.SetParamValue(TAG_RESTAG, strValue);
    }

    public final boolean isRESOURCETYPENull() {
        return this.IsParamNull(TAG_RESOURCETYPE);
    }

    public final String getRESOURCETYPE() {
        return this.GetParamStringValue(TAG_RESOURCETYPE, "");
    }

    public final void setRESOURCETYPE(String strValue) {
        this.SetParamValue(TAG_RESOURCETYPE, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isRESOURCEURINull() {
        return this.IsParamNull(TAG_RESOURCEURI);
    }

    public final String getRESOURCEURI() {
        return this.GetParamStringValue(TAG_RESOURCEURI, "");
    }

    public final void setRESOURCEURI(String strValue) {
        this.SetParamValue(TAG_RESOURCEURI, strValue);
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

    public final boolean isAUTHMODENull() {
        return this.IsParamNull(TAG_AUTHMODE);
    }

    public final String getAUTHMODE() {
        return this.GetParamStringValue(TAG_AUTHMODE, "");
    }

    public final void setAUTHMODE(String strValue) {
        this.SetParamValue(TAG_AUTHMODE, strValue);
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

    public final boolean isAUTHPARAM2Null() {
        return this.IsParamNull(TAG_AUTHPARAM2);
    }

    public final String getAUTHPARAM2() {
        return this.GetParamStringValue(TAG_AUTHPARAM2, "");
    }

    public final void setAUTHPARAM2(String strValue) {
        this.SetParamValue(TAG_AUTHPARAM2, strValue);
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

    public final boolean isRESOURCEPARAMSNull() {
        return this.IsParamNull(TAG_RESOURCEPARAMS);
    }

    public final String getRESOURCEPARAMS() {
        return this.GetParamStringValue(TAG_RESOURCEPARAMS, "");
    }

    public final void setRESOURCEPARAMS(String strValue) {
        this.SetParamValue(TAG_RESOURCEPARAMS, strValue);
    }

    public final boolean isPSSYSCONTENTCATIDNull() {
        return this.IsParamNull(TAG_PSSYSCONTENTCATID);
    }

    public final String getPSSYSCONTENTCATID() {
        return this.GetParamStringValue(TAG_PSSYSCONTENTCATID, "");
    }

    public final void setPSSYSCONTENTCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSCONTENTCATID, strValue);
    }

    public final boolean isPSSYSCONTENTCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSCONTENTCATNAME);
    }

    public final String getPSSYSCONTENTCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSCONTENTCATNAME, "");
    }

    public final void setPSSYSCONTENTCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCONTENTCATNAME, strValue);
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

    public final boolean isNAMEPSDEFIDNull() {
        return this.IsParamNull(TAG_NAMEPSDEFID);
    }

    public final String getNAMEPSDEFID() {
        return this.GetParamStringValue(TAG_NAMEPSDEFID, "");
    }

    public final void setNAMEPSDEFID(String strValue) {
        this.SetParamValue(TAG_NAMEPSDEFID, strValue);
    }

    public final boolean isNAMEPSDEFNAMENull() {
        return this.IsParamNull(TAG_NAMEPSDEFNAME);
    }

    public final String getNAMEPSDEFNAME() {
        return this.GetParamStringValue(TAG_NAMEPSDEFNAME, "");
    }

    public final void setNAMEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_NAMEPSDEFNAME, strValue);
    }

    public final boolean isPATHPSDEFIDNull() {
        return this.IsParamNull(TAG_PATHPSDEFID);
    }

    public final String getPATHPSDEFID() {
        return this.GetParamStringValue(TAG_PATHPSDEFID, "");
    }

    public final void setPATHPSDEFID(String strValue) {
        this.SetParamValue(TAG_PATHPSDEFID, strValue);
    }

    public final boolean isPATHPSDEFNAMENull() {
        return this.IsParamNull(TAG_PATHPSDEFNAME);
    }

    public final String getPATHPSDEFNAME() {
        return this.GetParamStringValue(TAG_PATHPSDEFNAME, "");
    }

    public final void setPATHPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PATHPSDEFNAME, strValue);
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
}

