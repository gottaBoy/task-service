/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDELogicParam
extends BaseDataEntity {
    public static final int PARAMTYPE_COMMON = 0;
    public static final int PARAMTYPE_GLOBAL = 1;
    public static final int PARAMTYPE_ENV = 2;
    public static final String TAG_PSDELOGICPARAMID = "PSDELOGICPARAMID";
    public static final String TAG_PSDELOGICPARAMNAME = "PSDELOGICPARAMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDELOGICID = "PSDELOGICID";
    public static final String TAG_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAMPSDEID = "PARAMPSDEID";
    public static final String TAG_PARAMPSDENAME = "PARAMPSDENAME";
    public static final String TAG_DEFAULTPARAM = "DEFAULTPARAM";
    public static final String TAG_GLOBALPARAM = "GLOBALPARAM";

    public final boolean isPSDELOGICPARAMIDNull() {
        return this.isParamNull(TAG_PSDELOGICPARAMID);
    }

    public final String getPSDELOGICPARAMID() {
        return this.getParamStringValue(TAG_PSDELOGICPARAMID, "");
    }

    public final void setPSDELOGICPARAMID(String strValue) {
        this.setParamValue(TAG_PSDELOGICPARAMID, strValue);
    }

    public final boolean isPSDELOGICPARAMNAMENull() {
        return this.isParamNull(TAG_PSDELOGICPARAMNAME);
    }

    public final String getPSDELOGICPARAMNAME() {
        return this.getParamStringValue(TAG_PSDELOGICPARAMNAME, "");
    }

    public final void setPSDELOGICPARAMNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICPARAMNAME, strValue);
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

    public final boolean isPSDELOGICIDNull() {
        return this.isParamNull(TAG_PSDELOGICID);
    }

    public final String getPSDELOGICID() {
        return this.getParamStringValue(TAG_PSDELOGICID, "");
    }

    public final void setPSDELOGICID(String strValue) {
        this.setParamValue(TAG_PSDELOGICID, strValue);
    }

    public final boolean isPSDELOGICNAMENull() {
        return this.isParamNull(TAG_PSDELOGICNAME);
    }

    public final String getPSDELOGICNAME() {
        return this.getParamStringValue(TAG_PSDELOGICNAME, "");
    }

    public final void setPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_PSDELOGICNAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.isParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.getParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.setParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPARAMPSDEIDNull() {
        return this.isParamNull(TAG_PARAMPSDEID);
    }

    public final String getPARAMPSDEID() {
        return this.getParamStringValue(TAG_PARAMPSDEID, "");
    }

    public final void setPARAMPSDEID(String strValue) {
        this.setParamValue(TAG_PARAMPSDEID, strValue);
    }

    public final boolean isPARAMPSDENAMENull() {
        return this.isParamNull(TAG_PARAMPSDENAME);
    }

    public final String getPARAMPSDENAME() {
        return this.getParamStringValue(TAG_PARAMPSDENAME, "");
    }

    public final void setPARAMPSDENAME(String strValue) {
        this.setParamValue(TAG_PARAMPSDENAME, strValue);
    }

    public final boolean isDEFAULTPARAMNull() {
        return this.isParamNull(TAG_DEFAULTPARAM);
    }

    public final boolean getDEFAULTPARAM() {
        return this.getParamIntValue(TAG_DEFAULTPARAM, 0) == 1;
    }

    public final void setDEFAULTPARAM(boolean bValue) {
        this.setParamValue(TAG_DEFAULTPARAM, bValue ? 1 : 0);
    }

    public final boolean isGLOBALPARAMNull() {
        return this.isParamNull(TAG_GLOBALPARAM);
    }

    public final int getGLOBALPARAM() {
        return this.getParamIntValue(TAG_GLOBALPARAM, 0);
    }

    public final void setGLOBALPARAM(int nValue) {
        this.setParamValue(TAG_GLOBALPARAM, nValue);
    }
}

