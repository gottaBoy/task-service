/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFIUDetail
extends BaseDataEntity {
    public static final String TAG_PSDEFIUDETAILID = "PSDEFIUDETAILID";
    public static final String TAG_PSDEFIUDETAILNAME = "PSDEFIUDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEFIUPDATEID = "PSDEFIUPDATEID";
    public static final String TAG_PSDEFIUPDATENAME = "PSDEFIUPDATENAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String TAG_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";

    public final boolean isPSDEFIUDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEFIUDETAILID);
    }

    public final String getPSDEFIUDETAILID() {
        return this.GetParamStringValue(TAG_PSDEFIUDETAILID, "");
    }

    public final void setPSDEFIUDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEFIUDETAILID, strValue);
    }

    public final boolean isPSDEFIUDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEFIUDETAILNAME);
    }

    public final String getPSDEFIUDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEFIUDETAILNAME, "");
    }

    public final void setPSDEFIUDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFIUDETAILNAME, strValue);
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

    public final boolean isPSDEFIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDEFIUPDATEID);
    }

    public final String getPSDEFIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDEFIUPDATEID, "");
    }

    public final void setPSDEFIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDEFIUPDATEID, strValue);
    }

    public final boolean isPSDEFIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDEFIUPDATENAME);
    }

    public final String getPSDEFIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDEFIUPDATENAME, "");
    }

    public final void setPSDEFIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEFIUPDATENAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEFORMDETAILID);
    }

    public final String getPSDEFORMDETAILID() {
        return this.GetParamStringValue(TAG_PSDEFORMDETAILID, "");
    }

    public final void setPSDEFORMDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMDETAILID, strValue);
    }

    public final boolean isPSDEFORMDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMDETAILNAME);
    }

    public final String getPSDEFORMDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMDETAILNAME, "");
    }

    public final void setPSDEFORMDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMDETAILNAME, strValue);
    }
}

