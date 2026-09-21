/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WFStepInst
extends BaseDataEntity {
    public static final int CLOSEFLAG_NORMAL = 0;
    public static final int CLOSEFLAG_USERCLOSE = 1;
    public static final String TAG_WFSTEPINSTID = "WFSTEPINSTID";
    public static final String TAG_WFSTEPINSTNAME = "WFSTEPINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WFSTEPID = "WFSTEPID";
    public static final String TAG_WFSTEPNAME = "WFSTEPNAME";
    public static final String TAG_WFINSTANCEID = "WFINSTANCEID";
    public static final String TAG_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String TAG_RETURNDATA = "RETURNDATA";
    public static final String TAG_CLOSEFLAG = "CLOSEFLAG";

    public String getWFSTEPINSTID() {
        return this.GetParamStringValue(TAG_WFSTEPINSTID, "");
    }

    public void setWFSTEPINSTID(String strValue) {
        this.SetParamValue(TAG_WFSTEPINSTID, strValue);
    }

    public String getWFSTEPINSTNAME() {
        return this.GetParamStringValue(TAG_WFSTEPINSTNAME, "");
    }

    public void setWFSTEPINSTNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPINSTNAME, strValue);
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

    public String getWFSTEPID() {
        return this.GetParamStringValue(TAG_WFSTEPID, "");
    }

    public void setWFSTEPID(String strValue) {
        this.SetParamValue(TAG_WFSTEPID, strValue);
    }

    public String getWFSTEPNAME() {
        return this.GetParamStringValue(TAG_WFSTEPNAME, "");
    }

    public void setWFSTEPNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPNAME, strValue);
    }

    public String getWFINSTANCEID() {
        return this.GetParamStringValue(TAG_WFINSTANCEID, "");
    }

    public void setWFINSTANCEID(String strValue) {
        this.SetParamValue(TAG_WFINSTANCEID, strValue);
    }

    public String getWFINSTANCENAME() {
        return this.GetParamStringValue(TAG_WFINSTANCENAME, "");
    }

    public void setWFINSTANCENAME(String strValue) {
        this.SetParamValue(TAG_WFINSTANCENAME, strValue);
    }

    public String getRETURNDATA() {
        return this.GetParamStringValue(TAG_RETURNDATA, "");
    }

    public void setRETURNDATA(String strValue) {
        this.SetParamValue(TAG_RETURNDATA, strValue);
    }

    public int getCLOSEFLAG() {
        return this.GetParamIntValue(TAG_CLOSEFLAG, 0);
    }

    public void setCLOSEFLAG(int strValue) {
        this.SetParamValue(TAG_CLOSEFLAG, strValue);
    }
}

