/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.IS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ISType
extends BaseDataEntity {
    public static final String TAG_ISTYPEID = "ISTYPEID";
    public static final String TAG_ISTYPENAME = "ISTYPENAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_DETAILURL = "DETAILURL";

    public String getISTYPEID() {
        return this.GetParamStringValue(TAG_ISTYPEID, "");
    }

    public void setISTYPEID(String strValue) {
        this.SetParamValue(TAG_ISTYPEID, strValue);
    }

    public String getISTYPENAME() {
        return this.GetParamStringValue(TAG_ISTYPENAME, "");
    }

    public void setISTYPENAME(String strValue) {
        this.SetParamValue(TAG_ISTYPENAME, strValue);
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

    public String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public String getDETAILURL() {
        return this.GetParamStringValue(TAG_DETAILURL, "");
    }

    public void setDETAILURL(String strValue) {
        this.SetParamValue(TAG_DETAILURL, strValue);
    }
}

