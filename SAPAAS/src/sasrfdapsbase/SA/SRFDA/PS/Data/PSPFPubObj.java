/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFPubObj
extends BaseDataEntity {
    public static final String TAG_PSPFPUBOBJID = "PSPFPUBOBJID";
    public static final String TAG_PSPFPUBOBJNAME = "PSPFPUBOBJNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PPSPFPUBOBJID = "PPSPFPUBOBJID";
    public static final String TAG_PPSPFPUBOBJNAME = "PPSPFPUBOBJNAME";
    public static final String TAG_TARGET = "TARGET";
    public static final String TAG_PUBOBJTAG2 = "PUBOBJTAG2";
    public static final String TAG_PUBOBJTAG = "PUBOBJTAG";
    public static final String TAG_MACROPARAMS = "MACROPARAMS";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";

    public final boolean isPSPFPUBOBJIDNull() {
        return this.IsParamNull(TAG_PSPFPUBOBJID);
    }

    public final String getPSPFPUBOBJID() {
        return this.GetParamStringValue(TAG_PSPFPUBOBJID, "");
    }

    public final void setPSPFPUBOBJID(String strValue) {
        this.SetParamValue(TAG_PSPFPUBOBJID, strValue);
    }

    public final boolean isPSPFPUBOBJNAMENull() {
        return this.IsParamNull(TAG_PSPFPUBOBJNAME);
    }

    public final String getPSPFPUBOBJNAME() {
        return this.GetParamStringValue(TAG_PSPFPUBOBJNAME, "");
    }

    public final void setPSPFPUBOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPUBOBJNAME, strValue);
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

    public final boolean isPSPFIDNull() {
        return this.IsParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.GetParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.SetParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.IsParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.GetParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.SetParamValue(TAG_PSPFNAME, strValue);
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

    public final boolean isPUBOBJNull() {
        return this.IsParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.GetParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.SetParamValue(TAG_PUBOBJ, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPPSPFPUBOBJIDNull() {
        return this.IsParamNull(TAG_PPSPFPUBOBJID);
    }

    public final String getPPSPFPUBOBJID() {
        return this.GetParamStringValue(TAG_PPSPFPUBOBJID, "");
    }

    public final void setPPSPFPUBOBJID(String strValue) {
        this.SetParamValue(TAG_PPSPFPUBOBJID, strValue);
    }

    public final boolean isPPSPFPUBOBJNAMENull() {
        return this.IsParamNull(TAG_PPSPFPUBOBJNAME);
    }

    public final String getPPSPFPUBOBJNAME() {
        return this.GetParamStringValue(TAG_PPSPFPUBOBJNAME, "");
    }

    public final void setPPSPFPUBOBJNAME(String strValue) {
        this.SetParamValue(TAG_PPSPFPUBOBJNAME, strValue);
    }

    public final boolean isTARGETNull() {
        return this.IsParamNull(TAG_TARGET);
    }

    public final String getTARGET() {
        return this.GetParamStringValue(TAG_TARGET, "");
    }

    public final void setTARGET(String strValue) {
        this.SetParamValue(TAG_TARGET, strValue);
    }

    public final boolean isPUBOBJTAG2Null() {
        return this.IsParamNull(TAG_PUBOBJTAG2);
    }

    public final String getPUBOBJTAG2() {
        return this.GetParamStringValue(TAG_PUBOBJTAG2, "");
    }

    public final void setPUBOBJTAG2(String strValue) {
        this.SetParamValue(TAG_PUBOBJTAG2, strValue);
    }

    public final boolean isPUBOBJTAGNull() {
        return this.IsParamNull(TAG_PUBOBJTAG);
    }

    public final String getPUBOBJTAG() {
        return this.GetParamStringValue(TAG_PUBOBJTAG, "");
    }

    public final void setPUBOBJTAG(String strValue) {
        this.SetParamValue(TAG_PUBOBJTAG, strValue);
    }

    public final boolean isMACROPARAMSNull() {
        return this.IsParamNull(TAG_MACROPARAMS);
    }

    public final String getMACROPARAMS() {
        return this.GetParamStringValue(TAG_MACROPARAMS, "");
    }

    public final void setMACROPARAMS(String strValue) {
        this.SetParamValue(TAG_MACROPARAMS, strValue);
    }

    public final boolean isTARGETTYPENull() {
        return this.IsParamNull(TAG_TARGETTYPE);
    }

    public final String getTARGETTYPE() {
        return this.GetParamStringValue(TAG_TARGETTYPE, "");
    }

    public final void setTARGETTYPE(String strValue) {
        this.SetParamValue(TAG_TARGETTYPE, strValue);
    }
}

