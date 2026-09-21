/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTestCaseInput
extends BaseDataEntity {
    public static final String INPUTTYPE_DATA = "DATA";
    public static final String INPUTTYPE_CUSTOMCODE = "CUSTOMCODE";
    public static final String INPUTTYPE_USER = "USER";
    public static final String INPUTTYPE_USER2 = "USER2";
    public static final String INPUTTYPE_USER3 = "USER3";
    public static final String INPUTTYPE_USER4 = "USER4";
    public static final String TAG_PSSYSTCINPUTID = "PSSYSTCINPUTID";
    public static final String TAG_PSSYSTCINPUTNAME = "PSSYSTCINPUTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTESTCASEID = "PSSYSTESTCASEID";
    public static final String TAG_PSSYSTESTCASENAME = "PSSYSTESTCASENAME";
    public static final String TAG_INPUTVALUES = "INPUTVALUES";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String TAG_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String TAG_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String TAG_TESTDATASN = "TESTDATASN";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_DEFVALUE = "DEFVALUE";
    public static final String TAG_DEFPSSYSSAMPLEVALUEID = "DEFPSSYSSAMPLEVALUEID";
    public static final String TAG_DEFPSSYSSAMPLEVALUENAME = "DEFPSSYSSAMPLEVALUENAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_INPUTTAG = "INPUTTAG";
    public static final String TAG_INPUTTAG2 = "INPUTTAG2";
    public static final String TAG_INPUTTAG3 = "INPUTTAG3";
    public static final String TAG_INPUTTAG4 = "INPUTTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_CUSTOMCODE = "CUSTOMCODE";
    public static final String TAG_INPUTTYPE = "INPUTTYPE";

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

    public final boolean isINPUTVALUESNull() {
        return this.IsParamNull(TAG_INPUTVALUES);
    }

    public final String getINPUTVALUES() {
        return this.GetParamStringValue(TAG_INPUTVALUES, "");
    }

    public final void setINPUTVALUES(String strValue) {
        this.SetParamValue(TAG_INPUTVALUES, strValue);
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

    public final boolean isACTIONPARAMSNull() {
        return this.IsParamNull(TAG_ACTIONPARAMS);
    }

    public final String getACTIONPARAMS() {
        return this.GetParamStringValue(TAG_ACTIONPARAMS, "");
    }

    public final void setACTIONPARAMS(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAMS, strValue);
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

    public final boolean isTESTDATASNNull() {
        return this.IsParamNull(TAG_TESTDATASN);
    }

    public final int getTESTDATASN() {
        return this.GetParamIntValue(TAG_TESTDATASN, 0);
    }

    public final void setTESTDATASN(int nValue) {
        this.SetParamValue(TAG_TESTDATASN, nValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isDEFVALUENull() {
        return this.IsParamNull(TAG_DEFVALUE);
    }

    public final String getDEFVALUE() {
        return this.GetParamStringValue(TAG_DEFVALUE, "");
    }

    public final void setDEFVALUE(String strValue) {
        this.SetParamValue(TAG_DEFVALUE, strValue);
    }

    public final boolean isDEFPSSYSSAMPLEVALUEIDNull() {
        return this.IsParamNull(TAG_DEFPSSYSSAMPLEVALUEID);
    }

    public final String getDEFPSSYSSAMPLEVALUEID() {
        return this.GetParamStringValue(TAG_DEFPSSYSSAMPLEVALUEID, "");
    }

    public final void setDEFPSSYSSAMPLEVALUEID(String strValue) {
        this.SetParamValue(TAG_DEFPSSYSSAMPLEVALUEID, strValue);
    }

    public final boolean isDEFPSSYSSAMPLEVALUENAMENull() {
        return this.IsParamNull(TAG_DEFPSSYSSAMPLEVALUENAME);
    }

    public final String getDEFPSSYSSAMPLEVALUENAME() {
        return this.GetParamStringValue(TAG_DEFPSSYSSAMPLEVALUENAME, "");
    }

    public final void setDEFPSSYSSAMPLEVALUENAME(String strValue) {
        this.SetParamValue(TAG_DEFPSSYSSAMPLEVALUENAME, strValue);
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

    public final boolean isINPUTTAGNull() {
        return this.IsParamNull(TAG_INPUTTAG);
    }

    public final String getINPUTTAG() {
        return this.GetParamStringValue(TAG_INPUTTAG, "");
    }

    public final void setINPUTTAG(String strValue) {
        this.SetParamValue(TAG_INPUTTAG, strValue);
    }

    public final boolean isINPUTTAG2Null() {
        return this.IsParamNull(TAG_INPUTTAG2);
    }

    public final String getINPUTTAG2() {
        return this.GetParamStringValue(TAG_INPUTTAG2, "");
    }

    public final void setINPUTTAG2(String strValue) {
        this.SetParamValue(TAG_INPUTTAG2, strValue);
    }

    public final boolean isINPUTTAG3Null() {
        return this.IsParamNull(TAG_INPUTTAG3);
    }

    public final String getINPUTTAG3() {
        return this.GetParamStringValue(TAG_INPUTTAG3, "");
    }

    public final void setINPUTTAG3(String strValue) {
        this.SetParamValue(TAG_INPUTTAG3, strValue);
    }

    public final boolean isINPUTTAG4Null() {
        return this.IsParamNull(TAG_INPUTTAG4);
    }

    public final String getINPUTTAG4() {
        return this.GetParamStringValue(TAG_INPUTTAG4, "");
    }

    public final void setINPUTTAG4(String strValue) {
        this.SetParamValue(TAG_INPUTTAG4, strValue);
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

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
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
        return this.IsParamNull("CUSTOMCODE");
    }

    public final String getCUSTOMCODE() {
        return this.GetParamStringValue("CUSTOMCODE", "");
    }

    public final void setCUSTOMCODE(String strValue) {
        this.SetParamValue("CUSTOMCODE", strValue);
    }

    public final boolean isINPUTTYPENull() {
        return this.IsParamNull(TAG_INPUTTYPE);
    }

    public final String getINPUTTYPE() {
        return this.GetParamStringValue(TAG_INPUTTYPE, "");
    }

    public final void setINPUTTYPE(String strValue) {
        this.SetParamValue(TAG_INPUTTYPE, strValue);
    }
}

