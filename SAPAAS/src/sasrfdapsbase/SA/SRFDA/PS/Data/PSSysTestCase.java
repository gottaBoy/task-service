/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTestCase
extends BaseDataEntity {
    public static final String TARGETTYPE_DEFVR = "DEFVR";
    public static final String TARGETTYPE_DEACTION = "DEACTION";
    public static final String TARGETTYPE_DELOGIC = "DELOGIC";
    public static final String TARGETTYPE_DESADETAIL = "DESADETAIL";
    public static final String TARGETTYPE_APPVIEW = "APPVIEW";
    public static final String ASSERTTYPE_RESULT = "RESULT";
    public static final String ASSERTTYPE_EXCEPTION = "EXCEPTION";
    public static final String ASSERTTYPE_DATAEXISTS = "DATAEXISTS";
    public static final String TAG_PSSYSTESTCASEID = "PSSYSTESTCASEID";
    public static final String TAG_PSSYSTESTCASENAME = "PSSYSTESTCASENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USERFLAG = "USERFLAG";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_TESTCASESN = "TESTCASESN";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";
    public static final String TAG_ROLLBACKTRAN = "ROLLBACKTRAN";
    public static final String TAG_PSSYSTESTDATAID = "PSSYSTESTDATAID";
    public static final String TAG_PSSYSTESTDATANAME = "PSSYSTESTDATANAME";
    public static final String TAG_DEFPSSYSSAMPLEVALUEID = "DEFPSSYSSAMPLEVALUEID";
    public static final String TAG_DEFPSSYSSAMPLEVALUENAME = "DEFPSSYSSAMPLEVALUENAME";
    public static final String TAG_INPUTVALUES = "INPUTVALUES";
    public static final String TAG_DEFVALUE = "DEFVALUE";
    public static final String TAG_ACTIONPARAMS = "ACTIONPARAMS";
    public static final String TAG_ASSERTTYPE = "ASSERTTYPE";
    public static final String TAG_ASSERTRESULT = "ASSERTRESULT";
    public static final String TAG_EXCEPTIONNAME = "EXCEPTIONNAME";
    public static final String TAG_EXCEPTIONDATA2 = "EXCEPTIONDATA2";
    public static final String TAG_EXCEPTIONDATA = "EXCEPTIONDATA";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_PSSYSTESTPRJID = "PSSYSTESTPRJID";
    public static final String TAG_PSSYSTESTPRJNAME = "PSSYSTESTPRJNAME";
    public static final String TAG_PSSYSTESTMODULEID = "PSSYSTESTMODULEID";
    public static final String TAG_PSSYSTESTMODULENAME = "PSSYSTESTMODULENAME";
    public static final String TAG_PSDESADETAILID = "PSDESADETAILID";
    public static final String TAG_PSDESADETAILNAME = "PSDESADETAILNAME";
    public static final String TAG_PSDESERVICEAPIID = "PSDESERVICEAPIID";
    public static final String TAG_PSDESERVICEAPINAME = "PSDESERVICEAPINAME";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";

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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.IsParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.GetParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSDELOGICNAME, strValue);
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

    public final boolean isUSERFLAGNull() {
        return this.IsParamNull(TAG_USERFLAG);
    }

    public final boolean getUSERFLAG() {
        return this.GetParamIntValue(TAG_USERFLAG, 0) == 1;
    }

    public final void setUSERFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERFLAG, bValue ? 1 : 0);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isTESTCASESNNull() {
        return this.IsParamNull(TAG_TESTCASESN);
    }

    public final String getTESTCASESN() {
        return this.GetParamStringValue(TAG_TESTCASESN, "");
    }

    public final void setTESTCASESN(String strValue) {
        this.SetParamValue(TAG_TESTCASESN, strValue);
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

    public final boolean isUSERDATANull() {
        return this.IsParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.IsParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isUSERDATA3Null() {
        return this.IsParamNull(TAG_USERDATA3);
    }

    public final String getUSERDATA3() {
        return this.GetParamStringValue(TAG_USERDATA3, "");
    }

    public final void setUSERDATA3(String strValue) {
        this.SetParamValue(TAG_USERDATA3, strValue);
    }

    public final boolean isUSERDATA4Null() {
        return this.IsParamNull(TAG_USERDATA4);
    }

    public final String getUSERDATA4() {
        return this.GetParamStringValue(TAG_USERDATA4, "");
    }

    public final void setUSERDATA4(String strValue) {
        this.SetParamValue(TAG_USERDATA4, strValue);
    }

    public final boolean isROLLBACKTRANNull() {
        return this.IsParamNull(TAG_ROLLBACKTRAN);
    }

    public final boolean getROLLBACKTRAN() {
        return this.GetParamIntValue(TAG_ROLLBACKTRAN, 0) == 1;
    }

    public final void setROLLBACKTRAN(boolean bValue) {
        this.SetParamValue(TAG_ROLLBACKTRAN, bValue ? 1 : 0);
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

    public final boolean isINPUTVALUESNull() {
        return this.IsParamNull(TAG_INPUTVALUES);
    }

    public final String getINPUTVALUES() {
        return this.GetParamStringValue(TAG_INPUTVALUES, "");
    }

    public final void setINPUTVALUES(String strValue) {
        this.SetParamValue(TAG_INPUTVALUES, strValue);
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

    public final boolean isACTIONPARAMSNull() {
        return this.IsParamNull(TAG_ACTIONPARAMS);
    }

    public final String getACTIONPARAMS() {
        return this.GetParamStringValue(TAG_ACTIONPARAMS, "");
    }

    public final void setACTIONPARAMS(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAMS, strValue);
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

    public final boolean isASSERTRESULTNull() {
        return this.IsParamNull(TAG_ASSERTRESULT);
    }

    public final String getASSERTRESULT() {
        return this.GetParamStringValue(TAG_ASSERTRESULT, "");
    }

    public final void setASSERTRESULT(String strValue) {
        this.SetParamValue(TAG_ASSERTRESULT, strValue);
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

    public final boolean isEXCEPTIONDATA2Null() {
        return this.IsParamNull(TAG_EXCEPTIONDATA2);
    }

    public final String getEXCEPTIONDATA2() {
        return this.GetParamStringValue(TAG_EXCEPTIONDATA2, "");
    }

    public final void setEXCEPTIONDATA2(String strValue) {
        this.SetParamValue(TAG_EXCEPTIONDATA2, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }

    public final boolean isPSSYSTESTPRJIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTPRJID);
    }

    public final String getPSSYSTESTPRJID() {
        return this.GetParamStringValue(TAG_PSSYSTESTPRJID, "");
    }

    public final void setPSSYSTESTPRJID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTPRJID, strValue);
    }

    public final boolean isPSSYSTESTPRJNAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTPRJNAME);
    }

    public final String getPSSYSTESTPRJNAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTPRJNAME, "");
    }

    public final void setPSSYSTESTPRJNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTPRJNAME, strValue);
    }

    public final boolean isPSSYSTESTMODULEIDNull() {
        return this.IsParamNull(TAG_PSSYSTESTMODULEID);
    }

    public final String getPSSYSTESTMODULEID() {
        return this.GetParamStringValue(TAG_PSSYSTESTMODULEID, "");
    }

    public final void setPSSYSTESTMODULEID(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTMODULEID, strValue);
    }

    public final boolean isPSSYSTESTMODULENAMENull() {
        return this.IsParamNull(TAG_PSSYSTESTMODULENAME);
    }

    public final String getPSSYSTESTMODULENAME() {
        return this.GetParamStringValue(TAG_PSSYSTESTMODULENAME, "");
    }

    public final void setPSSYSTESTMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTESTMODULENAME, strValue);
    }

    public final boolean isPSDESADETAILIDNull() {
        return this.IsParamNull(TAG_PSDESADETAILID);
    }

    public final String getPSDESADETAILID() {
        return this.GetParamStringValue(TAG_PSDESADETAILID, "");
    }

    public final void setPSDESADETAILID(String strValue) {
        this.SetParamValue(TAG_PSDESADETAILID, strValue);
    }

    public final boolean isPSDESADETAILNAMENull() {
        return this.IsParamNull(TAG_PSDESADETAILNAME);
    }

    public final String getPSDESADETAILNAME() {
        return this.GetParamStringValue(TAG_PSDESADETAILNAME, "");
    }

    public final void setPSDESADETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDESADETAILNAME, strValue);
    }

    public final boolean isPSDESERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSDESERVICEAPIID);
    }

    public final String getPSDESERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSDESERVICEAPIID, "");
    }

    public final void setPSDESERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSDESERVICEAPIID, strValue);
    }

    public final boolean isPSDESERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSDESERVICEAPINAME);
    }

    public final String getPSDESERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSDESERVICEAPINAME, "");
    }

    public final void setPSDESERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSDESERVICEAPINAME, strValue);
    }

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWNAME, strValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }
}

