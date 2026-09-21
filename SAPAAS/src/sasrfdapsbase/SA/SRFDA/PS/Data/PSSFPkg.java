/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFPkg
extends BaseDataEntity {
    public static final String OSLIC_BSD = "BSD";
    public static final String OSLIC_APACHE = "APACHE";
    public static final String OSLIC_GPL = "GPL";
    public static final String OSLIC_GPL2 = "GPL2";
    public static final String OSLIC_GPL3 = "GPL3";
    public static final String OSLIC_LGPL = "LGPL";
    public static final String OSLIC_MIT = "MIT";
    public static final String TAG_PSSFPKGID = "PSSFPKGID";
    public static final String TAG_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSFPKGCATID = "PSSFPKGCATID";
    public static final String TAG_PSSFPKGCATNAME = "PSSFPKGCATNAME";
    public static final String TAG_PKGTAG = "PKGTAG";
    public static final String TAG_PKGTAG2 = "PKGTAG2";
    public static final String TAG_OSLIC = "OSLIC";
    public static final String TAG_PSDCID = "PSDCID";
    public static final String TAG_PSDCNAME = "PSDCNAME";

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

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
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

    public final boolean isPSSFPKGCATIDNull() {
        return this.IsParamNull(TAG_PSSFPKGCATID);
    }

    public final String getPSSFPKGCATID() {
        return this.GetParamStringValue(TAG_PSSFPKGCATID, "");
    }

    public final void setPSSFPKGCATID(String strValue) {
        this.SetParamValue(TAG_PSSFPKGCATID, strValue);
    }

    public final boolean isPSSFPKGCATNAMENull() {
        return this.IsParamNull(TAG_PSSFPKGCATNAME);
    }

    public final String getPSSFPKGCATNAME() {
        return this.GetParamStringValue(TAG_PSSFPKGCATNAME, "");
    }

    public final void setPSSFPKGCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPKGCATNAME, strValue);
    }

    public final boolean isPKGTAGNull() {
        return this.IsParamNull(TAG_PKGTAG);
    }

    public final String getPKGTAG() {
        return this.GetParamStringValue(TAG_PKGTAG, "");
    }

    public final void setPKGTAG(String strValue) {
        this.SetParamValue(TAG_PKGTAG, strValue);
    }

    public final boolean isPKGTAG2Null() {
        return this.IsParamNull(TAG_PKGTAG2);
    }

    public final String getPKGTAG2() {
        return this.GetParamStringValue(TAG_PKGTAG2, "");
    }

    public final void setPKGTAG2(String strValue) {
        this.SetParamValue(TAG_PKGTAG2, strValue);
    }

    public final boolean isOSLICNull() {
        return this.IsParamNull(TAG_OSLIC);
    }

    public final String getOSLIC() {
        return this.GetParamStringValue(TAG_OSLIC, "");
    }

    public final void setOSLIC(String strValue) {
        this.SetParamValue(TAG_OSLIC, strValue);
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
}

