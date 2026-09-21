/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnSys
extends BaseDataEntity {
    public static final String TEMPLENGINE_DEFAULT = "DEFAULT";
    public static final String TEMPLENGINE_V2 = "V2";
    public static final String DBTYPES_DB2 = "DB2";
    public static final String DBTYPES_MYSQL5 = "MYSQL5";
    public static final String DBTYPES_ORACLE = "ORACLE";
    public static final String DBTYPES_SQLSERVER = "SQLSERVER";
    public static final String VCTYPE_TRUNK = "TRUNK";
    public static final String VCTYPE_BRANCH = "BRANCH";
    public static final String VCTYPE_TAG = "TAG";
    public static final String DEPLOYSYSTYPE_ORGWFSYS = "ORGWFSYS";
    public static final String DEPLOYSYSTYPE_ORGSECTORWFSYS = "ORGSECTORWFSYS";
    public static final String DEPLOYSYSTYPE_USER = "USER";
    public static final String DEPLOYSYSTYPE_USER2 = "USER2";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_CODENAME = "CODENAME";
    public static final String TAG_DBTYPES = "DBTYPES";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_SYSFOLDER = "SYSFOLDER";
    public static final String TAG_SYSVER = "SYSVER";
    public static final String TAG_DBVERSION = "DBVERSION";
    public static final String TAG_PSSFID = "PSSFID";
    public static final String TAG_PSSFNAME = "PSSFNAME";
    public static final String TAG_MODELPREFIX = "MODELPREFIX";
    public static final String TAG_ENABLEMYSQL5 = "ENABLEMYSQL5";
    public static final String TAG_ENABLEDB2 = "ENABLEDB2";
    public static final String TAG_ENABLESQLSERVER = "ENABLESQLSERVER";
    public static final String TAG_ENABLEORACLE = "ENABLEORACLE";
    public static final String TAG_MYSQLPSDCDBINSTID = "MYSQLPSDCDBINSTID";
    public static final String TAG_MYSQLPSDCDBINSTNAME = "MYSQLPSDCDBINSTNAME";
    public static final String TAG_DB2PSDCDBINSTID = "DB2PSDCDBINSTID";
    public static final String TAG_DB2PSDCDBINSTNAME = "DB2PSDCDBINSTNAME";
    public static final String TAG_MSSQLPSDCDBINSTID = "MSSQLPSDCDBINSTID";
    public static final String TAG_MSSQLPSDCDBINSTNAME = "MSSQLPSDCDBINSTNAME";
    public static final String TAG_ORAPSDCDBINSTID = "ORAPSDCDBINSTID";
    public static final String TAG_ORAPSDCDBINSTNAME = "ORAPSDCDBINSTNAME";
    public static final String TAG_PSDEVCENTERSVNID = "PSDEVCENTERSVNID";
    public static final String TAG_PSDEVCENTERSVNNAME = "PSDEVCENTERSVNNAME";
    public static final String TAG_SFPSSUBSYSID = "SFPSSUBSYSID";
    public static final String TAG_SFPSSUBSYSNAME = "SFPSSUBSYSNAME";
    public static final String TAG_VCTYPE = "VCTYPE";
    public static final String TAG_PPSDEVSLNSYSID = "PPSDEVSLNSYSID";
    public static final String TAG_PPSDEVSLNSYSNAME = "PPSDEVSLNSYSNAME";
    public static final String TAG_MAINPSDEVSLNSYSID = "MAINPSDEVSLNSYSID";
    public static final String TAG_MAINPSDEVSLNSYSNAME = "MAINPSDEVSLNSYSNAME";
    public static final String TAG_ROPSDEVCENTERSVNID = "ROPSDEVCENTERSVNID";
    public static final String TAG_ROPSDEVCENTERSVNNAME = "ROPSDEVCENTERSVNNAME";
    public static final String TAG_PSDEVCENTERASID3 = "PSDEVCENTERASID3";
    public static final String TAG_PSDEVCENTERASNAME3 = "PSDEVCENTERASNAME3";
    public static final String TAG_PSDEVCENTERASID4 = "PSDEVCENTERASID4";
    public static final String TAG_PSDEVCENTERASNAME4 = "PSDEVCENTERASNAME4";
    public static final String TAG_MODELINSTVER = "MODELINSTVER";
    public static final String TAG_JITPSDBDEVINSTID = "JITPSDBDEVINSTID";
    public static final String TAG_JITPSDBDEVINSTNAME = "JITPSDBDEVINSTNAME";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVSLNSYSRESID = "PSDEVSLNSYSRESID";
    public static final String TAG_PSDEVSLNSYSRESNAME = "PSDEVSLNSYSRESNAME";
    public static final String TAG_ENABLEWSSERVER = "ENABLEWSSERVER";
    public static final String TAG_ENABLEDEPLOYCENTER = "ENABLEDEPLOYCENTER";
    public static final String TAG_TEMPLENGINE = "TEMPLENGINE";
    public static final String TAG_ENABLEFOLDERKEY = "ENABLEFOLDERKEY";
    public static final String TAG_SYSROWKEY = "SYSROWKEY";
    public static final String TAG_SHAREFLAG = "SHAREFLAG";
    public static final String TAG_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String TAG_SYSTAG3 = "SYSTAG3";
    public static final String TAG_SYSTAG4 = "SYSTAG4";
    public static final String TAG_CALLBACKURL = "CALLBACKURL";
    public static final String TAG_CALLBACKTAG = "CALLBACKTAG";
    public static final String TAG_ENABLECALLBACK = "ENABLECALLBACK";
    public static final String TAG_DEPLOYSYSID = "DEPLOYSYSID";
    public static final String TAG_DEPLOYSYSTAG = "DEPLOYSYSTAG";
    public static final String TAG_DEPLOYSYSTAG2 = "DEPLOYSYSTAG2";
    public static final String TAG_SYSTAG = "SYSTAG";
    public static final String TAG_SYSTAG2 = "SYSTAG2";
    public static final String TAG_DEPLOYSYSTYPE = "DEPLOYSYSTYPE";
    public static final String TAG_DEPLOYSYSORGID = "DEPLOYSYSORGID";
    public static final String TAG_DEPLOYSYSORGSECTORID = "DEPLOYSYSORGSECTORID";
    public static final String TAG_OFFLINETIME = "OFFLINETIME";
    public static final String TAG_RTMODELPSDEVCENTERSVNID = "RTMODELPSDEVCENTERSVNID";
    public static final String TAG_RTMODELPSDEVCENTERSVNNAME = "RTMODELPSDEVCENTERSVNNAME";
    public static final String TAG_DOCPSDEVCENTERSVNID = "DOCPSDEVCENTERSVNID";
    public static final String TAG_DOCPSDEVCENTERSVNNAME = "DOCPSDEVCENTERSVNNAME";
    public static final String TAG_PSDCDEPLOYCENTERID = "PSDCDEPLOYCENTERID";
    public static final String TAG_PSDCDEPLOYCENTERNAME = "PSDCDEPLOYCENTERNAME";
    public static final String TAG_SYSTYPE = "SYSTYPE";

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
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

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isPSDEVSLNIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNID);
    }

    public final String getPSDEVSLNID() {
        return this.GetParamStringValue(TAG_PSDEVSLNID, "");
    }

    public final void setPSDEVSLNID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNID, strValue);
    }

    public final boolean isPSDEVSLNNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNNAME);
    }

    public final String getPSDEVSLNNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNNAME, "");
    }

    public final void setPSDEVSLNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isCODENAMENull() {
        return this.IsParamNull(TAG_CODENAME);
    }

    public final String getCODENAME() {
        return this.GetParamStringValue(TAG_CODENAME, "");
    }

    public final void setCODENAME(String strValue) {
        this.SetParamValue(TAG_CODENAME, strValue);
    }

    public final boolean isDBTYPESNull() {
        return this.IsParamNull(TAG_DBTYPES);
    }

    public final String getDBTYPES() {
        return this.GetParamStringValue(TAG_DBTYPES, "");
    }

    public final void setDBTYPES(String strValue) {
        this.SetParamValue(TAG_DBTYPES, strValue);
    }

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isSYSFOLDERNull() {
        return this.IsParamNull(TAG_SYSFOLDER);
    }

    public final String getSYSFOLDER() {
        return this.GetParamStringValue(TAG_SYSFOLDER, "");
    }

    public final void setSYSFOLDER(String strValue) {
        this.SetParamValue(TAG_SYSFOLDER, strValue);
    }

    public final boolean isSYSVERNull() {
        return this.IsParamNull(TAG_SYSVER);
    }

    public final String getSYSVER() {
        return this.GetParamStringValue(TAG_SYSVER, "");
    }

    public final void setSYSVER(String strValue) {
        this.SetParamValue(TAG_SYSVER, strValue);
    }

    public final boolean isDBVERSIONNull() {
        return this.IsParamNull(TAG_DBVERSION);
    }

    public final int getDBVERSION() {
        return this.GetParamIntValue(TAG_DBVERSION, 0);
    }

    public final void setDBVERSION(int nValue) {
        this.SetParamValue(TAG_DBVERSION, nValue);
    }

    public final boolean isPSSFIDNull() {
        return this.IsParamNull(TAG_PSSFID);
    }

    public final String getPSSFID() {
        return this.GetParamStringValue(TAG_PSSFID, "");
    }

    public final void setPSSFID(String strValue) {
        this.SetParamValue(TAG_PSSFID, strValue);
    }

    public final boolean isPSSFNAMENull() {
        return this.IsParamNull(TAG_PSSFNAME);
    }

    public final String getPSSFNAME() {
        return this.GetParamStringValue(TAG_PSSFNAME, "");
    }

    public final void setPSSFNAME(String strValue) {
        this.SetParamValue(TAG_PSSFNAME, strValue);
    }

    public final boolean isMODELPREFIXNull() {
        return this.IsParamNull(TAG_MODELPREFIX);
    }

    public final String getMODELPREFIX() {
        return this.GetParamStringValue(TAG_MODELPREFIX, "");
    }

    public final void setMODELPREFIX(String strValue) {
        this.SetParamValue(TAG_MODELPREFIX, strValue);
    }

    public final boolean isENABLEMYSQL5Null() {
        return this.IsParamNull(TAG_ENABLEMYSQL5);
    }

    public final boolean getENABLEMYSQL5() {
        return this.GetParamIntValue(TAG_ENABLEMYSQL5, 0) == 1;
    }

    public final void setENABLEMYSQL5(boolean bValue) {
        this.SetParamValue(TAG_ENABLEMYSQL5, bValue ? 1 : 0);
    }

    public final boolean isENABLEDB2Null() {
        return this.IsParamNull(TAG_ENABLEDB2);
    }

    public final boolean getENABLEDB2() {
        return this.GetParamIntValue(TAG_ENABLEDB2, 0) == 1;
    }

    public final void setENABLEDB2(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDB2, bValue ? 1 : 0);
    }

    public final boolean isENABLESQLSERVERNull() {
        return this.IsParamNull(TAG_ENABLESQLSERVER);
    }

    public final boolean getENABLESQLSERVER() {
        return this.GetParamIntValue(TAG_ENABLESQLSERVER, 0) == 1;
    }

    public final void setENABLESQLSERVER(boolean bValue) {
        this.SetParamValue(TAG_ENABLESQLSERVER, bValue ? 1 : 0);
    }

    public final boolean isENABLEORACLENull() {
        return this.IsParamNull(TAG_ENABLEORACLE);
    }

    public final boolean getENABLEORACLE() {
        return this.GetParamIntValue(TAG_ENABLEORACLE, 0) == 1;
    }

    public final void setENABLEORACLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLEORACLE, bValue ? 1 : 0);
    }

    public final boolean isMYSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_MYSQLPSDCDBINSTID);
    }

    public final String getMYSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_MYSQLPSDCDBINSTID, "");
    }

    public final void setMYSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_MYSQLPSDCDBINSTID, strValue);
    }

    public final boolean isMYSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_MYSQLPSDCDBINSTNAME);
    }

    public final String getMYSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_MYSQLPSDCDBINSTNAME, "");
    }

    public final void setMYSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_MYSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isDB2PSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_DB2PSDCDBINSTID);
    }

    public final String getDB2PSDCDBINSTID() {
        return this.GetParamStringValue(TAG_DB2PSDCDBINSTID, "");
    }

    public final void setDB2PSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_DB2PSDCDBINSTID, strValue);
    }

    public final boolean isDB2PSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_DB2PSDCDBINSTNAME);
    }

    public final String getDB2PSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_DB2PSDCDBINSTNAME, "");
    }

    public final void setDB2PSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_DB2PSDCDBINSTNAME, strValue);
    }

    public final boolean isMSSQLPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_MSSQLPSDCDBINSTID);
    }

    public final String getMSSQLPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_MSSQLPSDCDBINSTID, "");
    }

    public final void setMSSQLPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_MSSQLPSDCDBINSTID, strValue);
    }

    public final boolean isMSSQLPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_MSSQLPSDCDBINSTNAME);
    }

    public final String getMSSQLPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_MSSQLPSDCDBINSTNAME, "");
    }

    public final void setMSSQLPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_MSSQLPSDCDBINSTNAME, strValue);
    }

    public final boolean isORAPSDCDBINSTIDNull() {
        return this.IsParamNull(TAG_ORAPSDCDBINSTID);
    }

    public final String getORAPSDCDBINSTID() {
        return this.GetParamStringValue(TAG_ORAPSDCDBINSTID, "");
    }

    public final void setORAPSDCDBINSTID(String strValue) {
        this.SetParamValue(TAG_ORAPSDCDBINSTID, strValue);
    }

    public final boolean isORAPSDCDBINSTNAMENull() {
        return this.IsParamNull(TAG_ORAPSDCDBINSTNAME);
    }

    public final String getORAPSDCDBINSTNAME() {
        return this.GetParamStringValue(TAG_ORAPSDCDBINSTNAME, "");
    }

    public final void setORAPSDCDBINSTNAME(String strValue) {
        this.SetParamValue(TAG_ORAPSDCDBINSTNAME, strValue);
    }

    public final boolean isPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNID);
    }

    public final String getPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNID, "");
    }

    public final void setPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNID, strValue);
    }

    public final boolean isPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSVNNAME);
    }

    public final String getPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSVNNAME, "");
    }

    public final void setPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isSFPSSUBSYSIDNull() {
        return this.IsParamNull(TAG_SFPSSUBSYSID);
    }

    public final String getSFPSSUBSYSID() {
        return this.GetParamStringValue(TAG_SFPSSUBSYSID, "");
    }

    public final void setSFPSSUBSYSID(String strValue) {
        this.SetParamValue(TAG_SFPSSUBSYSID, strValue);
    }

    public final boolean isSFPSSUBSYSNAMENull() {
        return this.IsParamNull(TAG_SFPSSUBSYSNAME);
    }

    public final String getSFPSSUBSYSNAME() {
        return this.GetParamStringValue(TAG_SFPSSUBSYSNAME, "");
    }

    public final void setSFPSSUBSYSNAME(String strValue) {
        this.SetParamValue(TAG_SFPSSUBSYSNAME, strValue);
    }

    public final boolean isVCTYPENull() {
        return this.IsParamNull(TAG_VCTYPE);
    }

    public final String getVCTYPE() {
        return this.GetParamStringValue(TAG_VCTYPE, "");
    }

    public final void setVCTYPE(String strValue) {
        this.SetParamValue(TAG_VCTYPE, strValue);
    }

    public final boolean isPPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PPSDEVSLNSYSID);
    }

    public final String getPPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PPSDEVSLNSYSID, "");
    }

    public final void setPPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PPSDEVSLNSYSID, strValue);
    }

    public final boolean isPPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PPSDEVSLNSYSNAME);
    }

    public final String getPPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PPSDEVSLNSYSNAME, "");
    }

    public final void setPPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PPSDEVSLNSYSNAME, strValue);
    }

    public final boolean isMAINPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_MAINPSDEVSLNSYSID);
    }

    public final String getMAINPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_MAINPSDEVSLNSYSID, "");
    }

    public final void setMAINPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_MAINPSDEVSLNSYSID, strValue);
    }

    public final boolean isMAINPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_MAINPSDEVSLNSYSNAME);
    }

    public final String getMAINPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_MAINPSDEVSLNSYSNAME, "");
    }

    public final void setMAINPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_MAINPSDEVSLNSYSNAME, strValue);
    }

    public final boolean isROPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNID);
    }

    public final String getROPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNID, "");
    }

    public final void setROPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNID, strValue);
    }

    public final boolean isROPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_ROPSDEVCENTERSVNNAME);
    }

    public final String getROPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_ROPSDEVCENTERSVNNAME, "");
    }

    public final void setROPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_ROPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isPSDEVCENTERASID3Null() {
        return this.IsParamNull(TAG_PSDEVCENTERASID3);
    }

    public final String getPSDEVCENTERASID3() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID3, "");
    }

    public final void setPSDEVCENTERASID3(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID3, strValue);
    }

    public final boolean isPSDEVCENTERASNAME3Null() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME3);
    }

    public final String getPSDEVCENTERASNAME3() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME3, "");
    }

    public final void setPSDEVCENTERASNAME3(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME3, strValue);
    }

    public final boolean isPSDEVCENTERASID4Null() {
        return this.IsParamNull(TAG_PSDEVCENTERASID4);
    }

    public final String getPSDEVCENTERASID4() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID4, "");
    }

    public final void setPSDEVCENTERASID4(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID4, strValue);
    }

    public final boolean isPSDEVCENTERASNAME4Null() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME4);
    }

    public final String getPSDEVCENTERASNAME4() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME4, "");
    }

    public final void setPSDEVCENTERASNAME4(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME4, strValue);
    }

    public final boolean isMODELINSTVERNull() {
        return this.IsParamNull(TAG_MODELINSTVER);
    }

    public final int getMODELINSTVER() {
        return this.GetParamIntValue(TAG_MODELINSTVER, 0);
    }

    public final void setMODELINSTVER(int nValue) {
        this.SetParamValue(TAG_MODELINSTVER, nValue);
    }

    public final boolean isJITPSDBDEVINSTIDNull() {
        return this.IsParamNull(TAG_JITPSDBDEVINSTID);
    }

    public final String getJITPSDBDEVINSTID() {
        return this.GetParamStringValue(TAG_JITPSDBDEVINSTID, "");
    }

    public final void setJITPSDBDEVINSTID(String strValue) {
        this.SetParamValue(TAG_JITPSDBDEVINSTID, strValue);
    }

    public final boolean isJITPSDBDEVINSTNAMENull() {
        return this.IsParamNull(TAG_JITPSDBDEVINSTNAME);
    }

    public final String getJITPSDBDEVINSTNAME() {
        return this.GetParamStringValue(TAG_JITPSDBDEVINSTNAME, "");
    }

    public final void setJITPSDBDEVINSTNAME(String strValue) {
        this.SetParamValue(TAG_JITPSDBDEVINSTNAME, strValue);
    }

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
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

    public final boolean isPSDEVSLNSYSRESIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSRESID);
    }

    public final String getPSDEVSLNSYSRESID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSRESID, "");
    }

    public final void setPSDEVSLNSYSRESID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSRESID, strValue);
    }

    public final boolean isPSDEVSLNSYSRESNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSRESNAME);
    }

    public final String getPSDEVSLNSYSRESNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSRESNAME, "");
    }

    public final void setPSDEVSLNSYSRESNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSRESNAME, strValue);
    }

    public final boolean isENABLEWSSERVERNull() {
        return this.IsParamNull(TAG_ENABLEWSSERVER);
    }

    public final boolean getENABLEWSSERVER() {
        return this.GetParamIntValue(TAG_ENABLEWSSERVER, 0) == 1;
    }

    public final void setENABLEWSSERVER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEWSSERVER, bValue ? 1 : 0);
    }

    public final boolean isENABLEDEPLOYCENTERNull() {
        return this.IsParamNull(TAG_ENABLEDEPLOYCENTER);
    }

    public final boolean getENABLEDEPLOYCENTER() {
        return this.GetParamIntValue(TAG_ENABLEDEPLOYCENTER, 0) == 1;
    }

    public final void setENABLEDEPLOYCENTER(boolean bValue) {
        this.SetParamValue(TAG_ENABLEDEPLOYCENTER, bValue ? 1 : 0);
    }

    public final boolean isTEMPLENGINENull() {
        return this.IsParamNull(TAG_TEMPLENGINE);
    }

    public final String getTEMPLENGINE() {
        return this.GetParamStringValue(TAG_TEMPLENGINE, "");
    }

    public final void setTEMPLENGINE(String strValue) {
        this.SetParamValue(TAG_TEMPLENGINE, strValue);
    }

    public final boolean isENABLEFOLDERKEYNull() {
        return this.IsParamNull(TAG_ENABLEFOLDERKEY);
    }

    public final boolean getENABLEFOLDERKEY() {
        return this.GetParamIntValue(TAG_ENABLEFOLDERKEY, 0) == 1;
    }

    public final void setENABLEFOLDERKEY(boolean bValue) {
        this.SetParamValue(TAG_ENABLEFOLDERKEY, bValue ? 1 : 0);
    }

    public final boolean isSYSROWKEYNull() {
        return this.IsParamNull(TAG_SYSROWKEY);
    }

    public final String getSYSROWKEY() {
        return this.GetParamStringValue(TAG_SYSROWKEY, "");
    }

    public final void setSYSROWKEY(String strValue) {
        this.SetParamValue(TAG_SYSROWKEY, strValue);
    }

    public final boolean isSHAREFLAGNull() {
        return this.IsParamNull(TAG_SHAREFLAG);
    }

    public final boolean getSHAREFLAG() {
        return this.GetParamIntValue(TAG_SHAREFLAG, 0) == 1;
    }

    public final void setSHAREFLAG(boolean bValue) {
        this.SetParamValue(TAG_SHAREFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSDCWORKSPACEIDNull() {
        return this.IsParamNull(TAG_PSDCWORKSPACEID);
    }

    public final String getPSDCWORKSPACEID() {
        return this.GetParamStringValue(TAG_PSDCWORKSPACEID, "");
    }

    public final void setPSDCWORKSPACEID(String strValue) {
        this.SetParamValue(TAG_PSDCWORKSPACEID, strValue);
    }

    public final boolean isSYSTAG3Null() {
        return this.IsParamNull(TAG_SYSTAG3);
    }

    public final String getSYSTAG3() {
        return this.GetParamStringValue(TAG_SYSTAG3, "");
    }

    public final void setSYSTAG3(String strValue) {
        this.SetParamValue(TAG_SYSTAG3, strValue);
    }

    public final boolean isSYSTAG4Null() {
        return this.IsParamNull(TAG_SYSTAG4);
    }

    public final String getSYSTAG4() {
        return this.GetParamStringValue(TAG_SYSTAG4, "");
    }

    public final void setSYSTAG4(String strValue) {
        this.SetParamValue(TAG_SYSTAG4, strValue);
    }

    public final boolean isCALLBACKURLNull() {
        return this.IsParamNull(TAG_CALLBACKURL);
    }

    public final String getCALLBACKURL() {
        return this.GetParamStringValue(TAG_CALLBACKURL, "");
    }

    public final void setCALLBACKURL(String strValue) {
        this.SetParamValue(TAG_CALLBACKURL, strValue);
    }

    public final boolean isCALLBACKTAGNull() {
        return this.IsParamNull(TAG_CALLBACKTAG);
    }

    public final String getCALLBACKTAG() {
        return this.GetParamStringValue(TAG_CALLBACKTAG, "");
    }

    public final void setCALLBACKTAG(String strValue) {
        this.SetParamValue(TAG_CALLBACKTAG, strValue);
    }

    public final boolean isENABLECALLBACKNull() {
        return this.IsParamNull(TAG_ENABLECALLBACK);
    }

    public final boolean getENABLECALLBACK() {
        return this.GetParamIntValue(TAG_ENABLECALLBACK, 0) == 1;
    }

    public final void setENABLECALLBACK(boolean bValue) {
        this.SetParamValue(TAG_ENABLECALLBACK, bValue ? 1 : 0);
    }

    public final boolean isDEPLOYSYSIDNull() {
        return this.IsParamNull(TAG_DEPLOYSYSID);
    }

    public final String getDEPLOYSYSID() {
        return this.GetParamStringValue(TAG_DEPLOYSYSID, "");
    }

    public final void setDEPLOYSYSID(String strValue) {
        this.SetParamValue(TAG_DEPLOYSYSID, strValue);
    }

    public final boolean isDEPLOYSYSTAGNull() {
        return this.IsParamNull(TAG_DEPLOYSYSTAG);
    }

    public final String getDEPLOYSYSTAG() {
        return this.GetParamStringValue(TAG_DEPLOYSYSTAG, "");
    }

    public final void setDEPLOYSYSTAG(String strValue) {
        this.SetParamValue(TAG_DEPLOYSYSTAG, strValue);
    }

    public final boolean isDEPLOYSYSTAG2Null() {
        return this.IsParamNull(TAG_DEPLOYSYSTAG2);
    }

    public final String getDEPLOYSYSTAG2() {
        return this.GetParamStringValue(TAG_DEPLOYSYSTAG2, "");
    }

    public final void setDEPLOYSYSTAG2(String strValue) {
        this.SetParamValue(TAG_DEPLOYSYSTAG2, strValue);
    }

    public final boolean isDEPLOYSYSTYPENull() {
        return this.IsParamNull(TAG_DEPLOYSYSTYPE);
    }

    public final String getDEPLOYSYSTYPE() {
        return this.GetParamStringValue(TAG_DEPLOYSYSTYPE, "");
    }

    public final void setDEPLOYSYSTYPE(String strValue) {
        this.SetParamValue(TAG_DEPLOYSYSTYPE, strValue);
    }

    public final boolean isDEPLOYSYSORGIDNull() {
        return this.IsParamNull(TAG_DEPLOYSYSORGID);
    }

    public final String getDEPLOYSYSORGID() {
        return this.GetParamStringValue(TAG_DEPLOYSYSORGID, "");
    }

    public final void setDEPLOYSYSORGID(String strValue) {
        this.SetParamValue(TAG_DEPLOYSYSORGID, strValue);
    }

    public final boolean isDEPLOYSYSORGSECTORIDNull() {
        return this.IsParamNull(TAG_DEPLOYSYSORGSECTORID);
    }

    public final String getDEPLOYSYSORGSECTORID() {
        return this.GetParamStringValue(TAG_DEPLOYSYSORGSECTORID, "");
    }

    public final void setDEPLOYSYSORGSECTORID(String strValue) {
        this.SetParamValue(TAG_DEPLOYSYSORGSECTORID, strValue);
    }

    public final boolean isOFFLINETIMENull() {
        return this.IsParamNull(TAG_OFFLINETIME);
    }

    public final Date getOFFLINETIME() {
        return this.GetParamDateValue(TAG_OFFLINETIME, null);
    }

    public final void setOFFLINETIME(Date dtValue) {
        this.SetParamValue(TAG_OFFLINETIME, dtValue);
    }

    public final boolean isRTMODELPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_RTMODELPSDEVCENTERSVNID);
    }

    public final String getRTMODELPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_RTMODELPSDEVCENTERSVNID, "");
    }

    public final void setRTMODELPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_RTMODELPSDEVCENTERSVNID, strValue);
    }

    public final boolean isRTMODELPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_RTMODELPSDEVCENTERSVNNAME);
    }

    public final String getRTMODELPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_RTMODELPSDEVCENTERSVNNAME, "");
    }

    public final void setRTMODELPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_RTMODELPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isDOCPSDEVCENTERSVNIDNull() {
        return this.IsParamNull(TAG_DOCPSDEVCENTERSVNID);
    }

    public final String getDOCPSDEVCENTERSVNID() {
        return this.GetParamStringValue(TAG_DOCPSDEVCENTERSVNID, "");
    }

    public final void setDOCPSDEVCENTERSVNID(String strValue) {
        this.SetParamValue(TAG_DOCPSDEVCENTERSVNID, strValue);
    }

    public final boolean isDOCPSDEVCENTERSVNNAMENull() {
        return this.IsParamNull(TAG_DOCPSDEVCENTERSVNNAME);
    }

    public final String getDOCPSDEVCENTERSVNNAME() {
        return this.GetParamStringValue(TAG_DOCPSDEVCENTERSVNNAME, "");
    }

    public final void setDOCPSDEVCENTERSVNNAME(String strValue) {
        this.SetParamValue(TAG_DOCPSDEVCENTERSVNNAME, strValue);
    }

    public final boolean isPSDCDEPLOYCENTERIDNull() {
        return this.IsParamNull(TAG_PSDCDEPLOYCENTERID);
    }

    public final String getPSDCDEPLOYCENTERID() {
        return this.GetParamStringValue(TAG_PSDCDEPLOYCENTERID, "");
    }

    public final void setPSDCDEPLOYCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDCDEPLOYCENTERID, strValue);
    }

    public final boolean isPSDCDEPLOYCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDCDEPLOYCENTERNAME);
    }

    public final String getPSDCDEPLOYCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDCDEPLOYCENTERNAME, "");
    }

    public final void setPSDCDEPLOYCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCDEPLOYCENTERNAME, strValue);
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

    public final boolean isSYSTAGNull() {
        return this.IsParamNull(TAG_SYSTAG);
    }

    public final String getSYSTAG() {
        return this.GetParamStringValue(TAG_SYSTAG, "");
    }

    public final void setSYSTAG(String strValue) {
        this.SetParamValue(TAG_SYSTAG, strValue);
    }

    public final boolean isSYSTAG2Null() {
        return this.IsParamNull(TAG_SYSTAG2);
    }

    public final String getSYSTAG2() {
        return this.GetParamStringValue(TAG_SYSTAG2, "");
    }

    public final void setSYSTAG2(String strValue) {
        this.SetParamValue(TAG_SYSTAG2, strValue);
    }
}

