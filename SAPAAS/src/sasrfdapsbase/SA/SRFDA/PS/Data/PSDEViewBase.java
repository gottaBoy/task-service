/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_PSDERID = "PSDERID";
    public static final String TAG_PSDERNAME = "PSDERNAME";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_GROUPPSCODELISTID = "GROUPPSCODELISTID";
    public static final String TAG_GROUPPSCODELISTNAME = "GROUPPSCODELISTNAME";
    public static final String TAG_LAYOUTPANELMODE = "LAYOUTPANELMODE";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_VIEWPARAM11 = "VIEWPARAM11";
    public static final String TAG_VIEWPARAM12 = "VIEWPARAM12";
    public static final String TAG_VIEWPARAM13 = "VIEWPARAM13";
    public static final String TAG_VIEWPARAM14 = "VIEWPARAM14";
    public static final String TAG_VIEWPARAM15 = "VIEWPARAM15";
    public static final String TAG_VIEWPARAM16 = "VIEWPARAM16";
    public static final String TAG_VIEWPARAM17 = "VIEWPARAM17";
    public static final String TAG_VIEWPARAM18 = "VIEWPARAM18";
    public static final String TAG_DEVIEWTAG2 = "DEVIEWTAG2";

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

    public final boolean isPSDEVIEWBASETYPENull() {
        return this.IsParamNull(TAG_PSDEVIEWBASETYPE);
    }

    public final String getPSDEVIEWBASETYPE() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASETYPE, "");
    }

    public final void setPSDEVIEWBASETYPE(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASETYPE, strValue);
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

    public final boolean isTEMPLVIEWNull() {
        return this.IsParamNull(TAG_TEMPLVIEW);
    }

    public final boolean getTEMPLVIEW() {
        return this.GetParamIntValue(TAG_TEMPLVIEW, 0) == 1;
    }

    public final void setTEMPLVIEW(boolean bValue) {
        this.SetParamValue(TAG_TEMPLVIEW, bValue ? 1 : 0);
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

    public final boolean isTEMPLPSDEVIEWIDNull() {
        return this.IsParamNull(TAG_TEMPLPSDEVIEWID);
    }

    public final String getTEMPLPSDEVIEWID() {
        return this.GetParamStringValue(TAG_TEMPLPSDEVIEWID, "");
    }

    public final void setTEMPLPSDEVIEWID(String strValue) {
        this.SetParamValue(TAG_TEMPLPSDEVIEWID, strValue);
    }

    public final boolean isTEMPLPSDEVIEWNAMENull() {
        return this.IsParamNull(TAG_TEMPLPSDEVIEWNAME);
    }

    public final String getTEMPLPSDEVIEWNAME() {
        return this.GetParamStringValue(TAG_TEMPLPSDEVIEWNAME, "");
    }

    public final void setTEMPLPSDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_TEMPLPSDEVIEWNAME, strValue);
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

    public final boolean isSECPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_SECPSDETOOLBARID);
    }

    public final String getSECPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_SECPSDETOOLBARID, "");
    }

    public final void setSECPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_SECPSDETOOLBARID, strValue);
    }

    public final boolean isSECPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_SECPSDETOOLBARNAME);
    }

    public final String getSECPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_SECPSDETOOLBARNAME, "");
    }

    public final void setSECPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_SECPSDETOOLBARNAME, strValue);
    }

    public final boolean isVIEWSNNull() {
        return this.IsParamNull(TAG_VIEWSN);
    }

    public final String getVIEWSN() {
        return this.GetParamStringValue(TAG_VIEWSN, "");
    }

    public final void setVIEWSN(String strValue) {
        this.SetParamValue(TAG_VIEWSN, strValue);
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

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
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

    public final boolean isPSVTSTYLEIDNull() {
        return this.IsParamNull(TAG_PSVTSTYLEID);
    }

    public final String getPSVTSTYLEID() {
        return this.GetParamStringValue(TAG_PSVTSTYLEID, "");
    }

    public final void setPSVTSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSVTSTYLEID, strValue);
    }

    public final boolean isPSVTSTYLENAMENull() {
        return this.IsParamNull(TAG_PSVTSTYLENAME);
    }

    public final String getPSVTSTYLENAME() {
        return this.GetParamStringValue(TAG_PSVTSTYLENAME, "");
    }

    public final void setPSVTSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSVTSTYLENAME, strValue);
    }

    public final boolean isVIEWPARAMNull() {
        return this.IsParamNull(TAG_VIEWPARAM);
    }

    public final String getVIEWPARAM() {
        return this.GetParamStringValue(TAG_VIEWPARAM, "");
    }

    public final void setVIEWPARAM(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM, strValue);
    }

    public final boolean isVIEWPARAM2Null() {
        return this.IsParamNull(TAG_VIEWPARAM2);
    }

    public final String getVIEWPARAM2() {
        return this.GetParamStringValue(TAG_VIEWPARAM2, "");
    }

    public final void setVIEWPARAM2(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM2, strValue);
    }

    public final boolean isTITLENull() {
        return this.IsParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.GetParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.SetParamValue(TAG_TITLE, strValue);
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

    public final boolean isLOADDEFAULTNull() {
        return this.IsParamNull(TAG_LOADDEFAULT);
    }

    public final boolean getLOADDEFAULT() {
        return this.GetParamIntValue(TAG_LOADDEFAULT, 0) == 1;
    }

    public final void setLOADDEFAULT(boolean bValue) {
        this.SetParamValue(TAG_LOADDEFAULT, bValue ? 1 : 0);
    }

    public final boolean isVIEWPARAM5Null() {
        return this.IsParamNull(TAG_VIEWPARAM5);
    }

    public final boolean getVIEWPARAM5() {
        return this.GetParamIntValue(TAG_VIEWPARAM5, 0) == 1;
    }

    public final void setVIEWPARAM5(boolean bValue) {
        this.SetParamValue(TAG_VIEWPARAM5, bValue ? 1 : 0);
    }

    public final boolean isVIEWPARAM6Null() {
        return this.IsParamNull(TAG_VIEWPARAM6);
    }

    public final boolean getVIEWPARAM6() {
        return this.GetParamIntValue(TAG_VIEWPARAM6, 0) == 1;
    }

    public final void setVIEWPARAM6(boolean bValue) {
        this.SetParamValue(TAG_VIEWPARAM6, bValue ? 1 : 0);
    }

    public final boolean isPREDEFINEVIEWTYPENull() {
        return this.IsParamNull(TAG_PREDEFINEVIEWTYPE);
    }

    public final String getPREDEFINEVIEWTYPE() {
        return this.GetParamStringValue(TAG_PREDEFINEVIEWTYPE, "");
    }

    public final void setPREDEFINEVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PREDEFINEVIEWTYPE, strValue);
    }

    public final boolean isPDVTPARAMNull() {
        return this.IsParamNull(TAG_PDVTPARAM);
    }

    public final String getPDVTPARAM() {
        return this.GetParamStringValue(TAG_PDVTPARAM, "");
    }

    public final void setPDVTPARAM(String strValue) {
        this.SetParamValue(TAG_PDVTPARAM, strValue);
    }

    public final boolean isTEMPMODENull() {
        return this.IsParamNull(TAG_TEMPMODE);
    }

    public final int getTEMPMODE() {
        return this.GetParamIntValue(TAG_TEMPMODE, 0);
    }

    public final void setTEMPMODE(int nValue) {
        this.SetParamValue(TAG_TEMPMODE, nValue);
    }

    public final boolean isOPENMODENull() {
        return this.IsParamNull(TAG_OPENMODE);
    }

    public final String getOPENMODE() {
        return this.GetParamStringValue(TAG_OPENMODE, "");
    }

    public final void setOPENMODE(String strValue) {
        this.SetParamValue(TAG_OPENMODE, strValue);
    }

    public final boolean isPSWFDEIDNull() {
        return this.IsParamNull(TAG_PSWFDEID);
    }

    public final String getPSWFDEID() {
        return this.GetParamStringValue(TAG_PSWFDEID, "");
    }

    public final void setPSWFDEID(String strValue) {
        this.SetParamValue(TAG_PSWFDEID, strValue);
    }

    public final boolean isPSWFDENAMENull() {
        return this.IsParamNull(TAG_PSWFDENAME);
    }

    public final String getPSWFDENAME() {
        return this.GetParamStringValue(TAG_PSWFDENAME, "");
    }

    public final void setPSWFDENAME(String strValue) {
        this.SetParamValue(TAG_PSWFDENAME, strValue);
    }

    public final boolean isPSWFVERSIONIDNull() {
        return this.IsParamNull(TAG_PSWFVERSIONID);
    }

    public final String getPSWFVERSIONID() {
        return this.GetParamStringValue(TAG_PSWFVERSIONID, "");
    }

    public final void setPSWFVERSIONID(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONID, strValue);
    }

    public final boolean isPSWFVERSIONNAMENull() {
        return this.IsParamNull(TAG_PSWFVERSIONNAME);
    }

    public final String getPSWFVERSIONNAME() {
        return this.GetParamStringValue(TAG_PSWFVERSIONNAME, "");
    }

    public final void setPSWFVERSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSWFVERSIONNAME, strValue);
    }

    public final boolean isPSWFIDNull() {
        return this.IsParamNull(TAG_PSWFID);
    }

    public final String getPSWFID() {
        return this.GetParamStringValue(TAG_PSWFID, "");
    }

    public final void setPSWFID(String strValue) {
        this.SetParamValue(TAG_PSWFID, strValue);
    }

    public final boolean isVIEWPARAMSNull() {
        return this.IsParamNull(TAG_VIEWPARAMS);
    }

    public final String getVIEWPARAMS() {
        return this.GetParamStringValue(TAG_VIEWPARAMS, "");
    }

    public final void setVIEWPARAMS(String strValue) {
        this.SetParamValue(TAG_VIEWPARAMS, strValue);
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

    public final boolean isVIEWACTIONSNull() {
        return this.IsParamNull(TAG_VIEWACTIONS);
    }

    public final int getVIEWACTIONS() {
        return this.GetParamIntValue(TAG_VIEWACTIONS, 0);
    }

    public final void setVIEWACTIONS(int nValue) {
        this.SetParamValue(TAG_VIEWACTIONS, nValue);
    }

    public final boolean isSUBCAPTIONNull() {
        return this.IsParamNull(TAG_SUBCAPTION);
    }

    public final String getSUBCAPTION() {
        return this.GetParamStringValue(TAG_SUBCAPTION, "");
    }

    public final void setSUBCAPTION(String strValue) {
        this.SetParamValue(TAG_SUBCAPTION, strValue);
    }

    public final boolean isWFVIEWPARAMNull() {
        return this.IsParamNull(TAG_WFVIEWPARAM);
    }

    public final boolean getWFVIEWPARAM() {
        return this.GetParamIntValue(TAG_WFVIEWPARAM, 0) == 1;
    }

    public final void setWFVIEWPARAM(boolean bValue) {
        this.SetParamValue(TAG_WFVIEWPARAM, bValue ? 1 : 0);
    }

    public final boolean isWFVIEWPARAM2Null() {
        return this.IsParamNull(TAG_WFVIEWPARAM2);
    }

    public final boolean getWFVIEWPARAM2() {
        return this.GetParamIntValue(TAG_WFVIEWPARAM2, 0) == 1;
    }

    public final void setWFVIEWPARAM2(boolean bValue) {
        this.SetParamValue(TAG_WFVIEWPARAM2, bValue ? 1 : 0);
    }

    public final boolean isWFVIEWPARAM3Null() {
        return this.IsParamNull(TAG_WFVIEWPARAM3);
    }

    public final String getWFVIEWPARAM3() {
        return this.GetParamStringValue(TAG_WFVIEWPARAM3, "");
    }

    public final void setWFVIEWPARAM3(String strValue) {
        this.SetParamValue(TAG_WFVIEWPARAM3, strValue);
    }

    public final boolean isWFVIEWPARAM4Null() {
        return this.IsParamNull(TAG_WFVIEWPARAM4);
    }

    public final String getWFVIEWPARAM4() {
        return this.GetParamStringValue(TAG_WFVIEWPARAM4, "");
    }

    public final void setWFVIEWPARAM4(String strValue) {
        this.SetParamValue(TAG_WFVIEWPARAM4, strValue);
    }

    public final boolean isPSSUBSYSIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSID);
    }

    public final String getPSSUBSYSID() {
        return this.GetParamStringValue(TAG_PSSUBSYSID, "");
    }

    public final void setPSSUBSYSID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSID, strValue);
    }

    public final boolean isPSSUBSYSNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSNAME);
    }

    public final String getPSSUBSYSNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSNAME, "");
    }

    public final void setPSSUBSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSNAME, strValue);
    }

    public final boolean isPSSUBDEVIEWIDNull() {
        return this.IsParamNull(TAG_PSSUBDEVIEWID);
    }

    public final String getPSSUBDEVIEWID() {
        return this.GetParamStringValue(TAG_PSSUBDEVIEWID, "");
    }

    public final void setPSSUBDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSUBDEVIEWID, strValue);
    }

    public final boolean isPSSUBDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSUBDEVIEWNAME);
    }

    public final String getPSSUBDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSUBDEVIEWNAME, "");
    }

    public final void setPSSUBDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBDEVIEWNAME, strValue);
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

    public final boolean isPSSUBVIEWTYPEIDNull() {
        return this.IsParamNull(TAG_PSSUBVIEWTYPEID);
    }

    public final String getPSSUBVIEWTYPEID() {
        return this.GetParamStringValue(TAG_PSSUBVIEWTYPEID, "");
    }

    public final void setPSSUBVIEWTYPEID(String strValue) {
        this.SetParamValue(TAG_PSSUBVIEWTYPEID, strValue);
    }

    public final boolean isPSSUBVIEWTYPENAMENull() {
        return this.IsParamNull(TAG_PSSUBVIEWTYPENAME);
    }

    public final String getPSSUBVIEWTYPENAME() {
        return this.GetParamStringValue(TAG_PSSUBVIEWTYPENAME, "");
    }

    public final void setPSSUBVIEWTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSSUBVIEWTYPENAME, strValue);
    }

    public final boolean isPSDEMAINSTATEIDNull() {
        return this.IsParamNull(TAG_PSDEMAINSTATEID);
    }

    public final String getPSDEMAINSTATEID() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATEID, "");
    }

    public final void setPSDEMAINSTATEID(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATEID, strValue);
    }

    public final boolean isPSDEMAINSTATENAMENull() {
        return this.IsParamNull(TAG_PSDEMAINSTATENAME);
    }

    public final String getPSDEMAINSTATENAME() {
        return this.GetParamStringValue(TAG_PSDEMAINSTATENAME, "");
    }

    public final void setPSDEMAINSTATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAINSTATENAME, strValue);
    }

    public final boolean isACCUSERMODENull() {
        return this.IsParamNull(TAG_ACCUSERMODE);
    }

    public final String getACCUSERMODE() {
        return this.GetParamStringValue(TAG_ACCUSERMODE, "");
    }

    public final void setACCUSERMODE(String strValue) {
        this.SetParamValue(TAG_ACCUSERMODE, strValue);
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

    public final boolean isTODOTASKNull() {
        return this.IsParamNull(TAG_TODOTASK);
    }

    public final String getTODOTASK() {
        return this.GetParamStringValue(TAG_TODOTASK, "");
    }

    public final void setTODOTASK(String strValue) {
        this.SetParamValue(TAG_TODOTASK, strValue);
    }

    public final boolean isPDTPARAMPRENull() {
        return this.IsParamNull(TAG_PDTPARAMPRE);
    }

    public final String getPDTPARAMPRE() {
        return this.GetParamStringValue(TAG_PDTPARAMPRE, "");
    }

    public final void setPDTPARAMPRE(String strValue) {
        this.SetParamValue(TAG_PDTPARAMPRE, strValue);
    }

    public final boolean isPSDEAWGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEAWGROUPID);
    }

    public final String getPSDEAWGROUPID() {
        return this.GetParamStringValue(TAG_PSDEAWGROUPID, "");
    }

    public final void setPSDEAWGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEAWGROUPID, strValue);
    }

    public final boolean isPSDEAWGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEAWGROUPNAME);
    }

    public final String getPSDEAWGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEAWGROUPNAME, "");
    }

    public final void setPSDEAWGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEAWGROUPNAME, strValue);
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

    public final boolean isSUBCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_SUBCAPPSLANRESID);
    }

    public final String getSUBCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_SUBCAPPSLANRESID, "");
    }

    public final void setSUBCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_SUBCAPPSLANRESID, strValue);
    }

    public final boolean isSUBCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_SUBCAPPSLANRESNAME);
    }

    public final String getSUBCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_SUBCAPPSLANRESNAME, "");
    }

    public final void setSUBCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_SUBCAPPSLANRESNAME, strValue);
    }

    public final boolean isPSHELPMODULEIDNull() {
        return this.IsParamNull(TAG_PSHELPMODULEID);
    }

    public final String getPSHELPMODULEID() {
        return this.GetParamStringValue(TAG_PSHELPMODULEID, "");
    }

    public final void setPSHELPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULEID, strValue);
    }

    public final boolean isPSHELPMODULENAMENull() {
        return this.IsParamNull(TAG_PSHELPMODULENAME);
    }

    public final String getPSHELPMODULENAME() {
        return this.GetParamStringValue(TAG_PSHELPMODULENAME, "");
    }

    public final void setPSHELPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSHELPMODULENAME, strValue);
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

    public final boolean isSHOWCAPTIONBARNull() {
        return this.IsParamNull(TAG_SHOWCAPTIONBAR);
    }

    public final boolean getSHOWCAPTIONBAR() {
        return this.GetParamIntValue(TAG_SHOWCAPTIONBAR, 0) == 1;
    }

    public final void setSHOWCAPTIONBAR(boolean bValue) {
        this.SetParamValue(TAG_SHOWCAPTIONBAR, bValue ? 1 : 0);
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

    public final boolean isPSVIEWENGINEIDNull() {
        return this.IsParamNull(TAG_PSVIEWENGINEID);
    }

    public final String getPSVIEWENGINEID() {
        return this.GetParamStringValue(TAG_PSVIEWENGINEID, "");
    }

    public final void setPSVIEWENGINEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWENGINEID, strValue);
    }

    public final boolean isPSVIEWENGINENAMENull() {
        return this.IsParamNull(TAG_PSVIEWENGINENAME);
    }

    public final String getPSVIEWENGINENAME() {
        return this.GetParamStringValue(TAG_PSVIEWENGINENAME, "");
    }

    public final void setPSVIEWENGINENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWENGINENAME, strValue);
    }

    public final boolean isDYNCMODENull() {
        return this.IsParamNull(TAG_DYNCMODE);
    }

    public final int getDYNCMODE() {
        return this.GetParamIntValue(TAG_DYNCMODE, 0);
    }

    public final void setDYNCMODE(int bValue) {
        this.SetParamValue(TAG_DYNCMODE, bValue);
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

    public final boolean isVIEWPARAM3Null() {
        return this.IsParamNull(TAG_VIEWPARAM3);
    }

    public final int getVIEWPARAM3() {
        return this.GetParamIntValue(TAG_VIEWPARAM3, 0);
    }

    public final void setVIEWPARAM3(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM3, nValue);
    }

    public final boolean isVIEWPARAM4Null() {
        return this.IsParamNull(TAG_VIEWPARAM4);
    }

    public final int getVIEWPARAM4() {
        return this.GetParamIntValue(TAG_VIEWPARAM4, 0);
    }

    public final void setVIEWPARAM4(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM4, nValue);
    }

    public final boolean isVIEWPARAM7Null() {
        return this.IsParamNull(TAG_VIEWPARAM7);
    }

    public final String getVIEWPARAM7() {
        return this.GetParamStringValue(TAG_VIEWPARAM7, "");
    }

    public final void setVIEWPARAM7(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM7, strValue);
    }

    public final boolean isVIEWPARAM8Null() {
        return this.IsParamNull(TAG_VIEWPARAM8);
    }

    public final String getVIEWPARAM8() {
        return this.GetParamStringValue(TAG_VIEWPARAM8, "");
    }

    public final void setVIEWPARAM8(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM8, strValue);
    }

    public final boolean isVIEWPARAM9Null() {
        return this.IsParamNull(TAG_VIEWPARAM9);
    }

    public final int getVIEWPARAM9() {
        return this.GetParamIntValue(TAG_VIEWPARAM9, 0);
    }

    public final void setVIEWPARAM9(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM9, nValue);
    }

    public final boolean isVIEWPARAM10Null() {
        return this.IsParamNull(TAG_VIEWPARAM10);
    }

    public final int getVIEWPARAM10() {
        return this.GetParamIntValue(TAG_VIEWPARAM10, 0);
    }

    public final void setVIEWPARAM10(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM10, nValue);
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

    public final boolean isPSDYNADEVIEWTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDYNADEVIEWTEMPLID);
    }

    public final String getPSDYNADEVIEWTEMPLID() {
        return this.GetParamStringValue(TAG_PSDYNADEVIEWTEMPLID, "");
    }

    public final void setPSDYNADEVIEWTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDYNADEVIEWTEMPLID, strValue);
    }

    public final boolean isPSDYNADEVIEWTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDYNADEVIEWTEMPLNAME);
    }

    public final String getPSDYNADEVIEWTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDYNADEVIEWTEMPLNAME, "");
    }

    public final void setPSDYNADEVIEWTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDYNADEVIEWTEMPLNAME, strValue);
    }

    public final boolean isDYNAMODELFLAGNull() {
        return this.IsParamNull(TAG_DYNAMODELFLAG);
    }

    public final int getDYNAMODELFLAG() {
        return this.GetParamIntValue(TAG_DYNAMODELFLAG, 0);
    }

    public final void setDYNAMODELFLAG(int nValue) {
        this.SetParamValue(TAG_DYNAMODELFLAG, nValue);
    }

    public final boolean isHEADERINFONull() {
        return this.IsParamNull(TAG_HEADERINFO);
    }

    public final String getHEADERINFO() {
        return this.GetParamStringValue(TAG_HEADERINFO, "");
    }

    public final void setHEADERINFO(String strValue) {
        this.SetParamValue(TAG_HEADERINFO, strValue);
    }

    public final boolean isBOTTOMINFONull() {
        return this.IsParamNull(TAG_BOTTOMINFO);
    }

    public final String getBOTTOMINFO() {
        return this.GetParamStringValue(TAG_BOTTOMINFO, "");
    }

    public final void setBOTTOMINFO(String strValue) {
        this.SetParamValue(TAG_BOTTOMINFO, strValue);
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

    public final boolean isPSDERIDNull() {
        return this.IsParamNull(TAG_PSDERID);
    }

    public final String getPSDERID() {
        return this.GetParamStringValue(TAG_PSDERID, "");
    }

    public final void setPSDERID(String strValue) {
        this.SetParamValue(TAG_PSDERID, strValue);
    }

    public final boolean isPSDERNAMENull() {
        return this.IsParamNull(TAG_PSDERNAME);
    }

    public final String getPSDERNAME() {
        return this.GetParamStringValue(TAG_PSDERNAME, "");
    }

    public final void setPSDERNAME(String strValue) {
        this.SetParamValue(TAG_PSDERNAME, strValue);
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

    public final boolean isGROUPPSCODELISTIDNull() {
        return this.IsParamNull(TAG_GROUPPSCODELISTID);
    }

    public final String getGROUPPSCODELISTID() {
        return this.GetParamStringValue(TAG_GROUPPSCODELISTID, "");
    }

    public final void setGROUPPSCODELISTID(String strValue) {
        this.SetParamValue(TAG_GROUPPSCODELISTID, strValue);
    }

    public final boolean isGROUPPSCODELISTNAMENull() {
        return this.IsParamNull(TAG_GROUPPSCODELISTNAME);
    }

    public final String getGROUPPSCODELISTNAME() {
        return this.GetParamStringValue(TAG_GROUPPSCODELISTNAME, "");
    }

    public final void setGROUPPSCODELISTNAME(String strValue) {
        this.SetParamValue(TAG_GROUPPSCODELISTNAME, strValue);
    }

    public final boolean isLAYOUTPANELMODENull() {
        return this.IsParamNull(TAG_LAYOUTPANELMODE);
    }

    public final int getLAYOUTPANELMODE() {
        return this.GetParamIntValue(TAG_LAYOUTPANELMODE, 0);
    }

    public final void setLAYOUTPANELMODE(int nValue) {
        this.SetParamValue(TAG_LAYOUTPANELMODE, nValue);
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

    public final boolean isVIEWPARAM11Null() {
        return this.IsParamNull(TAG_VIEWPARAM11);
    }

    public final int getVIEWPARAM11() {
        return this.GetParamIntValue(TAG_VIEWPARAM11, 0);
    }

    public final void setVIEWPARAM11(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM11, nValue);
    }

    public final boolean isVIEWPARAM12Null() {
        return this.IsParamNull(TAG_VIEWPARAM12);
    }

    public final int getVIEWPARAM12() {
        return this.GetParamIntValue(TAG_VIEWPARAM12, 0);
    }

    public final void setVIEWPARAM12(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM12, nValue);
    }

    public final boolean isVIEWPARAM13Null() {
        return this.IsParamNull(TAG_VIEWPARAM13);
    }

    public final String getVIEWPARAM13() {
        return this.GetParamStringValue(TAG_VIEWPARAM13, "");
    }

    public final void setVIEWPARAM13(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM13, strValue);
    }

    public final boolean isVIEWPARAM14Null() {
        return this.IsParamNull(TAG_VIEWPARAM14);
    }

    public final String getVIEWPARAM14() {
        return this.GetParamStringValue(TAG_VIEWPARAM14, "");
    }

    public final void setVIEWPARAM14(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM14, strValue);
    }

    public final boolean isVIEWPARAM15Null() {
        return this.IsParamNull(TAG_VIEWPARAM15);
    }

    public final String getVIEWPARAM15() {
        return this.GetParamStringValue(TAG_VIEWPARAM15, "");
    }

    public final void setVIEWPARAM15(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM15, strValue);
    }

    public final boolean isVIEWPARAM16Null() {
        return this.IsParamNull(TAG_VIEWPARAM16);
    }

    public final String getVIEWPARAM16() {
        return this.GetParamStringValue(TAG_VIEWPARAM16, "");
    }

    public final void setVIEWPARAM16(String strValue) {
        this.SetParamValue(TAG_VIEWPARAM16, strValue);
    }

    public final boolean isVIEWPARAM17Null() {
        return this.IsParamNull(TAG_VIEWPARAM17);
    }

    public final int getVIEWPARAM17() {
        return this.GetParamIntValue(TAG_VIEWPARAM17, 0);
    }

    public final void setVIEWPARAM17(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM17, nValue);
    }

    public final boolean isVIEWPARAM18Null() {
        return this.IsParamNull(TAG_VIEWPARAM18);
    }

    public final int getVIEWPARAM18() {
        return this.GetParamIntValue(TAG_VIEWPARAM18, 0);
    }

    public final void setVIEWPARAM18(int nValue) {
        this.SetParamValue(TAG_VIEWPARAM18, nValue);
    }

    public final boolean isDEVIEWTAG2Null() {
        return this.IsParamNull(TAG_DEVIEWTAG2);
    }

    public final String getDEVIEWTAG2() {
        return this.GetParamStringValue(TAG_DEVIEWTAG2, "");
    }

    public final void setDEVIEWTAG2(String strValue) {
        this.SetParamValue(TAG_DEVIEWTAG2, strValue);
    }
}

