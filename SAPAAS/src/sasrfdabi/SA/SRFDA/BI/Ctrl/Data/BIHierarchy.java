/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIHierarchy
extends BaseDataEntity {
    public static final String TAG_BIHIERARCHYID = "BIHIERARCHYID";
    public static final String TAG_BIHIERARCHYNAME = "BIHIERARCHYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIDIMENSIONID = "BIDIMENSIONID";
    public static final String TAG_BIDIMENSIONNAME = "BIDIMENSIONNAME";
    public static final String TAG_RELATIONTYPE = "RELATIONTYPE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_HASALL = "HASALL";
    public static final String TAG_TABLENAME = "TABLENAME";
    public static final String TAG_CAPTION = "CAPTION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_ALLCAPTION = "ALLCAPTION";
    public static final String TAG_TIMEDEFID = "TIMEDEFID";
    public static final String TAG_TIMEDEFNAME = "TIMEDEFNAME";
    public static final String TAG_QUERYCTRL = "QUERYCTRL";
    public static final String TAG_CUSTOMQUERYCTRL = "CUSTOMQUERYCTRL";
    public static final String TAG_USEVIEW = "USEVIEW";

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

    public String getBIDIMENSIONID() {
        return this.GetParamStringValue(TAG_BIDIMENSIONID, "");
    }

    public void setBIDIMENSIONID(String strValue) {
        this.SetParamValue(TAG_BIDIMENSIONID, strValue);
    }

    public String getBIDIMENSIONNAME() {
        return this.GetParamStringValue(TAG_BIDIMENSIONNAME, "");
    }

    public void setBIDIMENSIONNAME(String strValue) {
        this.SetParamValue(TAG_BIDIMENSIONNAME, strValue);
    }

    public String getRELATIONTYPE() {
        return this.GetParamStringValue(TAG_RELATIONTYPE, "");
    }

    public void setRELATIONTYPE(String strValue) {
        this.SetParamValue(TAG_RELATIONTYPE, strValue);
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

    public boolean getHASALL() {
        return this.GetParamIntValue(TAG_HASALL, 0) == 1;
    }

    public void setHASALL(boolean bValue) {
        this.SetParamValue(TAG_HASALL, bValue ? 1 : 0);
    }

    public String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }

    public String getCAPTION() {
        return this.GetParamStringValue(TAG_CAPTION, "");
    }

    public void setCAPTION(String strValue) {
        this.SetParamValue(TAG_CAPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getALLCAPTION() {
        return this.GetParamStringValue(TAG_ALLCAPTION, "");
    }

    public void setALLCAPTION(String strValue) {
        this.SetParamValue(TAG_ALLCAPTION, strValue);
    }

    public String getTIMEDEFID() {
        return this.GetParamStringValue(TAG_TIMEDEFID, "");
    }

    public void setTIMEDEFID(String strValue) {
        this.SetParamValue(TAG_TIMEDEFID, strValue);
    }

    public String getTIMEDEFNAME() {
        return this.GetParamStringValue(TAG_TIMEDEFNAME, "");
    }

    public void setTIMEDEFNAME(String strValue) {
        this.SetParamValue(TAG_TIMEDEFNAME, strValue);
    }

    public boolean isQUERYCTRLNull() {
        return this.IsParamNull(TAG_QUERYCTRL);
    }

    public String getQUERYCTRL() {
        return this.GetParamStringValue(TAG_QUERYCTRL, "");
    }

    public void setQUERYCTRL(String strValue) {
        this.SetParamValue(TAG_QUERYCTRL, strValue);
    }

    public boolean isCUSTOMQUERYCTRLNull() {
        return this.IsParamNull(TAG_CUSTOMQUERYCTRL);
    }

    public String getCUSTOMQUERYCTRL() {
        return this.GetParamStringValue(TAG_CUSTOMQUERYCTRL, "");
    }

    public void setCUSTOMQUERYCTRL(String strValue) {
        this.SetParamValue(TAG_CUSTOMQUERYCTRL, strValue);
    }

    public boolean isUSEVIEWNull() {
        return this.IsParamNull(TAG_USEVIEW);
    }

    public boolean getUSEVIEW() {
        return this.GetParamIntValue(TAG_USEVIEW, 0) == 1;
    }

    public void setUSEVIEW(boolean bValue) {
        this.SetParamValue(TAG_USEVIEW, bValue ? 1 : 0);
    }
}

