/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSWPNavBar
extends BaseDataEntity {
    public static final String TAG_WSWPNAVBARID = "WSWPNAVBARID";
    public static final String TAG_WSWPNAVBARNAME = "WSWPNAVBARNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WSCHANNELNAME = "WSCHANNELNAME";
    public static final String TAG_WSCHANNELID = "WSCHANNELID";
    public static final String TAG_WSWEBSITEID = "WSWEBSITEID";
    public static final String TAG_WSWEBSITENAME = "WSWEBSITENAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_WSWBTYPEID = "WSWBTYPEID";
    public static final String TAG_WSWBTYPENAME = "WSWBTYPENAME";
    public static final String TAG_ISSHOWSUBNAVBAR = "ISSHOWSUBNAVBAR";

    public boolean isWSWPNAVBARIDNull() {
        return this.IsParamNull(TAG_WSWPNAVBARID);
    }

    public String getWSWPNAVBARID() {
        return this.GetParamStringValue(TAG_WSWPNAVBARID, "");
    }

    public void setWSWPNAVBARID(String strValue) {
        this.SetParamValue(TAG_WSWPNAVBARID, strValue);
    }

    public boolean isWSWPNAVBARNAMENull() {
        return this.IsParamNull(TAG_WSWPNAVBARNAME);
    }

    public String getWSWPNAVBARNAME() {
        return this.GetParamStringValue(TAG_WSWPNAVBARNAME, "");
    }

    public void setWSWPNAVBARNAME(String strValue) {
        this.SetParamValue(TAG_WSWPNAVBARNAME, strValue);
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

    public boolean isWSCHANNELNAMENull() {
        return this.IsParamNull(TAG_WSCHANNELNAME);
    }

    public String getWSCHANNELNAME() {
        return this.GetParamStringValue(TAG_WSCHANNELNAME, "");
    }

    public void setWSCHANNELNAME(String strValue) {
        this.SetParamValue(TAG_WSCHANNELNAME, strValue);
    }

    public boolean isWSCHANNELIDNull() {
        return this.IsParamNull(TAG_WSCHANNELID);
    }

    public String getWSCHANNELID() {
        return this.GetParamStringValue(TAG_WSCHANNELID, "");
    }

    public void setWSCHANNELID(String strValue) {
        this.SetParamValue(TAG_WSCHANNELID, strValue);
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

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isWSWBTYPEIDNull() {
        return this.IsParamNull(TAG_WSWBTYPEID);
    }

    public String getWSWBTYPEID() {
        return this.GetParamStringValue(TAG_WSWBTYPEID, "");
    }

    public void setWSWBTYPEID(String strValue) {
        this.SetParamValue(TAG_WSWBTYPEID, strValue);
    }

    public boolean isWSWBTYPENAMENull() {
        return this.IsParamNull(TAG_WSWBTYPENAME);
    }

    public String getWSWBTYPENAME() {
        return this.GetParamStringValue(TAG_WSWBTYPENAME, "");
    }

    public void setWSWBTYPENAME(String strValue) {
        this.SetParamValue(TAG_WSWBTYPENAME, strValue);
    }

    public boolean isISSHOWSUBNAVBARNull() {
        return this.IsParamNull(TAG_ISSHOWSUBNAVBAR);
    }

    public boolean getISSHOWSUBNAVBAR() {
        return this.GetParamIntValue(TAG_ISSHOWSUBNAVBAR, 0) == 1;
    }

    public void setISSHOWSUBNAVBAR(boolean bValue) {
        this.SetParamValue(TAG_ISSHOWSUBNAVBAR, bValue ? 1 : 0);
    }
}

