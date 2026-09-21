/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.sql.Timestamp;
import java.util.Date;

public class EAIService
extends BaseEAIObject {
    public static final String TAG_STARTMODE_AUTO = "AUTO";
    public static final String TAG_STARTMODE_MANUAL = "MANUAL";
    public static final String TAG_EAISERVICEID = "EAISERVICEID";
    public static final String TAG_EAISERVICENAME = "EAISERVICENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SERVICESTATUS = "SERVICESTATUS";
    public static final String TAG_SERVICESTATUS_START = "START";
    public static final String TAG_SERVICESTATUS_STARTING = "STARTING";
    public static final String TAG_SERVICESTATUS_STOP = "STOP";
    public static final String TAG_STARTMODE = "STARTMODE";
    public static final String TAG_SVRMODEL = "SVRMODEL";
    public static final String TAG_PID = "PID";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";

    public String getEAISERVICEID() {
        return this.GetParamStringValue(TAG_EAISERVICEID, "");
    }

    public void setEAISERVICEID(String strValue) {
        this.SetParamValue(TAG_EAISERVICEID, strValue);
    }

    public String getEAISERVICENAME() {
        return this.GetParamStringValue(TAG_EAISERVICENAME, "");
    }

    public void setEAISERVICENAME(String strValue) {
        this.SetParamValue(TAG_EAISERVICENAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getSERVICESTATUS() {
        return this.GetParamStringValue(TAG_SERVICESTATUS, "");
    }

    public void setSERVICESTATUS(String strValue) {
        this.SetParamValue(TAG_SERVICESTATUS, strValue);
    }

    public String getSTARTMODE() {
        return this.GetParamStringValue(TAG_STARTMODE, "");
    }

    public void setSTARTMODE(String strValue) {
        this.SetParamValue(TAG_STARTMODE, strValue);
    }

    public String getSVRMODEL() {
        return this.GetParamStringValue(TAG_SVRMODEL, "");
    }

    public void setSVRMODEL(String strValue) {
        this.SetParamValue(TAG_SVRMODEL, strValue);
    }

    public int getPID() {
        return this.GetParamIntValue(TAG_PID, -1);
    }

    public void setPID(int nValue) {
        this.SetParamValue(TAG_PID, nValue);
    }

    public Date getSTARTTIME() {
        return this.GetParamDateValue(TAG_STARTTIME, null);
    }

    public void setSTARTTIME(Timestamp strValue) {
        this.SetParamValue(TAG_STARTTIME, strValue);
    }

    public Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public void setENDTIME(Timestamp strValue) {
        this.SetParamValue(TAG_ENDTIME, strValue);
    }
}

