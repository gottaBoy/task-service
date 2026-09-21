/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSln
extends BaseDataEntity {
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SLNFOLDER = "SLNFOLDER";
    public static final String TAG_SLNSN = "SLNSN";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_ADMINPSDEVUSERID = "ADMINPSDEVUSERID";
    public static final String TAG_ADMINPSDEVUSERNAME = "ADMINPSDEVUSERNAME";
    public static final String TAG_SLNVER = "SLNVER";
    public static final String TAG_SLNTYPE = "SLNTYPE";
    public static final String TAG_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String TAG_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String TAG_PSDCWORKSHOPSERVERID = "PSDCWORKSHOPSERVERID";
    public static final String TAG_PSDCWORKSHOPSERVERNAME = "PSDCWORKSHOPSERVERNAME";
    public static final String TAG_VCUSER = "VCUSER";
    public static final String TAG_VCPASSWORD = "VCPASSWORD";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSDCMAVENREPOID = "PSDCMAVENREPOID";
    public static final String TAG_PSDCMAVENREPONAME = "PSDCMAVENREPONAME";
    public static final String TAG_CALLBACKURL = "CALLBACKURL";
    public static final String TAG_CALLBACKTAG = "CALLBACKTAG";
    public static final String TAG_ENABLECALLBACK = "ENABLECALLBACK";

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSLNFOLDERNull() {
        return this.IsParamNull(TAG_SLNFOLDER);
    }

    public final String getSLNFOLDER() {
        return this.GetParamStringValue(TAG_SLNFOLDER, "");
    }

    public final void setSLNFOLDER(String strValue) {
        this.SetParamValue(TAG_SLNFOLDER, strValue);
    }

    public final boolean isSLNSNNull() {
        return this.IsParamNull(TAG_SLNSN);
    }

    public final String getSLNSN() {
        return this.GetParamStringValue(TAG_SLNSN, "");
    }

    public final void setSLNSN(String strValue) {
        this.SetParamValue(TAG_SLNSN, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isADMINPSDEVUSERIDNull() {
        return this.IsParamNull(TAG_ADMINPSDEVUSERID);
    }

    public final String getADMINPSDEVUSERID() {
        return this.GetParamStringValue(TAG_ADMINPSDEVUSERID, "");
    }

    public final void setADMINPSDEVUSERID(String strValue) {
        this.SetParamValue(TAG_ADMINPSDEVUSERID, strValue);
    }

    public final boolean isADMINPSDEVUSERNAMENull() {
        return this.IsParamNull(TAG_ADMINPSDEVUSERNAME);
    }

    public final String getADMINPSDEVUSERNAME() {
        return this.GetParamStringValue(TAG_ADMINPSDEVUSERNAME, "");
    }

    public final void setADMINPSDEVUSERNAME(String strValue) {
        this.SetParamValue(TAG_ADMINPSDEVUSERNAME, strValue);
    }

    public final boolean isSLNVERNull() {
        return this.IsParamNull(TAG_SLNVER);
    }

    public final int getSLNVER() {
        return this.GetParamIntValue(TAG_SLNVER, 0);
    }

    public final void setSLNVER(int nValue) {
        this.SetParamValue(TAG_SLNVER, nValue);
    }

    public final boolean isSLNTYPENull() {
        return this.IsParamNull(TAG_SLNTYPE);
    }

    public final String getSLNTYPE() {
        return this.GetParamStringValue(TAG_SLNTYPE, "");
    }

    public final void setSLNTYPE(String strValue) {
        this.SetParamValue(TAG_SLNTYPE, strValue);
    }

    public final boolean isPSDCDEPLOYCENTERIDNull() {
        return this.IsParamNull(TAG_PSDCDEPLOYCENTERID);
    }

    public final String getPSDCDEPLOYCENTERID() {
        return this.GetParamStringValue(TAG_PSDCDEPLOYCENTERID, "");
    }

    public final void setPSDCDEPLOYCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDCDEPLOYCENTERID, strValue);
    }

    public final boolean isPSDCDEPLOYCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDCDEPLOYCENTERNAME);
    }

    public final String getPSDCDEPLOYCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDCDEPLOYCENTERNAME, "");
    }

    public final void setPSDCDEPLOYCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCDEPLOYCENTERNAME, strValue);
    }

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

    public final boolean isVCUSERNull() {
        return this.IsParamNull(TAG_VCUSER);
    }

    public final String getVCUSER() {
        return this.GetParamStringValue(TAG_VCUSER, "");
    }

    public final void setVCUSER(String strValue) {
        this.SetParamValue(TAG_VCUSER, strValue);
    }

    public final boolean isVCPASSWORDNull() {
        return this.IsParamNull(TAG_VCPASSWORD);
    }

    public final String getVCPASSWORD() {
        return this.GetParamStringValue(TAG_VCPASSWORD, "");
    }

    public final void setVCPASSWORD(String strValue) {
        this.SetParamValue(TAG_VCPASSWORD, strValue);
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

    public final boolean isPSDCMAVENREPOIDNull() {
        return this.IsParamNull(TAG_PSDCMAVENREPOID);
    }

    public final String getPSDCMAVENREPOID() {
        return this.GetParamStringValue(TAG_PSDCMAVENREPOID, "");
    }

    public final void setPSDCMAVENREPOID(String strValue) {
        this.SetParamValue(TAG_PSDCMAVENREPOID, strValue);
    }

    public final boolean isPSDCMAVENREPONAMENull() {
        return this.IsParamNull(TAG_PSDCMAVENREPONAME);
    }

    public final String getPSDCMAVENREPONAME() {
        return this.GetParamStringValue(TAG_PSDCMAVENREPONAME, "");
    }

    public final void setPSDCMAVENREPONAME(String strValue) {
        this.SetParamValue(TAG_PSDCMAVENREPONAME, strValue);
    }

    public final boolean isENABLECALLBACKNull() {
        return this.IsParamNull(TAG_ENABLECALLBACK);
    }

    public final boolean getENABLECALLBACK() {
        return this.GetParamIntValue(TAG_ENABLECALLBACK, 0) == 1;
    }

    public final void setENABLECALLBACK(boolean bValue) {
        this.SetParamValue(TAG_ENABLECALLBACK, bValue ? 1 : 0);
    }

    public final boolean isCALLBACKURLNull() {
        return this.IsParamNull(TAG_CALLBACKURL);
    }

    public final String getCALLBACKURL() {
        return this.GetParamStringValue(TAG_CALLBACKURL, "");
    }

    public final void setCALLBACKURL(String strValue) {
        this.SetParamValue(TAG_CALLBACKURL, strValue);
    }

    public final boolean isCALLBACKTAGNull() {
        return this.IsParamNull(TAG_CALLBACKTAG);
    }

    public final String getCALLBACKTAG() {
        return this.GetParamStringValue(TAG_CALLBACKTAG, "");
    }

    public final void setCALLBACKTAG(String strValue) {
        this.SetParamValue(TAG_CALLBACKTAG, strValue);
    }
}

