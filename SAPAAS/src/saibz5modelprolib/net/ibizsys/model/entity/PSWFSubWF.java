/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSWFSubWF
extends BaseDataEntity {
    public static final String TAG_PSWFSUBWFID = "PSWFSUBWFID";
    public static final String TAG_PSWFSUBWFNAME = "PSWFSUBWFNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_PSWFNAME = "PSWFNAME";
    public static final String TAG_SUBPSWFID = "SUBPSWFID";
    public static final String TAG_SUBPSWFNAME = "SUBPSWFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_SUBPSWFVERID = "SUBPSWFVERID";
    public static final String TAG_SUBPSWFVERNAME = "SUBPSWFVERNAME";

    public final boolean isPSWFSUBWFIDNull() {
        return this.isParamNull(TAG_PSWFSUBWFID);
    }

    public final String getPSWFSUBWFID() {
        return this.getParamStringValue(TAG_PSWFSUBWFID, "");
    }

    public final void setPSWFSUBWFID(String strValue) {
        this.setParamValue(TAG_PSWFSUBWFID, strValue);
    }

    public final boolean isPSWFSUBWFNAMENull() {
        return this.isParamNull(TAG_PSWFSUBWFNAME);
    }

    public final String getPSWFSUBWFNAME() {
        return this.getParamStringValue(TAG_PSWFSUBWFNAME, "");
    }

    public final void setPSWFSUBWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFSUBWFNAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.isParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.getParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.setParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isPSWFNAMENull() {
        return this.isParamNull(TAG_PSWFNAME);
    }

    public final String getPSWFNAME() {
        return this.getParamStringValue(TAG_PSWFNAME, "");
    }

    public final void setPSWFNAME(String strValue) {
        this.setParamValue(TAG_PSWFNAME, strValue);
    }

    public final boolean isSUBPSWFIDNull() {
        return this.isParamNull(TAG_SUBPSWFID);
    }

    public final String getSUBPSWFID() {
        return this.getParamStringValue(TAG_SUBPSWFID, "");
    }

    public final void setSUBPSWFID(String strValue) {
        this.setParamValue(TAG_SUBPSWFID, strValue);
    }

    public final boolean isSUBPSWFNAMENull() {
        return this.isParamNull(TAG_SUBPSWFNAME);
    }

    public final String getSUBPSWFNAME() {
        return this.getParamStringValue(TAG_SUBPSWFNAME, "");
    }

    public final void setSUBPSWFNAME(String strValue) {
        this.setParamValue(TAG_SUBPSWFNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isSUBPSWFVERIDNull() {
        return this.isParamNull(TAG_SUBPSWFVERID);
    }

    public final String getSUBPSWFVERID() {
        return this.getParamStringValue(TAG_SUBPSWFVERID, "");
    }

    public final void setSUBPSWFVERID(String strValue) {
        this.setParamValue(TAG_SUBPSWFVERID, strValue);
    }

    public final boolean isSUBPSWFVERNAMENull() {
        return this.isParamNull(TAG_SUBPSWFVERNAME);
    }

    public final String getSUBPSWFVERNAME() {
        return this.getParamStringValue(TAG_SUBPSWFVERNAME, "");
    }

    public final void setSUBPSWFVERNAME(String strValue) {
        this.setParamValue(TAG_SUBPSWFVERNAME, strValue);
    }
}

