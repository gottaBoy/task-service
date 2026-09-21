/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEToolbar
extends BaseDataEntity {
    public static final String TOOLBARSTYLE_TOOLBAR = "TOOLBAR";
    public static final String TOOLBARSTYLE_MENU = "MENU";
    public static final String TOOLBARSTYLE_CONTEXTMENU = "CONTEXTMENU";
    public static final String TAG_PSDETOOLBARID = "PSDETOOLBARID";
    public static final String TAG_PSDETOOLBARNAME = "PSDETOOLBARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_TEMPLTOOLBAR = "TEMPLTOOLBAR";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_TOOLBARSN = "TOOLBARSN";
    public static final String TAG_TBMODEL = "TBMODEL";
    public static final String TAG_PSSYSTOOLBARID = "PSSYSTOOLBARID";
    public static final String TAG_PSSYSTOOLBARNAME = "PSSYSTOOLBARNAME";
    public static final String TAG_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String TAG_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String TAG_NO2PSDEUAGROUPID = "NO2PSDEUAGROUPID";
    public static final String TAG_NO2PSDEUAGROUPNAME = "NO2PSDEUAGROUPNAME";
    public static final String TAG_NO3PSDEUAGROUPID = "NO3PSDEUAGROUPID";
    public static final String TAG_NO3PSDEUAGROUPNAME = "NO3PSDEUAGROUPNAME";
    public static final String TAG_NO4PSDEUAGROUPID = "NO4PSDEUAGROUPID";
    public static final String TAG_NO4PSDEUAGROUPNAME = "NO4PSDEUAGROUPNAME";
    public static final String TAG_NO5PSDEUAGROUPID = "NO5PSDEUAGROUPID";
    public static final String TAG_NO5PSDEUAGROUPNAME = "NO5PSDEUAGROUPNAME";
    public static final String TAG_NO6PSDEUAGROUPID = "NO6PSDEUAGROUPID";
    public static final String TAG_NO6PSDEUAGROUPNAME = "NO6PSDEUAGROUPNAME";
    public static final String TAG_USERPARAMS = "USERPARAMS";
    public static final String TAG_TOOLBARSTYLE = "TOOLBARSTYLE";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";

    public final boolean isPSDETOOLBARIDNull() {
        return this.IsParamNull(TAG_PSDETOOLBARID);
    }

    public final String getPSDETOOLBARID() {
        return this.GetParamStringValue(TAG_PSDETOOLBARID, "");
    }

    public final void setPSDETOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARID, strValue);
    }

    public final boolean isPSDETOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSDETOOLBARNAME);
    }

    public final String getPSDETOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSDETOOLBARNAME, "");
    }

    public final void setPSDETOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSDETOOLBARNAME, strValue);
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

    public final boolean isTEMPLTOOLBARNull() {
        return this.IsParamNull(TAG_TEMPLTOOLBAR);
    }

    public final boolean getTEMPLTOOLBAR() {
        return this.GetParamIntValue(TAG_TEMPLTOOLBAR, 0) == 1;
    }

    public final void setTEMPLTOOLBAR(boolean bValue) {
        this.SetParamValue(TAG_TEMPLTOOLBAR, bValue ? 1 : 0);
    }

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
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

    public final boolean isTOOLBARSNNull() {
        return this.IsParamNull(TAG_TOOLBARSN);
    }

    public final String getTOOLBARSN() {
        return this.GetParamStringValue(TAG_TOOLBARSN, "");
    }

    public final void setTOOLBARSN(String strValue) {
        this.SetParamValue(TAG_TOOLBARSN, strValue);
    }

    public final boolean isTBMODELNull() {
        return this.IsParamNull(TAG_TBMODEL);
    }

    public final String getTBMODEL() {
        return this.GetParamStringValue(TAG_TBMODEL, "");
    }

    public final void setTBMODEL(String strValue) {
        this.SetParamValue(TAG_TBMODEL, strValue);
    }

    public final boolean isPSSYSTOOLBARIDNull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARID);
    }

    public final String getPSSYSTOOLBARID() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARID, "");
    }

    public final void setPSSYSTOOLBARID(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARID, strValue);
    }

    public final boolean isPSSYSTOOLBARNAMENull() {
        return this.IsParamNull(TAG_PSSYSTOOLBARNAME);
    }

    public final String getPSSYSTOOLBARNAME() {
        return this.GetParamStringValue(TAG_PSSYSTOOLBARNAME, "");
    }

    public final void setPSSYSTOOLBARNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTOOLBARNAME, strValue);
    }

    public final boolean isPSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_PSDEUAGROUPID);
    }

    public final String getPSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPID, "");
    }

    public final void setPSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPID, strValue);
    }

    public final boolean isPSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDEUAGROUPNAME);
    }

    public final String getPSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDEUAGROUPNAME, "");
    }

    public final void setPSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO2PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO2PSDEUAGROUPID);
    }

    public final String getNO2PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO2PSDEUAGROUPID, "");
    }

    public final void setNO2PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO2PSDEUAGROUPID, strValue);
    }

    public final boolean isNO2PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO2PSDEUAGROUPNAME);
    }

    public final String getNO2PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO2PSDEUAGROUPNAME, "");
    }

    public final void setNO2PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO3PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO3PSDEUAGROUPID);
    }

    public final String getNO3PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO3PSDEUAGROUPID, "");
    }

    public final void setNO3PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO3PSDEUAGROUPID, strValue);
    }

    public final boolean isNO3PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO3PSDEUAGROUPNAME);
    }

    public final String getNO3PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO3PSDEUAGROUPNAME, "");
    }

    public final void setNO3PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO3PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO4PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO4PSDEUAGROUPID);
    }

    public final String getNO4PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO4PSDEUAGROUPID, "");
    }

    public final void setNO4PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO4PSDEUAGROUPID, strValue);
    }

    public final boolean isNO4PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO4PSDEUAGROUPNAME);
    }

    public final String getNO4PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO4PSDEUAGROUPNAME, "");
    }

    public final void setNO4PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO4PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO5PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO5PSDEUAGROUPID);
    }

    public final String getNO5PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO5PSDEUAGROUPID, "");
    }

    public final void setNO5PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO5PSDEUAGROUPID, strValue);
    }

    public final boolean isNO5PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO5PSDEUAGROUPNAME);
    }

    public final String getNO5PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO5PSDEUAGROUPNAME, "");
    }

    public final void setNO5PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO5PSDEUAGROUPNAME, strValue);
    }

    public final boolean isNO6PSDEUAGROUPIDNull() {
        return this.IsParamNull(TAG_NO6PSDEUAGROUPID);
    }

    public final String getNO6PSDEUAGROUPID() {
        return this.GetParamStringValue(TAG_NO6PSDEUAGROUPID, "");
    }

    public final void setNO6PSDEUAGROUPID(String strValue) {
        this.SetParamValue(TAG_NO6PSDEUAGROUPID, strValue);
    }

    public final boolean isNO6PSDEUAGROUPNAMENull() {
        return this.IsParamNull(TAG_NO6PSDEUAGROUPNAME);
    }

    public final String getNO6PSDEUAGROUPNAME() {
        return this.GetParamStringValue(TAG_NO6PSDEUAGROUPNAME, "");
    }

    public final void setNO6PSDEUAGROUPNAME(String strValue) {
        this.SetParamValue(TAG_NO6PSDEUAGROUPNAME, strValue);
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

    public final boolean isTOOLBARSTYLENull() {
        return this.IsParamNull(TAG_TOOLBARSTYLE);
    }

    public final String getTOOLBARSTYLE() {
        return this.GetParamStringValue(TAG_TOOLBARSTYLE, "");
    }

    public final void setTOOLBARSTYLE(String strValue) {
        this.SetParamValue(TAG_TOOLBARSTYLE, strValue);
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

    public final boolean isPSSYSCSSIDNull() {
        return this.IsParamNull(TAG_PSSYSCSSID);
    }

    public final String getPSSYSCSSID() {
        return this.GetParamStringValue(TAG_PSSYSCSSID, "");
    }

    public final void setPSSYSCSSID(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSID, strValue);
    }

    public final boolean isPSSYSCSSNAMENull() {
        return this.IsParamNull(TAG_PSSYSCSSNAME);
    }

    public final String getPSSYSCSSNAME() {
        return this.GetParamStringValue(TAG_PSSYSCSSNAME, "");
    }

    public final void setPSSYSCSSNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSCSSNAME, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPIDNull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPID);
    }

    public final String getPSCTRLLOGICGROUPID() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPID, "");
    }

    public final void setPSCTRLLOGICGROUPID(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPID, strValue);
    }

    public final boolean isPSCTRLLOGICGROUPNAMENull() {
        return this.IsParamNull(TAG_PSCTRLLOGICGROUPNAME);
    }

    public final String getPSCTRLLOGICGROUPNAME() {
        return this.GetParamStringValue(TAG_PSCTRLLOGICGROUPNAME, "");
    }

    public final void setPSCTRLLOGICGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLLOGICGROUPNAME, strValue);
    }
}

