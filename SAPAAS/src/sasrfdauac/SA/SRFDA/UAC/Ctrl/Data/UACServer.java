/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.UAC.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class UACServer
extends BaseDataEntity {
    public static final String TAG_UACSERVERID = "UACSERVERID";
    public static final String TAG_UACSERVERNAME = "UACSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_SERVERURL = "SERVERURL";
    public static final String TAG_IPADDRESS = "IPADDRESS";
    public static final String TAG_OSTYPE = "OSTYPE";
    public static final String TAG_SERVERPARAM = "SERVERPARAM";
    public static final String TAG_UACPOLICYNAME = "UACPOLICYNAME";
    public static final String TAG_UACPOLICYID = "UACPOLICYID";

    public String getUACSERVERID() {
        return this.GetParamStringValue(TAG_UACSERVERID, "");
    }

    public void setUACSERVERID(String strValue) {
        this.SetParamValue(TAG_UACSERVERID, strValue);
    }

    public String getUACSERVERNAME() {
        return this.GetParamStringValue(TAG_UACSERVERNAME, "");
    }

    public void setUACSERVERNAME(String strValue) {
        this.SetParamValue(TAG_UACSERVERNAME, strValue);
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

    public String getSERVERURL() {
        return this.GetParamStringValue(TAG_SERVERURL, "");
    }

    public void setSERVERURL(String strValue) {
        this.SetParamValue(TAG_SERVERURL, strValue);
    }

    public String getIPADDRESS() {
        return this.GetParamStringValue(TAG_IPADDRESS, "");
    }

    public void setIPADDRESS(String strValue) {
        this.SetParamValue(TAG_IPADDRESS, strValue);
    }

    public String getOSTYPE() {
        return this.GetParamStringValue(TAG_OSTYPE, "");
    }

    public void setOSTYPE(String strValue) {
        this.SetParamValue(TAG_OSTYPE, strValue);
    }

    public String getSERVERPARAM() {
        return this.GetParamStringValue(TAG_SERVERPARAM, "");
    }

    public void setSERVERPARAM(String strValue) {
        this.SetParamValue(TAG_SERVERPARAM, strValue);
    }

    public String getUACPOLICYNAME() {
        return this.GetParamStringValue(TAG_UACPOLICYNAME, "");
    }

    public void setUACPOLICYNAME(String strValue) {
        this.SetParamValue(TAG_UACPOLICYNAME, strValue);
    }

    public String getUACPOLICYID() {
        return this.GetParamStringValue(TAG_UACPOLICYID, "");
    }

    public void setUACPOLICYID(String strValue) {
        this.SetParamValue(TAG_UACPOLICYID, strValue);
    }
}

