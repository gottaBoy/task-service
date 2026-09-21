/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PubItem
extends BaseDataEntity {
    public static final String PUBITEMTYPE_FTP = "FTP";
    public static final String TAG_PUBITEMID = "PUBITEMID";
    public static final String TAG_PUBITEMNAME = "PUBITEMNAME";
    public static final String TAG_PUBITEMTYPE = "PUBITEMTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PUBGROUPID = "PUBGROUPID";
    public static final String TAG_PUBGROUPNAME = "PUBGROUPNAME";

    public String getPUBITEMID() {
        return this.GetParamStringValue(TAG_PUBITEMID, "");
    }

    public void setPUBITEMID(String strValue) {
        this.SetParamValue(TAG_PUBITEMID, strValue);
    }

    public String getPUBITEMNAME() {
        return this.GetParamStringValue(TAG_PUBITEMNAME, "");
    }

    public void setPUBITEMNAME(String strValue) {
        this.SetParamValue(TAG_PUBITEMNAME, strValue);
    }

    public String getPUBITEMTYPE() {
        return this.GetParamStringValue(TAG_PUBITEMTYPE, "");
    }

    public void setPUBITEMTYPE(String strValue) {
        this.SetParamValue(TAG_PUBITEMTYPE, strValue);
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

    public String getPUBGROUPID() {
        return this.GetParamStringValue(TAG_PUBGROUPID, "");
    }

    public void setPUBGROUPID(String strValue) {
        this.SetParamValue(TAG_PUBGROUPID, strValue);
    }

    public String getPUBGROUPNAME() {
        return this.GetParamStringValue(TAG_PUBGROUPNAME, "");
    }

    public void setPUBGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PUBGROUPNAME, strValue);
    }
}

