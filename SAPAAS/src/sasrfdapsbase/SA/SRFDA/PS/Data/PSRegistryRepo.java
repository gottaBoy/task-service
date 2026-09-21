/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSRegistryRepo
extends BaseDataEntity {
    public static final String REGISTRYTYPE_REGISTRY = "REGISTRY";
    public static final String TAG_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String TAG_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSREGISTRYSERVERID = "PSREGISTRYSERVERID";
    public static final String TAG_PSREGISTRYSERVERNAME = "PSREGISTRYSERVERNAME";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_LOGICNAME = "LOGICNAME";
    public static final String TAG_REPOSTATE = "REPOSTATE";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_LOCALRES = "LOCALRES";
    public static final String TAG_REGISTRYPASSWD = "REGISTRYPASSWD";
    public static final String TAG_REGISTRYUSERNAME = "REGISTRYUSERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PARAM5 = "PARAM5";
    public static final String TAG_PARAM6 = "PARAM6";
    public static final String TAG_PARAM7 = "PARAM7";
    public static final String TAG_PARAM8 = "PARAM8";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_PSOBJNAME = "PSOBJNAME";
    public static final String TAG_PSOBJTYPE = "PSOBJTYPE";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_ROPASSWD = "ROPASSWD";
    public static final String TAG_ROUSERNAME = "ROUSERNAME";
    public static final String TAG_REGISTRYTYPE = "REGISTRYTYPE";

    public final boolean isPSREGISTRYREPOIDNull() {
        return this.IsParamNull(TAG_PSREGISTRYREPOID);
    }

    public final String getPSREGISTRYREPOID() {
        return this.GetParamStringValue(TAG_PSREGISTRYREPOID, "");
    }

    public final void setPSREGISTRYREPOID(String strValue) {
        this.SetParamValue(TAG_PSREGISTRYREPOID, strValue);
    }

    public final boolean isPSREGISTRYREPONAMENull() {
        return this.IsParamNull(TAG_PSREGISTRYREPONAME);
    }

    public final String getPSREGISTRYREPONAME() {
        return this.GetParamStringValue(TAG_PSREGISTRYREPONAME, "");
    }

    public final void setPSREGISTRYREPONAME(String strValue) {
        this.SetParamValue(TAG_PSREGISTRYREPONAME, strValue);
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

    public final boolean isPSREGISTRYSERVERIDNull() {
        return this.IsParamNull(TAG_PSREGISTRYSERVERID);
    }

    public final String getPSREGISTRYSERVERID() {
        return this.GetParamStringValue(TAG_PSREGISTRYSERVERID, "");
    }

    public final void setPSREGISTRYSERVERID(String strValue) {
        this.SetParamValue(TAG_PSREGISTRYSERVERID, strValue);
    }

    public final boolean isPSREGISTRYSERVERNAMENull() {
        return this.IsParamNull(TAG_PSREGISTRYSERVERNAME);
    }

    public final String getPSREGISTRYSERVERNAME() {
        return this.GetParamStringValue(TAG_PSREGISTRYSERVERNAME, "");
    }

    public final void setPSREGISTRYSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSREGISTRYSERVERNAME, strValue);
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

    public final boolean isLOGICNAMENull() {
        return this.IsParamNull(TAG_LOGICNAME);
    }

    public final String getLOGICNAME() {
        return this.GetParamStringValue(TAG_LOGICNAME, "");
    }

    public final void setLOGICNAME(String strValue) {
        this.SetParamValue(TAG_LOGICNAME, strValue);
    }

    public final boolean isREPOSTATENull() {
        return this.IsParamNull(TAG_REPOSTATE);
    }

    public final int getREPOSTATE() {
        return this.GetParamIntValue(TAG_REPOSTATE, 0);
    }

    public final void setREPOSTATE(int nValue) {
        this.SetParamValue(TAG_REPOSTATE, nValue);
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

    public final boolean isLOCALRESNull() {
        return this.IsParamNull(TAG_LOCALRES);
    }

    public final boolean getLOCALRES() {
        return this.GetParamIntValue(TAG_LOCALRES, 0) == 1;
    }

    public final void setLOCALRES(boolean bValue) {
        this.SetParamValue(TAG_LOCALRES, bValue ? 1 : 0);
    }

    public final boolean isREGISTRYPASSWDNull() {
        return this.IsParamNull(TAG_REGISTRYPASSWD);
    }

    public final String getREGISTRYPASSWD() {
        return this.GetParamStringValue(TAG_REGISTRYPASSWD, "");
    }

    public final void setREGISTRYPASSWD(String strValue) {
        this.SetParamValue(TAG_REGISTRYPASSWD, strValue);
    }

    public final boolean isREGISTRYUSERNAMENull() {
        return this.IsParamNull(TAG_REGISTRYUSERNAME);
    }

    public final String getREGISTRYUSERNAME() {
        return this.GetParamStringValue(TAG_REGISTRYUSERNAME, "");
    }

    public final void setREGISTRYUSERNAME(String strValue) {
        this.SetParamValue(TAG_REGISTRYUSERNAME, strValue);
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

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.SetParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
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

    public final boolean isPSOBJTYPENull() {
        return this.IsParamNull(TAG_PSOBJTYPE);
    }

    public final String getPSOBJTYPE() {
        return this.GetParamStringValue(TAG_PSOBJTYPE, "");
    }

    public final void setPSOBJTYPE(String strValue) {
        this.SetParamValue(TAG_PSOBJTYPE, strValue);
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

    public final boolean isROPASSWDNull() {
        return this.IsParamNull(TAG_ROPASSWD);
    }

    public final String getROPASSWD() {
        return this.GetParamStringValue(TAG_ROPASSWD, "");
    }

    public final void setROPASSWD(String strValue) {
        this.SetParamValue(TAG_ROPASSWD, strValue);
    }

    public final boolean isROUSERNAMENull() {
        return this.IsParamNull(TAG_ROUSERNAME);
    }

    public final String getROUSERNAME() {
        return this.GetParamStringValue(TAG_ROUSERNAME, "");
    }

    public final void setROUSERNAME(String strValue) {
        this.SetParamValue(TAG_ROUSERNAME, strValue);
    }

    public final boolean isREGISTRYTYPENull() {
        return this.IsParamNull(TAG_REGISTRYTYPE);
    }

    public final String getREGISTRYTYPE() {
        return this.GetParamStringValue(TAG_REGISTRYTYPE, "");
    }

    public final void setREGISTRYTYPE(String strValue) {
        this.SetParamValue(TAG_REGISTRYTYPE, strValue);
    }
}

