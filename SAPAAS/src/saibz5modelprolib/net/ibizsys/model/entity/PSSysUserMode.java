/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSSysUserMode
extends BaseDataEntity {
    public static final String TAG_PSSYSUSERMODEID = "PSSYSUSERMODEID";
    public static final String TAG_PSSYSUSERMODENAME = "PSSYSUSERMODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSSYSUSERMODEIDNull() {
        return this.isParamNull(TAG_PSSYSUSERMODEID);
    }

    public final String getPSSYSUSERMODEID() {
        return this.getParamStringValue(TAG_PSSYSUSERMODEID, "");
    }

    public final void setPSSYSUSERMODEID(String strValue) {
        this.setParamValue(TAG_PSSYSUSERMODEID, strValue);
    }

    public final boolean isPSSYSUSERMODENAMENull() {
        return this.isParamNull(TAG_PSSYSUSERMODENAME);
    }

    public final String getPSSYSUSERMODENAME() {
        return this.getParamStringValue(TAG_PSSYSUSERMODENAME, "");
    }

    public final void setPSSYSUSERMODENAME(String strValue) {
        this.setParamValue(TAG_PSSYSUSERMODENAME, strValue);
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
}

