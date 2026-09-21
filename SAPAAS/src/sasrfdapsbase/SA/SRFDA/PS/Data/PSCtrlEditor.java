/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCtrlEditor
extends BaseDataEntity {
    public static final String CONTAINERTYPE_FORMITEM = "FORMITEM";
    public static final String CONTAINERTYPE_GRIDCOLUMN = "GRIDCOLUMN";
    public static final String TAG_PSCTRLEDITORID = "PSCTRLEDITORID";
    public static final String TAG_PSCTRLEDITORNAME = "PSCTRLEDITORNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CONTAINERTYPE = "CONTAINERTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String TAG_PSCTRLTYPENAME = "PSCTRLTYPENAME";

    public final boolean isPSCTRLEDITORIDNull() {
        return this.IsParamNull(TAG_PSCTRLEDITORID);
    }

    public final String getPSCTRLEDITORID() {
        return this.GetParamStringValue(TAG_PSCTRLEDITORID, "");
    }

    public final void setPSCTRLEDITORID(String strValue) {
        this.SetParamValue(TAG_PSCTRLEDITORID, strValue);
    }

    public final boolean isPSCTRLEDITORNAMENull() {
        return this.IsParamNull(TAG_PSCTRLEDITORNAME);
    }

    public final String getPSCTRLEDITORNAME() {
        return this.GetParamStringValue(TAG_PSCTRLEDITORNAME, "");
    }

    public final void setPSCTRLEDITORNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLEDITORNAME, strValue);
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

    public final boolean isCONTAINERTYPENull() {
        return this.IsParamNull(TAG_CONTAINERTYPE);
    }

    public final String getCONTAINERTYPE() {
        return this.GetParamStringValue(TAG_CONTAINERTYPE, "");
    }

    public final void setCONTAINERTYPE(String strValue) {
        this.SetParamValue(TAG_CONTAINERTYPE, strValue);
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
}

