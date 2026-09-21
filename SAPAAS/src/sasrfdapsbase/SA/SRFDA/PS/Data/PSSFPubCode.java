/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFPubCode
extends BaseDataEntity {
    public static final String TARGETTYPE_NONE = "NONE";
    public static final String PREVIEWCODE_CODE1 = "CODE1";
    public static final String PREVIEWCODE_CODE2 = "CODE2";
    public static final String PREVIEWCODE_CODE3 = "CODE3";
    public static final String PREVIEWCODE_CODE4 = "CODE4";
    public static final String TAG_PSSFPUBCODEID = "PSSFPUBCODEID";
    public static final String TAG_PSSFPUBCODENAME = "PSSFPUBCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_CODEEXT = "CODEEXT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_PKGNAME = "PKGNAME";
    public static final String TAG_CLASSEXT = "CLASSEXT";
    public static final String TAG_CODEFOLDER = "CODEFOLDER";
    public static final String TAG_PSSFCODEFOLDERID = "PSSFCODEFOLDERID";
    public static final String TAG_PSSFCODEFOLDERNAME = "PSSFCODEFOLDERNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PREVIEWFLAG = "PREVIEWFLAG";
    public static final String TAG_PREVIEWCODE = "PREVIEWCODE";
    public static final String TAG_PITEMPLCODE = "PITEMPLCODE";
    public static final String TAG_PPSSFPUBCODEID = "PPSSFPUBCODEID";
    public static final String TAG_PPSSFPUBCODENAME = "PPSSFPUBCODENAME";
    public static final String TAG_HASPSSFPUBCODE = "HASPSSFPUBCODE";
    public static final String TAG_DYNAVIEWFLAG = "DYNAVIEWFLAG";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";

    public final boolean isPSSFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSSFPUBCODEID);
    }

    public final String getPSSFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSSFPUBCODEID, "");
    }

    public final void setPSSFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSSFPUBCODEID, strValue);
    }

    public final boolean isPSSFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSSFPUBCODENAME);
    }

    public final String getPSSFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSSFPUBCODENAME, "");
    }

    public final void setPSSFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSSFPUBCODENAME, strValue);
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

    public final boolean isCODEEXTNull() {
        return this.IsParamNull(TAG_CODEEXT);
    }

    public final String getCODEEXT() {
        return this.GetParamStringValue(TAG_CODEEXT, "");
    }

    public final void setCODEEXT(String strValue) {
        this.SetParamValue(TAG_CODEEXT, strValue);
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

    public final boolean isTARGETTYPENull() {
        return this.IsParamNull(TAG_TARGETTYPE);
    }

    public final String getTARGETTYPE() {
        return this.GetParamStringValue(TAG_TARGETTYPE, "");
    }

    public final void setTARGETTYPE(String strValue) {
        this.SetParamValue(TAG_TARGETTYPE, strValue);
    }

    public final boolean isPKGNAMENull() {
        return this.IsParamNull(TAG_PKGNAME);
    }

    public final String getPKGNAME() {
        return this.GetParamStringValue(TAG_PKGNAME, "");
    }

    public final void setPKGNAME(String strValue) {
        this.SetParamValue(TAG_PKGNAME, strValue);
    }

    public final boolean isCLASSEXTNull() {
        return this.IsParamNull(TAG_CLASSEXT);
    }

    public final String getCLASSEXT() {
        return this.GetParamStringValue(TAG_CLASSEXT, "");
    }

    public final void setCLASSEXT(String strValue) {
        this.SetParamValue(TAG_CLASSEXT, strValue);
    }

    public final boolean isCODEFOLDERNull() {
        return this.IsParamNull(TAG_CODEFOLDER);
    }

    public final String getCODEFOLDER() {
        return this.GetParamStringValue(TAG_CODEFOLDER, "");
    }

    public final void setCODEFOLDER(String strValue) {
        this.SetParamValue(TAG_CODEFOLDER, strValue);
    }

    public final boolean isPSSFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERID);
    }

    public final String getPSSFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERID, "");
    }

    public final void setPSSFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERID, strValue);
    }

    public final boolean isPSSFCODEFOLDERNAMENull() {
        return this.IsParamNull(TAG_PSSFCODEFOLDERNAME);
    }

    public final String getPSSFCODEFOLDERNAME() {
        return this.GetParamStringValue(TAG_PSSFCODEFOLDERNAME, "");
    }

    public final void setPSSFCODEFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFCODEFOLDERNAME, strValue);
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

    public final boolean isPREVIEWFLAGNull() {
        return this.IsParamNull(TAG_PREVIEWFLAG);
    }

    public final boolean getPREVIEWFLAG() {
        return this.GetParamIntValue(TAG_PREVIEWFLAG, 0) == 1;
    }

    public final void setPREVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_PREVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isPREVIEWCODENull() {
        return this.IsParamNull(TAG_PREVIEWCODE);
    }

    public final String getPREVIEWCODE() {
        return this.GetParamStringValue(TAG_PREVIEWCODE, "");
    }

    public final void setPREVIEWCODE(String strValue) {
        this.SetParamValue(TAG_PREVIEWCODE, strValue);
    }

    public final boolean isPITEMPLCODENull() {
        return this.IsParamNull(TAG_PITEMPLCODE);
    }

    public final String getPITEMPLCODE() {
        return this.GetParamStringValue(TAG_PITEMPLCODE, "");
    }

    public final void setPITEMPLCODE(String strValue) {
        this.SetParamValue(TAG_PITEMPLCODE, strValue);
    }

    public final boolean isPPSSFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PPSSFPUBCODEID);
    }

    public final String getPPSSFPUBCODEID() {
        return this.GetParamStringValue(TAG_PPSSFPUBCODEID, "");
    }

    public final void setPPSSFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PPSSFPUBCODEID, strValue);
    }

    public final boolean isPPSSFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PPSSFPUBCODENAME);
    }

    public final String getPPSSFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PPSSFPUBCODENAME, "");
    }

    public final void setPPSSFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PPSSFPUBCODENAME, strValue);
    }

    public final boolean isHASPSSFPUBCODENull() {
        return this.IsParamNull(TAG_HASPSSFPUBCODE);
    }

    public final boolean getHASPSSFPUBCODE() {
        return this.GetParamIntValue(TAG_HASPSSFPUBCODE, 0) == 1;
    }

    public final void setHASPSSFPUBCODE(boolean bValue) {
        this.SetParamValue(TAG_HASPSSFPUBCODE, bValue ? 1 : 0);
    }

    public final boolean isDYNAVIEWFLAGNull() {
        return this.IsParamNull(TAG_DYNAVIEWFLAG);
    }

    public final boolean getDYNAVIEWFLAG() {
        return this.GetParamIntValue(TAG_DYNAVIEWFLAG, 0) == 1;
    }

    public final void setDYNAVIEWFLAG(boolean bValue) {
        this.SetParamValue(TAG_DYNAVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final boolean getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0) == 1;
    }

    public final void setDYNAMODELFLAG(boolean bValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, bValue ? 1 : 0);
    }
}

