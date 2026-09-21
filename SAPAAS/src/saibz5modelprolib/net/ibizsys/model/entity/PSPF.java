/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPF
extends BaseDataEntity {
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VIEWPUBOBJ = "VIEWPUBOBJ";
    public static final String TAG_CTRLPUBOBJ = "CTRLPUBOBJ";
    public static final String TAG_CTRLPARTPUBOBJ = "CTRLPARTPUBOBJ";
    public static final String TAG_EDITORPUBOBJ = "EDITORPUBOBJ";
    public static final String TAG_UAPUBOBJ = "UAPUBOBJ";
    public static final String TAG_VLPUBOBJ = "VLPUBOBJ";
    public static final String TAG_APPPUBOBJ = "APPPUBOBJ";
    public static final String TAG_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String TAG_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String TAG_FORMLAYOUTMODE = "FORMLAYOUTMODE";
    public static final String TAG_TYPEOBJ = "TYPEOBJ";
    public static final String TAG_STYLEOBJ = "STYLEOBJ";
    public static final String TAG_JITAPPOBJ = "JITAPPOBJ";
    public static final String TAG_USEJITPREVIEW = "USEJITPREVIEW";

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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isVIEWPUBOBJNull() {
        return this.isParamNull(TAG_VIEWPUBOBJ);
    }

    public final String getVIEWPUBOBJ() {
        return this.getParamStringValue(TAG_VIEWPUBOBJ, "");
    }

    public final void setVIEWPUBOBJ(String strValue) {
        this.setParamValue(TAG_VIEWPUBOBJ, strValue);
    }

    public final boolean isCTRLPUBOBJNull() {
        return this.isParamNull(TAG_CTRLPUBOBJ);
    }

    public final String getCTRLPUBOBJ() {
        return this.getParamStringValue(TAG_CTRLPUBOBJ, "");
    }

    public final void setCTRLPUBOBJ(String strValue) {
        this.setParamValue(TAG_CTRLPUBOBJ, strValue);
    }

    public final boolean isCTRLPARTPUBOBJNull() {
        return this.isParamNull(TAG_CTRLPARTPUBOBJ);
    }

    public final String getCTRLPARTPUBOBJ() {
        return this.getParamStringValue(TAG_CTRLPARTPUBOBJ, "");
    }

    public final void setCTRLPARTPUBOBJ(String strValue) {
        this.setParamValue(TAG_CTRLPARTPUBOBJ, strValue);
    }

    public final boolean isEDITORPUBOBJNull() {
        return this.isParamNull(TAG_EDITORPUBOBJ);
    }

    public final String getEDITORPUBOBJ() {
        return this.getParamStringValue(TAG_EDITORPUBOBJ, "");
    }

    public final void setEDITORPUBOBJ(String strValue) {
        this.setParamValue(TAG_EDITORPUBOBJ, strValue);
    }

    public final boolean isUAPUBOBJNull() {
        return this.isParamNull(TAG_UAPUBOBJ);
    }

    public final String getUAPUBOBJ() {
        return this.getParamStringValue(TAG_UAPUBOBJ, "");
    }

    public final void setUAPUBOBJ(String strValue) {
        this.setParamValue(TAG_UAPUBOBJ, strValue);
    }

    public final boolean isVLPUBOBJNull() {
        return this.isParamNull(TAG_VLPUBOBJ);
    }

    public final String getVLPUBOBJ() {
        return this.getParamStringValue(TAG_VLPUBOBJ, "");
    }

    public final void setVLPUBOBJ(String strValue) {
        this.setParamValue(TAG_VLPUBOBJ, strValue);
    }

    public final boolean isAPPPUBOBJNull() {
        return this.isParamNull(TAG_APPPUBOBJ);
    }

    public final String getAPPPUBOBJ() {
        return this.getParamStringValue(TAG_APPPUBOBJ, "");
    }

    public final void setAPPPUBOBJ(String strValue) {
        this.setParamValue(TAG_APPPUBOBJ, strValue);
    }

    public final boolean isFORMLAYOUTMODENull() {
        return this.isParamNull(TAG_FORMLAYOUTMODE);
    }

    public final String getFORMLAYOUTMODE() {
        return this.getParamStringValue(TAG_FORMLAYOUTMODE, "");
    }

    public final void setFORMLAYOUTMODE(String strValue) {
        this.setParamValue(TAG_FORMLAYOUTMODE, strValue);
    }

    public final boolean isTYPEOBJNull() {
        return this.isParamNull(TAG_TYPEOBJ);
    }

    public final String getTYPEOBJ() {
        return this.getParamStringValue(TAG_TYPEOBJ, "");
    }

    public final void setTYPEOBJ(String strValue) {
        this.setParamValue(TAG_TYPEOBJ, strValue);
    }

    public final boolean isPSAPPTYPEIDNull() {
        return this.isParamNull(TAG_PSAPPTYPEID);
    }

    public final String getPSAPPTYPEID() {
        return this.getParamStringValue(TAG_PSAPPTYPEID, "");
    }

    public final void setPSAPPTYPEID(String strValue) {
        this.setParamValue(TAG_PSAPPTYPEID, strValue);
    }

    public final boolean isPSAPPTYPENAMENull() {
        return this.isParamNull(TAG_PSAPPTYPENAME);
    }

    public final String getPSAPPTYPENAME() {
        return this.getParamStringValue(TAG_PSAPPTYPENAME, "");
    }

    public final void setPSAPPTYPENAME(String strValue) {
        this.setParamValue(TAG_PSAPPTYPENAME, strValue);
    }

    public final boolean isSTYLEOBJNull() {
        return this.isParamNull(TAG_STYLEOBJ);
    }

    public final String getSTYLEOBJ() {
        return this.getParamStringValue(TAG_STYLEOBJ, "");
    }

    public final void setSTYLEOBJ(String strValue) {
        this.setParamValue(TAG_STYLEOBJ, strValue);
    }

    public final boolean isJITAPPOBJNull() {
        return this.isParamNull(TAG_JITAPPOBJ);
    }

    public final String getJITAPPOBJ() {
        return this.getParamStringValue(TAG_JITAPPOBJ, "");
    }

    public final void setJITAPPOBJ(String strValue) {
        this.setParamValue(TAG_JITAPPOBJ, strValue);
    }

    public final boolean isUSEJITPREVIEWNull() {
        return this.isParamNull(TAG_USEJITPREVIEW);
    }

    public final boolean getUSEJITPREVIEW() {
        return this.getParamIntValue(TAG_USEJITPREVIEW, 0) == 1;
    }

    public final void setUSEJITPREVIEW(boolean bValue) {
        this.setParamValue(TAG_USEJITPREVIEW, bValue ? 1 : 0);
    }
}

