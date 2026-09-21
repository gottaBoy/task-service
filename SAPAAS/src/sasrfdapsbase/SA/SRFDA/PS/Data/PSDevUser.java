/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevUser
extends BaseDataEntity {
    public static final String PSDEVUSEROBJTYPE_USER = "USER";
    public static final String PSDEVUSEROBJTYPE_USERGROUP = "USERGROUP";
    public static final String VALIDFLAG_1 = "1";
    public static final String VALIDFLAG_0 = "0";
    public static final String TAG_PSDEVUSERID = "PSDEVUSERID";
    public static final String TAG_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_PSDEVUSEROBJTYPE = "PSDEVUSEROBJTYPE";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGINNAME = "LOGINNAME";
    public static final String TAG_LOGINPWD = "LOGINPWD";
    public static final String TAG_FULLLOGINNAME = "FULLLOGINNAME";
    public static final String TAG_ADMINMODE = "ADMINMODE";
    public static final String TAG_FROMPSDEVUSERID = "FROMPSDEVUSERID";
    public static final String TAG_FROMPSDEVUSERNAME = "FROMPSDEVUSERNAME";
    public static final String TAG_FROMPSDCNAME = "FROMPSDCNAME";
    public static final String TAG_FROMPSDCID = "FROMPSDCID";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";

    public final boolean isPSDEVUSERIDNull() {
        return this.IsParamNull(TAG_PSDEVUSERID);
    }

    public final String getPSDEVUSERID() {
        return this.GetParamStringValue(TAG_PSDEVUSERID, "");
    }

    public final void setPSDEVUSERID(String strValue) {
        this.SetParamValue(TAG_PSDEVUSERID, strValue);
    }

    public final boolean isPSDEVUSERNAMENull() {
        return this.IsParamNull(TAG_PSDEVUSERNAME);
    }

    public final String getPSDEVUSERNAME() {
        return this.GetParamStringValue(TAG_PSDEVUSERNAME, "");
    }

    public final void setPSDEVUSERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVUSERNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPSDEVUSEROBJTYPENull() {
        return this.IsParamNull(TAG_PSDEVUSEROBJTYPE);
    }

    public final String getPSDEVUSEROBJTYPE() {
        return this.GetParamStringValue(TAG_PSDEVUSEROBJTYPE, "");
    }

    public final void setPSDEVUSEROBJTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEVUSEROBJTYPE, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isLOGINNAMENull() {
        return this.IsParamNull(TAG_LOGINNAME);
    }

    public final String getLOGINNAME() {
        return this.GetParamStringValue(TAG_LOGINNAME, "");
    }

    public final void setLOGINNAME(String strValue) {
        this.SetParamValue(TAG_LOGINNAME, strValue);
    }

    public final boolean isLOGINPWDNull() {
        return this.IsParamNull(TAG_LOGINPWD);
    }

    public final String getLOGINPWD() {
        return this.GetParamStringValue(TAG_LOGINPWD, "");
    }

    public final void setLOGINPWD(String strValue) {
        this.SetParamValue(TAG_LOGINPWD, strValue);
    }

    public final boolean isFULLLOGINNAMENull() {
        return this.IsParamNull(TAG_FULLLOGINNAME);
    }

    public final String getFULLLOGINNAME() {
        return this.GetParamStringValue(TAG_FULLLOGINNAME, "");
    }

    public final void setFULLLOGINNAME(String strValue) {
        this.SetParamValue(TAG_FULLLOGINNAME, strValue);
    }

    public final boolean isADMINMODENull() {
        return this.IsParamNull(TAG_ADMINMODE);
    }

    public final boolean getADMINMODE() {
        return this.GetParamIntValue(TAG_ADMINMODE, 0) == 1;
    }

    public final void setADMINMODE(boolean bValue) {
        this.SetParamValue(TAG_ADMINMODE, bValue ? 1 : 0);
    }

    public final boolean isFROMPSDEVUSERIDNull() {
        return this.IsParamNull(TAG_FROMPSDEVUSERID);
    }

    public final String getFROMPSDEVUSERID() {
        return this.GetParamStringValue(TAG_FROMPSDEVUSERID, "");
    }

    public final void setFROMPSDEVUSERID(String strValue) {
        this.SetParamValue(TAG_FROMPSDEVUSERID, strValue);
    }

    public final boolean isFROMPSDEVUSERNAMENull() {
        return this.IsParamNull(TAG_FROMPSDEVUSERNAME);
    }

    public final String getFROMPSDEVUSERNAME() {
        return this.GetParamStringValue(TAG_FROMPSDEVUSERNAME, "");
    }

    public final void setFROMPSDEVUSERNAME(String strValue) {
        this.SetParamValue(TAG_FROMPSDEVUSERNAME, strValue);
    }

    public final boolean isFROMPSDCNAMENull() {
        return this.IsParamNull(TAG_FROMPSDCNAME);
    }

    public final String getFROMPSDCNAME() {
        return this.GetParamStringValue(TAG_FROMPSDCNAME, "");
    }

    public final void setFROMPSDCNAME(String strValue) {
        this.SetParamValue(TAG_FROMPSDCNAME, strValue);
    }

    public final boolean isFROMPSDCIDNull() {
        return this.IsParamNull(TAG_FROMPSDCID);
    }

    public final String getFROMPSDCID() {
        return this.GetParamStringValue(TAG_FROMPSDCID, "");
    }

    public final void setFROMPSDCID(String strValue) {
        this.SetParamValue(TAG_FROMPSDCID, strValue);
    }

    public final boolean isUSERMODENull() {
        return this.IsParamNull(TAG_USERMODE);
    }

    public final String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public final void setUSERMODE(String strValue) {
        this.SetParamValue(TAG_USERMODE, strValue);
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
}

