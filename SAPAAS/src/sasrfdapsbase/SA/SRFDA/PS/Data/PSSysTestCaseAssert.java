/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTestCaseAssert
extends BaseDataEntity {
    public static final String ASSERTTYPE_RESULT = "RESULT";
    public static final String ASSERTTYPE_EXCEPTION = "EXCEPTION";
    public static final String ASSERTTYPE_DATAEXISTS = "DATAEXISTS";
    public static final String TAG_PSSYSTCASSERTID = "PSSYSTCASSERTID";
    public static final String TAG_PSSYSTCASSERTNAME = "PSSYSTCASSERTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTESTCASEID = "PSSYSTESTCASEID";
    public static final String TAG_PSSYSTESTCASENAME = "PSSYSTESTCASENAME";
    public static final String TAG_ASSERTRESULT = "ASSERTRESULT";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_ASSERTTYPE = "ASSERTTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EXCEPTIONNAME = "EXCEPTIONNAME";
    public static final String TAG_EXCEPTIONDATA = "EXCEPTIONDATA";
    public static final String TAG_EXCEPTIONDATA2 = "EXCEPTIONDATA2";
    public static final String TAG_PSSYSTCINPUTID = "PSSYSTCINPUTID";
    public static final String TAG_PSSYSTCINPUTNAME = "PSSYSTCINPUTNAME";
    public static final String TAG_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String TAG_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String TAG_ASSERTTAG = "ASSERTTAG";
    public static final String TAG_ASSERTTAG2 = "ASSERTTAG2";
    public static final String TAG_ASSERTTAG3 = "ASSERTTAG3";
    public static final String TAG_ASSERTTAG4 = "ASSERTTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";

    public final boolean isPSSYSTCASSERTIDNull() {
        return this.IsParamNull(TAG_PSSYSTCASSERTID);
    }

    public final String getPSSYSTCASSERTID() {
        return this.GetParamStringValue(TAG_PSSYSTCASSERTID, "");
    }

    public final void setPSSYSTCASSERTID(String strValue) {
        this.SetParamValue(TAG_PSSYSTCASSERTID, strValue);
    }

    public final boolean isPSSYSTCASSERTNAMENull() {
        return this.IsParamNull(TAG_PSSYSTCASSERTNAME);
    }

    public final String getPSSYSTCASSERTNAME() {
        return this.GetParamStringValue(TAG_PSSYSTCASSERTNAME, "");
    }

    public final void setPSSYSTCASSERTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTCASSERTNAME, strValue);
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

    public final boolean isPSSYSTESTCASEIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTCASEID);
    }

    public final String getPSSYSTESTCASEID() {
        return this.GetParamStringValue(TAG_PSSYSTESTCASEID, "");
    }

    public final void setPSSYSTESTCASEID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTCASEID, strValue);
    }

    public final boolean isPSSYSTESTCASENAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTCASENAME);
    }

    public final String getPSSYSTESTCASENAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTCASENAME, "");
    }

    public final void setPSSYSTESTCASENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTCASENAME, strValue);
    }

    public final boolean isASSERTRESULTNull() {
        return this.IsParamNull(TAG_ASSERTRESULT);
    }

    public final String getASSERTRESULT() {
        return this.GetParamStringValue(TAG_ASSERTRESULT, "");
    }

    public final void setASSERTRESULT(String strValue) {
        this.SetParamValue(TAG_ASSERTRESULT, strValue);
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

    public final boolean isASSERTTYPENull() {
        return this.IsParamNull(TAG_ASSERTTYPE);
    }

    public final String getASSERTTYPE() {
        return this.GetParamStringValue(TAG_ASSERTTYPE, "");
    }

    public final void setASSERTTYPE(String strValue) {
        this.SetParamValue(TAG_ASSERTTYPE, strValue);
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

    public final boolean isEXCEPTIONNAMENull() {
        return this.IsParamNull(TAG_EXCEPTIONNAME);
    }

    public final String getEXCEPTIONNAME() {
        return this.GetParamStringValue(TAG_EXCEPTIONNAME, "");
    }

    public final void setEXCEPTIONNAME(String strValue) {
        this.SetParamValue(TAG_EXCEPTIONNAME, strValue);
    }

    public final boolean isEXCEPTIONDATANull() {
        return this.IsParamNull(TAG_EXCEPTIONDATA);
    }

    public final String getEXCEPTIONDATA() {
        return this.GetParamStringValue(TAG_EXCEPTIONDATA, "");
    }

    public final void setEXCEPTIONDATA(String strValue) {
        this.SetParamValue(TAG_EXCEPTIONDATA, strValue);
    }

    public final boolean isEXCEPTIONDATA2Null() {
        return this.IsParamNull(TAG_EXCEPTIONDATA2);
    }

    public final String getEXCEPTIONDATA2() {
        return this.GetParamStringValue(TAG_EXCEPTIONDATA2, "");
    }

    public final void setEXCEPTIONDATA2(String strValue) {
        this.SetParamValue(TAG_EXCEPTIONDATA2, strValue);
    }

    public final boolean isPSSYSTCINPUTIDNull() {
        return this.IsParamNull(TAG_PSSYSTCINPUTID);
    }

    public final String getPSSYSTCINPUTID() {
        return this.GetParamStringValue(TAG_PSSYSTCINPUTID, "");
    }

    public final void setPSSYSTCINPUTID(String strValue) {
        this.SetParamValue(TAG_PSSYSTCINPUTID, strValue);
    }

    public final boolean isPSSYSTCINPUTNAMENull() {
        return this.IsParamNull(TAG_PSSYSTCINPUTNAME);
    }

    public final String getPSSYSTCINPUTNAME() {
        return this.GetParamStringValue(TAG_PSSYSTCINPUTNAME, "");
    }

    public final void setPSSYSTCINPUTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTCINPUTNAME, strValue);
    }

    public final boolean isPSSYSTESTDATAIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTDATAID);
    }

    public final String getPSSYSTESTDATAID() {
        return this.GetParamStringValue(TAG_PSSYSTESTDATAID, "");
    }

    public final void setPSSYSTESTDATAID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTDATAID, strValue);
    }

    public final boolean isPSSYSTESTDATANAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTDATANAME);
    }

    public final String getPSSYSTESTDATANAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTDATANAME, "");
    }

    public final void setPSSYSTESTDATANAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTDATANAME, strValue);
    }

    public final boolean isASSERTTAGNull() {
        return this.IsParamNull(TAG_ASSERTTAG);
    }

    public final String getASSERTTAG() {
        return this.GetParamStringValue(TAG_ASSERTTAG, "");
    }

    public final void setASSERTTAG(String strValue) {
        this.SetParamValue(TAG_ASSERTTAG, strValue);
    }

    public final boolean isASSERTTAG2Null() {
        return this.IsParamNull(TAG_ASSERTTAG2);
    }

    public final String getASSERTTAG2() {
        return this.GetParamStringValue(TAG_ASSERTTAG2, "");
    }

    public final void setASSERTTAG2(String strValue) {
        this.SetParamValue(TAG_ASSERTTAG2, strValue);
    }

    public final boolean isASSERTTAG3Null() {
        return this.IsParamNull(TAG_ASSERTTAG3);
    }

    public final String getASSERTTAG3() {
        return this.GetParamStringValue(TAG_ASSERTTAG3, "");
    }

    public final void setASSERTTAG3(String strValue) {
        this.SetParamValue(TAG_ASSERTTAG3, strValue);
    }

    public final boolean isASSERTTAG4Null() {
        return this.IsParamNull(TAG_ASSERTTAG4);
    }

    public final String getASSERTTAG4() {
        return this.GetParamStringValue(TAG_ASSERTTAG4, "");
    }

    public final void setASSERTTAG4(String strValue) {
        this.SetParamValue(TAG_ASSERTTAG4, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isTARGETTYPENull() {
        return this.IsParamNull(TAG_TARGETTYPE);
    }

    public final String getTARGETTYPE() {
        return this.GetParamStringValue(TAG_TARGETTYPE, "");
    }

    public final void setTARGETTYPE(String strValue) {
        this.SetParamValue(TAG_TARGETTYPE, strValue);
    }

    public final boolean isCUSTOMCODENull() {
        return this.IsParamNull(TAG_CUSTOMCODE);
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue(TAG_CUSTOMCODE, "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue(TAG_CUSTOMCODE, strValue);
    }
}

