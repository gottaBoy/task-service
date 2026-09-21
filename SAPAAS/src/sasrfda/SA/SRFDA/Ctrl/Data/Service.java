/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Service
extends BaseDataEntity {
    public static final String SERVICESTATE_START = "START";
    public static final String SERVICESTATE_STOP = "STOP";
    public static final String TAG_SERVICEID = "SERVICEID";
    public static final String TAG_SERVICENAME = "SERVICENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_STARTMODE = "STARTMODE";
    public static final String TAG_SERVICEOBJECT = "SERVICEOBJECT";
    public static final String TAG_SERVICEPARAM = "SERVICEPARAM";
    public static final String TAG_CONTAINER = "CONTAINER";
    public static final String TAG_SERVICESTATE = "SERVICESTATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getSERVICEID() {
        return this.GetParamStringValue(TAG_SERVICEID, "");
    }

    public void setSERVICEID(String strValue) {
        this.SetParamValue(TAG_SERVICEID, strValue);
    }

    public String getSERVICENAME() {
        return this.GetParamStringValue(TAG_SERVICENAME, "");
    }

    public void setSERVICENAME(String strValue) {
        this.SetParamValue(TAG_SERVICENAME, strValue);
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

    public String getSTARTMODE() {
        return this.GetParamStringValue(TAG_STARTMODE, "");
    }

    public void setSTARTMODE(String strValue) {
        this.SetParamValue(TAG_STARTMODE, strValue);
    }

    public String getSERVICEOBJECT() {
        return this.GetParamStringValue(TAG_SERVICEOBJECT, "");
    }

    public void setSERVICEOBJECT(String strValue) {
        this.SetParamValue(TAG_SERVICEOBJECT, strValue);
    }

    public String getSERVICEPARAM() {
        return this.GetParamStringValue(TAG_SERVICEPARAM, "");
    }

    public void setSERVICEPARAM(String strValue) {
        this.SetParamValue(TAG_SERVICEPARAM, strValue);
    }

    public String getCONTAINER() {
        return this.GetParamStringValue(TAG_CONTAINER, "");
    }

    public void setCONTAINER(String strValue) {
        this.SetParamValue(TAG_CONTAINER, strValue);
    }

    public String getSERVICESTATE() {
        return this.GetParamStringValue(TAG_SERVICESTATE, "");
    }

    public void setSERVICESTATE(String strValue) {
        this.SetParamValue(TAG_SERVICESTATE, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

