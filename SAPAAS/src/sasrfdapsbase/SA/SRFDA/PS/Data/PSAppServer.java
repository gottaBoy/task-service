/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppServer
extends BaseDataEntity {
    public static final String ASTYPE_TOMCAT7 = "TOMCAT7";
    public static final String UPLOADFILEMODE_SSH = "SSH";
    public static final String UPLOADFILEMODE_SFTP = "SFTP";
    public static final String UPLOADFILEMODE_FTP = "FTP";
    public static final String TAG_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String TAG_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ASTYPE = "ASTYPE";
    public static final String TAG_HTTPPORT = "HTTPPORT";
    public static final String TAG_HTTPSPORT = "HTTPSPORT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_STARTCMD = "STARTCMD";
    public static final String TAG_STOPCMD = "STOPCMD";
    public static final String TAG_APPFOLDER = "APPFOLDER";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_ASSTATE = "ASSTATE";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_PSSVRSERVERID = "PSSVRSERVERID";
    public static final String TAG_PSSVRSERVERNAME = "PSSVRSERVERNAME";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_HTTPADDRESS = "HTTPADDRESS";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_LOCALRES = "LOCALRES";

    public final boolean isPSAPPSERVERIDNull() {
        return this.IsParamNull(TAG_PSAPPSERVERID);
    }

    public final String getPSAPPSERVERID() {
        return this.GetParamStringValue(TAG_PSAPPSERVERID, "");
    }

    public final void setPSAPPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSAPPSERVERID, strValue);
    }

    public final boolean isPSAPPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSAPPSERVERNAME);
    }

    public final String getPSAPPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSAPPSERVERNAME, "");
    }

    public final void setPSAPPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSERVERNAME, strValue);
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

    public final boolean isASTYPENull() {
        return this.IsParamNull(TAG_ASTYPE);
    }

    public final String getASTYPE() {
        return this.GetParamStringValue(TAG_ASTYPE, "");
    }

    public final void setASTYPE(String strValue) {
        this.SetParamValue(TAG_ASTYPE, strValue);
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

    public final boolean isHTTPSPORTNull() {
        return this.IsParamNull(TAG_HTTPSPORT);
    }

    public final int getHTTPSPORT() {
        return this.GetParamIntValue(TAG_HTTPSPORT, 0);
    }

    public final void setHTTPSPORT(int nValue) {
        this.SetParamValue(TAG_HTTPSPORT, nValue);
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

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
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

    public final boolean isAPPFOLDERNull() {
        return this.IsParamNull(TAG_APPFOLDER);
    }

    public final String getAPPFOLDER() {
        return this.GetParamStringValue(TAG_APPFOLDER, "");
    }

    public final void setAPPFOLDER(String strValue) {
        this.SetParamValue(TAG_APPFOLDER, strValue);
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

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
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

    public final boolean isASSTATENull() {
        return this.IsParamNull(TAG_ASSTATE);
    }

    public final int getASSTATE() {
        return this.GetParamIntValue(TAG_ASSTATE, 0);
    }

    public final void setASSTATE(int nValue) {
        this.SetParamValue(TAG_ASSTATE, nValue);
    }

    public final boolean isREFINFONull() {
        return this.IsParamNull(TAG_REFINFO);
    }

    public final String getREFINFO() {
        return this.GetParamStringValue(TAG_REFINFO, "");
    }

    public final void setREFINFO(String strValue) {
        this.SetParamValue(TAG_REFINFO, strValue);
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

    public final boolean isUPLOADFILEMODENull() {
        return this.IsParamNull(TAG_UPLOADFILEMODE);
    }

    public final String getUPLOADFILEMODE() {
        return this.GetParamStringValue(TAG_UPLOADFILEMODE, "");
    }

    public final void setUPLOADFILEMODE(String strValue) {
        this.SetParamValue(TAG_UPLOADFILEMODE, strValue);
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

    public final boolean isUPLOADPATHNull() {
        return this.IsParamNull(TAG_UPLOADPATH);
    }

    public final String getUPLOADPATH() {
        return this.GetParamStringValue(TAG_UPLOADPATH, "");
    }

    public final void setUPLOADPATH(String strValue) {
        this.SetParamValue(TAG_UPLOADPATH, strValue);
    }

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isLOCALRESNull() {
        return this.IsParamNull(TAG_LOCALRES);
    }

    public final boolean getLOCALRES() {
        return this.GetParamIntValue(TAG_LOCALRES, 0) == 1;
    }

    public final void setLOCALRES(boolean bValue) {
        this.SetParamValue(TAG_LOCALRES, bValue ? 1 : 0);
    }
}

