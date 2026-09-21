/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFStylePrj
extends BaseDataEntity {
    public static final String TAG_PSPFSTYLEPRJID = "PSPFSTYLEPRJID";
    public static final String TAG_PSPFSTYLEPRJNAME = "PSPFSTYLEPRJNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_NAMEFMT = "NAMEFMT";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_PRJTYPE = "PRJTYPE";
    public static final String TAG_MAVENFLAG = "MAVENFLAG";

    public final boolean isPSPFSTYLEPRJIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEPRJID);
    }

    public final String getPSPFSTYLEPRJID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEPRJID, "");
    }

    public final void setPSPFSTYLEPRJID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEPRJID, strValue);
    }

    public final boolean isPSPFSTYLEPRJNAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLEPRJNAME);
    }

    public final String getPSPFSTYLEPRJNAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLEPRJNAME, "");
    }

    public final void setPSPFSTYLEPRJNAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEPRJNAME, strValue);
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

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
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

    public final boolean isNAMEFMTNull() {
        return this.IsParamNull(TAG_NAMEFMT);
    }

    public final String getNAMEFMT() {
        return this.GetParamStringValue(TAG_NAMEFMT, "");
    }

    public final void setNAMEFMT(String strValue) {
        this.SetParamValue(TAG_NAMEFMT, strValue);
    }

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.SetParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
    }

    public final boolean isPRJTYPENull() {
        return this.IsParamNull(TAG_PRJTYPE);
    }

    public final String getPRJTYPE() {
        return this.GetParamStringValue(TAG_PRJTYPE, "");
    }

    public final void setPRJTYPE(String strValue) {
        this.SetParamValue(TAG_PRJTYPE, strValue);
    }

    public final boolean isMAVENFLAGNull() {
        return this.IsParamNull(TAG_MAVENFLAG);
    }

    public final boolean getMAVENFLAG() {
        return this.GetParamIntValue(TAG_MAVENFLAG, 0) == 1;
    }

    public final void setMAVENFLAG(boolean bValue) {
        this.SetParamValue(TAG_MAVENFLAG, bValue ? 1 : 0);
    }
}

