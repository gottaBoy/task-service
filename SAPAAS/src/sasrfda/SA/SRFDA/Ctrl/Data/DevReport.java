/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DevReport
extends BaseDataEntity {
    public static final String TAG_DEVREPORTID = "DEVREPORTID";
    public static final String TAG_DEVREPORTNAME = "DEVREPORTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_REPORTMODEL = "REPORTMODEL";
    public static final String TAG_DSTPATH = "DSTPATH";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getDEVREPORTID() {
        return this.GetParamStringValue(TAG_DEVREPORTID, "");
    }

    public void setDEVREPORTID(String strValue) {
        this.SetParamValue(TAG_DEVREPORTID, strValue);
    }

    public String getDEVREPORTNAME() {
        return this.GetParamStringValue(TAG_DEVREPORTNAME, "");
    }

    public void setDEVREPORTNAME(String strValue) {
        this.SetParamValue(TAG_DEVREPORTNAME, strValue);
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

    public String getREPORTMODEL() {
        return this.GetParamStringValue(TAG_REPORTMODEL, "");
    }

    public void setREPORTMODEL(String strValue) {
        this.SetParamValue(TAG_REPORTMODEL, strValue);
    }

    public String getDSTPATH() {
        return this.GetParamStringValue(TAG_DSTPATH, "");
    }

    public void setDSTPATH(String strValue) {
        this.SetParamValue(TAG_DSTPATH, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

