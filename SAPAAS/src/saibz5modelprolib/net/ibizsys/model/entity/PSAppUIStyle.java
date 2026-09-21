/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppUIStyle
extends BaseDataEntity {
    public static final String UISTYLE_DEFAULT = "DEFAULT";
    public static final String UISTYLE_STYLE2 = "STYLE2";
    public static final String UISTYLE_STYLE3 = "STYLE3";
    public static final String UISTYLE_STYLE4 = "STYLE4";
    public static final String TAG_PSAPPUISTYLEID = "PSAPPUISTYLEID";
    public static final String TAG_PSAPPUISTYLENAME = "PSAPPUISTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_UISTYLE = "UISTYLE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_APPPKGNAME = "APPPKGNAME";
    public static final String TAG_APPFOLDER = "APPFOLDER";
    public static final String TAG_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String TAG_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String TAG_ROOTPSAPPVIEWID = "ROOTPSAPPVIEWID";
    public static final String TAG_ROOTPSAPPVIEWNAME = "ROOTPSAPPVIEWNAME";

    public final boolean isPSAPPUISTYLEIDNull() {
        return this.isParamNull(TAG_PSAPPUISTYLEID);
    }

    public final String getPSAPPUISTYLEID() {
        return this.getParamStringValue(TAG_PSAPPUISTYLEID, "");
    }

    public final void setPSAPPUISTYLEID(String strValue) {
        this.setParamValue(TAG_PSAPPUISTYLEID, strValue);
    }

    public final boolean isPSAPPUISTYLENAMENull() {
        return this.isParamNull(TAG_PSAPPUISTYLENAME);
    }

    public final String getPSAPPUISTYLENAME() {
        return this.getParamStringValue(TAG_PSAPPUISTYLENAME, "");
    }

    public final void setPSAPPUISTYLENAME(String strValue) {
        this.setParamValue(TAG_PSAPPUISTYLENAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.isParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.getParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.setParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.isParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.getParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.setParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isUISTYLENull() {
        return this.isParamNull(TAG_UISTYLE);
    }

    public final String getUISTYLE() {
        return this.getParamStringValue(TAG_UISTYLE, "");
    }

    public final void setUISTYLE(String strValue) {
        this.setParamValue(TAG_UISTYLE, strValue);
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

    public final boolean isAPPPKGNAMENull() {
        return this.isParamNull(TAG_APPPKGNAME);
    }

    public final String getAPPPKGNAME() {
        return this.getParamStringValue(TAG_APPPKGNAME, "");
    }

    public final void setAPPPKGNAME(String strValue) {
        this.setParamValue(TAG_APPPKGNAME, strValue);
    }

    public final boolean isAPPFOLDERNull() {
        return this.isParamNull(TAG_APPFOLDER);
    }

    public final String getAPPFOLDER() {
        return this.getParamStringValue(TAG_APPFOLDER, "");
    }

    public final void setAPPFOLDER(String strValue) {
        this.setParamValue(TAG_APPFOLDER, strValue);
    }

    public final boolean isMAINMENUSIDENull() {
        return this.isParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.getParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.setParamValue(TAG_MAINMENUSIDE, strValue);
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

    public final boolean isROOTPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_ROOTPSAPPVIEWID);
    }

    public final String getROOTPSAPPVIEWID() {
        return this.getParamStringValue(TAG_ROOTPSAPPVIEWID, "");
    }

    public final void setROOTPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_ROOTPSAPPVIEWID, strValue);
    }

    public final boolean isROOTPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_ROOTPSAPPVIEWNAME);
    }

    public final String getROOTPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_ROOTPSAPPVIEWNAME, "");
    }

    public final void setROOTPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_ROOTPSAPPVIEWNAME, strValue);
    }
}

