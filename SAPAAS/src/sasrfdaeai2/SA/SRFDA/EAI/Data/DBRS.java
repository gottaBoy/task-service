/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBRS
extends BaseDataEntity {
    public static final String RSTYPE_QUERY = "QUERY";
    public static final String TAG_EAIDBRSID = "EAIDBRSID";
    public static final String TAG_EAIDBRSNAME = "EAIDBRSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_RSTYPE = "RSTYPE";
    public static final String TAG_QUERYCMD = "QUERYCMD";
    public static final String TAG_FIELDALIAS = "FIELDALIAS";
    public static final String TAG_QUERYCOND = "QUERYCOND";

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

    public boolean isRSTYPENull() {
        return this.IsParamNull(TAG_RSTYPE);
    }

    public String getRSTYPE() {
        return this.GetParamStringValue(TAG_RSTYPE, "");
    }

    public void setRSTYPE(String strValue) {
        this.SetParamValue(TAG_RSTYPE, strValue);
    }

    public boolean isQUERYCMDNull() {
        return this.IsParamNull(TAG_QUERYCMD);
    }

    public String getQUERYCMD() {
        return this.GetParamStringValue(TAG_QUERYCMD, "");
    }

    public void setQUERYCMD(String strValue) {
        this.SetParamValue(TAG_QUERYCMD, strValue);
    }

    public boolean isFIELDALIASNull() {
        return this.IsParamNull(TAG_FIELDALIAS);
    }

    public String getFIELDALIAS() {
        return this.GetParamStringValue(TAG_FIELDALIAS, "");
    }

    public void setFIELDALIAS(String strValue) {
        this.SetParamValue(TAG_FIELDALIAS, strValue);
    }

    public boolean isQUERYCONDNull() {
        return this.IsParamNull(TAG_QUERYCOND);
    }

    public String getQUERYCOND() {
        return this.GetParamStringValue(TAG_QUERYCOND, "");
    }

    public void setQUERYCOND(String strValue) {
        this.SetParamValue(TAG_QUERYCOND, strValue);
    }
}

