/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSearchDE
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
    public static final String TAG_PSSYSSEARCHDEID = "PSSYSSEARCHDEID";
    public static final String TAG_PSSYSSEARCHDENAME = "PSSYSSEARCHDENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSEARCHSCHEMEID = "PSSYSSEARCHSCHEMEID";
    public static final String TAG_PSSYSSEARCHSCHEMENAME = "PSSYSSEARCHSCHEMENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSSYSSEARCHDOCID = "PSSYSSEARCHDOCID";
    public static final String TAG_PSSYSSEARCHDOCNAME = "PSSYSSEARCHDOCNAME";
    public static final String TAG_NOSQLFLAG = "NOSQLFLAG";
    public static final String TAG_DETAG = "DETAG";
    public static final String TAG_DETAG2 = "DETAG2";

    public final boolean isPSSYSSEARCHDEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDEID);
    }

    public final String getPSSYSSEARCHDEID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDEID, "");
    }

    public final void setPSSYSSEARCHDEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDEID, strValue);
    }

    public final boolean isPSSYSSEARCHDENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDENAME);
    }

    public final String getPSSYSSEARCHDENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDENAME, "");
    }

    public final void setPSSYSSEARCHDENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDENAME, strValue);
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

    public final boolean isPSSYSSEARCHSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHSCHEMEID);
    }

    public final String getPSSYSSEARCHSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHSCHEMEID, "");
    }

    public final void setPSSYSSEARCHSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHSCHEMEID, strValue);
    }

    public final boolean isPSSYSSEARCHSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHSCHEMENAME);
    }

    public final String getPSSYSSEARCHSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHSCHEMENAME, "");
    }

    public final void setPSSYSSEARCHSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHSCHEMENAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isPSSYSSEARCHDOCIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCID);
    }

    public final String getPSSYSSEARCHDOCID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCID, "");
    }

    public final void setPSSYSSEARCHDOCID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCID, strValue);
    }

    public final boolean isPSSYSSEARCHDOCNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDOCNAME);
    }

    public final String getPSSYSSEARCHDOCNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDOCNAME, "");
    }

    public final void setPSSYSSEARCHDOCNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDOCNAME, strValue);
    }

    public final boolean isNOSQLFLAGNull() {
        return this.IsParamNull(TAG_NOSQLFLAG);
    }

    public final boolean getNOSQLFLAG() {
        return this.GetParamIntValue(TAG_NOSQLFLAG, 0) == 1;
    }

    public final void setNOSQLFLAG(boolean bValue) {
        this.SetParamValue(TAG_NOSQLFLAG, bValue ? 1 : 0);
    }

    public final boolean isDETAGNull() {
        return this.IsParamNull(TAG_DETAG);
    }

    public final String getDETAG() {
        return this.GetParamStringValue(TAG_DETAG, "");
    }

    public final void setDETAG(String strValue) {
        this.SetParamValue(TAG_DETAG, strValue);
    }

    public final boolean isDETAG2Null() {
        return this.IsParamNull(TAG_DETAG2);
    }

    public final String getDETAG2() {
        return this.GetParamStringValue(TAG_DETAG2, "");
    }

    public final void setDETAG2(String strValue) {
        this.SetParamValue(TAG_DETAG2, strValue);
    }
}

