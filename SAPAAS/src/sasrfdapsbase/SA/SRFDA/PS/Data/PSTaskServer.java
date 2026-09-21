/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSTaskServer
extends BaseDataEntity {
    public static final int DEVSYSDEPLOYMODE_LOCAL = 1;
    public static final int DEVSYSDEPLOYMODE_REMOTE = 2;
    public static final int DEVSYSDEPLOYMODE_LOCALANDREMOTE = 3;
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_SERVERURL = "SERVERURL";
    public static final String TAG_SERVERURL2 = "SERVERURL2";
    public static final String TAG_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String TAG_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String TAG_IPADDR = "IPADDR";
    public static final String TAG_IPADDR2 = "IPADDR2";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_REFINFO = "REFINFO";
    public static final String TAG_TSPARAMS = "TSPARAMS";
    public static final String TAG_DOMAINPARAMS = "DOMAINPARAMS";
    public static final String TAG_SYSVER = "SYSVER";
    public static final String TAG_PSMOBAPPPACKSERVERID = "PSMOBAPPPACKSERVERID";
    public static final String TAG_PSMOBAPPPACKSERVERNAME = "PSMOBAPPPACKSERVERNAME";
    public static final String TAG_NO2PSMOBAPPPSID = "NO2PSMOBAPPPSID";
    public static final String TAG_NO2PSMOBAPPPSNAME = "NO2PSMOBAPPPSNAME";
    public static final String TAG_DEVSYSDEPLOYMODE = "DEVSYSDEPLOYMODE";
    public static final String TAG_PSDEPLOYCENTERID = "PSDEPLOYCENTERID";
    public static final String TAG_PSDEPLOYCENTERNAME = "PSDEPLOYCENTERNAME";
    public static final String TAG_PSWORKSHOPSERVERID = "PSWORKSHOPSERVERID";
    public static final String TAG_PSWORKSHOPSERVERNAME = "PSWORKSHOPSERVERNAME";

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
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

    public final boolean isSERVERURLNull() {
        return this.IsParamNull(TAG_SERVERURL);
    }

    public final String getSERVERURL() {
        return this.GetParamStringValue(TAG_SERVERURL, "");
    }

    public final void setSERVERURL(String strValue) {
        this.SetParamValue(TAG_SERVERURL, strValue);
    }

    public final boolean isSERVERURL2Null() {
        return this.IsParamNull(TAG_SERVERURL2);
    }

    public final String getSERVERURL2() {
        return this.GetParamStringValue(TAG_SERVERURL2, "");
    }

    public final void setSERVERURL2(String strValue) {
        this.SetParamValue(TAG_SERVERURL2, strValue);
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

    public final boolean isREFINFONull() {
        return this.IsParamNull(TAG_REFINFO);
    }

    public final String getREFINFO() {
        return this.GetParamStringValue(TAG_REFINFO, "");
    }

    public final void setREFINFO(String strValue) {
        this.SetParamValue(TAG_REFINFO, strValue);
    }

    public final boolean isTSPARAMSNull() {
        return this.IsParamNull(TAG_TSPARAMS);
    }

    public final String getTSPARAMS() {
        return this.GetParamStringValue(TAG_TSPARAMS, "");
    }

    public final void setTSPARAMS(String strValue) {
        this.SetParamValue(TAG_TSPARAMS, strValue);
    }

    public final boolean isDOMAINPARAMSNull() {
        return this.IsParamNull(TAG_DOMAINPARAMS);
    }

    public final String getDOMAINPARAMS() {
        return this.GetParamStringValue(TAG_DOMAINPARAMS, "");
    }

    public final void setDOMAINPARAMS(String strValue) {
        this.SetParamValue(TAG_DOMAINPARAMS, strValue);
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

    public final boolean isPSMOBAPPPACKSERVERIDNull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKSERVERID);
    }

    public final String getPSMOBAPPPACKSERVERID() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKSERVERID, "");
    }

    public final void setPSMOBAPPPACKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKSERVERID, strValue);
    }

    public final boolean isPSMOBAPPPACKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSMOBAPPPACKSERVERNAME);
    }

    public final String getPSMOBAPPPACKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSMOBAPPPACKSERVERNAME, "");
    }

    public final void setPSMOBAPPPACKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSMOBAPPPACKSERVERNAME, strValue);
    }

    public final String getNO2PSMOBAPPPSID() {
        return this.GetParamStringValue(TAG_NO2PSMOBAPPPSID, "");
    }

    public final void setNO2PSMOBAPPPSID(String strValue) {
        this.SetParamValue(TAG_NO2PSMOBAPPPSID, strValue);
    }

    public final boolean isNO2PSMOBAPPPSNAMENull() {
        return this.IsParamNull(TAG_NO2PSMOBAPPPSNAME);
    }

    public final String getNO2PSMOBAPPPSNAME() {
        return this.GetParamStringValue(TAG_NO2PSMOBAPPPSNAME, "");
    }

    public final void setNO2PSMOBAPPPSNAME(String strValue) {
        this.SetParamValue(TAG_NO2PSMOBAPPPSNAME, strValue);
    }

    public final boolean isDEVSYSDEPLOYMODENull() {
        return this.IsParamNull(TAG_DEVSYSDEPLOYMODE);
    }

    public final int getDEVSYSDEPLOYMODE() {
        return this.GetParamIntValue(TAG_DEVSYSDEPLOYMODE, 0);
    }

    public final void setDEVSYSDEPLOYMODE(int nValue) {
        this.SetParamValue(TAG_DEVSYSDEPLOYMODE, nValue);
    }

    public final boolean isPSDEPLOYCENTERIDNull() {
        return this.IsParamNull(TAG_PSDEPLOYCENTERID);
    }

    public final String getPSDEPLOYCENTERID() {
        return this.GetParamStringValue(TAG_PSDEPLOYCENTERID, "");
    }

    public final void setPSDEPLOYCENTERID(String strValue) {
        this.SetParamValue(TAG_PSDEPLOYCENTERID, strValue);
    }

    public final boolean isPSDEPLOYCENTERNAMENull() {
        return this.IsParamNull(TAG_PSDEPLOYCENTERNAME);
    }

    public final String getPSDEPLOYCENTERNAME() {
        return this.GetParamStringValue(TAG_PSDEPLOYCENTERNAME, "");
    }

    public final void setPSDEPLOYCENTERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEPLOYCENTERNAME, strValue);
    }

    public final boolean isPSWORKSHOPSERVERIDNull() {
        return this.IsParamNull(TAG_PSWORKSHOPSERVERID);
    }

    public final String getPSWORKSHOPSERVERID() {
        return this.GetParamStringValue(TAG_PSWORKSHOPSERVERID, "");
    }

    public final void setPSWORKSHOPSERVERID(String strValue) {
        this.SetParamValue(TAG_PSWORKSHOPSERVERID, strValue);
    }

    public final boolean isPSWORKSHOPSERVERNAMENull() {
        return this.IsParamNull(TAG_PSWORKSHOPSERVERNAME);
    }

    public final String getPSWORKSHOPSERVERNAME() {
        return this.GetParamStringValue(TAG_PSWORKSHOPSERVERNAME, "");
    }

    public final void setPSWORKSHOPSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSWORKSHOPSERVERNAME, strValue);
    }
}

