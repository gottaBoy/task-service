/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysPDTView
extends BaseDataEntity {
    public static final String TAG_PSSYSPDTVIEWID = "PSSYSPDTVIEWID";
    public static final String TAG_PSSYSPDTVIEWNAME = "PSSYSPDTVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSPDTVIEWID = "PSPDTVIEWID";
    public static final String TAG_PSPDTVIEWNAME = "PSPDTVIEWNAME";

    public final boolean isPSSYSPDTVIEWIDNull() {
        return this.isParamNull(TAG_PSSYSPDTVIEWID);
    }

    public final String getPSSYSPDTVIEWID() {
        return this.getParamStringValue(TAG_PSSYSPDTVIEWID, "");
    }

    public final void setPSSYSPDTVIEWID(String strValue) {
        this.setParamValue(TAG_PSSYSPDTVIEWID, strValue);
    }

    public final boolean isPSSYSPDTVIEWNAMENull() {
        return this.isParamNull(TAG_PSSYSPDTVIEWNAME);
    }

    public final String getPSSYSPDTVIEWNAME() {
        return this.getParamStringValue(TAG_PSSYSPDTVIEWNAME, "");
    }

    public final void setPSSYSPDTVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPDTVIEWNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
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

    public final boolean isPSPDTVIEWIDNull() {
        return this.isParamNull(TAG_PSPDTVIEWID);
    }

    public final String getPSPDTVIEWID() {
        return this.getParamStringValue(TAG_PSPDTVIEWID, "");
    }

    public final void setPSPDTVIEWID(String strValue) {
        this.setParamValue(TAG_PSPDTVIEWID, strValue);
    }

    public final boolean isPSPDTVIEWNAMENull() {
        return this.isParamNull(TAG_PSPDTVIEWNAME);
    }

    public final String getPSPDTVIEWNAME() {
        return this.getParamStringValue(TAG_PSPDTVIEWNAME, "");
    }

    public final void setPSPDTVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSPDTVIEWNAME, strValue);
    }
}

