/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEFGridColumn
extends BaseDataEntity {
    public static final String GCMODE_DEFAULT = "DEFAULT";
    public static final String GCMODE_CUSTOM = "CUSTOM";
    public static final String TAG_PSDEFGRIDCOLID = "PSDEFGRIDCOLID";
    public static final String TAG_PSDEFGRIDCOLNAME = "PSDEFGRIDCOLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_GCMODE = "GCMODE";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEFID = "PSDEFID";
    public static final String TAG_PSDEFNAME = "PSDEFNAME";

    public final boolean isPSDEFGRIDCOLIDNull() {
        return this.IsParamNull(TAG_PSDEFGRIDCOLID);
    }

    public final String getPSDEFGRIDCOLID() {
        return this.GetParamStringValue(TAG_PSDEFGRIDCOLID, "");
    }

    public final void setPSDEFGRIDCOLID(String strValue) {
        this.SetParamValue(TAG_PSDEFGRIDCOLID, strValue);
    }

    public final boolean isPSDEFGRIDCOLNAMENull() {
        return this.IsParamNull(TAG_PSDEFGRIDCOLNAME);
    }

    public final String getPSDEFGRIDCOLNAME() {
        return this.GetParamStringValue(TAG_PSDEFGRIDCOLNAME, "");
    }

    public final void setPSDEFGRIDCOLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFGRIDCOLNAME, strValue);
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

    public final boolean isGCMODENull() {
        return this.IsParamNull(TAG_GCMODE);
    }

    public final String getGCMODE() {
        return this.GetParamStringValue(TAG_GCMODE, "");
    }

    public final void setGCMODE(String strValue) {
        this.SetParamValue(TAG_GCMODE, strValue);
    }

    public final boolean isWIDTHNull() {
        return this.IsParamNull(TAG_WIDTH);
    }

    public final int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public final void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
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

    public final boolean isPSDEFIDNull() {
        return this.IsParamNull(TAG_PSDEFID);
    }

    public final String getPSDEFID() {
        return this.GetParamStringValue(TAG_PSDEFID, "");
    }

    public final void setPSDEFID(String strValue) {
        this.SetParamValue(TAG_PSDEFID, strValue);
    }

    public final boolean isPSDEFNAMENull() {
        return this.IsParamNull(TAG_PSDEFNAME);
    }

    public final String getPSDEFNAME() {
        return this.GetParamStringValue(TAG_PSDEFNAME, "");
    }

    public final void setPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFNAME, strValue);
    }
}

