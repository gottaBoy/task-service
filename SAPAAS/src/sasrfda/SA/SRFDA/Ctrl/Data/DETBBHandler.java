/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DETBBHandler
extends BaseDataEntity {
    public static final String TAG_DETBBHANDLERID = "DETBBHANDLERID";
    public static final String TAG_DETBBHANDLERNAME = "DETBBHANDLERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_NEWHANDLER = "NEWHANDLER";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isDETBBHANDLERIDNull() {
        return this.IsParamNull(TAG_DETBBHANDLERID);
    }

    public final String getDETBBHANDLERID() {
        return this.GetParamStringValue(TAG_DETBBHANDLERID, "");
    }

    public final void setDETBBHANDLERID(String strValue) {
        this.SetParamValue(TAG_DETBBHANDLERID, strValue);
    }

    public final boolean isDETBBHANDLERNAMENull() {
        return this.IsParamNull(TAG_DETBBHANDLERNAME);
    }

    public final String getDETBBHANDLERNAME() {
        return this.GetParamStringValue(TAG_DETBBHANDLERNAME, "");
    }

    public final void setDETBBHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_DETBBHANDLERNAME, strValue);
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

    public final boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public final String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public final void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public final boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public final String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public final void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public final boolean isNEWHANDLERNull() {
        return this.IsParamNull(TAG_NEWHANDLER);
    }

    public final String getNEWHANDLER() {
        return this.GetParamStringValue(TAG_NEWHANDLER, "");
    }

    public final void setNEWHANDLER(String strValue) {
        this.SetParamValue(TAG_NEWHANDLER, strValue);
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

