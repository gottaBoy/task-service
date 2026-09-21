/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class WFInstance
extends BaseDataEntity {
    public static final String TAG_WFINSTANCEID = "WFINSTANCEID";
    public static final String TAG_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String TAG_PWFINSTANCEID = "PWFINSTANCEID";
    public static final String TAG_PWFTRACEID = "PWFTRACEID";
    public static final String TAG_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String TAG_WFVERSION = "WFVERSION";
    public static final String TAG_USERDATA = "USERDATA";
    public static final String TAG_USERDATA2 = "USERDATA2";
    public static final String TAG_USERDATA3 = "USERDATA3";
    public static final String TAG_USERDATA4 = "USERDATA4";
    public static final String TAG_USERDATAINFO = "USERDATAINFO";
    public static final String TAG_OWNER = "OWNER";
    public static final String TAG_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String TAG_ACTIVESTEPID = "ACTIVESTEPID";
    public static final String TAG_ACTIVESTEPNAME = "ACTIVESTEPNAME";
    public static final String TAG_ISERROR = "ISERROR";
    public static final String TAG_ERRORINFO = "ERRORINFO";
    public static final String TAG_ISCLOSE = "ISCLOSE";
    public static final String TAG_ISFINISH = "ISFINISH";
    public static final String TAG_ISCANCEL = "ISCANCEL";
    public static final String TAG_CANCELREASON = "CANCELREASON";
    public static final String TAG_STARTTIME = "STARTTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_WFMODEL = "WFMODEL";
    public static final String TAG_PSTEPID = "PSTEPID";
    public static final String TAG_PARALLELINST = "PARALLELINST";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";

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

    public String getCANCELREASON() {
        return this.GetParamStringValue(TAG_CANCELREASON, "");
    }

    public String getERRORINFO() {
        return this.GetParamStringValue(TAG_ERRORINFO, "");
    }

    public String getACTIVESTEPID() {
        return this.GetParamStringValue(TAG_ACTIVESTEPID, "");
    }

    public String getACTIVESTEPNAME() {
        return this.GetParamStringValue(TAG_ACTIVESTEPNAME, "");
    }

    public String getOWNER() {
        return this.GetParamStringValue(TAG_OWNER, "");
    }

    public String getUSERDATAINFO() {
        return this.GetParamStringValue(TAG_USERDATAINFO, "");
    }

    public String getUSERDATA4() {
        return this.GetParamStringValue(TAG_USERDATA4, "");
    }

    public String getUSERDATA3() {
        return this.GetParamStringValue(TAG_USERDATA3, "");
    }

    public String getUSERDATA2() {
        return this.GetParamStringValue(TAG_USERDATA2, "");
    }

    public String getUSERDATA() {
        return this.GetParamStringValue(TAG_USERDATA, "");
    }

    public String getWFWORKFLOWID() {
        return this.GetParamStringValue(TAG_WFWORKFLOWID, "");
    }

    public String getPWFTRACEID() {
        return this.GetParamStringValue(TAG_PWFTRACEID, "");
    }

    public String getPWFINSTANCEID() {
        return this.GetParamStringValue(TAG_PWFINSTANCEID, "");
    }

    public String getWFINSTANCEID() {
        return this.GetParamStringValue(TAG_WFINSTANCEID, "");
    }

    public String getWFMODEL() {
        return this.GetParamStringValue(TAG_WFMODEL, "");
    }

    public String getWFINSTANCENAME() {
        return this.GetParamStringValue(TAG_WFINSTANCENAME, "");
    }

    public String getPSTEPID() {
        return this.GetParamStringValue(TAG_PSTEPID, "");
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

    public void setCANCELREASON(String strValue) {
        this.SetParamValue(TAG_CANCELREASON, strValue);
    }

    public void setERRORINFO(String strValue) {
        this.SetParamValue(TAG_ERRORINFO, strValue);
    }

    public void setACTIVESTEPID(String strValue) {
        this.SetParamValue(TAG_ACTIVESTEPID, strValue);
    }

    public void setACTIVESTEPNAME(String strValue) {
        this.SetParamValue(TAG_ACTIVESTEPNAME, strValue);
    }

    public void setOWNER(String strValue) {
        this.SetParamValue(TAG_OWNER, strValue);
    }

    public void setUSERDATAINFO(String strValue) {
        this.SetParamValue(TAG_USERDATAINFO, strValue);
    }

    public void setUSERDATA4(String strValue) {
        this.SetParamValue(TAG_USERDATA4, strValue);
    }

    public void setUSERDATA3(String strValue) {
        this.SetParamValue(TAG_USERDATA3, strValue);
    }

    public void setUSERDATA2(String strValue) {
        this.SetParamValue(TAG_USERDATA2, strValue);
    }

    public void setUSERDATA(String strValue) {
        this.SetParamValue(TAG_USERDATA, strValue);
    }

    public void setWFWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_WFWORKFLOWID, strValue);
    }

    public void setPWFTRACEID(String strValue) {
        this.SetParamValue(TAG_PWFTRACEID, strValue);
    }

    public void setPWFINSTANCEID(String strValue) {
        this.SetParamValue(TAG_PWFINSTANCEID, strValue);
    }

    public void setWFINSTANCEID(String strValue) {
        this.SetParamValue(TAG_WFINSTANCEID, strValue);
    }

    public void setWFMODEL(String strValue) {
        this.SetParamValue(TAG_WFMODEL, strValue);
    }

    public void setWFINSTANCENAME(String strValue) {
        this.SetParamValue(TAG_WFINSTANCENAME, strValue);
    }

    public void setPSTEPID(String strValue) {
        this.SetParamValue(TAG_PSTEPID, strValue);
    }

    public int getWFVERSION() {
        return this.GetParamIntValue(TAG_WFVERSION, 0);
    }

    public int getIMPORTANCEFLAG() {
        return this.GetParamIntValue(TAG_IMPORTANCEFLAG, 0);
    }

    public void setWFVERSION(int nValue) {
        this.SetParamValue(TAG_WFVERSION, nValue);
    }

    public void setIMPORTANCEFLAG(int nValue) {
        this.SetParamValue(TAG_IMPORTANCEFLAG, nValue);
    }

    public boolean isCLOSE() {
        return this.GetParamIntValue(TAG_ISCLOSE, 0) == 1;
    }

    public boolean isERROR() {
        return this.GetParamIntValue(TAG_ISERROR, 0) == 1;
    }

    public boolean isFINISH() {
        return this.GetParamIntValue(TAG_ISFINISH, 0) == 1;
    }

    public boolean isCANCEL() {
        return this.GetParamIntValue(TAG_ISCANCEL, 0) == 1;
    }

    public void setISCLOSE(boolean bValue) {
        this.SetParamValue(TAG_ISCLOSE, bValue ? 1 : 0);
    }

    public void setISERROR(boolean bValue) {
        this.SetParamValue(TAG_ISERROR, bValue ? 1 : 0);
    }

    public boolean getPARALLELINST() {
        return this.GetParamIntValue(TAG_PARALLELINST, 0) == 1;
    }

    public void setPARALLELINST(boolean bValue) {
        this.SetParamValue(TAG_PARALLELINST, bValue ? 1 : 0);
    }

    public String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }
}

