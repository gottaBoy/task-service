/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBIHierarchy
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
    public static final String BIHIERARCHYTYPE_DE = "DE";
    public static final String TAG_PSSYSBIHIERARCHYID = "PSSYSBIHIERARCHYID";
    public static final String TAG_PSSYSBIHIERARCHYNAME = "PSSYSBIHIERARCHYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ALLCAPTION = "ALLCAPTION";
    public static final String TAG_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String TAG_PSSYSBIDIMENSIONNAME = "PSSYSBIDIMENSIONNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_BIHIERARCHYTAG = "BIHIERARCHYTAG";
    public static final String TAG_BIHIERARCHYTAG2 = "BIHIERARCHYTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_BIHIERARCHYTYPE = "BIHIERARCHYTYPE";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_HASALL = "HASALL";

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

    public final boolean isALLCAPTIONNull() {
        return this.IsParamNull(TAG_ALLCAPTION);
    }

    public final String getALLCAPTION() {
        return this.GetParamStringValue(TAG_ALLCAPTION, "");
    }

    public final void setALLCAPTION(String strValue) {
        this.SetParamValue(TAG_ALLCAPTION, strValue);
    }

    public final boolean isPSSYSBIDIMENSIONIDNull() {
        return this.IsParamNull(TAG_PSSYSBIDIMENSIONID);
    }

    public final String getPSSYSBIDIMENSIONID() {
        return this.GetParamStringValue(TAG_PSSYSBIDIMENSIONID, "");
    }

    public final void setPSSYSBIDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIDIMENSIONID, strValue);
    }

    public final boolean isPSSYSBIDIMENSIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIDIMENSIONNAME);
    }

    public final String getPSSYSBIDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIDIMENSIONNAME, "");
    }

    public final void setPSSYSBIDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIDIMENSIONNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isBIHIERARCHYTAGNull() {
        return this.IsParamNull(TAG_BIHIERARCHYTAG);
    }

    public final String getBIHIERARCHYTAG() {
        return this.GetParamStringValue(TAG_BIHIERARCHYTAG, "");
    }

    public final void setBIHIERARCHYTAG(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYTAG, strValue);
    }

    public final boolean isBIHIERARCHYTAG2Null() {
        return this.IsParamNull(TAG_BIHIERARCHYTAG2);
    }

    public final String getBIHIERARCHYTAG2() {
        return this.GetParamStringValue(TAG_BIHIERARCHYTAG2, "");
    }

    public final void setBIHIERARCHYTAG2(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYTAG2, strValue);
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

    public final boolean isBIHIERARCHYTYPENull() {
        return this.IsParamNull(TAG_BIHIERARCHYTYPE);
    }

    public final String getBIHIERARCHYTYPE() {
        return this.GetParamStringValue(TAG_BIHIERARCHYTYPE, "");
    }

    public final void setBIHIERARCHYTYPE(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYTYPE, strValue);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.IsParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.GetParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isHASALLNull() {
        return this.IsParamNull(TAG_HASALL);
    }

    public final boolean getHASALL() {
        return this.GetParamIntValue(TAG_HASALL, 0) == 1;
    }

    public final void setHASALL(boolean bValue) {
        this.SetParamValue(TAG_HASALL, bValue ? 1 : 0);
    }
}

