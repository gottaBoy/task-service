/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSFStyle
extends BaseDataEntity {
    public static final int ENABLEWSSERVER_NO = 0;
    public static final int ENABLEWSSERVER_YES = 1;
    public static final int ENABLEWSSERVER_DEFAULT = 3;
    public static final int ENABLEDEPLOYCENTER_NO = 0;
    public static final int ENABLEDEPLOYCENTER_YES = 1;
    public static final int ENABLEDEPLOYCENTER_DEFAULT = 3;
    public static final int PKGINHERITMODE_DEFAULT = 1;
    public static final int PKGINHERITMODE_SELF = 2;
    public static final String STYLEENGINE_DEFAULT = "DEFAULT";
    public static final String STYLEENGINE_V2 = "V2";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_PRJLIST = "PRJLIST";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_VERSTR = "VERSTR";
    public static final String TAG_PPSSFSTYLEID = "PPSSFSTYLEID";
    public static final String TAG_PPSSFSTYLENAME = "PPSSFSTYLENAME";
    public static final String TAG_WORKSHOPNAME = "WORKSHOPNAME";
    public static final String TAG_TEMPLROOTURL = "TEMPLROOTURL";
    public static final String TAG_ENABLEWSSERVER = "ENABLEWSSERVER";
    public static final String TAG_ENABLEDEPLOYCENTER = "ENABLEDEPLOYCENTER";
    public static final String TAG_STYLERESURL = "STYLERESURL";
    public static final String TAG_PKGINHERITMODE = "PKGINHERITMODE";
    public static final String TAG_STYLEENGINE = "STYLEENGINE";
    public static final String TAG_V2GITPATH = "V2GITPATH";
    public static final String TAG_V2FOLDER = "V2FOLDER";
    public static final String TAG_REFRESHVER = "REFRESHVER";
    public static final String TAG_V2FOLDER2 = "V2FOLDER2";

    public final boolean isPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEID);
    }

    public final String getPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEID, "");
    }

    public final void setPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEID, strValue);
    }

    public final boolean isPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLENAME);
    }

    public final String getPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLENAME, "");
    }

    public final void setPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLENAME, strValue);
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

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
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

    public final boolean isCLSPKGPARAMSNull() {
        return this.IsParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.GetParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.SetParamValue(TAG_CLSPKGPARAMS, strValue);
    }

    public final boolean isPRJLISTNull() {
        return this.IsParamNull(TAG_PRJLIST);
    }

    public final String getPRJLIST() {
        return this.GetParamStringValue(TAG_PRJLIST, "");
    }

    public final void setPRJLIST(String strValue) {
        this.SetParamValue(TAG_PRJLIST, strValue);
    }

    public final boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public final int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public final void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public final boolean isVERSTRNull() {
        return this.IsParamNull(TAG_VERSTR);
    }

    public final String getVERSTR() {
        return this.GetParamStringValue(TAG_VERSTR, "");
    }

    public final void setVERSTR(String strValue) {
        this.SetParamValue(TAG_VERSTR, strValue);
    }

    public final boolean isPPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_PPSSFSTYLEID);
    }

    public final String getPPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_PPSSFSTYLEID, "");
    }

    public final void setPPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PPSSFSTYLEID, strValue);
    }

    public final boolean isPPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_PPSSFSTYLENAME);
    }

    public final String getPPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_PPSSFSTYLENAME, "");
    }

    public final void setPPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PPSSFSTYLENAME, strValue);
    }

    public final boolean isWORKSHOPNAMENull() {
        return this.IsParamNull(TAG_WORKSHOPNAME);
    }

    public final String getWORKSHOPNAME() {
        return this.GetParamStringValue(TAG_WORKSHOPNAME, "");
    }

    public final void setWORKSHOPNAME(String strValue) {
        this.SetParamValue(TAG_WORKSHOPNAME, strValue);
    }

    public final boolean isTEMPLROOTURLNull() {
        return this.IsParamNull(TAG_TEMPLROOTURL);
    }

    public final String getTEMPLROOTURL() {
        return this.GetParamStringValue(TAG_TEMPLROOTURL, "");
    }

    public final void setTEMPLROOTURL(String strValue) {
        this.SetParamValue(TAG_TEMPLROOTURL, strValue);
    }

    public final boolean isENABLEWSSERVERNull() {
        return this.IsParamNull(TAG_ENABLEWSSERVER);
    }

    public final int getENABLEWSSERVER() {
        return this.GetParamIntValue(TAG_ENABLEWSSERVER, 0);
    }

    public final void setENABLEWSSERVER(int nValue) {
        this.SetParamValue(TAG_ENABLEWSSERVER, nValue);
    }

    public final boolean isENABLEDEPLOYCENTERNull() {
        return this.IsParamNull(TAG_ENABLEDEPLOYCENTER);
    }

    public final int getENABLEDEPLOYCENTER() {
        return this.GetParamIntValue(TAG_ENABLEDEPLOYCENTER, 0);
    }

    public final void setENABLEDEPLOYCENTER(int nValue) {
        this.SetParamValue(TAG_ENABLEDEPLOYCENTER, nValue);
    }

    public final boolean isSTYLERESURLNull() {
        return this.IsParamNull(TAG_STYLERESURL);
    }

    public final String getSTYLERESURL() {
        return this.GetParamStringValue(TAG_STYLERESURL, "");
    }

    public final void setSTYLERESURL(String strValue) {
        this.SetParamValue(TAG_STYLERESURL, strValue);
    }

    public final boolean isPKGINHERITMODENull() {
        return this.IsParamNull(TAG_PKGINHERITMODE);
    }

    public final int getPKGINHERITMODE() {
        return this.GetParamIntValue(TAG_PKGINHERITMODE, 0);
    }

    public final void setPKGINHERITMODE(int nValue) {
        this.SetParamValue(TAG_PKGINHERITMODE, nValue);
    }

    public final boolean isSTYLEENGINENull() {
        return this.IsParamNull(TAG_STYLEENGINE);
    }

    public final String getSTYLEENGINE() {
        return this.GetParamStringValue(TAG_STYLEENGINE, "");
    }

    public final void setSTYLEENGINE(String strValue) {
        this.SetParamValue(TAG_STYLEENGINE, strValue);
    }

    public final boolean isV2GITPATHNull() {
        return this.IsParamNull(TAG_V2GITPATH);
    }

    public final String getV2GITPATH() {
        return this.GetParamStringValue(TAG_V2GITPATH, "");
    }

    public final void setV2GITPATH(String strValue) {
        this.SetParamValue(TAG_V2GITPATH, strValue);
    }

    public final boolean isV2FOLDERNull() {
        return this.IsParamNull(TAG_V2FOLDER);
    }

    public final String getV2FOLDER() {
        return this.GetParamStringValue(TAG_V2FOLDER, "");
    }

    public final void setV2FOLDER(String strValue) {
        this.SetParamValue(TAG_V2FOLDER, strValue);
    }

    public final boolean isREFRESHVERNull() {
        return this.IsParamNull(TAG_REFRESHVER);
    }

    public final int getREFRESHVER() {
        return this.GetParamIntValue(TAG_REFRESHVER, 0);
    }

    public final void setREFRESHVER(int nValue) {
        this.SetParamValue(TAG_REFRESHVER, nValue);
    }

    public final boolean isV2FOLDER2Null() {
        return this.IsParamNull(TAG_V2FOLDER2);
    }

    public final String getV2FOLDER2() {
        return this.GetParamStringValue(TAG_V2FOLDER2, "");
    }

    public final void setV2FOLDER2(String strValue) {
        this.SetParamValue(TAG_V2FOLDER2, strValue);
    }
}

