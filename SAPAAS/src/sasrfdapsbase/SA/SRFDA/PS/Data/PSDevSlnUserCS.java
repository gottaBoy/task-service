/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnUserCS
extends BaseDataEntity {
    public static final String CODETARGET_ADVANCE = "ADVANCE";
    public static final String CODETARGET_PSDEVSLNSYS = "PSDEVSLNSYS";
    public static final String CODETARGET_PSDEVSLNTEMPL = "PSDEVSLNTEMPL";
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String TAG_PSDEVSLNUSERCSID = "PSDEVSLNUSERCSID";
    public static final String TAG_PSDEVSLNUSERCSNAME = "PSDEVSLNUSERCSNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_PSDEVUSERID = "PSDEVUSERID";
    public static final String TAG_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String TAG_ALLUSERFLAG = "ALLUSERFLAG";
    public static final String TAG_CODETARGET = "CODETARGET";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String TAG_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String TAG_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String TAG_RESREADYTIME = "RESREADYTIME";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_HOSTPASSWD = "HOSTPASSWD";
    public static final String TAG_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_PSDEVSLNCODESERVERID = "PSDEVSLNCODESERVERID";
    public static final String TAG_PSDEVSLNCODESERVERNAME = "PSDEVSLNCODESERVERNAME";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_CSPARAMS = "CSPARAMS";
    public static final String TAG_CSPARAM = "CSPARAM";
    public static final String TAG_CSPARAM2 = "CSPARAM2";
    public static final String TAG_CSPARAM3 = "CSPARAM3";
    public static final String TAG_CSPARAM4 = "CSPARAM4";

    public final boolean isPSDEVSLNUSERCSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNUSERCSID);
    }

    public final String getPSDEVSLNUSERCSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNUSERCSID, "");
    }

    public final void setPSDEVSLNUSERCSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNUSERCSID, strValue);
    }

    public final boolean isPSDEVSLNUSERCSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNUSERCSNAME);
    }

    public final String getPSDEVSLNUSERCSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNUSERCSNAME, "");
    }

    public final void setPSDEVSLNUSERCSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNUSERCSNAME, strValue);
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

    public final boolean isPSDEVUSERIDNull() {
        return this.IsParamNull(TAG_PSDEVUSERID);
    }

    public final String getPSDEVUSERID() {
        return this.GetParamStringValue(TAG_PSDEVUSERID, "");
    }

    public final void setPSDEVUSERID(String strValue) {
        this.SetParamValue(TAG_PSDEVUSERID, strValue);
    }

    public final boolean isPSDEVUSERNAMENull() {
        return this.IsParamNull(TAG_PSDEVUSERNAME);
    }

    public final String getPSDEVUSERNAME() {
        return this.GetParamStringValue(TAG_PSDEVUSERNAME, "");
    }

    public final void setPSDEVUSERNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVUSERNAME, strValue);
    }

    public final boolean isALLUSERFLAGNull() {
        return this.IsParamNull(TAG_ALLUSERFLAG);
    }

    public final boolean getALLUSERFLAG() {
        return this.GetParamIntValue(TAG_ALLUSERFLAG, 0) == 1;
    }

    public final void setALLUSERFLAG(boolean bValue) {
        this.SetParamValue(TAG_ALLUSERFLAG, bValue ? 1 : 0);
    }

    public final boolean isCODETARGETNull() {
        return this.IsParamNull(TAG_CODETARGET);
    }

    public final String getCODETARGET() {
        return this.GetParamStringValue(TAG_CODETARGET, "");
    }

    public final void setCODETARGET(String strValue) {
        this.SetParamValue(TAG_CODETARGET, strValue);
    }

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSDEVSLNSYSNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSNAME);
    }

    public final String getPSDEVSLNSYSNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSNAME, "");
    }

    public final void setPSDEVSLNSYSNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSNAME, strValue);
    }

    public final boolean isPSDEVSLNTEMPLIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNTEMPLID);
    }

    public final String getPSDEVSLNTEMPLID() {
        return this.GetParamStringValue(TAG_PSDEVSLNTEMPLID, "");
    }

    public final void setPSDEVSLNTEMPLID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNTEMPLID, strValue);
    }

    public final boolean isPSDEVSLNTEMPLNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNTEMPLNAME);
    }

    public final String getPSDEVSLNTEMPLNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNTEMPLNAME, "");
    }

    public final void setPSDEVSLNTEMPLNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNTEMPLNAME, strValue);
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

    public final boolean isEXPRIEDTIMENull() {
        return this.IsParamNull(TAG_EXPRIEDTIME);
    }

    public final Date getEXPRIEDTIME() {
        return this.GetParamDateValue(TAG_EXPRIEDTIME, null);
    }

    public final void setEXPRIEDTIME(Date dtValue) {
        this.SetParamValue(TAG_EXPRIEDTIME, dtValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
    }

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

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.SetParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
    }

    public final boolean isCSPARAMSNull() {
        return this.IsParamNull(TAG_CSPARAMS);
    }

    public final String getCSPARAMS() {
        return this.GetParamStringValue(TAG_CSPARAMS, "");
    }

    public final void setCSPARAMS(String strValue) {
        this.SetParamValue(TAG_CSPARAMS, strValue);
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

