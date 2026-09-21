/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSDEViewBase
extends BaseDataEntity {
    public static final String PSDEVIEWBASETYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String PSDEVIEWBASETYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String PSDEVIEWBASETYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String PSDEVIEWBASETYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String PSDEVIEWBASETYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String PSDEVIEWBASETYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String PSDEVIEWBASETYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String PSDEVIEWBASETYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String PSDEVIEWBASETYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String PSDEVIEWBASETYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String PSDEVIEWBASETYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String PSDEVIEWBASETYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String PSDEVIEWBASETYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String PSDEVIEWBASETYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String PSDEVIEWBASETYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String PSDEVIEWBASETYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String PSDEVIEWBASETYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String PSDEVIEWBASETYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String PSDEVIEWBASETYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String PREDEFINEVIEWTYPE_PICKUPVIEW = "PICKUPVIEW";
    public static final String PREDEFINEVIEWTYPE_EDITVIEW = "EDITVIEW";
    public static final String PREDEFINEVIEWTYPE_INDEXDEPICKUPVIEW = "INDEXDEPICKUPVIEW";
    public static final String PREDEFINEVIEWTYPE_FORMPICKUPVIEW = "FORMPICKUPVIEW";
    public static final String PREDEFINEVIEWTYPE_MPICKUPVIEW = "MPICKUPVIEW";
    public static final String PREDEFINEVIEWTYPE_MDATAVIEW = "MDATAVIEW";
    public static final String PREDEFINEVIEWTYPE_WFEDITVIEW = "WFEDITVIEW";
    public static final String PREDEFINEVIEWTYPE_WFMDATAVIEW = "WFMDATAVIEW";
    public static final String OPENMODE_INDEXVIEWTAB = "INDEXVIEWTAB";
    public static final String OPENMODE_POPUP = "POPUP";
    public static final String OPENMODE_POPUPMODAL = "POPUPMODAL";
    public static final int VIEWACTIONS_CREATE = 1;
    public static final int VIEWACTIONS_EDIT = 2;
    public static final int VIEWACTIONS_VIEW = 4;
    public static final int VIEWACTIONS_REMOVE = 8;
    public static final int VIEWACTIONS_COPY = 16;
    public static final int VIEWACTIONS_ROWEDIT = 32;
    public static final int VIEWACTIONS_EXPORT = 64;
    public static final int VIEWACTIONS_PRINT = 128;
    public static final int VIEWACTIONS_FILTER = 256;
    public static final int VIEWACTIONS_HELP = 512;
    public static final int VIEWACTIONS_IMPORT = 1024;
    public static final int VIEWACTIONS_STARTWF = 2048;
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_PSDEVIEWBASETYPE = "PSDEVIEWBASETYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TEMPLVIEW = "TEMPLVIEW";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_TEMPLPSDEVIEWID = "TEMPLPSDEVIEWID";
    public static final String TAG_TEMPLPSDEVIEWNAME = "TEMPLPSDEVIEWNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_SECPSDETOOLBARID = "SECPSDETOOLBARID";
    public static final String TAG_SECPSDETOOLBARNAME = "SECPSDETOOLBARNAME";
    public static final String TAG_VIEWSN = "VIEWSN";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_PSVTSTYLEID = "PSVTSTYLEID";
    public static final String TAG_PSVTSTYLENAME = "PSVTSTYLENAME";
    public static final String TAG_VIEWPARAM = "VIEWPARAM";
    public static final String TAG_VIEWPARAM2 = "VIEWPARAM2";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_LOADDEFAULT = "LOADDEFAULT";
    public static final String TAG_VIEWPARAM5 = "VIEWPARAM5";
    public static final String TAG_VIEWPARAM6 = "VIEWPARAM6";
    public static final String TAG_PREDEFINEVIEWTYPE = "PREDEFINEVIEWTYPE";
    public static final String TAG_PDVTPARAM = "PDVTPARAM";
    public static final String TAG_TEMPMODE = "TEMPMODE";
    public static final String TAG_OPENMODE = "OPENMODE";
    public static final String TAG_PSWFDEID = "PSWFDEID";
    public static final String TAG_PSWFDENAME = "PSWFDENAME";
    public static final String TAG_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String TAG_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String TAG_PSWFID = "PSWFID";
    public static final String TAG_VIEWPARAMS = "VIEWPARAMS";
    public static final String TAG_ENABLEVIEWACTIONS = "ENABLEVIEWACTIONS";
    public static final String TAG_VIEWACTIONS = "VIEWACTIONS";
    public static final String TAG_SUBCAPTION = "SUBCAPTION";
    public static final String TAG_WFVIEWPARAM = "WFVIEWPARAM";
    public static final String TAG_WFVIEWPARAM2 = "WFVIEWPARAM2";
    public static final String TAG_WFVIEWPARAM3 = "WFVIEWPARAM3";
    public static final String TAG_WFVIEWPARAM4 = "WFVIEWPARAM4";
    public static final String TAG_PSSUBSYSID = "PSSUBSYSID";
    public static final String TAG_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String TAG_PSSUBDEVIEWID = "PSSUBDEVIEWID";
    public static final String TAG_PSSUBDEVIEWNAME = "PSSUBDEVIEWNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSUBVIEWTYPEID = "PSSUBVIEWTYPEID";
    public static final String TAG_PSSUBVIEWTYPENAME = "PSSUBVIEWTYPENAME";
    public static final String TAG_PSDEMAINSTATEID = "PSDEMAINSTATEID";
    public static final String TAG_PSDEMAINSTATENAME = "PSDEMAINSTATENAME";
    public static final String TAG_ACCUSERMODE = "ACCUSERMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_TODOTASK = "TODOTASK";
    public static final String TAG_PDTPARAMPRE = "PDTPARAMPRE";
    public static final String TAG_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String TAG_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String TAG_PSDEAWGROUPID = "PSDEAWGROUPID";
    public static final String TAG_PSDEAWGROUPNAME = "PSDEAWGROUPNAME";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_SUBCAPPSLANRESID = "SUBCAPPSLANRESID";
    public static final String TAG_SUBCAPPSLANRESNAME = "SUBCAPPSLANRESNAME";
    public static final String TAG_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String TAG_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_SHOWCAPTIONBAR = "SHOWCAPTIONBAR";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String TAG_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String TAG_DYNCMODE = "DYNCMODE";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_VIEWPARAM3 = "VIEWPARAM3";
    public static final String TAG_VIEWPARAM4 = "VIEWPARAM4";
    public static final String TAG_VIEWPARAM7 = "VIEWPARAM7";
    public static final String TAG_VIEWPARAM8 = "VIEWPARAM8";
    public static final String TAG_VIEWPARAM9 = "VIEWPARAM9";
    public static final String TAG_VIEWPARAM10 = "VIEWPARAM10";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String TAG_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String TAG_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String TAG_HEADERINFO = "HEADERINFO";
    public static final String TAG_BOTTOMINFO = "BOTTOMINFO";

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

    public final boolean isPSDEVIEWBASETYPENull() {
        return this.isParamNull(TAG_PSDEVIEWBASETYPE);
    }

    public final String getPSDEVIEWBASETYPE() {
        return this.getParamStringValue(TAG_PSDEVIEWBASETYPE, "");
    }

    public final void setPSDEVIEWBASETYPE(String strValue) {
        this.setParamValue(TAG_PSDEVIEWBASETYPE, strValue);
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

    public final boolean isTEMPLVIEWNull() {
        return this.isParamNull(TAG_TEMPLVIEW);
    }

    public final boolean getTEMPLVIEW() {
        return this.getParamIntValue(TAG_TEMPLVIEW, 0) == 1;
    }

    public final void setTEMPLVIEW(boolean bValue) {
        this.setParamValue(TAG_TEMPLVIEW, bValue ? 1 : 0);
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

    public final boolean isPSSYSTEMNAMENull() {
        return this.isParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.getParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isPSDENAMENull() {
        return this.isParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.getParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.setParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isTEMPLPSDEVIEWIDNull() {
        return this.isParamNull(TAG_TEMPLPSDEVIEWID);
    }

    public final String getTEMPLPSDEVIEWID() {
        return this.getParamStringValue(TAG_TEMPLPSDEVIEWID, "");
    }

    public final void setTEMPLPSDEVIEWID(String strValue) {
        this.setParamValue(TAG_TEMPLPSDEVIEWID, strValue);
    }

    public final boolean isTEMPLPSDEVIEWNAMENull() {
        return this.isParamNull(TAG_TEMPLPSDEVIEWNAME);
    }

    public final String getTEMPLPSDEVIEWNAME() {
        return this.getParamStringValue(TAG_TEMPLPSDEVIEWNAME, "");
    }

    public final void setTEMPLPSDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_TEMPLPSDEVIEWNAME, strValue);
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

    public final boolean isSECPSDETOOLBARIDNull() {
        return this.isParamNull(TAG_SECPSDETOOLBARID);
    }

    public final String getSECPSDETOOLBARID() {
        return this.getParamStringValue(TAG_SECPSDETOOLBARID, "");
    }

    public final void setSECPSDETOOLBARID(String strValue) {
        this.setParamValue(TAG_SECPSDETOOLBARID, strValue);
    }

    public final boolean isSECPSDETOOLBARNAMENull() {
        return this.isParamNull(TAG_SECPSDETOOLBARNAME);
    }

    public final String getSECPSDETOOLBARNAME() {
        return this.getParamStringValue(TAG_SECPSDETOOLBARNAME, "");
    }

    public final void setSECPSDETOOLBARNAME(String strValue) {
        this.setParamValue(TAG_SECPSDETOOLBARNAME, strValue);
    }

    public final boolean isVIEWSNNull() {
        return this.isParamNull(TAG_VIEWSN);
    }

    public final String getVIEWSN() {
        return this.getParamStringValue(TAG_VIEWSN, "");
    }

    public final void setVIEWSN(String strValue) {
        this.setParamValue(TAG_VIEWSN, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.isParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.getParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.setParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.isParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.getParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.setParamValue(TAG_WIDTH, nValue);
    }

    public final boolean isHEIGHTNull() {
        return this.isParamNull(TAG_HEIGHT);
    }

    public final int getHEIGHT() {
        return this.getParamIntValue(TAG_HEIGHT, 0);
    }

    public final void setHEIGHT(int nValue) {
        this.setParamValue(TAG_HEIGHT, nValue);
    }

    public final boolean isPSVTSTYLEIDNull() {
        return this.isParamNull(TAG_PSVTSTYLEID);
    }

    public final String getPSVTSTYLEID() {
        return this.getParamStringValue(TAG_PSVTSTYLEID, "");
    }

    public final void setPSVTSTYLEID(String strValue) {
        this.setParamValue(TAG_PSVTSTYLEID, strValue);
    }

    public final boolean isPSVTSTYLENAMENull() {
        return this.isParamNull(TAG_PSVTSTYLENAME);
    }

    public final String getPSVTSTYLENAME() {
        return this.getParamStringValue(TAG_PSVTSTYLENAME, "");
    }

    public final void setPSVTSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSVTSTYLENAME, strValue);
    }

    public final boolean isVIEWPARAMNull() {
        return this.isParamNull(TAG_VIEWPARAM);
    }

    public final String getVIEWPARAM() {
        return this.getParamStringValue(TAG_VIEWPARAM, "");
    }

    public final void setVIEWPARAM(String strValue) {
        this.setParamValue(TAG_VIEWPARAM, strValue);
    }

    public final boolean isVIEWPARAM2Null() {
        return this.isParamNull(TAG_VIEWPARAM2);
    }

    public final String getVIEWPARAM2() {
        return this.getParamStringValue(TAG_VIEWPARAM2, "");
    }

    public final void setVIEWPARAM2(String strValue) {
        this.setParamValue(TAG_VIEWPARAM2, strValue);
    }

    public final boolean isTITLENull() {
        return this.isParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.getParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.setParamValue(TAG_TITLE, strValue);
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

    public final boolean isLOADDEFAULTNull() {
        return this.isParamNull(TAG_LOADDEFAULT);
    }

    public final boolean getLOADDEFAULT() {
        return this.getParamIntValue(TAG_LOADDEFAULT, 0) == 1;
    }

    public final void setLOADDEFAULT(boolean bValue) {
        this.setParamValue(TAG_LOADDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isVIEWPARAM5Null() {
        return this.isParamNull(TAG_VIEWPARAM5);
    }

    public final boolean getVIEWPARAM5() {
        return this.getParamIntValue(TAG_VIEWPARAM5, 0) == 1;
    }

    public final void setVIEWPARAM5(boolean bValue) {
        this.setParamValue(TAG_VIEWPARAM5, bValue ? 1 : 0);
    }

    public final boolean isVIEWPARAM6Null() {
        return this.isParamNull(TAG_VIEWPARAM6);
    }

    public final boolean getVIEWPARAM6() {
        return this.getParamIntValue(TAG_VIEWPARAM6, 0) == 1;
    }

    public final void setVIEWPARAM6(boolean bValue) {
        this.setParamValue(TAG_VIEWPARAM6, bValue ? 1 : 0);
    }

    public final boolean isPREDEFINEVIEWTYPENull() {
        return this.isParamNull(TAG_PREDEFINEVIEWTYPE);
    }

    public final String getPREDEFINEVIEWTYPE() {
        return this.getParamStringValue(TAG_PREDEFINEVIEWTYPE, "");
    }

    public final void setPREDEFINEVIEWTYPE(String strValue) {
        this.setParamValue(TAG_PREDEFINEVIEWTYPE, strValue);
    }

    public final boolean isPDVTPARAMNull() {
        return this.isParamNull(TAG_PDVTPARAM);
    }

    public final String getPDVTPARAM() {
        return this.getParamStringValue(TAG_PDVTPARAM, "");
    }

    public final void setPDVTPARAM(String strValue) {
        this.setParamValue(TAG_PDVTPARAM, strValue);
    }

    public final boolean isTEMPMODENull() {
        return this.isParamNull(TAG_TEMPMODE);
    }

    public final int getTEMPMODE() {
        return this.getParamIntValue(TAG_TEMPMODE, 0);
    }

    public final void setTEMPMODE(int nValue) {
        this.setParamValue(TAG_TEMPMODE, nValue);
    }

    public final boolean isOPENMODENull() {
        return this.isParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.getParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.setParamValue(TAG_OPENMODE, strValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.isParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.getParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.setParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.isParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.getParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.setParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.isParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.getParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.isParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.getParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.setParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.isParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.getParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.setParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.isParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.getParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.setParamValue(TAG_VIEWPARAMS, strValue);
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

    public final boolean isVIEWACTIONSNull() {
        return this.isParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.getParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.setParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isSUBCAPTIONNull() {
        return this.isParamNull(TAG_SUBCAPTION);
    }

    public final String getSUBCAPTION() {
        return this.getParamStringValue(TAG_SUBCAPTION, "");
    }

    public final void setSUBCAPTION(String strValue) {
        this.setParamValue(TAG_SUBCAPTION, strValue);
    }

    public final boolean isWFVIEWPARAMNull() {
        return this.isParamNull(TAG_WFVIEWPARAM);
    }

    public final boolean getWFVIEWPARAM() {
        return this.getParamIntValue(TAG_WFVIEWPARAM, 0) == 1;
    }

    public final void setWFVIEWPARAM(boolean bValue) {
        this.setParamValue(TAG_WFVIEWPARAM, bValue ? 1 : 0);
    }

    public final boolean isWFVIEWPARAM2Null() {
        return this.isParamNull(TAG_WFVIEWPARAM2);
    }

    public final boolean getWFVIEWPARAM2() {
        return this.getParamIntValue(TAG_WFVIEWPARAM2, 0) == 1;
    }

    public final void setWFVIEWPARAM2(boolean bValue) {
        this.setParamValue(TAG_WFVIEWPARAM2, bValue ? 1 : 0);
    }

    public final boolean isWFVIEWPARAM3Null() {
        return this.isParamNull(TAG_WFVIEWPARAM3);
    }

    public final String getWFVIEWPARAM3() {
        return this.getParamStringValue(TAG_WFVIEWPARAM3, "");
    }

    public final void setWFVIEWPARAM3(String strValue) {
        this.setParamValue(TAG_WFVIEWPARAM3, strValue);
    }

    public final boolean isWFVIEWPARAM4Null() {
        return this.isParamNull(TAG_WFVIEWPARAM4);
    }

    public final String getWFVIEWPARAM4() {
        return this.getParamStringValue(TAG_WFVIEWPARAM4, "");
    }

    public final void setWFVIEWPARAM4(String strValue) {
        this.setParamValue(TAG_WFVIEWPARAM4, strValue);
    }

    public final boolean isPSSUBSYSIDNull() {
        return this.isParamNull(TAG_PSSUBSYSID);
    }

    public final String getPSSUBSYSID() {
        return this.getParamStringValue(TAG_PSSUBSYSID, "");
    }

    public final void setPSSUBSYSID(String strValue) {
        this.setParamValue(TAG_PSSUBSYSID, strValue);
    }

    public final boolean isPSSUBSYSNAMENull() {
        return this.isParamNull(TAG_PSSUBSYSNAME);
    }

    public final String getPSSUBSYSNAME() {
        return this.getParamStringValue(TAG_PSSUBSYSNAME, "");
    }

    public final void setPSSUBSYSNAME(String strValue) {
        this.setParamValue(TAG_PSSUBSYSNAME, strValue);
    }

    public final boolean isPSSUBDEVIEWIDNull() {
        return this.isParamNull(TAG_PSSUBDEVIEWID);
    }

    public final String getPSSUBDEVIEWID() {
        return this.getParamStringValue(TAG_PSSUBDEVIEWID, "");
    }

    public final void setPSSUBDEVIEWID(String strValue) {
        this.setParamValue(TAG_PSSUBDEVIEWID, strValue);
    }

    public final boolean isPSSUBDEVIEWNAMENull() {
        return this.isParamNull(TAG_PSSUBDEVIEWNAME);
    }

    public final String getPSSUBDEVIEWNAME() {
        return this.getParamStringValue(TAG_PSSUBDEVIEWNAME, "");
    }

    public final void setPSSUBDEVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSSUBDEVIEWNAME, strValue);
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

    public final boolean isPSSUBVIEWTYPEIDNull() {
        return this.isParamNull(TAG_PSSUBVIEWTYPEID);
    }

    public final String getPSSUBVIEWTYPEID() {
        return this.getParamStringValue(TAG_PSSUBVIEWTYPEID, "");
    }

    public final void setPSSUBVIEWTYPEID(String strValue) {
        this.setParamValue(TAG_PSSUBVIEWTYPEID, strValue);
    }

    public final boolean isPSSUBVIEWTYPENAMENull() {
        return this.isParamNull(TAG_PSSUBVIEWTYPENAME);
    }

    public final String getPSSUBVIEWTYPENAME() {
        return this.getParamStringValue(TAG_PSSUBVIEWTYPENAME, "");
    }

    public final void setPSSUBVIEWTYPENAME(String strValue) {
        this.setParamValue(TAG_PSSUBVIEWTYPENAME, strValue);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.isParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.getParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.setParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.isParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.getParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.setParamValue(TAG_PSDEMAINSTATENAME, strValue);
    }

    public final boolean isACCUSERMODENull() {
        return this.isParamNull(TAG_ACCUSERMODE);
    }

    public final String getACCUSERMODE() {
        return this.getParamStringValue(TAG_ACCUSERMODE, "");
    }

    public final void setACCUSERMODE(String strValue) {
        this.setParamValue(TAG_ACCUSERMODE, strValue);
    }

    public final boolean isPSSYSUNIRESIDNull() {
        return this.isParamNull(TAG_PSSYSUNIRESID);
    }

    public final String getPSSYSUNIRESID() {
        return this.getParamStringValue(TAG_PSSYSUNIRESID, "");
    }

    public final void setPSSYSUNIRESID(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESID, strValue);
    }

    public final boolean isPSSYSUNIRESNAMENull() {
        return this.isParamNull(TAG_PSSYSUNIRESNAME);
    }

    public final String getPSSYSUNIRESNAME() {
        return this.getParamStringValue(TAG_PSSYSUNIRESNAME, "");
    }

    public final void setPSSYSUNIRESNAME(String strValue) {
        this.setParamValue(TAG_PSSYSUNIRESNAME, strValue);
    }

    public final boolean isPSSYSREQITEMIDNull() {
        return this.isParamNull(TAG_PSSYSREQITEMID);
    }

    public final String getPSSYSREQITEMID() {
        return this.getParamStringValue(TAG_PSSYSREQITEMID, "");
    }

    public final void setPSSYSREQITEMID(String strValue) {
        this.setParamValue(TAG_PSSYSREQITEMID, strValue);
    }

    public final boolean isPSSYSREQITEMNAMENull() {
        return this.isParamNull(TAG_PSSYSREQITEMNAME);
    }

    public final String getPSSYSREQITEMNAME() {
        return this.getParamStringValue(TAG_PSSYSREQITEMNAME, "");
    }

    public final void setPSSYSREQITEMNAME(String strValue) {
        this.setParamValue(TAG_PSSYSREQITEMNAME, strValue);
    }

    public final boolean isPSVIEWMSGGROUPIDNull() {
        return this.isParamNull(TAG_PSVIEWMSGGROUPID);
    }

    public final String getPSVIEWMSGGROUPID() {
        return this.getParamStringValue(TAG_PSVIEWMSGGROUPID, "");
    }

    public final void setPSVIEWMSGGROUPID(String strValue) {
        this.setParamValue(TAG_PSVIEWMSGGROUPID, strValue);
    }

    public final boolean isPSVIEWMSGGROUPNAMENull() {
        return this.isParamNull(TAG_PSVIEWMSGGROUPNAME);
    }

    public final String getPSVIEWMSGGROUPNAME() {
        return this.getParamStringValue(TAG_PSVIEWMSGGROUPNAME, "");
    }

    public final void setPSVIEWMSGGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSVIEWMSGGROUPNAME, strValue);
    }

    public final boolean isTODOTASKNull() {
        return this.isParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.getParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.setParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isPDTPARAMPRENull() {
        return this.isParamNull(TAG_PDTPARAMPRE);
    }

    public final String getPDTPARAMPRE() {
        return this.getParamStringValue(TAG_PDTPARAMPRE, "");
    }

    public final void setPDTPARAMPRE(String strValue) {
        this.setParamValue(TAG_PDTPARAMPRE, strValue);
    }

    public final boolean isPSDEAWGROUPIDNull() {
        return this.isParamNull(TAG_PSDEAWGROUPID);
    }

    public final String getPSDEAWGROUPID() {
        return this.getParamStringValue(TAG_PSDEAWGROUPID, "");
    }

    public final void setPSDEAWGROUPID(String strValue) {
        this.setParamValue(TAG_PSDEAWGROUPID, strValue);
    }

    public final boolean isPSDEAWGROUPNAMENull() {
        return this.isParamNull(TAG_PSDEAWGROUPNAME);
    }

    public final String getPSDEAWGROUPNAME() {
        return this.getParamStringValue(TAG_PSDEAWGROUPNAME, "");
    }

    public final void setPSDEAWGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSDEAWGROUPNAME, strValue);
    }

    public final boolean isTITLEPSLANRESIDNull() {
        return this.isParamNull(TAG_TITLEPSLANRESID);
    }

    public final String getTITLEPSLANRESID() {
        return this.getParamStringValue(TAG_TITLEPSLANRESID, "");
    }

    public final void setTITLEPSLANRESID(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESID, strValue);
    }

    public final boolean isTITLEPSLANRESNAMENull() {
        return this.isParamNull(TAG_TITLEPSLANRESNAME);
    }

    public final String getTITLEPSLANRESNAME() {
        return this.getParamStringValue(TAG_TITLEPSLANRESNAME, "");
    }

    public final void setTITLEPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_TITLEPSLANRESNAME, strValue);
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

    public final boolean isSUBCAPPSLANRESIDNull() {
        return this.isParamNull(TAG_SUBCAPPSLANRESID);
    }

    public final String getSUBCAPPSLANRESID() {
        return this.getParamStringValue(TAG_SUBCAPPSLANRESID, "");
    }

    public final void setSUBCAPPSLANRESID(String strValue) {
        this.setParamValue(TAG_SUBCAPPSLANRESID, strValue);
    }

    public final boolean isSUBCAPPSLANRESNAMENull() {
        return this.isParamNull(TAG_SUBCAPPSLANRESNAME);
    }

    public final String getSUBCAPPSLANRESNAME() {
        return this.getParamStringValue(TAG_SUBCAPPSLANRESNAME, "");
    }

    public final void setSUBCAPPSLANRESNAME(String strValue) {
        this.setParamValue(TAG_SUBCAPPSLANRESNAME, strValue);
    }

    public final boolean isPSHELPMODULEIDNull() {
        return this.isParamNull(TAG_PSHELPMODULEID);
    }

    public final String getPSHELPMODULEID() {
        return this.getParamStringValue(TAG_PSHELPMODULEID, "");
    }

    public final void setPSHELPMODULEID(String strValue) {
        this.setParamValue(TAG_PSHELPMODULEID, strValue);
    }

    public final boolean isPSHELPMODULENAMENull() {
        return this.isParamNull(TAG_PSHELPMODULENAME);
    }

    public final String getPSHELPMODULENAME() {
        return this.getParamStringValue(TAG_PSHELPMODULENAME, "");
    }

    public final void setPSHELPMODULENAME(String strValue) {
        this.setParamValue(TAG_PSHELPMODULENAME, strValue);
    }

    public final boolean isREADONLYMODENull() {
        return this.isParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.getParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.setParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
    }

    public final boolean isSHOWCAPTIONBARNull() {
        return this.isParamNull(TAG_SHOWCAPTIONBAR);
    }

    public final boolean getSHOWCAPTIONBAR() {
        return this.getParamIntValue(TAG_SHOWCAPTIONBAR, 0) == 1;
    }

    public final void setSHOWCAPTIONBAR(boolean bValue) {
        this.setParamValue(TAG_SHOWCAPTIONBAR, bValue ? 1 : 0);
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

    public final boolean isPSVIEWENGINEIDNull() {
        return this.isParamNull(TAG_PSVIEWENGINEID);
    }

    public final String getPSVIEWENGINEID() {
        return this.getParamStringValue(TAG_PSVIEWENGINEID, "");
    }

    public final void setPSVIEWENGINEID(String strValue) {
        this.setParamValue(TAG_PSVIEWENGINEID, strValue);
    }

    public final boolean isPSVIEWENGINENAMENull() {
        return this.isParamNull(TAG_PSVIEWENGINENAME);
    }

    public final String getPSVIEWENGINENAME() {
        return this.getParamStringValue(TAG_PSVIEWENGINENAME, "");
    }

    public final void setPSVIEWENGINENAME(String strValue) {
        this.setParamValue(TAG_PSVIEWENGINENAME, strValue);
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

    public final boolean isVIEWPARAM3Null() {
        return this.isParamNull(TAG_VIEWPARAM3);
    }

    public final int getVIEWPARAM3() {
        return this.getParamIntValue(TAG_VIEWPARAM3, 0);
    }

    public final void setVIEWPARAM3(int nValue) {
        this.setParamValue(TAG_VIEWPARAM3, nValue);
    }

    public final boolean isVIEWPARAM4Null() {
        return this.isParamNull(TAG_VIEWPARAM4);
    }

    public final int getVIEWPARAM4() {
        return this.getParamIntValue(TAG_VIEWPARAM4, 0);
    }

    public final void setVIEWPARAM4(int nValue) {
        this.setParamValue(TAG_VIEWPARAM4, nValue);
    }

    public final boolean isVIEWPARAM7Null() {
        return this.isParamNull(TAG_VIEWPARAM7);
    }

    public final String getVIEWPARAM7() {
        return this.getParamStringValue(TAG_VIEWPARAM7, "");
    }

    public final void setVIEWPARAM7(String strValue) {
        this.setParamValue(TAG_VIEWPARAM7, strValue);
    }

    public final boolean isVIEWPARAM8Null() {
        return this.isParamNull(TAG_VIEWPARAM8);
    }

    public final String getVIEWPARAM8() {
        return this.getParamStringValue(TAG_VIEWPARAM8, "");
    }

    public final void setVIEWPARAM8(String strValue) {
        this.setParamValue(TAG_VIEWPARAM8, strValue);
    }

    public final boolean isVIEWPARAM9Null() {
        return this.isParamNull(TAG_VIEWPARAM9);
    }

    public final int getVIEWPARAM9() {
        return this.getParamIntValue(TAG_VIEWPARAM9, 0);
    }

    public final void setVIEWPARAM9(int nValue) {
        this.setParamValue(TAG_VIEWPARAM9, nValue);
    }

    public final boolean isVIEWPARAM10Null() {
        return this.isParamNull(TAG_VIEWPARAM10);
    }

    public final int getVIEWPARAM10() {
        return this.getParamIntValue(TAG_VIEWPARAM10, 0);
    }

    public final void setVIEWPARAM10(int nValue) {
        this.setParamValue(TAG_VIEWPARAM10, nValue);
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

    public final boolean isPSDYNADEVIEWTEMPLIDNull() {
        return this.isParamNull(TAG_PSDYNADEVIEWTEMPLID);
    }

    public final String getPSDYNADEVIEWTEMPLID() {
        return this.getParamStringValue(TAG_PSDYNADEVIEWTEMPLID, "");
    }

    public final void setPSDYNADEVIEWTEMPLID(String strValue) {
        this.setParamValue(TAG_PSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLNAMENull() {
        return this.isParamNull(TAG_PSDYNADEVIEWTEMPLNAME);
    }

    public final String getPSDYNADEVIEWTEMPLNAME() {
        return this.getParamStringValue(TAG_PSDYNADEVIEWTEMPLNAME, "");
    }

    public final void setPSDYNADEVIEWTEMPLNAME(String strValue) {
        this.setParamValue(TAG_PSDYNADEVIEWTEMPLNAME, strValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.isParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.getParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.setParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isHEADERINFONull() {
        return this.isParamNull(TAG_HEADERINFO);
    }

    public final String getHEADERINFO() {
        return this.getParamStringValue(TAG_HEADERINFO, "");
    }

    public final void setHEADERINFO(String strValue) {
        this.setParamValue(TAG_HEADERINFO, strValue);
    }

    public final boolean isBOTTOMINFONull() {
        return this.isParamNull(TAG_BOTTOMINFO);
    }

    public final String getBOTTOMINFO() {
        return this.getParamStringValue(TAG_BOTTOMINFO, "");
    }

    public final void setBOTTOMINFO(String strValue) {
        this.setParamValue(TAG_BOTTOMINFO, strValue);
    }
}

