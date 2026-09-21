/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.TS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TSSDTaskPolicy
extends BaseDataEntity {
    public static final String TAG_TSSDTASKPOLICYID = "TSSDTASKPOLICYID";
    public static final String TAG_TSSDTASKPOLICYNAME = "TSSDTASKPOLICYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TSSDTASKID = "TSSDTASKID";
    public static final String TAG_TSSDTASKNAME = "TSSDTASKNAME";
    public static final String TAG_TSSDPOLICYID = "TSSDPOLICYID";
    public static final String TAG_TSSDPOLICYNAME = "TSSDPOLICYNAME";

    public String getTSSDTASKPOLICYID() {
        return this.GetParamStringValue(TAG_TSSDTASKPOLICYID, "");
    }

    public void setTSSDTASKPOLICYID(String strValue) {
        this.SetParamValue(TAG_TSSDTASKPOLICYID, strValue);
    }

    public String getTSSDTASKPOLICYNAME() {
        return this.GetParamStringValue(TAG_TSSDTASKPOLICYNAME, "");
    }

    public void setTSSDTASKPOLICYNAME(String strValue) {
        this.SetParamValue(TAG_TSSDTASKPOLICYNAME, strValue);
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

    public String getTSSDTASKID() {
        return this.GetParamStringValue(TAG_TSSDTASKID, "");
    }

    public void setTSSDTASKID(String strValue) {
        this.SetParamValue(TAG_TSSDTASKID, strValue);
    }

    public String getTSSDTASKNAME() {
        return this.GetParamStringValue(TAG_TSSDTASKNAME, "");
    }

    public void setTSSDTASKNAME(String strValue) {
        this.SetParamValue(TAG_TSSDTASKNAME, strValue);
    }

    public String getTSSDPOLICYID() {
        return this.GetParamStringValue(TAG_TSSDPOLICYID, "");
    }

    public void setTSSDPOLICYID(String strValue) {
        this.SetParamValue(TAG_TSSDPOLICYID, strValue);
    }

    public String getTSSDPOLICYNAME() {
        return this.GetParamStringValue(TAG_TSSDPOLICYNAME, "");
    }

    public void setTSSDPOLICYNAME(String strValue) {
        this.SetParamValue(TAG_TSSDPOLICYNAME, strValue);
    }
}

