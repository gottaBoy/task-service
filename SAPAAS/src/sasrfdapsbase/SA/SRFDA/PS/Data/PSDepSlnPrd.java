/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDepSlnPrd
extends BaseDataEntity {
    public static final String TAG_PSDEPSLNPRDID = "PSDEPSLNPRDID";
    public static final String TAG_PSDEPSLNPRDNAME = "PSDEPSLNPRDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEPSLNID = "PSDEPSLNID";
    public static final String TAG_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String TAG_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String TAG_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";

    public final boolean isPSDEPSLNPRDIDNull() {
        return this.IsParamNull(TAG_PSDEPSLNPRDID);
    }

    public final String getPSDEPSLNPRDID() {
        return this.GetParamStringValue(TAG_PSDEPSLNPRDID, "");
    }

    public final void setPSDEPSLNPRDID(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNPRDID, strValue);
    }

    public final boolean isPSDEPSLNPRDNAMENull() {
        return this.IsParamNull(TAG_PSDEPSLNPRDNAME);
    }

    public final String getPSDEPSLNPRDNAME() {
        return this.GetParamStringValue(TAG_PSDEPSLNPRDNAME, "");
    }

    public final void setPSDEPSLNPRDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPSLNPRDNAME, strValue);
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

    public final boolean isPSDEVSLNSYSVERIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSVERID);
    }

    public final String getPSDEVSLNSYSVERID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSVERID, "");
    }

    public final void setPSDEVSLNSYSVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSVERID, strValue);
    }

    public final boolean isPSDEVSLNSYSVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSVERNAME);
    }

    public final String getPSDEVSLNSYSVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSVERNAME, "");
    }

    public final void setPSDEVSLNSYSVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSVERNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
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
}

