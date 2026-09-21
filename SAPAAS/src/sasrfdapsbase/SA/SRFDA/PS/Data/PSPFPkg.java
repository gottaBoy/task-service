/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFPkg
extends BaseDataEntity {
    public static final String OSLIC_BSD = "BSD";
    public static final String OSLIC_APACHE = "APACHE";
    public static final String OSLIC_GPL = "GPL";
    public static final String OSLIC_GPL2 = "GPL2";
    public static final String OSLIC_GPL3 = "GPL3";
    public static final String OSLIC_LGPL = "LGPL";
    public static final String OSLIC_MIT = "MIT";
    public static final String TAG_PSPFPKGID = "PSPFPKGID";
    public static final String TAG_PSPFPKGNAME = "PSPFPKGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFPKGCATID = "PSPFPKGCATID";
    public static final String TAG_PSPFPKGCATNAME = "PSPFPKGCATNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PKGTAG = "PKGTAG";
    public static final String TAG_PKGTAG2 = "PKGTAG2";
    public static final String TAG_OSLIC = "OSLIC";

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

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isPSPFPKGCATIDNull() {
        return this.IsParamNull(TAG_PSPFPKGCATID);
    }

    public final String getPSPFPKGCATID() {
        return this.GetParamStringValue(TAG_PSPFPKGCATID, "");
    }

    public final void setPSPFPKGCATID(String strValue) {
        this.SetParamValue(TAG_PSPFPKGCATID, strValue);
    }

    public final boolean isPSPFPKGCATNAMENull() {
        return this.IsParamNull(TAG_PSPFPKGCATNAME);
    }

    public final String getPSPFPKGCATNAME() {
        return this.GetParamStringValue(TAG_PSPFPKGCATNAME, "");
    }

    public final void setPSPFPKGCATNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPKGCATNAME, strValue);
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
}

