/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.util.Date;

public class EAIOutbound
extends BaseEAIObject {
    public static final String TAG_EAIOUTBOUNDID = "EAIOUTBOUNDID";
    public static final String TAG_EAIOUTBOUNDNAME = "EAIOUTBOUNDNAME";
    public static final String TAG_EAIOUTBOUNDTYPE = "EAIOUTBOUNDTYPE";
    public static final String TAG_EAIOUTBOUNDTYPE_JDBC = "JDBC";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIPROCESSNAME = "EAIPROCESSNAME";
    public static final String TAG_EAIPROCESSID = "EAIPROCESSID";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";

    public String getEAIOUTBOUNDID() {
        return this.GetParamStringValue(TAG_EAIOUTBOUNDID, "");
    }

    public void setEAIOUTBOUNDID(String strValue) {
        this.SetParamValue(TAG_EAIOUTBOUNDID, strValue);
    }

    public String getEAIOUTBOUNDNAME() {
        return this.GetParamStringValue(TAG_EAIOUTBOUNDNAME, "");
    }

    public void setEAIOUTBOUNDNAME(String strValue) {
        this.SetParamValue(TAG_EAIOUTBOUNDNAME, strValue);
    }

    public String getEAIOUTBOUNDTYPE() {
        return this.GetParamStringValue(TAG_EAIOUTBOUNDTYPE, "");
    }

    public void setEAIOUTBOUNDTYPE(String strValue) {
        this.SetParamValue(TAG_EAIOUTBOUNDTYPE, strValue);
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

    public String getORDERFLAG() {
        return this.GetParamStringValue(TAG_ORDERFLAG, "");
    }

    public void setORDERFLAG(String strValue) {
        this.SetParamValue(TAG_ORDERFLAG, strValue);
    }
}

