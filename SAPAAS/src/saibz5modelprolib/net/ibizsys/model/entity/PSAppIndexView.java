/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

public class PSAppIndexView
extends BaseDataEntity {
    public static final String TAG_PSAPPINDEXVIEWID = "PSAPPINDEXVIEWID";
    public static final String TAG_PSAPPINDEXVIEWNAME = "PSAPPINDEXVIEWNAME";
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
    public static final String TAG_PSAPPMENUID = "PSAPPMENUID";
    public static final String TAG_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String TAG_DEFAULTPAGE = "DEFAULTPAGE";
    public static final String TAG_APPICONPATH = "APPICONPATH";
    public static final String TAG_APPICONPATH2 = "APPICONPATH2";
    public static final String TAG_PSSYSCOUNTERID = "PSSYSCOUNTERID";
    public static final String TAG_PSSYSCOUNTERNAME = "PSSYSCOUNTERNAME";
    public static final String TAG_MAINMENUSIDE = "MAINMENUSIDE";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String TAG_DEFPSAPPVIEWID = "DEFPSAPPVIEWID";
    public static final String TAG_DEFPSAPPVIEWNAME = "DEFPSAPPVIEWNAME";
    public static final String TAG_ACCUSERMODE = "ACCUSERMODE";
    public static final String TAG_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String TAG_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String TAG_ENABLECOUNTER = "ENABLECOUNTER";
    public static final String TAG_PSACHANDLERID = "PSACHANDLERID";
    public static final String TAG_PSACHANDLERNAME = "PSACHANDLERNAME";

    public final boolean isPSAPPINDEXVIEWIDNull() {
        return this.isParamNull(TAG_PSAPPINDEXVIEWID);
    }

    public final String getPSAPPINDEXVIEWID() {
        return this.getParamStringValue(TAG_PSAPPINDEXVIEWID, "");
    }

    public final void setPSAPPINDEXVIEWID(String strValue) {
        this.setParamValue(TAG_PSAPPINDEXVIEWID, strValue);
    }

    public final boolean isPSAPPINDEXVIEWNAMENull() {
        return this.isParamNull(TAG_PSAPPINDEXVIEWNAME);
    }

    public final String getPSAPPINDEXVIEWNAME() {
        return this.getParamStringValue(TAG_PSAPPINDEXVIEWNAME, "");
    }

    public final void setPSAPPINDEXVIEWNAME(String strValue) {
        this.setParamValue(TAG_PSAPPINDEXVIEWNAME, strValue);
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

    public final boolean isPSAPPMENUIDNull() {
        return this.isParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.getParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.setParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.isParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.getParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.setParamValue(TAG_PSAPPMENUNAME, strValue);
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

    public final boolean isAPPICONPATHNull() {
        return this.isParamNull(TAG_APPICONPATH);
    }

    public final String getAPPICONPATH() {
        return this.getParamStringValue(TAG_APPICONPATH, "");
    }

    public final void setAPPICONPATH(String strValue) {
        this.setParamValue(TAG_APPICONPATH, strValue);
    }

    public final boolean isAPPICONPATH2Null() {
        return this.isParamNull(TAG_APPICONPATH2);
    }

    public final String getAPPICONPATH2() {
        return this.getParamStringValue(TAG_APPICONPATH2, "");
    }

    public final void setAPPICONPATH2(String strValue) {
        this.setParamValue(TAG_APPICONPATH2, strValue);
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

    public final boolean isMAINMENUSIDENull() {
        return this.isParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.getParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.setParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isDEFPSAPPVIEWIDNull() {
        return this.isParamNull(TAG_DEFPSAPPVIEWID);
    }

    public final String getDEFPSAPPVIEWID() {
        return this.getParamStringValue(TAG_DEFPSAPPVIEWID, "");
    }

    public final void setDEFPSAPPVIEWID(String strValue) {
        this.setParamValue(TAG_DEFPSAPPVIEWID, strValue);
    }

    public final boolean isDEFPSAPPVIEWNAMENull() {
        return this.isParamNull(TAG_DEFPSAPPVIEWNAME);
    }

    public final String getDEFPSAPPVIEWNAME() {
        return this.getParamStringValue(TAG_DEFPSAPPVIEWNAME, "");
    }

    public final void setDEFPSAPPVIEWNAME(String strValue) {
        this.setParamValue(TAG_DEFPSAPPVIEWNAME, strValue);
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

    public final boolean isENABLECOUNTERNull() {
        return this.isParamNull(TAG_ENABLECOUNTER);
    }

    public final boolean getENABLECOUNTER() {
        return this.getParamIntValue(TAG_ENABLECOUNTER, 0) == 1;
    }

    public final void setENABLECOUNTER(boolean bValue) {
        this.setParamValue(TAG_ENABLECOUNTER, bValue ? 1 : 0);
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

