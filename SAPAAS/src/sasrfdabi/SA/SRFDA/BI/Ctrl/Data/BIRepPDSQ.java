/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPDSQ
extends BaseDataEntity {
    public static final String TAG_BIREPPDSQID = "BIREPPDSQID";
    public static final String TAG_BIREPPDSQNAME = "BIREPPDSQNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPPDSID = "BIREPPDSID";
    public static final String TAG_BIREPPDSNAME = "BIREPPDSNAME";
    public static final String TAG_BIREPPQID = "BIREPPQID";
    public static final String TAG_BIREPPQNAME = "BIREPPQNAME";

    public boolean isBIREPPDSQIDNull() {
        return this.IsParamNull(TAG_BIREPPDSQID);
    }

    public String getBIREPPDSQID() {
        return this.GetParamStringValue(TAG_BIREPPDSQID, "");
    }

    public void setBIREPPDSQID(String strValue) {
        this.SetParamValue(TAG_BIREPPDSQID, strValue);
    }

    public boolean isBIREPPDSQNAMENull() {
        return this.IsParamNull(TAG_BIREPPDSQNAME);
    }

    public String getBIREPPDSQNAME() {
        return this.GetParamStringValue(TAG_BIREPPDSQNAME, "");
    }

    public void setBIREPPDSQNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPDSQNAME, strValue);
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

    public boolean isBIREPPDSIDNull() {
        return this.IsParamNull(TAG_BIREPPDSID);
    }

    public String getBIREPPDSID() {
        return this.GetParamStringValue(TAG_BIREPPDSID, "");
    }

    public void setBIREPPDSID(String strValue) {
        this.SetParamValue(TAG_BIREPPDSID, strValue);
    }

    public boolean isBIREPPDSNAMENull() {
        return this.IsParamNull(TAG_BIREPPDSNAME);
    }

    public String getBIREPPDSNAME() {
        return this.GetParamStringValue(TAG_BIREPPDSNAME, "");
    }

    public void setBIREPPDSNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPDSNAME, strValue);
    }

    public boolean isBIREPPQIDNull() {
        return this.IsParamNull(TAG_BIREPPQID);
    }

    public String getBIREPPQID() {
        return this.GetParamStringValue(TAG_BIREPPQID, "");
    }

    public void setBIREPPQID(String strValue) {
        this.SetParamValue(TAG_BIREPPQID, strValue);
    }

    public boolean isBIREPPQNAMENull() {
        return this.IsParamNull(TAG_BIREPPQNAME);
    }

    public String getBIREPPQNAME() {
        return this.GetParamStringValue(TAG_BIREPPQNAME, "");
    }

    public void setBIREPPQNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPQNAME, strValue);
    }
}

