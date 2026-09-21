/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysValueRule
extends BaseDataEntity {
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String TAG_PSSYSVALUERULEID = "PSSYSVALUERULEID";
    public static final String TAG_PSSYSVALUERULENAME = "PSSYSVALUERULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSVALUERULEID = "PSVALUERULEID";
    public static final String TAG_PSVALUERULENAME = "PSVALUERULENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_RULETYPE = "RULETYPE";
    public static final String TAG_SCRIPT = "SCRIPT";
    public static final String TAG_REGEXPCODE = "REGEXPCODE";
    public static final String TAG_CUSTOMOBJ = "CUSTOMOBJ";
    public static final String TAG_CUSTOMPARAMS = "CUSTOMPARAMS";

    public final boolean isPSSYSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSSYSVALUERULEID);
    }

    public final String getPSSYSVALUERULEID() {
        return this.getParamStringValue(TAG_PSSYSVALUERULEID, "");
    }

    public final void setPSSYSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULEID, strValue);
    }

    public final boolean isPSSYSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSSYSVALUERULENAME);
    }

    public final String getPSSYSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSSYSVALUERULENAME, "");
    }

    public final void setPSSYSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSSYSVALUERULENAME, strValue);
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

    public final boolean isPSVALUERULEIDNull() {
        return this.isParamNull(TAG_PSVALUERULEID);
    }

    public final String getPSVALUERULEID() {
        return this.getParamStringValue(TAG_PSVALUERULEID, "");
    }

    public final void setPSVALUERULEID(String strValue) {
        this.setParamValue(TAG_PSVALUERULEID, strValue);
    }

    public final boolean isPSVALUERULENAMENull() {
        return this.isParamNull(TAG_PSVALUERULENAME);
    }

    public final String getPSVALUERULENAME() {
        return this.getParamStringValue(TAG_PSVALUERULENAME, "");
    }

    public final void setPSVALUERULENAME(String strValue) {
        this.setParamValue(TAG_PSVALUERULENAME, strValue);
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

    public final boolean isRULEINFONull() {
        return this.isParamNull(TAG_RULEINFO);
    }

    public final String getRULEINFO() {
        return this.getParamStringValue(TAG_RULEINFO, "");
    }

    public final void setRULEINFO(String strValue) {
        this.setParamValue(TAG_RULEINFO, strValue);
    }

    public final boolean isRULETYPENull() {
        return this.isParamNull(TAG_RULETYPE);
    }

    public final String getRULETYPE() {
        return this.getParamStringValue(TAG_RULETYPE, "");
    }

    public final void setRULETYPE(String strValue) {
        this.setParamValue(TAG_RULETYPE, strValue);
    }

    public final boolean isSCRIPTNull() {
        return this.isParamNull("SCRIPT");
    }

    public final String getSCRIPT() {
        return this.getParamStringValue("SCRIPT", "");
    }

    public final void setSCRIPT(String strValue) {
        this.setParamValue("SCRIPT", strValue);
    }

    public final boolean isREGEXPCODENull() {
        return this.isParamNull(TAG_REGEXPCODE);
    }

    public final String getREGEXPCODE() {
        return this.getParamStringValue(TAG_REGEXPCODE, "");
    }

    public final void setREGEXPCODE(String strValue) {
        this.setParamValue(TAG_REGEXPCODE, strValue);
    }

    public final boolean isCUSTOMOBJNull() {
        return this.isParamNull(TAG_CUSTOMOBJ);
    }

    public final String getCUSTOMOBJ() {
        return this.getParamStringValue(TAG_CUSTOMOBJ, "");
    }

    public final void setCUSTOMOBJ(String strValue) {
        this.setParamValue(TAG_CUSTOMOBJ, strValue);
    }

    public final boolean isCUSTOMPARAMSNull() {
        return this.isParamNull(TAG_CUSTOMPARAMS);
    }

    public final String getCUSTOMPARAMS() {
        return this.getParamStringValue(TAG_CUSTOMPARAMS, "");
    }

    public final void setCUSTOMPARAMS(String strValue) {
        this.setParamValue(TAG_CUSTOMPARAMS, strValue);
    }
}

