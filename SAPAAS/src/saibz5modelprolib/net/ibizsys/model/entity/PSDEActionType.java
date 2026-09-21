/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEActionType
extends BaseDataEntity {
    public static final String TAG_PSDEACTIONTYPEID = "PSDEACTIONTYPEID";
    public static final String TAG_PSDEACTIONTYPENAME = "PSDEACTIONTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PROCESSOBJ = "PROCESSOBJ";
    public static final String TAG_TYPEPARAM = "TYPEPARAM";

    public final boolean isPSDEACTIONTYPEIDNull() {
        return this.isParamNull(TAG_PSDEACTIONTYPEID);
    }

    public final String getPSDEACTIONTYPEID() {
        return this.getParamStringValue(TAG_PSDEACTIONTYPEID, "");
    }

    public final void setPSDEACTIONTYPEID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONTYPEID, strValue);
    }

    public final boolean isPSDEACTIONTYPENAMENull() {
        return this.isParamNull(TAG_PSDEACTIONTYPENAME);
    }

    public final String getPSDEACTIONTYPENAME() {
        return this.getParamStringValue(TAG_PSDEACTIONTYPENAME, "");
    }

    public final void setPSDEACTIONTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONTYPENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPROCESSOBJNull() {
        return this.isParamNull(TAG_PROCESSOBJ);
    }

    public final String getPROCESSOBJ() {
        return this.getParamStringValue(TAG_PROCESSOBJ, "");
    }

    public final void setPROCESSOBJ(String strValue) {
        this.setParamValue(TAG_PROCESSOBJ, strValue);
    }

    public final boolean isTYPEPARAMNull() {
        return this.isParamNull(TAG_TYPEPARAM);
    }

    public final String getTYPEPARAM() {
        return this.getParamStringValue(TAG_TYPEPARAM, "");
    }

    public final void setTYPEPARAM(String strValue) {
        this.setParamValue(TAG_TYPEPARAM, strValue);
    }
}

