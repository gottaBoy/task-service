/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_TYPEOBJ = "TYPEOBJ";

    public final boolean isPSPORTLETTYPEIDNull() {
        return this.IsParamNull(TAG_PSPORTLETTYPEID);
    }

    public final String getPSPORTLETTYPEID() {
        return this.GetParamStringValue(TAG_PSPORTLETTYPEID, "");
    }

    public final void setPSPORTLETTYPEID(String strValue) {
        this.SetParamValue(TAG_PSPORTLETTYPEID, strValue);
    }

    public final boolean isPSPORTLETTYPENAMENull() {
        return this.IsParamNull(TAG_PSPORTLETTYPENAME);
    }

    public final String getPSPORTLETTYPENAME() {
        return this.GetParamStringValue(TAG_PSPORTLETTYPENAME, "");
    }

    public final void setPSPORTLETTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSPORTLETTYPENAME, strValue);
    }

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isPORTLETOBJNull() {
        return this.IsParamNull(TAG_PORTLETOBJ);
    }

    public final String getPORTLETOBJ() {
        return this.GetParamStringValue(TAG_PORTLETOBJ, "");
    }

    public final void setPORTLETOBJ(String strValue) {
        this.SetParamValue(TAG_PORTLETOBJ, strValue);
    }

    public final boolean isSYSPORTLETOBJNull() {
        return this.IsParamNull(TAG_SYSPORTLETOBJ);
    }

    public final String getSYSPORTLETOBJ() {
        return this.GetParamStringValue(TAG_SYSPORTLETOBJ, "");
    }

    public final void setSYSPORTLETOBJ(String strValue) {
        this.SetParamValue(TAG_SYSPORTLETOBJ, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.IsParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.GetParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.SetParamValue(TAG_BASECLSPARAMS, strValue);
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

    public final boolean isJITMODELOBJNull() {
        return this.IsParamNull(TAG_JITMODELOBJ);
    }

    public final String getJITMODELOBJ() {
        return this.GetParamStringValue(TAG_JITMODELOBJ, "");
    }

    public final void setJITMODELOBJ(String strValue) {
        this.SetParamValue(TAG_JITMODELOBJ, strValue);
    }

    public final boolean isSYSPORTLETFLAGNull() {
        return this.IsParamNull(TAG_SYSPORTLETFLAG);
    }

    public final boolean getSYSPORTLETFLAG() {
        return this.GetParamIntValue(TAG_SYSPORTLETFLAG, 0) == 1;
    }

    public final void setSYSPORTLETFLAG(boolean bValue) {
        this.SetParamValue(TAG_SYSPORTLETFLAG, bValue ? 1 : 0);
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
}

