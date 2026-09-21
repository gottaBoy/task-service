/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFProcSubWF
extends BaseDataEntity {
    public static final String TAG_PSWFPROCSUBWFID = "PSWFPROCSUBWFID";
    public static final String TAG_PSWFPROCSUBWFNAME = "PSWFPROCSUBWFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFPROCESSID = "PSWFPROCESSID";
    public static final String TAG_PSWFPROCESSNAME = "PSWFPROCESSNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_EMBEDPSWFID = "EMBEDPSWFID";
    public static final String TAG_EMBEDPSWFNAME = "EMBEDPSWFNAME";
    public static final String TAG_EMBEDPSWFDEID = "EMBEDPSWFDEID";
    public static final String TAG_EMBEDPSWFDENAME = "EMBEDPSWFDENAME";
    public static final String TAG_EMBEDPSDEDSID = "EMBEDPSDEDSID";
    public static final String TAG_EMBEDPSDEDSNAME = "EMBEDPSDEDSNAME";
    public static final String TAG_EMBEDPSDEID = "EMBEDPSDEID";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_SUSPENDDEFAULT = "SUSPENDDEFAULT";
    public static final String TAG_EMBEDPSWFVERID = "EMBEDPSWFVERID";
    public static final String TAG_EMBEDPSWFVERNAME = "EMBEDPSWFVERNAME";

    public final boolean isPSWFPROCSUBWFIDNull() {
        return this.isParamNull(TAG_PSWFPROCSUBWFID);
    }

    public final String getPSWFPROCSUBWFID() {
        return this.getParamStringValue(TAG_PSWFPROCSUBWFID, "");
    }

    public final void setPSWFPROCSUBWFID(String strValue) {
        this.setParamValue(TAG_PSWFPROCSUBWFID, strValue);
    }

    public final boolean isPSWFPROCSUBWFNAMENull() {
        return this.isParamNull(TAG_PSWFPROCSUBWFNAME);
    }

    public final String getPSWFPROCSUBWFNAME() {
        return this.getParamStringValue(TAG_PSWFPROCSUBWFNAME, "");
    }

    public final void setPSWFPROCSUBWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFPROCSUBWFNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
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

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isEMBEDPSWFIDNull() {
        return this.isParamNull(TAG_EMBEDPSWFID);
    }

    public final String getEMBEDPSWFID() {
        return this.getParamStringValue(TAG_EMBEDPSWFID, "");
    }

    public final void setEMBEDPSWFID(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFID, strValue);
    }

    public final boolean isEMBEDPSWFNAMENull() {
        return this.isParamNull(TAG_EMBEDPSWFNAME);
    }

    public final String getEMBEDPSWFNAME() {
        return this.getParamStringValue(TAG_EMBEDPSWFNAME, "");
    }

    public final void setEMBEDPSWFNAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFNAME, strValue);
    }

    public final boolean isEMBEDPSWFDEIDNull() {
        return this.isParamNull(TAG_EMBEDPSWFDEID);
    }

    public final String getEMBEDPSWFDEID() {
        return this.getParamStringValue(TAG_EMBEDPSWFDEID, "");
    }

    public final void setEMBEDPSWFDEID(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFDEID, strValue);
    }

    public final boolean isEMBEDPSWFDENAMENull() {
        return this.isParamNull(TAG_EMBEDPSWFDENAME);
    }

    public final String getEMBEDPSWFDENAME() {
        return this.getParamStringValue(TAG_EMBEDPSWFDENAME, "");
    }

    public final void setEMBEDPSWFDENAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFDENAME, strValue);
    }

    public final boolean isEMBEDPSDEDSIDNull() {
        return this.isParamNull(TAG_EMBEDPSDEDSID);
    }

    public final String getEMBEDPSDEDSID() {
        return this.getParamStringValue(TAG_EMBEDPSDEDSID, "");
    }

    public final void setEMBEDPSDEDSID(String strValue) {
        this.setParamValue(TAG_EMBEDPSDEDSID, strValue);
    }

    public final boolean isEMBEDPSDEDSNAMENull() {
        return this.isParamNull(TAG_EMBEDPSDEDSNAME);
    }

    public final String getEMBEDPSDEDSNAME() {
        return this.getParamStringValue(TAG_EMBEDPSDEDSNAME, "");
    }

    public final void setEMBEDPSDEDSNAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSDEDSNAME, strValue);
    }

    public final boolean isEMBEDPSDEIDNull() {
        return this.isParamNull(TAG_EMBEDPSDEID);
    }

    public final String getEMBEDPSDEID() {
        return this.getParamStringValue(TAG_EMBEDPSDEID, "");
    }

    public final void setEMBEDPSDEID(String strValue) {
        this.setParamValue(TAG_EMBEDPSDEID, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isSUSPENDDEFAULTNull() {
        return this.isParamNull(TAG_SUSPENDDEFAULT);
    }

    public final boolean getSUSPENDDEFAULT() {
        return this.getParamIntValue(TAG_SUSPENDDEFAULT, 0) == 1;
    }

    public final void setSUSPENDDEFAULT(boolean bValue) {
        this.setParamValue(TAG_SUSPENDDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isEMBEDPSWFVERIDNull() {
        return this.isParamNull(TAG_EMBEDPSWFVERID);
    }

    public final String getEMBEDPSWFVERID() {
        return this.getParamStringValue(TAG_EMBEDPSWFVERID, "");
    }

    public final void setEMBEDPSWFVERID(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFVERID, strValue);
    }

    public final boolean isEMBEDPSWFVERNAMENull() {
        return this.isParamNull(TAG_EMBEDPSWFVERNAME);
    }

    public final String getEMBEDPSWFVERNAME() {
        return this.getParamStringValue(TAG_EMBEDPSWFVERNAME, "");
    }

    public final void setEMBEDPSWFVERNAME(String strValue) {
        this.setParamValue(TAG_EMBEDPSWFVERNAME, strValue);
    }
}

