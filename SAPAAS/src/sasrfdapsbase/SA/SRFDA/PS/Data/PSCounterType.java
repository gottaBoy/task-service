/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCounterType
extends BaseDataEntity {
    public static final String TAG_PSCOUNTERTYPEID = "PSCOUNTERTYPEID";
    public static final String TAG_PSCOUNTERTYPENAME = "PSCOUNTERTYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_COUNTEROBJ = "COUNTEROBJ";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_TYPEPARAMS = "TYPEPARAMS";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";

    public final boolean isPSCOUNTERTYPEIDNull() {
        return this.IsParamNull(TAG_PSCOUNTERTYPEID);
    }

    public final String getPSCOUNTERTYPEID() {
        return this.GetParamStringValue(TAG_PSCOUNTERTYPEID, "");
    }

    public final void setPSCOUNTERTYPEID(String strValue) {
        this.SetParamValue(TAG_PSCOUNTERTYPEID, strValue);
    }

    public final boolean isPSCOUNTERTYPENAMENull() {
        return this.IsParamNull(TAG_PSCOUNTERTYPENAME);
    }

    public final String getPSCOUNTERTYPENAME() {
        return this.GetParamStringValue(TAG_PSCOUNTERTYPENAME, "");
    }

    public final void setPSCOUNTERTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSCOUNTERTYPENAME, strValue);
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

    public final boolean isCOUNTEROBJNull() {
        return this.IsParamNull(TAG_COUNTEROBJ);
    }

    public final String getCOUNTEROBJ() {
        return this.GetParamStringValue(TAG_COUNTEROBJ, "");
    }

    public final void setCOUNTEROBJ(String strValue) {
        this.SetParamValue(TAG_COUNTEROBJ, strValue);
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

    public final boolean isTYPEPARAMSNull() {
        return this.IsParamNull(TAG_TYPEPARAMS);
    }

    public final String getTYPEPARAMS() {
        return this.GetParamStringValue(TAG_TYPEPARAMS, "");
    }

    public final void setTYPEPARAMS(String strValue) {
        this.SetParamValue(TAG_TYPEPARAMS, strValue);
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
}

