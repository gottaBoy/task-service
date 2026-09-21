/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.BI.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class BIRepPDS
extends BaseDataEntity {
    public static final String TAG_BIREPPDSID = "BIREPPDSID";
    public static final String TAG_BIREPPDSNAME = "BIREPPDSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_BIREPPANELID = "BIREPPANELID";
    public static final String TAG_BIREPPANELNAME = "BIREPPANELNAME";
    public static final String TAG_ENABLESORT = "ENABLESORT";
    public static final String TAG_BICUBEMEASUREID = "BICUBEMEASUREID";
    public static final String TAG_BICUBEMEASURENAME = "BICUBEMEASURENAME";
    public static final String TAG_TOPCNT = "TOPCNT";
    public static final String TAG_BICUBEID = "BICUBEID";
    public static final String TAG_SORTDIR = "SORTDIR";
    public static final String TAG_STATICCOND = "STATICCOND";

    public boolean isBIREPPDSIDNull() {
        return this.IsParamNull(TAG_BIREPPDSID);
    }

    public String getBIREPPDSID() {
        return this.GetParamStringValue(TAG_BIREPPDSID, "");
    }

    public void setBIREPPDSID(String strValue) {
        this.SetParamValue(TAG_BIREPPDSID, strValue);
    }

    public boolean isBIREPPDSNAMENull() {
        return this.IsParamNull(TAG_BIREPPDSNAME);
    }

    public String getBIREPPDSNAME() {
        return this.GetParamStringValue(TAG_BIREPPDSNAME, "");
    }

    public void setBIREPPDSNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPDSNAME, strValue);
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

    public boolean isBIREPPANELIDNull() {
        return this.IsParamNull(TAG_BIREPPANELID);
    }

    public String getBIREPPANELID() {
        return this.GetParamStringValue(TAG_BIREPPANELID, "");
    }

    public void setBIREPPANELID(String strValue) {
        this.SetParamValue(TAG_BIREPPANELID, strValue);
    }

    public boolean isBIREPPANELNAMENull() {
        return this.IsParamNull(TAG_BIREPPANELNAME);
    }

    public String getBIREPPANELNAME() {
        return this.GetParamStringValue(TAG_BIREPPANELNAME, "");
    }

    public void setBIREPPANELNAME(String strValue) {
        this.SetParamValue(TAG_BIREPPANELNAME, strValue);
    }

    public boolean isENABLESORTNull() {
        return this.IsParamNull(TAG_ENABLESORT);
    }

    public boolean getENABLESORT() {
        return this.GetParamIntValue(TAG_ENABLESORT, 0) == 1;
    }

    public void setENABLESORT(boolean bValue) {
        this.SetParamValue(TAG_ENABLESORT, bValue ? 1 : 0);
    }

    public boolean isBICUBEMEASUREIDNull() {
        return this.IsParamNull(TAG_BICUBEMEASUREID);
    }

    public String getBICUBEMEASUREID() {
        return this.GetParamStringValue(TAG_BICUBEMEASUREID, "");
    }

    public void setBICUBEMEASUREID(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASUREID, strValue);
    }

    public boolean isBICUBEMEASURENAMENull() {
        return this.IsParamNull(TAG_BICUBEMEASURENAME);
    }

    public String getBICUBEMEASURENAME() {
        return this.GetParamStringValue(TAG_BICUBEMEASURENAME, "");
    }

    public void setBICUBEMEASURENAME(String strValue) {
        this.SetParamValue(TAG_BICUBEMEASURENAME, strValue);
    }

    public boolean isTOPCNTNull() {
        return this.IsParamNull(TAG_TOPCNT);
    }

    public int getTOPCNT() {
        return this.GetParamIntValue(TAG_TOPCNT, 0);
    }

    public void setTOPCNT(int strValue) {
        this.SetParamValue(TAG_TOPCNT, strValue);
    }

    public boolean isBICUBEIDNull() {
        return this.IsParamNull(TAG_BICUBEID);
    }

    public String getBICUBEID() {
        return this.GetParamStringValue(TAG_BICUBEID, "");
    }

    public void setBICUBEID(String strValue) {
        this.SetParamValue(TAG_BICUBEID, strValue);
    }

    public boolean isSORTDIRNull() {
        return this.IsParamNull(TAG_SORTDIR);
    }

    public String getSORTDIR() {
        return this.GetParamStringValue(TAG_SORTDIR, "");
    }

    public void setSORTDIR(String strValue) {
        this.SetParamValue(TAG_SORTDIR, strValue);
    }

    public boolean isSTATICCONDNull() {
        return this.IsParamNull(TAG_STATICCOND);
    }

    public String getSTATICCOND() {
        return this.GetParamStringValue(TAG_STATICCOND, "");
    }

    public void setSTATICCOND(String strValue) {
        this.SetParamValue(TAG_STATICCOND, strValue);
    }
}

