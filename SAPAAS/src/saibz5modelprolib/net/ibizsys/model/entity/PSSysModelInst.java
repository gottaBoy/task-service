/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.entity;

import java.util.Date;
import net.ibizsys.model.entity.BaseDataEntity;

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

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.isParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.getParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.setParamValue(TAG_PSSYSMODELINSTID, strValue);
    }

    public final boolean isPSSYSMODELINSTNAMENull() {
        return this.isParamNull(TAG_PSSYSMODELINSTNAME);
    }

    public final String getPSSYSMODELINSTNAME() {
        return this.getParamStringValue(TAG_PSSYSMODELINSTNAME, "");
    }

    public final void setPSSYSMODELINSTNAME(String strValue) {
        this.setParamValue(TAG_PSSYSMODELINSTNAME, strValue);
    }

    public final boolean isCREATEMANNull() {
        return this.isParamNull(TAG_CREATEMAN);
    }

    public final String getCREATEMAN() {
        return this.getParamStringValue(TAG_CREATEMAN, "");
    }

    public final void setCREATEMAN(String strValue) {
        this.setParamValue(TAG_CREATEMAN, strValue);
    }

    public final boolean isCREATEDATENull() {
        return this.isParamNull(TAG_CREATEDATE);
    }

    public final Date getCREATEDATE() {
        return this.getParamDateValue(TAG_CREATEDATE, null);
    }

    public final void setCREATEDATE(Date dtValue) {
        this.setParamValue(TAG_CREATEDATE, dtValue);
    }

    public final boolean isUPDATEMANNull() {
        return this.isParamNull(TAG_UPDATEMAN);
    }

    public final String getUPDATEMAN() {
        return this.getParamStringValue(TAG_UPDATEMAN, "");
    }

    public final void setUPDATEMAN(String strValue) {
        this.setParamValue(TAG_UPDATEMAN, strValue);
    }

    public final boolean isUPDATEDATENull() {
        return this.isParamNull(TAG_UPDATEDATE);
    }

    public final Date getUPDATEDATE() {
        return this.getParamDateValue(TAG_UPDATEDATE, null);
    }

    public final void setUPDATEDATE(Date dtValue) {
        this.setParamValue(TAG_UPDATEDATE, dtValue);
    }

    public final boolean isCONNSTRNull() {
        return this.isParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.getParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.setParamValue(TAG_CONNSTR, strValue);
    }

    public final boolean isDBNAMENull() {
        return this.isParamNull(TAG_DBNAME);
    }

    public final String getDBNAME() {
        return this.getParamStringValue(TAG_DBNAME, "");
    }

    public final void setDBNAME(String strValue) {
        this.setParamValue(TAG_DBNAME, strValue);
    }

    public final boolean isDBTYPENull() {
        return this.isParamNull(TAG_DBTYPE);
    }

    public final String getDBTYPE() {
        return this.getParamStringValue(TAG_DBTYPE, "");
    }

    public final void setDBTYPE(String strValue) {
        this.setParamValue(TAG_DBTYPE, strValue);
    }

    public final boolean isMEMONull() {
        return this.isParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.getParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.setParamValue(TAG_MEMO, strValue);
    }

    public final boolean isPASSWDNull() {
        return this.isParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.getParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.setParamValue(TAG_PASSWD, strValue);
    }

    public final boolean isUSERNAMENull() {
        return this.isParamNull(TAG_USERNAME);
    }

    public final String getUSERNAME() {
        return this.getParamStringValue(TAG_USERNAME, "");
    }

    public final void setUSERNAME(String strValue) {
        this.setParamValue(TAG_USERNAME, strValue);
    }

    public final boolean isMODELVERNull() {
        return this.isParamNull(TAG_MODELVER);
    }

    public final int getMODELVER() {
        return this.getParamIntValue(TAG_MODELVER, 0);
    }

    public final void setMODELVER(int nValue) {
        this.setParamValue(TAG_MODELVER, nValue);
    }

    public final boolean isINSTSTATENull() {
        return this.isParamNull(TAG_INSTSTATE);
    }

    public final String getINSTSTATE() {
        return this.getParamStringValue(TAG_INSTSTATE, "");
    }

    public final void setINSTSTATE(String strValue) {
        this.setParamValue(TAG_INSTSTATE, strValue);
    }

    public final boolean isPSDBSERVERIDNull() {
        return this.isParamNull(TAG_PSDBSERVERID);
    }

    public final String getPSDBSERVERID() {
        return this.getParamStringValue(TAG_PSDBSERVERID, "");
    }

    public final void setPSDBSERVERID(String strValue) {
        this.setParamValue(TAG_PSDBSERVERID, strValue);
    }

    public final boolean isPSDBSERVERNAMENull() {
        return this.isParamNull(TAG_PSDBSERVERNAME);
    }

    public final String getPSDBSERVERNAME() {
        return this.getParamStringValue(TAG_PSDBSERVERNAME, "");
    }

    public final void setPSDBSERVERNAME(String strValue) {
        this.setParamValue(TAG_PSDBSERVERNAME, strValue);
    }

    public final boolean isPSSVRDOMAINIDNull() {
        return this.isParamNull(TAG_PSSVRDOMAINID);
    }

    public final String getPSSVRDOMAINID() {
        return this.getParamStringValue(TAG_PSSVRDOMAINID, "");
    }

    public final void setPSSVRDOMAINID(String strValue) {
        this.setParamValue(TAG_PSSVRDOMAINID, strValue);
    }

    public final boolean isPSSVRDOMAINNAMENull() {
        return this.isParamNull(TAG_PSSVRDOMAINNAME);
    }

    public final String getPSSVRDOMAINNAME() {
        return this.getParamStringValue(TAG_PSSVRDOMAINNAME, "");
    }

    public final void setPSSVRDOMAINNAME(String strValue) {
        this.setParamValue(TAG_PSSVRDOMAINNAME, strValue);
    }

    public final boolean isROWCNTNull() {
        return this.isParamNull(TAG_ROWCNT);
    }

    public final int getROWCNT() {
        return this.getParamIntValue(TAG_ROWCNT, 0);
    }

    public final void setROWCNT(int nValue) {
        this.setParamValue(TAG_ROWCNT, nValue);
    }

    public final boolean isUSEDSIZENull() {
        return this.isParamNull(TAG_USEDSIZE);
    }

    public final int getUSEDSIZE() {
        return this.getParamIntValue(TAG_USEDSIZE, 0);
    }

    public final void setUSEDSIZE(int nValue) {
        this.setParamValue(TAG_USEDSIZE, nValue);
    }

    public final boolean isINSTGROUPNull() {
        return this.isParamNull(TAG_INSTGROUP);
    }

    public final String getINSTGROUP() {
        return this.getParamStringValue(TAG_INSTGROUP, "");
    }

    public final void setINSTGROUP(String strValue) {
        this.setParamValue(TAG_INSTGROUP, strValue);
    }

    public final boolean isBEGINCALCTIMENull() {
        return this.isParamNull(TAG_BEGINCALCTIME);
    }

    public final Date getBEGINCALCTIME() {
        return this.getParamDateValue(TAG_BEGINCALCTIME, null);
    }

    public final void setBEGINCALCTIME(Date dtValue) {
        this.setParamValue(TAG_BEGINCALCTIME, dtValue);
    }

    public final boolean isENDCALCTIMENull() {
        return this.isParamNull(TAG_ENDCALCTIME);
    }

    public final Date getENDCALCTIME() {
        return this.getParamDateValue(TAG_ENDCALCTIME, null);
    }

    public final void setENDCALCTIME(Date dtValue) {
        this.setParamValue(TAG_ENDCALCTIME, dtValue);
    }

    public final boolean isENDMAINTAINTIMENull() {
        return this.isParamNull(TAG_ENDMAINTAINTIME);
    }

    public final Date getENDMAINTAINTIME() {
        return this.getParamDateValue(TAG_ENDMAINTAINTIME, null);
    }

    public final void setENDMAINTAINTIME(Date dtValue) {
        this.setParamValue(TAG_ENDMAINTAINTIME, dtValue);
    }

    public final boolean isBEGINMAINTAINTIMENull() {
        return this.isParamNull(TAG_BEGINMAINTAINTIME);
    }

    public final Date getBEGINMAINTAINTIME() {
        return this.getParamDateValue(TAG_BEGINMAINTAINTIME, null);
    }

    public final void setBEGINMAINTAINTIME(Date dtValue) {
        this.setParamValue(TAG_BEGINMAINTAINTIME, dtValue);
    }
}

