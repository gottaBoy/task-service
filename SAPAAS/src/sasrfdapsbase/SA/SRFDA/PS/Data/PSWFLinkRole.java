/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSWFLinkRole
extends BaseDataEntity {
    public static final String TAG_PSWFLINKROLEID = "PSWFLINKROLEID";
    public static final String TAG_PSWFLINKROLENAME = "PSWFLINKROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFLINKID = "PSWFLINKID";
    public static final String TAG_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String TAG_PSWFPROCROLEID = "PSWFPROCROLEID";
    public static final String TAG_PSWFPROCROLENAME = "PSWFPROCROLENAME";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";

    public final boolean isPSWFLINKROLEIDNull() {
        return this.IsParamNull(TAG_PSWFLINKROLEID);
    }

    public final String getPSWFLINKROLEID() {
        return this.GetParamStringValue(TAG_PSWFLINKROLEID, "");
    }

    public final void setPSWFLINKROLEID(String strValue) {
        this.SetParamValue(TAG_PSWFLINKROLEID, strValue);
    }

    public final boolean isPSWFLINKROLENAMENull() {
        return this.IsParamNull(TAG_PSWFLINKROLENAME);
    }

    public final String getPSWFLINKROLENAME() {
        return this.GetParamStringValue(TAG_PSWFLINKROLENAME, "");
    }

    public final void setPSWFLINKROLENAME(String strValue) {
        this.SetParamValue(TAG_PSWFLINKROLENAME, strValue);
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

    public final boolean isPSWFLINKIDNull() {
        return this.IsParamNull(TAG_PSWFLINKID);
    }

    public final String getPSWFLINKID() {
        return this.GetParamStringValue(TAG_PSWFLINKID, "");
    }

    public final void setPSWFLINKID(String strValue) {
        this.SetParamValue(TAG_PSWFLINKID, strValue);
    }

    public final boolean isPSWFLINKNAMENull() {
        return this.IsParamNull(TAG_PSWFLINKNAME);
    }

    public final String getPSWFLINKNAME() {
        return this.GetParamStringValue(TAG_PSWFLINKNAME, "");
    }

    public final void setPSWFLINKNAME(String strValue) {
        this.SetParamValue(TAG_PSWFLINKNAME, strValue);
    }

    public final boolean isPSWFPROCROLEIDNull() {
        return this.IsParamNull(TAG_PSWFPROCROLEID);
    }

    public final String getPSWFPROCROLEID() {
        return this.GetParamStringValue(TAG_PSWFPROCROLEID, "");
    }

    public final void setPSWFPROCROLEID(String strValue) {
        this.SetParamValue(TAG_PSWFPROCROLEID, strValue);
    }

    public final boolean isPSWFPROCROLENAMENull() {
        return this.IsParamNull(TAG_PSWFPROCROLENAME);
    }

    public final String getPSWFPROCROLENAME() {
        return this.GetParamStringValue(TAG_PSWFPROCROLENAME, "");
    }

    public final void setPSWFPROCROLENAME(String strValue) {
        this.SetParamValue(TAG_PSWFPROCROLENAME, strValue);
    }

    public final boolean isPSWFPROCESSIDNull() {
        return this.IsParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.GetParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.SetParamValue(TAG_PSWFPROCESSID, strValue);
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

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }
}

