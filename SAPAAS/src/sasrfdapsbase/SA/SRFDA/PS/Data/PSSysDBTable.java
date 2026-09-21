/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDBTable
extends BaseDataEntity {
    public static final String TABLETYPE_TABLE = "TABLE";
    public static final String TABLETYPE_VIEW = "VIEW";
    public static final String TAG_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String TAG_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSDBSCHEMEID = "PSSYSDBSCHEMEID";
    public static final String TAG_PSSYSDBSCHEMENAME = "PSSYSDBSCHEMENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TABLETYPE = "TABLETYPE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_AUTOEXTENDMODEL = "AUTOEXTENDMODEL";
    public static final String TAG_EXISTINGMODEL = "EXISTINGMODEL";
    public static final String TAG_CREATESQL = "CREATESQL";
    public static final String TAG_DROPSQL = "DROPSQL";
    public static final String TAG_DSLINK = "DSLINK";
    public static final String TAG_TABLETAG = "TABLETAG";
    public static final String TAG_TABLETAG2 = "TABLETAG2";

    public final boolean isPSSYSDBTABLEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBTABLEID);
    }

    public final String getPSSYSDBTABLEID() {
        return this.GetParamStringValue(TAG_PSSYSDBTABLEID, "");
    }

    public final void setPSSYSDBTABLEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBTABLEID, strValue);
    }

    public final boolean isPSSYSDBTABLENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBTABLENAME);
    }

    public final String getPSSYSDBTABLENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBTABLENAME, "");
    }

    public final void setPSSYSDBTABLENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBTABLENAME, strValue);
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

    public final boolean isPSSYSDBSCHEMEIDNull() {
        return this.IsParamNull(TAG_PSSYSDBSCHEMEID);
    }

    public final String getPSSYSDBSCHEMEID() {
        return this.GetParamStringValue(TAG_PSSYSDBSCHEMEID, "");
    }

    public final void setPSSYSDBSCHEMEID(String strValue) {
        this.SetParamValue(TAG_PSSYSDBSCHEMEID, strValue);
    }

    public final boolean isPSSYSDBSCHEMENAMENull() {
        return this.IsParamNull(TAG_PSSYSDBSCHEMENAME);
    }

    public final String getPSSYSDBSCHEMENAME() {
        return this.GetParamStringValue(TAG_PSSYSDBSCHEMENAME, "");
    }

    public final void setPSSYSDBSCHEMENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDBSCHEMENAME, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
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

    public final boolean isTABLETYPENull() {
        return this.IsParamNull(TAG_TABLETYPE);
    }

    public final String getTABLETYPE() {
        return this.GetParamStringValue(TAG_TABLETYPE, "");
    }

    public final void setTABLETYPE(String strValue) {
        this.SetParamValue(TAG_TABLETYPE, strValue);
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

    public final boolean isAUTOEXTENDMODELNull() {
        return this.IsParamNull(TAG_AUTOEXTENDMODEL);
    }

    public final boolean getAUTOEXTENDMODEL() {
        return this.GetParamIntValue(TAG_AUTOEXTENDMODEL, 0) == 1;
    }

    public final void setAUTOEXTENDMODEL(boolean bValue) {
        this.SetParamValue(TAG_AUTOEXTENDMODEL, bValue ? 1 : 0);
    }

    public final boolean isEXISTINGMODELNull() {
        return this.IsParamNull(TAG_EXISTINGMODEL);
    }

    public final boolean getEXISTINGMODEL() {
        return this.GetParamIntValue(TAG_EXISTINGMODEL, 0) == 1;
    }

    public final void setEXISTINGMODEL(boolean bValue) {
        this.SetParamValue(TAG_EXISTINGMODEL, bValue ? 1 : 0);
    }

    public final boolean isCREATESQLNull() {
        return this.IsParamNull(TAG_CREATESQL);
    }

    public final String getCREATESQL() {
        return this.GetParamStringValue(TAG_CREATESQL, "");
    }

    public final void setCREATESQL(String strValue) {
        this.SetParamValue(TAG_CREATESQL, strValue);
    }

    public final boolean isDROPSQLNull() {
        return this.IsParamNull(TAG_DROPSQL);
    }

    public final String getDROPSQL() {
        return this.GetParamStringValue(TAG_DROPSQL, "");
    }

    public final void setDROPSQL(String strValue) {
        this.SetParamValue(TAG_DROPSQL, strValue);
    }

    public final boolean isDSLINKNull() {
        return this.IsParamNull(TAG_DSLINK);
    }

    public final String getDSLINK() {
        return this.GetParamStringValue(TAG_DSLINK, "");
    }

    public final void setDSLINK(String strValue) {
        this.SetParamValue(TAG_DSLINK, strValue);
    }

    public final boolean isTABLETAGNull() {
        return this.IsParamNull(TAG_TABLETAG);
    }

    public final String getTABLETAG() {
        return this.GetParamStringValue(TAG_TABLETAG, "");
    }

    public final void setTABLETAG(String strValue) {
        this.SetParamValue(TAG_TABLETAG, strValue);
    }

    public final boolean isTABLETAG2Null() {
        return this.IsParamNull(TAG_TABLETAG2);
    }

    public final String getTABLETAG2() {
        return this.GetParamStringValue(TAG_TABLETAG2, "");
    }

    public final void setTABLETAG2(String strValue) {
        this.SetParamValue(TAG_TABLETAG2, strValue);
    }
}

