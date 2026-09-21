/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
        return this.IsParamNull(TAG_PSCTRLTYPEID);
    }

    public final String getPSCTRLTYPEID() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEID, "");
    }

    public final void setPSCTRLTYPEID(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEID, strValue);
    }

    public final boolean isPSCTRLTYPENAMENull() {
        return this.IsParamNull(TAG_PSCTRLTYPENAME);
    }

    public final String getPSCTRLTYPENAME() {
        return this.GetParamStringValue(TAG_PSCTRLTYPENAME, "");
    }

    public final void setPSCTRLTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isAJAXCTRLNull() {
        return this.IsParamNull(TAG_AJAXCTRL);
    }

    public final boolean getAJAXCTRL() {
        return this.GetParamIntValue(TAG_AJAXCTRL, 0) == 1;
    }

    public final void setAJAXCTRL(boolean bValue) {
        this.SetParamValue(TAG_AJAXCTRL, bValue ? 1 : 0);
    }

    public final boolean isCTRLOBJNull() {
        return this.IsParamNull(TAG_CTRLOBJ);
    }

    public final String getCTRLOBJ() {
        return this.GetParamStringValue(TAG_CTRLOBJ, "");
    }

    public final void setCTRLOBJ(String strValue) {
        this.SetParamValue(TAG_CTRLOBJ, strValue);
    }

    public final boolean isCTRLDEIDNull() {
        return this.IsParamNull(TAG_CTRLDEID);
    }

    public final String getCTRLDEID() {
        return this.GetParamStringValue(TAG_CTRLDEID, "");
    }

    public final void setCTRLDEID(String strValue) {
        this.SetParamValue(TAG_CTRLDEID, strValue);
    }

    public final boolean isCTRLDENAMENull() {
        return this.IsParamNull(TAG_CTRLDENAME);
    }

    public final String getCTRLDENAME() {
        return this.GetParamStringValue(TAG_CTRLDENAME, "");
    }

    public final void setCTRLDENAME(String strValue) {
        this.SetParamValue(TAG_CTRLDENAME, strValue);
    }

    public final boolean isPARAMOBJNull() {
        return this.IsParamNull(TAG_PARAMOBJ);
    }

    public final String getPARAMOBJ() {
        return this.GetParamStringValue(TAG_PARAMOBJ, "");
    }

    public final void setPARAMOBJ(String strValue) {
        this.SetParamValue(TAG_PARAMOBJ, strValue);
    }

    public final boolean isHANDLEROBJNull() {
        return this.IsParamNull(TAG_HANDLEROBJ);
    }

    public final String getHANDLEROBJ() {
        return this.GetParamStringValue(TAG_HANDLEROBJ, "");
    }

    public final void setHANDLEROBJ(String strValue) {
        this.SetParamValue(TAG_HANDLEROBJ, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.IsParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.GetParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.SetParamValue(TAG_TYPEOBJ, strValue);
    }

    public final boolean isJITMODELOBJNull() {
        return this.IsParamNull(TAG_JITMODELOBJ);
    }

    public final String getJITMODELOBJ() {
        return this.GetParamStringValue(TAG_JITMODELOBJ, "");
    }

    public final void setJITMODELOBJ(String strValue) {
        this.SetParamValue(TAG_JITMODELOBJ, strValue);
    }

    public final boolean isJITCTRLOBJNull() {
        return this.IsParamNull(TAG_JITCTRLOBJ);
    }

    public final String getJITCTRLOBJ() {
        return this.GetParamStringValue(TAG_JITCTRLOBJ, "");
    }

    public final void setJITCTRLOBJ(String strValue) {
        this.SetParamValue(TAG_JITCTRLOBJ, strValue);
    }

    public final boolean isJITCTRLOBJ2Null() {
        return this.IsParamNull(TAG_JITCTRLOBJ2);
    }

    public final String getJITCTRLOBJ2() {
        return this.GetParamStringValue(TAG_JITCTRLOBJ2, "");
    }

    public final void setJITCTRLOBJ2(String strValue) {
        this.SetParamValue(TAG_JITCTRLOBJ2, strValue);
    }
}

