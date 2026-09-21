/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCWorkshopServer
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
    public static final String TAG_PSDCWORKSHOPSERVERID = "PSDCWORKSHOPSERVERID";
    public static final String TAG_PSDCWORKSHOPSERVERNAME = "PSDCWORKSHOPSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSWORKSHOPSERVERID = "PSWORKSHOPSERVERID";
    public static final String TAG_PSWORKSHOPSERVERNAME = "PSWORKSHOPSERVERNAME";
    public static final String TAG_REFCOUNT = "REFCOUNT";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
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
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_WORKSHOPPATH = "WORKSHOPPATH";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_GITPATH = "GITPATH";
    public static final String TAG_GITUSERNAME = "GITUSERNAME";
    public static final String TAG_GITPASSWORD = "GITPASSWORD";

    public final boolean isPSDCWORKSHOPSERVERIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSHOPSERVERID);
    }

    public final String getPSDCWORKSHOPSERVERID() {
        return this.GetParamStringValue(TAG_PSDCWORKSHOPSERVERID, "");
    }

    public final void setPSDCWORKSHOPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSHOPSERVERID, strValue);
    }

    public final boolean isPSDCWORKSHOPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSHOPSERVERNAME);
    }

    public final String getPSDCWORKSHOPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSHOPSERVERNAME, "");
    }

    public final void setPSDCWORKSHOPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSHOPSERVERNAME, strValue);
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

    public final boolean isREFCOUNTNull() {
        return this.IsParamNull(TAG_REFCOUNT);
    }

    public final int getREFCOUNT() {
        return this.GetParamIntValue(TAG_REFCOUNT, 0);
    }

    public final void setREFCOUNT(int nValue) {
        this.SetParamValue(TAG_REFCOUNT, nValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isWORKSHOPPATHNull() {
        return this.IsParamNull(TAG_WORKSHOPPATH);
    }

    public final String getWORKSHOPPATH() {
        return this.GetParamStringValue(TAG_WORKSHOPPATH, "");
    }

    public final void setWORKSHOPPATH(String strValue) {
        this.SetParamValue(TAG_WORKSHOPPATH, strValue);
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

    public final boolean isGITPATHNull() {
        return this.IsParamNull(TAG_GITPATH);
    }

    public final String getGITPATH() {
        return this.GetParamStringValue(TAG_GITPATH, "");
    }

    public final void setGITPATH(String strValue) {
        this.SetParamValue(TAG_GITPATH, strValue);
    }

    public final boolean isGITUSERNAMENull() {
        return this.IsParamNull(TAG_GITUSERNAME);
    }

    public final String getGITUSERNAME() {
        return this.GetParamStringValue(TAG_GITUSERNAME, "");
    }

    public final void setGITUSERNAME(String strValue) {
        this.SetParamValue(TAG_GITUSERNAME, strValue);
    }

    public final boolean isGITPASSWORDNull() {
        return this.IsParamNull(TAG_GITPASSWORD);
    }

    public final String getGITPASSWORD() {
        return this.GetParamStringValue(TAG_GITPASSWORD, "");
    }

    public final void setGITPASSWORD(String strValue) {
        this.SetParamValue(TAG_GITPASSWORD, strValue);
    }
}

