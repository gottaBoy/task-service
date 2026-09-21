/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSFPlugin
extends BaseDataEntity {
    public static final String PLUGINTYPE_STRFUNC = "STRFUNC";
    public static final String PLUGINTYPE_MATHFUNC = "MATHFUNC";
    public static final String PLUGINTYPE_DOCFUNC = "DOCFUNC";
    public static final String PLUGINTYPE_USER = "USER";
    public static final int RTOBJECTMODE_NO = 0;
    public static final int RTOBJECTMODE_LOCAL = 1;
    public static final int RTOBJECTMODE_REMOTE = 2;
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSFPLUGINID = "PSSFPLUGINID";
    public static final String TAG_PSSFPLUGINNAME = "PSSFPLUGINNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PLUGINTYPE = "PLUGINTYPE";
    public static final String TAG_KEYWORDS = "KEYWORDS";
    public static final String TAG_PSSYSSFPITEMPLSCNT = "PSSYSSFPITEMPLSCNT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PLUGINMODEL = "PLUGINMODEL";
    public static final String TAG_PLUGINPARAMS = "PLUGINPARAMS";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_REPDEFAULT = "REPDEFAULT";
    public static final String TAG_RTOBJECTMODE = "RTOBJECTMODE";
    public static final String TAG_RTOBJECTNAME = "RTOBJECTNAME";
    public static final String TAG_RTOBJECTREPO = "RTOBJECTREPO";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PLUGINTAG2 = "PLUGINTAG2";
    public static final String TAG_PLUGINTAG = "PLUGINTAG";
    public static final String TAG_SINGLEINSTMODE = "SINGLEINSTMODE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String TAG_TEMPLATEFUNC = "TEMPLATEFUNC";
    public static final String TAG_RUNTIMETYPE = "RUNTIMETYPE";

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

    public final boolean isPSSFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSFPLUGINID);
    }

    public final String getPSSFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSFPLUGINID, "");
    }

    public final void setPSSFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSFPLUGINID, strValue);
    }

    public final boolean isPSSFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSFPLUGINNAME);
    }

    public final String getPSSFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSFPLUGINNAME, "");
    }

    public final void setPSSFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPLUGINNAME, strValue);
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

    public final boolean isPLUGINTYPENull() {
        return this.IsParamNull(TAG_PLUGINTYPE);
    }

    public final String getPLUGINTYPE() {
        return this.GetParamStringValue(TAG_PLUGINTYPE, "");
    }

    public final void setPLUGINTYPE(String strValue) {
        this.SetParamValue(TAG_PLUGINTYPE, strValue);
    }

    public final boolean isKEYWORDSNull() {
        return this.IsParamNull(TAG_KEYWORDS);
    }

    public final String getKEYWORDS() {
        return this.GetParamStringValue(TAG_KEYWORDS, "");
    }

    public final void setKEYWORDS(String strValue) {
        this.SetParamValue(TAG_KEYWORDS, strValue);
    }

    public final boolean isPSSYSSFPITEMPLSCNTNull() {
        return this.IsParamNull(TAG_PSSYSSFPITEMPLSCNT);
    }

    public final int getPSSYSSFPITEMPLSCNT() {
        return this.GetParamIntValue(TAG_PSSYSSFPITEMPLSCNT, 0);
    }

    public final void setPSSYSSFPITEMPLSCNT(int nValue) {
        this.SetParamValue(TAG_PSSYSSFPITEMPLSCNT, nValue);
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

    public final boolean isPLUGINMODELNull() {
        return this.IsParamNull(TAG_PLUGINMODEL);
    }

    public final String getPLUGINMODEL() {
        return this.GetParamStringValue(TAG_PLUGINMODEL, "");
    }

    public final void setPLUGINMODEL(String strValue) {
        this.SetParamValue(TAG_PLUGINMODEL, strValue);
    }

    public final boolean isPLUGINPARAMSNull() {
        return this.IsParamNull(TAG_PLUGINPARAMS);
    }

    public final String getPLUGINPARAMS() {
        return this.GetParamStringValue(TAG_PLUGINPARAMS, "");
    }

    public final void setPLUGINPARAMS(String strValue) {
        this.SetParamValue(TAG_PLUGINPARAMS, strValue);
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

    public final boolean isREPDEFAULTNull() {
        return this.IsParamNull(TAG_REPDEFAULT);
    }

    public final boolean getREPDEFAULT() {
        return this.GetParamIntValue(TAG_REPDEFAULT, 0) == 1;
    }

    public final void setREPDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_REPDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isRTOBJECTMODENull() {
        return this.IsParamNull(TAG_RTOBJECTMODE);
    }

    public final int getRTOBJECTMODE() {
        return this.GetParamIntValue(TAG_RTOBJECTMODE, 0);
    }

    public final void setRTOBJECTMODE(int nValue) {
        this.SetParamValue(TAG_RTOBJECTMODE, nValue);
    }

    public final boolean isRTOBJECTNAMENull() {
        return this.IsParamNull(TAG_RTOBJECTNAME);
    }

    public final String getRTOBJECTNAME() {
        return this.GetParamStringValue(TAG_RTOBJECTNAME, "");
    }

    public final void setRTOBJECTNAME(String strValue) {
        this.SetParamValue(TAG_RTOBJECTNAME, strValue);
    }

    public final boolean isRTOBJECTREPONull() {
        return this.IsParamNull(TAG_RTOBJECTREPO);
    }

    public final String getRTOBJECTREPO() {
        return this.GetParamStringValue(TAG_RTOBJECTREPO, "");
    }

    public final void setRTOBJECTREPO(String strValue) {
        this.SetParamValue(TAG_RTOBJECTREPO, strValue);
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

    public final boolean isPLUGINTAG2Null() {
        return this.IsParamNull(TAG_PLUGINTAG2);
    }

    public final String getPLUGINTAG2() {
        return this.GetParamStringValue(TAG_PLUGINTAG2, "");
    }

    public final void setPLUGINTAG2(String strValue) {
        this.SetParamValue(TAG_PLUGINTAG2, strValue);
    }

    public final boolean isPLUGINTAGNull() {
        return this.IsParamNull(TAG_PLUGINTAG);
    }

    public final String getPLUGINTAG() {
        return this.GetParamStringValue(TAG_PLUGINTAG, "");
    }

    public final void setPLUGINTAG(String strValue) {
        this.SetParamValue(TAG_PLUGINTAG, strValue);
    }

    public final boolean isSINGLEINSTMODENull() {
        return this.IsParamNull(TAG_SINGLEINSTMODE);
    }

    public final boolean getSINGLEINSTMODE() {
        return this.GetParamIntValue(TAG_SINGLEINSTMODE, 0) == 1;
    }

    public final void setSINGLEINSTMODE(boolean bValue) {
        this.SetParamValue(TAG_SINGLEINSTMODE, bValue ? 1 : 0);
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

    public final boolean isTEMPLATEMODENull() {
        return this.IsParamNull(TAG_TEMPLATEMODE);
    }

    public final int getTEMPLATEMODE() {
        return this.GetParamIntValue(TAG_TEMPLATEMODE, 0);
    }

    public final void setTEMPLATEMODE(int nValue) {
        this.SetParamValue(TAG_TEMPLATEMODE, nValue);
    }

    public final boolean isTEMPLATEFUNCNull() {
        return this.IsParamNull(TAG_TEMPLATEFUNC);
    }

    public final String getTEMPLATEFUNC() {
        return this.GetParamStringValue(TAG_TEMPLATEFUNC, "");
    }

    public final void setTEMPLATEFUNC(String strValue) {
        this.SetParamValue(TAG_TEMPLATEFUNC, strValue);
    }

    public final boolean isRUNTIMETYPENull() {
        return this.IsParamNull(TAG_RUNTIMETYPE);
    }

    public final String getRUNTIMETYPE() {
        return this.GetParamStringValue(TAG_RUNTIMETYPE, "");
    }

    public final void setRUNTIMETYPE(String strValue) {
        this.SetParamValue(TAG_RUNTIMETYPE, strValue);
    }
}

