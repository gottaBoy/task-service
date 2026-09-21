/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class OnlineUser
extends BaseDataEntity {
    public static final String TAG_ONLINEUSERID = "ONLINEUSERID";
    public static final String TAG_ONLINEUSERNAME = "ONLINEUSERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_USERID = "USERID";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_LOGINTIME = "LOGINTIME";
    public static final String TAG_IPADDRESS = "IPADDRESS";
    public static final String TAG_SERVERID = "SERVERID";

    public String getONLINEUSERID() {
        return this.GetParamStringValue(TAG_ONLINEUSERID, "");
    }

    public void setONLINEUSERID(String strValue) {
        this.SetParamValue(TAG_ONLINEUSERID, strValue);
    }

    public String getONLINEUSERNAME() {
        return this.GetParamStringValue(TAG_ONLINEUSERNAME, "");
    }

    public void setONLINEUSERNAME(String strValue) {
        this.SetParamValue(TAG_ONLINEUSERNAME, strValue);
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

    public Date getLOGINTIME() {
        return this.GetParamDateValue(TAG_LOGINTIME, null);
    }

    public void setLOGINTIME(Date strValue) {
        this.SetParamValue(TAG_LOGINTIME, strValue);
    }

    public String getIPADDRESS() {
        return this.GetParamStringValue(TAG_IPADDRESS, "");
    }

    public void setIPADDRESS(String strValue) {
        this.SetParamValue(TAG_IPADDRESS, strValue);
    }

    public String getSERVERID() {
        return this.GetParamStringValue(TAG_SERVERID, "");
    }

    public void setSERVERID(String strValue) {
        this.SetParamValue(TAG_SERVERID, strValue);
    }
}

