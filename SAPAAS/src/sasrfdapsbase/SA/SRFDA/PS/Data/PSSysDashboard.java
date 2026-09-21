/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDashboard
extends BaseDataEntity {
    public static final String TAG_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String TAG_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_COLMODEL = "COLMODEL";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_DBMODEL = "DBMODEL";
    public static final String TAG_FLEXALIGN = "FLEXALIGN";
    public static final String TAG_FLEXDIR = "FLEXDIR";
    public static final String TAG_FLEXVALIGN = "FLEXVALIGN";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_DASHBOARDSTYLE = "DASHBOARDSTYLE";
    public static final String TAG_DASHBOARDTAG = "DASHBOARDTAG";
    public static final String TAG_DASHBOARDTAG2 = "DASHBOARDTAG2";
    public static final String TAG_DASHBOARDNAVBAR = "DASHBOARDNAVBAR";
    public static final String TAG_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String TAG_NAVBARPOS = "NAVBARPOS";
    public static final String TAG_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String TAG_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String TAG_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String TAG_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";

    public final boolean isPSSYSDASHBOARDIDNull() {
        return this.IsParamNull(TAG_PSSYSDASHBOARDID);
    }

    public final String getPSSYSDASHBOARDID() {
        return this.GetParamStringValue(TAG_PSSYSDASHBOARDID, "");
    }

    public final void setPSSYSDASHBOARDID(String strValue) {
        this.SetParamValue(TAG_PSSYSDASHBOARDID, strValue);
    }

    public final boolean isPSSYSDASHBOARDNAMENull() {
        return this.IsParamNull(TAG_PSSYSDASHBOARDNAME);
    }

    public final String getPSSYSDASHBOARDNAME() {
        return this.GetParamStringValue(TAG_PSSYSDASHBOARDNAME, "");
    }

    public final void setPSSYSDASHBOARDNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDASHBOARDNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isCOLMODELNull() {
        return this.IsParamNull(TAG_COLMODEL);
    }

    public final String getCOLMODEL() {
        return this.GetParamStringValue(TAG_COLMODEL, "");
    }

    public final void setCOLMODEL(String strValue) {
        this.SetParamValue(TAG_COLMODEL, strValue);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isLAYOUTMODENull() {
        return this.IsParamNull(TAG_LAYOUTMODE);
    }

    public final String getLAYOUTMODE() {
        return this.GetParamStringValue(TAG_LAYOUTMODE, "");
    }

    public final void setLAYOUTMODE(String strValue) {
        this.SetParamValue(TAG_LAYOUTMODE, strValue);
    }

    public final boolean isDBMODELNull() {
        return this.IsParamNull(TAG_DBMODEL);
    }

    public final String getDBMODEL() {
        return this.GetParamStringValue(TAG_DBMODEL, "");
    }

    public final void setDBMODEL(String strValue) {
        this.SetParamValue(TAG_DBMODEL, strValue);
    }

    public final boolean isFLEXALIGNNull() {
        return this.IsParamNull(TAG_FLEXALIGN);
    }

    public final String getFLEXALIGN() {
        return this.GetParamStringValue(TAG_FLEXALIGN, "");
    }

    public final void setFLEXALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXALIGN, strValue);
    }

    public final boolean isFLEXDIRNull() {
        return this.IsParamNull(TAG_FLEXDIR);
    }

    public final String getFLEXDIR() {
        return this.GetParamStringValue(TAG_FLEXDIR, "");
    }

    public final void setFLEXDIR(String strValue) {
        this.SetParamValue(TAG_FLEXDIR, strValue);
    }

    public final boolean isFLEXVALIGNNull() {
        return this.IsParamNull(TAG_FLEXVALIGN);
    }

    public final String getFLEXVALIGN() {
        return this.GetParamStringValue(TAG_FLEXVALIGN, "");
    }

    public final void setFLEXVALIGN(String strValue) {
        this.SetParamValue(TAG_FLEXVALIGN, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPIDNull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPID);
    }

    public final String getPSCTRLLOGICGROUPID() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPID, "");
    }

    public final void setPSCTRLLOGICGROUPID(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPID, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPNAMENull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPNAME);
    }

    public final String getPSCTRLLOGICGROUPNAME() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPNAME, "");
    }

    public final void setPSCTRLLOGICGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPNAME, strValue);
    }

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isENABLECUSTOMIZEDNull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZED);
    }

    public final int getENABLECUSTOMIZED() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZED, 0);
    }

    public final void setENABLECUSTOMIZED(int bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZED, bValue);
    }

    public final boolean isPSVIEWMSGGROUPIDNull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPID);
    }

    public final String getPSVIEWMSGGROUPID() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPID, "");
    }

    public final void setPSVIEWMSGGROUPID(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPID, strValue);
    }

    public final boolean isPSVIEWMSGGROUPNAMENull() {
        return this.IsParamNull(TAG_PSVIEWMSGGROUPNAME);
    }

    public final String getPSVIEWMSGGROUPNAME() {
        return this.GetParamStringValue(TAG_PSVIEWMSGGROUPNAME, "");
    }

    public final void setPSVIEWMSGGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWMSGGROUPNAME, strValue);
    }

    public final boolean isDASHBOARDSTYLENull() {
        return this.IsParamNull(TAG_DASHBOARDSTYLE);
    }

    public final String getDASHBOARDSTYLE() {
        return this.GetParamStringValue(TAG_DASHBOARDSTYLE, "");
    }

    public final void setDASHBOARDSTYLE(String strValue) {
        this.SetParamValue(TAG_DASHBOARDSTYLE, strValue);
    }

    public final boolean isDASHBOARDTAGNull() {
        return this.IsParamNull(TAG_DASHBOARDTAG);
    }

    public final String getDASHBOARDTAG() {
        return this.GetParamStringValue(TAG_DASHBOARDTAG, "");
    }

    public final void setDASHBOARDTAG(String strValue) {
        this.SetParamValue(TAG_DASHBOARDTAG, strValue);
    }

    public final boolean isDASHBOARDTAG2Null() {
        return this.IsParamNull(TAG_DASHBOARDTAG2);
    }

    public final String getDASHBOARDTAG2() {
        return this.GetParamStringValue(TAG_DASHBOARDTAG2, "");
    }

    public final void setDASHBOARDTAG2(String strValue) {
        this.SetParamValue(TAG_DASHBOARDTAG2, strValue);
    }

    public final boolean isDASHBOARDNAVBARNull() {
        return this.IsParamNull(TAG_DASHBOARDNAVBAR);
    }

    public final boolean getDASHBOARDNAVBAR() {
        return this.GetParamIntValue(TAG_DASHBOARDNAVBAR, 0) == 1;
    }

    public final void setDASHBOARDNAVBAR(boolean bValue) {
        this.SetParamValue(TAG_DASHBOARDNAVBAR, bValue ? 1 : 0);
    }

    public final boolean isNAVBARHEIGHTNull() {
        return this.IsParamNull(TAG_NAVBARHEIGHT);
    }

    public final int getNAVBARHEIGHT() {
        return this.GetParamIntValue(TAG_NAVBARHEIGHT, 0);
    }

    public final void setNAVBARHEIGHT(int nValue) {
        this.SetParamValue(TAG_NAVBARHEIGHT, nValue);
    }

    public final boolean isNAVBARPOSNull() {
        return this.IsParamNull(TAG_NAVBARPOS);
    }

    public final String getNAVBARPOS() {
        return this.GetParamStringValue(TAG_NAVBARPOS, "");
    }

    public final void setNAVBARPOS(String strValue) {
        this.SetParamValue(TAG_NAVBARPOS, strValue);
    }

    public final boolean isNAVBARSTYLENull() {
        return this.IsParamNull(TAG_NAVBARSTYLE);
    }

    public final String getNAVBARSTYLE() {
        return this.GetParamStringValue(TAG_NAVBARSTYLE, "");
    }

    public final void setNAVBARSTYLE(String strValue) {
        this.SetParamValue(TAG_NAVBARSTYLE, strValue);
    }

    public final boolean isNAVBARWIDTHNull() {
        return this.IsParamNull(TAG_NAVBARWIDTH);
    }

    public final int getNAVBARWIDTH() {
        return this.GetParamIntValue(TAG_NAVBARWIDTH, 0);
    }

    public final void setNAVBARWIDTH(int nValue) {
        this.SetParamValue(TAG_NAVBARWIDTH, nValue);
    }

    public final boolean isNAVBARPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_NAVBARPSSYSCSSID);
    }

    public final String getNAVBARPSSYSCSSID() {
        return this.GetParamStringValue(TAG_NAVBARPSSYSCSSID, "");
    }

    public final void setNAVBARPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_NAVBARPSSYSCSSID, strValue);
    }

    public final boolean isNAVBARPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_NAVBARPSSYSCSSNAME);
    }

    public final String getNAVBARPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_NAVBARPSSYSCSSNAME, "");
    }

    public final void setNAVBARPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_NAVBARPSSYSCSSNAME, strValue);
    }
}

