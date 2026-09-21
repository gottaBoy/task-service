/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSDCBKTask
extends BaseDataEntity {
    public static final int TASKSTATE_10 = 10;
    public static final int TASKSTATE_20 = 20;
    public static final int TASKSTATE_30 = 30;
    public static final int TASKSTATE_40 = 40;
    public static final String TASKTYPE_X = "X";
    public static final String TASKTYPE_CREATEDEVSLNSYS = "CREATEDEVSLNSYS";
    public static final String TASKTYPE_PACKDEVSLNSYS = "PACKDEVSLNSYS";
    public static final String TASKTYPE_BACKUPDCDBINST = "BACKUPDCDBINST";
    public static final String TASKTYPE_RESTOREDCDBINST = "RESTOREDCDBINST";
    public static final String TASKTYPE_IMPPFSTYLE = "IMPPFSTYLE";
    public static final String TASKTYPE_IMPSFSTYLEVER = "IMPSFSTYLEVER";
    public static final String TAG_PSDCBKTASKID = "PSDCBKTASKID";
    public static final String TAG_PSDCBKTASKNAME = "PSDCBKTASKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String TAG_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String TAG_BEGINTIME = "BEGINTIME";
    public static final String TAG_ENDTIME = "ENDTIME";
    public static final String TAG_FULLRESULTINFO = "FULLRESULTINFO";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_RESULTINFO = "RESULTINFO";
    public static final String TAG_TASKPARAM = "TASKPARAM";
    public static final String TAG_TASKPARAM2 = "TASKPARAM2";
    public static final String TAG_TASKPARAM3 = "TASKPARAM3";
    public static final String TAG_TASKPARAM4 = "TASKPARAM4";
    public static final String TAG_TASKSTATE = "TASKSTATE";
    public static final String TAG_TASKTYPE = "TASKTYPE";
    public static final String TAG_PSDEVSLNID = "PSDEVSLNID";
    public static final String TAG_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String TAG_TASKPARAMS = "TASKPARAMS";
    public static final String TAG_USEROBOTFLAG = "USEROBOTFLAG";
    public static final String TAG_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String TAG_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String TAG_TOTALTIME = "TOTALTIME";
    public static final String TAG_LASTCALCTIME = "LASTCALCTIME";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";

    public final boolean isPSDCBKTASKIDNull() {
        return this.IsParamNull(TAG_PSDCBKTASKID);
    }

    public final String getPSDCBKTASKID() {
        return this.GetParamStringValue(TAG_PSDCBKTASKID, "");
    }

    public final void setPSDCBKTASKID(String strValue) {
        this.SetParamValue(TAG_PSDCBKTASKID, strValue);
    }

    public final boolean isPSDCBKTASKNAMENull() {
        return this.IsParamNull(TAG_PSDCBKTASKNAME);
    }

    public final String getPSDCBKTASKNAME() {
        return this.GetParamStringValue(TAG_PSDCBKTASKNAME, "");
    }

    public final void setPSDCBKTASKNAME(String strValue) {
        this.SetParamValue(TAG_PSDCBKTASKNAME, strValue);
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

    public final boolean isFULLRESULTINFONull() {
        return this.IsParamNull(TAG_FULLRESULTINFO);
    }

    public final String getFULLRESULTINFO() {
        return this.GetParamStringValue(TAG_FULLRESULTINFO, "");
    }

    public final void setFULLRESULTINFO(String strValue) {
        this.SetParamValue(TAG_FULLRESULTINFO, strValue);
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

    public final boolean isORDERVALUENull() {
        return this.IsParamNull(TAG_ORDERVALUE);
    }

    public final int getORDERVALUE() {
        return this.GetParamIntValue(TAG_ORDERVALUE, 0);
    }

    public final void setORDERVALUE(int nValue) {
        this.SetParamValue(TAG_ORDERVALUE, nValue);
    }

    public final boolean isRESULTINFONull() {
        return this.IsParamNull(TAG_RESULTINFO);
    }

    public final String getRESULTINFO() {
        return this.GetParamStringValue(TAG_RESULTINFO, "");
    }

    public final void setRESULTINFO(String strValue) {
        this.SetParamValue(TAG_RESULTINFO, strValue);
    }

    public final boolean isTASKPARAMNull() {
        return this.IsParamNull(TAG_TASKPARAM);
    }

    public final String getTASKPARAM() {
        return this.GetParamStringValue(TAG_TASKPARAM, "");
    }

    public final void setTASKPARAM(String strValue) {
        this.SetParamValue(TAG_TASKPARAM, strValue);
    }

    public final boolean isTASKPARAM2Null() {
        return this.IsParamNull(TAG_TASKPARAM2);
    }

    public final String getTASKPARAM2() {
        return this.GetParamStringValue(TAG_TASKPARAM2, "");
    }

    public final void setTASKPARAM2(String strValue) {
        this.SetParamValue(TAG_TASKPARAM2, strValue);
    }

    public final boolean isTASKPARAM3Null() {
        return this.IsParamNull(TAG_TASKPARAM3);
    }

    public final String getTASKPARAM3() {
        return this.GetParamStringValue(TAG_TASKPARAM3, "");
    }

    public final void setTASKPARAM3(String strValue) {
        this.SetParamValue(TAG_TASKPARAM3, strValue);
    }

    public final boolean isTASKPARAM4Null() {
        return this.IsParamNull(TAG_TASKPARAM4);
    }

    public final String getTASKPARAM4() {
        return this.GetParamStringValue(TAG_TASKPARAM4, "");
    }

    public final void setTASKPARAM4(String strValue) {
        this.SetParamValue(TAG_TASKPARAM4, strValue);
    }

    public final boolean isTASKSTATENull() {
        return this.IsParamNull(TAG_TASKSTATE);
    }

    public final int getTASKSTATE() {
        return this.GetParamIntValue(TAG_TASKSTATE, 0);
    }

    public final void setTASKSTATE(int nValue) {
        this.SetParamValue(TAG_TASKSTATE, nValue);
    }

    public final boolean isTASKTYPENull() {
        return this.IsParamNull(TAG_TASKTYPE);
    }

    public final String getTASKTYPE() {
        return this.GetParamStringValue(TAG_TASKTYPE, "");
    }

    public final void setTASKTYPE(String strValue) {
        this.SetParamValue(TAG_TASKTYPE, strValue);
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

    public final boolean isTASKPARAMSNull() {
        return this.IsParamNull(TAG_TASKPARAMS);
    }

    public final String getTASKPARAMS() {
        return this.GetParamStringValue(TAG_TASKPARAMS, "");
    }

    public final void setTASKPARAMS(String strValue) {
        this.SetParamValue(TAG_TASKPARAMS, strValue);
    }

    public final boolean isUSEROBOTFLAGNull() {
        return this.IsParamNull(TAG_USEROBOTFLAG);
    }

    public final boolean getUSEROBOTFLAG() {
        return this.GetParamIntValue(TAG_USEROBOTFLAG, 0) == 1;
    }

    public final void setUSEROBOTFLAG(boolean bValue) {
        this.SetParamValue(TAG_USEROBOTFLAG, bValue ? 1 : 0);
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

    public final boolean isPSTASKSERVERNAMENull() {
        return this.IsParamNull(TAG_PSTASKSERVERNAME);
    }

    public final String getPSTASKSERVERNAME() {
        return this.GetParamStringValue(TAG_PSTASKSERVERNAME, "");
    }

    public final void setPSTASKSERVERNAME(String strValue) {
        this.SetParamValue(TAG_PSTASKSERVERNAME, strValue);
    }

    public final boolean isPSDYNAINSTIDNull() {
        return this.IsParamNull(TAG_PSDYNAINSTID);
    }

    public final String getPSDYNAINSTID() {
        return this.GetParamStringValue(TAG_PSDYNAINSTID, "");
    }

    public final void setPSDYNAINSTID(String strValue) {
        this.SetParamValue(TAG_PSDYNAINSTID, strValue);
    }
}

