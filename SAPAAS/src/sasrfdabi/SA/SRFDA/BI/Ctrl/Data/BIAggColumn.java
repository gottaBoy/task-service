/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIAggColumn
extends BaseDataEntity {
    public static final String TAG_BIAGGCOLUMNID = "BIAGGCOLUMNID";
    public static final String TAG_BIAGGCOLUMNNAME = "BIAGGCOLUMNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIAGGTABLEID = "BIAGGTABLEID";
    public static final String TAG_BIAGGTABLENAME = "BIAGGTABLENAME";
    public static final String TAG_AGGFIELDID = "AGGFIELDID";
    public static final String TAG_AGGFIELDNAME = "AGGFIELDNAME";
    public static final String TAG_AGGCOLUMNTYPE = "AGGCOLUMNTYPE";
    public static final String TAG_FKFIELDID = "FKFIELDID";
    public static final String TAG_FKFIELDNAME = "FKFIELDNAME";
    public static final String TAG_BICUBEMEASUREID = "BICUBEMEASUREID";
    public static final String TAG_BICUBEMEASURENAME = "BICUBEMEASURENAME";
    public static final String TAG_BICUBEDMID = "BICUBEDMID";
    public static final String TAG_BICUBEDMNAME = "BICUBEDMNAME";
    public static final String TAG_BIDMLEVELID = "BIDMLEVELID";
    public static final String TAG_BIDMLEVELNAME = "BIDMLEVELNAME";

    public String getBIAGGCOLUMNID() {
        return this.GetParamStringValue(TAG_BIAGGCOLUMNID, "");
    }

    public void setBIAGGCOLUMNID(String strValue) {
        this.SetParamValue(TAG_BIAGGCOLUMNID, strValue);
    }

    public String getBIAGGCOLUMNNAME() {
        return this.GetParamStringValue(TAG_BIAGGCOLUMNNAME, "");
    }

    public void setBIAGGCOLUMNNAME(String strValue) {
        this.SetParamValue(TAG_BIAGGCOLUMNNAME, strValue);
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

    public String getBIAGGTABLEID() {
        return this.GetParamStringValue(TAG_BIAGGTABLEID, "");
    }

    public void setBIAGGTABLEID(String strValue) {
        this.SetParamValue(TAG_BIAGGTABLEID, strValue);
    }

    public String getBIAGGTABLENAME() {
        return this.GetParamStringValue(TAG_BIAGGTABLENAME, "");
    }

    public void setBIAGGTABLENAME(String strValue) {
        this.SetParamValue(TAG_BIAGGTABLENAME, strValue);
    }

    public String getAGGFIELDID() {
        return this.GetParamStringValue(TAG_AGGFIELDID, "");
    }

    public void setAGGFIELDID(String strValue) {
        this.SetParamValue(TAG_AGGFIELDID, strValue);
    }

    public String getAGGFIELDNAME() {
        return this.GetParamStringValue(TAG_AGGFIELDNAME, "");
    }

    public void setAGGFIELDNAME(String strValue) {
        this.SetParamValue(TAG_AGGFIELDNAME, strValue);
    }

    public String getAGGCOLUMNTYPE() {
        return this.GetParamStringValue(TAG_AGGCOLUMNTYPE, "");
    }

    public void setAGGCOLUMNTYPE(String strValue) {
        this.SetParamValue(TAG_AGGCOLUMNTYPE, strValue);
    }

    public String getFKFIELDID() {
        return this.GetParamStringValue(TAG_FKFIELDID, "");
    }

    public void setFKFIELDID(String strValue) {
        this.SetParamValue(TAG_FKFIELDID, strValue);
    }

    public String getFKFIELDNAME() {
        return this.GetParamStringValue(TAG_FKFIELDNAME, "");
    }

    public void setFKFIELDNAME(String strValue) {
        this.SetParamValue(TAG_FKFIELDNAME, strValue);
    }

    public String getBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_BICUBEMEASUREID, "");
    }

    public void setBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASUREID, strValue);
    }

    public String getBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_BICUBEMEASURENAME, "");
    }

    public void setBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURENAME, strValue);
    }

    public String getBICUBEDMID() {
        return this.GetParamStringValue(TAG_BICUBEDMID, "");
    }

    public void setBICUBEDMID(String strValue) {
        this.SetParamValue(TAG_BICUBEDMID, strValue);
    }

    public String getBICUBEDMNAME() {
        return this.GetParamStringValue(TAG_BICUBEDMNAME, "");
    }

    public void setBICUBEDMNAME(String strValue) {
        this.SetParamValue(TAG_BICUBEDMNAME, strValue);
    }

    public String getBIDMLEVELID() {
        return this.GetParamStringValue(TAG_BIDMLEVELID, "");
    }

    public void setBIDMLEVELID(String strValue) {
        this.SetParamValue(TAG_BIDMLEVELID, strValue);
    }

    public String getBIDMLEVELNAME() {
        return this.GetParamStringValue(TAG_BIDMLEVELNAME, "");
    }

    public void setBIDMLEVELNAME(String strValue) {
        this.SetParamValue(TAG_BIDMLEVELNAME, strValue);
    }
}

