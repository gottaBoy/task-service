/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.sql.Timestamp;

public class WFStep
extends BaseDataEntity {
    public static final String TAG_WFSTEPID = "WFSTEPID";
    public static final String TAG_WFSTEPNAME = "WFSTEPNAME";
    public static final String TAG_WFINSTANCEID = "WFINSTANCEID";
    public static final String TAG_FROMWFSTEPID = "FROMWFSTEPID";
    public static final String TAG_WFPNAME = "WFPNAME";
    public static final String TAG_WFPLOGICNAME = "WFPLOGICNAME";
    public static final String TAG_WFPMODEL = "WFPMODEL";
    public static final String TAG_TRACESTEP = "TRACESTEP";
    public static final String TAG_ISFINISH = "ISFINISH";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_DEADLINE = "DEADLINE";
    public static final String TAG_ISINTERACTIVE = "ISINTERACTIVE";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";

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

    public String getWFPMODEL() {
        return this.GetParamStringValue(TAG_WFPMODEL, "");
    }

    public String getWFPLOGICNAME() {
        return this.GetParamStringValue(TAG_WFPLOGICNAME, "");
    }

    public String getWFPNAME() {
        return this.GetParamStringValue(TAG_WFPNAME, "");
    }

    public String getFROMWFSTEPID() {
        return this.GetParamStringValue(TAG_FROMWFSTEPID, "");
    }

    public String getWFINSTANCEID() {
        return this.GetParamStringValue(TAG_WFINSTANCEID, "");
    }

    public String getWFSTEPID() {
        return this.GetParamStringValue(TAG_WFSTEPID, "");
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

    public void setWFPMODEL(String strValue) {
        this.SetParamValue(TAG_WFPMODEL, strValue);
    }

    public void setWFPLOGICNAME(String strValue) {
        this.SetParamValue(TAG_WFPLOGICNAME, strValue);
    }

    public void setWFPNAME(String strValue) {
        this.SetParamValue(TAG_WFPNAME, strValue);
    }

    public void setFROMWFSTEPID(String strValue) {
        this.SetParamValue(TAG_FROMWFSTEPID, strValue);
    }

    public void setWFINSTANCEID(String strValue) {
        this.SetParamValue(TAG_WFINSTANCEID, strValue);
    }

    public void setWFSTEPID(String strValue) {
        this.SetParamValue(TAG_WFSTEPID, strValue);
    }

    public void setWFSTEPNAME(String strValue) {
        this.SetParamValue(TAG_WFSTEPNAME, strValue);
    }

    public void setSTARTTIME(Timestamp value) {
        this.SetParamValue(TAG_STARTTIME, value);
    }

    public void setDEADLINE(Timestamp value) {
        this.SetParamValue(TAG_DEADLINE, value);
    }

    public boolean isISFINISH() {
        return this.GetParamIntValue(TAG_ISFINISH, 0) == 1;
    }

    public boolean isISINTERACTIVE() {
        return this.GetParamIntValue(TAG_ISINTERACTIVE, 0) == 1;
    }

    public int getTRACESTEP() {
        return this.GetParamIntValue(TAG_TRACESTEP, 0);
    }

    public int getWFVERSION() {
        return this.GetParamIntValue(TAG_WFVERSION, 0);
    }

    public void setTRACESTEP(int nValue) {
        this.SetParamValue(TAG_TRACESTEP, nValue);
    }

    public void setWFVERSION(int nValue) {
        this.SetParamValue(TAG_WFVERSION, nValue);
    }

    public void setISFINISH(boolean bValue) {
        this.SetParamValue(TAG_ISFINISH, bValue ? 1 : 0);
    }

    public void setISINTERACTIVE(boolean bValue) {
        this.SetParamValue(TAG_ISINTERACTIVE, bValue ? 1 : 0);
    }
}

