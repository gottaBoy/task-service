/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBActionStep
extends BaseDataEntity {
    public static final String TAG_ACTIONSTEP_CALLPARAM = "CALLPARAM";
    public static final String TAG_ACTIONSTEP_USERDECLARE = "USERDECLARE";
    public static final String TAG_ACTIONSTEP_USERINIT = "USERINIT";
    public static final String TAG_ACTIONSTEP_INPUTCHECK = "INPUTCHECK";
    public static final String TAG_ACTIONSTEP_BEFOREACTION = "BEFOREACTION";
    public static final String TAG_ACTIONSTEP_EXECUTEACTION = "EXECUTEACTION";
    public static final String TAG_ACTIONSTEP_AFTERACTION = "AFTERACTION";
    public static final String TAG_DBACTIONSTEPID = "DBACTIONSTEPID";
    public static final String TAG_DBACTIONSTEPNAME = "DBACTIONSTEPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ACTION = "ACTION";
    public static final String TAG_ACTIONSTEP = "ACTIONSTEP";
    public static final String TAG_ACTIONCODE = "ACTIONCODE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_STEPVERSION = "STEPVERSION";
    public static final String TAG_ACTIONMODE = "ACTIONMODE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";

    public String getDBACTIONSTEPID() {
        return this.GetParamStringValue(TAG_DBACTIONSTEPID, "");
    }

    public void setDBACTIONSTEPID(String strValue) {
        this.SetParamValue(TAG_DBACTIONSTEPID, strValue);
    }

    public String getDBACTIONSTEPNAME() {
        return this.GetParamStringValue(TAG_DBACTIONSTEPNAME, "");
    }

    public void setDBACTIONSTEPNAME(String strValue) {
        this.SetParamValue(TAG_DBACTIONSTEPNAME, strValue);
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

    public String getACTION() {
        return this.GetParamStringValue(TAG_ACTION, "");
    }

    public void setACTION(String strValue) {
        this.SetParamValue(TAG_ACTION, strValue);
    }

    public String getACTIONSTEP() {
        return this.GetParamStringValue(TAG_ACTIONSTEP, "");
    }

    public void setACTIONSTEP(String strValue) {
        this.SetParamValue(TAG_ACTIONSTEP, strValue);
    }

    public String getACTIONCODE() {
        return this.GetParamStringValue(TAG_ACTIONCODE, "");
    }

    public void setACTIONCODE(String strValue) {
        this.SetParamValue(TAG_ACTIONCODE, strValue);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public int getSTEPVERSION() {
        return this.GetParamIntValue(TAG_STEPVERSION, 0);
    }

    public void setSTEPVERSION(int strValue) {
        this.SetParamValue(TAG_STEPVERSION, strValue);
    }

    public String getACTIONMODE() {
        return this.GetParamStringValue(TAG_ACTIONMODE, "");
    }

    public void setACTIONMODE(String strValue) {
        this.SetParamValue(TAG_ACTIONMODE, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }
}

