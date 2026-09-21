/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWorkflow
extends BaseDataEntity {
    public static final String WFENGINETYPE_EMBEDDED = "EMBEDDED";
    public static final String WFENGINETYPE_ACTIVITI = "ACTIVITI";
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

    public final boolean isPSWORKFLOWIDNull() {
        return this.isParamNull(TAG_PSWORKFLOWID);
    }

    public final String getPSWORKFLOWID() {
        return this.getParamStringValue(TAG_PSWORKFLOWID, "");
    }

    public final void setPSWORKFLOWID(String strValue) {
        this.setParamValue(TAG_PSWORKFLOWID, strValue);
    }

    public final boolean isPSWORKFLOWNAMENull() {
        return this.isParamNull(TAG_PSWORKFLOWNAME);
    }

    public final String getPSWORKFLOWNAME() {
        return this.getParamStringValue(TAG_PSWORKFLOWNAME, "");
    }

    public final void setPSWORKFLOWNAME(String strValue) {
        this.setParamValue(TAG_PSWORKFLOWNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.isParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.getParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.setParamValue(TAG_ENABLE, bValue ? 1 : 0);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isWFSTEPCODELISTIDNull() {
        return this.isParamNull(TAG_WFSTEPCODELISTID);
    }

    public final String getWFSTEPCODELISTID() {
        return this.getParamStringValue(TAG_WFSTEPCODELISTID, "");
    }

    public final void setWFSTEPCODELISTID(String strValue) {
        this.setParamValue(TAG_WFSTEPCODELISTID, strValue);
    }

    public final boolean isWFSTEPCODELISTNAMENull() {
        return this.isParamNull(TAG_WFSTEPCODELISTNAME);
    }

    public final String getWFSTEPCODELISTNAME() {
        return this.getParamStringValue(TAG_WFSTEPCODELISTNAME, "");
    }

    public final void setWFSTEPCODELISTNAME(String strValue) {
        this.setParamValue(TAG_WFSTEPCODELISTNAME, strValue);
    }

    public final boolean isSTATECODELISTIDNull() {
        return this.isParamNull(TAG_STATECODELISTID);
    }

    public final String getSTATECODELISTID() {
        return this.getParamStringValue(TAG_STATECODELISTID, "");
    }

    public final void setSTATECODELISTID(String strValue) {
        this.setParamValue(TAG_STATECODELISTID, strValue);
    }

    public final boolean isSTATECODELISTNAMENull() {
        return this.isParamNull(TAG_STATECODELISTNAME);
    }

    public final String getSTATECODELISTNAME() {
        return this.getParamStringValue(TAG_STATECODELISTNAME, "");
    }

    public final void setSTATECODELISTNAME(String strValue) {
        this.setParamValue(TAG_STATECODELISTNAME, strValue);
    }

    public final boolean isWFSTATEVALUENull() {
        return this.isParamNull(TAG_WFSTATEVALUE);
    }

    public final String getWFSTATEVALUE() {
        return this.getParamStringValue(TAG_WFSTATEVALUE, "");
    }

    public final void setWFSTATEVALUE(String strValue) {
        this.setParamValue(TAG_WFSTATEVALUE, strValue);
    }

    public final boolean isEXTCNTSTATESNull() {
        return this.isParamNull(TAG_EXTCNTSTATES);
    }

    public final String getEXTCNTSTATES() {
        return this.getParamStringValue(TAG_EXTCNTSTATES, "");
    }

    public final void setEXTCNTSTATES(String strValue) {
        this.setParamValue(TAG_EXTCNTSTATES, strValue);
    }

    public final boolean isEDITABLEWFSTEPNull() {
        return this.isParamNull(TAG_EDITABLEWFSTEP);
    }

    public final String getEDITABLEWFSTEP() {
        return this.getParamStringValue(TAG_EDITABLEWFSTEP, "");
    }

    public final void setEDITABLEWFSTEP(String strValue) {
        this.setParamValue(TAG_EDITABLEWFSTEP, strValue);
    }

    public final boolean isWFSNNull() {
        return this.isParamNull(TAG_WFSN);
    }

    public final String getWFSN() {
        return this.getParamStringValue(TAG_WFSN, "");
    }

    public final void setWFSN(String strValue) {
        this.setParamValue(TAG_WFSN, strValue);
    }

    public final boolean isREMINDPSSYSMSGTEMPLIDNull() {
        return this.isParamNull(TAG_REMINDPSSYSMSGTEMPLID);
    }

    public final String getREMINDPSSYSMSGTEMPLID() {
        return this.getParamStringValue(TAG_REMINDPSSYSMSGTEMPLID, "");
    }

    public final void setREMINDPSSYSMSGTEMPLID(String strValue) {
        this.setParamValue(TAG_REMINDPSSYSMSGTEMPLID, strValue);
    }

    public final boolean isREMINDPSSYSMSGTEMPLNAMENull() {
        return this.isParamNull(TAG_REMINDPSSYSMSGTEMPLNAME);
    }

    public final String getREMINDPSSYSMSGTEMPLNAME() {
        return this.getParamStringValue(TAG_REMINDPSSYSMSGTEMPLNAME, "");
    }

    public final void setREMINDPSSYSMSGTEMPLNAME(String strValue) {
        this.setParamValue(TAG_REMINDPSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isENABLEMOBNull() {
        return this.isParamNull(TAG_ENABLEMOB);
    }

    public final boolean getENABLEMOB() {
        return this.getParamIntValue(TAG_ENABLEMOB, 0) == 1;
    }

    public final void setENABLEMOB(boolean bValue) {
        this.setParamValue(TAG_ENABLEMOB, bValue ? 1 : 0);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSWXACCOUNTIDNull() {
        return this.isParamNull(TAG_PSWXACCOUNTID);
    }

    public final String getPSWXACCOUNTID() {
        return this.getParamStringValue(TAG_PSWXACCOUNTID, "");
    }

    public final void setPSWXACCOUNTID(String strValue) {
        this.setParamValue(TAG_PSWXACCOUNTID, strValue);
    }

    public final boolean isPSWXACCOUNTNAMENull() {
        return this.isParamNull(TAG_PSWXACCOUNTNAME);
    }

    public final String getPSWXACCOUNTNAME() {
        return this.getParamStringValue(TAG_PSWXACCOUNTNAME, "");
    }

    public final void setPSWXACCOUNTNAME(String strValue) {
        this.setParamValue(TAG_PSWXACCOUNTNAME, strValue);
    }

    public final boolean isPSWXENTAPPIDNull() {
        return this.isParamNull(TAG_PSWXENTAPPID);
    }

    public final String getPSWXENTAPPID() {
        return this.getParamStringValue(TAG_PSWXENTAPPID, "");
    }

    public final void setPSWXENTAPPID(String strValue) {
        this.setParamValue(TAG_PSWXENTAPPID, strValue);
    }

    public final boolean isPSWXENTAPPNAMENull() {
        return this.isParamNull(TAG_PSWXENTAPPNAME);
    }

    public final String getPSWXENTAPPNAME() {
        return this.getParamStringValue(TAG_PSWXENTAPPNAME, "");
    }

    public final void setPSWXENTAPPNAME(String strValue) {
        this.setParamValue(TAG_PSWXENTAPPNAME, strValue);
    }

    public final boolean isENABLEDYNAVIEWNull() {
        return this.isParamNull(TAG_ENABLEDYNAVIEW);
    }

    public final boolean getENABLEDYNAVIEW() {
        return this.getParamIntValue(TAG_ENABLEDYNAVIEW, 0) == 1;
    }

    public final void setENABLEDYNAVIEW(boolean bValue) {
        this.setParamValue(TAG_ENABLEDYNAVIEW, bValue ? 1 : 0);
    }

    public final boolean isWFENGINETYPENull() {
        return this.isParamNull(TAG_WFENGINETYPE);
    }

    public final String getWFENGINETYPE() {
        return this.getParamStringValue(TAG_WFENGINETYPE, "");
    }

    public final void setWFENGINETYPE(String strValue) {
        this.setParamValue(TAG_WFENGINETYPE, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.isParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.getParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.setParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }

    public final boolean isNAMEPSLANRESIDNull() {
        return this.isParamNull(TAG_NAMEPSLANRESID);
    }

    public final String getNAMEPSLANRESID() {
        return this.getParamStringValue(TAG_NAMEPSLANRESID, "");
    }

    public final void setNAMEPSLANRESID(String strValue) {
        this.setParamValue(TAG_NAMEPSLANRESID, strValue);
    }

    public final boolean isNAMEPSLANRESNAMENull() {
        return this.isParamNull(TAG_NAMEPSLANRESNAME);
    }

    public final String getNAMEPSLANRESNAME() {
        return this.getParamStringValue(TAG_NAMEPSLANRESNAME, "");
    }

    public final void setNAMEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_NAMEPSLANRESNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.isParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.getParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.setParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.isParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.getParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.setParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isREMOTEENGINEFLAGNull() {
        return this.isParamNull(TAG_REMOTEENGINEFLAG);
    }

    public final boolean getREMOTEENGINEFLAG() {
        return this.getParamIntValue(TAG_REMOTEENGINEFLAG, 0) == 1;
    }

    public final void setREMOTEENGINEFLAG(boolean bValue) {
        this.setParamValue(TAG_REMOTEENGINEFLAG, bValue ? 1 : 0);
    }

    public final boolean isWFPROXYMODENull() {
        return this.isParamNull(TAG_WFPROXYMODE);
    }

    public final int getWFPROXYMODE() {
        return this.getParamIntValue(TAG_WFPROXYMODE, 0);
    }

    public final void setWFPROXYMODE(int nValue) {
        this.setParamValue(TAG_WFPROXYMODE, nValue);
    }
}

