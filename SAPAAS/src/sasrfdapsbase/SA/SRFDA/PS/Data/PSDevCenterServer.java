/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevCenterServer
extends BaseDataEntity {
    public static final int RESPOS_1 = 1;
    public static final int RESPOS_2 = 2;
    public static final int RESPOS_5 = 5;
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String DSTYPE_WIN2008 = "WIN2008";
    public static final String DSTYPE_WIN2012 = "WIN2012";
    public static final String TAG_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String TAG_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String TAG_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_HOSTADDRESS = "HOSTADDRESS";
    public static final String TAG_HOSTPASSWD = "HOSTPASSWD";
    public static final String TAG_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String TAG_RESPOS = "RESPOS";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_RESREADYTIME = "RESREADYTIME";
    public static final String TAG_DSTYPE = "DSTYPE";

    public final boolean isPSDEVCENTERSERVERIDNull() {
        return this.IsParamNull(TAG_PSDEVCENTERSERVERID);
    }

    public final String getPSDEVCENTERSERVERID() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSERVERID, "");
    }

    public final void setPSDEVCENTERSERVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSERVERID, strValue);
    }

    public final boolean isPSDEVCENTERSERVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVCENTERSERVERNAME);
    }

    public final String getPSDEVCENTERSERVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVCENTERSERVERNAME, "");
    }

    public final void setPSDEVCENTERSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVCENTERSERVERNAME, strValue);
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

    public final boolean isHOSTADDRESSNull() {
        return this.IsParamNull(TAG_HOSTADDRESS);
    }

    public final String getHOSTADDRESS() {
        return this.GetParamStringValue(TAG_HOSTADDRESS, "");
    }

    public final void setHOSTADDRESS(String strValue) {
        this.SetParamValue(TAG_HOSTADDRESS, strValue);
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

    public final boolean isHOSTUSERNAMENull() {
        return this.IsParamNull(TAG_HOSTUSERNAME);
    }

    public final String getHOSTUSERNAME() {
        return this.GetParamStringValue(TAG_HOSTUSERNAME, "");
    }

    public final void setHOSTUSERNAME(String strValue) {
        this.SetParamValue(TAG_HOSTUSERNAME, strValue);
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

    public final boolean isRESREADYTIMENull() {
        return this.IsParamNull(TAG_RESREADYTIME);
    }

    public final Date getRESREADYTIME() {
        return this.GetParamDateValue(TAG_RESREADYTIME, null);
    }

    public final void setRESREADYTIME(Date dtValue) {
        this.SetParamValue(TAG_RESREADYTIME, dtValue);
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
}

