/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSChannel
extends BaseDataEntity {
    public static final String TAG_WSCHANNELID = "WSCHANNELID";
    public static final String TAG_WSCHANNELNAME = "WSCHANNELNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WSWEBSITEID = "WSWEBSITEID";
    public static final String TAG_WSWEBSITENAME = "WSWEBSITENAME";
    public static final String TAG_PWSCHANNELID = "PWSCHANNELID";
    public static final String TAG_PWSCHANNELNAME = "PWSCHANNELNAME";
    public static final String TAG_ORDERNO = "ORDERNO";
    public static final String TAG_DEFAULTWSPAGEID = "DEFAULTWSPAGEID";
    public static final String TAG_DEFAULTWSPAGENAME = "DEFAULTWSPAGENAME";

    public boolean isWSCHANNELIDNull() {
        return this.IsParamNull(TAG_WSCHANNELID);
    }

    public String getWSCHANNELID() {
        return this.GetParamStringValue(TAG_WSCHANNELID, "");
    }

    public void setWSCHANNELID(String strValue) {
        this.SetParamValue(TAG_WSCHANNELID, strValue);
    }

    public boolean isWSCHANNELNAMENull() {
        return this.IsParamNull(TAG_WSCHANNELNAME);
    }

    public String getWSCHANNELNAME() {
        return this.GetParamStringValue(TAG_WSCHANNELNAME, "");
    }

    public void setWSCHANNELNAME(String strValue) {
        this.SetParamValue(TAG_WSCHANNELNAME, strValue);
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

    public boolean isWSWEBSITEIDNull() {
        return this.IsParamNull(TAG_WSWEBSITEID);
    }

    public String getWSWEBSITEID() {
        return this.GetParamStringValue(TAG_WSWEBSITEID, "");
    }

    public void setWSWEBSITEID(String strValue) {
        this.SetParamValue(TAG_WSWEBSITEID, strValue);
    }

    public boolean isWSWEBSITENAMENull() {
        return this.IsParamNull(TAG_WSWEBSITENAME);
    }

    public String getWSWEBSITENAME() {
        return this.GetParamStringValue(TAG_WSWEBSITENAME, "");
    }

    public void setWSWEBSITENAME(String strValue) {
        this.SetParamValue(TAG_WSWEBSITENAME, strValue);
    }

    public boolean isPWSCHANNELIDNull() {
        return this.IsParamNull(TAG_PWSCHANNELID);
    }

    public String getPWSCHANNELID() {
        return this.GetParamStringValue(TAG_PWSCHANNELID, "");
    }

    public void setPWSCHANNELID(String strValue) {
        this.SetParamValue(TAG_PWSCHANNELID, strValue);
    }

    public boolean isPWSCHANNELNAMENull() {
        return this.IsParamNull(TAG_PWSCHANNELNAME);
    }

    public String getPWSCHANNELNAME() {
        return this.GetParamStringValue(TAG_PWSCHANNELNAME, "");
    }

    public void setPWSCHANNELNAME(String strValue) {
        this.SetParamValue(TAG_PWSCHANNELNAME, strValue);
    }

    public boolean isORDERNONull() {
        return this.IsParamNull(TAG_ORDERNO);
    }

    public int getORDERNO() {
        return this.GetParamIntValue(TAG_ORDERNO, 0);
    }

    public void setORDERNO(int strValue) {
        this.SetParamValue(TAG_ORDERNO, strValue);
    }

    public boolean isDEFAULTWSPAGEIDNull() {
        return this.IsParamNull(TAG_DEFAULTWSPAGEID);
    }

    public String getDEFAULTWSPAGEID() {
        return this.GetParamStringValue(TAG_DEFAULTWSPAGEID, "");
    }

    public void setDEFAULTWSPAGEID(String strValue) {
        this.SetParamValue(TAG_DEFAULTWSPAGEID, strValue);
    }

    public boolean isDEFAULTWSPAGENAMENull() {
        return this.IsParamNull(TAG_DEFAULTWSPAGENAME);
    }

    public String getDEFAULTWSPAGENAME() {
        return this.GetParamStringValue(TAG_DEFAULTWSPAGENAME, "");
    }

    public void setDEFAULTWSPAGENAME(String strValue) {
        this.SetParamValue(TAG_DEFAULTWSPAGENAME, strValue);
    }
}

