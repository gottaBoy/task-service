/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysPortlet
extends BaseDataEntity {
    public static final String PORTLETTYPE_CHART = "CHART";
    public static final String PORTLETTYPE_LIST = "LIST";
    public static final String PORTLETTYPE_CUSTOM = "CUSTOM";
    public static final String PORTLETTYPE_VIEW = "VIEW";
    public static final String PORTLETTYPE_HTML = "HTML";
    public static final String PORTLETTYPE_APPMENU = "APPMENU";
    public static final String PORTLETTYPE_INFO = "INFO";
    public static final String PORTLETTYPE_EDITFORM = "EDITFORM";
    public static final String PORTLETTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String HTMLSHOWMODE_INNER = "INNER";
    public static final String HTMLSHOWMODE_IFRAME = "IFRAME";
    public static final String GROUPEXTRACTMODE_ITEM = "ITEM";
    public static final String GROUPEXTRACTMODE_ITEMS = "ITEMS";
    public static final int DASHBOARDSCOPE_APP = 1;
    public static final int DASHBOARDSCOPE_DE = 2;
    public static final int DASHBOARDSCOPE_APPAndDE = 3;
    public static final String TEMPLENGINE_DEFAULT = "DEFAULT";
    public static final String TEMPLENGINE_V2 = "V2";
    public static final String TAG_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String TAG_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PORTLETTYPE = "PORTLETTYPE";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSDEVIEWID = "PSDEVIEWID";
    public static final String TAG_PSDEVIEWNAME = "PSDEVIEWNAME";
    public static final String TAG_HTMLURL = "HTMLURL";
    public static final String TAG_RELOADTIMER = "RELOADTIMER";
    public static final String TAG_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String TAG_TITLEPSSYSPFPLUGINID = "TITLEPSSYSPFPLUGINID";
    public static final String TAG_TITLEPSSYSPFPLUGINNAME = "TITLEPSSYSPFPLUGINNAME";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_HTMLSHOWMODE = "HTMLSHOWMODE";
    public static final String TAG_EMPTYTEXT = "EMPTYTEXT";
    public static final String TAG_EMPTYTEXTPSLANRESID = "EMPTYTEXTPSLANRESID";
    public static final String TAG_EMPTYTEXTPSLANRESNAME = "EMPTYTEXTPSLANRESNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSSYSPORTLETCATID = "PSSYSPORTLETCATID";
    public static final String TAG_PSSYSPORTLETCATNAME = "PSSYSPORTLETCATNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_DEDASHBOARDONLY = "DEDASHBOARDONLY";
    public static final String TAG_GROUPEXTRACTMODE = "GROUPEXTRACTMODE";
    public static final String TAG_DASHBOARDSCOPE = "DASHBOARDSCOPE";
    public static final String TAG_PORTLETSTYLE = "PORTLETSTYLE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PORTLETPARAMS = "PORTLETPARAMS";
    public static final String TAG_TEMPLENGINE = "TEMPLENGINE";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_PSDEREPORTID = "PSDEREPORTID";
    public static final String TAG_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String TAG_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String TAG_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String TAG_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String TAG_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String TAG_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String TAG_FILTERPSDEDSID = "FILTERPSDEDSID";
    public static final String TAG_FILTERPSDEDSNAME = "FILTERPSDEDSNAME";

    public final boolean isPSSYSPORTLETIDNull() {
        return this.IsParamNull(TAG_PSSYSPORTLETID);
    }

    public final String getPSSYSPORTLETID() {
        return this.GetParamStringValue(TAG_PSSYSPORTLETID, "");
    }

    public final void setPSSYSPORTLETID(String strValue) {
        this.SetParamValue(TAG_PSSYSPORTLETID, strValue);
    }

    public final boolean isPSSYSPORTLETNAMENull() {
        return this.IsParamNull(TAG_PSSYSPORTLETNAME);
    }

    public final String getPSSYSPORTLETNAME() {
        return this.GetParamStringValue(TAG_PSSYSPORTLETNAME, "");
    }

    public final void setPSSYSPORTLETNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPORTLETNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isPORTLETTYPENull() {
        return this.IsParamNull(TAG_PORTLETTYPE);
    }

    public final String getPORTLETTYPE() {
        return this.GetParamStringValue(TAG_PORTLETTYPE, "");
    }

    public final void setPORTLETTYPE(String strValue) {
        this.SetParamValue(TAG_PORTLETTYPE, strValue);
    }

    public final boolean isPSDECHARTIDNull() {
        return this.IsParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.GetParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.SetParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.IsParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.GetParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.SetParamValue(TAG_PSDECHARTNAME, strValue);
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

    public final boolean isPSDELISTIDNull() {
        return this.IsParamNull(TAG_PSDELISTID);
    }

    public final String getPSDELISTID() {
        return this.GetParamStringValue(TAG_PSDELISTID, "");
    }

    public final void setPSDELISTID(String strValue) {
        this.SetParamValue(TAG_PSDELISTID, strValue);
    }

    public final boolean isPSDELISTNAMENull() {
        return this.IsParamNull(TAG_PSDELISTNAME);
    }

    public final String getPSDELISTNAME() {
        return this.GetParamStringValue(TAG_PSDELISTNAME, "");
    }

    public final void setPSDELISTNAME(String strValue) {
        this.SetParamValue(TAG_PSDELISTNAME, strValue);
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

    public final boolean isPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWID);
    }

    public final String getPSDEVIEWID() {
        return this.GetParamStringValue(TAG_PSDEVIEWID, "");
    }

    public final void setPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWID, strValue);
    }

    public final boolean isPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWNAME);
    }

    public final String getPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWNAME, "");
    }

    public final void setPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWNAME, strValue);
    }

    public final boolean isHTMLURLNull() {
        return this.IsParamNull(TAG_HTMLURL);
    }

    public final String getHTMLURL() {
        return this.GetParamStringValue(TAG_HTMLURL, "");
    }

    public final void setHTMLURL(String strValue) {
        this.SetParamValue(TAG_HTMLURL, strValue);
    }

    public final boolean isRELOADTIMERNull() {
        return this.IsParamNull(TAG_RELOADTIMER);
    }

    public final int getRELOADTIMER() {
        return this.GetParamIntValue(TAG_RELOADTIMER, 0);
    }

    public final void setRELOADTIMER(int nValue) {
        this.SetParamValue(TAG_RELOADTIMER, nValue);
    }

    public final boolean isSHOWTITLEBARNull() {
        return this.IsParamNull(TAG_SHOWTITLEBAR);
    }

    public final boolean getSHOWTITLEBAR() {
        return this.GetParamIntValue(TAG_SHOWTITLEBAR, 0) == 1;
    }

    public final void setSHOWTITLEBAR(boolean bValue) {
        this.SetParamValue(TAG_SHOWTITLEBAR, bValue ? 1 : 0);
    }

    public final boolean isTITLEPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_TITLEPSSYSPFPLUGINID);
    }

    public final String getTITLEPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_TITLEPSSYSPFPLUGINID, "");
    }

    public final void setTITLEPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_TITLEPSSYSPFPLUGINID, strValue);
    }

    public final boolean isTITLEPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_TITLEPSSYSPFPLUGINNAME);
    }

    public final String getTITLEPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_TITLEPSSYSPFPLUGINNAME, "");
    }

    public final void setTITLEPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.IsParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.GetParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.SetParamValue(TAG_BASECLSPARAMS, strValue);
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSREQITEMNAME, strValue);
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

    public final boolean isTITLEPSLANRESIDNull() {
        return this.IsParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_TITLEPSLANRESNAME, strValue);
    }

    public final boolean isHTMLSHOWMODENull() {
        return this.IsParamNull(TAG_HTMLSHOWMODE);
    }

    public final String getHTMLSHOWMODE() {
        return this.GetParamStringValue(TAG_HTMLSHOWMODE, "");
    }

    public final void setHTMLSHOWMODE(String strValue) {
        this.SetParamValue(TAG_HTMLSHOWMODE, strValue);
    }

    public final boolean isEMPTYTEXTNull() {
        return this.IsParamNull(TAG_EMPTYTEXT);
    }

    public final String getEMPTYTEXT() {
        return this.GetParamStringValue(TAG_EMPTYTEXT, "");
    }

    public final void setEMPTYTEXT(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXT, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESID);
    }

    public final String getEMPTYTEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESID, "");
    }

    public final void setEMPTYTEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESID, strValue);
    }

    public final boolean isEMPTYTEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_EMPTYTEXTPSLANRESNAME);
    }

    public final String getEMPTYTEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_EMPTYTEXTPSLANRESNAME, "");
    }

    public final void setEMPTYTEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_EMPTYTEXTPSLANRESNAME, strValue);
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

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isADPSDELOGICIDNull() {
        return this.IsParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.GetParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.IsParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.GetParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.SetParamValue(TAG_ADPSDELOGICNAME, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.IsParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.IsParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.GetParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isPSSYSPORTLETCATIDNull() {
        return this.IsParamNull(TAG_PSSYSPORTLETCATID);
    }

    public final String getPSSYSPORTLETCATID() {
        return this.GetParamStringValue(TAG_PSSYSPORTLETCATID, "");
    }

    public final void setPSSYSPORTLETCATID(String strValue) {
        this.SetParamValue(TAG_PSSYSPORTLETCATID, strValue);
    }

    public final boolean isPSSYSPORTLETCATNAMENull() {
        return this.IsParamNull(TAG_PSSYSPORTLETCATNAME);
    }

    public final String getPSSYSPORTLETCATNAME() {
        return this.GetParamStringValue(TAG_PSSYSPORTLETCATNAME, "");
    }

    public final void setPSSYSPORTLETCATNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPORTLETCATNAME, strValue);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isGROUPEXTRACTMODENull() {
        return this.IsParamNull(TAG_GROUPEXTRACTMODE);
    }

    public final String getGROUPEXTRACTMODE() {
        return this.GetParamStringValue(TAG_GROUPEXTRACTMODE, "");
    }

    public final void setGROUPEXTRACTMODE(String strValue) {
        this.SetParamValue(TAG_GROUPEXTRACTMODE, strValue);
    }

    public final boolean isDASHBOARDSCOPENull() {
        return this.IsParamNull(TAG_DASHBOARDSCOPE);
    }

    public final int getDASHBOARDSCOPE() {
        return this.GetParamIntValue(TAG_DASHBOARDSCOPE, 0);
    }

    public final void setDASHBOARDSCOPE(int nValue) {
        this.SetParamValue(TAG_DASHBOARDSCOPE, nValue);
    }

    public final boolean isPORTLETSTYLENull() {
        return this.IsParamNull(TAG_PORTLETSTYLE);
    }

    public final String getPORTLETSTYLE() {
        return this.GetParamStringValue(TAG_PORTLETSTYLE, "");
    }

    public final void setPORTLETSTYLE(String strValue) {
        this.SetParamValue(TAG_PORTLETSTYLE, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isPORTLETPARAMSNull() {
        return this.IsParamNull(TAG_PORTLETPARAMS);
    }

    public final String getPORTLETPARAMS() {
        return this.GetParamStringValue(TAG_PORTLETPARAMS, "");
    }

    public final void setPORTLETPARAMS(String strValue) {
        this.SetParamValue(TAG_PORTLETPARAMS, strValue);
    }

    public final boolean isTEMPLENGINENull() {
        return this.IsParamNull(TAG_TEMPLENGINE);
    }

    public final String getTEMPLENGINE() {
        return this.GetParamStringValue(TAG_TEMPLENGINE, "");
    }

    public final void setTEMPLENGINE(String strValue) {
        this.SetParamValue(TAG_TEMPLENGINE, strValue);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
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

    public final boolean isPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARNAME, strValue);
    }

    public final boolean isPSDEREPORTIDNull() {
        return this.IsParamNull(TAG_PSDEREPORTID);
    }

    public final String getPSDEREPORTID() {
        return this.GetParamStringValue(TAG_PSDEREPORTID, "");
    }

    public final void setPSDEREPORTID(String strValue) {
        this.SetParamValue(TAG_PSDEREPORTID, strValue);
    }

    public final boolean isPSDEREPORTNAMENull() {
        return this.IsParamNull(TAG_PSDEREPORTNAME);
    }

    public final String getPSDEREPORTNAME() {
        return this.GetParamStringValue(TAG_PSDEREPORTNAME, "");
    }

    public final void setPSDEREPORTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEREPORTNAME, strValue);
    }

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

    public final boolean isPSDEDATAVIEWIDNull() {
        return this.IsParamNull(TAG_PSDEDATAVIEWID);
    }

    public final String getPSDEDATAVIEWID() {
        return this.GetParamStringValue(TAG_PSDEDATAVIEWID, "");
    }

    public final void setPSDEDATAVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAVIEWID, strValue);
    }

    public final boolean isPSDEDATAVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAVIEWNAME);
    }

    public final String getPSDEDATAVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAVIEWNAME, "");
    }

    public final void setPSDEDATAVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAVIEWNAME, strValue);
    }

    public final boolean isPSSYSCALENDARIDNull() {
        return this.IsParamNull(TAG_PSSYSCALENDARID);
    }

    public final String getPSSYSCALENDARID() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARID, "");
    }

    public final void setPSSYSCALENDARID(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARID, strValue);
    }

    public final boolean isPSSYSCALENDARNAMENull() {
        return this.IsParamNull(TAG_PSSYSCALENDARNAME);
    }

    public final String getPSSYSCALENDARNAME() {
        return this.GetParamStringValue(TAG_PSSYSCALENDARNAME, "");
    }

    public final void setPSSYSCALENDARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCALENDARNAME, strValue);
    }

    public final boolean isPSSYSMAPVIEWIDNull() {
        return this.IsParamNull(TAG_PSSYSMAPVIEWID);
    }

    public final String getPSSYSMAPVIEWID() {
        return this.GetParamStringValue(TAG_PSSYSMAPVIEWID, "");
    }

    public final void setPSSYSMAPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSYSMAPVIEWID, strValue);
    }

    public final boolean isPSSYSMAPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSYSMAPVIEWNAME);
    }

    public final String getPSSYSMAPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSYSMAPVIEWNAME, "");
    }

    public final void setPSSYSMAPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMAPVIEWNAME, strValue);
    }

    public final boolean isFILTERPSDEDSIDNull() {
        return this.IsParamNull(TAG_FILTERPSDEDSID);
    }

    public final String getFILTERPSDEDSID() {
        return this.GetParamStringValue(TAG_FILTERPSDEDSID, "");
    }

    public final void setFILTERPSDEDSID(String strValue) {
        this.SetParamValue(TAG_FILTERPSDEDSID, strValue);
    }

    public final boolean isFILTERPSDEDSNAMENull() {
        return this.IsParamNull(TAG_FILTERPSDEDSNAME);
    }

    public final String getFILTERPSDEDSNAME() {
        return this.GetParamStringValue(TAG_FILTERPSDEDSNAME, "");
    }

    public final void setFILTERPSDEDSNAME(String strValue) {
        this.SetParamValue(TAG_FILTERPSDEDSNAME, strValue);
    }
}

