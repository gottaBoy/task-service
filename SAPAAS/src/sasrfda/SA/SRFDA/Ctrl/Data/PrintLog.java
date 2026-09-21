/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PrintLog
extends BaseDataEntity {
    public static final String TAG_PRINTLOGID = "PRINTLOGID";
    public static final String TAG_PRINTLOGNAME = "PRINTLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PRINTFORMID = "PRINTFORMID";
    public static final String TAG_PRINTFORMNAME = "PRINTFORMNAME";
    public static final String TAG_FORMDATA = "FORMDATA";

    public boolean isPRINTLOGIDNull() {
        return this.IsParamNull(TAG_PRINTLOGID);
    }

    public String getPRINTLOGID() {
        return this.GetParamStringValue(TAG_PRINTLOGID, "");
    }

    public void setPRINTLOGID(String strValue) {
        this.SetParamValue(TAG_PRINTLOGID, strValue);
    }

    public boolean isPRINTLOGNAMENull() {
        return this.IsParamNull(TAG_PRINTLOGNAME);
    }

    public String getPRINTLOGNAME() {
        return this.GetParamStringValue(TAG_PRINTLOGNAME, "");
    }

    public void setPRINTLOGNAME(String strValue) {
        this.SetParamValue(TAG_PRINTLOGNAME, strValue);
    }

    public boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public boolean isPRINTFORMIDNull() {
        return this.IsParamNull(TAG_PRINTFORMID);
    }

    public String getPRINTFORMID() {
        return this.GetParamStringValue(TAG_PRINTFORMID, "");
    }

    public void setPRINTFORMID(String strValue) {
        this.SetParamValue(TAG_PRINTFORMID, strValue);
    }

    public boolean isPRINTFORMNAMENull() {
        return this.IsParamNull(TAG_PRINTFORMNAME);
    }

    public String getPRINTFORMNAME() {
        return this.GetParamStringValue(TAG_PRINTFORMNAME, "");
    }

    public void setPRINTFORMNAME(String strValue) {
        this.SetParamValue(TAG_PRINTFORMNAME, strValue);
    }

    public boolean isFORMDATANull() {
        return this.IsParamNull(TAG_FORMDATA);
    }

    public String getFORMDATA() {
        return this.GetParamStringValue(TAG_FORMDATA, "");
    }

    public void setFORMDATA(String strValue) {
        this.SetParamValue(TAG_FORMDATA, strValue);
    }
}

