/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class EAIProtocol
extends BaseDataEntity {
    public static final String TAG_EAIPROTOCOLID = "EAIPROTOCOLID";
    public static final String TAG_EAIPROTOCOLNAME = "EAIPROTOCOLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TRANSFORMER = "TRANSFORMER";
    public static final String TAG_REPTRANSFORMER = "REPTRANSFORMER";

    public String getEAIPROTOCOLID() {
        return this.GetParamStringValue(TAG_EAIPROTOCOLID, "");
    }

    public void setEAIPROTOCOLID(String strValue) {
        this.SetParamValue(TAG_EAIPROTOCOLID, strValue);
    }

    public String getEAIPROTOCOLNAME() {
        return this.GetParamStringValue(TAG_EAIPROTOCOLNAME, "");
    }

    public void setEAIPROTOCOLNAME(String strValue) {
        this.SetParamValue(TAG_EAIPROTOCOLNAME, strValue);
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

    public String getTRANSFORMER() {
        return this.GetParamStringValue(TAG_TRANSFORMER, "");
    }

    public void setTRANSFORMER(String strValue) {
        this.SetParamValue(TAG_TRANSFORMER, strValue);
    }

    public String getREPTRANSFORMER() {
        return this.GetParamStringValue(TAG_REPTRANSFORMER, "");
    }

    public void setREPTRANSFORMER(String strValue) {
        this.SetParamValue(TAG_REPTRANSFORMER, strValue);
    }
}

