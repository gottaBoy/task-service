/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWorkshopServer
extends BaseDataEntity {
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String TAG_PSWORKSHOPSERVERID = "PSWORKSHOPSERVERID";
    public static final String TAG_PSWORKSHOPSERVERNAME = "PSWORKSHOPSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_WEBCONSOLEPATH = "WEBCONSOLEPATH";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String TAG_ADMINPASSWD = "ADMINPASSWD";
    public static final String TAG_LOCALRES = "LOCALRES";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_WORKSHOPPATH = "WORKSHOPPATH";
    public static final String TAG_PSSVNSERVERID = "PSSVNSERVERID";
    public static final String TAG_PSSVNSERVERNAME = "PSSVNSERVERNAME";

    public final boolean isPSWORKSHOPSERVERIDNull() {
        return this.IsParamNull(TAG_PSWORKSHOPSERVERID);
    }

    public final String getPSWORKSHOPSERVERID() {
        return this.GetParamStringValue(TAG_PSWORKSHOPSERVERID, "");
    }

    public final void setPSWORKSHOPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSWORKSHOPSERVERID, strValue);
    }

    public final boolean isPSWORKSHOPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSWORKSHOPSERVERNAME);
    }

    public final String getPSWORKSHOPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSWORKSHOPSERVERNAME, "");
    }

    public final void setPSWORKSHOPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSWORKSHOPSERVERNAME, strValue);
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

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
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

    public final boolean isLOCALRESNull() {
        return this.IsParamNull(TAG_LOCALRES);
    }

    public final boolean getLOCALRES() {
        return this.GetParamIntValue(TAG_LOCALRES, 0) == 1;
    }

    public final void setLOCALRES(boolean bValue) {
        this.SetParamValue(TAG_LOCALRES, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isUPLOADFILEMODENull() {
        return this.IsParamNull(TAG_UPLOADFILEMODE);
    }

    public final String getUPLOADFILEMODE() {
        return this.GetParamStringValue(TAG_UPLOADFILEMODE, "");
    }

    public final void setUPLOADFILEMODE(String strValue) {
        this.SetParamValue(TAG_UPLOADFILEMODE, strValue);
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

    public final boolean isWORKSHOPPATHNull() {
        return this.IsParamNull(TAG_WORKSHOPPATH);
    }

    public final String getWORKSHOPPATH() {
        return this.GetParamStringValue(TAG_WORKSHOPPATH, "");
    }

    public final void setWORKSHOPPATH(String strValue) {
        this.SetParamValue(TAG_WORKSHOPPATH, strValue);
    }

    public final boolean isPSSVNSERVERIDNull() {
        return this.IsParamNull(TAG_PSSVNSERVERID);
    }

    public final String getPSSVNSERVERID() {
        return this.GetParamStringValue(TAG_PSSVNSERVERID, "");
    }

    public final void setPSSVNSERVERID(String strValue) {
        this.SetParamValue(TAG_PSSVNSERVERID, strValue);
    }

    public final boolean isPSSVNSERVERNAMENull() {
        return this.IsParamNull(TAG_PSSVNSERVERNAME);
    }

    public final String getPSSVNSERVERNAME() {
        return this.GetParamStringValue(TAG_PSSVNSERVERNAME, "");
    }

    public final void setPSSVNSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSVNSERVERNAME, strValue);
    }
}

