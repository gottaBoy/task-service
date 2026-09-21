/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.EAI.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class DBCustom
extends BaseDataEntity {
    public static final String TAG_EAIDBCUSTOMID = "EAIDBCUSTOMID";
    public static final String TAG_EAIDBCUSTOMNAME = "EAIDBCUSTOMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_RAWCODE = "RAWCODE";
    public static final String TAG_FIELDALIAS = "FIELDALIAS";
    public static final String TAG_EAIDBOPPROCTYPE = "EAIDBOPPROCTYPE";
    public static final String TAG_EAIDBOPPKGID = "EAIDBOPPKGID";
    public static final String TAG_EAIDBOPPKGNAME = "EAIDBOPPKGNAME";
    public static final String TAG_DESCRIPTION = "DESCRIPTION";

    public void setDESCRIPTION(String strValue) {
        this.SetParamValue(TAG_DESCRIPTION, strValue);
    }

    public String getDESCRIPTION() {
        return this.GetParamStringValue(TAG_DESCRIPTION, "");
    }

    public boolean isEAIDBCUSTOMIDNull() {
        return this.IsParamNull(TAG_EAIDBCUSTOMID);
    }

    public String getEAIDBCUSTOMID() {
        return this.GetParamStringValue(TAG_EAIDBCUSTOMID, "");
    }

    public void setEAIDBCUSTOMID(String strValue) {
        this.SetParamValue(TAG_EAIDBCUSTOMID, strValue);
    }

    public boolean isEAIDBCUSTOMNAMENull() {
        return this.IsParamNull(TAG_EAIDBCUSTOMNAME);
    }

    public String getEAIDBCUSTOMNAME() {
        return this.GetParamStringValue(TAG_EAIDBCUSTOMNAME, "");
    }

    public void setEAIDBCUSTOMNAME(String strValue) {
        this.SetParamValue(TAG_EAIDBCUSTOMNAME, strValue);
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

    public boolean isRAWCODENull() {
        return this.IsParamNull(TAG_RAWCODE);
    }

    public String getRAWCODE() {
        return this.GetParamStringValue(TAG_RAWCODE, "");
    }

    public void setRAWCODE(String strValue) {
        this.SetParamValue(TAG_RAWCODE, strValue);
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
}

