/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSystemRun
extends BaseDataEntity {
    public static final String PSSYSTEMDBCFGNAME_MYSQL5 = "MYSQL5";
    public static final String PSSYSTEMDBCFGNAME_DB2 = "DB2";
    public static final String PSSYSTEMDBCFGNAME_ORACLE = "ORACLE";
    public static final String PSSYSTEMDBCFGNAME_SQLSERVER = "SQLSERVER";
    public static final String TAG_PSSYSTEMRUNID = "PSSYSTEMRUNID";
    public static final String TAG_PSSYSTEMRUNNAME = "PSSYSTEMRUNNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String TAG_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String TAG_PSSYSAPPID2 = "PSSYSAPPID2";
    public static final String TAG_PSSYSAPPNAME2 = "PSSYSAPPNAME2";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMASID = "PSSYSTEMASID";
    public static final String TAG_PSSYSTEMASNAME = "PSSYSTEMASNAME";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String TAG_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";

    public final boolean isPSSYSTEMRUNIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMRUNID);
    }

    public final String getPSSYSTEMRUNID() {
        return this.GetParamStringValue(TAG_PSSYSTEMRUNID, "");
    }

    public final void setPSSYSTEMRUNID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMRUNID, strValue);
    }

    public final boolean isPSSYSTEMRUNNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMRUNNAME);
    }

    public final String getPSSYSTEMRUNNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMRUNNAME, "");
    }

    public final void setPSSYSTEMRUNNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMRUNNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPSSYSSFPUBIDNull() {
        return this.IsParamNull(TAG_PSSYSSFPUBID);
    }

    public final String getPSSYSSFPUBID() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBID, "");
    }

    public final void setPSSYSSFPUBID(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBID, strValue);
    }

    public final boolean isPSSYSSFPUBNAMENull() {
        return this.IsParamNull(TAG_PSSYSSFPUBNAME);
    }

    public final String getPSSYSSFPUBNAME() {
        return this.GetParamStringValue(TAG_PSSYSSFPUBNAME, "");
    }

    public final void setPSSYSSFPUBNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSSFPUBNAME, strValue);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSSYSAPPNAME);
    }

    public final String getPSSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME, "");
    }

    public final void setPSSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME, strValue);
    }

    public final boolean isPSSYSAPPID2Null() {
        return this.IsParamNull(TAG_PSSYSAPPID2);
    }

    public final String getPSSYSAPPID2() {
        return this.GetParamStringValue(TAG_PSSYSAPPID2, "");
    }

    public final void setPSSYSAPPID2(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID2, strValue);
    }

    public final boolean isPSSYSAPPNAME2Null() {
        return this.IsParamNull(TAG_PSSYSAPPNAME2);
    }

    public final String getPSSYSAPPNAME2() {
        return this.GetParamStringValue(TAG_PSSYSAPPNAME2, "");
    }

    public final void setPSSYSAPPNAME2(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPNAME2, strValue);
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

    public final boolean isPSSYSTEMASIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMASID);
    }

    public final String getPSSYSTEMASID() {
        return this.GetParamStringValue(TAG_PSSYSTEMASID, "");
    }

    public final void setPSSYSTEMASID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMASID, strValue);
    }

    public final boolean isPSSYSTEMASNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMASNAME);
    }

    public final String getPSSYSTEMASNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMASNAME, "");
    }

    public final void setPSSYSTEMASNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMASNAME, strValue);
    }

    public final boolean isDEFAULTFLAGNull() {
        return this.IsParamNull(TAG_DEFAULTFLAG);
    }

    public final boolean getDEFAULTFLAG() {
        return this.GetParamIntValue(TAG_DEFAULTFLAG, 0) == 1;
    }

    public final void setDEFAULTFLAG(boolean bValue) {
        this.SetParamValue(TAG_DEFAULTFLAG, bValue ? 1 : 0);
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
}

