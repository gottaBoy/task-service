/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDMItem
extends BaseDataEntity {
    public static final String DBOBJTYPE_TABLE = "TABLE";
    public static final String DBOBJTYPE_COLUMN = "COLUMN";
    public static final String DBOBJTYPE_VIEW = "VIEW";
    public static final String DBOBJTYPE_FKEY = "FKEY";
    public static final String DBOBJTYPE_INDEX = "INDEX";
    public static final String PSSYSTEMDBCFGNAME_MYSQL5 = "MYSQL5";
    public static final String PSSYSTEMDBCFGNAME_DB2 = "DB2";
    public static final String PSSYSTEMDBCFGNAME_ORACLE = "ORACLE";
    public static final String PSSYSTEMDBCFGNAME_SQLSERVER = "SQLSERVER";
    public static final String TAG_PSSYSDMITEMID = "PSSYSDMITEMID";
    public static final String TAG_PSSYSDMITEMNAME = "PSSYSDMITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBOBJTYPE = "DBOBJTYPE";
    public static final String TAG_USERFLAG = "USERFLAG";
    public static final String TAG_DROPSQL = "DROPSQL";
    public static final String TAG_CREATESQL = "CREATESQL";
    public static final String TAG_TESTSQL = "TESTSQL";
    public static final String TAG_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String TAG_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEID = "PSDEID";
    public static final String TAG_PSDENAME = "PSDENAME";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_CREATESQL2 = "CREATESQL2";
    public static final String TAG_CREATESQL3 = "CREATESQL3";
    public static final String TAG_CREATESQL4 = "CREATESQL4";
    public static final String TAG_CREATESQL5 = "CREATESQL5";
    public static final String TAG_CREATESQL6 = "CREATESQL6";
    public static final String TAG_CREATESQL7 = "CREATESQL7";
    public static final String TAG_PSSYSDMVERID = "PSSYSDMVERID";
    public static final String TAG_PSSYSDMVERNAME = "PSSYSDMVERNAME";

    public final boolean isPSSYSDMITEMIDNull() {
        return this.IsParamNull(TAG_PSSYSDMITEMID);
    }

    public final String getPSSYSDMITEMID() {
        return this.GetParamStringValue(TAG_PSSYSDMITEMID, "");
    }

    public final void setPSSYSDMITEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSDMITEMID, strValue);
    }

    public final boolean isPSSYSDMITEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSDMITEMNAME);
    }

    public final String getPSSYSDMITEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSDMITEMNAME, "");
    }

    public final void setPSSYSDMITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDMITEMNAME, strValue);
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

    public final boolean isDBOBJTYPENull() {
        return this.IsParamNull(TAG_DBOBJTYPE);
    }

    public final String getDBOBJTYPE() {
        return this.GetParamStringValue(TAG_DBOBJTYPE, "");
    }

    public final void setDBOBJTYPE(String strValue) {
        this.SetParamValue(TAG_DBOBJTYPE, strValue);
    }

    public final boolean isUSERFLAGNull() {
        return this.IsParamNull(TAG_USERFLAG);
    }

    public final boolean getUSERFLAG() {
        return this.GetParamIntValue(TAG_USERFLAG, 0) == 1;
    }

    public final void setUSERFLAG(boolean bValue) {
        this.SetParamValue(TAG_USERFLAG, bValue ? 1 : 0);
    }

    public final boolean isDROPSQLNull() {
        return this.IsParamNull(TAG_DROPSQL);
    }

    public final String getDROPSQL() {
        return this.GetParamStringValue(TAG_DROPSQL, "");
    }

    public final void setDROPSQL(String strValue) {
        this.SetParamValue(TAG_DROPSQL, strValue);
    }

    public final boolean isCREATESQLNull() {
        return this.IsParamNull(TAG_CREATESQL);
    }

    public final String getCREATESQL() {
        return this.GetParamStringValue(TAG_CREATESQL, "");
    }

    public final void setCREATESQL(String strValue) {
        this.SetParamValue(TAG_CREATESQL, strValue);
    }

    public final boolean isTESTSQLNull() {
        return this.IsParamNull(TAG_TESTSQL);
    }

    public final String getTESTSQL() {
        return this.GetParamStringValue(TAG_TESTSQL, "");
    }

    public final void setTESTSQL(String strValue) {
        this.SetParamValue(TAG_TESTSQL, strValue);
    }

    public final boolean isPSSYSTEMDBCFGIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGID);
    }

    public final String getPSSYSTEMDBCFGID() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGID, "");
    }

    public final void setPSSYSTEMDBCFGID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGID, strValue);
    }

    public final boolean isPSSYSTEMDBCFGNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMDBCFGNAME);
    }

    public final String getPSSYSTEMDBCFGNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMDBCFGNAME, "");
    }

    public final void setPSSYSTEMDBCFGNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMDBCFGNAME, strValue);
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

    public final boolean isPSDEIDNull() {
        return this.IsParamNull(TAG_PSDEID);
    }

    public final String getPSDEID() {
        return this.GetParamStringValue(TAG_PSDEID, "");
    }

    public final void setPSDEID(String strValue) {
        this.SetParamValue(TAG_PSDEID, strValue);
    }

    public final boolean isPSDENAMENull() {
        return this.IsParamNull(TAG_PSDENAME);
    }

    public final String getPSDENAME() {
        return this.GetParamStringValue(TAG_PSDENAME, "");
    }

    public final void setPSDENAME(String strValue) {
        this.SetParamValue(TAG_PSDENAME, strValue);
    }

    public final boolean isPSOBJIDNull() {
        return this.IsParamNull(TAG_PSOBJID);
    }

    public final String getPSOBJID() {
        return this.GetParamStringValue(TAG_PSOBJID, "");
    }

    public final void setPSOBJID(String strValue) {
        this.SetParamValue(TAG_PSOBJID, strValue);
    }

    public final boolean isPSOBJNAMENull() {
        return this.IsParamNull(TAG_PSOBJNAME);
    }

    public final String getPSOBJNAME() {
        return this.GetParamStringValue(TAG_PSOBJNAME, "");
    }

    public final void setPSOBJNAME(String strValue) {
        this.SetParamValue(TAG_PSOBJNAME, strValue);
    }

    public final boolean isCREATESQL2Null() {
        return this.IsParamNull(TAG_CREATESQL2);
    }

    public final String getCREATESQL2() {
        return this.GetParamStringValue(TAG_CREATESQL2, "");
    }

    public final void setCREATESQL2(String strValue) {
        this.SetParamValue(TAG_CREATESQL2, strValue);
    }

    public final boolean isCREATESQL3Null() {
        return this.IsParamNull(TAG_CREATESQL3);
    }

    public final String getCREATESQL3() {
        return this.GetParamStringValue(TAG_CREATESQL3, "");
    }

    public final void setCREATESQL3(String strValue) {
        this.SetParamValue(TAG_CREATESQL3, strValue);
    }

    public final boolean isCREATESQL4Null() {
        return this.IsParamNull(TAG_CREATESQL4);
    }

    public final String getCREATESQL4() {
        return this.GetParamStringValue(TAG_CREATESQL4, "");
    }

    public final void setCREATESQL4(String strValue) {
        this.SetParamValue(TAG_CREATESQL4, strValue);
    }

    public final boolean isCREATESQL5Null() {
        return this.IsParamNull(TAG_CREATESQL5);
    }

    public final String getCREATESQL5() {
        return this.GetParamStringValue(TAG_CREATESQL5, "");
    }

    public final void setCREATESQL5(String strValue) {
        this.SetParamValue(TAG_CREATESQL5, strValue);
    }

    public final boolean isCREATESQL6Null() {
        return this.IsParamNull(TAG_CREATESQL6);
    }

    public final String getCREATESQL6() {
        return this.GetParamStringValue(TAG_CREATESQL6, "");
    }

    public final void setCREATESQL6(String strValue) {
        this.SetParamValue(TAG_CREATESQL6, strValue);
    }

    public final boolean isCREATESQL7Null() {
        return this.IsParamNull(TAG_CREATESQL7);
    }

    public final String getCREATESQL7() {
        return this.GetParamStringValue(TAG_CREATESQL7, "");
    }

    public final void setCREATESQL7(String strValue) {
        this.SetParamValue(TAG_CREATESQL7, strValue);
    }

    public final boolean isPSSYSDMVERIDNull() {
        return this.IsParamNull(TAG_PSSYSDMVERID);
    }

    public final String getPSSYSDMVERID() {
        return this.GetParamStringValue(TAG_PSSYSDMVERID, "");
    }

    public final void setPSSYSDMVERID(String strValue) {
        this.SetParamValue(TAG_PSSYSDMVERID, strValue);
    }

    public final boolean isPSSYSDMVERNAMENull() {
        return this.IsParamNull(TAG_PSSYSDMVERNAME);
    }

    public final String getPSSYSDMVERNAME() {
        return this.GetParamStringValue(TAG_PSSYSDMVERNAME, "");
    }

    public final void setPSSYSDMVERNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDMVERNAME, strValue);
    }
}

