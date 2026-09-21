/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppPkg
extends BaseDataEntity {
    public static final String TAG_PSAPPPKGID = "PSAPPPKGID";
    public static final String TAG_PSAPPPKGNAME = "PSAPPPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSPFPKGID = "PSPFPKGID";
    public static final String TAG_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String TAG_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String TAG_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PKGPARAM = "PKGPARAM";
    public static final String TAG_PKGPARAM2 = "PKGPARAM2";
    public static final String TAG_PKGPARAM3 = "PKGPARAM3";
    public static final String TAG_PKGPARAM4 = "PKGPARAM4";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERCAT = "USERCAT";

    public final boolean isPSAPPPKGIDNull() {
        return this.IsParamNull(TAG_PSAPPPKGID);
    }

    public final String getPSAPPPKGID() {
        return this.GetParamStringValue(TAG_PSAPPPKGID, "");
    }

    public final void setPSAPPPKGID(String strValue) {
        this.SetParamValue(TAG_PSAPPPKGID, strValue);
    }

    public final boolean isPSAPPPKGNAMENull() {
        return this.IsParamNull(TAG_PSAPPPKGNAME);
    }

    public final String getPSAPPPKGNAME() {
        return this.GetParamStringValue(TAG_PSAPPPKGNAME, "");
    }

    public final void setPSAPPPKGNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPPKGNAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSPFPKGIDNull() {
        return this.IsParamNull(TAG_PSPFPKGID);
    }

    public final String getPSPFPKGID() {
        return this.GetParamStringValue(TAG_PSPFPKGID, "");
    }

    public final void setPSPFPKGID(String strValue) {
        this.SetParamValue(TAG_PSPFPKGID, strValue);
    }

    public final boolean isPSPFPKGNAMENull() {
        return this.IsParamNull(TAG_PSPFPKGNAME);
    }

    public final String getPSPFPKGNAME() {
        return this.GetParamStringValue(TAG_PSPFPKGNAME, "");
    }

    public final void setPSPFPKGNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPKGNAME, strValue);
    }

    public final boolean isPSPFPKGVERIDNull() {
        return this.IsParamNull(TAG_PSPFPKGVERID);
    }

    public final String getPSPFPKGVERID() {
        return this.GetParamStringValue(TAG_PSPFPKGVERID, "");
    }

    public final void setPSPFPKGVERID(String strValue) {
        this.SetParamValue(TAG_PSPFPKGVERID, strValue);
    }

    public final boolean isPSPFPKGVERNAMENull() {
        return this.IsParamNull(TAG_PSPFPKGVERNAME);
    }

    public final String getPSPFPKGVERNAME() {
        return this.GetParamStringValue(TAG_PSPFPKGVERNAME, "");
    }

    public final void setPSPFPKGVERNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPKGVERNAME, strValue);
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

    public final boolean isPKGPARAMNull() {
        return this.IsParamNull(TAG_PKGPARAM);
    }

    public final String getPKGPARAM() {
        return this.GetParamStringValue(TAG_PKGPARAM, "");
    }

    public final void setPKGPARAM(String strValue) {
        this.SetParamValue(TAG_PKGPARAM, strValue);
    }

    public final boolean isPKGPARAM2Null() {
        return this.IsParamNull(TAG_PKGPARAM2);
    }

    public final String getPKGPARAM2() {
        return this.GetParamStringValue(TAG_PKGPARAM2, "");
    }

    public final void setPKGPARAM2(String strValue) {
        this.SetParamValue(TAG_PKGPARAM2, strValue);
    }

    public final boolean isPKGPARAM3Null() {
        return this.IsParamNull(TAG_PKGPARAM3);
    }

    public final String getPKGPARAM3() {
        return this.GetParamStringValue(TAG_PKGPARAM3, "");
    }

    public final void setPKGPARAM3(String strValue) {
        this.SetParamValue(TAG_PKGPARAM3, strValue);
    }

    public final boolean isPKGPARAM4Null() {
        return this.IsParamNull(TAG_PKGPARAM4);
    }

    public final String getPKGPARAM4() {
        return this.GetParamStringValue(TAG_PKGPARAM4, "");
    }

    public final void setPKGPARAM4(String strValue) {
        this.SetParamValue(TAG_PKGPARAM4, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
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

    public final boolean isUSERCATNull() {
        return this.IsParamNull(TAG_USERCAT);
    }

    public final String getUSERCAT() {
        return this.GetParamStringValue(TAG_USERCAT, "");
    }

    public final void setUSERCAT(String strValue) {
        this.SetParamValue(TAG_USERCAT, strValue);
    }
}

