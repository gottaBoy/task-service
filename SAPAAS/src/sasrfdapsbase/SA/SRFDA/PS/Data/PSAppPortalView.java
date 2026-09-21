/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSAppPortalView
extends BaseDataEntity {
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
    public static final String PSDEVIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String PSDEVIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String PSDEVIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String PSDEVIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String TAG_DEFAULTPAGE = "DEFAULTPAGE";
    public static final String USERREFFLAG_1 = "1";
    public static final String USERREFFLAG_0 = "0";
    public static final String TAG_PSAPPPORTALVIEWID = "PSAPPPORTALVIEWID";
    public static final String TAG_PSAPPPORTALVIEWNAME = "PSAPPPORTALVIEWNAME";
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
    public static final String TAG_COLMODEL = "COLMODEL";
    public static final String TAG_ACCUSERMODE = "ACCUSERMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";
    public static final String TAG_PSAPPUTILVIEWTYPE = "PSAPPUTILVIEWTYPE";
    public static final String TAG_LAYOUTMODE = "LAYOUTMODE";
    public static final String TAG_DBMODEL = "DBMODEL";
    public static final String TAG_FLEXALIGN = "FLEXALIGN";
    public static final String TAG_FLEXDIR = "FLEXDIR";
    public static final String TAG_FLEXVALIGN = "FLEXVALIGN";
    public static final String TAG_ENABLECUSTOMIZE = "ENABLECUSTOMIZE";
    public static final String TAG_DASHBOARDSTYLE = "DASHBOARDSTYLE";
    public static final String TAG_DASHBOARDTAG2 = "DASHBOARDTAG2";
    public static final String TAG_DASHBOARDTAG = "DASHBOARDTAG";
    public static final String TAG_DASHBOARDNAVBAR = "DASHBOARDNAVBAR";
    public static final String TAG_NAVBARHEIGHT = "NAVBARHEIGHT";
    public static final String TAG_NAVBARPOS = "NAVBARPOS";
    public static final String TAG_NAVBARSTYLE = "NAVBARSTYLE";
    public static final String TAG_NAVBARWIDTH = "NAVBARWIDTH";
    public static final String TAG_NAVBARPSSYSCSSID = "NAVBARPSSYSCSSID";
    public static final String TAG_NAVBARPSSYSCSSNAME = "NAVBARPSSYSCSSNAME";

    public final boolean isPSAPPPORTALVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPPORTALVIEWID);
    }

    public final String getPSAPPPORTALVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPPORTALVIEWID, "");
    }

    public final void setPSAPPPORTALVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPPORTALVIEWID, strValue);
    }

    public final boolean isPSAPPPORTALVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPPORTALVIEWNAME);
    }

    public final String getPSAPPPORTALVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPPORTALVIEWNAME, "");
    }

    public final void setPSAPPPORTALVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPPORTALVIEWNAME, strValue);
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

    public final boolean isPSAPPMODULEIDNull() {
        return this.IsParamNull(TAG_PSAPPMODULEID);
    }

    public final String getPSAPPMODULEID() {
        return this.GetParamStringValue(TAG_PSAPPMODULEID, "");
    }

    public final void setPSAPPMODULEID(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULEID, strValue);
    }

    public final boolean isPSAPPMODULENAMENull() {
        return this.IsParamNull(TAG_PSAPPMODULENAME);
    }

    public final String getPSAPPMODULENAME() {
        return this.GetParamStringValue(TAG_PSAPPMODULENAME, "");
    }

    public final void setPSAPPMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMODULENAME, strValue);
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

    public final boolean isPSAPPVIEWSTYLEIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWSTYLEID);
    }

    public final String getPSAPPVIEWSTYLEID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWSTYLEID, "");
    }

    public final void setPSAPPVIEWSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWSTYLEID, strValue);
    }

    public final boolean isPSAPPVIEWSTYLENAMENull() {
        return this.IsParamNull(TAG_PSAPPVIEWSTYLENAME);
    }

    public final String getPSAPPVIEWSTYLENAME() {
        return this.GetParamStringValue(TAG_PSAPPVIEWSTYLENAME, "");
    }

    public final void setPSAPPVIEWSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWSTYLENAME, strValue);
    }

    public final boolean isPSAPPVIEWTYPENull() {
        return this.IsParamNull(TAG_PSAPPVIEWTYPE);
    }

    public final String getPSAPPVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSAPPVIEWTYPE, "");
    }

    public final void setPSAPPVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWTYPE, strValue);
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

    public final boolean isPSDEVIEWTYPENull() {
        return this.IsParamNull(TAG_PSDEVIEWTYPE);
    }

    public final String getPSDEVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSDEVIEWTYPE, "");
    }

    public final void setPSDEVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWTYPE, strValue);
    }

    public final boolean isUSERREFFLAGNull() {
        return this.IsParamNull(TAG_USERREFFLAG);
    }

    public final boolean getUSERREFFLAG() {
        return this.GetParamIntValue(TAG_USERREFFLAG, 0) == 1;
    }

    public final void setUSERREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERREFFLAG, bValue ? 1 : 0);
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

    public final boolean isDEFAULTPAGENull() {
        return this.IsParamNull(TAG_DEFAULTPAGE);
    }

    public final boolean getDEFAULTPAGE() {
        return this.GetParamIntValue(TAG_DEFAULTPAGE, 0) == 1;
    }

    public final void setDEFAULTPAGE(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTPAGE, bValue ? 1 : 0);
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

    public final boolean isPSAPPUTILVIEWTYPENull() {
        return this.IsParamNull(TAG_PSAPPUTILVIEWTYPE);
    }

    public final String getPSAPPUTILVIEWTYPE() {
        return this.GetParamStringValue(TAG_PSAPPUTILVIEWTYPE, "");
    }

    public final void setPSAPPUTILVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_PSAPPUTILVIEWTYPE, strValue);
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

    public final boolean isENABLECUSTOMIZENull() {
        return this.IsParamNull(TAG_ENABLECUSTOMIZE);
    }

    public final int getENABLECUSTOMIZE() {
        return this.GetParamIntValue(TAG_ENABLECUSTOMIZE, 0);
    }

    public final void setENABLECUSTOMIZE(int bValue) {
        this.SetParamValue(TAG_ENABLECUSTOMIZE, bValue);
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

    public final boolean isDASHBOARDTAG2Null() {
        return this.IsParamNull(TAG_DASHBOARDTAG2);
    }

    public final String getDASHBOARDTAG2() {
        return this.GetParamStringValue(TAG_DASHBOARDTAG2, "");
    }

    public final void setDASHBOARDTAG2(String strValue) {
        this.SetParamValue(TAG_DASHBOARDTAG2, strValue);
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

