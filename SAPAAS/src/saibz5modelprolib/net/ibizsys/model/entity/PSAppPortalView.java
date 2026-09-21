/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSAPPPORTALVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPPORTALVIEWID);
    }

    public final String getPSAPPPORTALVIEWID() {
        return this.getParamStringValue(TAG_PSAPPPORTALVIEWID, "");
    }

    public final void setPSAPPPORTALVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPPORTALVIEWID, strValue);
    }

    public final boolean isPSAPPPORTALVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPPORTALVIEWNAME);
    }

    public final String getPSAPPPORTALVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPPORTALVIEWNAME, "");
    }

    public final void setPSAPPPORTALVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPPORTALVIEWNAME, strValue);
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

    public final boolean isCOLMODELNull() {
        return this.isParamNull(TAG_COLMODEL);
    }

    public final String getCOLMODEL() {
        return this.getParamStringValue(TAG_COLMODEL, "");
    }

    public final void setCOLMODEL(String strValue) {
        this.setParamValue(TAG_COLMODEL, strValue);
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

    public final boolean isDEFAULTPAGENull() {
        return this.isParamNull(TAG_DEFAULTPAGE);
    }

    public final boolean getDEFAULTPAGE() {
        return this.getParamIntValue(TAG_DEFAULTPAGE, 0) == 1;
    }

    public final void setDEFAULTPAGE(boolean bValue) {
        this.setParamValue(TAG_DEFAULTPAGE, bValue ? 1 : 0);
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
}

