/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIHierarchyRole
extends BaseDataEntity {
    public static final String TAG_BIHIERARCHYROLEID = "BIHIERARCHYROLEID";
    public static final String TAG_BIHIERARCHYROLENAME = "BIHIERARCHYROLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIHIERARCHYID = "BIHIERARCHYID";
    public static final String TAG_BIHIERARCHYNAME = "BIHIERARCHYNAME";
    public static final String TAG_BICUBEROLEID = "BICUBEROLEID";
    public static final String TAG_BICUBEROLENAME = "BICUBEROLENAME";
    public static final String TAG_ACCESSTYPE = "ACCESSTYPE";
    public static final String TAG_BIDIMENSIONNAME = "BIDIMENSIONNAME";

    public String getBIHIERARCHYROLEID() {
        return this.GetParamStringValue(TAG_BIHIERARCHYROLEID, "");
    }

    public void setBIHIERARCHYROLEID(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYROLEID, strValue);
    }

    public String getBIHIERARCHYROLENAME() {
        return this.GetParamStringValue(TAG_BIHIERARCHYROLENAME, "");
    }

    public void setBIHIERARCHYROLENAME(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYROLENAME, strValue);
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

    public String getBIHIERARCHYID() {
        return this.GetParamStringValue(TAG_BIHIERARCHYID, "");
    }

    public void setBIHIERARCHYID(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYID, strValue);
    }

    public String getBIHIERARCHYNAME() {
        return this.GetParamStringValue(TAG_BIHIERARCHYNAME, "");
    }

    public void setBIHIERARCHYNAME(String strValue) {
        this.SetParamValue(TAG_BIHIERARCHYNAME, strValue);
    }

    public String getBICUBEROLEID() {
        return this.GetParamStringValue(TAG_BICUBEROLEID, "");
    }

    public void setBICUBEROLEID(String strValue) {
        this.SetParamValue(TAG_BICUBEROLEID, strValue);
    }

    public String getBICUBEROLENAME() {
        return this.GetParamStringValue(TAG_BICUBEROLENAME, "");
    }

    public void setBICUBEROLENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEROLENAME, strValue);
    }

    public String getACCESSTYPE() {
        return this.GetParamStringValue(TAG_ACCESSTYPE, "");
    }

    public void setACCESSTYPE(String strValue) {
        this.SetParamValue(TAG_ACCESSTYPE, strValue);
    }

    public String getBIDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_BIDIMENSIONNAME, "");
    }

    public void setBIDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_BIDIMENSIONNAME, strValue);
    }
}

