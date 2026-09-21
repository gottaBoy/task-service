/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysTitleBar
extends BaseDataEntity {
    public static final String TITLEBARSTYLE_USER = "USER";
    public static final String TITLEBARSTYLE_USER2 = "USER2";
    public static final String TAG_PSSYSTITLEBARID = "PSSYSTITLEBARID";
    public static final String TAG_PSSYSTITLEBARNAME = "PSSYSTITLEBARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_TITLEBARSTYLE = "TITLEBARSTYLE";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String TAG_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String TAG_LEFTPSDETOOLBARID = "LEFTPSDETOOLBARID";
    public static final String TAG_LEFTPSDETOOLBARNAME = "LEFTPSDETOOLBARNAME";
    public static final String TAG_RIGHTPSDETOOLBARID = "RIGHTPSDETOOLBARID";
    public static final String TAG_RIGHTPSDETOOLBARNAME = "RIGHTPSDETOOLBARNAME";

    public final boolean isPSSYSTITLEBARIDNull() {
        return this.IsParamNull(TAG_PSSYSTITLEBARID);
    }

    public final String getPSSYSTITLEBARID() {
        return this.GetParamStringValue(TAG_PSSYSTITLEBARID, "");
    }

    public final void setPSSYSTITLEBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSTITLEBARID, strValue);
    }

    public final boolean isPSSYSTITLEBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSTITLEBARNAME);
    }

    public final String getPSSYSTITLEBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSTITLEBARNAME, "");
    }

    public final void setPSSYSTITLEBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTITLEBARNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
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

    public final boolean isPSSYSPFPLUGINIDNull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINID);
    }

    public final String getPSSYSPFPLUGINID() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINID, "");
    }

    public final void setPSSYSPFPLUGINID(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINID, strValue);
    }

    public final boolean isPSSYSPFPLUGINNAMENull() {
        return this.IsParamNull(TAG_PSSYSPFPLUGINNAME);
    }

    public final String getPSSYSPFPLUGINNAME() {
        return this.GetParamStringValue(TAG_PSSYSPFPLUGINNAME, "");
    }

    public final void setPSSYSPFPLUGINNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSPFPLUGINNAME, strValue);
    }

    public final boolean isTITLEBARSTYLENull() {
        return this.IsParamNull(TAG_TITLEBARSTYLE);
    }

    public final String getTITLEBARSTYLE() {
        return this.GetParamStringValue(TAG_TITLEBARSTYLE, "");
    }

    public final void setTITLEBARSTYLE(String strValue) {
        this.SetParamValue(TAG_TITLEBARSTYLE, strValue);
    }

    public final boolean isCAPTIONNull() {
        return this.IsParamNull(TAG_CAPTION);
    }

    public final String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public final void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public final boolean isCAPPSLANRESIDNull() {
        return this.IsParamNull(TAG_CAPPSLANRESID);
    }

    public final String getCAPPSLANRESID() {
        return this.GetParamStringValue(TAG_CAPPSLANRESID, "");
    }

    public final void setCAPPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESID, strValue);
    }

    public final boolean isCAPPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CAPPSLANRESNAME);
    }

    public final String getCAPPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CAPPSLANRESNAME, "");
    }

    public final void setCAPPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CAPPSLANRESNAME, strValue);
    }

    public final boolean isLEFTPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_LEFTPSDETOOLBARID);
    }

    public final String getLEFTPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_LEFTPSDETOOLBARID, "");
    }

    public final void setLEFTPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_LEFTPSDETOOLBARID, strValue);
    }

    public final boolean isLEFTPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_LEFTPSDETOOLBARNAME);
    }

    public final String getLEFTPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_LEFTPSDETOOLBARNAME, "");
    }

    public final void setLEFTPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_LEFTPSDETOOLBARNAME, strValue);
    }

    public final boolean isRIGHTPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_RIGHTPSDETOOLBARID);
    }

    public final String getRIGHTPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_RIGHTPSDETOOLBARID, "");
    }

    public final void setRIGHTPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_RIGHTPSDETOOLBARID, strValue);
    }

    public final boolean isRIGHTPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_RIGHTPSDETOOLBARNAME);
    }

    public final String getRIGHTPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_RIGHTPSDETOOLBARNAME, "");
    }

    public final void setRIGHTPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_RIGHTPSDETOOLBARNAME, strValue);
    }
}

