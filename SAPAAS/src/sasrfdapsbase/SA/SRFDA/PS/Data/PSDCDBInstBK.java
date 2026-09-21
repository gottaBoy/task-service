/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCDBInstBK
extends BaseDataEntity {
    public static final int BKMODE_10 = 10;
    public static final int BKMODE_20 = 20;
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String DBTYPE_POSTGRESQL = "POSTGRESQL";
    public static final String DBTYPE_PPAS = "PPAS";
    public static final int BKSTATE_10 = 10;
    public static final int BKSTATE_20 = 20;
    public static final int BKSTATE_30 = 30;
    public static final int BKSTATE_40 = 40;
    public static final String TAG_PSDCDBINSTBKID = "PSDCDBINSTBKID";
    public static final String TAG_PSDCDBINSTBKNAME = "PSDCDBINSTBKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String TAG_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String TAG_BACKUPSIZE = "BACKUPSIZE";
    public static final String TAG_BKMODE = "BKMODE";
    public static final String TAG_PPSDCDBINSTBKID = "PPSDCDBINSTBKID";
    public static final String TAG_PPSDCDBINSTBKNAME = "PPSDCDBINSTBKNAME";
    public static final String TAG_BKTIME = "BKTIME";
    public static final String TAG_PSDBDEVINSTBKID = "PSDBDEVINSTBKID";
    public static final String TAG_PSDBDEVINSTBKNAME = "PSDBDEVINSTBKNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_BKSTATE = "BKSTATE";
    public static final String TAG_BKINFO = "BKINFO";
    public static final String TAG_BKFILEPATH = "BKFILEPATH";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";

    public final boolean isPSDCDBINSTBKIDNull() {
        return this.IsParamNull(TAG_PSDCDBINSTBKID);
    }

    public final String getPSDCDBINSTBKID() {
        return this.GetParamStringValue(TAG_PSDCDBINSTBKID, "");
    }

    public final void setPSDCDBINSTBKID(String strValue) {
        this.SetParamValue(TAG_PSDCDBINSTBKID, strValue);
    }

    public final boolean isPSDCDBINSTBKNAMENull() {
        return this.IsParamNull(TAG_PSDCDBINSTBKNAME);
    }

    public final String getPSDCDBINSTBKNAME() {
        return this.GetParamStringValue(TAG_PSDCDBINSTBKNAME, "");
    }

    public final void setPSDCDBINSTBKNAME(String strValue) {
        this.SetParamValue(TAG_PSDCDBINSTBKNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDEVCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERID);
    }

    public final String getPSDEVCENTERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERID, "");
    }

    public final void setPSDEVCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERID, strValue);
    }

    public final boolean isPSDEVCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERNAME);
    }

    public final String getPSDEVCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERNAME, "");
    }

    public final void setPSDEVCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERNAME, strValue);
    }

    public final boolean isPSDEVCENTERDBINSTIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTID);
    }

    public final String getPSDEVCENTERDBINSTID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTID, "");
    }

    public final void setPSDEVCENTERDBINSTID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTID, strValue);
    }

    public final boolean isPSDEVCENTERDBINSTNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERDBINSTNAME);
    }

    public final String getPSDEVCENTERDBINSTNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERDBINSTNAME, "");
    }

    public final void setPSDEVCENTERDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERDBINSTNAME, strValue);
    }

    public final boolean isBACKUPSIZENull() {
        return this.IsParamNull(TAG_BACKUPSIZE);
    }

    public final int getBACKUPSIZE() {
        return this.GetParamIntValue(TAG_BACKUPSIZE, 0);
    }

    public final void setBACKUPSIZE(int nValue) {
        this.SetParamValue(TAG_BACKUPSIZE, nValue);
    }

    public final boolean isBKMODENull() {
        return this.IsParamNull(TAG_BKMODE);
    }

    public final int getBKMODE() {
        return this.GetParamIntValue(TAG_BKMODE, 0);
    }

    public final void setBKMODE(int nValue) {
        this.SetParamValue(TAG_BKMODE, nValue);
    }

    public final boolean isPPSDCDBINSTBKIDNull() {
        return this.IsParamNull(TAG_PPSDCDBINSTBKID);
    }

    public final String getPPSDCDBINSTBKID() {
        return this.GetParamStringValue(TAG_PPSDCDBINSTBKID, "");
    }

    public final void setPPSDCDBINSTBKID(String strValue) {
        this.SetParamValue(TAG_PPSDCDBINSTBKID, strValue);
    }

    public final boolean isPPSDCDBINSTBKNAMENull() {
        return this.IsParamNull(TAG_PPSDCDBINSTBKNAME);
    }

    public final String getPPSDCDBINSTBKNAME() {
        return this.GetParamStringValue(TAG_PPSDCDBINSTBKNAME, "");
    }

    public final void setPPSDCDBINSTBKNAME(String strValue) {
        this.SetParamValue(TAG_PPSDCDBINSTBKNAME, strValue);
    }

    public final boolean isBKTIMENull() {
        return this.IsParamNull(TAG_BKTIME);
    }

    public final Date getBKTIME() {
        return this.GetParamDateValue(TAG_BKTIME, null);
    }

    public final void setBKTIME(Date dtValue) {
        this.SetParamValue(TAG_BKTIME, dtValue);
    }

    public final boolean isPSDBDEVINSTBKIDNull() {
        return this.IsParamNull(TAG_PSDBDEVINSTBKID);
    }

    public final String getPSDBDEVINSTBKID() {
        return this.GetParamStringValue(TAG_PSDBDEVINSTBKID, "");
    }

    public final void setPSDBDEVINSTBKID(String strValue) {
        this.SetParamValue(TAG_PSDBDEVINSTBKID, strValue);
    }

    public final boolean isPSDBDEVINSTBKNAMENull() {
        return this.IsParamNull(TAG_PSDBDEVINSTBKNAME);
    }

    public final String getPSDBDEVINSTBKNAME() {
        return this.GetParamStringValue(TAG_PSDBDEVINSTBKNAME, "");
    }

    public final void setPSDBDEVINSTBKNAME(String strValue) {
        this.SetParamValue(TAG_PSDBDEVINSTBKNAME, strValue);
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

    public final boolean isBKSTATENull() {
        return this.IsParamNull(TAG_BKSTATE);
    }

    public final int getBKSTATE() {
        return this.GetParamIntValue(TAG_BKSTATE, 0);
    }

    public final void setBKSTATE(int nValue) {
        this.SetParamValue(TAG_BKSTATE, nValue);
    }

    public final boolean isBKINFONull() {
        return this.IsParamNull(TAG_BKINFO);
    }

    public final String getBKINFO() {
        return this.GetParamStringValue(TAG_BKINFO, "");
    }

    public final void setBKINFO(String strValue) {
        this.SetParamValue(TAG_BKINFO, strValue);
    }

    public final boolean isBKFILEPATHNull() {
        return this.IsParamNull(TAG_BKFILEPATH);
    }

    public final String getBKFILEPATH() {
        return this.GetParamStringValue(TAG_BKFILEPATH, "");
    }

    public final void setBKFILEPATH(String strValue) {
        this.SetParamValue(TAG_BKFILEPATH, strValue);
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

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }
}

