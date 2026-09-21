/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class MainMenu
extends BaseDataEntity {
    public static final String TAG_MAINMENU_ID = "MAINMENU_ID";
    public static final String TAG_MAINMENU_NAME = "MAINMENU_NAME";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_MMVERSION = "MMVERSION";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_MENUMODEL = "MENUMODEL";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";

    public String getMAINMENU_ID() {
        return this.GetParamStringValue(TAG_MAINMENU_ID, "").trim();
    }

    public String getMAINMENU_NAME() {
        return this.GetParamStringValue(TAG_MAINMENU_NAME, "");
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public String getMENUMODEL() {
        return this.GetParamStringValue(TAG_MENUMODEL, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setMAINMENU_ID(String strValue) {
        this.SetParamValue(TAG_MAINMENU_ID, strValue);
    }

    public void setMAINMENU_NAME(String strValue) {
        this.SetParamValue(TAG_MAINMENU_NAME, strValue);
    }

    public void setUSERMODE(String strValue) {
        this.SetParamValue(TAG_USERMODE, strValue);
    }

    public void setMENUMODEL(String strValue) {
        this.SetParamValue(TAG_MENUMODEL, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public int getMMVERSION() {
        return this.GetParamIntValue(TAG_MMVERSION, 0);
    }

    public void setMMVERSION(int nValue) {
        this.SetParamValue(TAG_MMVERSION, nValue);
    }
}

