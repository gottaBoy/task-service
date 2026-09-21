/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFDA.EAI.Config.BaseDataSourceConfigWriter;
import SA.SRFDA.EAI.Ctrl.Data.BaseEAIObject;
import java.util.Date;

public class EAIDataSource
extends BaseEAIObject {
    public static final String TAG_EAIDATASOURCEID = "EAIDATASOURCEID";
    public static final String TAG_EAIDATASOURCENAME = "EAIDATASOURCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PWD = "PWD";
    public static final String TAG_URL = "URL";
    public static final String TAG_DBTYPE = "DBTYPE";

    public String getEAIDATASOURCEID() {
        return this.GetParamStringValue(TAG_EAIDATASOURCEID, "");
    }

    public void setEAIDATASOURCEID(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCEID, strValue);
    }

    public String getEAIDATASOURCENAME() {
        return this.GetParamStringValue(TAG_EAIDATASOURCENAME, "");
    }

    public void setEAIDATASOURCENAME(String strValue) {
        this.SetParamValue(TAG_EAIDATASOURCENAME, strValue);
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

    public String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public String getPWD() {
        return this.GetParamStringValue(TAG_PWD, "");
    }

    public void setPWD(String strValue) {
        this.SetParamValue(TAG_PWD, strValue);
    }

    public String getURL() {
        return this.GetParamStringValue(TAG_URL, "");
    }

    public void setURL(String strValue) {
        this.SetParamValue(TAG_URL, strValue);
    }

    public String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    @Override
    protected String OnGetDefaultConfigWriter() {
        return BaseDataSourceConfigWriter.class.getName();
    }
}

