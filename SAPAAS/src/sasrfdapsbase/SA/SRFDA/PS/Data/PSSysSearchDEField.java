/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSearchDEField
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
    public static final String TAG_PSSYSSEARCHDEFIELDID = "PSSYSSEARCHDEFIELDID";
    public static final String TAG_PSSYSSEARCHDEFIELDNAME = "PSSYSSEARCHDEFIELDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSSYSSEARCHDEID = "PSSYSSEARCHDEID";
    public static final String TAG_PSSYSSEARCHDENAME = "PSSYSSEARCHDENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSSEARCHFIELDID = "PSSYSSEARCHFIELDID";
    public static final String TAG_PSSYSSEARCHFIELDNAME = "PSSYSSEARCHFIELDNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_FIELDTAG2 = "FIELDTAG2";
    public static final String TAG_FIELDTAG = "FIELDTAG";
    public static final String TAG_DEFAULTVALUETYPE = "DEFAULTVALUETYPE";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String TAG_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String TAG_FIELDS = "FIELDS";
    public static final String TAG_FIELDPARAMS = "FIELDPARAMS";

    public final boolean isPSSYSSEARCHDEFIELDIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDEFIELDID);
    }

    public final String getPSSYSSEARCHDEFIELDID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDEFIELDID, "");
    }

    public final void setPSSYSSEARCHDEFIELDID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDEFIELDID, strValue);
    }

    public final boolean isPSSYSSEARCHDEFIELDNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHDEFIELDNAME);
    }

    public final String getPSSYSSEARCHDEFIELDNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHDEFIELDNAME, "");
    }

    public final void setPSSYSSEARCHDEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHDEFIELDNAME, strValue);
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

    public final boolean isPSSYSSEARCHFIELDIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHFIELDID);
    }

    public final String getPSSYSSEARCHFIELDID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHFIELDID, "");
    }

    public final void setPSSYSSEARCHFIELDID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHFIELDID, strValue);
    }

    public final boolean isPSSYSSEARCHFIELDNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHFIELDNAME);
    }

    public final String getPSSYSSEARCHFIELDNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHFIELDNAME, "");
    }

    public final void setPSSYSSEARCHFIELDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHFIELDNAME, strValue);
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

    public final boolean isFIELDTAG2Null() {
        return this.IsParamNull(TAG_FIELDTAG2);
    }

    public final String getFIELDTAG2() {
        return this.GetParamStringValue(TAG_FIELDTAG2, "");
    }

    public final void setFIELDTAG2(String strValue) {
        this.SetParamValue(TAG_FIELDTAG2, strValue);
    }

    public final boolean isFIELDTAGNull() {
        return this.IsParamNull(TAG_FIELDTAG);
    }

    public final String getFIELDTAG() {
        return this.GetParamStringValue(TAG_FIELDTAG, "");
    }

    public final void setFIELDTAG(String strValue) {
        this.SetParamValue(TAG_FIELDTAG, strValue);
    }

    public final boolean isDEFAULTVALUETYPENull() {
        return this.IsParamNull(TAG_DEFAULTVALUETYPE);
    }

    public final String getDEFAULTVALUETYPE() {
        return this.GetParamStringValue(TAG_DEFAULTVALUETYPE, "");
    }

    public final void setDEFAULTVALUETYPE(String strValue) {
        this.SetParamValue(TAG_DEFAULTVALUETYPE, strValue);
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

    public final boolean isPSSYSTRANSLATORIDNull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORID);
    }

    public final String getPSSYSTRANSLATORID() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORID, "");
    }

    public final void setPSSYSTRANSLATORID(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORID, strValue);
    }

    public final boolean isPSSYSTRANSLATORNAMENull() {
        return this.IsParamNull(TAG_PSSYSTRANSLATORNAME);
    }

    public final String getPSSYSTRANSLATORNAME() {
        return this.GetParamStringValue(TAG_PSSYSTRANSLATORNAME, "");
    }

    public final void setPSSYSTRANSLATORNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTRANSLATORNAME, strValue);
    }

    public final boolean isFIELDSNull() {
        return this.IsParamNull(TAG_FIELDS);
    }

    public final String getFIELDS() {
        return this.GetParamStringValue(TAG_FIELDS, "");
    }

    public final void setFIELDS(String strValue) {
        this.SetParamValue(TAG_FIELDS, strValue);
    }

    public final boolean isFIELDPARAMSNull() {
        return this.IsParamNull(TAG_FIELDPARAMS);
    }

    public final String getFIELDPARAMS() {
        return this.GetParamStringValue(TAG_FIELDPARAMS, "");
    }

    public final void setFIELDPARAMS(String strValue) {
        this.SetParamValue(TAG_FIELDPARAMS, strValue);
    }
}

