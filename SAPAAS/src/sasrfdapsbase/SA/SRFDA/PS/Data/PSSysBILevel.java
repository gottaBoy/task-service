/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBILevel
extends BaseDataEntity {
    public static final String BILEVELTYPE_COMMON = "COMMON";
    public static final String BILEVELTYPE_TIME_YEARS = "TIME_YEARS";
    public static final String BILEVELTYPE_TIME_HALFYEARS = "TIME_HALFYEARS";
    public static final String BILEVELTYPE_TIME_QUARTERS = "TIME_QUARTERS";
    public static final String BILEVELTYPE_TIME_MONTHS = "TIME_MONTHS";
    public static final String BILEVELTYPE_TIME_WEEKS = "TIME_WEEKS";
    public static final String BILEVELTYPE_TIME_DAYS = "TIME_DAYS";
    public static final String BILEVELTYPE_TIME_HOURS = "TIME_HOURS";
    public static final String BILEVELTYPE_TIME_MINUTES = "TIME_MINUTES";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSBILEVELID = "PSSYSBILEVELID";
    public static final String TAG_PSSYSBILEVELNAME = "PSSYSBILEVELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBIHIERARCHYID = "PSSYSBIHIERARCHYID";
    public static final String TAG_PSSYSBIHIERARCHYNAME = "PSSYSBIHIERARCHYNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String TAG_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String TAG_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String TAG_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    public static final String TAG_BILEVELTYPE = "BILEVELTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_BILEVELTAG = "BILEVELTAG";
    public static final String TAG_BILEVELTAG2 = "BILEVELTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_UNIQUEMEMBERS = "UNIQUEMEMBERS";
    public static final String TAG_AGGCAPTION = "AGGCAPTION";

    public final boolean isPSSYSBILEVELIDNull() {
        return this.IsParamNull(TAG_PSSYSBILEVELID);
    }

    public final String getPSSYSBILEVELID() {
        return this.GetParamStringValue(TAG_PSSYSBILEVELID, "");
    }

    public final void setPSSYSBILEVELID(String strValue) {
        this.SetParamValue(TAG_PSSYSBILEVELID, strValue);
    }

    public final boolean isPSSYSBILEVELNAMENull() {
        return this.IsParamNull(TAG_PSSYSBILEVELNAME);
    }

    public final String getPSSYSBILEVELNAME() {
        return this.GetParamStringValue(TAG_PSSYSBILEVELNAME, "");
    }

    public final void setPSSYSBILEVELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBILEVELNAME, strValue);
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

    public final boolean isPSSYSBIHIERARCHYIDNull() {
        return this.IsParamNull(TAG_PSSYSBIHIERARCHYID);
    }

    public final String getPSSYSBIHIERARCHYID() {
        return this.GetParamStringValue(TAG_PSSYSBIHIERARCHYID, "");
    }

    public final void setPSSYSBIHIERARCHYID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIHIERARCHYID, strValue);
    }

    public final boolean isPSSYSBIHIERARCHYNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIHIERARCHYNAME);
    }

    public final String getPSSYSBIHIERARCHYNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIHIERARCHYNAME, "");
    }

    public final void setPSSYSBIHIERARCHYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIHIERARCHYNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isTEXTPSDEFIDNull() {
        return this.IsParamNull(TAG_TEXTPSDEFID);
    }

    public final String getTEXTPSDEFID() {
        return this.GetParamStringValue(TAG_TEXTPSDEFID, "");
    }

    public final void setTEXTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFID, strValue);
    }

    public final boolean isTEXTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TEXTPSDEFNAME);
    }

    public final String getTEXTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TEXTPSDEFNAME, "");
    }

    public final void setTEXTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TEXTPSDEFNAME, strValue);
    }

    public final boolean isVALUEPSDEFIDNull() {
        return this.IsParamNull(TAG_VALUEPSDEFID);
    }

    public final String getVALUEPSDEFID() {
        return this.GetParamStringValue(TAG_VALUEPSDEFID, "");
    }

    public final void setVALUEPSDEFID(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFID, strValue);
    }

    public final boolean isVALUEPSDEFNAMENull() {
        return this.IsParamNull(TAG_VALUEPSDEFNAME);
    }

    public final String getVALUEPSDEFNAME() {
        return this.GetParamStringValue(TAG_VALUEPSDEFNAME, "");
    }

    public final void setVALUEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_VALUEPSDEFNAME, strValue);
    }

    public final boolean isBILEVELTYPENull() {
        return this.IsParamNull(TAG_BILEVELTYPE);
    }

    public final String getBILEVELTYPE() {
        return this.GetParamStringValue(TAG_BILEVELTYPE, "");
    }

    public final void setBILEVELTYPE(String strValue) {
        this.SetParamValue(TAG_BILEVELTYPE, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isBILEVELTAGNull() {
        return this.IsParamNull(TAG_BILEVELTAG);
    }

    public final String getBILEVELTAG() {
        return this.GetParamStringValue(TAG_BILEVELTAG, "");
    }

    public final void setBILEVELTAG(String strValue) {
        this.SetParamValue(TAG_BILEVELTAG, strValue);
    }

    public final boolean isBILEVELTAG2Null() {
        return this.IsParamNull(TAG_BILEVELTAG2);
    }

    public final String getBILEVELTAG2() {
        return this.GetParamStringValue(TAG_BILEVELTAG2, "");
    }

    public final void setBILEVELTAG2(String strValue) {
        this.SetParamValue(TAG_BILEVELTAG2, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isUNIQUEMEMBERSNull() {
        return this.IsParamNull(TAG_UNIQUEMEMBERS);
    }

    public final boolean getUNIQUEMEMBERS() {
        return this.GetParamIntValue(TAG_UNIQUEMEMBERS, 0) == 1;
    }

    public final void setUNIQUEMEMBERS(boolean bValue) {
        this.SetParamValue(TAG_UNIQUEMEMBERS, bValue ? 1 : 0);
    }

    public final boolean isAGGCAPTIONNull() {
        return this.IsParamNull(TAG_AGGCAPTION);
    }

    public final String getAGGCAPTION() {
        return this.GetParamStringValue(TAG_AGGCAPTION, "");
    }

    public final void setAGGCAPTION(String strValue) {
        this.SetParamValue(TAG_AGGCAPTION, strValue);
    }
}

