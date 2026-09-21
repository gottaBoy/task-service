/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class UserRoleDataDetail
extends BaseDataEntity {
    public static final String TAG_USERROLEDATAID = "USERROLEDATAID";
    public static final String TAG_USERROLEDATANAME = "USERROLEDATANAME";
    public static final String TAG_USERROLEDATATYPE = "USERROLEDATATYPE";
    public static final String TAG_USERROLEDATAPATH = "USERROLEDATAPATH";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_ISEXCLUDE = "ISEXCLUDE";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISMODELSTYLE = "ISMODELSTYLE";
    public static final String TAG_WINDOWSTYLE = "WINDOWSTYLE";
    public static final String TAG_WTPARAM = "WTPARAM";
    public static final String TAG_USERROLEDATAPARAM = "USERROLEDATAPARAM";
    public static final String TAG_USERROLEDATATEMPLID = "USERROLEDATATEMPLID";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_UDVERSION = "UDVERSION";
    public static final String TAG_TOOLBAR = "TOOLBAR";
    public static final String TAG_DEID = "DEID";

    public String getUSERROLEDATAID() {
        return this.GetParamStringValue(TAG_USERROLEDATAID, "").trim();
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getUSERROLEDATANAME() {
        return this.GetParamStringValue(TAG_USERROLEDATANAME, "");
    }

    public String getUSERROLEID() {
        return this.GetParamStringValue(TAG_USERROLEID, "");
    }

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getRESERVER() {
        return this.GetParamStringValue(TAG_RESERVER, "");
    }

    public String getRESERVER2() {
        return this.GetParamStringValue(TAG_RESERVER2, "");
    }

    public String getWINDOWSTYLE() {
        return this.GetParamStringValue(TAG_WINDOWSTYLE, "");
    }

    public String getWTPARAM() {
        return this.GetParamStringValue(TAG_WTPARAM, "");
    }

    public String getUSERROLEDATAPARAM() {
        return this.GetParamStringValue(TAG_USERROLEDATAPARAM, "");
    }

    public String getTOOLBAR() {
        return this.GetParamStringValue(TAG_TOOLBAR, "");
    }

    public void setUSERROLEDATAID(String strValue) {
        this.SetParamValue(TAG_USERROLEDATAID, strValue);
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setUSERROLEDATANAME(String strValue) {
        this.SetParamValue(TAG_USERROLEDATANAME, strValue);
    }

    public void setUSERROLEDATAPATH(String strValue) {
        this.SetParamValue(TAG_USERROLEDATAPATH, strValue);
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setRESERVER(String strValue) {
        this.SetParamValue(TAG_RESERVER, strValue);
    }

    public void setRESERVER2(String strValue) {
        this.SetParamValue(TAG_RESERVER2, strValue);
    }

    public void setWINDOWSTYLE(String strValue) {
        this.SetParamValue(TAG_WINDOWSTYLE, strValue);
    }

    public boolean isEXCLUDE() {
        return this.GetParamIntValue(TAG_ISEXCLUDE, 0) == 1;
    }

    public boolean isMODELSTYLE() {
        return this.GetParamIntValue(TAG_ISMODELSTYLE, 0) == 1;
    }

    public void setMODELSTYLE(boolean value) {
        this.SetParamValue(TAG_ISMODELSTYLE, value ? 1 : 0);
    }

    public int getUSERROLEDATATYPE() {
        return this.GetParamIntValue(TAG_USERROLEDATATYPE, 0);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setUSERROLEDATATYPE(int nValue) {
        this.SetParamValue(TAG_USERROLEDATATYPE, nValue);
    }

    public void setWIDTH(int nValue) {
        this.SetParamValue(TAG_WIDTH, nValue);
    }

    public void setHEIGHT(int nValue) {
        this.SetParamValue(TAG_HEIGHT, nValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 1);
    }

    public void setVERSION(int nValue) {
        this.SetParamValue(TAG_VERSION, nValue);
    }

    public int getUDVERSION() {
        return this.GetParamIntValue(TAG_UDVERSION, 1);
    }

    public void setUDVERSION(int nValue) {
        this.SetParamValue(TAG_UDVERSION, nValue);
    }
}

