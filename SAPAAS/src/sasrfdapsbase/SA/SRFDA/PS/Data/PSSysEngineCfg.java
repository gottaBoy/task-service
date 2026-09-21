/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysEngineCfg
extends BaseDataEntity {
    public static final int IMPDEFRULE_1 = 1;
    public static final String TAG_PSSYSENGINECFGID = "PSSYSENGINECFGID";
    public static final String TAG_PSSYSENGINECFGNAME = "PSSYSENGINECFGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_GLOBALFLAG = "GLOBALFLAG";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_IMPDEFRULE = "IMPDEFRULE";
    public static final String TAG_CFGVER = "CFGVER";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_VIEWUAREGMODE = "VIEWUAREGMODE";
    public static final String TAG_VIEWCTRLAJAXMODE = "VIEWCTRLAJAXMODE";
    public static final String TAG_VIEWCTRLHANDLERFIRST = "VIEWCTRLHANDLERFIRST";

    public final boolean isPSSYSENGINECFGIDNull() {
        return this.IsParamNull(TAG_PSSYSENGINECFGID);
    }

    public final String getPSSYSENGINECFGID() {
        return this.GetParamStringValue(TAG_PSSYSENGINECFGID, "");
    }

    public final void setPSSYSENGINECFGID(String strValue) {
        this.SetParamValue(TAG_PSSYSENGINECFGID, strValue);
    }

    public final boolean isPSSYSENGINECFGNAMENull() {
        return this.IsParamNull(TAG_PSSYSENGINECFGNAME);
    }

    public final String getPSSYSENGINECFGNAME() {
        return this.GetParamStringValue(TAG_PSSYSENGINECFGNAME, "");
    }

    public final void setPSSYSENGINECFGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSENGINECFGNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isGLOBALFLAGNull() {
        return this.IsParamNull(TAG_GLOBALFLAG);
    }

    public final boolean getGLOBALFLAG() {
        return this.GetParamIntValue(TAG_GLOBALFLAG, 0) == 1;
    }

    public final void setGLOBALFLAG(boolean bValue) {
        this.SetParamValue(TAG_GLOBALFLAG, bValue ? 1 : 0);
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

    public final boolean isIMPDEFRULENull() {
        return this.IsParamNull(TAG_IMPDEFRULE);
    }

    public final int getIMPDEFRULE() {
        return this.GetParamIntValue(TAG_IMPDEFRULE, 0);
    }

    public final void setIMPDEFRULE(int nValue) {
        this.SetParamValue(TAG_IMPDEFRULE, nValue);
    }

    public final boolean isCFGVERNull() {
        return this.IsParamNull(TAG_CFGVER);
    }

    public final int getCFGVER() {
        return this.GetParamIntValue(TAG_CFGVER, 0);
    }

    public final void setCFGVER(int nValue) {
        this.SetParamValue(TAG_CFGVER, nValue);
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

    public final boolean isVIEWUAREGMODENull() {
        return this.IsParamNull(TAG_VIEWUAREGMODE);
    }

    public final int getVIEWUAREGMODE() {
        return this.GetParamIntValue(TAG_VIEWUAREGMODE, 0);
    }

    public final void setVIEWUAREGMODE(int nValue) {
        this.SetParamValue(TAG_VIEWUAREGMODE, nValue);
    }

    public final boolean isVIEWCTRLAJAXMODENull() {
        return this.IsParamNull(TAG_VIEWCTRLAJAXMODE);
    }

    public final int getVIEWCTRLAJAXMODE() {
        return this.GetParamIntValue(TAG_VIEWCTRLAJAXMODE, 0);
    }

    public final void setVIEWCTRLAJAXMODE(int nValue) {
        this.SetParamValue(TAG_VIEWCTRLAJAXMODE, nValue);
    }

    public final boolean isVIEWCTRLHANDLERFIRSTNull() {
        return this.IsParamNull(TAG_VIEWCTRLHANDLERFIRST);
    }

    public final boolean getVIEWCTRLHANDLERFIRST() {
        return this.GetParamIntValue(TAG_VIEWCTRLHANDLERFIRST, 0) == 1;
    }

    public final void setVIEWCTRLHANDLERFIRST(boolean bValue) {
        this.SetParamValue(TAG_VIEWCTRLHANDLERFIRST, bValue ? 1 : 0);
    }
}

