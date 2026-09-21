/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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
        return this.isParamNull(TAG_PSDEPSLNSYSID);
    }

    public final String getPSDEPSLNSYSID() {
        return this.getParamStringValue(TAG_PSDEPSLNSYSID, "");
    }

    public final void setPSDEPSLNSYSID(String strValue) {
        this.setParamValue(TAG_PSDEPSLNSYSID, strValue);
    }

    public final boolean isPSDEPSLNSYSNAMENull() {
        return this.isParamNull(TAG_PSDEPSLNSYSNAME);
    }

    public final String getPSDEPSLNSYSNAME() {
        return this.getParamStringValue(TAG_PSDEPSLNSYSNAME, "");
    }

    public final void setPSDEPSLNSYSNAME(String strValue) {
        this.setParamValue(TAG_PSDEPSLNSYSNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isPSDEPSLNIDNull() {
        return this.isParamNull(TAG_PSDEPSLNID);
    }

    public final String getPSDEPSLNID() {
        return this.getParamStringValue(TAG_PSDEPSLNID, "");
    }

    public final void setPSDEPSLNID(String strValue) {
        this.setParamValue(TAG_PSDEPSLNID, strValue);
    }

    public final boolean isPSDEPSLNNAMENull() {
        return this.isParamNull(TAG_PSDEPSLNNAME);
    }

    public final String getPSDEPSLNNAME() {
        return this.getParamStringValue(TAG_PSDEPSLNNAME, "");
    }

    public final void setPSDEPSLNNAME(String strValue) {
        this.setParamValue(TAG_PSDEPSLNNAME, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEPSYSIDNull() {
        return this.isParamNull(TAG_PSDEPSYSID);
    }

    public final String getPSDEPSYSID() {
        return this.getParamStringValue(TAG_PSDEPSYSID, "");
    }

    public final void setPSDEPSYSID(String strValue) {
        this.setParamValue(TAG_PSDEPSYSID, strValue);
    }

    public final boolean isPSDEPSYSNAMENull() {
        return this.isParamNull(TAG_PSDEPSYSNAME);
    }

    public final String getPSDEPSYSNAME() {
        return this.getParamStringValue(TAG_PSDEPSYSNAME, "");
    }

    public final void setPSDEPSYSNAME(String strValue) {
        this.setParamValue(TAG_PSDEPSYSNAME, strValue);
    }

    public final boolean isPSDEPSYSVERIDNull() {
        return this.isParamNull(TAG_PSDEPSYSVERID);
    }

    public final String getPSDEPSYSVERID() {
        return this.getParamStringValue(TAG_PSDEPSYSVERID, "");
    }

    public final void setPSDEPSYSVERID(String strValue) {
        this.setParamValue(TAG_PSDEPSYSVERID, strValue);
    }

    public final boolean isPSDEPSYSVERNAMENull() {
        return this.isParamNull(TAG_PSDEPSYSVERNAME);
    }

    public final String getPSDEPSYSVERNAME() {
        return this.getParamStringValue(TAG_PSDEPSYSVERNAME, "");
    }

    public final void setPSDEPSYSVERNAME(String strValue) {
        this.setParamValue(TAG_PSDEPSYSVERNAME, strValue);
    }

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.isParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.getParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.setParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.isParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.getParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.setParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.isParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.getParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.setParamValue(TAG_EXPRIEDTIME, dtValue);
    }

    public final boolean isPSSYSTEMIDNull() {
        return this.isParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.getParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.setParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.isParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.getParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.setParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isDEPSYSSTATENull() {
        return this.isParamNull(TAG_DEPSYSSTATE);
    }

    public final int getDEPSYSSTATE() {
        return this.getParamIntValue(TAG_DEPSYSSTATE, 0);
    }

    public final void setDEPSYSSTATE(int nValue) {
        this.setParamValue(TAG_DEPSYSSTATE, nValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.isParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.getParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.isParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.getParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.setParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isENABLEDYNASYSNull() {
        return this.isParamNull(TAG_ENABLEDYNASYS);
    }

    public final boolean getENABLEDYNASYS() {
        return this.getParamIntValue(TAG_ENABLEDYNASYS, 0) == 1;
    }

    public final void setENABLEDYNASYS(boolean bValue) {
        this.setParamValue(TAG_ENABLEDYNASYS, bValue ? 1 : 0);
    }
}

