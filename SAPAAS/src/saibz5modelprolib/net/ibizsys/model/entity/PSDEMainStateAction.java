/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEMainStateAction
extends BaseDataEntity {
    public static final String ALLOWMODE_ALLOW = "ALLOW";
    public static final String ALLOWMODE_DENY = "DENY";
    public static final String TAG_PSDEMSACTIONID = "PSDEMSACTIONID";
    public static final String TAG_PSDEMSACTIONNAME = "PSDEMSACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEMSID = "PSDEMSID";
    public static final String TAG_PSDEMSNAME = "PSDEMSNAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_ALLOWMODE = "ALLOWMODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSDEMSACTIONIDNull() {
        return this.isParamNull(TAG_PSDEMSACTIONID);
    }

    public final String getPSDEMSACTIONID() {
        return this.getParamStringValue(TAG_PSDEMSACTIONID, "");
    }

    public final void setPSDEMSACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEMSACTIONID, strValue);
    }

    public final boolean isPSDEMSACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEMSACTIONNAME);
    }

    public final String getPSDEMSACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEMSACTIONNAME, "");
    }

    public final void setPSDEMSACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEMSACTIONNAME, strValue);
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

    public final boolean isPSDEMSIDNull() {
        return this.isParamNull(TAG_PSDEMSID);
    }

    public final String getPSDEMSID() {
        return this.getParamStringValue(TAG_PSDEMSID, "");
    }

    public final void setPSDEMSID(String strValue) {
        this.setParamValue(TAG_PSDEMSID, strValue);
    }

    public final boolean isPSDEMSNAMENull() {
        return this.isParamNull(TAG_PSDEMSNAME);
    }

    public final String getPSDEMSNAME() {
        return this.getParamStringValue(TAG_PSDEMSNAME, "");
    }

    public final void setPSDEMSNAME(String strValue) {
        this.setParamValue(TAG_PSDEMSNAME, strValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isALLOWMODENull() {
        return this.isParamNull(TAG_ALLOWMODE);
    }

    public final String getALLOWMODE() {
        return this.getParamStringValue(TAG_ALLOWMODE, "");
    }

    public final void setALLOWMODE(String strValue) {
        this.setParamValue(TAG_ALLOWMODE, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

