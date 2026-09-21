/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEDBTable
extends BaseDataEntity {
    public static final String TABLETYPE_MAIN = "MAIN";
    public static final String TAG_PSDETABLEID = "PSDETABLEID";
    public static final String TAG_PSDETABLENAME = "PSDETABLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSSYSDBTABLEID = "PSSYSDBTABLEID";
    public static final String TAG_PSSYSDBTABLENAME = "PSSYSDBTABLENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TABLETYPE = "TABLETYPE";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";

    public final boolean isPSDETABLEIDNull() {
        return this.IsParamNull(TAG_PSDETABLEID);
    }

    public final String getPSDETABLEID() {
        return this.GetParamStringValue(TAG_PSDETABLEID, "");
    }

    public final void setPSDETABLEID(String strValue) {
        this.SetParamValue(TAG_PSDETABLEID, strValue);
    }

    public final boolean isPSDETABLENAMENull() {
        return this.IsParamNull(TAG_PSDETABLENAME);
    }

    public final String getPSDETABLENAME() {
        return this.GetParamStringValue(TAG_PSDETABLENAME, "");
    }

    public final void setPSDETABLENAME(String strValue) {
        this.SetParamValue(TAG_PSDETABLENAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

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
}

