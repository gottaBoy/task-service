/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WizardStepData
extends BaseDataEntity {
    public static final String TAG_WIZARDSTEPDATAID = "WIZARDSTEPDATAID";
    public static final String TAG_WIZARDSTEPDATANAME = "WIZARDSTEPDATANAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WIZARDSESSIONID = "WIZARDSESSIONID";
    public static final String TAG_WIZARDSESSIONNAME = "WIZARDSESSIONNAME";
    public static final String TAG_PSTEPDATAID = "PSTEPDATAID";
    public static final String TAG_DEDATA = "DEDATA";
    public static final String TAG_FOREIGNKEY = "FOREIGNKEY";
    public static final String TAG_PKEYVALUE = "PKEYVALUE";
    public static final String TAG_SAVEDATAACTIONID = "SAVEDATAACTIONID";
    public static final String TAG_IGNORESAVE = "IGNORESAVE";

    public final boolean isWIZARDSTEPDATAIDNull() {
        return this.IsParamNull(TAG_WIZARDSTEPDATAID);
    }

    public final String getWIZARDSTEPDATAID() {
        return this.GetParamStringValue(TAG_WIZARDSTEPDATAID, "");
    }

    public final void setWIZARDSTEPDATAID(String strValue) {
        this.SetParamValue(TAG_WIZARDSTEPDATAID, strValue);
    }

    public final boolean isWIZARDSTEPDATANAMENull() {
        return this.IsParamNull(TAG_WIZARDSTEPDATANAME);
    }

    public final String getWIZARDSTEPDATANAME() {
        return this.GetParamStringValue(TAG_WIZARDSTEPDATANAME, "");
    }

    public final void setWIZARDSTEPDATANAME(String strValue) {
        this.SetParamValue(TAG_WIZARDSTEPDATANAME, strValue);
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

    public final boolean isPSTEPDATAIDNull() {
        return this.IsParamNull(TAG_PSTEPDATAID);
    }

    public final String getPSTEPDATAID() {
        return this.GetParamStringValue(TAG_PSTEPDATAID, "");
    }

    public final void setPSTEPDATAID(String strValue) {
        this.SetParamValue(TAG_PSTEPDATAID, strValue);
    }

    public final boolean isDEDATANull() {
        return this.IsParamNull(TAG_DEDATA);
    }

    public final String getDEDATA() {
        return this.GetParamStringValue(TAG_DEDATA, "");
    }

    public final void setDEDATA(String strValue) {
        this.SetParamValue(TAG_DEDATA, strValue);
    }

    public final boolean isFOREIGNKEYNull() {
        return this.IsParamNull(TAG_FOREIGNKEY);
    }

    public final String getFOREIGNKEY() {
        return this.GetParamStringValue(TAG_FOREIGNKEY, "");
    }

    public final void setFOREIGNKEY(String strValue) {
        this.SetParamValue(TAG_FOREIGNKEY, strValue);
    }

    public final boolean isPKEYVALUENull() {
        return this.IsParamNull(TAG_PKEYVALUE);
    }

    public final String getPKEYVALUE() {
        return this.GetParamStringValue(TAG_PKEYVALUE, "");
    }

    public final void setPKEYVALUE(String strValue) {
        this.SetParamValue(TAG_PKEYVALUE, strValue);
    }

    public final boolean isSAVEDATAACTIONIDNull() {
        return this.IsParamNull(TAG_SAVEDATAACTIONID);
    }

    public final String getSAVEDATAACTIONID() {
        return this.GetParamStringValue(TAG_SAVEDATAACTIONID, "");
    }

    public final void setSAVEDATAACTIONID(String strValue) {
        this.SetParamValue(TAG_SAVEDATAACTIONID, strValue);
    }

    public final boolean isIGNORESAVENull() {
        return this.IsParamNull(TAG_IGNORESAVE);
    }

    public final boolean getIGNORESAVE() {
        return this.GetParamIntValue(TAG_IGNORESAVE, 0) == 1;
    }

    public final void setIGNORESAVE(boolean bValue) {
        this.SetParamValue(TAG_IGNORESAVE, bValue ? 1 : 0);
    }
}

