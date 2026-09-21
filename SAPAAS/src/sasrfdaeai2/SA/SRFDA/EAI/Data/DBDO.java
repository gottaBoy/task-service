/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBDO
extends BaseDataEntity {
    public static final String DOTYPE_DATAENTITY = "DATAENTITY";
    public static final String DOTYPE_TMPTABLE = "TMPTABLE";
    public static final String TAG_EAIDBDOID = "EAIDBDOID";
    public static final String TAG_EAIDBDONAME = "EAIDBDONAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DOTYPE = "DOTYPE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_EAIDBTMPTABID = "EAIDBTMPTABID";
    public static final String TAG_EAIDBTMPTABNAME = "EAIDBTMPTABNAME";

    public boolean isEAIDBDOIDNull() {
        return this.IsParamNull(TAG_EAIDBDOID);
    }

    public String getEAIDBDOID() {
        return this.GetParamStringValue(TAG_EAIDBDOID, "");
    }

    public void setEAIDBDOID(String strValue) {
        this.SetParamValue(TAG_EAIDBDOID, strValue);
    }

    public boolean isEAIDBDONAMENull() {
        return this.IsParamNull(TAG_EAIDBDONAME);
    }

    public String getEAIDBDONAME() {
        return this.GetParamStringValue(TAG_EAIDBDONAME, "");
    }

    public void setEAIDBDONAME(String strValue) {
        this.SetParamValue(TAG_EAIDBDONAME, strValue);
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

    public boolean isDOTYPENull() {
        return this.IsParamNull(TAG_DOTYPE);
    }

    public String getDOTYPE() {
        return this.GetParamStringValue(TAG_DOTYPE, "");
    }

    public void setDOTYPE(String strValue) {
        this.SetParamValue(TAG_DOTYPE, strValue);
    }

    public boolean isDEIDNull() {
        return this.IsParamNull(TAG_DEID);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean isDENAMENull() {
        return this.IsParamNull(TAG_DENAME);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

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
}

