/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEAWGrpDetail
extends BaseDataEntity {
    public static final String TAG_PSDEAWGRPDETAILID = "PSDEAWGRPDETAILID";
    public static final String TAG_PSDEAWGRPDETAILNAME = "PSDEAWGRPDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEAWGROUPID = "PSDEAWGROUPID";
    public static final String TAG_PSDEAWGROUPNAME = "PSDEAWGROUPNAME";
    public static final String TAG_PSDEACTIONWIZARDID = "PSDEACTIONWIZARDID";
    public static final String TAG_PSDEACTIONWIZARDNAME = "PSDEACTIONWIZARDNAME";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEAWGRPDETAILIDNull() {
        return this.IsParamNull(TAG_PSDEAWGRPDETAILID);
    }

    public final String getPSDEAWGRPDETAILID() {
        return this.GetParamStringValue(TAG_PSDEAWGRPDETAILID, "");
    }

    public final void setPSDEAWGRPDETAILID(String strValue) {
        this.SetParamValue(TAG_PSDEAWGRPDETAILID, strValue);
    }

    public final boolean isPSDEAWGRPDETAILNAMENull() {
        return this.IsParamNull(TAG_PSDEAWGRPDETAILNAME);
    }

    public final String getPSDEAWGRPDETAILNAME() {
        return this.GetParamStringValue(TAG_PSDEAWGRPDETAILNAME, "");
    }

    public final void setPSDEAWGRPDETAILNAME(String strValue) {
        this.SetParamValue(TAG_PSDEAWGRPDETAILNAME, strValue);
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

    public final boolean isPSDEAWGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEAWGROUPID);
    }

    public final String getPSDEAWGROUPID() {
        return this.GetParamStringValue(TAG_PSDEAWGROUPID, "");
    }

    public final void setPSDEAWGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEAWGROUPID, strValue);
    }

    public final boolean isPSDEAWGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEAWGROUPNAME);
    }

    public final String getPSDEAWGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEAWGROUPNAME, "");
    }

    public final void setPSDEAWGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEAWGROUPNAME, strValue);
    }

    public final boolean isPSDEACTIONWIZARDIDNull() {
        return this.IsParamNull(TAG_PSDEACTIONWIZARDID);
    }

    public final String getPSDEACTIONWIZARDID() {
        return this.GetParamStringValue(TAG_PSDEACTIONWIZARDID, "");
    }

    public final void setPSDEACTIONWIZARDID(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONWIZARDID, strValue);
    }

    public final boolean isPSDEACTIONWIZARDNAMENull() {
        return this.IsParamNull(TAG_PSDEACTIONWIZARDNAME);
    }

    public final String getPSDEACTIONWIZARDNAME() {
        return this.GetParamStringValue(TAG_PSDEACTIONWIZARDNAME, "");
    }

    public final void setPSDEACTIONWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEACTIONWIZARDNAME, strValue);
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
}

