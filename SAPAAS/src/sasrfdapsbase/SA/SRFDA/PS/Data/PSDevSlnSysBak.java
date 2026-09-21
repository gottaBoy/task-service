/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSysBak
extends BaseDataEntity {
    public static final int BACKUPSTATE_10 = 10;
    public static final int BACKUPSTATE_20 = 20;
    public static final int BACKUPSTATE_30 = 30;
    public static final int BACKUPSTATE_40 = 40;
    public static final String TAG_PSDEVSLNSYSBAKID = "PSDEVSLNSYSBAKID";
    public static final String TAG_PSDEVSLNSYSBAKNAME = "PSDEVSLNSYSBAKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_BACKUPSTATE = "BACKUPSTATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ENDBACKUPTIME = "ENDBACKUPTIME";
    public static final String TAG_BEGINBACKUPTIME = "BEGINBACKUPTIME";
    public static final String TAG_BACKUPTIME = "BACKUPTIME";
    public static final String TAG_BACKUPSIZE = "BACKUPSIZE";
    public static final String TAG_BACKUPFILEPATH = "BACKUPFILEPATH";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";

    public final boolean isPSDEVSLNSYSBAKIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSBAKID);
    }

    public final String getPSDEVSLNSYSBAKID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSBAKID, "");
    }

    public final void setPSDEVSLNSYSBAKID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSBAKID, strValue);
    }

    public final boolean isPSDEVSLNSYSBAKNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSBAKNAME);
    }

    public final String getPSDEVSLNSYSBAKNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSBAKNAME, "");
    }

    public final void setPSDEVSLNSYSBAKNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSBAKNAME, strValue);
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

    public final boolean isBACKUPSTATENull() {
        return this.IsParamNull(TAG_BACKUPSTATE);
    }

    public final int getBACKUPSTATE() {
        return this.GetParamIntValue(TAG_BACKUPSTATE, 0);
    }

    public final void setBACKUPSTATE(int nValue) {
        this.SetParamValue(TAG_BACKUPSTATE, nValue);
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

    public final boolean isENDBACKUPTIMENull() {
        return this.IsParamNull(TAG_ENDBACKUPTIME);
    }

    public final Date getENDBACKUPTIME() {
        return this.GetParamDateValue(TAG_ENDBACKUPTIME, null);
    }

    public final void setENDBACKUPTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDBACKUPTIME, dtValue);
    }

    public final boolean isBEGINBACKUPTIMENull() {
        return this.IsParamNull(TAG_BEGINBACKUPTIME);
    }

    public final Date getBEGINBACKUPTIME() {
        return this.GetParamDateValue(TAG_BEGINBACKUPTIME, null);
    }

    public final void setBEGINBACKUPTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINBACKUPTIME, dtValue);
    }

    public final boolean isBACKUPTIMENull() {
        return this.IsParamNull(TAG_BACKUPTIME);
    }

    public final Date getBACKUPTIME() {
        return this.GetParamDateValue(TAG_BACKUPTIME, null);
    }

    public final void setBACKUPTIME(Date dtValue) {
        this.SetParamValue(TAG_BACKUPTIME, dtValue);
    }

    public final boolean isBACKUPSIZENull() {
        return this.IsParamNull(TAG_BACKUPSIZE);
    }

    public final int getBACKUPSIZE() {
        return this.GetParamIntValue(TAG_BACKUPSIZE, 0);
    }

    public final void setBACKUPSIZE(int nValue) {
        this.SetParamValue(TAG_BACKUPSIZE, nValue);
    }

    public final boolean isBACKUPFILEPATHNull() {
        return this.IsParamNull(TAG_BACKUPFILEPATH);
    }

    public final String getBACKUPFILEPATH() {
        return this.GetParamStringValue(TAG_BACKUPFILEPATH, "");
    }

    public final void setBACKUPFILEPATH(String strValue) {
        this.SetParamValue(TAG_BACKUPFILEPATH, strValue);
    }

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
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

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
    }
}

