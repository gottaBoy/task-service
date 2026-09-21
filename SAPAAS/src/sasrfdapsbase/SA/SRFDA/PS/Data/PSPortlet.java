/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSPortlet
extends BaseDataEntity {
    public static final String PORTLETTYPE_CHART = "CHART";
    public static final String PORTLETTYPE_LIST = "LIST";
    public static final String PORTLETTYPE_CUSTOM = "CUSTOM";
    public static final String PORTLETTYPE_VIEW = "VIEW";
    public static final String PORTLETTYPE_HTML = "HTML";
    public static final String TAG_PSPORTLETID = "PSPORTLETID";
    public static final String TAG_PSPORTLETNAME = "PSPORTLETNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PORTLETTYPE = "PORTLETTYPE";
    public static final String TAG_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String TAG_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String TAG_BASECLSPARAMS = "BASECLSPARAMS";

    public final boolean isPSPORTLETIDNull() {
        return this.IsParamNull(TAG_PSPORTLETID);
    }

    public final String getPSPORTLETID() {
        return this.GetParamStringValue(TAG_PSPORTLETID, "");
    }

    public final void setPSPORTLETID(String strValue) {
        this.SetParamValue(TAG_PSPORTLETID, strValue);
    }

    public final boolean isPSPORTLETNAMENull() {
        return this.IsParamNull(TAG_PSPORTLETNAME);
    }

    public final String getPSPORTLETNAME() {
        return this.GetParamStringValue(TAG_PSPORTLETNAME, "");
    }

    public final void setPSPORTLETNAME(String strValue) {
        this.SetParamValue(TAG_PSPORTLETNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
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

    public final boolean isPORTLETTYPENull() {
        return this.IsParamNull(TAG_PORTLETTYPE);
    }

    public final String getPORTLETTYPE() {
        return this.GetParamStringValue(TAG_PORTLETTYPE, "");
    }

    public final void setPORTLETTYPE(String strValue) {
        this.SetParamValue(TAG_PORTLETTYPE, strValue);
    }

    public final boolean isPSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSPFPLUGINID);
    }

    public final String getPSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSPFPLUGINID, "");
    }

    public final void setPSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSPFPLUGINID, strValue);
    }

    public final boolean isPSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSPFPLUGINNAME);
    }

    public final String getPSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSPFPLUGINNAME, "");
    }

    public final void setPSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSPFPLUGINNAME, strValue);
    }

    public final boolean isBASECLSPARAMSNull() {
        return this.IsParamNull(TAG_BASECLSPARAMS);
    }

    public final String getBASECLSPARAMS() {
        return this.GetParamStringValue(TAG_BASECLSPARAMS, "");
    }

    public final void setBASECLSPARAMS(String strValue) {
        this.SetParamValue(TAG_BASECLSPARAMS, strValue);
    }
}

