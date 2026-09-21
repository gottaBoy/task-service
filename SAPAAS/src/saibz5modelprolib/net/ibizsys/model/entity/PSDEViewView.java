/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEViewView
extends BaseDataEntity {
    public static final String TAG_PSDEVIEWRVID = "PSDEVIEWRVID";
    public static final String TAG_PSDEVIEWRVNAME = "PSDEVIEWRVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAJORPSDEVIEWID = "MAJORPSDEVIEWID";
    public static final String TAG_MAJORPSDEVIEWNAME = "MAJORPSDEVIEWNAME";
    public static final String TAG_MINORPSDEVIEWID = "MINORPSDEVIEWID";
    public static final String TAG_MINORPSDEVIEWNAME = "MINORPSDEVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEFVIEWTYPE = "DEFVIEWTYPE";
    public static final String TAG_OPENMODE = "OPENMODE";

    public final boolean isPSDEVIEWRVIDNull() {
        return this.isParamNull(TAG_PSDEVIEWRVID);
    }

    public final String getPSDEVIEWRVID() {
        return this.getParamStringValue(TAG_PSDEVIEWRVID, "");
    }

    public final void setPSDEVIEWRVID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWRVID, strValue);
    }

    public final boolean isPSDEVIEWRVNAMENull() {
        return this.isParamNull(TAG_PSDEVIEWRVNAME);
    }

    public final String getPSDEVIEWRVNAME() {
        return this.getParamStringValue(TAG_PSDEVIEWRVNAME, "");
    }

    public final void setPSDEVIEWRVNAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWRVNAME, strValue);
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

    public final boolean isMAJORPSDEVIEWIDNull() {
        return this.isParamNull(TAG_MAJORPSDEVIEWID);
    }

    public final String getMAJORPSDEVIEWID() {
        return this.getParamStringValue(TAG_MAJORPSDEVIEWID, "");
    }

    public final void setMAJORPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_MAJORPSDEVIEWID, strValue);
    }

    public final boolean isMAJORPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_MAJORPSDEVIEWNAME);
    }

    public final String getMAJORPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_MAJORPSDEVIEWNAME, "");
    }

    public final void setMAJORPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_MAJORPSDEVIEWNAME, strValue);
    }

    public final boolean isMINORPSDEVIEWIDNull() {
        return this.isParamNull(TAG_MINORPSDEVIEWID);
    }

    public final String getMINORPSDEVIEWID() {
        return this.getParamStringValue(TAG_MINORPSDEVIEWID, "");
    }

    public final void setMINORPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_MINORPSDEVIEWID, strValue);
    }

    public final boolean isMINORPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_MINORPSDEVIEWNAME);
    }

    public final String getMINORPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_MINORPSDEVIEWNAME, "");
    }

    public final void setMINORPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_MINORPSDEVIEWNAME, strValue);
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

    public final boolean isDEFVIEWTYPENull() {
        return this.isParamNull(TAG_DEFVIEWTYPE);
    }

    public final String getDEFVIEWTYPE() {
        return this.getParamStringValue(TAG_DEFVIEWTYPE, "");
    }

    public final void setDEFVIEWTYPE(String strValue) {
        this.setParamValue(TAG_DEFVIEWTYPE, strValue);
    }

    public final boolean isOPENMODENull() {
        return this.isParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.getParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.setParamValue(TAG_OPENMODE, strValue);
    }
}

