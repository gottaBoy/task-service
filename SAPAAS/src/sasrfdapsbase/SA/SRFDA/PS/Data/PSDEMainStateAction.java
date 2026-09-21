/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEMainStateAction
extends BaseDataEntity {
    public static final String ALLOWMODE_ALLOW = "ALLOW";
    public static final String ALLOWMODE_DENY = "DENY";
    public static final String TAG_PSDEMSACTIONID = "PSDEMSACTIONID";
    public static final String TAG_PSDEMSACTIONNAME = "PSDEMSACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEMSID = "PSDEMSID";
    public static final String TAG_PSDEMSNAME = "PSDEMSNAME";
    public static final String TAG_PSDEACTIONID = "PSDEACTIONID";
    public static final String TAG_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String TAG_ALLOWMODE = "ALLOWMODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";

    public final boolean isPSDEMSACTIONIDNull() {
        return this.IsParamNull(TAG_PSDEMSACTIONID);
    }

    public final String getPSDEMSACTIONID() {
        return this.GetParamStringValue(TAG_PSDEMSACTIONID, "");
    }

    public final void setPSDEMSACTIONID(String strValue) {
        this.SetParamValue(TAG_PSDEMSACTIONID, strValue);
    }

    public final boolean isPSDEMSACTIONNAMENull() {
        return this.IsParamNull(TAG_PSDEMSACTIONNAME);
    }

    public final String getPSDEMSACTIONNAME() {
        return this.GetParamStringValue(TAG_PSDEMSACTIONNAME, "");
    }

    public final void setPSDEMSACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMSACTIONNAME, strValue);
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

    public final boolean isPSDEMSIDNull() {
        return this.IsParamNull(TAG_PSDEMSID);
    }

    public final String getPSDEMSID() {
        return this.GetParamStringValue(TAG_PSDEMSID, "");
    }

    public final void setPSDEMSID(String strValue) {
        this.SetParamValue(TAG_PSDEMSID, strValue);
    }

    public final boolean isPSDEMSNAMENull() {
        return this.IsParamNull(TAG_PSDEMSNAME);
    }

    public final String getPSDEMSNAME() {
        return this.GetParamStringValue(TAG_PSDEMSNAME, "");
    }

    public final void setPSDEMSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEMSNAME, strValue);
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

    public final boolean isALLOWMODENull() {
        return this.IsParamNull(TAG_ALLOWMODE);
    }

    public final String getALLOWMODE() {
        return this.GetParamStringValue(TAG_ALLOWMODE, "");
    }

    public final void setALLOWMODE(String strValue) {
        this.SetParamValue(TAG_ALLOWMODE, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }
}

