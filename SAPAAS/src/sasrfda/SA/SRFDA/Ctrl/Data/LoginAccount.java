/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LoginAccount
extends BaseDataEntity {
    public static final String TAG_LOGINACCOUNTID = "LOGINACCOUNTID";
    public static final String TAG_LOGINACCOUNTNAME = "LOGINACCOUNTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PWD = "PWD";
    public static final String TAG_ISENABLE = "ISENABLE";
    public static final String TAG_LASTLOGINTIME = "LASTLOGINTIME";
    public static final String TAG_USERID = "USERID";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_USERMODEID = "USERMODEID";
    public static final String TAG_USERMODENAME = "USERMODENAME";
    public static final String TAG_LANGUAGE = "LANGUAGE";
    public static final String TAG_APPUITHEME = "APPUITHEME";

    public String getLOGINACCOUNTID() {
        return this.GetParamStringValue(TAG_LOGINACCOUNTID, "");
    }

    public void setLOGINACCOUNTID(String strValue) {
        this.SetParamValue(TAG_LOGINACCOUNTID, strValue);
    }

    public String getLOGINACCOUNTNAME() {
        return this.GetParamStringValue(TAG_LOGINACCOUNTNAME, "");
    }

    public void setLOGINACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_LOGINACCOUNTNAME, strValue);
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

    public String getPWD() {
        return this.GetParamStringValue(TAG_PWD, "");
    }

    public void setPWD(String strValue) {
        this.SetParamValue(TAG_PWD, strValue);
    }

    public boolean getISENABLE() {
        return this.GetParamIntValue(TAG_ISENABLE, 0) == 1;
    }

    public void setISENABLE(boolean bValue) {
        this.SetParamValue(TAG_ISENABLE, bValue ? 1 : 0);
    }

    public Date getLASTLOGINTIME() {
        return this.GetParamDateValue(TAG_LASTLOGINTIME, null);
    }

    public void setLASTLOGINTIME(Date strValue) {
        this.SetParamValue(TAG_LASTLOGINTIME, strValue);
    }

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

    public String getUSERMODEID() {
        return this.GetParamStringValue(TAG_USERMODEID, "");
    }

    public void setUSERMODEID(String strValue) {
        this.SetParamValue(TAG_USERMODEID, strValue);
    }

    public String getUSERMODENAME() {
        return this.GetParamStringValue(TAG_USERMODENAME, "");
    }

    public void setUSERMODENAME(String strValue) {
        this.SetParamValue(TAG_USERMODENAME, strValue);
    }

    public String getLANGUAGE() {
        return this.GetParamStringValue(TAG_LANGUAGE, "");
    }

    public void setLANGUAGE(String strValue) {
        this.SetParamValue(TAG_LANGUAGE, strValue);
    }

    public String getAPPUITHEME() {
        return this.GetParamStringValue(TAG_APPUITHEME, "");
    }

    public void setAPPUITHEME(String strValue) {
        this.SetParamValue(TAG_APPUITHEME, strValue);
    }
}

