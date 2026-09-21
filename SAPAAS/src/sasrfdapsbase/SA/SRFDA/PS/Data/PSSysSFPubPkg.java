/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSFPubPkg
extends BaseDataEntity {
    public static final String TAG_PSSYSSFPUBPKGID = "PSSYSSFPUBPKGID";
    public static final String TAG_PSSYSSFPUBPKGNAME = "PSSYSSFPUBPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_PSSFPKGID = "PSSFPKGID";
    public static final String TAG_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String TAG_PSSFPKGVERID = "PSSFPKGVERID";
    public static final String TAG_PSSFPKGVERNAME = "PSSFPKGVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PKGPARAM = "PKGPARAM";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PKGPARAM2 = "PKGPARAM2";
    public static final String TAG_PKGPARAM3 = "PKGPARAM3";
    public static final String TAG_PKGPARAM4 = "PKGPARAM4";

    public final boolean isPSSYSSFPUBPKGIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBPKGID);
    }

    public final String getPSSYSSFPUBPKGID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBPKGID, "");
    }

    public final void setPSSYSSFPUBPKGID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBPKGID, strValue);
    }

    public final boolean isPSSYSSFPUBPKGNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBPKGNAME);
    }

    public final String getPSSYSSFPUBPKGNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBPKGNAME, "");
    }

    public final void setPSSYSSFPUBPKGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBPKGNAME, strValue);
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

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isPSSFPKGIDNull() {
        return this.IsParamNull(TAG_PSSFPKGID);
    }

    public final String getPSSFPKGID() {
        return this.GetParamStringValue(TAG_PSSFPKGID, "");
    }

    public final void setPSSFPKGID(String strValue) {
        this.SetParamValue(TAG_PSSFPKGID, strValue);
    }

    public final boolean isPSSFPKGNAMENull() {
        return this.IsParamNull(TAG_PSSFPKGNAME);
    }

    public final String getPSSFPKGNAME() {
        return this.GetParamStringValue(TAG_PSSFPKGNAME, "");
    }

    public final void setPSSFPKGNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPKGNAME, strValue);
    }

    public final boolean isPSSFPKGVERIDNull() {
        return this.IsParamNull(TAG_PSSFPKGVERID);
    }

    public final String getPSSFPKGVERID() {
        return this.GetParamStringValue(TAG_PSSFPKGVERID, "");
    }

    public final void setPSSFPKGVERID(String strValue) {
        this.SetParamValue(TAG_PSSFPKGVERID, strValue);
    }

    public final boolean isPSSFPKGVERNAMENull() {
        return this.IsParamNull(TAG_PSSFPKGVERNAME);
    }

    public final String getPSSFPKGVERNAME() {
        return this.GetParamStringValue(TAG_PSSFPKGVERNAME, "");
    }

    public final void setPSSFPKGVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPKGVERNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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
}

