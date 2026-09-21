/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFDA.PS.Data.PSWFLink;
import SA.SRFDA.PS.Data.PSWFProcParam;
import SA.SRFDA.PS.Data.PSWFProcRole;
import SA.SRFDA.PS.Data.PSWFProcSubWF;
import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.ArrayList;
import java.util.Date;

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
    public static final String NORMALPROCTYPE_DEACTION = "DEACTION";
    public static final String NORMALPROCTYPE_NONE = "NONE";
    public static final int THREADSN_1 = 1;
    public static final int THREADSN_2 = 2;
    public static final int THREADSN_3 = 3;
    public static final int THREADSN_4 = 4;
    public static final int THREADSN_5 = 5;
    public static final int THREADSN_6 = 6;
    public static final int THREADSN_7 = 7;
    public static final int THREADSN_8 = 8;
    public static final int THREADSN_9 = 9;
    public static final String UTILTYPE_SENDBACK = "SENDBACK";
    public static final String UTILTYPE_SUPPLYINFO = "SUPPLYINFO";
    public static final String UTILTYPE_ADDSTEPBEFORE = "ADDSTEPBEFORE";
    public static final String UTILTYPE_ADDSTEPAFTER = "ADDSTEPAFTER";
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
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PROCESSTAG = "PROCESSTAG";
    public static final String TAG_PROCESSTAG2 = "PROCESSTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERCAT = "USERCAT";
    public static final String TAG_NORMALPROCTYPE = "NORMALPROCTYPE";
    public static final String TAG_FORMCODENAME = "FORMCODENAME";
    public static final String TAG_MOBFORMCODENAME = "MOBFORMCODENAME";
    public static final String TAG_UTILPSDEFORMID = "UTILPSDEFORMID";
    public static final String TAG_UTILPSDEFORMNAME = "UTILPSDEFORMNAME";
    public static final String TAG_UTIL2PSDEFORMID = "UTIL2PSDEFORMID";
    public static final String TAG_UTIL2PSDEFORMNAME = "UTIL2PSDEFORMNAME";
    public static final String TAG_UTIL3PSDEFORMID = "UTIL3PSDEFORMID";
    public static final String TAG_UTIL3PSDEFORMNAME = "UTIL3PSDEFORMNAME";
    public static final String TAG_UTIL4PSDEFORMID = "UTIL4PSDEFORMID";
    public static final String TAG_UTIL4PSDEFORMNAME = "UTIL4PSDEFORMNAME";
    public static final String TAG_UTIL5PSDEFORMID = "UTIL5PSDEFORMID";
    public static final String TAG_UTIL5PSDEFORMNAME = "UTIL5PSDEFORMNAME";
    public static final String TAG_MOBUTIL5PSDEFORMID = "MOBUTIL5PSDEFORMID";
    public static final String TAG_MOBUTIL5PSDEFORMNAME = "MOBUTIL5PSDEFORMNAME";
    public static final String TAG_MOBUTILPSDEFORMID = "MOBUTILPSDEFORMID";
    public static final String TAG_MOBUTILPSDEFORMNAME = "MOBUTILPSDEFORMNAME";
    public static final String TAG_MOBUTIL2PSDEFORMID = "MOBUTIL2PSDEFORMID";
    public static final String TAG_MOBUTIL2PSDEFORMNAME = "MOBUTIL2PSDEFORMNAME";
    public static final String TAG_MOBUTIL3PSDEFORMID = "MOBUTIL3PSDEFORMID";
    public static final String TAG_MOBUTIL3PSDEFORMNAME = "MOBUTIL3PSDEFORMNAME";
    public static final String TAG_MOBUTIL4PSDEFORMID = "MOBUTIL4PSDEFORMID";
    public static final String TAG_MOBUTIL4PSDEFORMNAME = "MOBUTIL4PSDEFORMNAME";
    public static final String TAG_UTILFORMCODENAME = "UTILFORMCODENAME";
    public static final String TAG_UTIL2FORMCODENAME = "UTIL2FORMCODENAME";
    public static final String TAG_UTIL3FORMCODENAME = "UTIL3FORMCODENAME";
    public static final String TAG_UTIL4FORMCODENAME = "UTIL4FORMCODENAME";
    public static final String TAG_UTIL5FORMCODENAME = "UTIL5FORMCODENAME";
    public static final String TAG_MOBUTIL5FORMCODENAME = "MOBUTIL5FORMCODENAME";
    public static final String TAG_MOBUTIL4FORMCODENAME = "MOBUTIL4FORMCODENAME";
    public static final String TAG_MOBUTIL3FORMCODENAME = "MOBUTIL3FORMCODENAME";
    public static final String TAG_MOBUTIL2FORMCODENAME = "MOBUTIL2FORMCODENAME";
    public static final String TAG_MOBUTILFORMCODENAME = "MOBUTILFORMCODENAME";
    public static final String TAG_EDITFIELDS = "EDITFIELDS";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_MOBPSDEUAGROUPID = "MOBPSDEUAGROUPID";
    public static final String TAG_MOBPSDEUAGROUPNAME = "MOBPSDEUAGROUPNAME";
    public static final String TAG_UAGROUPCODENAME = "UAGROUPCODENAME";
    public static final String TAG_MOBUAGROUPCODENAME = "MOBUAGROUPCODENAME";
    private ArrayList<PSWFLink> childPSWFLinkList = null;
    private ArrayList<PSWFProcParam> childPSWFProcParamList = null;
    private ArrayList<PSWFProcSubWF> childPSWFProcSubWFList = null;
    private ArrayList<PSWFProcRole> childPSWFProcRoleList = null;

    public final boolean isPSWFPROCESSIDNull() {
        return this.IsParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.GetParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSID, strValue);
    }

    public final boolean isPSWFPROCESSNAMENull() {
        return this.IsParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.GetParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSNAME, strValue);
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

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.IsParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.GetParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.SetParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isWFPROCESSTYPENull() {
        return this.IsParamNull(TAG_WFPROCESSTYPE);
    }

    public final String getWFPROCESSTYPE() {
        return this.GetParamStringValue(TAG_WFPROCESSTYPE, "");
    }

    public final void setWFPROCESSTYPE(String strValue) {
        this.SetParamValue(TAG_WFPROCESSTYPE, strValue);
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

    public final boolean isASYNCMODENull() {
        return this.IsParamNull(TAG_ASYNCMODE);
    }

    public final boolean getASYNCMODE() {
        return this.GetParamIntValue(TAG_ASYNCMODE, 0) == 1;
    }

    public final void setASYNCMODE(boolean bValue) {
        this.SetParamValue(TAG_ASYNCMODE, bValue ? 1 : 0);
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

    public final boolean isTIMEOUTTYPENull() {
        return this.IsParamNull(TAG_TIMEOUTTYPE);
    }

    public final String getTIMEOUTTYPE() {
        return this.GetParamStringValue(TAG_TIMEOUTTYPE, "");
    }

    public final void setTIMEOUTTYPE(String strValue) {
        this.SetParamValue(TAG_TIMEOUTTYPE, strValue);
    }

    public final boolean isTIMEOUTNull() {
        return this.IsParamNull(TAG_TIMEOUT);
    }

    public final int getTIMEOUT() {
        return this.GetParamIntValue(TAG_TIMEOUT, 0);
    }

    public final void setTIMEOUT(int nValue) {
        this.SetParamValue(TAG_TIMEOUT, nValue);
    }

    public final boolean isPSWFWORKTIMEIDNull() {
        return this.IsParamNull(TAG_PSWFWORKTIMEID);
    }

    public final String getPSWFWORKTIMEID() {
        return this.GetParamStringValue(TAG_PSWFWORKTIMEID, "");
    }

    public final void setPSWFWORKTIMEID(String strValue) {
        this.SetParamValue(TAG_PSWFWORKTIMEID, strValue);
    }

    public final boolean isPSWFWORKTIMENAMENull() {
        return this.IsParamNull(TAG_PSWFWORKTIMENAME);
    }

    public final String getPSWFWORKTIMENAME() {
        return this.GetParamStringValue(TAG_PSWFWORKTIMENAME, "");
    }

    public final void setPSWFWORKTIMENAME(String strValue) {
        this.SetParamValue(TAG_PSWFWORKTIMENAME, strValue);
    }

    public final boolean isTIMEOUTPSDEFIDNull() {
        return this.IsParamNull(TAG_TIMEOUTPSDEFID);
    }

    public final String getTIMEOUTPSDEFID() {
        return this.GetParamStringValue(TAG_TIMEOUTPSDEFID, "");
    }

    public final void setTIMEOUTPSDEFID(String strValue) {
        this.SetParamValue(TAG_TIMEOUTPSDEFID, strValue);
    }

    public final boolean isTIMEOUTPSDEFNAMENull() {
        return this.IsParamNull(TAG_TIMEOUTPSDEFNAME);
    }

    public final String getTIMEOUTPSDEFNAME() {
        return this.GetParamStringValue(TAG_TIMEOUTPSDEFNAME, "");
    }

    public final void setTIMEOUTPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_TIMEOUTPSDEFNAME, strValue);
    }

    public final boolean isWFSTEPVALUENull() {
        return this.IsParamNull(TAG_WFSTEPVALUE);
    }

    public final String getWFSTEPVALUE() {
        return this.GetParamStringValue(TAG_WFSTEPVALUE, "");
    }

    public final void setWFSTEPVALUE(String strValue) {
        this.SetParamValue(TAG_WFSTEPVALUE, strValue);
    }

    public final boolean isLEFTPOSNull() {
        return this.IsParamNull(TAG_LEFTPOS);
    }

    public final int getLEFTPOS() {
        return this.GetParamIntValue(TAG_LEFTPOS, 0);
    }

    public final void setLEFTPOS(int nValue) {
        this.SetParamValue(TAG_LEFTPOS, nValue);
    }

    public final boolean isTOPPOSNull() {
        return this.IsParamNull(TAG_TOPPOS);
    }

    public final int getTOPPOS() {
        return this.GetParamIntValue(TAG_TOPPOS, 0);
    }

    public final void setTOPPOS(int nValue) {
        this.SetParamValue(TAG_TOPPOS, nValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.IsParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.GetParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.SetParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.IsParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.GetParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_PSWFDENAME, strValue);
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

    public final boolean isEDITFLAGNull() {
        return this.IsParamNull(TAG_EDITFLAG);
    }

    public final boolean getEDITFLAG() {
        return this.GetParamIntValue(TAG_EDITFLAG, 0) == 1;
    }

    public final void setEDITFLAG(boolean bValue) {
        this.SetParamValue(TAG_EDITFLAG, bValue ? 1 : 0);
    }

    public final boolean isMEMOFIELDNull() {
        return this.IsParamNull(TAG_MEMOFIELD);
    }

    public final String getMEMOFIELD() {
        return this.GetParamStringValue(TAG_MEMOFIELD, "");
    }

    public final void setMEMOFIELD(String strValue) {
        this.SetParamValue(TAG_MEMOFIELD, strValue);
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

    public final boolean isEMBEDPSWFIDNull() {
        return this.IsParamNull(TAG_EMBEDPSWFID);
    }

    public final String getEMBEDPSWFID() {
        return this.GetParamStringValue(TAG_EMBEDPSWFID, "");
    }

    public final void setEMBEDPSWFID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFID, strValue);
    }

    public final boolean isEMBEDPSWFNAMENull() {
        return this.IsParamNull(TAG_EMBEDPSWFNAME);
    }

    public final String getEMBEDPSWFNAME() {
        return this.GetParamStringValue(TAG_EMBEDPSWFNAME, "");
    }

    public final void setEMBEDPSWFNAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFNAME, strValue);
    }

    public final boolean isEMBEDPSWFDEIDNull() {
        return this.IsParamNull(TAG_EMBEDPSWFDEID);
    }

    public final String getEMBEDPSWFDEID() {
        return this.GetParamStringValue(TAG_EMBEDPSWFDEID, "");
    }

    public final void setEMBEDPSWFDEID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFDEID, strValue);
    }

    public final boolean isEMBEDPSWFDENAMENull() {
        return this.IsParamNull(TAG_EMBEDPSWFDENAME);
    }

    public final String getEMBEDPSWFDENAME() {
        return this.GetParamStringValue(TAG_EMBEDPSWFDENAME, "");
    }

    public final void setEMBEDPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSWFDENAME, strValue);
    }

    public final boolean isEMBEDPSDEDSIDNull() {
        return this.IsParamNull(TAG_EMBEDPSDEDSID);
    }

    public final String getEMBEDPSDEDSID() {
        return this.GetParamStringValue(TAG_EMBEDPSDEDSID, "");
    }

    public final void setEMBEDPSDEDSID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSDEDSID, strValue);
    }

    public final boolean isEMBEDPSDEDSNAMENull() {
        return this.IsParamNull(TAG_EMBEDPSDEDSNAME);
    }

    public final String getEMBEDPSDEDSNAME() {
        return this.GetParamStringValue(TAG_EMBEDPSDEDSNAME, "");
    }

    public final void setEMBEDPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_EMBEDPSDEDSNAME, strValue);
    }

    public final boolean isEMBEDPSDEIDNull() {
        return this.IsParamNull(TAG_EMBEDPSDEID);
    }

    public final String getEMBEDPSDEID() {
        return this.GetParamStringValue(TAG_EMBEDPSDEID, "");
    }

    public final void setEMBEDPSDEID(String strValue) {
        this.SetParamValue(TAG_EMBEDPSDEID, strValue);
    }

    public final boolean isSENDINFORMNull() {
        return this.IsParamNull(TAG_SENDINFORM);
    }

    public final boolean getSENDINFORM() {
        return this.GetParamIntValue(TAG_SENDINFORM, 0) == 1;
    }

    public final void setSENDINFORM(boolean bValue) {
        this.SetParamValue(TAG_SENDINFORM, bValue ? 1 : 0);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isMSGTYPENull() {
        return this.IsParamNull(TAG_MSGTYPE);
    }

    public final int getMSGTYPE() {
        return this.GetParamIntValue(TAG_MSGTYPE, 0);
    }

    public final void setMSGTYPE(int nValue) {
        this.SetParamValue(TAG_MSGTYPE, nValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final String getMOBPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMID, "");
    }

    public final void setMOBPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMID, strValue);
    }

    public final boolean isMOBPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEFORMNAME);
    }

    public final String getMOBPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMNAME, "");
    }

    public final void setMOBPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMNAME, strValue);
    }

    public final boolean isMOBPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_MOBPSDEVIEWID);
    }

    public final String getMOBPSDEVIEWID() {
        return this.GetParamStringValue(TAG_MOBPSDEVIEWID, "");
    }

    public final void setMOBPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEVIEWID, strValue);
    }

    public final boolean isMOBPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEVIEWNAME);
    }

    public final String getMOBPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEVIEWNAME, "");
    }

    public final void setMOBPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEVIEWNAME, strValue);
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

    public final boolean isENABLETIMEOUTNull() {
        return this.IsParamNull(TAG_ENABLETIMEOUT);
    }

    public final boolean getENABLETIMEOUT() {
        return this.GetParamIntValue(TAG_ENABLETIMEOUT, 0) == 1;
    }

    public final void setENABLETIMEOUT(boolean bValue) {
        this.SetParamValue(TAG_ENABLETIMEOUT, bValue ? 1 : 0);
    }

    public final boolean isTHREADSNNull() {
        return this.IsParamNull(TAG_THREADSN);
    }

    public final int getTHREADSN() {
        return this.GetParamIntValue(TAG_THREADSN, 0);
    }

    public final void setTHREADSN(int nValue) {
        this.SetParamValue(TAG_THREADSN, nValue);
    }

    public final boolean isREFPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_REFPSWFVERSIONID);
    }

    public final String getREFPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_REFPSWFVERSIONID, "");
    }

    public final void setREFPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_REFPSWFVERSIONID, strValue);
    }

    public final boolean isREFPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_REFPSWFVERSIONNAME);
    }

    public final String getREFPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_REFPSWFVERSIONNAME, "");
    }

    public final void setREFPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_REFPSWFVERSIONNAME, strValue);
    }

    public final boolean isTHREADNAMENull() {
        return this.IsParamNull(TAG_THREADNAME);
    }

    public final String getTHREADNAME() {
        return this.GetParamStringValue(TAG_THREADNAME, "");
    }

    public final void setTHREADNAME(String strValue) {
        this.SetParamValue(TAG_THREADNAME, strValue);
    }

    public final boolean isEXITSTATEVALUENull() {
        return this.IsParamNull(TAG_EXITSTATEVALUE);
    }

    public final String getEXITSTATEVALUE() {
        return this.GetParamStringValue(TAG_EXITSTATEVALUE, "");
    }

    public final void setEXITSTATEVALUE(String strValue) {
        this.SetParamValue(TAG_EXITSTATEVALUE, strValue);
    }

    public final boolean isEXITSTATENAMENull() {
        return this.IsParamNull(TAG_EXITSTATENAME);
    }

    public final String getEXITSTATENAME() {
        return this.GetParamStringValue(TAG_EXITSTATENAME, "");
    }

    public final void setEXITSTATENAME(String strValue) {
        this.SetParamValue(TAG_EXITSTATENAME, strValue);
    }

    public final boolean isMODELIDNull() {
        return this.IsParamNull(TAG_MODELID);
    }

    public final String getMODELID() {
        return this.GetParamStringValue(TAG_MODELID, "");
    }

    public final void setMODELID(String strValue) {
        this.SetParamValue(TAG_MODELID, strValue);
    }

    public final boolean isMULTIINSTMODENull() {
        return this.IsParamNull(TAG_MULTIINSTMODE);
    }

    public final String getMULTIINSTMODE() {
        return this.GetParamStringValue(TAG_MULTIINSTMODE, "");
    }

    public final void setMULTIINSTMODE(String strValue) {
        this.SetParamValue(TAG_MULTIINSTMODE, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isMOBPSDYNADEVIEWTEMPLIDNull() {
        return this.IsParamNull(TAG_MOBPSDYNADEVIEWTEMPLID);
    }

    public final String getMOBPSDYNADEVIEWTEMPLID() {
        return this.GetParamStringValue(TAG_MOBPSDYNADEVIEWTEMPLID, "");
    }

    public final void setMOBPSDYNADEVIEWTEMPLID(String strValue) {
        this.SetParamValue(TAG_MOBPSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADEVIEWTEMPLID);
    }

    public final String getPSDYNADEVIEWTEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADEVIEWTEMPLID, "");
    }

    public final void setPSDYNADEVIEWTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPREDEFINEDACTIONSNull() {
        return this.IsParamNull(TAG_PREDEFINEDACTIONS);
    }

    public final String getPREDEFINEDACTIONS() {
        return this.GetParamStringValue(TAG_PREDEFINEDACTIONS, "");
    }

    public final void setPREDEFINEDACTIONS(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDACTIONS, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isPROCESSTAGNull() {
        return this.IsParamNull(TAG_PROCESSTAG);
    }

    public final String getPROCESSTAG() {
        return this.GetParamStringValue(TAG_PROCESSTAG, "");
    }

    public final void setPROCESSTAG(String strValue) {
        this.SetParamValue(TAG_PROCESSTAG, strValue);
    }

    public final boolean isPROCESSTAG2Null() {
        return this.IsParamNull(TAG_PROCESSTAG2);
    }

    public final String getPROCESSTAG2() {
        return this.GetParamStringValue(TAG_PROCESSTAG2, "");
    }

    public final void setPROCESSTAG2(String strValue) {
        this.SetParamValue(TAG_PROCESSTAG2, strValue);
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

    public final boolean isNORMALPROCTYPENull() {
        return this.IsParamNull(TAG_NORMALPROCTYPE);
    }

    public final String getNORMALPROCTYPE() {
        return this.GetParamStringValue(TAG_NORMALPROCTYPE, "");
    }

    public final void setNORMALPROCTYPE(String strValue) {
        this.SetParamValue(TAG_NORMALPROCTYPE, strValue);
    }

    public final boolean isFORMCODENAMENull() {
        return this.IsParamNull(TAG_FORMCODENAME);
    }

    public final String getFORMCODENAME() {
        return this.GetParamStringValue(TAG_FORMCODENAME, "");
    }

    public final void setFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_FORMCODENAME, strValue);
    }

    public final boolean isMOBFORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBFORMCODENAME);
    }

    public final String getMOBFORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBFORMCODENAME, "");
    }

    public final void setMOBFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBFORMCODENAME, strValue);
    }

    public final boolean isUTILPSDEFORMIDNull() {
        return this.IsParamNull(TAG_UTILPSDEFORMID);
    }

    public final String getUTILPSDEFORMID() {
        return this.GetParamStringValue(TAG_UTILPSDEFORMID, "");
    }

    public final void setUTILPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_UTILPSDEFORMID, strValue);
    }

    public final boolean isUTILPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_UTILPSDEFORMNAME);
    }

    public final String getUTILPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_UTILPSDEFORMNAME, "");
    }

    public final void setUTILPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_UTILPSDEFORMNAME, strValue);
    }

    public final boolean isUTIL2PSDEFORMIDNull() {
        return this.IsParamNull(TAG_UTIL2PSDEFORMID);
    }

    public final String getUTIL2PSDEFORMID() {
        return this.GetParamStringValue(TAG_UTIL2PSDEFORMID, "");
    }

    public final void setUTIL2PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_UTIL2PSDEFORMID, strValue);
    }

    public final boolean isUTIL2PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_UTIL2PSDEFORMNAME);
    }

    public final String getUTIL2PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_UTIL2PSDEFORMNAME, "");
    }

    public final void setUTIL2PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_UTIL2PSDEFORMNAME, strValue);
    }

    public final boolean isUTIL3PSDEFORMIDNull() {
        return this.IsParamNull(TAG_UTIL3PSDEFORMID);
    }

    public final String getUTIL3PSDEFORMID() {
        return this.GetParamStringValue(TAG_UTIL3PSDEFORMID, "");
    }

    public final void setUTIL3PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_UTIL3PSDEFORMID, strValue);
    }

    public final boolean isUTIL3PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_UTIL3PSDEFORMNAME);
    }

    public final String getUTIL3PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_UTIL3PSDEFORMNAME, "");
    }

    public final void setUTIL3PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_UTIL3PSDEFORMNAME, strValue);
    }

    public final boolean isUTIL4PSDEFORMIDNull() {
        return this.IsParamNull(TAG_UTIL4PSDEFORMID);
    }

    public final String getUTIL4PSDEFORMID() {
        return this.GetParamStringValue(TAG_UTIL4PSDEFORMID, "");
    }

    public final void setUTIL4PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_UTIL4PSDEFORMID, strValue);
    }

    public final boolean isUTIL4PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_UTIL4PSDEFORMNAME);
    }

    public final String getUTIL4PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_UTIL4PSDEFORMNAME, "");
    }

    public final void setUTIL4PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_UTIL4PSDEFORMNAME, strValue);
    }

    public final boolean isUTIL5PSDEFORMIDNull() {
        return this.IsParamNull(TAG_UTIL5PSDEFORMID);
    }

    public final String getUTIL5PSDEFORMID() {
        return this.GetParamStringValue(TAG_UTIL5PSDEFORMID, "");
    }

    public final void setUTIL5PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_UTIL5PSDEFORMID, strValue);
    }

    public final boolean isUTIL5PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_UTIL5PSDEFORMNAME);
    }

    public final String getUTIL5PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_UTIL5PSDEFORMNAME, "");
    }

    public final void setUTIL5PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_UTIL5PSDEFORMNAME, strValue);
    }

    public final boolean isMOBUTIL5PSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBUTIL5PSDEFORMID);
    }

    public final String getMOBUTIL5PSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBUTIL5PSDEFORMID, "");
    }

    public final void setMOBUTIL5PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBUTIL5PSDEFORMID, strValue);
    }

    public final boolean isMOBUTIL5PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBUTIL5PSDEFORMNAME);
    }

    public final String getMOBUTIL5PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBUTIL5PSDEFORMNAME, "");
    }

    public final void setMOBUTIL5PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL5PSDEFORMNAME, strValue);
    }

    public final boolean isMOBUTILPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBUTILPSDEFORMID);
    }

    public final String getMOBUTILPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBUTILPSDEFORMID, "");
    }

    public final void setMOBUTILPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBUTILPSDEFORMID, strValue);
    }

    public final boolean isMOBUTILPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBUTILPSDEFORMNAME);
    }

    public final String getMOBUTILPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBUTILPSDEFORMNAME, "");
    }

    public final void setMOBUTILPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBUTILPSDEFORMNAME, strValue);
    }

    public final boolean isMOBUTIL2PSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBUTIL2PSDEFORMID);
    }

    public final String getMOBUTIL2PSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBUTIL2PSDEFORMID, "");
    }

    public final void setMOBUTIL2PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBUTIL2PSDEFORMID, strValue);
    }

    public final boolean isMOBUTIL2PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBUTIL2PSDEFORMNAME);
    }

    public final String getMOBUTIL2PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBUTIL2PSDEFORMNAME, "");
    }

    public final void setMOBUTIL2PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL2PSDEFORMNAME, strValue);
    }

    public final boolean isMOBUTIL3PSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBUTIL3PSDEFORMID);
    }

    public final String getMOBUTIL3PSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBUTIL3PSDEFORMID, "");
    }

    public final void setMOBUTIL3PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBUTIL3PSDEFORMID, strValue);
    }

    public final boolean isMOBUTIL3PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBUTIL3PSDEFORMNAME);
    }

    public final String getMOBUTIL3PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBUTIL3PSDEFORMNAME, "");
    }

    public final void setMOBUTIL3PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL3PSDEFORMNAME, strValue);
    }

    public final boolean isMOBUTIL4PSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBUTIL4PSDEFORMID);
    }

    public final String getMOBUTIL4PSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBUTIL4PSDEFORMID, "");
    }

    public final void setMOBUTIL4PSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBUTIL4PSDEFORMID, strValue);
    }

    public final boolean isMOBUTIL4PSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBUTIL4PSDEFORMNAME);
    }

    public final String getMOBUTIL4PSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBUTIL4PSDEFORMNAME, "");
    }

    public final void setMOBUTIL4PSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL4PSDEFORMNAME, strValue);
    }

    public final boolean isUTILFORMCODENAMENull() {
        return this.IsParamNull(TAG_UTILFORMCODENAME);
    }

    public final String getUTILFORMCODENAME() {
        return this.GetParamStringValue(TAG_UTILFORMCODENAME, "");
    }

    public final void setUTILFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_UTILFORMCODENAME, strValue);
    }

    public final boolean isUTIL2FORMCODENAMENull() {
        return this.IsParamNull(TAG_UTIL2FORMCODENAME);
    }

    public final String getUTIL2FORMCODENAME() {
        return this.GetParamStringValue(TAG_UTIL2FORMCODENAME, "");
    }

    public final void setUTIL2FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_UTIL2FORMCODENAME, strValue);
    }

    public final boolean isUTIL3FORMCODENAMENull() {
        return this.IsParamNull(TAG_UTIL3FORMCODENAME);
    }

    public final String getUTIL3FORMCODENAME() {
        return this.GetParamStringValue(TAG_UTIL3FORMCODENAME, "");
    }

    public final void setUTIL3FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_UTIL3FORMCODENAME, strValue);
    }

    public final boolean isUTIL4FORMCODENAMENull() {
        return this.IsParamNull(TAG_UTIL4FORMCODENAME);
    }

    public final String getUTIL4FORMCODENAME() {
        return this.GetParamStringValue(TAG_UTIL4FORMCODENAME, "");
    }

    public final void setUTIL4FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_UTIL4FORMCODENAME, strValue);
    }

    public final boolean isUTIL5FORMCODENAMENull() {
        return this.IsParamNull(TAG_UTIL5FORMCODENAME);
    }

    public final String getUTIL5FORMCODENAME() {
        return this.GetParamStringValue(TAG_UTIL5FORMCODENAME, "");
    }

    public final void setUTIL5FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_UTIL5FORMCODENAME, strValue);
    }

    public final boolean isMOBUTIL5FORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBUTIL5FORMCODENAME);
    }

    public final String getMOBUTIL5FORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBUTIL5FORMCODENAME, "");
    }

    public final void setMOBUTIL5FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL5FORMCODENAME, strValue);
    }

    public final boolean isMOBUTIL4FORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBUTIL4FORMCODENAME);
    }

    public final String getMOBUTIL4FORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBUTIL4FORMCODENAME, "");
    }

    public final void setMOBUTIL4FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL4FORMCODENAME, strValue);
    }

    public final boolean isMOBUTIL3FORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBUTIL3FORMCODENAME);
    }

    public final String getMOBUTIL3FORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBUTIL3FORMCODENAME, "");
    }

    public final void setMOBUTIL3FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL3FORMCODENAME, strValue);
    }

    public final boolean isMOBUTIL2FORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBUTIL2FORMCODENAME);
    }

    public final String getMOBUTIL2FORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBUTIL2FORMCODENAME, "");
    }

    public final void setMOBUTIL2FORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUTIL2FORMCODENAME, strValue);
    }

    public final boolean isMOBUTILFORMCODENAMENull() {
        return this.IsParamNull(TAG_MOBUTILFORMCODENAME);
    }

    public final String getMOBUTILFORMCODENAME() {
        return this.GetParamStringValue(TAG_MOBUTILFORMCODENAME, "");
    }

    public final void setMOBUTILFORMCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUTILFORMCODENAME, strValue);
    }

    public final boolean isEDITFIELDSNull() {
        return this.IsParamNull(TAG_EDITFIELDS);
    }

    public final String getEDITFIELDS() {
        return this.GetParamStringValue(TAG_EDITFIELDS, "");
    }

    public final void setEDITFIELDS(String strValue) {
        this.SetParamValue(TAG_EDITFIELDS, strValue);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isMOBPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_MOBPSDEUAGROUPID);
    }

    public final String getMOBPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_MOBPSDEUAGROUPID, "");
    }

    public final void setMOBPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEUAGROUPID, strValue);
    }

    public final boolean isMOBPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEUAGROUPNAME);
    }

    public final String getMOBPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEUAGROUPNAME, "");
    }

    public final void setMOBPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEUAGROUPNAME, strValue);
    }

    public final boolean isUAGROUPCODENAMENull() {
        return this.IsParamNull(TAG_UAGROUPCODENAME);
    }

    public final String getUAGROUPCODENAME() {
        return this.GetParamStringValue(TAG_UAGROUPCODENAME, "");
    }

    public final void setUAGROUPCODENAME(String strValue) {
        this.SetParamValue(TAG_UAGROUPCODENAME, strValue);
    }

    public final boolean isMOBUAGROUPCODENAMENull() {
        return this.IsParamNull(TAG_MOBUAGROUPCODENAME);
    }

    public final String getMOBUAGROUPCODENAME() {
        return this.GetParamStringValue(TAG_MOBUAGROUPCODENAME, "");
    }

    public final void setMOBUAGROUPCODENAME(String strValue) {
        this.SetParamValue(TAG_MOBUAGROUPCODENAME, strValue);
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

