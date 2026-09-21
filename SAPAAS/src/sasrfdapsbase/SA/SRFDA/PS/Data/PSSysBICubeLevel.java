/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBICubeLevel
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
    public static final String TAG_PSSYSBICUBELEVELID = "PSSYSBICUBELEVELID";
    public static final String TAG_PSSYSBICUBELEVELNAME = "PSSYSBICUBELEVELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String TAG_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_BICUBELEVELTAG = "BICUBELEVELTAG";
    public static final String TAG_BICUBELEVELTAG2 = "BICUBELEVELTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSSYSBIHIERARCHYID = "PSSYSBIHIERARCHYID";
    public static final String TAG_PSSYSBIHIERARCHYNAME = "PSSYSBIHIERARCHYNAME";
    public static final String TAG_PSSYSBILEVELID = "PSSYSBILEVELID";
    public static final String TAG_PSSYSBILEVELNAME = "PSSYSBILEVELNAME";
    public static final String TAG_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String TAG_ALLLEVELFLAG = "ALLLEVELFLAG";

    public final boolean isPSSYSBICUBELEVELIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBELEVELID);
    }

    public final String getPSSYSBICUBELEVELID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBELEVELID, "");
    }

    public final void setPSSYSBICUBELEVELID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBELEVELID, strValue);
    }

    public final boolean isPSSYSBICUBELEVELNAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBELEVELNAME);
    }

    public final String getPSSYSBICUBELEVELNAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBELEVELNAME, "");
    }

    public final void setPSSYSBICUBELEVELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBELEVELNAME, strValue);
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

    public final boolean isPSSYSBICUBEDIMENSIONIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEDIMENSIONID);
    }

    public final String getPSSYSBICUBEDIMENSIONID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEDIMENSIONID, "");
    }

    public final void setPSSYSBICUBEDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEDIMENSIONID, strValue);
    }

    public final boolean isPSSYSBICUBEDIMENSIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBEDIMENSIONNAME);
    }

    public final String getPSSYSBICUBEDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEDIMENSIONNAME, "");
    }

    public final void setPSSYSBICUBEDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEDIMENSIONNAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }

    public final boolean isBICUBELEVELTAGNull() {
        return this.IsParamNull(TAG_BICUBELEVELTAG);
    }

    public final String getBICUBELEVELTAG() {
        return this.GetParamStringValue(TAG_BICUBELEVELTAG, "");
    }

    public final void setBICUBELEVELTAG(String strValue) {
        this.SetParamValue(TAG_BICUBELEVELTAG, strValue);
    }

    public final boolean isBICUBELEVELTAG2Null() {
        return this.IsParamNull(TAG_BICUBELEVELTAG2);
    }

    public final String getBICUBELEVELTAG2() {
        return this.GetParamStringValue(TAG_BICUBELEVELTAG2, "");
    }

    public final void setBICUBELEVELTAG2(String strValue) {
        this.SetParamValue(TAG_BICUBELEVELTAG2, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
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

    public final boolean isPSSYSBIDIMENSIONIDNull() {
        return this.IsParamNull(TAG_PSSYSBIDIMENSIONID);
    }

    public final String getPSSYSBIDIMENSIONID() {
        return this.GetParamStringValue(TAG_PSSYSBIDIMENSIONID, "");
    }

    public final void setPSSYSBIDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIDIMENSIONID, strValue);
    }

    public final boolean isALLLEVELFLAGNull() {
        return this.IsParamNull(TAG_ALLLEVELFLAG);
    }

    public final boolean getALLLEVELFLAG() {
        return this.GetParamIntValue(TAG_ALLLEVELFLAG, 0) == 1;
    }

    public final void setALLLEVELFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLLEVELFLAG, bValue ? 1 : 0);
    }
}

