/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.util.Date;

public class EAIEndPoint
extends BaseEAIObject {
    public static final String TAG_EAIENDPOINTID = "EAIENDPOINTID";
    public static final String TAG_EAIENDPOINTNAME = "EAIENDPOINTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DIRECTION = "DIRECTION";
    public static final String TAG_DIRECTION_INBOUND = "INBOUND";
    public static final String TAG_DIRECTION_OUTBOUND = "OUTBOUND";
    public static final String TAG_EPTYPE = "EPTYPE";
    public static final String TAG_EPICON = "EPICON";
    public static final String TAG_EDITPATH = "EDITPATH";
    public static final String TAG_SHOWORDER = "SHOWORDER";

    public String getEAIENDPOINTID() {
        return this.GetParamStringValue(TAG_EAIENDPOINTID, "");
    }

    public void setEAIENDPOINTID(String strValue) {
        this.SetParamValue(TAG_EAIENDPOINTID, strValue);
    }

    public String getEAIENDPOINTNAME() {
        return this.GetParamStringValue(TAG_EAIENDPOINTNAME, "");
    }

    public void setEAIENDPOINTNAME(String strValue) {
        this.SetParamValue(TAG_EAIENDPOINTNAME, strValue);
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

    public String getDIRECTION() {
        return this.GetParamStringValue(TAG_DIRECTION, "");
    }

    public void setDIRECTION(String strValue) {
        this.SetParamValue(TAG_DIRECTION, strValue);
    }

    public String getEPTYPE() {
        return this.GetParamStringValue(TAG_EPTYPE, "");
    }

    public void setEPTYPE(String strValue) {
        this.SetParamValue(TAG_EPTYPE, strValue);
    }

    public String getEPICON() {
        return this.GetParamStringValue(TAG_EPICON, "");
    }

    public void setEPICON(String strValue) {
        this.SetParamValue(TAG_EPICON, strValue);
    }

    public String getEDITPATH() {
        return this.GetParamStringValue(TAG_EDITPATH, "");
    }

    public void setEDITPATH(String strValue) {
        this.SetParamValue(TAG_EDITPATH, strValue);
    }

    public String getSHOWORDER() {
        return this.GetParamStringValue(TAG_SHOWORDER, "");
    }

    public void setSHOWORDER(String strValue) {
        this.SetParamValue(TAG_SHOWORDER, strValue);
    }
}

