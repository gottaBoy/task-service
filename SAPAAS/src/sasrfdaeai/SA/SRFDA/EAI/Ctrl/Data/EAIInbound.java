/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.util.Date;

public class EAIInbound
extends BaseEAIObject {
    public static final String TAG_EAIINBOUNDID = "EAIINBOUNDID";
    public static final String TAG_EAIINBOUNDNAME = "EAIINBOUNDNAME";
    public static final String TAG_EAIINBOUNDTYPE = "EAIINBOUNDTYPE";
    public static final String TAG_EAIINBOUNDTYPE_VM = "VM";
    public static final String TAG_EAIINBOUNDTYPE_JDBC = "JDBC";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIPROCESSNAME = "EAIPROCESSNAME";
    public static final String TAG_EAIPROCESSID = "EAIPROCESSID";

    public String getEAIINBOUNDID() {
        return this.GetParamStringValue(TAG_EAIINBOUNDID, "");
    }

    public void setEAIINBOUNDID(String strValue) {
        this.SetParamValue(TAG_EAIINBOUNDID, strValue);
    }

    public String getEAIINBOUNDNAME() {
        return this.GetParamStringValue(TAG_EAIINBOUNDNAME, "");
    }

    public void setEAIINBOUNDNAME(String strValue) {
        this.SetParamValue(TAG_EAIINBOUNDNAME, strValue);
    }

    public String getEAIINBOUNDTYPE() {
        return this.GetParamStringValue(TAG_EAIINBOUNDTYPE, "");
    }

    public void setEAIINBOUNDTYPE(String strValue) {
        this.SetParamValue(TAG_EAIINBOUNDTYPE, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getEAIPROCESSNAME() {
        return this.GetParamStringValue(TAG_EAIPROCESSNAME, "");
    }

    public void setEAIPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSNAME, strValue);
    }

    public String getEAIPROCESSID() {
        return this.GetParamStringValue(TAG_EAIPROCESSID, "");
    }

    public void setEAIPROCESSID(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSID, strValue);
    }
}

