/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPT
extends BaseDataEntity {
    public static final String TAG_BIREPPTID = "BIREPPTID";
    public static final String TAG_BIREPPTNAME = "BIREPPTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PANELMODEL = "PANELMODEL";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isBIREPPTIDNull() {
        return this.IsParamNull(TAG_BIREPPTID);
    }

    public String getBIREPPTID() {
        return this.GetParamStringValue(TAG_BIREPPTID, "");
    }

    public void setBIREPPTID(String strValue) {
        this.SetParamValue(TAG_BIREPPTID, strValue);
    }

    public boolean isBIREPPTNAMENull() {
        return this.IsParamNull(TAG_BIREPPTNAME);
    }

    public String getBIREPPTNAME() {
        return this.GetParamStringValue(TAG_BIREPPTNAME, "");
    }

    public void setBIREPPTNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPTNAME, strValue);
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

    public boolean isPANELMODELNull() {
        return this.IsParamNull(TAG_PANELMODEL);
    }

    public String getPANELMODEL() {
        return this.GetParamStringValue(TAG_PANELMODEL, "");
    }

    public void setPANELMODEL(String strValue) {
        this.SetParamValue(TAG_PANELMODEL, strValue);
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
}

