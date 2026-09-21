/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SRFWF.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class WFIAAction
extends BaseDataEntity {
    public static final String TAG_WFIAACTIONID = "WFIAACTIONID";
    public static final String TAG_WFSTEPID = "WFSTEPID";
    public static final String TAG_ACTIONNAME = "ACTIONNAME";
    public static final String TAG_ACTIONLOGICNAME = "ACTIONLOGICNAME";
    public static final String TAG_ACTIONCOUNT = "ACTIONCOUNT";
    public static final String TAG_PAGEPATH = "PAGEPATH";
    public static final String TAG_PANELID = "PANELID";
    public static final String TAG_FAHELPER = "FAHELPER";
    public static final String TAG_ORDERFLAG = "ORDERFLAG";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_NEXTTO = "NEXTTO";
    public static final String TAG_NEXTCONDITION = "NEXTCONDITION";

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

    public String getFAHELPER() {
        return this.GetParamStringValue(TAG_FAHELPER, "");
    }

    public String getPANELID() {
        return this.GetParamStringValue(TAG_PANELID, "");
    }

    public String getPAGEPATH() {
        return this.GetParamStringValue(TAG_PAGEPATH, "");
    }

    public String getACTIONLOGICNAME() {
        return this.GetParamStringValue(TAG_ACTIONLOGICNAME, "");
    }

    public String getACTIONNAME() {
        return this.GetParamStringValue(TAG_ACTIONNAME, "");
    }

    public String getWFSTEPID() {
        return this.GetParamStringValue(TAG_WFSTEPID, "");
    }

    public String getWFIAACTIONID() {
        return this.GetParamStringValue(TAG_WFIAACTIONID, "");
    }

    public String getNEXTTO() {
        return this.GetParamStringValue(TAG_NEXTTO, "");
    }

    public String getNEXTCONDITION() {
        return this.GetParamStringValue(TAG_NEXTCONDITION, "");
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

    public void setFAHELPER(String strValue) {
        this.SetParamValue(TAG_FAHELPER, strValue);
    }

    public void setPANELID(String strValue) {
        this.SetParamValue(TAG_PANELID, strValue);
    }

    public void setPAGEPATH(String strValue) {
        this.SetParamValue(TAG_PAGEPATH, strValue);
    }

    public void setACTIONLOGICNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONLOGICNAME, strValue);
    }

    public void setACTIONNAME(String strValue) {
        this.SetParamValue(TAG_ACTIONNAME, strValue);
    }

    public void setWFSTEPID(String strValue) {
        this.SetParamValue(TAG_WFSTEPID, strValue);
    }

    public void setWFIAACTIONID(String strValue) {
        this.SetParamValue(TAG_WFIAACTIONID, strValue);
    }

    public void setNEXTTO(String strValue) {
        this.SetParamValue(TAG_NEXTTO, strValue);
    }

    public void setNEXTCONDITION(String strValue) {
        this.SetParamValue(TAG_NEXTCONDITION, strValue);
    }

    public int getACTIONCOUNT() {
        return this.GetParamIntValue(TAG_ACTIONCOUNT, 0);
    }

    public int getORDERFLAG() {
        return this.GetParamIntValue(TAG_ORDERFLAG, 0);
    }

    public void setACTIONCOUNT(int nValue) {
        this.SetParamValue(TAG_ACTIONCOUNT, nValue);
    }

    public void setORDERFLAG(int nValue) {
        this.SetParamValue(TAG_ORDERFLAG, nValue);
    }
}

