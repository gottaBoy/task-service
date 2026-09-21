/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEWizard
extends BaseDataEntity {
    public static final String TAG_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String TAG_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_INITPSDEACTIONID = "INITPSDEACTIONID";
    public static final String TAG_INITPSDEACTIONNAME = "INITPSDEACTIONNAME";
    public static final String TAG_FINISHPSDEACTIONID = "FINISHPSDEACTIONID";
    public static final String TAG_FINISHPSDEACTIONNAME = "FINISHPSDEACTIONNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_PREVCAPTION = "PREVCAPTION";
    public static final String TAG_NEXTCAPTION = "NEXTCAPTION";
    public static final String TAG_FINISHCAPTION = "FINISHCAPTION";
    public static final String TAG_PREVPSLANRESID = "PREVPSLANRESID";
    public static final String TAG_PREVPSLANRESNAME = "PREVPSLANRESNAME";
    public static final String TAG_NEXTPSLANRESID = "NEXTPSLANRESID";
    public static final String TAG_NEXTPSLANRESNAME = "NEXTPSLANRESNAME";
    public static final String TAG_FINISHPSLANRESID = "FINISHPSLANRESID";
    public static final String TAG_FINISHPSLANRESNAME = "FINISHPSLANRESNAME";
    public static final String TAG_WIZARDSTYLE = "WIZARDSTYLE";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_STATEWIZARDFLAG = "STATEWIZARDFLAG";
    public static final String TAG_STATEPSDEFID = "STATEPSDEFID";
    public static final String TAG_STATEPSDEFNAME = "STATEPSDEFNAME";
    public static final String TAG_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String TAG_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String TAG_PSCTRLMSGID = "PSCTRLMSGID";
    public static final String TAG_PSCTRLMSGNAME = "PSCTRLMSGNAME";
    public static final String TAG_ENABLEMSLOGIC = "ENABLEMSLOGIC";
    public static final String TAG_PSCTRLLOGICGROUPID = "PSCTRLLOGICGROUPID";
    public static final String TAG_PSCTRLLOGICGROUPNAME = "PSCTRLLOGICGROUPNAME";
    public static final String TAG_BUSYINDICATOR = "BUSYINDICATOR";

    public final boolean isPSDEWIZARDIDNull() {
        return this.IsParamNull(TAG_PSDEWIZARDID);
    }

    public final String getPSDEWIZARDID() {
        return this.GetParamStringValue(TAG_PSDEWIZARDID, "");
    }

    public final void setPSDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDID, strValue);
    }

    public final boolean isPSDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_PSDEWIZARDNAME);
    }

    public final String getPSDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_PSDEWIZARDNAME, "");
    }

    public final void setPSDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDNAME, strValue);
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

    public final boolean isINITPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_INITPSDEACTIONID);
    }

    public final String getINITPSDEACTIONID() {
        return this.GetParamStringValue(TAG_INITPSDEACTIONID, "");
    }

    public final void setINITPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_INITPSDEACTIONID, strValue);
    }

    public final boolean isINITPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_INITPSDEACTIONNAME);
    }

    public final String getINITPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_INITPSDEACTIONNAME, "");
    }

    public final void setINITPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_INITPSDEACTIONNAME, strValue);
    }

    public final boolean isFINISHPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_FINISHPSDEACTIONID);
    }

    public final String getFINISHPSDEACTIONID() {
        return this.GetParamStringValue(TAG_FINISHPSDEACTIONID, "");
    }

    public final void setFINISHPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEACTIONID, strValue);
    }

    public final boolean isFINISHPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_FINISHPSDEACTIONNAME);
    }

    public final String getFINISHPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_FINISHPSDEACTIONNAME, "");
    }

    public final void setFINISHPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_FINISHPSDEACTIONNAME, strValue);
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

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isPREVCAPTIONNull() {
        return this.IsParamNull(TAG_PREVCAPTION);
    }

    public final String getPREVCAPTION() {
        return this.GetParamStringValue(TAG_PREVCAPTION, "");
    }

    public final void setPREVCAPTION(String strValue) {
        this.SetParamValue(TAG_PREVCAPTION, strValue);
    }

    public final boolean isNEXTCAPTIONNull() {
        return this.IsParamNull(TAG_NEXTCAPTION);
    }

    public final String getNEXTCAPTION() {
        return this.GetParamStringValue(TAG_NEXTCAPTION, "");
    }

    public final void setNEXTCAPTION(String strValue) {
        this.SetParamValue(TAG_NEXTCAPTION, strValue);
    }

    public final boolean isFINISHCAPTIONNull() {
        return this.IsParamNull(TAG_FINISHCAPTION);
    }

    public final String getFINISHCAPTION() {
        return this.GetParamStringValue(TAG_FINISHCAPTION, "");
    }

    public final void setFINISHCAPTION(String strValue) {
        this.SetParamValue(TAG_FINISHCAPTION, strValue);
    }

    public final boolean isPREVPSLANRESIDNull() {
        return this.IsParamNull(TAG_PREVPSLANRESID);
    }

    public final String getPREVPSLANRESID() {
        return this.GetParamStringValue(TAG_PREVPSLANRESID, "");
    }

    public final void setPREVPSLANRESID(String strValue) {
        this.SetParamValue(TAG_PREVPSLANRESID, strValue);
    }

    public final boolean isPREVPSLANRESNAMENull() {
        return this.IsParamNull(TAG_PREVPSLANRESNAME);
    }

    public final String getPREVPSLANRESNAME() {
        return this.GetParamStringValue(TAG_PREVPSLANRESNAME, "");
    }

    public final void setPREVPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_PREVPSLANRESNAME, strValue);
    }

    public final boolean isNEXTPSLANRESIDNull() {
        return this.IsParamNull(TAG_NEXTPSLANRESID);
    }

    public final String getNEXTPSLANRESID() {
        return this.GetParamStringValue(TAG_NEXTPSLANRESID, "");
    }

    public final void setNEXTPSLANRESID(String strValue) {
        this.SetParamValue(TAG_NEXTPSLANRESID, strValue);
    }

    public final boolean isNEXTPSLANRESNAMENull() {
        return this.IsParamNull(TAG_NEXTPSLANRESNAME);
    }

    public final String getNEXTPSLANRESNAME() {
        return this.GetParamStringValue(TAG_NEXTPSLANRESNAME, "");
    }

    public final void setNEXTPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_NEXTPSLANRESNAME, strValue);
    }

    public final boolean isFINISHPSLANRESIDNull() {
        return this.IsParamNull(TAG_FINISHPSLANRESID);
    }

    public final String getFINISHPSLANRESID() {
        return this.GetParamStringValue(TAG_FINISHPSLANRESID, "");
    }

    public final void setFINISHPSLANRESID(String strValue) {
        this.SetParamValue(TAG_FINISHPSLANRESID, strValue);
    }

    public final boolean isFINISHPSLANRESNAMENull() {
        return this.IsParamNull(TAG_FINISHPSLANRESNAME);
    }

    public final String getFINISHPSLANRESNAME() {
        return this.GetParamStringValue(TAG_FINISHPSLANRESNAME, "");
    }

    public final void setFINISHPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_FINISHPSLANRESNAME, strValue);
    }

    public final boolean isWIZARDSTYLENull() {
        return this.IsParamNull(TAG_WIZARDSTYLE);
    }

    public final String getWIZARDSTYLE() {
        return this.GetParamStringValue(TAG_WIZARDSTYLE, "");
    }

    public final void setWIZARDSTYLE(String strValue) {
        this.SetParamValue(TAG_WIZARDSTYLE, strValue);
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

    public final boolean isSTATEWIZARDFLAGNull() {
        return this.IsParamNull(TAG_STATEWIZARDFLAG);
    }

    public final boolean getSTATEWIZARDFLAG() {
        return this.GetParamIntValue(TAG_STATEWIZARDFLAG, 0) == 1;
    }

    public final void setSTATEWIZARDFLAG(boolean bValue) {
        this.SetParamValue(TAG_STATEWIZARDFLAG, bValue ? 1 : 0);
    }

    public final boolean isSTATEPSDEFIDNull() {
        return this.IsParamNull(TAG_STATEPSDEFID);
    }

    public final String getSTATEPSDEFID() {
        return this.GetParamStringValue(TAG_STATEPSDEFID, "");
    }

    public final void setSTATEPSDEFID(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFID, strValue);
    }

    public final boolean isSTATEPSDEFNAMENull() {
        return this.IsParamNull(TAG_STATEPSDEFNAME);
    }

    public final String getSTATEPSDEFNAME() {
        return this.GetParamStringValue(TAG_STATEPSDEFNAME, "");
    }

    public final void setSTATEPSDEFNAME(String strValue) {
        this.SetParamValue(TAG_STATEPSDEFNAME, strValue);
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

    public final boolean isPSCTRLMSGIDNull() {
        return this.IsParamNull(TAG_PSCTRLMSGID);
    }

    public final String getPSCTRLMSGID() {
        return this.GetParamStringValue(TAG_PSCTRLMSGID, "");
    }

    public final void setPSCTRLMSGID(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGID, strValue);
    }

    public final boolean isPSCTRLMSGNAMENull() {
        return this.IsParamNull(TAG_PSCTRLMSGNAME);
    }

    public final String getPSCTRLMSGNAME() {
        return this.GetParamStringValue(TAG_PSCTRLMSGNAME, "");
    }

    public final void setPSCTRLMSGNAME(String strValue) {
        this.SetParamValue(TAG_PSCTRLMSGNAME, strValue);
    }

    public final boolean isENABLEMSLOGICNull() {
        return this.IsParamNull(TAG_ENABLEMSLOGIC);
    }

    public final boolean getENABLEMSLOGIC() {
        return this.GetParamIntValue(TAG_ENABLEMSLOGIC, 0) == 1;
    }

    public final void setENABLEMSLOGIC(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMSLOGIC, bValue ? 1 : 0);
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

    public final boolean isBUSYINDICATORNull() {
        return this.IsParamNull(TAG_BUSYINDICATOR);
    }

    public final boolean getBUSYINDICATOR() {
        return this.GetParamIntValue(TAG_BUSYINDICATOR, 0) == 1;
    }

    public final void setBUSYINDICATOR(boolean bValue) {
        this.SetParamValue(TAG_BUSYINDICATOR, bValue ? 1 : 0);
    }
}

