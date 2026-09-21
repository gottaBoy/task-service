/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSFormType
extends BaseDataEntity {
    public static final String TAG_PSFORMTYPEID = "PSFORMTYPEID";
    public static final String TAG_PSFORMTYPENAME = "PSFORMTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_FORMOBJ = "FORMOBJ";

    public final boolean isPSFORMTYPEIDNull() {
        return this.isParamNull(TAG_PSFORMTYPEID);
    }

    public final String getPSFORMTYPEID() {
        return this.getParamStringValue(TAG_PSFORMTYPEID, "");
    }

    public final void setPSFORMTYPEID(String strValue) {
        this.setParamValue(TAG_PSFORMTYPEID, strValue);
    }

    public final boolean isPSFORMTYPENAMENull() {
        return this.isParamNull(TAG_PSFORMTYPENAME);
    }

    public final String getPSFORMTYPENAME() {
        return this.getParamStringValue(TAG_PSFORMTYPENAME, "");
    }

    public final void setPSFORMTYPENAME(String strValue) {
        this.setParamValue(TAG_PSFORMTYPENAME, strValue);
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

    public final boolean isFORMOBJNull() {
        return this.isParamNull(TAG_FORMOBJ);
    }

    public final String getFORMOBJ() {
        return this.getParamStringValue(TAG_FORMOBJ, "");
    }

    public final void setFORMOBJ(String strValue) {
        this.setParamValue(TAG_FORMOBJ, strValue);
    }
}

