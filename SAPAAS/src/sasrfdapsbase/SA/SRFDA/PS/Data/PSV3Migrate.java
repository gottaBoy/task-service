/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSV3Migrate
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String TAG_PSMODULEID = "PSMODULEID";
    public static final String TAG_PSMODULENAME = "PSMODULENAME";
    public static final String TAG_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String TAG_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_DENAMEPREFIX = "DENAMEPREFIX";
    public static final String TAG_EXCLUDENAMES = "EXCLUDENAMES";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DEIDPREFIX = "DEIDPREFIX";
    public static final String TAG_EXCLUDEIDS = "EXCLUDEIDS";

    public final boolean isPSV3MIGRATEIDNull() {
        return this.IsParamNull(TAG_PSV3MIGRATEID);
    }

    public final String getPSV3MIGRATEID() {
        return this.GetParamStringValue(TAG_PSV3MIGRATEID, "");
    }

    public final void setPSV3MIGRATEID(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATEID, strValue);
    }

    public final boolean isPSV3MIGRATENAMENull() {
        return this.IsParamNull(TAG_PSV3MIGRATENAME);
    }

    public final String getPSV3MIGRATENAME() {
        return this.GetParamStringValue(TAG_PSV3MIGRATENAME, "");
    }

    public final void setPSV3MIGRATENAME(String strValue) {
        this.SetParamValue(TAG_PSV3MIGRATENAME, strValue);
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

    public final boolean isDENAMEPREFIXNull() {
        return this.IsParamNull(TAG_DENAMEPREFIX);
    }

    public final String getDENAMEPREFIX() {
        return this.GetParamStringValue(TAG_DENAMEPREFIX, "");
    }

    public final void setDENAMEPREFIX(String strValue) {
        this.SetParamValue(TAG_DENAMEPREFIX, strValue);
    }

    public final boolean isEXCLUDENAMESNull() {
        return this.IsParamNull(TAG_EXCLUDENAMES);
    }

    public final String getEXCLUDENAMES() {
        return this.GetParamStringValue(TAG_EXCLUDENAMES, "");
    }

    public final void setEXCLUDENAMES(String strValue) {
        this.SetParamValue(TAG_EXCLUDENAMES, strValue);
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

    public final boolean isDEIDPREFIXNull() {
        return this.IsParamNull(TAG_DEIDPREFIX);
    }

    public final String getDEIDPREFIX() {
        return this.GetParamStringValue(TAG_DEIDPREFIX, "");
    }

    public final void setDEIDPREFIX(String strValue) {
        this.SetParamValue(TAG_DEIDPREFIX, strValue);
    }

    public final boolean isEXCLUDEIDSNull() {
        return this.IsParamNull(TAG_EXCLUDEIDS);
    }

    public final String getEXCLUDEIDS() {
        return this.GetParamStringValue(TAG_EXCLUDEIDS, "");
    }

    public final void setEXCLUDEIDS(String strValue) {
        this.SetParamValue(TAG_EXCLUDEIDS, strValue);
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
}

