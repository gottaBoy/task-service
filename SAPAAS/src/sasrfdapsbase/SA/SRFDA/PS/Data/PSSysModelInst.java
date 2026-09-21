/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysModelInst
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String INSTSTATE_UNINITIALIZED = "10";
    public static final String INSTSTATE_INITIALIZED = "20";
    public static final String INSTSTATE_USED = "30";
    public static final String INSTSTATE_CANCELLED = "40";
    public static final String SYSTYPE_DEVSYS = "DEVSYS";
    public static final String SYSTYPE_DEPSYS = "DEPSYS";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_DBNAME = "DBNAME";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_MODELVER = "MODELVER";
    public static final String TAG_INSTSTATE = "INSTSTATE";
    public static final String TAG_PSDBSERVERID = "PSDBSERVERID";
    public static final String TAG_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_ROWCNT = "ROWCNT";
    public static final String TAG_USEDSIZE = "USEDSIZE";
    public static final String TAG_INSTGROUP = "INSTGROUP";
    public static final String TAG_BEGINCALCTIME = "BEGINCALCTIME";
    public static final String TAG_ENDCALCTIME = "ENDCALCTIME";
    public static final String TAG_ENDMAINTAINTIME = "ENDMAINTAINTIME";
    public static final String TAG_BEGINMAINTAINTIME = "BEGINMAINTAINTIME";
    public static final String TAG_SYSTYPE = "SYSTYPE";
    public static final String TAG_INITPOOLSIZE = "INITPOOLSIZE";
    public static final String TAG_MAXPOOLSIZE = "MAXPOOLSIZE";
    public static final String TAG_MINPOOLSIZE = "MINPOOLSIZE";

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

    public final boolean isCONNSTRNull() {
        return this.IsParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.GetParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.SetParamValue(TAG_CONNSTR, strValue);
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

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
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

    public final boolean isMODELVERNull() {
        return this.IsParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.GetParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.SetParamValue(TAG_MODELVER, nValue);
    }

    public final boolean isINSTSTATENull() {
        return this.IsParamNull(TAG_INSTSTATE);
    }

    public final String getINSTSTATE() {
        return this.GetParamStringValue(TAG_INSTSTATE, "");
    }

    public final void setINSTSTATE(String strValue) {
        this.SetParamValue(TAG_INSTSTATE, strValue);
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

    public final boolean isROWCNTNull() {
        return this.IsParamNull(TAG_ROWCNT);
    }

    public final int getROWCNT() {
        return this.GetParamIntValue(TAG_ROWCNT, 0);
    }

    public final void setROWCNT(int nValue) {
        this.SetParamValue(TAG_ROWCNT, nValue);
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

    public final boolean isINSTGROUPNull() {
        return this.IsParamNull(TAG_INSTGROUP);
    }

    public final String getINSTGROUP() {
        return this.GetParamStringValue(TAG_INSTGROUP, "");
    }

    public final void setINSTGROUP(String strValue) {
        this.SetParamValue(TAG_INSTGROUP, strValue);
    }

    public final boolean isBEGINCALCTIMENull() {
        return this.IsParamNull(TAG_BEGINCALCTIME);
    }

    public final Date getBEGINCALCTIME() {
        return this.GetParamDateValue(TAG_BEGINCALCTIME, null);
    }

    public final void setBEGINCALCTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINCALCTIME, dtValue);
    }

    public final boolean isENDCALCTIMENull() {
        return this.IsParamNull(TAG_ENDCALCTIME);
    }

    public final Date getENDCALCTIME() {
        return this.GetParamDateValue(TAG_ENDCALCTIME, null);
    }

    public final void setENDCALCTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDCALCTIME, dtValue);
    }

    public final boolean isENDMAINTAINTIMENull() {
        return this.IsParamNull(TAG_ENDMAINTAINTIME);
    }

    public final Date getENDMAINTAINTIME() {
        return this.GetParamDateValue(TAG_ENDMAINTAINTIME, null);
    }

    public final void setENDMAINTAINTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDMAINTAINTIME, dtValue);
    }

    public final boolean isBEGINMAINTAINTIMENull() {
        return this.IsParamNull(TAG_BEGINMAINTAINTIME);
    }

    public final Date getBEGINMAINTAINTIME() {
        return this.GetParamDateValue(TAG_BEGINMAINTAINTIME, null);
    }

    public final void setBEGINMAINTAINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINMAINTAINTIME, dtValue);
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

    public final boolean isINITPOOLSIZENull() {
        return this.IsParamNull(TAG_INITPOOLSIZE);
    }

    public final int getINITPOOLSIZE() {
        return this.GetParamIntValue(TAG_INITPOOLSIZE, 0);
    }

    public final void setINITPOOLSIZE(int nValue) {
        this.SetParamValue(TAG_INITPOOLSIZE, nValue);
    }

    public final boolean isMAXPOOLSIZENull() {
        return this.IsParamNull(TAG_MAXPOOLSIZE);
    }

    public final int getMAXPOOLSIZE() {
        return this.GetParamIntValue(TAG_MAXPOOLSIZE, 0);
    }

    public final void setMAXPOOLSIZE(int nValue) {
        this.SetParamValue(TAG_MAXPOOLSIZE, nValue);
    }

    public final boolean isMINPOOLSIZENull() {
        return this.IsParamNull(TAG_MINPOOLSIZE);
    }

    public final int getMINPOOLSIZE() {
        return this.GetParamIntValue(TAG_MINPOOLSIZE, 0);
    }

    public final void setMINPOOLSIZE(int nValue) {
        this.SetParamValue(TAG_MINPOOLSIZE, nValue);
    }
}

