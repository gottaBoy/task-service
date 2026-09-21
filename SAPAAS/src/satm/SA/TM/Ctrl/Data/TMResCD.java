/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMResCD
extends BaseDataEntity {
    public static final String TAG_TMRESCDID = "TMRESCDID";
    public static final String TAG_TMRESCDNAME = "TMRESCDNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PRIORITY = "PRIORITY";
    public static final String TAG_TMRESCATALOGID = "TMRESCATALOGID";
    public static final String TAG_TMRESCATALOGNAME = "TMRESCATALOGNAME";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_TMRESBASENAME = "TMRESBASENAME";

    public boolean isTMRESCDIDNull() {
        return this.IsParamNull(TAG_TMRESCDID);
    }

    public String getTMRESCDID() {
        return this.GetParamStringValue(TAG_TMRESCDID, "");
    }

    public void setTMRESCDID(String strValue) {
        this.SetParamValue(TAG_TMRESCDID, strValue);
    }

    public boolean isTMRESCDNAMENull() {
        return this.IsParamNull(TAG_TMRESCDNAME);
    }

    public String getTMRESCDNAME() {
        return this.GetParamStringValue(TAG_TMRESCDNAME, "");
    }

    public void setTMRESCDNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCDNAME, strValue);
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

    public boolean isPRIORITYNull() {
        return this.IsParamNull(TAG_PRIORITY);
    }

    public int getPRIORITY() {
        return this.GetParamIntValue(TAG_PRIORITY, 0);
    }

    public void setPRIORITY(int strValue) {
        this.SetParamValue(TAG_PRIORITY, strValue);
    }

    public boolean isTMRESCATALOGIDNull() {
        return this.IsParamNull(TAG_TMRESCATALOGID);
    }

    public String getTMRESCATALOGID() {
        return this.GetParamStringValue(TAG_TMRESCATALOGID, "");
    }

    public void setTMRESCATALOGID(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGID, strValue);
    }

    public boolean isTMRESCATALOGNAMENull() {
        return this.IsParamNull(TAG_TMRESCATALOGNAME);
    }

    public String getTMRESCATALOGNAME() {
        return this.GetParamStringValue(TAG_TMRESCATALOGNAME, "");
    }

    public void setTMRESCATALOGNAME(String strValue) {
        this.SetParamValue(TAG_TMRESCATALOGNAME, strValue);
    }

    public boolean isTMRESBASEIDNull() {
        return this.IsParamNull(TAG_TMRESBASEID);
    }

    public String getTMRESBASEID() {
        return this.GetParamStringValue(TAG_TMRESBASEID, "");
    }

    public void setTMRESBASEID(String strValue) {
        this.SetParamValue(TAG_TMRESBASEID, strValue);
    }

    public boolean isTMRESBASENAMENull() {
        return this.IsParamNull(TAG_TMRESBASENAME);
    }

    public String getTMRESBASENAME() {
        return this.GetParamStringValue(TAG_TMRESBASENAME, "");
    }

    public void setTMRESBASENAME(String strValue) {
        this.SetParamValue(TAG_TMRESBASENAME, strValue);
    }
}

