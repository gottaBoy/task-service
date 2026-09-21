/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACPolicyDetail
extends BaseDataEntity {
    public static final String TAG_UACPOLICYDETAILID = "UACPOLICYDETAILID";
    public static final String TAG_UACPOLICYDETAILNAME = "UACPOLICYDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ISENABLE = "ISENABLE";
    public static final String TAG_AUTHORDER = "AUTHORDER";
    public static final String TAG_UACAUTHINTNAME = "UACAUTHINTNAME";
    public static final String TAG_UACPOLICYNAME = "UACPOLICYNAME";
    public static final String TAG_UACAUTHINTID = "UACAUTHINTID";
    public static final String TAG_UACPOLICYID = "UACPOLICYID";

    public String getUACPOLICYDETAILID() {
        return this.GetParamStringValue(TAG_UACPOLICYDETAILID, "");
    }

    public void setUACPOLICYDETAILID(String strValue) {
        this.SetParamValue(TAG_UACPOLICYDETAILID, strValue);
    }

    public String getUACPOLICYDETAILNAME() {
        return this.GetParamStringValue(TAG_UACPOLICYDETAILNAME, "");
    }

    public void setUACPOLICYDETAILNAME(String strValue) {
        this.SetParamValue(TAG_UACPOLICYDETAILNAME, strValue);
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

    public boolean getISENABLE() {
        return this.GetParamIntValue(TAG_ISENABLE, 0) == 1;
    }

    public void setISENABLE(boolean bValue) {
        this.SetParamValue(TAG_ISENABLE, bValue ? 1 : 0);
    }

    public int getAUTHORDER() {
        return this.GetParamIntValue(TAG_AUTHORDER, 0);
    }

    public void setAUTHORDER(int strValue) {
        this.SetParamValue(TAG_AUTHORDER, strValue);
    }

    public String getUACAUTHINTNAME() {
        return this.GetParamStringValue(TAG_UACAUTHINTNAME, "");
    }

    public void setUACAUTHINTNAME(String strValue) {
        this.SetParamValue(TAG_UACAUTHINTNAME, strValue);
    }

    public String getUACPOLICYNAME() {
        return this.GetParamStringValue(TAG_UACPOLICYNAME, "");
    }

    public void setUACPOLICYNAME(String strValue) {
        this.SetParamValue(TAG_UACPOLICYNAME, strValue);
    }

    public String getUACAUTHINTID() {
        return this.GetParamStringValue(TAG_UACAUTHINTID, "");
    }

    public void setUACAUTHINTID(String strValue) {
        this.SetParamValue(TAG_UACAUTHINTID, strValue);
    }

    public String getUACPOLICYID() {
        return this.GetParamStringValue(TAG_UACPOLICYID, "");
    }

    public void setUACPOLICYID(String strValue) {
        this.SetParamValue(TAG_UACPOLICYID, strValue);
    }
}

