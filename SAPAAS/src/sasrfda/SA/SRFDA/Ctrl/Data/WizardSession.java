/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WizardSession
extends BaseDataEntity {
    public static final String TAG_WIZARDSESSIONID = "WIZARDSESSIONID";
    public static final String TAG_WIZARDSESSIONNAME = "WIZARDSESSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEWIZARDID = "DEWIZARDID";
    public static final String TAG_DEWIZARDNAME = "DEWIZARDNAME";
    public static final String TAG_TEMPDATAID = "TEMPDATAID";
    public static final String TAG_L1STEPDATAID = "L1STEPDATAID";
    public static final String TAG_L2STEPDATAID = "L2STEPDATAID";
    public static final String TAG_L3STEPDATAID = "L3STEPDATAID";
    public static final String TAG_LASTSTEPDATAID = "LASTSTEPDATAID";

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

    public final boolean isDEWIZARDIDNull() {
        return this.IsParamNull(TAG_DEWIZARDID);
    }

    public final String getDEWIZARDID() {
        return this.GetParamStringValue(TAG_DEWIZARDID, "");
    }

    public final void setDEWIZARDID(String strValue) {
        this.SetParamValue(TAG_DEWIZARDID, strValue);
    }

    public final boolean isDEWIZARDNAMENull() {
        return this.IsParamNull(TAG_DEWIZARDNAME);
    }

    public final String getDEWIZARDNAME() {
        return this.GetParamStringValue(TAG_DEWIZARDNAME, "");
    }

    public final void setDEWIZARDNAME(String strValue) {
        this.SetParamValue(TAG_DEWIZARDNAME, strValue);
    }

    public final boolean isL1STEPDATAIDNull() {
        return this.IsParamNull(TAG_L1STEPDATAID);
    }

    public final String getL1STEPDATAID() {
        return this.GetParamStringValue(TAG_L1STEPDATAID, "");
    }

    public final void setL1STEPDATAID(String strValue) {
        this.SetParamValue(TAG_L1STEPDATAID, strValue);
    }

    public final boolean isL2STEPDATAIDNull() {
        return this.IsParamNull(TAG_L2STEPDATAID);
    }

    public final String getL2STEPDATAID() {
        return this.GetParamStringValue(TAG_L2STEPDATAID, "");
    }

    public final void setL2STEPDATAID(String strValue) {
        this.SetParamValue(TAG_L2STEPDATAID, strValue);
    }

    public final boolean isL3STEPDATAIDNull() {
        return this.IsParamNull(TAG_L3STEPDATAID);
    }

    public final String getL3STEPDATAID() {
        return this.GetParamStringValue(TAG_L3STEPDATAID, "");
    }

    public final void setL3STEPDATAID(String strValue) {
        this.SetParamValue(TAG_L3STEPDATAID, strValue);
    }

    public final boolean isLASTSTEPDATAIDNull() {
        return this.IsParamNull(TAG_LASTSTEPDATAID);
    }

    public final String getLASTSTEPDATAID() {
        return this.GetParamStringValue(TAG_LASTSTEPDATAID, "");
    }

    public final void setLASTSTEPDATAID(String strValue) {
        this.SetParamValue(TAG_LASTSTEPDATAID, strValue);
    }
}

