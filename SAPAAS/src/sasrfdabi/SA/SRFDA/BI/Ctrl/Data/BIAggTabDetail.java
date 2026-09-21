/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIAggTabDetail
extends BaseDataEntity {
    public static final String TAG_BIAGGTABDETAILID = "BIAGGTABDETAILID";
    public static final String TAG_BIAGGTABDETAILNAME = "BIAGGTABDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIAGGTABLEID = "BIAGGTABLEID";
    public static final String TAG_BIAGGTABLENAME = "BIAGGTABLENAME";
    public static final String TAG_AGGPROCNAME = "AGGPROCNAME";
    public static final String TAG_LASTAGGTIME = "LASTAGGTIME";

    public String getBIAGGTABDETAILID() {
        return this.GetParamStringValue(TAG_BIAGGTABDETAILID, "");
    }

    public void setBIAGGTABDETAILID(String strValue) {
        this.SetParamValue(TAG_BIAGGTABDETAILID, strValue);
    }

    public String getBIAGGTABDETAILNAME() {
        return this.GetParamStringValue(TAG_BIAGGTABDETAILNAME, "");
    }

    public void setBIAGGTABDETAILNAME(String strValue) {
        this.SetParamValue(TAG_BIAGGTABDETAILNAME, strValue);
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

    public String getBIAGGTABLEID() {
        return this.GetParamStringValue(TAG_BIAGGTABLEID, "");
    }

    public void setBIAGGTABLEID(String strValue) {
        this.SetParamValue(TAG_BIAGGTABLEID, strValue);
    }

    public String getBIAGGTABLENAME() {
        return this.GetParamStringValue(TAG_BIAGGTABLENAME, "");
    }

    public void setBIAGGTABLENAME(String strValue) {
        this.SetParamValue(TAG_BIAGGTABLENAME, strValue);
    }

    public String getAGGPROCNAME() {
        return this.GetParamStringValue(TAG_AGGPROCNAME, "");
    }

    public void setAGGPROCNAME(String strValue) {
        this.SetParamValue(TAG_AGGPROCNAME, strValue);
    }

    public Date getLASTAGGTIME() {
        return this.GetParamDateValue(TAG_LASTAGGTIME, null);
    }

    public void setLASTAGGTIME(Date strValue) {
        this.SetParamValue(TAG_LASTAGGTIME, strValue);
    }
}

