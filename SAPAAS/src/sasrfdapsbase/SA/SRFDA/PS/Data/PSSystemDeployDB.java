/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemDeployDB
extends BaseDataEntity {
    public static final String PSSYSDEPLOYDBNAME_DEFAULT = "DEFAULT";
    public static final String PSSYSDEPLOYDBNAME_DB1 = "DB1";
    public static final String PSSYSDEPLOYDBNAME_DB2 = "DB2";
    public static final String PSSYSDEPLOYDBNAME_DB3 = "DB3";
    public static final String PSSYSDEPLOYDBNAME_DB4 = "DB4";
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String TAG_PSSYSDEPLOYDBID = "PSSYSDEPLOYDBID";
    public static final String TAG_PSSYSDEPLOYDBNAME = "PSSYSDEPLOYDBNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSDEPLOYID = "PSSYSDEPLOYID";
    public static final String TAG_PSSYSDEPLOYNAME = "PSSYSDEPLOYNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_DBNAME = "DBNAME";

    public final boolean isPSSYSDEPLOYDBIDNull() {
        return this.IsParamNull(TAG_PSSYSDEPLOYDBID);
    }

    public final String getPSSYSDEPLOYDBID() {
        return this.GetParamStringValue(TAG_PSSYSDEPLOYDBID, "");
    }

    public final void setPSSYSDEPLOYDBID(String strValue) {
        this.SetParamValue(TAG_PSSYSDEPLOYDBID, strValue);
    }

    public final boolean isPSSYSDEPLOYDBNAMENull() {
        return this.IsParamNull(TAG_PSSYSDEPLOYDBNAME);
    }

    public final String getPSSYSDEPLOYDBNAME() {
        return this.GetParamStringValue(TAG_PSSYSDEPLOYDBNAME, "");
    }

    public final void setPSSYSDEPLOYDBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDEPLOYDBNAME, strValue);
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

    public final boolean isPSSYSDEPLOYIDNull() {
        return this.IsParamNull(TAG_PSSYSDEPLOYID);
    }

    public final String getPSSYSDEPLOYID() {
        return this.GetParamStringValue(TAG_PSSYSDEPLOYID, "");
    }

    public final void setPSSYSDEPLOYID(String strValue) {
        this.SetParamValue(TAG_PSSYSDEPLOYID, strValue);
    }

    public final boolean isPSSYSDEPLOYNAMENull() {
        return this.IsParamNull(TAG_PSSYSDEPLOYNAME);
    }

    public final String getPSSYSDEPLOYNAME() {
        return this.GetParamStringValue(TAG_PSSYSDEPLOYNAME, "");
    }

    public final void setPSSYSDEPLOYNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDEPLOYNAME, strValue);
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

    public final boolean isCONNSTRNull() {
        return this.IsParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.GetParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.SetParamValue(TAG_CONNSTR, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.IsParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.GetParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.SetParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }

    public final boolean isDBNAMENull() {
        return this.IsParamNull(TAG_DBNAME);
    }

    public final String getDBNAME() {
        return this.GetParamStringValue(TAG_DBNAME, "");
    }

    public final void setDBNAME(String strValue) {
        this.SetParamValue(TAG_DBNAME, strValue);
    }
}

