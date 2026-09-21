/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCMSPlatformNode
extends BaseDataEntity {
    public static final String UPLOADFILEMODE_SSH = "SSH";
    public static final String UPLOADFILEMODE_SFTP = "SFTP";
    public static final String UPLOADFILEMODE_FTP = "FTP";
    public static final String TAG_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String TAG_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String TAG_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String TAG_PSMSPLATFORMNODEID = "PSMSPLATFORMNODEID";
    public static final String TAG_PSMSPLATFORMNODENAME = "PSMSPLATFORMNODENAME";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_WORKSHOPPATH = "WORKSHOPPATH";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_PSDCREGISTRYITEMID = "PSDCREGISTRYITEMID";
    public static final String TAG_PSDCREGISTRYITEMNAME = "PSDCREGISTRYITEMNAME";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";

    public final boolean isPSDCMSPLATFORMNODEIDNull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMNODEID);
    }

    public final String getPSDCMSPLATFORMNODEID() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMNODEID, "");
    }

    public final void setPSDCMSPLATFORMNODEID(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMNODEID, strValue);
    }

    public final boolean isPSDCMSPLATFORMNODENAMENull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMNODENAME);
    }

    public final String getPSDCMSPLATFORMNODENAME() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMNODENAME, "");
    }

    public final void setPSDCMSPLATFORMNODENAME(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMNODENAME, strValue);
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

    public final boolean isPSMSPLATFORMNODEIDNull() {
        return this.IsParamNull(TAG_PSMSPLATFORMNODEID);
    }

    public final String getPSMSPLATFORMNODEID() {
        return this.GetParamStringValue(TAG_PSMSPLATFORMNODEID, "");
    }

    public final void setPSMSPLATFORMNODEID(String strValue) {
        this.SetParamValue(TAG_PSMSPLATFORMNODEID, strValue);
    }

    public final boolean isPSMSPLATFORMNODENAMENull() {
        return this.IsParamNull(TAG_PSMSPLATFORMNODENAME);
    }

    public final String getPSMSPLATFORMNODENAME() {
        return this.GetParamStringValue(TAG_PSMSPLATFORMNODENAME, "");
    }

    public final void setPSMSPLATFORMNODENAME(String strValue) {
        this.SetParamValue(TAG_PSMSPLATFORMNODENAME, strValue);
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

    public final boolean isIPADDR2Null() {
        return this.IsParamNull(TAG_IPADDR2);
    }

    public final String getIPADDR2() {
        return this.GetParamStringValue(TAG_IPADDR2, "");
    }

    public final void setIPADDR2(String strValue) {
        this.SetParamValue(TAG_IPADDR2, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPORTNull() {
        return this.IsParamNull(TAG_PORT);
    }

    public final int getPORT() {
        return this.GetParamIntValue(TAG_PORT, 0);
    }

    public final void setPORT(int nValue) {
        this.SetParamValue(TAG_PORT, nValue);
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

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
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

    public final boolean isPSDCREGISTRYITEMIDNull() {
        return this.IsParamNull(TAG_PSDCREGISTRYITEMID);
    }

    public final String getPSDCREGISTRYITEMID() {
        return this.GetParamStringValue(TAG_PSDCREGISTRYITEMID, "");
    }

    public final void setPSDCREGISTRYITEMID(String strValue) {
        this.SetParamValue(TAG_PSDCREGISTRYITEMID, strValue);
    }

    public final boolean isPSDCREGISTRYITEMNAMENull() {
        return this.IsParamNull(TAG_PSDCREGISTRYITEMNAME);
    }

    public final String getPSDCREGISTRYITEMNAME() {
        return this.GetParamStringValue(TAG_PSDCREGISTRYITEMNAME, "");
    }

    public final void setPSDCREGISTRYITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDCREGISTRYITEMNAME, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }
}

