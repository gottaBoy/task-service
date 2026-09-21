/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevServer
extends BaseDataEntity {
    public static final int DSSTATE_10 = 10;
    public static final int DSSTATE_20 = 20;
    public static final int DSSTATE_30 = 30;
    public static final int DSSTATE_35 = 35;
    public static final int DSSTATE_40 = 40;
    public static final String TIMESHARERESTYPE_AS_TOMCAT7_MYSQL5 = "AS_TOMCAT7_MYSQL5";
    public static final String TIMESHARERESTYPE_DS = "DS";
    public static final String TIMESHARERESSPEC_C1_M1G = "C1_M1G";
    public static final String TIMESHARERESSPEC_C1_M2G = "C1_M2G";
    public static final String TIMESHARERESSPEC_C2_M2G = "C2_M2G";
    public static final String TIMESHARERESSPEC_C2_M4G = "C2_M4G";
    public static final String TIMESHARERESSPEC_C4_M4G = "C4_M4G";
    public static final String DSTYPE_WIN2008 = "WIN2008";
    public static final String DSTYPE_WIN2012 = "WIN2012";
    public static final String TAG_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String TAG_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_DSSTATE = "DSSTATE";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_TIMESHARERESTYPE = "TIMESHARERESTYPE";
    public static final String TAG_TIMESHARERESSPEC = "TIMESHARERESSPEC";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_PASSWD = "PASSWD";
    public static final String TAG_ADMINUSERNAME = "ADMINUSERNAME";
    public static final String TAG_ADMINPASSWD = "ADMINPASSWD";
    public static final String TAG_LOCALRES = "LOCALRES";
    public static final String TAG_TIMESHAREMODE = "TIMESHAREMODE";
    public static final String TAG_DSTYPE = "DSTYPE";
    public static final String TAG_SSHPORT = "SSHPORT";
    public static final String TAG_SSHIPADDR = "SSHIPADDR";
    public static final String TAG_UPLOADFILEMODE = "UPLOADFILEMODE";

    public final boolean isPSDEVSERVERIDNull() {
        return this.IsParamNull(TAG_PSDEVSERVERID);
    }

    public final String getPSDEVSERVERID() {
        return this.GetParamStringValue(TAG_PSDEVSERVERID, "");
    }

    public final void setPSDEVSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVSERVERID, strValue);
    }

    public final boolean isPSDEVSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVSERVERNAME);
    }

    public final String getPSDEVSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVSERVERNAME, "");
    }

    public final void setPSDEVSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSERVERNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isIPADDRNull() {
        return this.IsParamNull(TAG_IPADDR);
    }

    public final String getIPADDR() {
        return this.GetParamStringValue(TAG_IPADDR, "");
    }

    public final void setIPADDR(String strValue) {
        this.SetParamValue(TAG_IPADDR, strValue);
    }

    public final boolean isIPADDR2Null() {
        return this.IsParamNull(TAG_IPADDR2);
    }

    public final String getIPADDR2() {
        return this.GetParamStringValue(TAG_IPADDR2, "");
    }

    public final void setIPADDR2(String strValue) {
        this.SetParamValue(TAG_IPADDR2, strValue);
    }

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isDSSTATENull() {
        return this.IsParamNull(TAG_DSSTATE);
    }

    public final int getDSSTATE() {
        return this.GetParamIntValue(TAG_DSSTATE, 0);
    }

    public final void setDSSTATE(int nValue) {
        this.SetParamValue(TAG_DSSTATE, nValue);
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

    public final boolean isTIMESHARERESTYPENull() {
        return this.IsParamNull(TAG_TIMESHARERESTYPE);
    }

    public final String getTIMESHARERESTYPE() {
        return this.GetParamStringValue(TAG_TIMESHARERESTYPE, "");
    }

    public final void setTIMESHARERESTYPE(String strValue) {
        this.SetParamValue(TAG_TIMESHARERESTYPE, strValue);
    }

    public final boolean isTIMESHARERESSPECNull() {
        return this.IsParamNull(TAG_TIMESHARERESSPEC);
    }

    public final String getTIMESHARERESSPEC() {
        return this.GetParamStringValue(TAG_TIMESHARERESSPEC, "");
    }

    public final void setTIMESHARERESSPEC(String strValue) {
        this.SetParamValue(TAG_TIMESHARERESSPEC, strValue);
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

    public final boolean isADMINUSERNAMENull() {
        return this.IsParamNull(TAG_ADMINUSERNAME);
    }

    public final String getADMINUSERNAME() {
        return this.GetParamStringValue(TAG_ADMINUSERNAME, "");
    }

    public final void setADMINUSERNAME(String strValue) {
        this.SetParamValue(TAG_ADMINUSERNAME, strValue);
    }

    public final boolean isADMINPASSWDNull() {
        return this.IsParamNull(TAG_ADMINPASSWD);
    }

    public final String getADMINPASSWD() {
        return this.GetParamStringValue(TAG_ADMINPASSWD, "");
    }

    public final void setADMINPASSWD(String strValue) {
        this.SetParamValue(TAG_ADMINPASSWD, strValue);
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

    public final boolean isDSTYPENull() {
        return this.IsParamNull(TAG_DSTYPE);
    }

    public final String getDSTYPE() {
        return this.GetParamStringValue(TAG_DSTYPE, "");
    }

    public final void setDSTYPE(String strValue) {
        this.SetParamValue(TAG_DSTYPE, strValue);
    }

    public final boolean isSSHPORTNull() {
        return this.IsParamNull(TAG_SSHPORT);
    }

    public final int getSSHPORT() {
        return this.GetParamIntValue(TAG_SSHPORT, 0);
    }

    public final void setSSHPORT(int nValue) {
        this.SetParamValue(TAG_SSHPORT, nValue);
    }

    public final boolean isSSHIPADDRNull() {
        return this.IsParamNull(TAG_SSHIPADDR);
    }

    public final String getSSHIPADDR() {
        return this.GetParamStringValue(TAG_SSHIPADDR, "");
    }

    public final void setSSHIPADDR(String strValue) {
        this.SetParamValue(TAG_SSHIPADDR, strValue);
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
}

