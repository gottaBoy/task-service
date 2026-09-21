/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSTaskServerCmd
extends BaseDataEntity {
    public static final String TAG_PSTSCMDID = "PSTSCMDID";
    public static final String TAG_PSTSCMDNAME = "PSTSCMDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RUNCMD = "RUNCMD";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String TAG_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String TAG_DATA = "DATA";
    public static final String TAG_RESULT = "RESULT";
    public static final String TAG_TASKNAME = "TASKNAME";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";

    public final boolean isPSTSCMDIDNull() {
        return this.IsParamNull(TAG_PSTSCMDID);
    }

    public final String getPSTSCMDID() {
        return this.GetParamStringValue(TAG_PSTSCMDID, "");
    }

    public final void setPSTSCMDID(String strValue) {
        this.SetParamValue(TAG_PSTSCMDID, strValue);
    }

    public final boolean isPSTSCMDNAMENull() {
        return this.IsParamNull(TAG_PSTSCMDNAME);
    }

    public final String getPSTSCMDNAME() {
        return this.GetParamStringValue(TAG_PSTSCMDNAME, "");
    }

    public final void setPSTSCMDNAME(String strValue) {
        this.SetParamValue(TAG_PSTSCMDNAME, strValue);
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

    public final boolean isRUNCMDNull() {
        return this.IsParamNull(TAG_RUNCMD);
    }

    public final String getRUNCMD() {
        return this.GetParamStringValue(TAG_RUNCMD, "");
    }

    public final void setRUNCMD(String strValue) {
        this.SetParamValue(TAG_RUNCMD, strValue);
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

    public final boolean isPSDEVSLNTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNTEMPLID);
    }

    public final String getPSDEVSLNTEMPLID() {
        return this.GetParamStringValue(TAG_PSDEVSLNTEMPLID, "");
    }

    public final void setPSDEVSLNTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNTEMPLID, strValue);
    }

    public final boolean isPSDEVSLNTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNTEMPLNAME);
    }

    public final String getPSDEVSLNTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNTEMPLNAME, "");
    }

    public final void setPSDEVSLNTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNTEMPLNAME, strValue);
    }

    public final boolean isDATANull() {
        return this.IsParamNull(TAG_DATA);
    }

    public final String getDATA() {
        return this.GetParamStringValue(TAG_DATA, "");
    }

    public final void setDATA(String strValue) {
        this.SetParamValue(TAG_DATA, strValue);
    }

    public final boolean isRESULTNull() {
        return this.IsParamNull(TAG_RESULT);
    }

    public final String getRESULT() {
        return this.GetParamStringValue(TAG_RESULT, "");
    }

    public final void setRESULT(String strValue) {
        this.SetParamValue(TAG_RESULT, strValue);
    }

    public final boolean isTASKNAMENull() {
        return this.IsParamNull(TAG_TASKNAME);
    }

    public final String getTASKNAME() {
        return this.GetParamStringValue(TAG_TASKNAME, "");
    }

    public final void setTASKNAME(String strValue) {
        this.SetParamValue(TAG_TASKNAME, strValue);
    }

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
    }
}

