/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubAppView
extends BaseDataEntity {
    public static final String TAG_PSSUBAPPVIEWID = "PSSUBAPPVIEWID";
    public static final String TAG_PSSUBAPPVIEWNAME = "PSSUBAPPVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBAPPID = "PSSUBAPPID";
    public static final String TAG_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String TAG_PSSUBDEVIEWID = "PSSUBDEVIEWID";
    public static final String TAG_PSSUBDEVIEWNAME = "PSSUBDEVIEWNAME";
    public static final String TAG_PAGEURL = "PAGEURL";
    public static final String TAG_BACKENDURL = "BACKENDURL";
    public static final String TAG_FULLCODENAME = "FULLCODENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_MODULECODENAME = "MODULECODENAME";
    public static final String TAG_MODULENAME = "MODULENAME";

    public final boolean isPSSUBAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSSUBAPPVIEWID);
    }

    public final String getPSSUBAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSSUBAPPVIEWID, "");
    }

    public final void setPSSUBAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPVIEWID, strValue);
    }

    public final boolean isPSSUBAPPVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSUBAPPVIEWNAME);
    }

    public final String getPSSUBAPPVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSUBAPPVIEWNAME, "");
    }

    public final void setPSSUBAPPVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPVIEWNAME, strValue);
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

    public final boolean isPSSUBAPPIDNull() {
        return this.IsParamNull(TAG_PSSUBAPPID);
    }

    public final String getPSSUBAPPID() {
        return this.GetParamStringValue(TAG_PSSUBAPPID, "");
    }

    public final void setPSSUBAPPID(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPID, strValue);
    }

    public final boolean isPSSUBAPPNAMENull() {
        return this.IsParamNull(TAG_PSSUBAPPNAME);
    }

    public final String getPSSUBAPPNAME() {
        return this.GetParamStringValue(TAG_PSSUBAPPNAME, "");
    }

    public final void setPSSUBAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBAPPNAME, strValue);
    }

    public final boolean isPSSUBDEVIEWIDNull() {
        return this.IsParamNull(TAG_PSSUBDEVIEWID);
    }

    public final String getPSSUBDEVIEWID() {
        return this.GetParamStringValue(TAG_PSSUBDEVIEWID, "");
    }

    public final void setPSSUBDEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSSUBDEVIEWID, strValue);
    }

    public final boolean isPSSUBDEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSSUBDEVIEWNAME);
    }

    public final String getPSSUBDEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSSUBDEVIEWNAME, "");
    }

    public final void setPSSUBDEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBDEVIEWNAME, strValue);
    }

    public final boolean isPAGEURLNull() {
        return this.IsParamNull(TAG_PAGEURL);
    }

    public final String getPAGEURL() {
        return this.GetParamStringValue(TAG_PAGEURL, "");
    }

    public final void setPAGEURL(String strValue) {
        this.SetParamValue(TAG_PAGEURL, strValue);
    }

    public final boolean isBACKENDURLNull() {
        return this.IsParamNull(TAG_BACKENDURL);
    }

    public final String getBACKENDURL() {
        return this.GetParamStringValue(TAG_BACKENDURL, "");
    }

    public final void setBACKENDURL(String strValue) {
        this.SetParamValue(TAG_BACKENDURL, strValue);
    }

    public final boolean isFULLCODENAMENull() {
        return this.IsParamNull(TAG_FULLCODENAME);
    }

    public final String getFULLCODENAME() {
        return this.GetParamStringValue(TAG_FULLCODENAME, "");
    }

    public final void setFULLCODENAME(String strValue) {
        this.SetParamValue(TAG_FULLCODENAME, strValue);
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

    public final boolean isPSAPPVIEWIDNull() {
        return this.IsParamNull(TAG_PSAPPVIEWID);
    }

    public final String getPSAPPVIEWID() {
        return this.GetParamStringValue(TAG_PSAPPVIEWID, "");
    }

    public final void setPSAPPVIEWID(String strValue) {
        this.SetParamValue(TAG_PSAPPVIEWID, strValue);
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

    public final boolean isMODULECODENAMENull() {
        return this.IsParamNull(TAG_MODULECODENAME);
    }

    public final String getMODULECODENAME() {
        return this.GetParamStringValue(TAG_MODULECODENAME, "");
    }

    public final void setMODULECODENAME(String strValue) {
        this.SetParamValue(TAG_MODULECODENAME, strValue);
    }

    public final boolean isMODULENAMENull() {
        return this.IsParamNull(TAG_MODULENAME);
    }

    public final String getMODULENAME() {
        return this.GetParamStringValue(TAG_MODULENAME, "");
    }

    public final void setMODULENAME(String strValue) {
        this.SetParamValue(TAG_MODULENAME, strValue);
    }
}

