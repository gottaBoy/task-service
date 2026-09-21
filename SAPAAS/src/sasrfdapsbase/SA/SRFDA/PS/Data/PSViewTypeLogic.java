/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSViewTypeLogic
extends BaseDataEntity {
    public static final String TAG_PSVIEWTYPELOGICID = "PSVIEWTYPELOGICID";
    public static final String TAG_PSVIEWTYPELOGICNAME = "PSVIEWTYPELOGICNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String TAG_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String TAG_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";

    public final boolean isPSVIEWTYPELOGICIDNull() {
        return this.IsParamNull(TAG_PSVIEWTYPELOGICID);
    }

    public final String getPSVIEWTYPELOGICID() {
        return this.GetParamStringValue(TAG_PSVIEWTYPELOGICID, "");
    }

    public final void setPSVIEWTYPELOGICID(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPELOGICID, strValue);
    }

    public final boolean isPSVIEWTYPELOGICNAMENull() {
        return this.IsParamNull(TAG_PSVIEWTYPELOGICNAME);
    }

    public final String getPSVIEWTYPELOGICNAME() {
        return this.GetParamStringValue(TAG_PSVIEWTYPELOGICNAME, "");
    }

    public final void setPSVIEWTYPELOGICNAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPELOGICNAME, strValue);
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

    public final boolean isPSVIEWTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWTYPEID);
    }

    public final String getPSVIEWTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWTYPEID, "");
    }

    public final void setPSVIEWTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPEID, strValue);
    }

    public final boolean isPSVIEWTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWTYPENAME);
    }

    public final String getPSVIEWTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWTYPENAME, "");
    }

    public final void setPSVIEWTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWTYPENAME, strValue);
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

    public final boolean isPSVIEWLOGICTYPEIDNull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPEID);
    }

    public final String getPSVIEWLOGICTYPEID() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPEID, "");
    }

    public final void setPSVIEWLOGICTYPEID(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPEID, strValue);
    }

    public final boolean isPSVIEWLOGICTYPENAMENull() {
        return this.IsParamNull(TAG_PSVIEWLOGICTYPENAME);
    }

    public final String getPSVIEWLOGICTYPENAME() {
        return this.GetParamStringValue(TAG_PSVIEWLOGICTYPENAME, "");
    }

    public final void setPSVIEWLOGICTYPENAME(String strValue) {
        this.SetParamValue(TAG_PSVIEWLOGICTYPENAME, strValue);
    }
}

