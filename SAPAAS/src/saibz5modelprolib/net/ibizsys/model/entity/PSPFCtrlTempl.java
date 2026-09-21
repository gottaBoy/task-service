/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPFCtrlTempl
extends BaseDataEntity {
    public static final String TAG_PSPFCTRLTEMPLID = "PSPFCTRLTEMPLID";
    public static final String TAG_PSPFCTRLTEMPLNAME = "PSPFCTRLTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFPUBCODEID = "PSPFPUBCODEID";
    public static final String TAG_PSPFPUBCODENAME = "PSPFPUBCODENAME";
    public static final String TAG_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String TAG_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String TAG_TEMPLCODE = "TEMPLCODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PUBOBJ = "PUBOBJ";
    public static final String TAG_TEMPLCODE2 = "TEMPLCODE2";
    public static final String TAG_TEMPLCODE3 = "TEMPLCODE3";
    public static final String TAG_TEMPLCODE4 = "TEMPLCODE4";
    public static final String TAG_PITEMPLCODE = "PITEMPLCODE";
    public static final String TAG_PITEMPLCODE2 = "PITEMPLCODE2";

    public final boolean isPSPFCTRLTEMPLIDNull() {
        return this.isParamNull(TAG_PSPFCTRLTEMPLID);
    }

    public final String getPSPFCTRLTEMPLID() {
        return this.getParamStringValue(TAG_PSPFCTRLTEMPLID, "");
    }

    public final void setPSPFCTRLTEMPLID(String strValue) {
        this.setParamValue(TAG_PSPFCTRLTEMPLID, strValue);
    }

    public final boolean isPSPFCTRLTEMPLNAMENull() {
        return this.isParamNull(TAG_PSPFCTRLTEMPLNAME);
    }

    public final String getPSPFCTRLTEMPLNAME() {
        return this.getParamStringValue(TAG_PSPFCTRLTEMPLNAME, "");
    }

    public final void setPSPFCTRLTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSPFCTRLTEMPLNAME, strValue);
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

    public final boolean isPSCTRLTYPEIDNull() {
        return this.isParamNull(TAG_PSCTRLTYPEID);
    }

    public final String getPSCTRLTYPEID() {
        return this.getParamStringValue(TAG_PSCTRLTYPEID, "");
    }

    public final void setPSCTRLTYPEID(String strValue) {
        this.setParamValue(TAG_PSCTRLTYPEID, strValue);
    }

    public final boolean isPSCTRLTYPENAMENull() {
        return this.isParamNull(TAG_PSCTRLTYPENAME);
    }

    public final String getPSCTRLTYPENAME() {
        return this.getParamStringValue(TAG_PSCTRLTYPENAME, "");
    }

    public final void setPSCTRLTYPENAME(String strValue) {
        this.setParamValue(TAG_PSCTRLTYPENAME, strValue);
    }

    public final boolean isTEMPLCODENull() {
        return this.isParamNull(TAG_TEMPLCODE);
    }

    public final String getTEMPLCODE() {
        return this.getParamStringValue(TAG_TEMPLCODE, "");
    }

    public final void setTEMPLCODE(String strValue) {
        this.setParamValue(TAG_TEMPLCODE, strValue);
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

    public final boolean isPSPFSTYLEIDNull() {
        return this.isParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.getParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.setParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.isParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.getParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSPFSTYLENAME, strValue);
    }

    public final boolean isPUBOBJNull() {
        return this.isParamNull(TAG_PUBOBJ);
    }

    public final String getPUBOBJ() {
        return this.getParamStringValue(TAG_PUBOBJ, "");
    }

    public final void setPUBOBJ(String strValue) {
        this.setParamValue(TAG_PUBOBJ, strValue);
    }

    public final boolean isTEMPLCODE2Null() {
        return this.isParamNull(TAG_TEMPLCODE2);
    }

    public final String getTEMPLCODE2() {
        return this.getParamStringValue(TAG_TEMPLCODE2, "");
    }

    public final void setTEMPLCODE2(String strValue) {
        this.setParamValue(TAG_TEMPLCODE2, strValue);
    }

    public final boolean isTEMPLCODE3Null() {
        return this.isParamNull(TAG_TEMPLCODE3);
    }

    public final String getTEMPLCODE3() {
        return this.getParamStringValue(TAG_TEMPLCODE3, "");
    }

    public final void setTEMPLCODE3(String strValue) {
        this.setParamValue(TAG_TEMPLCODE3, strValue);
    }

    public final boolean isTEMPLCODE4Null() {
        return this.isParamNull(TAG_TEMPLCODE4);
    }

    public final String getTEMPLCODE4() {
        return this.getParamStringValue(TAG_TEMPLCODE4, "");
    }

    public final void setTEMPLCODE4(String strValue) {
        this.setParamValue(TAG_TEMPLCODE4, strValue);
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

    public final boolean isPITEMPLCODE2Null() {
        return this.isParamNull(TAG_PITEMPLCODE2);
    }

    public final String getPITEMPLCODE2() {
        return this.getParamStringValue(TAG_PITEMPLCODE2, "");
    }

    public final void setPITEMPLCODE2(String strValue) {
        this.setParamValue(TAG_PITEMPLCODE2, strValue);
    }
}

