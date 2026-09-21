/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSysVer
extends BaseDataEntity {
    public static final String PSDEPSYSVERTYPE_DEVSLNSYS = "DEVSLNSYS";
    public static final String PSDEPSYSVERTYPE_SAASSYS = "SAASSYS";
    public static final String TAG_PSDEPSYSVERID = "PSDEPSYSVERID";
    public static final String TAG_PSDEPSYSVERNAME = "PSDEPSYSVERNAME";
    public static final String TAG_PSDEPSYSVERTYPE = "PSDEPSYSVERTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSYSID = "PSDEPSYSID";
    public static final String TAG_PSDEPSYSNAME = "PSDEPSYSNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SYSVER = "SYSVER";
    public static final String TAG_DBVERSION = "DBVERSION";
    public static final String TAG_MODELINSTVER = "MODELINSTVER";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String TAG_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";

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

    public final boolean isPSDEPSYSVERTYPENull() {
        return this.IsParamNull(TAG_PSDEPSYSVERTYPE);
    }

    public final String getPSDEPSYSVERTYPE() {
        return this.GetParamStringValue(TAG_PSDEPSYSVERTYPE, "");
    }

    public final void setPSDEPSYSVERTYPE(String strValue) {
        this.SetParamValue(TAG_PSDEPSYSVERTYPE, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isSYSVERNull() {
        return this.IsParamNull(TAG_SYSVER);
    }

    public final String getSYSVER() {
        return this.GetParamStringValue(TAG_SYSVER, "");
    }

    public final void setSYSVER(String strValue) {
        this.SetParamValue(TAG_SYSVER, strValue);
    }

    public final boolean isDBVERSIONNull() {
        return this.IsParamNull(TAG_DBVERSION);
    }

    public final int getDBVERSION() {
        return this.GetParamIntValue(TAG_DBVERSION, 0);
    }

    public final void setDBVERSION(int nValue) {
        this.SetParamValue(TAG_DBVERSION, nValue);
    }

    public final boolean isMODELINSTVERNull() {
        return this.IsParamNull(TAG_MODELINSTVER);
    }

    public final int getMODELINSTVER() {
        return this.GetParamIntValue(TAG_MODELINSTVER, 0);
    }

    public final void setMODELINSTVER(int nValue) {
        this.SetParamValue(TAG_MODELINSTVER, nValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isROPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNID);
    }

    public final String getROPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNID, "");
    }

    public final void setROPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNID, strValue);
    }

    public final boolean isROPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNNAME);
    }

    public final String getROPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNNAME, "");
    }

    public final void setROPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNNAME, strValue);
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
}

