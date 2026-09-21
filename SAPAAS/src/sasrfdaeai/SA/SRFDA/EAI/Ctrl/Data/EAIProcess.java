/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Config.BaseProcessConfigWriter;
import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.util.Date;

public class EAIProcess
extends BaseEAIObject {
    public static final String TAG_EAIPROCESSID = "EAIPROCESSID";
    public static final String TAG_EAIPROCESSNAME = "EAIPROCESSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_IBROUTER = "IBROUTER";
    public static final String TAG_IBROUTER_NOROUTER = "NOROUTER";
    public static final String TAG_OBROUTER = "OBROUTER";
    public static final String TAG_OBROUTER_CHAINING = "CHAINING";
    public static final String TAG_OBROUTER_PASSTHROUGH = "PASSTHROUGH";
    public static final String TAG_OBROUTER_MULTICASTING = "MULTICASTING";
    public static final String TAG_IBPARAM = "IBPARAM";
    public static final String TAG_OBPARAM = "OBPARAM";
    public static final String TAG_EAISERVICENAME = "EAISERVICENAME";
    public static final String TAG_EAISERVICEID = "EAISERVICEID";
    public static final String TAG_CUSTOMOBJECT = "CUSTOMOBJECT";

    public String getEAIPROCESSID() {
        return this.GetParamStringValue(TAG_EAIPROCESSID, "");
    }

    public void setEAIPROCESSID(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSID, strValue);
    }

    public String getEAIPROCESSNAME() {
        return this.GetParamStringValue(TAG_EAIPROCESSNAME, "");
    }

    public void setEAIPROCESSNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROCESSNAME, strValue);
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

    public String getIBROUTER() {
        return this.GetParamStringValue(TAG_IBROUTER, "");
    }

    public void setIBROUTER(String strValue) {
        this.SetParamValue(TAG_IBROUTER, strValue);
    }

    public String getOBROUTER() {
        return this.GetParamStringValue(TAG_OBROUTER, "");
    }

    public void setOBROUTER(String strValue) {
        this.SetParamValue(TAG_OBROUTER, strValue);
    }

    public String getIBPARAM() {
        return this.GetParamStringValue(TAG_IBPARAM, "");
    }

    public void setIBPARAM(String strValue) {
        this.SetParamValue(TAG_IBPARAM, strValue);
    }

    public String getOBPARAM() {
        return this.GetParamStringValue(TAG_OBPARAM, "");
    }

    public void setOBPARAM(String strValue) {
        this.SetParamValue(TAG_OBPARAM, strValue);
    }

    public String getEAISERVICENAME() {
        return this.GetParamStringValue(TAG_EAISERVICENAME, "");
    }

    public void setEAISERVICENAME(String strValue) {
        this.SetParamValue(TAG_EAISERVICENAME, strValue);
    }

    public String getEAISERVICEID() {
        return this.GetParamStringValue(TAG_EAISERVICEID, "");
    }

    public void setEAISERVICEID(String strValue) {
        this.SetParamValue(TAG_EAISERVICEID, strValue);
    }

    public String getCUSTOMOBJECT() {
        return this.GetParamStringValue(TAG_CUSTOMOBJECT, "");
    }

    public void setCUSTOMOBJECT(String strValue) {
        this.SetParamValue(TAG_CUSTOMOBJECT, strValue);
    }

    @Override
    public String getCONFIGWRITER() {
        return BaseProcessConfigWriter.class.getName();
    }
}

