/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnMSDepApp
extends BaseDataEntity {
    public static final String TAG_PSDEVSLNMSDEPAPPID = "PSDEVSLNMSDEPAPPID";
    public static final String TAG_PSDEVSLNMSDEPAPPNAME = "PSDEVSLNMSDEPAPPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNMSDEPLOYID = "PSDEVSLNMSDEPLOYID";
    public static final String TAG_PSDEVSLNMSDEPLOYNAME = "PSDEVSLNMSDEPLOYNAME";
    public static final String TAG_PSDCMSPLATFORMNODEID = "PSDCMSPLATFORMNODEID";
    public static final String TAG_PSDCMSPLATFORMNODENAME = "PSDCMSPLATFORMNODENAME";
    public static final String TAG_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String TAG_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_HTTPADDRESS = "HTTPADDRESS";
    public static final String TAG_HTTPPORT = "HTTPPORT";
    public static final String TAG_HTTPSPORT = "HTTPSPORT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSDCMSPLATFORMID = "PSDCMSPLATFORMID";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String TAG_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String TAG_USERPARAMS = "USERPARAMS";

    public final boolean isPSDEVSLNMSDEPAPPIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPPID);
    }

    public final String getPSDEVSLNMSDEPAPPID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPAPPID, "");
    }

    public final void setPSDEVSLNMSDEPAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPPID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPAPPNAME);
    }

    public final String getPSDEVSLNMSDEPAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPAPPNAME, "");
    }

    public final void setPSDEVSLNMSDEPAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPAPPNAME, strValue);
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

    public final boolean isPSDCMSPLATFORMNODEIDNull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMNODEID);
    }

    public final String getPSDCMSPLATFORMNODEID() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMNODEID, "");
    }

    public final void setPSDCMSPLATFORMNODEID(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMNODEID, strValue);
    }

    public final boolean isPSDCMSPLATFORMNODENAMENull() {
        return this.IsParamNull(TAG_PSDCMSPLATFORMNODENAME);
    }

    public final String getPSDCMSPLATFORMNODENAME() {
        return this.GetParamStringValue(TAG_PSDCMSPLATFORMNODENAME, "");
    }

    public final void setPSDCMSPLATFORMNODENAME(String strValue) {
        this.SetParamValue(TAG_PSDCMSPLATFORMNODENAME, strValue);
    }

    public final boolean isPSDEVSLNSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPID);
    }

    public final String getPSDEVSLNSYSAPPID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPID, "");
    }

    public final void setPSDEVSLNSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPID, strValue);
    }

    public final boolean isPSDEVSLNSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPNAME);
    }

    public final String getPSDEVSLNSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPNAME, "");
    }

    public final void setPSDEVSLNSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPNAME, strValue);
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

    public final boolean isHTTPADDRESSNull() {
        return this.IsParamNull(TAG_HTTPADDRESS);
    }

    public final String getHTTPADDRESS() {
        return this.GetParamStringValue(TAG_HTTPADDRESS, "");
    }

    public final void setHTTPADDRESS(String strValue) {
        this.SetParamValue(TAG_HTTPADDRESS, strValue);
    }

    public final boolean isHTTPPORTNull() {
        return this.IsParamNull(TAG_HTTPPORT);
    }

    public final int getHTTPPORT() {
        return this.GetParamIntValue(TAG_HTTPPORT, 0);
    }

    public final void setHTTPPORT(int nValue) {
        this.SetParamValue(TAG_HTTPPORT, nValue);
    }

    public final boolean isHTTPSPORTNull() {
        return this.IsParamNull(TAG_HTTPSPORT);
    }

    public final int getHTTPSPORT() {
        return this.GetParamIntValue(TAG_HTTPSPORT, 0);
    }

    public final void setHTTPSPORT(int nValue) {
        this.SetParamValue(TAG_HTTPSPORT, nValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSDEVCENTERDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTID);
    }

    public final String getPSDEVCENTERDBINSTID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTID, "");
    }

    public final void setPSDEVCENTERDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTID, strValue);
    }

    public final boolean isPSDEVCENTERDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTNAME);
    }

    public final String getPSDEVCENTERDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTNAME, "");
    }

    public final void setPSDEVCENTERDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTNAME, strValue);
    }

    public final boolean isUSERPARAMSNull() {
        return this.IsParamNull(TAG_USERPARAMS);
    }

    public final String getUSERPARAMS() {
        return this.GetParamStringValue(TAG_USERPARAMS, "");
    }

    public final void setUSERPARAMS(String strValue) {
        this.SetParamValue(TAG_USERPARAMS, strValue);
    }
}

