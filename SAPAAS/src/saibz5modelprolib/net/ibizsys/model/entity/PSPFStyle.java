/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSPFStyle
extends BaseDataEntity {
    public static final int PKGINHERITMODE_DEFAULT = 1;
    public static final int PKGINHERITMODE_SELF = 2;
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLPSPFSTYLEID = "TEMPLPSPFSTYLEID";
    public static final String TAG_TEMPLPSPFSTYLENAME = "TEMPLPSPFSTYLENAME";
    public static final String TAG_STYLECODE = "STYLECODE";
    public static final String TAG_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_LASTIMPTIME = "LASTIMPTIME";
    public static final String TAG_TEMPLSTATE = "TEMPLSTATE";
    public static final String TAG_TEMPLINFO = "TEMPLINFO";
    public static final String TAG_VERSTR = "VERSTR";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_TEMPLROOTURL = "TEMPLROOTURL";
    public static final String TAG_STYLERESURL = "STYLERESURL";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_PKGINHERITMODE = "PKGINHERITMODE";

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

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTEMPLPSPFSTYLEIDNull() {
        return this.isParamNull(TAG_TEMPLPSPFSTYLEID);
    }

    public final String getTEMPLPSPFSTYLEID() {
        return this.getParamStringValue(TAG_TEMPLPSPFSTYLEID, "");
    }

    public final void setTEMPLPSPFSTYLEID(String strValue) {
        this.setParamValue(TAG_TEMPLPSPFSTYLEID, strValue);
    }

    public final boolean isTEMPLPSPFSTYLENAMENull() {
        return this.isParamNull(TAG_TEMPLPSPFSTYLENAME);
    }

    public final String getTEMPLPSPFSTYLENAME() {
        return this.getParamStringValue(TAG_TEMPLPSPFSTYLENAME, "");
    }

    public final void setTEMPLPSPFSTYLENAME(String strValue) {
        this.setParamValue(TAG_TEMPLPSPFSTYLENAME, strValue);
    }

    public final boolean isSTYLECODENull() {
        return this.isParamNull(TAG_STYLECODE);
    }

    public final String getSTYLECODE() {
        return this.getParamStringValue(TAG_STYLECODE, "");
    }

    public final void setSTYLECODE(String strValue) {
        this.setParamValue(TAG_STYLECODE, strValue);
    }

    public final boolean isPFSTYLEPARAMNull() {
        return this.isParamNull(TAG_PFSTYLEPARAM);
    }

    public final String getPFSTYLEPARAM() {
        return this.getParamStringValue(TAG_PFSTYLEPARAM, "");
    }

    public final void setPFSTYLEPARAM(String strValue) {
        this.setParamValue(TAG_PFSTYLEPARAM, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.isParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.getParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.setParamValue(TAG_VERSION, nValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.isParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.getParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.isParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.getParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.isParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.getParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.isParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.getParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isLASTIMPTIMENull() {
        return this.isParamNull(TAG_LASTIMPTIME);
    }

    public final Date getLASTIMPTIME() {
        return this.getParamDateValue(TAG_LASTIMPTIME, null);
    }

    public final void setLASTIMPTIME(Date dtValue) {
        this.setParamValue(TAG_LASTIMPTIME, dtValue);
    }

    public final boolean isTEMPLSTATENull() {
        return this.isParamNull(TAG_TEMPLSTATE);
    }

    public final int getTEMPLSTATE() {
        return this.getParamIntValue(TAG_TEMPLSTATE, 0);
    }

    public final void setTEMPLSTATE(int nValue) {
        this.setParamValue(TAG_TEMPLSTATE, nValue);
    }

    public final boolean isTEMPLINFONull() {
        return this.isParamNull(TAG_TEMPLINFO);
    }

    public final String getTEMPLINFO() {
        return this.getParamStringValue(TAG_TEMPLINFO, "");
    }

    public final void setTEMPLINFO(String strValue) {
        this.setParamValue(TAG_TEMPLINFO, strValue);
    }

    public final boolean isVERSTRNull() {
        return this.isParamNull(TAG_VERSTR);
    }

    public final String getVERSTR() {
        return this.getParamStringValue(TAG_VERSTR, "");
    }

    public final void setVERSTR(String strValue) {
        this.setParamValue(TAG_VERSTR, strValue);
    }

    public final boolean isTEMPLROOTURLNull() {
        return this.isParamNull(TAG_TEMPLROOTURL);
    }

    public final String getTEMPLROOTURL() {
        return this.getParamStringValue(TAG_TEMPLROOTURL, "");
    }

    public final void setTEMPLROOTURL(String strValue) {
        this.setParamValue(TAG_TEMPLROOTURL, strValue);
    }

    public final boolean isSTYLERESURLNull() {
        return this.isParamNull(TAG_STYLERESURL);
    }

    public final String getSTYLERESURL() {
        return this.getParamStringValue(TAG_STYLERESURL, "");
    }

    public final void setSTYLERESURL(String strValue) {
        this.setParamValue(TAG_STYLERESURL, strValue);
    }

    public final boolean isCLSPKGPARAMSNull() {
        return this.isParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.getParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.setParamValue(TAG_CLSPKGPARAMS, strValue);
    }

    public final boolean isPKGINHERITMODENull() {
        return this.isParamNull(TAG_PKGINHERITMODE);
    }

    public final int getPKGINHERITMODE() {
        return this.getParamIntValue(TAG_PKGINHERITMODE, 0);
    }

    public final void setPKGINHERITMODE(int nValue) {
        this.setParamValue(TAG_PKGINHERITMODE, nValue);
    }
}

