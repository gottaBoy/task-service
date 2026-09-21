/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEFIUDetail
extends BaseDataEntity {
    public static final String TAG_PSDEFIUDETAILID = "PSDEFIUDETAILID";
    public static final String TAG_PSDEFIUDETAILNAME = "PSDEFIUDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFIUPDATEID = "PSDEFIUPDATEID";
    public static final String TAG_PSDEFIUPDATENAME = "PSDEFIUPDATENAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String TAG_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";

    public final boolean isPSDEFIUDETAILIDNull() {
        return this.isParamNull(TAG_PSDEFIUDETAILID);
    }

    public final String getPSDEFIUDETAILID() {
        return this.getParamStringValue(TAG_PSDEFIUDETAILID, "");
    }

    public final void setPSDEFIUDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEFIUDETAILID, strValue);
    }

    public final boolean isPSDEFIUDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEFIUDETAILNAME);
    }

    public final String getPSDEFIUDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEFIUDETAILNAME, "");
    }

    public final void setPSDEFIUDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEFIUDETAILNAME, strValue);
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

    public final boolean isPSDEFIUPDATEIDNull() {
        return this.isParamNull(TAG_PSDEFIUPDATEID);
    }

    public final String getPSDEFIUPDATEID() {
        return this.getParamStringValue(TAG_PSDEFIUPDATEID, "");
    }

    public final void setPSDEFIUPDATEID(String strValue) {
        this.setParamValue(TAG_PSDEFIUPDATEID, strValue);
    }

    public final boolean isPSDEFIUPDATENAMENull() {
        return this.isParamNull(TAG_PSDEFIUPDATENAME);
    }

    public final String getPSDEFIUPDATENAME() {
        return this.getParamStringValue(TAG_PSDEFIUPDATENAME, "");
    }

    public final void setPSDEFIUPDATENAME(String strValue) {
        this.setParamValue(TAG_PSDEFIUPDATENAME, strValue);
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

    public final boolean isPSDEFORMDETAILIDNull() {
        return this.isParamNull(TAG_PSDEFORMDETAILID);
    }

    public final String getPSDEFORMDETAILID() {
        return this.getParamStringValue(TAG_PSDEFORMDETAILID, "");
    }

    public final void setPSDEFORMDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEFORMDETAILID, strValue);
    }

    public final boolean isPSDEFORMDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEFORMDETAILNAME);
    }

    public final String getPSDEFORMDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEFORMDETAILNAME, "");
    }

    public final void setPSDEFORMDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMDETAILNAME, strValue);
    }
}

