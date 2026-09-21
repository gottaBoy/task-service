/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysSFPub
extends BaseDataEntity {
    public static final String CONTENTTYPE_CODE = "CODE";
    public static final String CONTENTTYPE_DOC = "DOC";
    public static final String CONTENTTYPE_TESTCODE = "TESTCODE";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSFSTYLEID = "PSSFSTYLEID";
    public static final String TAG_PSSFSTYLENAME = "PSSFSTYLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PKGCODENAME = "PKGCODENAME";
    public static final String TAG_BASECLSPKGCODENAME = "BASECLSPKGCODENAME";
    public static final String TAG_DEFAULTPUB = "DEFAULTPUB";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSSFSTYLEVERID = "PSSFSTYLEVERID";
    public static final String TAG_PSSFSTYLEVERNAME = "PSSFSTYLEVERNAME";
    public static final String TAG_PUBFOLDER = "PUBFOLDER";
    public static final String TAG_PSSFSTYLEPARAMID = "PSSFSTYLEPARAMID";
    public static final String TAG_PSSFSTYLEPARAMNAME = "PSSFSTYLEPARAMNAME";
    public static final String TAG_STYLEPARAMS = "STYLEPARAMS";
    public static final String TAG_VERSTR = "VERSTR";
    public static final String TAG_SUBSYSPKGFLAG = "SUBSYSPKGFLAG";
    public static final String TAG_PPSSYSSFPUBID = "PPSSYSSFPUBID";
    public static final String TAG_PPSSYSSFPUBNAME = "PPSSYSSFPUBNAME";
    public static final String TAG_CONTENTTYPE = "CONTENTTYPE";
    public static final String TAG_DOCPSSFSTYLEID = "DOCPSSFSTYLEID";
    public static final String TAG_DOCPSSFSTYLENAME = "DOCPSSFSTYLENAME";
    public static final String TAG_DYNAMODELMODE = "DYNAMODELMODE";

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPKGCODENAMENull() {
        return this.IsParamNull(TAG_PKGCODENAME);
    }

    public final String getPKGCODENAME() {
        return this.GetParamStringValue(TAG_PKGCODENAME, "");
    }

    public final void setPKGCODENAME(String strValue) {
        this.SetParamValue(TAG_PKGCODENAME, strValue);
    }

    public final boolean isBASECLSPKGCODENAMENull() {
        return this.IsParamNull(TAG_BASECLSPKGCODENAME);
    }

    public final String getBASECLSPKGCODENAME() {
        return this.GetParamStringValue(TAG_BASECLSPKGCODENAME, "");
    }

    public final void setBASECLSPKGCODENAME(String strValue) {
        this.SetParamValue(TAG_BASECLSPKGCODENAME, strValue);
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

    public final boolean isPSSFSTYLEVERIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEVERID);
    }

    public final String getPSSFSTYLEVERID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEVERID, "");
    }

    public final void setPSSFSTYLEVERID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEVERID, strValue);
    }

    public final boolean isPSSFSTYLEVERNAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLEVERNAME);
    }

    public final String getPSSFSTYLEVERNAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLEVERNAME, "");
    }

    public final void setPSSFSTYLEVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEVERNAME, strValue);
    }

    public final boolean isPUBFOLDERNull() {
        return this.IsParamNull(TAG_PUBFOLDER);
    }

    public final String getPUBFOLDER() {
        return this.GetParamStringValue(TAG_PUBFOLDER, "");
    }

    public final void setPUBFOLDER(String strValue) {
        this.SetParamValue(TAG_PUBFOLDER, strValue);
    }

    public final boolean isPSSFSTYLEPARAMIDNull() {
        return this.IsParamNull(TAG_PSSFSTYLEPARAMID);
    }

    public final String getPSSFSTYLEPARAMID() {
        return this.GetParamStringValue(TAG_PSSFSTYLEPARAMID, "");
    }

    public final void setPSSFSTYLEPARAMID(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEPARAMID, strValue);
    }

    public final boolean isPSSFSTYLEPARAMNAMENull() {
        return this.IsParamNull(TAG_PSSFSTYLEPARAMNAME);
    }

    public final String getPSSFSTYLEPARAMNAME() {
        return this.GetParamStringValue(TAG_PSSFSTYLEPARAMNAME, "");
    }

    public final void setPSSFSTYLEPARAMNAME(String strValue) {
        this.SetParamValue(TAG_PSSFSTYLEPARAMNAME, strValue);
    }

    public final boolean isSTYLEPARAMSNull() {
        return this.IsParamNull(TAG_STYLEPARAMS);
    }

    public final String getSTYLEPARAMS() {
        return this.GetParamStringValue(TAG_STYLEPARAMS, "");
    }

    public final void setSTYLEPARAMS(String strValue) {
        this.SetParamValue(TAG_STYLEPARAMS, strValue);
    }

    public final boolean isDEFAULTPUBNull() {
        return this.IsParamNull(TAG_DEFAULTPUB);
    }

    public final boolean getDEFAULTPUB() {
        return this.GetParamIntValue(TAG_DEFAULTPUB, 0) == 1;
    }

    public final void setDEFAULTPUB(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTPUB, bValue ? 1 : 0);
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

    public final boolean isSUBSYSPKGFLAGNull() {
        return this.IsParamNull(TAG_SUBSYSPKGFLAG);
    }

    public final boolean getSUBSYSPKGFLAG() {
        return this.GetParamIntValue(TAG_SUBSYSPKGFLAG, 0) == 1;
    }

    public final void setSUBSYSPKGFLAG(boolean bValue) {
        this.SetParamValue(TAG_SUBSYSPKGFLAG, bValue ? 1 : 0);
    }

    public final boolean isPPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PPSSYSSFPUBID);
    }

    public final String getPPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PPSSYSSFPUBID, "");
    }

    public final void setPPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PPSSYSSFPUBID, strValue);
    }

    public final boolean isPPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PPSSYSSFPUBNAME);
    }

    public final String getPPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PPSSYSSFPUBNAME, "");
    }

    public final void setPPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSSFPUBNAME, strValue);
    }

    public final boolean isCONTENTTYPENull() {
        return this.IsParamNull(TAG_CONTENTTYPE);
    }

    public final String getCONTENTTYPE() {
        return this.GetParamStringValue(TAG_CONTENTTYPE, "");
    }

    public final void setCONTENTTYPE(String strValue) {
        this.SetParamValue(TAG_CONTENTTYPE, strValue);
    }

    public final boolean isDOCPSSFSTYLEIDNull() {
        return this.IsParamNull(TAG_DOCPSSFSTYLEID);
    }

    public final String getDOCPSSFSTYLEID() {
        return this.GetParamStringValue(TAG_DOCPSSFSTYLEID, "");
    }

    public final void setDOCPSSFSTYLEID(String strValue) {
        this.SetParamValue(TAG_DOCPSSFSTYLEID, strValue);
    }

    public final boolean isDOCPSSFSTYLENAMENull() {
        return this.IsParamNull(TAG_DOCPSSFSTYLENAME);
    }

    public final String getDOCPSSFSTYLENAME() {
        return this.GetParamStringValue(TAG_DOCPSSFSTYLENAME, "");
    }

    public final void setDOCPSSFSTYLENAME(String strValue) {
        this.SetParamValue(TAG_DOCPSSFSTYLENAME, strValue);
    }

    public final boolean isDYNAMODELMODENull() {
        return this.IsParamNull(TAG_DYNAMODELMODE);
    }

    public final String getDYNAMODELMODE() {
        return this.GetParamStringValue(TAG_DYNAMODELMODE, "");
    }

    public final void setDYNAMODELMODE(String strValue) {
        this.SetParamValue(TAG_DYNAMODELMODE, strValue);
    }
}

