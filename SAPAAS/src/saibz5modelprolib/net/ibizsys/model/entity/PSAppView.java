/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppView
extends BaseDataEntity {
    public static final String PSAPPVIEWTYPE_APPDEVIEW = "APPDEVIEW";
    public static final String PSAPPVIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String PSDEVIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String PSDEVIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String PSDEVIEWTYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String PSDEVIEWTYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String PSDEVIEWTYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String PSDEVIEWTYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String PSDEVIEWTYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String PSDEVIEWTYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String PSDEVIEWTYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String PSDEVIEWTYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String PSDEVIEWTYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String PSDEVIEWTYPE_DEHTMLVIEW = "DEHTMLVIEW";
    public static final String PSDEVIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String PSDEVIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String TAG_PSAPPMODULENAME = "PSAPPMODULENAME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSAPPVIEWSTYLEID = "PSAPPVIEWSTYLEID";
    public static final String TAG_PSAPPVIEWSTYLENAME = "PSAPPVIEWSTYLENAME";
    public static final String TAG_PSAPPVIEWTYPE = "PSAPPVIEWTYPE";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String TAG_PSDEVIEWTYPE = "PSDEVIEWTYPE";
    public static final String TAG_USERREFFLAG = "USERREFFLAG";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_SUBCAPTION = "SUBCAPTION";
    public static final String TAG_PSSUBVIEWTYPEID = "PSSUBVIEWTYPEID";
    public static final String TAG_PSSUBVIEWTYPENAME = "PSSUBVIEWTYPENAME";
    public static final String TAG_ACCUSERMODE = "ACCUSERMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSVIEWWIZARDGROUPID = "PSVIEWWIZARDGROUPID";
    public static final String TAG_PSVIEWWIZARDGROUPNAME = "PSVIEWWIZARDGROUPNAME";
    public static final String TAG_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String TAG_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_SUBCAPPSLANRESID = "SUBCAPPSLANRESID";
    public static final String TAG_SUBCAPPSLANRESNAME = "SUBCAPPSLANRESNAME";
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_PSHELPMODULEID = "PSHELPMODULEID";
    public static final String TAG_PSHELPMODULENAME = "PSHELPMODULENAME";
    public static final String TAG_SHOWCAPTIONBAR = "SHOWCAPTIONBAR";
    public static final String TAG_SYSREFFLAG = "SYSREFFLAG";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_ENABLEVIEWSTYLE = "ENABLEVIEWSTYLE";
    public static final String TAG_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String TAG_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String TAG_DYNCMODE = "DYNCMODE";
    public static final String TAG_PREVENTXSS = "PREVENTXSS";
    public static final String TAG_PSAPPTITLEBARID = "PSAPPTITLEBARID";
    public static final String TAG_PSAPPTITLEBARNAME = "PSAPPTITLEBARNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String TAG_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String TAG_PSDYNADEVIEWTEMPLID = "PSDYNADEVIEWTEMPLID";
    public static final String TAG_PSDYNADEVIEWTEMPLNAME = "PSDYNADEVIEWTEMPLNAME";
    public static final String TAG_PSDYNADEVIEWTYPE = "PSDYNADEVIEWTYPE";
    public static final String TAG_PSAPPUTILVIEWTYPE = "PSAPPUTILVIEWTYPE";

    public final boolean isPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.getParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWID, strValue);
    }

    public final boolean isPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWNAME);
    }

    public final String getPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWNAME, "");
    }

    public final void setPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWNAME, strValue);
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

    public final boolean isPSAPPMODULEIDNull() {
        return this.isParamNull(TAG_PSAPPMODULEID);
    }

    public final String getPSAPPMODULEID() {
        return this.getParamStringValue(TAG_PSAPPMODULEID, "");
    }

    public final void setPSAPPMODULEID(String strValue) {
        this.setParamValue(TAG_PSAPPMODULEID, strValue);
    }

    public final boolean isPSAPPMODULENAMENull() {
        return this.isParamNull(TAG_PSAPPMODULENAME);
    }

    public final String getPSAPPMODULENAME() {
        return this.getParamStringValue(TAG_PSAPPMODULENAME, "");
    }

    public final void setPSAPPMODULENAME(String strValue) {
        this.setParamValue(TAG_PSAPPMODULENAME, strValue);
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

    public final boolean isPSAPPVIEWSTYLEIDNull() {
        return this.isParamNull(TAG_PSAPPVIEWSTYLEID);
    }

    public final String getPSAPPVIEWSTYLEID() {
        return this.getParamStringValue(TAG_PSAPPVIEWSTYLEID, "");
    }

    public final void setPSAPPVIEWSTYLEID(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWSTYLEID, strValue);
    }

    public final boolean isPSAPPVIEWSTYLENAMENull() {
        return this.isParamNull(TAG_PSAPPVIEWSTYLENAME);
    }

    public final String getPSAPPVIEWSTYLENAME() {
        return this.getParamStringValue(TAG_PSAPPVIEWSTYLENAME, "");
    }

    public final void setPSAPPVIEWSTYLENAME(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWSTYLENAME, strValue);
    }

    public final boolean isPSAPPVIEWTYPENull() {
        return this.isParamNull(TAG_PSAPPVIEWTYPE);
    }

    public final String getPSAPPVIEWTYPE() {
        return this.getParamStringValue(TAG_PSAPPVIEWTYPE, "");
    }

    public final void setPSAPPVIEWTYPE(String strValue) {
        this.setParamValue(TAG_PSAPPVIEWTYPE, strValue);
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

    public final boolean isPSDEVIEWTYPENull() {
        return this.isParamNull(TAG_PSDEVIEWTYPE);
    }

    public final String getPSDEVIEWTYPE() {
        return this.getParamStringValue(TAG_PSDEVIEWTYPE, "");
    }

    public final void setPSDEVIEWTYPE(String strValue) {
        this.setParamValue(TAG_PSDEVIEWTYPE, strValue);
    }

    public final boolean isUSERREFFLAGNull() {
        return this.isParamNull(TAG_USERREFFLAG);
    }

    public final boolean getUSERREFFLAG() {
        return this.getParamIntValue(TAG_USERREFFLAG, 0) == 1;
    }

    public final void setUSERREFFLAG(boolean bValue) {
        this.setParamValue(TAG_USERREFFLAG, bValue ? 1 : 0);
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

    public final boolean isTITLENull() {
        return this.isParamNull(TAG_TITLE);
    }

    public final String getTITLE() {
        return this.getParamStringValue(TAG_TITLE, "");
    }

    public final void setTITLE(String strValue) {
        this.setParamValue(TAG_TITLE, strValue);
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

    public final boolean isPSPFIDNull() {
        return this.isParamNull(TAG_PSPFID);
    }

    public final String getPSPFID() {
        return this.getParamStringValue(TAG_PSPFID, "");
    }

    public final void setPSPFID(String strValue) {
        this.setParamValue(TAG_PSPFID, strValue);
    }

    public final boolean isPSVIEWWIZARDGROUPIDNull() {
        return this.isParamNull(TAG_PSVIEWWIZARDGROUPID);
    }

    public final String getPSVIEWWIZARDGROUPID() {
        return this.getParamStringValue(TAG_PSVIEWWIZARDGROUPID, "");
    }

    public final void setPSVIEWWIZARDGROUPID(String strValue) {
        this.setParamValue(TAG_PSVIEWWIZARDGROUPID, strValue);
    }

    public final boolean isPSVIEWWIZARDGROUPNAMENull() {
        return this.isParamNull(TAG_PSVIEWWIZARDGROUPNAME);
    }

    public final String getPSVIEWWIZARDGROUPNAME() {
        return this.getParamStringValue(TAG_PSVIEWWIZARDGROUPNAME, "");
    }

    public final void setPSVIEWWIZARDGROUPNAME(String strValue) {
        this.setParamValue(TAG_PSVIEWWIZARDGROUPNAME, strValue);
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

    public final boolean isSHOWCAPTIONBARNull() {
        return this.isParamNull(TAG_SHOWCAPTIONBAR);
    }

    public final boolean getSHOWCAPTIONBAR() {
        return this.getParamIntValue(TAG_SHOWCAPTIONBAR, 0) == 1;
    }

    public final void setSHOWCAPTIONBAR(boolean bValue) {
        this.setParamValue(TAG_SHOWCAPTIONBAR, bValue ? 1 : 0);
    }

    public final boolean isSYSREFFLAGNull() {
        return this.isParamNull(TAG_SYSREFFLAG);
    }

    public final boolean getSYSREFFLAG() {
        return this.getParamIntValue(TAG_SYSREFFLAG, 0) == 1;
    }

    public final void setSYSREFFLAG(boolean bValue) {
        this.setParamValue(TAG_SYSREFFLAG, bValue ? 1 : 0);
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

    public final boolean isENABLEVIEWSTYLENull() {
        return this.isParamNull(TAG_ENABLEVIEWSTYLE);
    }

    public final boolean getENABLEVIEWSTYLE() {
        return this.getParamIntValue(TAG_ENABLEVIEWSTYLE, 0) == 1;
    }

    public final void setENABLEVIEWSTYLE(boolean bValue) {
        this.setParamValue(TAG_ENABLEVIEWSTYLE, bValue ? 1 : 0);
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

    public final boolean isPREVENTXSSNull() {
        return this.isParamNull(TAG_PREVENTXSS);
    }

    public final boolean getPREVENTXSS() {
        return this.getParamIntValue(TAG_PREVENTXSS, 0) == 1;
    }

    public final void setPREVENTXSS(boolean bValue) {
        this.setParamValue(TAG_PREVENTXSS, bValue ? 1 : 0);
    }

    public final boolean isPSAPPTITLEBARIDNull() {
        return this.isParamNull(TAG_PSAPPTITLEBARID);
    }

    public final String getPSAPPTITLEBARID() {
        return this.getParamStringValue(TAG_PSAPPTITLEBARID, "");
    }

    public final void setPSAPPTITLEBARID(String strValue) {
        this.setParamValue(TAG_PSAPPTITLEBARID, strValue);
    }

    public final boolean isPSAPPTITLEBARNAMENull() {
        return this.isParamNull(TAG_PSAPPTITLEBARNAME);
    }

    public final String getPSAPPTITLEBARNAME() {
        return this.getParamStringValue(TAG_PSAPPTITLEBARNAME, "");
    }

    public final void setPSAPPTITLEBARNAME(String strValue) {
        this.setParamValue(TAG_PSAPPTITLEBARNAME, strValue);
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

    public final boolean isPSDYNADEVIEWTYPENull() {
        return this.isParamNull(TAG_PSDYNADEVIEWTYPE);
    }

    public final String getPSDYNADEVIEWTYPE() {
        return this.getParamStringValue(TAG_PSDYNADEVIEWTYPE, "");
    }

    public final void setPSDYNADEVIEWTYPE(String strValue) {
        this.setParamValue(TAG_PSDYNADEVIEWTYPE, strValue);
    }

    public final boolean isPSAPPUTILVIEWTYPENull() {
        return this.isParamNull(TAG_PSAPPUTILVIEWTYPE);
    }

    public final String getPSAPPUTILVIEWTYPE() {
        return this.getParamStringValue(TAG_PSAPPUTILVIEWTYPE, "");
    }

    public final void setPSAPPUTILVIEWTYPE(String strValue) {
        this.setParamValue(TAG_PSAPPUTILVIEWTYPE, strValue);
    }
}

