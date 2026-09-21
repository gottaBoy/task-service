/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewMsgGroup
extends BaseDataEntity {
    public static final String TAG_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String TAG_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DYNAMICMODE = "DYNAMICMODE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_LOCKFLAG = "LOCKFLAG";
    public static final String TAG_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String TAG_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_BODYMSGSTYLE = "BODYMSGSTYLE";
    public static final String TAG_BOTTOMMSGSTYLE = "BOTTOMMSGSTYLE";
    public static final String TAG_TOPMSGSTYLE = "TOPMSGSTYLE";
    public static final String TAG_TOPMSGPSSYSCSSID = "TOPMSGPSSYSCSSID";
    public static final String TAG_TOPMSGPSSYSCSSNAME = "TOPMSGPSSYSCSSNAME";
    public static final String TAG_BOTTOMMSGPSSYSCSSID = "BOTTOMMSGPSSYSCSSID";
    public static final String TAG_BOTTOMMSGPSSYSCSSNAME = "BOTTOMMSGPSSYSCSSNAME";
    public static final String TAG_BODYMSGPSSYSCSSID = "BODYMSGPSSYSCSSID";
    public static final String TAG_BODYMSGPSSYSCSSNAME = "BODYMSGPSSYSCSSNAME";

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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isDYNAMICMODENull() {
        return this.IsParamNull(TAG_DYNAMICMODE);
    }

    public final boolean getDYNAMICMODE() {
        return this.GetParamIntValue(TAG_DYNAMICMODE, 0) == 1;
    }

    public final void setDYNAMICMODE(boolean bValue) {
        this.SetParamValue(TAG_DYNAMICMODE, bValue ? 1 : 0);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isPSMODULEIDNull() {
        return this.IsParamNull(TAG_PSMODULEID);
    }

    public final String getPSMODULEID() {
        return this.GetParamStringValue(TAG_PSMODULEID, "");
    }

    public final void setPSMODULEID(String strValue) {
        this.SetParamValue(TAG_PSMODULEID, strValue);
    }

    public final boolean isPSMODULENAMENull() {
        return this.IsParamNull(TAG_PSMODULENAME);
    }

    public final String getPSMODULENAME() {
        return this.GetParamStringValue(TAG_PSMODULENAME, "");
    }

    public final void setPSMODULENAME(String strValue) {
        this.SetParamValue(TAG_PSMODULENAME, strValue);
    }

    public final boolean isLOCKFLAGNull() {
        return this.IsParamNull(TAG_LOCKFLAG);
    }

    public final boolean getLOCKFLAG() {
        return this.GetParamIntValue(TAG_LOCKFLAG, 0) == 1;
    }

    public final void setLOCKFLAG(boolean bValue) {
        this.SetParamValue(TAG_LOCKFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }

    public final boolean isBODYMSGSTYLENull() {
        return this.IsParamNull(TAG_BODYMSGSTYLE);
    }

    public final String getBODYMSGSTYLE() {
        return this.GetParamStringValue(TAG_BODYMSGSTYLE, "");
    }

    public final void setBODYMSGSTYLE(String strValue) {
        this.SetParamValue(TAG_BODYMSGSTYLE, strValue);
    }

    public final boolean isBOTTOMMSGSTYLENull() {
        return this.IsParamNull(TAG_BOTTOMMSGSTYLE);
    }

    public final String getBOTTOMMSGSTYLE() {
        return this.GetParamStringValue(TAG_BOTTOMMSGSTYLE, "");
    }

    public final void setBOTTOMMSGSTYLE(String strValue) {
        this.SetParamValue(TAG_BOTTOMMSGSTYLE, strValue);
    }

    public final boolean isTOPMSGSTYLENull() {
        return this.IsParamNull(TAG_TOPMSGSTYLE);
    }

    public final String getTOPMSGSTYLE() {
        return this.GetParamStringValue(TAG_TOPMSGSTYLE, "");
    }

    public final void setTOPMSGSTYLE(String strValue) {
        this.SetParamValue(TAG_TOPMSGSTYLE, strValue);
    }

    public final boolean isTOPMSGPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_TOPMSGPSSYSCSSID);
    }

    public final String getTOPMSGPSSYSCSSID() {
        return this.GetParamStringValue(TAG_TOPMSGPSSYSCSSID, "");
    }

    public final void setTOPMSGPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_TOPMSGPSSYSCSSID, strValue);
    }

    public final boolean isTOPMSGPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_TOPMSGPSSYSCSSNAME);
    }

    public final String getTOPMSGPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_TOPMSGPSSYSCSSNAME, "");
    }

    public final void setTOPMSGPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_TOPMSGPSSYSCSSNAME, strValue);
    }

    public final boolean isBOTTOMMSGPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_BOTTOMMSGPSSYSCSSID);
    }

    public final String getBOTTOMMSGPSSYSCSSID() {
        return this.GetParamStringValue(TAG_BOTTOMMSGPSSYSCSSID, "");
    }

    public final void setBOTTOMMSGPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_BOTTOMMSGPSSYSCSSID, strValue);
    }

    public final boolean isBOTTOMMSGPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_BOTTOMMSGPSSYSCSSNAME);
    }

    public final String getBOTTOMMSGPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_BOTTOMMSGPSSYSCSSNAME, "");
    }

    public final void setBOTTOMMSGPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_BOTTOMMSGPSSYSCSSNAME, strValue);
    }

    public final boolean isBODYMSGPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_BODYMSGPSSYSCSSID);
    }

    public final String getBODYMSGPSSYSCSSID() {
        return this.GetParamStringValue(TAG_BODYMSGPSSYSCSSID, "");
    }

    public final void setBODYMSGPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_BODYMSGPSSYSCSSID, strValue);
    }

    public final boolean isBODYMSGPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_BODYMSGPSSYSCSSNAME);
    }

    public final String getBODYMSGPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_BODYMSGPSSYSCSSNAME, "");
    }

    public final void setBODYMSGPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_BODYMSGPSSYSCSSNAME, strValue);
    }
}

