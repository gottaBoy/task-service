/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class CaretTemplGroup
extends BaseDataEntity {
    public static final String TAG_CARETTEMPLGROUPID = "CARETTEMPLGROUPID";
    public static final String TAG_CARETTEMPLGROUPNAME = "CARETTEMPLGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";

    public String getCARETTEMPLGROUPID() {
        return this.GetParamStringValue(TAG_CARETTEMPLGROUPID, "");
    }

    public void setCARETTEMPLGROUPID(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLGROUPID, strValue);
    }

    public String getCARETTEMPLGROUPNAME() {
        return this.GetParamStringValue(TAG_CARETTEMPLGROUPNAME, "");
    }

    public void setCARETTEMPLGROUPNAME(String strValue) {
        this.SetParamValue(TAG_CARETTEMPLGROUPNAME, strValue);
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
}

