/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenterDBInst
extends BaseDataEntity {
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String DBTYPE_POSTGRESQL = "POSTGRESQL";
    public static final String DBTYPE_PPAS = "PPAS";
    public static final String USAGEMODE_DEVELOP = "DEVELOP";
    public static final String USAGEMODE_DEPLOY = "DEPLOY";
    public static final String UPLOADFILEMODE_SSH = "SSH";
    public static final String UPLOADFILEMODE_SFTP = "SFTP";
    public static final String UPLOADFILEMODE_FTP = "FTP";
    public static final String TAG_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String TAG_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String TAG_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_SYSMEMO = "SYSMEMO";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_REFCOUNT = "REFCOUNT";
    public static final String TAG_USAGEMODE = "USAGEMODE";
    public static final String TAG_ALLOCSIZE = "ALLOCSIZE";
    public static final String TAG_USEDSIZE = "USEDSIZE";
    public static final String TAG_DCINSTSTATE = "DCINSTSTATE";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_DBNAME = "DBNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_HOSTADDRESS = "HOSTADDRESS";
    public static final String TAG_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String TAG_HOSTPASSWD = "HOSTPASSWD";
    public static final String TAG_HOSTSSHPORT = "HOSTSSHPORT";
    public static final String TAG_DBINSTALLPATH = "DBINSTALLPATH";
    public static final String TAG_LOCKMODE = "LOCKMODE";
    public static final String TAG_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String TAG_LOCKOBJID = "LOCKOBJID";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_DBPORT = "DBPORT";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String TAG_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";

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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isSYSMEMONull() {
        return this.IsParamNull(TAG_SYSMEMO);
    }

    public final String getSYSMEMO() {
        return this.GetParamStringValue(TAG_SYSMEMO, "");
    }

    public final void setSYSMEMO(String strValue) {
        this.SetParamValue(TAG_SYSMEMO, strValue);
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

    public final boolean isREFCOUNTNull() {
        return this.IsParamNull(TAG_REFCOUNT);
    }

    public final int getREFCOUNT() {
        return this.GetParamIntValue(TAG_REFCOUNT, 0);
    }

    public final void setREFCOUNT(int nValue) {
        this.SetParamValue(TAG_REFCOUNT, nValue);
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

    public final boolean isALLOCSIZENull() {
        return this.IsParamNull(TAG_ALLOCSIZE);
    }

    public final int getALLOCSIZE() {
        return this.GetParamIntValue(TAG_ALLOCSIZE, 0);
    }

    public final void setALLOCSIZE(int nValue) {
        this.SetParamValue(TAG_ALLOCSIZE, nValue);
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

    public final boolean isDCINSTSTATENull() {
        return this.IsParamNull(TAG_DCINSTSTATE);
    }

    public final int getDCINSTSTATE() {
        return this.GetParamIntValue(TAG_DCINSTSTATE, 0);
    }

    public final void setDCINSTSTATE(int nValue) {
        this.SetParamValue(TAG_DCINSTSTATE, nValue);
    }

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
    }

    public final boolean isRESPOSNull() {
        return this.IsParamNull(TAG_RESPOS);
    }

    public final int getRESPOS() {
        return this.GetParamIntValue(TAG_RESPOS, 0);
    }

    public final void setRESPOS(int nValue) {
        this.SetParamValue(TAG_RESPOS, nValue);
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

    public final boolean isHOSTADDRESSNull() {
        return this.IsParamNull(TAG_HOSTADDRESS);
    }

    public final String getHOSTADDRESS() {
        return this.GetParamStringValue(TAG_HOSTADDRESS, "");
    }

    public final void setHOSTADDRESS(String strValue) {
        this.SetParamValue(TAG_HOSTADDRESS, strValue);
    }

    public final boolean isHOSTUSERNAMENull() {
        return this.IsParamNull(TAG_HOSTUSERNAME);
    }

    public final String getHOSTUSERNAME() {
        return this.GetParamStringValue(TAG_HOSTUSERNAME, "");
    }

    public final void setHOSTUSERNAME(String strValue) {
        this.SetParamValue(TAG_HOSTUSERNAME, strValue);
    }

    public final boolean isHOSTPASSWDNull() {
        return this.IsParamNull(TAG_HOSTPASSWD);
    }

    public final String getHOSTPASSWD() {
        return this.GetParamStringValue(TAG_HOSTPASSWD, "");
    }

    public final void setHOSTPASSWD(String strValue) {
        this.SetParamValue(TAG_HOSTPASSWD, strValue);
    }

    public final boolean isHOSTSSHPORTNull() {
        return this.IsParamNull(TAG_HOSTSSHPORT);
    }

    public final int getHOSTSSHPORT() {
        return this.GetParamIntValue(TAG_HOSTSSHPORT, 0);
    }

    public final void setHOSTSSHPORT(int nValue) {
        this.SetParamValue(TAG_HOSTSSHPORT, nValue);
    }

    public final boolean isDBINSTALLPATHNull() {
        return this.IsParamNull(TAG_DBINSTALLPATH);
    }

    public final String getDBINSTALLPATH() {
        return this.GetParamStringValue(TAG_DBINSTALLPATH, "");
    }

    public final void setDBINSTALLPATH(String strValue) {
        this.SetParamValue(TAG_DBINSTALLPATH, strValue);
    }

    public final boolean isLOCKMODENull() {
        return this.IsParamNull(TAG_LOCKMODE);
    }

    public final int getLOCKMODE() {
        return this.GetParamIntValue(TAG_LOCKMODE, 0);
    }

    public final void setLOCKMODE(int nValue) {
        this.SetParamValue(TAG_LOCKMODE, nValue);
    }

    public final boolean isLOCKOBJTYPENull() {
        return this.IsParamNull(TAG_LOCKOBJTYPE);
    }

    public final String getLOCKOBJTYPE() {
        return this.GetParamStringValue(TAG_LOCKOBJTYPE, "");
    }

    public final void setLOCKOBJTYPE(String strValue) {
        this.SetParamValue(TAG_LOCKOBJTYPE, strValue);
    }

    public final boolean isLOCKOBJIDNull() {
        return this.IsParamNull(TAG_LOCKOBJID);
    }

    public final String getLOCKOBJID() {
        return this.GetParamStringValue(TAG_LOCKOBJID, "");
    }

    public final void setLOCKOBJID(String strValue) {
        this.SetParamValue(TAG_LOCKOBJID, strValue);
    }

    public final boolean isUPLOADFILEMODENull() {
        return this.IsParamNull(TAG_UPLOADFILEMODE);
    }

    public final String getUPLOADFILEMODE() {
        return this.GetParamStringValue(TAG_UPLOADFILEMODE, "");
    }

    public final void setUPLOADFILEMODE(String strValue) {
        this.SetParamValue(TAG_UPLOADFILEMODE, strValue);
    }

    public final boolean isDBPORTNull() {
        return this.IsParamNull(TAG_DBPORT);
    }

    public final int getDBPORT() {
        return this.GetParamIntValue(TAG_DBPORT, 0);
    }

    public final void setDBPORT(int nValue) {
        this.SetParamValue(TAG_DBPORT, nValue);
    }

    public final boolean isUPLOADPATHNull() {
        return this.IsParamNull(TAG_UPLOADPATH);
    }

    public final String getUPLOADPATH() {
        return this.GetParamStringValue(TAG_UPLOADPATH, "");
    }

    public final void setUPLOADPATH(String strValue) {
        this.SetParamValue(TAG_UPLOADPATH, strValue);
    }

    public final boolean isPSDEVCENTERASIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERASID);
    }

    public final String getPSDEVCENTERASID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASID, "");
    }

    public final void setPSDEVCENTERASID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASID, strValue);
    }

    public final boolean isPSDEVCENTERASNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERASNAME);
    }

    public final String getPSDEVCENTERASNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERASNAME, "");
    }

    public final void setPSDEVCENTERASNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERASNAME, strValue);
    }
}

