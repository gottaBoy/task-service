/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysModelVer
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String SYSTYPE_DEVSYS = "DEVSYS";
    public static final String SYSTYPE_DEPSYS = "DEPSYS";
    public static final String TAG_PSSYSMODELVERID = "PSSYSMODELVERID";
    public static final String TAG_PSSYSMODELVERNAME = "PSSYSMODELVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_MODELSQL = "MODELSQL";
    public static final String TAG_MODELVER = "MODELVER";
    public static final String TAG_DATASQL = "DATASQL";
    public static final String TAG_ACTIVEFLAG = "ACTIVEFLAG";
    public static final String TAG_MODELSQL2 = "MODELSQL2";
    public static final String TAG_MODELSQL3 = "MODELSQL3";
    public static final String TAG_MODELSQL4 = "MODELSQL4";
    public static final String TAG_SYSTYPE = "SYSTYPE";

    public final boolean isPSSYSMODELVERIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELVERID);
    }

    public final String getPSSYSMODELVERID() {
        return this.GetParamStringValue(TAG_PSSYSMODELVERID, "");
    }

    public final void setPSSYSMODELVERID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELVERID, strValue);
    }

    public final boolean isPSSYSMODELVERNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELVERNAME);
    }

    public final String getPSSYSMODELVERNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELVERNAME, "");
    }

    public final void setPSSYSMODELVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELVERNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.IsParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.IsParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.SetParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.IsParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.IsParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.SetParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isDBTYPENull() {
        return this.IsParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.GetParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.SetParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isMODELSQLNull() {
        return this.IsParamNull(TAG_MODELSQL);
    }

    public final String getMODELSQL() {
        return this.GetParamStringValue(TAG_MODELSQL, "");
    }

    public final void setMODELSQL(String strValue) {
        this.SetParamValue(TAG_MODELSQL, strValue);
    }

    public final boolean isMODELVERNull() {
        return this.IsParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.GetParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.SetParamValue(TAG_MODELVER, nValue);
    }

    public final boolean isDATASQLNull() {
        return this.IsParamNull(TAG_DATASQL);
    }

    public final String getDATASQL() {
        return this.GetParamStringValue(TAG_DATASQL, "");
    }

    public final void setDATASQL(String strValue) {
        this.SetParamValue(TAG_DATASQL, strValue);
    }

    public final boolean isACTIVEFLAGNull() {
        return this.IsParamNull(TAG_ACTIVEFLAG);
    }

    public final boolean getACTIVEFLAG() {
        return this.GetParamIntValue(TAG_ACTIVEFLAG, 0) == 1;
    }

    public final void setACTIVEFLAG(boolean bValue) {
        this.SetParamValue(TAG_ACTIVEFLAG, bValue ? 1 : 0);
    }

    public final boolean isMODELSQL2Null() {
        return this.IsParamNull(TAG_MODELSQL2);
    }

    public final String getMODELSQL2() {
        return this.GetParamStringValue(TAG_MODELSQL2, "");
    }

    public final void setMODELSQL2(String strValue) {
        this.SetParamValue(TAG_MODELSQL2, strValue);
    }

    public final boolean isMODELSQL3Null() {
        return this.IsParamNull(TAG_MODELSQL3);
    }

    public final String getMODELSQL3() {
        return this.GetParamStringValue(TAG_MODELSQL3, "");
    }

    public final void setMODELSQL3(String strValue) {
        this.SetParamValue(TAG_MODELSQL3, strValue);
    }

    public final boolean isMODELSQL4Null() {
        return this.IsParamNull(TAG_MODELSQL4);
    }

    public final String getMODELSQL4() {
        return this.GetParamStringValue(TAG_MODELSQL4, "");
    }

    public final void setMODELSQL4(String strValue) {
        this.SetParamValue(TAG_MODELSQL4, strValue);
    }

    public final boolean isSYSTYPENull() {
        return this.IsParamNull(TAG_SYSTYPE);
    }

    public final String getSYSTYPE() {
        return this.GetParamStringValue(TAG_SYSTYPE, "");
    }

    public final void setSYSTYPE(String strValue) {
        this.SetParamValue(TAG_SYSTYPE, strValue);
    }
}

