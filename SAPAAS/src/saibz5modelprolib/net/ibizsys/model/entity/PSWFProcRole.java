/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFProcRole
extends BaseDataEntity {
    public static final String ROLETYPE_WFROLE = "WFROLE";
    public static final String ROLETYPE_LASTTWOSTEPACTOR = "LASTTWOSTEPACTOR";
    public static final String ROLETYPE_LASTTHREESTEPACTOR = "LASTTHREESTEPACTOR";
    public static final String ROLETYPE_LASTSTEPACTOR = "LASTSTEPACTOR";
    public static final String ROLETYPE_UDACTOR = "UDACTOR";
    public static final String ROLETYPE_CURACTOR = "CURACTOR";
    public static final String TAG_PSWFPROCROLEID = "PSWFPROCROLEID";
    public static final String TAG_PSWFPROCROLENAME = "PSWFPROCROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_PSWFROLEID = "PSWFROLEID";
    public static final String TAG_PSWFROLENAME = "PSWFROLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_ROLETYPE = "ROLETYPE";
    public static final String TAG_UDFIELDS = "UDFIELDS";

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

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
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

    public final boolean isPSWFPROCESSNAMENull() {
        return this.isParamNull(TAG_PSWFPROCESSNAME);
    }

    public final String getPSWFPROCESSNAME() {
        return this.getParamStringValue(TAG_PSWFPROCESSNAME, "");
    }

    public final void setPSWFPROCESSNAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCESSNAME, strValue);
    }

    public final boolean isPSWFROLEIDNull() {
        return this.isParamNull(TAG_PSWFROLEID);
    }

    public final String getPSWFROLEID() {
        return this.getParamStringValue(TAG_PSWFROLEID, "");
    }

    public final void setPSWFROLEID(String strValue) {
        this.setParamValue(TAG_PSWFROLEID, strValue);
    }

    public final boolean isPSWFROLENAMENull() {
        return this.isParamNull(TAG_PSWFROLENAME);
    }

    public final String getPSWFROLENAME() {
        return this.getParamStringValue(TAG_PSWFROLENAME, "");
    }

    public final void setPSWFROLENAME(String strValue) {
        this.setParamValue(TAG_PSWFROLENAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isROLETYPENull() {
        return this.isParamNull(TAG_ROLETYPE);
    }

    public final String getROLETYPE() {
        return this.getParamStringValue(TAG_ROLETYPE, "");
    }

    public final void setROLETYPE(String strValue) {
        this.setParamValue(TAG_ROLETYPE, strValue);
    }

    public final boolean isUDFIELDSNull() {
        return this.isParamNull(TAG_UDFIELDS);
    }

    public final String getUDFIELDS() {
        return this.getParamStringValue(TAG_UDFIELDS, "");
    }

    public final void setUDFIELDS(String strValue) {
        this.setParamValue(TAG_UDFIELDS, strValue);
    }
}

