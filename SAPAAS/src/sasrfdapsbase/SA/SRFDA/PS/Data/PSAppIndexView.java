/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

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
    public static final String TAG_BLANKMODE = "BLANKMODE";
    public static final String TAG_APPSWITCHMODE = "APPSWITCHMODE";
    public static final String TAG_TOPSIDEPSAPPMENUID = "TOPSIDEPSAPPMENUID";
    public static final String TAG_TOPSIDEPSAPPMENUNAME = "TOPSIDEPSAPPMENUNAME";
    public static final String TAG_LEFTSIDEPSAPPMENUID = "LEFTSIDEPSAPPMENUID";
    public static final String TAG_LEFTSIDEPSAPPMENUNAME = "LEFTSIDEPSAPPMENUNAME";
    public static final String TAG_RIGHTSIDEPSAPPMENUID = "RIGHTSIDEPSAPPMENUID";
    public static final String TAG_RIGHTSIDEPSAPPMENUNAME = "RIGHTSIDEPSAPPMENUNAME";
    public static final String TAG_BOTTOMSIDEPSAPPMENUID = "BOTTOMSIDEPSAPPMENUID";
    public static final String TAG_BOTTOMSIDEPSAPPMENUNAME = "BOTTOMSIDEPSAPPMENUNAME";

    public final boolean isPSAPPINDEXVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPINDEXVIEWID);
    }

    public final String getPSAPPINDEXVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPINDEXVIEWID, "");
    }

    public final void setPSAPPINDEXVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPINDEXVIEWID, strValue);
    }

    public final boolean isPSAPPINDEXVIEWNAMENull() {
        return this.IsParamNull(TAG_PSAPPINDEXVIEWNAME);
    }

    public final String getPSAPPINDEXVIEWNAME() {
        return this.GetParamStringValue(TAG_PSAPPINDEXVIEWNAME, "");
    }

    public final void setPSAPPINDEXVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPINDEXVIEWNAME, strValue);
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

    public final boolean isPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_PSAPPMENUID);
    }

    public final String getPSAPPMENUID() {
        return this.GetParamStringValue(TAG_PSAPPMENUID, "");
    }

    public final void setPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUID, strValue);
    }

    public final boolean isPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_PSAPPMENUNAME);
    }

    public final String getPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_PSAPPMENUNAME, "");
    }

    public final void setPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPMENUNAME, strValue);
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

    public final boolean isAPPICONPATHNull() {
        return this.IsParamNull(TAG_APPICONPATH);
    }

    public final String getAPPICONPATH() {
        return this.GetParamStringValue(TAG_APPICONPATH, "");
    }

    public final void setAPPICONPATH(String strValue) {
        this.SetParamValue(TAG_APPICONPATH, strValue);
    }

    public final boolean isAPPICONPATH2Null() {
        return this.IsParamNull(TAG_APPICONPATH2);
    }

    public final String getAPPICONPATH2() {
        return this.GetParamStringValue(TAG_APPICONPATH2, "");
    }

    public final void setAPPICONPATH2(String strValue) {
        this.SetParamValue(TAG_APPICONPATH2, strValue);
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

    public final boolean isMAINMENUSIDENull() {
        return this.IsParamNull(TAG_MAINMENUSIDE);
    }

    public final String getMAINMENUSIDE() {
        return this.GetParamStringValue(TAG_MAINMENUSIDE, "");
    }

    public final void setMAINMENUSIDE(String strValue) {
        this.SetParamValue(TAG_MAINMENUSIDE, strValue);
    }

    public final boolean isDEFPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_DEFPSAPPVIEWID);
    }

    public final String getDEFPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_DEFPSAPPVIEWID, "");
    }

    public final void setDEFPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_DEFPSAPPVIEWID, strValue);
    }

    public final boolean isDEFPSAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_DEFPSAPPVIEWNAME);
    }

    public final String getDEFPSAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_DEFPSAPPVIEWNAME, "");
    }

    public final void setDEFPSAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_DEFPSAPPVIEWNAME, strValue);
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

    public final boolean isENABLECOUNTERNull() {
        return this.IsParamNull(TAG_ENABLECOUNTER);
    }

    public final boolean getENABLECOUNTER() {
        return this.GetParamIntValue(TAG_ENABLECOUNTER, 0) == 1;
    }

    public final void setENABLECOUNTER(boolean bValue) {
        this.SetParamValue(TAG_ENABLECOUNTER, bValue ? 1 : 0);
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

    public final boolean isBLANKMODENull() {
        return this.IsParamNull(TAG_BLANKMODE);
    }

    public final boolean getBLANKMODE() {
        return this.GetParamIntValue(TAG_BLANKMODE, 0) == 1;
    }

    public final void setBLANKMODE(boolean bValue) {
        this.SetParamValue(TAG_BLANKMODE, bValue ? 1 : 0);
    }

    public final boolean isAPPSWITCHMODENull() {
        return this.IsParamNull(TAG_APPSWITCHMODE);
    }

    public final int getAPPSWITCHMODE() {
        return this.GetParamIntValue(TAG_APPSWITCHMODE, 0);
    }

    public final void setAPPSWITCHMODE(int nValue) {
        this.SetParamValue(TAG_APPSWITCHMODE, nValue);
    }

    public final boolean isTOPSIDEPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_TOPSIDEPSAPPMENUID);
    }

    public final String getTOPSIDEPSAPPMENUID() {
        return this.GetParamStringValue(TAG_TOPSIDEPSAPPMENUID, "");
    }

    public final void setTOPSIDEPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_TOPSIDEPSAPPMENUID, strValue);
    }

    public final boolean isTOPSIDEPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_TOPSIDEPSAPPMENUNAME);
    }

    public final String getTOPSIDEPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_TOPSIDEPSAPPMENUNAME, "");
    }

    public final void setTOPSIDEPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_TOPSIDEPSAPPMENUNAME, strValue);
    }

    public final boolean isLEFTSIDEPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_LEFTSIDEPSAPPMENUID);
    }

    public final String getLEFTSIDEPSAPPMENUID() {
        return this.GetParamStringValue(TAG_LEFTSIDEPSAPPMENUID, "");
    }

    public final void setLEFTSIDEPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_LEFTSIDEPSAPPMENUID, strValue);
    }

    public final boolean isLEFTSIDEPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_LEFTSIDEPSAPPMENUNAME);
    }

    public final String getLEFTSIDEPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_LEFTSIDEPSAPPMENUNAME, "");
    }

    public final void setLEFTSIDEPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_LEFTSIDEPSAPPMENUNAME, strValue);
    }

    public final boolean isRIGHTSIDEPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_RIGHTSIDEPSAPPMENUID);
    }

    public final String getRIGHTSIDEPSAPPMENUID() {
        return this.GetParamStringValue(TAG_RIGHTSIDEPSAPPMENUID, "");
    }

    public final void setRIGHTSIDEPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_RIGHTSIDEPSAPPMENUID, strValue);
    }

    public final boolean isRIGHTSIDEPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_RIGHTSIDEPSAPPMENUNAME);
    }

    public final String getRIGHTSIDEPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_RIGHTSIDEPSAPPMENUNAME, "");
    }

    public final void setRIGHTSIDEPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_RIGHTSIDEPSAPPMENUNAME, strValue);
    }

    public final boolean isBOTTOMSIDEPSAPPMENUIDNull() {
        return this.IsParamNull(TAG_BOTTOMSIDEPSAPPMENUID);
    }

    public final String getBOTTOMSIDEPSAPPMENUID() {
        return this.GetParamStringValue(TAG_BOTTOMSIDEPSAPPMENUID, "");
    }

    public final void setBOTTOMSIDEPSAPPMENUID(String strValue) {
        this.SetParamValue(TAG_BOTTOMSIDEPSAPPMENUID, strValue);
    }

    public final boolean isBOTTOMSIDEPSAPPMENUNAMENull() {
        return this.IsParamNull(TAG_BOTTOMSIDEPSAPPMENUNAME);
    }

    public final String getBOTTOMSIDEPSAPPMENUNAME() {
        return this.GetParamStringValue(TAG_BOTTOMSIDEPSAPPMENUNAME, "");
    }

    public final void setBOTTOMSIDEPSAPPMENUNAME(String strValue) {
        this.SetParamValue(TAG_BOTTOMSIDEPSAPPMENUNAME, strValue);
    }
}

