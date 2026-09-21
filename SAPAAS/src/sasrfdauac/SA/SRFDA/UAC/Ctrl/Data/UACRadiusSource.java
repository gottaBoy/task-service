/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACRadiusSource
extends BaseDataEntity {
    public static final String AUTHENTICATOR_PAP = "PAP";
    public static final String AUTHENTICATOR_CHAP = "CHAP";
    public static final String AUTHENTICATOR_EAP = "EAP";
    public static final String AUTHENTICATOR_EAPMD5 = "EAPMD5";
    public static final String AUTHENTICATOR_EAPMSCHAPv2 = "EAPMSCHAPv2";
    public static final String AUTHENTICATOR_EAPTLS = "EAPTLS";
    public static final String AUTHENTICATOR_EAPTTLS = "EAPTTLS";
    public static final String AUTHENTICATOR_MSCHAPv1 = "MSCHAPv1";
    public static final String AUTHENTICATOR_MSCHAPv2 = "MSCHAPv2";
    public static final String TAG_UACRADIUSSOURCEID = "UACRADIUSSOURCEID";
    public static final String TAG_UACRADIUSSOURCENAME = "UACRADIUSSOURCENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RADIUSSERVER = "RADIUSSERVER";
    public static final String TAG_AUTHPORT = "AUTHPORT";
    public static final String TAG_ACCOPORT = "ACCOPORT";
    public static final String TAG_TIMEOUT = "TIMEOUT";
    public static final String TAG_RETRYCOUNT = "RETRYCOUNT";
    public static final String TAG_AUTHENTICATOR = "AUTHENTICATOR";
    public static final String TAG_SHAREDSECRET = "SHAREDSECRET";

    public String getUACRADIUSSOURCEID() {
        return this.GetParamStringValue(TAG_UACRADIUSSOURCEID, "");
    }

    public void setUACRADIUSSOURCEID(String strValue) {
        this.SetParamValue(TAG_UACRADIUSSOURCEID, strValue);
    }

    public String getUACRADIUSSOURCENAME() {
        return this.GetParamStringValue(TAG_UACRADIUSSOURCENAME, "");
    }

    public void setUACRADIUSSOURCENAME(String strValue) {
        this.SetParamValue(TAG_UACRADIUSSOURCENAME, strValue);
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

    public String getRADIUSSERVER() {
        return this.GetParamStringValue(TAG_RADIUSSERVER, "");
    }

    public void setRADIUSSERVER(String strValue) {
        this.SetParamValue(TAG_RADIUSSERVER, strValue);
    }

    public int getAUTHPORT() {
        return this.GetParamIntValue(TAG_AUTHPORT, 0);
    }

    public void setAUTHPORT(int strValue) {
        this.SetParamValue(TAG_AUTHPORT, strValue);
    }

    public int getACCOPORT() {
        return this.GetParamIntValue(TAG_ACCOPORT, 0);
    }

    public void setACCOPORT(int strValue) {
        this.SetParamValue(TAG_ACCOPORT, strValue);
    }

    public int getTIMEOUT() {
        return this.GetParamIntValue(TAG_TIMEOUT, 0);
    }

    public void setTIMEOUT(int strValue) {
        this.SetParamValue(TAG_TIMEOUT, strValue);
    }

    public int getRETRYCOUNT() {
        return this.GetParamIntValue(TAG_RETRYCOUNT, 0);
    }

    public void setRETRYCOUNT(int strValue) {
        this.SetParamValue(TAG_RETRYCOUNT, strValue);
    }

    public String getAUTHENTICATOR() {
        return this.GetParamStringValue(TAG_AUTHENTICATOR, "");
    }

    public void setAUTHENTICATOR(String strValue) {
        this.SetParamValue(TAG_AUTHENTICATOR, strValue);
    }

    public String getSHAREDSECRET() {
        return this.GetParamStringValue(TAG_SHAREDSECRET, "");
    }

    public void setSHAREDSECRET(String strValue) {
        this.SetParamValue(TAG_SHAREDSECRET, strValue);
    }
}

