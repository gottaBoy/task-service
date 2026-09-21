/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICatalogRole
extends BaseDataEntity {
    public static final String TAG_BICATALOGROLEID = "BICATALOGROLEID";
    public static final String TAG_BICATALOGROLENAME = "BICATALOGROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICATALOGID = "BICATALOGID";
    public static final String TAG_BICATALOGNAME = "BICATALOGNAME";
    public static final String TAG_BIUSERROLEID = "BIUSERROLEID";
    public static final String TAG_BIUSERROLENAME = "BIUSERROLENAME";
    public static final String TAG_DEFAULTACCESS = "DEFAULTACCESS";

    public String getBICATALOGROLEID() {
        return this.GetParamStringValue(TAG_BICATALOGROLEID, "");
    }

    public void setBICATALOGROLEID(String strValue) {
        this.SetParamValue(TAG_BICATALOGROLEID, strValue);
    }

    public String getBICATALOGROLENAME() {
        return this.GetParamStringValue(TAG_BICATALOGROLENAME, "");
    }

    public void setBICATALOGROLENAME(String strValue) {
        this.SetParamValue(TAG_BICATALOGROLENAME, strValue);
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

    public String getBICATALOGID() {
        return this.GetParamStringValue(TAG_BICATALOGID, "");
    }

    public void setBICATALOGID(String strValue) {
        this.SetParamValue(TAG_BICATALOGID, strValue);
    }

    public String getBICATALOGNAME() {
        return this.GetParamStringValue(TAG_BICATALOGNAME, "");
    }

    public void setBICATALOGNAME(String strValue) {
        this.SetParamValue(TAG_BICATALOGNAME, strValue);
    }

    public String getBIUSERROLEID() {
        return this.GetParamStringValue(TAG_BIUSERROLEID, "");
    }

    public void setBIUSERROLEID(String strValue) {
        this.SetParamValue(TAG_BIUSERROLEID, strValue);
    }

    public String getBIUSERROLENAME() {
        return this.GetParamStringValue(TAG_BIUSERROLENAME, "");
    }

    public void setBIUSERROLENAME(String strValue) {
        this.SetParamValue(TAG_BIUSERROLENAME, strValue);
    }

    public String getDEFAULTACCESS() {
        return this.GetParamStringValue(TAG_DEFAULTACCESS, "");
    }

    public void setDEFAULTACCESS(String strValue) {
        this.SetParamValue(TAG_DEFAULTACCESS, strValue);
    }
}

