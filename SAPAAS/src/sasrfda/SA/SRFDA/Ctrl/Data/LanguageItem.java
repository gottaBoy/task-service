/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class LanguageItem
extends BaseDataEntity {
    public static final String TAG_LANGUAGEITEMID = "LANGUAGEITEMID";
    public static final String TAG_LANGUAGEITEMNAME = "LANGUAGEITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_LANGUAGEID = "LANGUAGEID";
    public static final String TAG_LANGUAGENAME = "LANGUAGENAME";
    public static final String TAG_CONTENT = "CONTENT";
    public static final String TAG_LANGUAGERESID = "LANGUAGERESID";
    public static final String TAG_LANGUAGERESNAME = "LANGUAGERESNAME";

    public String getLANGUAGEITEMID() {
        return this.GetParamStringValue(TAG_LANGUAGEITEMID, "");
    }

    public void setLANGUAGEITEMID(String strValue) {
        this.SetParamValue(TAG_LANGUAGEITEMID, strValue);
    }

    public String getLANGUAGEITEMNAME() {
        return this.GetParamStringValue(TAG_LANGUAGEITEMNAME, "");
    }

    public void setLANGUAGEITEMNAME(String strValue) {
        this.SetParamValue(TAG_LANGUAGEITEMNAME, strValue);
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

    public String getLANGUAGEID() {
        return this.GetParamStringValue(TAG_LANGUAGEID, "");
    }

    public void setLANGUAGEID(String strValue) {
        this.SetParamValue(TAG_LANGUAGEID, strValue);
    }

    public String getLANGUAGENAME() {
        return this.GetParamStringValue(TAG_LANGUAGENAME, "");
    }

    public void setLANGUAGENAME(String strValue) {
        this.SetParamValue(TAG_LANGUAGENAME, strValue);
    }

    public String getCONTENT() {
        return this.GetParamStringValue(TAG_CONTENT, "");
    }

    public void setCONTENT(String strValue) {
        this.SetParamValue(TAG_CONTENT, strValue);
    }

    public String getLANGUAGERESID() {
        return this.GetParamStringValue(TAG_LANGUAGERESID, "");
    }

    public void setLANGUAGERESID(String strValue) {
        this.SetParamValue(TAG_LANGUAGERESID, strValue);
    }

    public String getLANGUAGERESNAME() {
        return this.GetParamStringValue(TAG_LANGUAGERESNAME, "");
    }

    public void setLANGUAGERESNAME(String strValue) {
        this.SetParamValue(TAG_LANGUAGERESNAME, strValue);
    }
}

