/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCASGroup
extends BaseDataEntity {
    public static final String ASTYPE_TOMCAT7 = "TOMCAT7";
    public static final String USAGEMODE_DEVELOP = "DEVELOP";
    public static final String USAGEMODE_DEPLOY = "DEPLOY";
    public static final String TAG_PSDCASGROUPID = "PSDCASGROUPID";
    public static final String TAG_PSDCASGROUPNAME = "PSDCASGROUPNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSASGROUPID = "PSASGROUPID";
    public static final String TAG_PSASGROUPNAME = "PSASGROUPNAME";
    public static final String TAG_ASTYPE = "ASTYPE";
    public static final String TAG_HTTPPORT = "HTTPPORT";
    public static final String TAG_HTTPSPORT = "HTTPSPORT";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_REFFLAG = "REFFLAG";
    public static final String TAG_REFOBJID = "REFOBJID";
    public static final String TAG_REFOBJNAME = "REFOBJNAME";
    public static final String TAG_USAGEMODE = "USAGEMODE";

    public final boolean isPSDCASGROUPIDNull() {
        return this.IsParamNull(TAG_PSDCASGROUPID);
    }

    public final String getPSDCASGROUPID() {
        return this.GetParamStringValue(TAG_PSDCASGROUPID, "");
    }

    public final void setPSDCASGROUPID(String strValue) {
        this.SetParamValue(TAG_PSDCASGROUPID, strValue);
    }

    public final boolean isPSDCASGROUPNAMENull() {
        return this.IsParamNull(TAG_PSDCASGROUPNAME);
    }

    public final String getPSDCASGROUPNAME() {
        return this.GetParamStringValue(TAG_PSDCASGROUPNAME, "");
    }

    public final void setPSDCASGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSDCASGROUPNAME, strValue);
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

    public final boolean isPSASGROUPIDNull() {
        return this.IsParamNull(TAG_PSASGROUPID);
    }

    public final String getPSASGROUPID() {
        return this.GetParamStringValue(TAG_PSASGROUPID, "");
    }

    public final void setPSASGROUPID(String strValue) {
        this.SetParamValue(TAG_PSASGROUPID, strValue);
    }

    public final boolean isPSASGROUPNAMENull() {
        return this.IsParamNull(TAG_PSASGROUPNAME);
    }

    public final String getPSASGROUPNAME() {
        return this.GetParamStringValue(TAG_PSASGROUPNAME, "");
    }

    public final void setPSASGROUPNAME(String strValue) {
        this.SetParamValue(TAG_PSASGROUPNAME, strValue);
    }

    public final boolean isASTYPENull() {
        return this.IsParamNull(TAG_ASTYPE);
    }

    public final String getASTYPE() {
        return this.GetParamStringValue(TAG_ASTYPE, "");
    }

    public final void setASTYPE(String strValue) {
        this.SetParamValue(TAG_ASTYPE, strValue);
    }

    public final boolean isHTTPPORTNull() {
        return this.IsParamNull(TAG_HTTPPORT);
    }

    public final int getHTTPPORT() {
        return this.GetParamIntValue(TAG_HTTPPORT, 0);
    }

    public final void setHTTPPORT(int nValue) {
        this.SetParamValue(TAG_HTTPPORT, nValue);
    }

    public final boolean isHTTPSPORTNull() {
        return this.IsParamNull(TAG_HTTPSPORT);
    }

    public final int getHTTPSPORT() {
        return this.GetParamIntValue(TAG_HTTPSPORT, 0);
    }

    public final void setHTTPSPORT(int nValue) {
        this.SetParamValue(TAG_HTTPSPORT, nValue);
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

    public final boolean isREFFLAGNull() {
        return this.IsParamNull(TAG_REFFLAG);
    }

    public final boolean getREFFLAG() {
        return this.GetParamIntValue(TAG_REFFLAG, 0) == 1;
    }

    public final void setREFFLAG(boolean bValue) {
        this.SetParamValue(TAG_REFFLAG, bValue ? 1 : 0);
    }

    public final boolean isREFOBJIDNull() {
        return this.IsParamNull(TAG_REFOBJID);
    }

    public final String getREFOBJID() {
        return this.GetParamStringValue(TAG_REFOBJID, "");
    }

    public final void setREFOBJID(String strValue) {
        this.SetParamValue(TAG_REFOBJID, strValue);
    }

    public final boolean isREFOBJNAMENull() {
        return this.IsParamNull(TAG_REFOBJNAME);
    }

    public final String getREFOBJNAME() {
        return this.GetParamStringValue(TAG_REFOBJNAME, "");
    }

    public final void setREFOBJNAME(String strValue) {
        this.SetParamValue(TAG_REFOBJNAME, strValue);
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
}

