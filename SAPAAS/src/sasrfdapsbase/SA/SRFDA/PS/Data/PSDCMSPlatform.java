/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCMSPlatform
extends BaseDataEntity {
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final int RESPOS_1 = 1;
    public static final int RESPOS_2 = 2;
    public static final int RESPOS_5 = 5;
    public static final String UPLOADFILEMODE_SSH = "SSH";
    public static final String UPLOADFILEMODE_SFTP = "SFTP";
    public static final String UPLOADFILEMODE_FTP = "FTP";
    public static final String TAG_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String TAG_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSMSPLATFORMID = "PSMSPLATFORMID";
    public static final String TAG_PSMSPLATFORMNAME = "PSMSPLATFORMNAME";
    public static final String TAG_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String TAG_ADMINPASSWD = "ADMINPASSWD";
    public static final String TAG_RESREADYTIME = "RESREADYTIME";
    public static final String TAG_RESVER = "RESVER";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_WORKSHOPPATH = "WORKSHOPPATH";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_REFCOUNT = "REFCOUNT";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String TAG_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String TAG_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String TAG_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String TAG_PSDCFILEID = "PSDCFILEID";
    public static final String TAG_PSDCFILENAME = "PSDCFILENAME";
    public static final String TAG_CLUSTERNAMESPACE = "CLUSTERNAMESPACE";
    public static final String TAG_CFGSERVICEURL = "CFGSERVICEURL";
    public static final String TAG_SERVICEURL = "SERVICEURL";

    public final boolean isPSDCMSPLATFORMIDNull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMID);
    }

    public final String getPSDCMSPLATFORMID() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMID, "");
    }

    public final void setPSDCMSPLATFORMID(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMID, strValue);
    }

    public final boolean isPSDCMSPLATFORMNAMENull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMNAME);
    }

    public final String getPSDCMSPLATFORMNAME() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMNAME, "");
    }

    public final void setPSDCMSPLATFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMNAME, strValue);
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

    public final boolean isPSMSPLATFORMIDNull() {
        return this.IsParamNull(TAG_PSMSPLATFORMID);
    }

    public final String getPSMSPLATFORMID() {
        return this.GetParamStringValue(TAG_PSMSPLATFORMID, "");
    }

    public final void setPSMSPLATFORMID(String strValue) {
        this.SetParamValue(TAG_PSMSPLATFORMID, strValue);
    }

    public final boolean isPSMSPLATFORMNAMENull() {
        return this.IsParamNull(TAG_PSMSPLATFORMNAME);
    }

    public final String getPSMSPLATFORMNAME() {
        return this.GetParamStringValue(TAG_PSMSPLATFORMNAME, "");
    }

    public final void setPSMSPLATFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSMSPLATFORMNAME, strValue);
    }

    public final boolean isWEBCONSOLEPATHNull() {
        return this.IsParamNull(TAG_WEBCONSOLEPATH);
    }

    public final String getWEBCONSOLEPATH() {
        return this.GetParamStringValue(TAG_WEBCONSOLEPATH, "");
    }

    public final void setWEBCONSOLEPATH(String strValue) {
        this.SetParamValue(TAG_WEBCONSOLEPATH, strValue);
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

    public final boolean isSSHPORTNull() {
        return this.IsParamNull(TAG_SSHPORT);
    }

    public final int getSSHPORT() {
        return this.GetParamIntValue(TAG_SSHPORT, 0);
    }

    public final void setSSHPORT(int nValue) {
        this.SetParamValue(TAG_SSHPORT, nValue);
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

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
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

    public final boolean isIPADDR2Null() {
        return this.IsParamNull(TAG_IPADDR2);
    }

    public final String getIPADDR2() {
        return this.GetParamStringValue(TAG_IPADDR2, "");
    }

    public final void setIPADDR2(String strValue) {
        this.SetParamValue(TAG_IPADDR2, strValue);
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

    public final boolean isADMINUSERNAMENull() {
        return this.IsParamNull(TAG_ADMINUSERNAME);
    }

    public final String getADMINUSERNAME() {
        return this.GetParamStringValue(TAG_ADMINUSERNAME, "");
    }

    public final void setADMINUSERNAME(String strValue) {
        this.SetParamValue(TAG_ADMINUSERNAME, strValue);
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

    public final boolean isRESREADYTIMENull() {
        return this.IsParamNull(TAG_RESREADYTIME);
    }

    public final Date getRESREADYTIME() {
        return this.GetParamDateValue(TAG_RESREADYTIME, null);
    }

    public final void setRESREADYTIME(Date dtValue) {
        this.SetParamValue(TAG_RESREADYTIME, dtValue);
    }

    public final boolean isRESVERNull() {
        return this.IsParamNull(TAG_RESVER);
    }

    public final int getRESVER() {
        return this.GetParamIntValue(TAG_RESVER, 0);
    }

    public final void setRESVER(int nValue) {
        this.SetParamValue(TAG_RESVER, nValue);
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

    public final boolean isPORTNull() {
        return this.IsParamNull(TAG_PORT);
    }

    public final int getPORT() {
        return this.GetParamIntValue(TAG_PORT, 0);
    }

    public final void setPORT(int nValue) {
        this.SetParamValue(TAG_PORT, nValue);
    }

    public final boolean isWORKSHOPPATHNull() {
        return this.IsParamNull(TAG_WORKSHOPPATH);
    }

    public final String getWORKSHOPPATH() {
        return this.GetParamStringValue(TAG_WORKSHOPPATH, "");
    }

    public final void setWORKSHOPPATH(String strValue) {
        this.SetParamValue(TAG_WORKSHOPPATH, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isREFCOUNTNull() {
        return this.IsParamNull(TAG_REFCOUNT);
    }

    public final int getREFCOUNT() {
        return this.GetParamIntValue(TAG_REFCOUNT, 0);
    }

    public final void setREFCOUNT(int nValue) {
        this.SetParamValue(TAG_REFCOUNT, nValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isPSDCCLUSTERIDNull() {
        return this.IsParamNull(TAG_PSDCCLUSTERID);
    }

    public final String getPSDCCLUSTERID() {
        return this.GetParamStringValue(TAG_PSDCCLUSTERID, "");
    }

    public final void setPSDCCLUSTERID(String strValue) {
        this.SetParamValue(TAG_PSDCCLUSTERID, strValue);
    }

    public final boolean isPSDCCLUSTERNAMENull() {
        return this.IsParamNull(TAG_PSDCCLUSTERNAME);
    }

    public final String getPSDCCLUSTERNAME() {
        return this.GetParamStringValue(TAG_PSDCCLUSTERNAME, "");
    }

    public final void setPSDCCLUSTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCLUSTERNAME, strValue);
    }

    public final boolean isPSDCCONTAINERSPECIDNull() {
        return this.IsParamNull(TAG_PSDCCONTAINERSPECID);
    }

    public final String getPSDCCONTAINERSPECID() {
        return this.GetParamStringValue(TAG_PSDCCONTAINERSPECID, "");
    }

    public final void setPSDCCONTAINERSPECID(String strValue) {
        this.SetParamValue(TAG_PSDCCONTAINERSPECID, strValue);
    }

    public final boolean isPSDCCONTAINERSPECNAMENull() {
        return this.IsParamNull(TAG_PSDCCONTAINERSPECNAME);
    }

    public final String getPSDCCONTAINERSPECNAME() {
        return this.GetParamStringValue(TAG_PSDCCONTAINERSPECNAME, "");
    }

    public final void setPSDCCONTAINERSPECNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCONTAINERSPECNAME, strValue);
    }

    public final boolean isPSDCFILEIDNull() {
        return this.IsParamNull(TAG_PSDCFILEID);
    }

    public final String getPSDCFILEID() {
        return this.GetParamStringValue(TAG_PSDCFILEID, "");
    }

    public final void setPSDCFILEID(String strValue) {
        this.SetParamValue(TAG_PSDCFILEID, strValue);
    }

    public final boolean isPSDCFILENAMENull() {
        return this.IsParamNull(TAG_PSDCFILENAME);
    }

    public final String getPSDCFILENAME() {
        return this.GetParamStringValue(TAG_PSDCFILENAME, "");
    }

    public final void setPSDCFILENAME(String strValue) {
        this.SetParamValue(TAG_PSDCFILENAME, strValue);
    }

    public final boolean isCLUSTERNAMESPACENull() {
        return this.IsParamNull(TAG_CLUSTERNAMESPACE);
    }

    public final String getCLUSTERNAMESPACE() {
        return this.GetParamStringValue(TAG_CLUSTERNAMESPACE, "");
    }

    public final void setCLUSTERNAMESPACE(String strValue) {
        this.SetParamValue(TAG_CLUSTERNAMESPACE, strValue);
    }

    public final boolean isCFGSERVICEURLNull() {
        return this.IsParamNull(TAG_CFGSERVICEURL);
    }

    public final String getCFGSERVICEURL() {
        return this.GetParamStringValue(TAG_CFGSERVICEURL, "");
    }

    public final void setCFGSERVICEURL(String strValue) {
        this.SetParamValue(TAG_CFGSERVICEURL, strValue);
    }

    public final boolean isSERVICEURLNull() {
        return this.IsParamNull(TAG_SERVICEURL);
    }

    public final String getSERVICEURL() {
        return this.GetParamStringValue(TAG_SERVICEURL, "");
    }

    public final void setSERVICEURL(String strValue) {
        this.SetParamValue(TAG_SERVICEURL, strValue);
    }
}

