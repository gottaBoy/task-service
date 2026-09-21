/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysBIAggColumn
extends BaseDataEntity {
    public static final String BIAGGCOLUMNTYPE_MEASURE = "MEASURE";
    public static final String BIAGGCOLUMNTYPE_DIMENSION = "DIMENSION";
    public static final String BIAGGCOLUMNTYPE_USER = "USER";
    public static final String USERCAT_CAT1 = "CAT1";
    public static final String USERCAT_CAT2 = "CAT2";
    public static final String USERCAT_CAT3 = "CAT3";
    public static final String USERCAT_CAT4 = "CAT4";
    public static final String USERCAT_CAT5 = "CAT5";
    public static final String USERCAT_CAT6 = "CAT6";
    public static final String USERCAT_CAT7 = "CAT7";
    public static final String USERCAT_CAT8 = "CAT8";
    public static final String USERCAT_CAT9 = "CAT9";
    public static final String TAG_PSSYSBIAGGCOLUMNID = "PSSYSBIAGGCOLUMNID";
    public static final String TAG_PSSYSBIAGGCOLUMNNAME = "PSSYSBIAGGCOLUMNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSBIAGGTABLEID = "PSSYSBIAGGTABLEID";
    public static final String TAG_PSSYSBIAGGTABLENAME = "PSSYSBIAGGTABLENAME";
    public static final String TAG_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String TAG_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String TAG_PSSYSBICUBEMEASUREID = "PSSYSBICUBEMEASUREID";
    public static final String TAG_PSSYSBICUBEMEASURENAME = "PSSYSBICUBEMEASURENAME";
    public static final String TAG_BIAGGCOLUMNTYPE = "BIAGGCOLUMNTYPE";
    public static final String TAG_BIAGGCOLUMNTAG = "BIAGGCOLUMNTAG";
    public static final String TAG_BIAGGCOLUMNTAG2 = "BIAGGCOLUMNTAG2";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_DVT = "DVT";

    public final boolean isPSSYSBIAGGCOLUMNIDNull() {
        return this.IsParamNull(TAG_PSSYSBIAGGCOLUMNID);
    }

    public final String getPSSYSBIAGGCOLUMNID() {
        return this.GetParamStringValue(TAG_PSSYSBIAGGCOLUMNID, "");
    }

    public final void setPSSYSBIAGGCOLUMNID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIAGGCOLUMNID, strValue);
    }

    public final boolean isPSSYSBIAGGCOLUMNNAMENull() {
        return this.IsParamNull(TAG_PSSYSBIAGGCOLUMNNAME);
    }

    public final String getPSSYSBIAGGCOLUMNNAME() {
        return this.GetParamStringValue(TAG_PSSYSBIAGGCOLUMNNAME, "");
    }

    public final void setPSSYSBIAGGCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIAGGCOLUMNNAME, strValue);
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

    public final boolean isPSSYSBIAGGTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSBIAGGTABLEID);
    }

    public final String getPSSYSBIAGGTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSBIAGGTABLEID, "");
    }

    public final void setPSSYSBIAGGTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBIAGGTABLEID, strValue);
    }

    public final boolean isPSSYSBIAGGTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSBIAGGTABLENAME);
    }

    public final String getPSSYSBIAGGTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSBIAGGTABLENAME, "");
    }

    public final void setPSSYSBIAGGTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBIAGGTABLENAME, strValue);
    }

    public final boolean isPSSYSBICUBEIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEID);
    }

    public final String getPSSYSBICUBEID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEID, "");
    }

    public final void setPSSYSBICUBEID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEID, strValue);
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

    public final boolean isPSSYSBICUBEMEASUREIDNull() {
        return this.IsParamNull(TAG_PSSYSBICUBEMEASUREID);
    }

    public final String getPSSYSBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEMEASUREID, "");
    }

    public final void setPSSYSBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEMEASUREID, strValue);
    }

    public final boolean isPSSYSBICUBEMEASURENAMENull() {
        return this.IsParamNull(TAG_PSSYSBICUBEMEASURENAME);
    }

    public final String getPSSYSBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_PSSYSBICUBEMEASURENAME, "");
    }

    public final void setPSSYSBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSBICUBEMEASURENAME, strValue);
    }

    public final boolean isBIAGGCOLUMNTYPENull() {
        return this.IsParamNull(TAG_BIAGGCOLUMNTYPE);
    }

    public final String getBIAGGCOLUMNTYPE() {
        return this.GetParamStringValue(TAG_BIAGGCOLUMNTYPE, "");
    }

    public final void setBIAGGCOLUMNTYPE(String strValue) {
        this.SetParamValue(TAG_BIAGGCOLUMNTYPE, strValue);
    }

    public final boolean isBIAGGCOLUMNTAGNull() {
        return this.IsParamNull(TAG_BIAGGCOLUMNTAG);
    }

    public final String getBIAGGCOLUMNTAG() {
        return this.GetParamStringValue(TAG_BIAGGCOLUMNTAG, "");
    }

    public final void setBIAGGCOLUMNTAG(String strValue) {
        this.SetParamValue(TAG_BIAGGCOLUMNTAG, strValue);
    }

    public final boolean isBIAGGCOLUMNTAG2Null() {
        return this.IsParamNull(TAG_BIAGGCOLUMNTAG2);
    }

    public final String getBIAGGCOLUMNTAG2() {
        return this.GetParamStringValue(TAG_BIAGGCOLUMNTAG2, "");
    }

    public final void setBIAGGCOLUMNTAG2(String strValue) {
        this.SetParamValue(TAG_BIAGGCOLUMNTAG2, strValue);
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

    public final boolean isDEFAULTVALUENull() {
        return this.IsParamNull(TAG_DEFAULTVALUE);
    }

    public final String getDEFAULTVALUE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUE, "");
    }

    public final void setDEFAULTVALUE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUE, strValue);
    }

    public final boolean isDVTNull() {
        return this.IsParamNull(TAG_DVT);
    }

    public final String getDVT() {
        return this.GetParamStringValue(TAG_DVT, "");
    }

    public final void setDVT(String strValue) {
        this.SetParamValue(TAG_DVT, strValue);
    }
}

