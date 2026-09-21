/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysModelGroup
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
    public static final String TAG_PSSYSMODELGROUPID = "PSSYSMODELGROUPID";
    public static final String TAG_PSSYSMODELGROUPNAME = "PSSYSMODELGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_GROUPTAG = "GROUPTAG";
    public static final String TAG_GROUPTAG2 = "GROUPTAG2";
    public static final String TAG_GROUPTAG3 = "GROUPTAG3";
    public static final String TAG_GROUPTAG4 = "GROUPTAG4";
    public static final String TAG_PKGCODENAME = "PKGCODENAME";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_SYSMODELFROM = "SYSMODELFROM";
    public static final String TAG_PSSYSMODELREPOID = "PSSYSMODELREPOID";
    public static final String TAG_PSSYSMODELREPONAME = "PSSYSMODELREPONAME";
    public static final String TAG_PSDCSYSMODELREPOID = "PSDCSYSMODELREPOID";
    public static final String TAG_PSDCSYSMODELREPONAME = "PSDCSYSMODELREPONAME";
    public static final String TAG_SYNCMODE = "SYNCMODE";
    public static final String TAG_DYNAINSTMODE = "DYNAINSTMODE";
    public static final String TAG_DYNAINSTTAG = "DYNAINSTTAG";
    public static final String TAG_DYNAINSTTAG2 = "DYNAINSTTAG2";
    public static final String TAG_SFRTOBJECTREPO = "SFRTOBJECTREPO";
    public static final String TAG_PFRTOBJECTREPO = "PFRTOBJECTREPO";
    public static final String TAG_GROUPPARAMS = "GROUPPARAMS";
    public static final String TAG_DTOFORMAT = "DTOFORMAT";
    public static final String TAG_CODENAMEMODE = "CODENAMEMODE";
    public static final String TAG_ENABLEPQL = "ENABLEPQL";
    public static final String TAG_RUNTIMETYPE = "RUNTIMETYPE";

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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
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

    public final boolean isGROUPTAGNull() {
        return this.IsParamNull(TAG_GROUPTAG);
    }

    public final String getGROUPTAG() {
        return this.GetParamStringValue(TAG_GROUPTAG, "");
    }

    public final void setGROUPTAG(String strValue) {
        this.SetParamValue(TAG_GROUPTAG, strValue);
    }

    public final boolean isGROUPTAG2Null() {
        return this.IsParamNull(TAG_GROUPTAG2);
    }

    public final String getGROUPTAG2() {
        return this.GetParamStringValue(TAG_GROUPTAG2, "");
    }

    public final void setGROUPTAG2(String strValue) {
        this.SetParamValue(TAG_GROUPTAG2, strValue);
    }

    public final boolean isPKGCODENAMENull() {
        return this.IsParamNull(TAG_PKGCODENAME);
    }

    public final String getPKGCODENAME() {
        return this.GetParamStringValue(TAG_PKGCODENAME, "");
    }

    public final void setPKGCODENAME(String strValue) {
        this.SetParamValue(TAG_PKGCODENAME, strValue);
    }

    public final boolean isCLSPKGPARAMSNull() {
        return this.IsParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.GetParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.SetParamValue(TAG_CLSPKGPARAMS, strValue);
    }

    public final boolean isSYSMODELFROMNull() {
        return this.IsParamNull(TAG_SYSMODELFROM);
    }

    public final String getSYSMODELFROM() {
        return this.GetParamStringValue(TAG_SYSMODELFROM, "");
    }

    public final void setSYSMODELFROM(String strValue) {
        this.SetParamValue(TAG_SYSMODELFROM, strValue);
    }

    public final boolean isPSSYSMODELREPOIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELREPOID);
    }

    public final String getPSSYSMODELREPOID() {
        return this.GetParamStringValue(TAG_PSSYSMODELREPOID, "");
    }

    public final void setPSSYSMODELREPOID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELREPOID, strValue);
    }

    public final boolean isPSSYSMODELREPONAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELREPONAME);
    }

    public final String getPSSYSMODELREPONAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELREPONAME, "");
    }

    public final void setPSSYSMODELREPONAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELREPONAME, strValue);
    }

    public final boolean isPSDCSYSMODELREPOIDNull() {
        return this.IsParamNull(TAG_PSDCSYSMODELREPOID);
    }

    public final String getPSDCSYSMODELREPOID() {
        return this.GetParamStringValue(TAG_PSDCSYSMODELREPOID, "");
    }

    public final void setPSDCSYSMODELREPOID(String strValue) {
        this.SetParamValue(TAG_PSDCSYSMODELREPOID, strValue);
    }

    public final boolean isPSDCSYSMODELREPONAMENull() {
        return this.IsParamNull(TAG_PSDCSYSMODELREPONAME);
    }

    public final String getPSDCSYSMODELREPONAME() {
        return this.GetParamStringValue(TAG_PSDCSYSMODELREPONAME, "");
    }

    public final void setPSDCSYSMODELREPONAME(String strValue) {
        this.SetParamValue(TAG_PSDCSYSMODELREPONAME, strValue);
    }

    public final boolean isSYNCMODENull() {
        return this.IsParamNull(TAG_SYNCMODE);
    }

    public final String getSYNCMODE() {
        return this.GetParamStringValue(TAG_SYNCMODE, "");
    }

    public final void setSYNCMODE(String strValue) {
        this.SetParamValue(TAG_SYNCMODE, strValue);
    }

    public final boolean isDYNAINSTMODENull() {
        return this.IsParamNull(TAG_DYNAINSTMODE);
    }

    public final int getDYNAINSTMODE() {
        return this.GetParamIntValue(TAG_DYNAINSTMODE, 0);
    }

    public final void setDYNAINSTMODE(int nValue) {
        this.SetParamValue(TAG_DYNAINSTMODE, nValue);
    }

    public final boolean isDYNAINSTTAGNull() {
        return this.IsParamNull(TAG_DYNAINSTTAG);
    }

    public final String getDYNAINSTTAG() {
        return this.GetParamStringValue(TAG_DYNAINSTTAG, "");
    }

    public final void setDYNAINSTTAG(String strValue) {
        this.SetParamValue(TAG_DYNAINSTTAG, strValue);
    }

    public final boolean isDYNAINSTTAG2Null() {
        return this.IsParamNull(TAG_DYNAINSTTAG2);
    }

    public final String getDYNAINSTTAG2() {
        return this.GetParamStringValue(TAG_DYNAINSTTAG2, "");
    }

    public final void setDYNAINSTTAG2(String strValue) {
        this.SetParamValue(TAG_DYNAINSTTAG2, strValue);
    }

    public final boolean isSFRTOBJECTREPONull() {
        return this.IsParamNull(TAG_SFRTOBJECTREPO);
    }

    public final String getSFRTOBJECTREPO() {
        return this.GetParamStringValue(TAG_SFRTOBJECTREPO, "");
    }

    public final void setSFRTOBJECTREPO(String strValue) {
        this.SetParamValue(TAG_SFRTOBJECTREPO, strValue);
    }

    public final boolean isPFRTOBJECTREPONull() {
        return this.IsParamNull(TAG_PFRTOBJECTREPO);
    }

    public final String getPFRTOBJECTREPO() {
        return this.GetParamStringValue(TAG_PFRTOBJECTREPO, "");
    }

    public final void setPFRTOBJECTREPO(String strValue) {
        this.SetParamValue(TAG_PFRTOBJECTREPO, strValue);
    }

    public final String getGROUPTAG3() {
        return this.GetParamStringValue(TAG_GROUPTAG3, "");
    }

    public final void setGROUPTAG3(String strValue) {
        this.SetParamValue(TAG_GROUPTAG3, strValue);
    }

    public final boolean isGROUPTAG4Null() {
        return this.IsParamNull(TAG_GROUPTAG4);
    }

    public final String getGROUPTAG4() {
        return this.GetParamStringValue(TAG_GROUPTAG4, "");
    }

    public final void setGROUPTAG4(String strValue) {
        this.SetParamValue(TAG_GROUPTAG4, strValue);
    }

    public final boolean isGROUPPARAMSNull() {
        return this.IsParamNull(TAG_GROUPPARAMS);
    }

    public final String getGROUPPARAMS() {
        return this.GetParamStringValue(TAG_GROUPPARAMS, "");
    }

    public final void setGROUPPARAMS(String strValue) {
        this.SetParamValue(TAG_GROUPPARAMS, strValue);
    }

    public final boolean isDTOFORMATNull() {
        return this.IsParamNull(TAG_DTOFORMAT);
    }

    public final String getDTOFORMAT() {
        return this.GetParamStringValue(TAG_DTOFORMAT, "");
    }

    public final void setDTOFORMAT(String strValue) {
        this.SetParamValue(TAG_DTOFORMAT, strValue);
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

    public final boolean isENABLEPQLNull() {
        return this.IsParamNull(TAG_ENABLEPQL);
    }

    public final boolean getENABLEPQL() {
        return this.GetParamIntValue(TAG_ENABLEPQL, 0) == 1;
    }

    public final void setENABLEPQL(boolean bValue) {
        this.SetParamValue(TAG_ENABLEPQL, bValue ? 1 : 0);
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

