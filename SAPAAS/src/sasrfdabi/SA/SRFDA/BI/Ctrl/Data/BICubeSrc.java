/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BICubeSrc
extends BaseDataEntity {
    public static final String TAG_BICUBESRCID = "BICUBESRCID";
    public static final String TAG_BICUBESRCNAME = "BICUBESRCNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_TIMEDEFID = "TIMEDEFID";
    public static final String TAG_TIMEDEFNAME = "TIMEDEFNAME";
    public static final String TAG_QUERYMODELID = "QUERYMODELID";
    public static final String TAG_QUERYMODELNAME = "QUERYMODELNAME";
    public static final String TAG_PAGEID = "PAGEID";
    public static final String TAG_PAGENAME = "PAGENAME";
    public static final String TAG_MEASUREMAP = "MEASUREMAP";
    public static final String TAG_SRCSELVALUE = "SRCSELVALUE";
    public static final String TAG_SRCSELFIELDS = "SRCSELFIELDS";

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

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public String getBICUBENAME() {
        return this.GetParamStringValue(TAG_BICUBENAME, "");
    }

    public void setBICUBENAME(String strValue) {
        this.SetParamValue(TAG_BICUBENAME, strValue);
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

    public String getQUERYMODELID() {
        return this.GetParamStringValue(TAG_QUERYMODELID, "");
    }

    public void setQUERYMODELID(String strValue) {
        this.SetParamValue(TAG_QUERYMODELID, strValue);
    }

    public String getQUERYMODELNAME() {
        return this.GetParamStringValue(TAG_QUERYMODELNAME, "");
    }

    public void setQUERYMODELNAME(String strValue) {
        this.SetParamValue(TAG_QUERYMODELNAME, strValue);
    }

    public String getPAGEID() {
        return this.GetParamStringValue(TAG_PAGEID, "");
    }

    public void setPAGEID(String strValue) {
        this.SetParamValue(TAG_PAGEID, strValue);
    }

    public String getPAGENAME() {
        return this.GetParamStringValue(TAG_PAGENAME, "");
    }

    public void setPAGENAME(String strValue) {
        this.SetParamValue(TAG_PAGENAME, strValue);
    }

    public String getMEASUREMAP() {
        return this.GetParamStringValue(TAG_MEASUREMAP, "");
    }

    public void setMEASUREMAP(String strValue) {
        this.SetParamValue(TAG_MEASUREMAP, strValue);
    }

    public String getSRCSELFIELDS() {
        return this.GetParamStringValue(TAG_SRCSELFIELDS, "");
    }

    public void setSRCSELFIELDS(String strValue) {
        this.SetParamValue(TAG_SRCSELFIELDS, strValue);
    }

    public String getSRCSELVALUE() {
        return this.GetParamStringValue(TAG_SRCSELVALUE, "");
    }

    public void setSRCSELVALUE(String strValue) {
        this.SetParamValue(TAG_SRCSELVALUE, strValue);
    }
}

