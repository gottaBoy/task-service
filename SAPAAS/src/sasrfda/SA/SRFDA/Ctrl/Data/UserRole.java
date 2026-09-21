/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class UserRole
extends BaseDataEntity {
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_USERROLENAME = "USERROLENAME";
    public static final String TAG_MENUMODE = "MENUMODE";
    public static final String TAG_USERROLEPATH = "USERROLEPATH";
    public static final String TAG_WIDTH = "WIDTH";
    public static final String TAG_HEIGHT = "HEIGHT";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RESERVER = "RESERVER";
    public static final String TAG_RESERVER2 = "RESERVER2";
    public static final String TAG_ISMODELSTYLE = "ISMODELSTYLE";
    public static final String TAG_WINDOWSTYLE = "WINDOWSTYLE";
    public static final String TAG_WTPARAM = "WTPARAM";
    public static final String TAG_USERROLEPARAM = "USERROLEPARAM";
    public static final String TAG_USERROLETEMPLID = "USERROLETEMPLID";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_UDVERSION = "UDVERSION";
    public static final String TAG_TOOLBAR = "TOOLBAR";
    public static final String TAG_DEID = "DEID";

    public final boolean isUSERROLEIDNull() {
        return this.IsParamNull(TAG_USERROLEID);
    }

    public final String getUSERROLEID() {
        return this.GetParamStringValue(TAG_USERROLEID, "");
    }

    public final void setUSERROLEID(String strValue) {
        this.SetParamValue(TAG_USERROLEID, strValue);
    }

    public final boolean isUSERROLENAMENull() {
        return this.IsParamNull(TAG_USERROLENAME);
    }

    public final String getUSERROLENAME() {
        return this.GetParamStringValue(TAG_USERROLENAME, "");
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "").trim();
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
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

    public String getUSERROLEPARAM() {
        return this.GetParamStringValue(TAG_USERROLEPARAM, "");
    }

    public String getTOOLBAR() {
        return this.GetParamStringValue(TAG_TOOLBAR, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public void setUSERROLENAME(String strValue) {
        this.SetParamValue(TAG_USERROLENAME, strValue);
    }

    public void setUSERROLEPATH(String strValue) {
        this.SetParamValue(TAG_USERROLEPATH, strValue);
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
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

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public boolean isMODELSTYLE() {
        return this.GetParamIntValue(TAG_ISMODELSTYLE, 0) == 1;
    }

    public void setMODELSTYLE(boolean value) {
        this.SetParamValue(TAG_ISMODELSTYLE, value ? 1 : 0);
    }

    public int getMENUMODE() {
        return this.GetParamIntValue(TAG_MENUMODE, 0);
    }

    public int getWIDTH() {
        return this.GetParamIntValue(TAG_WIDTH, 0);
    }

    public int getHEIGHT() {
        return this.GetParamIntValue(TAG_HEIGHT, 0);
    }

    public void setMENUMODE(int nValue) {
        this.SetParamValue(TAG_MENUMODE, nValue);
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

