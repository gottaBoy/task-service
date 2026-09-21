/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEGEIUDetail
extends BaseDataEntity {
    public static final String TAG_PSDEGEIUDETAILID = "PSDEGEIUDETAILID";
    public static final String TAG_PSDEGEIUDETAILNAME = "PSDEGEIUDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEGEIUPDATEID = "PSDEGEIUPDATEID";
    public static final String TAG_PSDEGEIUPDATENAME = "PSDEGEIUPDATENAME";
    public static final String TAG_PSDEGRIDCOLID = "PSDEGRIDCOLID";
    public static final String TAG_PSDEGRIDCOLNAME = "PSDEGRIDCOLNAME";
    public static final String TAG_PSDEGRIDID = "PSDEGRIDID";
    public static final String TAG_PSDEGRIDNAME = "PSDEGRIDNAME";

    public final boolean isPSDEGEIUDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEGEIUDETAILID);
    }

    public final String getPSDEGEIUDETAILID() {
        return this.GetParamStringValue(TAG_PSDEGEIUDETAILID, "");
    }

    public final void setPSDEGEIUDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEGEIUDETAILID, strValue);
    }

    public final boolean isPSDEGEIUDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEGEIUDETAILNAME);
    }

    public final String getPSDEGEIUDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEGEIUDETAILNAME, "");
    }

    public final void setPSDEGEIUDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGEIUDETAILNAME, strValue);
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

    public final boolean isPSDEGEIUPDATEIDNull() {
        return this.IsParamNull(TAG_PSDEGEIUPDATEID);
    }

    public final String getPSDEGEIUPDATEID() {
        return this.GetParamStringValue(TAG_PSDEGEIUPDATEID, "");
    }

    public final void setPSDEGEIUPDATEID(String strValue) {
        this.SetParamValue(TAG_PSDEGEIUPDATEID, strValue);
    }

    public final boolean isPSDEGEIUPDATENAMENull() {
        return this.IsParamNull(TAG_PSDEGEIUPDATENAME);
    }

    public final String getPSDEGEIUPDATENAME() {
        return this.GetParamStringValue(TAG_PSDEGEIUPDATENAME, "");
    }

    public final void setPSDEGEIUPDATENAME(String strValue) {
        this.SetParamValue(TAG_PSDEGEIUPDATENAME, strValue);
    }

    public final boolean isPSDEGRIDCOLIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDCOLID);
    }

    public final String getPSDEGRIDCOLID() {
        return this.GetParamStringValue(TAG_PSDEGRIDCOLID, "");
    }

    public final void setPSDEGRIDCOLID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDCOLID, strValue);
    }

    public final boolean isPSDEGRIDCOLNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDCOLNAME);
    }

    public final String getPSDEGRIDCOLNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDCOLNAME, "");
    }

    public final void setPSDEGRIDCOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDCOLNAME, strValue);
    }

    public final boolean isPSDEGRIDIDNull() {
        return this.IsParamNull(TAG_PSDEGRIDID);
    }

    public final String getPSDEGRIDID() {
        return this.GetParamStringValue(TAG_PSDEGRIDID, "");
    }

    public final void setPSDEGRIDID(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDID, strValue);
    }

    public final boolean isPSDEGRIDNAMENull() {
        return this.IsParamNull(TAG_PSDEGRIDNAME);
    }

    public final String getPSDEGRIDNAME() {
        return this.GetParamStringValue(TAG_PSDEGRIDNAME, "");
    }

    public final void setPSDEGRIDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEGRIDNAME, strValue);
    }
}

