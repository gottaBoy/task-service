/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDBServer
extends BaseDataEntity {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String DBTYPE_DB2 = "DB2";
    public static final String DBTYPE_ORACLE = "ORACLE";
    public static final String DBTYPE_SQLSERVER = "SQLSERVER";
    public static final String DBTYPE_POSTGRESQL = "POSTGRESQL";
    public static final String DBTYPE_PPAS = "PPAS";
    public static final String TAG_PSDBSERVERID = "PSDBSERVERID";
    public static final String TAG_PSDBSERVERNAME = "PSDBSERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_DBTYPE = "DBTYPE";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_DBROOT = "DBROOT";
    public static final String TAG_DBURL = "DBURL";
    public static final String TAG_DBUSERNAME = "DBUSERNAME";
    public static final String TAG_DBPASSWD = "DBPASSWD";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String TAG_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String TAG_UPLOADPATH = "UPLOADPATH";
    public static final String TAG_DBPORT = "DBPORT";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";
    public static final String TAG_DBINSTALLPATH = "DBINSTALLPATH";

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

    public final boolean isENABLENull() {
        return this.IsParamNull(TAG_ENABLE);
    }

    public final boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public final void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
    }

    public final boolean isPORTNull() {
        return this.IsParamNull(TAG_PORT);
    }

    public final int getPORT() {
        return this.GetParamIntValue(TAG_PORT, 0);
    }

    public final void setPORT(int nValue) {
        this.SetParamValue(TAG_PORT, nValue);
    }

    public final boolean isDBROOTNull() {
        return this.IsParamNull(TAG_DBROOT);
    }

    public final String getDBROOT() {
        return this.GetParamStringValue(TAG_DBROOT, "");
    }

    public final void setDBROOT(String strValue) {
        this.SetParamValue(TAG_DBROOT, strValue);
    }

    public final boolean isDBURLNull() {
        return this.IsParamNull(TAG_DBURL);
    }

    public final String getDBURL() {
        return this.GetParamStringValue(TAG_DBURL, "");
    }

    public final void setDBURL(String strValue) {
        this.SetParamValue(TAG_DBURL, strValue);
    }

    public final boolean isDBUSERNAMENull() {
        return this.IsParamNull(TAG_DBUSERNAME);
    }

    public final String getDBUSERNAME() {
        return this.GetParamStringValue(TAG_DBUSERNAME, "");
    }

    public final void setDBUSERNAME(String strValue) {
        this.SetParamValue(TAG_DBUSERNAME, strValue);
    }

    public final boolean isDBPASSWDNull() {
        return this.IsParamNull(TAG_DBPASSWD);
    }

    public final String getDBPASSWD() {
        return this.GetParamStringValue(TAG_DBPASSWD, "");
    }

    public final void setDBPASSWD(String strValue) {
        this.SetParamValue(TAG_DBPASSWD, strValue);
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

    public final boolean isUPLOADPATHNull() {
        return this.IsParamNull(TAG_UPLOADPATH);
    }

    public final String getUPLOADPATH() {
        return this.GetParamStringValue(TAG_UPLOADPATH, "");
    }

    public final void setUPLOADPATH(String strValue) {
        this.SetParamValue(TAG_UPLOADPATH, strValue);
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

    public final boolean isUPLOADFILEMODENull() {
        return this.IsParamNull(TAG_UPLOADFILEMODE);
    }

    public final String getUPLOADFILEMODE() {
        return this.GetParamStringValue(TAG_UPLOADFILEMODE, "");
    }

    public final void setUPLOADFILEMODE(String strValue) {
        this.SetParamValue(TAG_UPLOADFILEMODE, strValue);
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
}

