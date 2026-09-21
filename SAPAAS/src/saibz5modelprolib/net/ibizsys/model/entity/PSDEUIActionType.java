/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEUIActionType
extends BaseDataEntity {
    public static final String TAG_PSDEUIACTIONTYPEID = "PSDEUIACTIONTYPEID";
    public static final String TAG_PSDEUIACTIONTYPENAME = "PSDEUIACTIONTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEUIACTIONTYPEIDNull() {
        return this.isParamNull(TAG_PSDEUIACTIONTYPEID);
    }

    public final String getPSDEUIACTIONTYPEID() {
        return this.getParamStringValue(TAG_PSDEUIACTIONTYPEID, "");
    }

    public final void setPSDEUIACTIONTYPEID(String strValue) {
        this.setParamValue(TAG_PSDEUIACTIONTYPEID, strValue);
    }

    public final boolean isPSDEUIACTIONTYPENAMENull() {
        return this.isParamNull(TAG_PSDEUIACTIONTYPENAME);
    }

    public final String getPSDEUIACTIONTYPENAME() {
        return this.getParamStringValue(TAG_PSDEUIACTIONTYPENAME, "");
    }

    public final void setPSDEUIACTIONTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDEUIACTIONTYPENAME, strValue);
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
}

