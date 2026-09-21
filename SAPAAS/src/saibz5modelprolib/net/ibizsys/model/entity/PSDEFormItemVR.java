/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEFormItemVR
extends BaseDataEntity {
    public static final int CHECKMODE_FRONT = 1;
    public static final int CHECKMODE_BACKEND = 2;
    public static final int CHECKMODE_ALL = 3;
    public static final String TAG_PSDEFIVRID = "PSDEFIVRID";
    public static final String TAG_PSDEFIVRNAME = "PSDEFIVRNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFIID = "PSDEFIID";
    public static final String TAG_PSDEFINAME = "PSDEFINAME";
    public static final String TAG_PSDEFVRID = "PSDEFVRID";
    public static final String TAG_PSDEFVRNAME = "PSDEFVRNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CHECKMODE = "CHECKMODE";

    public final boolean isPSDEFIVRIDNull() {
        return this.isParamNull(TAG_PSDEFIVRID);
    }

    public final String getPSDEFIVRID() {
        return this.getParamStringValue(TAG_PSDEFIVRID, "");
    }

    public final void setPSDEFIVRID(String strValue) {
        this.setParamValue(TAG_PSDEFIVRID, strValue);
    }

    public final boolean isPSDEFIVRNAMENull() {
        return this.isParamNull(TAG_PSDEFIVRNAME);
    }

    public final String getPSDEFIVRNAME() {
        return this.getParamStringValue(TAG_PSDEFIVRNAME, "");
    }

    public final void setPSDEFIVRNAME(String strValue) {
        this.setParamValue(TAG_PSDEFIVRNAME, strValue);
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

    public final boolean isPSDEFIIDNull() {
        return this.isParamNull(TAG_PSDEFIID);
    }

    public final String getPSDEFIID() {
        return this.getParamStringValue(TAG_PSDEFIID, "");
    }

    public final void setPSDEFIID(String strValue) {
        this.setParamValue(TAG_PSDEFIID, strValue);
    }

    public final boolean isPSDEFINAMENull() {
        return this.isParamNull(TAG_PSDEFINAME);
    }

    public final String getPSDEFINAME() {
        return this.getParamStringValue(TAG_PSDEFINAME, "");
    }

    public final void setPSDEFINAME(String strValue) {
        this.setParamValue(TAG_PSDEFINAME, strValue);
    }

    public final boolean isPSDEFVRIDNull() {
        return this.isParamNull(TAG_PSDEFVRID);
    }

    public final String getPSDEFVRID() {
        return this.getParamStringValue(TAG_PSDEFVRID, "");
    }

    public final void setPSDEFVRID(String strValue) {
        this.setParamValue(TAG_PSDEFVRID, strValue);
    }

    public final boolean isPSDEFVRNAMENull() {
        return this.isParamNull(TAG_PSDEFVRNAME);
    }

    public final String getPSDEFVRNAME() {
        return this.getParamStringValue(TAG_PSDEFVRNAME, "");
    }

    public final void setPSDEFVRNAME(String strValue) {
        this.setParamValue(TAG_PSDEFVRNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.isParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.getParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.setParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.isParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.getParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMNAME, strValue);
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

    public final boolean isCHECKMODENull() {
        return this.isParamNull(TAG_CHECKMODE);
    }

    public final int getCHECKMODE() {
        return this.getParamIntValue(TAG_CHECKMODE, 0);
    }

    public final void setCHECKMODE(int nValue) {
        this.setParamValue(TAG_CHECKMODE, nValue);
    }
}

