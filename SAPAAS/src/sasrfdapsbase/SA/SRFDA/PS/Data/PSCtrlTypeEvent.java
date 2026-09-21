/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCtrlTypeEvent
extends BaseDataEntity {
    public static final String TAG_PSCTRLTYPEEVENTID = "PSCTRLTYPEEVENTID";
    public static final String TAG_PSCTRLTYPEEVENTNAME = "PSCTRLTYPEEVENTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String TAG_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String TAG_PSCTRLEVENTID = "PSCTRLEVENTID";
    public static final String TAG_PSCTRLEVENTNAME = "PSCTRLEVENTNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSCTRLTYPEEVENTIDNull() {
        return this.IsParamNull(TAG_PSCTRLTYPEEVENTID);
    }

    public final String getPSCTRLTYPEEVENTID() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEEVENTID, "");
    }

    public final void setPSCTRLTYPEEVENTID(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEEVENTID, strValue);
    }

    public final boolean isPSCTRLTYPEEVENTNAMENull() {
        return this.IsParamNull(TAG_PSCTRLTYPEEVENTNAME);
    }

    public final String getPSCTRLTYPEEVENTNAME() {
        return this.GetParamStringValue(TAG_PSCTRLTYPEEVENTNAME, "");
    }

    public final void setPSCTRLTYPEEVENTNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLTYPEEVENTNAME, strValue);
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

    public final boolean isPSCTRLEVENTIDNull() {
        return this.IsParamNull(TAG_PSCTRLEVENTID);
    }

    public final String getPSCTRLEVENTID() {
        return this.GetParamStringValue(TAG_PSCTRLEVENTID, "");
    }

    public final void setPSCTRLEVENTID(String strValue) {
        this.SetParamValue(TAG_PSCTRLEVENTID, strValue);
    }

    public final boolean isPSCTRLEVENTNAMENull() {
        return this.IsParamNull(TAG_PSCTRLEVENTNAME);
    }

    public final String getPSCTRLEVENTNAME() {
        return this.GetParamStringValue(TAG_PSCTRLEVENTNAME, "");
    }

    public final void setPSCTRLEVENTNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLEVENTNAME, strValue);
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

