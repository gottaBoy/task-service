/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSRuntime
extends BaseDataEntity {
    public static final String TAG_WSRUNTIMEID = "WSRUNTIMEID";
    public static final String TAG_WSRUNTIMENAME = "WSRUNTIMENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WSWEBSITEID = "WSWEBSITEID";
    public static final String TAG_WSWEBSITENAME = "WSWEBSITENAME";
    public static final String TAG_RTTYPE = "RTTYPE";
    public static final String TAG_RTPATH = "RTPATH";

    public boolean isWSRUNTIMEIDNull() {
        return this.IsParamNull(TAG_WSRUNTIMEID);
    }

    public String getWSRUNTIMEID() {
        return this.GetParamStringValue(TAG_WSRUNTIMEID, "");
    }

    public void setWSRUNTIMEID(String strValue) {
        this.SetParamValue(TAG_WSRUNTIMEID, strValue);
    }

    public boolean isWSRUNTIMENAMENull() {
        return this.IsParamNull(TAG_WSRUNTIMENAME);
    }

    public String getWSRUNTIMENAME() {
        return this.GetParamStringValue(TAG_WSRUNTIMENAME, "");
    }

    public void setWSRUNTIMENAME(String strValue) {
        this.SetParamValue(TAG_WSRUNTIMENAME, strValue);
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

    public boolean isRTTYPENull() {
        return this.IsParamNull(TAG_RTTYPE);
    }

    public String getRTTYPE() {
        return this.GetParamStringValue(TAG_RTTYPE, "");
    }

    public void setRTTYPE(String strValue) {
        this.SetParamValue(TAG_RTTYPE, strValue);
    }

    public boolean isRTPATHNull() {
        return this.IsParamNull(TAG_RTPATH);
    }

    public String getRTPATH() {
        return this.GetParamStringValue(TAG_RTPATH, "");
    }

    public void setRTPATH(String strValue) {
        this.SetParamValue(TAG_RTPATH, strValue);
    }
}

