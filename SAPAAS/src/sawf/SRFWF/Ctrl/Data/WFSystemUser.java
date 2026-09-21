/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFSystemUser
extends BaseDataEntity {
    public static final String WFUSER_LASTSTEPACTOR = "WFUSER_LASTSTEPACTOR";
    public static final String WFUSER_LASTTWOSTEPACTOR = "WFUSER_LASTTWOSTEPACTOR";
    public static final String WFUSER_LASTTHREESTEPACTOR = "WFUSER_LASTTHREESTEPACTOR";
    public static final String TAG_WFSYSTEMUSERID = "WFSYSTEMUSERID";
    public static final String TAG_WFSYSTEMUSERNAME = "WFSYSTEMUSERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";

    public String getWFSYSTEMUSERID() {
        return this.GetParamStringValue(TAG_WFSYSTEMUSERID, "");
    }

    public void setWFSYSTEMUSERID(String strValue) {
        this.SetParamValue(TAG_WFSYSTEMUSERID, strValue);
    }

    public String getWFSYSTEMUSERNAME() {
        return this.GetParamStringValue(TAG_WFSYSTEMUSERNAME, "");
    }

    public void setWFSYSTEMUSERNAME(String strValue) {
        this.SetParamValue(TAG_WFSYSTEMUSERNAME, strValue);
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
}

