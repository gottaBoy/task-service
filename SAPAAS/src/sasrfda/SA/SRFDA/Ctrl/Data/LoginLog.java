/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LoginLog
extends BaseDataEntity {
    public static final String TAG_LOGINLOGID = "LOGINLOGID";
    public static final String TAG_LOGINLOGNAME = "LOGINLOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LOGINACCOUNTID = "LOGINACCOUNTID";
    public static final String TAG_LOGINACCOUNTNAME = "LOGINACCOUNTNAME";
    public static final String TAG_LOGINTIME = "LOGINTIME";
    public static final String TAG_LOGOUTTIME = "LOGOUTTIME";
    public static final String TAG_IPADDRESS = "IPADDRESS";
    public static final String TAG_SERVERADDR = "SERVERADDR";

    public String getLOGINLOGID() {
        return this.GetParamStringValue(TAG_LOGINLOGID, "");
    }

    public void setLOGINLOGID(String strValue) {
        this.SetParamValue(TAG_LOGINLOGID, strValue);
    }

    public String getLOGINLOGNAME() {
        return this.GetParamStringValue(TAG_LOGINLOGNAME, "");
    }

    public void setLOGINLOGNAME(String strValue) {
        this.SetParamValue(TAG_LOGINLOGNAME, strValue);
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

    public String getLOGINACCOUNTID() {
        return this.GetParamStringValue(TAG_LOGINACCOUNTID, "");
    }

    public void setLOGINACCOUNTID(String strValue) {
        this.SetParamValue(TAG_LOGINACCOUNTID, strValue);
    }

    public String getLOGINACCOUNTNAME() {
        return this.GetParamStringValue(TAG_LOGINACCOUNTNAME, "");
    }

    public void setLOGINACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_LOGINACCOUNTNAME, strValue);
    }

    public Date getLOGINTIME() {
        return this.GetParamDateValue(TAG_LOGINTIME, null);
    }

    public void setLOGINTIME(Date strValue) {
        this.SetParamValue(TAG_LOGINTIME, strValue);
    }

    public Date getLOGOUTTIME() {
        return this.GetParamDateValue(TAG_LOGOUTTIME, null);
    }

    public void setLOGOUTTIME(Date strValue) {
        this.SetParamValue(TAG_LOGOUTTIME, strValue);
    }

    public String getIPADDRESS() {
        return this.GetParamStringValue(TAG_IPADDRESS, "");
    }

    public void setIPADDRESS(String strValue) {
        this.SetParamValue(TAG_IPADDRESS, strValue);
    }

    public String getSERVERADDR() {
        return this.GetParamStringValue(TAG_SERVERADDR, "");
    }

    public void setSERVERADDR(String strValue) {
        this.SetParamValue(TAG_SERVERADDR, strValue);
    }
}

