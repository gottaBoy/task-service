/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEGridColumnType
extends BaseDataEntity {
    public static final String TAG_PSDEGCTYPEID = "PSDEGCTYPEID";
    public static final String TAG_PSDEGCTYPENAME = "PSDEGCTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_COLUMNOBJ = "COLUMNOBJ";
    public static final String TAG_TREECOLUMNOBJ = "TREECOLUMNOBJ";

    public final boolean isPSDEGCTYPEIDNull() {
        return this.isParamNull(TAG_PSDEGCTYPEID);
    }

    public final String getPSDEGCTYPEID() {
        return this.getParamStringValue(TAG_PSDEGCTYPEID, "");
    }

    public final void setPSDEGCTYPEID(String strValue) {
        this.setParamValue(TAG_PSDEGCTYPEID, strValue);
    }

    public final boolean isPSDEGCTYPENAMENull() {
        return this.isParamNull(TAG_PSDEGCTYPENAME);
    }

    public final String getPSDEGCTYPENAME() {
        return this.getParamStringValue(TAG_PSDEGCTYPENAME, "");
    }

    public final void setPSDEGCTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDEGCTYPENAME, strValue);
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

    public final boolean isCOLUMNOBJNull() {
        return this.isParamNull(TAG_COLUMNOBJ);
    }

    public final String getCOLUMNOBJ() {
        return this.getParamStringValue(TAG_COLUMNOBJ, "");
    }

    public final void setCOLUMNOBJ(String strValue) {
        this.setParamValue(TAG_COLUMNOBJ, strValue);
    }

    public final boolean isTREECOLUMNOBJNull() {
        return this.isParamNull(TAG_TREECOLUMNOBJ);
    }

    public final String getTREECOLUMNOBJ() {
        return this.getParamStringValue(TAG_TREECOLUMNOBJ, "");
    }

    public final void setTREECOLUMNOBJ(String strValue) {
        this.setParamValue(TAG_TREECOLUMNOBJ, strValue);
    }
}

