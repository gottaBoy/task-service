/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICubeRole
extends BaseDataEntity {
    public static final String TAG_BICUBEROLEID = "BICUBEROLEID";
    public static final String TAG_BICUBEROLENAME = "BICUBEROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICATALOGROLEID = "BICATALOGROLEID";
    public static final String TAG_BICATALOGROLENAME = "BICATALOGROLENAME";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_ACCESSTYPE = "ACCESSTYPE";

    public String getBICUBEROLEID() {
        return this.GetParamStringValue(TAG_BICUBEROLEID, "");
    }

    public void setBICUBEROLEID(String strValue) {
        this.SetParamValue(TAG_BICUBEROLEID, strValue);
    }

    public String getBICUBEROLENAME() {
        return this.GetParamStringValue(TAG_BICUBEROLENAME, "");
    }

    public void setBICUBEROLENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEROLENAME, strValue);
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

    public String getBICATALOGROLEID() {
        return this.GetParamStringValue(TAG_BICATALOGROLEID, "");
    }

    public void setBICATALOGROLEID(String strValue) {
        this.SetParamValue(TAG_BICATALOGROLEID, strValue);
    }

    public String getBICATALOGROLENAME() {
        return this.GetParamStringValue(TAG_BICATALOGROLENAME, "");
    }

    public void setBICATALOGROLENAME(String strValue) {
        this.SetParamValue(TAG_BICATALOGROLENAME, strValue);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
    }

    public String getACCESSTYPE() {
        return this.GetParamStringValue(TAG_ACCESSTYPE, "");
    }

    public void setACCESSTYPE(String strValue) {
        this.SetParamValue(TAG_ACCESSTYPE, strValue);
    }
}

