/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFPubObj
extends BaseDataEntity {
    public static final String TAG_PSSFPUBOBJID = "PSSFPUBOBJID";
    public static final String TAG_PSSFPUBOBJNAME = "PSSFPUBOBJNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_PPSSFPUBOBJID = "PPSSFPUBOBJID";
    public static final String TAG_PPSSFPUBOBJNAME = "PPSSFPUBOBJNAME";
    public static final String TAG_TARGET = "TARGET";
    public static final String TAG_PUBOBJTAG = "PUBOBJTAG";
    public static final String TAG_PUBOBJTAG2 = "PUBOBJTAG2";
    public static final String TAG_MACROPARAMS = "MACROPARAMS";
    public static final String TAG_MODELLIST = "MODELLIST";

    public final boolean isPSSFPUBOBJIDNull() {
        return this.IsParamNull(TAG_PSSFPUBOBJID);
    }

    public final String getPSSFPUBOBJID() {
        return this.GetParamStringValue(TAG_PSSFPUBOBJID, "");
    }

    public final void setPSSFPUBOBJID(String strValue) {
        this.SetParamValue(TAG_PSSFPUBOBJID, strValue);
    }

    public final boolean isPSSFPUBOBJNAMENull() {
        return this.IsParamNull(TAG_PSSFPUBOBJNAME);
    }

    public final String getPSSFPUBOBJNAME() {
        return this.GetParamStringValue(TAG_PSSFPUBOBJNAME, "");
    }

    public final void setPSSFPUBOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSSFPUBOBJNAME, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
    }

    public final boolean isPPSSFPUBOBJIDNull() {
        return this.IsParamNull(TAG_PPSSFPUBOBJID);
    }

    public final String getPPSSFPUBOBJID() {
        return this.GetParamStringValue(TAG_PPSSFPUBOBJID, "");
    }

    public final void setPPSSFPUBOBJID(String strValue) {
        this.SetParamValue(TAG_PPSSFPUBOBJID, strValue);
    }

    public final boolean isPPSSFPUBOBJNAMENull() {
        return this.IsParamNull(TAG_PPSSFPUBOBJNAME);
    }

    public final String getPPSSFPUBOBJNAME() {
        return this.GetParamStringValue(TAG_PPSSFPUBOBJNAME, "");
    }

    public final void setPPSSFPUBOBJNAME(String strValue) {
        this.SetParamValue(TAG_PPSSFPUBOBJNAME, strValue);
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

    public final boolean isPUBOBJTAGNull() {
        return this.IsParamNull(TAG_PUBOBJTAG);
    }

    public final String getPUBOBJTAG() {
        return this.GetParamStringValue(TAG_PUBOBJTAG, "");
    }

    public final void setPUBOBJTAG(String strValue) {
        this.SetParamValue(TAG_PUBOBJTAG, strValue);
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

    public final boolean isMACROPARAMSNull() {
        return this.IsParamNull(TAG_MACROPARAMS);
    }

    public final String getMACROPARAMS() {
        return this.GetParamStringValue(TAG_MACROPARAMS, "");
    }

    public final void setMACROPARAMS(String strValue) {
        this.SetParamValue(TAG_MACROPARAMS, strValue);
    }

    public final boolean isMODELLISTNull() {
        return this.IsParamNull(TAG_MODELLIST);
    }

    public final String getMODELLIST() {
        return this.GetParamStringValue(TAG_MODELLIST, "");
    }

    public final void setMODELLIST(String strValue) {
        this.SetParamValue(TAG_MODELLIST, strValue);
    }
}

