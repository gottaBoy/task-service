/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEACModeItem
extends BaseDataEntity {
    public static final String TAG_PSDEACMODEITEMID = "PSDEACMODEITEMID";
    public static final String TAG_PSDEACMODEITEMNAME = "PSDEACMODEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEACMODEID = "PSDEACMODEID";
    public static final String TAG_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CLCONVERTFLAG = "CLCONVERTFLAG";
    public static final String TAG_PSCODELISTID = "PSCODELISTID";
    public static final String TAG_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String TAG_VALUEFORMAT = "VALUEFORMAT";

    public final boolean isPSDEACMODEITEMIDNull() {
        return this.isParamNull(TAG_PSDEACMODEITEMID);
    }

    public final String getPSDEACMODEITEMID() {
        return this.getParamStringValue(TAG_PSDEACMODEITEMID, "");
    }

    public final void setPSDEACMODEITEMID(String strValue) {
        this.setParamValue(TAG_PSDEACMODEITEMID, strValue);
    }

    public final boolean isPSDEACMODEITEMNAMENull() {
        return this.isParamNull(TAG_PSDEACMODEITEMNAME);
    }

    public final String getPSDEACMODEITEMNAME() {
        return this.getParamStringValue(TAG_PSDEACMODEITEMNAME, "");
    }

    public final void setPSDEACMODEITEMNAME(String strValue) {
        this.setParamValue(TAG_PSDEACMODEITEMNAME, strValue);
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

    public final boolean isPSDEACMODEIDNull() {
        return this.isParamNull(TAG_PSDEACMODEID);
    }

    public final String getPSDEACMODEID() {
        return this.getParamStringValue(TAG_PSDEACMODEID, "");
    }

    public final void setPSDEACMODEID(String strValue) {
        this.setParamValue(TAG_PSDEACMODEID, strValue);
    }

    public final boolean isPSDEACMODENAMENull() {
        return this.isParamNull(TAG_PSDEACMODENAME);
    }

    public final String getPSDEACMODENAME() {
        return this.getParamStringValue(TAG_PSDEACMODENAME, "");
    }

    public final void setPSDEACMODENAME(String strValue) {
        this.setParamValue(TAG_PSDEACMODENAME, strValue);
    }

    public final boolean isPSDEFIDNull() {
        return this.isParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.getParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.setParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.isParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.getParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.setParamValue(TAG_PSDEFNAME, strValue);
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

    public final boolean isCLCONVERTFLAGNull() {
        return this.isParamNull(TAG_CLCONVERTFLAG);
    }

    public final boolean getCLCONVERTFLAG() {
        return this.getParamIntValue(TAG_CLCONVERTFLAG, 0) == 1;
    }

    public final void setCLCONVERTFLAG(boolean bValue) {
        this.setParamValue(TAG_CLCONVERTFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSCODELISTIDNull() {
        return this.isParamNull(TAG_PSCODELISTID);
    }

    public final String getPSCODELISTID() {
        return this.getParamStringValue(TAG_PSCODELISTID, "");
    }

    public final void setPSCODELISTID(String strValue) {
        this.setParamValue(TAG_PSCODELISTID, strValue);
    }

    public final boolean isPSCODELISTNAMENull() {
        return this.isParamNull(TAG_PSCODELISTNAME);
    }

    public final String getPSCODELISTNAME() {
        return this.getParamStringValue(TAG_PSCODELISTNAME, "");
    }

    public final void setPSCODELISTNAME(String strValue) {
        this.setParamValue(TAG_PSCODELISTNAME, strValue);
    }

    public final boolean isVALUEFORMATNull() {
        return this.isParamNull(TAG_VALUEFORMAT);
    }

    public final String getVALUEFORMAT() {
        return this.getParamStringValue(TAG_VALUEFORMAT, "");
    }

    public final void setVALUEFORMAT(String strValue) {
        this.setParamValue(TAG_VALUEFORMAT, strValue);
    }
}

