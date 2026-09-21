/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSDEVIEWCTRLIDNull() {
        return this.isParamNull(TAG_PSDEVIEWCTRLID);
    }

    public final String getPSDEVIEWCTRLID() {
        return this.getParamStringValue(TAG_PSDEVIEWCTRLID, "");
    }

    public final void setPSDEVIEWCTRLID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWCTRLID, strValue);
    }

    public final boolean isPSDEVIEWCTRLNAMENull() {
        return this.isParamNull(TAG_PSDEVIEWCTRLNAME);
    }

    public final String getPSDEVIEWCTRLNAME() {
        return this.getParamStringValue(TAG_PSDEVIEWCTRLNAME, "");
    }

    public final void setPSDEVIEWCTRLNAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWCTRLNAME, strValue);
    }

    public final boolean isPSDEVIEWCTRLTYPENull() {
        return this.isParamNull(TAG_PSDEVIEWCTRLTYPE);
    }

    public final String getPSDEVIEWCTRLTYPE() {
        return this.getParamStringValue(TAG_PSDEVIEWCTRLTYPE, "");
    }

    public final void setPSDEVIEWCTRLTYPE(String strValue) {
        this.setParamValue(TAG_PSDEVIEWCTRLTYPE, strValue);
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

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.isParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.getParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASEID, strValue);
    }

    public final boolean isPSDEVIEWBASENAMENull() {
        return this.isParamNull(TAG_PSDEVIEWBASENAME);
    }

    public final String getPSDEVIEWBASENAME() {
        return this.getParamStringValue(TAG_PSDEVIEWBASENAME, "");
    }

    public final void setPSDEVIEWBASENAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASENAME, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final float getWIDTH() {
        return this.getParamFloatValue(TAG_WIDTH, 0.0f);
    }

    public final void setWIDTH(float fValue) {
        this.setParamValue(TAG_WIDTH, Float.valueOf(fValue));
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final float getHEIGHT() {
        return this.getParamFloatValue(TAG_HEIGHT, 0.0f);
    }

    public final void setHEIGHT(float fValue) {
        this.setParamValue(TAG_HEIGHT, Float.valueOf(fValue));
    }

    public final boolean isMARGINNull() {
        return this.isParamNull(TAG_MARGIN);
    }

    public final String getMARGIN() {
        return this.getParamStringValue(TAG_MARGIN, "");
    }

    public final void setMARGIN(String strValue) {
        this.setParamValue(TAG_MARGIN, strValue);
    }

    public final boolean isPADDINGNull() {
        return this.isParamNull(TAG_PADDING);
    }

    public final String getPADDING() {
        return this.getParamStringValue(TAG_PADDING, "");
    }

    public final void setPADDING(String strValue) {
        this.setParamValue(TAG_PADDING, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.isParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.getParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.setParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSACHANDLERIDNull() {
        return this.isParamNull(TAG_PSACHANDLERID);
    }

    public final String getPSACHANDLERID() {
        return this.getParamStringValue(TAG_PSACHANDLERID, "");
    }

    public final void setPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_PSACHANDLERID, strValue);
    }

    public final boolean isPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_PSACHANDLERNAME);
    }

    public final String getPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_PSACHANDLERNAME, "");
    }

    public final void setPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_PSACHANDLERNAME, strValue);
    }

    public final boolean isPSDEDATASETIDNull() {
        return this.isParamNull(TAG_PSDEDATASETID);
    }

    public final String getPSDEDATASETID() {
        return this.getParamStringValue(TAG_PSDEDATASETID, "");
    }

    public final void setPSDEDATASETID(String strValue) {
        this.setParamValue(TAG_PSDEDATASETID, strValue);
    }

    public final boolean isPSDEDATASETNAMENull() {
        return this.isParamNull(TAG_PSDEDATASETNAME);
    }

    public final String getPSDEDATASETNAME() {
        return this.getParamStringValue(TAG_PSDEDATASETNAME, "");
    }

    public final void setPSDEDATASETNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATASETNAME, strValue);
    }

    public final boolean isPSDEGRIDIDNull() {
        return this.isParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.getParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.setParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.isParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.getParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.setParamValue(TAG_PSDEGRIDNAME, strValue);
    }

    public final boolean isPSDETOOLBARIDNull() {
        return this.isParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.getParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.setParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.isParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.getParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.setParamValue(TAG_PSDETOOLBARNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.isParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.getParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.setParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.isParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.getParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.setParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isPSDEDRIDNull() {
        return this.isParamNull(TAG_PSDEDRID);
    }

    public final String getPSDEDRID() {
        return this.getParamStringValue(TAG_PSDEDRID, "");
    }

    public final void setPSDEDRID(String strValue) {
        this.setParamValue(TAG_PSDEDRID, strValue);
    }

    public final boolean isPSDEDRNAMENull() {
        return this.isParamNull(TAG_PSDEDRNAME);
    }

    public final String getPSDEDRNAME() {
        return this.getParamStringValue(TAG_PSDEDRNAME, "");
    }

    public final void setPSDEDRNAME(String strValue) {
        this.setParamValue(TAG_PSDEDRNAME, strValue);
    }

    public final boolean isCONFIGINFONull() {
        return this.isParamNull(TAG_CONFIGINFO);
    }

    public final String getCONFIGINFO() {
        return this.getParamStringValue(TAG_CONFIGINFO, "");
    }

    public final void setCONFIGINFO(String strValue) {
        this.setParamValue(TAG_CONFIGINFO, strValue);
    }

    public final boolean isPSDEVIEWIDNull() {
        return this.isParamNull(TAG_PSDEVIEWID);
    }

    public final String getPSDEVIEWID() {
        return this.getParamStringValue(TAG_PSDEVIEWID, "");
    }

    public final void setPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_PSDEVIEWID, strValue);
    }

    public final boolean isPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_PSDEVIEWNAME);
    }

    public final String getPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_PSDEVIEWNAME, "");
    }

    public final void setPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSDEVIEWNAME, strValue);
    }

    public final boolean isPSDEDATAVIEWIDNull() {
        return this.isParamNull(TAG_PSDEDATAVIEWID);
    }

    public final String getPSDEDATAVIEWID() {
        return this.getParamStringValue(TAG_PSDEDATAVIEWID, "");
    }

    public final void setPSDEDATAVIEWID(String strValue) {
        this.setParamValue(TAG_PSDEDATAVIEWID, strValue);
    }

    public final boolean isPSDEDATAVIEWNAMENull() {
        return this.isParamNull(TAG_PSDEDATAVIEWNAME);
    }

    public final String getPSDEDATAVIEWNAME() {
        return this.getParamStringValue(TAG_PSDEDATAVIEWNAME, "");
    }

    public final void setPSDEDATAVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATAVIEWNAME, strValue);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.getParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO2PSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_NO2PSDEUAGROUPID);
    }

    public final String getNO2PSDEUAGROUPID() {
        return this.getParamStringValue(TAG_NO2PSDEUAGROUPID, "");
    }

    public final void setNO2PSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_NO2PSDEUAGROUPID, strValue);
    }

    public final boolean isNO2PSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_NO2PSDEUAGROUPNAME);
    }

    public final String getNO2PSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_NO2PSDEUAGROUPNAME, "");
    }

    public final void setNO2PSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_NO2PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO3PSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_NO3PSDEUAGROUPID);
    }

    public final String getNO3PSDEUAGROUPID() {
        return this.getParamStringValue(TAG_NO3PSDEUAGROUPID, "");
    }

    public final void setNO3PSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_NO3PSDEUAGROUPID, strValue);
    }

    public final boolean isNO3PSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_NO3PSDEUAGROUPNAME);
    }

    public final String getNO3PSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_NO3PSDEUAGROUPNAME, "");
    }

    public final void setNO3PSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_NO3PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO4PSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_NO4PSDEUAGROUPID);
    }

    public final String getNO4PSDEUAGROUPID() {
        return this.getParamStringValue(TAG_NO4PSDEUAGROUPID, "");
    }

    public final void setNO4PSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_NO4PSDEUAGROUPID, strValue);
    }

    public final boolean isNO4PSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_NO4PSDEUAGROUPNAME);
    }

    public final String getNO4PSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_NO4PSDEUAGROUPNAME, "");
    }

    public final void setNO4PSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_NO4PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO5PSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_NO5PSDEUAGROUPID);
    }

    public final String getNO5PSDEUAGROUPID() {
        return this.getParamStringValue(TAG_NO5PSDEUAGROUPID, "");
    }

    public final void setNO5PSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_NO5PSDEUAGROUPID, strValue);
    }

    public final boolean isNO5PSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_NO5PSDEUAGROUPNAME);
    }

    public final String getNO5PSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_NO5PSDEUAGROUPNAME, "");
    }

    public final void setNO5PSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_NO5PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO6PSDEUAGROUPIDNull() {
        return this.isParamNull(TAG_NO6PSDEUAGROUPID);
    }

    public final String getNO6PSDEUAGROUPID() {
        return this.getParamStringValue(TAG_NO6PSDEUAGROUPID, "");
    }

    public final void setNO6PSDEUAGROUPID(String strValue) {
        this.setParamValue(TAG_NO6PSDEUAGROUPID, strValue);
    }

    public final boolean isNO6PSDEUAGROUPNAMENull() {
        return this.isParamNull(TAG_NO6PSDEUAGROUPNAME);
    }

    public final String getNO6PSDEUAGROUPNAME() {
        return this.getParamStringValue(TAG_NO6PSDEUAGROUPNAME, "");
    }

    public final void setNO6PSDEUAGROUPNAME(String strValue) {
        this.setParamValue(TAG_NO6PSDEUAGROUPNAME, strValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isCTRLPARAMSNull() {
        return this.isParamNull(TAG_CTRLPARAMS);
    }

    public final String getCTRLPARAMS() {
        return this.getParamStringValue(TAG_CTRLPARAMS, "");
    }

    public final void setCTRLPARAMS(String strValue) {
        this.setParamValue(TAG_CTRLPARAMS, strValue);
    }

    public final boolean isPSDETREEVIEWIDNull() {
        return this.isParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.getParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.setParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.isParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.getParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSDETREEVIEWNAME, strValue);
    }

    public final boolean isPSSYSCOUNTERIDNull() {
        return this.isParamNull(TAG_PSSYSCOUNTERID);
    }

    public final String getPSSYSCOUNTERID() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERID, "");
    }

    public final void setPSSYSCOUNTERID(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERID, strValue);
    }

    public final boolean isPSSYSCOUNTERNAMENull() {
        return this.isParamNull(TAG_PSSYSCOUNTERNAME);
    }

    public final String getPSSYSCOUNTERNAME() {
        return this.getParamStringValue(TAG_PSSYSCOUNTERNAME, "");
    }

    public final void setPSSYSCOUNTERNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCOUNTERNAME, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.isParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.getParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.setParamValue(TAG_CAPTION, strValue);
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

    public final boolean isMULTISELECTNull() {
        return this.isParamNull(TAG_MULTISELECT);
    }

    public final boolean getMULTISELECT() {
        return this.getParamIntValue(TAG_MULTISELECT, 0) == 1;
    }

    public final void setMULTISELECT(boolean bValue) {
        this.setParamValue(TAG_MULTISELECT, bValue ? 1 : 0);
    }

    public final boolean isCTRLPSDEIDNull() {
        return this.isParamNull(TAG_CTRLPSDEID);
    }

    public final String getCTRLPSDEID() {
        return this.getParamStringValue(TAG_CTRLPSDEID, "");
    }

    public final void setCTRLPSDEID(String strValue) {
        this.setParamValue(TAG_CTRLPSDEID, strValue);
    }

    public final boolean isCTRLPSDENAMENull() {
        return this.isParamNull(TAG_CTRLPSDENAME);
    }

    public final String getCTRLPSDENAME() {
        return this.getParamStringValue(TAG_CTRLPSDENAME, "");
    }

    public final void setCTRLPSDENAME(String strValue) {
        this.setParamValue(TAG_CTRLPSDENAME, strValue);
    }

    public final boolean isSUBPSACHANDLERIDNull() {
        return this.isParamNull(TAG_SUBPSACHANDLERID);
    }

    public final String getSUBPSACHANDLERID() {
        return this.getParamStringValue(TAG_SUBPSACHANDLERID, "");
    }

    public final void setSUBPSACHANDLERID(String strValue) {
        this.setParamValue(TAG_SUBPSACHANDLERID, strValue);
    }

    public final boolean isSUBPSACHANDLERNAMENull() {
        return this.isParamNull(TAG_SUBPSACHANDLERNAME);
    }

    public final String getSUBPSACHANDLERNAME() {
        return this.getParamStringValue(TAG_SUBPSACHANDLERNAME, "");
    }

    public final void setSUBPSACHANDLERNAME(String strValue) {
        this.setParamValue(TAG_SUBPSACHANDLERNAME, strValue);
    }

    public final boolean isPSDECHARTIDNull() {
        return this.isParamNull(TAG_PSDECHARTID);
    }

    public final String getPSDECHARTID() {
        return this.getParamStringValue(TAG_PSDECHARTID, "");
    }

    public final void setPSDECHARTID(String strValue) {
        this.setParamValue(TAG_PSDECHARTID, strValue);
    }

    public final boolean isPSDECHARTNAMENull() {
        return this.isParamNull(TAG_PSDECHARTNAME);
    }

    public final String getPSDECHARTNAME() {
        return this.getParamStringValue(TAG_PSDECHARTNAME, "");
    }

    public final void setPSDECHARTNAME(String strValue) {
        this.setParamValue(TAG_PSDECHARTNAME, strValue);
    }

    public final boolean isORDERVALUENull() {
        return this.isParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.getParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.setParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isPSDEREPORTIDNull() {
        return this.isParamNull(TAG_PSDEREPORTID);
    }

    public final String getPSDEREPORTID() {
        return this.getParamStringValue(TAG_PSDEREPORTID, "");
    }

    public final void setPSDEREPORTID(String strValue) {
        this.setParamValue(TAG_PSDEREPORTID, strValue);
    }

    public final boolean isPSDEREPORTNAMENull() {
        return this.isParamNull(TAG_PSDEREPORTNAME);
    }

    public final String getPSDEREPORTNAME() {
        return this.getParamStringValue(TAG_PSDEREPORTNAME, "");
    }

    public final boolean isPSDELISTIDNull() {
        return this.isParamNull(TAG_PSDELISTID);
    }

    public final String getPSDELISTID() {
        return this.getParamStringValue(TAG_PSDELISTID, "");
    }

    public final void setPSDELISTID(String strValue) {
        this.setParamValue(TAG_PSDELISTID, strValue);
    }

    public final boolean isPSDELISTNAMENull() {
        return this.isParamNull(TAG_PSDELISTNAME);
    }

    public final String getPSDELISTNAME() {
        return this.getParamStringValue(TAG_PSDELISTNAME, "");
    }

    public final void setPSDELISTNAME(String strValue) {
        this.setParamValue(TAG_PSDELISTNAME, strValue);
    }

    public final boolean isCTRLPARAMNull() {
        return this.isParamNull(TAG_CTRLPARAM);
    }

    public final String getCTRLPARAM() {
        return this.getParamStringValue(TAG_CTRLPARAM, "");
    }

    public final void setCTRLPARAM(String strValue) {
        this.setParamValue(TAG_CTRLPARAM, strValue);
    }

    public final boolean isCTRLPARAM2Null() {
        return this.isParamNull(TAG_CTRLPARAM2);
    }

    public final String getCTRLPARAM2() {
        return this.getParamStringValue(TAG_CTRLPARAM2, "");
    }

    public final void setCTRLPARAM2(String strValue) {
        this.setParamValue(TAG_CTRLPARAM2, strValue);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.isParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.getParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.isParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.getParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.setParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isCTRLPARAM3Null() {
        return this.isParamNull(TAG_CTRLPARAM3);
    }

    public final String getCTRLPARAM3() {
        return this.getParamStringValue(TAG_CTRLPARAM3, "");
    }

    public final void setCTRLPARAM3(String strValue) {
        this.setParamValue(TAG_CTRLPARAM3, strValue);
    }

    public final boolean isCTRLPARAM4Null() {
        return this.isParamNull(TAG_CTRLPARAM4);
    }

    public final String getCTRLPARAM4() {
        return this.getParamStringValue(TAG_CTRLPARAM4, "");
    }

    public final void setCTRLPARAM4(String strValue) {
        this.setParamValue(TAG_CTRLPARAM4, strValue);
    }

    public final boolean isCTRLPARAM5Null() {
        return this.isParamNull(TAG_CTRLPARAM5);
    }

    public final boolean getCTRLPARAM5() {
        return this.getParamIntValue(TAG_CTRLPARAM5, 0) == 1;
    }

    public final void setCTRLPARAM5(boolean bValue) {
        this.setParamValue(TAG_CTRLPARAM5, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM6Null() {
        return this.isParamNull(TAG_CTRLPARAM6);
    }

    public final boolean getCTRLPARAM6() {
        return this.getParamIntValue(TAG_CTRLPARAM6, 0) == 1;
    }

    public final void setCTRLPARAM6(boolean bValue) {
        this.setParamValue(TAG_CTRLPARAM6, bValue ? 1 : 0);
    }

    public final boolean isCTRLPARAM7Null() {
        return this.isParamNull(TAG_CTRLPARAM7);
    }

    public final int getCTRLPARAM7() {
        return this.getParamIntValue(TAG_CTRLPARAM7, 0);
    }

    public final void setCTRLPARAM7(int nValue) {
        this.setParamValue(TAG_CTRLPARAM7, nValue);
    }

    public final boolean isCTRLPARAM8Null() {
        return this.isParamNull(TAG_CTRLPARAM8);
    }

    public final int getCTRLPARAM8() {
        return this.getParamIntValue(TAG_CTRLPARAM8, 0);
    }

    public final void setCTRLPARAM8(int nValue) {
        this.setParamValue(TAG_CTRLPARAM8, nValue);
    }

    public final boolean isCTRLPARAM9Null() {
        return this.isParamNull(TAG_CTRLPARAM9);
    }

    public final float getCTRLPARAM9() {
        return this.getParamFloatValue(TAG_CTRLPARAM9, 0.0f);
    }

    public final void setCTRLPARAM9(float fValue) {
        this.setParamValue(TAG_CTRLPARAM9, Float.valueOf(fValue));
    }

    public final boolean isCTRLPARAM10Null() {
        return this.isParamNull(TAG_CTRLPARAM10);
    }

    public final float getCTRLPARAM10() {
        return this.getParamFloatValue(TAG_CTRLPARAM10, 0.0f);
    }

    public final void setCTRLPARAM10(float fValue) {
        this.setParamValue(TAG_CTRLPARAM10, Float.valueOf(fValue));
    }

    public final boolean isCTRLPARAM11Null() {
        return this.isParamNull(TAG_CTRLPARAM11);
    }

    public final int getCTRLPARAM11() {
        return this.getParamIntValue(TAG_CTRLPARAM11, 0);
    }

    public final void setCTRLPARAM11(int nValue) {
        this.setParamValue(TAG_CTRLPARAM11, nValue);
    }

    public final boolean isCTRLPARAM12Null() {
        return this.isParamNull(TAG_CTRLPARAM12);
    }

    public final int getCTRLPARAM12() {
        return this.getParamIntValue(TAG_CTRLPARAM12, 0);
    }

    public final void setCTRLPARAM12(int nValue) {
        this.setParamValue(TAG_CTRLPARAM12, nValue);
    }

    public final boolean isPSDEWIZARDIDNull() {
        return this.isParamNull(TAG_PSDEWIZARDID);
    }

    public final String getPSDEWIZARDID() {
        return this.getParamStringValue(TAG_PSDEWIZARDID, "");
    }

    public final void setPSDEWIZARDID(String strValue) {
        this.setParamValue(TAG_PSDEWIZARDID, strValue);
    }

    public final boolean isPSDEWIZARDNAMENull() {
        return this.isParamNull(TAG_PSDEWIZARDNAME);
    }

    public final String getPSDEWIZARDNAME() {
        return this.getParamStringValue(TAG_PSDEWIZARDNAME, "");
    }

    public final void setPSDEWIZARDNAME(String strValue) {
        this.setParamValue(TAG_PSDEWIZARDNAME, strValue);
    }

    public final boolean isPSSYSMSGTEMPLIDNull() {
        return this.isParamNull(TAG_PSSYSMSGTEMPLID);
    }

    public final String getPSSYSMSGTEMPLID() {
        return this.getParamStringValue(TAG_PSSYSMSGTEMPLID, "");
    }

    public final void setPSSYSMSGTEMPLID(String strValue) {
        this.setParamValue(TAG_PSSYSMSGTEMPLID, strValue);
    }

    public final boolean isPSSYSMSGTEMPLNAMENull() {
        return this.isParamNull(TAG_PSSYSMSGTEMPLNAME);
    }

    public final String getPSSYSMSGTEMPLNAME() {
        return this.getParamStringValue(TAG_PSSYSMSGTEMPLNAME, "");
    }

    public final void setPSSYSMSGTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSSYSMSGTEMPLNAME, strValue);
    }

    public final boolean isPSDEACTIONIDNull() {
        return this.isParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.getParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.setParamValue(TAG_PSDEACTIONID, strValue);
    }

    public final boolean isPSDEACTIONNAMENull() {
        return this.isParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.getParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.setParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.isParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.getParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.setParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.isParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.getParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.setParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isENABLEITEMPRIVNull() {
        return this.isParamNull(TAG_ENABLEITEMPRIV);
    }

    public final boolean getENABLEITEMPRIV() {
        return this.getParamIntValue(TAG_ENABLEITEMPRIV, 0) == 1;
    }

    public final void setENABLEITEMPRIV(boolean bValue) {
        this.setParamValue(TAG_ENABLEITEMPRIV, bValue ? 1 : 0);
    }

    public final boolean isPSDEDATAEXPIDNull() {
        return this.isParamNull(TAG_PSDEDATAEXPID);
    }

    public final String getPSDEDATAEXPID() {
        return this.getParamStringValue(TAG_PSDEDATAEXPID, "");
    }

    public final void setPSDEDATAEXPID(String strValue) {
        this.setParamValue(TAG_PSDEDATAEXPID, strValue);
    }

    public final boolean isPSDEDATAEXPNAMENull() {
        return this.isParamNull(TAG_PSDEDATAEXPNAME);
    }

    public final String getPSDEDATAEXPNAME() {
        return this.getParamStringValue(TAG_PSDEDATAEXPNAME, "");
    }

    public final void setPSDEDATAEXPNAME(String strValue) {
        this.setParamValue(TAG_PSDEDATAEXPNAME, strValue);
    }

    public final boolean isPSCTRLMSGIDNull() {
        return this.isParamNull(TAG_PSCTRLMSGID);
    }

    public final String getPSCTRLMSGID() {
        return this.getParamStringValue(TAG_PSCTRLMSGID, "");
    }

    public final void setPSCTRLMSGID(String strValue) {
        this.setParamValue(TAG_PSCTRLMSGID, strValue);
    }

    public final boolean isPSCTRLMSGNAMENull() {
        return this.isParamNull(TAG_PSCTRLMSGNAME);
    }

    public final String getPSCTRLMSGNAME() {
        return this.getParamStringValue(TAG_PSCTRLMSGNAME, "");
    }

    public final void setPSCTRLMSGNAME(String strValue) {
        this.setParamValue(TAG_PSCTRLMSGNAME, strValue);
    }

    public final boolean isPSSYSCSSIDNull() {
        return this.isParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.getParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.setParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.isParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.getParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.getParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isENABLEVIEWACTIONSNull() {
        return this.isParamNull(TAG_ENABLEVIEWACTIONS);
    }

    public final boolean getENABLEVIEWACTIONS() {
        return this.getParamIntValue(TAG_ENABLEVIEWACTIONS, 0) == 1;
    }

    public final void setENABLEVIEWACTIONS(boolean bValue) {
        this.setParamValue(TAG_ENABLEVIEWACTIONS, bValue ? 1 : 0);
    }

    public final boolean isPSSYSSEARCHBARIDNull() {
        return this.isParamNull(TAG_PSSYSSEARCHBARID);
    }

    public final String getPSSYSSEARCHBARID() {
        return this.getParamStringValue(TAG_PSSYSSEARCHBARID, "");
    }

    public final void setPSSYSSEARCHBARID(String strValue) {
        this.setParamValue(TAG_PSSYSSEARCHBARID, strValue);
    }

    public final boolean isPSSYSSEARCHBARNAMENull() {
        return this.isParamNull(TAG_PSSYSSEARCHBARNAME);
    }

    public final String getPSSYSSEARCHBARNAME() {
        return this.getParamStringValue(TAG_PSSYSSEARCHBARNAME, "");
    }

    public final void setPSSYSSEARCHBARNAME(String strValue) {
        this.setParamValue(TAG_PSSYSSEARCHBARNAME, strValue);
    }

    public final boolean isPSSYSDASHBOARDIDNull() {
        return this.isParamNull(TAG_PSSYSDASHBOARDID);
    }

    public final String getPSSYSDASHBOARDID() {
        return this.getParamStringValue(TAG_PSSYSDASHBOARDID, "");
    }

    public final void setPSSYSDASHBOARDID(String strValue) {
        this.setParamValue(TAG_PSSYSDASHBOARDID, strValue);
    }

    public final boolean isPSSYSDASHBOARDNAMENull() {
        return this.isParamNull(TAG_PSSYSDASHBOARDNAME);
    }

    public final String getPSSYSDASHBOARDNAME() {
        return this.getParamStringValue(TAG_PSSYSDASHBOARDNAME, "");
    }

    public final void setPSSYSDASHBOARDNAME(String strValue) {
        this.setParamValue(TAG_PSSYSDASHBOARDNAME, strValue);
    }

    public final boolean isDYNCMODENull() {
        return this.isParamNull(TAG_DYNCMODE);
    }

    public final boolean getDYNCMODE() {
        return this.getParamIntValue(TAG_DYNCMODE, 0) == 1;
    }

    public final void setDYNCMODE(boolean bValue) {
        this.setParamValue(TAG_DYNCMODE, bValue ? 1 : 0);
    }

    public final boolean isADPSDELOGICIDNull() {
        return this.isParamNull(TAG_ADPSDELOGICID);
    }

    public final String getADPSDELOGICID() {
        return this.getParamStringValue(TAG_ADPSDELOGICID, "");
    }

    public final void setADPSDELOGICID(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICID, strValue);
    }

    public final boolean isADPSDELOGICNAMENull() {
        return this.isParamNull(TAG_ADPSDELOGICNAME);
    }

    public final String getADPSDELOGICNAME() {
        return this.getParamStringValue(TAG_ADPSDELOGICNAME, "");
    }

    public final void setADPSDELOGICNAME(String strValue) {
        this.setParamValue(TAG_ADPSDELOGICNAME, strValue);
    }

    public final boolean isPSSYSCALENDARIDNull() {
        return this.isParamNull(TAG_PSSYSCALENDARID);
    }

    public final String getPSSYSCALENDARID() {
        return this.getParamStringValue(TAG_PSSYSCALENDARID, "");
    }

    public final void setPSSYSCALENDARID(String strValue) {
        this.setParamValue(TAG_PSSYSCALENDARID, strValue);
    }

    public final boolean isPSSYSCALENDARNAMENull() {
        return this.isParamNull(TAG_PSSYSCALENDARNAME);
    }

    public final String getPSSYSCALENDARNAME() {
        return this.getParamStringValue(TAG_PSSYSCALENDARNAME, "");
    }

    public final void setPSSYSCALENDARNAME(String strValue) {
        this.setParamValue(TAG_PSSYSCALENDARNAME, strValue);
    }

    public final boolean isPSSYSVIEWPANELIDNull() {
        return this.isParamNull(TAG_PSSYSVIEWPANELID);
    }

    public final String getPSSYSVIEWPANELID() {
        return this.getParamStringValue(TAG_PSSYSVIEWPANELID, "");
    }

    public final void setPSSYSVIEWPANELID(String strValue) {
        this.setParamValue(TAG_PSSYSVIEWPANELID, strValue);
    }

    public final boolean isPSSYSVIEWPANELNAMENull() {
        return this.isParamNull(TAG_PSSYSVIEWPANELNAME);
    }

    public final String getPSSYSVIEWPANELNAME() {
        return this.getParamStringValue(TAG_PSSYSVIEWPANELNAME, "");
    }

    public final void setPSSYSVIEWPANELNAME(String strValue) {
        this.setParamValue(TAG_PSSYSVIEWPANELNAME, strValue);
    }
}

