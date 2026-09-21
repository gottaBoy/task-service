/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPFPubCode
extends BaseDataEntity {
    public static final String TARGETTYPE_VIEW = "VIEW";
    public static final String TARGETTYPE_APP = "APP";
    public static final String TARGETTYPE_VIEWCTRL = "VIEWCTRL";
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
        return this.isParamNull(TAG_PSPFPUBCODEID);
    }

    public final String getPSPFPUBCODEID() {
        return this.getParamStringValue(TAG_PSPFPUBCODEID, "");
    }

    public final void setPSPFPUBCODEID(String strValue) {
        this.setParamValue(TAG_PSPFPUBCODEID, strValue);
    }

    public final boolean isPSPFPUBCODENAMENull() {
        return this.isParamNull(TAG_PSPFPUBCODENAME);
    }

    public final String getPSPFPUBCODENAME() {
        return this.getParamStringValue(TAG_PSPFPUBCODENAME, "");
    }

    public final void setPSPFPUBCODENAME(String strValue) {
        this.setParamValue(TAG_PSPFPUBCODENAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSPFIDNull() {
        return this.isParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.getParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.setParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSPFNAMENull() {
        return this.isParamNull(TAG_PSPFNAME);
    }

    public final String getPSPFNAME() {
        return this.getParamStringValue(TAG_PSPFNAME, "");
    }

    public final void setPSPFNAME(String strValue) {
        this.setParamValue(TAG_PSPFNAME, strValue);
    }

    public final boolean isCODEEXTNull() {
        return this.isParamNull(TAG_CODEEXT);
    }

    public final String getCODEEXT() {
        return this.getParamStringValue(TAG_CODEEXT, "");
    }

    public final void setCODEEXT(String strValue) {
        this.setParamValue(TAG_CODEEXT, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTARGETTYPENull() {
        return this.isParamNull(TAG_TARGETTYPE);
    }

    public final String getTARGETTYPE() {
        return this.getParamStringValue(TAG_TARGETTYPE, "");
    }

    public final void setTARGETTYPE(String strValue) {
        this.setParamValue(TAG_TARGETTYPE, strValue);
    }

    public final boolean isPKGNAMENull() {
        return this.isParamNull(TAG_PKGNAME);
    }

    public final String getPKGNAME() {
        return this.getParamStringValue(TAG_PKGNAME, "");
    }

    public final void setPKGNAME(String strValue) {
        this.setParamValue(TAG_PKGNAME, strValue);
    }

    public final boolean isCLASSEXTNull() {
        return this.isParamNull(TAG_CLASSEXT);
    }

    public final String getCLASSEXT() {
        return this.getParamStringValue(TAG_CLASSEXT, "");
    }

    public final void setCLASSEXT(String strValue) {
        this.setParamValue(TAG_CLASSEXT, strValue);
    }

    public final boolean isCODEFOLDERNull() {
        return this.isParamNull(TAG_CODEFOLDER);
    }

    public final String getCODEFOLDER() {
        return this.getParamStringValue(TAG_CODEFOLDER, "");
    }

    public final void setCODEFOLDER(String strValue) {
        this.setParamValue(TAG_CODEFOLDER, strValue);
    }

    public final boolean isPSPFCODEFOLDERIDNull() {
        return this.isParamNull(TAG_PSPFCODEFOLDERID);
    }

    public final String getPSPFCODEFOLDERID() {
        return this.getParamStringValue(TAG_PSPFCODEFOLDERID, "");
    }

    public final void setPSPFCODEFOLDERID(String strValue) {
        this.setParamValue(TAG_PSPFCODEFOLDERID, strValue);
    }

    public final boolean isPSPFCODEFOLDERNAMENull() {
        return this.isParamNull(TAG_PSPFCODEFOLDERNAME);
    }

    public final String getPSPFCODEFOLDERNAME() {
        return this.getParamStringValue(TAG_PSPFCODEFOLDERNAME, "");
    }

    public final void setPSPFCODEFOLDERNAME(String strValue) {
        this.setParamValue(TAG_PSPFCODEFOLDERNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPREVIEWFLAGNull() {
        return this.isParamNull(TAG_PREVIEWFLAG);
    }

    public final boolean getPREVIEWFLAG() {
        return this.getParamIntValue(TAG_PREVIEWFLAG, 0) == 1;
    }

    public final void setPREVIEWFLAG(boolean bValue) {
        this.setParamValue(TAG_PREVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isPREVIEWCODENull() {
        return this.isParamNull(TAG_PREVIEWCODE);
    }

    public final String getPREVIEWCODE() {
        return this.getParamStringValue(TAG_PREVIEWCODE, "");
    }

    public final void setPREVIEWCODE(String strValue) {
        this.setParamValue(TAG_PREVIEWCODE, strValue);
    }

    public final boolean isPITEMPLCODENull() {
        return this.isParamNull(TAG_PITEMPLCODE);
    }

    public final String getPITEMPLCODE() {
        return this.getParamStringValue(TAG_PITEMPLCODE, "");
    }

    public final void setPITEMPLCODE(String strValue) {
        this.setParamValue(TAG_PITEMPLCODE, strValue);
    }

    public final boolean isPPSPFPUBCODEIDNull() {
        return this.isParamNull(TAG_PPSPFPUBCODEID);
    }

    public final String getPPSPFPUBCODEID() {
        return this.getParamStringValue(TAG_PPSPFPUBCODEID, "");
    }

    public final void setPPSPFPUBCODEID(String strValue) {
        this.setParamValue(TAG_PPSPFPUBCODEID, strValue);
    }

    public final boolean isPPSPFPUBCODENAMENull() {
        return this.isParamNull(TAG_PPSPFPUBCODENAME);
    }

    public final String getPPSPFPUBCODENAME() {
        return this.getParamStringValue(TAG_PPSPFPUBCODENAME, "");
    }

    public final void setPPSPFPUBCODENAME(String strValue) {
        this.setParamValue(TAG_PPSPFPUBCODENAME, strValue);
    }

    public final boolean isHASPSPFPUBCODENull() {
        return this.isParamNull(TAG_HASPSPFPUBCODE);
    }

    public final boolean getHASPSPFPUBCODE() {
        return this.getParamIntValue(TAG_HASPSPFPUBCODE, 0) == 1;
    }

    public final void setHASPSPFPUBCODE(boolean bValue) {
        this.setParamValue(TAG_HASPSPFPUBCODE, bValue ? 1 : 0);
    }

    public final boolean isDYNAVIEWFLAGNull() {
        return this.isParamNull(TAG_DYNAVIEWFLAG);
    }

    public final boolean getDYNAVIEWFLAG() {
        return this.getParamIntValue(TAG_DYNAVIEWFLAG, 0) == 1;
    }

    public final void setDYNAVIEWFLAG(boolean bValue) {
        this.setParamValue(TAG_DYNAVIEWFLAG, bValue ? 1 : 0);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.isParamNull(TAG_DYNAMODELFLAG);
    }

    public final boolean getDYNAMODELFLAG() {
        return this.getParamIntValue(TAG_DYNAMODELFLAG, 0) == 1;
    }

    public final void setDYNAMODELFLAG(boolean bValue) {
        this.setParamValue(TAG_DYNAMODELFLAG, bValue ? 1 : 0);
    }
}

