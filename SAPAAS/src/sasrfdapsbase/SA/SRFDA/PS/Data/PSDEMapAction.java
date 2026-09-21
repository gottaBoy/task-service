/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMapAction
extends BaseDataEntity {
    public static final String TAG_PSDEMAPACTIONID = "PSDEMAPACTIONID";
    public static final String TAG_PSDEMAPACTIONNAME = "PSDEMAPACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEMAPID = "PSDEMAPID";
    public static final String TAG_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String TAG_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PROPERTYMAP = "PROPERTYMAP";
    public static final String TAG_MAPMODE = "MAPMODE";

    public final boolean isPSDEMAPACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEMAPACTIONID);
    }

    public final String getPSDEMAPACTIONID() {
        return this.GetParamStringValue(TAG_PSDEMAPACTIONID, "");
    }

    public final void setPSDEMAPACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPACTIONID, strValue);
    }

    public final boolean isPSDEMAPACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPACTIONNAME);
    }

    public final String getPSDEMAPACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPACTIONNAME, "");
    }

    public final void setPSDEMAPACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPACTIONNAME, strValue);
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

    public final boolean isPSDEMAPIDNull() {
        return this.IsParamNull(TAG_PSDEMAPID);
    }

    public final String getPSDEMAPID() {
        return this.GetParamStringValue(TAG_PSDEMAPID, "");
    }

    public final void setPSDEMAPID(String strValue) {
        this.SetParamValue(TAG_PSDEMAPID, strValue);
    }

    public final boolean isPSDEMAPNAMENull() {
        return this.IsParamNull(TAG_PSDEMAPNAME);
    }

    public final String getPSDEMAPNAME() {
        return this.GetParamStringValue(TAG_PSDEMAPNAME, "");
    }

    public final void setPSDEMAPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMAPNAME, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONNAME);
    }

    public final String getPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONNAME, "");
    }

    public final void setPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONNAME, strValue);
    }

    public final boolean isDSTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_DSTPSDEACTIONID);
    }

    public final String getDSTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_DSTPSDEACTIONID, "");
    }

    public final void setDSTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEACTIONID, strValue);
    }

    public final boolean isDSTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEACTIONNAME);
    }

    public final String getDSTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEACTIONNAME, "");
    }

    public final void setDSTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEACTIONNAME, strValue);
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

    public final boolean isPROPERTYMAPNull() {
        return this.IsParamNull(TAG_PROPERTYMAP);
    }

    public final String getPROPERTYMAP() {
        return this.GetParamStringValue(TAG_PROPERTYMAP, "");
    }

    public final void setPROPERTYMAP(String strValue) {
        this.SetParamValue(TAG_PROPERTYMAP, strValue);
    }

    public final boolean isMAPMODENull() {
        return this.IsParamNull(TAG_MAPMODE);
    }

    public final String getMAPMODE() {
        return this.GetParamStringValue(TAG_MAPMODE, "");
    }

    public final void setMAPMODE(String strValue) {
        this.SetParamValue(TAG_MAPMODE, strValue);
    }
}

