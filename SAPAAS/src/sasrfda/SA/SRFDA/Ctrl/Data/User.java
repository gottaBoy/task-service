/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class User
extends BaseDataEntity {
    public static final String USERMODE_DEFAULT = "DEFAULT";
    public static final String USERMODE_SYSTEMDEVELOP = "SYSTEMDEVELOP";
    public static final String USERMODE_EAI = "EAI";
    public static final String TAG_USERID = "USERID";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_USERMODE = "USERMODE";
    public static final String TAG_LOGINNAME = "LOGINNAME";
    public static final String TAG_LOGINPWD = "LOGINPWD";
    public static final String TAG_TIMEZONE = "TIMEZONE";

    public String getUSERID() {
        return this.GetParamStringValue(TAG_USERID, "");
    }

    public void setUSERID(String strValue) {
        this.SetParamValue(TAG_USERID, strValue);
    }

    public String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public boolean getISSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }

    public void setISSYSTEM(boolean bValue) {
        this.SetParamValue(TAG_ISSYSTEM, bValue ? 1 : 0);
    }

    public String getUSERMODE() {
        return this.GetParamStringValue(TAG_USERMODE, "");
    }

    public void setUSERMODE(String strValue) {
        this.SetParamValue(TAG_USERMODE, strValue);
    }

    public String getLOGINNAME() {
        return this.GetParamStringValue(TAG_LOGINNAME, "");
    }

    public void setLOGINNAME(String strValue) {
        this.SetParamValue(TAG_LOGINNAME, strValue);
    }

    public String getLOGINPWD() {
        return this.GetParamStringValue(TAG_LOGINPWD, "");
    }

    public void setLOGINPWD(String strValue) {
        this.SetParamValue(TAG_LOGINPWD, strValue);
    }

    public String getTIMEZONE() {
        return this.GetParamStringValue(TAG_TIMEZONE, "");
    }

    public void setTIMEZONE(String strValue) {
        this.SetParamValue(TAG_TIMEZONE, strValue);
    }
}

