/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACAuthInt
extends BaseDataEntity {
    public static final String TAG_UACAUTHINTID = "UACAUTHINTID";
    public static final String TAG_UACAUTHINTNAME = "UACAUTHINTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_AUTHINTTYPE = "AUTHINTTYPE";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_UACDATASOURCENAME = "UACDATASOURCENAME";
    public static final String TAG_UACDATASOURCEID = "UACDATASOURCEID";

    public String getUACAUTHINTID() {
        return this.GetParamStringValue(TAG_UACAUTHINTID, "");
    }

    public void setUACAUTHINTID(String strValue) {
        this.SetParamValue(TAG_UACAUTHINTID, strValue);
    }

    public String getUACAUTHINTNAME() {
        return this.GetParamStringValue(TAG_UACAUTHINTNAME, "");
    }

    public void setUACAUTHINTNAME(String strValue) {
        this.SetParamValue(TAG_UACAUTHINTNAME, strValue);
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

    public String getAUTHINTTYPE() {
        return this.GetParamStringValue(TAG_AUTHINTTYPE, "");
    }

    public void setAUTHINTTYPE(String strValue) {
        this.SetParamValue(TAG_AUTHINTTYPE, strValue);
    }

    public String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public String getPARAM5() {
        return this.GetParamStringValue(TAG_PARAM5, "");
    }

    public void setPARAM5(String strValue) {
        this.SetParamValue(TAG_PARAM5, strValue);
    }

    public String getPARAM6() {
        return this.GetParamStringValue(TAG_PARAM6, "");
    }

    public void setPARAM6(String strValue) {
        this.SetParamValue(TAG_PARAM6, strValue);
    }

    public int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public void setPARAM7(int nValue) {
        this.SetParamValue(TAG_PARAM7, nValue);
    }

    public int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public void setPARAM8(int nValue) {
        this.SetParamValue(TAG_PARAM8, nValue);
    }

    public String getUACDATASOURCENAME() {
        return this.GetParamStringValue(TAG_UACDATASOURCENAME, "");
    }

    public void setUACDATASOURCENAME(String strValue) {
        this.SetParamValue(TAG_UACDATASOURCENAME, strValue);
    }

    public String getUACDATASOURCEID() {
        return this.GetParamStringValue(TAG_UACDATASOURCEID, "");
    }

    public void setUACDATASOURCEID(String strValue) {
        this.SetParamValue(TAG_UACDATASOURCEID, strValue);
    }
}

