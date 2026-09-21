/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEWFDetail
extends BaseDataEntity {
    public static final String TAG_DEWFDETAILID = "DEWFDETAILID";
    public static final String TAG_DEWFDETAILNAME = "DEWFDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_WFMODE = "WFMODE";
    public static final String TAG_WFID = "WFID";
    public static final String TAG_WFNAME = "WFNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_WFFORMPARAM = "WFFORMPARAM";

    public final boolean isDEWFDETAILIDNull() {
        return this.IsParamNull(TAG_DEWFDETAILID);
    }

    public final String getDEWFDETAILID() {
        return this.GetParamStringValue(TAG_DEWFDETAILID, "");
    }

    public final void setDEWFDETAILID(String strValue) {
        this.SetParamValue(TAG_DEWFDETAILID, strValue);
    }

    public final boolean isDEWFDETAILNAMENull() {
        return this.IsParamNull(TAG_DEWFDETAILNAME);
    }

    public final String getDEWFDETAILNAME() {
        return this.GetParamStringValue(TAG_DEWFDETAILNAME, "");
    }

    public final void setDEWFDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DEWFDETAILNAME, strValue);
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

    public final boolean isWFMODENull() {
        return this.IsParamNull(TAG_WFMODE);
    }

    public final String getWFMODE() {
        return this.GetParamStringValue(TAG_WFMODE, "");
    }

    public final void setWFMODE(String strValue) {
        this.SetParamValue(TAG_WFMODE, strValue);
    }

    public final boolean isWFIDNull() {
        return this.IsParamNull(TAG_WFID);
    }

    public final String getWFID() {
        return this.GetParamStringValue(TAG_WFID, "");
    }

    public final void setWFID(String strValue) {
        this.SetParamValue(TAG_WFID, strValue);
    }

    public final boolean isWFNAMENull() {
        return this.IsParamNull(TAG_WFNAME);
    }

    public final String getWFNAME() {
        return this.GetParamStringValue(TAG_WFNAME, "");
    }

    public final void setWFNAME(String strValue) {
        this.SetParamValue(TAG_WFNAME, strValue);
    }

    public final boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public final String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public final void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public final boolean isWFFORMPARAMNull() {
        return this.IsParamNull(TAG_WFFORMPARAM);
    }

    public final String getWFFORMPARAM() {
        return this.GetParamStringValue(TAG_WFFORMPARAM, "");
    }

    public final void setWFFORMPARAM(String strValue) {
        this.SetParamValue(TAG_WFFORMPARAM, strValue);
    }
}

