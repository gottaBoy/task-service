/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class RawFIStyle
extends BaseDataEntity {
    public static final String TAG_RAWFISTYLEID = "RAWFISTYLEID";
    public static final String TAG_RAWFISTYLENAME = "RAWFISTYLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BEGINTAG = "BEGINTAG";
    public static final String TAG_ENDTAG = "ENDTAG";
    public static final String TAG_SLBEGINTAG = "SLBEGINTAG";
    public static final String TAG_SLENDTAG = "SLENDTAG";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getRAWFISTYLEID() {
        return this.GetParamStringValue(TAG_RAWFISTYLEID, "");
    }

    public void setRAWFISTYLEID(String strValue) {
        this.SetParamValue(TAG_RAWFISTYLEID, strValue);
    }

    public String getRAWFISTYLENAME() {
        return this.GetParamStringValue(TAG_RAWFISTYLENAME, "");
    }

    public void setRAWFISTYLENAME(String strValue) {
        this.SetParamValue(TAG_RAWFISTYLENAME, strValue);
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

    public String getBEGINTAG() {
        return this.GetParamStringValue(TAG_BEGINTAG, "");
    }

    public void setBEGINTAG(String strValue) {
        this.SetParamValue(TAG_BEGINTAG, strValue);
    }

    public String getENDTAG() {
        return this.GetParamStringValue(TAG_ENDTAG, "");
    }

    public void setENDTAG(String strValue) {
        this.SetParamValue(TAG_ENDTAG, strValue);
    }

    public String getSLBEGINTAG() {
        return this.GetParamStringValue(TAG_SLBEGINTAG, "");
    }

    public void setSLBEGINTAG(String strValue) {
        this.SetParamValue(TAG_SLBEGINTAG, strValue);
    }

    public String getSLENDTAG() {
        return this.GetParamStringValue(TAG_SLENDTAG, "");
    }

    public void setSLENDTAG(String strValue) {
        this.SetParamValue(TAG_SLENDTAG, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

