/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class GSRMeasureGroup
extends BaseDataEntity {
    public static final String TAG_GSRMEASUREGROUPID = "GSRMEASUREGROUPID";
    public static final String TAG_GSRMEASUREGROUPNAME = "GSRMEASUREGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";

    public String getGSRMEASUREGROUPID() {
        return this.GetParamStringValue(TAG_GSRMEASUREGROUPID, "");
    }

    public void setGSRMEASUREGROUPID(String strValue) {
        this.SetParamValue(TAG_GSRMEASUREGROUPID, strValue);
    }

    public String getGSRMEASUREGROUPNAME() {
        return this.GetParamStringValue(TAG_GSRMEASUREGROUPNAME, "");
    }

    public void setGSRMEASUREGROUPNAME(String strValue) {
        this.SetParamValue(TAG_GSRMEASUREGROUPNAME, strValue);
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

