/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBSelIns
extends BaseDataEntity {
    public static final String TAG_EAIDBSELINSID = "EAIDBSELINSID";
    public static final String TAG_EAIDBSELINSNAME = "EAIDBSELINSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIDBOPPROCTYPE = "EAIDBOPPROCTYPE";
    public static final String TAG_EAIDBOPPKGID = "EAIDBOPPKGID";
    public static final String TAG_EAIDBOPPKGNAME = "EAIDBOPPKGNAME";
    public static final String TAG_EAIDBRSID = "EAIDBRSID";
    public static final String TAG_EAIDBRSNAME = "EAIDBRSNAME";
    public static final String TAG_EAIDBDOID = "EAIDBDOID";
    public static final String TAG_EAIDBDONAME = "EAIDBDONAME";
    public static final String TAG_RESETDO = "RESETDO";
    public static final String TAG_RESETDOCOND = "RESETDOCOND";
    public static final String TAG_QUERYCOND = "QUERYCOND";
    public static final String TAG_FIELDMAP = "FIELDMAP";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public boolean isEAIDBSELINSIDNull() {
        return this.IsParamNull(TAG_EAIDBSELINSID);
    }

    public String getEAIDBSELINSID() {
        return this.GetParamStringValue(TAG_EAIDBSELINSID, "");
    }

    public void setEAIDBSELINSID(String strValue) {
        this.SetParamValue(TAG_EAIDBSELINSID, strValue);
    }

    public boolean isEAIDBSELINSNAMENull() {
        return this.IsParamNull(TAG_EAIDBSELINSNAME);
    }

    public String getEAIDBSELINSNAME() {
        return this.GetParamStringValue(TAG_EAIDBSELINSNAME, "");
    }

    public void setEAIDBSELINSNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBSELINSNAME, strValue);
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

    public boolean isEAIDBOPPROCTYPENull() {
        return this.IsParamNull(TAG_EAIDBOPPROCTYPE);
    }

    public String getEAIDBOPPROCTYPE() {
        return this.GetParamStringValue(TAG_EAIDBOPPROCTYPE, "");
    }

    public void setEAIDBOPPROCTYPE(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPROCTYPE, strValue);
    }

    public boolean isEAIDBOPPKGIDNull() {
        return this.IsParamNull(TAG_EAIDBOPPKGID);
    }

    public String getEAIDBOPPKGID() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGID, "");
    }

    public void setEAIDBOPPKGID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGID, strValue);
    }

    public boolean isEAIDBOPPKGNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPPKGNAME);
    }

    public String getEAIDBOPPKGNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPPKGNAME, "");
    }

    public void setEAIDBOPPKGNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPKGNAME, strValue);
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

    public boolean isRESETDONull() {
        return this.IsParamNull(TAG_RESETDO);
    }

    public boolean getRESETDO() {
        return this.GetParamIntValue(TAG_RESETDO, 0) == 1;
    }

    public void setRESETDO(boolean bValue) {
        this.SetParamValue(TAG_RESETDO, bValue ? 1 : 0);
    }

    public boolean isRESETDOCONDNull() {
        return this.IsParamNull(TAG_RESETDOCOND);
    }

    public String getRESETDOCOND() {
        return this.GetParamStringValue(TAG_RESETDOCOND, "");
    }

    public void setRESETDOCOND(String strValue) {
        this.SetParamValue(TAG_RESETDOCOND, strValue);
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

    public boolean isFIELDMAPNull() {
        return this.IsParamNull(TAG_FIELDMAP);
    }

    public String getFIELDMAP() {
        return this.GetParamStringValue(TAG_FIELDMAP, "");
    }

    public void setFIELDMAP(String strValue) {
        this.SetParamValue(TAG_FIELDMAP, strValue);
    }
}

