/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFPreviewNode
extends BaseDataEntity {
    public static final String UPLOADFILEMODE_SSH = "SSH";
    public static final String UPLOADFILEMODE_SFTP = "SFTP";
    public static final String UPLOADFILEMODE_FTP = "FTP";
    public static final int ASSTATE_10 = 10;
    public static final int ASSTATE_20 = 20;
    public static final int ASSTATE_30 = 30;
    public static final int ASSTATE_35 = 35;
    public static final int ASSTATE_40 = 40;
    public static final String TAG_PSPFPREVIEWNODEID = "PSPFPREVIEWNODEID";
    public static final String TAG_PSPFPREVIEWNODENAME = "PSPFPREVIEWNODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_CFGFOLDER = "CFGFOLDER";
    public static final String TAG_ADMINPASSWD = "ADMINPASSWD";
    public static final String TAG_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_HTTPADDRESS = "HTTPADDRESS";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_ASSTATE = "ASSTATE";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_APPFOLDER = "APPFOLDER";
    public static final String TAG_STARTCMD = "STARTCMD";
    public static final String TAG_STOPCMD = "STOPCMD";
    public static final String TAG_HTTPSPORT = "HTTPSPORT";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_HTTPPORT = "HTTPPORT";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_PSSVRSERVERID = "PSSVRSERVERID";
    public static final String TAG_PSSVRSERVERNAME = "PSSVRSERVERNAME";
    public static final String TAG_LASTPREVIEWTIME = "LASTPREVIEWTIME";
    public static final String TAG_PREVIEWURL = "PREVIEWURL";

    public final boolean isPSPFPREVIEWNODEIDNull() {
        return this.IsParamNull(TAG_PSPFPREVIEWNODEID);
    }

    public final String getPSPFPREVIEWNODEID() {
        return this.GetParamStringValue(TAG_PSPFPREVIEWNODEID, "");
    }

    public final void setPSPFPREVIEWNODEID(String strValue) {
        this.SetParamValue(TAG_PSPFPREVIEWNODEID, strValue);
    }

    public final boolean isPSPFPREVIEWNODENAMENull() {
        return this.IsParamNull(TAG_PSPFPREVIEWNODENAME);
    }

    public final String getPSPFPREVIEWNODENAME() {
        return this.GetParamStringValue(TAG_PSPFPREVIEWNODENAME, "");
    }

    public final void setPSPFPREVIEWNODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFPREVIEWNODENAME, strValue);
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

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isCFGFOLDERNull() {
        return this.IsParamNull(TAG_CFGFOLDER);
    }

    public final String getCFGFOLDER() {
        return this.GetParamStringValue(TAG_CFGFOLDER, "");
    }

    public final void setCFGFOLDER(String strValue) {
        this.SetParamValue(TAG_CFGFOLDER, strValue);
    }

    public final boolean isADMINPASSWDNull() {
        return this.IsParamNull(TAG_ADMINPASSWD);
    }

    public final String getADMINPASSWD() {
        return this.GetParamStringValue(TAG_ADMINPASSWD, "");
    }

    public final void setADMINPASSWD(String strValue) {
        this.SetParamValue(TAG_ADMINPASSWD, strValue);
    }

    public final boolean isADMINUSERNAMENull() {
        return this.IsParamNull(TAG_ADMINUSERNAME);
    }

    public final String getADMINUSERNAME() {
        return this.GetParamStringValue(TAG_ADMINUSERNAME, "");
    }

    public final void setADMINUSERNAME(String strValue) {
        this.SetParamValue(TAG_ADMINUSERNAME, strValue);
    }

    public final boolean isUPLOADPATHNull() {
        return this.IsParamNull(TAG_UPLOADPATH);
    }

    public final String getUPLOADPATH() {
        return this.GetParamStringValue(TAG_UPLOADPATH, "");
    }

    public final void setUPLOADPATH(String strValue) {
        this.SetParamValue(TAG_UPLOADPATH, strValue);
    }

    public final boolean isHTTPADDRESSNull() {
        return this.IsParamNull(TAG_HTTPADDRESS);
    }

    public final String getHTTPADDRESS() {
        return this.GetParamStringValue(TAG_HTTPADDRESS, "");
    }

    public final void setHTTPADDRESS(String strValue) {
        this.SetParamValue(TAG_HTTPADDRESS, strValue);
    }

    public final boolean isPARAM7Null() {
        return this.IsParamNull(TAG_PARAM7);
    }

    public final int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public final void setPARAM7(int nValue) {
        this.SetParamValue(TAG_PARAM7, nValue);
    }

    public final boolean isPARAM8Null() {
        return this.IsParamNull(TAG_PARAM8);
    }

    public final int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public final void setPARAM8(int nValue) {
        this.SetParamValue(TAG_PARAM8, nValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public final void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public final void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public final boolean isPARAM5Null() {
        return this.IsParamNull(TAG_PARAM5);
    }

    public final int getPARAM5() {
        return this.GetParamIntValue(TAG_PARAM5, 0);
    }

    public final void setPARAM5(int nValue) {
        this.SetParamValue(TAG_PARAM5, nValue);
    }

    public final boolean isPARAM6Null() {
        return this.IsParamNull(TAG_PARAM6);
    }

    public final int getPARAM6() {
        return this.GetParamIntValue(TAG_PARAM6, 0);
    }

    public final void setPARAM6(int nValue) {
        this.SetParamValue(TAG_PARAM6, nValue);
    }

    public final boolean isPARAMNull() {
        return this.IsParamNull(TAG_PARAM);
    }

    public final String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public final void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isUPLOADFILEMODENull() {
        return this.IsParamNull(TAG_UPLOADFILEMODE);
    }

    public final String getUPLOADFILEMODE() {
        return this.GetParamStringValue(TAG_UPLOADFILEMODE, "");
    }

    public final void setUPLOADFILEMODE(String strValue) {
        this.SetParamValue(TAG_UPLOADFILEMODE, strValue);
    }

    public final boolean isASSTATENull() {
        return this.IsParamNull(TAG_ASSTATE);
    }

    public final int getASSTATE() {
        return this.GetParamIntValue(TAG_ASSTATE, 0);
    }

    public final void setASSTATE(int nValue) {
        this.SetParamValue(TAG_ASSTATE, nValue);
    }

    public final boolean isSSHIPADDRNull() {
        return this.IsParamNull(TAG_SSHIPADDR);
    }

    public final String getSSHIPADDR() {
        return this.GetParamStringValue(TAG_SSHIPADDR, "");
    }

    public final void setSSHIPADDR(String strValue) {
        this.SetParamValue(TAG_SSHIPADDR, strValue);
    }

    public final boolean isSSHPORTNull() {
        return this.IsParamNull(TAG_SSHPORT);
    }

    public final int getSSHPORT() {
        return this.GetParamIntValue(TAG_SSHPORT, 0);
    }

    public final void setSSHPORT(int nValue) {
        this.SetParamValue(TAG_SSHPORT, nValue);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isAPPFOLDERNull() {
        return this.IsParamNull(TAG_APPFOLDER);
    }

    public final String getAPPFOLDER() {
        return this.GetParamStringValue(TAG_APPFOLDER, "");
    }

    public final void setAPPFOLDER(String strValue) {
        this.SetParamValue(TAG_APPFOLDER, strValue);
    }

    public final boolean isSTARTCMDNull() {
        return this.IsParamNull(TAG_STARTCMD);
    }

    public final String getSTARTCMD() {
        return this.GetParamStringValue(TAG_STARTCMD, "");
    }

    public final void setSTARTCMD(String strValue) {
        this.SetParamValue(TAG_STARTCMD, strValue);
    }

    public final boolean isSTOPCMDNull() {
        return this.IsParamNull(TAG_STOPCMD);
    }

    public final String getSTOPCMD() {
        return this.GetParamStringValue(TAG_STOPCMD, "");
    }

    public final void setSTOPCMD(String strValue) {
        this.SetParamValue(TAG_STOPCMD, strValue);
    }

    public final boolean isHTTPSPORTNull() {
        return this.IsParamNull(TAG_HTTPSPORT);
    }

    public final int getHTTPSPORT() {
        return this.GetParamIntValue(TAG_HTTPSPORT, 0);
    }

    public final void setHTTPSPORT(int nValue) {
        this.SetParamValue(TAG_HTTPSPORT, nValue);
    }

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
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

    public final boolean isHTTPPORTNull() {
        return this.IsParamNull(TAG_HTTPPORT);
    }

    public final int getHTTPPORT() {
        return this.GetParamIntValue(TAG_HTTPPORT, 0);
    }

    public final void setHTTPPORT(int nValue) {
        this.SetParamValue(TAG_HTTPPORT, nValue);
    }

    public final boolean isPSSVRDOMAINIDNull() {
        return this.IsParamNull(TAG_PSSVRDOMAINID);
    }

    public final String getPSSVRDOMAINID() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINID, "");
    }

    public final void setPSSVRDOMAINID(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINID, strValue);
    }

    public final boolean isPSSVRDOMAINNAMENull() {
        return this.IsParamNull(TAG_PSSVRDOMAINNAME);
    }

    public final String getPSSVRDOMAINNAME() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINNAME, "");
    }

    public final void setPSSVRDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINNAME, strValue);
    }

    public final boolean isPSSVRSERVERIDNull() {
        return this.IsParamNull(TAG_PSSVRSERVERID);
    }

    public final String getPSSVRSERVERID() {
        return this.GetParamStringValue(TAG_PSSVRSERVERID, "");
    }

    public final void setPSSVRSERVERID(String strValue) {
        this.SetParamValue(TAG_PSSVRSERVERID, strValue);
    }

    public final boolean isPSSVRSERVERNAMENull() {
        return this.IsParamNull(TAG_PSSVRSERVERNAME);
    }

    public final String getPSSVRSERVERNAME() {
        return this.GetParamStringValue(TAG_PSSVRSERVERNAME, "");
    }

    public final void setPSSVRSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRSERVERNAME, strValue);
    }

    public final boolean isLASTPREVIEWTIMENull() {
        return this.IsParamNull(TAG_LASTPREVIEWTIME);
    }

    public final Date getLASTPREVIEWTIME() {
        return this.GetParamDateValue(TAG_LASTPREVIEWTIME, null);
    }

    public final void setLASTPREVIEWTIME(Date dtValue) {
        this.SetParamValue(TAG_LASTPREVIEWTIME, dtValue);
    }

    public final boolean isPREVIEWURLNull() {
        return this.IsParamNull(TAG_PREVIEWURL);
    }

    public final String getPREVIEWURL() {
        return this.GetParamStringValue(TAG_PREVIEWURL, "");
    }

    public final void setPREVIEWURL(String strValue) {
        this.SetParamValue(TAG_PREVIEWURL, strValue);
    }
}

