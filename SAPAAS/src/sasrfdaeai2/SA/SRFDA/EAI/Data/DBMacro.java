/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBMacro
extends BaseDataEntity {
    public static final String TAG_EAIDBMACROID = "EAIDBMACROID";
    public static final String TAG_EAIDBMACRONAME = "EAIDBMACRONAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EXPRESSION = "EXPRESSION";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public boolean isEAIDBMACROIDNull() {
        return this.IsParamNull(TAG_EAIDBMACROID);
    }

    public String getEAIDBMACROID() {
        return this.GetParamStringValue(TAG_EAIDBMACROID, "");
    }

    public void setEAIDBMACROID(String strValue) {
        this.SetParamValue(TAG_EAIDBMACROID, strValue);
    }

    public boolean isEAIDBMACRONAMENull() {
        return this.IsParamNull(TAG_EAIDBMACRONAME);
    }

    public String getEAIDBMACRONAME() {
        return this.GetParamStringValue(TAG_EAIDBMACRONAME, "");
    }

    public void setEAIDBMACRONAME(String strValue) {
        this.SetParamValue(TAG_EAIDBMACRONAME, strValue);
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

    public boolean isEXPRESSIONNull() {
        return this.IsParamNull(TAG_EXPRESSION);
    }

    public String getEXPRESSION() {
        return this.GetParamStringValue(TAG_EXPRESSION, "");
    }

    public void setEXPRESSION(String strValue) {
        this.SetParamValue(TAG_EXPRESSION, strValue);
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
}

