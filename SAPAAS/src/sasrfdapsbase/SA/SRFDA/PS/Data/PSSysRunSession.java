/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysRunSession
extends BaseDataEntity {
    public static final String RUNMODE_STARTX = "STARTX";
    public static final String RUNMODE_PUBCODE = "PUBCODE";
    public static final String RUNMODE_PUBCODE2 = "PUBCODE2";
    public static final String RUNMODE_PUBDOC = "PUBDOC";
    public static final String RUNMODE_PUBMODEL = "PUBMODEL";
    public static final String RUNMODE_PACKVER = "PACKVER";
    public static final String RUNMODE_PACKVER2 = "PACKVER2";
    public static final String RUNMODE_PACKMOBAPP = "PACKMOBAPP";
    public static final String RUNMODE_STARTMSAPI = "STARTMSAPI";
    public static final String RUNMODE_STARTMSAPP = "STARTMSAPP";
    public static final String RUNMODE_DEPLOYPKG = "DEPLOYPKG";
    public static final String RUNMODE_STARTMSFUNC = "STARTMSFUNC";
    public static final String RUNMODE_PUBDYNAINSTMODEL = "PUBDYNAINSTMODEL";
    public static final String TAG_PSSYSRUNSESSIONID = "PSSYSRUNSESSIONID";
    public static final String TAG_PSSYSRUNSESSIONNAME = "PSSYSRUNSESSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_PSSYSAPPID2 = "PSSYSAPPID2";
    public static final String TAG_PSSYSAPPNAME2 = "PSSYSAPPNAME2";
    public static final String TAG_PSSYSTEMASID = "PSSYSTEMASID";
    public static final String TAG_PSSYSTEMASNAME = "PSSYSTEMASNAME";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String TAG_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String TAG_RUNSTATE = "RUNSTATE";
    public static final String TAG_REBUILDMODE = "REBUILDMODE";
    public static final String TAG_ENABLEVC = "ENABLEVC";
    public static final String TAG_RUNMODE = "RUNMODE";
    public static final String TAG_RUNPARAM = "RUNPARAM";
    public static final String TAG_RUNPARAM2 = "RUNPARAM2";
    public static final String TAG_RUNPARAM3 = "RUNPARAM3";
    public static final String TAG_RUNPARAM4 = "RUNPARAM4";
    public static final String TAG_RUNPARAM5 = "RUNPARAM5";
    public static final String TAG_RUNPARAM6 = "RUNPARAM6";
    public static final String TAG_PSSYSBDINSTCFGID = "PSSYSBDINSTCFGID";
    public static final String TAG_PSSYSBDINSTCFGNAME = "PSSYSBDINSTCFGNAME";
    public static final String TAG_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String TAG_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String TAG_PSDEVSLNMSDEPAPPID = "PSDEVSLNMSDEPAPPID";
    public static final String TAG_PSDEVSLNMSDEPAPPNAME = "PSDEVSLNMSDEPAPPNAME";
    public static final String TAG_PSDEVSLNMSDEPAPIID = "PSDEVSLNMSDEPAPIID";
    public static final String TAG_PSDEVSLNMSDEPAPINAME = "PSDEVSLNMSDEPAPINAME";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";
    public static final String TAG_PSSYSSERVICEAPINAME = "PSSYSSERVICEAPINAME";
    public static final String TAG_PSDEVSLNMSDEPFUNCID = "PSDEVSLNMSDEPFUNCID";
    public static final String TAG_PSDEVSLNMSDEPFUNCNAME = "PSDEVSLNMSDEPFUNCNAME";
    public static final String TAG_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String TAG_RUNPSSYSDYNAMODELID = "RUNPSSYSDYNAMODELID";
    public static final String TAG_RUNPSSYSDYNAMODELNAME = "RUNPSSYSDYNAMODELNAME";
    public static final String TAG_STOPWHENTEMPLERROR = "STOPWHENTEMPLERROR";
    public static final String TAG_DEBUGMODE = "DEBUGMODE";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_QUICKMODE = "QUICKMODE";
    public static final String TAG_RUNPARAM7 = "RUNPARAM7";
    public static final String TAG_RUNPARAM8 = "RUNPARAM8";
    public static final String TAG_RUNPARAM9 = "RUNPARAM9";
    public static final String TAG_RUNPARAM10 = "RUNPARAM10";
    public static final String TAG_RUNPARAM11 = "RUNPARAM11";
    public static final String TAG_RUNPARAM12 = "RUNPARAM12";

    public final boolean isPSSYSRUNSESSIONIDNull() {
        return this.IsParamNull(TAG_PSSYSRUNSESSIONID);
    }

    public final String getPSSYSRUNSESSIONID() {
        return this.GetParamStringValue(TAG_PSSYSRUNSESSIONID, "");
    }

    public final void setPSSYSRUNSESSIONID(String strValue) {
        this.SetParamValue(TAG_PSSYSRUNSESSIONID, strValue);
    }

    public final boolean isPSSYSRUNSESSIONNAMENull() {
        return this.IsParamNull(TAG_PSSYSRUNSESSIONNAME);
    }

    public final String getPSSYSRUNSESSIONNAME() {
        return this.GetParamStringValue(TAG_PSSYSRUNSESSIONNAME, "");
    }

    public final void setPSSYSRUNSESSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSRUNSESSIONNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isPSSYSAPPID2Null() {
        return this.IsParamNull(TAG_PSSYSAPPID2);
    }

    public final String getPSSYSAPPID2() {
        return this.GetParamStringValue(TAG_PSSYSAPPID2, "");
    }

    public final void setPSSYSAPPID2(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID2, strValue);
    }

    public final boolean isPSSYSAPPNAME2Null() {
        return this.IsParamNull(TAG_PSSYSAPPNAME2);
    }

    public final String getPSSYSAPPNAME2() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME2, "");
    }

    public final void setPSSYSAPPNAME2(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME2, strValue);
    }

    public final boolean isPSSYSTEMASIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMASID);
    }

    public final String getPSSYSTEMASID() {
        return this.GetParamStringValue(TAG_PSSYSTEMASID, "");
    }

    public final void setPSSYSTEMASID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMASID, strValue);
    }

    public final boolean isPSSYSTEMASNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMASNAME);
    }

    public final String getPSSYSTEMASNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMASNAME, "");
    }

    public final void setPSSYSTEMASNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMASNAME, strValue);
    }

    public final boolean isSTARTTIMENull() {
        return this.IsParamNull(TAG_STARTTIME);
    }

    public final Date getSTARTTIME() {
        return this.GetParamDateValue(TAG_STARTTIME, null);
    }

    public final void setSTARTTIME(Date dtValue) {
        this.SetParamValue(TAG_STARTTIME, dtValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
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

    public final boolean isPSSYSTEMDBCFGIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGID);
    }

    public final String getPSSYSTEMDBCFGID() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGID, "");
    }

    public final void setPSSYSTEMDBCFGID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGID, strValue);
    }

    public final boolean isPSSYSTEMDBCFGNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGNAME);
    }

    public final String getPSSYSTEMDBCFGNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGNAME, "");
    }

    public final void setPSSYSTEMDBCFGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGNAME, strValue);
    }

    public final boolean isRUNSTATENull() {
        return this.IsParamNull(TAG_RUNSTATE);
    }

    public final int getRUNSTATE() {
        return this.GetParamIntValue(TAG_RUNSTATE, 0);
    }

    public final void setRUNSTATE(int nValue) {
        this.SetParamValue(TAG_RUNSTATE, nValue);
    }

    public final boolean isREBUILDMODENull() {
        return this.IsParamNull(TAG_REBUILDMODE);
    }

    public final boolean getREBUILDMODE() {
        return this.GetParamIntValue(TAG_REBUILDMODE, 0) == 1;
    }

    public final void setREBUILDMODE(boolean bValue) {
        this.SetParamValue(TAG_REBUILDMODE, bValue ? 1 : 0);
    }

    public final boolean isENABLEVCNull() {
        return this.IsParamNull(TAG_ENABLEVC);
    }

    public final boolean getENABLEVC() {
        return this.GetParamIntValue(TAG_ENABLEVC, 0) == 1;
    }

    public final void setENABLEVC(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVC, bValue ? 1 : 0);
    }

    public final boolean isRUNMODENull() {
        return this.IsParamNull(TAG_RUNMODE);
    }

    public final String getRUNMODE() {
        return this.GetParamStringValue(TAG_RUNMODE, "");
    }

    public final void setRUNMODE(String strValue) {
        this.SetParamValue(TAG_RUNMODE, strValue);
    }

    public final boolean isRUNPARAMNull() {
        return this.IsParamNull(TAG_RUNPARAM);
    }

    public final String getRUNPARAM() {
        return this.GetParamStringValue(TAG_RUNPARAM, "");
    }

    public final void setRUNPARAM(String strValue) {
        this.SetParamValue(TAG_RUNPARAM, strValue);
    }

    public final boolean isRUNPARAM2Null() {
        return this.IsParamNull(TAG_RUNPARAM2);
    }

    public final String getRUNPARAM2() {
        return this.GetParamStringValue(TAG_RUNPARAM2, "");
    }

    public final void setRUNPARAM2(String strValue) {
        this.SetParamValue(TAG_RUNPARAM2, strValue);
    }

    public final boolean isRUNPARAM3Null() {
        return this.IsParamNull(TAG_RUNPARAM3);
    }

    public final String getRUNPARAM3() {
        return this.GetParamStringValue(TAG_RUNPARAM3, "");
    }

    public final void setRUNPARAM3(String strValue) {
        this.SetParamValue(TAG_RUNPARAM3, strValue);
    }

    public final boolean isRUNPARAM4Null() {
        return this.IsParamNull(TAG_RUNPARAM4);
    }

    public final String getRUNPARAM4() {
        return this.GetParamStringValue(TAG_RUNPARAM4, "");
    }

    public final void setRUNPARAM4(String strValue) {
        this.SetParamValue(TAG_RUNPARAM4, strValue);
    }

    public final boolean isRUNPARAM5Null() {
        return this.IsParamNull(TAG_RUNPARAM5);
    }

    public final int getRUNPARAM5() {
        return this.GetParamIntValue(TAG_RUNPARAM5, 0);
    }

    public final void setRUNPARAM5(int nValue) {
        this.SetParamValue(TAG_RUNPARAM5, nValue);
    }

    public final boolean isRUNPARAM6Null() {
        return this.IsParamNull(TAG_RUNPARAM6);
    }

    public final int getRUNPARAM6() {
        return this.GetParamIntValue(TAG_RUNPARAM6, 0);
    }

    public final void setRUNPARAM6(int nValue) {
        this.SetParamValue(TAG_RUNPARAM6, nValue);
    }

    public final boolean isPSMOBAPPPACKIDNull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKID);
    }

    public final String getPSMOBAPPPACKID() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKID, "");
    }

    public final void setPSMOBAPPPACKID(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKID, strValue);
    }

    public final boolean isPSMOBAPPPACKNAMENull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKNAME);
    }

    public final String getPSMOBAPPPACKNAME() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKNAME, "");
    }

    public final void setPSMOBAPPPACKNAME(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKNAME, strValue);
    }

    public final boolean isPSDEVSLNMSDEPAPPIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPPID);
    }

    public final String getPSDEVSLNMSDEPAPPID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPAPPID, "");
    }

    public final void setPSDEVSLNMSDEPAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPPID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPPNAME);
    }

    public final String getPSDEVSLNMSDEPAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPAPPNAME, "");
    }

    public final void setPSDEVSLNMSDEPAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPPNAME, strValue);
    }

    public final boolean isPSDEVSLNMSDEPAPIIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPIID);
    }

    public final String getPSDEVSLNMSDEPAPIID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPAPIID, "");
    }

    public final void setPSDEVSLNMSDEPAPIID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPIID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPAPINAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPINAME);
    }

    public final String getPSDEVSLNMSDEPAPINAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPAPINAME, "");
    }

    public final void setPSDEVSLNMSDEPAPINAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPINAME, strValue);
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

    public final boolean isPSSYSSERVICEAPINAMENull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPINAME);
    }

    public final String getPSSYSSERVICEAPINAME() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPINAME, "");
    }

    public final void setPSSYSSERVICEAPINAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPINAME, strValue);
    }

    public final boolean isPSDEVSLNMSDEPFUNCIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPFUNCID);
    }

    public final String getPSDEVSLNMSDEPFUNCID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPFUNCID, "");
    }

    public final void setPSDEVSLNMSDEPFUNCID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPFUNCID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPFUNCNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPFUNCNAME);
    }

    public final String getPSDEVSLNMSDEPFUNCNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPFUNCNAME, "");
    }

    public final void setPSDEVSLNMSDEPFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPFUNCNAME, strValue);
    }

    public final boolean isPSDSCONSOLEIDNull() {
        return this.IsParamNull(TAG_PSDSCONSOLEID);
    }

    public final String getPSDSCONSOLEID() {
        return this.GetParamStringValue(TAG_PSDSCONSOLEID, "");
    }

    public final void setPSDSCONSOLEID(String strValue) {
        this.SetParamValue(TAG_PSDSCONSOLEID, strValue);
    }

    public final boolean isRUNPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_RUNPSSYSDYNAMODELID);
    }

    public final String getRUNPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_RUNPSSYSDYNAMODELID, "");
    }

    public final void setRUNPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_RUNPSSYSDYNAMODELID, strValue);
    }

    public final boolean isRUNPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_RUNPSSYSDYNAMODELNAME);
    }

    public final String getRUNPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_RUNPSSYSDYNAMODELNAME, "");
    }

    public final void setRUNPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_RUNPSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isSTOPWHENTEMPLERRORNull() {
        return this.IsParamNull(TAG_STOPWHENTEMPLERROR);
    }

    public final boolean getSTOPWHENTEMPLERROR() {
        return this.GetParamIntValue(TAG_STOPWHENTEMPLERROR, 0) == 1;
    }

    public final void setSTOPWHENTEMPLERROR(boolean bValue) {
        this.SetParamValue(TAG_STOPWHENTEMPLERROR, bValue ? 1 : 0);
    }

    public final boolean isDEBUGMODENull() {
        return this.IsParamNull(TAG_DEBUGMODE);
    }

    public final boolean getDEBUGMODE() {
        return this.GetParamIntValue(TAG_DEBUGMODE, 0) == 1;
    }

    public final void setDEBUGMODE(boolean bValue) {
        this.SetParamValue(TAG_DEBUGMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
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

    public final boolean isQUICKMODENull() {
        return this.IsParamNull(TAG_QUICKMODE);
    }

    public final int getQUICKMODE() {
        return this.GetParamIntValue(TAG_QUICKMODE, 0);
    }

    public final void setQUICKMODE(int bValue) {
        this.SetParamValue(TAG_QUICKMODE, bValue);
    }

    public final boolean isRUNPARAM7Null() {
        return this.IsParamNull(TAG_RUNPARAM7);
    }

    public final String getRUNPARAM7() {
        return this.GetParamStringValue(TAG_RUNPARAM7, "");
    }

    public final void setRUNPARAM7(String strValue) {
        this.SetParamValue(TAG_RUNPARAM7, strValue);
    }

    public final boolean isRUNPARAM8Null() {
        return this.IsParamNull(TAG_RUNPARAM8);
    }

    public final String getRUNPARAM8() {
        return this.GetParamStringValue(TAG_RUNPARAM8, "");
    }

    public final void setRUNPARAM8(String strValue) {
        this.SetParamValue(TAG_RUNPARAM8, strValue);
    }

    public final boolean isRUNPARAM9Null() {
        return this.IsParamNull(TAG_RUNPARAM9);
    }

    public final String getRUNPARAM9() {
        return this.GetParamStringValue(TAG_RUNPARAM9, "");
    }

    public final void setRUNPARAM9(String strValue) {
        this.SetParamValue(TAG_RUNPARAM9, strValue);
    }

    public final boolean isRUNPARAM10Null() {
        return this.IsParamNull(TAG_RUNPARAM10);
    }

    public final String getRUNPARAM10() {
        return this.GetParamStringValue(TAG_RUNPARAM10, "");
    }

    public final void setRUNPARAM10(String strValue) {
        this.SetParamValue(TAG_RUNPARAM10, strValue);
    }

    public final boolean isRUNPARAM11Null() {
        return this.IsParamNull(TAG_RUNPARAM11);
    }

    public final String getRUNPARAM11() {
        return this.GetParamStringValue(TAG_RUNPARAM11, "");
    }

    public final void setRUNPARAM11(String strValue) {
        this.SetParamValue(TAG_RUNPARAM11, strValue);
    }

    public final boolean isRUNPARAM12Null() {
        return this.IsParamNull(TAG_RUNPARAM12);
    }

    public final String getRUNPARAM12() {
        return this.GetParamStringValue(TAG_RUNPARAM12, "");
    }

    public final void setRUNPARAM12(String strValue) {
        this.SetParamValue(TAG_RUNPARAM12, strValue);
    }
}

