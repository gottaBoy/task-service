/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACDataSource
extends BaseDataEntity {
    public static final String TAG_UACDATASOURCEID = "UACDATASOURCEID";
    public static final String TAG_UACDATASOURCENAME = "UACDATASOURCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_URL = "URL";
    public static final String TAG_PWD = "PWD";
    public static final String TAG_USERNAME = "USERNAME";

    public String getUACDATASOURCEID() {
        return this.GetParamStringValue(TAG_UACDATASOURCEID, "");
    }

    public void setUACDATASOURCEID(String strValue) {
        this.SetParamValue(TAG_UACDATASOURCEID, strValue);
    }

    public String getUACDATASOURCENAME() {
        return this.GetParamStringValue(TAG_UACDATASOURCENAME, "");
    }

    public void setUACDATASOURCENAME(String strValue) {
        this.SetParamValue(TAG_UACDATASOURCENAME, strValue);
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

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public String getURL() {
        return this.GetParamStringValue(TAG_URL, "");
    }

    public void setURL(String strValue) {
        this.SetParamValue(TAG_URL, strValue);
    }

    public String getPWD() {
        return this.GetParamStringValue(TAG_PWD, "");
    }

    public void setPWD(String strValue) {
        this.SetParamValue(TAG_PWD, strValue);
    }

    public String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }
}

