/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBTmpTable
extends BaseDataEntity {
    public static final String TAG_EAIDBTMPTABID = "EAIDBTMPTABID";
    public static final String TAG_EAIDBTMPTABNAME = "EAIDBTMPTABNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";
    public static final String TAG_EAIDBRSID = "EAIDBRSID";
    public static final String TAG_EAIDBRSNAME = "EAIDBRSNAME";
    public static final String TAG_COLFROMRS = "COLFROMRS";
    public static final String TAG_TABLENAME = "TABLENAME";

    public boolean isEAIDBTMPTABIDNull() {
        return this.IsParamNull(TAG_EAIDBTMPTABID);
    }

    public String getEAIDBTMPTABID() {
        return this.GetParamStringValue(TAG_EAIDBTMPTABID, "");
    }

    public void setEAIDBTMPTABID(String strValue) {
        this.SetParamValue(TAG_EAIDBTMPTABID, strValue);
    }

    public boolean isEAIDBTMPTABNAMENull() {
        return this.IsParamNull(TAG_EAIDBTMPTABNAME);
    }

    public String getEAIDBTMPTABNAME() {
        return this.GetParamStringValue(TAG_EAIDBTMPTABNAME, "");
    }

    public void setEAIDBTMPTABNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBTMPTABNAME, strValue);
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

    public boolean isDESCRIPTIONNull() {
        return this.IsParamNull(TAG_DESCRIPTION);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public boolean isEAIDBRSIDNull() {
        return this.IsParamNull(TAG_EAIDBRSID);
    }

    public String getEAIDBRSID() {
        return this.GetParamStringValue(TAG_EAIDBRSID, "");
    }

    public void setEAIDBRSID(String strValue) {
        this.SetParamValue(TAG_EAIDBRSID, strValue);
    }

    public boolean isEAIDBRSNAMENull() {
        return this.IsParamNull(TAG_EAIDBRSNAME);
    }

    public String getEAIDBRSNAME() {
        return this.GetParamStringValue(TAG_EAIDBRSNAME, "");
    }

    public void setEAIDBRSNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBRSNAME, strValue);
    }

    public boolean isCOLFROMRSNull() {
        return this.IsParamNull(TAG_COLFROMRS);
    }

    public boolean getCOLFROMRS() {
        return this.GetParamIntValue(TAG_COLFROMRS, 0) == 1;
    }

    public void setCOLFROMRS(boolean bValue) {
        this.SetParamValue(TAG_COLFROMRS, bValue ? 1 : 0);
    }

    public boolean isTABLENAMENull() {
        return this.IsParamNull(TAG_TABLENAME);
    }

    public String getTABLENAME() {
        return this.GetParamStringValue(TAG_TABLENAME, "");
    }

    public void setTABLENAME(String strValue) {
        this.SetParamValue(TAG_TABLENAME, strValue);
    }
}

