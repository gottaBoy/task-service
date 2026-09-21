/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBDevInst
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String USAGEMODE_DEVELOP = "DEVELOP";
    public static final String USAGEMODE_DEPLOY = "DEPLOY";
    public static final String USAGEMODE_JIT = "JIT";
    public static final int INSTSTATE_10 = 10;
    public static final int INSTSTATE_20 = 20;
    public static final int INSTSTATE_30 = 30;
    public static final int INSTSTATE_40 = 40;
    public static final String TAG_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String TAG_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_DBNAME = "DBNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDBSERVERID = "PSDBSERVERID";
    public static final String TAG_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String TAG_USAGEMODE = "USAGEMODE";
    public static final String TAG_USEDSIZE = "USEDSIZE";
    public static final String TAG_ALLOCSIZE = "ALLOCSIZE";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_INSTSTATE = "INSTSTATE";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_DMUSERNAME = "DMUSERNAME";
    public static final String TAG_DMPASSWD = "DMPASSWD";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_LOCALRES = "LOCALRES";
    public static final String TAG_TIMESHAREMODE = "TIMESHAREMODE";
    public static final String TAG_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String TAG_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String TAG_CONNSTRFMT = "CONNSTRFMT";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_DBSCHEMA = "DBSCHEMA";

    public final boolean isPSDBDEVINSTIDNull() {
        return this.IsParamNull(TAG_PSDBDEVINSTID);
    }

    public final String getPSDBDEVINSTID() {
        return this.GetParamStringValue(TAG_PSDBDEVINSTID, "");
    }

    public final void setPSDBDEVINSTID(String strValue) {
        this.SetParamValue(TAG_PSDBDEVINSTID, strValue);
    }

    public final boolean isPSDBDEVINSTNAMENull() {
        return this.IsParamNull(TAG_PSDBDEVINSTNAME);
    }

    public final String getPSDBDEVINSTNAME() {
        return this.GetParamStringValue(TAG_PSDBDEVINSTNAME, "");
    }

    public final void setPSDBDEVINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSDBDEVINSTNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPSDBSERVERIDNull() {
        return this.IsParamNull(TAG_PSDBSERVERID);
    }

    public final String getPSDBSERVERID() {
        return this.GetParamStringValue(TAG_PSDBSERVERID, "");
    }

    public final void setPSDBSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDBSERVERID, strValue);
    }

    public final boolean isPSDBSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDBSERVERNAME);
    }

    public final String getPSDBSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDBSERVERNAME, "");
    }

    public final void setPSDBSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDBSERVERNAME, strValue);
    }

    public final boolean isUSAGEMODENull() {
        return this.IsParamNull(TAG_USAGEMODE);
    }

    public final String getUSAGEMODE() {
        return this.GetParamStringValue(TAG_USAGEMODE, "");
    }

    public final void setUSAGEMODE(String strValue) {
        this.SetParamValue(TAG_USAGEMODE, strValue);
    }

    public final boolean isUSEDSIZENull() {
        return this.IsParamNull(TAG_USEDSIZE);
    }

    public final int getUSEDSIZE() {
        return this.GetParamIntValue(TAG_USEDSIZE, 0);
    }

    public final void setUSEDSIZE(int nValue) {
        this.SetParamValue(TAG_USEDSIZE, nValue);
    }

    public final boolean isALLOCSIZENull() {
        return this.IsParamNull(TAG_ALLOCSIZE);
    }

    public final int getALLOCSIZE() {
        return this.GetParamIntValue(TAG_ALLOCSIZE, 0);
    }

    public final void setALLOCSIZE(int nValue) {
        this.SetParamValue(TAG_ALLOCSIZE, nValue);
    }

    public final boolean isPSSVRDOMAINIDNull() {
        return this.IsParamNull(TAG_PSSVRDOMAINID);
    }

    public final String getPSSVRDOMAINID() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINID, "");
    }

    public final void setPSSVRDOMAINID(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINID, strValue);
    }

    public final boolean isPSSVRDOMAINNAMENull() {
        return this.IsParamNull(TAG_PSSVRDOMAINNAME);
    }

    public final String getPSSVRDOMAINNAME() {
        return this.GetParamStringValue(TAG_PSSVRDOMAINNAME, "");
    }

    public final void setPSSVRDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_PSSVRDOMAINNAME, strValue);
    }

    public final boolean isINSTSTATENull() {
        return this.IsParamNull(TAG_INSTSTATE);
    }

    public final int getINSTSTATE() {
        return this.GetParamIntValue(TAG_INSTSTATE, 0);
    }

    public final void setINSTSTATE(int nValue) {
        this.SetParamValue(TAG_INSTSTATE, nValue);
    }

    public final boolean isREFINFONull() {
        return this.IsParamNull(TAG_REFINFO);
    }

    public final String getREFINFO() {
        return this.GetParamStringValue(TAG_REFINFO, "");
    }

    public final void setREFINFO(String strValue) {
        this.SetParamValue(TAG_REFINFO, strValue);
    }

    public final boolean isDMUSERNAMENull() {
        return this.IsParamNull(TAG_DMUSERNAME);
    }

    public final String getDMUSERNAME() {
        return this.GetParamStringValue(TAG_DMUSERNAME, "");
    }

    public final void setDMUSERNAME(String strValue) {
        this.SetParamValue(TAG_DMUSERNAME, strValue);
    }

    public final boolean isDMPASSWDNull() {
        return this.IsParamNull(TAG_DMPASSWD);
    }

    public final String getDMPASSWD() {
        return this.GetParamStringValue(TAG_DMPASSWD, "");
    }

    public final void setDMPASSWD(String strValue) {
        this.SetParamValue(TAG_DMPASSWD, strValue);
    }

    public final boolean isPARAMNull() {
        return this.IsParamNull(TAG_PARAM);
    }

    public final String getPARAM() {
        return this.GetParamStringValue(TAG_PARAM, "");
    }

    public final void setPARAM(String strValue) {
        this.SetParamValue(TAG_PARAM, strValue);
    }

    public final boolean isPARAM2Null() {
        return this.IsParamNull(TAG_PARAM2);
    }

    public final String getPARAM2() {
        return this.GetParamStringValue(TAG_PARAM2, "");
    }

    public final void setPARAM2(String strValue) {
        this.SetParamValue(TAG_PARAM2, strValue);
    }

    public final boolean isPARAM3Null() {
        return this.IsParamNull(TAG_PARAM3);
    }

    public final String getPARAM3() {
        return this.GetParamStringValue(TAG_PARAM3, "");
    }

    public final void setPARAM3(String strValue) {
        this.SetParamValue(TAG_PARAM3, strValue);
    }

    public final boolean isPARAM4Null() {
        return this.IsParamNull(TAG_PARAM4);
    }

    public final String getPARAM4() {
        return this.GetParamStringValue(TAG_PARAM4, "");
    }

    public final void setPARAM4(String strValue) {
        this.SetParamValue(TAG_PARAM4, strValue);
    }

    public final boolean isPARAM5Null() {
        return this.IsParamNull(TAG_PARAM5);
    }

    public final int getPARAM5() {
        return this.GetParamIntValue(TAG_PARAM5, 0);
    }

    public final void setPARAM5(int nValue) {
        this.SetParamValue(TAG_PARAM5, nValue);
    }

    public final boolean isPARAM6Null() {
        return this.IsParamNull(TAG_PARAM6);
    }

    public final int getPARAM6() {
        return this.GetParamIntValue(TAG_PARAM6, 0);
    }

    public final void setPARAM6(int nValue) {
        this.SetParamValue(TAG_PARAM6, nValue);
    }

    public final boolean isPARAM7Null() {
        return this.IsParamNull(TAG_PARAM7);
    }

    public final int getPARAM7() {
        return this.GetParamIntValue(TAG_PARAM7, 0);
    }

    public final void setPARAM7(int nValue) {
        this.SetParamValue(TAG_PARAM7, nValue);
    }

    public final boolean isPARAM8Null() {
        return this.IsParamNull(TAG_PARAM8);
    }

    public final int getPARAM8() {
        return this.GetParamIntValue(TAG_PARAM8, 0);
    }

    public final void setPARAM8(int nValue) {
        this.SetParamValue(TAG_PARAM8, nValue);
    }

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isLOCALRESNull() {
        return this.IsParamNull(TAG_LOCALRES);
    }

    public final boolean getLOCALRES() {
        return this.GetParamIntValue(TAG_LOCALRES, 0) == 1;
    }

    public final void setLOCALRES(boolean bValue) {
        this.SetParamValue(TAG_LOCALRES, bValue ? 1 : 0);
    }

    public final boolean isTIMESHAREMODENull() {
        return this.IsParamNull(TAG_TIMESHAREMODE);
    }

    public final boolean getTIMESHAREMODE() {
        return this.GetParamIntValue(TAG_TIMESHAREMODE, 0) == 1;
    }

    public final void setTIMESHAREMODE(boolean bValue) {
        this.SetParamValue(TAG_TIMESHAREMODE, bValue ? 1 : 0);
    }

    public final boolean isPSAPPSERVERIDNull() {
        return this.IsParamNull(TAG_PSAPPSERVERID);
    }

    public final String getPSAPPSERVERID() {
        return this.GetParamStringValue(TAG_PSAPPSERVERID, "");
    }

    public final void setPSAPPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSAPPSERVERID, strValue);
    }

    public final boolean isPSAPPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSAPPSERVERNAME);
    }

    public final String getPSAPPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSAPPSERVERNAME, "");
    }

    public final void setPSAPPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSAPPSERVERNAME, strValue);
    }

    public final boolean isCONNSTRFMTNull() {
        return this.IsParamNull(TAG_CONNSTRFMT);
    }

    public final String getCONNSTRFMT() {
        return this.GetParamStringValue(TAG_CONNSTRFMT, "");
    }

    public final void setCONNSTRFMT(String strValue) {
        this.SetParamValue(TAG_CONNSTRFMT, strValue);
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

    public final boolean isDBSCHEMANull() {
        return this.IsParamNull(TAG_DBSCHEMA);
    }

    public final String getDBSCHEMA() {
        return this.GetParamStringValue(TAG_DBSCHEMA, "");
    }

    public final void setDBSCHEMA(String strValue) {
        this.SetParamValue(TAG_DBSCHEMA, strValue);
    }
}

