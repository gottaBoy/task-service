/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFPkgVer
extends BaseDataEntity {
    public static final String TAG_PSSFPKGVERID = "PSSFPKGVERID";
    public static final String TAG_PSSFPKGVERNAME = "PSSFPKGVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFPKGID = "PSSFPKGID";
    public static final String TAG_PSSFPKGNAME = "PSSFPKGNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VERPARAM = "VERPARAM";
    public static final String TAG_VERTAG = "VERTAG";
    public static final String TAG_VERTAG2 = "VERTAG2";

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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isVERPARAMNull() {
        return this.IsParamNull(TAG_VERPARAM);
    }

    public final String getVERPARAM() {
        return this.GetParamStringValue(TAG_VERPARAM, "");
    }

    public final void setVERPARAM(String strValue) {
        this.SetParamValue(TAG_VERPARAM, strValue);
    }

    public final boolean isVERTAGNull() {
        return this.IsParamNull(TAG_VERTAG);
    }

    public final String getVERTAG() {
        return this.GetParamStringValue(TAG_VERTAG, "");
    }

    public final void setVERTAG(String strValue) {
        this.SetParamValue(TAG_VERTAG, strValue);
    }

    public final boolean isVERTAG2Null() {
        return this.IsParamNull(TAG_VERTAG2);
    }

    public final String getVERTAG2() {
        return this.GetParamStringValue(TAG_VERTAG2, "");
    }

    public final void setVERTAG2(String strValue) {
        this.SetParamValue(TAG_VERTAG2, strValue);
    }
}

