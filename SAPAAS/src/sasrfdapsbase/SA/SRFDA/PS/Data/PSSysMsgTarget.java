/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysMsgTarget
extends BaseDataEntity {
    public static final String MSGTARGETTYPE_RUNTIME = "RUNTIME";
    public static final String MSGTARGETTYPE_DE = "DE";
    public static final String MSGTARGETTYPE_USER = "USER";
    public static final String MSGTARGETTYPE_USER2 = "USER2";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSMSGTARGETID = "PSSYSMSGTARGETID";
    public static final String TAG_PSSYSMSGTARGETNAME = "PSSYSMSGTARGETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String TAG_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MSGTARGETTAG = "MSGTARGETTAG";
    public static final String TAG_MSGTARGETTAG2 = "MSGTARGETTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_MSGTARGETTYPE = "MSGTARGETTYPE";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEDSID = "PSDEDSID";
    public static final String TAG_PSDEDSNAME = "PSDEDSNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_TARGETPSDEFID = "TARGETPSDEFID";
    public static final String TAG_TARGETPSDEFNAME = "TARGETPSDEFNAME";
    public static final String TAG_TARGETTYPEPSDEFID = "TARGETTYPEPSDEFID";
    public static final String TAG_TARGETTYPEPSDEFNAME = "TARGETTYPEPSDEFNAME";
    public static final String TAG_PSSYSUTILDEID = "PSSYSUTILDEID";
    public static final String TAG_PSSYSUTILDENAME = "PSSYSUTILDENAME";
    public static final String TAG_USER2PSDEFID = "USER2PSDEFID";
    public static final String TAG_USER2PSDEFNAME = "USER2PSDEFNAME";
    public static final String TAG_USERPSDEFID = "USERPSDEFID";
    public static final String TAG_USERPSDEFNAME = "USERPSDEFNAME";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_CUSTOMMODE = "CUSTOMMODE";
    public static final String TAG_MSGTARGETPARAMS = "MSGTARGETPARAMS";

    public final boolean isPSSYSMSGTARGETIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTARGETID);
    }

    public final String getPSSYSMSGTARGETID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTARGETID, "");
    }

    public final void setPSSYSMSGTARGETID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTARGETID, strValue);
    }

    public final boolean isPSSYSMSGTARGETNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTARGETNAME);
    }

    public final String getPSSYSMSGTARGETNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTARGETNAME, "");
    }

    public final void setPSSYSMSGTARGETNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTARGETNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMSGTARGETTAGNull() {
        return this.IsParamNull(TAG_MSGTARGETTAG);
    }

    public final String getMSGTARGETTAG() {
        return this.GetParamStringValue(TAG_MSGTARGETTAG, "");
    }

    public final void setMSGTARGETTAG(String strValue) {
        this.SetParamValue(TAG_MSGTARGETTAG, strValue);
    }

    public final boolean isMSGTARGETTAG2Null() {
        return this.IsParamNull(TAG_MSGTARGETTAG2);
    }

    public final String getMSGTARGETTAG2() {
        return this.GetParamStringValue(TAG_MSGTARGETTAG2, "");
    }

    public final void setMSGTARGETTAG2(String strValue) {
        this.SetParamValue(TAG_MSGTARGETTAG2, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isMSGTARGETTYPENull() {
        return this.IsParamNull(TAG_MSGTARGETTYPE);
    }

    public final String getMSGTARGETTYPE() {
        return this.GetParamStringValue(TAG_MSGTARGETTYPE, "");
    }

    public final void setMSGTARGETTYPE(String strValue) {
        this.SetParamValue(TAG_MSGTARGETTYPE, strValue);
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

    public final boolean isMSGTARGETPARAMSNull() {
        return this.IsParamNull(TAG_MSGTARGETPARAMS);
    }

    public final String getMSGTARGETPARAMS() {
        return this.GetParamStringValue(TAG_MSGTARGETPARAMS, "");
    }

    public final void setMSGTARGETPARAMS(String strValue) {
        this.SetParamValue(TAG_MSGTARGETPARAMS, strValue);
    }
}

