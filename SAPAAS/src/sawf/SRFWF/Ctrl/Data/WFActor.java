/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class WFActor
extends BaseDataEntity {
    public static final String TAG_WFACTORID = "WFACTORID";
    public static final String TAG_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String TAG_WFACTORTYPE = "WFACTORTYPE";
    public static final String TAG_ACTIONLOGICNAME = "ACTIONLOGICNAME";
    public static final String TAG_ACTIONTYPE = "ACTIONTYPE";
    public static final String TAG_BAHELPER = "BAHELPER";
    public static final String TAG_WFACTORNAME = "WFACTORNAME";
    public static final String TAG_PAGESTYLE = "PAGESTYLE";
    public static final String TAG_ICONSTYLE = "ICONSTYLE";
    public static final String TAG_ISSUPPORTMULTI = "ISSUPPORTMULTI";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_WFACTORPARAM = "WFACTORPARAM";
    public static final String TAG_WFACTORPARAM2 = "WFACTORPARAM2";
    public static final String TAG_PARAMS = "PARAMS";
    public static final String TAG_WFACTORTYPE_USER = "USER";
    public static final String TAG_WFACTORTYPE_USERGROUP = "USERGROUP";
    public static final String TAG_WFACTORTYPE_SYSTEMUSER = "SYSTEMUSER";
    public static final String TAG_WFACTORTYPE_DYNAMICUSER = "DYNAMICUSER";

    public String getWFACTORPARAM() {
        return this.GetParamStringValue(TAG_WFACTORPARAM, "");
    }

    public String getWFACTORPARAM2() {
        return this.GetParamStringValue(TAG_WFACTORPARAM2, "");
    }

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

    public String getICONSTYLE() {
        return this.GetParamStringValue(TAG_ICONSTYLE, "");
    }

    public String getPAGESTYLE() {
        return this.GetParamStringValue(TAG_PAGESTYLE, "");
    }

    public String getWFACTORNAME() {
        return this.GetParamStringValue(TAG_WFACTORNAME, "");
    }

    public String getBAHELPER() {
        return this.GetParamStringValue(TAG_BAHELPER, "");
    }

    public String getACTIONLOGICNAME() {
        return this.GetParamStringValue(TAG_ACTIONLOGICNAME, "");
    }

    public String getWFACTORTYPE() {
        return this.GetParamStringValue(TAG_WFACTORTYPE, "");
    }

    public String getWFWORKFLOWID() {
        return this.GetParamStringValue(TAG_WFWORKFLOWID, "");
    }

    public String getWFACTORID() {
        return this.GetParamStringValue(TAG_WFACTORID, "");
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

    public void setICONSTYLE(String strValue) {
        this.SetParamValue(TAG_ICONSTYLE, strValue);
    }

    public void setPAGESTYLE(String strValue) {
        this.SetParamValue(TAG_PAGESTYLE, strValue);
    }

    public void setWFACTORNAME(String strValue) {
        this.SetParamValue(TAG_WFACTORNAME, strValue);
    }

    public void setBAHELPER(String strValue) {
        this.SetParamValue(TAG_BAHELPER, strValue);
    }

    public void setACTIONLOGICNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONLOGICNAME, strValue);
    }

    public void setWFACTORTYPE(String strValue) {
        this.SetParamValue(TAG_WFACTORTYPE, strValue);
    }

    public void setWFWORKFLOWID(String strValue) {
        this.SetParamValue(TAG_WFWORKFLOWID, strValue);
    }

    public void setWFACTORID(String strValue) {
        this.SetParamValue(TAG_WFACTORID, strValue);
    }

    public boolean isSUPPORTMULTI() {
        return this.GetParamIntValue(TAG_ISSUPPORTMULTI, 0) == 1;
    }

    public int getACTIONTYPE() {
        return this.GetParamIntValue(TAG_ACTIONTYPE, 0);
    }

    public void setACTIONTYPE(int nValue) {
        this.SetParamValue(TAG_ACTIONTYPE, nValue);
    }

    public void setSUPPORTMULTI(boolean bValue) {
        this.SetParamValue(TAG_ISSUPPORTMULTI, bValue ? 1 : 0);
    }

    public String getPARAMS() {
        return this.GetParamStringValue(TAG_PARAMS, "");
    }

    public void setPARAMS(String strValue) {
        this.SetParamValue(TAG_PARAMS, strValue);
    }
}

