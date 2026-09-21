/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFPubCode
extends BaseDataEntity {
    public static final String TARGETTYPE_VIEW = "VIEW";
    public static final String TARGETTYPE_APP = "APP";
    public static final String TARGETTYPE_VIEWCTRL = "VIEWCTRL";
    public static final String TARGETTYPE_DATAENTITY = "DATAENTITY";
    public static final String PREVIEWCODE_CODE1 = "CODE1";
    public static final String PREVIEWCODE_CODE2 = "CODE2";
    public static final String PREVIEWCODE_CODE3 = "CODE3";
    public static final String PREVIEWCODE_CODE4 = "CODE4";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_CODEEXT = "CODEEXT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TARGETTYPE = "TARGETTYPE";
    public static final String TAG_PKGNAME = "PKGNAME";
    public static final String TAG_CLASSEXT = "CLASSEXT";
    public static final String TAG_CODEFOLDER = "CODEFOLDER";
    public static final String TAG_PSPFCODEFOLDERID = "PSPFCODEFOLDERID";
    public static final String TAG_PSPFCODEFOLDERNAME = "PSPFCODEFOLDERNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PREVIEWFLAG = "PREVIEWFLAG";
    public static final String TAG_PREVIEWCODE = "PREVIEWCODE";
    public static final String TAG_PITEMPLCODE = "PITEMPLCODE";
    public static final String TAG_PPSPFPUBCODEID = "PPSPFPUBCODEID";
    public static final String TAG_PPSPFPUBCODENAME = "PPSPFPUBCODENAME";
    public static final String TAG_HASPSPFPUBCODE = "HASPSPFPUBCODE";
    public static final String TAG_DYNAVIEWFLAG = "DYNAVIEWFLAG";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";

    public final boolean isPSPFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.GetParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PSPFPUBCODENAME, strValue);
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

    public final boolean isPSPFCODEFOLDERIDNull() {
        return this.IsParamNull(TAG_PSPFCODEFOLDERID);
    }

    public final String getPSPFCODEFOLDERID() {
        return this.GetParamStringValue(TAG_PSPFCODEFOLDERID, "");
    }

    public final void setPSPFCODEFOLDERID(String strValue) {
        this.SetParamValue(TAG_PSPFCODEFOLDERID, strValue);
    }

    public final boolean isPSPFCODEFOLDERNAMENull() {
        return this.IsParamNull(TAG_PSPFCODEFOLDERNAME);
    }

    public final String getPSPFCODEFOLDERNAME() {
        return this.GetParamStringValue(TAG_PSPFCODEFOLDERNAME, "");
    }

    public final void setPSPFCODEFOLDERNAME(String strValue) {
        this.SetParamValue(TAG_PSPFCODEFOLDERNAME, strValue);
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

    public final boolean isPPSPFPUBCODEIDNull() {
        return this.IsParamNull(TAG_PPSPFPUBCODEID);
    }

    public final String getPPSPFPUBCODEID() {
        return this.GetParamStringValue(TAG_PPSPFPUBCODEID, "");
    }

    public final void setPPSPFPUBCODEID(String strValue) {
        this.SetParamValue(TAG_PPSPFPUBCODEID, strValue);
    }

    public final boolean isPPSPFPUBCODENAMENull() {
        return this.IsParamNull(TAG_PPSPFPUBCODENAME);
    }

    public final String getPPSPFPUBCODENAME() {
        return this.GetParamStringValue(TAG_PPSPFPUBCODENAME, "");
    }

    public final void setPPSPFPUBCODENAME(String strValue) {
        this.SetParamValue(TAG_PPSPFPUBCODENAME, strValue);
    }

    public final boolean isHASPSPFPUBCODENull() {
        return this.IsParamNull(TAG_HASPSPFPUBCODE);
    }

    public final boolean getHASPSPFPUBCODE() {
        return this.GetParamIntValue(TAG_HASPSPFPUBCODE, 0) == 1;
    }

    public final void setHASPSPFPUBCODE(boolean bValue) {
        this.SetParamValue(TAG_HASPSPFPUBCODE, bValue ? 1 : 0);
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

