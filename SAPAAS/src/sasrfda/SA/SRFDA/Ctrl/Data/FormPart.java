/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class FormPart
extends BaseDataEntity {
    public static final String TAG_FORMPARTID = "FORMPARTID";
    public static final String TAG_FORMPARTNAME = "FORMPARTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FORMPARTMODEL = "FORMPARTMODEL";

    public String getFORMPARTID() {
        return this.GetParamStringValue(TAG_FORMPARTID, "");
    }

    public void setFORMPARTID(String strValue) {
        this.SetParamValue(TAG_FORMPARTID, strValue);
    }

    public String getFORMPARTNAME() {
        return this.GetParamStringValue(TAG_FORMPARTNAME, "");
    }

    public void setFORMPARTNAME(String strValue) {
        this.SetParamValue(TAG_FORMPARTNAME, strValue);
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

    public String getFORMPARTMODEL() {
        return this.GetParamStringValue(TAG_FORMPARTMODEL, "");
    }

    public void setFORMPARTMODEL(String strValue) {
        this.SetParamValue(TAG_FORMPARTMODEL, strValue);
    }
}

