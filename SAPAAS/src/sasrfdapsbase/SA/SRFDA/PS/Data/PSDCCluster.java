/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCCluster
extends BaseDataEntity {
    public static final String CLUSTERTYPE_K8S = "K8S";
    public static final int RESPOS_1 = 1;
    public static final int RESPOS_2 = 2;
    public static final int RESPOS_5 = 5;
    public static final int RESPOS_10 = 10;
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String TAG_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String TAG_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_CLUSTERTYPE = "CLUSTERTYPE";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_PORT = "PORT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_PARAM = "PARAM";
    public static final String TAG_PARAM2 = "PARAM2";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_RESREADYTIME = "RESREADYTIME";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_RESVER = "RESVER";
    public static final String TAG_USERNAME = "USERNAME";
    public static final String TAG_USERTAG = "USERTAG";
    public static final String TAG_USERTAG2 = "USERTAG2";
    public static final String TAG_USERTAG3 = "USERTAG3";
    public static final String TAG_USERTAG4 = "USERTAG4";
    public static final String TAG_PARAM3 = "PARAM3";
    public static final String TAG_PARAM4 = "PARAM4";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_DOMAINNAME = "DOMAINNAME";
    public static final String TAG_URL = "URL";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_CLUSTERCFG = "CLUSTERCFG";
    public static final String TAG_CLUSTERPARAMS = "CLUSTERPARAMS";

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

    public final boolean isCLUSTERTYPENull() {
        return this.IsParamNull(TAG_CLUSTERTYPE);
    }

    public final String getCLUSTERTYPE() {
        return this.GetParamStringValue(TAG_CLUSTERTYPE, "");
    }

    public final void setCLUSTERTYPE(String strValue) {
        this.SetParamValue(TAG_CLUSTERTYPE, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isRESPOSNull() {
        return this.IsParamNull(TAG_RESPOS);
    }

    public final int getRESPOS() {
        return this.GetParamIntValue(TAG_RESPOS, 0);
    }

    public final void setRESPOS(int nValue) {
        this.SetParamValue(TAG_RESPOS, nValue);
    }

    public final boolean isRESREADYTIMENull() {
        return this.IsParamNull(TAG_RESREADYTIME);
    }

    public final Date getRESREADYTIME() {
        return this.GetParamDateValue(TAG_RESREADYTIME, null);
    }

    public final void setRESREADYTIME(Date dtValue) {
        this.SetParamValue(TAG_RESREADYTIME, dtValue);
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

    public final boolean isRESVERNull() {
        return this.IsParamNull(TAG_RESVER);
    }

    public final int getRESVER() {
        return this.GetParamIntValue(TAG_RESVER, 0);
    }

    public final void setRESVER(int nValue) {
        this.SetParamValue(TAG_RESVER, nValue);
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

    public final boolean isDOMAINNAMENull() {
        return this.IsParamNull(TAG_DOMAINNAME);
    }

    public final String getDOMAINNAME() {
        return this.GetParamStringValue(TAG_DOMAINNAME, "");
    }

    public final void setDOMAINNAME(String strValue) {
        this.SetParamValue(TAG_DOMAINNAME, strValue);
    }

    public final boolean isURLNull() {
        return this.IsParamNull(TAG_URL);
    }

    public final String getURL() {
        return this.GetParamStringValue(TAG_URL, "");
    }

    public final void setURL(String strValue) {
        this.SetParamValue(TAG_URL, strValue);
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

    public final boolean isCLUSTERCFGNull() {
        return this.IsParamNull(TAG_CLUSTERCFG);
    }

    public final String getCLUSTERCFG() {
        return this.GetParamStringValue(TAG_CLUSTERCFG, "");
    }

    public final void setCLUSTERCFG(String strValue) {
        this.SetParamValue(TAG_CLUSTERCFG, strValue);
    }

    public final boolean isCLUSTERPARAMSNull() {
        return this.IsParamNull(TAG_CLUSTERPARAMS);
    }

    public final String getCLUSTERPARAMS() {
        return this.GetParamStringValue(TAG_CLUSTERPARAMS, "");
    }

    public final void setCLUSTERPARAMS(String strValue) {
        this.SetParamValue(TAG_CLUSTERPARAMS, strValue);
    }
}

