/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCDBView
extends BaseDataEntity {
    public static final String TAG_PSDCDBVIEWID = "PSDCDBVIEWID";
    public static final String TAG_PSDCDBVIEWNAME = "PSDCDBVIEWNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SQL = "SQL";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String TAG_PSDCDBINSTNAME = "PSDCDBINSTNAME";

    public final boolean isPSDCDBVIEWIDNull() {
        return this.IsParamNull(TAG_PSDCDBVIEWID);
    }

    public final String getPSDCDBVIEWID() {
        return this.GetParamStringValue(TAG_PSDCDBVIEWID, "");
    }

    public final void setPSDCDBVIEWID(String strValue) {
        this.SetParamValue(TAG_PSDCDBVIEWID, strValue);
    }

    public final boolean isPSDCDBVIEWNAMENull() {
        return this.IsParamNull(TAG_PSDCDBVIEWNAME);
    }

    public final String getPSDCDBVIEWNAME() {
        return this.GetParamStringValue(TAG_PSDCDBVIEWNAME, "");
    }

    public final void setPSDCDBVIEWNAME(String strValue) {
        this.SetParamValue(TAG_PSDCDBVIEWNAME, strValue);
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

    public final boolean isSQLNull() {
        return this.IsParamNull(TAG_SQL);
    }

    public final String getSQL() {
        return this.GetParamStringValue(TAG_SQL, "");
    }

    public final void setSQL(String strValue) {
        this.SetParamValue(TAG_SQL, strValue);
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

    public final boolean isPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDCDBINSTID);
    }

    public final String getPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_PSDCDBINSTID, "");
    }

    public final void setPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDCDBINSTID, strValue);
    }

    public final boolean isPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDCDBINSTNAME);
    }

    public final String getPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDCDBINSTNAME, "");
    }

    public final void setPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDCDBINSTNAME, strValue);
    }
}

