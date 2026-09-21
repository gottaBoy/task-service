/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class HelpDoc
extends BaseDataEntity {
    public static final String TAG_HELPDOCID = "HELPDOCID";
    public static final String TAG_HELPDOCNAME = "HELPDOCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MAINPATH = "MAINPATH";
    public static final String TAG_CONTENTPATH = "CONTENTPATH";

    public String getHELPDOCID() {
        return this.GetParamStringValue(TAG_HELPDOCID, "");
    }

    public void setHELPDOCID(String strValue) {
        this.SetParamValue(TAG_HELPDOCID, strValue);
    }

    public String getHELPDOCNAME() {
        return this.GetParamStringValue(TAG_HELPDOCNAME, "");
    }

    public void setHELPDOCNAME(String strValue) {
        this.SetParamValue(TAG_HELPDOCNAME, strValue);
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

    public String getMAINPATH() {
        return this.GetParamStringValue(TAG_MAINPATH, "");
    }

    public void setMAINPATH(String strValue) {
        this.SetParamValue(TAG_MAINPATH, strValue);
    }

    public String getCONTENTPATH() {
        return this.GetParamStringValue(TAG_CONTENTPATH, "");
    }

    public void setCONTENTPATH(String strValue) {
        this.SetParamValue(TAG_CONTENTPATH, strValue);
    }
}

