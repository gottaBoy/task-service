/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.WS.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class WSPageWB
extends BaseDataEntity {
    public static final String TAG_WSPAGEWBID = "WSPAGEWBID";
    public static final String TAG_WSPAGEWBNAME = "WSPAGEWBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_WSPAGEID = "WSPAGEID";
    public static final String TAG_WSPAGENAME = "WSPAGENAME";
    public static final String TAG_WSWEBPARTID = "WSWEBPARTID";
    public static final String TAG_WSWEBPARTNAME = "WSWEBPARTNAME";

    public boolean isWSPAGEWBIDNull() {
        return this.IsParamNull(TAG_WSPAGEWBID);
    }

    public String getWSPAGEWBID() {
        return this.GetParamStringValue(TAG_WSPAGEWBID, "");
    }

    public void setWSPAGEWBID(String strValue) {
        this.SetParamValue(TAG_WSPAGEWBID, strValue);
    }

    public boolean isWSPAGEWBNAMENull() {
        return this.IsParamNull(TAG_WSPAGEWBNAME);
    }

    public String getWSPAGEWBNAME() {
        return this.GetParamStringValue(TAG_WSPAGEWBNAME, "");
    }

    public void setWSPAGEWBNAME(String strValue) {
        this.SetParamValue(TAG_WSPAGEWBNAME, strValue);
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

    public boolean isWSPAGEIDNull() {
        return this.IsParamNull(TAG_WSPAGEID);
    }

    public String getWSPAGEID() {
        return this.GetParamStringValue(TAG_WSPAGEID, "");
    }

    public void setWSPAGEID(String strValue) {
        this.SetParamValue(TAG_WSPAGEID, strValue);
    }

    public boolean isWSPAGENAMENull() {
        return this.IsParamNull(TAG_WSPAGENAME);
    }

    public String getWSPAGENAME() {
        return this.GetParamStringValue(TAG_WSPAGENAME, "");
    }

    public void setWSPAGENAME(String strValue) {
        this.SetParamValue(TAG_WSPAGENAME, strValue);
    }

    public boolean isWSWEBPARTIDNull() {
        return this.IsParamNull(TAG_WSWEBPARTID);
    }

    public String getWSWEBPARTID() {
        return this.GetParamStringValue(TAG_WSWEBPARTID, "");
    }

    public void setWSWEBPARTID(String strValue) {
        this.SetParamValue(TAG_WSWEBPARTID, strValue);
    }

    public boolean isWSWEBPARTNAMENull() {
        return this.IsParamNull(TAG_WSWEBPARTNAME);
    }

    public String getWSWEBPARTNAME() {
        return this.GetParamStringValue(TAG_WSWEBPARTNAME, "");
    }

    public void setWSWEBPARTNAME(String strValue) {
        this.SetParamValue(TAG_WSWEBPARTNAME, strValue);
    }
}

