/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class SysAdmin
extends BaseDataEntity {
    public static final String TAG_SYSADMINID = "SYSADMINID";
    public static final String TAG_SYSADMINNAME = "SYSADMINNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ADMINOBJECT = "ADMINOBJECT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getSYSADMINID() {
        return this.GetParamStringValue(TAG_SYSADMINID, "");
    }

    public void setSYSADMINID(String strValue) {
        this.SetParamValue(TAG_SYSADMINID, strValue);
    }

    public String getSYSADMINNAME() {
        return this.GetParamStringValue(TAG_SYSADMINNAME, "");
    }

    public void setSYSADMINNAME(String strValue) {
        this.SetParamValue(TAG_SYSADMINNAME, strValue);
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

    public String getADMINOBJECT() {
        return this.GetParamStringValue(TAG_ADMINOBJECT, "");
    }

    public void setADMINOBJECT(String strValue) {
        this.SetParamValue(TAG_ADMINOBJECT, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

