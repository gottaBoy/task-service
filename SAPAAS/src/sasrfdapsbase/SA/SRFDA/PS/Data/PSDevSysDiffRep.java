/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSysDiffRep
extends BaseDataEntity {
    public static final int REPSTATE_NOTSTART = 10;
    public static final int REPSTATE_PROCESSING = 20;
    public static final int REPSTATE_FINISHED = 30;
    public static final int REPSTATE_CANCELLED = 40;
    public static final String TAG_PSDEVSYSDIFFREPID = "PSDEVSYSDIFFREPID";
    public static final String TAG_PSDEVSYSDIFFREPNAME = "PSDEVSYSDIFFREPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_REPSTATE = "REPSTATE";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_DSTPSDEVSLNSYSID = "DSTPSDEVSLNSYSID";
    public static final String TAG_DSTPSDEVSLNSYSNAME = "DSTPSDEVSLNSYSNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_SYSMODELVER = "SYSMODELVER";
    public static final String TAG_DSTSYSMODELVER = "DSTSYSMODELVER";
    public static final String TAG_MEMO = "MEMO";

    public final boolean isPSDEVSYSDIFFREPIDNull() {
        return this.IsParamNull(TAG_PSDEVSYSDIFFREPID);
    }

    public final String getPSDEVSYSDIFFREPID() {
        return this.GetParamStringValue(TAG_PSDEVSYSDIFFREPID, "");
    }

    public final void setPSDEVSYSDIFFREPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSYSDIFFREPID, strValue);
    }

    public final boolean isPSDEVSYSDIFFREPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSYSDIFFREPNAME);
    }

    public final String getPSDEVSYSDIFFREPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSYSDIFFREPNAME, "");
    }

    public final void setPSDEVSYSDIFFREPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSYSDIFFREPNAME, strValue);
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

    public final boolean isREPSTATENull() {
        return this.IsParamNull(TAG_REPSTATE);
    }

    public final int getREPSTATE() {
        return this.GetParamIntValue(TAG_REPSTATE, 0);
    }

    public final void setREPSTATE(int nValue) {
        this.SetParamValue(TAG_REPSTATE, nValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
    }

    public final boolean isDSTPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_DSTPSDEVSLNSYSID);
    }

    public final String getDSTPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_DSTPSDEVSLNSYSID, "");
    }

    public final void setDSTPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_DSTPSDEVSLNSYSID, strValue);
    }

    public final boolean isDSTPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_DSTPSDEVSLNSYSNAME);
    }

    public final String getDSTPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_DSTPSDEVSLNSYSNAME, "");
    }

    public final void setDSTPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_DSTPSDEVSLNSYSNAME, strValue);
    }

    public final boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public final Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public final void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public final boolean isSYSMODELVERNull() {
        return this.IsParamNull(TAG_SYSMODELVER);
    }

    public final int getSYSMODELVER() {
        return this.GetParamIntValue(TAG_SYSMODELVER, 0);
    }

    public final void setSYSMODELVER(int nValue) {
        this.SetParamValue(TAG_SYSMODELVER, nValue);
    }

    public final boolean isDSTSYSMODELVERNull() {
        return this.IsParamNull(TAG_DSTSYSMODELVER);
    }

    public final int getDSTSYSMODELVER() {
        return this.GetParamIntValue(TAG_DSTSYSMODELVER, 0);
    }

    public final void setDSTSYSMODELVER(int nValue) {
        this.SetParamValue(TAG_DSTSYSMODELVER, nValue);
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

