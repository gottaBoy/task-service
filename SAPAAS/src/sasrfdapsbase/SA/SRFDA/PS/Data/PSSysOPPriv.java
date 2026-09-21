/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysOPPriv
extends BaseDataEntity {
    public static final String PRIVTYPE_CUSTOM = "CUSTOM";
    public static final String PRIVTYPE_DEDATASET = "DEDATASET";
    public static final String DEFAULTMODE_NONE = "NONE";
    public static final String DEFAULTMODE_USER = "USER";
    public static final String DEFAULTMODE_ADMIN = "ADMIN";
    public static final String TAG_PSSYSOPPRIVID = "PSSYSOPPRIVID";
    public static final String TAG_PSSYSOPPRIVNAME = "PSSYSOPPRIVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PRIVID = "PRIVID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PRIVTYPE = "PRIVTYPE";
    public static final String TAG_DEOPPRIV = "DEOPPRIV";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERROLESN = "USERROLESN";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_ORGDR = "ORGDR";
    public static final String TAG_SECDR = "SECDR";
    public static final String TAG_SYSUSERDR2PARAM = "SYSUSERDR2PARAM";
    public static final String TAG_SYSUSERDRPARAM = "SYSUSERDRPARAM";
    public static final String TAG_ENABLEORGDR = "ENABLEORGDR";
    public static final String TAG_ENABLESECDR = "ENABLESECDR";
    public static final String TAG_ENABLEUSERDR = "ENABLEUSERDR";
    public static final String TAG_PSSYSUSERDRID = "PSSYSUSERDRID";
    public static final String TAG_PSSYSUSERDRNAME = "PSSYSUSERDRNAME";
    public static final String TAG_PSSYSUSERDRID2 = "PSSYSUSERDRID2";
    public static final String TAG_PSSYSUSERDRNAME2 = "PSSYSUSERDRNAME2";
    public static final String TAG_ENABLESECBC = "ENABLESECBC";
    public static final String TAG_SECBC = "SECBC";
    public static final String TAG_DEFAULTMODE = "DEFAULTMODE";
    public static final String TAG_SYSTEMFLAG = "SYSTEMFLAG";
    public static final String TAG_GLOBALFLAG = "GLOBALFLAG";
    public static final String TAG_USERIDPSDEFID = "USERIDPSDEFID";
    public static final String TAG_USERIDPSDEFNAME = "USERIDPSDEFNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_ROLETAGPSDEFID = "ROLETAGPSDEFID";
    public static final String TAG_ROLETAGPSDEFNAME = "ROLETAGPSDEFNAME";

    public final boolean isPSSYSOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSSYSOPPRIVID);
    }

    public final String getPSSYSOPPRIVID() {
        return this.GetParamStringValue(TAG_PSSYSOPPRIVID, "");
    }

    public final void setPSSYSOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSSYSOPPRIVID, strValue);
    }

    public final boolean isPSSYSOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSSYSOPPRIVNAME);
    }

    public final String getPSSYSOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSSYSOPPRIVNAME, "");
    }

    public final void setPSSYSOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSOPPRIVNAME, strValue);
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

    public final boolean isPRIVIDNull() {
        return this.IsParamNull(TAG_PRIVID);
    }

    public final String getPRIVID() {
        return this.GetParamStringValue(TAG_PRIVID, "");
    }

    public final void setPRIVID(String strValue) {
        this.SetParamValue(TAG_PRIVID, strValue);
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

    public final boolean isPRIVTYPENull() {
        return this.IsParamNull(TAG_PRIVTYPE);
    }

    public final String getPRIVTYPE() {
        return this.GetParamStringValue(TAG_PRIVTYPE, "");
    }

    public final void setPRIVTYPE(String strValue) {
        this.SetParamValue(TAG_PRIVTYPE, strValue);
    }

    public final boolean isDEOPPRIVNull() {
        return this.IsParamNull(TAG_DEOPPRIV);
    }

    public final String getDEOPPRIV() {
        return this.GetParamStringValue(TAG_DEOPPRIV, "");
    }

    public final void setDEOPPRIV(String strValue) {
        this.SetParamValue(TAG_DEOPPRIV, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
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

    public final boolean isUSERROLESNNull() {
        return this.IsParamNull(TAG_USERROLESN);
    }

    public final String getUSERROLESN() {
        return this.GetParamStringValue(TAG_USERROLESN, "");
    }

    public final void setUSERROLESN(String strValue) {
        this.SetParamValue(TAG_USERROLESN, strValue);
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

    public final boolean isORGDRNull() {
        return this.IsParamNull(TAG_ORGDR);
    }

    public final int getORGDR() {
        return this.GetParamIntValue(TAG_ORGDR, 0);
    }

    public final void setORGDR(int nValue) {
        this.SetParamValue(TAG_ORGDR, nValue);
    }

    public final boolean isSECDRNull() {
        return this.IsParamNull(TAG_SECDR);
    }

    public final int getSECDR() {
        return this.GetParamIntValue(TAG_SECDR, 0);
    }

    public final void setSECDR(int nValue) {
        this.SetParamValue(TAG_SECDR, nValue);
    }

    public final boolean isSYSUSERDR2PARAMNull() {
        return this.IsParamNull(TAG_SYSUSERDR2PARAM);
    }

    public final String getSYSUSERDR2PARAM() {
        return this.GetParamStringValue(TAG_SYSUSERDR2PARAM, "");
    }

    public final void setSYSUSERDR2PARAM(String strValue) {
        this.SetParamValue(TAG_SYSUSERDR2PARAM, strValue);
    }

    public final boolean isSYSUSERDRPARAMNull() {
        return this.IsParamNull(TAG_SYSUSERDRPARAM);
    }

    public final String getSYSUSERDRPARAM() {
        return this.GetParamStringValue(TAG_SYSUSERDRPARAM, "");
    }

    public final void setSYSUSERDRPARAM(String strValue) {
        this.SetParamValue(TAG_SYSUSERDRPARAM, strValue);
    }

    public final boolean isENABLEORGDRNull() {
        return this.IsParamNull(TAG_ENABLEORGDR);
    }

    public final boolean getENABLEORGDR() {
        return this.GetParamIntValue(TAG_ENABLEORGDR, 0) == 1;
    }

    public final void setENABLEORGDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEORGDR, bValue ? 1 : 0);
    }

    public final boolean isENABLESECDRNull() {
        return this.IsParamNull(TAG_ENABLESECDR);
    }

    public final boolean getENABLESECDR() {
        return this.GetParamIntValue(TAG_ENABLESECDR, 0) == 1;
    }

    public final void setENABLESECDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLESECDR, bValue ? 1 : 0);
    }

    public final boolean isENABLEUSERDRNull() {
        return this.IsParamNull(TAG_ENABLEUSERDR);
    }

    public final boolean getENABLEUSERDR() {
        return this.GetParamIntValue(TAG_ENABLEUSERDR, 0) == 1;
    }

    public final void setENABLEUSERDR(boolean bValue) {
        this.SetParamValue(TAG_ENABLEUSERDR, bValue ? 1 : 0);
    }

    public final boolean isPSSYSUSERDRIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERDRID);
    }

    public final String getPSSYSUSERDRID() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRID, "");
    }

    public final void setPSSYSUSERDRID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRID, strValue);
    }

    public final boolean isPSSYSUSERDRNAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERDRNAME);
    }

    public final String getPSSYSUSERDRNAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRNAME, "");
    }

    public final void setPSSYSUSERDRNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRNAME, strValue);
    }

    public final boolean isPSSYSUSERDRID2Null() {
        return this.IsParamNull(TAG_PSSYSUSERDRID2);
    }

    public final String getPSSYSUSERDRID2() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRID2, "");
    }

    public final void setPSSYSUSERDRID2(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRID2, strValue);
    }

    public final boolean isPSSYSUSERDRNAME2Null() {
        return this.IsParamNull(TAG_PSSYSUSERDRNAME2);
    }

    public final String getPSSYSUSERDRNAME2() {
        return this.GetParamStringValue(TAG_PSSYSUSERDRNAME2, "");
    }

    public final void setPSSYSUSERDRNAME2(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERDRNAME2, strValue);
    }

    public final boolean isENABLESECBCNull() {
        return this.IsParamNull(TAG_ENABLESECBC);
    }

    public final boolean getENABLESECBC() {
        return this.GetParamIntValue(TAG_ENABLESECBC, 0) == 1;
    }

    public final void setENABLESECBC(boolean bValue) {
        this.SetParamValue(TAG_ENABLESECBC, bValue ? 1 : 0);
    }

    public final boolean isSECBCNull() {
        return this.IsParamNull(TAG_SECBC);
    }

    public final String getSECBC() {
        return this.GetParamStringValue(TAG_SECBC, "");
    }

    public final void setSECBC(String strValue) {
        this.SetParamValue(TAG_SECBC, strValue);
    }

    public final boolean isDEFAULTMODENull() {
        return this.IsParamNull(TAG_DEFAULTMODE);
    }

    public final String getDEFAULTMODE() {
        return this.GetParamStringValue(TAG_DEFAULTMODE, "");
    }

    public final void setDEFAULTMODE(String strValue) {
        this.SetParamValue(TAG_DEFAULTMODE, strValue);
    }

    public final boolean isSYSTEMFLAGNull() {
        return this.IsParamNull(TAG_SYSTEMFLAG);
    }

    public final boolean getSYSTEMFLAG() {
        return this.GetParamIntValue(TAG_SYSTEMFLAG, 0) == 1;
    }

    public final void setSYSTEMFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSTEMFLAG, bValue ? 1 : 0);
    }

    public final boolean isGLOBALFLAGNull() {
        return this.IsParamNull(TAG_GLOBALFLAG);
    }

    public final boolean getGLOBALFLAG() {
        return this.GetParamIntValue(TAG_GLOBALFLAG, 0) == 1;
    }

    public final void setGLOBALFLAG(boolean bValue) {
        this.SetParamValue(TAG_GLOBALFLAG, bValue ? 1 : 0);
    }

    public final boolean isUSERIDPSDEFIDNull() {
        return this.IsParamNull(TAG_USERIDPSDEFID);
    }

    public final String getUSERIDPSDEFID() {
        return this.GetParamStringValue(TAG_USERIDPSDEFID, "");
    }

    public final void setUSERIDPSDEFID(String strValue) {
        this.SetParamValue(TAG_USERIDPSDEFID, strValue);
    }

    public final boolean isUSERIDPSDEFNAMENull() {
        return this.IsParamNull(TAG_USERIDPSDEFNAME);
    }

    public final String getUSERIDPSDEFNAME() {
        return this.GetParamStringValue(TAG_USERIDPSDEFNAME, "");
    }

    public final void setUSERIDPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_USERIDPSDEFNAME, strValue);
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

    public final boolean isROLETAGPSDEFIDNull() {
        return this.IsParamNull(TAG_ROLETAGPSDEFID);
    }

    public final String getROLETAGPSDEFID() {
        return this.GetParamStringValue(TAG_ROLETAGPSDEFID, "");
    }

    public final void setROLETAGPSDEFID(String strValue) {
        this.SetParamValue(TAG_ROLETAGPSDEFID, strValue);
    }

    public final boolean isROLETAGPSDEFNAMENull() {
        return this.IsParamNull(TAG_ROLETAGPSDEFNAME);
    }

    public final String getROLETAGPSDEFNAME() {
        return this.GetParamStringValue(TAG_ROLETAGPSDEFNAME, "");
    }

    public final void setROLETAGPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_ROLETAGPSDEFNAME, strValue);
    }
}

