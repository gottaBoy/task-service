/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class Module
extends BaseDataEntity {
    public static final String TAG_MODULE_ID = "MODULE_ID";
    public static final String TAG_MODULE_NAME = "MODULE_NAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISSYSTEM = "ISSYSTEM";

    public String getMODULE_ID() {
        return this.GetParamStringValue(TAG_MODULE_ID, "");
    }

    public void setMODULE_ID(String strValue) {
        this.SetParamValue(TAG_MODULE_ID, strValue);
    }

    public String getMODULE_NAME() {
        return this.GetParamStringValue(TAG_MODULE_NAME, "");
    }

    public void setMODULE_NAME(String strValue) {
        this.SetParamValue(TAG_MODULE_NAME, strValue);
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
}

