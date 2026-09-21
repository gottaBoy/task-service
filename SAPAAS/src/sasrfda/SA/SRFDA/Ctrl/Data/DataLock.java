/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;

public class DataLock
extends BaseDataEntity {
    public static final String TAG_DATALOCKID = "DATALOCKID";
    public static final String TAG_DATALOCKNAME = "DATALOCKNAME";
    public static final String TAG_OBJECTID = "OBJECTID";
    public static final String TAG_OBJECTTYPE = "OBJECTTYPE";
    public static final String TAG_KEY = "KEY";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DATAGRIDID = "DATAGRIDID";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_OBJECTID_DEDATAGRID = "DEDATAGRID";
    public static final String TAG_OBJECTID_DEGRIDVIEW = "DEGRIDVIEW";
    public static final String TAG_OBJECTID_PAGELINK = "PAGELINK";
    public static final String TAG_OBJECTID_JSCODE = "JSCODE";
    public static final String TAG_OBJECTID_PAGE = "PAGE";
    public static final String TAG_JSCODE = "JSCODE";

    public String getDATALOCKID() {
        return this.GetParamStringValue(TAG_DATALOCKID, "").trim();
    }

    public String getDATALOCKNAME() {
        return this.GetParamStringValue(TAG_DATALOCKNAME, "");
    }

    public String getOBJECTTYPE() {
        return this.GetParamStringValue(TAG_OBJECTTYPE, "");
    }

    public String getOBJECTID() {
        return this.GetParamStringValue(TAG_OBJECTID, "");
    }

    public String getJSCODE() {
        return this.GetParamStringValue("JSCODE", "");
    }

    public String getKEY() {
        return this.GetParamStringValue(TAG_KEY, "");
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public String getDATAGRIDID() {
        return this.GetParamStringValue(TAG_DATAGRIDID, "");
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setDATALOCKID(String strValue) {
        this.SetParamValue(TAG_DATALOCKID, strValue);
    }

    public void setDATALOCKNAME(String strValue) {
        this.SetParamValue(TAG_DATALOCKNAME, strValue);
    }

    public void setOBJECTTYPE(String strValue) {
        this.SetParamValue(TAG_OBJECTTYPE, strValue);
    }

    public void setOBJECTID(String strValue) {
        this.SetParamValue(TAG_OBJECTID, strValue);
    }

    public void setKEY(String strValue) {
        this.SetParamValue(TAG_KEY, strValue);
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public void setJSCODE(String strValue) {
        this.SetParamValue("JSCODE", strValue);
    }

    public boolean isSYSTEM() {
        return this.GetParamIntValue(TAG_ISSYSTEM, 0) == 1;
    }
}

