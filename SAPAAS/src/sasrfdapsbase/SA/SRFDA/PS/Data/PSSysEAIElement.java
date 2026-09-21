/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEAIElement
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
    public static final String EAIELEMENTTYPE_COMPLEX = "COMPLEX";
    public static final String EAIELEMENTTYPE_ELEMENTGROUP = "ELEMENTGROUP";
    public static final String EAIELEMENTTYPE_ATTRIBUTEGROUP = "ATTRIBUTEGROUP";
    public static final String ORDERMODE_ALL = "ALL";
    public static final String ORDERMODE_CHOICE = "CHOICE";
    public static final String ORDERMODE_SEQUENCE = "SEQUENCE";
    public static final String TAG_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String TAG_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String TAG_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String TAG_EAIELEMENTTAG2 = "EAIELEMENTTAG2";
    public static final String TAG_EAIELEMENTTAG = "EAIELEMENTTAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EAIELEMENTTYPE = "EAIELEMENTTYPE";
    public static final String TAG_ORDERMODE = "ORDERMODE";

    public final boolean isPSSYSEAIELEMENTIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTID);
    }

    public final String getPSSYSEAIELEMENTID() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTID, "");
    }

    public final void setPSSYSEAIELEMENTID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTID, strValue);
    }

    public final boolean isPSSYSEAIELEMENTNAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTNAME);
    }

    public final String getPSSYSEAIELEMENTNAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTNAME, "");
    }

    public final void setPSSYSEAIELEMENTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTNAME, strValue);
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

    public final boolean isPSSYSEAISCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMEID);
    }

    public final String getPSSYSEAISCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMEID, "");
    }

    public final void setPSSYSEAISCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMEID, strValue);
    }

    public final boolean isPSSYSEAISCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAISCHEMENAME);
    }

    public final String getPSSYSEAISCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAISCHEMENAME, "");
    }

    public final void setPSSYSEAISCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAISCHEMENAME, strValue);
    }

    public final boolean isEAIELEMENTTAG2Null() {
        return this.IsParamNull(TAG_EAIELEMENTTAG2);
    }

    public final String getEAIELEMENTTAG2() {
        return this.GetParamStringValue(TAG_EAIELEMENTTAG2, "");
    }

    public final void setEAIELEMENTTAG2(String strValue) {
        this.SetParamValue(TAG_EAIELEMENTTAG2, strValue);
    }

    public final boolean isEAIELEMENTTAGNull() {
        return this.IsParamNull(TAG_EAIELEMENTTAG);
    }

    public final String getEAIELEMENTTAG() {
        return this.GetParamStringValue(TAG_EAIELEMENTTAG, "");
    }

    public final void setEAIELEMENTTAG(String strValue) {
        this.SetParamValue(TAG_EAIELEMENTTAG, strValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isEAIELEMENTTYPENull() {
        return this.IsParamNull(TAG_EAIELEMENTTYPE);
    }

    public final String getEAIELEMENTTYPE() {
        return this.GetParamStringValue(TAG_EAIELEMENTTYPE, "");
    }

    public final void setEAIELEMENTTYPE(String strValue) {
        this.SetParamValue(TAG_EAIELEMENTTYPE, strValue);
    }

    public final boolean isORDERMODENull() {
        return this.IsParamNull(TAG_ORDERMODE);
    }

    public final String getORDERMODE() {
        return this.GetParamStringValue(TAG_ORDERMODE, "");
    }

    public final void setORDERMODE(String strValue) {
        this.SetParamValue(TAG_ORDERMODE, strValue);
    }
}

