/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICubeSrcMap
extends BaseDataEntity {
    public static final String TAG_BICUBESRCMAPID = "BICUBESRCMAPID";
    public static final String TAG_BICUBESRCMAPNAME = "BICUBESRCMAPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBESRCID = "BICUBESRCID";
    public static final String TAG_BICUBESRCNAME = "BICUBESRCNAME";
    public static final String TAG_CUBEDEFID = "CUBEDEFID";
    public static final String TAG_CUBEDEFNAME = "CUBEDEFNAME";
    public static final String TAG_DRILLSQL = "DRILLSQL";
    public static final String TAG_QUERYCOND = "QUERYCOND";
    public static final String TAG_QUERYPARAMFMT = "QUERYPARAMFMT";

    public String getBICUBESRCMAPID() {
        return this.GetParamStringValue(TAG_BICUBESRCMAPID, "");
    }

    public void setBICUBESRCMAPID(String strValue) {
        this.SetParamValue(TAG_BICUBESRCMAPID, strValue);
    }

    public String getBICUBESRCMAPNAME() {
        return this.GetParamStringValue(TAG_BICUBESRCMAPNAME, "");
    }

    public void setBICUBESRCMAPNAME(String strValue) {
        this.SetParamValue(TAG_BICUBESRCMAPNAME, strValue);
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

    public String getBICUBESRCID() {
        return this.GetParamStringValue(TAG_BICUBESRCID, "");
    }

    public void setBICUBESRCID(String strValue) {
        this.SetParamValue(TAG_BICUBESRCID, strValue);
    }

    public String getBICUBESRCNAME() {
        return this.GetParamStringValue(TAG_BICUBESRCNAME, "");
    }

    public void setBICUBESRCNAME(String strValue) {
        this.SetParamValue(TAG_BICUBESRCNAME, strValue);
    }

    public String getCUBEDEFID() {
        return this.GetParamStringValue(TAG_CUBEDEFID, "");
    }

    public void setCUBEDEFID(String strValue) {
        this.SetParamValue(TAG_CUBEDEFID, strValue);
    }

    public String getCUBEDEFNAME() {
        return this.GetParamStringValue(TAG_CUBEDEFNAME, "");
    }

    public void setCUBEDEFNAME(String strValue) {
        this.SetParamValue(TAG_CUBEDEFNAME, strValue);
    }

    public String getDRILLSQL() {
        return this.GetParamStringValue(TAG_DRILLSQL, "");
    }

    public void setDRILLSQL(String strValue) {
        this.SetParamValue(TAG_DRILLSQL, strValue);
    }

    public String getQUERYCOND() {
        return this.GetParamStringValue(TAG_QUERYCOND, "");
    }

    public void setQUERYCOND(String strValue) {
        this.SetParamValue(TAG_QUERYCOND, strValue);
    }

    public String getQUERYPARAMFMT() {
        return this.GetParamStringValue(TAG_QUERYPARAMFMT, "");
    }

    public void setQUERYPARAMFMT(String strValue) {
        this.SetParamValue(TAG_QUERYPARAMFMT, strValue);
    }
}

