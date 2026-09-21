/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnCodeServer
extends BaseDataEntity {
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String TAG_PSDEVSLNCODESERVERID = "PSDEVSLNCODESERVERID";
    public static final String TAG_PSDEVSLNCODESERVERNAME = "PSDEVSLNCODESERVERNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String TAG_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_RESREADYTIME = "RESREADYTIME";
    public static final String TAG_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String TAG_HOSTPASSWD = "HOSTPASSWD";
    public static final String TAG_CSPARAM = "CSPARAM";
    public static final String TAG_CSPARAM2 = "CSPARAM2";
    public static final String TAG_CSPARAM3 = "CSPARAM3";
    public static final String TAG_CSPARAM4 = "CSPARAM4";

    public final boolean isPSDEVSLNCODESERVERIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNCODESERVERID);
    }

    public final String getPSDEVSLNCODESERVERID() {
        return this.GetParamStringValue(TAG_PSDEVSLNCODESERVERID, "");
    }

    public final void setPSDEVSLNCODESERVERID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNCODESERVERID, strValue);
    }

    public final boolean isPSDEVSLNCODESERVERNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNCODESERVERNAME);
    }

    public final String getPSDEVSLNCODESERVERNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNCODESERVERNAME, "");
    }

    public final void setPSDEVSLNCODESERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNCODESERVERNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
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

    public final boolean isCSPARAMNull() {
        return this.IsParamNull(TAG_CSPARAM);
    }

    public final String getCSPARAM() {
        return this.GetParamStringValue(TAG_CSPARAM, "");
    }

    public final void setCSPARAM(String strValue) {
        this.SetParamValue(TAG_CSPARAM, strValue);
    }

    public final boolean isCSPARAM2Null() {
        return this.IsParamNull(TAG_CSPARAM2);
    }

    public final String getCSPARAM2() {
        return this.GetParamStringValue(TAG_CSPARAM2, "");
    }

    public final void setCSPARAM2(String strValue) {
        this.SetParamValue(TAG_CSPARAM2, strValue);
    }

    public final boolean isCSPARAM3Null() {
        return this.IsParamNull(TAG_CSPARAM3);
    }

    public final int getCSPARAM3() {
        return this.GetParamIntValue(TAG_CSPARAM3, 0);
    }

    public final void setCSPARAM3(int nValue) {
        this.SetParamValue(TAG_CSPARAM3, nValue);
    }

    public final boolean isCSPARAM4Null() {
        return this.IsParamNull(TAG_CSPARAM4);
    }

    public final int getCSPARAM4() {
        return this.GetParamIntValue(TAG_CSPARAM4, 0);
    }

    public final void setCSPARAM4(int nValue) {
        this.SetParamValue(TAG_CSPARAM4, nValue);
    }
}

