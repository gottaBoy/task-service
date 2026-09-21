/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class IgnorePatch
extends BaseDataEntity {
    public static final String TAG_IGNOREPATCHID = "IGNOREPATCHID";
    public static final String TAG_IGNOREPATCHNAME = "IGNOREPATCHNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DATAKEY = "DATAKEY";
    public static final String TAG_IGNOREFIELDS = "IGNOREFIELDS";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isIGNOREPATCHIDNull() {
        return this.IsParamNull(TAG_IGNOREPATCHID);
    }

    public String getIGNOREPATCHID() {
        return this.GetParamStringValue(TAG_IGNOREPATCHID, "");
    }

    public void setIGNOREPATCHID(String strValue) {
        this.SetParamValue(TAG_IGNOREPATCHID, strValue);
    }

    public boolean isIGNOREPATCHNAMENull() {
        return this.IsParamNull(TAG_IGNOREPATCHNAME);
    }

    public String getIGNOREPATCHNAME() {
        return this.GetParamStringValue(TAG_IGNOREPATCHNAME, "");
    }

    public void setIGNOREPATCHNAME(String strValue) {
        this.SetParamValue(TAG_IGNOREPATCHNAME, strValue);
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

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public boolean isDATAKEYNull() {
        return this.IsParamNull(TAG_DATAKEY);
    }

    public String getDATAKEY() {
        return this.GetParamStringValue(TAG_DATAKEY, "");
    }

    public void setDATAKEY(String strValue) {
        this.SetParamValue(TAG_DATAKEY, strValue);
    }

    public boolean isIGNOREFIELDSNull() {
        return this.IsParamNull(TAG_IGNOREFIELDS);
    }

    public String getIGNOREFIELDS() {
        return this.GetParamStringValue(TAG_IGNOREFIELDS, "");
    }

    public void setIGNOREFIELDS(String strValue) {
        this.SetParamValue(TAG_IGNOREFIELDS, strValue);
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
}

