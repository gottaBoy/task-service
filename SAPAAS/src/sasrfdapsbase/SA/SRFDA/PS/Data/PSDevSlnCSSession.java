/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDevSlnCSSession
extends BaseDataEntity {
    public static final int RESSTATE_10 = 10;
    public static final int RESSTATE_11 = 11;
    public static final int RESSTATE_20 = 20;
    public static final int RESSTATE_40 = 40;
    public static final int RESSTATE_41 = 41;
    public static final int RESSTATE_42 = 42;
    public static final String CODETARGET_ADVANCE = "ADVANCE";
    public static final String CODETARGET_PSDEVSLNSYS = "PSDEVSLNSYS";
    public static final String CODETARGET_PSDEVSLNTEMPL = "PSDEVSLNTEMPL";
    public static final String TAG_PSDEVSLNCSSESSIONID = "PSDEVSLNCSSESSIONID";
    public static final String TAG_PSDEVSLNCSSESSIONNAME = "PSDEVSLNCSSESSIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVSLNUSERCSID = "PSDEVSLNUSERCSID";
    public static final String TAG_PSDEVSLNUSERCSNAME = "PSDEVSLNUSERCSNAME";
    public static final String TAG_GITPATH = "GITPATH";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_HOSTPASSWD = "HOSTPASSWD";
    public static final String TAG_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String TAG_RESREADYTIME = "RESREADYTIME";
    public static final String TAG_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String TAG_RESSTATE = "RESSTATE";
    public static final String TAG_HOSTADDRESS = "HOSTADDRESS";
    public static final String TAG_HOSTPORT = "HOSTPORT";
    public static final String TAG_GITUSER = "GITUSER";
    public static final String TAG_WORKSHOPPATH = "WORKSHOPPATH";
    public static final String TAG_CSPARAM4 = "CSPARAM4";
    public static final String TAG_CSPARAM3 = "CSPARAM3";
    public static final String TAG_CSPARAM2 = "CSPARAM2";
    public static final String TAG_CSPARAM = "CSPARAM";
    public static final String TAG_CSPARAMS = "CSPARAMS";
    public static final String TAG_READONLYMODE = "READONLYMODE";
    public static final String TAG_CODETARGET = "CODETARGET";
    public static final String TAG_TARGETID = "TARGETID";

    public final boolean isPSDEVSLNCSSESSIONIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNCSSESSIONID);
    }

    public final String getPSDEVSLNCSSESSIONID() {
        return this.GetParamStringValue(TAG_PSDEVSLNCSSESSIONID, "");
    }

    public final void setPSDEVSLNCSSESSIONID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNCSSESSIONID, strValue);
    }

    public final boolean isPSDEVSLNCSSESSIONNAMENull() {
        return this.IsParamNull(TAG_PSDEVSLNCSSESSIONNAME);
    }

    public final String getPSDEVSLNCSSESSIONNAME() {
        return this.GetParamStringValue(TAG_PSDEVSLNCSSESSIONNAME, "");
    }

    public final void setPSDEVSLNCSSESSIONNAME(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNCSSESSIONNAME, strValue);
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

    public final boolean isGITPATHNull() {
        return this.IsParamNull(TAG_GITPATH);
    }

    public final String getGITPATH() {
        return this.GetParamStringValue(TAG_GITPATH, "");
    }

    public final void setGITPATH(String strValue) {
        this.SetParamValue(TAG_GITPATH, strValue);
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

    public final boolean isRESREADYTIMENull() {
        return this.IsParamNull(TAG_RESREADYTIME);
    }

    public final Date getRESREADYTIME() {
        return this.GetParamDateValue(TAG_RESREADYTIME, null);
    }

    public final void setRESREADYTIME(Date dtValue) {
        this.SetParamValue(TAG_RESREADYTIME, dtValue);
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

    public final boolean isRESSTATENull() {
        return this.IsParamNull(TAG_RESSTATE);
    }

    public final int getRESSTATE() {
        return this.GetParamIntValue(TAG_RESSTATE, 0);
    }

    public final void setRESSTATE(int nValue) {
        this.SetParamValue(TAG_RESSTATE, nValue);
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

    public final boolean isHOSTPORTNull() {
        return this.IsParamNull(TAG_HOSTPORT);
    }

    public final int getHOSTPORT() {
        return this.GetParamIntValue(TAG_HOSTPORT, 0);
    }

    public final void setHOSTPORT(int nValue) {
        this.SetParamValue(TAG_HOSTPORT, nValue);
    }

    public final boolean isGITUSERNull() {
        return this.IsParamNull(TAG_GITUSER);
    }

    public final String getGITUSER() {
        return this.GetParamStringValue(TAG_GITUSER, "");
    }

    public final void setGITUSER(String strValue) {
        this.SetParamValue(TAG_GITUSER, strValue);
    }

    public final boolean isWORKSHOPPATHNull() {
        return this.IsParamNull(TAG_WORKSHOPPATH);
    }

    public final String getWORKSHOPPATH() {
        return this.GetParamStringValue(TAG_WORKSHOPPATH, "");
    }

    public final void setWORKSHOPPATH(String strValue) {
        this.SetParamValue(TAG_WORKSHOPPATH, strValue);
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

    public final boolean isCSPARAM3Null() {
        return this.IsParamNull(TAG_CSPARAM3);
    }

    public final int getCSPARAM3() {
        return this.GetParamIntValue(TAG_CSPARAM3, 0);
    }

    public final void setCSPARAM3(int nValue) {
        this.SetParamValue(TAG_CSPARAM3, nValue);
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

    public final boolean isCSPARAMNull() {
        return this.IsParamNull(TAG_CSPARAM);
    }

    public final String getCSPARAM() {
        return this.GetParamStringValue(TAG_CSPARAM, "");
    }

    public final void setCSPARAM(String strValue) {
        this.SetParamValue(TAG_CSPARAM, strValue);
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

    public final boolean isREADONLYMODENull() {
        return this.IsParamNull(TAG_READONLYMODE);
    }

    public final boolean getREADONLYMODE() {
        return this.GetParamIntValue(TAG_READONLYMODE, 0) == 1;
    }

    public final void setREADONLYMODE(boolean bValue) {
        this.SetParamValue(TAG_READONLYMODE, bValue ? 1 : 0);
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

    public final boolean isTARGETIDNull() {
        return this.IsParamNull(TAG_TARGETID);
    }

    public final String getTARGETID() {
        return this.GetParamStringValue(TAG_TARGETID, "");
    }

    public final void setTARGETID(String strValue) {
        this.SetParamValue(TAG_TARGETID, strValue);
    }
}

