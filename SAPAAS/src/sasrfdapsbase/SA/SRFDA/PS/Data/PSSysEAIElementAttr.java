/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEAIElementAttr
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
    public static final String EAIELEMENTATTRTYPE_SIMPLE = "SIMPLE";
    public static final String EAIELEMENTATTRTYPE_GROUP = "GROUP";
    public static final String TAG_PSSYSEAIELEMENTATTRID = "PSSYSEAIELEMENTATTRID";
    public static final String TAG_PSSYSEAIELEMENTATTRNAME = "PSSYSEAIELEMENTATTRNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String TAG_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String TAG_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String TAG_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String TAG_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String TAG_FIXEDVALUE = "FIXEDVALUE";
    public static final String TAG_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_ATTRTAG = "ATTRTAG";
    public static final String TAG_ATTRTAG2 = "ATTRTAG2";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_EAIELEMENTATTRTYPE = "EAIELEMENTATTRTYPE";
    public static final String TAG_REFPSSYSEAIELEMENTID = "REFPSSYSEAIELEMENTID";
    public static final String TAG_REFPSSYSEAIELEMENTNAME = "REFPSSYSEAIELEMENTNAME";
    public static final String TAG_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";

    public final boolean isPSSYSEAIELEMENTATTRIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTATTRID);
    }

    public final String getPSSYSEAIELEMENTATTRID() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTATTRID, "");
    }

    public final void setPSSYSEAIELEMENTATTRID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTATTRID, strValue);
    }

    public final boolean isPSSYSEAIELEMENTATTRNAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIELEMENTATTRNAME);
    }

    public final String getPSSYSEAIELEMENTATTRNAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIELEMENTATTRNAME, "");
    }

    public final void setPSSYSEAIELEMENTATTRNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIELEMENTATTRNAME, strValue);
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

    public final boolean isPSSYSEAIDATATYPEIDNull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPEID);
    }

    public final String getPSSYSEAIDATATYPEID() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPEID, "");
    }

    public final void setPSSYSEAIDATATYPEID(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPEID, strValue);
    }

    public final boolean isPSSYSEAIDATATYPENAMENull() {
        return this.IsParamNull(TAG_PSSYSEAIDATATYPENAME);
    }

    public final String getPSSYSEAIDATATYPENAME() {
        return this.GetParamStringValue(TAG_PSSYSEAIDATATYPENAME, "");
    }

    public final void setPSSYSEAIDATATYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSEAIDATATYPENAME, strValue);
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

    public final boolean isFIXEDVALUENull() {
        return this.IsParamNull(TAG_FIXEDVALUE);
    }

    public final String getFIXEDVALUE() {
        return this.GetParamStringValue(TAG_FIXEDVALUE, "");
    }

    public final void setFIXEDVALUE(String strValue) {
        this.SetParamValue(TAG_FIXEDVALUE, strValue);
    }

    public final boolean isALLOWEMPTYNull() {
        return this.IsParamNull(TAG_ALLOWEMPTY);
    }

    public final boolean getALLOWEMPTY() {
        return this.GetParamIntValue(TAG_ALLOWEMPTY, 0) == 1;
    }

    public final void setALLOWEMPTY(boolean bValue) {
        this.SetParamValue(TAG_ALLOWEMPTY, bValue ? 1 : 0);
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

    public final boolean isATTRTAGNull() {
        return this.IsParamNull(TAG_ATTRTAG);
    }

    public final String getATTRTAG() {
        return this.GetParamStringValue(TAG_ATTRTAG, "");
    }

    public final void setATTRTAG(String strValue) {
        this.SetParamValue(TAG_ATTRTAG, strValue);
    }

    public final boolean isATTRTAG2Null() {
        return this.IsParamNull(TAG_ATTRTAG2);
    }

    public final String getATTRTAG2() {
        return this.GetParamStringValue(TAG_ATTRTAG2, "");
    }

    public final void setATTRTAG2(String strValue) {
        this.SetParamValue(TAG_ATTRTAG2, strValue);
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

    public final boolean isEAIELEMENTATTRTYPENull() {
        return this.IsParamNull(TAG_EAIELEMENTATTRTYPE);
    }

    public final String getEAIELEMENTATTRTYPE() {
        return this.GetParamStringValue(TAG_EAIELEMENTATTRTYPE, "");
    }

    public final void setEAIELEMENTATTRTYPE(String strValue) {
        this.SetParamValue(TAG_EAIELEMENTATTRTYPE, strValue);
    }

    public final boolean isREFPSSYSEAIELEMENTIDNull() {
        return this.IsParamNull(TAG_REFPSSYSEAIELEMENTID);
    }

    public final String getREFPSSYSEAIELEMENTID() {
        return this.GetParamStringValue(TAG_REFPSSYSEAIELEMENTID, "");
    }

    public final void setREFPSSYSEAIELEMENTID(String strValue) {
        this.SetParamValue(TAG_REFPSSYSEAIELEMENTID, strValue);
    }

    public final boolean isREFPSSYSEAIELEMENTNAMENull() {
        return this.IsParamNull(TAG_REFPSSYSEAIELEMENTNAME);
    }

    public final String getREFPSSYSEAIELEMENTNAME() {
        return this.GetParamStringValue(TAG_REFPSSYSEAIELEMENTNAME, "");
    }

    public final void setREFPSSYSEAIELEMENTNAME(String strValue) {
        this.SetParamValue(TAG_REFPSSYSEAIELEMENTNAME, strValue);
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
}

