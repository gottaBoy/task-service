/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBOPProc
extends BaseDataEntity {
    public static final String DBOPPROC_SELECT_INSERT = "DBOPPROC_SELECT_INSERT";
    public static final String DBOPPROC_SELECT_LOOPCALL = "DBOPPROC_SELECT_LOOPCALL";
    public static final String DBOPPROC_PACKAGE = "DBOPPROC_PACKAGE";
    public static final String DBOPPROC_STANDARD_CALL = "DBOPPROC_STANDARD_CALL";
    public static final String DBOPPROC_MERGE_CALL = "DBOPPROC_MERGE_CALL";
    public static final String DBOPPROC_CUSTOM_CALL = "DBOPPROC_CUSTOM_CALL";
    public static final String TAG_EAIDBOPPROCID = "EAIDBOPPROCID";
    public static final String TAG_EAIDBOPPROCNAME = "EAIDBOPPROCNAME";
    public static final String TAG_EAIDBOPPROCTYPE = "EAIDBOPPROCTYPE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_EAIDBOPPKGID = "EAIDBOPPKGID";
    public static final String TAG_EAIDBOPPKGNAME = "EAIDBOPPKGNAME";
    public static final String TAG_LOGDETAIL = "LOGDETAIL";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public boolean isEAIDBOPPROCIDNull() {
        return this.IsParamNull(TAG_EAIDBOPPROCID);
    }

    public String getEAIDBOPPROCID() {
        return this.GetParamStringValue(TAG_EAIDBOPPROCID, "");
    }

    public void setEAIDBOPPROCID(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPROCID, strValue);
    }

    public boolean isEAIDBOPPROCNAMENull() {
        return this.IsParamNull(TAG_EAIDBOPPROCNAME);
    }

    public String getEAIDBOPPROCNAME() {
        return this.GetParamStringValue(TAG_EAIDBOPPROCNAME, "");
    }

    public void setEAIDBOPPROCNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBOPPROCNAME, strValue);
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

    public boolean isLOGDETAILNull() {
        return this.IsParamNull(TAG_LOGDETAIL);
    }

    public boolean getLOGDETAIL() {
        return this.GetParamIntValue(TAG_LOGDETAIL, 0) == 1;
    }

    public void setLOGDETAIL(boolean bValue) {
        this.SetParamValue(TAG_LOGDETAIL, bValue ? 1 : 0);
    }
}

