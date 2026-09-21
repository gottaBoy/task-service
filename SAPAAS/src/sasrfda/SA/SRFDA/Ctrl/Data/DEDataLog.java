/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DEDataLog
extends BaseDataEntity {
    public static final String TAG_DEDATALOGID = "DEDATALOGID";
    public static final String TAG_DEDATALOGNAME = "DEDATALOGNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_NEWDATA = "NEWDATA";
    public static final String TAG_OLDDATA = "OLDDATA";
    public static final String TAG_EVENTTYPE = "EVENTTYPE";

    public String getDEDATALOGID() {
        return this.GetParamStringValue(TAG_DEDATALOGID, "");
    }

    public void setDEDATALOGID(String strValue) {
        this.SetParamValue(TAG_DEDATALOGID, strValue);
    }

    public String getDEDATALOGNAME() {
        return this.GetParamStringValue(TAG_DEDATALOGNAME, "");
    }

    public void setDEDATALOGNAME(String strValue) {
        this.SetParamValue(TAG_DEDATALOGNAME, strValue);
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

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getNEWDATA() {
        return this.GetParamStringValue(TAG_NEWDATA, "");
    }

    public void setNEWDATA(String strValue) {
        this.SetParamValue(TAG_NEWDATA, strValue);
    }

    public String getOLDDATA() {
        return this.GetParamStringValue(TAG_OLDDATA, "");
    }

    public void setOLDDATA(String strValue) {
        this.SetParamValue(TAG_OLDDATA, strValue);
    }

    public int getEVENTTYPE() {
        return this.GetParamIntValue(TAG_EVENTTYPE, 0);
    }

    public void setEVENTTYPE(int strValue) {
        this.SetParamValue(TAG_EVENTTYPE, strValue);
    }
}

