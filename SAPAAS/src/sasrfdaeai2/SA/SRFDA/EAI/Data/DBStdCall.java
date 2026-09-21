/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBStdCall
extends BaseDataEntity {
    public static final String TAG_EAIDBSTDCALLID = "EAIDBSTDCALLID";
    public static final String TAG_EAIDBSTDCALLNAME = "EAIDBSTDCALLNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIDBDOID = "EAIDBDOID";
    public static final String TAG_EAIDBDONAME = "EAIDBDONAME";
    public static final String TAG_STDACTION = "STDACTION";
    public static final String TAG_FIELDMAP = "FIELDMAP";
    public static final String TAG_FILTER = "FILTER";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public boolean isEAIDBSTDCALLIDNull() {
        return this.IsParamNull(TAG_EAIDBSTDCALLID);
    }

    public String getEAIDBSTDCALLID() {
        return this.GetParamStringValue(TAG_EAIDBSTDCALLID, "");
    }

    public void setEAIDBSTDCALLID(String strValue) {
        this.SetParamValue(TAG_EAIDBSTDCALLID, strValue);
    }

    public boolean isEAIDBSTDCALLNAMENull() {
        return this.IsParamNull(TAG_EAIDBSTDCALLNAME);
    }

    public String getEAIDBSTDCALLNAME() {
        return this.GetParamStringValue(TAG_EAIDBSTDCALLNAME, "");
    }

    public void setEAIDBSTDCALLNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBSTDCALLNAME, strValue);
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

    public boolean isSTDACTIONNull() {
        return this.IsParamNull(TAG_STDACTION);
    }

    public String getSTDACTION() {
        return this.GetParamStringValue(TAG_STDACTION, "");
    }

    public void setSTDACTION(String strValue) {
        this.SetParamValue(TAG_STDACTION, strValue);
    }

    public boolean isFIELDMAPNull() {
        return this.IsParamNull(TAG_FIELDMAP);
    }

    public String getFIELDMAP() {
        return this.GetParamStringValue(TAG_FIELDMAP, "");
    }

    public void setFIELDMAP(String strValue) {
        this.SetParamValue(TAG_FIELDMAP, strValue);
    }

    public boolean isFILTERNull() {
        return this.IsParamNull(TAG_FILTER);
    }

    public String getFILTER() {
        return this.GetParamStringValue(TAG_FILTER, "");
    }

    public void setFILTER(String strValue) {
        this.SetParamValue(TAG_FILTER, strValue);
    }
}

