/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEDataQueryCodeExp
extends BaseDataEntity {
    public static final String TAG_PSDEDQCODEEXPID = "PSDEDQCODEEXPID";
    public static final String TAG_PSDEDQCODEEXPNAME = "PSDEDQCODEEXPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEDQCODEID = "PSDEDQCODEID";
    public static final String TAG_PSDEDQCODENAME = "PSDEDQCODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EXPCODE = "EXPCODE";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";

    public final boolean isPSDEDQCODEEXPIDNull() {
        return this.isParamNull(TAG_PSDEDQCODEEXPID);
    }

    public final String getPSDEDQCODEEXPID() {
        return this.getParamStringValue(TAG_PSDEDQCODEEXPID, "");
    }

    public final void setPSDEDQCODEEXPID(String strValue) {
        this.setParamValue(TAG_PSDEDQCODEEXPID, strValue);
    }

    public final boolean isPSDEDQCODEEXPNAMENull() {
        return this.isParamNull(TAG_PSDEDQCODEEXPNAME);
    }

    public final String getPSDEDQCODEEXPNAME() {
        return this.getParamStringValue(TAG_PSDEDQCODEEXPNAME, "");
    }

    public final void setPSDEDQCODEEXPNAME(String strValue) {
        this.setParamValue(TAG_PSDEDQCODEEXPNAME, strValue);
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

    public final boolean isPSDEDQCODEIDNull() {
        return this.isParamNull(TAG_PSDEDQCODEID);
    }

    public final String getPSDEDQCODEID() {
        return this.getParamStringValue(TAG_PSDEDQCODEID, "");
    }

    public final void setPSDEDQCODEID(String strValue) {
        this.setParamValue(TAG_PSDEDQCODEID, strValue);
    }

    public final boolean isPSDEDQCODENAMENull() {
        return this.isParamNull(TAG_PSDEDQCODENAME);
    }

    public final String getPSDEDQCODENAME() {
        return this.getParamStringValue(TAG_PSDEDQCODENAME, "");
    }

    public final void setPSDEDQCODENAME(String strValue) {
        this.setParamValue(TAG_PSDEDQCODENAME, strValue);
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

    public final boolean isEXPCODENull() {
        return this.isParamNull(TAG_EXPCODE);
    }

    public final String getEXPCODE() {
        return this.getParamStringValue(TAG_EXPCODE, "");
    }

    public final void setEXPCODE(String strValue) {
        this.setParamValue(TAG_EXPCODE, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }
}

