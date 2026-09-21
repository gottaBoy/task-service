/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSCodeServerAction
extends BaseDataEntity {
    public static final int ACTIONSTATE_10 = 10;
    public static final int ACTIONSTATE_20 = 20;
    public static final int ACTIONSTATE_30 = 30;
    public static final int ACTIONSTATE_40 = 40;
    public static final String TAG_PSCODESERVERACTIONID = "PSCODESERVERACTIONID";
    public static final String TAG_PSCODESERVERACTIONNAME = "PSCODESERVERACTIONNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_ACTIONSTATE = "ACTIONSTATE";
    public static final String TAG_ACTIONRESULT = "ACTIONRESULT";
    public static final String TAG_CODESERVERURL = "CODESERVERURL";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSOBJTYPE = "PSOBJTYPE";
    public static final String TAG_PSOBJID = "PSOBJID";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_ACTIONSTEP = "ACTIONSTEP";
    public static final String TAG_ACTIONPARAM = "ACTIONPARAM";
    public static final String TAG_ACTIONPARAM2 = "ACTIONPARAM2";
    public static final String TAG_ACTIONPARAM3 = "ACTIONPARAM3";
    public static final String TAG_ACTIONPARAM4 = "ACTIONPARAM4";
    public static final String TAG_ACTIONPARAM5 = "ACTIONPARAM5";
    public static final String TAG_ACTIONPARAM6 = "ACTIONPARAM6";
    public static final String TAG_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String TAG_PASSWD = "PASSWD";

    public final boolean isPSCODESERVERACTIONIDNull() {
        return this.IsParamNull(TAG_PSCODESERVERACTIONID);
    }

    public final String getPSCODESERVERACTIONID() {
        return this.GetParamStringValue(TAG_PSCODESERVERACTIONID, "");
    }

    public final void setPSCODESERVERACTIONID(String strValue) {
        this.SetParamValue(TAG_PSCODESERVERACTIONID, strValue);
    }

    public final boolean isPSCODESERVERACTIONNAMENull() {
        return this.IsParamNull(TAG_PSCODESERVERACTIONNAME);
    }

    public final String getPSCODESERVERACTIONNAME() {
        return this.GetParamStringValue(TAG_PSCODESERVERACTIONNAME, "");
    }

    public final void setPSCODESERVERACTIONNAME(String strValue) {
        this.SetParamValue(TAG_PSCODESERVERACTIONNAME, strValue);
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

    public final boolean isACTIONSTATENull() {
        return this.IsParamNull(TAG_ACTIONSTATE);
    }

    public final int getACTIONSTATE() {
        return this.GetParamIntValue(TAG_ACTIONSTATE, 0);
    }

    public final void setACTIONSTATE(int nValue) {
        this.SetParamValue(TAG_ACTIONSTATE, nValue);
    }

    public final boolean isACTIONRESULTNull() {
        return this.IsParamNull(TAG_ACTIONRESULT);
    }

    public final String getACTIONRESULT() {
        return this.GetParamStringValue(TAG_ACTIONRESULT, "");
    }

    public final void setACTIONRESULT(String strValue) {
        this.SetParamValue(TAG_ACTIONRESULT, strValue);
    }

    public final boolean isCODESERVERURLNull() {
        return this.IsParamNull(TAG_CODESERVERURL);
    }

    public final String getCODESERVERURL() {
        return this.GetParamStringValue(TAG_CODESERVERURL, "");
    }

    public final void setCODESERVERURL(String strValue) {
        this.SetParamValue(TAG_CODESERVERURL, strValue);
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

    public final boolean isPSOBJTYPENull() {
        return this.IsParamNull(TAG_PSOBJTYPE);
    }

    public final String getPSOBJTYPE() {
        return this.GetParamStringValue(TAG_PSOBJTYPE, "");
    }

    public final void setPSOBJTYPE(String strValue) {
        this.SetParamValue(TAG_PSOBJTYPE, strValue);
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

    public final boolean isBEGINTIMENull() {
        return this.IsParamNull(TAG_BEGINTIME);
    }

    public final Date getBEGINTIME() {
        return this.GetParamDateValue(TAG_BEGINTIME, null);
    }

    public final void setBEGINTIME(Date dtValue) {
        this.SetParamValue(TAG_BEGINTIME, dtValue);
    }

    public final boolean isENDTIMENull() {
        return this.IsParamNull(TAG_ENDTIME);
    }

    public final Date getENDTIME() {
        return this.GetParamDateValue(TAG_ENDTIME, null);
    }

    public final void setENDTIME(Date dtValue) {
        this.SetParamValue(TAG_ENDTIME, dtValue);
    }

    public final boolean isPSTASKSERVERIDNull() {
        return this.IsParamNull(TAG_PSTASKSERVERID);
    }

    public final String getPSTASKSERVERID() {
        return this.GetParamStringValue(TAG_PSTASKSERVERID, "");
    }

    public final void setPSTASKSERVERID(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERID, strValue);
    }

    public final boolean isACTIONSTEPNull() {
        return this.IsParamNull(TAG_ACTIONSTEP);
    }

    public final String getACTIONSTEP() {
        return this.GetParamStringValue(TAG_ACTIONSTEP, "");
    }

    public final void setACTIONSTEP(String strValue) {
        this.SetParamValue(TAG_ACTIONSTEP, strValue);
    }

    public final boolean isACTIONPARAMNull() {
        return this.IsParamNull(TAG_ACTIONPARAM);
    }

    public final String getACTIONPARAM() {
        return this.GetParamStringValue(TAG_ACTIONPARAM, "");
    }

    public final void setACTIONPARAM(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM, strValue);
    }

    public final boolean isACTIONPARAM2Null() {
        return this.IsParamNull(TAG_ACTIONPARAM2);
    }

    public final String getACTIONPARAM2() {
        return this.GetParamStringValue(TAG_ACTIONPARAM2, "");
    }

    public final void setACTIONPARAM2(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM2, strValue);
    }

    public final boolean isACTIONPARAM3Null() {
        return this.IsParamNull(TAG_ACTIONPARAM3);
    }

    public final String getACTIONPARAM3() {
        return this.GetParamStringValue(TAG_ACTIONPARAM3, "");
    }

    public final void setACTIONPARAM3(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM3, strValue);
    }

    public final boolean isACTIONPARAM4Null() {
        return this.IsParamNull(TAG_ACTIONPARAM4);
    }

    public final String getACTIONPARAM4() {
        return this.GetParamStringValue(TAG_ACTIONPARAM4, "");
    }

    public final void setACTIONPARAM4(String strValue) {
        this.SetParamValue(TAG_ACTIONPARAM4, strValue);
    }

    public final boolean isACTIONPARAM5Null() {
        return this.IsParamNull(TAG_ACTIONPARAM5);
    }

    public final int getACTIONPARAM5() {
        return this.GetParamIntValue(TAG_ACTIONPARAM5, 0);
    }

    public final void setACTIONPARAM5(int nValue) {
        this.SetParamValue(TAG_ACTIONPARAM5, nValue);
    }

    public final boolean isACTIONPARAM6Null() {
        return this.IsParamNull(TAG_ACTIONPARAM6);
    }

    public final int getACTIONPARAM6() {
        return this.GetParamIntValue(TAG_ACTIONPARAM6, 0);
    }

    public final void setACTIONPARAM6(int nValue) {
        this.SetParamValue(TAG_ACTIONPARAM6, nValue);
    }

    public final boolean isPSDSCONSOLEIDNull() {
        return this.IsParamNull(TAG_PSDSCONSOLEID);
    }

    public final String getPSDSCONSOLEID() {
        return this.GetParamStringValue(TAG_PSDSCONSOLEID, "");
    }

    public final void setPSDSCONSOLEID(String strValue) {
        this.SetParamValue(TAG_PSDSCONSOLEID, strValue);
    }

    public final boolean isPASSWDNull() {
        return this.IsParamNull(TAG_PASSWD);
    }

    public final String getPASSWD() {
        return this.GetParamStringValue(TAG_PASSWD, "");
    }

    public final void setPASSWD(String strValue) {
        this.SetParamValue(TAG_PASSWD, strValue);
    }
}

