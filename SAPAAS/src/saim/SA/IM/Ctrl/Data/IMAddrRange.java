/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.IM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IMAddrRange
extends BaseDataEntity {
    public static final String TAG_IMADDRRANGEID = "IMADDRRANGEID";
    public static final String TAG_IMADDRRANGENAME = "IMADDRRANGENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IMDOMAINID = "IMDOMAINID";
    public static final String TAG_IMDOMAINNAME = "IMDOMAINNAME";
    public static final String TAG_STARTADDR = "STARTADDR";
    public static final String TAG_ENDADDR = "ENDADDR";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isIMADDRRANGEIDNull() {
        return this.IsParamNull(TAG_IMADDRRANGEID);
    }

    public final String getIMADDRRANGEID() {
        return this.GetParamStringValue(TAG_IMADDRRANGEID, "");
    }

    public final void setIMADDRRANGEID(String strValue) {
        this.SetParamValue(TAG_IMADDRRANGEID, strValue);
    }

    public final boolean isIMADDRRANGENAMENull() {
        return this.IsParamNull(TAG_IMADDRRANGENAME);
    }

    public final String getIMADDRRANGENAME() {
        return this.GetParamStringValue(TAG_IMADDRRANGENAME, "");
    }

    public final void setIMADDRRANGENAME(String strValue) {
        this.SetParamValue(TAG_IMADDRRANGENAME, strValue);
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

    public final boolean isIMDOMAINIDNull() {
        return this.IsParamNull(TAG_IMDOMAINID);
    }

    public final String getIMDOMAINID() {
        return this.GetParamStringValue(TAG_IMDOMAINID, "");
    }

    public final void setIMDOMAINID(String strValue) {
        this.SetParamValue(TAG_IMDOMAINID, strValue);
    }

    public final boolean isIMDOMAINNAMENull() {
        return this.IsParamNull(TAG_IMDOMAINNAME);
    }

    public final String getIMDOMAINNAME() {
        return this.GetParamStringValue(TAG_IMDOMAINNAME, "");
    }

    public final void setIMDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_IMDOMAINNAME, strValue);
    }

    public final boolean isSTARTADDRNull() {
        return this.IsParamNull(TAG_STARTADDR);
    }

    public final String getSTARTADDR() {
        return this.GetParamStringValue(TAG_STARTADDR, "");
    }

    public final void setSTARTADDR(String strValue) {
        this.SetParamValue(TAG_STARTADDR, strValue);
    }

    public final boolean isENDADDRNull() {
        return this.IsParamNull(TAG_ENDADDR);
    }

    public final String getENDADDR() {
        return this.GetParamStringValue(TAG_ENDADDR, "");
    }

    public final void setENDADDR(String strValue) {
        this.SetParamValue(TAG_ENDADDR, strValue);
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

