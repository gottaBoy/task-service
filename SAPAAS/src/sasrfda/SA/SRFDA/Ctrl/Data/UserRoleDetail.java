/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UserRoleDetail
extends BaseDataEntity {
    public static final String TAG_USERROLEDETAILID = "USERROLEDETAILID";
    public static final String TAG_USERROLEDETAILNAME = "USERROLEDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERROLEID = "USERROLEID";
    public static final String TAG_UESRROLENAME = "UESRROLENAME";
    public static final String TAG_USEROBJECTID = "USEROBJECTID";
    public static final String TAG_USEROBJECTNAME = "USEROBJECTNAME";
    public static final String TAG_USERTAG = "USERTAG";

    public final boolean isUSERROLEDETAILIDNull() {
        return this.IsParamNull(TAG_USERROLEDETAILID);
    }

    public final String getUSERROLEDETAILID() {
        return this.GetParamStringValue(TAG_USERROLEDETAILID, "");
    }

    public final void setUSERROLEDETAILID(String strValue) {
        this.SetParamValue(TAG_USERROLEDETAILID, strValue);
    }

    public final boolean isUSERROLEDETAILNAMENull() {
        return this.IsParamNull(TAG_USERROLEDETAILNAME);
    }

    public final String getUSERROLEDETAILNAME() {
        return this.GetParamStringValue(TAG_USERROLEDETAILNAME, "");
    }

    public final void setUSERROLEDETAILNAME(String strValue) {
        this.SetParamValue(TAG_USERROLEDETAILNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isUSERROLEIDNull() {
        return this.IsParamNull(TAG_USERROLEID);
    }

    public final String getUSERROLEID() {
        return this.GetParamStringValue(TAG_USERROLEID, "");
    }

    public final void setUSERROLEID(String strValue) {
        this.SetParamValue(TAG_USERROLEID, strValue);
    }

    public final boolean isUESRROLENAMENull() {
        return this.IsParamNull(TAG_UESRROLENAME);
    }

    public final String getUESRROLENAME() {
        return this.GetParamStringValue(TAG_UESRROLENAME, "");
    }

    public final void setUESRROLENAME(String strValue) {
        this.SetParamValue(TAG_UESRROLENAME, strValue);
    }

    public final boolean isUSEROBJECTIDNull() {
        return this.IsParamNull(TAG_USEROBJECTID);
    }

    public final String getUSEROBJECTID() {
        return this.GetParamStringValue(TAG_USEROBJECTID, "");
    }

    public final void setUSEROBJECTID(String strValue) {
        this.SetParamValue(TAG_USEROBJECTID, strValue);
    }

    public final boolean isUSEROBJECTNAMENull() {
        return this.IsParamNull(TAG_USEROBJECTNAME);
    }

    public final String getUSEROBJECTNAME() {
        return this.GetParamStringValue(TAG_USEROBJECTNAME, "");
    }

    public final void setUSEROBJECTNAME(String strValue) {
        this.SetParamValue(TAG_USEROBJECTNAME, strValue);
    }

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }
}

