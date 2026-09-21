/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSMSPlatformFunc
extends BaseDataEntity {
    public static final String MSFUNCTYPE_SERVICECENTER = "SERVICECENTER";
    public static final String MSFUNCTYPE_SERVICEGATEWAY = "SERVICEGATEWAY";
    public static final String MSFUNCTYPE_MESSAGEBUS = "MESSAGEBUS";
    public static final String MSFUNCTYPE_LOGCENTER = "LOGCENTER";
    public static final String TAG_PSMSPLATFORMFUNCID = "PSMSPLATFORMFUNCID";
    public static final String TAG_PSMSPLATFORMFUNCNAME = "PSMSPLATFORMFUNCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSMSPLATFORMID = "PSMSPLATFORMID";
    public static final String TAG_PSMSPLATFORMNAME = "PSMSPLATFORMNAME";
    public static final String TAG_MSFUNCTYPE = "MSFUNCTYPE";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_FUNCPARAM = "FUNCPARAM";
    public static final String TAG_FUNCPARAM2 = "FUNCPARAM2";
    public static final String TAG_FUNCPARAM3 = "FUNCPARAM3";
    public static final String TAG_FUNCPARAM4 = "FUNCPARAM4";
    public static final String TAG_FUNCPARAM5 = "FUNCPARAM5";
    public static final String TAG_FUNCPARAM6 = "FUNCPARAM6";
    public static final String TAG_FUNCPARAM7 = "FUNCPARAM7";
    public static final String TAG_FUNCPARAM8 = "FUNCPARAM8";
    public static final String TAG_WORKSHOPPATH = "WORKSHOPPATH";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_SERVICEURL = "SERVICEURL";

    public final boolean isPSMSPLATFORMFUNCIDNull() {
        return this.IsParamNull(TAG_PSMSPLATFORMFUNCID);
    }

    public final String getPSMSPLATFORMFUNCID() {
        return this.GetParamStringValue(TAG_PSMSPLATFORMFUNCID, "");
    }

    public final void setPSMSPLATFORMFUNCID(String strValue) {
        this.SetParamValue(TAG_PSMSPLATFORMFUNCID, strValue);
    }

    public final boolean isPSMSPLATFORMFUNCNAMENull() {
        return this.IsParamNull(TAG_PSMSPLATFORMFUNCNAME);
    }

    public final String getPSMSPLATFORMFUNCNAME() {
        return this.GetParamStringValue(TAG_PSMSPLATFORMFUNCNAME, "");
    }

    public final void setPSMSPLATFORMFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSMSPLATFORMFUNCNAME, strValue);
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

    public final boolean isMSFUNCTYPENull() {
        return this.IsParamNull(TAG_MSFUNCTYPE);
    }

    public final String getMSFUNCTYPE() {
        return this.GetParamStringValue(TAG_MSFUNCTYPE, "");
    }

    public final void setMSFUNCTYPE(String strValue) {
        this.SetParamValue(TAG_MSFUNCTYPE, strValue);
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

    public final boolean isFUNCPARAMNull() {
        return this.IsParamNull(TAG_FUNCPARAM);
    }

    public final String getFUNCPARAM() {
        return this.GetParamStringValue(TAG_FUNCPARAM, "");
    }

    public final void setFUNCPARAM(String strValue) {
        this.SetParamValue(TAG_FUNCPARAM, strValue);
    }

    public final boolean isFUNCPARAM2Null() {
        return this.IsParamNull(TAG_FUNCPARAM2);
    }

    public final String getFUNCPARAM2() {
        return this.GetParamStringValue(TAG_FUNCPARAM2, "");
    }

    public final void setFUNCPARAM2(String strValue) {
        this.SetParamValue(TAG_FUNCPARAM2, strValue);
    }

    public final boolean isFUNCPARAM3Null() {
        return this.IsParamNull(TAG_FUNCPARAM3);
    }

    public final String getFUNCPARAM3() {
        return this.GetParamStringValue(TAG_FUNCPARAM3, "");
    }

    public final void setFUNCPARAM3(String strValue) {
        this.SetParamValue(TAG_FUNCPARAM3, strValue);
    }

    public final boolean isFUNCPARAM4Null() {
        return this.IsParamNull(TAG_FUNCPARAM4);
    }

    public final String getFUNCPARAM4() {
        return this.GetParamStringValue(TAG_FUNCPARAM4, "");
    }

    public final void setFUNCPARAM4(String strValue) {
        this.SetParamValue(TAG_FUNCPARAM4, strValue);
    }

    public final boolean isFUNCPARAM5Null() {
        return this.IsParamNull(TAG_FUNCPARAM5);
    }

    public final boolean getFUNCPARAM5() {
        return this.GetParamIntValue(TAG_FUNCPARAM5, 0) == 1;
    }

    public final void setFUNCPARAM5(boolean bValue) {
        this.SetParamValue(TAG_FUNCPARAM5, bValue ? 1 : 0);
    }

    public final boolean isFUNCPARAM6Null() {
        return this.IsParamNull(TAG_FUNCPARAM6);
    }

    public final boolean getFUNCPARAM6() {
        return this.GetParamIntValue(TAG_FUNCPARAM6, 0) == 1;
    }

    public final void setFUNCPARAM6(boolean bValue) {
        this.SetParamValue(TAG_FUNCPARAM6, bValue ? 1 : 0);
    }

    public final boolean isFUNCPARAM7Null() {
        return this.IsParamNull(TAG_FUNCPARAM7);
    }

    public final int getFUNCPARAM7() {
        return this.GetParamIntValue(TAG_FUNCPARAM7, 0);
    }

    public final void setFUNCPARAM7(int nValue) {
        this.SetParamValue(TAG_FUNCPARAM7, nValue);
    }

    public final boolean isFUNCPARAM8Null() {
        return this.IsParamNull(TAG_FUNCPARAM8);
    }

    public final int getFUNCPARAM8() {
        return this.GetParamIntValue(TAG_FUNCPARAM8, 0);
    }

    public final void setFUNCPARAM8(int nValue) {
        this.SetParamValue(TAG_FUNCPARAM8, nValue);
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

