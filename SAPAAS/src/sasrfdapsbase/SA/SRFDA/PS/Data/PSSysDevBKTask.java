/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.DataEx.BaseDataEntity;
import java.util.Date;

public class PSSysDevBKTask
extends BaseDataEntity {
    public static final int TASKSTATE_CREATED = 10;
    public static final int TASKSTATE_EXECUTING = 20;
    public static final int TASKSTATE_FINISHED = 30;
    public static final int TASKSTATE_CANCELLED = 40;
    public static final String TASKTYPE_DEPLOYSYS = "DEPLOYSYS";
    public static final String TASKTYPE_PACKSFCODE = "PACKSFCODE";
    public static final String TASKTYPE_PACKPFCODE = "PACKPFCODE";
    public static final String TASKTYPE_PUBSFCODE = "PUBSFCODE";
    public static final String TASKTYPE_PUBPFCODE = "PUBPFCODE";
    public static final String TASKTYPE_STARTUPSYS = "STARTUPSYS";
    public static final String TASKTYPE_SYNCDBMODEL = "SYNCDBMODEL";
    public static final String TASKTYPE_STARTUPEX = "STARTUPEX";
    public static final String TAG_PSSYSDEVBKTASKID = "PSSYSDEVBKTASKID";
    public static final String TAG_PSSYSDEVBKTASKNAME = "PSSYSDEVBKTASKNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_PSSYSTEMID = "PSSYSTEMID";
    public static final String TAG_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String TAG_PPSSYSDEVBKTASKID = "PPSSYSDEVBKTASKID";
    public static final String TAG_PPSSYSDEVBKTASKNAME = "PPSSYSDEVBKTASKNAME";
    public static final String TAG_TASKPARAM = "TASKPARAM";
    public static final String TAG_TASKPARAM2 = "TASKPARAM2";
    public static final String TAG_TASKPARAM3 = "TASKPARAM3";
    public static final String TAG_TASKPARAM4 = "TASKPARAM4";
    public static final String TAG_TASKSTATE = "TASKSTATE";
    public static final String TAG_TASKTYPE = "TASKTYPE";
    public static final String TAG_MEMO = "MEMO";
    public static final String TAG_RESULTINFO = "RESULTINFO";
    public static final String TAG_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String TAG_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String TAG_ORDERVALUE = "ORDERVALUE";
    public static final String TAG_MODELLEVEL = "MODELLEVEL";
    public static final String TAG_USEROBOTFLAG = "USEROBOTFLAG";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";

    public final boolean isPSSYSDEVBKTASKIDNull() {
        return this.IsParamNull(TAG_PSSYSDEVBKTASKID);
    }

    public final String getPSSYSDEVBKTASKID() {
        return this.GetParamStringValue(TAG_PSSYSDEVBKTASKID, "");
    }

    public final void setPSSYSDEVBKTASKID(String strValue) {
        this.SetParamValue(TAG_PSSYSDEVBKTASKID, strValue);
    }

    public final boolean isPSSYSDEVBKTASKNAMENull() {
        return this.IsParamNull(TAG_PSSYSDEVBKTASKNAME);
    }

    public final String getPSSYSDEVBKTASKNAME() {
        return this.GetParamStringValue(TAG_PSSYSDEVBKTASKNAME, "");
    }

    public final void setPSSYSDEVBKTASKNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSDEVBKTASKNAME, strValue);
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

    public final boolean isPSSYSTEMIDNull() {
        return this.IsParamNull(TAG_PSSYSTEMID);
    }

    public final String getPSSYSTEMID() {
        return this.GetParamStringValue(TAG_PSSYSTEMID, "");
    }

    public final void setPSSYSTEMID(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMID, strValue);
    }

    public final boolean isPSSYSTEMNAMENull() {
        return this.IsParamNull(TAG_PSSYSTEMNAME);
    }

    public final String getPSSYSTEMNAME() {
        return this.GetParamStringValue(TAG_PSSYSTEMNAME, "");
    }

    public final void setPSSYSTEMNAME(String strValue) {
        this.SetParamValue(TAG_PSSYSTEMNAME, strValue);
    }

    public final boolean isPPSSYSDEVBKTASKIDNull() {
        return this.IsParamNull(TAG_PPSSYSDEVBKTASKID);
    }

    public final String getPPSSYSDEVBKTASKID() {
        return this.GetParamStringValue(TAG_PPSSYSDEVBKTASKID, "");
    }

    public final void setPPSSYSDEVBKTASKID(String strValue) {
        this.SetParamValue(TAG_PPSSYSDEVBKTASKID, strValue);
    }

    public final boolean isPPSSYSDEVBKTASKNAMENull() {
        return this.IsParamNull(TAG_PPSSYSDEVBKTASKNAME);
    }

    public final String getPPSSYSDEVBKTASKNAME() {
        return this.GetParamStringValue(TAG_PPSSYSDEVBKTASKNAME, "");
    }

    public final void setPPSSYSDEVBKTASKNAME(String strValue) {
        this.SetParamValue(TAG_PPSSYSDEVBKTASKNAME, strValue);
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

    public final boolean isMEMONull() {
        return this.IsParamNull(TAG_MEMO);
    }

    public final String getMEMO() {
        return this.GetParamStringValue(TAG_MEMO, "");
    }

    public final void setMEMO(String strValue) {
        this.SetParamValue(TAG_MEMO, strValue);
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

    public final boolean isPSDEVSLNSYSIDNull() {
        return this.IsParamNull(TAG_PSDEVSLNSYSID);
    }

    public final String getPSDEVSLNSYSID() {
        return this.GetParamStringValue(TAG_PSDEVSLNSYSID, "");
    }

    public final void setPSDEVSLNSYSID(String strValue) {
        this.SetParamValue(TAG_PSDEVSLNSYSID, strValue);
    }

    public final boolean isPSSYSMODELINSTIDNull() {
        return this.IsParamNull(TAG_PSSYSMODELINSTID);
    }

    public final String getPSSYSMODELINSTID() {
        return this.GetParamStringValue(TAG_PSSYSMODELINSTID, "");
    }

    public final void setPSSYSMODELINSTID(String strValue) {
        this.SetParamValue(TAG_PSSYSMODELINSTID, strValue);
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

    public final boolean isMODELLEVELNull() {
        return this.IsParamNull(TAG_MODELLEVEL);
    }

    public final int getMODELLEVEL() {
        return this.GetParamIntValue(TAG_MODELLEVEL, 0);
    }

    public final void setMODELLEVEL(int nValue) {
        this.SetParamValue(TAG_MODELLEVEL, nValue);
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

