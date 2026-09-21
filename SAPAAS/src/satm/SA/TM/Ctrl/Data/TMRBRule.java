/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMRBRule
extends BaseDataEntity {
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_TMRBRULEID = "TMRBRULEID";
    public static final String TAG_TMRBRULENAME = "TMRBRULENAME";
    public static final String TAG_TMRBRULETYPE = "TMRBRULETYPE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_VERSION = "VERSION";
    public static final String TAG_RULEINFO = "RULEINFO";
    public static final String TAG_RULEOBJECT = "RULEOBJECT";

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

    public boolean isTMRBRULEIDNull() {
        return this.IsParamNull(TAG_TMRBRULEID);
    }

    public String getTMRBRULEID() {
        return this.GetParamStringValue(TAG_TMRBRULEID, "");
    }

    public void setTMRBRULEID(String strValue) {
        this.SetParamValue(TAG_TMRBRULEID, strValue);
    }

    public boolean isTMRBRULENAMENull() {
        return this.IsParamNull(TAG_TMRBRULENAME);
    }

    public String getTMRBRULENAME() {
        return this.GetParamStringValue(TAG_TMRBRULENAME, "");
    }

    public void setTMRBRULENAME(String strValue) {
        this.SetParamValue(TAG_TMRBRULENAME, strValue);
    }

    public boolean isTMRBRULETYPENull() {
        return this.IsParamNull(TAG_TMRBRULETYPE);
    }

    public String getTMRBRULETYPE() {
        return this.GetParamStringValue(TAG_TMRBRULETYPE, "");
    }

    public void setTMRBRULETYPE(String strValue) {
        this.SetParamValue(TAG_TMRBRULETYPE, strValue);
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

    public boolean isVERSIONNull() {
        return this.IsParamNull(TAG_VERSION);
    }

    public int getVERSION() {
        return this.GetParamIntValue(TAG_VERSION, 0);
    }

    public void setVERSION(int strValue) {
        this.SetParamValue(TAG_VERSION, strValue);
    }

    public boolean isRULEINFONull() {
        return this.IsParamNull(TAG_RULEINFO);
    }

    public String getRULEINFO() {
        return this.GetParamStringValue(TAG_RULEINFO, "");
    }

    public void setRULEINFO(String strValue) {
        this.SetParamValue(TAG_RULEINFO, strValue);
    }

    public boolean isRULEOBJECTNull() {
        return this.IsParamNull(TAG_RULEOBJECT);
    }

    public String getRULEOBJECT() {
        return this.GetParamStringValue(TAG_RULEOBJECT, "");
    }

    public void setRULEOBJECT(String strValue) {
        this.SetParamValue(TAG_RULEOBJECT, strValue);
    }
}

