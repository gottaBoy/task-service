/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCWorkspace
extends BaseDataEntity {
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String WORKSPACETYPE_DEMO = "DEMO";
    public static final String WORKSPACESTATE_10 = "10";
    public static final String WORKSPACESTATE_20 = "20";
    public static final String WORKSPACESTATE_30 = "30";
    public static final String WORKSPACESTATE_35 = "35";
    public static final String WORKSPACESTATE_40 = "40";
    public static final String TAG_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String TAG_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String TAG_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String TAG_EXPIREDTIME = "EXPIREDTIME";
    public static final String TAG_WORKSPACETYPE = "WORKSPACETYPE";
    public static final String TAG_WORKSPACESTATE = "WORKSPACESTATE";
    public static final String TAG_WORKSPACELEVEL = "WORKSPACELEVEL";
    public static final String TAG_IPADDRS = "IPADDRS";
    public static final String TAG_CURACTIVETIME = "CURACTIVETIME";
    public static final String TAG_CUREXPIREDTIME = "CUREXPIREDTIME";

    public final boolean isPSDCWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEID);
    }

    public final String getPSDCWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEID, "");
    }

    public final void setPSDCWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEID, strValue);
    }

    public final boolean isPSDCWORKSPACENAMENull() {
        return this.IsParamNull(TAG_PSDCWORKSPACENAME);
    }

    public final String getPSDCWORKSPACENAME() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACENAME, "");
    }

    public final void setPSDCWORKSPACENAME(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACENAME, strValue);
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

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
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

    public final boolean isPSWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSWORKSPACEID);
    }

    public final String getPSWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSWORKSPACEID, "");
    }

    public final void setPSWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSWORKSPACEID, strValue);
    }

    public final boolean isPSWORKSPACENAMENull() {
        return this.IsParamNull(TAG_PSWORKSPACENAME);
    }

    public final String getPSWORKSPACENAME() {
        return this.GetParamStringValue(TAG_PSWORKSPACENAME, "");
    }

    public final void setPSWORKSPACENAME(String strValue) {
        this.SetParamValue(TAG_PSWORKSPACENAME, strValue);
    }

    public final boolean isEXPIREDTIMENull() {
        return this.IsParamNull(TAG_EXPIREDTIME);
    }

    public final Date getEXPIREDTIME() {
        return this.GetParamDateValue(TAG_EXPIREDTIME, null);
    }

    public final void setEXPIREDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPIREDTIME, dtValue);
    }

    public final boolean isWORKSPACETYPENull() {
        return this.IsParamNull(TAG_WORKSPACETYPE);
    }

    public final String getWORKSPACETYPE() {
        return this.GetParamStringValue(TAG_WORKSPACETYPE, "");
    }

    public final void setWORKSPACETYPE(String strValue) {
        this.SetParamValue(TAG_WORKSPACETYPE, strValue);
    }

    public final boolean isWORKSPACESTATENull() {
        return this.IsParamNull(TAG_WORKSPACESTATE);
    }

    public final int getWORKSPACESTATE() {
        return this.GetParamIntValue(TAG_WORKSPACESTATE, 0);
    }

    public final void setWORKSPACESTATE(int nValue) {
        this.SetParamValue(TAG_WORKSPACESTATE, nValue);
    }

    public final boolean isWORKSPACELEVELNull() {
        return this.IsParamNull(TAG_WORKSPACELEVEL);
    }

    public final int getWORKSPACELEVEL() {
        return this.GetParamIntValue(TAG_WORKSPACELEVEL, 0);
    }

    public final void setWORKSPACELEVEL(int nValue) {
        this.SetParamValue(TAG_WORKSPACELEVEL, nValue);
    }

    public final boolean isIPADDRSNull() {
        return this.IsParamNull(TAG_IPADDRS);
    }

    public final String getIPADDRS() {
        return this.GetParamStringValue(TAG_IPADDRS, "");
    }

    public final void setIPADDRS(String strValue) {
        this.SetParamValue(TAG_IPADDRS, strValue);
    }

    public final boolean isCURACTIVETIMENull() {
        return this.IsParamNull(TAG_CURACTIVETIME);
    }

    public final Date getCURACTIVETIME() {
        return this.GetParamDateValue(TAG_CURACTIVETIME, null);
    }

    public final void setCURACTIVETIME(Date dtValue) {
        this.SetParamValue(TAG_CURACTIVETIME, dtValue);
    }

    public final boolean isCUREXPIREDTIMENull() {
        return this.IsParamNull(TAG_CUREXPIREDTIME);
    }

    public final Date getCUREXPIREDTIME() {
        return this.GetParamDateValue(TAG_CUREXPIREDTIME, null);
    }

    public final void setCUREXPIREDTIME(Date dtValue) {
        this.SetParamValue(TAG_CUREXPIREDTIME, dtValue);
    }
}

