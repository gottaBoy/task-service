/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.TM.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class TMRBRuleType
extends BaseDataEntity {
    public static final String TAG_TMRBRULETYPEID = "TMRBRULETYPEID";
    public static final String TAG_TMRBRULETYPENAME = "TMRBRULETYPENAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_RULEOBJECT = "RULEOBJECT";

    public boolean isTMRBRULETYPEIDNull() {
        return this.IsParamNull(TAG_TMRBRULETYPEID);
    }

    public String getTMRBRULETYPEID() {
        return this.GetParamStringValue(TAG_TMRBRULETYPEID, "");
    }

    public void setTMRBRULETYPEID(String strValue) {
        this.SetParamValue(TAG_TMRBRULETYPEID, strValue);
    }

    public boolean isTMRBRULETYPENAMENull() {
        return this.IsParamNull(TAG_TMRBRULETYPENAME);
    }

    public String getTMRBRULETYPENAME() {
        return this.GetParamStringValue(TAG_TMRBRULETYPENAME, "");
    }

    public void setTMRBRULETYPENAME(String strValue) {
        this.SetParamValue(TAG_TMRBRULETYPENAME, strValue);
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

    public boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
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

