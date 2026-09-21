/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEAIDER
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
    public static final String TAG_PSSYSEAIDERID = "PSSYSEAIDERID";
    public static final String TAG_PSSYSEAIDERNAME = "PSSYSEAIDERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSEAIDEID = "PSSYSEAIDEID";
    public static final String TAG_PSSYSEAIDENAME = "PSSYSEAIDENAME";
    public static final String TAG_PSSYSEAIELEMENTREID = "PSSYSEAIELEMENTREID";
    public static final String TAG_PSSYSEAIELEMENTRENAME = "PSSYSEAIELEMENTRENAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_EAIDERTAG = "EAIDERTAG";
    public static final String TAG_EAIDERTAG2 = "EAIDERTAG2";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";

    public final boolean isPSSYSEAIDERIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIDERID);
    }

    public final String getPSSYSEAIDERID() {
        return this.GetParamStringValue(TAG_PSSYSEAIDERID, "");
    }

    public final void setPSSYSEAIDERID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDERID, strValue);
    }

    public final boolean isPSSYSEAIDERNAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIDERNAME);
    }

    public final String getPSSYSEAIDERNAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIDERNAME, "");
    }

    public final void setPSSYSEAIDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDERNAME, strValue);
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

    public final boolean isPSSYSEAIDEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIDEID);
    }

    public final String getPSSYSEAIDEID() {
        return this.GetParamStringValue(TAG_PSSYSEAIDEID, "");
    }

    public final void setPSSYSEAIDEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDEID, strValue);
    }

    public final boolean isPSSYSEAIDENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIDENAME);
    }

    public final String getPSSYSEAIDENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIDENAME, "");
    }

    public final void setPSSYSEAIDENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDENAME, strValue);
    }

    public final boolean isPSSYSEAIELEMENTREIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTREID);
    }

    public final String getPSSYSEAIELEMENTREID() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTREID, "");
    }

    public final void setPSSYSEAIELEMENTREID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTREID, strValue);
    }

    public final boolean isPSSYSEAIELEMENTRENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTRENAME);
    }

    public final String getPSSYSEAIELEMENTRENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTRENAME, "");
    }

    public final void setPSSYSEAIELEMENTRENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTRENAME, strValue);
    }

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
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

    public final boolean isEAIDERTAGNull() {
        return this.IsParamNull(TAG_EAIDERTAG);
    }

    public final String getEAIDERTAG() {
        return this.GetParamStringValue(TAG_EAIDERTAG, "");
    }

    public final void setEAIDERTAG(String strValue) {
        this.SetParamValue(TAG_EAIDERTAG, strValue);
    }

    public final boolean isEAIDERTAG2Null() {
        return this.IsParamNull(TAG_EAIDERTAG2);
    }

    public final String getEAIDERTAG2() {
        return this.GetParamStringValue(TAG_EAIDERTAG2, "");
    }

    public final void setEAIDERTAG2(String strValue) {
        this.SetParamValue(TAG_EAIDERTAG2, strValue);
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

    public final boolean isPSSYSEAIELEMENTIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTID);
    }

    public final String getPSSYSEAIELEMENTID() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTID, "");
    }

    public final void setPSSYSEAIELEMENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTID, strValue);
    }
}

