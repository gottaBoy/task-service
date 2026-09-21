/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMComplexResDetail
extends BaseDataEntity {
    public static final String TAG_TMCOMPLEXRESDETAILID = "TMCOMPLEXRESDETAILID";
    public static final String TAG_TMCOMPLEXRESDETAILNAME = "TMCOMPLEXRESDETAILNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_TMCOMPLEXRESID = "TMCOMPLEXRESID";
    public static final String TAG_TMCOMPLEXRESNAME = "TMCOMPLEXRESNAME";
    public static final String TAG_TMRESBASEID = "TMRESBASEID";
    public static final String TAG_TMRESBASENAME = "TMRESBASENAME";

    public boolean isTMCOMPLEXRESDETAILIDNull() {
        return this.IsParamNull(TAG_TMCOMPLEXRESDETAILID);
    }

    public String getTMCOMPLEXRESDETAILID() {
        return this.GetParamStringValue(TAG_TMCOMPLEXRESDETAILID, "");
    }

    public void setTMCOMPLEXRESDETAILID(String strValue) {
        this.SetParamValue(TAG_TMCOMPLEXRESDETAILID, strValue);
    }

    public boolean isTMCOMPLEXRESDETAILNAMENull() {
        return this.IsParamNull(TAG_TMCOMPLEXRESDETAILNAME);
    }

    public String getTMCOMPLEXRESDETAILNAME() {
        return this.GetParamStringValue(TAG_TMCOMPLEXRESDETAILNAME, "");
    }

    public void setTMCOMPLEXRESDETAILNAME(String strValue) {
        this.SetParamValue(TAG_TMCOMPLEXRESDETAILNAME, strValue);
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

    public boolean isTMCOMPLEXRESIDNull() {
        return this.IsParamNull(TAG_TMCOMPLEXRESID);
    }

    public String getTMCOMPLEXRESID() {
        return this.GetParamStringValue(TAG_TMCOMPLEXRESID, "");
    }

    public void setTMCOMPLEXRESID(String strValue) {
        this.SetParamValue(TAG_TMCOMPLEXRESID, strValue);
    }

    public boolean isTMCOMPLEXRESNAMENull() {
        return this.IsParamNull(TAG_TMCOMPLEXRESNAME);
    }

    public String getTMCOMPLEXRESNAME() {
        return this.GetParamStringValue(TAG_TMCOMPLEXRESNAME, "");
    }

    public void setTMCOMPLEXRESNAME(String strValue) {
        this.SetParamValue(TAG_TMCOMPLEXRESNAME, strValue);
    }

    public boolean isTMRESBASEIDNull() {
        return this.IsParamNull(TAG_TMRESBASEID);
    }

    public String getTMRESBASEID() {
        return this.GetParamStringValue(TAG_TMRESBASEID, "");
    }

    public void setTMRESBASEID(String strValue) {
        this.SetParamValue(TAG_TMRESBASEID, strValue);
    }

    public boolean isTMRESBASENAMENull() {
        return this.IsParamNull(TAG_TMRESBASENAME);
    }

    public String getTMRESBASENAME() {
        return this.GetParamStringValue(TAG_TMRESBASENAME, "");
    }

    public void setTMRESBASENAME(String strValue) {
        this.SetParamValue(TAG_TMRESBASENAME, strValue);
    }
}

