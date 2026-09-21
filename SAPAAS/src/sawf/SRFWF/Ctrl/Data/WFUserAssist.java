/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFUserAssist
extends BaseDataEntity {
    public static final String TAG_WFUSERASSISTID = "WFUSERASSISTID";
    public static final String TAG_WFUSERASSISTNAME = "WFUSERASSISTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WFSTEP = "WFSTEP";
    public static final String TAG_WFMAJORUSERNAME = "WFMAJORUSERNAME";
    public static final String TAG_WFMINORUSERNAME = "WFMINORUSERNAME";
    public static final String TAG_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    public static final String TAG_WFMAJORUSERID = "WFMAJORUSERID";
    public static final String TAG_WFMINORUSERID = "WFMINORUSERID";
    public static final String TAG_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";

    public String getWFUSERASSISTID() {
        return this.GetParamStringValue(TAG_WFUSERASSISTID, "");
    }

    public void setWFUSERASSISTID(String strValue) {
        this.SetParamValue(TAG_WFUSERASSISTID, strValue);
    }

    public String getWFUSERASSISTNAME() {
        return this.GetParamStringValue(TAG_WFUSERASSISTNAME, "");
    }

    public void setWFUSERASSISTNAME(String strValue) {
        this.SetParamValue(TAG_WFUSERASSISTNAME, strValue);
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

    public String getWFSTEP() {
        return this.GetParamStringValue(TAG_WFSTEP, "");
    }

    public void setWFSTEP(String strValue) {
        this.SetParamValue(TAG_WFSTEP, strValue);
    }

    public String getWFMAJORUSERNAME() {
        return this.GetParamStringValue(TAG_WFMAJORUSERNAME, "");
    }

    public void setWFMAJORUSERNAME(String strValue) {
        this.SetParamValue(TAG_WFMAJORUSERNAME, strValue);
    }

    public String getWFMINORUSERNAME() {
        return this.GetParamStringValue(TAG_WFMINORUSERNAME, "");
    }

    public void setWFMINORUSERNAME(String strValue) {
        this.SetParamValue(TAG_WFMINORUSERNAME, strValue);
    }

    public String getWFWORKFLOWNAME() {
        return this.GetParamStringValue(TAG_WFWORKFLOWNAME, "");
    }

    public void setWFWORKFLOWNAME(String strValue) {
        this.SetParamValue(TAG_WFWORKFLOWNAME, strValue);
    }

    public String getWFMAJORUSERID() {
        return this.GetParamStringValue(TAG_WFMAJORUSERID, "");
    }

    public void setWFMAJORUSERID(String strValue) {
        this.SetParamValue(TAG_WFMAJORUSERID, strValue);
    }

    public String getWFMINORUSERID() {
        return this.GetParamStringValue(TAG_WFMINORUSERID, "");
    }

    public void setWFMINORUSERID(String strValue) {
        this.SetParamValue(TAG_WFMINORUSERID, strValue);
    }

    public String getWFWORKFLOWID() {
        return this.GetParamStringValue(TAG_WFWORKFLOWID, "");
    }

    public void setWFWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_WFWORKFLOWID, strValue);
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }
}

