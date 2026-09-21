/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDEWizardStep
extends BaseDataEntity {
    public static final String STEPACTION_PREV = "PREV";
    public static final String STEPACTION_NEXT = "NEXT";
    public static final String STEPACTION_FINISH = "FINISH";
    public static final String TAG_PSDEWIZARDSTEPID = "PSDEWIZARDSTEPID";
    public static final String TAG_PSDEWIZARDSTEPNAME = "PSDEWIZARDSTEPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEWIZARDID = "PSDEWIZARDID";
    public static final String TAG_PSDEWIZARDNAME = "PSDEWIZARDNAME";
    public static final String TAG_PSDEFORMID = "PSDEFORMID";
    public static final String TAG_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String TAG_STEPACTION = "STEPACTION";
    public static final String TAG_INITPSDEACTIONID = "INITPSDEACTIONID";
    public static final String TAG_INITPSDEACTIONNAME = "INITPSDEACTIONNAME";
    public static final String TAG_NEXTPSDEACTIONID = "NEXTPSDEACTIONID";
    public static final String TAG_NEXTPSDEACTIONNAME = "NEXTPSDEACTIONNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_STEPTAG = "STEPTAG";
    public static final String TAG_PSSYSCSSID = "PSSYSCSSID";
    public static final String TAG_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String TAG_SUBTITLE = "SUBTITLE";
    public static final String TAG_ENABLELINK = "ENABLELINK";
    public static final String TAG_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String TAG_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String TAG_LNPSLANRESID = "LNPSLANRESID";
    public static final String TAG_LNPSLANRESNAME = "LNPSLANRESNAME";
    public static final String TAG_SUBTITLEPSLANRESID = "SUBTITLEPSLANRESID";
    public static final String TAG_SUBTITLEPSLANRESNAME = "SUBTITLEPSLANRESNAME";
    public static final String TAG_ENABLELOGIC = "ENABLELOGIC";
    public static final String TAG_VISIBLELOGIC = "VISIBLELOGIC";

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

    public final boolean isSTEPACTIONNull() {
        return this.IsParamNull(TAG_STEPACTION);
    }

    public final String getSTEPACTION() {
        return this.GetParamStringValue(TAG_STEPACTION, "");
    }

    public final void setSTEPACTION(String strValue) {
        this.SetParamValue(TAG_STEPACTION, strValue);
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

    public final boolean isNEXTPSDEACTIONIDNull() {
        return this.IsParamNull(TAG_NEXTPSDEACTIONID);
    }

    public final String getNEXTPSDEACTIONID() {
        return this.GetParamStringValue(TAG_NEXTPSDEACTIONID, "");
    }

    public final void setNEXTPSDEACTIONID(String strValue) {
        this.SetParamValue(TAG_NEXTPSDEACTIONID, strValue);
    }

    public final boolean isNEXTPSDEACTIONNAMENull() {
        return this.IsParamNull(TAG_NEXTPSDEACTIONNAME);
    }

    public final String getNEXTPSDEACTIONNAME() {
        return this.GetParamStringValue(TAG_NEXTPSDEACTIONNAME, "");
    }

    public final void setNEXTPSDEACTIONNAME(String strValue) {
        this.SetParamValue(TAG_NEXTPSDEACTIONNAME, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isSTEPTAGNull() {
        return this.IsParamNull(TAG_STEPTAG);
    }

    public final String getSTEPTAG() {
        return this.GetParamStringValue(TAG_STEPTAG, "");
    }

    public final void setSTEPTAG(String strValue) {
        this.SetParamValue(TAG_STEPTAG, strValue);
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

    public final boolean isSUBTITLENull() {
        return this.IsParamNull(TAG_SUBTITLE);
    }

    public final String getSUBTITLE() {
        return this.GetParamStringValue(TAG_SUBTITLE, "");
    }

    public final void setSUBTITLE(String strValue) {
        this.SetParamValue(TAG_SUBTITLE, strValue);
    }

    public final boolean isENABLELINKNull() {
        return this.IsParamNull(TAG_ENABLELINK);
    }

    public final boolean getENABLELINK() {
        return this.GetParamIntValue(TAG_ENABLELINK, 0) == 1;
    }

    public final void setENABLELINK(boolean bValue) {
        this.SetParamValue(TAG_ENABLELINK, bValue ? 1 : 0);
    }

    public final boolean isPSSYSIMAGEIDNull() {
        return this.IsParamNull(TAG_PSSYSIMAGEID);
    }

    public final String getPSSYSIMAGEID() {
        return this.GetParamStringValue(TAG_PSSYSIMAGEID, "");
    }

    public final void setPSSYSIMAGEID(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGEID, strValue);
    }

    public final boolean isPSSYSIMAGENAMENull() {
        return this.IsParamNull(TAG_PSSYSIMAGENAME);
    }

    public final String getPSSYSIMAGENAME() {
        return this.GetParamStringValue(TAG_PSSYSIMAGENAME, "");
    }

    public final void setPSSYSIMAGENAME(String strValue) {
        this.SetParamValue(TAG_PSSYSIMAGENAME, strValue);
    }

    public final boolean isLNPSLANRESIDNull() {
        return this.IsParamNull(TAG_LNPSLANRESID);
    }

    public final String getLNPSLANRESID() {
        return this.GetParamStringValue(TAG_LNPSLANRESID, "");
    }

    public final void setLNPSLANRESID(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESID, strValue);
    }

    public final boolean isLNPSLANRESNAMENull() {
        return this.IsParamNull(TAG_LNPSLANRESNAME);
    }

    public final String getLNPSLANRESNAME() {
        return this.GetParamStringValue(TAG_LNPSLANRESNAME, "");
    }

    public final void setLNPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_LNPSLANRESNAME, strValue);
    }

    public final boolean isSUBTITLEPSLANRESIDNull() {
        return this.IsParamNull(TAG_SUBTITLEPSLANRESID);
    }

    public final String getSUBTITLEPSLANRESID() {
        return this.GetParamStringValue(TAG_SUBTITLEPSLANRESID, "");
    }

    public final void setSUBTITLEPSLANRESID(String strValue) {
        this.SetParamValue(TAG_SUBTITLEPSLANRESID, strValue);
    }

    public final boolean isSUBTITLEPSLANRESNAMENull() {
        return this.IsParamNull(TAG_SUBTITLEPSLANRESNAME);
    }

    public final String getSUBTITLEPSLANRESNAME() {
        return this.GetParamStringValue(TAG_SUBTITLEPSLANRESNAME, "");
    }

    public final void setSUBTITLEPSLANRESNAME(String strValue) {
        this.SetParamValue(TAG_SUBTITLEPSLANRESNAME, strValue);
    }

    public final boolean isENABLELOGICNull() {
        return this.IsParamNull(TAG_ENABLELOGIC);
    }

    public final String getENABLELOGIC() {
        return this.GetParamStringValue(TAG_ENABLELOGIC, "");
    }

    public final void setENABLELOGIC(String strValue) {
        this.SetParamValue(TAG_ENABLELOGIC, strValue);
    }

    public final boolean isVISIBLELOGICNull() {
        return this.IsParamNull(TAG_VISIBLELOGIC);
    }

    public final String getVISIBLELOGIC() {
        return this.GetParamStringValue(TAG_VISIBLELOGIC, "");
    }

    public final void setVISIBLELOGIC(String strValue) {
        this.SetParamValue(TAG_VISIBLELOGIC, strValue);
    }
}

