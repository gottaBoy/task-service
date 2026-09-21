/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysUserCaseRS
extends BaseDataEntity {
    public static final String TAG_PSSYSUSERCASERSID = "PSSYSUSERCASERSID";
    public static final String TAG_PSSYSUSERCASERSNAME = "PSSYSUSERCASERSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String TAG_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String TAG_PSSYSACTORID = "PSSYSACTORID";
    public static final String TAG_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PPSSYSUSERCASEID = "PPSSYSUSERCASEID";
    public static final String TAG_PPSSYSUSERCASENAME = "PPSSYSUSERCASENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_RSTYPE = "RSTYPE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_RSMODE = "RSMODE";
    public static final String TAG_PPSSYSACTORID = "PPSSYSACTORID";
    public static final String TAG_PPSSYSACTORNAME = "PPSSYSACTORNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";

    public final boolean isPSSYSUSERCASERSIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERCASERSID);
    }

    public final String getPSSYSUSERCASERSID() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASERSID, "");
    }

    public final void setPSSYSUSERCASERSID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASERSID, strValue);
    }

    public final boolean isPSSYSUSERCASERSNAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERCASERSNAME);
    }

    public final String getPSSYSUSERCASERSNAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASERSNAME, "");
    }

    public final void setPSSYSUSERCASERSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASERSNAME, strValue);
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

    public final boolean isPSSYSUSERCASEIDNull() {
        return this.IsParamNull(TAG_PSSYSUSERCASEID);
    }

    public final String getPSSYSUSERCASEID() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASEID, "");
    }

    public final void setPSSYSUSERCASEID(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASEID, strValue);
    }

    public final boolean isPSSYSUSERCASENAMENull() {
        return this.IsParamNull(TAG_PSSYSUSERCASENAME);
    }

    public final String getPSSYSUSERCASENAME() {
        return this.GetParamStringValue(TAG_PSSYSUSERCASENAME, "");
    }

    public final void setPSSYSUSERCASENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUSERCASENAME, strValue);
    }

    public final boolean isPSSYSACTORIDNull() {
        return this.IsParamNull(TAG_PSSYSACTORID);
    }

    public final String getPSSYSACTORID() {
        return this.GetParamStringValue(TAG_PSSYSACTORID, "");
    }

    public final void setPSSYSACTORID(String strValue) {
        this.SetParamValue(TAG_PSSYSACTORID, strValue);
    }

    public final boolean isPSSYSACTORNAMENull() {
        return this.IsParamNull(TAG_PSSYSACTORNAME);
    }

    public final String getPSSYSACTORNAME() {
        return this.GetParamStringValue(TAG_PSSYSACTORNAME, "");
    }

    public final void setPSSYSACTORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSACTORNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isPPSSYSUSERCASEIDNull() {
        return this.IsParamNull(TAG_PPSSYSUSERCASEID);
    }

    public final String getPPSSYSUSERCASEID() {
        return this.GetParamStringValue(TAG_PPSSYSUSERCASEID, "");
    }

    public final void setPPSSYSUSERCASEID(String strValue) {
        this.SetParamValue(TAG_PPSSYSUSERCASEID, strValue);
    }

    public final boolean isPPSSYSUSERCASENAMENull() {
        return this.IsParamNull(TAG_PPSSYSUSERCASENAME);
    }

    public final String getPPSSYSUSERCASENAME() {
        return this.GetParamStringValue(TAG_PPSSYSUSERCASENAME, "");
    }

    public final void setPPSSYSUSERCASENAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSUSERCASENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isRSTYPENull() {
        return this.IsParamNull(TAG_RSTYPE);
    }

    public final String getRSTYPE() {
        return this.GetParamStringValue(TAG_RSTYPE, "");
    }

    public final void setRSTYPE(String strValue) {
        this.SetParamValue(TAG_RSTYPE, strValue);
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

    public final boolean isRSMODENull() {
        return this.IsParamNull(TAG_RSMODE);
    }

    public final String getRSMODE() {
        return this.GetParamStringValue(TAG_RSMODE, "");
    }

    public final void setRSMODE(String strValue) {
        this.SetParamValue(TAG_RSMODE, strValue);
    }

    public final boolean isPPSSYSACTORIDNull() {
        return this.IsParamNull(TAG_PPSSYSACTORID);
    }

    public final String getPPSSYSACTORID() {
        return this.GetParamStringValue(TAG_PPSSYSACTORID, "");
    }

    public final void setPPSSYSACTORID(String strValue) {
        this.SetParamValue(TAG_PPSSYSACTORID, strValue);
    }

    public final boolean isPPSSYSACTORNAMENull() {
        return this.IsParamNull(TAG_PPSSYSACTORNAME);
    }

    public final String getPPSSYSACTORNAME() {
        return this.GetParamStringValue(TAG_PPSSYSACTORNAME, "");
    }

    public final void setPPSSYSACTORNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSACTORNAME, strValue);
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
}

