/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICubeDimensionRole
extends BaseDataEntity {
    public static final String TAG_BICUBEDIMENSIONROLEID = "BICUBEDIMENSIONROLEID";
    public static final String TAG_BICUBEDIMENSIONROLENAME = "BICUBEDIMENSIONROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEROLEID = "BICUBEROLEID";
    public static final String TAG_BICUBEROLENAME = "BICUBEROLENAME";
    public static final String TAG_BICUBEDIMENSIONID = "BICUBEDIMENSIONID";
    public static final String TAG_BICUBEDIMENSIONNAME = "BICUBEDIMENSIONNAME";
    public static final String TAG_ACCESSTYPE = "ACCESSTYPE";

    public String getBICUBEDIMENSIONROLEID() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONROLEID, "");
    }

    public void setBICUBEDIMENSIONROLEID(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONROLEID, strValue);
    }

    public String getBICUBEDIMENSIONROLENAME() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONROLENAME, "");
    }

    public void setBICUBEDIMENSIONROLENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONROLENAME, strValue);
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

    public String getBICUBEDIMENSIONID() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONID, "");
    }

    public void setBICUBEDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONID, strValue);
    }

    public String getBICUBEDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_BICUBEDIMENSIONNAME, "");
    }

    public void setBICUBEDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_BICUBEDIMENSIONNAME, strValue);
    }

    public String getACCESSTYPE() {
        return this.GetParamStringValue(TAG_ACCESSTYPE, "");
    }

    public void setACCESSTYPE(String strValue) {
        this.SetParamValue(TAG_ACCESSTYPE, strValue);
    }
}

