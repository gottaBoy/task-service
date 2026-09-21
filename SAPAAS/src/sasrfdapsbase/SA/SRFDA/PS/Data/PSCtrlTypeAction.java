/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCtrlTypeAction
extends BaseDataEntity {
    public static final String TAG_PSCTRLTYPEACTIONID = "PSCTRLTYPEACTIONID";
    public static final String TAG_PSCTRLTYPEACTIONNAME = "PSCTRLTYPEACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String TAG_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String TAG_PSCTRLACTIONID = "PSCTRLACTIONID";
    public static final String TAG_PSCTRLACTIONNAME = "PSCTRLACTIONNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSCTRLTYPEACTIONIDNull() {
        return this.IsParamNull(TAG_PSCTRLTYPEACTIONID);
    }

    public final String getPSCTRLTYPEACTIONID() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEACTIONID, "");
    }

    public final void setPSCTRLTYPEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEACTIONID, strValue);
    }

    public final boolean isPSCTRLTYPEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSCTRLTYPEACTIONNAME);
    }

    public final String getPSCTRLTYPEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEACTIONNAME, "");
    }

    public final void setPSCTRLTYPEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEACTIONNAME, strValue);
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

    public final boolean isPSCTRLACTIONIDNull() {
        return this.IsParamNull(TAG_PSCTRLACTIONID);
    }

    public final String getPSCTRLACTIONID() {
        return this.GetParamStringValue(TAG_PSCTRLACTIONID, "");
    }

    public final void setPSCTRLACTIONID(String strValue) {
        this.SetParamValue(TAG_PSCTRLACTIONID, strValue);
    }

    public final boolean isPSCTRLACTIONNAMENull() {
        return this.IsParamNull(TAG_PSCTRLACTIONNAME);
    }

    public final String getPSCTRLACTIONNAME() {
        return this.GetParamStringValue(TAG_PSCTRLACTIONNAME, "");
    }

    public final void setPSCTRLACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLACTIONNAME, strValue);
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
}

