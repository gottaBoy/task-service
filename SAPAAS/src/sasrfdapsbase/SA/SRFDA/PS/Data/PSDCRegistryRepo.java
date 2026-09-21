/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCRegistryRepo
extends BaseDataEntity {
    public static final String REGISTRYTYPE_REGISTRY = "REGISTRY";
    public static final String TAG_PSDCREGISTRYREPOID = "PSDCREGISTRYREPOID";
    public static final String TAG_PSDCREGISTRYREPONAME = "PSDCREGISTRYREPONAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_CONNSTR = "CONNSTR";
    public static final String TAG_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_REGISTRYPASSWD = "REGISTRYPASSWD";
    public static final String TAG_REGISTRYUSERNAME = "REGISTRYUSERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_ROPASSWD = "ROPASSWD";
    public static final String TAG_ROUSERNAME = "ROUSERNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String TAG_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String TAG_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String TAG_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String TAG_PSDCFILEID = "PSDCFILEID";
    public static final String TAG_PSDCFILENAME = "PSDCFILENAME";
    public static final String TAG_REGISTRYTYPE = "REGISTRYTYPE";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_PSREGISTRYREPOID = "PSREGISTRYREPOID";
    public static final String TAG_PSREGISTRYREPONAME = "PSREGISTRYREPONAME";

    public final boolean isPSDCREGISTRYREPOIDNull() {
        return this.IsParamNull(TAG_PSDCREGISTRYREPOID);
    }

    public final String getPSDCREGISTRYREPOID() {
        return this.GetParamStringValue(TAG_PSDCREGISTRYREPOID, "");
    }

    public final void setPSDCREGISTRYREPOID(String strValue) {
        this.SetParamValue(TAG_PSDCREGISTRYREPOID, strValue);
    }

    public final boolean isPSDCREGISTRYREPONAMENull() {
        return this.IsParamNull(TAG_PSDCREGISTRYREPONAME);
    }

    public final String getPSDCREGISTRYREPONAME() {
        return this.GetParamStringValue(TAG_PSDCREGISTRYREPONAME, "");
    }

    public final void setPSDCREGISTRYREPONAME(String strValue) {
        this.SetParamValue(TAG_PSDCREGISTRYREPONAME, strValue);
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

    public final boolean isCONNSTRNull() {
        return this.IsParamNull(TAG_CONNSTR);
    }

    public final String getCONNSTR() {
        return this.GetParamStringValue(TAG_CONNSTR, "");
    }

    public final void setCONNSTR(String strValue) {
        this.SetParamValue(TAG_CONNSTR, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
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

    public final boolean isUSERTAGNull() {
        return this.IsParamNull(TAG_USERTAG);
    }

    public final String getUSERTAG() {
        return this.GetParamStringValue(TAG_USERTAG, "");
    }

    public final void setUSERTAG(String strValue) {
        this.SetParamValue(TAG_USERTAG, strValue);
    }

    public final boolean isUSERTAG2Null() {
        return this.IsParamNull(TAG_USERTAG2);
    }

    public final String getUSERTAG2() {
        return this.GetParamStringValue(TAG_USERTAG2, "");
    }

    public final void setUSERTAG2(String strValue) {
        this.SetParamValue(TAG_USERTAG2, strValue);
    }

    public final boolean isUSERTAG3Null() {
        return this.IsParamNull(TAG_USERTAG3);
    }

    public final String getUSERTAG3() {
        return this.GetParamStringValue(TAG_USERTAG3, "");
    }

    public final void setUSERTAG3(String strValue) {
        this.SetParamValue(TAG_USERTAG3, strValue);
    }

    public final boolean isUSERTAG4Null() {
        return this.IsParamNull(TAG_USERTAG4);
    }

    public final String getUSERTAG4() {
        return this.GetParamStringValue(TAG_USERTAG4, "");
    }

    public final void setUSERTAG4(String strValue) {
        this.SetParamValue(TAG_USERTAG4, strValue);
    }

    public final boolean isPSDCCLUSTERIDNull() {
        return this.IsParamNull(TAG_PSDCCLUSTERID);
    }

    public final String getPSDCCLUSTERID() {
        return this.GetParamStringValue(TAG_PSDCCLUSTERID, "");
    }

    public final void setPSDCCLUSTERID(String strValue) {
        this.SetParamValue(TAG_PSDCCLUSTERID, strValue);
    }

    public final boolean isPSDCCLUSTERNAMENull() {
        return this.IsParamNull(TAG_PSDCCLUSTERNAME);
    }

    public final String getPSDCCLUSTERNAME() {
        return this.GetParamStringValue(TAG_PSDCCLUSTERNAME, "");
    }

    public final void setPSDCCLUSTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCLUSTERNAME, strValue);
    }

    public final boolean isPSDCCONTAINERSPECIDNull() {
        return this.IsParamNull(TAG_PSDCCONTAINERSPECID);
    }

    public final String getPSDCCONTAINERSPECID() {
        return this.GetParamStringValue(TAG_PSDCCONTAINERSPECID, "");
    }

    public final void setPSDCCONTAINERSPECID(String strValue) {
        this.SetParamValue(TAG_PSDCCONTAINERSPECID, strValue);
    }

    public final boolean isPSDCCONTAINERSPECNAMENull() {
        return this.IsParamNull(TAG_PSDCCONTAINERSPECNAME);
    }

    public final String getPSDCCONTAINERSPECNAME() {
        return this.GetParamStringValue(TAG_PSDCCONTAINERSPECNAME, "");
    }

    public final void setPSDCCONTAINERSPECNAME(String strValue) {
        this.SetParamValue(TAG_PSDCCONTAINERSPECNAME, strValue);
    }

    public final boolean isPSDCFILEIDNull() {
        return this.IsParamNull(TAG_PSDCFILEID);
    }

    public final String getPSDCFILEID() {
        return this.GetParamStringValue(TAG_PSDCFILEID, "");
    }

    public final void setPSDCFILEID(String strValue) {
        this.SetParamValue(TAG_PSDCFILEID, strValue);
    }

    public final boolean isPSDCFILENAMENull() {
        return this.IsParamNull(TAG_PSDCFILENAME);
    }

    public final String getPSDCFILENAME() {
        return this.GetParamStringValue(TAG_PSDCFILENAME, "");
    }

    public final void setPSDCFILENAME(String strValue) {
        this.SetParamValue(TAG_PSDCFILENAME, strValue);
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

    public final boolean isRESPOSNull() {
        return this.IsParamNull(TAG_RESPOS);
    }

    public final int getRESPOS() {
        return this.GetParamIntValue(TAG_RESPOS, 0);
    }

    public final void setRESPOS(int nValue) {
        this.SetParamValue(TAG_RESPOS, nValue);
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
}

