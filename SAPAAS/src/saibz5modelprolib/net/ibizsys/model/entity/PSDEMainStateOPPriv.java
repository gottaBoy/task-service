/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEMainStateOPPriv
extends BaseDataEntity {
    public static final String TAG_PSDEMSOPPRIVID = "PSDEMSOPPRIVID";
    public static final String TAG_PSDEMSOPPRIVNAME = "PSDEMSOPPRIVNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEMSOPPRIVIDNull() {
        return this.isParamNull(TAG_PSDEMSOPPRIVID);
    }

    public final String getPSDEMSOPPRIVID() {
        return this.getParamStringValue(TAG_PSDEMSOPPRIVID, "");
    }

    public final void setPSDEMSOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSDEMSOPPRIVID, strValue);
    }

    public final boolean isPSDEMSOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSDEMSOPPRIVNAME);
    }

    public final String getPSDEMSOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSDEMSOPPRIVNAME, "");
    }

    public final void setPSDEMSOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSDEMSOPPRIVNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.isParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.getParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.setParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.isParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.getParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.setParamValue(TAG_PSDEMAINSTATENAME, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.isParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.getParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.isParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.getParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.setParamValue(TAG_PSDEOPPRIVNAME, strValue);
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

