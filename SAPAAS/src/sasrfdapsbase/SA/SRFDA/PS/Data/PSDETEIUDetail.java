/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDETEIUDetail
extends BaseDataEntity {
    public static final String TAG_PSDETEIUDETAILID = "PSDETEIUDETAILID";
    public static final String TAG_PSDETEIUDETAILNAME = "PSDETEIUDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String TAG_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String TAG_PSDETREECOLID = "PSDETREECOLID";
    public static final String TAG_PSDETREECOLNAME = "PSDETREECOLNAME";
    public static final String TAG_PSDETEIUPDATEID = "PSDETEIUPDATEID";
    public static final String TAG_PSDETEIUPDATENAME = "PSDETEIUPDATENAME";

    public final boolean isPSDETEIUDETAILIDNull() {
        return this.IsParamNull(TAG_PSDETEIUDETAILID);
    }

    public final String getPSDETEIUDETAILID() {
        return this.GetParamStringValue(TAG_PSDETEIUDETAILID, "");
    }

    public final void setPSDETEIUDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDETEIUDETAILID, strValue);
    }

    public final boolean isPSDETEIUDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDETEIUDETAILNAME);
    }

    public final String getPSDETEIUDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDETEIUDETAILNAME, "");
    }

    public final void setPSDETEIUDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDETEIUDETAILNAME, strValue);
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

    public final boolean isPSDETREEVIEWIDNull() {
        return this.IsParamNull(TAG_PSDETREEVIEWID);
    }

    public final String getPSDETREEVIEWID() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWID, "");
    }

    public final void setPSDETREEVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWID, strValue);
    }

    public final boolean isPSDETREEVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDETREEVIEWNAME);
    }

    public final String getPSDETREEVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDETREEVIEWNAME, "");
    }

    public final void setPSDETREEVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREEVIEWNAME, strValue);
    }

    public final boolean isPSDETREECOLIDNull() {
        return this.IsParamNull(TAG_PSDETREECOLID);
    }

    public final String getPSDETREECOLID() {
        return this.GetParamStringValue(TAG_PSDETREECOLID, "");
    }

    public final void setPSDETREECOLID(String strValue) {
        this.SetParamValue(TAG_PSDETREECOLID, strValue);
    }

    public final boolean isPSDETREECOLNAMENull() {
        return this.IsParamNull(TAG_PSDETREECOLNAME);
    }

    public final String getPSDETREECOLNAME() {
        return this.GetParamStringValue(TAG_PSDETREECOLNAME, "");
    }

    public final void setPSDETREECOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDETREECOLNAME, strValue);
    }

    public final boolean isPSDETEIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDETEIUPDATEID);
    }

    public final String getPSDETEIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDETEIUPDATEID, "");
    }

    public final void setPSDETEIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDETEIUPDATEID, strValue);
    }

    public final boolean isPSDETEIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDETEIUPDATENAME);
    }

    public final String getPSDETEIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDETEIUPDATENAME, "");
    }

    public final void setPSDETEIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDETEIUPDATENAME, strValue);
    }
}

