/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEGEIUDetail
extends BaseDataEntity {
    public static final String TAG_PSDEGEIUDETAILID = "PSDEGEIUDETAILID";
    public static final String TAG_PSDEGEIUDETAILNAME = "PSDEGEIUDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEGEIUPDATEID = "PSDEGEIUPDATEID";
    public static final String TAG_PSDEGEIUPDATENAME = "PSDEGEIUPDATENAME";
    public static final String TAG_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String TAG_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";

    public final boolean isPSDEGEIUDETAILIDNull() {
        return this.isParamNull(TAG_PSDEGEIUDETAILID);
    }

    public final String getPSDEGEIUDETAILID() {
        return this.getParamStringValue(TAG_PSDEGEIUDETAILID, "");
    }

    public final void setPSDEGEIUDETAILID(String strValue) {
        this.setParamValue(TAG_PSDEGEIUDETAILID, strValue);
    }

    public final boolean isPSDEGEIUDETAILNAMENull() {
        return this.isParamNull(TAG_PSDEGEIUDETAILNAME);
    }

    public final String getPSDEGEIUDETAILNAME() {
        return this.getParamStringValue(TAG_PSDEGEIUDETAILNAME, "");
    }

    public final void setPSDEGEIUDETAILNAME(String strValue) {
        this.setParamValue(TAG_PSDEGEIUDETAILNAME, strValue);
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

    public final boolean isPSDEGEIUPDATEIDNull() {
        return this.isParamNull(TAG_PSDEGEIUPDATEID);
    }

    public final String getPSDEGEIUPDATEID() {
        return this.getParamStringValue(TAG_PSDEGEIUPDATEID, "");
    }

    public final void setPSDEGEIUPDATEID(String strValue) {
        this.setParamValue(TAG_PSDEGEIUPDATEID, strValue);
    }

    public final boolean isPSDEGEIUPDATENAMENull() {
        return this.isParamNull(TAG_PSDEGEIUPDATENAME);
    }

    public final String getPSDEGEIUPDATENAME() {
        return this.getParamStringValue(TAG_PSDEGEIUPDATENAME, "");
    }

    public final void setPSDEGEIUPDATENAME(String strValue) {
        this.setParamValue(TAG_PSDEGEIUPDATENAME, strValue);
    }

    public final boolean isPSDEGRIDCOLIDNull() {
        return this.isParamNull(TAG_PSDEGRIDCOLID);
    }

    public final String getPSDEGRIDCOLID() {
        return this.getParamStringValue(TAG_PSDEGRIDCOLID, "");
    }

    public final void setPSDEGRIDCOLID(String strValue) {
        this.setParamValue(TAG_PSDEGRIDCOLID, strValue);
    }

    public final boolean isPSDEGRIDCOLNAMENull() {
        return this.isParamNull(TAG_PSDEGRIDCOLNAME);
    }

    public final String getPSDEGRIDCOLNAME() {
        return this.getParamStringValue(TAG_PSDEGRIDCOLNAME, "");
    }

    public final void setPSDEGRIDCOLNAME(String strValue) {
        this.setParamValue(TAG_PSDEGRIDCOLNAME, strValue);
    }

    public final boolean isPSDEGRIDIDNull() {
        return this.isParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.getParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.setParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.isParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.getParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.setParamValue(TAG_PSDEGRIDNAME, strValue);
    }
}

