/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEViewCtrl
extends BaseDataEntity {
    public static final String PSDEVIEWCTRLTYPE_TOOLBAR = "TOOLBAR";
    public static final String PSDEVIEWCTRLTYPE_GRID = "GRID";
    public static final String PSDEVIEWCTRLTYPE_FORM = "FORM";
    public static final String PSDEVIEWCTRLTYPE_SEARCHFORM = "SEARCHFORM";
    public static final String PSDEVIEWCTRLTYPE_DRBAR = "DRBAR";
    public static final String PSDEVIEWCTRLTYPE_VIEWPANEL = "VIEWPANEL";
    public static final String PSDEVIEWCTRLTYPE_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    public static final String PSDEVIEWCTRLTYPE_DATAVIEW = "DATAVIEW";
    public static final String PSDEVIEWCTRLTYPE_CHART = "CHART";
    public static final String PSDEVIEWCTRLTYPE_REPORTPANEL = "REPORTPANEL";
    public static final String PSDEVIEWCTRLTYPE_LIST = "LIST";
    public static final String PSDEVIEWCTRLTYPE_PANEL = "PANEL";
    public static final String PSDEVIEWCTRLTYPE_DASHBOARD = "DASHBOARD";
    public static final String PSDEVIEWCTRLTYPE_VIEWLAYOUTPANEL = "VIEWLAYOUTPANEL";
    public static final String PSDEVIEWCTRLTYPE_MAP = "MAP";
    public static final String TAG_PSDEVIEWCTRLID = "PSDEVIEWCTRLID";
    public static final String TAG_PSDEVIEWCTRLNAME = "PSDEVIEWCTRLNAME";
    public static final String TAG_PSDEVIEWCTRLTYPE = "PSDEVIEWCTRLTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_MARGIN = "MARGIN";
    public static final String TAG_PADDING = "PADDING";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_PSDEDATASETID = "PSDEDATASETID";
    public static final String TAG_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_PSDEDRID = "PSDEDRID";
    public static final String TAG_PSDEDRNAME = "PSDEDRNAME";
    public static final String TAG_CONFIGINFO = "CONFIGINFO";
    public static final String TAG_PSDEVIEWID = "PSDEVIEWID";
    public static final String TAG_PSDEVIEWNAME = "PSDEVIEWNAME";
    public static final String TAG_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String TAG_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String TAG_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String TAG_NO3PSDEUAGROUPID = "NO3PSDEUAGROUPID";
    public static final String TAG_NO3PSDEUAGROUPNAME = "NO3PSDEUAGROUPNAME";
    public static final String TAG_NO4PSDEUAGROUPID = "NO4PSDEUAGROUPID";
    public static final String TAG_NO4PSDEUAGROUPNAME = "NO4PSDEUAGROUPNAME";
    public static final String TAG_NO5PSDEUAGROUPID = "NO5PSDEUAGROUPID";
    public static final String TAG_NO5PSDEUAGROUPNAME = "NO5PSDEUAGROUPNAME";
    public static final String TAG_NO6PSDEUAGROUPID = "NO6PSDEUAGROUPID";
    public static final String TAG_NO6PSDEUAGROUPNAME = "NO6PSDEUAGROUPNAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_CTRLPARAMS = "CTRLPARAMS";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_CTRLPSDEID = "CTRLPSDEID";
    public static final String TAG_CTRLPSDENAME = "CTRLPSDENAME";
    public static final String TAG_MULTISELECT = "MULTISELECT";
    public static final String TAG_SUBPSACHANDLERID = "SUBPSACHANDLERID";
    public static final String TAG_SUBPSACHANDLERNAME = "SUBPSACHANDLERNAME";
    public static final String TAG_PSDECHARTID = "PSDECHARTID";
    public static final String TAG_PSDECHARTNAME = "PSDECHARTNAME";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_PSDEREPORTID = "PSDEREPORTID";
    public static final String TAG_PSDEREPORTNAME = "PSDEREPORTNAME";
    public static final String TAG_PSDELISTID = "PSDELISTID";
    public static final String TAG_PSDELISTNAME = "PSDELISTNAME";
    public static final String TAG_CTRLPARAM = "CTRLPARAM";
    public static final String TAG_CTRLPARAM2 = "CTRLPARAM2";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_CTRLPARAM3 = "CTRLPARAM3";
    public static final String TAG_CTRLPARAM4 = "CTRLPARAM4";
    public static final String TAG_CTRLPARAM5 = "CTRLPARAM5";
    public static final String TAG_CTRLPARAM6 = "CTRLPARAM6";
    public static final String TAG_CTRLPARAM7 = "CTRLPARAM7";
    public static final String TAG_CTRLPARAM8 = "CTRLPARAM8";
    public static final String TAG_CTRLPARAM9 = "CTRLPARAM9";
    public static final String TAG_CTRLPARAM10 = "CTRLPARAM10";
    public static final String TAG_CTRLPARAM11 = "CTRLPARAM11";
    public static final String TAG_CTRLPARAM12 = "CTRLPARAM12";
    public static final String TAG_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String TAG_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String TAG_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String TAG_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String TAG_PSDEDATAEXPID = "PSDEDATAEXPID";
    public static final String TAG_PSDEDATAEXPNAME = "PSDEDATAEXPNAME";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_PSSYSSEARCHBARID = "PSSYSSEARCHBARID";
    public static final String TAG_PSSYSSEARCHBARNAME = "PSSYSSEARCHBARNAME";
    public static final String TAG_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String TAG_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String TAG_DYNCMODE = "DYNCMODE";
    public static final String TAG_ADPSDELOGICID = "ADPSDELOGICID";
    public static final String TAG_ADPSDELOGICNAME = "ADPSDELOGICNAME";
    public static final String TAG_PSSYSCALENDARID = "PSSYSCALENDARID";
    public static final String TAG_PSSYSCALENDARNAME = "PSSYSCALENDARNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";
    public static final String TAG_LOCALMODE = "LOCALMODE";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_PSSYSMAPVIEWID = "PSSYSMAPVIEWID";
    public static final String TAG_PSSYSMAPVIEWNAME = "PSSYSMAPVIEWNAME";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_PSDEDATAIMPID = "PSDEDATAIMPID";
    public static final String TAG_PSDEDATAIMPNAME = "PSDEDATAIMPNAME";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSDEOPPRIVID = "PSDEOPPRIVID";
    public static final String TAG_PSDEOPPRIVNAME = "PSDEOPPRIVNAME";
    public static final String TAG_CUSTOMCOND = "CUSTOMCOND";
    public static final String TAG_REFCTRLNAME = "REFCTRLNAME";
    public static final String TAG_REFCTRL2NAME = "REFCTRL2NAME";
    public static final String TAG_REFCTRLUSAGE = "REFCTRLUSAGE";
    public static final String TAG_REFCTRL2USAGE = "REFCTRL2USAGE";
    public static final String TAG_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String TAG_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String TAG_BTNACTIONTYPE = "BTNACTIONTYPE";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";

    public final boolean isPSDEVIEWCTRLIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLID);
    }

    public final String getPSDEVIEWCTRLID() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLID, "");
    }

    public final void setPSDEVIEWCTRLID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLID, strValue);
    }

    public final boolean isPSDEVIEWCTRLNAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLNAME);
    }

    public final String getPSDEVIEWCTRLNAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLNAME, "");
    }

    public final void setPSDEVIEWCTRLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isPSDEVIEWCTRLTYPENull() {
        return this.IsParamNull(TAG_PSDEVIEWCTRLTYPE);
    }

    public final String getPSDEVIEWCTRLTYPE() {
        return this.GetParamStringValue(TAG_PSDEVIEWCTRLTYPE, "");
    }

    public final void setPSDEVIEWCTRLTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWCTRLTYPE, strValue);
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

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final float getWIDTH() {
        return this.GetParamFloatValue(TAG_WIDTH, 0.0f);
    }

    public final void setWIDTH(float fValue) {
        this.SetParamValue(TAG_WIDTH, Float.valueOf(fValue));
    }

    public final boolean isHEIGHTNull() {
        return this.IsParamNull(TAG_HEIGHT);
    }

    public final float getHEIGHT() {
        return this.GetParamFloatValue(TAG_HEIGHT, 0.0f);
    }

    public final void setHEIGHT(float fValue) {
        this.SetParamValue(TAG_HEIGHT, Float.valueOf(fValue));
    }

    public final boolean isMARGINNull() {
        return this.IsParamNull(TAG_MARGIN);
    }

    public final String getMARGIN() {
        return this.GetParamStringValue(TAG_MARGIN, "");
    }

    public final void setMARGIN(String strValue) {
        this.SetParamValue(TAG_MARGIN, strValue);
    }

    public final boolean isPADDINGNull() {
        return this.IsParamNull(TAG_PADDING);
    }

    public final String getPADDING() {
        return this.GetParamStringValue(TAG_PADDING, "");
    }

    public final void setPADDING(String strValue) {
        this.SetParamValue(TAG_PADDING, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
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

    public final boolean isPSDEDATASETIDNull() {
        return this.IsParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.GetParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.IsParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.GetParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isPSDEGRIDIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.GetParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDNAME, strValue);
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

    public final boolean isPSDEDRIDNull() {
        return this.IsParamNull(TAG_PSDEDRID);
    }

    public final String getPSDEDRID() {
        return this.GetParamStringValue(TAG_PSDEDRID, "");
    }

    public final void setPSDEDRID(String strValue) {
        this.SetParamValue(TAG_PSDEDRID, strValue);
    }

    public final boolean isPSDEDRNAMENull() {
        return this.IsParamNull(TAG_PSDEDRNAME);
    }

    public final String getPSDEDRNAME() {
        return this.GetParamStringValue(TAG_PSDEDRNAME, "");
    }

    public final void setPSDEDRNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDRNAME, strValue);
    }

    public final boolean isCONFIGINFONull() {
        return this.IsParamNull(TAG_CONFIGINFO);
    }

    public final String getCONFIGINFO() {
        return this.GetParamStringValue(TAG_CONFIGINFO, "");
    }

    public final void setCONFIGINFO(String strValue) {
        this.SetParamValue(TAG_CONFIGINFO, strValue);
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

    public final boolean isNO2PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO2PSDEUAGROUPID);
    }

    public final String getNO2PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO2PSDEUAGROUPID, "");
    }

    public final void setNO2PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEUAGROUPID, strValue);
    }

    public final boolean isNO2PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEUAGROUPNAME);
    }

    public final String getNO2PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEUAGROUPNAME, "");
    }

    public final void setNO2PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO3PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO3PSDEUAGROUPID);
    }

    public final String getNO3PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO3PSDEUAGROUPID, "");
    }

    public final void setNO3PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO3PSDEUAGROUPID, strValue);
    }

    public final boolean isNO3PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO3PSDEUAGROUPNAME);
    }

    public final String getNO3PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO3PSDEUAGROUPNAME, "");
    }

    public final void setNO3PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO3PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO4PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO4PSDEUAGROUPID);
    }

    public final String getNO4PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO4PSDEUAGROUPID, "");
    }

    public final void setNO4PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO4PSDEUAGROUPID, strValue);
    }

    public final boolean isNO4PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO4PSDEUAGROUPNAME);
    }

    public final String getNO4PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO4PSDEUAGROUPNAME, "");
    }

    public final void setNO4PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO4PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO5PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO5PSDEUAGROUPID);
    }

    public final String getNO5PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO5PSDEUAGROUPID, "");
    }

    public final void setNO5PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO5PSDEUAGROUPID, strValue);
    }

    public final boolean isNO5PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO5PSDEUAGROUPNAME);
    }

    public final String getNO5PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO5PSDEUAGROUPNAME, "");
    }

    public final void setNO5PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO5PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO6PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO6PSDEUAGROUPID);
    }

    public final String getNO6PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO6PSDEUAGROUPID, "");
    }

    public final void setNO6PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO6PSDEUAGROUPID, strValue);
    }

    public final boolean isNO6PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO6PSDEUAGROUPNAME);
    }

    public final String getNO6PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO6PSDEUAGROUPNAME, "");
    }

    public final void setNO6PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO6PSDEUAGROUPNAME, strValue);
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

    public final boolean isCTRLPARAMSNull() {
        return this.IsParamNull(TAG_CTRLPARAMS);
    }

    public final String getCTRLPARAMS() {
        return this.GetParamStringValue(TAG_CTRLPARAMS, "");
    }

    public final void setCTRLPARAMS(String strValue) {
        this.SetParamValue(TAG_CTRLPARAMS, strValue);
    }

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
    }

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.IsParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.GetParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
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

    public final boolean isMULTISELECTNull() {
        return this.IsParamNull(TAG_MULTISELECT);
    }

    public final boolean getMULTISELECT() {
        return this.GetParamIntValue(TAG_MULTISELECT, 0) == 1;
    }

    public final void setMULTISELECT(boolean bValue) {
        this.SetParamValue(TAG_MULTISELECT, bValue ? 1 : 0);
    }

    public final boolean isCTRLPSDEIDNull() {
        return this.IsParamNull(TAG_CTRLPSDEID);
    }

    public final String getCTRLPSDEID() {
        return this.GetParamStringValue(TAG_CTRLPSDEID, "");
    }

    public final void setCTRLPSDEID(String strValue) {
        this.SetParamValue(TAG_CTRLPSDEID, strValue);
    }

    public final boolean isCTRLPSDENAMENull() {
        return this.IsParamNull(TAG_CTRLPSDENAME);
    }

    public final String getCTRLPSDENAME() {
        return this.GetParamStringValue(TAG_CTRLPSDENAME, "");
    }

    public final void setCTRLPSDENAME(String strValue) {
        this.SetParamValue(TAG_CTRLPSDENAME, strValue);
    }

    public final boolean isSUBPSACHANDLERIDNull() {
        return this.IsParamNull(TAG_SUBPSACHANDLERID);
    }

    public final String getSUBPSACHANDLERID() {
        return this.GetParamStringValue(TAG_SUBPSACHANDLERID, "");
    }

    public final void setSUBPSACHANDLERID(String strValue) {
        this.SetParamValue(TAG_SUBPSACHANDLERID, strValue);
    }

    public final boolean isSUBPSACHANDLERNAMENull() {
        return this.IsParamNull(TAG_SUBPSACHANDLERNAME);
    }

    public final String getSUBPSACHANDLERNAME() {
        return this.GetParamStringValue(TAG_SUBPSACHANDLERNAME, "");
    }

    public final void setSUBPSACHANDLERNAME(String strValue) {
        this.SetParamValue(TAG_SUBPSACHANDLERNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
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

    public final boolean isCTRLPARAMNull() {
        return this.IsParamNull(TAG_CTRLPARAM);
    }

    public final String getCTRLPARAM() {
        return this.GetParamStringValue(TAG_CTRLPARAM, "");
    }

    public final void setCTRLPARAM(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM, strValue);
    }

    public final boolean isCTRLPARAM2Null() {
        return this.IsParamNull(TAG_CTRLPARAM2);
    }

    public final String getCTRLPARAM2() {
        return this.GetParamStringValue(TAG_CTRLPARAM2, "");
    }

    public final void setCTRLPARAM2(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM2, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
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

    public final boolean isCTRLPARAM3Null() {
        return this.IsParamNull(TAG_CTRLPARAM3);
    }

    public final String getCTRLPARAM3() {
        return this.GetParamStringValue(TAG_CTRLPARAM3, "");
    }

    public final void setCTRLPARAM3(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM3, strValue);
    }

    public final boolean isCTRLPARAM4Null() {
        return this.IsParamNull(TAG_CTRLPARAM4);
    }

    public final String getCTRLPARAM4() {
        return this.GetParamStringValue(TAG_CTRLPARAM4, "");
    }

    public final void setCTRLPARAM4(String strValue) {
        this.SetParamValue(TAG_CTRLPARAM4, strValue);
    }

    public final boolean isCTRLPARAM5Null() {
        return this.IsParamNull(TAG_CTRLPARAM5);
    }

    public final boolean getCTRLPARAM5() {
        return this.GetParamIntValue(TAG_CTRLPARAM5, 0) == 1;
    }

    public final void setCTRLPARAM5(boolean bValue) {
        this.SetParamValue(TAG_CTRLPARAM5, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM6Null() {
        return this.IsParamNull(TAG_CTRLPARAM6);
    }

    public final boolean getCTRLPARAM6() {
        return this.GetParamIntValue(TAG_CTRLPARAM6, 0) == 1;
    }

    public final void setCTRLPARAM6(boolean bValue) {
        this.SetParamValue(TAG_CTRLPARAM6, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM7Null() {
        return this.IsParamNull(TAG_CTRLPARAM7);
    }

    public final int getCTRLPARAM7() {
        return this.GetParamIntValue(TAG_CTRLPARAM7, 0);
    }

    public final void setCTRLPARAM7(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM7, nValue);
    }

    public final boolean isCTRLPARAM8Null() {
        return this.IsParamNull(TAG_CTRLPARAM8);
    }

    public final int getCTRLPARAM8() {
        return this.GetParamIntValue(TAG_CTRLPARAM8, 0);
    }

    public final void setCTRLPARAM8(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM8, nValue);
    }

    public final boolean isCTRLPARAM9Null() {
        return this.IsParamNull(TAG_CTRLPARAM9);
    }

    public final float getCTRLPARAM9() {
        return this.GetParamFloatValue(TAG_CTRLPARAM9, 0.0f);
    }

    public final void setCTRLPARAM9(float fValue) {
        this.SetParamValue(TAG_CTRLPARAM9, Float.valueOf(fValue));
    }

    public final boolean isCTRLPARAM10Null() {
        return this.IsParamNull(TAG_CTRLPARAM10);
    }

    public final float getCTRLPARAM10() {
        return this.GetParamFloatValue(TAG_CTRLPARAM10, 0.0f);
    }

    public final void setCTRLPARAM10(float fValue) {
        this.SetParamValue(TAG_CTRLPARAM10, Float.valueOf(fValue));
    }

    public final boolean isCTRLPARAM11Null() {
        return this.IsParamNull(TAG_CTRLPARAM11);
    }

    public final int getCTRLPARAM11() {
        return this.GetParamIntValue(TAG_CTRLPARAM11, 0);
    }

    public final void setCTRLPARAM11(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM11, nValue);
    }

    public final boolean isCTRLPARAM12Null() {
        return this.IsParamNull(TAG_CTRLPARAM12);
    }

    public final int getCTRLPARAM12() {
        return this.GetParamIntValue(TAG_CTRLPARAM12, 0);
    }

    public final void setCTRLPARAM12(int nValue) {
        this.SetParamValue(TAG_CTRLPARAM12, nValue);
    }

    public final boolean isPSDEWIZARDIDNull() {
        return this.IsParamNull(TAG_PSDEWIZARDID);
    }

    public final String getPSDEWIZARDID() {
        return this.GetParamStringValue(TAG_PSDEWIZARDID, "");
    }

    public final void setPSDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDID, strValue);
    }

    public final boolean isPSDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_PSDEWIZARDNAME);
    }

    public final String getPSDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_PSDEWIZARDNAME, "");
    }

    public final void setPSDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDNAME, strValue);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isENABLEITEMPRIVNull() {
        return this.IsParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.GetParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.SetParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
    }

    public final boolean isPSDEDATAEXPIDNull() {
        return this.IsParamNull(TAG_PSDEDATAEXPID);
    }

    public final String getPSDEDATAEXPID() {
        return this.GetParamStringValue(TAG_PSDEDATAEXPID, "");
    }

    public final void setPSDEDATAEXPID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAEXPID, strValue);
    }

    public final boolean isPSDEDATAEXPNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAEXPNAME);
    }

    public final String getPSDEDATAEXPNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAEXPNAME, "");
    }

    public final void setPSDEDATAEXPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAEXPNAME, strValue);
    }

    public final boolean isPSCTRLMSGIDNull() {
        return this.IsParamNull(TAG_PSCTRLMSGID);
    }

    public final String getPSCTRLMSGID() {
        return this.GetParamStringValue(TAG_PSCTRLMSGID, "");
    }

    public final void setPSCTRLMSGID(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGID, strValue);
    }

    public final boolean isPSCTRLMSGNAMENull() {
        return this.IsParamNull(TAG_PSCTRLMSGNAME);
    }

    public final String getPSCTRLMSGNAME() {
        return this.GetParamStringValue(TAG_PSCTRLMSGNAME, "");
    }

    public final void setPSCTRLMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGNAME, strValue);
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

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.IsParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.GetParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isPSSYSSEARCHBARIDNull() {
        return this.IsParamNull(TAG_PSSYSSEARCHBARID);
    }

    public final String getPSSYSSEARCHBARID() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHBARID, "");
    }

    public final void setPSSYSSEARCHBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHBARID, strValue);
    }

    public final boolean isPSSYSSEARCHBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSSEARCHBARNAME);
    }

    public final String getPSSYSSEARCHBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSSEARCHBARNAME, "");
    }

    public final void setPSSYSSEARCHBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSEARCHBARNAME, strValue);
    }

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

    public final boolean isDYNCMODENull() {
        return this.IsParamNull(TAG_DYNCMODE);
    }

    public final Integer getDYNCMODE() {
        return this.GetParamIntValue(TAG_DYNCMODE, 0);
    }

    public final void setDYNCMODE(int bValue) {
        this.SetParamValue(TAG_DYNCMODE, bValue);
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

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
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

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }

    public final boolean isLOCALMODENull() {
        return this.IsParamNull(TAG_LOCALMODE);
    }

    public final boolean getLOCALMODE() {
        return this.GetParamIntValue(TAG_LOCALMODE, 0) == 1;
    }

    public final void setLOCALMODE(boolean bValue) {
        this.SetParamValue(TAG_LOCALMODE, bValue ? 1 : 0);
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

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.SetParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
    }

    public final boolean isPSDEDATAIMPIDNull() {
        return this.IsParamNull(TAG_PSDEDATAIMPID);
    }

    public final String getPSDEDATAIMPID() {
        return this.GetParamStringValue(TAG_PSDEDATAIMPID, "");
    }

    public final void setPSDEDATAIMPID(String strValue) {
        this.SetParamValue(TAG_PSDEDATAIMPID, strValue);
    }

    public final boolean isPSDEDATAIMPNAMENull() {
        return this.IsParamNull(TAG_PSDEDATAIMPNAME);
    }

    public final String getPSDEDATAIMPNAME() {
        return this.GetParamStringValue(TAG_PSDEDATAIMPNAME, "");
    }

    public final void setPSDEDATAIMPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEDATAIMPNAME, strValue);
    }

    public final boolean isPSSYSDYNAMODELIDNull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELID);
    }

    public final String getPSSYSDYNAMODELID() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELID, "");
    }

    public final void setPSSYSDYNAMODELID(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELID, strValue);
    }

    public final boolean isPSSYSDYNAMODELNAMENull() {
        return this.IsParamNull(TAG_PSSYSDYNAMODELNAME);
    }

    public final String getPSSYSDYNAMODELNAME() {
        return this.GetParamStringValue(TAG_PSSYSDYNAMODELNAME, "");
    }

    public final void setPSSYSDYNAMODELNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDYNAMODELNAME, strValue);
    }

    public final boolean isPSDEOPPRIVIDNull() {
        return this.IsParamNull(TAG_PSDEOPPRIVID);
    }

    public final String getPSDEOPPRIVID() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVID, "");
    }

    public final void setPSDEOPPRIVID(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVID, strValue);
    }

    public final boolean isPSDEOPPRIVNAMENull() {
        return this.IsParamNull(TAG_PSDEOPPRIVNAME);
    }

    public final String getPSDEOPPRIVNAME() {
        return this.GetParamStringValue(TAG_PSDEOPPRIVNAME, "");
    }

    public final void setPSDEOPPRIVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEOPPRIVNAME, strValue);
    }

    public final boolean isCUSTOMCONDNull() {
        return this.IsParamNull(TAG_CUSTOMCOND);
    }

    public final String getCUSTOMCOND() {
        return this.GetParamStringValue(TAG_CUSTOMCOND, "");
    }

    public final void setCUSTOMCOND(String strValue) {
        this.SetParamValue(TAG_CUSTOMCOND, strValue);
    }

    public final boolean isREFCTRLNAMENull() {
        return this.IsParamNull(TAG_REFCTRLNAME);
    }

    public final String getREFCTRLNAME() {
        return this.GetParamStringValue(TAG_REFCTRLNAME, "");
    }

    public final void setREFCTRLNAME(String strValue) {
        this.SetParamValue(TAG_REFCTRLNAME, strValue);
    }

    public final boolean isREFCTRL2NAMENull() {
        return this.IsParamNull(TAG_REFCTRL2NAME);
    }

    public final String getREFCTRL2NAME() {
        return this.GetParamStringValue(TAG_REFCTRL2NAME, "");
    }

    public final void setREFCTRL2NAME(String strValue) {
        this.SetParamValue(TAG_REFCTRL2NAME, strValue);
    }

    public final boolean isREFCTRLUSAGENull() {
        return this.IsParamNull(TAG_REFCTRLUSAGE);
    }

    public final String getREFCTRLUSAGE() {
        return this.GetParamStringValue(TAG_REFCTRLUSAGE, "");
    }

    public final void setREFCTRLUSAGE(String strValue) {
        this.SetParamValue(TAG_REFCTRLUSAGE, strValue);
    }

    public final boolean isREFCTRL2USAGENull() {
        return this.IsParamNull(TAG_REFCTRL2USAGE);
    }

    public final String getREFCTRL2USAGE() {
        return this.GetParamStringValue(TAG_REFCTRL2USAGE, "");
    }

    public final void setREFCTRL2USAGE(String strValue) {
        this.SetParamValue(TAG_REFCTRL2USAGE, strValue);
    }

    public final boolean isPREDEFINEDTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPE);
    }

    public final String getPREDEFINEDTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPE, "");
    }

    public final void setPREDEFINEDTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPE, strValue);
    }

    public final boolean isPREDEFINEDTYPETEXTNull() {
        return this.IsParamNull(TAG_PREDEFINEDTYPETEXT);
    }

    public final String getPREDEFINEDTYPETEXT() {
        return this.GetParamStringValue(TAG_PREDEFINEDTYPETEXT, "");
    }

    public final void setPREDEFINEDTYPETEXT(String strValue) {
        this.SetParamValue(TAG_PREDEFINEDTYPETEXT, strValue);
    }

    public final boolean isBTNACTIONTYPENull() {
        return this.IsParamNull(TAG_BTNACTIONTYPE);
    }

    public final String getBTNACTIONTYPE() {
        return this.GetParamStringValue(TAG_BTNACTIONTYPE, "");
    }

    public final void setBTNACTIONTYPE(String strValue) {
        this.SetParamValue(TAG_BTNACTIONTYPE, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final int getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0);
    }

    public final void setENABLEDYNASYS(int bValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, bValue);
    }
}

