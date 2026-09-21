/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSControlType
extends BaseDataEntity {
    public static final String TAG_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String TAG_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_AJAXCTRL = "AJAXCTRL";
    public static final String TAG_CTRLOBJ = "CTRLOBJ";
    public static final String TAG_CTRLDEID = "CTRLDEID";
    public static final String TAG_CTRLDENAME = "CTRLDENAME";
    public static final String TAG_PARAMOBJ = "PARAMOBJ";
    public static final String TAG_HANDLEROBJ = "HANDLEROBJ";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_JITMODELOBJ = "JITMODELOBJ";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String TAG_JITCTRLOBJ2 = "JITCTRLOBJ2";

    public final boolean isPSCTRLTYPEIDNull() {
        return this.isParamNull(TAG_PSCTRLTYPEID);
    }

    public final String getPSCTRLTYPEID() {
        return this.getParamStringValue(TAG_PSCTRLTYPEID, "");
    }

    public final void setPSCTRLTYPEID(String strValue) {
        this.setParamValue(TAG_PSCTRLTYPEID, strValue);
    }

    public final boolean isPSCTRLTYPENAMENull() {
        return this.isParamNull(TAG_PSCTRLTYPENAME);
    }

    public final String getPSCTRLTYPENAME() {
        return this.getParamStringValue(TAG_PSCTRLTYPENAME, "");
    }

    public final void setPSCTRLTYPENAME(String strValue) {
        this.setParamValue(TAG_PSCTRLTYPENAME, strValue);
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

    public final boolean isAJAXCTRLNull() {
        return this.isParamNull(TAG_AJAXCTRL);
    }

    public final boolean getAJAXCTRL() {
        return this.getParamIntValue(TAG_AJAXCTRL, 0) == 1;
    }

    public final void setAJAXCTRL(boolean bValue) {
        this.setParamValue(TAG_AJAXCTRL, bValue ? 1 : 0);
    }

    public final boolean isCTRLOBJNull() {
        return this.isParamNull(TAG_CTRLOBJ);
    }

    public final String getCTRLOBJ() {
        return this.getParamStringValue(TAG_CTRLOBJ, "");
    }

    public final void setCTRLOBJ(String strValue) {
        this.setParamValue(TAG_CTRLOBJ, strValue);
    }

    public final boolean isCTRLDEIDNull() {
        return this.isParamNull(TAG_CTRLDEID);
    }

    public final String getCTRLDEID() {
        return this.getParamStringValue(TAG_CTRLDEID, "");
    }

    public final void setCTRLDEID(String strValue) {
        this.setParamValue(TAG_CTRLDEID, strValue);
    }

    public final boolean isCTRLDENAMENull() {
        return this.isParamNull(TAG_CTRLDENAME);
    }

    public final String getCTRLDENAME() {
        return this.getParamStringValue(TAG_CTRLDENAME, "");
    }

    public final void setCTRLDENAME(String strValue) {
        this.setParamValue(TAG_CTRLDENAME, strValue);
    }

    public final boolean isPARAMOBJNull() {
        return this.isParamNull(TAG_PARAMOBJ);
    }

    public final String getPARAMOBJ() {
        return this.getParamStringValue(TAG_PARAMOBJ, "");
    }

    public final void setPARAMOBJ(String strValue) {
        this.setParamValue(TAG_PARAMOBJ, strValue);
    }

    public final boolean isHANDLEROBJNull() {
        return this.isParamNull(TAG_HANDLEROBJ);
    }

    public final String getHANDLEROBJ() {
        return this.getParamStringValue(TAG_HANDLEROBJ, "");
    }

    public final void setHANDLEROBJ(String strValue) {
        this.setParamValue(TAG_HANDLEROBJ, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.isParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.getParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.setParamValue(TAG_TYPEOBJ, strValue);
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

    public final boolean isJITCTRLOBJNull() {
        return this.isParamNull(TAG_JITCTRLOBJ);
    }

    public final String getJITCTRLOBJ() {
        return this.getParamStringValue(TAG_JITCTRLOBJ, "");
    }

    public final void setJITCTRLOBJ(String strValue) {
        this.setParamValue(TAG_JITCTRLOBJ, strValue);
    }

    public final boolean isJITCTRLOBJ2Null() {
        return this.isParamNull(TAG_JITCTRLOBJ2);
    }

    public final String getJITCTRLOBJ2() {
        return this.getParamStringValue(TAG_JITCTRLOBJ2, "");
    }

    public final void setJITCTRLOBJ2(String strValue) {
        this.setParamValue(TAG_JITCTRLOBJ2, strValue);
    }
}

