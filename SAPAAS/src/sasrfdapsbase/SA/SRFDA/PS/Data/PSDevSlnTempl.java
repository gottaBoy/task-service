/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnTempl
extends BaseDataEntity {
    public static final String STYLEENGINE_DEFAULT = "DEFAULT";
    public static final String STYLEENGINE_V2 = "V2";
    public static final String TEMPLTYPE_PSPF = "PSPF";
    public static final String TEMPLTYPE_PSSF = "PSSF";
    public static final int DEVTEMPLSTATE_30 = 30;
    public static final int DEVTEMPLSTATE_31 = 31;
    public static final int DEVTEMPLSTATE_35 = 35;
    public static final int DEVTEMPLSTATE_40 = 40;
    public static final int DEVTEMPLSTATE_42 = 42;
    public static final String CURACTION_NONE = "NONE";
    public static final String CURACTION_BACKUP = "BACKUP";
    public static final String CURACTION_RECOVER = "RECOVER";
    public static final String TAG_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String TAG_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_PSPFID = "PSPFID";
    public static final String TAG_PSPFNAME = "PSPFNAME";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_V2GITPATH = "V2GITPATH";
    public static final String TAG_PSPFSTYLEID = "PSPFSTYLEID";
    public static final String TAG_PSPFSTYLENAME = "PSPFSTYLENAME";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_VERSTR = "VERSTR";
    public static final String TAG_STYLEENGINE = "STYLEENGINE";
    public static final String TAG_STYLECODE = "STYLECODE";
    public static final String TAG_TEMPLPARAMS = "TEMPLPARAMS";
    public static final String TAG_TEMPLPSPFSTYLEID = "TEMPLPSPFSTYLEID";
    public static final String TAG_TEMPLPSPFSTYLENAME = "TEMPLPSPFSTYLENAME";
    public static final String TAG_TEMPLPSSFSTYLEID = "TEMPLPSSFSTYLEID";
    public static final String TAG_TEMPLPSSFSTYLENAME = "TEMPLPSSFSTYLENAME";
    public static final String TAG_TEMPLMDURL = "TEMPLMDURL";
    public static final String TAG_TEMPLTYPE = "TEMPLTYPE";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_DEVTEMPLSTATE = "DEVTEMPLSTATE";
    public static final String TAG_CURACTION = "CURACTION";
    public static final String TAG_ACTIONOWNER = "ACTIONOWNER";
    public static final String TAG_TEMPLTAG = "TEMPLTAG";
    public static final String TAG_TEMPLTAG2 = "TEMPLTAG2";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_LASTPUBDATE = "LASTPUBDATE";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_PSDEVSLNSYSSRVID = "PSDEVSLNSYSSRVID";
    public static final String TAG_PSDEVSLNSYSSRVNAME = "PSDEVSLNSYSSRVNAME";
    public static final String TAG_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String TAG_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";

    public final boolean isPSDEVSLNTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNTEMPLID);
    }

    public final String getPSDEVSLNTEMPLID() {
        return this.GetParamStringValue(TAG_PSDEVSLNTEMPLID, "");
    }

    public final void setPSDEVSLNTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNTEMPLID, strValue);
    }

    public final boolean isPSDEVSLNTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNTEMPLNAME);
    }

    public final String getPSDEVSLNTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNTEMPLNAME, "");
    }

    public final void setPSDEVSLNTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNTEMPLNAME, strValue);
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

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
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

    public final boolean isV2GITPATHNull() {
        return this.IsParamNull(TAG_V2GITPATH);
    }

    public final String getV2GITPATH() {
        return this.GetParamStringValue(TAG_V2GITPATH, "");
    }

    public final void setV2GITPATH(String strValue) {
        this.SetParamValue(TAG_V2GITPATH, strValue);
    }

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

    public final boolean isVERSTRNull() {
        return this.IsParamNull(TAG_VERSTR);
    }

    public final String getVERSTR() {
        return this.GetParamStringValue(TAG_VERSTR, "");
    }

    public final void setVERSTR(String strValue) {
        this.SetParamValue(TAG_VERSTR, strValue);
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

    public final boolean isSTYLECODENull() {
        return this.IsParamNull(TAG_STYLECODE);
    }

    public final String getSTYLECODE() {
        return this.GetParamStringValue(TAG_STYLECODE, "");
    }

    public final void setSTYLECODE(String strValue) {
        this.SetParamValue(TAG_STYLECODE, strValue);
    }

    public final boolean isTEMPLPARAMSNull() {
        return this.IsParamNull(TAG_TEMPLPARAMS);
    }

    public final String getTEMPLPARAMS() {
        return this.GetParamStringValue(TAG_TEMPLPARAMS, "");
    }

    public final void setTEMPLPARAMS(String strValue) {
        this.SetParamValue(TAG_TEMPLPARAMS, strValue);
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

    public final boolean isTEMPLPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_TEMPLPSSFSTYLEID);
    }

    public final String getTEMPLPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_TEMPLPSSFSTYLEID, "");
    }

    public final void setTEMPLPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_TEMPLPSSFSTYLEID, strValue);
    }

    public final boolean isTEMPLPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_TEMPLPSSFSTYLENAME);
    }

    public final String getTEMPLPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_TEMPLPSSFSTYLENAME, "");
    }

    public final void setTEMPLPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_TEMPLPSSFSTYLENAME, strValue);
    }

    public final boolean isTEMPLMDURLNull() {
        return this.IsParamNull(TAG_TEMPLMDURL);
    }

    public final String getTEMPLMDURL() {
        return this.GetParamStringValue(TAG_TEMPLMDURL, "");
    }

    public final void setTEMPLMDURL(String strValue) {
        this.SetParamValue(TAG_TEMPLMDURL, strValue);
    }

    public final boolean isTEMPLTYPENull() {
        return this.IsParamNull(TAG_TEMPLTYPE);
    }

    public final String getTEMPLTYPE() {
        return this.GetParamStringValue(TAG_TEMPLTYPE, "");
    }

    public final void setTEMPLTYPE(String strValue) {
        this.SetParamValue(TAG_TEMPLTYPE, strValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
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

    public final boolean isDEVTEMPLSTATENull() {
        return this.IsParamNull(TAG_DEVTEMPLSTATE);
    }

    public final int getDEVTEMPLSTATE() {
        return this.GetParamIntValue(TAG_DEVTEMPLSTATE, 0);
    }

    public final void setDEVTEMPLSTATE(int nValue) {
        this.SetParamValue(TAG_DEVTEMPLSTATE, nValue);
    }

    public final boolean isCURACTIONNull() {
        return this.IsParamNull(TAG_CURACTION);
    }

    public final String getCURACTION() {
        return this.GetParamStringValue(TAG_CURACTION, "");
    }

    public final void setCURACTION(String strValue) {
        this.SetParamValue(TAG_CURACTION, strValue);
    }

    public final boolean isACTIONOWNERNull() {
        return this.IsParamNull(TAG_ACTIONOWNER);
    }

    public final String getACTIONOWNER() {
        return this.GetParamStringValue(TAG_ACTIONOWNER, "");
    }

    public final void setACTIONOWNER(String strValue) {
        this.SetParamValue(TAG_ACTIONOWNER, strValue);
    }

    public final boolean isTEMPLTAGNull() {
        return this.IsParamNull(TAG_TEMPLTAG);
    }

    public final String getTEMPLTAG() {
        return this.GetParamStringValue(TAG_TEMPLTAG, "");
    }

    public final void setTEMPLTAG(String strValue) {
        this.SetParamValue(TAG_TEMPLTAG, strValue);
    }

    public final boolean isTEMPLTAG2Null() {
        return this.IsParamNull(TAG_TEMPLTAG2);
    }

    public final String getTEMPLTAG2() {
        return this.GetParamStringValue(TAG_TEMPLTAG2, "");
    }

    public final void setTEMPLTAG2(String strValue) {
        this.SetParamValue(TAG_TEMPLTAG2, strValue);
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

    public final boolean isLASTPUBDATENull() {
        return this.IsParamNull(TAG_LASTPUBDATE);
    }

    public final Date getLASTPUBDATE() {
        return this.GetParamDateValue(TAG_LASTPUBDATE, null);
    }

    public final void setLASTPUBDATE(Date dtValue) {
        this.SetParamValue(TAG_LASTPUBDATE, dtValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
    }

    public final boolean isPSDEVSLNSYSSRVIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSSRVID);
    }

    public final String getPSDEVSLNSYSSRVID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSSRVID, "");
    }

    public final void setPSDEVSLNSYSSRVID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSSRVID, strValue);
    }

    public final boolean isPSDEVSLNSYSSRVNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSSRVNAME);
    }

    public final String getPSDEVSLNSYSSRVNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSSRVNAME, "");
    }

    public final void setPSDEVSLNSYSSRVNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSSRVNAME, strValue);
    }

    public final boolean isPSDEVSLNSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPID);
    }

    public final String getPSDEVSLNSYSAPPID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPID, "");
    }

    public final void setPSDEVSLNSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPID, strValue);
    }

    public final boolean isPSDEVSLNSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPNAME);
    }

    public final String getPSDEVSLNSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPNAME, "");
    }

    public final void setPSDEVSLNSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPNAME, strValue);
    }
}

