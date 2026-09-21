/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnMSDepFuncItem
extends BaseDataEntity {
    public static final String ITEMTYPE_APP = "APP";
    public static final String ITEMTYPE_API = "API";
    public static final String AUTHMODE_NONE = "NONE";
    public static final String AUTHMODE_AUTHORIZATION_CODE = "AUTHORIZATION_CODE";
    public static final String AUTHMODE_PASSWORD = "PASSWORD";
    public static final String AUTHMODE_CLIENT_CREDENTIALS = "CLIENT_CREDENTIALS";
    public static final String AUTHMODE_IMPLICIT = "IMPLICIT";
    public static final String TAG_PSDEVSLNMSDEPFUNCITEMID = "PSDEVSLNMSDEPFUNCITEMID";
    public static final String TAG_PSDEVSLNMSDEPFUNCITEMNAME = "PSDEVSLNMSDEPFUNCITEMNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNMSDEPFUNCID = "PSDEVSLNMSDEPFUNCID";
    public static final String TAG_PSDEVSLNMSDEPFUNCNAME = "PSDEVSLNMSDEPFUNCNAME";
    public static final String TAG_ITEMTYPE = "ITEMTYPE";
    public static final String TAG_PSDEVSLNSYSAPPID = "PSDEVSLNSYSAPPID";
    public static final String TAG_PSDEVSLNSYSAPPNAME = "PSDEVSLNSYSAPPNAME";
    public static final String TAG_PSDEVSLNSYSAPIID = "PSDEVSLNSYSAPIID";
    public static final String TAG_PSDEVSLNSYSAPINAME = "PSDEVSLNSYSAPINAME";
    public static final String TAG_AUTHCHECKTOKENURI = "AUTHCHECKTOKENURI";
    public static final String TAG_AUTHCLIENTID = "AUTHCLIENTID";
    public static final String TAG_AUTHCLIENTSECRET = "AUTHCLIENTSECRET";
    public static final String TAG_AUTHMODE = "AUTHMODE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_VALIDFLAG = "VALIDFLAG";
    public static final String TAG_PSSYSAPPID = "PSSYSAPPID";
    public static final String TAG_PSSYSSERVICEAPIID = "PSSYSSERVICEAPIID";

    public final boolean isPSDEVSLNMSDEPFUNCITEMIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPFUNCITEMID);
    }

    public final String getPSDEVSLNMSDEPFUNCITEMID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPFUNCITEMID, "");
    }

    public final void setPSDEVSLNMSDEPFUNCITEMID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPFUNCITEMID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPFUNCITEMNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPFUNCITEMNAME);
    }

    public final String getPSDEVSLNMSDEPFUNCITEMNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPFUNCITEMNAME, "");
    }

    public final void setPSDEVSLNMSDEPFUNCITEMNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPFUNCITEMNAME, strValue);
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

    public final boolean isPSDEVSLNMSDEPFUNCIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPFUNCID);
    }

    public final String getPSDEVSLNMSDEPFUNCID() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPFUNCID, "");
    }

    public final void setPSDEVSLNMSDEPFUNCID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPFUNCID, strValue);
    }

    public final boolean isPSDEVSLNMSDEPFUNCNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNMSDEPFUNCNAME);
    }

    public final String getPSDEVSLNMSDEPFUNCNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNMSDEPFUNCNAME, "");
    }

    public final void setPSDEVSLNMSDEPFUNCNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNMSDEPFUNCNAME, strValue);
    }

    public final boolean isITEMTYPENull() {
        return this.IsParamNull(TAG_ITEMTYPE);
    }

    public final String getITEMTYPE() {
        return this.GetParamStringValue(TAG_ITEMTYPE, "");
    }

    public final void setITEMTYPE(String strValue) {
        this.SetParamValue(TAG_ITEMTYPE, strValue);
    }

    public final boolean isPSDEVSLNSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPID);
    }

    public final String getPSDEVSLNSYSAPPID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPID, "");
    }

    public final void setPSDEVSLNSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPID, strValue);
    }

    public final boolean isPSDEVSLNSYSAPPNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPPNAME);
    }

    public final String getPSDEVSLNSYSAPPNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPPNAME, "");
    }

    public final void setPSDEVSLNSYSAPPNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPPNAME, strValue);
    }

    public final boolean isPSDEVSLNSYSAPIIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPIID);
    }

    public final String getPSDEVSLNSYSAPIID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPIID, "");
    }

    public final void setPSDEVSLNSYSAPIID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPIID, strValue);
    }

    public final boolean isPSDEVSLNSYSAPINAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSAPINAME);
    }

    public final String getPSDEVSLNSYSAPINAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSAPINAME, "");
    }

    public final void setPSDEVSLNSYSAPINAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSAPINAME, strValue);
    }

    public final boolean isAUTHCHECKTOKENURINull() {
        return this.IsParamNull(TAG_AUTHCHECKTOKENURI);
    }

    public final String getAUTHCHECKTOKENURI() {
        return this.GetParamStringValue(TAG_AUTHCHECKTOKENURI, "");
    }

    public final void setAUTHCHECKTOKENURI(String strValue) {
        this.SetParamValue(TAG_AUTHCHECKTOKENURI, strValue);
    }

    public final boolean isAUTHCLIENTIDNull() {
        return this.IsParamNull(TAG_AUTHCLIENTID);
    }

    public final String getAUTHCLIENTID() {
        return this.GetParamStringValue(TAG_AUTHCLIENTID, "");
    }

    public final void setAUTHCLIENTID(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTID, strValue);
    }

    public final boolean isAUTHCLIENTSECRETNull() {
        return this.IsParamNull(TAG_AUTHCLIENTSECRET);
    }

    public final String getAUTHCLIENTSECRET() {
        return this.GetParamStringValue(TAG_AUTHCLIENTSECRET, "");
    }

    public final void setAUTHCLIENTSECRET(String strValue) {
        this.SetParamValue(TAG_AUTHCLIENTSECRET, strValue);
    }

    public final boolean isAUTHMODENull() {
        return this.IsParamNull(TAG_AUTHMODE);
    }

    public final String getAUTHMODE() {
        return this.GetParamStringValue(TAG_AUTHMODE, "");
    }

    public final void setAUTHMODE(String strValue) {
        this.SetParamValue(TAG_AUTHMODE, strValue);
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

    public final boolean isVALIDFLAGNull() {
        return this.IsParamNull(TAG_VALIDFLAG);
    }

    public final boolean getVALIDFLAG() {
        return this.GetParamIntValue(TAG_VALIDFLAG, 0) == 1;
    }

    public final void setVALIDFLAG(boolean bValue) {
        this.SetParamValue(TAG_VALIDFLAG, bValue ? 1 : 0);
    }

    public final boolean isPSSYSAPPIDNull() {
        return this.IsParamNull(TAG_PSSYSAPPID);
    }

    public final String getPSSYSAPPID() {
        return this.GetParamStringValue(TAG_PSSYSAPPID, "");
    }

    public final void setPSSYSAPPID(String strValue) {
        this.SetParamValue(TAG_PSSYSAPPID, strValue);
    }

    public final boolean isPSSYSSERVICEAPIIDNull() {
        return this.IsParamNull(TAG_PSSYSSERVICEAPIID);
    }

    public final String getPSSYSSERVICEAPIID() {
        return this.GetParamStringValue(TAG_PSSYSSERVICEAPIID, "");
    }

    public final void setPSSYSSERVICEAPIID(String strValue) {
        this.SetParamValue(TAG_PSSYSSERVICEAPIID, strValue);
    }
}

