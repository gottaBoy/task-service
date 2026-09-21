/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.ArrayList;
import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.model.entity.PSWFLink;
import net.ibizsys.model.entity.PSWFProcParam;
import net.ibizsys.model.entity.PSWFProcRole;
import net.ibizsys.model.entity.PSWFProcSubWF;

public class PSWFProcess
extends BaseDataEntity {
    public static final String WFPROCESSTYPE_START = "START";
    public static final String WFPROCESSTYPE_END = "END";
    public static final String WFPROCESSTYPE_PROCESS = "PROCESS";
    public static final String WFPROCESSTYPE_INTERACTIVE = "INTERACTIVE";
    public static final String WFPROCESSTYPE_PARALLEL = "PARALLEL";
    public static final String WFPROCESSTYPE_EMBED = "EMBED";
    public static final String TIMEOUTTYPE_MINUTE = "MINUTE";
    public static final String TIMEOUTTYPE_HOUR = "HOUR";
    public static final String TIMEOUTTYPE_DAY = "DAY";
    public static final String TIMEOUTTYPE_WORKDAY = "WORKDAY";
    public static final int THREADSN_1 = 1;
    public static final int THREADSN_2 = 2;
    public static final int THREADSN_3 = 3;
    public static final int THREADSN_4 = 4;
    public static final int THREADSN_5 = 5;
    public static final int THREADSN_6 = 6;
    public static final int THREADSN_7 = 7;
    public static final int THREADSN_8 = 8;
    public static final int THREADSN_9 = 9;
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_WFPROCESSTYPE = "WFPROCESSTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ASYNCMODE = "ASYNCMODE";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_TIMEOUTTYPE = "TIMEOUTTYPE";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_PSWFWORKTIMEID = "PSWFWORKTIMEID";
    public static final String TAG_PSWFWORKTIMENAME = "PSWFWORKTIMENAME";
    public static final String TAG_TIMEOUTPSDEFID = "TIMEOUTPSDEFID";
    public static final String TAG_TIMEOUTPSDEFNAME = "TIMEOUTPSDEFNAME";
    public static final String TAG_WFSTEPVALUE = "WFSTEPVALUE";
    public static final String TAG_LEFTPOS = "LEFTPOS";
    public static final String TAG_TOPPOS = "TOPPOS";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSWFDEID = "PSWFDEID";
    public static final String TAG_PSWFDENAME = "PSWFDENAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_EDITFLAG = "EDITFLAG";
    public static final String TAG_MEMOFIELD = "MEMOFIELD";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_EMBEDPSWFID = "EMBEDPSWFID";
    public static final String TAG_EMBEDPSWFNAME = "EMBEDPSWFNAME";
    public static final String TAG_EMBEDPSWFDEID = "EMBEDPSWFDEID";
    public static final String TAG_EMBEDPSWFDENAME = "EMBEDPSWFDENAME";
    public static final String TAG_EMBEDPSDEDSID = "EMBEDPSDEDSID";
    public static final String TAG_EMBEDPSDEDSNAME = "EMBEDPSDEDSNAME";
    public static final String TAG_EMBEDPSDEID = "EMBEDPSDEID";
    public static final String TAG_SENDINFORM = "SENDINFORM";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_MSGTYPE = "MSGTYPE";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String TAG_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";
    public static final String TAG_MOBPSDEVIEWID = "MOBPSDEVIEWID";
    public static final String TAG_MOBPSDEVIEWNAME = "MOBPSDEVIEWNAME";
    public static final String TAG_NAMEPSLANRESID = "NAMEPSLANRESID";
    public static final String TAG_NAMEPSLANRESNAME = "NAMEPSLANRESNAME";
    public static final String TAG_ENABLETIMEOUT = "ENABLETIMEOUT";
    public static final String TAG_THREADSN = "THREADSN";
    public static final String TAG_REFPSWFVERSIONID = "REFPSWFVERSIONID";
    public static final String TAG_REFPSWFVERSIONNAME = "REFPSWFVERSIONNAME";
    public static final String TAG_THREADNAME = "THREADNAME";
    public static final String TAG_EXITSTATEVALUE = "EXITSTATEVALUE";
    public static final String TAG_EXITSTATENAME = "EXITSTATENAME";
    public static final String TAG_MODELID = "MODELID";
    public static final String TAG_MULTIINSTMODE = "MULTIINSTMODE";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_MOBPSDYNADEVIEWTEMPLID = "MOBPSDYNADEVIEWTEMPLID";
    public static final String TAG_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String TAG_PREDEFINEDACTIONS = "PREDEFINEDACTIONS";
    private ArrayList<PSWFLink> childPSWFLinkList = null;
    private ArrayList<PSWFProcParam> childPSWFProcParamList = null;
    private ArrayList<PSWFProcSubWF> childPSWFProcSubWFList = null;
    private ArrayList<PSWFProcRole> childPSWFProcRoleList = null;

    public final boolean isPSWFPROCESSIDNull() {
        return this.isParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.getParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSID, strValue);
    }

    public final boolean isPSWFPROCESSNAMENull() {
        return this.isParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.getParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSNAME, strValue);
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

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.isParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.getParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isWFPROCESSTYPENull() {
        return this.isParamNull(TAG_WFPROCESSTYPE);
    }

    public final String getWFPROCESSTYPE() {
        return this.getParamStringValue(TAG_WFPROCESSTYPE, "");
    }

    public final void setWFPROCESSTYPE(String strValue) {
        this.setParamValue(TAG_WFPROCESSTYPE, strValue);
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

    public final boolean isASYNCMODENull() {
        return this.isParamNull(TAG_ASYNCMODE);
    }

    public final boolean getASYNCMODE() {
        return this.getParamIntValue(TAG_ASYNCMODE, 0) == 1;
    }

    public final void setASYNCMODE(boolean bValue) {
        this.setParamValue(TAG_ASYNCMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isTIMEOUTTYPENull() {
        return this.isParamNull(TAG_TIMEOUTTYPE);
    }

    public final String getTIMEOUTTYPE() {
        return this.getParamStringValue(TAG_TIMEOUTTYPE, "");
    }

    public final void setTIMEOUTTYPE(String strValue) {
        this.setParamValue(TAG_TIMEOUTTYPE, strValue);
    }

    public final boolean isTIMEOUTNull() {
        return this.isParamNull(TAG_TIMEOUT);
    }

    public final int getTIMEOUT() {
        return this.getParamIntValue(TAG_TIMEOUT, 0);
    }

    public final void setTIMEOUT(int nValue) {
        this.setParamValue(TAG_TIMEOUT, nValue);
    }

    public final boolean isPSWFWORKTIMEIDNull() {
        return this.isParamNull(TAG_PSWFWORKTIMEID);
    }

    public final String getPSWFWORKTIMEID() {
        return this.getParamStringValue(TAG_PSWFWORKTIMEID, "");
    }

    public final void setPSWFWORKTIMEID(String strValue) {
        this.setParamValue(TAG_PSWFWORKTIMEID, strValue);
    }

    public final boolean isPSWFWORKTIMENAMENull() {
        return this.isParamNull(TAG_PSWFWORKTIMENAME);
    }

    public final String getPSWFWORKTIMENAME() {
        return this.getParamStringValue(TAG_PSWFWORKTIMENAME, "");
    }

    public final void setPSWFWORKTIMENAME(String strValue) {
        this.setParamValue(TAG_PSWFWORKTIMENAME, strValue);
    }

    public final boolean isTIMEOUTPSDEFIDNull() {
        return this.isParamNull(TAG_TIMEOUTPSDEFID);
    }

    public final String getTIMEOUTPSDEFID() {
        return this.getParamStringValue(TAG_TIMEOUTPSDEFID, "");
    }

    public final void setTIMEOUTPSDEFID(String strValue) {
        this.setParamValue(TAG_TIMEOUTPSDEFID, strValue);
    }

    public final boolean isTIMEOUTPSDEFNAMENull() {
        return this.isParamNull(TAG_TIMEOUTPSDEFNAME);
    }

    public final String getTIMEOUTPSDEFNAME() {
        return this.getParamStringValue(TAG_TIMEOUTPSDEFNAME, "");
    }

    public final void setTIMEOUTPSDEFNAME(String strValue) {
        this.setParamValue(TAG_TIMEOUTPSDEFNAME, strValue);
    }

    public final boolean isWFSTEPVALUENull() {
        return this.isParamNull(TAG_WFSTEPVALUE);
    }

    public final String getWFSTEPVALUE() {
        return this.getParamStringValue(TAG_WFSTEPVALUE, "");
    }

    public final void setWFSTEPVALUE(String strValue) {
        this.setParamValue(TAG_WFSTEPVALUE, strValue);
    }

    public final boolean isLEFTPOSNull() {
        return this.isParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.getParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.setParamValue(TAG_LEFTPOS, nValue);
    }

    public final boolean isTOPPOSNull() {
        return this.isParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.getParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.setParamValue(TAG_TOPPOS, nValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.isParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.getParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.setParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.isParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.getParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.setParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isEDITFLAGNull() {
        return this.isParamNull(TAG_EDITFLAG);
    }

    public final boolean getEDITFLAG() {
        return this.getParamIntValue(TAG_EDITFLAG, 0) == 1;
    }

    public final void setEDITFLAG(boolean bValue) {
        this.setParamValue(TAG_EDITFLAG, bValue ? 1 : 0);
    }

    public final boolean isMEMOFIELDNull() {
        return this.isParamNull(TAG_MEMOFIELD);
    }

    public final String getMEMOFIELD() {
        return this.getParamStringValue(TAG_MEMOFIELD, "");
    }

    public final void setMEMOFIELD(String strValue) {
        this.setParamValue(TAG_MEMOFIELD, strValue);
    }

    public final boolean isUSERDATANull() {
        return this.isParamNull(TAG_USERDATA);
    }

    public final String getUSERDATA() {
        return this.getParamStringValue(TAG_USERDATA, "");
    }

    public final void setUSERDATA(String strValue) {
        this.setParamValue(TAG_USERDATA, strValue);
    }

    public final boolean isUSERDATA2Null() {
        return this.isParamNull(TAG_USERDATA2);
    }

    public final String getUSERDATA2() {
        return this.getParamStringValue(TAG_USERDATA2, "");
    }

    public final void setUSERDATA2(String strValue) {
        this.setParamValue(TAG_USERDATA2, strValue);
    }

    public final boolean isEMBEDPSWFIDNull() {
        return this.isParamNull(TAG_EMBEDPSWFID);
    }

    public final String getEMBEDPSWFID() {
        return this.getParamStringValue(TAG_EMBEDPSWFID, "");
    }

    public final void setEMBEDPSWFID(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFID, strValue);
    }

    public final boolean isEMBEDPSWFNAMENull() {
        return this.isParamNull(TAG_EMBEDPSWFNAME);
    }

    public final String getEMBEDPSWFNAME() {
        return this.getParamStringValue(TAG_EMBEDPSWFNAME, "");
    }

    public final void setEMBEDPSWFNAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFNAME, strValue);
    }

    public final boolean isEMBEDPSWFDEIDNull() {
        return this.isParamNull(TAG_EMBEDPSWFDEID);
    }

    public final String getEMBEDPSWFDEID() {
        return this.getParamStringValue(TAG_EMBEDPSWFDEID, "");
    }

    public final void setEMBEDPSWFDEID(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFDEID, strValue);
    }

    public final boolean isEMBEDPSWFDENAMENull() {
        return this.isParamNull(TAG_EMBEDPSWFDENAME);
    }

    public final String getEMBEDPSWFDENAME() {
        return this.getParamStringValue(TAG_EMBEDPSWFDENAME, "");
    }

    public final void setEMBEDPSWFDENAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFDENAME, strValue);
    }

    public final boolean isEMBEDPSDEDSIDNull() {
        return this.isParamNull(TAG_EMBEDPSDEDSID);
    }

    public final String getEMBEDPSDEDSID() {
        return this.getParamStringValue(TAG_EMBEDPSDEDSID, "");
    }

    public final void setEMBEDPSDEDSID(String strValue) {
        this.setParamValue(TAG_EMBEDPSDEDSID, strValue);
    }

    public final boolean isEMBEDPSDEDSNAMENull() {
        return this.isParamNull(TAG_EMBEDPSDEDSNAME);
    }

    public final String getEMBEDPSDEDSNAME() {
        return this.getParamStringValue(TAG_EMBEDPSDEDSNAME, "");
    }

    public final void setEMBEDPSDEDSNAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSDEDSNAME, strValue);
    }

    public final boolean isEMBEDPSDEIDNull() {
        return this.isParamNull(TAG_EMBEDPSDEID);
    }

    public final String getEMBEDPSDEID() {
        return this.getParamStringValue(TAG_EMBEDPSDEID, "");
    }

    public final void setEMBEDPSDEID(String strValue) {
        this.setParamValue(TAG_EMBEDPSDEID, strValue);
    }

    public final boolean isSENDINFORMNull() {
        return this.isParamNull(TAG_SENDINFORM);
    }

    public final boolean getSENDINFORM() {
        return this.getParamIntValue(TAG_SENDINFORM, 0) == 1;
    }

    public final void setSENDINFORM(boolean bValue) {
        this.setParamValue(TAG_SENDINFORM, bValue ? 1 : 0);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.isParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.getParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.setParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.isParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.getParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isMSGTYPENull() {
        return this.isParamNull(TAG_MSGTYPE);
    }

    public final int getMSGTYPE() {
        return this.getParamIntValue(TAG_MSGTYPE, 0);
    }

    public final void setMSGTYPE(int nValue) {
        this.setParamValue(TAG_MSGTYPE, nValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.isParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.getParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.setParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.isParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.getParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final String getMOBPSDEFORMID() {
        return this.getParamStringValue(TAG_MOBPSDEFORMID, "");
    }

    public final void setMOBPSDEFORMID(String strValue) {
        this.setParamValue(TAG_MOBPSDEFORMID, strValue);
    }

    public final boolean isMOBPSDEFORMNAMENull() {
        return this.isParamNull(TAG_MOBPSDEFORMNAME);
    }

    public final String getMOBPSDEFORMNAME() {
        return this.getParamStringValue(TAG_MOBPSDEFORMNAME, "");
    }

    public final void setMOBPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_MOBPSDEFORMNAME, strValue);
    }

    public final boolean isMOBPSDEVIEWIDNull() {
        return this.isParamNull(TAG_MOBPSDEVIEWID);
    }

    public final String getMOBPSDEVIEWID() {
        return this.getParamStringValue(TAG_MOBPSDEVIEWID, "");
    }

    public final void setMOBPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_MOBPSDEVIEWID, strValue);
    }

    public final boolean isMOBPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_MOBPSDEVIEWNAME);
    }

    public final String getMOBPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_MOBPSDEVIEWNAME, "");
    }

    public final void setMOBPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_MOBPSDEVIEWNAME, strValue);
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

    public final boolean isENABLETIMEOUTNull() {
        return this.isParamNull(TAG_ENABLETIMEOUT);
    }

    public final boolean getENABLETIMEOUT() {
        return this.getParamIntValue(TAG_ENABLETIMEOUT, 0) == 1;
    }

    public final void setENABLETIMEOUT(boolean bValue) {
        this.setParamValue(TAG_ENABLETIMEOUT, bValue ? 1 : 0);
    }

    public final boolean isTHREADSNNull() {
        return this.isParamNull(TAG_THREADSN);
    }

    public final int getTHREADSN() {
        return this.getParamIntValue(TAG_THREADSN, 0);
    }

    public final void setTHREADSN(int nValue) {
        this.setParamValue(TAG_THREADSN, nValue);
    }

    public final boolean isREFPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_REFPSWFVERSIONID);
    }

    public final String getREFPSWFVERSIONID() {
        return this.getParamStringValue(TAG_REFPSWFVERSIONID, "");
    }

    public final void setREFPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_REFPSWFVERSIONID, strValue);
    }

    public final boolean isREFPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_REFPSWFVERSIONNAME);
    }

    public final String getREFPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_REFPSWFVERSIONNAME, "");
    }

    public final void setREFPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_REFPSWFVERSIONNAME, strValue);
    }

    public final boolean isTHREADNAMENull() {
        return this.isParamNull(TAG_THREADNAME);
    }

    public final String getTHREADNAME() {
        return this.getParamStringValue(TAG_THREADNAME, "");
    }

    public final void setTHREADNAME(String strValue) {
        this.setParamValue(TAG_THREADNAME, strValue);
    }

    public final boolean isEXITSTATEVALUENull() {
        return this.isParamNull(TAG_EXITSTATEVALUE);
    }

    public final String getEXITSTATEVALUE() {
        return this.getParamStringValue(TAG_EXITSTATEVALUE, "");
    }

    public final void setEXITSTATEVALUE(String strValue) {
        this.setParamValue(TAG_EXITSTATEVALUE, strValue);
    }

    public final boolean isEXITSTATENAMENull() {
        return this.isParamNull(TAG_EXITSTATENAME);
    }

    public final String getEXITSTATENAME() {
        return this.getParamStringValue(TAG_EXITSTATENAME, "");
    }

    public final void setEXITSTATENAME(String strValue) {
        this.setParamValue(TAG_EXITSTATENAME, strValue);
    }

    public final boolean isMODELIDNull() {
        return this.isParamNull(TAG_MODELID);
    }

    public final String getMODELID() {
        return this.getParamStringValue(TAG_MODELID, "");
    }

    public final void setMODELID(String strValue) {
        this.setParamValue(TAG_MODELID, strValue);
    }

    public final boolean isMULTIINSTMODENull() {
        return this.isParamNull(TAG_MULTIINSTMODE);
    }

    public final String getMULTIINSTMODE() {
        return this.getParamStringValue(TAG_MULTIINSTMODE, "");
    }

    public final void setMULTIINSTMODE(String strValue) {
        this.setParamValue(TAG_MULTIINSTMODE, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isMOBPSDYNADEVIEWTEMPLIDNull() {
        return this.isParamNull(TAG_MOBPSDYNADEVIEWTEMPLID);
    }

    public final String getMOBPSDYNADEVIEWTEMPLID() {
        return this.getParamStringValue(TAG_MOBPSDYNADEVIEWTEMPLID, "");
    }

    public final void setMOBPSDYNADEVIEWTEMPLID(String strValue) {
        this.setParamValue(TAG_MOBPSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLIDNull() {
        return this.isParamNull(TAG_PSDYNADEVIEWTEMPLID);
    }

    public final String getPSDYNADEVIEWTEMPLID() {
        return this.getParamStringValue(TAG_PSDYNADEVIEWTEMPLID, "");
    }

    public final void setPSDYNADEVIEWTEMPLID(String strValue) {
        this.setParamValue(TAG_PSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPREDEFINEDACTIONSNull() {
        return this.isParamNull(TAG_PREDEFINEDACTIONS);
    }

    public final String getPREDEFINEDACTIONS() {
        return this.getParamStringValue(TAG_PREDEFINEDACTIONS, "");
    }

    public final void setPREDEFINEDACTIONS(String strValue) {
        this.setParamValue(TAG_PREDEFINEDACTIONS, strValue);
    }

    public ArrayList<PSWFLink> getPSWFLinks(boolean bCreated) {
        if (this.childPSWFLinkList != null) {
            return this.childPSWFLinkList;
        }
        if (bCreated) {
            this.childPSWFLinkList = new ArrayList();
        }
        return this.childPSWFLinkList;
    }

    public ArrayList<PSWFProcParam> getPSWFProcParams(boolean bCreated) {
        if (this.childPSWFProcParamList != null) {
            return this.childPSWFProcParamList;
        }
        if (bCreated) {
            this.childPSWFProcParamList = new ArrayList();
        }
        return this.childPSWFProcParamList;
    }

    public ArrayList<PSWFProcSubWF> getPSWFProcSubWFs(boolean bCreated) {
        if (this.childPSWFProcSubWFList != null) {
            return this.childPSWFProcSubWFList;
        }
        if (bCreated) {
            this.childPSWFProcSubWFList = new ArrayList();
        }
        return this.childPSWFProcSubWFList;
    }

    public ArrayList<PSWFProcRole> getPSWFProcRoles(boolean bCreated) {
        if (this.childPSWFProcRoleList != null) {
            return this.childPSWFProcRoleList;
        }
        if (bCreated) {
            this.childPSWFProcRoleList = new ArrayList();
        }
        return this.childPSWFProcRoleList;
    }

    public void resetChildDatas() {
        if (this.childPSWFLinkList != null) {
            this.childPSWFLinkList.clear();
            this.childPSWFLinkList = null;
        }
        if (this.childPSWFProcParamList != null) {
            this.childPSWFProcParamList.clear();
            this.childPSWFProcParamList = null;
        }
        if (this.childPSWFProcSubWFList != null) {
            this.childPSWFProcSubWFList.clear();
            this.childPSWFProcSubWFList = null;
        }
        if (this.childPSWFProcRoleList != null) {
            this.childPSWFProcRoleList.clear();
            this.childPSWFProcRoleList = null;
        }
    }
}

