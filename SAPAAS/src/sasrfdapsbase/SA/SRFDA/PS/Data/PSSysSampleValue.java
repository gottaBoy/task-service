/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSampleValue
extends BaseDataEntity {
    public static final String TAG_PSSYSSAMPLEVALUEID = "PSSYSSAMPLEVALUEID";
    public static final String TAG_PSSYSSAMPLEVALUENAME = "PSSYSSAMPLEVALUENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSAMPLEVALUEID = "PSSAMPLEVALUEID";
    public static final String TAG_PSSAMPLEVALUENAME = "PSSAMPLEVALUENAME";
    public static final String TAG_VALUES = "VALUES";
    public static final String TAG_VALUE = "VALUE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_NULLVALUE = "NULLVALUE";
    public static final String TAG_VALUELIST = "VALUELIST";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERCAT = "USERCAT";

    public final boolean isPSSYSSAMPLEVALUEIDNull() {
        return this.IsParamNull(TAG_PSSYSSAMPLEVALUEID);
    }

    public final String getPSSYSSAMPLEVALUEID() {
        return this.GetParamStringValue(TAG_PSSYSSAMPLEVALUEID, "");
    }

    public final void setPSSYSSAMPLEVALUEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSAMPLEVALUEID, strValue);
    }

    public final boolean isPSSYSSAMPLEVALUENAMENull() {
        return this.IsParamNull(TAG_PSSYSSAMPLEVALUENAME);
    }

    public final String getPSSYSSAMPLEVALUENAME() {
        return this.GetParamStringValue(TAG_PSSYSSAMPLEVALUENAME, "");
    }

    public final void setPSSYSSAMPLEVALUENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSAMPLEVALUENAME, strValue);
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

    public final boolean isPSSAMPLEVALUEIDNull() {
        return this.IsParamNull(TAG_PSSAMPLEVALUEID);
    }

    public final String getPSSAMPLEVALUEID() {
        return this.GetParamStringValue(TAG_PSSAMPLEVALUEID, "");
    }

    public final void setPSSAMPLEVALUEID(String strValue) {
        this.SetParamValue(TAG_PSSAMPLEVALUEID, strValue);
    }

    public final boolean isPSSAMPLEVALUENAMENull() {
        return this.IsParamNull(TAG_PSSAMPLEVALUENAME);
    }

    public final String getPSSAMPLEVALUENAME() {
        return this.GetParamStringValue(TAG_PSSAMPLEVALUENAME, "");
    }

    public final void setPSSAMPLEVALUENAME(String strValue) {
        this.SetParamValue(TAG_PSSAMPLEVALUENAME, strValue);
    }

    public final boolean isVALUESNull() {
        return this.IsParamNull(TAG_VALUES);
    }

    public final String getVALUES() {
        return this.GetParamStringValue(TAG_VALUES, "");
    }

    public final void setVALUES(String strValue) {
        this.SetParamValue(TAG_VALUES, strValue);
    }

    public final boolean isVALUENull() {
        return this.IsParamNull(TAG_VALUE);
    }

    public final String getVALUE() {
        return this.GetParamStringValue(TAG_VALUE, "");
    }

    public final void setVALUE(String strValue) {
        this.SetParamValue(TAG_VALUE, strValue);
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

    public final boolean isNULLVALUENull() {
        return this.IsParamNull(TAG_NULLVALUE);
    }

    public final boolean getNULLVALUE() {
        return this.GetParamIntValue(TAG_NULLVALUE, 0) == 1;
    }

    public final void setNULLVALUE(boolean bValue) {
        this.SetParamValue(TAG_NULLVALUE, bValue ? 1 : 0);
    }

    public final boolean isVALUELISTNull() {
        return this.IsParamNull(TAG_VALUELIST);
    }

    public final String getVALUELIST() {
        return this.GetParamStringValue(TAG_VALUELIST, "");
    }

    public final void setVALUELIST(String strValue) {
        this.SetParamValue(TAG_VALUELIST, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }
}

