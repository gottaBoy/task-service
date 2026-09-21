/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DevImgDetail
extends BaseDataEntity {
    public static final String TAG_DEVIMGDETAILID = "DEVIMGDETAILID";
    public static final String TAG_DEVIMGDETAILNAME = "DEVIMGDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEVIMAGEID = "DEVIMAGEID";
    public static final String TAG_DEVIMAGENAME = "DEVIMAGENAME";
    public static final String TAG_IMAGETYPE = "IMAGETYPE";
    public static final String TAG_IMAGEPATH = "IMAGEPATH";
    public static final String TAG_CSSCLASS = "CSSCLASS";

    public String getDEVIMGDETAILID() {
        return this.GetParamStringValue(TAG_DEVIMGDETAILID, "");
    }

    public void setDEVIMGDETAILID(String strValue) {
        this.SetParamValue(TAG_DEVIMGDETAILID, strValue);
    }

    public String getDEVIMGDETAILNAME() {
        return this.GetParamStringValue(TAG_DEVIMGDETAILNAME, "");
    }

    public void setDEVIMGDETAILNAME(String strValue) {
        this.SetParamValue(TAG_DEVIMGDETAILNAME, strValue);
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

    public String getDEVIMAGEID() {
        return this.GetParamStringValue(TAG_DEVIMAGEID, "");
    }

    public void setDEVIMAGEID(String strValue) {
        this.SetParamValue(TAG_DEVIMAGEID, strValue);
    }

    public String getDEVIMAGENAME() {
        return this.GetParamStringValue(TAG_DEVIMAGENAME, "");
    }

    public void setDEVIMAGENAME(String strValue) {
        this.SetParamValue(TAG_DEVIMAGENAME, strValue);
    }

    public String getIMAGETYPE() {
        return this.GetParamStringValue(TAG_IMAGETYPE, "");
    }

    public void setIMAGETYPE(String strValue) {
        this.SetParamValue(TAG_IMAGETYPE, strValue);
    }

    public String getIMAGEPATH() {
        return this.GetParamStringValue(TAG_IMAGEPATH, "");
    }

    public void setIMAGEPATH(String strValue) {
        this.SetParamValue(TAG_IMAGEPATH, strValue);
    }

    public String getCSSCLASS() {
        return this.GetParamStringValue(TAG_CSSCLASS, "");
    }

    public void setCSSCLASS(String strValue) {
        this.SetParamValue(TAG_CSSCLASS, strValue);
    }
}

