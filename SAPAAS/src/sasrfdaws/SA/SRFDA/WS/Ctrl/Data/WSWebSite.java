/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSWebSite
extends BaseDataEntity {
    public static final String TAG_WSWEBSITEID = "WSWEBSITEID";
    public static final String TAG_WSWEBSITENAME = "WSWEBSITENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WSPATH = "WSPATH";
    public static final String TAG_VERSION = "VERSION";

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

    public String getWSPath() {
        return this.GetParamStringValue(TAG_WSPATH, "");
    }

    public void setWSPath(String strValue) {
        this.SetParamValue(TAG_WSPATH, strValue);
    }

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }
}

