/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEWizardForm
extends BaseDataEntity {
    public static final String STEPACTIONS_PREV = "PREV";
    public static final String STEPACTIONS_NEXT = "NEXT";
    public static final String STEPACTIONS_FINISH = "FINISH";
    public static final String TAG_PSDEWIZARDFORMID = "PSDEWIZARDFORMID";
    public static final String TAG_PSDEWIZARDFORMNAME = "PSDEWIZARDFORMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String TAG_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String TAG_PSDEWIZARDSTEPID = "PSDEWIZARDSTEPID";
    public static final String TAG_PSDEWIZARDSTEPNAME = "PSDEWIZARDSTEPNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_LOADPSDEACTIONID = "LOADPSDEACTIONID";
    public static final String TAG_LOADPSDEACTIONNAME = "LOADPSDEACTIONNAME";
    public static final String TAG_SAVEPSDEACTIONID = "SAVEPSDEACTIONID";
    public static final String TAG_SAVEPSDEACTIONNAME = "SAVEPSDEACTIONNAME";
    public static final String TAG_STEPACTIONS = "STEPACTIONS";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_FORMTAG = "FORMTAG";
    public static final String TAG_FIRSTFORM = "FIRSTFORM";
    public static final String TAG_STEPORDERVALUE = "STEPORDERVALUE";
    public static final String TAG_CONFIRMINFO = "CONFIRMINFO";
    public static final String TAG_CONFIRMINFO2 = "CONFIRMINFO2";
    public static final String TAG_CMPSLANRESID = "CMPSLANRESID";
    public static final String TAG_CMPSLANRESNAME = "CMPSLANRESNAME";
    public static final String TAG_CMPSLANRESID2 = "CMPSLANRESID2";
    public static final String TAG_CMPSLANRESNAME2 = "CMPSLANRESNAME2";
    public static final String TAG_PREVPSDEACTIONID = "PREVPSDEACTIONID";
    public static final String TAG_PREVPSDEACTIONNAME = "PREVPSDEACTIONNAME";
    public static final String TAG_PREVENABLELOGIC = "PREVENABLELOGIC";
    public static final String TAG_NEXTENABLELOGIC = "NEXTENABLELOGIC";
    public static final String TAG_FINISHENABLELOGIC = "FINISHENABLELOGIC";
    public static final String TAG_MOBPSDEFORMID = "MOBPSDEFORMID";
    public static final String TAG_MOBPSDEFORMNAME = "MOBPSDEFORMNAME";

    public final boolean isPSDEWIZARDFORMIDNull() {
        return this.IsParamNull(TAG_PSDEWIZARDFORMID);
    }

    public final String getPSDEWIZARDFORMID() {
        return this.GetParamStringValue(TAG_PSDEWIZARDFORMID, "");
    }

    public final void setPSDEWIZARDFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDFORMID, strValue);
    }

    public final boolean isPSDEWIZARDFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEWIZARDFORMNAME);
    }

    public final String getPSDEWIZARDFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEWIZARDFORMNAME, "");
    }

    public final void setPSDEWIZARDFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDFORMNAME, strValue);
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

    public final boolean isPSDEWIZARDSTEPIDNull() {
        return this.IsParamNull(TAG_PSDEWIZARDSTEPID);
    }

    public final String getPSDEWIZARDSTEPID() {
        return this.GetParamStringValue(TAG_PSDEWIZARDSTEPID, "");
    }

    public final void setPSDEWIZARDSTEPID(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDSTEPID, strValue);
    }

    public final boolean isPSDEWIZARDSTEPNAMENull() {
        return this.IsParamNull(TAG_PSDEWIZARDSTEPNAME);
    }

    public final String getPSDEWIZARDSTEPNAME() {
        return this.GetParamStringValue(TAG_PSDEWIZARDSTEPNAME, "");
    }

    public final void setPSDEWIZARDSTEPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEWIZARDSTEPNAME, strValue);
    }

    public final boolean isPSDEFORMIDNull() {
        return this.IsParamNull(TAG_PSDEFORMID);
    }

    public final String getPSDEFORMID() {
        return this.GetParamStringValue(TAG_PSDEFORMID, "");
    }

    public final void setPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_PSDEFORMID, strValue);
    }

    public final boolean isPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_PSDEFORMNAME);
    }

    public final String getPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_PSDEFORMNAME, "");
    }

    public final void setPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEFORMNAME, strValue);
    }

    public final boolean isLOADPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_LOADPSDEACTIONID);
    }

    public final String getLOADPSDEACTIONID() {
        return this.GetParamStringValue(TAG_LOADPSDEACTIONID, "");
    }

    public final void setLOADPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_LOADPSDEACTIONID, strValue);
    }

    public final boolean isLOADPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_LOADPSDEACTIONNAME);
    }

    public final String getLOADPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_LOADPSDEACTIONNAME, "");
    }

    public final void setLOADPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_LOADPSDEACTIONNAME, strValue);
    }

    public final boolean isSAVEPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_SAVEPSDEACTIONID);
    }

    public final String getSAVEPSDEACTIONID() {
        return this.GetParamStringValue(TAG_SAVEPSDEACTIONID, "");
    }

    public final void setSAVEPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_SAVEPSDEACTIONID, strValue);
    }

    public final boolean isSAVEPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_SAVEPSDEACTIONNAME);
    }

    public final String getSAVEPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_SAVEPSDEACTIONNAME, "");
    }

    public final void setSAVEPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_SAVEPSDEACTIONNAME, strValue);
    }

    public final boolean isSTEPACTIONSNull() {
        return this.IsParamNull(TAG_STEPACTIONS);
    }

    public final String getSTEPACTIONS() {
        return this.GetParamStringValue(TAG_STEPACTIONS, "");
    }

    public final void setSTEPACTIONS(String strValue) {
        this.SetParamValue(TAG_STEPACTIONS, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isFORMTAGNull() {
        return this.IsParamNull(TAG_FORMTAG);
    }

    public final String getFORMTAG() {
        return this.GetParamStringValue(TAG_FORMTAG, "");
    }

    public final void setFORMTAG(String strValue) {
        this.SetParamValue(TAG_FORMTAG, strValue);
    }

    public final boolean isFIRSTFORMNull() {
        return this.IsParamNull(TAG_FIRSTFORM);
    }

    public final boolean getFIRSTFORM() {
        return this.GetParamIntValue(TAG_FIRSTFORM, 0) == 1;
    }

    public final void setFIRSTFORM(boolean bValue) {
        this.SetParamValue(TAG_FIRSTFORM, bValue ? 1 : 0);
    }

    public final boolean isSTEPORDERVALUENull() {
        return this.IsParamNull(TAG_STEPORDERVALUE);
    }

    public final int getSTEPORDERVALUE() {
        return this.GetParamIntValue(TAG_STEPORDERVALUE, 0);
    }

    public final void setSTEPORDERVALUE(int nValue) {
        this.SetParamValue(TAG_STEPORDERVALUE, nValue);
    }

    public final boolean isCONFIRMINFONull() {
        return this.IsParamNull(TAG_CONFIRMINFO);
    }

    public final String getCONFIRMINFO() {
        return this.GetParamStringValue(TAG_CONFIRMINFO, "");
    }

    public final void setCONFIRMINFO(String strValue) {
        this.SetParamValue(TAG_CONFIRMINFO, strValue);
    }

    public final boolean isCONFIRMINFO2Null() {
        return this.IsParamNull(TAG_CONFIRMINFO2);
    }

    public final String getCONFIRMINFO2() {
        return this.GetParamStringValue(TAG_CONFIRMINFO2, "");
    }

    public final void setCONFIRMINFO2(String strValue) {
        this.SetParamValue(TAG_CONFIRMINFO2, strValue);
    }

    public final boolean isCMPSLANRESIDNull() {
        return this.IsParamNull(TAG_CMPSLANRESID);
    }

    public final String getCMPSLANRESID() {
        return this.GetParamStringValue(TAG_CMPSLANRESID, "");
    }

    public final void setCMPSLANRESID(String strValue) {
        this.SetParamValue(TAG_CMPSLANRESID, strValue);
    }

    public final boolean isCMPSLANRESNAMENull() {
        return this.IsParamNull(TAG_CMPSLANRESNAME);
    }

    public final String getCMPSLANRESNAME() {
        return this.GetParamStringValue(TAG_CMPSLANRESNAME, "");
    }

    public final void setCMPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_CMPSLANRESNAME, strValue);
    }

    public final boolean isCMPSLANRESID2Null() {
        return this.IsParamNull(TAG_CMPSLANRESID2);
    }

    public final String getCMPSLANRESID2() {
        return this.GetParamStringValue(TAG_CMPSLANRESID2, "");
    }

    public final void setCMPSLANRESID2(String strValue) {
        this.SetParamValue(TAG_CMPSLANRESID2, strValue);
    }

    public final boolean isCMPSLANRESNAME2Null() {
        return this.IsParamNull(TAG_CMPSLANRESNAME2);
    }

    public final String getCMPSLANRESNAME2() {
        return this.GetParamStringValue(TAG_CMPSLANRESNAME2, "");
    }

    public final void setCMPSLANRESNAME2(String strValue) {
        this.SetParamValue(TAG_CMPSLANRESNAME2, strValue);
    }

    public final boolean isPREVPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_PREVPSDEACTIONID);
    }

    public final String getPREVPSDEACTIONID() {
        return this.GetParamStringValue(TAG_PREVPSDEACTIONID, "");
    }

    public final void setPREVPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_PREVPSDEACTIONID, strValue);
    }

    public final boolean isPREVPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_PREVPSDEACTIONNAME);
    }

    public final String getPREVPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_PREVPSDEACTIONNAME, "");
    }

    public final void setPREVPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PREVPSDEACTIONNAME, strValue);
    }

    public final boolean isPREVENABLELOGICNull() {
        return this.IsParamNull(TAG_PREVENABLELOGIC);
    }

    public final String getPREVENABLELOGIC() {
        return this.GetParamStringValue(TAG_PREVENABLELOGIC, "");
    }

    public final void setPREVENABLELOGIC(String strValue) {
        this.SetParamValue(TAG_PREVENABLELOGIC, strValue);
    }

    public final boolean isNEXTENABLELOGICNull() {
        return this.IsParamNull(TAG_NEXTENABLELOGIC);
    }

    public final String getNEXTENABLELOGIC() {
        return this.GetParamStringValue(TAG_NEXTENABLELOGIC, "");
    }

    public final void setNEXTENABLELOGIC(String strValue) {
        this.SetParamValue(TAG_NEXTENABLELOGIC, strValue);
    }

    public final boolean isFINISHENABLELOGICNull() {
        return this.IsParamNull(TAG_FINISHENABLELOGIC);
    }

    public final String getFINISHENABLELOGIC() {
        return this.GetParamStringValue(TAG_FINISHENABLELOGIC, "");
    }

    public final void setFINISHENABLELOGIC(String strValue) {
        this.SetParamValue(TAG_FINISHENABLELOGIC, strValue);
    }

    public final boolean isMOBPSDEFORMIDNull() {
        return this.IsParamNull(TAG_MOBPSDEFORMID);
    }

    public final String getMOBPSDEFORMID() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMID, "");
    }

    public final void setMOBPSDEFORMID(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMID, strValue);
    }

    public final boolean isMOBPSDEFORMNAMENull() {
        return this.IsParamNull(TAG_MOBPSDEFORMNAME);
    }

    public final String getMOBPSDEFORMNAME() {
        return this.GetParamStringValue(TAG_MOBPSDEFORMNAME, "");
    }

    public final void setMOBPSDEFORMNAME(String strValue) {
        this.SetParamValue(TAG_MOBPSDEFORMNAME, strValue);
    }
}

