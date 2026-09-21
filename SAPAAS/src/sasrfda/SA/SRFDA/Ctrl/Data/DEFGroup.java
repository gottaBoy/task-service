/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEFGroup
extends BaseDataEntity {
    public static final String TAG_DEFGROUPID = "DEFGROUPID";
    public static final String TAG_DEFGROUPNAME = "DEFGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEFGROUPVERSION = "DEFGROUPVERSION";

    public String getDEFGROUPID() {
        return this.GetParamStringValue(TAG_DEFGROUPID, "");
    }

    public void setDEFGROUPID(String strValue) {
        this.SetParamValue(TAG_DEFGROUPID, strValue);
    }

    public String getDEFGROUPNAME() {
        return this.GetParamStringValue(TAG_DEFGROUPNAME, "");
    }

    public void setDEFGROUPNAME(String strValue) {
        this.SetParamValue(TAG_DEFGROUPNAME, strValue);
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

    public String getDEFGROUPVERSION() {
        return this.GetParamStringValue(TAG_DEFGROUPVERSION, "");
    }

    public void setDEFGROUPVERSION(String strValue) {
        this.SetParamValue(TAG_DEFGROUPVERSION, strValue);
    }
}

