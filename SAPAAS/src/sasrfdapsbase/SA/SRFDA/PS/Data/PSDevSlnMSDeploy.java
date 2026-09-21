/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnMSDeploy
extends BaseDataEntity {
    public static final String TAG_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String TAG_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String TAG_PSDCMSPLATFORMNAME = "PSDCMSPLATFORMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDEVSLNMSDEPAPPSCNT = "PSDEVSLNMSDEPAPPSCNT";
    public static final String TAG_PSDEVSLNMSDEPAPISCNT = "PSDEVSLNMSDEPAPISCNT";

    public final boolean isPSDEVSLNMSDEPLOYIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPLOYID);
    }

    public final String getPSDEVSLNMSDEPLOYID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPLOYID, "");
    }

    public final void setPSDEVSLNMSDEPLOYID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPLOYID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPLOYNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPLOYNAME);
    }

    public final String getPSDEVSLNMSDEPLOYNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPLOYNAME, "");
    }

    public final void setPSDEVSLNMSDEPLOYNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPLOYNAME, strValue);
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

    public final boolean isPSDCMSPLATFORMIDNull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMID);
    }

    public final String getPSDCMSPLATFORMID() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMID, "");
    }

    public final void setPSDCMSPLATFORMID(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMID, strValue);
    }

    public final boolean isPSDCMSPLATFORMNAMENull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMNAME);
    }

    public final String getPSDCMSPLATFORMNAME() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMNAME, "");
    }

    public final void setPSDCMSPLATFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMNAME, strValue);
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

    public final boolean isPSDEVSLNMSDEPAPPSCNTNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPPSCNT);
    }

    public final int getPSDEVSLNMSDEPAPPSCNT() {
        return this.GetParamIntValue(TAG_PSDEVSLNMSDEPAPPSCNT, 0);
    }

    public final void setPSDEVSLNMSDEPAPPSCNT(int nValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPPSCNT, nValue);
    }

    public final boolean isPSDEVSLNMSDEPAPISCNTNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPISCNT);
    }

    public final int getPSDEVSLNMSDEPAPISCNT() {
        return this.GetParamIntValue(TAG_PSDEVSLNMSDEPAPISCNT, 0);
    }

    public final void setPSDEVSLNMSDEPAPISCNT(int nValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPISCNT, nValue);
    }
}

