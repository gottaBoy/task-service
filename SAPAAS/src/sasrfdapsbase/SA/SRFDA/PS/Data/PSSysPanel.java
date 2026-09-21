/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysPanel
extends BaseDataEntity {
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_PANELMODEL = "PANELMODEL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PANELWIDTH = "PANELWIDTH";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PANELSTYLE = "PANELSTYLE";
    public static final String TAG_MOBFLAG = "MOBFLAG";
    public static final String TAG_VIEWLAYOUTFLAG = "VIEWLAYOUTFLAG";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String TAG_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";
    public static final String TAG_NAVBARPOS = "NAVBARPOS";
    public static final String TAG_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String TAG_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String TAG_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String TAG_PANELNAVBAR = "PANELNAVBAR";
    public static final String TAG_GETPSDEACTIONID = "GETPSDEACTIONID";
    public static final String TAG_GETPSDEACTIONNAME = "GETPSDEACTIONNAME";
    public static final String TAG_GETDATAMODE = "GETDATAMODE";
    public static final String TAG_GETDATATIMER = "GETDATATIMER";
    public static final String TAG_BODYONLYFLAG = "BODYONLYFLAG";
    public static final String TAG_DATANAME = "DATANAME";

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.IsParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.GetParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
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

    public final boolean isTODOTASKNull() {
        return this.IsParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.GetParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.SetParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isPANELMODELNull() {
        return this.IsParamNull(TAG_PANELMODEL);
    }

    public final String getPANELMODEL() {
        return this.GetParamStringValue(TAG_PANELMODEL, "");
    }

    public final void setPANELMODEL(String strValue) {
        this.SetParamValue(TAG_PANELMODEL, strValue);
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

    public final boolean isPANELWIDTHNull() {
        return this.IsParamNull(TAG_PANELWIDTH);
    }

    public final int getPANELWIDTH() {
        return this.GetParamIntValue(TAG_PANELWIDTH, 0);
    }

    public final void setPANELWIDTH(int nValue) {
        this.SetParamValue(TAG_PANELWIDTH, nValue);
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

    public final boolean isPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.GetParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_PSACHANDLERNAME, strValue);
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

    public final boolean isPANELSTYLENull() {
        return this.IsParamNull(TAG_PANELSTYLE);
    }

    public final String getPANELSTYLE() {
        return this.GetParamStringValue(TAG_PANELSTYLE, "");
    }

    public final void setPANELSTYLE(String strValue) {
        this.SetParamValue(TAG_PANELSTYLE, strValue);
    }

    public final boolean isMOBFLAGNull() {
        return this.IsParamNull(TAG_MOBFLAG);
    }

    public final boolean getMOBFLAG() {
        return this.GetParamIntValue(TAG_MOBFLAG, 0) == 1;
    }

    public final void setMOBFLAG(boolean bValue) {
        this.SetParamValue(TAG_MOBFLAG, bValue ? 1 : 0);
    }

    public final boolean isVIEWLAYOUTFLAGNull() {
        return this.IsParamNull(TAG_VIEWLAYOUTFLAG);
    }

    public final int getVIEWLAYOUTFLAG() {
        return this.GetParamIntValue(TAG_VIEWLAYOUTFLAG, 0);
    }

    public final void setVIEWLAYOUTFLAG(int bValue) {
        this.SetParamValue(TAG_VIEWLAYOUTFLAG, bValue);
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

    public final boolean isNAVBARHEIGHTNull() {
        return this.IsParamNull(TAG_NAVBARHEIGHT);
    }

    public final int getNAVBARHEIGHT() {
        return this.GetParamIntValue(TAG_NAVBARHEIGHT, 0);
    }

    public final void setNAVBARHEIGHT(int nValue) {
        this.SetParamValue(TAG_NAVBARHEIGHT, nValue);
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

    public final boolean isPANELNAVBARNull() {
        return this.IsParamNull(TAG_PANELNAVBAR);
    }

    public final boolean getPANELNAVBAR() {
        return this.GetParamIntValue(TAG_PANELNAVBAR, 0) == 1;
    }

    public final void setPANELNAVBAR(boolean bValue) {
        this.SetParamValue(TAG_PANELNAVBAR, bValue ? 1 : 0);
    }

    public final boolean isGETPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_GETPSDEACTIONID);
    }

    public final String getGETPSDEACTIONID() {
        return this.GetParamStringValue(TAG_GETPSDEACTIONID, "");
    }

    public final void setGETPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_GETPSDEACTIONID, strValue);
    }

    public final boolean isGETPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_GETPSDEACTIONNAME);
    }

    public final String getGETPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_GETPSDEACTIONNAME, "");
    }

    public final void setGETPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_GETPSDEACTIONNAME, strValue);
    }

    public final boolean isGETDATAMODENull() {
        return this.IsParamNull(TAG_GETDATAMODE);
    }

    public final int getGETDATAMODE() {
        return this.GetParamIntValue(TAG_GETDATAMODE, 0);
    }

    public final void setGETDATAMODE(int nValue) {
        this.SetParamValue(TAG_GETDATAMODE, nValue);
    }

    public final boolean isGETDATATIMERNull() {
        return this.IsParamNull(TAG_GETDATATIMER);
    }

    public final int getGETDATATIMER() {
        return this.GetParamIntValue(TAG_GETDATATIMER, 0);
    }

    public final void setGETDATATIMER(int nValue) {
        this.SetParamValue(TAG_GETDATATIMER, nValue);
    }

    public final boolean isBODYONLYFLAGNull() {
        return this.IsParamNull(TAG_BODYONLYFLAG);
    }

    public final boolean getBODYONLYFLAG() {
        return this.GetParamIntValue(TAG_BODYONLYFLAG, 0) == 1;
    }

    public final void setBODYONLYFLAG(boolean bValue) {
        this.SetParamValue(TAG_BODYONLYFLAG, bValue ? 1 : 0);
    }

    public final boolean isDATANAMENull() {
        return this.IsParamNull(TAG_DATANAME);
    }

    public final String getDATANAME() {
        return this.GetParamStringValue(TAG_DATANAME, "");
    }

    public final void setDATANAME(String strValue) {
        this.SetParamValue(TAG_DATANAME, strValue);
    }
}

