/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubDEView
extends BaseDataEntity {
    public static final String VIEWTYPE_APPPORTALVIEW = "APPPORTALVIEW";
    public static final String VIEWTYPE_APPINDEXVIEW = "APPINDEXVIEW";
    public static final String VIEWTYPE_DEPICKUPVIEW = "DEPICKUPVIEW";
    public static final String VIEWTYPE_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String VIEWTYPE_DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    public static final String VIEWTYPE_DEGRIDVIEW9 = "DEGRIDVIEW9";
    public static final String VIEWTYPE_DEMPICKUPVIEW = "DEMPICKUPVIEW";
    public static final String VIEWTYPE_DEWFGRIDVIEW = "DEWFGRIDVIEW";
    public static final String VIEWTYPE_DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    public static final String VIEWTYPE_DEWFEXPVIEW = "DEWFEXPVIEW";
    public static final String VIEWTYPE_DEEDITVIEW2 = "DEEDITVIEW2";
    public static final String VIEWTYPE_DEEDITVIEW = "DEEDITVIEW";
    public static final String VIEWTYPE_DEOPTVIEW = "DEOPTVIEW";
    public static final String VIEWTYPE_DEWFEDITVIEW = "DEWFEDITVIEW";
    public static final String VIEWTYPE_DEHTMLVIEW = "DEHTMLVIEW";
    public static final String VIEWTYPE_DEWFACTIONVIEW = "DEWFACTIONVIEW";
    public static final String VIEWTYPE_DEEDITVIEW9 = "DEEDITVIEW9";
    public static final String VIEWTYPE_DEDATAVIEW = "DEDATAVIEW";
    public static final String VIEWTYPE_DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    public static final String VIEWTYPE_DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    public static final String VIEWTYPE_DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    public static final String TAG_PSSUBDEVIEWID = "PSSUBDEVIEWID";
    public static final String TAG_PSSUBDEVIEWNAME = "PSSUBDEVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBDEID = "PSSUBDEID";
    public static final String TAG_PSSUBDENAME = "PSSUBDENAME";
    public static final String TAG_PSSUBSYSID = "PSSUBSYSID";
    public static final String TAG_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String TAG_VIEWTYPE = "VIEWTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String TAG_CODENAME = "CODENAME";

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

    public final boolean isPSSUBDEIDNull() {
        return this.IsParamNull(TAG_PSSUBDEID);
    }

    public final String getPSSUBDEID() {
        return this.GetParamStringValue(TAG_PSSUBDEID, "");
    }

    public final void setPSSUBDEID(String strValue) {
        this.SetParamValue(TAG_PSSUBDEID, strValue);
    }

    public final boolean isPSSUBDENAMENull() {
        return this.IsParamNull(TAG_PSSUBDENAME);
    }

    public final String getPSSUBDENAME() {
        return this.GetParamStringValue(TAG_PSSUBDENAME, "");
    }

    public final void setPSSUBDENAME(String strValue) {
        this.SetParamValue(TAG_PSSUBDENAME, strValue);
    }

    public final boolean isPSSUBSYSIDNull() {
        return this.IsParamNull(TAG_PSSUBSYSID);
    }

    public final String getPSSUBSYSID() {
        return this.GetParamStringValue(TAG_PSSUBSYSID, "");
    }

    public final void setPSSUBSYSID(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSID, strValue);
    }

    public final boolean isPSSUBSYSNAMENull() {
        return this.IsParamNull(TAG_PSSUBSYSNAME);
    }

    public final String getPSSUBSYSNAME() {
        return this.GetParamStringValue(TAG_PSSUBSYSNAME, "");
    }

    public final void setPSSUBSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBSYSNAME, strValue);
    }

    public final boolean isVIEWTYPENull() {
        return this.IsParamNull(TAG_VIEWTYPE);
    }

    public final String getVIEWTYPE() {
        return this.GetParamStringValue(TAG_VIEWTYPE, "");
    }

    public final void setVIEWTYPE(String strValue) {
        this.SetParamValue(TAG_VIEWTYPE, strValue);
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

    public final boolean isPSDEVIEWBASEIDNull() {
        return this.IsParamNull(TAG_PSDEVIEWBASEID);
    }

    public final String getPSDEVIEWBASEID() {
        return this.GetParamStringValue(TAG_PSDEVIEWBASEID, "");
    }

    public final void setPSDEVIEWBASEID(String strValue) {
        this.SetParamValue(TAG_PSDEVIEWBASEID, strValue);
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
}

