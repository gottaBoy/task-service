/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DALog
extends BaseDataEntity {
    public static final String TAG_DALOG_ID = "DALOG_ID";
    public static final String TAG_DALOG_NAME = "DALOG_NAME";
    public static final String TAG_OBJECTTYPE = "OBJECTTYPE";
    public static final String TAG_OBJECTID = "OBJECTID";
    public static final String TAG_DALOGSIZE = "DALOGSIZE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGTYPE = "LOGTYPE";

    public String getDALOG_ID() {
        return this.GetParamStringValue(TAG_DALOG_ID, "").trim();
    }

    public String getDALOG_NAME() {
        return this.GetParamStringValue(TAG_DALOG_NAME, "");
    }

    public String getOBJECTID() {
        return this.GetParamStringValue(TAG_OBJECTID, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getLOGTYPE() {
        return this.GetParamStringValue(TAG_LOGTYPE, "");
    }

    public void setDALOG_ID(String strValue) {
        this.SetParamValue(TAG_DALOG_ID, strValue);
    }

    public void setDALOG_NAME(String strValue) {
        this.SetParamValue(TAG_DALOG_NAME, strValue);
    }

    public void setOBJECTID(String strValue) {
        this.SetParamValue(TAG_OBJECTID, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setLOGTYPE(String strValue) {
        this.SetParamValue(TAG_LOGTYPE, strValue);
    }

    public String getOBJECTTYPE() {
        return this.GetParamStringValue(TAG_OBJECTTYPE, "");
    }

    public int getDALOGSIZE() {
        return this.GetParamIntValue(TAG_DALOGSIZE, 0);
    }

    public void setOBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_OBJECTTYPE, strValue);
    }

    public void setDALOGSIZE(int nValue) {
        this.SetParamValue(TAG_DALOGSIZE, nValue);
    }
}

