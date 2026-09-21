/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPQ
extends BaseDataEntity {
    public static final String TAG_BIREPPQID = "BIREPPQID";
    public static final String TAG_BIREPPQNAME = "BIREPPQNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPPANELID = "BIREPPANELID";
    public static final String TAG_BIREPPANELNAME = "BIREPPANELNAME";

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

    public boolean isBIREPPANELIDNull() {
        return this.IsParamNull(TAG_BIREPPANELID);
    }

    public String getBIREPPANELID() {
        return this.GetParamStringValue(TAG_BIREPPANELID, "");
    }

    public void setBIREPPANELID(String strValue) {
        this.SetParamValue(TAG_BIREPPANELID, strValue);
    }

    public boolean isBIREPPANELNAMENull() {
        return this.IsParamNull(TAG_BIREPPANELNAME);
    }

    public String getBIREPPANELNAME() {
        return this.GetParamStringValue(TAG_BIREPPANELNAME, "");
    }

    public void setBIREPPANELNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPANELNAME, strValue);
    }
}

