/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWorkflow
extends BaseDataEntity {
    public static final String WFENGINETYPE_EMBEDDED = "EMBEDDED";
    public static final String WFENGINETYPE_ACTIVITI = "ACTIVITI";
    public static final String WFTYPE_ORG = "ORG";
    public static final String WFTYPE_ORGSECTOR = "ORGSECTOR";
    public static final String WFTYPE_DEFAULT = "DEFAULT";
    public static final String TAG_PSWORKFLOWID = "PSWORKFLOWID";
    public static final String TAG_PSWORKFLOWNAME = "PSWORKFLOWNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_STATECODELISTID = "STATECODELISTID";
    public static final String TAG_STATECODELISTNAME = "STATECODELISTNAME";
    public static final String TAG_WFSTEPCODELISTID = "WFSTEPCODELISTID";
    public static final String TAG_WFSTEPCODELISTNAME = "WFSTEPCODELISTNAME";
    public static final String TAG_WFSTATEVALUE = "WFSTATEVALUE";
    public static final String TAG_EXTCNTSTATES = "EXTCNTSTATES";
    public static final String TAG_EDITABLEWFSTEP = "EDITABLEWFSTEP";
    public static final String TAG_WFSN = "WFSN";
    public static final String TAG_REMINDPSSYSMSGTEMPLID = "REMINDPSSYSMSGTEMPLID";
    public static final String TAG_REMINDPSSYSMSGTEMPLNAME = "REMINDPSSYSMSGTEMPLNAME";
    public static final String TAG_ENABLEMOB = "ENABLEMOB";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSWXACCOUNTID = "PSWXACCOUNTID";
    public static final String TAG_PSWXACCOUNTNAME = "PSWXACCOUNTNAME";
    public static final String TAG_PSWXENTAPPID = "PSWXENTAPPID";
    public static final String TAG_PSWXENTAPPNAME = "PSWXENTAPPNAME";
    public static final String TAG_ENABLEDYNAVIEW = "ENABLEDYNAVIEW";
    public static final String TAG_WFENGINETYPE = "WFENGINETYPE";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";
    public static final String TAG_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String TAG_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_REMOTEENGINEFLAG = "REMOTEENGINEFLAG";
    public static final String TAG_WFPROXYMODE = "WFPROXYMODE";
    public static final String TAG_STARTPSDEVIEWID = "STARTPSDEVIEWID";
    public static final String TAG_STARTPSDEVIEWNAME = "STARTPSDEVIEWNAME";
    public static final String TAG_STARTMOBPSDEVIEWID = "STARTMOBPSDEVIEWID";
    public static final String TAG_STARTMOBPSDEVIEWNAME = "STARTMOBPSDEVIEWNAME";
    public static final String TAG_ACTIONPSDEVIEWID = "ACTIONPSDEVIEWID";
    public static final String TAG_ACTIONPSDEVIEWNAME = "ACTIONPSDEVIEWNAME";
    public static final String TAG_ACTIONMOBPSDEVIEWID = "ACTIONMOBPSDEVIEWID";
    public static final String TAG_ACTIONMOBPSDEVIEWNAME = "ACTIONMOBPSDEVIEWNAME";
    public static final String TAG_WFTYPE = "WFTYPE";
    public static final String TAG_PSSYSWFCATID = "PSSYSWFCATID";
    public static final String TAG_PSSYSWFCATNAME = "PSSYSWFCATNAME";
    public static final String TAG_ACTIONVIEWCODENAME = "ACTIONVIEWCODENAME";
    public static final String TAG_ACTIONMOBVIEWCODENAME = "ACTIONMOBVIEWCODENAME";
    public static final String TAG_STARTMOBVIEWCODENAME = "STARTMOBVIEWCODENAME";
    public static final String TAG_STARTVIEWCODENAME = "STARTVIEWCODENAME";
    public static final String TAG_WFFINISHEVALUE = "WFFINISHEVALUE";
    public static final String TAG_WFERRORVALUE = "WFERRORVALUE";
    public static final String TAG_WFCANCELVALUE = "WFCANCELVALUE";
    public static final String TAG_WFCANCELVALUETEXT = "WFCANCELVALUETEXT";
    public static final String TAG_WFERRORVALUETEXT = "WFERRORVALUETEXT";
    public static final String TAG_WFFINISHEVALUETEXT = "WFFINISHEVALUETEXT";
    public static final String TAG_WFCATCODE = "WFCATCODE";

    public final boolean isPSWORKFLOWIDNull() {
        return this.IsParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.GetParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWID, strValue);
    }

    public final boolean isPSWORKFLOWNAMENull() {
        return this.IsParamNull(TAG_PSWORKFLOWNAME);
    }

    public final String getPSWORKFLOWNAME() {
        return this.GetParamStringValue(TAG_PSWORKFLOWNAME, "");
    }

    public final void setPSWORKFLOWNAME(String strValue) {
        this.SetParamValue(TAG_PSWORKFLOWNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isWFSTEPCODELISTIDNull() {
        return this.IsParamNull(TAG_WFSTEPCODELISTID);
    }

    public final String getWFSTEPCODELISTID() {
        return this.GetParamStringValue(TAG_WFSTEPCODELISTID, "");
    }

    public final void setWFSTEPCODELISTID(String strValue) {
        this.SetParamValue(TAG_WFSTEPCODELISTID, strValue);
    }

    public final boolean isWFSTEPCODELISTNAMENull() {
        return this.IsParamNull(TAG_WFSTEPCODELISTNAME);
    }

    public final String getWFSTEPCODELISTNAME() {
        return this.GetParamStringValue(TAG_WFSTEPCODELISTNAME, "");
    }

    public final void setWFSTEPCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPCODELISTNAME, strValue);
    }

    public final boolean isSTATECODELISTIDNull() {
        return this.IsParamNull(TAG_STATECODELISTID);
    }

    public final String getSTATECODELISTID() {
        return this.GetParamStringValue(TAG_STATECODELISTID, "");
    }

    public final void setSTATECODELISTID(String strValue) {
        this.SetParamValue(TAG_STATECODELISTID, strValue);
    }

    public final boolean isSTATECODELISTNAMENull() {
        return this.IsParamNull(TAG_STATECODELISTNAME);
    }

    public final String getSTATECODELISTNAME() {
        return this.GetParamStringValue(TAG_STATECODELISTNAME, "");
    }

    public final void setSTATECODELISTNAME(String strValue) {
        this.SetParamValue(TAG_STATECODELISTNAME, strValue);
    }

    public final boolean isWFSTATEVALUENull() {
        return this.IsParamNull(TAG_WFSTATEVALUE);
    }

    public final String getWFSTATEVALUE() {
        return this.GetParamStringValue(TAG_WFSTATEVALUE, "");
    }

    public final void setWFSTATEVALUE(String strValue) {
        this.SetParamValue(TAG_WFSTATEVALUE, strValue);
    }

    public final boolean isEXTCNTSTATESNull() {
        return this.IsParamNull(TAG_EXTCNTSTATES);
    }

    public final String getEXTCNTSTATES() {
        return this.GetParamStringValue(TAG_EXTCNTSTATES, "");
    }

    public final void setEXTCNTSTATES(String strValue) {
        this.SetParamValue(TAG_EXTCNTSTATES, strValue);
    }

    public final boolean isEDITABLEWFSTEPNull() {
        return this.IsParamNull(TAG_EDITABLEWFSTEP);
    }

    public final String getEDITABLEWFSTEP() {
        return this.GetParamStringValue(TAG_EDITABLEWFSTEP, "");
    }

    public final void setEDITABLEWFSTEP(String strValue) {
        this.SetParamValue(TAG_EDITABLEWFSTEP, strValue);
    }

    public final boolean isWFSNNull() {
        return this.IsParamNull(TAG_WFSN);
    }

    public final String getWFSN() {
        return this.GetParamStringValue(TAG_WFSN, "");
    }

    public final void setWFSN(String strValue) {
        this.SetParamValue(TAG_WFSN, strValue);
    }

    public final boolean isREMINDPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_REMINDPSSYSMSGTEMPLID);
    }

    public final String getREMINDPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_REMINDPSSYSMSGTEMPLID, "");
    }

    public final void setREMINDPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_REMINDPSSYSMSGTEMPLID, strValue);
    }

    public final boolean isREMINDPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_REMINDPSSYSMSGTEMPLNAME);
    }

    public final String getREMINDPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_REMINDPSSYSMSGTEMPLNAME, "");
    }

    public final void setREMINDPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_REMINDPSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isENABLEMOBNull() {
        return this.IsParamNull(TAG_ENABLEMOB);
    }

    public final boolean getENABLEMOB() {
        return this.GetParamIntValue(TAG_ENABLEMOB, 0) == 1;
    }

    public final void setENABLEMOB(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMOB, bValue ? 1 : 0);
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

    public final boolean isPSWXACCOUNTIDNull() {
        return this.IsParamNull(TAG_PSWXACCOUNTID);
    }

    public final String getPSWXACCOUNTID() {
        return this.GetParamStringValue(TAG_PSWXACCOUNTID, "");
    }

    public final void setPSWXACCOUNTID(String strValue) {
        this.SetParamValue(TAG_PSWXACCOUNTID, strValue);
    }

    public final boolean isPSWXACCOUNTNAMENull() {
        return this.IsParamNull(TAG_PSWXACCOUNTNAME);
    }

    public final String getPSWXACCOUNTNAME() {
        return this.GetParamStringValue(TAG_PSWXACCOUNTNAME, "");
    }

    public final void setPSWXACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_PSWXACCOUNTNAME, strValue);
    }

    public final boolean isPSWXENTAPPIDNull() {
        return this.IsParamNull(TAG_PSWXENTAPPID);
    }

    public final String getPSWXENTAPPID() {
        return this.GetParamStringValue(TAG_PSWXENTAPPID, "");
    }

    public final void setPSWXENTAPPID(String strValue) {
        this.SetParamValue(TAG_PSWXENTAPPID, strValue);
    }

    public final boolean isPSWXENTAPPNAMENull() {
        return this.IsParamNull(TAG_PSWXENTAPPNAME);
    }

    public final String getPSWXENTAPPNAME() {
        return this.GetParamStringValue(TAG_PSWXENTAPPNAME, "");
    }

    public final void setPSWXENTAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSWXENTAPPNAME, strValue);
    }

    public final boolean isENABLEDYNAVIEWNull() {
        return this.IsParamNull(TAG_ENABLEDYNAVIEW);
    }

    public final boolean getENABLEDYNAVIEW() {
        return this.GetParamIntValue(TAG_ENABLEDYNAVIEW, 0) == 1;
    }

    public final void setENABLEDYNAVIEW(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNAVIEW, bValue ? 1 : 0);
    }

    public final boolean isWFENGINETYPENull() {
        return this.IsParamNull(TAG_WFENGINETYPE);
    }

    public final String getWFENGINETYPE() {
        return this.GetParamStringValue(TAG_WFENGINETYPE, "");
    }

    public final void setWFENGINETYPE(String strValue) {
        this.SetParamValue(TAG_WFENGINETYPE, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }

    public final boolean isNAMEPSLANRESIDNull() {
        return this.IsParamNull(TAG_NAMEPSLANRESID);
    }

    public final String getNAMEPSLANRESID() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESID, "");
    }

    public final void setNAMEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESID, strValue);
    }

    public final boolean isNAMEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_NAMEPSLANRESNAME);
    }

    public final String getNAMEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_NAMEPSLANRESNAME, "");
    }

    public final void setNAMEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_NAMEPSLANRESNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isREMOTEENGINEFLAGNull() {
        return this.IsParamNull(TAG_REMOTEENGINEFLAG);
    }

    public final boolean getREMOTEENGINEFLAG() {
        return this.GetParamIntValue(TAG_REMOTEENGINEFLAG, 0) == 1;
    }

    public final void setREMOTEENGINEFLAG(boolean bValue) {
        this.SetParamValue(TAG_REMOTEENGINEFLAG, bValue ? 1 : 0);
    }

    public final boolean isWFPROXYMODENull() {
        return this.IsParamNull(TAG_WFPROXYMODE);
    }

    public final int getWFPROXYMODE() {
        return this.GetParamIntValue(TAG_WFPROXYMODE, 0);
    }

    public final void setWFPROXYMODE(int nValue) {
        this.SetParamValue(TAG_WFPROXYMODE, nValue);
    }

    public final boolean isSTARTPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_STARTPSDEVIEWID);
    }

    public final String getSTARTPSDEVIEWID() {
        return this.GetParamStringValue(TAG_STARTPSDEVIEWID, "");
    }

    public final void setSTARTPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_STARTPSDEVIEWID, strValue);
    }

    public final boolean isSTARTPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_STARTPSDEVIEWNAME);
    }

    public final String getSTARTPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_STARTPSDEVIEWNAME, "");
    }

    public final void setSTARTPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_STARTPSDEVIEWNAME, strValue);
    }

    public final boolean isSTARTMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_STARTMOBPSDEVIEWID);
    }

    public final String getSTARTMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_STARTMOBPSDEVIEWID, "");
    }

    public final void setSTARTMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_STARTMOBPSDEVIEWID, strValue);
    }

    public final boolean isSTARTMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_STARTMOBPSDEVIEWNAME);
    }

    public final String getSTARTMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_STARTMOBPSDEVIEWNAME, "");
    }

    public final void setSTARTMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_STARTMOBPSDEVIEWNAME, strValue);
    }

    public final boolean isACTIONPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_ACTIONPSDEVIEWID);
    }

    public final String getACTIONPSDEVIEWID() {
        return this.GetParamStringValue(TAG_ACTIONPSDEVIEWID, "");
    }

    public final void setACTIONPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_ACTIONPSDEVIEWID, strValue);
    }

    public final boolean isACTIONPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_ACTIONPSDEVIEWNAME);
    }

    public final String getACTIONPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_ACTIONPSDEVIEWNAME, "");
    }

    public final void setACTIONPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONPSDEVIEWNAME, strValue);
    }

    public final boolean isACTIONMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_ACTIONMOBPSDEVIEWID);
    }

    public final String getACTIONMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_ACTIONMOBPSDEVIEWID, "");
    }

    public final void setACTIONMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_ACTIONMOBPSDEVIEWID, strValue);
    }

    public final boolean isACTIONMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_ACTIONMOBPSDEVIEWNAME);
    }

    public final String getACTIONMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_ACTIONMOBPSDEVIEWNAME, "");
    }

    public final void setACTIONMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONMOBPSDEVIEWNAME, strValue);
    }

    public final boolean isPSSYSWFCATIDNull() {
        return this.IsParamNull(TAG_PSSYSWFCATID);
    }

    public final String getPSSYSWFCATID() {
        return this.GetParamStringValue(TAG_PSSYSWFCATID, "");
    }

    public final void setPSSYSWFCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSWFCATID, strValue);
    }

    public final boolean isPSSYSWFCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSWFCATNAME);
    }

    public final String getPSSYSWFCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSWFCATNAME, "");
    }

    public final void setPSSYSWFCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSWFCATNAME, strValue);
    }

    public final boolean isWFTYPENull() {
        return this.IsParamNull(TAG_WFTYPE);
    }

    public final String getWFTYPE() {
        return this.GetParamStringValue(TAG_WFTYPE, "");
    }

    public final void setWFTYPE(String strValue) {
        this.SetParamValue(TAG_WFTYPE, strValue);
    }

    public final boolean isACTIONVIEWCODENAMENull() {
        return this.IsParamNull(TAG_ACTIONVIEWCODENAME);
    }

    public final String getACTIONVIEWCODENAME() {
        return this.GetParamStringValue(TAG_ACTIONVIEWCODENAME, "");
    }

    public final void setACTIONVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_ACTIONVIEWCODENAME, strValue);
    }

    public final boolean isACTIONMOBVIEWCODENAMENull() {
        return this.IsParamNull(TAG_ACTIONMOBVIEWCODENAME);
    }

    public final String getACTIONMOBVIEWCODENAME() {
        return this.GetParamStringValue(TAG_ACTIONMOBVIEWCODENAME, "");
    }

    public final void setACTIONMOBVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_ACTIONMOBVIEWCODENAME, strValue);
    }

    public final boolean isSTARTMOBVIEWCODENAMENull() {
        return this.IsParamNull(TAG_STARTMOBVIEWCODENAME);
    }

    public final String getSTARTMOBVIEWCODENAME() {
        return this.GetParamStringValue(TAG_STARTMOBVIEWCODENAME, "");
    }

    public final void setSTARTMOBVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_STARTMOBVIEWCODENAME, strValue);
    }

    public final boolean isSTARTVIEWCODENAMENull() {
        return this.IsParamNull(TAG_STARTVIEWCODENAME);
    }

    public final String getSTARTVIEWCODENAME() {
        return this.GetParamStringValue(TAG_STARTVIEWCODENAME, "");
    }

    public final void setSTARTVIEWCODENAME(String strValue) {
        this.SetParamValue(TAG_STARTVIEWCODENAME, strValue);
    }

    public final boolean isWFFINISHEVALUENull() {
        return this.IsParamNull(TAG_WFFINISHEVALUE);
    }

    public final String getWFFINISHEVALUE() {
        return this.GetParamStringValue(TAG_WFFINISHEVALUE, "");
    }

    public final void setWFFINISHEVALUE(String strValue) {
        this.SetParamValue(TAG_WFFINISHEVALUE, strValue);
    }

    public final boolean isWFERRORVALUENull() {
        return this.IsParamNull(TAG_WFERRORVALUE);
    }

    public final String getWFERRORVALUE() {
        return this.GetParamStringValue(TAG_WFERRORVALUE, "");
    }

    public final void setWFERRORVALUE(String strValue) {
        this.SetParamValue(TAG_WFERRORVALUE, strValue);
    }

    public final boolean isWFCANCELVALUENull() {
        return this.IsParamNull(TAG_WFCANCELVALUE);
    }

    public final String getWFCANCELVALUE() {
        return this.GetParamStringValue(TAG_WFCANCELVALUE, "");
    }

    public final void setWFCANCELVALUE(String strValue) {
        this.SetParamValue(TAG_WFCANCELVALUE, strValue);
    }

    public final boolean isWFCANCELVALUETEXTNull() {
        return this.IsParamNull(TAG_WFCANCELVALUETEXT);
    }

    public final String getWFCANCELVALUETEXT() {
        return this.GetParamStringValue(TAG_WFCANCELVALUETEXT, "");
    }

    public final void setWFCANCELVALUETEXT(String strValue) {
        this.SetParamValue(TAG_WFCANCELVALUETEXT, strValue);
    }

    public final boolean isWFERRORVALUETEXTNull() {
        return this.IsParamNull(TAG_WFERRORVALUETEXT);
    }

    public final String getWFERRORVALUETEXT() {
        return this.GetParamStringValue(TAG_WFERRORVALUETEXT, "");
    }

    public final void setWFERRORVALUETEXT(String strValue) {
        this.SetParamValue(TAG_WFERRORVALUETEXT, strValue);
    }

    public final boolean isWFFINISHEVALUETEXTNull() {
        return this.IsParamNull(TAG_WFFINISHEVALUETEXT);
    }

    public final String getWFFINISHEVALUETEXT() {
        return this.GetParamStringValue(TAG_WFFINISHEVALUETEXT, "");
    }

    public final void setWFFINISHEVALUETEXT(String strValue) {
        this.SetParamValue(TAG_WFFINISHEVALUETEXT, strValue);
    }

    public final boolean isWFCATCODENull() {
        return this.IsParamNull(TAG_WFCATCODE);
    }

    public final String getWFCATCODE() {
        return this.GetParamStringValue(TAG_WFCATCODE, "");
    }

    public final void setWFCATCODE(String strValue) {
        this.SetParamValue(TAG_WFCATCODE, strValue);
    }
}

