/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIAggTable
extends BaseDataEntity {
    public static final String TAG_BIAGGTABLEID = "BIAGGTABLEID";
    public static final String TAG_BIAGGTABLENAME = "BIAGGTABLENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_BICUBENAME = "BICUBENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_EXCLUDEFALG = "EXCLUDEFALG";
    public static final String TAG_FACTCOUNTFIELDID = "FACTCOUNTFIELDID";
    public static final String TAG_FACTCOUNTFIELDNAME = "FACTCOUNTFIELDNAME";
    public static final String TAG_SEPARATETYPE = "SEPARATETYPE";
    public static final String TAG_ENABLEAUTOAGG = "ENABLEAUTOAGG";
    public static final String TAG_AGGTABLENAME = "AGGTABLENAME";
    public static final String TAG_AGGBUILDEROBJECT = "AGGBUILDEROBJECT";
    public static final String TAG_AGGPROCNAME = "AGGPROCNAME";
    public static final String TAG_AGGPROCNAMEFMT = "AGGPROCNAMEFMT";
    public static final String TAG_AGGPROCDELAYDAY = "AGGPROCDELAYDAY";
    public static final String TAG_TIMEDEFID = "TIMEDEFID";
    public static final String TAG_TIMEDEFNAME = "TIMEDEFNAME";

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

    public boolean getEXCLUDEFALG() {
        return this.GetParamIntValue(TAG_EXCLUDEFALG, 0) == 1;
    }

    public void setEXCLUDEFALG(boolean bValue) {
        this.SetParamValue(TAG_EXCLUDEFALG, bValue ? 1 : 0);
    }

    public String getFACTCOUNTFIELDID() {
        return this.GetParamStringValue(TAG_FACTCOUNTFIELDID, "");
    }

    public void setFACTCOUNTFIELDID(String strValue) {
        this.SetParamValue(TAG_FACTCOUNTFIELDID, strValue);
    }

    public String getFACTCOUNTFIELDNAME() {
        return this.GetParamStringValue(TAG_FACTCOUNTFIELDNAME, "");
    }

    public void setFACTCOUNTFIELDNAME(String strValue) {
        this.SetParamValue(TAG_FACTCOUNTFIELDNAME, strValue);
    }

    public String getSEPARATETYPE() {
        return this.GetParamStringValue(TAG_SEPARATETYPE, "");
    }

    public void setSEPARATETYPE(String strValue) {
        this.SetParamValue(TAG_SEPARATETYPE, strValue);
    }

    public boolean getENABLEAUTOAGG() {
        return this.GetParamIntValue(TAG_ENABLEAUTOAGG, 0) == 1;
    }

    public void setENABLEAUTOAGG(boolean bValue) {
        this.SetParamValue(TAG_ENABLEAUTOAGG, bValue ? 1 : 0);
    }

    public String getAGGTABLENAME() {
        return this.GetParamStringValue(TAG_AGGTABLENAME, "");
    }

    public void setAGGTABLENAME(String strValue) {
        this.SetParamValue(TAG_AGGTABLENAME, strValue);
    }

    public String getAGGBUILDEROBJECT() {
        return this.GetParamStringValue(TAG_AGGBUILDEROBJECT, "");
    }

    public void setAGGBUILDEROBJECT(String strValue) {
        this.SetParamValue(TAG_AGGBUILDEROBJECT, strValue);
    }

    public String getAGGPROCNAME() {
        return this.GetParamStringValue(TAG_AGGPROCNAME, "");
    }

    public void setAGGPROCNAME(String strValue) {
        this.SetParamValue(TAG_AGGPROCNAME, strValue);
    }

    public String getAGGPROCNAMEFMT() {
        return this.GetParamStringValue(TAG_AGGPROCNAMEFMT, "");
    }

    public void setAGGPROCNAMEFMT(String strValue) {
        this.SetParamValue(TAG_AGGPROCNAMEFMT, strValue);
    }

    public int getAGGPROCDELAYDAY() {
        return this.GetParamIntValue(TAG_AGGPROCDELAYDAY, 0);
    }

    public void setAGGPROCDELAYDAY(int strValue) {
        this.SetParamValue(TAG_AGGPROCDELAYDAY, strValue);
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
}

