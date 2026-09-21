/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
        return this.IsParamNull(TAG_PSAPPUISTYLEID);
    }

    public final String getPSAPPUISTYLEID() {
        return this.GetParamStringValue(TAG_PSAPPUISTYLEID, "");
    }

    public final void setPSAPPUISTYLEID(String strValue) {
        this.SetParamValue(TAG_PSAPPUISTYLEID, strValue);
    }

    public final boolean isPSAPPUISTYLENAMENull() {
        return this.IsParamNull(TAG_PSAPPUISTYLENAME);
    }

    public final String getPSAPPUISTYLENAME() {
        return this.GetParamStringValue(TAG_PSAPPUISTYLENAME, "");
    }

    public final void setPSAPPUISTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPUISTYLENAME, strValue);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
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

    public final boolean isUISTYLENull() {
        return this.IsParamNull(TAG_UISTYLE);
    }

    public final String getUISTYLE() {
        return this.GetParamStringValue(TAG_UISTYLE, "");
    }

    public final void setUISTYLE(String strValue) {
        this.SetParamValue(TAG_UISTYLE, strValue);
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

    public final boolean isAPPPKGNAMENull() {
        return this.IsParamNull(TAG_APPPKGNAME);
    }

    public final String getAPPPKGNAME() {
        return this.GetParamStringValue(TAG_APPPKGNAME, "");
    }

    public final void setAPPPKGNAME(String strValue) {
        this.SetParamValue(TAG_APPPKGNAME, strValue);
    }

    public final boolean isAPPFOLDERNull() {
        return this.IsParamNull(TAG_APPFOLDER);
    }

    public final String getAPPFOLDER() {
        return this.GetParamStringValue(TAG_APPFOLDER, "");
    }

    public final void setAPPFOLDER(String strValue) {
        this.SetParamValue(TAG_APPFOLDER, strValue);
    }

    public final boolean isMAINMENUSIDENull() {
        return this.IsParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.GetParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.SetParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isPFSTYLEPARAMNull() {
        return this.IsParamNull(TAG_PFSTYLEPARAM);
    }

    public final String getPFSTYLEPARAM() {
        return this.GetParamStringValue(TAG_PFSTYLEPARAM, "");
    }

    public final void setPFSTYLEPARAM(String strValue) {
        this.SetParamValue(TAG_PFSTYLEPARAM, strValue);
    }

    public final boolean isROOTPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_ROOTPSAPPVIEWID);
    }

    public final String getROOTPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_ROOTPSAPPVIEWID, "");
    }

    public final void setROOTPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_ROOTPSAPPVIEWID, strValue);
    }

    public final boolean isROOTPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_ROOTPSAPPVIEWNAME);
    }

    public final String getROOTPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_ROOTPSAPPVIEWNAME, "");
    }

    public final void setROOTPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_ROOTPSAPPVIEWNAME, strValue);
    }
}

