/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPortletType
extends BaseDataEntity {
    public static final String TAG_PSPORTLETTYPEID = "PSPORTLETTYPEID";
    public static final String TAG_PSPORTLETTYPENAME = "PSPORTLETTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PORTLETOBJ = "PORTLETOBJ";
    public static final String TAG_SYSPORTLETOBJ = "SYSPORTLETOBJ";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String TAG_JITMODELOBJ = "JITMODELOBJ";
    public static final String TAG_SYSPORTLETFLAG = "SYSPORTLETFLAG";

    public final boolean isPSPORTLETTYPEIDNull() {
        return this.isParamNull(TAG_PSPORTLETTYPEID);
    }

    public final String getPSPORTLETTYPEID() {
        return this.getParamStringValue(TAG_PSPORTLETTYPEID, "");
    }

    public final void setPSPORTLETTYPEID(String strValue) {
        this.setParamValue(TAG_PSPORTLETTYPEID, strValue);
    }

    public final boolean isPSPORTLETTYPENAMENull() {
        return this.isParamNull(TAG_PSPORTLETTYPENAME);
    }

    public final String getPSPORTLETTYPENAME() {
        return this.getParamStringValue(TAG_PSPORTLETTYPENAME, "");
    }

    public final void setPSPORTLETTYPENAME(String strValue) {
        this.setParamValue(TAG_PSPORTLETTYPENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.isParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.getParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.setParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPORTLETOBJNull() {
        return this.isParamNull(TAG_PORTLETOBJ);
    }

    public final String getPORTLETOBJ() {
        return this.getParamStringValue(TAG_PORTLETOBJ, "");
    }

    public final void setPORTLETOBJ(String strValue) {
        this.setParamValue(TAG_PORTLETOBJ, strValue);
    }

    public final boolean isSYSPORTLETOBJNull() {
        return this.isParamNull(TAG_SYSPORTLETOBJ);
    }

    public final String getSYSPORTLETOBJ() {
        return this.getParamStringValue(TAG_SYSPORTLETOBJ, "");
    }

    public final void setSYSPORTLETOBJ(String strValue) {
        this.setParamValue(TAG_SYSPORTLETOBJ, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.isParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.getParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.setParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isJITCTRLOBJNull() {
        return this.isParamNull(TAG_JITCTRLOBJ);
    }

    public final String getJITCTRLOBJ() {
        return this.getParamStringValue(TAG_JITCTRLOBJ, "");
    }

    public final void setJITCTRLOBJ(String strValue) {
        this.setParamValue(TAG_JITCTRLOBJ, strValue);
    }

    public final boolean isJITMODELOBJNull() {
        return this.isParamNull(TAG_JITMODELOBJ);
    }

    public final String getJITMODELOBJ() {
        return this.getParamStringValue(TAG_JITMODELOBJ, "");
    }

    public final void setJITMODELOBJ(String strValue) {
        this.setParamValue(TAG_JITMODELOBJ, strValue);
    }

    public final boolean isSYSPORTLETFLAGNull() {
        return this.isParamNull(TAG_SYSPORTLETFLAG);
    }

    public final boolean getSYSPORTLETFLAG() {
        return this.getParamIntValue(TAG_SYSPORTLETFLAG, 0) == 1;
    }

    public final void setSYSPORTLETFLAG(boolean bValue) {
        this.setParamValue(TAG_SYSPORTLETFLAG, bValue ? 1 : 0);
    }
}

