/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDERType
extends BaseDataEntity {
    public static final String TAG_PSDERTYPEID = "PSDERTYPEID";
    public static final String TAG_PSDERTYPENAME = "PSDERTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEROBJ = "DEROBJ";

    public final boolean isPSDERTYPEIDNull() {
        return this.isParamNull(TAG_PSDERTYPEID);
    }

    public final String getPSDERTYPEID() {
        return this.getParamStringValue(TAG_PSDERTYPEID, "");
    }

    public final void setPSDERTYPEID(String strValue) {
        this.setParamValue(TAG_PSDERTYPEID, strValue);
    }

    public final boolean isPSDERTYPENAMENull() {
        return this.isParamNull(TAG_PSDERTYPENAME);
    }

    public final String getPSDERTYPENAME() {
        return this.getParamStringValue(TAG_PSDERTYPENAME, "");
    }

    public final void setPSDERTYPENAME(String strValue) {
        this.setParamValue(TAG_PSDERTYPENAME, strValue);
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

    public final boolean isDEROBJNull() {
        return this.isParamNull(TAG_DEROBJ);
    }

    public final String getDEROBJ() {
        return this.getParamStringValue(TAG_DEROBJ, "");
    }

    public final void setDEROBJ(String strValue) {
        this.setParamValue(TAG_DEROBJ, strValue);
    }
}

