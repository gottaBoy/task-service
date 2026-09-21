/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnSys
extends BaseDataEntity {
    public static final String TAG_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String TAG_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEPSYSID = "PSDEPSYSID";
    public static final String TAG_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String TAG_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String TAG_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_DEPSYSSTATE = "DEPSYSSTATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_ENABLEDYNASYS = "ENABLEDYNASYS";

    public final boolean isPSDEPSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSID);
    }

    public final String getPSDEPSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSID, "");
    }

    public final void setPSDEPSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSID, strValue);
    }

    public final boolean isPSDEPSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNSYSNAME);
    }

    public final String getPSDEPSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNSYSNAME, "");
    }

    public final void setPSDEPSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNSYSNAME, strValue);
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

    public final boolean isPSDEPSLNIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.GetParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNNAME, strValue);
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

    public final boolean isPSDEPSYSIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSID);
    }

    public final String getPSDEPSYSID() {
        return this.GetParamStringValue(TAG_PSDEPSYSID, "");
    }

    public final void setPSDEPSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSID, strValue);
    }

    public final boolean isPSDEPSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSNAME);
    }

    public final String getPSDEPSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSNAME, "");
    }

    public final void setPSDEPSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSNAME, strValue);
    }

    public final boolean isPSDEPSYSVERIDNull() {
        return this.IsParamNull(TAG_PSDEPSYSVERID);
    }

    public final String getPSDEPSYSVERID() {
        return this.GetParamStringValue(TAG_PSDEPSYSVERID, "");
    }

    public final void setPSDEPSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSVERID, strValue);
    }

    public final boolean isPSDEPSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSDEPSYSVERNAME);
    }

    public final String getPSDEPSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSDEPSYSVERNAME, "");
    }

    public final void setPSDEPSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSVERNAME, strValue);
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

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
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

    public final boolean isDEPSYSSTATENull() {
        return this.IsParamNull(TAG_DEPSYSSTATE);
    }

    public final int getDEPSYSSTATE() {
        return this.GetParamIntValue(TAG_DEPSYSSTATE, 0);
    }

    public final void setDEPSYSSTATE(int nValue) {
        this.SetParamValue(TAG_DEPSYSSTATE, nValue);
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

    public final boolean isENABLEDYNASYSNull() {
        return this.IsParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.GetParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }
}

