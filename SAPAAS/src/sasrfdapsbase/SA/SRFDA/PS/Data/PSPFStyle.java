/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPFStyle
extends BaseDataEntity {
    public static final int PKGINHERITMODE_DEFAULT = 1;
    public static final int PKGINHERITMODE_SELF = 2;
    public static final String STYLEENGINE_DEFAULT = "DEFAULT";
    public static final String STYLEENGINE_V2 = "V2";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TEMPLPSPFSTYLEID = "TEMPLPSPFSTYLEID";
    public static final String TAG_TEMPLPSPFSTYLENAME = "TEMPLPSPFSTYLENAME";
    public static final String TAG_STYLECODE = "STYLECODE";
    public static final String TAG_PFSTYLEPARAM = "PFSTYLEPARAM";
    public static final String TAG_PUBMODE = "PUBMODE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_LASTIMPTIME = "LASTIMPTIME";
    public static final String TAG_TEMPLSTATE = "TEMPLSTATE";
    public static final String TAG_TEMPLINFO = "TEMPLINFO";
    public static final String TAG_VERSTR = "VERSTR";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_TEMPLROOTURL = "TEMPLROOTURL";
    public static final String TAG_STYLERESURL = "STYLERESURL";
    public static final String TAG_CLSPKGPARAMS = "CLSPKGPARAMS";
    public static final String TAG_PKGINHERITMODE = "PKGINHERITMODE";
    public static final String TAG_STYLEENGINE = "STYLEENGINE";
    public static final String TAG_V2GITPATH = "V2GITPATH";
    public static final String TAG_V2FOLDER = "V2FOLDER";
    public static final String TAG_DYNADEPSTYLEFLAG = "DYNADEPSTYLEFLAG";
    public static final String TAG_REFRESHVER = "REFRESHVER";
    public static final String TAG_V2FOLDER2 = "V2FOLDER2";

    public final boolean isPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_PSPFSTYLEID);
    }

    public final String getPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_PSPFSTYLEID, "");
    }

    public final void setPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLEID, strValue);
    }

    public final boolean isPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_PSPFSTYLENAME);
    }

    public final String getPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_PSPFSTYLENAME, "");
    }

    public final void setPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_PSPFSTYLENAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isTEMPLPSPFSTYLEIDNull() {
        return this.IsParamNull(TAG_TEMPLPSPFSTYLEID);
    }

    public final String getTEMPLPSPFSTYLEID() {
        return this.GetParamStringValue(TAG_TEMPLPSPFSTYLEID, "");
    }

    public final void setTEMPLPSPFSTYLEID(String strValue) {
        this.SetParamValue(TAG_TEMPLPSPFSTYLEID, strValue);
    }

    public final boolean isTEMPLPSPFSTYLENAMENull() {
        return this.IsParamNull(TAG_TEMPLPSPFSTYLENAME);
    }

    public final String getTEMPLPSPFSTYLENAME() {
        return this.GetParamStringValue(TAG_TEMPLPSPFSTYLENAME, "");
    }

    public final void setTEMPLPSPFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_TEMPLPSPFSTYLENAME, strValue);
    }

    public final boolean isSTYLECODENull() {
        return this.IsParamNull(TAG_STYLECODE);
    }

    public final String getSTYLECODE() {
        return this.GetParamStringValue(TAG_STYLECODE, "");
    }

    public final void setSTYLECODE(String strValue) {
        this.SetParamValue(TAG_STYLECODE, strValue);
    }

    public final boolean isPFSTYLEPARAMNull() {
        return this.IsParamNull(TAG_PFSTYLEPARAM);
    }

    public final String getPFSTYLEPARAM() {
        return this.GetParamStringValue(TAG_PFSTYLEPARAM, "");
    }

    public final void setPFSTYLEPARAM(String strValue) {
        this.SetParamValue(TAG_PFSTYLEPARAM, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isLASTIMPTIMENull() {
        return this.IsParamNull(TAG_LASTIMPTIME);
    }

    public final Date getLASTIMPTIME() {
        return this.GetParamDateValue(TAG_LASTIMPTIME, null);
    }

    public final void setLASTIMPTIME(Date dtValue) {
        this.SetParamValue(TAG_LASTIMPTIME, dtValue);
    }

    public final boolean isTEMPLSTATENull() {
        return this.IsParamNull(TAG_TEMPLSTATE);
    }

    public final int getTEMPLSTATE() {
        return this.GetParamIntValue(TAG_TEMPLSTATE, 0);
    }

    public final void setTEMPLSTATE(int nValue) {
        this.SetParamValue(TAG_TEMPLSTATE, nValue);
    }

    public final boolean isTEMPLINFONull() {
        return this.IsParamNull(TAG_TEMPLINFO);
    }

    public final String getTEMPLINFO() {
        return this.GetParamStringValue(TAG_TEMPLINFO, "");
    }

    public final void setTEMPLINFO(String strValue) {
        this.SetParamValue(TAG_TEMPLINFO, strValue);
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

    public final boolean isTEMPLROOTURLNull() {
        return this.IsParamNull(TAG_TEMPLROOTURL);
    }

    public final String getTEMPLROOTURL() {
        return this.GetParamStringValue(TAG_TEMPLROOTURL, "");
    }

    public final void setTEMPLROOTURL(String strValue) {
        this.SetParamValue(TAG_TEMPLROOTURL, strValue);
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

    public final boolean isCLSPKGPARAMSNull() {
        return this.IsParamNull(TAG_CLSPKGPARAMS);
    }

    public final String getCLSPKGPARAMS() {
        return this.GetParamStringValue(TAG_CLSPKGPARAMS, "");
    }

    public final void setCLSPKGPARAMS(String strValue) {
        this.SetParamValue(TAG_CLSPKGPARAMS, strValue);
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

    public final boolean isDYNADEPSTYLEFLAGNull() {
        return this.IsParamNull(TAG_DYNADEPSTYLEFLAG);
    }

    public final boolean getDYNADEPSTYLEFLAG() {
        return this.GetParamIntValue(TAG_DYNADEPSTYLEFLAG, 0) == 1;
    }

    public final void setDYNADEPSTYLEFLAG(boolean bValue) {
        this.SetParamValue(TAG_DYNADEPSTYLEFLAG, bValue ? 1 : 0);
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

