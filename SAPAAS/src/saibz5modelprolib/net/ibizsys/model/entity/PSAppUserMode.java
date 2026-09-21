/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppUserMode
extends BaseDataEntity {
    public static final String TAG_PSAPPUSERMODEID = "PSAPPUSERMODEID";
    public static final String TAG_PSAPPUSERMODENAME = "PSAPPUSERMODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSUSERMODEID = "PSSYSUSERMODEID";
    public static final String TAG_PSSYSUSERMODENAME = "PSSYSUSERMODENAME";
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";

    public final boolean isPSAPPUSERMODEIDNull() {
        return this.isParamNull(TAG_PSAPPUSERMODEID);
    }

    public final String getPSAPPUSERMODEID() {
        return this.getParamStringValue(TAG_PSAPPUSERMODEID, "");
    }

    public final void setPSAPPUSERMODEID(String strValue) {
        this.setParamValue(TAG_PSAPPUSERMODEID, strValue);
    }

    public final boolean isPSAPPUSERMODENAMENull() {
        return this.isParamNull(TAG_PSAPPUSERMODENAME);
    }

    public final String getPSAPPUSERMODENAME() {
        return this.getParamStringValue(TAG_PSAPPUSERMODENAME, "");
    }

    public final void setPSAPPUSERMODENAME(String strValue) {
        this.setParamValue(TAG_PSAPPUSERMODENAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isPSAPPMENUIDNull() {
        return this.isParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.getParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUNAME, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.isParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.getParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.setParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
    }
}

