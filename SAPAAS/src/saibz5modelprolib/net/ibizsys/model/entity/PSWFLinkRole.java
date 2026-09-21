/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSWFLINKROLEIDNull() {
        return this.isParamNull(TAG_PSWFLINKROLEID);
    }

    public final String getPSWFLINKROLEID() {
        return this.getParamStringValue(TAG_PSWFLINKROLEID, "");
    }

    public final void setPSWFLINKROLEID(String strValue) {
        this.setParamValue(TAG_PSWFLINKROLEID, strValue);
    }

    public final boolean isPSWFLINKROLENAMENull() {
        return this.isParamNull(TAG_PSWFLINKROLENAME);
    }

    public final String getPSWFLINKROLENAME() {
        return this.getParamStringValue(TAG_PSWFLINKROLENAME, "");
    }

    public final void setPSWFLINKROLENAME(String strValue) {
        this.setParamValue(TAG_PSWFLINKROLENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSWFLINKIDNull() {
        return this.isParamNull(TAG_PSWFLINKID);
    }

    public final String getPSWFLINKID() {
        return this.getParamStringValue(TAG_PSWFLINKID, "");
    }

    public final void setPSWFLINKID(String strValue) {
        this.setParamValue(TAG_PSWFLINKID, strValue);
    }

    public final boolean isPSWFLINKNAMENull() {
        return this.isParamNull(TAG_PSWFLINKNAME);
    }

    public final String getPSWFLINKNAME() {
        return this.getParamStringValue(TAG_PSWFLINKNAME, "");
    }

    public final void setPSWFLINKNAME(String strValue) {
        this.setParamValue(TAG_PSWFLINKNAME, strValue);
    }

    public final boolean isPSWFPROCROLEIDNull() {
        return this.isParamNull(TAG_PSWFPROCROLEID);
    }

    public final String getPSWFPROCROLEID() {
        return this.getParamStringValue(TAG_PSWFPROCROLEID, "");
    }

    public final void setPSWFPROCROLEID(String strValue) {
        this.setParamValue(TAG_PSWFPROCROLEID, strValue);
    }

    public final boolean isPSWFPROCROLENAMENull() {
        return this.isParamNull(TAG_PSWFPROCROLENAME);
    }

    public final String getPSWFPROCROLENAME() {
        return this.getParamStringValue(TAG_PSWFPROCROLENAME, "");
    }

    public final void setPSWFPROCROLENAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCROLENAME, strValue);
    }

    public final boolean isPSWFPROCESSIDNull() {
        return this.isParamNull(TAG_PSWFPROCESSID);
    }

    public final String getPSWFPROCESSID() {
        return this.getParamStringValue(TAG_PSWFPROCESSID, "");
    }

    public final void setPSWFPROCESSID(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSID, strValue);
    }
}

