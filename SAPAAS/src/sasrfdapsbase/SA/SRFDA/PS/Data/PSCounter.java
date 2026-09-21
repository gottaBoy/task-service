/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCounter
extends BaseDataEntity {
    public static final String TAG_PSCOUNTERID = "PSCOUNTERID";
    public static final String TAG_PSCOUNTERNAME = "PSCOUNTERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_COUNTERTYPE = "COUNTERTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_JITCTRLOBJ = "JITCTRLOBJ";

    public final boolean isPSCOUNTERIDNull() {
        return this.IsParamNull(TAG_PSCOUNTERID);
    }

    public final String getPSCOUNTERID() {
        return this.GetParamStringValue(TAG_PSCOUNTERID, "");
    }

    public final void setPSCOUNTERID(String strValue) {
        this.SetParamValue(TAG_PSCOUNTERID, strValue);
    }

    public final boolean isPSCOUNTERNAMENull() {
        return this.IsParamNull(TAG_PSCOUNTERNAME);
    }

    public final String getPSCOUNTERNAME() {
        return this.GetParamStringValue(TAG_PSCOUNTERNAME, "");
    }

    public final void setPSCOUNTERNAME(String strValue) {
        this.SetParamValue(TAG_PSCOUNTERNAME, strValue);
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

    public final boolean isCOUNTERTYPENull() {
        return this.IsParamNull(TAG_COUNTERTYPE);
    }

    public final String getCOUNTERTYPE() {
        return this.GetParamStringValue(TAG_COUNTERTYPE, "");
    }

    public final void setCOUNTERTYPE(String strValue) {
        this.SetParamValue(TAG_COUNTERTYPE, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

