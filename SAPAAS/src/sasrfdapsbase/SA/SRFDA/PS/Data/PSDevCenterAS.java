/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenterAS
extends BaseDataEntity {
    public static final String ASTYPE_TOMCAT7 = "TOMCAT7";
    public static final String ASMODE_PSAS = "PSAS";
    public static final String ASMODE_PSDEVCENTERSERVER = "PSDEVCENTERSERVER";
    public static final String USAGEMODE_DEVELOP = "DEVELOP";
    public static final String USAGEMODE_DEPLOY = "DEPLOY";
    public static final String UPLOADFILEMODE_SSH = "SSH";
    public static final String UPLOADFILEMODE_SFTP = "SFTP";
    public static final String UPLOADFILEMODE_FTP = "FTP";
    public static final String TAG_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String TAG_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String TAG_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ASTYPE = "ASTYPE";
    public static final String TAG_HTTPPORT = "HTTPPORT";
    public static final String TAG_HTTPSPORT = "HTTPSPORT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ASMODE = "ASMODE";
    public static final String TAG_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String TAG_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String TAG_REFFLAG = "REFFLAG";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_REFOBJNAME = "REFOBJNAME";
    public static final String TAG_USAGEMODE = "USAGEMODE";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_LOCKMODE = "LOCKMODE";
    public static final String TAG_LOCKOBJID = "LOCKOBJID";
    public static final String TAG_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String TAG_HOSTADDRESS = "HOSTADDRESS";
    public static final String TAG_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String TAG_HOSTPASSWD = "HOSTPASSWD";
    public static final String TAG_ASINSTALLPATH = "ASINSTALLPATH";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_HOSTPORT = "HOSTPORT";
    public static final String TAG_STARTCMD = "STARTCMD";
    public static final String TAG_STOPCMD = "STOPCMD";
    public static final String TAG_HTTPADDRESS = "HTTPADDRESS";

    public final boolean isPSDEVCENTERASIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERASID);
    }

    public final String getPSDEVCENTERASID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID, "");
    }

    public final void setPSDEVCENTERASID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID, strValue);
    }

    public final boolean isPSDEVCENTERASNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME);
    }

    public final String getPSDEVCENTERASNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME, "");
    }

    public final void setPSDEVCENTERASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
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

    public final boolean isASMODENull() {
        return this.IsParamNull(TAG_ASMODE);
    }

    public final String getASMODE() {
        return this.GetParamStringValue(TAG_ASMODE, "");
    }

    public final void setASMODE(String strValue) {
        this.SetParamValue(TAG_ASMODE, strValue);
    }

    public final boolean isPSDEVCENTERSERVERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSERVERID);
    }

    public final String getPSDEVCENTERSERVERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSERVERID, "");
    }

    public final void setPSDEVCENTERSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSERVERID, strValue);
    }

    public final boolean isPSDEVCENTERSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSERVERNAME);
    }

    public final String getPSDEVCENTERSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSERVERNAME, "");
    }

    public final void setPSDEVCENTERSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSERVERNAME, strValue);
    }

    public final boolean isREFFLAGNull() {
        return this.IsParamNull(TAG_REFFLAG);
    }

    public final boolean getREFFLAG() {
        return this.GetParamIntValue(TAG_REFFLAG, 0) == 1;
    }

    public final void setREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_REFFLAG, bValue ? 1 : 0);
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

    public final boolean isREFOBJNAMENull() {
        return this.IsParamNull(TAG_REFOBJNAME);
    }

    public final String getREFOBJNAME() {
        return this.GetParamStringValue(TAG_REFOBJNAME, "");
    }

    public final void setREFOBJNAME(String strValue) {
        this.SetParamValue(TAG_REFOBJNAME, strValue);
    }

    public final boolean isUSAGEMODENull() {
        return this.IsParamNull(TAG_USAGEMODE);
    }

    public final String getUSAGEMODE() {
        return this.GetParamStringValue(TAG_USAGEMODE, "");
    }

    public final void setUSAGEMODE(String strValue) {
        this.SetParamValue(TAG_USAGEMODE, strValue);
    }

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
    }

    public final boolean isRESPOSNull() {
        return this.IsParamNull(TAG_RESPOS);
    }

    public final int getRESPOS() {
        return this.GetParamIntValue(TAG_RESPOS, 0);
    }

    public final void setRESPOS(int nValue) {
        this.SetParamValue(TAG_RESPOS, nValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
    }

    public final boolean isLOCKMODENull() {
        return this.IsParamNull(TAG_LOCKMODE);
    }

    public final int getLOCKMODE() {
        return this.GetParamIntValue(TAG_LOCKMODE, 0);
    }

    public final void setLOCKMODE(int nValue) {
        this.SetParamValue(TAG_LOCKMODE, nValue);
    }

    public final boolean isLOCKOBJIDNull() {
        return this.IsParamNull(TAG_LOCKOBJID);
    }

    public final String getLOCKOBJID() {
        return this.GetParamStringValue(TAG_LOCKOBJID, "");
    }

    public final void setLOCKOBJID(String strValue) {
        this.SetParamValue(TAG_LOCKOBJID, strValue);
    }

    public final boolean isLOCKOBJTYPENull() {
        return this.IsParamNull(TAG_LOCKOBJTYPE);
    }

    public final String getLOCKOBJTYPE() {
        return this.GetParamStringValue(TAG_LOCKOBJTYPE, "");
    }

    public final void setLOCKOBJTYPE(String strValue) {
        this.SetParamValue(TAG_LOCKOBJTYPE, strValue);
    }

    public final boolean isHOSTADDRESSNull() {
        return this.IsParamNull(TAG_HOSTADDRESS);
    }

    public final String getHOSTADDRESS() {
        return this.GetParamStringValue(TAG_HOSTADDRESS, "");
    }

    public final void setHOSTADDRESS(String strValue) {
        this.SetParamValue(TAG_HOSTADDRESS, strValue);
    }

    public final boolean isHOSTUSERNAMENull() {
        return this.IsParamNull(TAG_HOSTUSERNAME);
    }

    public final String getHOSTUSERNAME() {
        return this.GetParamStringValue(TAG_HOSTUSERNAME, "");
    }

    public final void setHOSTUSERNAME(String strValue) {
        this.SetParamValue(TAG_HOSTUSERNAME, strValue);
    }

    public final boolean isHOSTPASSWDNull() {
        return this.IsParamNull(TAG_HOSTPASSWD);
    }

    public final String getHOSTPASSWD() {
        return this.GetParamStringValue(TAG_HOSTPASSWD, "");
    }

    public final void setHOSTPASSWD(String strValue) {
        this.SetParamValue(TAG_HOSTPASSWD, strValue);
    }

    public final boolean isASINSTALLPATHNull() {
        return this.IsParamNull(TAG_ASINSTALLPATH);
    }

    public final String getASINSTALLPATH() {
        return this.GetParamStringValue(TAG_ASINSTALLPATH, "");
    }

    public final void setASINSTALLPATH(String strValue) {
        this.SetParamValue(TAG_ASINSTALLPATH, strValue);
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

    public final boolean isUPLOADFILEMODENull() {
        return this.IsParamNull(TAG_UPLOADFILEMODE);
    }

    public final String getUPLOADFILEMODE() {
        return this.GetParamStringValue(TAG_UPLOADFILEMODE, "");
    }

    public final void setUPLOADFILEMODE(String strValue) {
        this.SetParamValue(TAG_UPLOADFILEMODE, strValue);
    }

    public final boolean isHOSTPORTNull() {
        return this.IsParamNull(TAG_HOSTPORT);
    }

    public final int getHOSTPORT() {
        return this.GetParamIntValue(TAG_HOSTPORT, 0);
    }

    public final void setHOSTPORT(int nValue) {
        this.SetParamValue(TAG_HOSTPORT, nValue);
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

    public final boolean isHTTPADDRESSNull() {
        return this.IsParamNull(TAG_HTTPADDRESS);
    }

    public final String getHTTPADDRESS() {
        return this.GetParamStringValue(TAG_HTTPADDRESS, "");
    }

    public final void setHTTPADDRESS(String strValue) {
        this.SetParamValue(TAG_HTTPADDRESS, strValue);
    }
}

