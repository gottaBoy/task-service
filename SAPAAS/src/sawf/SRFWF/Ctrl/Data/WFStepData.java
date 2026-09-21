/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class WFStepData
extends BaseDataEntity {
    public static final String TAG_WFSTEPDATAID = "WFSTEPDATAID";
    public static final String TAG_WFSTEPDATANAME = "WFSTEPDATANAME";
    public static final String TAG_WFSTEPID = "WFSTEPID";
    public static final String TAG_ACTORID = "ACTORID";
    public static final String TAG_CONNECTIONNAME = "CONNECTIONNAME";
    public static final String TAG_NEXTTO = "NEXTTO";
    public static final String TAG_SDPARAM = "SDPARAM";
    public static final String TAG_SDPARAM2 = "SDPARAM2";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_WFINSTANCEID = "WFINSTANCEID";

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public String getSDPARAM2() {
        return this.GetParamStringValue(TAG_SDPARAM2, "");
    }

    public String getSDPARAM() {
        return this.GetParamStringValue(TAG_SDPARAM, "");
    }

    public String getNEXTTO() {
        return this.GetParamStringValue(TAG_NEXTTO, "");
    }

    public String getCONNECTIONNAME() {
        return this.GetParamStringValue(TAG_CONNECTIONNAME, "");
    }

    public String getACTORID() {
        return this.GetParamStringValue(TAG_ACTORID, "");
    }

    public String getWFSTEPID() {
        return this.GetParamStringValue(TAG_WFSTEPID, "");
    }

    public String getWFSTEPDATAID() {
        return this.GetParamStringValue(TAG_WFSTEPDATAID, "");
    }

    public String getWFINSTANCEID() {
        return this.GetParamStringValue(TAG_WFINSTANCEID, "");
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public void setSDPARAM2(String strValue) {
        this.SetParamValue(TAG_SDPARAM2, strValue);
    }

    public void setSDPARAM(String strValue) {
        this.SetParamValue(TAG_SDPARAM, strValue);
    }

    public void setNEXTTO(String strValue) {
        this.SetParamValue(TAG_NEXTTO, strValue);
    }

    public void setCONNECTIONNAME(String strValue) {
        this.SetParamValue(TAG_CONNECTIONNAME, strValue);
    }

    public void setACTORID(String strValue) {
        this.SetParamValue(TAG_ACTORID, strValue);
    }

    public void setWFSTEPID(String strValue) {
        this.SetParamValue(TAG_WFSTEPID, strValue);
    }

    public void setWFSTEPDATAID(String strValue) {
        this.SetParamValue(TAG_WFSTEPDATAID, strValue);
    }

    public void setWFINSTANCEID(String strValue) {
        this.SetParamValue(TAG_WFINSTANCEID, strValue);
    }

    public void setWFSTEPDATANAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPDATANAME, strValue);
    }
}

