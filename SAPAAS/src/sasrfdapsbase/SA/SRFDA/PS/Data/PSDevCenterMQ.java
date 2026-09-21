/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenterMQ
extends BaseDataEntity {
    public static final String USAGEMODE_DEVELOP = "DEVELOP";
    public static final String USAGEMODE_DEPLOY = "DEPLOY";
    public static final String TAG_PSDEVCENTERMQID = "PSDEVCENTERMQID";
    public static final String TAG_PSDEVCENTERMQNAME = "PSDEVCENTERMQNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSMQINSTID = "PSMQINSTID";
    public static final String TAG_PSMQINSTNAME = "PSMQINSTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_USAGEMODE = "USAGEMODE";

    public final boolean isPSDEVCENTERMQIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERMQID);
    }

    public final String getPSDEVCENTERMQID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERMQID, "");
    }

    public final void setPSDEVCENTERMQID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERMQID, strValue);
    }

    public final boolean isPSDEVCENTERMQNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERMQNAME);
    }

    public final String getPSDEVCENTERMQNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERMQNAME, "");
    }

    public final void setPSDEVCENTERMQNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERMQNAME, strValue);
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

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSMQINSTIDNull() {
        return this.IsParamNull(TAG_PSMQINSTID);
    }

    public final String getPSMQINSTID() {
        return this.GetParamStringValue(TAG_PSMQINSTID, "");
    }

    public final void setPSMQINSTID(String strValue) {
        this.SetParamValue(TAG_PSMQINSTID, strValue);
    }

    public final boolean isPSMQINSTNAMENull() {
        return this.IsParamNull(TAG_PSMQINSTNAME);
    }

    public final String getPSMQINSTNAME() {
        return this.GetParamStringValue(TAG_PSMQINSTNAME, "");
    }

    public final void setPSMQINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSMQINSTNAME, strValue);
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

    public final boolean isUSAGEMODENull() {
        return this.IsParamNull(TAG_USAGEMODE);
    }

    public final String getUSAGEMODE() {
        return this.GetParamStringValue(TAG_USAGEMODE, "");
    }

    public final void setUSAGEMODE(String strValue) {
        this.SetParamValue(TAG_USAGEMODE, strValue);
    }
}

