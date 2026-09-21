/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WizardStep
extends BaseDataEntity {
    public static final String TAG_WIZARDSTEPID = "WIZARDSTEPID";
    public static final String TAG_WIZARDSTEPNAME = "WIZARDSTEPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WIZARDSESSIONID = "WIZARDSESSIONID";
    public static final String TAG_WIZARDSESSIONNAME = "WIZARDSESSIONNAME";
    public static final String TAG_STEPSN = "STEPSN";
    public static final String TAG_WIZARDSTEPDATAID = "WIZARDSTEPDATAID";
    public static final String TAG_NEXTSTEPID = "NEXTSTEPID";

    public final boolean isWIZARDSTEPIDNull() {
        return this.IsParamNull(TAG_WIZARDSTEPID);
    }

    public final String getWIZARDSTEPID() {
        return this.GetParamStringValue(TAG_WIZARDSTEPID, "");
    }

    public final void setWIZARDSTEPID(String strValue) {
        this.SetParamValue(TAG_WIZARDSTEPID, strValue);
    }

    public final boolean isWIZARDSTEPNAMENull() {
        return this.IsParamNull(TAG_WIZARDSTEPNAME);
    }

    public final String getWIZARDSTEPNAME() {
        return this.GetParamStringValue(TAG_WIZARDSTEPNAME, "");
    }

    public final void setWIZARDSTEPNAME(String strValue) {
        this.SetParamValue(TAG_WIZARDSTEPNAME, strValue);
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

    public final boolean isWIZARDSESSIONIDNull() {
        return this.IsParamNull(TAG_WIZARDSESSIONID);
    }

    public final String getWIZARDSESSIONID() {
        return this.GetParamStringValue(TAG_WIZARDSESSIONID, "");
    }

    public final void setWIZARDSESSIONID(String strValue) {
        this.SetParamValue(TAG_WIZARDSESSIONID, strValue);
    }

    public final boolean isWIZARDSESSIONNAMENull() {
        return this.IsParamNull(TAG_WIZARDSESSIONNAME);
    }

    public final String getWIZARDSESSIONNAME() {
        return this.GetParamStringValue(TAG_WIZARDSESSIONNAME, "");
    }

    public final void setWIZARDSESSIONNAME(String strValue) {
        this.SetParamValue(TAG_WIZARDSESSIONNAME, strValue);
    }

    public final boolean isSTEPSNNull() {
        return this.IsParamNull(TAG_STEPSN);
    }

    public final int getSTEPSN() {
        return this.GetParamIntValue(TAG_STEPSN, 0);
    }

    public final void setSTEPSN(int nValue) {
        this.SetParamValue(TAG_STEPSN, nValue);
    }

    public final boolean isWIZARDSTEPDATAIDNull() {
        return this.IsParamNull(TAG_WIZARDSTEPDATAID);
    }

    public final String getWIZARDSTEPDATAID() {
        return this.GetParamStringValue(TAG_WIZARDSTEPDATAID, "");
    }

    public final void setWIZARDSTEPDATAID(String strValue) {
        this.SetParamValue(TAG_WIZARDSTEPDATAID, strValue);
    }

    public final boolean isNEXTSTEPIDNull() {
        return this.IsParamNull(TAG_NEXTSTEPID);
    }

    public final String getNEXTSTEPID() {
        return this.GetParamStringValue(TAG_NEXTSTEPID, "");
    }

    public final void setNEXTSTEPID(String strValue) {
        this.SetParamValue(TAG_NEXTSTEPID, strValue);
    }
}

