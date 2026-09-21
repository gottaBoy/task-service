/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class ValueRule
extends BaseDataEntity {
    public static final String RULETYPE_SCRIPT = "SCRIPT";
    public static final String RULETYPE_REG = "REG";
    public static final String TAG_VALUERULEID = "VALUERULEID";
    public static final String TAG_VALUERULENAME = "VALUERULENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RULETYPE = "RULETYPE";
    public static final String TAG_SCRIPT = "SCRIPT";
    public static final String TAG_REGEXP = "REGEXP";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_RULEINFOLANRESID = "RULEINFOLANRESID";
    public static final String TAG_RULEINFOLANRESNAME = "RULEINFOLANRESNAME";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public String getVALUERULEID() {
        return this.GetParamStringValue(TAG_VALUERULEID, "");
    }

    public void setVALUERULEID(String strValue) {
        this.SetParamValue(TAG_VALUERULEID, strValue);
    }

    public String getVALUERULENAME() {
        return this.GetParamStringValue(TAG_VALUERULENAME, "");
    }

    public void setVALUERULENAME(String strValue) {
        this.SetParamValue(TAG_VALUERULENAME, strValue);
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

    public String getRULETYPE() {
        return this.GetParamStringValue(TAG_RULETYPE, "");
    }

    public void setRULETYPE(String strValue) {
        this.SetParamValue(TAG_RULETYPE, strValue);
    }

    public String getSCRIPT() {
        return this.GetParamStringValue("SCRIPT", "");
    }

    public void setSCRIPT(String strValue) {
        this.SetParamValue("SCRIPT", strValue);
    }

    public String getREGEXP() {
        return this.GetParamStringValue(TAG_REGEXP, "");
    }

    public void setREGEXP(String strValue) {
        this.SetParamValue(TAG_REGEXP, strValue);
    }

    public String getRULEINFO() {
        return this.GetParamStringValue(TAG_RULEINFO, "");
    }

    public void setRULEINFO(String strValue) {
        this.SetParamValue(TAG_RULEINFO, strValue);
    }

    public String getRULEINFOLANRESID() {
        return this.GetParamStringValue(TAG_RULEINFOLANRESID, "");
    }

    public void setRULEINFOLANRESID(String strValue) {
        this.SetParamValue(TAG_RULEINFOLANRESID, strValue);
    }

    public String getRULEINFOLANRESNAME() {
        return this.GetParamStringValue(TAG_RULEINFOLANRESNAME, "");
    }

    public void setRULEINFOLANRESNAME(String strValue) {
        this.SetParamValue(TAG_RULEINFOLANRESNAME, strValue);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }
}

