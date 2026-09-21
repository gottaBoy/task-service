/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSubDEAction
extends BaseDataEntity {
    public static final String TAG_PSSUBDEACTIONID = "PSSUBDEACTIONID";
    public static final String TAG_PSSUBDEACTIONNAME = "PSSUBDEACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSUBDEID = "PSSUBDEID";
    public static final String TAG_PSSUBDENAME = "PSSUBDENAME";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";

    public final boolean isPSSUBDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSSUBDEACTIONID);
    }

    public final String getPSSUBDEACTIONID() {
        return this.GetParamStringValue(TAG_PSSUBDEACTIONID, "");
    }

    public final void setPSSUBDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSSUBDEACTIONID, strValue);
    }

    public final boolean isPSSUBDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSSUBDEACTIONNAME);
    }

    public final String getPSSUBDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSSUBDEACTIONNAME, "");
    }

    public final void setPSSUBDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSSUBDEACTIONNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONID);
    }

    public final String getPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PSDEACTIONID, "");
    }

    public final void setPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONID, strValue);
    }
}

