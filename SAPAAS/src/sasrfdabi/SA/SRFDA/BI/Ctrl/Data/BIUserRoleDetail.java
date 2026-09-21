/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIUserRoleDetail
extends BaseDataEntity {
    public static final String TAG_BIUSERROLEDETAILID = "BIUSERROLEDETAILID";
    public static final String TAG_BIUSERROLEDETAILNAME = "BIUSERROLEDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIUSERROLEID = "BIUSERROLEID";
    public static final String TAG_BIUSERROLENAME = "BIUSERROLENAME";
    public static final String TAG_USERID = "USERID";
    public static final String TAG_USERNAME = "USERNAME";

    public String getBIUSERROLEDETAILID() {
        return this.GetParamStringValue(TAG_BIUSERROLEDETAILID, "");
    }

    public void setBIUSERROLEDETAILID(String strValue) {
        this.SetParamValue(TAG_BIUSERROLEDETAILID, strValue);
    }

    public String getBIUSERROLEDETAILNAME() {
        return this.GetParamStringValue(TAG_BIUSERROLEDETAILNAME, "");
    }

    public void setBIUSERROLEDETAILNAME(String strValue) {
        this.SetParamValue(TAG_BIUSERROLEDETAILNAME, strValue);
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

    public String getBIUSERROLEID() {
        return this.GetParamStringValue(TAG_BIUSERROLEID, "");
    }

    public void setBIUSERROLEID(String strValue) {
        this.SetParamValue(TAG_BIUSERROLEID, strValue);
    }

    public String getBIUSERROLENAME() {
        return this.GetParamStringValue(TAG_BIUSERROLENAME, "");
    }

    public void setBIUSERROLENAME(String strValue) {
        this.SetParamValue(TAG_BIUSERROLENAME, strValue);
    }

    public String getUSERID() {
        return this.GetParamStringValue(TAG_USERID, "");
    }

    public void setUSERID(String strValue) {
        this.SetParamValue(TAG_USERID, strValue);
    }

    public String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }
}

