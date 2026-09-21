/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PODBQuery
extends BaseDataEntity {
    public static final String TAG_PODBQUERYID = "PODBQUERYID";
    public static final String TAG_PODBQUERYNAME = "PODBQUERYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PROCESSTIME = "PROCESSTIME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_QUERYSQL = "QUERYSQL";
    public static final String TAG_PERSONID = "PERSONID";
    public static final String TAG_QUERYKEY = "QUERYKEY";
    public static final String TAG_PROCESSDATE = "PROCESSDATE";

    public String getPODBQUERYID() {
        return this.GetParamStringValue(TAG_PODBQUERYID, "");
    }

    public void setPODBQUERYID(String strValue) {
        this.SetParamValue(TAG_PODBQUERYID, strValue);
    }

    public String getPODBQUERYNAME() {
        return this.GetParamStringValue(TAG_PODBQUERYNAME, "");
    }

    public void setPODBQUERYNAME(String strValue) {
        this.SetParamValue(TAG_PODBQUERYNAME, strValue);
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

    public int getPROCESSTIME() {
        return this.GetParamIntValue(TAG_PROCESSTIME, 0);
    }

    public void setPROCESSTIME(int strValue) {
        this.SetParamValue(TAG_PROCESSTIME, strValue);
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

    public String getQUERYSQL() {
        return this.GetParamStringValue(TAG_QUERYSQL, "");
    }

    public void setQUERYSQL(String strValue) {
        this.SetParamValue(TAG_QUERYSQL, strValue);
    }

    public String getPERSONID() {
        return this.GetParamStringValue(TAG_PERSONID, "");
    }

    public void setPERSONID(String strValue) {
        this.SetParamValue(TAG_PERSONID, strValue);
    }

    public String getQUERYKEY() {
        return this.GetParamStringValue(TAG_QUERYKEY, "");
    }

    public void setQUERYKEY(String strValue) {
        this.SetParamValue(TAG_QUERYKEY, strValue);
    }

    public Date getPROCESSDATE() {
        return this.GetParamDateValue(TAG_PROCESSDATE, null);
    }

    public void setPROCESSDATE(Date strValue) {
        this.SetParamValue(TAG_PROCESSDATE, strValue);
    }
}

