/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFPkgVer
extends BaseDataEntity {
    public static final String TAG_PSPFPKGVERID = "PSPFPKGVERID";
    public static final String TAG_PSPFPKGVERNAME = "PSPFPKGVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFPKGID = "PSPFPKGID";
    public static final String TAG_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String TAG_PKGPARAM = "PKGPARAM";
    public static final String TAG_PKGPARAM2 = "PKGPARAM2";
    public static final String TAG_PKGPARAM3 = "PKGPARAM3";
    public static final String TAG_PKGPARAM4 = "PKGPARAM4";
    public static final String TAG_PSDCID = "PSDCID";
    public static final String TAG_PSDCNAME = "PSDCNAME";
    public static final String TAG_MEMO = "MEMO";

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

    public final boolean isPSDCIDNull() {
        return this.IsParamNull(TAG_PSDCID);
    }

    public final String getPSDCID() {
        return this.GetParamStringValue(TAG_PSDCID, "");
    }

    public final void setPSDCID(String strValue) {
        this.SetParamValue(TAG_PSDCID, strValue);
    }

    public final boolean isPSDCNAMENull() {
        return this.IsParamNull(TAG_PSDCNAME);
    }

    public final String getPSDCNAME() {
        return this.GetParamStringValue(TAG_PSDCNAME, "");
    }

    public final void setPSDCNAME(String strValue) {
        this.SetParamValue(TAG_PSDCNAME, strValue);
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
}

